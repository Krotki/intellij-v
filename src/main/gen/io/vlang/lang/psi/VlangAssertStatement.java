// This is a generated file. Not intended for manual editing.
package io.vlang.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VlangAssertStatement extends VlangStatement {

  @NotNull
  List<VlangExpression> getExpressionList();

  @Nullable
  PsiElement getComma();

  @NotNull
  PsiElement getAssert();

}
