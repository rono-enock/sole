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

public class detailsoverview extends Activity implements B4AActivity{
	public static detailsoverview mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "com.KashLend.cleanpesa", "com.KashLend.cleanpesa.detailsoverview");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (detailsoverview).");
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
		activityBA = new BA(this, layout, processBA, "com.KashLend.cleanpesa", "com.KashLend.cleanpesa.detailsoverview");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.KashLend.cleanpesa.detailsoverview", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (detailsoverview) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (detailsoverview) Resume **");
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
		return detailsoverview.class;
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
            BA.LogInfo("** Activity (detailsoverview) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (detailsoverview) Pause event (activity is not paused). **");
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
            detailsoverview mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (detailsoverview) Resume **");
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
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtname = null;
public anywheresoftware.b4a.objects.LabelWrapper _label3 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtphone = null;
public anywheresoftware.b4a.objects.LabelWrapper _label4 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtcountry = null;
public anywheresoftware.b4a.objects.LabelWrapper _label5 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtkinname = null;
public anywheresoftware.b4a.objects.LabelWrapper _label6 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtkinphone = null;
public anywheresoftware.b4a.objects.LabelWrapper _label7 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtkincountry = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnfinish = null;
public com.KashLend.cleanpesa.main _main = null;
public com.KashLend.cleanpesa.acclogin _acclogin = null;
public com.KashLend.cleanpesa.apply _apply = null;
public com.KashLend.cleanpesa.applyconfirm _applyconfirm = null;
public com.KashLend.cleanpesa.claim _claim = null;
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
String _names = "";
String _phone = "";
anywheresoftware.b4a.objects.collections.List _list = null;
String _country = "";
anywheresoftware.b4a.objects.collections.List _listz = null;
String _kinnames = "";
String _kinphone = "";
String _kincountry = "";
anywheresoftware.b4a.objects.collections.List _lists = null;
 //BA.debugLineNum = 33;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 35;BA.debugLine="Activity.LoadLayout(\"OverviewPage\")";
mostCurrent._activity.LoadLayout("OverviewPage",mostCurrent.activityBA);
 //BA.debugLineNum = 36;BA.debugLine="Activity.Title=Vuka.title";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence(mostCurrent._vuka._title /*String*/ ));
 //BA.debugLineNum = 38;BA.debugLine="Dim PageColors As ColorDrawable";
_pagecolors = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 39;BA.debugLine="PageColors.Initialize(Vuka.B_Colors,0)";
_pagecolors.Initialize(mostCurrent._vuka._b_colors /*int*/ ,(int) (0));
 //BA.debugLineNum = 40;BA.debugLine="Panel1.Background=PageColors";
mostCurrent._panel1.setBackground((android.graphics.drawable.Drawable)(_pagecolors.getObject()));
 //BA.debugLineNum = 42;BA.debugLine="Label1.Text=\"Confirm that this are the correct de";
mostCurrent._label1.setText(BA.ObjectToCharSequence("Confirm that this are the correct details"));
 //BA.debugLineNum = 43;BA.debugLine="Label1.TextColor=Colors.Black";
mostCurrent._label1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 44;BA.debugLine="Label1.TextSize=16";
mostCurrent._label1.setTextSize((float) (16));
 //BA.debugLineNum = 46;BA.debugLine="Label2.Text=\"Your name:\"";
mostCurrent._label2.setText(BA.ObjectToCharSequence("Your name:"));
 //BA.debugLineNum = 47;BA.debugLine="Label2.TextColor=Colors.Black";
mostCurrent._label2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 48;BA.debugLine="Label2.TextSize=14";
mostCurrent._label2.setTextSize((float) (14));
 //BA.debugLineNum = 50;BA.debugLine="Label3.Text=\"Your phone number:\"";
mostCurrent._label3.setText(BA.ObjectToCharSequence("Your phone number:"));
 //BA.debugLineNum = 51;BA.debugLine="Label3.TextColor=Colors.Black";
mostCurrent._label3.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 52;BA.debugLine="Label3.TextSize=14";
mostCurrent._label3.setTextSize((float) (14));
 //BA.debugLineNum = 54;BA.debugLine="Label4.Text=\"Your country:\"";
mostCurrent._label4.setText(BA.ObjectToCharSequence("Your country:"));
 //BA.debugLineNum = 55;BA.debugLine="Label4.TextColor=Colors.Black";
mostCurrent._label4.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 56;BA.debugLine="Label4.TextSize=14";
mostCurrent._label4.setTextSize((float) (14));
 //BA.debugLineNum = 58;BA.debugLine="Label5.Text=\"Kin's name:\"";
mostCurrent._label5.setText(BA.ObjectToCharSequence("Kin's name:"));
 //BA.debugLineNum = 59;BA.debugLine="Label5.TextColor=Colors.Black";
mostCurrent._label5.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 60;BA.debugLine="Label5.TextSize=14";
mostCurrent._label5.setTextSize((float) (14));
 //BA.debugLineNum = 62;BA.debugLine="Label6.Text=\"Kin's phone number:\"";
mostCurrent._label6.setText(BA.ObjectToCharSequence("Kin's phone number:"));
 //BA.debugLineNum = 63;BA.debugLine="Label6.TextColor=Colors.Black";
mostCurrent._label6.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 64;BA.debugLine="Label6.TextSize=14";
mostCurrent._label6.setTextSize((float) (14));
 //BA.debugLineNum = 66;BA.debugLine="Label7.Text=\"Kin's Country:\"";
mostCurrent._label7.setText(BA.ObjectToCharSequence("Kin's Country:"));
 //BA.debugLineNum = 67;BA.debugLine="Label7.TextColor=Colors.Black";
