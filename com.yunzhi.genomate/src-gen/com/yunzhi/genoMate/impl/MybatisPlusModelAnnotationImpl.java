/**
 * generated by Xtext 2.38.0
 */
package com.yunzhi.genoMate.impl;

import com.yunzhi.genoMate.AnnotationParameters;
import com.yunzhi.genoMate.GenoMatePackage;
import com.yunzhi.genoMate.MybatisPlusModelAnnotation;
import com.yunzhi.genoMate.MybatisPlusModelType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mybatis Plus Model Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.yunzhi.genoMate.impl.MybatisPlusModelAnnotationImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.yunzhi.genoMate.impl.MybatisPlusModelAnnotationImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MybatisPlusModelAnnotationImpl extends MinimalEObjectImpl.Container implements MybatisPlusModelAnnotation
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final MybatisPlusModelType NAME_EDEFAULT = MybatisPlusModelType.KEY_SEQUENCE;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected MybatisPlusModelType name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected AnnotationParameters parameters;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MybatisPlusModelAnnotationImpl()
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
    return GenoMatePackage.Literals.MYBATIS_PLUS_MODEL_ANNOTATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MybatisPlusModelType getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(MybatisPlusModelType newName)
  {
    MybatisPlusModelType oldName = name;
    name = newName == null ? NAME_EDEFAULT : newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenoMatePackage.MYBATIS_PLUS_MODEL_ANNOTATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AnnotationParameters getParameters()
  {
    return parameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParameters(AnnotationParameters newParameters, NotificationChain msgs)
  {
    AnnotationParameters oldParameters = parameters;
    parameters = newParameters;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GenoMatePackage.MYBATIS_PLUS_MODEL_ANNOTATION__PARAMETERS, oldParameters, newParameters);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setParameters(AnnotationParameters newParameters)
  {
    if (newParameters != parameters)
    {
      NotificationChain msgs = null;
      if (parameters != null)
        msgs = ((InternalEObject)parameters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GenoMatePackage.MYBATIS_PLUS_MODEL_ANNOTATION__PARAMETERS, null, msgs);
      if (newParameters != null)
        msgs = ((InternalEObject)newParameters).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GenoMatePackage.MYBATIS_PLUS_MODEL_ANNOTATION__PARAMETERS, null, msgs);
      msgs = basicSetParameters(newParameters, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenoMatePackage.MYBATIS_PLUS_MODEL_ANNOTATION__PARAMETERS, newParameters, newParameters));
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
      case GenoMatePackage.MYBATIS_PLUS_MODEL_ANNOTATION__PARAMETERS:
        return basicSetParameters(null, msgs);
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
      case GenoMatePackage.MYBATIS_PLUS_MODEL_ANNOTATION__NAME:
        return getName();
      case GenoMatePackage.MYBATIS_PLUS_MODEL_ANNOTATION__PARAMETERS:
        return getParameters();
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
      case GenoMatePackage.MYBATIS_PLUS_MODEL_ANNOTATION__NAME:
        setName((MybatisPlusModelType)newValue);
        return;
      case GenoMatePackage.MYBATIS_PLUS_MODEL_ANNOTATION__PARAMETERS:
        setParameters((AnnotationParameters)newValue);
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
      case GenoMatePackage.MYBATIS_PLUS_MODEL_ANNOTATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GenoMatePackage.MYBATIS_PLUS_MODEL_ANNOTATION__PARAMETERS:
        setParameters((AnnotationParameters)null);
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
      case GenoMatePackage.MYBATIS_PLUS_MODEL_ANNOTATION__NAME:
        return name != NAME_EDEFAULT;
      case GenoMatePackage.MYBATIS_PLUS_MODEL_ANNOTATION__PARAMETERS:
        return parameters != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //MybatisPlusModelAnnotationImpl
