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

public class acccreate extends Activity implements B4AActivity{
	public static acccreate mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "com.vukapesa.cleandeal", "com.vukapesa.cleandeal.acccreate");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (acccreate).");
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
		activityBA = new BA(this, layout, processBA, "com.vukapesa.cleandeal", "com.vukapesa.cleandeal.acccreate");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.vukapesa.cleandeal.acccreate", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (acccreate) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (acccreate) Resume **");
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
		return acccreate.class;
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
            BA.LogInfo("** Activity (acccreate) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (acccreate) Pause event (activity is not paused). **");
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
            acccreate mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (acccreate) Resume **");
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
public static String _naming = "";
public static String _phones = "";
public static String _namings = "";
public anywheresoftware.b4a.objects.EditTextWrapper _edtname = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtmail = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtphone = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtid = null;
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
 //BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"AccCreatePage1\")";
mostCurrent._activity.LoadLayout("AccCreatePage1",mostCurrent.activityBA);
 //BA.debugLineNum = 42;BA.debugLine="Dim page As ColorDrawable";
_page = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 43;BA.debugLine="page.Initialize(Inuka.pages,0)";
_page.Initialize(mostCurrent._inuka._pages /*int*/ ,(int) (0));
 //BA.debugLineNum = 44;BA.debugLine="Panel1.Background=page";
mostCurrent._panel1.setBackground((android.graphics.drawable.Drawable)(_page.getObject()));
 //BA.debugLineNum = 47;BA.debugLine="BtnNext.Text=\"Next\"";
mostCurrent._btnnext.setText(BA.ObjectToCharSequence("Next"));
 //BA.debugLineNum = 48;BA.debugLine="BtnNext.TextColor=Colors.Black";
mostCurrent._btnnext.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 49;BA.debugLine="BtnNext.TextSize=15";
mostCurrent._btnnext.setTextSize((float) (15));
 //BA.debugLineNum = 51;BA.debugLine="edtPhone.InputType=edtPhone.INPUT_TYPE_PHONE";
mostCurrent._edtphone.setInputType(mostCurrent._edtphone.INPUT_TYPE_PHONE);
 //BA.debugLineNum = 52;BA.debugLine="edtID.InputType=edtID.INPUT_TYPE_PHONE";
mostCurrent._edtid.setInputType(mostCurrent._edtid.INPUT_TYPE_PHONE);
 //BA.debugLineNum = 54;BA.debugLine="edtName.Hint=\"Full Names\"";
mostCurrent._edtname.setHint("Full Names");
 //BA.debugLineNum = 55;BA.debugLine="edtName.TextColor=Colors.Black";
mostCurrent._edtname.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 56;BA.debugLine="edtName.TextSize=14";
mostCurrent._edtname.setTextSize((float) (14));
 //BA.debugLineNum = 57;BA.debugLine="edtName.HintColor=btn";
mostCurrent._edtname.setHintColor(_btn);
 //BA.debugLineNum = 59;BA.debugLine="edtMail.Hint=\"E-mail Address\"";
mostCurrent._edtmail.setHint("E-mail Address");
 //BA.debugLineNum = 60;BA.debugLine="edtMail.TextColor=Colors.Black";
mostCurrent._edtmail.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 61;BA.debugLine="edtMail.TextSize=14";
mostCurrent._edtmail.setTextSize((float) (14));
 //BA.debugLineNum = 62;BA.debugLine="edtMail.HintColor=btn";
mostCurrent._edtmail.setHintColor(_btn);
 //BA.debugLineNum = 64;BA.debugLine="edtPhone.Hint=\"Phone number\"";
mostCurrent._edtphone.setHint("Phone number");
 //BA.debugLineNum = 65;BA.debugLine="edtPhone.TextColor=Colors.Black";
mostCurrent._edtphone.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 66;BA.debugLine="edtPhone.TextSize=14";
mostCurrent._edtphone.setTextSize((float) (14));
 //BA.debugLineNum = 67;BA.debugLine="edtPhone.HintColor=btn";
