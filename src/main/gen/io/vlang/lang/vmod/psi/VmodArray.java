// This is a generated file. Not intended for manual editing.
package io.vlang.lang.vmod.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import io.vlang.vmod.psi.VmodCompositeElement;

public interface VmodArray extends VmodCompositeElement {

  @Nullable
  VmodArrayItems getArrayItems();

  @NotNull
  PsiElement getLbrack();

  @NotNull
  PsiElement getRbrack();

}
