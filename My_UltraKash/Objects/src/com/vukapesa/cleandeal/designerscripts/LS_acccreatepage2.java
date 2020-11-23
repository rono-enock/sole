package com.vukapesa.cleandeal.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_acccreatepage2{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("edtloc").vw.setTop((int)((60d * scale)));
views.get("edtloc").vw.setLeft((int)((15d / 100 * width)));
views.get("edtloc").vw.setWidth((int)((85d / 100 * width) - ((15d / 100 * width))));
views.get("edtloc").vw.setHeight((int)((12d / 100 * height)));
views.get("edtpass").vw.setLeft((int)((15d / 100 * width)));
views.get("edtpass").vw.setWidth((int)((85d / 100 * width) - ((15d / 100 * width))));
views.get("edtpass").vw.setHeight((int)((12d / 100 * height)));
views.get("edtpass").vw.setTop((int)((views.get("edtloc").vw.getTop() + views.get("edtloc").vw.getHeight())+(20d * scale)));
views.get("edtcpass").vw.setLeft((int)((15d / 100 * width)));
views.get("edtcpass").vw.setWidth((int)((85d / 100 * width) - ((15d / 100 * width))));
views.get("edtcpass").vw.setHeight((int)((12d / 100 * height)));
views.get("edtcpass").vw.setTop((int)((views.get("edtpass").vw.getTop() + views.get("edtpass").vw.getHeight())+(20d * scale)));
views.get("edtday").vw.setLeft((int)((15d / 100 * width)));
views.get("edtday").vw.setWidth((int)((35d / 100 * width) - ((15d / 100 * width))));
views.get("edtday").vw.setHeight((int)((12d / 100 * height)));
views.get("edtday").vw.setTop((int)((views.get("edtcpass").vw.getTop() + views.get("edtcpass").vw.getHeight())+(20d * scale)));
views.get("edtmonth").vw.setLeft((int)((40d / 100 * width)));
views.get("edtmonth").vw.setWidth((int)((60d / 100 * width) - ((40d / 100 * width))));
views.get("edtmonth").vw.setHeight((int)((12d / 100 * height)));
//BA.debugLineNum = 26;BA.debugLine="edtmonth.Top=edtcpass.Bottom +20dip"[AccCreatePage2/General script]
views.get("edtmonth").vw.setTop((int)((views.get("edtcpass").vw.getTop() + views.get("edtcpass").vw.getHeight())+(20d * scale)));
//BA.debugLineNum = 28;BA.debugLine="edtyear.SetLeftAndRight(65%x,85%x)"[AccCreatePage2/General script]
views.get("edtyear").vw.setLeft((int)((65d / 100 * width)));
views.get("edtyear").vw.setWidth((int)((85d / 100 * width) - ((65d / 100 * width))));
//BA.debugLineNum = 29;BA.debugLine="edtyear.Height=12%y"[AccCreatePage2/General script]
views.get("edtyear").vw.setHeight((int)((12d / 100 * height)));
//BA.debugLineNum = 30;BA.debugLine="edtyear.Top=edtcpass.Bottom +20dip"[AccCreatePage2/General script]
views.get("edtyear").vw.setTop((int)((views.get("edtcpass").vw.getTop() + views.get("edtcpass").vw.getHeight())+(20d * scale)));
//BA.debugLineNum = 32;BA.debugLine="Btnsubmit.SetLeftAndRight(5%x,95%x)"[AccCreatePage2/General script]
views.get("btnsubmit").vw.setLeft((int)((5d / 100 * width)));
views.get("btnsubmit").vw.setWidth((int)((95d / 100 * width) - ((5d / 100 * width))));
//BA.debugLineNum = 33;BA.debugLine="Btnsubmit.Height=12%y"[AccCreatePage2/General script]
views.get("btnsubmit").vw.setHeight((int)((12d / 100 * height)));
//BA.debugLineNum = 34;BA.debugLine="Btnsubmit.Top=edtday.Bottom +60dip"[AccCreatePage2/General script]
views.get("btnsubmit").vw.setTop((int)((views.get("edtday").vw.getTop() + views.get("edtday").vw.getHeight())+(60d * scale)));

}
}