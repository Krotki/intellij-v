// This is a generated file. Not intended for manual editing.
package org.vlang.lang.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface VlangNotInExpression extends VlangExpression {

  @NotNull
  List<VlangExpression> getExpressionList();

  @NotNull
  PsiElement getNotIn();

}