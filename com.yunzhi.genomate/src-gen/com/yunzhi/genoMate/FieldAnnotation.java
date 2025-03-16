/**
 * generated by Xtext 2.38.0
 */
package com.yunzhi.genoMate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yunzhi.genoMate.FieldAnnotation#getField <em>Field</em>}</li>
 *   <li>{@link com.yunzhi.genoMate.FieldAnnotation#getAnnList <em>Ann List</em>}</li>
 * </ul>
 *
 * @see com.yunzhi.genoMate.GenoMatePackage#getFieldAnnotation()
 * @model
 * @generated
 */
public interface FieldAnnotation extends EObject
{
  /**
   * Returns the value of the '<em><b>Field</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field</em>' reference.
   * @see #setField(Field)
   * @see com.yunzhi.genoMate.GenoMatePackage#getFieldAnnotation_Field()
   * @model
   * @generated
   */
  Field getField();

  /**
   * Sets the value of the '{@link com.yunzhi.genoMate.FieldAnnotation#getField <em>Field</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field</em>' reference.
   * @see #getField()
   * @generated
   */
  void setField(Field value);

  /**
   * Returns the value of the '<em><b>Ann List</b></em>' containment reference list.
   * The list contents are of type {@link com.yunzhi.genoMate.MybatisPlusFieldAnnotation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ann List</em>' containment reference list.
   * @see com.yunzhi.genoMate.GenoMatePackage#getFieldAnnotation_AnnList()
   * @model containment="true"
   * @generated
   */
  EList<MybatisPlusFieldAnnotation> getAnnList();

} // FieldAnnotation
