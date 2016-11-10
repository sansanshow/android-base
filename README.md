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

