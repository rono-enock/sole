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

public class reviews extends Activity implements B4AActivity{
	public static reviews mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "com.KashLend.cleanpesa", "com.KashLend.cleanpesa.reviews");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (reviews).");
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
		activityBA = new BA(this, layout, processBA, "com.KashLend.cleanpesa", "com.KashLend.cleanpesa.reviews");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.KashLend.cleanpesa.reviews", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (reviews) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (reviews) Resume **");
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
		return reviews.class;
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
            BA.LogInfo("** Activity (reviews) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (reviews) Pause event (activity is not paused). **");
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
            reviews mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (reviews) Resume **");
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
public anywheresoftware.b4a.objects.LabelWrapper _labelstatusdesc = null;
public anywheresoftware.b4a.objects.LabelWrapper _labelstatus = null;
public anywheresoftware.b4a.objects.LabelWrapper _labeldescdesc = null;
public anywheresoftware.b4a.objects.LabelWrapper _labeldesc = null;
public anywheresoftware.b4a.objects.LabelWrapper _label5 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnreapply = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnclaim = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public com.KashLend.cleanpesa.main _main = null;
public com.KashLend.cleanpesa.acclogin _acclogin = null;
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
anywheresoftware.b4a.objects.collections.List _listing = null;
String _names = "";
String _phone = "";
anywheresoftware.b4a.objects.collections.List _listings = null;
String _phone_no = "";
anywheresoftware.b4a.objects.collections.List _listeds = null;
String _r_amount = "";
String _r_period = "";
anywheresoftware.b4a.objects.collections.List _listed = null;
String _amount = "";
String _period = "";
 //BA.debugLineNum = 26;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 28;BA.debugLine="Activity.LoadLayout(\"ReviewPage\")";
mostCurrent._activity.LoadLayout("ReviewPage",mostCurrent.activityBA);
 //BA.debugLineNum = 29;BA.debugLine="Activity.Title=Vuka.title";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence(mostCurrent._vuka._title /*String*/ ));
 //BA.debugLineNum = 31;BA.debugLine="Dim PageColors As ColorDrawable";
_pagecolors = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 32;BA.debugLine="PageColors.Initialize(Vuka.B_Colors,0)";
_pagecolors.Initialize(mostCurrent._vuka._b_colors /*int*/ ,(int) (0));
 //BA.debugLineNum = 33;BA.debugLine="Panel1.Background=PageColors";
mostCurrent._panel1.setBackground((android.graphics.drawable.Drawable)(_pagecolors.getObject()));
 //BA.debugLineNum = 35;BA.debugLine="BtnClaim.Text=\"Claim Savings\"";
mostCurrent._btnclaim.setText(BA.ObjectToCharSequence("Claim Savings"));
 //BA.debugLineNum = 36;BA.debugLine="BtnClaim.TextColor=Colors.Black";
mostCurrent._btnclaim.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 37;BA.debugLine="BtnClaim.TextSize=15";
mostCurrent._btnclaim.setTextSize((float) (15));
 //BA.debugLineNum = 39;BA.debugLine="BtnReapply.Text=\"Reapply\"";
mostCurrent._btnreapply.setText(BA.ObjectToCharSequence("Reapply"));
 //BA.debugLineNum = 40;BA.debugLine="BtnReapply.TextColor=Colors.Black";
mostCurrent._btnreapply.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 41;BA.debugLine="BtnReapply.TextSize=15";
mostCurrent._btnreapply.setTextSize((float) (15));
 //BA.debugLineNum = 42;BA.debugLine="BtnReapply.Visible=False";
mostCurrent._btnreapply.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 44;BA.debugLine="Dim listing As List";
_listing = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 45;BA.debugLine="Dim names,phone As String";
_names = "";
_phone = "";
 //BA.debugLineNum = 46;BA.debugLine="If File.Exists(File.DirInternal,\"data.dat\")Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data.dat")) { 
 //BA.debugLineNum = 47;BA.debugLine="listing=File.ReadList(File.DirInternal,\"data.dat\"";
_listing = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data.dat");
 //BA.debugLineNum = 48;BA.debugLine="names=listing.Get(0)";
_names = BA.ObjectToString(_listing.Get((int) (0)));
 //BA.debugLineNum = 49;BA.debugLine="phone=listing.Get(1)";
_phone = BA.ObjectToString(_listing.Get((int) (1)));
 };
 //BA.debugLineNum = 52;BA.debugLine="Dim listings As List";
_listings = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 53;BA.debugLine="Dim phone_no As String";
_phone_no = "";
 //BA.debugLineNum = 54;BA.debugLine="listings.Initialize";
