package io.vlang.lang.stubs.types

import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import io.vlang.lang.psi.VlangAttributeKey
import io.vlang.lang.psi.impl.VlangAttributeKeyImpl
import io.vlang.lang.stubs.VlangAttributeKeyStub

class VlangAttributeKeyStubElementType(name: String) : VlangStubElementType<VlangAttributeKeyStub, VlangAttributeKey>(name) {
    override fun createPsi(stub: VlangAttributeKeyStub): VlangAttributeKey {
        return VlangAttributeKeyImpl(stub, this)
    }

    override fun createStub(psi: VlangAttributeKey, parentStub: StubElement<*>?): VlangAttributeKeyStub {
        return VlangAttributeKeyStub(parentStub, this, psi.text)
    }

    override fun serialize(stub: VlangAttributeKeyStub, dataStream: StubOutputStream) {
        dataStream.writeName(stub.getText())
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): VlangAttributeKeyStub {
        return VlangAttributeKeyStub(parentStub, this, dataStream.readName())
    }
}
