package org.vlang.lang.resolve

import com.intellij.openapi.editor.Caret
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiReference
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import org.intellij.lang.annotations.Language
import org.vlang.lang.psi.VlangNamedElement

abstract class ResolveTestBase : BasePlatformTestCase() {
    override fun getTestDataPath() = "src/test/resources/resolve"

    private var carets: MutableList<Caret>? = null
    private var caretIndex = 0

    protected fun assertReferencedTo(name: String) {
        val caret = carets!!.getOrNull(caretIndex++) ?: error("No more carets")
        val offset = caret.offset

        val ref = myFixture.file.findReferenceAt(offset)
        check(ref != null) { "No reference at caret" }

        val resolved = ref.resolve() as? VlangNamedElement
        check(resolved != null) { "Cannot resolve reference" }

        val kind = resolved.toString()
        val resolvedName = resolved.name
        val expected = "$kind $resolvedName"
        check(expected == name) { "Expected to resolve to $name, but got $expected" }
    }

    protected fun file(path: String, @Language("vlang") text: String) {
        myFixture.configureByText(path, text)
    }

    protected fun mainFile(path: String, @Language("vlang") text: String) {
        file(path, text)
        carets = myFixture.editor.caretModel.allCarets
    }

    protected fun findReferenceAtCaret(filePath: String): PsiReference? {
        val file: PsiFile = myFixture.configureByFile(filePath)
        return file.findReferenceAt(myFixture.editor.caretModel.offset)
    }
}