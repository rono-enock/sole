package com.vukapesa.cleandeal.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_reviewspage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("labelrevname").vw.setLeft((int)((2d / 100 * width)));
views.get("labelrevname").vw.setWidth((int)((27d / 100 * width) - ((2d / 100 * width))));
views.get("labelrevname").vw.setHeight((int)((15d / 100 * height)));
views.get("labelrevname").vw.setTop((int)((3d / 100 * height)));
views.get("labelreview").vw.setLeft((int)((30d / 100 * width)));
views.get("labelreview").vw.setWidth((int)((98d / 100 * width) - ((30d / 100 * width))));
views.get("labelreview").vw.setHeight((int)((15d / 100 * height)));
views.get("labelreview").vw.setTop((int)((3d / 100 * height)));
views.get("labeldetname").vw.setLeft((int)((2d / 100 * width)));
views.get("labeldetname").vw.setWidth((int)((27d / 100 * width) - ((2d / 100 * width))));
views.get("labeldetname").vw.setHeight((int)((15d / 100 * height)));
views.get("labeldetname").vw.setTop((int)((views.get("labelrevname").vw.getTop() + views.get("labelrevname").vw.getHeight())+(3d / 100 * height)));
views.get("labeldetails").vw.setLeft((int)((30d / 100 * width)));
views.get("labeldetails").vw.setWidth((int)((98d / 100 * width) - ((30d / 100 * width))));
views.get("labeldetails").vw.setHeight((int)((15d / 100 * height)));
views.get("labeldetails").vw.setTop((int)((views.get("labelreview").vw.getTop() + views.get("labelreview").vw.getHeight())+(3d / 100 * height)));
views.get("labeldesc").vw.setLeft((int)((2d / 100 * width)));
views.get("labeldesc").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("labeldesc").vw.setHeight((int)((15d / 100 * height)));
views.get("labeldesc").vw.setTop((int)((views.get("labeldetname").vw.getTop() + views.get("labeldetname").vw.getHeight())+(3d / 100 * height)));
views.get("btnreapply").vw.setLeft((int)((2d / 100 * width)));
views.get("btnreapply").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("btnreapply").vw.setHeight((int)((15d / 100 * height)));
views.get("btnreapply").vw.setTop((int)((views.get("labeldesc").vw.getTop() + views.get("labeldesc").vw.getHeight())+(6d / 100 * height)));
views.get("btnclaim").vw.setLeft((int)((2d / 100 * width)));
views.get("btnclaim").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("btnclaim").vw.setHeight((int)((15d / 100 * height)));
views.get("btnclaim").vw.setTop((int)((views.get("btnreapply").vw.getTop() + views.get("btnreapply").vw.getHeight())+(3d / 100 * height)));

}
}