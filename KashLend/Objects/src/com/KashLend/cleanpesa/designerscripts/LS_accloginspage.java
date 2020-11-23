package com.KashLend.cleanpesa.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_accloginspage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[AccLoginsPage/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 4;BA.debugLine="Panel1.Height=100%y"[AccLoginsPage/General script]
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
//BA.debugLineNum = 5;BA.debugLine="Panel1.Width=100%x"[AccLoginsPage/General script]
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 7;BA.debugLine="Label1.Top=10%y"[AccLoginsPage/General script]
views.get("label1").vw.setTop((int)((10d / 100 * height)));
//BA.debugLineNum = 8;BA.debugLine="Label1.SetLeftAndRight(2%x,98%x)"[AccLoginsPage/General script]
views.get("label1").vw.setLeft((int)((2d / 100 * width)));
views.get("label1").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
//BA.debugLineNum = 9;BA.debugLine="Label1.Height=20%y"[AccLoginsPage/General script]
views.get("label1").vw.setHeight((int)((20d / 100 * height)));
//BA.debugLineNum = 11;BA.debugLine="PasswordLabel.Top=Label1.Bottom +2%y"[AccLoginsPage/General script]
views.get("passwordlabel").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(2d / 100 * height)));
//BA.debugLineNum = 12;BA.debugLine="PasswordLabel.SetLeftAndRight(40%x,60%x)"[AccLoginsPage/General script]
views.get("passwordlabel").vw.setLeft((int)((40d / 100 * width)));
views.get("passwordlabel").vw.setWidth((int)((60d / 100 * width) - ((40d / 100 * width))));
//BA.debugLineNum = 13;BA.debugLine="PasswordLabel.Height=2%y"[AccLoginsPage/General script]
views.get("passwordlabel").vw.setHeight((int)((2d / 100 * height)));
//BA.debugLineNum = 15;BA.debugLine="B1.SetLeftAndRight(23%x,35%x)"[AccLoginsPage/General script]
views.get("b1").vw.setLeft((int)((23d / 100 * width)));
views.get("b1").vw.setWidth((int)((35d / 100 * width) - ((23d / 100 * width))));
//BA.debugLineNum = 16;BA.debugLine="B1.Top=PasswordLabel.Bottom +5%y"[AccLoginsPage/General script]
views.get("b1").vw.setTop((int)((views.get("passwordlabel").vw.getTop() + views.get("passwordlabel").vw.getHeight())+(5d / 100 * height)));
//BA.debugLineNum = 17;BA.debugLine="B1.Height=8%y"[AccLoginsPage/General script]
views.get("b1").vw.setHeight((int)((8d / 100 * height)));
//BA.debugLineNum = 19;BA.debugLine="B2.SetLeftAndRight(37%x,49%x)"[AccLoginsPage/General script]
views.get("b2").vw.setLeft((int)((37d / 100 * width)));
views.get("b2").vw.setWidth((int)((49d / 100 * width) - ((37d / 100 * width))));
//BA.debugLineNum = 20;BA.debugLine="B2.Top=PasswordLabel.Bottom +5%y"[AccLoginsPage/General script]
views.get("b2").vw.setTop((int)((views.get("passwordlabel").vw.getTop() + views.get("passwordlabel").vw.getHeight())+(5d / 100 * height)));
//BA.debugLineNum = 21;BA.debugLine="B2.Height=8%y"[AccLoginsPage/General script]
views.get("b2").vw.setHeight((int)((8d / 100 * height)));
//BA.debugLineNum = 23;BA.debugLine="B3.SetLeftAndRight(51%x,63%x)"[AccLoginsPage/General script]
views.get("b3").vw.setLeft((int)((51d / 100 * width)));
views.get("b3").vw.setWidth((int)((63d / 100 * width) - ((51d / 100 * width))));
//BA.debugLineNum = 24;BA.debugLine="B3.Top=PasswordLabel.Bottom +5%y"[AccLoginsPage/General script]
views.get("b3").vw.setTop((int)((views.get("passwordlabel").vw.getTop() + views.get("passwordlabel").vw.getHeight())+(5d / 100 * height)));
//BA.debugLineNum = 25;BA.debugLine="B3.Height=8%y"[AccLoginsPage/General script]
views.get("b3").vw.setHeight((int)((8d / 100 * height)));
//BA.debugLineNum = 27;BA.debugLine="B4.SetLeftAndRight(65%x,77%x)"[AccLoginsPage/General script]
views.get("b4").vw.setLeft((int)((65d / 100 * width)));
views.get("b4").vw.setWidth((int)((77d / 100 * width) - ((65d / 100 * width))));
//BA.debugLineNum = 28;BA.debugLine="B4.Top=PasswordLabel.Bottom +5%y"[AccLoginsPage/General script]
views.get("b4").vw.setTop((int)((views.get("passwordlabel").vw.getTop() + views.get("passwordlabel").vw.getHeight())+(5d / 100 * height)));
//BA.debugLineNum = 29;BA.debugLine="B4.Height=8%y"[AccLoginsPage/General script]
views.get("b4").vw.setHeight((int)((8d / 100 * height)));
//BA.debugLineNum = 31;BA.debugLine="B5.SetLeftAndRight(23%x,35%x)"[AccLoginsPage/General script]
views.get("b5").vw.setLeft((int)((23d / 100 * width)));
views.get("b5").vw.setWidth((int)((35d / 100 * width) - ((23d / 100 * width))));
//BA.debugLineNum = 32;BA.debugLine="B5.Top=B1.Bottom +5%y"[AccLoginsPage/General script]
views.get("b5").vw.setTop((int)((views.get("b1").vw.getTop() + views.get("b1").vw.getHeight())+(5d / 100 * height)));
//BA.debugLineNum = 33;BA.debugLine="B5.Height=8%y"[AccLoginsPage/General script]
views.get("b5").vw.setHeight((int)((8d / 100 * height)));
//BA.debugLineNum = 35;BA.debugLine="B6.SetLeftAndRight(37%x,49%x)"[AccLoginsPage/General script]
views.get("b6").vw.setLeft((int)((37d / 100 * width)));
views.get("b6").vw.setWidth((int)((49d / 100 * width) - ((37d / 100 * width))));
//BA.debugLineNum = 36;BA.debugLine="B6.Top=B2.Bottom +5%y"[AccLoginsPage/General script]
views.get("b6").vw.setTop((int)((views.get("b2").vw.getTop() + views.get("b2").vw.getHeight())+(5d / 100 * height)));
//BA.debugLineNum = 37;BA.debugLine="B6.Height=8%y"[AccLoginsPage/General script]
views.get("b6").vw.setHeight((int)((8d / 100 * height)));
//BA.debugLineNum = 39;BA.debugLine="B7.SetLeftAndRight(51%x,63%x)"[AccLoginsPage/General script]
views.get("b7").vw.setLeft((int)((51d / 100 * width)));
views.get("b7").vw.setWidth((int)((63d / 100 * width) - ((51d / 100 * width))));
//BA.debugLineNum = 40;BA.debugLine="B7.Top=B3.Bottom +5%y"[AccLoginsPage/General script]
views.get("b7").vw.setTop((int)((views.get("b3").vw.getTop() + views.get("b3").vw.getHeight())+(5d / 100 * height)));
//BA.debugLineNum = 41;BA.debugLine="B7.Height=8%y"[AccLoginsPage/General script]
views.get("b7").vw.setHeight((int)((8d / 100 * height)));
//BA.debugLineNum = 43;BA.debugLine="B_X.SetLeftAndRight(65%x,77%x)"[AccLoginsPage/General script]
views.get("b_x").vw.setLeft((int)((65d / 100 * width)));
views.get("b_x").vw.setWidth((int)((77d / 100 * width) - ((65d / 100 * width))));
//BA.debugLineNum = 44;BA.debugLine="B_X.Top=B4.Bottom +5%y"[AccLoginsPage/General script]
views.get("b_x").vw.setTop((int)((views.get("b4").vw.getTop() + views.get("b4").vw.getHeight())+(5d / 100 * height)));
//BA.debugLineNum = 45;BA.debugLine="B_X.Height=8%y"[AccLoginsPage/General script]
views.get("b_x").vw.setHeight((int)((8d / 100 * height)));
//BA.debugLineNum = 47;BA.debugLine="B8.SetLeftAndRight(23%x,35%x)"[AccLoginsPage/General script]
views.get("b8").vw.setLeft((int)((23d / 100 * width)));
views.get("b8").vw.setWidth((int)((35d / 100 * width) - ((23d / 100 * width))));
//BA.debugLineNum = 48;BA.debugLine="B8.Top=B5.Bottom +5%y"[AccLoginsPage/General script]
views.get("b8").vw.setTop((int)((views.get("b5").vw.getTop() + views.get("b5").vw.getHeight())+(5d / 100 * height)));
//BA.debugLineNum = 49;BA.debugLine="B8.Height=8%y"[AccLoginsPage/General script]
views.get("b8").vw.setHeight((int)((8d / 100 * height)));
//BA.debugLineNum = 51;BA.debugLine="B9.SetLeftAndRight(37%x,49%x)"[AccLoginsPage/General script]
views.get("b9").vw.setLeft((int)((37d / 100 * width)));
views.get("b9").vw.setWidth((int)((49d / 100 * width) - ((37d / 100 * width))));
//BA.debugLineNum = 52;BA.debugLine="B9.Top=B6.Bottom +5%y"[AccLoginsPage/General script]
views.get("b9").vw.setTop((int)((views.get("b6").vw.getTop() + views.get("b6").vw.getHeight())+(5d / 100 * height)));
//BA.debugLineNum = 53;BA.debugLine="B9.Height=8%y"[AccLoginsPage/General script]
views.get("b9").vw.setHeight((int)((8d / 100 * height)));
//BA.debugLineNum = 55;BA.debugLine="B0.SetLeftAndRight(51%x,63%x)"[AccLoginsPage/General script]
views.get("b0").vw.setLeft((int)((51d / 100 * width)));
views.get("b0").vw.setWidth((int)((63d / 100 * width) - ((51d / 100 * width))));
//BA.debugLineNum = 56;BA.debugLine="B0.Top=B7.Bottom +5%y"[AccLoginsPage/General script]
views.get("b0").vw.setTop((int)((views.get("b7").vw.getTop() + views.get("b7").vw.getHeight())+(5d / 100 * height)));
//BA.debugLineNum = 57;BA.debugLine="B0.Height=8%y"[AccLoginsPage/General script]
views.get("b0").vw.setHeight((int)((8d / 100 * height)));
//BA.debugLineNum = 59;BA.debugLine="B_OK.SetLeftAndRight(65%x,77%x)"[AccLoginsPage/General script]
views.get("b_ok").vw.setLeft((int)((65d / 100 * width)));
views.get("b_ok").vw.setWidth((int)((77d / 100 * width) - ((65d / 100 * width))));
//BA.debugLineNum = 60;BA.debugLine="B_OK.Top=B_X.Bottom +5%y"[AccLoginsPage/General script]
views.get("b_ok").vw.setTop((int)((views.get("b_x").vw.getTop() + views.get("b_x").vw.getHeight())+(5d / 100 * height)));
//BA.debugLineNum = 61;BA.debugLine="B_OK.Height=8%y"[AccLoginsPage/General script]
views.get("b_ok").vw.setHeight((int)((8d / 100 * height)));

}
}