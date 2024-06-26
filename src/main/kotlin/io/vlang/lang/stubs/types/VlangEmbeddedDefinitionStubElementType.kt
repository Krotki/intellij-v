package io.vlang.lang.stubs.types

import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import io.vlang.lang.psi.VlangEmbeddedDefinition
import io.vlang.lang.psi.impl.VlangEmbeddedDefinitionImpl
import io.vlang.lang.stubs.VlangEmbeddedDefinitionStub

class VlangEmbeddedDefinitionStubElementType(name: String) :
    VlangNamedStubElementType<VlangEmbeddedDefinitionStub, VlangEmbeddedDefinition>(name) {

    override fun createPsi(stub: VlangEmbeddedDefinitionStub): VlangEmbeddedDefinition {
        return VlangEmbeddedDefinitionImpl(stub, this)
    }

    override fun createStub(psi: VlangEmbeddedDefinition, parentStub: StubElement<*>?): VlangEmbeddedDefinitionStub {
        return VlangEmbeddedDefinitionStub(parentStub, this, psi.name)
    }

    override fun serialize(stub: VlangEmbeddedDefinitionStub, dataStream: StubOutputStream) {
        dataStream.writeName(stub.name)
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): VlangEmbeddedDefinitionStub {
        return VlangEmbeddedDefinitionStub(parentStub, this, dataStream.readName())
    }
}
