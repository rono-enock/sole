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

public class acccreate2 extends Activity implements B4AActivity{
	public static acccreate2 mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "com.vukapesa.cleandeal", "com.vukapesa.cleandeal.acccreate2");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (acccreate2).");
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
		activityBA = new BA(this, layout, processBA, "com.vukapesa.cleandeal", "com.vukapesa.cleandeal.acccreate2");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.vukapesa.cleandeal.acccreate2", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (acccreate2) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (acccreate2) Resume **");
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
		return acccreate2.class;
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
            BA.LogInfo("** Activity (acccreate2) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (acccreate2) Pause event (activity is not paused). **");
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
            acccreate2 mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (acccreate2) Resume **");
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
public static String _locates = "";
public static String _pss = "";
public static int _col = 0;
public anywheresoftware.b4a.objects.EditTextWrapper _edtloc = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtpass = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtcpass = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtday = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtmonth = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtyear = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnsubmit = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public com.vukapesa.cleandeal.main _main = null;
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
 //BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"AccCreatePage2\")";
mostCurrent._activity.LoadLayout("AccCreatePage2",mostCurrent.activityBA);
 //BA.debugLineNum = 34;BA.debugLine="Dim page As ColorDrawable";
_page = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 35;BA.debugLine="page.Initialize(Inuka.pages,0)";
_page.Initialize(mostCurrent._inuka._pages /*int*/ ,(int) (0));
 //BA.debugLineNum = 36;BA.debugLine="Panel1.Background=page";
mostCurrent._panel1.setBackground((android.graphics.drawable.Drawable)(_page.getObject()));
 //BA.debugLineNum = 41;BA.debugLine="edtcpass.InputType=edtcpass.INPUT_TYPE_NUMBERS";
mostCurrent._edtcpass.setInputType(mostCurrent._edtcpass.INPUT_TYPE_NUMBERS);
 //BA.debugLineNum = 42;BA.debugLine="edtpass.InputType=edtpass.INPUT_TYPE_NUMBERS";
mostCurrent._edtpass.setInputType(mostCurrent._edtpass.INPUT_TYPE_NUMBERS);
 //BA.debugLineNum = 44;BA.debugLine="edtday.InputType=edtday.INPUT_TYPE_NUMBERS";
mostCurrent._edtday.setInputType(mostCurrent._edtday.INPUT_TYPE_NUMBERS);
 //BA.debugLineNum = 45;BA.debugLine="edtmonth.InputType=edtmonth.INPUT_TYPE_NUMBERS";
mostCurrent._edtmonth.setInputType(mostCurrent._edtmonth.INPUT_TYPE_NUMBERS);
 //BA.debugLineNum = 46;BA.debugLine="edtyear.InputType=edtyear.INPUT_TYPE_NUMBERS";
mostCurrent._edtyear.setInputType(mostCurrent._edtyear.INPUT_TYPE_NUMBERS);
 //BA.debugLineNum = 49;BA.debugLine="Btnsubmit.Text=\"Next\"";
mostCurrent._btnsubmit.setText(BA.ObjectToCharSequence("Next"));
 //BA.debugLineNum = 50;BA.debugLine="Btnsubmit.TextColor=Colors.Black";
mostCurrent._btnsubmit.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 51;BA.debugLine="Btnsubmit.TextSize=15";
mostCurrent._btnsubmit.setTextSize((float) (15));
 //BA.debugLineNum = 53;BA.debugLine="edtpass.Hint=\"Enter Password\"";
mostCurrent._edtpass.setHint("Enter Password");
 //BA.debugLineNum = 54;BA.debugLine="edtpass.HintColor=btn";
mostCurrent._edtpass.setHintColor(_btn);
 //BA.debugLineNum = 55;BA.debugLine="edtpass.TextColor=Colors.Black";
mostCurrent._edtpass.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 56;BA.debugLine="edtpass.TextSize=14";
mostCurrent._edtpass.setTextSize((float) (14));
 //BA.debugLineNum = 58;BA.debugLine="edtcpass.Hint=\"Confirm Password\"";
