package com.vukapesa.cleandeal.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_occupationpage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("label1").vw.setTop((int)((70d * scale)));
views.get("label1").vw.setHeight((int)((10d / 100 * height)));
views.get("label1").vw.setLeft((int)((2d / 100 * width)));
views.get("label1").vw.setWidth((int)((45d / 100 * width) - ((2d / 100 * width))));
views.get("spinoccupation").vw.setTop((int)((70d * scale)));
views.get("spinoccupation").vw.setLeft((int)((47d / 100 * width)));
views.get("spinoccupation").vw.setWidth((int)((98d / 100 * width) - ((47d / 100 * width))));
views.get("spinoccupation").vw.setHeight((int)((10d / 100 * height)));
views.get("label2").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(10d * scale)));
views.get("label2").vw.setHeight((int)((10d / 100 * height)));
views.get("label2").vw.setLeft((int)((2d / 100 * width)));
views.get("label2").vw.setWidth((int)((45d / 100 * width) - ((2d / 100 * width))));
views.get("spinsalary").vw.setTop((int)((views.get("spinoccupation").vw.getTop() + views.get("spinoccupation").vw.getHeight())+(10d * scale)));
views.get("spinsalary").vw.setLeft((int)((47d / 100 * width)));
views.get("spinsalary").vw.setWidth((int)((98d / 100 * width) - ((47d / 100 * width))));
views.get("spinsalary").vw.setHeight((int)((10d / 100 * height)));
views.get("edtreason").vw.setLeft((int)((5d / 100 * width)));
views.get("edtreason").vw.setWidth((int)((95d / 100 * width) - ((5d / 100 * width))));
views.get("edtreason").vw.setHeight((int)((30d / 100 * height)));
views.get("edtreason").vw.setTop((int)((views.get("label2").vw.getTop() + views.get("label2").vw.getHeight())+(15d * scale)));
views.get("btnnext").vw.setLeft((int)((5d / 100 * width)));
views.get("btnnext").vw.setWidth((int)((95d / 100 * width) - ((5d / 100 * width))));
views.get("btnnext").vw.setHeight((int)((12d / 100 * height)));
views.get("btnnext").vw.setTop((int)((views.get("edtreason").vw.getTop() + views.get("edtreason").vw.getHeight())+(60d * scale)));

}
}