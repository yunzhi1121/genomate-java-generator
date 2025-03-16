/**
 * generated by Xtext 2.38.0
 */
package com.yunzhi.genoMate.impl;

import com.yunzhi.genoMate.GenerateSection;
import com.yunzhi.genoMate.GenoMate;
import com.yunzhi.genoMate.GenoMatePackage;
import com.yunzhi.genoMate.GlobalConfig;
import com.yunzhi.genoMate.Mapping;
import com.yunzhi.genoMate.Model;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Geno Mate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.yunzhi.genoMate.impl.GenoMateImpl#getGlobalConfig <em>Global Config</em>}</li>
 *   <li>{@link com.yunzhi.genoMate.impl.GenoMateImpl#getModel <em>Model</em>}</li>
 *   <li>{@link com.yunzhi.genoMate.impl.GenoMateImpl#getGenerateSection <em>Generate Section</em>}</li>
 *   <li>{@link com.yunzhi.genoMate.impl.GenoMateImpl#getMappings <em>Mappings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenoMateImpl extends MinimalEObjectImpl.Container implements GenoMate
{
  /**
   * The cached value of the '{@link #getGlobalConfig() <em>Global Config</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGlobalConfig()
   * @generated
   * @ordered
   */
  protected GlobalConfig globalConfig;

  /**
   * The cached value of the '{@link #getModel() <em>Model</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModel()
   * @generated
   * @ordered
   */
  protected Model model;

  /**
   * The cached value of the '{@link #getGenerateSection() <em>Generate Section</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenerateSection()
   * @generated
   * @ordered
   */
  protected GenerateSection generateSection;

  /**
   * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMappings()
   * @generated
   * @ordered
   */
  protected EList<Mapping> mappings;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GenoMateImpl()
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
    return GenoMatePackage.Literals.GENO_MATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GlobalConfig getGlobalConfig()
  {
    return globalConfig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGlobalConfig(GlobalConfig newGlobalConfig, NotificationChain msgs)
  {
    GlobalConfig oldGlobalConfig = globalConfig;
    globalConfig = newGlobalConfig;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GenoMatePackage.GENO_MATE__GLOBAL_CONFIG, oldGlobalConfig, newGlobalConfig);
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
  public void setGlobalConfig(GlobalConfig newGlobalConfig)
  {
    if (newGlobalConfig != globalConfig)
    {
      NotificationChain msgs = null;
      if (globalConfig != null)
        msgs = ((InternalEObject)globalConfig).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GenoMatePackage.GENO_MATE__GLOBAL_CONFIG, null, msgs);
      if (newGlobalConfig != null)
        msgs = ((InternalEObject)newGlobalConfig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GenoMatePackage.GENO_MATE__GLOBAL_CONFIG, null, msgs);
      msgs = basicSetGlobalConfig(newGlobalConfig, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenoMatePackage.GENO_MATE__GLOBAL_CONFIG, newGlobalConfig, newGlobalConfig));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Model getModel()
  {
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModel(Model newModel, NotificationChain msgs)
  {
    Model oldModel = model;
    model = newModel;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GenoMatePackage.GENO_MATE__MODEL, oldModel, newModel);
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
  public void setModel(Model newModel)
  {
    if (newModel != model)
    {
      NotificationChain msgs = null;
      if (model != null)
        msgs = ((InternalEObject)model).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GenoMatePackage.GENO_MATE__MODEL, null, msgs);
      if (newModel != null)
        msgs = ((InternalEObject)newModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GenoMatePackage.GENO_MATE__MODEL, null, msgs);
      msgs = basicSetModel(newModel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenoMatePackage.GENO_MATE__MODEL, newModel, newModel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GenerateSection getGenerateSection()
  {
    return generateSection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGenerateSection(GenerateSection newGenerateSection, NotificationChain msgs)
  {
    GenerateSection oldGenerateSection = generateSection;
    generateSection = newGenerateSection;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GenoMatePackage.GENO_MATE__GENERATE_SECTION, oldGenerateSection, newGenerateSection);
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
  public void setGenerateSection(GenerateSection newGenerateSection)
  {
    if (newGenerateSection != generateSection)
    {
      NotificationChain msgs = null;
      if (generateSection != null)
        msgs = ((InternalEObject)generateSection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GenoMatePackage.GENO_MATE__GENERATE_SECTION, null, msgs);
      if (newGenerateSection != null)
        msgs = ((InternalEObject)newGenerateSection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GenoMatePackage.GENO_MATE__GENERATE_SECTION, null, msgs);
      msgs = basicSetGenerateSection(newGenerateSection, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenoMatePackage.GENO_MATE__GENERATE_SECTION, newGenerateSection, newGenerateSection));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Mapping> getMappings()
  {
    if (mappings == null)
    {
      mappings = new EObjectContainmentEList<Mapping>(Mapping.class, this, GenoMatePackage.GENO_MATE__MAPPINGS);
    }
    return mappings;
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
      case GenoMatePackage.GENO_MATE__GLOBAL_CONFIG:
        return basicSetGlobalConfig(null, msgs);
      case GenoMatePackage.GENO_MATE__MODEL:
        return basicSetModel(null, msgs);
      case GenoMatePackage.GENO_MATE__GENERATE_SECTION:
        return basicSetGenerateSection(null, msgs);
      case GenoMatePackage.GENO_MATE__MAPPINGS:
        return ((InternalEList<?>)getMappings()).basicRemove(otherEnd, msgs);
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
      case GenoMatePackage.GENO_MATE__GLOBAL_CONFIG:
        return getGlobalConfig();
      case GenoMatePackage.GENO_MATE__MODEL:
        return getModel();
      case GenoMatePackage.GENO_MATE__GENERATE_SECTION:
        return getGenerateSection();
      case GenoMatePackage.GENO_MATE__MAPPINGS:
        return getMappings();
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
      case GenoMatePackage.GENO_MATE__GLOBAL_CONFIG:
        setGlobalConfig((GlobalConfig)newValue);
        return;
      case GenoMatePackage.GENO_MATE__MODEL:
        setModel((Model)newValue);
        return;
      case GenoMatePackage.GENO_MATE__GENERATE_SECTION:
        setGenerateSection((GenerateSection)newValue);
        return;
      case GenoMatePackage.GENO_MATE__MAPPINGS:
        getMappings().clear();
        getMappings().addAll((Collection<? extends Mapping>)newValue);
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
      case GenoMatePackage.GENO_MATE__GLOBAL_CONFIG:
        setGlobalConfig((GlobalConfig)null);
        return;
      case GenoMatePackage.GENO_MATE__MODEL:
        setModel((Model)null);
        return;
      case GenoMatePackage.GENO_MATE__GENERATE_SECTION:
        setGenerateSection((GenerateSection)null);
        return;
      case GenoMatePackage.GENO_MATE__MAPPINGS:
        getMappings().clear();
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
      case GenoMatePackage.GENO_MATE__GLOBAL_CONFIG:
        return globalConfig != null;
      case GenoMatePackage.GENO_MATE__MODEL:
        return model != null;
      case GenoMatePackage.GENO_MATE__GENERATE_SECTION:
        return generateSection != null;
      case GenoMatePackage.GENO_MATE__MAPPINGS:
        return mappings != null && !mappings.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //GenoMateImpl
