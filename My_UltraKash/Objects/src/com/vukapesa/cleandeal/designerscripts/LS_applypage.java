package com.vukapesa.cleandeal.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_applypage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("label1").vw.setLeft((int)((4d / 100 * width)));
views.get("label1").vw.setWidth((int)((96d / 100 * width) - ((4d / 100 * width))));
views.get("label1").vw.setHeight((int)((20d / 100 * height)));
views.get("label1").vw.setTop((int)((50d * scale)));
views.get("labelamount").vw.setLeft((int)((5d / 100 * width)));
views.get("labelamount").vw.setWidth((int)((30d / 100 * width) - ((5d / 100 * width))));
views.get("labelamount").vw.setHeight((int)((10d / 100 * height)));
views.get("labelamount").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(15d * scale)));
views.get("edtamount").vw.setLeft((int)((33d / 100 * width)));
views.get("edtamount").vw.setWidth((int)((75d / 100 * width) - ((33d / 100 * width))));
views.get("edtamount").vw.setHeight((int)((10d / 100 * height)));
views.get("edtamount").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(15d * scale)));
views.get("labelduedate").vw.setLeft((int)((5d / 100 * width)));
views.get("labelduedate").vw.setWidth((int)((30d / 100 * width) - ((5d / 100 * width))));
views.get("labelduedate").vw.setHeight((int)((10d / 100 * height)));
views.get("labelduedate").vw.setTop((int)((views.get("labelamount").vw.getTop() + views.get("labelamount").vw.getHeight())+(10d * scale)));
views.get("edtduedates").vw.setLeft((int)((33d / 100 * width)));
views.get("edtduedates").vw.setWidth((int)((75d / 100 * width) - ((33d / 100 * width))));
views.get("edtduedates").vw.setHeight((int)((10d / 100 * height)));
views.get("edtduedates").vw.setTop((int)((views.get("edtamount").vw.getTop() + views.get("edtamount").vw.getHeight())+(10d * scale)));
views.get("labelinterest").vw.setLeft((int)((5d / 100 * width)));
views.get("labelinterest").vw.setWidth((int)((85d / 100 * width) - ((5d / 100 * width))));
views.get("labelinterest").vw.setHeight((int)((11d / 100 * height)));
views.get("labelinterest").vw.setTop((int)((views.get("labelduedate").vw.getTop() + views.get("labelduedate").vw.getHeight())+(15d * scale)));
views.get("btncontinue").vw.setLeft((int)((5d / 100 * width)));
views.get("btncontinue").vw.setWidth((int)((95d / 100 * width) - ((5d / 100 * width))));
views.get("btncontinue").vw.setHeight((int)((12d / 100 * height)));
//BA.debugLineNum = 33;BA.debugLine="BtnContinue.Top=LabelInterest.Bottom +40dip"[ApplyPage/General script]
views.get("btncontinue").vw.setTop((int)((views.get("labelinterest").vw.getTop() + views.get("labelinterest").vw.getHeight())+(40d * scale)));

}
}