mostCurrent._edtphone.setHintColor(_btn);
 //BA.debugLineNum = 69;BA.debugLine="edtID.Hint=\"ID Number\"";
mostCurrent._edtid.setHint("ID Number");
 //BA.debugLineNum = 70;BA.debugLine="edtID.TextColor=Colors.Black";
mostCurrent._edtid.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 71;BA.debugLine="edtID.TextSize=14";
mostCurrent._edtid.setTextSize((float) (14));
 //BA.debugLineNum = 72;BA.debugLine="edtID.HintColor=btn";
mostCurrent._edtid.setHintColor(_btn);
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 81;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 83;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 77;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public static String  _btnnext_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _list1 = null;
String _nem = "";
String _nam = "";
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _match = null;
 //BA.debugLineNum = 100;BA.debugLine="Sub BtnNext_Click";
 //BA.debugLineNum = 102;BA.debugLine="naming=edtName.Text";
_naming = mostCurrent._edtname.getText();
 //BA.debugLineNum = 103;BA.debugLine="phones=edtPhone.Text";
_phones = mostCurrent._edtphone.getText();
 //BA.debugLineNum = 104;BA.debugLine="Dim list1 As List";
_list1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 105;BA.debugLine="list1.Initialize";
_list1.Initialize();
 //BA.debugLineNum = 106;BA.debugLine="list1.Add(edtName.Text)";
_list1.Add((Object)(mostCurrent._edtname.getText()));
 //BA.debugLineNum = 108;BA.debugLine="list1.Add(edtPhone.Text)";
_list1.Add((Object)(mostCurrent._edtphone.getText()));
 //BA.debugLineNum = 109;BA.debugLine="File.WriteList(File.DirInternal,\"data.dat\",list1)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data.dat",_list1);
 //BA.debugLineNum = 112;BA.debugLine="Dim nem,nam As String";
_nem = "";
_nam = "";
 //BA.debugLineNum = 113;BA.debugLine="Dim match As Matcher";
_match = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
 //BA.debugLineNum = 114;BA.debugLine="nem=edtName.Text";
_nem = mostCurrent._edtname.getText();
 //BA.debugLineNum = 115;BA.debugLine="match=Regex.Matcher(\"\\d\",nem)";
_match = anywheresoftware.b4a.keywords.Common.Regex.Matcher("\\d",_nem);
 //BA.debugLineNum = 116;BA.debugLine="If(nem.IndexOf(\" \")= -1) Or (match.Find) Or (nem.";
