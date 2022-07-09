package org.vlang.lang.stubs

import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubElement
import com.intellij.util.io.StringRef
import org.vlang.lang.psi.VlangFunctionOrMethodDeclaration
import org.vlang.lang.psi.VlangStructDeclaration

class VlangStructDeclarationStub : VlangNamedStub<VlangStructDeclaration> {
    constructor(
        parent: StubElement<*>?,
        elementType: IStubElementType<*, *>,
        name: StringRef?,
        isPublic: Boolean,
        isGlobal: Boolean,
    ) : super(parent, elementType, name, isPublic, isGlobal)

    constructor(
        parent: StubElement<*>?,
        elementType: IStubElementType<*, *>,
        name: String?,
        isPublic: Boolean,
        isGlobal: Boolean,
    ) : super(parent, elementType, name, isPublic, isGlobal)
}