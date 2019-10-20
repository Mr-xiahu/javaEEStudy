/**
 * 添加轮播图片
 * 步骤:
 *   1.确定事件(OnLoad)，并为其绑定函数
 *   2.书写绑定的函数
 *   3.书写定时任务(setInterval())
 *   4.书写定时任务的函数
 */
//1.为事件绑定函数
function init() {
	//设置轮播图片定时任务函数
	setInterval("changeImage()", 3000);
	//设置弹出广告栏定时任务函数
	time = setInterval("popAd()", 3000);
}
//定义一个变量i
var i = 1;
//书写定时任务函数
function changeImage() {
	i++;
	document.getElementById("img1").src = "../img/" + i + ".jpg";
	//添加一个条件
	if (i == 3) {
		i = 0;
	}
}
/**
 * 添加定时弹出广告框
 *  步骤:
 *     1.在页面指定一个广告图片,设置display值为none
 *     2.确定事件(OnLoad),为其绑定函数
 *     3.书写绑定的函数，设置广告显示的定时操作 
 *     4.书写定时任务的函数(获取广告图片的位置并修改style的属性display为block)
 *     5.清除弹出广告的定时操作操作,
 *     6.设置广告隐藏的定时操作
 *     7.书写定时任务的函数(获取广告图片的位置并修改style的属性display为none)
 *     8.清除隐藏广告的定时操作操作,
 *     
 */
function popAd() {
	//获取广告图片所在的位置
	var ad = document.getElementById("ad");
	//改变广告的display值为   可见
	ad.style.display = "block";
	//清除弹出广告的定时任务
	clearInterval(time);
	//设置广告隐藏定时函数
	time = setInterval("hiddenAd()", 3000);
}

function hiddenAd() {
	//8.获取广告图片并设置其style属性的display值为none
	document.getElementById("ad").style.display = "none";
	//9.清除隐藏广告图片的定时操作
	clearInterval(time);
}