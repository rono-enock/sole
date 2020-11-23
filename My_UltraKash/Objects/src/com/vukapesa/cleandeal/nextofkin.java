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

public class nextofkin extends Activity implements B4AActivity{
	public static nextofkin mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "com.vukapesa.cleandeal", "com.vukapesa.cleandeal.nextofkin");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (nextofkin).");
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
		activityBA = new BA(this, layout, processBA, "com.vukapesa.cleandeal", "com.vukapesa.cleandeal.nextofkin");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.vukapesa.cleandeal.nextofkin", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (nextofkin) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (nextofkin) Resume **");
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
		return nextofkin.class;
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
            BA.LogInfo("** Activity (nextofkin) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (nextofkin) Pause event (activity is not paused). **");
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
            nextofkin mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (nextofkin) Resume **");
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
public static String _kin = "";
public static String _kinphon = "";
public static String _kinloc = "";
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtnames = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtphone = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtlocation = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnnext = null;
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
public com.vukapesa.cleandeal.occupation _occupation = null;
public com.vukapesa.cleandeal.processingtill _processingtill = null;
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
 //BA.debugLineNum = 31;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"KinPage\")";
mostCurrent._activity.LoadLayout("KinPage",mostCurrent.activityBA);
 //BA.debugLineNum = 34;BA.debugLine="Dim page As ColorDrawable";
_page = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 35;BA.debugLine="page.Initialize(Inuka.pages,0)";
_page.Initialize(mostCurrent._inuka._pages /*int*/ ,(int) (0));
 //BA.debugLineNum = 36;BA.debugLine="Panel1.Background=page";
mostCurrent._panel1.setBackground((android.graphics.drawable.Drawable)(_page.getObject()));
 //BA.debugLineNum = 41;BA.debugLine="edtPhone.InputType=edtPhone.INPUT_TYPE_NUMBERS";
mostCurrent._edtphone.setInputType(mostCurrent._edtphone.INPUT_TYPE_NUMBERS);
 //BA.debugLineNum = 43;BA.debugLine="Label1.TextColor=Colors.Black";
mostCurrent._label1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 44;BA.debugLine="Label1.TextSize=15";
mostCurrent._label1.setTextSize((float) (15));
 //BA.debugLineNum = 47;BA.debugLine="BtnNext.Text=\"Next\"";
mostCurrent._btnnext.setText(BA.ObjectToCharSequence("Next"));
 //BA.debugLineNum = 48;BA.debugLine="BtnNext.TextColor=Colors.Black";
mostCurrent._btnnext.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 49;BA.debugLine="BtnNext.TextSize=15";
mostCurrent._btnnext.setTextSize((float) (15));
 //BA.debugLineNum = 51;BA.debugLine="Label1.Text=\"Provide your next of kin's details\"";
mostCurrent._label1.setText(BA.ObjectToCharSequence("Provide your next of kin's details"));
 //BA.debugLineNum = 53;BA.debugLine="edtNames.Hint=\"Names\"";
mostCurrent._edtnames.setHint("Names");
 //BA.debugLineNum = 54;BA.debugLine="edtNames.HintColor=btn";
mostCurrent._edtnames.setHintColor(_btn);
 //BA.debugLineNum = 55;BA.debugLine="edtNames.TextSize=14";
mostCurrent._edtnames.setTextSize((float) (14));
 //BA.debugLineNum = 56;BA.debugLine="edtNames.TextColor=Colors.Black";
mostCurrent._edtnames.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 58;BA.debugLine="edtPhone.Hint=\"Phone number\"";
mostCurrent._edtphone.setHint("Phone number");
 //BA.debugLineNum = 59;BA.debugLine="edtPhone.HintColor=btn";
mostCurrent._edtphone.setHintColor(_btn);
 //BA.debugLineNum = 60;BA.debugLine="edtPhone.TextSize=14";
mostCurrent._edtphone.setTextSize((float) (14));
 //BA.debugLineNum = 61;BA.debugLine="edtPhone.TextColor=Colors.Black";
mostCurrent._edtphone.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 63;BA.debugLine="edtLocation.Hint=\"Relationship (Brother/Sister...";
mostCurrent._edtlocation.setHint("Relationship (Brother/Sister....)");
 //BA.debugLineNum = 64;BA.debugLine="edtLocation.HintColor=btn";
mostCurrent._edtlocation.setHintColor(_btn);
 //BA.debugLineNum = 65;BA.debugLine="edtLocation.TextSize=14";
mostCurrent._edtlocation.setTextSize((float) (14));
 //BA.debugLineNum = 66;BA.debugLine="edtLocation.TextColor=Colors.Black";
