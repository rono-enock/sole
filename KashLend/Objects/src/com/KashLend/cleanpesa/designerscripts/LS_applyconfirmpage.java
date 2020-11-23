package com.KashLend.cleanpesa.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_applyconfirmpage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("label1").vw.setLeft((int)((2d / 100 * width)));
views.get("label1").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("label1").vw.setHeight((int)((30d / 100 * height)));
views.get("label1").vw.setTop((int)((15d / 100 * height)));
views.get("btnshare").vw.setLeft((int)((2d / 100 * width)));
views.get("btnshare").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("btnshare").vw.setHeight((int)((15d / 100 * height)));
views.get("btnshare").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(15d / 100 * height)));
views.get("btnrate").vw.setLeft((int)((2d / 100 * width)));
views.get("btnrate").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("btnrate").vw.setHeight((int)((15d / 100 * height)));
views.get("btnrate").vw.setTop((int)((views.get("btnshare").vw.getTop() + views.get("btnshare").vw.getHeight())+(3d / 100 * height)));

}
}