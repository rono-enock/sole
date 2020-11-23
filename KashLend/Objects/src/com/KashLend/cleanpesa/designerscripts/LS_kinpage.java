package com.KashLend.cleanpesa.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_kinpage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("label1").vw.setTop((int)((7d / 100 * height)));
views.get("label1").vw.setLeft((int)((2d / 100 * width)));
views.get("label1").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("label1").vw.setHeight((int)((15d / 100 * height)));
views.get("edtname").vw.setHeight((int)((10d / 100 * height)));
views.get("edtname").vw.setLeft((int)((2d / 100 * width)));
views.get("edtname").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("edtname").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(5d / 100 * height)));
views.get("edtphone").vw.setHeight((int)((10d / 100 * height)));
views.get("edtphone").vw.setLeft((int)((2d / 100 * width)));
views.get("edtphone").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("edtphone").vw.setTop((int)((views.get("edtname").vw.getTop() + views.get("edtname").vw.getHeight())+(2d / 100 * height)));
views.get("label2").vw.setHeight((int)((10d / 100 * height)));
views.get("label2").vw.setLeft((int)((2d / 100 * width)));
views.get("label2").vw.setWidth((int)((58d / 100 * width) - ((2d / 100 * width))));
views.get("label2").vw.setTop((int)((views.get("edtphone").vw.getTop() + views.get("edtphone").vw.getHeight())+(2d / 100 * height)));
views.get("spinnerkin").vw.setHeight((int)((10d / 100 * height)));
views.get("spinnerkin").vw.setLeft((int)((59d / 100 * width)));
views.get("spinnerkin").vw.setWidth((int)((98d / 100 * width) - ((59d / 100 * width))));
views.get("spinnerkin").vw.setTop((int)((views.get("edtphone").vw.getTop() + views.get("edtphone").vw.getHeight())+(2d / 100 * height)));
views.get("btncontinue").vw.setHeight((int)((15d / 100 * height)));
views.get("btncontinue").vw.setLeft((int)((2d / 100 * width)));
views.get("btncontinue").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("btncontinue").vw.setTop((int)((views.get("label2").vw.getTop() + views.get("label2").vw.getHeight())+(15d / 100 * height)));

}
}