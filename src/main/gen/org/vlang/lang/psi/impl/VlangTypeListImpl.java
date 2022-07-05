// This is a generated file. Not intended for manual editing.
package org.vlang.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.vlang.lang.psi.VlangPsiTreeUtil;
import org.vlang.lang.psi.VlangTypeDecl;
import org.vlang.lang.psi.VlangTypeList;
import org.vlang.lang.psi.VlangVisitor;

import java.util.List;

public class VlangTypeListImpl extends VlangTypeDeclImpl implements VlangTypeList {

  public VlangTypeListImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull VlangVisitor visitor) {
    visitor.visitTypeList(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VlangVisitor) accept((VlangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<VlangTypeDecl> getTypeDeclList() {
    return VlangPsiTreeUtil.getChildrenOfTypeAsList(this, VlangTypeDecl.class);
  }

}