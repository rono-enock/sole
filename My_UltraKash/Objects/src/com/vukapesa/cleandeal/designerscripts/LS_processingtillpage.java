package com.vukapesa.cleandeal.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_processingtillpage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("label1").vw.setTop((int)((55d * scale)));
views.get("label1").vw.setLeft((int)((6d / 100 * width)));
views.get("label1").vw.setWidth((int)((94d / 100 * width) - ((6d / 100 * width))));
views.get("label1").vw.setHeight((int)((50d / 100 * width)));
views.get("edtmpesacode").vw.setHeight((int)((20d / 100 * height)));
views.get("edtmpesacode").vw.setLeft((int)((20d / 100 * width)));
views.get("edtmpesacode").vw.setWidth((int)((80d / 100 * width) - ((20d / 100 * width))));
views.get("edtmpesacode").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(15d * scale)));
views.get("btnapprovecode").vw.setLeft((int)((5d / 100 * width)));
views.get("btnapprovecode").vw.setWidth((int)((95d / 100 * width) - ((5d / 100 * width))));
views.get("btnapprovecode").vw.setHeight((int)((12d / 100 * height)));
views.get("btnapprovecode").vw.setTop((int)((views.get("edtmpesacode").vw.getTop() + views.get("edtmpesacode").vw.getHeight())+(60d * scale)));

}
}