_listings.Initialize();
 //BA.debugLineNum = 55;BA.debugLine="If File.Exists(File.DirInternal,\"data6.dat\") Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data6.dat")) { 
 //BA.debugLineNum = 56;BA.debugLine="listings=File.ReadList(File.DirInternal,\"data6.d";
_listings = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data6.dat");
 //BA.debugLineNum = 57;BA.debugLine="phone_no=listings.Get(0)";
_phone_no = BA.ObjectToString(_listings.Get((int) (0)));
 //BA.debugLineNum = 58;BA.debugLine="LabelStatusDesc.Text=\"Claim Status:\"";
mostCurrent._labelstatusdesc.setText(BA.ObjectToCharSequence("Claim Status:"));
 //BA.debugLineNum = 59;BA.debugLine="LabelStatusDesc.TextColor=Colors.Black";
mostCurrent._labelstatusdesc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 60;BA.debugLine="LabelStatusDesc.TextSize=20";
mostCurrent._labelstatusdesc.setTextSize((float) (20));
 //BA.debugLineNum = 62;BA.debugLine="LabelStatus.Text=$\" Refund of KShs.${Starter.sav";
mostCurrent._labelstatus.setText(BA.ObjectToCharSequence((" Refund of KShs."+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._starter._saving /*int*/ ))+" is in review")));
 //BA.debugLineNum = 63;BA.debugLine="LabelStatus.TextColor=Colors.Black";
mostCurrent._labelstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 64;BA.debugLine="LabelStatus.TextSize=14";
mostCurrent._labelstatus.setTextSize((float) (14));
 //BA.debugLineNum = 66;BA.debugLine="LabelDescDesc.Text=$\"Account to credit:\"$";
mostCurrent._labeldescdesc.setText(BA.ObjectToCharSequence(("Account to credit:")));
 //BA.debugLineNum = 67;BA.debugLine="LabelDescDesc.TextColor=Colors.Black";
mostCurrent._labeldescdesc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 68;BA.debugLine="LabelDescDesc.TextSize=20";
mostCurrent._labeldescdesc.setTextSize((float) (20));
 //BA.debugLineNum = 70;BA.debugLine="LabelDesc.Text=phone_no";
mostCurrent._labeldesc.setText(BA.ObjectToCharSequence(_phone_no));
 //BA.debugLineNum = 71;BA.debugLine="LabelDesc.TextColor=Colors.Black";
mostCurrent._labeldesc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 72;BA.debugLine="LabelDesc.TextSize=14";
mostCurrent._labeldesc.setTextSize((float) (14));
 //BA.debugLineNum = 74;BA.debugLine="Label5.TextSize=15";
mostCurrent._label5.setTextSize((float) (15));
 //BA.debugLineNum = 75;BA.debugLine="Label5.Text=$\"Dear \"$&names&$\",your loan process";
mostCurrent._label5.setText(BA.ObjectToCharSequence(("Dear ")+_names+(",your loan processing was altered.Kindly wait as we process your savings refund.\n"+"We're sorry for any incovinience caused.")));
 //BA.debugLineNum = 77;BA.debugLine="Label5.TextColor=Colors.Black";
