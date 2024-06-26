package io.vlang.ide.inspections.general

import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import io.vlang.ide.inspections.VlangBaseInspection
import io.vlang.lang.psi.VlangLabelRef
import io.vlang.lang.psi.VlangVisitor

class VlangUnresolvedLabelInspection : VlangBaseInspection() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : VlangVisitor() {
            override fun visitLabelRef(labelRef: VlangLabelRef) {
                val label = labelRef.reference.resolve()
                if (label == null) {
                    holder.registerProblem(labelRef, "Unresolved label '#ref'", ProblemHighlightType.GENERIC_ERROR)
                }
            }
        }
    }
}
