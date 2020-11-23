package com.vukapesa.cleandeal;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class processingtill extends Activity implements B4AActivity{
	public static processingtill mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "com.vukapesa.cleandeal", "com.vukapesa.cleandeal.processingtill");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (processingtill).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "com.vukapesa.cleandeal", "com.vukapesa.cleandeal.processingtill");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.vukapesa.cleandeal.processingtill", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (processingtill) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (processingtill) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return processingtill.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (processingtill) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (processingtill) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            processingtill mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (processingtill) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static int _btn = 0;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtmpesacode = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnapprovecode = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public com.vukapesa.cleandeal.main _main = null;
public com.vukapesa.cleandeal.acccreate2 _acccreate2 = null;
public com.vukapesa.cleandeal.acclogins _acclogins = null;
public com.vukapesa.cleandeal.applicationconfirm _applicationconfirm = null;
public com.vukapesa.cleandeal.apply _apply = null;
public com.vukapesa.cleandeal.claimsavings _claimsavings = null;
public com.vukapesa.cleandeal.detailsoverview _detailsoverview = null;
public com.vukapesa.cleandeal.directory _directory = null;
public com.vukapesa.cleandeal.educlevel _educlevel = null;
public com.vukapesa.cleandeal.inuka _inuka = null;
public com.vukapesa.cleandeal.login _login = null;
public com.vukapesa.cleandeal.starter _starter = null;
public com.vukapesa.cleandeal.acccreate _acccreate = null;
public com.vukapesa.cleandeal.acclogin _acclogin = null;
public com.vukapesa.cleandeal.inukaloan _inukaloan = null;
public com.vukapesa.cleandeal.membership _membership = null;
public com.vukapesa.cleandeal.membershipselection _membershipselection = null;
public com.vukapesa.cleandeal.nextofkin _nextofkin = null;
public com.vukapesa.cleandeal.occupation _occupation = null;
public com.vukapesa.cleandeal.reviews _reviews = null;
public com.vukapesa.cleandeal.reward _reward = null;
public com.vukapesa.cleandeal.saveconfirmpage _saveconfirmpage = null;
public com.vukapesa.cleandeal.savingspage _savingspage = null;
public com.vukapesa.cleandeal.tillsavings _tillsavings = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.objects.drawable.ColorDrawable _page = null;
 //BA.debugLineNum = 23;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"ProcessingTillPage\")";
mostCurrent._activity.LoadLayout("ProcessingTillPage",mostCurrent.activityBA);
 //BA.debugLineNum = 26;BA.debugLine="Dim page As ColorDrawable";
_page = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 27;BA.debugLine="page.Initialize(Inuka.pages,0)";
_page.Initialize(mostCurrent._inuka._pages /*int*/ ,(int) (0));
 //BA.debugLineNum = 28;BA.debugLine="Panel1.Background=page";
mostCurrent._panel1.setBackground((android.graphics.drawable.Drawable)(_page.getObject()));
 //BA.debugLineNum = 31;BA.debugLine="BtnApproveCode.Text=\"Approve Code\"";
mostCurrent._btnapprovecode.setText(BA.ObjectToCharSequence("Approve Code"));
 //BA.debugLineNum = 32;BA.debugLine="BtnApproveCode.TextColor=Colors.Black";
mostCurrent._btnapprovecode.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 33;BA.debugLine="BtnApproveCode.TextSize=15";
mostCurrent._btnapprovecode.setTextSize((float) (15));
 //BA.debugLineNum = 35;BA.debugLine="edtMpesaCode.Hint=\"PASTE THE MPESA MESSAGE RECEIV";
mostCurrent._edtmpesacode.setHint("PASTE THE MPESA MESSAGE RECEIVED HERE");
 //BA.debugLineNum = 36;BA.debugLine="edtMpesaCode.HintColor=Colors.Magenta";
mostCurrent._edtmpesacode.setHintColor(anywheresoftware.b4a.keywords.Common.Colors.Magenta);
 //BA.debugLineNum = 37;BA.debugLine="edtMpesaCode.TextSize=14";
mostCurrent._edtmpesacode.setTextSize((float) (14));
 //BA.debugLineNum = 38;BA.debugLine="edtMpesaCode.TextColor=Colors.Black";
