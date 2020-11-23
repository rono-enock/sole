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
			processBA = new BA(this.getApplicationContext(), null, null, "com.vukapesa.cleandeal", "com.vukapesa.cleandeal.reviews");
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
		activityBA = new BA(this, layout, processBA, "com.vukapesa.cleandeal", "com.vukapesa.cleandeal.reviews");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.vukapesa.cleandeal.reviews", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
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
public static int _btn = 0;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _labelrevname = null;
public anywheresoftware.b4a.objects.LabelWrapper _labeldetname = null;
public anywheresoftware.b4a.objects.LabelWrapper _labelreview = null;
public anywheresoftware.b4a.objects.LabelWrapper _labeldetails = null;
public anywheresoftware.b4a.objects.LabelWrapper _labeldesc = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnreapply = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnclaim = null;
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
public com.vukapesa.cleandeal.processingtill _processingtill = null;
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
anywheresoftware.b4a.objects.collections.List _lists = null;
String _pass = "";
String _phon = "";
String _names = "";
String _amount = "";
String _period = "";
String _repay = "";
String _intrests = "";
String _amounts = "";
String _interest = "";
String _periods = "";
 //BA.debugLineNum = 28;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 30;BA.debugLine="Activity.LoadLayout(\"ReviewsPage\")";
mostCurrent._activity.LoadLayout("ReviewsPage",mostCurrent.activityBA);
 //BA.debugLineNum = 31;BA.debugLine="Dim page As ColorDrawable";
_page = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 32;BA.debugLine="page.Initialize(Inuka.pages,0)";
_page.Initialize(mostCurrent._inuka._pages /*int*/ ,(int) (0));
 //BA.debugLineNum = 33;BA.debugLine="Panel1.Background=page";
mostCurrent._panel1.setBackground((android.graphics.drawable.Drawable)(_page.getObject()));
 //BA.debugLineNum = 43;BA.debugLine="LabelRevName.Text=\"Loan Status:\"";
mostCurrent._labelrevname.setText(BA.ObjectToCharSequence("Loan Status:"));
 //BA.debugLineNum = 44;BA.debugLine="LabelRevName.TextSize=16";
mostCurrent._labelrevname.setTextSize((float) (16));
 //BA.debugLineNum = 45;BA.debugLine="LabelRevName.TextColor=Colors.Black";
mostCurrent._labelrevname.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 47;BA.debugLine="LabelDetName.Text=\"Amount applied:\"";
mostCurrent._labeldetname.setText(BA.ObjectToCharSequence("Amount applied:"));
 //BA.debugLineNum = 48;BA.debugLine="LabelDetName.TextSize=16";
mostCurrent._labeldetname.setTextSize((float) (16));
 //BA.debugLineNum = 49;BA.debugLine="LabelDetName.TextColor=Colors.Black";
mostCurrent._labeldetname.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 51;BA.debugLine="BtnReapply.Text=\"Reapply\"";
mostCurrent._btnreapply.setText(BA.ObjectToCharSequence("Reapply"));
 //BA.debugLineNum = 52;BA.debugLine="BtnReapply.TextSize=15";
mostCurrent._btnreapply.setTextSize((float) (15));
 //BA.debugLineNum = 53;BA.debugLine="BtnReapply.TextColor=Colors.Black";
mostCurrent._btnreapply.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 55;BA.debugLine="BtnClaim.Text=\"Claim Savings\"";
mostCurrent._btnclaim.setText(BA.ObjectToCharSequence("Claim Savings"));
 //BA.debugLineNum = 56;BA.debugLine="BtnClaim.TextSize=15";
mostCurrent._btnclaim.setTextSize((float) (15));
 //BA.debugLineNum = 57;BA.debugLine="BtnClaim.TextColor=Colors.Black";
