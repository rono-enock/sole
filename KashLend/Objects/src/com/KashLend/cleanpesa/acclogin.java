package com.KashLend.cleanpesa;


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

public class acclogin extends Activity implements B4AActivity{
	public static acclogin mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "com.KashLend.cleanpesa", "com.KashLend.cleanpesa.acclogin");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (acclogin).");
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
		activityBA = new BA(this, layout, processBA, "com.KashLend.cleanpesa", "com.KashLend.cleanpesa.acclogin");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.KashLend.cleanpesa.acclogin", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (acclogin) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (acclogin) Resume **");
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
		return acclogin.class;
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
            BA.LogInfo("** Activity (acclogin) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (acclogin) Pause event (activity is not paused). **");
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
            acclogin mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (acclogin) Resume **");
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
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _b1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _b2 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _b3 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _b4 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _b5 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _b6 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _b7 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _b_x = null;
public anywheresoftware.b4a.objects.ButtonWrapper _b8 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _b9 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _b0 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _b_ok = null;
public anywheresoftware.b4a.objects.LabelWrapper _passwordlabel = null;
public com.KashLend.cleanpesa.main _main = null;
public com.KashLend.cleanpesa.apply _apply = null;
public com.KashLend.cleanpesa.applyconfirm _applyconfirm = null;
public com.KashLend.cleanpesa.claim _claim = null;
public com.KashLend.cleanpesa.detailsoverview _detailsoverview = null;
public com.KashLend.cleanpesa.directory _directory = null;
public com.KashLend.cleanpesa.educlev _educlev = null;
public com.KashLend.cleanpesa.id_number _id_number = null;
public com.KashLend.cleanpesa.kin _kin = null;
public com.KashLend.cleanpesa.location _location = null;
public com.KashLend.cleanpesa.name _name = null;
public com.KashLend.cleanpesa.rejectpage _rejectpage = null;
public com.KashLend.cleanpesa.reviews _reviews = null;
public com.KashLend.cleanpesa.saveconfirm _saveconfirm = null;
public com.KashLend.cleanpesa.savings _savings = null;
public com.KashLend.cleanpesa.starter _starter = null;
public com.KashLend.cleanpesa.vuka _vuka = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.objects.drawable.ColorDrawable _pagecolors = null;
 //BA.debugLineNum = 33;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 35;BA.debugLine="Activity.LoadLayout(\"AccLoginsPage\")";
mostCurrent._activity.LoadLayout("AccLoginsPage",mostCurrent.activityBA);
 //BA.debugLineNum = 36;BA.debugLine="Activity.Title=Vuka.title";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence(mostCurrent._vuka._title /*String*/ ));
 //BA.debugLineNum = 38;BA.debugLine="Dim PageColors As ColorDrawable";
_pagecolors = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 39;BA.debugLine="PageColors.Initialize(Vuka.B_Colors,0)";
_pagecolors.Initialize(mostCurrent._vuka._b_colors /*int*/ ,(int) (0));
 //BA.debugLineNum = 40;BA.debugLine="Panel1.Background=PageColors";
mostCurrent._panel1.setBackground((android.graphics.drawable.Drawable)(_pagecolors.getObject()));
 //BA.debugLineNum = 42;BA.debugLine="Label1.Text=\"Enter your password\"";
mostCurrent._label1.setText(BA.ObjectToCharSequence("Enter your password"));
 //BA.debugLineNum = 43;BA.debugLine="Label1.TextColor=Colors.Black";
mostCurrent._label1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 44;BA.debugLine="Label1.TextSize=18";
mostCurrent._label1.setTextSize((float) (18));
 //BA.debugLineNum = 46;BA.debugLine="PasswordLabel.Color=Colors.White";
mostCurrent._passwordlabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 47;BA.debugLine="Label1.TextColor=Colors.Black";
mostCurrent._label1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 48;BA.debugLine="Label1.TextSize=14";
mostCurrent._label1.setTextSize((float) (14));
 //BA.debugLineNum = 50;BA.debugLine="B_OK.Text=\"OK\"";
