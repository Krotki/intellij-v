package io.vlang.lang.psi

interface VlangMutabilityOwner : VlangCompositeElement {
    fun isMutable(): Boolean
    fun makeMutable()
    fun makeImmutable()
}
