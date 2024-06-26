package io.vlang.lang.stubs.types

import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import io.vlang.lang.psi.VlangEnumFieldDefinition
import io.vlang.lang.psi.impl.VlangEnumFieldDefinitionImpl
import io.vlang.lang.stubs.VlangEnumFieldDefinitionStub

class VlangEnumFieldDefinitionStubElementType(name: String) :
    VlangNamedStubElementType<VlangEnumFieldDefinitionStub, VlangEnumFieldDefinition>(name) {

    override fun createPsi(stub: VlangEnumFieldDefinitionStub): VlangEnumFieldDefinition {
        return VlangEnumFieldDefinitionImpl(stub, this)
    }

    override fun createStub(psi: VlangEnumFieldDefinition, parentStub: StubElement<*>?): VlangEnumFieldDefinitionStub {
        return VlangEnumFieldDefinitionStub(parentStub, this, psi.name)
    }

    override fun serialize(stub: VlangEnumFieldDefinitionStub, dataStream: StubOutputStream) {
        dataStream.writeName(stub.name)
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): VlangEnumFieldDefinitionStub {
        return VlangEnumFieldDefinitionStub(parentStub, this, dataStream.readName())
    }
}
