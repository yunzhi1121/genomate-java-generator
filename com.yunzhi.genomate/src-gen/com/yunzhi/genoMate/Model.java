/**
 * generated by Xtext 2.38.0
 */
package com.yunzhi.genoMate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yunzhi.genoMate.Model#getName <em>Name</em>}</li>
 *   <li>{@link com.yunzhi.genoMate.Model#getFields <em>Fields</em>}</li>
 * </ul>
 *
 * @see com.yunzhi.genoMate.GenoMatePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.yunzhi.genoMate.GenoMatePackage#getModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.yunzhi.genoMate.Model#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
   * The list contents are of type {@link com.yunzhi.genoMate.Field}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fields</em>' containment reference list.
   * @see com.yunzhi.genoMate.GenoMatePackage#getModel_Fields()
   * @model containment="true"
   * @generated
   */
  EList<Field> getFields();

} // Model
