# rollingNews
新闻滚动，类似淘宝头条新闻滚动
说明：

<br>1.不是继承自系统自带的 ViewFlipper,使用ViewFlipper耗内存？，而且会在fragment切换时可能会重叠，重叠，重叠（难道是我使用姿势有问题？）</br>

<br>2.未使用属性动画，避免了属性动画会因为开发者选项关闭动画后不再起作用</br>

<br>使用Scoller的startScroll平滑滚动 + 子控件的setY()复位 操作实现<br>

demo使用多个fragment切换测试的，非单个activity测试


截图如下
<img src="https://github.com/docwei2050/rollingNews/blob/master/screenshots/rollingnews.gif"  />
<img src="https://github.com/docwei2050/rollingNews/blob/master/screenshots/Screenshot_20180517-091725.png" width=270 height=480 />
<img src="https://github.com/docwei2050/rollingNews/blob/master/screenshots/Screenshot_20180517-091728.png" width=270 height=480 />




