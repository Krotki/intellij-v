package io.vlang.ide.navigation.goto

import com.intellij.codeInsight.navigation.actions.TypeDeclarationProvider
import com.intellij.psi.PsiElement
import io.vlang.lang.psi.VlangMethodDeclaration
import io.vlang.lang.psi.VlangTypeOwner
import io.vlang.lang.psi.types.VlangBaseTypeEx.Companion.toEx
import io.vlang.lang.psi.types.VlangBaseTypeEx.Companion.unwrapAlias
import io.vlang.lang.psi.types.VlangBaseTypeEx.Companion.unwrapArray
import io.vlang.lang.psi.types.VlangBaseTypeEx.Companion.unwrapGenericInstantiation
import io.vlang.lang.psi.types.VlangBaseTypeEx.Companion.unwrapPointer
import io.vlang.lang.psi.types.VlangResolvableTypeEx
import io.vlang.lang.psi.types.VlangTypeEx

class VlangTypeDeclarationProvider : TypeDeclarationProvider {
    override fun getSymbolTypeDeclarations(symbol: PsiElement): Array<PsiElement>? {
        if (symbol is VlangMethodDeclaration) {
            val type = symbol.receiverType.toEx()
            return processType(type, symbol)
        }

        if (symbol is VlangTypeOwner) {
            val type = symbol.getType(null) ?: return null
            return processType(type, symbol)
        }

        return null
    }

    private fun processType(rawType: VlangTypeEx, symbol: VlangTypeOwner): Array<PsiElement>? {
        val type = rawType
            .unwrapAlias()
            .unwrapArray()
            .unwrapPointer()
            .unwrapGenericInstantiation()

        if (type is VlangResolvableTypeEx<*>) {
            val resolved = type.resolve(symbol.project) ?: return null
            return arrayOf(resolved)
        }

        return null
    }
}