mostCurrent._b_ok.setText(BA.ObjectToCharSequence("OK"));
 //BA.debugLineNum = 51;BA.debugLine="B_OK.TextColor=Colors.Black";
mostCurrent._b_ok.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 52;BA.debugLine="B_OK.TextSize=15";
mostCurrent._b_ok.setTextSize((float) (15));
 //BA.debugLineNum = 54;BA.debugLine="B1.Text=\"1\"";
mostCurrent._b1.setText(BA.ObjectToCharSequence("1"));
 //BA.debugLineNum = 55;BA.debugLine="B1.TextColor=Colors.Black";
mostCurrent._b1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 56;BA.debugLine="B1.TextSize=15";
mostCurrent._b1.setTextSize((float) (15));
 //BA.debugLineNum = 58;BA.debugLine="B2.Text=\"2\"";
mostCurrent._b2.setText(BA.ObjectToCharSequence("2"));
 //BA.debugLineNum = 59;BA.debugLine="B2.TextColor=Colors.Black";
mostCurrent._b2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 60;BA.debugLine="B2.TextSize=15";
mostCurrent._b2.setTextSize((float) (15));
 //BA.debugLineNum = 62;BA.debugLine="B3.Text=\"3\"";
mostCurrent._b3.setText(BA.ObjectToCharSequence("3"));
 //BA.debugLineNum = 63;BA.debugLine="B3.TextColor=Colors.Black";
mostCurrent._b3.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 64;BA.debugLine="B3.TextSize=15";
mostCurrent._b3.setTextSize((float) (15));
 //BA.debugLineNum = 66;BA.debugLine="B4.Text=\"4\"";
mostCurrent._b4.setText(BA.ObjectToCharSequence("4"));
 //BA.debugLineNum = 67;BA.debugLine="B4.TextColor=Colors.Black";
mostCurrent._b4.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 68;BA.debugLine="B4.TextSize=15";
mostCurrent._b4.setTextSize((float) (15));
 //BA.debugLineNum = 70;BA.debugLine="B5.Text=\"5\"";
mostCurrent._b5.setText(BA.ObjectToCharSequence("5"));
 //BA.debugLineNum = 71;BA.debugLine="B5.TextColor=Colors.Black";
mostCurrent._b5.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 72;BA.debugLine="B5.TextSize=15";
mostCurrent._b5.setTextSize((float) (15));
 //BA.debugLineNum = 74;BA.debugLine="B6.Text=\"6\"";
mostCurrent._b6.setText(BA.ObjectToCharSequence("6"));
 //BA.debugLineNum = 75;BA.debugLine="B6.TextColor=Colors.Black";
mostCurrent._b6.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 76;BA.debugLine="B6.TextSize=15";
mostCurrent._b6.setTextSize((float) (15));
 //BA.debugLineNum = 78;BA.debugLine="B7.Text=\"7\"";
mostCurrent._b7.setText(BA.ObjectToCharSequence("7"));
 //BA.debugLineNum = 79;BA.debugLine="B7.TextColor=Colors.Black";
mostCurrent._b7.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 80;BA.debugLine="B7.TextSize=15";
mostCurrent._b7.setTextSize((float) (15));
 //BA.debugLineNum = 82;BA.debugLine="B8.Text=\"8\"";
mostCurrent._b8.setText(BA.ObjectToCharSequence("8"));
 //BA.debugLineNum = 83;BA.debugLine="B8.TextColor=Colors.Black";
mostCurrent._b8.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 84;BA.debugLine="B8.TextSize=15";
mostCurrent._b8.setTextSize((float) (15));
 //BA.debugLineNum = 86;BA.debugLine="B9.Text=\"9\"";
mostCurrent._b9.setText(BA.ObjectToCharSequence("9"));
 //BA.debugLineNum = 87;BA.debugLine="B9.TextColor=Colors.Black";
mostCurrent._b9.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 88;BA.debugLine="B9.TextSize=15";
mostCurrent._b9.setTextSize((float) (15));
 //BA.debugLineNum = 90;BA.debugLine="B0.Text=\"0\"";
