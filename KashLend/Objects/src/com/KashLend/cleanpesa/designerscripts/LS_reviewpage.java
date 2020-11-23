package com.KashLend.cleanpesa.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_reviewpage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("labelstatusdesc").vw.setLeft((int)((2d / 100 * width)));
views.get("labelstatusdesc").vw.setWidth((int)((38d / 100 * width) - ((2d / 100 * width))));
views.get("labelstatusdesc").vw.setHeight((int)((14d / 100 * height)));
views.get("labelstatusdesc").vw.setTop((int)((5d / 100 * height)));
views.get("labelstatus").vw.setLeft((int)((39d / 100 * width)));
views.get("labelstatus").vw.setWidth((int)((98d / 100 * width) - ((39d / 100 * width))));
views.get("labelstatus").vw.setHeight((int)((14d / 100 * height)));
views.get("labelstatus").vw.setTop((int)((5d / 100 * height)));
views.get("labeldescdesc").vw.setLeft((int)((2d / 100 * width)));
views.get("labeldescdesc").vw.setWidth((int)((38d / 100 * width) - ((2d / 100 * width))));
views.get("labeldescdesc").vw.setHeight((int)((14d / 100 * height)));
views.get("labeldescdesc").vw.setTop((int)((views.get("labelstatusdesc").vw.getTop() + views.get("labelstatusdesc").vw.getHeight())+(2d / 100 * height)));
views.get("labeldesc").vw.setLeft((int)((39d / 100 * width)));
views.get("labeldesc").vw.setWidth((int)((98d / 100 * width) - ((39d / 100 * width))));
views.get("labeldesc").vw.setHeight((int)((14d / 100 * height)));
views.get("labeldesc").vw.setTop((int)((views.get("labelstatus").vw.getTop() + views.get("labelstatus").vw.getHeight())+(2d / 100 * height)));
views.get("label5").vw.setLeft((int)((2d / 100 * width)));
views.get("label5").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("label5").vw.setHeight((int)((22d / 100 * height)));
views.get("label5").vw.setTop((int)((views.get("labeldescdesc").vw.getTop() + views.get("labeldescdesc").vw.getHeight())+(2d / 100 * height)));
views.get("btnreapply").vw.setLeft((int)((2d / 100 * width)));
views.get("btnreapply").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("btnreapply").vw.setHeight((int)((1d / 100 * height)));
views.get("btnreapply").vw.setTop((int)((views.get("label5").vw.getTop() + views.get("label5").vw.getHeight())+(5d / 100 * height)));
views.get("btnclaim").vw.setLeft((int)((2d / 100 * width)));
views.get("btnclaim").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("btnclaim").vw.setHeight((int)((15d / 100 * height)));
views.get("btnclaim").vw.setTop((int)((views.get("btnreapply").vw.getTop() + views.get("btnreapply").vw.getHeight())+(2d / 100 * height)));

}
}