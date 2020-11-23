package com.KashLend.cleanpesa.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_idpage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("label1").vw.setTop((int)((8d / 100 * height)));
views.get("label1").vw.setLeft((int)((2d / 100 * width)));
views.get("label1").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("label1").vw.setHeight((int)((15d / 100 * height)));
views.get("edtpin").vw.setHeight((int)((15d / 100 * height)));
views.get("edtpin").vw.setLeft((int)((5d / 100 * width)));
views.get("edtpin").vw.setWidth((int)((95d / 100 * width) - ((5d / 100 * width))));
views.get("edtpin").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(9d / 100 * height)));
views.get("edtid").vw.setHeight((int)((15d / 100 * height)));
views.get("edtid").vw.setLeft((int)((5d / 100 * width)));
views.get("edtid").vw.setWidth((int)((95d / 100 * width) - ((5d / 100 * width))));
views.get("edtid").vw.setTop((int)((views.get("edtpin").vw.getTop() + views.get("edtpin").vw.getHeight())+(2d / 100 * height)));
views.get("btnnext").vw.setHeight((int)((15d / 100 * height)));
views.get("btnnext").vw.setLeft((int)((2d / 100 * width)));
views.get("btnnext").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("btnnext").vw.setTop((int)((views.get("edtid").vw.getTop() + views.get("edtid").vw.getHeight())+(13d / 100 * height)));

}
}