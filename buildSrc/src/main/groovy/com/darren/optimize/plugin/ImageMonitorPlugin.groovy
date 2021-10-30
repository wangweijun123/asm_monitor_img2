package com.darren.optimize.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * gradle编译的一个插件，很像一个拦截器,调用完一个拦截器修改之后的内容，接着给
 * 下一个插件  class  ---插件1----插件2---->  dex
 */
class ImageMonitorPlugin implements Plugin<Project> {
    public static final String EXT_NAME = "tinkerPatch"
    @Override
    void apply(Project project) {
        println " apply image plugin "
        // 传递参数
        // 这里怎么写？怎么样去修改 class ，asm，模板，transform
//        def android = project.extensions.getByType(AppExtension)
//        android.registerTransform(new ImageMonitorTransform())
    }
}
