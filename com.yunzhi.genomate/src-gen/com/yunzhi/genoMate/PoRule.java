/**
 * generated by Xtext 2.38.0
 */
package com.yunzhi.genoMate;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Po Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yunzhi.genoMate.PoRule#getSerializable <em>Serializable</em>}</li>
 *   <li>{@link com.yunzhi.genoMate.PoRule#getLombokAnnotation <em>Lombok Annotation</em>}</li>
 *   <li>{@link com.yunzhi.genoMate.PoRule#getMybatisPlusModelAnnotation <em>Mybatis Plus Model Annotation</em>}</li>
 *   <li>{@link com.yunzhi.genoMate.PoRule#getFieldAnns <em>Field Anns</em>}</li>
 *   <li>{@link com.yunzhi.genoMate.PoRule#getAddField <em>Add Field</em>}</li>
 * </ul>
 *
 * @see com.yunzhi.genoMate.GenoMatePackage#getPoRule()
 * @model
 * @generated
 */
public interface PoRule extends GenerationRule
{
  /**
   * Returns the value of the '<em><b>Serializable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Serializable</em>' attribute.
   * @see #setSerializable(String)
   * @see com.yunzhi.genoMate.GenoMatePackage#getPoRule_Serializable()
   * @model
   * @generated
   */
  String getSerializable();

  /**
   * Sets the value of the '{@link com.yunzhi.genoMate.PoRule#getSerializable <em>Serializable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Serializable</em>' attribute.
   * @see #getSerializable()
   * @generated
   */
  void setSerializable(String value);

  /**
   * Returns the value of the '<em><b>Lombok Annotation</b></em>' containment reference list.
   * The list contents are of type {@link com.yunzhi.genoMate.LombokAnnotation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lombok Annotation</em>' containment reference list.
   * @see com.yunzhi.genoMate.GenoMatePackage#getPoRule_LombokAnnotation()
   * @model containment="true"
   * @generated
   */
  EList<LombokAnnotation> getLombokAnnotation();

  /**
   * Returns the value of the '<em><b>Mybatis Plus Model Annotation</b></em>' containment reference list.
   * The list contents are of type {@link com.yunzhi.genoMate.MybatisPlusModelAnnotation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mybatis Plus Model Annotation</em>' containment reference list.
   * @see com.yunzhi.genoMate.GenoMatePackage#getPoRule_MybatisPlusModelAnnotation()
   * @model containment="true"
   * @generated
   */
  EList<MybatisPlusModelAnnotation> getMybatisPlusModelAnnotation();

  /**
   * Returns the value of the '<em><b>Field Anns</b></em>' containment reference list.
   * The list contents are of type {@link com.yunzhi.genoMate.FieldAnnotation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field Anns</em>' containment reference list.
   * @see com.yunzhi.genoMate.GenoMatePackage#getPoRule_FieldAnns()
   * @model containment="true"
   * @generated
   */
  EList<FieldAnnotation> getFieldAnns();

  /**
   * Returns the value of the '<em><b>Add Field</b></em>' containment reference list.
   * The list contents are of type {@link com.yunzhi.genoMate.PoAddField}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Add Field</em>' containment reference list.
   * @see com.yunzhi.genoMate.GenoMatePackage#getPoRule_AddField()
   * @model containment="true"
   * @generated
   */
  EList<PoAddField> getAddField();

} // PoRule
