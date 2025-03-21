/*
 * generated by Xtext 2.38.0
 */
package com.yunzhi.ui;

import com.google.inject.Injector;
import com.yunzhi.genomate.ui.internal.GenomateActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class GenoMateExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(GenomateActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		GenomateActivator activator = GenomateActivator.getInstance();
		return activator != null ? activator.getInjector(GenomateActivator.COM_YUNZHI_GENOMATE) : null;
	}

}
