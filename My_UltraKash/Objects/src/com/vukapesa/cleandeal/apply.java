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

public class apply extends Activity implements B4AActivity{
	public static apply mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "com.vukapesa.cleandeal", "com.vukapesa.cleandeal.apply");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (apply).");
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
		activityBA = new BA(this, layout, processBA, "com.vukapesa.cleandeal", "com.vukapesa.cleandeal.apply");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.vukapesa.cleandeal.apply", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (apply) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (apply) Resume **");
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
		return apply.class;
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
            BA.LogInfo("** Activity (apply) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (apply) Pause event (activity is not paused). **");
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
            apply mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (apply) Resume **");
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
public static String _gamount = "";
public static String _gperiod = "";
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _labelamount = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtamount = null;
public anywheresoftware.b4a.objects.LabelWrapper _labelduedate = null;
public anywheresoftware.b4a.objects.LabelWrapper _labelinterest = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncontinue = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtduedates = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public com.vukapesa.cleandeal.main _main = null;
public com.vukapesa.cleandeal.acccreate2 _acccreate2 = null;
public com.vukapesa.cleandeal.acclogins _acclogins = null;
public com.vukapesa.cleandeal.applicationconfirm _applicationconfirm = null;
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
 //BA.debugLineNum = 33;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 35;BA.debugLine="Activity.LoadLayout(\"ApplyPage\")";
mostCurrent._activity.LoadLayout("ApplyPage",mostCurrent.activityBA);
 //BA.debugLineNum = 36;BA.debugLine="Dim page As ColorDrawable";
_page = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 37;BA.debugLine="page.Initialize(Inuka.pages,0)";
_page.Initialize(mostCurrent._inuka._pages /*int*/ ,(int) (0));
 //BA.debugLineNum = 38;BA.debugLine="Panel1.Background=page";
mostCurrent._panel1.setBackground((android.graphics.drawable.Drawable)(_page.getObject()));
 //BA.debugLineNum = 44;BA.debugLine="edtAmount.InputType=edtAmount.INPUT_TYPE_NUMBERS";
mostCurrent._edtamount.setInputType(mostCurrent._edtamount.INPUT_TYPE_NUMBERS);
 //BA.debugLineNum = 45;BA.debugLine="edtDueDates.InputType=edtDueDates.INPUT_TYPE_NUMB";
mostCurrent._edtduedates.setInputType(mostCurrent._edtduedates.INPUT_TYPE_NUMBERS);
 //BA.debugLineNum = 47;BA.debugLine="Label1.Text=\"Loan description\"";
mostCurrent._label1.setText(BA.ObjectToCharSequence("Loan description"));
 //BA.debugLineNum = 48;BA.debugLine="Label1.TextColor=Colors.Black";
mostCurrent._label1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 49;BA.debugLine="Label1.TextSize=14";
mostCurrent._label1.setTextSize((float) (14));
 //BA.debugLineNum = 51;BA.debugLine="LabelAmount.Text=\"Amount\"";
mostCurrent._labelamount.setText(BA.ObjectToCharSequence("Amount"));
 //BA.debugLineNum = 52;BA.debugLine="LabelAmount.TextColor=Colors.Black";
mostCurrent._labelamount.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 53;BA.debugLine="LabelAmount.TextSize=14";
mostCurrent._labelamount.setTextSize((float) (14));
 //BA.debugLineNum = 55;BA.debugLine="edtAmount.TextColor=Colors.Black";
mostCurrent._edtamount.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 56;BA.debugLine="edtAmount.TextSize=14";
mostCurrent._edtamount.setTextSize((float) (14));
 //BA.debugLineNum = 57;BA.debugLine="edtAmount.Hint=\"Ksh\"";
mostCurrent._edtamount.setHint("Ksh");
 //BA.debugLineNum = 58;BA.debugLine="edtAmount.HintColor=btn";