mostCurrent._b0.setText(BA.ObjectToCharSequence("0"));
 //BA.debugLineNum = 91;BA.debugLine="B0.TextColor=Colors.Black";
mostCurrent._b0.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 92;BA.debugLine="B0.TextSize=15";
mostCurrent._b0.setTextSize((float) (15));
 //BA.debugLineNum = 94;BA.debugLine="B_X.Text=\"DEL\"";
mostCurrent._b_x.setText(BA.ObjectToCharSequence("DEL"));
 //BA.debugLineNum = 95;BA.debugLine="B_X.TextColor=Colors.Black";
mostCurrent._b_x.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 96;BA.debugLine="B_X.TextSize=15";
mostCurrent._b_x.setTextSize((float) (15));
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 104;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 100;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return "";
}
public static String  _b_ok_click() throws Exception{
String _password = "";
anywheresoftware.b4a.objects.collections.List _list = null;
 //BA.debugLineNum = 153;BA.debugLine="Sub B_OK_Click";
 //BA.debugLineNum = 155;BA.debugLine="Dim password As String";
_password = "";
 //BA.debugLineNum = 156;BA.debugLine="Dim list As List";
_list = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 157;BA.debugLine="list.Initialize";
_list.Initialize();
 //BA.debugLineNum = 158;BA.debugLine="If File.Exists(File.DirInternal,\"data1.dat\")Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data1.dat")) { 
 //BA.debugLineNum = 159;BA.debugLine="list=File.ReadList(File.DirInternal,\"data1.dat\")";
_list = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data1.dat");
 //BA.debugLineNum = 160;BA.debugLine="password=list.Get(0)";
_password = BA.ObjectToString(_list.Get((int) (0)));
 };
 //BA.debugLineNum = 163;BA.debugLine="If PasswordLabel.Text=password Then";
if ((mostCurrent._passwordlabel.getText()).equals(_password)) { 
 //BA.debugLineNum = 164;BA.debugLine="If File.Exists(File.DirInternal,\"data4.dat\")Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data4.dat")) { 
 //BA.debugLineNum = 165;BA.debugLine="StartActivity(Reviews)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._reviews.getObject()));
 }else {
 //BA.debugLineNum = 167;BA.debugLine="StartActivity(Directory)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._directory.getObject()));
 };
 }else {
 //BA.debugLineNum = 171;BA.debugLine="MsgboxAsync(\"Enter the correct password\",\"Error\"";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Enter the correct password"),BA.ObjectToCharSequence("Error"),processBA);
 };
 //BA.debugLineNum = 174;BA.debugLine="End Sub";
