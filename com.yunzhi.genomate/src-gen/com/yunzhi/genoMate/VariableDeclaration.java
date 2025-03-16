/**
 * generated by Xtext 2.38.0
 */
package com.yunzhi.genoMate;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yunzhi.genoMate.VariableDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link com.yunzhi.genoMate.VariableDeclaration#getAnnotation <em>Annotation</em>}</li>
 * </ul>
 *
 * @see com.yunzhi.genoMate.GenoMatePackage#getVariableDeclaration()
 * @model
 * @generated
 */
public interface VariableDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.yunzhi.genoMate.GenoMatePackage#getVariableDeclaration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.yunzhi.genoMate.VariableDeclaration#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Annotation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotation</em>' containment reference.
   * @see #setAnnotation(BeanValidationAnnotation)
   * @see com.yunzhi.genoMate.GenoMatePackage#getVariableDeclaration_Annotation()
   * @model containment="true"
   * @generated
   */
  BeanValidationAnnotation getAnnotation();

  /**
   * Sets the value of the '{@link com.yunzhi.genoMate.VariableDeclaration#getAnnotation <em>Annotation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Annotation</em>' containment reference.
   * @see #getAnnotation()
   * @generated
   */
  void setAnnotation(BeanValidationAnnotation value);

} // VariableDeclaration
