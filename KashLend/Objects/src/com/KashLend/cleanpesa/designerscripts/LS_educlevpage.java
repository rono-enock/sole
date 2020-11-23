package com.KashLend.cleanpesa.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_educlevpage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("label1").vw.setTop((int)((7d / 100 * height)));
views.get("label1").vw.setLeft((int)((2d / 100 * width)));
views.get("label1").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("label1").vw.setHeight((int)((15d / 100 * height)));
views.get("rdprimary").vw.setHeight((int)((7d / 100 * height)));
views.get("rdprimary").vw.setLeft((int)((2d / 100 * width)));
views.get("rdprimary").vw.setWidth((int)((50d / 100 * width) - ((2d / 100 * width))));
views.get("rdprimary").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(5d / 100 * height)));
views.get("rdsecondary").vw.setHeight((int)((8d / 100 * height)));
views.get("rdsecondary").vw.setLeft((int)((2d / 100 * width)));
views.get("rdsecondary").vw.setWidth((int)((50d / 100 * width) - ((2d / 100 * width))));
views.get("rdsecondary").vw.setTop((int)((views.get("rdprimary").vw.getTop() + views.get("rdprimary").vw.getHeight())+(2d / 100 * height)));
views.get("rdundergraduate").vw.setHeight((int)((8d / 100 * height)));
views.get("rdundergraduate").vw.setLeft((int)((2d / 100 * width)));
views.get("rdundergraduate").vw.setWidth((int)((50d / 100 * width) - ((2d / 100 * width))));
views.get("rdundergraduate").vw.setTop((int)((views.get("rdsecondary").vw.getTop() + views.get("rdsecondary").vw.getHeight())+(2d / 100 * height)));
views.get("rdpostgraduate").vw.setHeight((int)((8d / 100 * height)));
views.get("rdpostgraduate").vw.setLeft((int)((2d / 100 * width)));
views.get("rdpostgraduate").vw.setWidth((int)((50d / 100 * width) - ((2d / 100 * width))));
views.get("rdpostgraduate").vw.setTop((int)((views.get("rdundergraduate").vw.getTop() + views.get("rdundergraduate").vw.getHeight())+(2d / 100 * height)));
views.get("btnnext").vw.setHeight((int)((15d / 100 * height)));
views.get("btnnext").vw.setLeft((int)((2d / 100 * width)));
views.get("btnnext").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("btnnext").vw.setTop((int)((views.get("rdpostgraduate").vw.getTop() + views.get("rdpostgraduate").vw.getHeight())+(10d / 100 * height)));

}
}