### Android 轻量级UI开发框架
   在总结一往大小开发经验后，封装集成了这个单纯面向UI的框架。
   简易的封装层，轻量的层级依赖关系，极少的耦合关系。
    

##### 目前版本信息：

|name| desc|
|:--:|:--:|
|Version|1.0|
|minSdkVersion|14|
|示例安装包下载|[tb](tbaseui-debug.apk)|

#### 已封装模块：
|number|function list|remark|
|:--:|:--|---|
|1.|Titlebr StatusBar|颜色,透明度,Left Center Right 按钮|
|2.|加载动画|和UI页面同级的原型progressbar,跟随主题配色|
|3.|快速侧滑集成|两种侧滑，并支持一键切换Fragment 无需初始化|
|4.|全局一键切换fragment|封装Fragment加载策略,防止重叠和内测溢出|
|5.|边缘右滑返回|使用开源库SwipeBack|
|6.|版本更新|一键配置版本更新，下载apk到本地，提供软更新和强制更新两种策略|

***
#### demo效果图:

![updatev.gif](http://upload-images.jianshu.io/upload_images/2909203-053b36a3c2329ed3.gif?imageMogr2/auto-orient/strip)![navigationbottom.gif](http://upload-images.jianshu.io/upload_images/2909203-0df2123f7cee277d.gif?imageMogr2/auto-orient/strip)

![sliding.gif](http://upload-images.jianshu.io/upload_images/2909203-282044e29590be89.gif?imageMogr2/auto-orient/strip)![navigationbottom.gif](http://upload-images.jianshu.io/upload_images/2909203-0df2123f7cee277d.gif?imageMogr2/auto-orient/strip)




#### 用到的开源库:

|地址|
|:----:|
|[SwipeBackLayout](https://github.com/ikew0ng/SwipeBackLayout)|
|[FileDownloader](https://github.com/lingochamp/FileDownloader)|
|[com.victor:lib:1.0.4]()|


****
###  下一步

引入对`PopupWindow`基类进行封装，提供参数式position算法和动画配置。

<p>



