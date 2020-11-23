package com.KashLend.cleanpesa.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_locationpage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("label1").vw.setTop((int)((10d / 100 * height)));
views.get("label1").vw.setLeft((int)((2d / 100 * width)));
views.get("label1").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("label1").vw.setHeight((int)((15d / 100 * height)));
views.get("labelcountry").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(5d / 100 * height)));
views.get("labelcountry").vw.setLeft((int)((2d / 100 * width)));
views.get("labelcountry").vw.setWidth((int)((40d / 100 * width) - ((2d / 100 * width))));
views.get("label1").vw.setHeight((int)((15d / 100 * height)));
views.get("spinner1").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(5d / 100 * height)));
views.get("spinner1").vw.setLeft((int)((41d / 100 * width)));
views.get("spinner1").vw.setWidth((int)((98d / 100 * width) - ((41d / 100 * width))));
views.get("spinner1").vw.setHeight((int)((12d / 100 * height)));
views.get("labelgender").vw.setTop((int)((views.get("labelcountry").vw.getTop() + views.get("labelcountry").vw.getHeight())+(2d / 100 * height)));
views.get("labelgender").vw.setLeft((int)((2d / 100 * width)));
views.get("labelgender").vw.setWidth((int)((40d / 100 * width) - ((2d / 100 * width))));
views.get("labelgender").vw.setHeight((int)((10d / 100 * height)));
views.get("rdmale").vw.setTop((int)((views.get("labelgender").vw.getTop() + views.get("labelgender").vw.getHeight())+(2d / 100 * height)));
views.get("rdmale").vw.setLeft((int)((2d / 100 * width)));
views.get("rdmale").vw.setWidth((int)((36d / 100 * width) - ((2d / 100 * width))));
views.get("rdmale").vw.setHeight((int)((12d / 100 * height)));
views.get("rdfemale").vw.setTop((int)((views.get("labelgender").vw.getTop() + views.get("labelgender").vw.getHeight())+(2d / 100 * height)));
views.get("rdfemale").vw.setLeft((int)((37d / 100 * width)));
views.get("rdfemale").vw.setWidth((int)((65d / 100 * width) - ((37d / 100 * width))));
views.get("rdfemale").vw.setHeight((int)((12d / 100 * height)));
views.get("rdother").vw.setTop((int)((views.get("labelgender").vw.getTop() + views.get("labelgender").vw.getHeight())+(2d / 100 * height)));
views.get("rdother").vw.setLeft((int)((66d / 100 * width)));
views.get("rdother").vw.setWidth((int)((98d / 100 * width) - ((66d / 100 * width))));
views.get("rdother").vw.setHeight((int)((12d / 100 * height)));
views.get("btnnext").vw.setTop((int)((views.get("rdfemale").vw.getTop() + views.get("rdfemale").vw.getHeight())+(12d / 100 * height)));
views.get("btnnext").vw.setLeft((int)((2d / 100 * width)));
views.get("btnnext").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("btnnext").vw.setHeight((int)((15d / 100 * height)));

}
}