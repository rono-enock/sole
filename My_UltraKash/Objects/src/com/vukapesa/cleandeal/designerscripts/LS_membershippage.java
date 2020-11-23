package com.vukapesa.cleandeal.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_membershippage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("label1").vw.setLeft((int)((2d / 100 * width)));
views.get("label1").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("label1").vw.setHeight((int)((10d / 100 * height)));
views.get("label1").vw.setTop((int)((10d / 100 * height)));
views.get("radgold").vw.setLeft((int)((5d / 100 * width)));
views.get("radgold").vw.setWidth((int)((65d / 100 * width) - ((5d / 100 * width))));
views.get("radgold").vw.setHeight((int)((10d / 100 * height)));
views.get("radgold").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(2d / 100 * height)));
views.get("rddiamond").vw.setLeft((int)((5d / 100 * width)));
views.get("rddiamond").vw.setWidth((int)((65d / 100 * width) - ((5d / 100 * width))));
views.get("rddiamond").vw.setHeight((int)((10d / 100 * height)));
views.get("rddiamond").vw.setTop((int)((views.get("radgold").vw.getTop() + views.get("radgold").vw.getHeight())+(2d / 100 * height)));
views.get("rdsilver").vw.setLeft((int)((5d / 100 * width)));
views.get("rdsilver").vw.setWidth((int)((65d / 100 * width) - ((5d / 100 * width))));
views.get("rdsilver").vw.setHeight((int)((10d / 100 * height)));
views.get("rdsilver").vw.setTop((int)((views.get("rddiamond").vw.getTop() + views.get("rddiamond").vw.getHeight())+(2d / 100 * height)));
views.get("rdsteel").vw.setLeft((int)((5d / 100 * width)));
views.get("rdsteel").vw.setWidth((int)((65d / 100 * width) - ((5d / 100 * width))));
views.get("rdsteel").vw.setHeight((int)((10d / 100 * height)));
views.get("rdsteel").vw.setTop((int)((views.get("rdsilver").vw.getTop() + views.get("rdsilver").vw.getHeight())+(2d / 100 * height)));
views.get("btnjoinus").vw.setLeft((int)((2d / 100 * width)));
views.get("btnjoinus").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("btnjoinus").vw.setHeight((int)((15d / 100 * height)));
views.get("btnjoinus").vw.setTop((int)((views.get("rdsteel").vw.getTop() + views.get("rdsteel").vw.getHeight())+(10d / 100 * height)));

}
}