mostCurrent._edtmpesacode.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 39;BA.debugLine="edtMpesaCode.Color=Colors.White";
mostCurrent._edtmpesacode.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 41;BA.debugLine="Label1.Text=$\"We are commited to serving our cust";
mostCurrent._label1.setText(BA.ObjectToCharSequence(("We are commited to serving our customers to satisfaction.\n"+"Therefore "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._starter._compname /*String*/ ))+" requires you to pay processing fee of Ksh."+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._starter._pfee /*int*/ ))+" to Till No. "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._starter._till /*String*/ ))+".\n"+"\n"+"CLICK HERE To COPY TILL NUMBER TO CLIPBOARD.")));
 //BA.debugLineNum = 45;BA.debugLine="Label1.TextColor=Colors.Black";
mostCurrent._label1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 46;BA.debugLine="Label1.TextSize=14";
mostCurrent._label1.setTextSize((float) (14));
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 49;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public static void  _btnapprovecode_click() throws Exception{
ResumableSub_BtnApproveCode_Click rsub = new ResumableSub_BtnApproveCode_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_BtnApproveCode_Click extends BA.ResumableSub {
public ResumableSub_BtnApproveCode_Click(com.vukapesa.cleandeal.processingtill parent) {
this.parent = parent;
}
com.vukapesa.cleandeal.processingtill parent;
String _mcode = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 59;BA.debugLine="Dim Mcode As String";
_mcode = "";
 //BA.debugLineNum = 60;BA.debugLine="Mcode = edtMpesaCode.Text.Trim";
_mcode = parent.mostCurrent._edtmpesacode.getText().trim();
 //BA.debugLineNum = 62;BA.debugLine="If Mcode = \"\" Then";
if (true) break;

case 1:
//if
this.state = 8;
if ((_mcode).equals("")) { 
this.state = 3;
}else if(_mcode.length()<142) { 
this.state = 5;
}else {
this.state = 7;
}if (true) break;

case 3:
//C
this.state = 8;
 //BA.debugLineNum = 63;BA.debugLine="edtMpesaCode.Hint = \"MPESA MESSAGE REQUIRED!\"";
parent.mostCurrent._edtmpesacode.setHint("MPESA MESSAGE REQUIRED!");
 //BA.debugLineNum = 64;BA.debugLine="edtMpesaCode.HintColor = Colors.Red";
parent.mostCurrent._edtmpesacode.setHintColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 65;BA.debugLine="edtMpesaCode.Gravity = Gravity.CENTER";
parent.mostCurrent._edtmpesacode.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 66;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 5:
//C
this.state = 8;
 //BA.debugLineNum = 68;BA.debugLine="edtMpesaCode.Text = \"\"";
parent.mostCurrent._edtmpesacode.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 69;BA.debugLine="edtMpesaCode.Hint = \"INVALID MPESA MESSAGE!\"";
parent.mostCurrent._edtmpesacode.setHint("INVALID MPESA MESSAGE!");
 //BA.debugLineNum = 70;BA.debugLine="edtMpesaCode.HintColor = Colors.Red";
parent.mostCurrent._edtmpesacode.setHintColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 71;BA.debugLine="edtMpesaCode.Gravity = Gravity.CENTER";
parent.mostCurrent._edtmpesacode.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 72;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 7:
//C
this.state = 8;
 //BA.debugLineNum = 74;BA.debugLine="ProgressDialogShow2(\"Confirming message....\",Fal";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,BA.ObjectToCharSequence("Confirming message...."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 75;BA.debugLine="Sleep(2000)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (2000));
this.state = 9;
return;
case 9:
//C
this.state = 8;
;
 //BA.debugLineNum = 76;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 77;BA.debugLine="StartActivity(ApplicationConfirm)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._applicationconfirm.getObject()));
 if (true) break;

case 8:
//C
this.state = -1;
;
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private edtMpesaCode As EditText";
mostCurrent._edtmpesacode = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private BtnApproveCode As Button";
mostCurrent._btnapprovecode = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public static String  _label1_click() throws Exception{
b4a.util.BClipboard _click = null;
 //BA.debugLineNum = 84;BA.debugLine="Sub Label1_Click";
 //BA.debugLineNum = 85;BA.debugLine="Dim Click As BClipboard";
_click = new b4a.util.BClipboard();
 //BA.debugLineNum = 86;BA.debugLine="Click.setText(Starter.Till)";
_click.setText(mostCurrent.activityBA,mostCurrent._starter._till /*String*/ );
 //BA.debugLineNum = 87;BA.debugLine="ToastMessageShow($\"Till Number - ${Starter.Till}";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(("Till Number - "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._starter._till /*String*/ ))+" copied to clipboard")),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Dim btn As Int = Colors.ARGB(182,223,255,255)";
_btn = anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (182),(int) (223),(int) (255),(int) (255));
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
}
