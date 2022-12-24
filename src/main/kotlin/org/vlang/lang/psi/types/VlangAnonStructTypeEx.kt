package org.vlang.lang.psi.types

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import org.vlang.lang.psi.VlangAnonymousStructType
import org.vlang.lang.psi.VlangStructDeclaration

class VlangAnonStructTypeEx(anchor: VlangAnonymousStructType) : VlangStructTypeEx("<anonymous>", anchor) {
    override fun toString() = "<anonymous struct>"

    override fun readableName(context: PsiElement) = buildString {
        append("struct {\n")
        val fields = (anchor as VlangAnonymousStructType).getFieldList()
        append(
            fields.joinToString("\n") { field ->
                buildString {
                    append("   ")
                    append(field.name)
                    append(" ")
                    append(field.getType(null)?.readableName(context) ?: "<unknown>")
                }
            }
        )
        append("\n}")
    }

    override fun isAssignableFrom(rhs: VlangTypeEx, project: Project): Boolean {
        return when (rhs) {
            is VlangAnyTypeEx        -> true
            is VlangUnknownTypeEx    -> true
            is VlangVoidPtrTypeEx    -> true
            is VlangAnonStructTypeEx -> true
            else                     -> false
        }
    }

    override fun isEqual(rhs: VlangTypeEx): Boolean = rhs is VlangAnonStructTypeEx

    override fun accept(visitor: VlangTypeVisitor) {
        if (!visitor.enter(this)) {
            return
        }
    }

    override fun substituteGenerics(nameMap: Map<String, VlangTypeEx>): VlangTypeEx = this

    fun resolve(): VlangAnonymousStructType? {
        return anchor as? VlangAnonymousStructType
    }
}