return "";
}
public static String  _b_x_click() throws Exception{
 //BA.debugLineNum = 137;BA.debugLine="Sub B_X_Click";
 //BA.debugLineNum = 138;BA.debugLine="PasswordLabel.Text=\"\"";
mostCurrent._passwordlabel.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public static String  _b0_click() throws Exception{
 //BA.debugLineNum = 149;BA.debugLine="Sub B0_Click";
 //BA.debugLineNum = 150;BA.debugLine="PasswordLabel.Text=PasswordLabel.Text& B0.Text";
mostCurrent._passwordlabel.setText(BA.ObjectToCharSequence(mostCurrent._passwordlabel.getText()+mostCurrent._b0.getText()));
 //BA.debugLineNum = 151;BA.debugLine="End Sub";
return "";
}
public static String  _b1_click() throws Exception{
 //BA.debugLineNum = 109;BA.debugLine="Sub B1_Click";
 //BA.debugLineNum = 110;BA.debugLine="PasswordLabel.Text=PasswordLabel.Text& B1.Text";
mostCurrent._passwordlabel.setText(BA.ObjectToCharSequence(mostCurrent._passwordlabel.getText()+mostCurrent._b1.getText()));
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public static String  _b2_click() throws Exception{
 //BA.debugLineNum = 113;BA.debugLine="Sub B2_Click";
 //BA.debugLineNum = 114;BA.debugLine="PasswordLabel.Text=PasswordLabel.Text& B2.Text";
mostCurrent._passwordlabel.setText(BA.ObjectToCharSequence(mostCurrent._passwordlabel.getText()+mostCurrent._b2.getText()));
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return "";
}
public static String  _b3_click() throws Exception{
 //BA.debugLineNum = 117;BA.debugLine="Sub B3_Click";
 //BA.debugLineNum = 118;BA.debugLine="PasswordLabel.Text=PasswordLabel.Text& B3.Text";
mostCurrent._passwordlabel.setText(BA.ObjectToCharSequence(mostCurrent._passwordlabel.getText()+mostCurrent._b3.getText()));
 //BA.debugLineNum = 119;BA.debugLine="End Sub";
return "";
}
public static String  _b4_click() throws Exception{
 //BA.debugLineNum = 121;BA.debugLine="Sub B4_Click";
 //BA.debugLineNum = 122;BA.debugLine="PasswordLabel.Text=PasswordLabel.Text& B4.Text";
mostCurrent._passwordlabel.setText(BA.ObjectToCharSequence(mostCurrent._passwordlabel.getText()+mostCurrent._b4.getText()));
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
return "";
}
public static String  _b5_click() throws Exception{
 //BA.debugLineNum = 125;BA.debugLine="Sub B5_Click";
 //BA.debugLineNum = 126;BA.debugLine="PasswordLabel.Text=PasswordLabel.Text& B5.Text";
mostCurrent._passwordlabel.setText(BA.ObjectToCharSequence(mostCurrent._passwordlabel.getText()+mostCurrent._b5.getText()));
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public static String  _b6_click() throws Exception{
 //BA.debugLineNum = 129;BA.debugLine="Sub B6_Click";
 //BA.debugLineNum = 130;BA.debugLine="PasswordLabel.Text=PasswordLabel.Text& B6.Text";
mostCurrent._passwordlabel.setText(BA.ObjectToCharSequence(mostCurrent._passwordlabel.getText()+mostCurrent._b6.getText()));
 //BA.debugLineNum = 131;BA.debugLine="End Sub";
return "";
}
public static String  _b7_click() throws Exception{
 //BA.debugLineNum = 133;BA.debugLine="Sub B7_Click";
 //BA.debugLineNum = 134;BA.debugLine="PasswordLabel.Text=PasswordLabel.Text& B7.Text";
mostCurrent._passwordlabel.setText(BA.ObjectToCharSequence(mostCurrent._passwordlabel.getText()+mostCurrent._b7.getText()));
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
return "";
}
public static String  _b8_click() throws Exception{
 //BA.debugLineNum = 141;BA.debugLine="Sub B8_Click";
 //BA.debugLineNum = 142;BA.debugLine="PasswordLabel.Text=PasswordLabel.Text& B8.Text";
mostCurrent._passwordlabel.setText(BA.ObjectToCharSequence(mostCurrent._passwordlabel.getText()+mostCurrent._b8.getText()));
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
public static String  _b9_click() throws Exception{
 //BA.debugLineNum = 145;BA.debugLine="Sub B9_Click";
 //BA.debugLineNum = 146;BA.debugLine="PasswordLabel.Text=PasswordLabel.Text& B9.Text";
mostCurrent._passwordlabel.setText(BA.ObjectToCharSequence(mostCurrent._passwordlabel.getText()+mostCurrent._b9.getText()));
 //BA.debugLineNum = 147;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private B1 As Button";
mostCurrent._b1 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private B2 As Button";
mostCurrent._b2 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private B3 As Button";
mostCurrent._b3 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private B4 As Button";
mostCurrent._b4 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private B5 As Button";
mostCurrent._b5 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private B6 As Button";
mostCurrent._b6 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private B7 As Button";
mostCurrent._b7 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private B_X As Button";
mostCurrent._b_x = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private B8 As Button";
mostCurrent._b8 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private B9 As Button";
mostCurrent._b9 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private B0 As Button";
mostCurrent._b0 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private B_OK As Button";
mostCurrent._b_ok = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private PasswordLabel As Label";
mostCurrent._passwordlabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