mostCurrent._label5.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 79;BA.debugLine="Dim listeds As List";
_listeds = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 80;BA.debugLine="Dim R_amount,R_period As String";
_r_amount = "";
_r_period = "";
 }else if(anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data5.dat")) { 
 //BA.debugLineNum = 82;BA.debugLine="listeds=File.ReadList(File.DirInternal,\"data5";
_listeds = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data5.dat");
 //BA.debugLineNum = 83;BA.debugLine="R_amount=listeds.Get(1)";
_r_amount = BA.ObjectToString(_listeds.Get((int) (1)));
 //BA.debugLineNum = 84;BA.debugLine="R_period=listeds.Get(2)";
_r_period = BA.ObjectToString(_listeds.Get((int) (2)));
 //BA.debugLineNum = 86;BA.debugLine="LabelStatusDesc.Text=\"Loan Status:\"";
mostCurrent._labelstatusdesc.setText(BA.ObjectToCharSequence("Loan Status:"));
 //BA.debugLineNum = 87;BA.debugLine="LabelStatusDesc.TextColor=Colors.Black";
mostCurrent._labelstatusdesc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 88;BA.debugLine="LabelStatusDesc.TextSize=20";
mostCurrent._labelstatusdesc.setTextSize((float) (20));
 //BA.debugLineNum = 90;BA.debugLine="LabelStatus.Text=$\"KShs.\"$&R_amount&$\" on review";
mostCurrent._labelstatus.setText(BA.ObjectToCharSequence(("KShs.")+_r_amount+(" on review")));
 //BA.debugLineNum = 91;BA.debugLine="LabelStatus.TextColor=Colors.Black";
mostCurrent._labelstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 92;BA.debugLine="LabelStatus.TextSize=14";
mostCurrent._labelstatus.setTextSize((float) (14));
 //BA.debugLineNum = 94;BA.debugLine="LabelDescDesc.Text=$\"Due in:\"$";
mostCurrent._labeldescdesc.setText(BA.ObjectToCharSequence(("Due in:")));
 //BA.debugLineNum = 95;BA.debugLine="LabelDescDesc.TextColor=Colors.Black";
mostCurrent._labeldescdesc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 96;BA.debugLine="LabelDescDesc.TextSize=20";
mostCurrent._labeldescdesc.setTextSize((float) (20));
 //BA.debugLineNum = 98;BA.debugLine="LabelDesc.Text=R_period";
mostCurrent._labeldesc.setText(BA.ObjectToCharSequence(_r_period));
 //BA.debugLineNum = 99;BA.debugLine="LabelDesc.TextColor=Colors.Black";
mostCurrent._labeldesc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 100;BA.debugLine="LabelDesc.TextSize=14";
mostCurrent._labeldesc.setTextSize((float) (14));
 //BA.debugLineNum = 102;BA.debugLine="Label5.TextSize=15";
mostCurrent._label5.setTextSize((float) (15));
 //BA.debugLineNum = 103;BA.debugLine="Label5.Text=$\"Dear \"$&names&$\" your loan request";
mostCurrent._label5.setText(BA.ObjectToCharSequence(("Dear ")+_names+(" your loan request is in review and will be processed as soon as possible.\n"+"Sorry for any inconviniences caused.")));
 //BA.debugLineNum = 105;BA.debugLine="Label5.TextColor=Colors.Black";
mostCurrent._label5.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 107;BA.debugLine="Dim listed As List";
_listed = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 108;BA.debugLine="Dim amount,period As String";
_amount = "";
_period = "";
 }else if(anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data4.dat")) { 
 //BA.debugLineNum = 110;BA.debugLine="listed=File.ReadList(File.DirInternal,\"data4.dat";
_listed = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data4.dat");
 //BA.debugLineNum = 111;BA.debugLine="amount=listed.Get(0)";
_amount = BA.ObjectToString(_listed.Get((int) (0)));
 //BA.debugLineNum = 112;BA.debugLine="period=listed.Get(1)";
_period = BA.ObjectToString(_listed.Get((int) (1)));
 //BA.debugLineNum = 114;BA.debugLine="LabelStatusDesc.Text=\"Loan Status:\"";
mostCurrent._labelstatusdesc.setText(BA.ObjectToCharSequence("Loan Status:"));
 //BA.debugLineNum = 115;BA.debugLine="LabelStatusDesc.TextColor=Colors.Black";
mostCurrent._labelstatusdesc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 116;BA.debugLine="LabelStatusDesc.TextSize=20";
mostCurrent._labelstatusdesc.setTextSize((float) (20));
 //BA.debugLineNum = 118;BA.debugLine="LabelStatus.Text=$\"KShs.\"$&amount&$\" on review\"$";
mostCurrent._labelstatus.setText(BA.ObjectToCharSequence(("KShs.")+_amount+(" on review")));
 //BA.debugLineNum = 119;BA.debugLine="LabelStatus.TextColor=Colors.Black";
mostCurrent._labelstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 120;BA.debugLine="LabelStatus.TextSize=14";
mostCurrent._labelstatus.setTextSize((float) (14));
 //BA.debugLineNum = 122;BA.debugLine="LabelDescDesc.Text=$\"Due in:\"$";
mostCurrent._labeldescdesc.setText(BA.ObjectToCharSequence(("Due in:")));
 //BA.debugLineNum = 123;BA.debugLine="LabelDescDesc.TextColor=Colors.Black";
mostCurrent._labeldescdesc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 124;BA.debugLine="LabelDescDesc.TextSize=20";
mostCurrent._labeldescdesc.setTextSize((float) (20));
 //BA.debugLineNum = 126;BA.debugLine="LabelDesc.Text=period";
mostCurrent._labeldesc.setText(BA.ObjectToCharSequence(_period));
 //BA.debugLineNum = 127;BA.debugLine="LabelDesc.TextColor=Colors.Black";
mostCurrent._labeldesc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 128;BA.debugLine="LabelDesc.TextSize=14";
mostCurrent._labeldesc.setTextSize((float) (14));
 //BA.debugLineNum = 130;BA.debugLine="Label5.TextSize=15";
mostCurrent._label5.setTextSize((float) (15));
 //BA.debugLineNum = 131;BA.debugLine="Label5.Text=$\"Dear \"$&names&$\" your loan request";
mostCurrent._label5.setText(BA.ObjectToCharSequence(("Dear ")+_names+(" your loan request is in review and will be processed as soon as possible.\n"+"Sorry for any inconviniences caused.")));
 //BA.debugLineNum = 133;BA.debugLine="Label5.TextColor=Colors.Black";
mostCurrent._label5.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 }else {
 //BA.debugLineNum = 135;BA.debugLine="LabelStatusDesc.Text=\"Loan Status:\"";
mostCurrent._labelstatusdesc.setText(BA.ObjectToCharSequence("Loan Status:"));
 //BA.debugLineNum = 136;BA.debugLine="LabelStatusDesc.TextColor=Colors.Black";
mostCurrent._labelstatusdesc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 137;BA.debugLine="LabelStatusDesc.TextSize=20";
mostCurrent._labelstatusdesc.setTextSize((float) (20));
 //BA.debugLineNum = 139;BA.debugLine="LabelStatus.Text=$\"KShs.\"$&amount&$\" on review\"$";
mostCurrent._labelstatus.setText(BA.ObjectToCharSequence(("KShs.")+_amount+(" on review")));
 //BA.debugLineNum = 140;BA.debugLine="LabelStatus.TextColor=Colors.Black";
mostCurrent._labelstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 141;BA.debugLine="LabelStatus.TextSize=14";
mostCurrent._labelstatus.setTextSize((float) (14));
 //BA.debugLineNum = 143;BA.debugLine="LabelDescDesc.Text=$\"Due in:\"$";
mostCurrent._labeldescdesc.setText(BA.ObjectToCharSequence(("Due in:")));
 //BA.debugLineNum = 144;BA.debugLine="LabelDescDesc.TextColor=Colors.Black";
mostCurrent._labeldescdesc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 145;BA.debugLine="LabelDescDesc.TextSize=20";
mostCurrent._labeldescdesc.setTextSize((float) (20));
 //BA.debugLineNum = 147;BA.debugLine="LabelDesc.Text=period";
mostCurrent._labeldesc.setText(BA.ObjectToCharSequence(_period));
 //BA.debugLineNum = 148;BA.debugLine="LabelDesc.TextColor=Colors.Black";
mostCurrent._labeldesc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 149;BA.debugLine="LabelDesc.TextSize=14";
mostCurrent._labeldesc.setTextSize((float) (14));
 //BA.debugLineNum = 151;BA.debugLine="Label5.TextSize=15";
mostCurrent._label5.setTextSize((float) (15));
 //BA.debugLineNum = 152;BA.debugLine="Label5.Text=$\"Dear \"$&names&$\" your loan request";
mostCurrent._label5.setText(BA.ObjectToCharSequence(("Dear ")+_names+(" your loan request is in review and will be processed as soon as possible.\n"+"Sorry for any inconviniences caused.")));
 //BA.debugLineNum = 154;BA.debugLine="Label5.TextColor=Colors.Black";
mostCurrent._label5.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
 //BA.debugLineNum = 158;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 164;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 160;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return "";
}
public static String  _btnclaim_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _listz = null;
 //BA.debugLineNum = 176;BA.debugLine="Sub BtnClaim_Click";
 //BA.debugLineNum = 177;BA.debugLine="Dim listz As List";
