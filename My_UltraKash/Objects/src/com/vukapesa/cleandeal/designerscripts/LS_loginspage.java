package com.vukapesa.cleandeal.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_loginspage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("edtname").vw.setLeft((int)((15d / 100 * width)));
views.get("edtname").vw.setWidth((int)((85d / 100 * width) - ((15d / 100 * width))));
views.get("edtname").vw.setHeight((int)((10d / 100 * height)));
views.get("edtname").vw.setTop((int)((27d / 100 * height)));
views.get("edtpass").vw.setHeight((int)((10d / 100 * height)));
views.get("edtpass").vw.setLeft((int)((15d / 100 * width)));
views.get("edtpass").vw.setWidth((int)((85d / 100 * width) - ((15d / 100 * width))));
views.get("edtpass").vw.setTop((int)((views.get("edtname").vw.getTop() + views.get("edtname").vw.getHeight())+(20d * scale)));
views.get("btnlogin").vw.setTop((int)((views.get("edtpass").vw.getTop() + views.get("edtpass").vw.getHeight())+(90d * scale)));
views.get("btnlogin").vw.setLeft((int)((5d / 100 * width)));
views.get("btnlogin").vw.setWidth((int)((95d / 100 * width) - ((5d / 100 * width))));
views.get("btnlogin").vw.setHeight((int)((12d / 100 * height)));

}
}