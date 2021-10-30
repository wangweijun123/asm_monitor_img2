package com.darren.optimize.plugin
import com.android.build.gradle.AppExtension
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
        println 'apply ImageMonitorPlugin'
        // extensions 调用的是方法
        def android = project.extensions.getByType(AppExtension)
        println 'apply android =' + android
        android.registerTransform(new ImageMonitorTransform())
    }
}
