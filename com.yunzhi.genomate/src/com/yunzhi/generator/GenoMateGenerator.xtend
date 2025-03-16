/*
 * generated by Xtext 2.38.0
 * 完成第一版 保存 后续用豆包优化

 */
 // GenoMateGenerator.xtend
package com.yunzhi.generator

import com.yunzhi.genoMate.AndTypeCondition
import com.yunzhi.genoMate.ArrayType
import com.yunzhi.genoMate.BeanValidationAnnotation
import com.yunzhi.genoMate.DtoDefinition
import com.yunzhi.genoMate.DtoRule
import com.yunzhi.genoMate.GenericDataType
import com.yunzhi.genoMate.GenoMate
import com.yunzhi.genoMate.JacksonAnnotation
import com.yunzhi.genoMate.LombokAnnotation
import com.yunzhi.genoMate.Model
import com.yunzhi.genoMate.MybatisPlusFieldAnnotation
import com.yunzhi.genoMate.MybatisPlusModelAnnotation
import com.yunzhi.genoMate.NormalType
import com.yunzhi.genoMate.OrTypeCondition
import com.yunzhi.genoMate.Parameter
import com.yunzhi.genoMate.PoRule
import com.yunzhi.genoMate.SimpleType
import com.yunzhi.genoMate.Type
import com.yunzhi.genoMate.TypeCondition
import com.yunzhi.genoMate.TypeEqualityCondition
import com.yunzhi.genoMate.VoDefinition
import com.yunzhi.genoMate.VoRule
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class GenoMateGenerator extends AbstractGenerator {
    // 重写 doGenerate 方法，该方法用于根据资源生成相关类文件
	// 参数说明：
	// - resource: 要处理的资源对象，包含生成代码所需的信息
	// - fsa: 文件系统访问接口，用于文件的创建、读写等操作
	// - context: 生成器上下文对象，可能包含额外的生成信息
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
	    val model = resource.contents.head as GenoMate
	    
	    if (model === null) {
	        println("GenoMate is null!")
	        return
	    }
	    val rules = model.generateSection.rules
	    if (rules.isEmpty) {
	        println("Rules list is empty!")
	        return
	    }
	    // 生成 PO 类文件
        for (rule : rules.filter(PoRule)) {
            val className = rule.model.name.toFirstUpper
            val poClassCode = rule.toPOClass
            println('========================================================================')
            println("Generated PO class code for " + className + ": \n")
            fsa.generateFile(className + '.java', poClassCode)
        }
        // 生成 DTO 类文件
        for (rule : rules.filter(DtoRule)) {
        	val md = rule.model
            for (dto : rule.dtos) {
                val className = dto.name
                val dtoClassCode = dto.toDTOClass(md)
                println('========================================================================')
                println("Generated DTO class code for " + className + ": \n")
                fsa.generateFile(className + '.java', dtoClassCode)
            }
        }
        // 生成 VO 类文件
        for (rule : rules.filter(VoRule)) {
        	val md = rule.model
            for (vo : rule.vos) {
                val className = vo.name
                val voClassCode = vo.toVOClass(md)
                println('========================================================================')
                println("Generated VO class code for " + className + ": \n")
                fsa.generateFile(className + '.java', voClassCode)
            }
        }
	}


	// 生成PO类代码
	def CharSequence toPOClass(PoRule rule) '''
	    «IF !rule.lombokAnnotation.nullOrEmpty»
	        «rule.lombokAnnotation.map[toAnnotationString].join('\n')»
	    «ENDIF»
	    «IF !rule.mybatisPlusModelAnnotation.nullOrEmpty»
	        «rule.mybatisPlusModelAnnotation.map[toAnnotationString].join('\n')»
	    «ENDIF»
	    public class «rule.model.name.toFirstUpper» «IF rule.serializable == 'true'»implements Serializable «ENDIF» {
	    	
	        «FOR currentfield : rule.model.fields»
	            «IF rule.fieldAnns.exists[it.field.name == currentfield.name]»
					«rule.fieldAnns.findFirst[it.field.name == currentfield.name].annList.map[toAnnotationString].join('\n')»
	            «ENDIF»
	            private «currentfield.type.getTypeName» «currentfield.name»;
	            
	        «ENDFOR»
	        «FOR currentfield : rule.addField»
		        «currentfield.annotationList.map[toAnnotationString].join('\n')»
		        	private «currentfield.properties.type.getTypeName» «currentfield.properties.name»«IF !currentfield.properties.defaultClause.nullOrEmpty» «currentfield.properties.defaultClause»«ENDIF»;
		            
	        «ENDFOR»
	        «IF rule.serializable == 'true'»
	            @TableField(exist = false)
	            private static final long serialVersionUID = 1L;
	            
	        «ENDIF»
	    }
	'''    
	
	// 生成DTO类代码
	def CharSequence toDTOClass(DtoDefinition rule, Model model) '''
	    «IF !rule.lombokAnnotation.nullOrEmpty»
	        «rule.lombokAnnotation.map[toAnnotationString].join('\n')»
	    «ENDIF»
	    public class «rule.name.toFirstUpper» «IF rule.serializable == 'true'»implements Serializable «ENDIF»{
	    	
	        «IF rule.excludeAll != 'true'»
    	        «val excludeNames = rule.exclusions.map[it.field.name].toSet»
    	        «FOR currentfield : model.fields.filter[ !excludeNames.contains(it.name) ]»
		            «IF rule.fieldAnnotationsBlock !== null»
			            «IF rule.fieldAnnotationsBlock.actionGlobal !== null && !rule.fieldAnnotationsBlock.actionGlobal.nullOrEmpty»
			                «rule.fieldAnnotationsBlock.actionGlobal.map[ it.variable.annotation ].filterNull.map[ toAnnotationString ].join('\n')»
			            «ENDIF»
			            «IF rule.fieldAnnotationsBlock.actionLocal !== null && !rule.fieldAnnotationsBlock.actionLocal.nullOrEmpty»
			                «FOR loop : rule.fieldAnnotationsBlock.actionLocal» ««« 处理每一个循环
			                    «IF !loop.actions.nullOrEmpty»					««« 如果循环中有行动
			                        «FOR action : loop.actions»					««« 添加每一个 的注释
			                            «IF evaluateCondition(action.condition, currentfield.type)»
			                                «loop.varDeclarations.map[ it.annotation ].filterNull.map[ toAnnotationString ].join('\n')»
			                            «ENDIF»
			                        «ENDFOR»
			                    «ENDIF»
			                «ENDFOR»
			            «ENDIF»
			            «IF rule.fieldAnnotationsBlock.actionSingle !== null && rule.fieldAnnotationsBlock.actionSingle.validations.exists[it.field == currentfield.name]»
			                «rule.fieldAnnotationsBlock.actionSingle.validations.findFirst[it.field == currentfield.name].annList.map[toAnnotationString].join('\n')»
			            «ENDIF»
		            «ENDIF»
		            	private «currentfield.type.getTypeName» «currentfield.name»;
		            
		        «ENDFOR»
	        «ENDIF»
	        «FOR currentfield : rule.addField»
        		«currentfield.annotationList.map[toAnnotationString].join('\n')»
        			private «currentfield.properties.type.getTypeName» «currentfield.properties.name»«IF !currentfield.properties.defaultClause.nullOrEmpty» «currentfield.properties.defaultClause»«ENDIF»;
        			
	        «ENDFOR»
	        «IF rule.serializable == 'true'»
	            @TableField(exist = false)
	            private static final long serialVersionUID = 1L;
	            
	        «ENDIF»
	    }
	'''
	
	// 生成VO类代码
	def CharSequence toVOClass(VoDefinition rule, Model model) '''
	«IF !rule.lombokAnnotation.nullOrEmpty»
	«rule.lombokAnnotation.map[toAnnotationString].join('\n')»
	«ENDIF»
	public class «rule.name.toFirstUpper» «IF rule.serializable == 'true'»implements Serializable «ENDIF»{
		
	    «IF rule.excludeAll != 'true'»
	        «val excludeNames = rule.exclusions.map[it.field.name].toSet»
	        «FOR currentfield : model.fields.filter[ !excludeNames.contains(it.name) ]»
	            «IF rule.jacksons.exists[it.field.name == currentfield.name]»
	«rule.jacksons.findFirst[it.field.name == currentfield.name].annList.map[toAnnotationString].join('\n')»
	            «ENDIF»
	            private «currentfield.type.getTypeName» «currentfield.name»;
	            
	        «ENDFOR»
	    «ENDIF»
	    «FOR currentfield : rule.addField»
	        «currentfield.annotationList.map[toAnnotationString].join('\n')»
	        private «currentfield.properties.type.getTypeName» «currentfield.properties.name»«IF !currentfield.properties.defaultClause.nullOrEmpty» «currentfield.properties.defaultClause»«ENDIF»;
	        
	    «ENDFOR»
	    «IF rule.serializable == 'true'»
	        @TableField(exist = false)
	        private static final long serialVersionUID = 1L;
	        
	    «ENDIF»
	}
	'''


    

    def dispatch String getTypeName(NormalType type) {
    	println('NormalType')
        return type.customType
    }

    def dispatch String getTypeName(SimpleType type) {
    	println('BuiltInType: ' + type.builtInType.literal)
        return type.builtInType.literal
    }
    
    def dispatch String getTypeName(ArrayType type) {
    	println('ArrayType')
        return getTypeName(type.elementType) + '[]'
    }
    
    def dispatch String getTypeName(GenericDataType type) {
    	println('GenericDataType')
        return type.containerTypeName + '<' + getTypeName(type.containedTypeName) + '>'
    }
	
	
	// 处理 Lombok 注解
	def String toAnnotationString(LombokAnnotation annotation) {
	    if (annotation.parameters !== null)
	        '''@«annotation.name»(«annotation.parameters.annparameters.map[getKey() + " = " + getValue()].join(", ")»)'''
	    else
	        '''@«annotation.name»'''
	}
	
	// 处理 Mybatis-Plus 注解
	def String toAnnotationString(MybatisPlusModelAnnotation annotation) {
	    if (annotation.parameters !== null)
	        '''@«annotation.name»(«annotation.parameters.annparameters.map[getKey() + " = " + getValue()].join(", ")»)'''
	    else
	        '''@«annotation.name»'''
	}
	
	// 处理 Mybatis-Plus 字段注解
	def String toAnnotationString(MybatisPlusFieldAnnotation annotation) {
	    if (annotation.parameters !== null)
	        '''	@«annotation.name»(«annotation.parameters.annparameters.map[getKey() + " = " + getValue()].join(", ")»)'''
	    else
	        '''	@«annotation.name»'''
	}
	
	// 处理 Jackson 字段注解
	def String toAnnotationString(JacksonAnnotation annotation) {
	    if (annotation.parameters !== null)
	        '''	@«annotation.name»(«annotation.parameters.annparameters.map[getKey() + " = " + getValue()].join(", ")»)'''
	    else
	        '''	@«annotation.name»'''
	}
	
	// 处理 Bean Validation 字段注解
	def String toAnnotationString(BeanValidationAnnotation annotation) {
	    if (annotation.parameters !== null)
	        '''	@«annotation.name»(«annotation.parameters.annparameters.map[getKey() + " = " + getValue()].join(", ")»)'''
	    else
	        '''	@«annotation.name»'''
	}
	
	
	// 处理注解参数格式化
	def String toString(Parameter param) {
	    '''«param.key» = «param.value»'''
	}
	

	def Boolean evaluateCondition(TypeCondition condition, Type type) {
		println("\n****************************************************")
	    println("\n开始评估条件: ===== 当前Type: "+type)
	    var result = evaluateOrCondition(condition as OrTypeCondition, type)
	    println("条件评估结果: " + result)
	    return result
	}
	
	def private Boolean evaluateOrCondition(OrTypeCondition condition, Type type) {
	    println("\n开始评估 OR 条件: ")
	    var leftResult = evaluateAndCondition(condition.left, type)
	    println("OR 条件左部分结果: " + leftResult)
	    if (leftResult) {
	        println("OR 条件因左部分为 true 直接返回 true")
	        return true
	    }
	    for (rightCondition : condition.right) {
	        var rightResult = evaluateAndCondition(rightCondition, type)
	        println("OR 条件右部分 " + rightCondition + " 结果: " + rightResult)
	        if (rightResult) {
	            println("OR 条件因右部分为 true 返回 true")
	            return true
	        }
	    }
	    println("OR 条件所有部分都为 false，返回 false")
	    return false
	}
	
	def private Boolean evaluateAndCondition(AndTypeCondition condition, Type type) {
	    println("\n开始评估 AND 条件: ")
	    var leftResult = evaluateEqualityCondition(condition.left, type)
	    println("AND 条件左部分结果: " + leftResult)
	    if (!leftResult) {
	        println("AND 条件因左部分为 false 直接返回 false")
	        return false
	    }
	    for (rightCondition : condition.right) {
	        var rightResult = evaluateEqualityCondition(rightCondition, type)
	        println("AND 条件右部分 " + rightCondition + " 结果: " + rightResult)
	        if (!rightResult) {
	            println("AND 条件因右部分为 false 返回 false")
	            return false
	        }
	    }
	    println("AND 条件所有部分都为 true，返回 true")
	    return true
	}
	
	def private Boolean evaluateEqualityCondition(TypeEqualityCondition condition, Type type) {
	    println("\n开始评估相等条件: ")
	    val targetType = condition.type
	    println("targetType: " + targetType + " === type: " + type)
	    println("condition.isEqual: " + condition.isEqual + " | condition.isNotEqual: " + condition.isNotEqual)
	
	    // 判断条件是 "==" 还是 "!="
	    val isEqualCondition = (condition.isEqual !== null)  // 如果有 isEqual 标记，说明是 == 比较
	    println("是否为相等条件: " + isEqualCondition)
	
	    val result = if (isEqualCondition) {
	        // 执行 == 比较
	        isTypeEqual(type, targetType)  // 需要确保 Type 类正确重写了 equals 方法
	    } else {
	        // 执行 != 比较
	        !isTypeEqual(type, targetType)
	    }
	    println("评估结果: " + result)
	    return result
	}
	
	def static boolean isTypeEqual(Type t1, Type t2) {
	    // 处理空值和同一实例
	    if (t1 === t2) {
	        println("类型相同（同一实例）：true")
	        return true
	    }
	    if (t1 === null || t2 === null) {
	        println("其中一个类型为 null：false")
	        return false
	    }
	
	    // 打印当前比较的类型
	    println("\n比较类型：")
	    println("t1: " + t1.class.simpleName + " -> " + t1)
	    println("t2: " + t2.class.simpleName + " -> " + t2)
	
	    // 根据具体类型分支比较
	    val result = switch(t1) {
	        SimpleType: {
	            if (t2 instanceof SimpleType) {
	                // 比较内置类型枚举值
	                println("比较 SimpleType：")
	                println("t1.builtInType: " + t1.builtInType)
	                println("t2.builtInType: " + t2.builtInType)
	                t1.builtInType == t2.builtInType
	            } else {
	                println("t2 不是 SimpleType：false")
	                false
	            }
	        }
	        NormalType: {
	            if (t2 instanceof NormalType) {
	                // 比较自定义类型名
	                println("比较 NormalType：")
	                println("t1.customType: " + t1.customType)
	                println("t2.customType: " + t2.customType)
	                t1.customType == t2.customType
	            } else {
	                println("t2 不是 NormalType：false")
	                false
	            }
	        }
	        ArrayType: {
	            if (t2 instanceof ArrayType) {
	                // 递归比较元素类型
	                println("比较 ArrayType：")
	                println("t1.elementType: " + t1.elementType)
	                println("t2.elementType: " + t2.elementType)
	                isTypeEqual(t1.elementType, t2.elementType)
	            } else {
	                println("t2 不是 ArrayType：false")
	                false
	            }
	        }
	        GenericDataType: {
	            if (t2 instanceof GenericDataType) {
	                // 比较容器类型名和嵌套类型
	                println("比较 GenericDataType：")
	                println("t1.containerTypeName: " + t1.containerTypeName)
	                println("t2.containerTypeName: " + t2.containerTypeName)
	                println("t1.containedTypeName: " + t1.containedTypeName)
	                println("t2.containedTypeName: " + t2.containedTypeName)
	                t1.containerTypeName == t2.containerTypeName &&
	                isTypeEqual(t1.containedTypeName, t2.containedTypeName)
	            } else {
	                println("t2 不是 GenericDataType：false")
	                false
	            }
	        }
	        default: {
	            println("未知类型：false")
	            false
	        }
	    }
	
	    println("比较结果：" + result)
	    return result
	}
}