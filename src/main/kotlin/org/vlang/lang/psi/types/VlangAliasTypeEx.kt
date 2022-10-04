package org.vlang.lang.psi.types

import org.vlang.ide.codeInsight.VlangCodeInsightUtil
import org.vlang.lang.psi.VlangAliasType
import org.vlang.lang.psi.VlangCompositeElement
import org.vlang.lang.psi.VlangTypeAliasDeclaration

class VlangAliasTypeEx(raw: VlangAliasType) : VlangBaseTypeEx<VlangAliasType>(raw), VlangImportableType {
    private val decl = raw.parent as VlangTypeAliasDeclaration
    private val name = decl.getQualifiedName() ?: ANON
    private val left = VlangSimpleTypeEx(raw.type)
    private val rightList = raw.typeUnionList?.typeList?.map { it.toEx() } ?: emptyList()

    override fun toString() = buildString {
        append(name)
        append(" = ")
        append(rightList.joinToString(" | ") { it.toString() })
    }

    override fun qualifiedName() = name

    override fun readableName(context: VlangCompositeElement) = VlangCodeInsightUtil.getQualifiedName(context, decl)

    override fun accept(visitor: VlangTypeVisitor) {
        if (!visitor.enter(this)) {
            return
        }

        if (!visitor.enter(left)) {
            return
        }

        for (right in rightList) {
            if (!visitor.enter(right)) {
                return
            }
        }
    }
}