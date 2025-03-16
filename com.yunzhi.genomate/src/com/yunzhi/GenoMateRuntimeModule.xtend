package com.yunzhi

import com.yunzhi.generator.GenoMateGenerator
import org.eclipse.xtext.generator.IGenerator2
import com.yunzhi.scoping.GenoMateScopeProvider

class GenoMateRuntimeModule extends AbstractGenoMateRuntimeModule {
    override bindIScopeProvider() {
        GenoMateScopeProvider
    }
    // 绑定生成器类
    override Class<? extends IGenerator2> bindIGenerator2() {
        return GenoMateGenerator
    }
}