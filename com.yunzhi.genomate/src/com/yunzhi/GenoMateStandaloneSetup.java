/*
 * generated by Xtext 2.38.0
 */
package com.yunzhi;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class GenoMateStandaloneSetup extends GenoMateStandaloneSetupGenerated {

	public static void doSetup() {
		new GenoMateStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
