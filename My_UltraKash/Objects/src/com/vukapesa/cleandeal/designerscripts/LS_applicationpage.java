package com.vukapesa.cleandeal.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_applicationpage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("labelsave").vw.setLeft((int)((2d / 100 * width)));
views.get("labelsave").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("labelsave").vw.setHeight((int)((50d / 100 * height)));
views.get("labelsave").vw.setTop((int)((40d * scale)));
views.get("btnsave").vw.setLeft((int)((10d / 100 * width)));
views.get("btnsave").vw.setWidth((int)((90d / 100 * width) - ((10d / 100 * width))));
views.get("btnsave").vw.setHeight((int)((12d / 100 * height)));
views.get("btnsave").vw.setTop((int)((views.get("labelsave").vw.getTop() + views.get("labelsave").vw.getHeight())+(50d * scale)));

}
}