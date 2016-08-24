/*
    Copyright 1996-2008 Ariba, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

    $Id: //ariba/platform/ui/ideplugin/ariba/ideplugin/idea/lang/grammer/psi
    /OSSRuleImpl.java $
*/
package ariba.ideplugin.idea.lang.grammer.psi;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

public class OSSRuleImpl extends ASTWrapperPsiElement implements OSSRule
{

    public OSSRuleImpl (ASTNode node)
    {
        super(node);
    }

    @Override
    @Nullable
    public OSSRuleBody getRuleBody ()
    {
        return findChildByClass(OSSRuleBody.class);
    }

    @Override
    @NotNull
    public List<OSSSelector> getSelectorList ()
    {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, OSSSelector.class);
    }

    @Override
    @Nullable
    public OSSTraitList getTraitList ()
    {
        return findChildByClass(OSSTraitList.class);
    }

    public void accept (@NotNull PsiElementVisitor visitor)
    {
        if (visitor instanceof OSSVisitor) {
            ((OSSVisitor)visitor).visitRule(this);
        }
        else {
            super.accept(visitor);
        }
    }

}