mostCurrent._edtcpass.setHint("Confirm Password");
 //BA.debugLineNum = 59;BA.debugLine="edtcpass.HintColor=btn";
mostCurrent._edtcpass.setHintColor(_btn);
 //BA.debugLineNum = 60;BA.debugLine="edtcpass.TextColor=Colors.Black";
mostCurrent._edtcpass.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 61;BA.debugLine="edtcpass.TextSize=14";
mostCurrent._edtcpass.setTextSize((float) (14));
 //BA.debugLineNum = 63;BA.debugLine="edtLoc.Hint=\"Location (Country)\"";
mostCurrent._edtloc.setHint("Location (Country)");
 //BA.debugLineNum = 64;BA.debugLine="edtLoc.HintColor=btn";
mostCurrent._edtloc.setHintColor(_btn);
 //BA.debugLineNum = 65;BA.debugLine="edtLoc.TextColor=Colors.Black";
mostCurrent._edtloc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 66;BA.debugLine="edtLoc.TextSize=14";
mostCurrent._edtloc.setTextSize((float) (14));
 //BA.debugLineNum = 68;BA.debugLine="edtday.Hint=\"Day\"";
mostCurrent._edtday.setHint("Day");
 //BA.debugLineNum = 69;BA.debugLine="edtday.HintColor=btn";
mostCurrent._edtday.setHintColor(_btn);
 //BA.debugLineNum = 70;BA.debugLine="edtday.TextColor=Colors.Black";
mostCurrent._edtday.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 71;BA.debugLine="edtday.TextSize=14";
mostCurrent._edtday.setTextSize((float) (14));
 //BA.debugLineNum = 73;BA.debugLine="edtmonth.Hint=\"Month\"";
mostCurrent._edtmonth.setHint("Month");
 //BA.debugLineNum = 74;BA.debugLine="edtmonth.HintColor=btn";
mostCurrent._edtmonth.setHintColor(_btn);
 //BA.debugLineNum = 75;BA.debugLine="edtmonth.TextColor=Colors.Black";
mostCurrent._edtmonth.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 76;BA.debugLine="edtmonth.TextSize=14";
mostCurrent._edtmonth.setTextSize((float) (14));
 //BA.debugLineNum = 78;BA.debugLine="edtyear.Hint=\"Year\"";
mostCurrent._edtyear.setHint("Year");
 //BA.debugLineNum = 79;BA.debugLine="edtyear.HintColor=btn";
mostCurrent._edtyear.setHintColor(_btn);
 //BA.debugLineNum = 80;BA.debugLine="edtyear.TextColor=Colors.Black";
