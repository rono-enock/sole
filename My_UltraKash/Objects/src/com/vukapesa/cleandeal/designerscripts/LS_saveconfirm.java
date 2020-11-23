package com.vukapesa.cleandeal.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_saveconfirm{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("labelconfirmsave").vw.setLeft((int)((6d / 100 * width)));
views.get("labelconfirmsave").vw.setWidth((int)((98d / 100 * width) - ((6d / 100 * width))));
views.get("labelconfirmsave").vw.setHeight((int)((21d / 100 * height)));
views.get("labelconfirmsave").vw.setTop((int)((18d / 100 * height)));
views.get("labelloanlimit").vw.setLeft((int)((6d / 100 * width)));
views.get("labelloanlimit").vw.setWidth((int)((98d / 100 * width) - ((6d / 100 * width))));
views.get("labelloanlimit").vw.setHeight((int)((10d / 100 * height)));
views.get("labelloanlimit").vw.setTop((int)((views.get("labelconfirmsave").vw.getTop() + views.get("labelconfirmsave").vw.getHeight())+(5d * scale)));
views.get("btnapplynow").vw.setLeft((int)((5d / 100 * width)));
views.get("btnapplynow").vw.setWidth((int)((95d / 100 * width) - ((5d / 100 * width))));
views.get("btnapplynow").vw.setHeight((int)((13d / 100 * height)));
views.get("btnapplynow").vw.setTop((int)((views.get("labelloanlimit").vw.getTop() + views.get("labelloanlimit").vw.getHeight())+(28d / 100 * height)));

}
}