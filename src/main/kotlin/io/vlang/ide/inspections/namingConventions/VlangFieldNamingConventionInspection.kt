package io.vlang.ide.inspections.namingConventions

import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import io.vlang.lang.psi.VlangEnumFieldDefinition
import io.vlang.lang.psi.VlangFieldDefinition
import io.vlang.lang.psi.VlangVisitor

class VlangFieldNamingConventionInspection : VlangNamingConventionInspectionBase() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : VlangVisitor() {
            override fun visitFieldDefinition(o: VlangFieldDefinition) {
                holder.checkSnakeCase(o, "Field")
            }

            override fun visitEnumFieldDefinition(o: VlangEnumFieldDefinition) {
                holder.checkSnakeCase(o, "Enum field")
            }
        }
    }
}