mostCurrent._label7.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 68;BA.debugLine="Label7.TextSize=14";
mostCurrent._label7.setTextSize((float) (14));
 //BA.debugLineNum = 70;BA.debugLine="BtnFinish.Text=\"Continue\"";
mostCurrent._btnfinish.setText(BA.ObjectToCharSequence("Continue"));
 //BA.debugLineNum = 71;BA.debugLine="BtnFinish.TextColor=Colors.Black";
mostCurrent._btnfinish.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 72;BA.debugLine="BtnFinish.TextSize=15";
mostCurrent._btnfinish.setTextSize((float) (15));
 //BA.debugLineNum = 74;BA.debugLine="Dim names,phone As String";
_names = "";
_phone = "";
 //BA.debugLineNum = 75;BA.debugLine="Dim list As List";
_list = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 76;BA.debugLine="list.Initialize";
_list.Initialize();
 //BA.debugLineNum = 77;BA.debugLine="If File.Exists(File.DirInternal,\"data.dat\")Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data.dat")) { 
 //BA.debugLineNum = 78;BA.debugLine="list=File.ReadList(File.DirInternal,\"data.dat\")";
_list = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data.dat");
 //BA.debugLineNum = 79;BA.debugLine="names=list.Get(0)";
_names = BA.ObjectToString(_list.Get((int) (0)));
 //BA.debugLineNum = 80;BA.debugLine="phone=list.Get(1)";
_phone = BA.ObjectToString(_list.Get((int) (1)));
 };
 //BA.debugLineNum = 83;BA.debugLine="Dim country As String";
_country = "";
 //BA.debugLineNum = 84;BA.debugLine="Dim listz As List";
_listz = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 85;BA.debugLine="listz.Initialize";
_listz.Initialize();
 //BA.debugLineNum = 86;BA.debugLine="If File.Exists(File.DirInternal,\"data2.dat\")Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data2.dat")) { 
 //BA.debugLineNum = 87;BA.debugLine="listz=File.ReadList(File.DirInternal,\"data2.dat\"";
_listz = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data2.dat");
 //BA.debugLineNum = 88;BA.debugLine="country=listz.Get(0)";
_country = BA.ObjectToString(_listz.Get((int) (0)));
 };
 //BA.debugLineNum = 91;BA.debugLine="Dim kinnames,kinphone,kincountry As String";
_kinnames = "";
_kinphone = "";
_kincountry = "";
 //BA.debugLineNum = 92;BA.debugLine="Dim lists As List";
_lists = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 93;BA.debugLine="lists.Initialize";
_lists.Initialize();
 //BA.debugLineNum = 94;BA.debugLine="If File.Exists(File.DirInternal,\"data3.dat\")Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data3.dat")) { 
 //BA.debugLineNum = 95;BA.debugLine="lists=File.ReadList(File.DirInternal,\"data3.dat\"";
_lists = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data3.dat");
 //BA.debugLineNum = 96;BA.debugLine="kinnames=lists.Get(0)";
_kinnames = BA.ObjectToString(_lists.Get((int) (0)));
 //BA.debugLineNum = 97;BA.debugLine="kinphone=lists.Get(1)";
_kinphone = BA.ObjectToString(_lists.Get((int) (1)));
 //BA.debugLineNum = 98;BA.debugLine="kincountry=lists.Get(2)";
_kincountry = BA.ObjectToString(_lists.Get((int) (2)));
 };
 //BA.debugLineNum = 101;BA.debugLine="edtName.Text=names";
mostCurrent._edtname.setText(BA.ObjectToCharSequence(_names));
 //BA.debugLineNum = 102;BA.debugLine="edtPhone.Text=phone";
mostCurrent._edtphone.setText(BA.ObjectToCharSequence(_phone));
 //BA.debugLineNum = 103;BA.debugLine="edtCountry.Text=country";
mostCurrent._edtcountry.setText(BA.ObjectToCharSequence(_country));
 //BA.debugLineNum = 104;BA.debugLine="edtKinName.Text=kinnames";
mostCurrent._edtkinname.setText(BA.ObjectToCharSequence(_kinnames));
 //BA.debugLineNum = 105;BA.debugLine="edtKinPhone.Text=kinphone";
mostCurrent._edtkinphone.setText(BA.ObjectToCharSequence(_kinphone));
 //BA.debugLineNum = 106;BA.debugLine="edtKinCountry.Text=kincountry";
mostCurrent._edtkincountry.setText(BA.ObjectToCharSequence(_kincountry));
 //BA.debugLineNum = 108;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 114;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 116;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 110;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 112;BA.debugLine="End Sub";
return "";
}
public static String  _btnfinish_click() throws Exception{
 //BA.debugLineNum = 119;BA.debugLine="Sub BtnFinish_Click";
 //BA.debugLineNum = 120;BA.debugLine="StartActivity(AccLogin)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._acclogin.getObject()));
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private Label2 As Label";
mostCurrent._label2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private edtName As EditText";
mostCurrent._edtname = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private Label3 As Label";
mostCurrent._label3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private edtPhone As EditText";
mostCurrent._edtphone = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private Label4 As Label";
mostCurrent._label4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private edtCountry As EditText";
mostCurrent._edtcountry = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private Label5 As Label";
mostCurrent._label5 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private edtKinName As EditText";
mostCurrent._edtkinname = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private Label6 As Label";
mostCurrent._label6 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private edtKinPhone As EditText";
mostCurrent._edtkinphone = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private Label7 As Label";
mostCurrent._label7 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private edtKinCountry As EditText";
mostCurrent._edtkincountry = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private BtnFinish As Button";
mostCurrent._btnfinish = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