if ((_nem.indexOf(" ")==-1) || (_match.Find()) || (_nem.length()<5)) { 
 //BA.debugLineNum = 117;BA.debugLine="Displayerror(\"name\")";
_displayerror("name");
 //BA.debugLineNum = 118;BA.debugLine="edtName.RequestFocus";
mostCurrent._edtname.RequestFocus();
 //BA.debugLineNum = 119;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 122;BA.debugLine="nem = edtMail.Text.Trim";
_nem = mostCurrent._edtmail.getText().trim();
 //BA.debugLineNum = 123;BA.debugLine="If Not(Regex.IsMatch(\"\\S+@\\S+\\.\\S+\",nem)) Then";
if (anywheresoftware.b4a.keywords.Common.Not(anywheresoftware.b4a.keywords.Common.Regex.IsMatch("\\S+@\\S+\\.\\S+",_nem))) { 
 //BA.debugLineNum = 124;BA.debugLine="Displayerror(\"email\")";
_displayerror("email");
 //BA.debugLineNum = 125;BA.debugLine="edtMail.RequestFocus";
mostCurrent._edtmail.RequestFocus();
 //BA.debugLineNum = 126;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 129;BA.debugLine="nem=edtID.Text";
_nem = mostCurrent._edtid.getText();
 //BA.debugLineNum = 130;BA.debugLine="If Not(Regex.IsMatch(\"\\d+\",nem)) Or (nem.Length <";
if (anywheresoftware.b4a.keywords.Common.Not(anywheresoftware.b4a.keywords.Common.Regex.IsMatch("\\d+",_nem)) || (_nem.length()<7) || (_nem.length()>8)) { 
 //BA.debugLineNum = 131;BA.debugLine="Displayerror(\"ID\")";
_displayerror("ID");
 //BA.debugLineNum = 132;BA.debugLine="edtID.RequestFocus";
mostCurrent._edtid.RequestFocus();
 //BA.debugLineNum = 133;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 138;BA.debugLine="nem=edtPhone.Text";
_nem = mostCurrent._edtphone.getText();
 //BA.debugLineNum = 139;BA.debugLine="If Not(Regex.IsMatch(\"\\d+\",nem)) Or (nem.Length <";
if (anywheresoftware.b4a.keywords.Common.Not(anywheresoftware.b4a.keywords.Common.Regex.IsMatch("\\d+",_nem)) || (_nem.length()!=10)) { 
 //BA.debugLineNum = 140;BA.debugLine="Displayerror(\"phone\")";
_displayerror("phone");
 //BA.debugLineNum = 141;BA.debugLine="edtPhone.RequestFocus";
mostCurrent._edtphone.RequestFocus();
 //BA.debugLineNum = 142;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 150;BA.debugLine="StartActivity(AccCreate2)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._acccreate2.getObject()));
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return "";
}
public static String  _displayerror(String _msg) throws Exception{
String _error = "";
String _title = "";
 //BA.debugLineNum = 85;BA.debugLine="Sub Displayerror(msg As String)";
 //BA.debugLineNum = 86;BA.debugLine="Dim error As String";
_error = "";
 //BA.debugLineNum = 87;BA.debugLine="Dim title As String=\"Error\"";
_title = "Error";
 //BA.debugLineNum = 88;BA.debugLine="Select msg";
switch (BA.switchObjectToInt(_msg,"name","ID","phone","email")) {
case 0: {
 //BA.debugLineNum = 90;BA.debugLine="error=\"Enter correct names\"";
_error = "Enter correct names";
 break; }
case 1: {
 //BA.debugLineNum = 92;BA.debugLine="error=\"Enter correct National ID\"";
_error = "Enter correct National ID";
 break; }
case 2: {
 //BA.debugLineNum = 94;BA.debugLine="error=\"Enter a valid phone number\"";
_error = "Enter a valid phone number";
 break; }
case 3: {
 //BA.debugLineNum = 96;BA.debugLine="error=\"Enter a valid e-mail\"";
_error = "Enter a valid e-mail";
 break; }
}
;
 //BA.debugLineNum = 98;BA.debugLine="MsgboxAsync(error, title)";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence(_error),BA.ObjectToCharSequence(_title),processBA);
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 21;BA.debugLine="Private edtName As EditText";
mostCurrent._edtname = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private edtMail As EditText";
mostCurrent._edtmail = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private edtPhone As EditText";
mostCurrent._edtphone = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private edtID As EditText";
mostCurrent._edtid = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private BtnNext As Button";
mostCurrent._btnnext = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public static String  _inter_onaddismissed() throws Exception{
 //BA.debugLineNum = 155;BA.debugLine="Sub Inter_onAdDismissed";
 //BA.debugLineNum = 156;BA.debugLine="StartActivity(AccCreate2)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._acccreate2.getObject()));
 //BA.debugLineNum = 157;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Dim btn As Int = Colors.ARGB(182,223,255,255)";
_btn = anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (182),(int) (223),(int) (255),(int) (255));
 //BA.debugLineNum = 11;BA.debugLine="Dim naming As String";
_naming = "";
 //BA.debugLineNum = 12;BA.debugLine="Dim phones As String";
_phones = "";
 //BA.debugLineNum = 13;BA.debugLine="Dim namings As String";
_namings = "";
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return "";
}
}
