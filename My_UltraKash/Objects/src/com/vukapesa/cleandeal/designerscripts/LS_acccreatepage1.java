package com.vukapesa.cleandeal.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_acccreatepage1{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[AccCreatePage1/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 4;BA.debugLine="Panel1.Height=100%y"[AccCreatePage1/General script]
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
//BA.debugLineNum = 5;BA.debugLine="Panel1.Width=100%x"[AccCreatePage1/General script]
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 7;BA.debugLine="edtName.SetLeftAndRight(15%x,85%x)"[AccCreatePage1/General script]
views.get("edtname").vw.setLeft((int)((15d / 100 * width)));
views.get("edtname").vw.setWidth((int)((85d / 100 * width) - ((15d / 100 * width))));
//BA.debugLineNum = 8;BA.debugLine="edtName.Height=10%y"[AccCreatePage1/General script]
views.get("edtname").vw.setHeight((int)((10d / 100 * height)));
//BA.debugLineNum = 9;BA.debugLine="edtName.Top=90dip"[AccCreatePage1/General script]
views.get("edtname").vw.setTop((int)((90d * scale)));
//BA.debugLineNum = 11;BA.debugLine="edtID.SetLeftAndRight(15%x,85%x)"[AccCreatePage1/General script]
views.get("edtid").vw.setLeft((int)((15d / 100 * width)));
views.get("edtid").vw.setWidth((int)((85d / 100 * width) - ((15d / 100 * width))));
//BA.debugLineNum = 12;BA.debugLine="edtID.Height=10%y"[AccCreatePage1/General script]
views.get("edtid").vw.setHeight((int)((10d / 100 * height)));
//BA.debugLineNum = 13;BA.debugLine="edtID.Top=edtName.Bottom +20dip"[AccCreatePage1/General script]
views.get("edtid").vw.setTop((int)((views.get("edtname").vw.getTop() + views.get("edtname").vw.getHeight())+(20d * scale)));
//BA.debugLineNum = 15;BA.debugLine="edtMail.SetLeftAndRight(15%x,85%x)"[AccCreatePage1/General script]
views.get("edtmail").vw.setLeft((int)((15d / 100 * width)));
views.get("edtmail").vw.setWidth((int)((85d / 100 * width) - ((15d / 100 * width))));
//BA.debugLineNum = 16;BA.debugLine="edtMail.Height=10%y"[AccCreatePage1/General script]
views.get("edtmail").vw.setHeight((int)((10d / 100 * height)));
//BA.debugLineNum = 17;BA.debugLine="edtMail.Top=edtID.Bottom +20dip"[AccCreatePage1/General script]
views.get("edtmail").vw.setTop((int)((views.get("edtid").vw.getTop() + views.get("edtid").vw.getHeight())+(20d * scale)));
//BA.debugLineNum = 19;BA.debugLine="edtPhone.SetLeftAndRight(15%x,85%x)"[AccCreatePage1/General script]
views.get("edtphone").vw.setLeft((int)((15d / 100 * width)));
views.get("edtphone").vw.setWidth((int)((85d / 100 * width) - ((15d / 100 * width))));
//BA.debugLineNum = 20;BA.debugLine="edtPhone.Height=10%y"[AccCreatePage1/General script]
views.get("edtphone").vw.setHeight((int)((10d / 100 * height)));
//BA.debugLineNum = 21;BA.debugLine="edtPhone.Top=edtMail.Bottom +20dip"[AccCreatePage1/General script]
views.get("edtphone").vw.setTop((int)((views.get("edtmail").vw.getTop() + views.get("edtmail").vw.getHeight())+(20d * scale)));
//BA.debugLineNum = 23;BA.debugLine="BtnNext.SetLeftAndRight(5%x,95%x)"[AccCreatePage1/General script]
views.get("btnnext").vw.setLeft((int)((5d / 100 * width)));
views.get("btnnext").vw.setWidth((int)((95d / 100 * width) - ((5d / 100 * width))));
//BA.debugLineNum = 24;BA.debugLine="BtnNext.Height=12%y"[AccCreatePage1/General script]
views.get("btnnext").vw.setHeight((int)((12d / 100 * height)));
//BA.debugLineNum = 25;BA.debugLine="BtnNext.Top=edtPhone.Bottom +60dip"[AccCreatePage1/General script]
views.get("btnnext").vw.setTop((int)((views.get("edtphone").vw.getTop() + views.get("edtphone").vw.getHeight())+(60d * scale)));

}
}