package com.yunzhi.scoping;

import com.yunzhi.genoMate.DTOToModelMapping;
import com.yunzhi.genoMate.DtoDefinition;
import com.yunzhi.genoMate.GenerateSection;
import com.yunzhi.genoMate.GenoMate;
import com.yunzhi.genoMate.GenoMatePackage;
import com.yunzhi.genoMate.GlobalConfig;
import com.yunzhi.genoMate.Model;
import com.yunzhi.genoMate.ModelToVOMapping;
import com.yunzhi.genoMate.VariableDeclaration;
import com.yunzhi.genoMate.VoDefinition;
import java.util.List;
import java.util.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

@SuppressWarnings("all")
public class GenoMateScopeProvider extends AbstractDeclarativeScopeProvider {
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    IScope _xblockexpression = null;
    {
      if (((context instanceof ModelToVOMapping) && Objects.equals(reference, GenoMatePackage.Literals.MODEL_TO_VO_MAPPING__TARGET))) {
        final EObject root = EcoreUtil2.getRootContainer(context);
        final List<VoDefinition> allVos = EcoreUtil2.<VoDefinition>getAllContentsOfType(root, VoDefinition.class);
        return Scopes.scopeFor(allVos);
      }
      if (((context instanceof DTOToModelMapping) && Objects.equals(reference, GenoMatePackage.Literals.DTO_TO_MODEL_MAPPING__SOURCE))) {
        final EObject root_1 = EcoreUtil2.getRootContainer(context);
        final List<DtoDefinition> allDtos = EcoreUtil2.<DtoDefinition>getAllContentsOfType(root_1, DtoDefinition.class);
        return Scopes.scopeFor(allDtos);
      }
      boolean _equals = Objects.equals(reference, GenoMatePackage.Literals.DTO_TO_MODEL_MAPPING__TARGET);
      if (_equals) {
        final EObject root_2 = EcoreUtil2.getRootContainer(context);
        final List<Model> allModels = EcoreUtil2.<Model>getAllContentsOfType(root_2, Model.class);
        return Scopes.scopeFor(allModels);
      }
      boolean _equals_1 = Objects.equals(reference, GenoMatePackage.Literals.GLOBAL_ACTION__VARIABLE);
      if (_equals_1) {
        return this.GlobalActionVariable(context);
      }
      _xblockexpression = super.getScope(context, reference);
    }
    return _xblockexpression;
  }

  public IScope GlobalActionVariable(final EObject context) {
    final GenerateSection generateSection = EcoreUtil2.<GenerateSection>getContainerOfType(context, GenerateSection.class);
    final GenoMate GenoMate = EcoreUtil2.<com.yunzhi.genoMate.GenoMate>getContainerOfType(generateSection, com.yunzhi.genoMate.GenoMate.class);
    GlobalConfig _globalConfig = null;
    if (GenoMate!=null) {
      _globalConfig=GenoMate.getGlobalConfig();
    }
    boolean _tripleNotEquals = (_globalConfig != null);
    if (_tripleNotEquals) {
      final EList<VariableDeclaration> annotations = GenoMate.getGlobalConfig().getVarDefaultAnnotations();
      return Scopes.scopeFor(annotations);
    }
    return IScope.NULLSCOPE;
  }
}