mostCurrent._edtyear.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 81;BA.debugLine="edtyear.TextSize=14";
mostCurrent._edtyear.setTextSize((float) (14));
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 88;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public static String  _btnsubmit_click() throws Exception{
String _loc = "";
String _pass = "";
String _pass2 = "";
String _time = "";
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _match = null;
anywheresoftware.b4a.objects.collections.List _list2 = null;
String _names = "";
String _id = "";
String _phon = "";
 //BA.debugLineNum = 144;BA.debugLine="Sub Btnsubmit_Click";
 //BA.debugLineNum = 145;BA.debugLine="Dim loc,pass,pass2,time As String";
_loc = "";
_pass = "";
_pass2 = "";
_time = "";
 //BA.debugLineNum = 146;BA.debugLine="Dim match As Matcher";
_match = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
 //BA.debugLineNum = 150;BA.debugLine="loc = edtLoc.Text";
_loc = mostCurrent._edtloc.getText();
 //BA.debugLineNum = 151;BA.debugLine="match=Regex.Matcher(\"\\d\",loc)";
_match = anywheresoftware.b4a.keywords.Common.Regex.Matcher("\\d",_loc);
 //BA.debugLineNum = 152;BA.debugLine="If(loc.Length<5) Or (loc=\"\") Or (loc.Length>12)Th";
if ((_loc.length()<5) || ((_loc).equals("")) || (_loc.length()>12)) { 
 //BA.debugLineNum = 153;BA.debugLine="ErrorMeth(\"loc\")";
_errormeth("loc");
 //BA.debugLineNum = 154;BA.debugLine="edtLoc.RequestFocus";
mostCurrent._edtloc.RequestFocus();
 //BA.debugLineNum = 155;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 158;BA.debugLine="pass=edtpass.Text";
_pass = mostCurrent._edtpass.getText();
 //BA.debugLineNum = 159;BA.debugLine="If Not(Regex.IsMatch(\"\\d+\",pass)) Or (pass.Length";
if (anywheresoftware.b4a.keywords.Common.Not(anywheresoftware.b4a.keywords.Common.Regex.IsMatch("\\d+",_pass)) || (_pass.length()<6)) { 
 //BA.debugLineNum = 160;BA.debugLine="ErrorMeth(\"pass\")";
_errormeth("pass");
 //BA.debugLineNum = 161;BA.debugLine="edtLoc.RequestFocus";
mostCurrent._edtloc.RequestFocus();
 //BA.debugLineNum = 162;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 165;BA.debugLine="pass2=edtcpass.Text";
_pass2 = mostCurrent._edtcpass.getText();
 //BA.debugLineNum = 166;BA.debugLine="If (pass=\"\")Then";
if (((_pass).equals(""))) { 
 //BA.debugLineNum = 167;BA.debugLine="ErrorMeth(\"passEmpt\")";
_errormeth("passEmpt");
 //BA.debugLineNum = 168;BA.debugLine="edtcpass.RequestFocus";
mostCurrent._edtcpass.RequestFocus();
 //BA.debugLineNum = 169;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 172;BA.debugLine="pass2=edtcpass.Text";
_pass2 = mostCurrent._edtcpass.getText();
 //BA.debugLineNum = 173;BA.debugLine="If (pass<>pass2) Or ((pass=\"\"))Then";
if (((_pass).equals(_pass2) == false) || (((_pass).equals("")))) { 
 //BA.debugLineNum = 174;BA.debugLine="ErrorMeth(\"passmatch\")";
_errormeth("passmatch");
 //BA.debugLineNum = 175;BA.debugLine="edtcpass.RequestFocus";
mostCurrent._edtcpass.RequestFocus();
 //BA.debugLineNum = 176;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 179;BA.debugLine="time=edtday.Text";
_time = mostCurrent._edtday.getText();
 //BA.debugLineNum = 180;BA.debugLine="If Not(Regex.IsMatch(\"\\d+\",time)) Or (time.Length";
if (anywheresoftware.b4a.keywords.Common.Not(anywheresoftware.b4a.keywords.Common.Regex.IsMatch("\\d+",_time)) || (_time.length()<1) || (_time.length()>2) || ((double)(Double.parseDouble(_time))>31) || ((double)(Double.parseDouble(_time))<1)) { 
 //BA.debugLineNum = 181;BA.debugLine="ErrorMeth(\"day\")";
_errormeth("day");
 //BA.debugLineNum = 182;BA.debugLine="edtday.RequestFocus";
mostCurrent._edtday.RequestFocus();
 //BA.debugLineNum = 183;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 186;BA.debugLine="time=edtmonth.Text";
_time = mostCurrent._edtmonth.getText();
 //BA.debugLineNum = 187;BA.debugLine="If Not(Regex.IsMatch(\"\\d+\",time)) Or (time.Length";
if (anywheresoftware.b4a.keywords.Common.Not(anywheresoftware.b4a.keywords.Common.Regex.IsMatch("\\d+",_time)) || (_time.length()<1) || (_time.length()>2) || ((double)(Double.parseDouble(_time))>12) || ((double)(Double.parseDouble(_time))<1)) { 
 //BA.debugLineNum = 188;BA.debugLine="ErrorMeth(\"month\")";
_errormeth("month");
 //BA.debugLineNum = 189;BA.debugLine="edtmonth.RequestFocus";
mostCurrent._edtmonth.RequestFocus();
 //BA.debugLineNum = 190;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 193;BA.debugLine="time=edtyear.Text";
_time = mostCurrent._edtyear.getText();
 //BA.debugLineNum = 194;BA.debugLine="If Not(Regex.IsMatch(\"\\d+\",time)) Or (time.Length";
if (anywheresoftware.b4a.keywords.Common.Not(anywheresoftware.b4a.keywords.Common.Regex.IsMatch("\\d+",_time)) || (_time.length()!=4) || ((double)(Double.parseDouble(_time))>2002)) { 
 //BA.debugLineNum = 195;BA.debugLine="ErrorMeth(\"year\")";
_errormeth("year");
 //BA.debugLineNum = 196;BA.debugLine="edtyear.RequestFocus";
mostCurrent._edtyear.RequestFocus();
 //BA.debugLineNum = 197;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 199;BA.debugLine="time=edtyear.Text";
_time = mostCurrent._edtyear.getText();
 //BA.debugLineNum = 200;BA.debugLine="If (time>2002) Then";
if (((double)(Double.parseDouble(_time))>2002)) { 
 //BA.debugLineNum = 201;BA.debugLine="ErrorMeth(\"yearerror\")";
_errormeth("yearerror");
 //BA.debugLineNum = 202;BA.debugLine="edtyear.RequestFocus";
mostCurrent._edtyear.RequestFocus();
 //BA.debugLineNum = 203;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 206;BA.debugLine="pss=edtcpass.Text";
_pss = mostCurrent._edtcpass.getText();
 //BA.debugLineNum = 207;BA.debugLine="locates=edtLoc.Text";
_locates = mostCurrent._edtloc.getText();
 //BA.debugLineNum = 210;BA.debugLine="Dim list2 As List";
_list2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 211;BA.debugLine="list2.Initialize";
_list2.Initialize();
 //BA.debugLineNum = 212;BA.debugLine="Dim names,ID,Phon As String";
_names = "";
_id = "";
_phon = "";
 //BA.debugLineNum = 213;BA.debugLine="If File.Exists(File.DirInternal,\"data.dat\")Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data.dat")) { 
 //BA.debugLineNum = 214;BA.debugLine="list2=File.ReadList(File.DirInternal,\"data.dat\")";
_list2 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data.dat");
 //BA.debugLineNum = 215;BA.debugLine="names=list2.Get(0)";
_names = BA.ObjectToString(_list2.Get((int) (0)));
 //BA.debugLineNum = 217;BA.debugLine="Phon=list2.Get(1)";
_phon = BA.ObjectToString(_list2.Get((int) (1)));
 };
 //BA.debugLineNum = 220;BA.debugLine="Dim list2 As List";
_list2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 221;BA.debugLine="list2.Initialize";
_list2.Initialize();
 //BA.debugLineNum = 222;BA.debugLine="list2.Add(names)";
_list2.Add((Object)(_names));
 //BA.debugLineNum = 224;BA.debugLine="list2.Add(Phon)";
_list2.Add((Object)(_phon));
 //BA.debugLineNum = 226;BA.debugLine="File.WriteList(File.DirInternal,\"data.dat\",list2)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data.dat",_list2);
 //BA.debugLineNum = 230;BA.debugLine="StartActivity(NextOfKin)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._nextofkin.getObject()));
 //BA.debugLineNum = 233;BA.debugLine="End Sub";
return "";
}
public static String  _edtcpass_enterpressed() throws Exception{
 //BA.debugLineNum = 106;BA.debugLine="Sub edtcpass_EnterPressed";
 //BA.debugLineNum = 108;BA.debugLine="End Sub";
return "";
}
public static String  _edtday_enterpressed() throws Exception{
 //BA.debugLineNum = 110;BA.debugLine="Sub edtday_EnterPressed";
 //BA.debugLineNum = 112;BA.debugLine="End Sub";
return "";
}
public static String  _edtloc_enterpressed() throws Exception{
 //BA.debugLineNum = 98;BA.debugLine="Sub edtLoc_EnterPressed";
 //BA.debugLineNum = 100;BA.debugLine="End Sub";
return "";
}
public static String  _edtmonth_enterpressed() throws Exception{
 //BA.debugLineNum = 114;BA.debugLine="Sub edtmonth_EnterPressed";
 //BA.debugLineNum = 116;BA.debugLine="End Sub";
return "";
}
public static String  _edtpass_enterpressed() throws Exception{
 //BA.debugLineNum = 102;BA.debugLine="Sub edtpass_EnterPressed";
 //BA.debugLineNum = 104;BA.debugLine="End Sub";
return "";
}
public static String  _edtyear_enterpressed() throws Exception{
 //BA.debugLineNum = 118;BA.debugLine="Sub edtyear_EnterPressed";
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
return "";
}
public static String  _errormeth(String _msg) throws Exception{
String _error = "";
String _title = "";
 //BA.debugLineNum = 121;BA.debugLine="Sub ErrorMeth(msg As String)";
 //BA.debugLineNum = 122;BA.debugLine="Dim error As String";
_error = "";
 //BA.debugLineNum = 123;BA.debugLine="Dim title As String=\"Error\"";
_title = "Error";
 //BA.debugLineNum = 124;BA.debugLine="Select msg";
switch (BA.switchObjectToInt(_msg,"loc","pass","passmatch","passEmpt","day","month","year","yearerror")) {
case 0: {
 //BA.debugLineNum = 126;BA.debugLine="error=\"Enter the correct country\"";
_error = "Enter the correct country";
 break; }
case 1: {
 //BA.debugLineNum = 128;BA.debugLine="error=\"Enter password of more than five charact";
_error = "Enter password of more than five characters ";
 break; }
case 2: {
 //BA.debugLineNum = 130;BA.debugLine="error=\"Passsword does not match\"";
_error = "Passsword does not match";
 break; }
case 3: {
 //BA.debugLineNum = 132;BA.debugLine="error=\"First set password\"";
_error = "First set password";
 break; }
case 4: {
 //BA.debugLineNum = 134;BA.debugLine="error=\"Enter the correct day\"";
_error = "Enter the correct day";
 break; }
case 5: {
 //BA.debugLineNum = 136;BA.debugLine="error=\"Enter the correct month\"";
_error = "Enter the correct month";
 break; }
case 6: {
 //BA.debugLineNum = 138;BA.debugLine="error=\"Applicant must be above 18 years\"";
_error = "Applicant must be above 18 years";
 break; }
case 7: {
 //BA.debugLineNum = 140;BA.debugLine="error=\"Applicant must be above 18 years\"";
_error = "Applicant must be above 18 years";
 break; }
}
;
 //BA.debugLineNum = 142;BA.debugLine="MsgboxAsync(error,title)";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence(_error),BA.ObjectToCharSequence(_title),processBA);
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 20;BA.debugLine="Private edtLoc As EditText";
mostCurrent._edtloc = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private edtpass As EditText";
mostCurrent._edtpass = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private edtcpass As EditText";
mostCurrent._edtcpass = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private edtday As EditText";
mostCurrent._edtday = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private edtmonth As EditText";
mostCurrent._edtmonth = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private edtyear As EditText";
mostCurrent._edtyear = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private Btnsubmit As Button";
mostCurrent._btnsubmit = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Dim btn As Int = Colors.ARGB(182,223,255,255)";
_btn = anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (182),(int) (223),(int) (255),(int) (255));
 //BA.debugLineNum = 11;BA.debugLine="Dim locates As String";
_locates = "";
 //BA.debugLineNum = 12;BA.debugLine="Dim pss As String";
_pss = "";
 //BA.debugLineNum = 13;BA.debugLine="Dim col As Int=Colors.ARGB(147,107,228,255)";
_col = anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (147),(int) (107),(int) (228),(int) (255));
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
}
