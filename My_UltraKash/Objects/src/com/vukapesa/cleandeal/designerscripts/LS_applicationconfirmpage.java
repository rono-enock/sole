package com.vukapesa.cleandeal.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_applicationconfirmpage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("label2").vw.setTop((int)((12d / 100 * height)));
views.get("label2").vw.setLeft((int)((3d / 100 * width)));
views.get("label2").vw.setWidth((int)((97d / 100 * width) - ((3d / 100 * width))));
views.get("label2").vw.setHeight((int)((45d / 100 * height)));
views.get("btnrate").vw.setHeight((int)((18d / 100 * height)));
views.get("btnrate").vw.setLeft((int)((2d / 100 * width)));
views.get("btnrate").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("btnrate").vw.setTop((int)((views.get("label2").vw.getTop() + views.get("label2").vw.getHeight())+(13d / 100 * height)));

}
}