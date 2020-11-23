package com.KashLend.cleanpesa.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_directorypage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("label1").vw.setTop((int)((25d / 100 * height)));
views.get("label1").vw.setLeft((int)((2d / 100 * width)));
views.get("label1").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("label1").vw.setHeight((int)((30d / 100 * height)));
views.get("btnproceed").vw.setHeight((int)((15d / 100 * height)));
views.get("btnproceed").vw.setLeft((int)((2d / 100 * width)));
views.get("btnproceed").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("btnproceed").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(20d / 100 * height)));

}
}