// This is a generated file. Not intended for manual editing.
package io.vlang.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VlangForStatement extends VlangStatement {

  @Nullable
  VlangExpression getExpression();

  @Nullable
  VlangForClause getForClause();

  @Nullable
  VlangRangeClause getRangeClause();

  @NotNull
  PsiElement getFor();

}
