package com.yunzhi;

import com.yunzhi.generator.GenoMateGenerator;
import com.yunzhi.scoping.GenoMateScopeProvider;
import org.eclipse.xtext.generator.IGenerator2;
import org.eclipse.xtext.scoping.IScopeProvider;

@SuppressWarnings("all")
public class GenoMateRuntimeModule extends AbstractGenoMateRuntimeModule {
  @Override
  public Class<? extends IScopeProvider> bindIScopeProvider() {
    return GenoMateScopeProvider.class;
  }

  @Override
  public Class<? extends IGenerator2> bindIGenerator2() {
    return GenoMateGenerator.class;
  }
}