_listz = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 178;BA.debugLine="listz.Initialize";
_listz.Initialize();
 //BA.debugLineNum = 179;BA.debugLine="If File.Exists(File.DirInternal,\"data6.dat\")Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data6.dat")) { 
 //BA.debugLineNum = 180;BA.debugLine="MsgboxAsync(\"You have already claimed your savin";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("You have already claimed your savings"),BA.ObjectToCharSequence("Error"),processBA);
 }else {
 //BA.debugLineNum = 182;BA.debugLine="StartActivity(Claim)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._claim.getObject()));
 };
 //BA.debugLineNum = 184;BA.debugLine="End Sub";
return "";
}
public static String  _btnreapply_click() throws Exception{
 //BA.debugLineNum = 169;BA.debugLine="Sub BtnReapply_Click";
 //BA.debugLineNum = 171;BA.debugLine="StartActivity(Apply)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._apply.getObject()));
 //BA.debugLineNum = 174;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private LabelStatusDesc As Label";
mostCurrent._labelstatusdesc = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private LabelStatus As Label";
mostCurrent._labelstatus = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private LabelDescDesc As Label";
mostCurrent._labeldescdesc = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private LabelDesc As Label";
mostCurrent._labeldesc = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private Label5 As Label";
mostCurrent._label5 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private BtnReapply As Button";
mostCurrent._btnreapply = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private BtnClaim As Button";
mostCurrent._btnclaim = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