mostCurrent._edtamount.setHintColor(_btn);
 //BA.debugLineNum = 60;BA.debugLine="LabelDueDate.Text=\"Period\"";
mostCurrent._labelduedate.setText(BA.ObjectToCharSequence("Period"));
 //BA.debugLineNum = 61;BA.debugLine="LabelDueDate.TextColor=Colors.Black";
mostCurrent._labelduedate.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 62;BA.debugLine="LabelDueDate.TextSize=14";
mostCurrent._labelduedate.setTextSize((float) (14));
 //BA.debugLineNum = 64;BA.debugLine="edtDueDates.TextColor=Colors.Black";
mostCurrent._edtduedates.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 65;BA.debugLine="edtDueDates.TextSize=14";
mostCurrent._edtduedates.setTextSize((float) (14));
 //BA.debugLineNum = 66;BA.debugLine="edtDueDates.Hint=\"Months (3-6)\"";
mostCurrent._edtduedates.setHint("Months (3-6)");
 //BA.debugLineNum = 67;BA.debugLine="edtDueDates.HintColor=btn";
mostCurrent._edtduedates.setHintColor(_btn);
 //BA.debugLineNum = 69;BA.debugLine="LabelInterest.Text=$\"Loan interest is calculated";
mostCurrent._labelinterest.setText(BA.ObjectToCharSequence(("Loan interest is calculated as per the period entered a bove.\n"+"Interest rate is 0.025%")));
 //BA.debugLineNum = 71;BA.debugLine="LabelInterest.TextColor=Colors.Black";
mostCurrent._labelinterest.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 72;BA.debugLine="LabelInterest.TextSize=14";
mostCurrent._labelinterest.setTextSize((float) (14));
 //BA.debugLineNum = 74;BA.debugLine="BtnContinue.Text=\"Continue\"";
mostCurrent._btncontinue.setText(BA.ObjectToCharSequence("Continue"));
 //BA.debugLineNum = 75;BA.debugLine="BtnContinue.TextColor=Colors.Black";
mostCurrent._btncontinue.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 76;BA.debugLine="BtnContinue.TextSize=15";
mostCurrent._btncontinue.setTextSize((float) (15));
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 83;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public static String  _btncontinue_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _lists = null;
String _names = "";
String _phon = "";
anywheresoftware.b4a.objects.collections.List _list4 = null;
 //BA.debugLineNum = 92;BA.debugLine="Sub BtnContinue_Click";
 //BA.debugLineNum = 95;BA.debugLine="Dim lists As List";
_lists = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 96;BA.debugLine="lists.Initialize";
_lists.Initialize();
 //BA.debugLineNum = 97;BA.debugLine="Dim names,phon As String";
_names = "";
_phon = "";
 //BA.debugLineNum = 98;BA.debugLine="If File.Exists(File.DirInternal,\"data.dat\")Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data.dat")) { 
 //BA.debugLineNum = 99;BA.debugLine="lists=File.ReadList(File.DirInternal,\"data.dat\")";
_lists = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data.dat");
 //BA.debugLineNum = 100;BA.debugLine="names=lists.Get(0)";
_names = BA.ObjectToString(_lists.Get((int) (0)));
 //BA.debugLineNum = 101;BA.debugLine="phon=lists.Get(1)";
_phon = BA.ObjectToString(_lists.Get((int) (1)));
 };
 //BA.debugLineNum = 104;BA.debugLine="Dim list4 As List";
_list4 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 105;BA.debugLine="list4.Initialize";
_list4.Initialize();
 //BA.debugLineNum = 106;BA.debugLine="list4.Add(names)";
_list4.Add((Object)(_names));
 //BA.debugLineNum = 107;BA.debugLine="list4.Add(phon)";
_list4.Add((Object)(_phon));
 //BA.debugLineNum = 108;BA.debugLine="list4.Add(edtAmount.Text)";
