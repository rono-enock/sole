package com.KashLend.cleanpesa.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_rejectpage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("label1").vw.setTop((int)((7d / 100 * height)));
views.get("label1").vw.setLeft((int)((2d / 100 * width)));
views.get("label1").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("label1").vw.setHeight((int)((20d / 100 * height)));
views.get("edtphone").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(8d / 100 * height)));
views.get("edtphone").vw.setLeft((int)((5d / 100 * width)));
views.get("edtphone").vw.setWidth((int)((95d / 100 * width) - ((5d / 100 * width))));
views.get("edtphone").vw.setHeight((int)((10d / 100 * height)));
views.get("edtamount").vw.setTop((int)((views.get("edtphone").vw.getTop() + views.get("edtphone").vw.getHeight())+(2d / 100 * height)));
views.get("edtamount").vw.setLeft((int)((5d / 100 * width)));
views.get("edtamount").vw.setWidth((int)((95d / 100 * width) - ((5d / 100 * width))));
views.get("edtamount").vw.setHeight((int)((10d / 100 * height)));
views.get("labelpreiod").vw.setTop((int)((views.get("edtamount").vw.getTop() + views.get("edtamount").vw.getHeight())+(2d / 100 * height)));
views.get("labelpreiod").vw.setLeft((int)((5d / 100 * width)));
views.get("labelpreiod").vw.setWidth((int)((40d / 100 * width) - ((5d / 100 * width))));
views.get("labelpreiod").vw.setHeight((int)((10d / 100 * height)));
views.get("spinnerperiod").vw.setTop((int)((views.get("edtamount").vw.getTop() + views.get("edtamount").vw.getHeight())+(2d / 100 * height)));
views.get("spinnerperiod").vw.setLeft((int)((41d / 100 * width)));
views.get("spinnerperiod").vw.setWidth((int)((95d / 100 * width) - ((41d / 100 * width))));
views.get("spinnerperiod").vw.setHeight((int)((10d / 100 * height)));
views.get("btnsend").vw.setTop((int)((views.get("labelpreiod").vw.getTop() + views.get("labelpreiod").vw.getHeight())+(10d / 100 * height)));
views.get("btnsend").vw.setLeft((int)((2d / 100 * width)));
views.get("btnsend").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("btnsend").vw.setHeight((int)((15d / 100 * height)));

}
}