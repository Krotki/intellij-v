package io.vlang.lang.stubs.index

import com.intellij.openapi.project.Project
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubIndex
import com.intellij.psi.stubs.StubIndexKey
import com.intellij.util.Processor
import io.vlang.lang.VlangFileElementType
import io.vlang.lang.psi.VlangFieldDefinition

class VlangInterfaceFieldFingerprintIndex : StringStubIndexExtension<VlangFieldDefinition>() {
    companion object {
        val KEY = StubIndexKey.createIndexKey<String, VlangFieldDefinition>("vlang.interface.field.fingerprint")

        fun find(
            name: String, project: Project,
            scope: GlobalSearchScope?,
        ): Collection<VlangFieldDefinition> {
            return StubIndex.getElements(KEY, name, project, scope, null, VlangFieldDefinition::class.java)
        }

        fun process(
            name: String, project: Project,
            scope: GlobalSearchScope?, processor: Processor<VlangFieldDefinition>,
        ): Boolean {
            return StubIndex.getInstance().processElements(
                KEY, name, project, scope, null,
                VlangFieldDefinition::class.java, processor
            )
        }
    }

    override fun getVersion() = VlangFileElementType.VERSION + 2

    override fun getKey() = KEY
}
