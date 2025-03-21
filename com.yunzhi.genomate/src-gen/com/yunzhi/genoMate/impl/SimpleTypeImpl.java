/**
 * generated by Xtext 2.38.0
 */
package com.yunzhi.genoMate.impl;

import com.yunzhi.genoMate.BuiltInType;
import com.yunzhi.genoMate.GenoMatePackage;
import com.yunzhi.genoMate.SimpleType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.yunzhi.genoMate.impl.SimpleTypeImpl#getBuiltInType <em>Built In Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimpleTypeImpl extends TypeImpl implements SimpleType
{
  /**
   * The default value of the '{@link #getBuiltInType() <em>Built In Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBuiltInType()
   * @generated
   * @ordered
   */
  protected static final BuiltInType BUILT_IN_TYPE_EDEFAULT = BuiltInType.INT;

  /**
   * The cached value of the '{@link #getBuiltInType() <em>Built In Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBuiltInType()
   * @generated
   * @ordered
   */
  protected BuiltInType builtInType = BUILT_IN_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SimpleTypeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return GenoMatePackage.Literals.SIMPLE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BuiltInType getBuiltInType()
  {
    return builtInType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setBuiltInType(BuiltInType newBuiltInType)
  {
    BuiltInType oldBuiltInType = builtInType;
    builtInType = newBuiltInType == null ? BUILT_IN_TYPE_EDEFAULT : newBuiltInType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenoMatePackage.SIMPLE_TYPE__BUILT_IN_TYPE, oldBuiltInType, builtInType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case GenoMatePackage.SIMPLE_TYPE__BUILT_IN_TYPE:
        return getBuiltInType();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GenoMatePackage.SIMPLE_TYPE__BUILT_IN_TYPE:
        setBuiltInType((BuiltInType)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case GenoMatePackage.SIMPLE_TYPE__BUILT_IN_TYPE:
        setBuiltInType(BUILT_IN_TYPE_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GenoMatePackage.SIMPLE_TYPE__BUILT_IN_TYPE:
        return builtInType != BUILT_IN_TYPE_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (builtInType: ");
    result.append(builtInType);
    result.append(')');
    return result.toString();
  }

} //SimpleTypeImpl
