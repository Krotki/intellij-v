package io.vlang.lang.stubs.types

import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import io.vlang.lang.psi.VlangAttributeExpression
import io.vlang.lang.psi.impl.VlangAttributeExpressionImpl
import io.vlang.lang.stubs.VlangAttributeExpressionStub

class VlangAttributeExpressionStubElementType(name: String) : VlangStubElementType<VlangAttributeExpressionStub, VlangAttributeExpression>(name) {
    override fun createPsi(stub: VlangAttributeExpressionStub): VlangAttributeExpression {
        return VlangAttributeExpressionImpl(stub, this)
    }

    override fun createStub(psi: VlangAttributeExpression, parentStub: StubElement<*>?): VlangAttributeExpressionStub {
        return VlangAttributeExpressionStub(parentStub, this, psi.text)
    }

    override fun serialize(stub: VlangAttributeExpressionStub, dataStream: StubOutputStream) {
        dataStream.writeName(stub.getText())
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): VlangAttributeExpressionStub {
        return VlangAttributeExpressionStub(parentStub, this, dataStream.readName())
    }
}
