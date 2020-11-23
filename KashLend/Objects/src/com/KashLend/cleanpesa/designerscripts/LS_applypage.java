package com.KashLend.cleanpesa.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_applypage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("label1").vw.setTop((int)((3d / 100 * height)));
views.get("label1").vw.setLeft((int)((2d / 100 * width)));
views.get("label1").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("label1").vw.setHeight((int)((15d / 100 * height)));
views.get("labelamount").vw.setLeft((int)((2d / 100 * width)));
views.get("labelamount").vw.setWidth((int)((38d / 100 * width) - ((2d / 100 * width))));
views.get("labelamount").vw.setHeight((int)((15d / 100 * height)));
views.get("labelamount").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(2d / 100 * height)));
views.get("edtamount").vw.setLeft((int)((39d / 100 * width)));
views.get("edtamount").vw.setWidth((int)((75d / 100 * width) - ((39d / 100 * width))));
views.get("edtamount").vw.setHeight((int)((15d / 100 * height)));
views.get("edtamount").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(2d / 100 * height)));
views.get("labelperiod").vw.setLeft((int)((2d / 100 * width)));
views.get("labelperiod").vw.setWidth((int)((38d / 100 * width) - ((2d / 100 * width))));
views.get("labelperiod").vw.setHeight((int)((15d / 100 * height)));
views.get("labelperiod").vw.setTop((int)((views.get("labelamount").vw.getTop() + views.get("labelamount").vw.getHeight())+(2d / 100 * height)));
views.get("spinnerperiod").vw.setLeft((int)((39d / 100 * width)));
views.get("spinnerperiod").vw.setWidth((int)((80d / 100 * width) - ((39d / 100 * width))));
views.get("spinnerperiod").vw.setHeight((int)((15d / 100 * height)));
views.get("spinnerperiod").vw.setTop((int)((views.get("edtamount").vw.getTop() + views.get("edtamount").vw.getHeight())+(2d / 100 * height)));
views.get("label4").vw.setLeft((int)((2d / 100 * width)));
views.get("label4").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("label4").vw.setHeight((int)((15d / 100 * height)));
views.get("label4").vw.setTop((int)((views.get("labelperiod").vw.getTop() + views.get("labelperiod").vw.getHeight())+(2d / 100 * height)));
views.get("btnapply").vw.setLeft((int)((2d / 100 * width)));
views.get("btnapply").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("btnapply").vw.setHeight((int)((15d / 100 * height)));
views.get("btnapply").vw.setTop((int)((views.get("label4").vw.getTop() + views.get("label4").vw.getHeight())+(2d / 100 * height)));

}
}