/*
 * generated by Xtext 2.38.0
 */
package com.yunzhi.ui.tests;

import com.google.inject.Injector;
import com.yunzhi.genomate.ui.internal.GenomateActivator;
import org.eclipse.xtext.testing.IInjectorProvider;

public class GenoMateUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return GenomateActivator.getInstance().getInjector("com.yunzhi.GenoMate");
	}

}
