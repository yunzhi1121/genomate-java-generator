package com.yunzhi.scoping

import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import com.yunzhi.genoMate.ModelToVOMapping
import org.eclipse.xtext.EcoreUtil2
import com.yunzhi.genoMate.VoDefinition
import com.yunzhi.genoMate.GenoMatePackage
import com.yunzhi.genoMate.DTOToModelMapping
import org.eclipse.xtext.scoping.Scopes
import com.yunzhi.genoMate.DtoDefinition
import com.yunzhi.genoMate.Model
import com.yunzhi.genoMate.GenerateSection
import org.eclipse.xtext.scoping.IScope
import com.yunzhi.genoMate.GenoMate

class GenoMateScopeProvider extends AbstractDeclarativeScopeProvider {

    override getScope(EObject context, EReference reference) {
        
        
        // 情况1：处理 ModelToVOMapping 的 target（VO）
        if (context instanceof ModelToVOMapping && reference == GenoMatePackage.Literals.MODEL_TO_VO_MAPPING__TARGET) {
            val root = EcoreUtil2.getRootContainer(context)
            val allVos = EcoreUtil2.getAllContentsOfType(root, VoDefinition)
            return Scopes.scopeFor(allVos)
        }

        // 情况2：处理 DTOToModelMapping 的 source（DTO）
        if (context instanceof DTOToModelMapping && reference == GenoMatePackage.Literals.DTO_TO_MODEL_MAPPING__SOURCE) {
            val root = EcoreUtil2.getRootContainer(context)
            val allDtos = EcoreUtil2.getAllContentsOfType(root, DtoDefinition)
            return Scopes.scopeFor(allDtos)
        }

        // 情况3：处理其他 Model 引用（如 target=[Model|ID]）
        if (reference == GenoMatePackage.Literals.DTO_TO_MODEL_MAPPING__TARGET) {
            val root = EcoreUtil2.getRootContainer(context)
            val allModels = EcoreUtil2.getAllContentsOfType(root, Model)
            return Scopes.scopeFor(allModels)
        }
        
        // 情况4：全局变量范围
        if (reference == GenoMatePackage.Literals.GLOBAL_ACTION__VARIABLE){
        	return GlobalActionVariable(context)
        }

        // 默认作用域
        super.getScope(context, reference)
    
    }
    
    def IScope GlobalActionVariable(EObject context){
    	val generateSection = EcoreUtil2.getContainerOfType(context, GenerateSection)
        val GenoMate = EcoreUtil2.getContainerOfType(generateSection, GenoMate)
        
        if (GenoMate?.globalConfig !== null) {
            val annotations = GenoMate.globalConfig.varDefaultAnnotations
            return Scopes.scopeFor(annotations)
        }
        return IScope.NULLSCOPE
        
    }
}