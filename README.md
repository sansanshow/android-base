# android-base
安卓基础知识案例
## 高德地图使用
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


