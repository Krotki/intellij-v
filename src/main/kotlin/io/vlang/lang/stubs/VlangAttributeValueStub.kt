package io.vlang.lang.stubs

import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubElement
import com.intellij.util.io.StringRef
import io.vlang.lang.psi.*

class VlangAttributeValueStub(parent: StubElement<*>?, elementType: IStubElementType<*, *>?, ref: StringRef?) :
    StubWithText<VlangAttributeValue>(parent, elementType, ref) {

    constructor(parent: StubElement<*>?, elementType: IStubElementType<*, *>?, text: String?) :
            this(parent, elementType, StringRef.fromString(text))
}