mostCurrent._btnclaim.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 59;BA.debugLine="Dim lists As List";
_lists = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 60;BA.debugLine="lists.Initialize";
_lists.Initialize();
 //BA.debugLineNum = 61;BA.debugLine="Dim pass,phon As String";
_pass = "";
_phon = "";
 //BA.debugLineNum = 62;BA.debugLine="If File.Exists(File.DirInternal,\"data2.dat\")Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data2.dat")) { 
 //BA.debugLineNum = 63;BA.debugLine="lists=File.ReadList(File.DirInternal,\"data2.dat\")";
_lists = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data2.dat");
 //BA.debugLineNum = 64;BA.debugLine="pass=lists.Get(0)";
_pass = BA.ObjectToString(_lists.Get((int) (0)));
 //BA.debugLineNum = 65;BA.debugLine="phon=lists.Get(1)";
_phon = BA.ObjectToString(_lists.Get((int) (1)));
 //BA.debugLineNum = 67;BA.debugLine="LabelReview.Text=$\"Interrupted!\"$";
mostCurrent._labelreview.setText(BA.ObjectToCharSequence(("Interrupted!")));
 //BA.debugLineNum = 68;BA.debugLine="LabelReview.Color=Colors.Green";
mostCurrent._labelreview.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 69;BA.debugLine="LabelReview.TextSize=14";
mostCurrent._labelreview.setTextSize((float) (14));
 //BA.debugLineNum = 70;BA.debugLine="LabelReview.TextColor=Colors.Red";
mostCurrent._labelreview.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 73;BA.debugLine="LabelDetails.Text=$\"Not Found!\"$";
mostCurrent._labeldetails.setText(BA.ObjectToCharSequence(("Not Found!")));
 //BA.debugLineNum = 74;BA.debugLine="LabelDetails.Color=Colors.Green";
mostCurrent._labeldetails.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 75;BA.debugLine="LabelDetails.TextSize=14";
mostCurrent._labeldetails.setTextSize((float) (14));
 //BA.debugLineNum = 76;BA.debugLine="LabelDetails.TextColor=Colors.Red";
mostCurrent._labeldetails.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 79;BA.debugLine="LabelDesc.Text=$\"Your loan application was inter";
mostCurrent._labeldesc.setText(BA.ObjectToCharSequence(("Your loan application was interrupted!")));
 //BA.debugLineNum = 80;BA.debugLine="LabelDesc.TextSize=14";
mostCurrent._labeldesc.setTextSize((float) (14));
 //BA.debugLineNum = 81;BA.debugLine="LabelDesc.TextColor=Colors.Red";
