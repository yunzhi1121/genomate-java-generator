/**
 * generated by Xtext 2.38.0
 */
package com.yunzhi.genoMate;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mybatis Plus Field Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yunzhi.genoMate.MybatisPlusFieldAnnotation#getName <em>Name</em>}</li>
 *   <li>{@link com.yunzhi.genoMate.MybatisPlusFieldAnnotation#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see com.yunzhi.genoMate.GenoMatePackage#getMybatisPlusFieldAnnotation()
 * @model
 * @generated
 */
public interface MybatisPlusFieldAnnotation extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * The literals are from the enumeration {@link com.yunzhi.genoMate.MybatisPlusFieldType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see com.yunzhi.genoMate.MybatisPlusFieldType
   * @see #setName(MybatisPlusFieldType)
   * @see com.yunzhi.genoMate.GenoMatePackage#getMybatisPlusFieldAnnotation_Name()
   * @model
   * @generated
   */
  MybatisPlusFieldType getName();

  /**
   * Sets the value of the '{@link com.yunzhi.genoMate.MybatisPlusFieldAnnotation#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see com.yunzhi.genoMate.MybatisPlusFieldType
   * @see #getName()
   * @generated
   */
  void setName(MybatisPlusFieldType value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference.
   * @see #setParameters(AnnotationParameters)
   * @see com.yunzhi.genoMate.GenoMatePackage#getMybatisPlusFieldAnnotation_Parameters()
   * @model containment="true"
   * @generated
   */
  AnnotationParameters getParameters();

  /**
   * Sets the value of the '{@link com.yunzhi.genoMate.MybatisPlusFieldAnnotation#getParameters <em>Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameters</em>' containment reference.
   * @see #getParameters()
   * @generated
   */
  void setParameters(AnnotationParameters value);

} // MybatisPlusFieldAnnotation
