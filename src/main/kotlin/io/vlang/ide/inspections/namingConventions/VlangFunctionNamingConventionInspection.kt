package io.vlang.ide.inspections.namingConventions

import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import io.vlang.lang.psi.VlangFunctionDeclaration
import io.vlang.lang.psi.VlangMethodDeclaration
import io.vlang.lang.psi.VlangVisitor

class VlangFunctionNamingConventionInspection : VlangNamingConventionInspectionBase() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : VlangVisitor() {
            override fun visitFunctionDeclaration(o: VlangFunctionDeclaration) {
                holder.checkSnakeCase(o, "Function")
            }

            override fun visitMethodDeclaration(o: VlangMethodDeclaration) {
                holder.checkSnakeCase(o, "Method")
            }
        }
    }
}
