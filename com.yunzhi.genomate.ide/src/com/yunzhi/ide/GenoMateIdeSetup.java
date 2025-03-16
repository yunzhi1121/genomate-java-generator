/*
 * generated by Xtext 2.38.0
 */
package com.yunzhi.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.yunzhi.GenoMateRuntimeModule;
import com.yunzhi.GenoMateStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class GenoMateIdeSetup extends GenoMateStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new GenoMateRuntimeModule(), new GenoMateIdeModule()));
	}
	
}
