// This is a generated file. Not intended for manual editing.
package org.vlang.lang.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface VlangIndexOrSliceExpr extends VlangExpression {

  @NotNull
  List<VlangExpression> getExpressionList();

  @Nullable
  PsiElement getHashLbrack();

  @Nullable
  PsiElement getLbrack();

  @Nullable
  PsiElement getRbrack();

  //WARNING: getExpression(...) is skipped
  //matching getExpression(VlangIndexOrSliceExpr, ...)
  //methods are not found in VlangPsiImplUtil

  //WARNING: getIndices(...) is skipped
  //matching getIndices(VlangIndexOrSliceExpr, ...)
  //methods are not found in VlangPsiImplUtil

}