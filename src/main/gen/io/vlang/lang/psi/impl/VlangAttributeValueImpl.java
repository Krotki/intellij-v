// This is a generated file. Not intended for manual editing.
package io.vlang.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import io.vlang.lang.psi.VlangPsiTreeUtil;
import static io.vlang.lang.VlangTypes.*;
import io.vlang.lang.stubs.VlangAttributeValueStub;
import io.vlang.lang.psi.*;
import com.intellij.psi.stubs.IStubElementType;

public class VlangAttributeValueImpl extends VlangStubbedElementImpl<VlangAttributeValueStub> implements VlangAttributeValue {

  public VlangAttributeValueImpl(@NotNull VlangAttributeValueStub stub, @NotNull IStubElementType<?, ?> type) {
    super(stub, type);
  }

  public VlangAttributeValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VlangVisitor visitor) {
    visitor.visitAttributeValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VlangVisitor) accept((VlangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VlangExpression getExpression() {
    return VlangPsiTreeUtil.getChildOfType(this, VlangExpression.class);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

}
