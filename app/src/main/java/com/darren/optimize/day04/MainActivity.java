package com.darren.optimize.day04;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 插入一个方法耗时代码，自己去实现，配合 annotation ,配合配置，自己去实现
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 背景需求, 为什么插件代码在这里会生效？

        ImageView imageView = findViewById(R.id.image_view);
        imageView.setImageResource(R.mipmap.ic_launcher);
        //1 imageView 真正的类型是 AppCompontImageView,2
        // 2 AppCompontImageView父类不再是ImageView,背替换成了MonitorImageView
        Log.i(MonitorImageView.TAG, "imageView = " +imageView + ", getSuperclass="+imageView.getClass().getSuperclass());// AppCompontImageView
        // bitmap 是大图，2M ，告警加载了大图， 图片大小只有 40 dp
        // 网络或者本地的图片加载 200dp*200dp ，告警加载不合法
        // 滴滴的方案也很不错，加载大图告警，还可以显示链接，弊端需要各种适配4套，不能显示是否合法
    }
}