mostCurrent._labeldesc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 }else {
 //BA.debugLineNum = 83;BA.debugLine="Dim lists As List";
_lists = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 84;BA.debugLine="lists.Initialize";
_lists.Initialize();
 //BA.debugLineNum = 85;BA.debugLine="Dim names,phon,amount,period As String";
_names = "";
_phon = "";
_amount = "";
_period = "";
 //BA.debugLineNum = 86;BA.debugLine="If File.Exists(File.DirInternal,\"data1.dat\")Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data1.dat")) { 
 //BA.debugLineNum = 87;BA.debugLine="lists=File.ReadList(File.DirInternal,\"data1.dat";
_lists = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data1.dat");
 //BA.debugLineNum = 88;BA.debugLine="names=lists.Get(0)";
_names = BA.ObjectToString(_lists.Get((int) (0)));
 //BA.debugLineNum = 89;BA.debugLine="phon=lists.Get(1)";
_phon = BA.ObjectToString(_lists.Get((int) (1)));
 //BA.debugLineNum = 90;BA.debugLine="amount=lists.Get(2)";
_amount = BA.ObjectToString(_lists.Get((int) (2)));
 //BA.debugLineNum = 91;BA.debugLine="period=lists.Get(3)";
_period = BA.ObjectToString(_lists.Get((int) (3)));
 //BA.debugLineNum = 93;BA.debugLine="Dim repay,intrests As String";
_repay = "";
_intrests = "";
 //BA.debugLineNum = 94;BA.debugLine="Dim amounts As String=amount";
_amounts = _amount;
 //BA.debugLineNum = 95;BA.debugLine="Dim interest As String=0.025";
_interest = BA.NumberToString(0.025);
 //BA.debugLineNum = 96;BA.debugLine="Dim periods As String=period";
_periods = _period;
 //BA.debugLineNum = 97;BA.debugLine="repay=(periods*interest*amount)";
_repay = BA.NumberToString(((double)(Double.parseDouble(_periods))*(double)(Double.parseDouble(_interest))*(double)(Double.parseDouble(_amount))));
 //BA.debugLineNum = 98;BA.debugLine="intrests=(repay-amounts)";
_intrests = BA.NumberToString(((double)(Double.parseDouble(_repay))-(double)(Double.parseDouble(_amounts))));
 //BA.debugLineNum = 100;BA.debugLine="LabelReview.Text=$\"In Review\"$";
mostCurrent._labelreview.setText(BA.ObjectToCharSequence(("In Review")));
 //BA.debugLineNum = 101;BA.debugLine="LabelReview.Color=Colors.Green";
mostCurrent._labelreview.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 102;BA.debugLine="LabelReview.TextSize=14";
mostCurrent._labelreview.setTextSize((float) (14));
 //BA.debugLineNum = 103;BA.debugLine="LabelReview.TextColor=Colors.Black";
mostCurrent._labelreview.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 106;BA.debugLine="LabelDetails.Text=$\"Ksh.\"$&amount&$\" due in \"$&";
mostCurrent._labeldetails.setText(BA.ObjectToCharSequence(("Ksh.")+_amount+(" due in ")+_period+(" months.")));
 //BA.debugLineNum = 107;BA.debugLine="LabelDetails.Color=Colors.Green";
mostCurrent._labeldetails.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 108;BA.debugLine="LabelDetails.TextSize=14";
mostCurrent._labeldetails.setTextSize((float) (14));
 //BA.debugLineNum = 109;BA.debugLine="LabelDetails.TextColor=Colors.Black";
mostCurrent._labeldetails.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 112;BA.debugLine="LabelDesc.Text=$\"Dear \"$&names&$\" your loan req";
mostCurrent._labeldesc.setText(BA.ObjectToCharSequence(("Dear ")+_names+(" your loan request is in review and will be processed as soon as possible.\n"+"Sorry for any inconviniences caused.")));
 //BA.debugLineNum = 114;BA.debugLine="LabelDesc.TextSize=14";
mostCurrent._labeldesc.setTextSize((float) (14));
 //BA.debugLineNum = 115;BA.debugLine="LabelDesc.TextColor=Colors.Black";
mostCurrent._labeldesc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 }else {
 //BA.debugLineNum = 118;BA.debugLine="LabelReview.Color=Colors.White";
mostCurrent._labelreview.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 119;BA.debugLine="LabelReview.TextSize=14";
mostCurrent._labelreview.setTextSize((float) (14));
 //BA.debugLineNum = 120;BA.debugLine="LabelReview.TextColor=Colors.Red";
mostCurrent._labelreview.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 121;BA.debugLine="LabelReview.Text=$\"Not applied\"$";
mostCurrent._labelreview.setText(BA.ObjectToCharSequence(("Not applied")));
 //BA.debugLineNum = 123;BA.debugLine="LabelDesc.Color=Colors.White";
mostCurrent._labeldesc.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 124;BA.debugLine="LabelDesc.Text=$\"\"$&names&$\"You have not applie";
mostCurrent._labeldesc.setText(BA.ObjectToCharSequence(("")+_names+("You have not applied for any loan! Apply and get the loan instantly")));
 //BA.debugLineNum = 125;BA.debugLine="LabelDesc.TextSize=17";
mostCurrent._labeldesc.setTextSize((float) (17));
 //BA.debugLineNum = 126;BA.debugLine="LabelDesc.TextColor=Colors.Red";
mostCurrent._labeldesc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 128;BA.debugLine="LabelDetails.Text=$\"Not applied\"$";
mostCurrent._labeldetails.setText(BA.ObjectToCharSequence(("Not applied")));
 //BA.debugLineNum = 129;BA.debugLine="LabelDetails.Color=Colors.White";
mostCurrent._labeldetails.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 130;BA.debugLine="LabelDetails.TextSize=14";
mostCurrent._labeldetails.setTextSize((float) (14));
 //BA.debugLineNum = 131;BA.debugLine="LabelDetails.TextColor=Colors.Red";
mostCurrent._labeldetails.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 };
 };
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 146;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 148;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 142;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 144;BA.debugLine="End Sub";
return "";
}
public static void  _btnclaim_click() throws Exception{
ResumableSub_BtnClaim_Click rsub = new ResumableSub_BtnClaim_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_BtnClaim_Click extends BA.ResumableSub {
public ResumableSub_BtnClaim_Click(com.vukapesa.cleandeal.reviews parent) {
this.parent = parent;
}
com.vukapesa.cleandeal.reviews parent;
anywheresoftware.b4a.objects.collections.List _lists = null;
String _pass = "";
String _phon = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 191;BA.debugLine="Dim lists As List";
_lists = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 192;BA.debugLine="lists.Initialize";
_lists.Initialize();
 //BA.debugLineNum = 193;BA.debugLine="Dim pass,phon As String";
_pass = "";
_phon = "";
 //BA.debugLineNum = 194;BA.debugLine="If File.Exists(File.DirInternal,\"data2.dat\")Then";
if (true) break;

case 1:
//if
this.state = 12;
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data2.dat")) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 12;
 //BA.debugLineNum = 195;BA.debugLine="ProgressDialogShow(\"Checking savings.....\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Checking savings....."));
 //BA.debugLineNum = 196;BA.debugLine="Sleep(4000)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (4000));
this.state = 13;
return;
case 13:
//C
this.state = 12;
;
 //BA.debugLineNum = 197;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 198;BA.debugLine="MsgboxAsync(\"You have already claimed\",\"Dear use";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("You have already claimed"),BA.ObjectToCharSequence("Dear user"),processBA);
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 200;BA.debugLine="Dim lists As List";
_lists = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 201;BA.debugLine="lists.Initialize";
_lists.Initialize();
 //BA.debugLineNum = 202;BA.debugLine="If File.Exists(File.DirInternal,\"data1.dat\")Then";
if (true) break;

case 6:
//if
this.state = 11;
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data1.dat")) { 
this.state = 8;
}else {
this.state = 10;
}if (true) break;

case 8:
//C
this.state = 11;
 //BA.debugLineNum = 203;BA.debugLine="ProgressDialogShow(\"Checking savings.....\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Checking savings....."));
 //BA.debugLineNum = 204;BA.debugLine="Sleep(4000)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (4000));
this.state = 14;
return;
case 14:
//C
this.state = 11;
;
 //BA.debugLineNum = 205;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 209;BA.debugLine="StartActivity(ClaimSavings)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._claimsavings.getObject()));
 if (true) break;

case 10:
//C
this.state = 11;
 //BA.debugLineNum = 212;BA.debugLine="ProgressDialogShow(\"Checking savings.....\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Checking savings....."));
 //BA.debugLineNum = 213;BA.debugLine="Sleep(4000)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (4000));
this.state = 15;
return;
case 15:
//C
this.state = 11;
;
 //BA.debugLineNum = 214;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 215;BA.debugLine="MsgboxAsync(\"You have no savings yet\",\"Dear user";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("You have no savings yet"),BA.ObjectToCharSequence("Dear user"),processBA);
 if (true) break;

case 11:
//C
this.state = 12;
;
 if (true) break;

case 12:
//C
this.state = -1;
;
 //BA.debugLineNum = 218;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _btnreapply_click() throws Exception{
ResumableSub_BtnReapply_Click rsub = new ResumableSub_BtnReapply_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_BtnReapply_Click extends BA.ResumableSub {
public ResumableSub_BtnReapply_Click(com.vukapesa.cleandeal.reviews parent) {
this.parent = parent;
}
com.vukapesa.cleandeal.reviews parent;
anywheresoftware.b4a.objects.collections.List _lists = null;
String _pass = "";
String _phon = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 151;BA.debugLine="Dim lists As List";
_lists = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 152;BA.debugLine="lists.Initialize";
_lists.Initialize();
 //BA.debugLineNum = 153;BA.debugLine="Dim pass,phon As String";
_pass = "";
_phon = "";
 //BA.debugLineNum = 154;BA.debugLine="If File.Exists(File.DirInternal,\"data2.dat\")Then";
if (true) break;

case 1:
//if
this.state = 12;
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data2.dat")) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 12;
 //BA.debugLineNum = 155;BA.debugLine="ProgressDialogShow(\"Validating loan reapplicatio";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Validating loan reapplication....."));
 //BA.debugLineNum = 156;BA.debugLine="Sleep(4000)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (4000));
this.state = 13;
return;
case 13:
//C
this.state = 12;
;
 //BA.debugLineNum = 157;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 158;BA.debugLine="MsgboxAsync(\"Your savings refund is already in p";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Your savings refund is already in process"),BA.ObjectToCharSequence("Dear user"),processBA);
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 160;BA.debugLine="Dim lists As List";
_lists = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 161;BA.debugLine="lists.Initialize";
_lists.Initialize();
 //BA.debugLineNum = 162;BA.debugLine="If File.Exists(File.DirInternal,\"data1.dat\")Then";
if (true) break;

case 6:
//if
this.state = 11;
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data1.dat")) { 
this.state = 8;
}else {
this.state = 10;
}if (true) break;

case 8:
//C
this.state = 11;
 //BA.debugLineNum = 163;BA.debugLine="ProgressDialogShow(\"Validating loan reapplication";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Validating loan reapplication....."));
 //BA.debugLineNum = 164;BA.debugLine="Sleep(4000)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (4000));
this.state = 14;
return;
case 14:
//C
this.state = 11;
;
 //BA.debugLineNum = 165;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 169;BA.debugLine="StartActivity(SaveConfirmPage)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._saveconfirmpage.getObject()));
 if (true) break;

case 10:
//C
this.state = 11;
 //BA.debugLineNum = 172;BA.debugLine="ProgressDialogShow(\"Checking savings.....\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Checking savings....."));
 //BA.debugLineNum = 173;BA.debugLine="Sleep(4000)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (4000));
this.state = 15;
return;
case 15:
//C
this.state = 11;
;
 //BA.debugLineNum = 174;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 175;BA.debugLine="MsgboxAsync(\"You have not applied\",\"Dear user\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("You have not applied"),BA.ObjectToCharSequence("Dear user"),processBA);
 if (true) break;

case 11:
//C
this.state = 12;
;
 if (true) break;

case 12:
//C
this.state = -1;
;
 //BA.debugLineNum = 188;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private LabelRevName As Label";
mostCurrent._labelrevname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private LabelDetName As Label";
mostCurrent._labeldetname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private LabelReview As Label";
mostCurrent._labelreview = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private LabelDetails As Label";
mostCurrent._labeldetails = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private LabelDesc As Label";
mostCurrent._labeldesc = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private BtnReapply As Button";
mostCurrent._btnreapply = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private BtnClaim As Button";
mostCurrent._btnclaim = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim btn As Int = Colors.ARGB(182,223,255,255)";
_btn = anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (182),(int) (223),(int) (255),(int) (255));
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
