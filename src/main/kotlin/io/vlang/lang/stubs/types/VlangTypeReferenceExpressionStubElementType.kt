package io.vlang.lang.stubs.types

import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import io.vlang.lang.psi.VlangTypeReferenceExpression
import io.vlang.lang.psi.impl.VlangTypeReferenceExpressionImpl
import io.vlang.lang.stubs.VlangTypeReferenceExpressionStub

class VlangTypeReferenceExpressionStubElementType(name: String) : VlangStubElementType<VlangTypeReferenceExpressionStub, VlangTypeReferenceExpression>(name) {
    override fun createPsi(stub: VlangTypeReferenceExpressionStub): VlangTypeReferenceExpression {
        return VlangTypeReferenceExpressionImpl(stub, this)
    }

    override fun createStub(psi: VlangTypeReferenceExpression, parentStub: StubElement<*>?): VlangTypeReferenceExpressionStub {
        return VlangTypeReferenceExpressionStub(parentStub, this, psi.text)
    }

    override fun serialize(stub: VlangTypeReferenceExpressionStub, dataStream: StubOutputStream) {
        dataStream.writeName(stub.getText())
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): VlangTypeReferenceExpressionStub {
        return VlangTypeReferenceExpressionStub(parentStub, this, dataStream.readName())
    }
}