_list4.Add((Object)(mostCurrent._edtamount.getText()));
 //BA.debugLineNum = 109;BA.debugLine="list4.Add(edtDueDates.Text)";
_list4.Add((Object)(mostCurrent._edtduedates.getText()));
 //BA.debugLineNum = 112;BA.debugLine="File.WriteList(File.DirInternal,\"data1.dat\",list4";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data1.dat",_list4);
 //BA.debugLineNum = 113;BA.debugLine="GAmount=edtAmount.Text";
_gamount = mostCurrent._edtamount.getText();
 //BA.debugLineNum = 114;BA.debugLine="GPeriod=edtDueDates.Text";
_gperiod = mostCurrent._edtduedates.getText();
 //BA.debugLineNum = 116;BA.debugLine="If(GAmount =\"\") Or (GPeriod =\"\") Then";
if (((_gamount).equals("")) || ((_gperiod).equals(""))) { 
 //BA.debugLineNum = 117;BA.debugLine="MsgboxAsync(\"Enter valid details\",\"Invalid choic";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Enter valid details"),BA.ObjectToCharSequence("Invalid choice"),processBA);
 }else if(((double)(Double.parseDouble(_gamount))>(double)(Double.parseDouble(mostCurrent._starter._limit /*String*/ )))) { 
 //BA.debugLineNum = 119;BA.debugLine="MsgboxAsync(\"You can't qualify for that amount\",";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("You can't qualify for that amount"),BA.ObjectToCharSequence("Invalid choice"),processBA);
 }else if(((double)(Double.parseDouble(_gamount))<100)) { 
 //BA.debugLineNum = 121;BA.debugLine="MsgboxAsync(\"Ksh.100 is the minimum amount you c";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Ksh.100 is the minimum amount you can apply"),BA.ObjectToCharSequence("Invalid choice"),processBA);
 }else if(((double)(Double.parseDouble(_gperiod))<3) || (_gperiod.length()!=1) || ((double)(Double.parseDouble(_gperiod))>6)) { 
 //BA.debugLineNum = 123;BA.debugLine="MsgboxAsync(\"Enter a valid period\",\"Invalid choi";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Enter a valid period"),BA.ObjectToCharSequence("Invalid choice"),processBA);
 }else if(anywheresoftware.b4a.keywords.Common.Not((_gamount).equals("")) && anywheresoftware.b4a.keywords.Common.Not((_gperiod).equals("")) && anywheresoftware.b4a.keywords.Common.Not((double)(Double.parseDouble(_gamount))>(double)(Double.parseDouble(mostCurrent._starter._limit /*String*/ ))) && anywheresoftware.b4a.keywords.Common.Not((double)(Double.parseDouble(_gperiod))<3) && (_gperiod.length()==1) && anywheresoftware.b4a.keywords.Common.Not((double)(Double.parseDouble(_gamount))<100) && anywheresoftware.b4a.keywords.Common.Not((double)(Double.parseDouble(_gperiod))>10)) { 
 //BA.debugLineNum = 128;BA.debugLine="StartActivity(ApplicationConfirm)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._applicationconfirm.getObject()));
 };
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 20;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private LabelAmount As Label";
mostCurrent._labelamount = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private edtAmount As EditText";
mostCurrent._edtamount = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private LabelDueDate As Label";
mostCurrent._labelduedate = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private LabelInterest As Label";
mostCurrent._labelinterest = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private BtnContinue As Button";
mostCurrent._btncontinue = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private edtDueDates As EditText";
mostCurrent._edtduedates = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Dim btn As Int = Colors.ARGB(182,223,255,255)";
_btn = anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (182),(int) (223),(int) (255),(int) (255));
 //BA.debugLineNum = 11;BA.debugLine="Dim GAmount As String";
_gamount = "";
 //BA.debugLineNum = 12;BA.debugLine="Dim GPeriod As String";
_gperiod = "";
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
}
