package com.vukapesa.cleandeal.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_overviewpage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("label2").vw.setTop((int)((2d * scale)));
views.get("label2").vw.setHeight((int)((4d / 100 * height)));
views.get("label2").vw.setLeft((int)((4d / 100 * width)));
views.get("label2").vw.setWidth((int)((96d / 100 * width) - ((4d / 100 * width))));
views.get("label1").vw.setTop((int)((views.get("label2").vw.getTop() + views.get("label2").vw.getHeight())+(2d * scale)));
views.get("label1").vw.setHeight((int)((9d / 100 * height)));
views.get("label1").vw.setLeft((int)((1d / 100 * width)));
views.get("label1").vw.setWidth((int)((99d / 100 * width) - ((1d / 100 * width))));
views.get("label3").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(2d * scale)));
views.get("label3").vw.setHeight((int)((6d / 100 * height)));
views.get("label3").vw.setLeft((int)((4d / 100 * width)));
views.get("label3").vw.setWidth((int)((96d / 100 * width) - ((4d / 100 * width))));
views.get("edtnames").vw.setLeft((int)((15d / 100 * width)));
views.get("edtnames").vw.setWidth((int)((85d / 100 * width) - ((15d / 100 * width))));
views.get("edtnames").vw.setHeight((int)((8d / 100 * height)));
views.get("edtnames").vw.setTop((int)((views.get("label3").vw.getTop() + views.get("label3").vw.getHeight())+(7d * scale)));
views.get("edtphone").vw.setLeft((int)((15d / 100 * width)));
views.get("edtphone").vw.setWidth((int)((85d / 100 * width) - ((15d / 100 * width))));
views.get("edtphone").vw.setHeight((int)((8d / 100 * height)));
views.get("edtphone").vw.setTop((int)((views.get("edtnames").vw.getTop() + views.get("edtnames").vw.getHeight())+(7d * scale)));
views.get("edtlocate").vw.setLeft((int)((15d / 100 * width)));
views.get("edtlocate").vw.setWidth((int)((85d / 100 * width) - ((15d / 100 * width))));
views.get("edtlocate").vw.setHeight((int)((8d / 100 * height)));
views.get("edtlocate").vw.setTop((int)((views.get("edtphone").vw.getTop() + views.get("edtphone").vw.getHeight())+(7d * scale)));
views.get("label4").vw.setTop((int)((views.get("edtlocate").vw.getTop() + views.get("edtlocate").vw.getHeight())+(2d * scale)));
views.get("label4").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 33;BA.debugLine="Label4.SetLeftAndRight(4%x,96%x)"[OverViewPage/General script]
views.get("label4").vw.setLeft((int)((4d / 100 * width)));
views.get("label4").vw.setWidth((int)((96d / 100 * width) - ((4d / 100 * width))));
//BA.debugLineNum = 35;BA.debugLine="edtNextOfKin.SetLeftAndRight(15%x,85%x)"[OverViewPage/General script]
views.get("edtnextofkin").vw.setLeft((int)((15d / 100 * width)));
views.get("edtnextofkin").vw.setWidth((int)((85d / 100 * width) - ((15d / 100 * width))));
//BA.debugLineNum = 36;BA.debugLine="edtNextOfKin.Height=8%y"[OverViewPage/General script]
views.get("edtnextofkin").vw.setHeight((int)((8d / 100 * height)));
//BA.debugLineNum = 37;BA.debugLine="edtNextOfKin.Top=Label4.Bottom + 7dip"[OverViewPage/General script]
views.get("edtnextofkin").vw.setTop((int)((views.get("label4").vw.getTop() + views.get("label4").vw.getHeight())+(7d * scale)));
//BA.debugLineNum = 39;BA.debugLine="edtKinPhone.SetLeftAndRight(15%x,85%x)"[OverViewPage/General script]
views.get("edtkinphone").vw.setLeft((int)((15d / 100 * width)));
views.get("edtkinphone").vw.setWidth((int)((85d / 100 * width) - ((15d / 100 * width))));
//BA.debugLineNum = 40;BA.debugLine="edtKinPhone.Height=8%y"[OverViewPage/General script]
views.get("edtkinphone").vw.setHeight((int)((8d / 100 * height)));
//BA.debugLineNum = 41;BA.debugLine="edtKinPhone.Top=edtNextOfKin.Bottom +7dip"[OverViewPage/General script]
views.get("edtkinphone").vw.setTop((int)((views.get("edtnextofkin").vw.getTop() + views.get("edtnextofkin").vw.getHeight())+(7d * scale)));
//BA.debugLineNum = 43;BA.debugLine="edtLocation.SetLeftAndRight(15%x,85%x)"[OverViewPage/General script]
views.get("edtlocation").vw.setLeft((int)((15d / 100 * width)));
views.get("edtlocation").vw.setWidth((int)((85d / 100 * width) - ((15d / 100 * width))));
//BA.debugLineNum = 44;BA.debugLine="edtLocation.Height=8%y"[OverViewPage/General script]
views.get("edtlocation").vw.setHeight((int)((8d / 100 * height)));
//BA.debugLineNum = 45;BA.debugLine="edtLocation.Top=edtKinPhone.Bottom +7dip"[OverViewPage/General script]
views.get("edtlocation").vw.setTop((int)((views.get("edtkinphone").vw.getTop() + views.get("edtkinphone").vw.getHeight())+(7d * scale)));
//BA.debugLineNum = 47;BA.debugLine="BtnConfirm.SetLeftAndRight(5%x,95%x)"[OverViewPage/General script]
views.get("btnconfirm").vw.setLeft((int)((5d / 100 * width)));
views.get("btnconfirm").vw.setWidth((int)((95d / 100 * width) - ((5d / 100 * width))));
//BA.debugLineNum = 48;BA.debugLine="BtnConfirm.Top=edtLocation.Bottom +10dip"[OverViewPage/General script]
views.get("btnconfirm").vw.setTop((int)((views.get("edtlocation").vw.getTop() + views.get("edtlocation").vw.getHeight())+(10d * scale)));
//BA.debugLineNum = 49;BA.debugLine="BtnConfirm.Height=11%y"[OverViewPage/General script]
views.get("btnconfirm").vw.setHeight((int)((11d / 100 * height)));

}
}