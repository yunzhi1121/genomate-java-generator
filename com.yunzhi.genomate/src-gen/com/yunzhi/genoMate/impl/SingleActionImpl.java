/**
 * generated by Xtext 2.38.0
 */
package com.yunzhi.genoMate.impl;

import com.yunzhi.genoMate.DtoValidation;
import com.yunzhi.genoMate.GenoMatePackage;
import com.yunzhi.genoMate.SingleAction;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.yunzhi.genoMate.impl.SingleActionImpl#getValidations <em>Validations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SingleActionImpl extends MinimalEObjectImpl.Container implements SingleAction
{
  /**
   * The cached value of the '{@link #getValidations() <em>Validations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValidations()
   * @generated
   * @ordered
   */
  protected EList<DtoValidation> validations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SingleActionImpl()
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
    return GenoMatePackage.Literals.SINGLE_ACTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<DtoValidation> getValidations()
  {
    if (validations == null)
    {
      validations = new EObjectContainmentEList<DtoValidation>(DtoValidation.class, this, GenoMatePackage.SINGLE_ACTION__VALIDATIONS);
    }
    return validations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GenoMatePackage.SINGLE_ACTION__VALIDATIONS:
        return ((InternalEList<?>)getValidations()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case GenoMatePackage.SINGLE_ACTION__VALIDATIONS:
        return getValidations();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GenoMatePackage.SINGLE_ACTION__VALIDATIONS:
        getValidations().clear();
        getValidations().addAll((Collection<? extends DtoValidation>)newValue);
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
      case GenoMatePackage.SINGLE_ACTION__VALIDATIONS:
        getValidations().clear();
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
      case GenoMatePackage.SINGLE_ACTION__VALIDATIONS:
        return validations != null && !validations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SingleActionImpl
