package io.vlang.lang.stubs.types

import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import io.vlang.lang.psi.VlangParameters
import io.vlang.lang.psi.impl.VlangParametersImpl
import io.vlang.lang.stubs.VlangParametersStub

class VlangParametersStubElementType(name: String) : VlangStubElementType<VlangParametersStub, VlangParameters>(name) {
    override fun createPsi(stub: VlangParametersStub): VlangParameters {
        return VlangParametersImpl(stub, this)
    }

    override fun createStub(psi: VlangParameters, parentStub: StubElement<*>?): VlangParametersStub {
        return VlangParametersStub(parentStub, this, psi.text)
    }

    override fun serialize(stub: VlangParametersStub, dataStream: StubOutputStream) {
        dataStream.writeName(stub.getText())
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): VlangParametersStub {
        return VlangParametersStub(parentStub, this, dataStream.readName())
    }
}
