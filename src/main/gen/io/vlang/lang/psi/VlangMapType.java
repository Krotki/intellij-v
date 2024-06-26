// This is a generated file. Not intended for manual editing.
package io.vlang.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VlangMapType extends VlangType {

  @NotNull
  List<VlangType> getTypeList();

  @NotNull
  PsiElement getLbrack();

  @Nullable
  PsiElement getRbrack();

  @Nullable
  VlangType getKeyType();

  @Nullable
  VlangType getValueType();

}
