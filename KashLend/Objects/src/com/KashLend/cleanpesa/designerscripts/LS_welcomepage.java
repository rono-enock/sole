package com.KashLend.cleanpesa.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_welcomepage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("label1").vw.setTop((int)((20d / 100 * height)));
views.get("label1").vw.setLeft((int)((2d / 100 * width)));
views.get("label1").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("label1").vw.setHeight((int)((15d / 100 * height)));
views.get("lblmessage").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(20d / 100 * height)));
views.get("lblmessage").vw.setLeft((int)((88d / 100 * width)));
views.get("lblmessage").vw.setWidth((int)((98d / 100 * width) - ((88d / 100 * width))));
views.get("lblmessage").vw.setHeight((int)((5d / 100 * height)));
views.get("btnstart").vw.setTop((int)((views.get("lblmessage").vw.getTop() + views.get("lblmessage").vw.getHeight())+(4d / 100 * height)));
views.get("btnstart").vw.setLeft((int)((2d / 100 * width)));
views.get("btnstart").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("btnstart").vw.setHeight((int)((15d / 100 * height)));

}
}