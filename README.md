# android-base
安卓基础知识案例
## 一.高德地图使用
#### 包com.keaven.android.base.map

## 各种Drawable使用
#### 包com.keaven.android.base.drawable

##### BitmapDrawable
---

Content

##### layer-list--层次
---

Content

##### level-list--有层级
----

Content

##### TransitionDrawable--带过渡动画
----
TransitionDrawable是LayerDrawable的子类，不过它只负责管理两层drawable，并且提供了一个透明变化的动画，可以从议程drawable过渡到另外一层drawable的动画效果。

##### InsertDrawble
----
InsertDrawbleActivity
四周有padding的Drawable

##### ClipDrawable--裁剪
----
ClipDrawableActivity

##### 自定义Drawable
----
BitmapShader详解
public   BitmapShader(Bitmap bitmap,Shader.TileMode tileX,Shader.TileMode tileY)
调用这个方法来产生一个画有一个位图的渲染器（Shader）。
bitmap   在渲染器内使用的位图
tileX      The tiling mode for x to draw the bitmap in.   在位图上X方向花砖模式
tileY     The tiling mode for y to draw the bitmap in.    在位图上Y方向花砖模式
TileMode：（一共有三种）
CLAMP  ：如果渲染器超出原始边界范围，会复制范围内边缘染色。
REPEAT ：横向和纵向的重复渲染器图片，平铺。
MIRROR ：横向和纵向的重复渲染器图片，这个和REPEAT 重复方式不一样，他是以镜像方式平铺。

## 三.应用自动更新
#### 包com.keaven.android.base.update

## 四.WebView js交互
#### 包com.keaven.android.base.webview
参考：
JS调用Android里面的方法，Android调用JS里面的方法
http://blog.csdn.net/hj563308597/article/details/45197709

http://blog.csdn.net/beyond0525/article/details/9374301

跟webview相关：WebChromeClient，WebViewClient，WebSettings（查找资料）

关于android WebViewClient和WebChromeClient
http://blog.csdn.net/jackyhuangch/article/details/8310033
WebChromeClient：

好好和h5沟通！几种常见的hybrid通信方式
http://zjutkz.net/2016/04/17/%E5%A5%BD%E5%A5%BD%E5%92%8Ch5%E6%B2%9F%E9%80%9A%EF%BC%81%E5%87%A0%E7%A7%8D%E5%B8%B8%E8%A7%81%E7%9A%84hybrid%E9%80%9A%E4%BF%A1%E6%96%B9%E5%BC%8F/
内容概要：
1、原生方式
2、JSBridge
3、
4、
##### JsBridge交互实现
参考： http://blog.csdn.net/sbsujjbcy/article/details/50752595
自定义WebChromeClient并实现onJsPrompt方法，拦截html 中的prompt(arg0,arg1)方法，来实现js向原生方法的通信！
核心方法
 WebSettings settings = mWebView.getSettings();
 settings.setJavaScriptEnabled(true);
 mWebView.setWebChromeClient(new JSBridgeWebChromeClient());
 mWebView.loadUrl("file:///android_asset/index.html");
 JSBridge.register("bridge", BridgeImpl.class);//
 
##### DataBinding入门与实践
一、基础要求
1.支持：
Android平台最低能到Android 2.1（API等级7+）上使用它。需求：Android Plugin for Gradle 1.5.0-alpha1 或 更高版本。
2.构建环境：
要开始使用Data Binding，首先需要在Android SDK Manager的支持库里下载该库。
你的app要使用Data Binding，需要添加Data Binding到gradle构建文件里，如下：
android {
    ....
    dataBinding {
        enabled = true    
    }    
}
Data Binding插件将会在你的项目内添加必需提供的以及编译配置依赖。
请确保您使用的是Android Studio的兼容版本。Android Studio的Data Binding插件需要Android Studio 1.3.0 或 更高版本。
二、基本使用
1,Data Binding Layout文件
起始跟标签是<layout>……</layout>
接下来一个data元素以及一个view的根元素。这个view元素就是你没有使用Data Binding的layout文件的根元素。举例说明activity_demo.xml如下：
```
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">
   <data>
       <variable name="user" type="com.example.User"/>
   </data>
   <LinearLayout
       android:orientation="vertical"
       android:layout_width="match_parent"
       android:layout_height="match_parent">
       <TextView android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="@{user.firstName}"/>
       <TextView android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="@{user.lastName}"/>
   </LinearLayout>
</layout>
```
2.Activity写法
编写一个activity_demo.xml
```
public class BindingDemoActivity extends BaseActivity{
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user=new User("Jack","Jhons");
        ActivityDemoBinding binding= DataBindingUtil.setContentView(this, R.layout.activity_demo);//layout的绑定
//此处的ActivityDemoBinding是自动生成的，命名规范类似驼峰法，结尾加上Binding。例如：aaa_bbb.xml则对应AaaBbbBinding类
//此后，通过该binding更新数据或者绑定事件
        binding.setUser(user);
    }
}
```
2,数据绑定方式：
数据设置及表达式具体参照：
http://blog.csdn.net/qibin0506/article/details/47393725
(1)通过组件id来设置
假如有以下组件：
 <TextView android:id="@+id/first_name"
  android:layout_width="wrap_content"
           android:layout_height="wrap_content"/>
我们可以在Activity中使用
binding.firstName.setText(XXX);
这样就将数据更新到UI视图中去了
(2)UI绑定
```
<data>
       <variable name="user" type="com.example.User"/>
   </data>
 <TextView android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="@{user.firstName}"/>
       <TextView android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="@{user.lastName}"/>
```
在Activity中的表现形式是：
binding.setUser(user);
这样数据就更新到视图中了
(3)事件绑定：
方法绑定
监听器绑定lamada表达式



三、DataBinding原理
android.binding
BR
XXXBinding
基本原理






四、重要知识汇总
1，null处理

dataBinding在处理null值的时候，做了非空判断
比如，在如下的代码中，
```
<data>
    <import type="com.keaven.android.base.databinding.User" alias="User" />
    <variable
        name="anotheruser"
        type="User" />
</data>

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:text='@{anotheruser.lastName+}' />
```
如果在java中没有binding.setOtheruser(user)或者赋值为null,即binding.setOtheruser(null);;此时，取到的lastName的值是null。
在databinding自动生成的文件中做了非空处理
if (otheruser != null) {
    // read otheruser.firstName
    firstNameOtheruser = otheruser.getFirstName();
    // read otheruser.lastName
    lastNameOtheruser = otheruser.getLastName();
}


2，include
1>.bind
<include layout="@layout/activity_include" bind:anotheruser="@{user}"/>
其中
2>.尚不支持direct child，比如root 为merge

参考下面示例：
activity_demo.xml 源码：
```
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">

    <data>

        <import type="com.keaven.android.base.databinding.User" alias="User" />
        <variable
            name="otheruser"
            type="User" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:text="@{otheruser.lastName}" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:text="@{otheruser.firstName}" />
        <include layout="@layout/activity_include" bind:anotheruser="@{user}"/>
    </LinearLayout>
```
</layout>
activity_include.xml内容：
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">
<data>
    <import type="com.keaven.android.base.databinding.User" alias="User" />
    <variable
        name="anotheruser"
        type="User" />
</data>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:text='@{anotheruser.lastName+"--jjj"}' />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:text='@{anotheruser.firstName+"--jjj"}'/>
    </LinearLayout>
</layout>
注意这中间，bind:dataModel=@{value}
dataModel是include中的数据模型的name，value是值，保持值类型一致

3,viewStub

binding.viewStub.getViewStub().inflate();

4.observable







 