mostCurrent._edtlocation.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 74;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 70;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return "";
}
public static String  _btnnext_click() throws Exception{
String _nem = "";
String _loc = "";
String _phone = "";
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _match = null;
 //BA.debugLineNum = 98;BA.debugLine="Sub BtnNext_Click";
 //BA.debugLineNum = 100;BA.debugLine="kin=edtNames.Text";
_kin = mostCurrent._edtnames.getText();
 //BA.debugLineNum = 101;BA.debugLine="kinphon=edtPhone.Text";
_kinphon = mostCurrent._edtphone.getText();
 //BA.debugLineNum = 102;BA.debugLine="kinloc=edtLocation.Text";
_kinloc = mostCurrent._edtlocation.getText();
 //BA.debugLineNum = 104;BA.debugLine="Dim nem,loc,phone As String";
_nem = "";
_loc = "";
_phone = "";
 //BA.debugLineNum = 105;BA.debugLine="Dim match As Matcher";
_match = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
 //BA.debugLineNum = 107;BA.debugLine="nem=edtNames.Text";
_nem = mostCurrent._edtnames.getText();
 //BA.debugLineNum = 108;BA.debugLine="match=Regex.Matcher(\"\\d\",nem)";
_match = anywheresoftware.b4a.keywords.Common.Regex.Matcher("\\d",_nem);
 //BA.debugLineNum = 109;BA.debugLine="If(nem.IndexOf(\" \")= -1) Or (nem=\"\") Or (match.Fi";
if ((_nem.indexOf(" ")==-1) || ((_nem).equals("")) || (_match.Find()) || (_nem.length()<5)) { 
 //BA.debugLineNum = 110;BA.debugLine="Errorfun(\"name\")";
_errorfun("name");
 //BA.debugLineNum = 111;BA.debugLine="edtNames.RequestFocus";
mostCurrent._edtnames.RequestFocus();
 //BA.debugLineNum = 112;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 115;BA.debugLine="nem=edtPhone.Text";
_nem = mostCurrent._edtphone.getText();
 //BA.debugLineNum = 116;BA.debugLine="If Not(Regex.IsMatch(\"\\d+\",nem)) Or (nem=\"\") Or (";
if (anywheresoftware.b4a.keywords.Common.Not(anywheresoftware.b4a.keywords.Common.Regex.IsMatch("\\d+",_nem)) || ((_nem).equals("")) || (_nem.length()!=10)) { 
 //BA.debugLineNum = 117;BA.debugLine="Errorfun(\"phone\")";
_errorfun("phone");
 //BA.debugLineNum = 118;BA.debugLine="edtPhone.RequestFocus";
mostCurrent._edtphone.RequestFocus();
 //BA.debugLineNum = 119;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 122;BA.debugLine="nem=edtLocation.Text";
_nem = mostCurrent._edtlocation.getText();
 //BA.debugLineNum = 123;BA.debugLine="match=Regex.Matcher(\"\\d\",nem)";
_match = anywheresoftware.b4a.keywords.Common.Regex.Matcher("\\d",_nem);
 //BA.debugLineNum = 124;BA.debugLine="If(nem.Length<5) Or (nem=\"\") Or (nem.Length>12)Th";
if ((_nem.length()<5) || ((_nem).equals("")) || (_nem.length()>12)) { 
 //BA.debugLineNum = 125;BA.debugLine="Errorfun(\"loc\")";
_errorfun("loc");
 //BA.debugLineNum = 126;BA.debugLine="edtLocation.RequestFocus";
mostCurrent._edtlocation.RequestFocus();
 //BA.debugLineNum = 127;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 130;BA.debugLine="detailss";
_detailss();
 //BA.debugLineNum = 134;BA.debugLine="StartActivity(DetailsOverView)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._detailsoverview.getObject()));
 //BA.debugLineNum = 137;BA.debugLine="End Sub";
return "";
}
public static String  _detailss() throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub detailss";
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public static String  _errorfun(String _msg) throws Exception{
String _error = "";
String _title = "";
 //BA.debugLineNum = 77;BA.debugLine="Sub Errorfun(msg As String)";
 //BA.debugLineNum = 78;BA.debugLine="Dim error As String";
_error = "";
 //BA.debugLineNum = 79;BA.debugLine="Dim title As String=\"Error\"";
_title = "Error";
 //BA.debugLineNum = 80;BA.debugLine="Select msg";
switch (BA.switchObjectToInt(_msg,"name","phone","loc","nameEmp","phoneEmp","locEmp","Emp")) {
case 0: {
 //BA.debugLineNum = 82;BA.debugLine="error=\"Enter the correct names\"";
_error = "Enter the correct names";
 break; }
case 1: {
 //BA.debugLineNum = 84;BA.debugLine="error=\"Enter a valid phone number\"";
_error = "Enter a valid phone number";
 break; }
case 2: {
 //BA.debugLineNum = 86;BA.debugLine="error=\"Enter the correct country\"";
_error = "Enter the correct country";
 break; }
case 3: {
 //BA.debugLineNum = 88;BA.debugLine="error=\"Enter your name\"";
_error = "Enter your name";
 break; }
case 4: {
 //BA.debugLineNum = 90;BA.debugLine="error=\"Enter your phone number\"";
_error = "Enter your phone number";
 break; }
case 5: {
 //BA.debugLineNum = 92;BA.debugLine="error=\"Enter your location\"";
_error = "Enter your location";
 break; }
case 6: {
 //BA.debugLineNum = 94;BA.debugLine="error=\"Enter your details\"";
_error = "Enter your details";
 break; }
}
;
 //BA.debugLineNum = 96;BA.debugLine="MsgboxAsync(error,title)";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence(_error),BA.ObjectToCharSequence(_title),processBA);
 //BA.debugLineNum = 97;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private edtNames As EditText";
mostCurrent._edtnames = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private edtPhone As EditText";
mostCurrent._edtphone = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private edtLocation As EditText";
mostCurrent._edtlocation = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private BtnNext As Button";
mostCurrent._btnnext = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Dim btn As Int = Colors.ARGB(182,223,255,255)";
_btn = anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (182),(int) (223),(int) (255),(int) (255));
 //BA.debugLineNum = 11;BA.debugLine="Dim kin,kinphon,kinloc As String";
_kin = "";
_kinphon = "";
_kinloc = "";
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
}
