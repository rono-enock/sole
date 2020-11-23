package com.KashLend.cleanpesa.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_overviewpage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("label1").vw.setLeft((int)((2d / 100 * width)));
views.get("label1").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("label1").vw.setHeight((int)((12d / 100 * height)));
views.get("label1").vw.setTop((int)((2d / 100 * height)));
views.get("label2").vw.setLeft((int)((2d / 100 * width)));
views.get("label2").vw.setWidth((int)((48d / 100 * width) - ((2d / 100 * width))));
views.get("label2").vw.setHeight((int)((10d / 100 * height)));
views.get("label2").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(3d / 100 * height)));
views.get("edtname").vw.setLeft((int)((49d / 100 * width)));
views.get("edtname").vw.setWidth((int)((98d / 100 * width) - ((49d / 100 * width))));
views.get("edtname").vw.setHeight((int)((10d / 100 * height)));
views.get("edtname").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(3d / 100 * height)));
views.get("label3").vw.setLeft((int)((2d / 100 * width)));
views.get("label3").vw.setWidth((int)((48d / 100 * width) - ((2d / 100 * width))));
views.get("label3").vw.setHeight((int)((10d / 100 * height)));
views.get("label3").vw.setTop((int)((views.get("label2").vw.getTop() + views.get("label2").vw.getHeight())+(1d / 100 * height)));
views.get("edtphone").vw.setLeft((int)((49d / 100 * width)));
views.get("edtphone").vw.setWidth((int)((98d / 100 * width) - ((49d / 100 * width))));
views.get("edtphone").vw.setHeight((int)((10d / 100 * height)));
views.get("edtphone").vw.setTop((int)((views.get("label2").vw.getTop() + views.get("label2").vw.getHeight())+(1d / 100 * height)));
views.get("label4").vw.setLeft((int)((2d / 100 * width)));
views.get("label4").vw.setWidth((int)((48d / 100 * width) - ((2d / 100 * width))));
views.get("label4").vw.setHeight((int)((10d / 100 * height)));
views.get("label4").vw.setTop((int)((views.get("label3").vw.getTop() + views.get("label3").vw.getHeight())+(1d / 100 * height)));
views.get("edtcountry").vw.setLeft((int)((49d / 100 * width)));
views.get("edtcountry").vw.setWidth((int)((98d / 100 * width) - ((49d / 100 * width))));
views.get("edtcountry").vw.setHeight((int)((10d / 100 * height)));
views.get("edtcountry").vw.setTop((int)((views.get("label3").vw.getTop() + views.get("label3").vw.getHeight())+(1d / 100 * height)));
views.get("label5").vw.setLeft((int)((2d / 100 * width)));
views.get("label5").vw.setWidth((int)((48d / 100 * width) - ((2d / 100 * width))));
views.get("label5").vw.setHeight((int)((10d / 100 * height)));
views.get("label5").vw.setTop((int)((views.get("label4").vw.getTop() + views.get("label4").vw.getHeight())+(1d / 100 * height)));
views.get("edtkinname").vw.setLeft((int)((49d / 100 * width)));
views.get("edtkinname").vw.setWidth((int)((98d / 100 * width) - ((49d / 100 * width))));
views.get("edtkinname").vw.setHeight((int)((10d / 100 * height)));
views.get("edtkinname").vw.setTop((int)((views.get("label4").vw.getTop() + views.get("label4").vw.getHeight())+(1d / 100 * height)));
views.get("label6").vw.setLeft((int)((2d / 100 * width)));
views.get("label6").vw.setWidth((int)((48d / 100 * width) - ((2d / 100 * width))));
views.get("label6").vw.setHeight((int)((10d / 100 * height)));
views.get("label6").vw.setTop((int)((views.get("label5").vw.getTop() + views.get("label5").vw.getHeight())+(1d / 100 * height)));
views.get("edtkinphone").vw.setLeft((int)((49d / 100 * width)));
views.get("edtkinphone").vw.setWidth((int)((98d / 100 * width) - ((49d / 100 * width))));
views.get("edtkinphone").vw.setHeight((int)((10d / 100 * height)));
views.get("edtkinphone").vw.setTop((int)((views.get("label5").vw.getTop() + views.get("label5").vw.getHeight())+(1d / 100 * height)));
views.get("label7").vw.setLeft((int)((2d / 100 * width)));
views.get("label7").vw.setWidth((int)((48d / 100 * width) - ((2d / 100 * width))));
views.get("label7").vw.setHeight((int)((10d / 100 * height)));
views.get("label7").vw.setTop((int)((views.get("label6").vw.getTop() + views.get("label6").vw.getHeight())+(1d / 100 * height)));
views.get("edtkincountry").vw.setLeft((int)((49d / 100 * width)));
views.get("edtkincountry").vw.setWidth((int)((98d / 100 * width) - ((49d / 100 * width))));
views.get("edtkincountry").vw.setHeight((int)((10d / 100 * height)));
views.get("edtkincountry").vw.setTop((int)((views.get("label6").vw.getTop() + views.get("label6").vw.getHeight())+(1d / 100 * height)));
views.get("btnfinish").vw.setLeft((int)((2d / 100 * width)));
views.get("btnfinish").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("btnfinish").vw.setHeight((int)((13d / 100 * height)));
//BA.debugLineNum = 61;BA.debugLine="BtnFinish.Top=edtKinCountry.Bottom +4%y"[OverviewPage/General script]
views.get("btnfinish").vw.setTop((int)((views.get("edtkincountry").vw.getTop() + views.get("edtkincountry").vw.getHeight())+(4d / 100 * height)));

}
}