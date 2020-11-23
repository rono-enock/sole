package com.vukapesa.cleandeal.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_kinpage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("label1").vw.setLeft((int)((2d / 100 * width)));
views.get("label1").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("label1").vw.setTop((int)((60d * scale)));
views.get("label1").vw.setHeight((int)((10d / 100 * height)));
views.get("edtnames").vw.setLeft((int)((15d / 100 * width)));
views.get("edtnames").vw.setWidth((int)((85d / 100 * width) - ((15d / 100 * width))));
views.get("edtnames").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(20d * scale)));
views.get("edtnames").vw.setHeight((int)((12d / 100 * height)));
views.get("edtphone").vw.setLeft((int)((15d / 100 * width)));
views.get("edtphone").vw.setWidth((int)((85d / 100 * width) - ((15d / 100 * width))));
views.get("edtphone").vw.setTop((int)((views.get("edtnames").vw.getTop() + views.get("edtnames").vw.getHeight())+(15d * scale)));
views.get("edtphone").vw.setHeight((int)((12d / 100 * height)));
views.get("edtlocation").vw.setLeft((int)((15d / 100 * width)));
views.get("edtlocation").vw.setWidth((int)((85d / 100 * width) - ((15d / 100 * width))));
views.get("edtlocation").vw.setTop((int)((views.get("edtphone").vw.getTop() + views.get("edtphone").vw.getHeight())+(15d * scale)));
views.get("edtlocation").vw.setHeight((int)((12d / 100 * height)));
views.get("btnnext").vw.setLeft((int)((5d / 100 * width)));
views.get("btnnext").vw.setWidth((int)((95d / 100 * width) - ((5d / 100 * width))));
views.get("btnnext").vw.setHeight((int)((12d / 100 * height)));
views.get("btnnext").vw.setTop((int)((views.get("edtlocation").vw.getTop() + views.get("edtlocation").vw.getHeight())+(80d * scale)));

}
}