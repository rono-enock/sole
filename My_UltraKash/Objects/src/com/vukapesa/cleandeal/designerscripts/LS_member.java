package com.vukapesa.cleandeal.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_member{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("label1").vw.setTop((int)((3d / 100 * height)));
views.get("label1").vw.setLeft((int)((2d / 100 * width)));
views.get("label1").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("label1").vw.setHeight((int)((38d / 100 * height)));
views.get("edtcode").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(5d / 100 * height)));
views.get("edtcode").vw.setLeft((int)((15d / 100 * width)));
views.get("edtcode").vw.setWidth((int)((85d / 100 * width) - ((15d / 100 * width))));
views.get("edtcode").vw.setHeight((int)((22d / 100 * height)));
views.get("btnback").vw.setTop((int)((views.get("edtcode").vw.getTop() + views.get("edtcode").vw.getHeight())+(11d / 100 * height)));
views.get("btnback").vw.setLeft((int)((2d / 100 * width)));
views.get("btnback").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("btnback").vw.setHeight((int)((15d / 100 * height)));

}
}