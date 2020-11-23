package com.vukapesa.cleandeal;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class starter extends  android.app.Service{
	public static class starter_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (starter) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, starter.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, true, BA.class);
		}

	}
    static starter mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return starter.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "com.vukapesa.cleandeal", "com.vukapesa.cleandeal.starter");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "com.vukapesa.cleandeal.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (starter) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (true) {
			ServiceHelper.StarterHelper.runWaitForLayouts();
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (starter) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (true)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (starter) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (true) {
            BA.LogInfo("** Service (starter) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (starter) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}public anywheresoftware.b4a.keywords.Common __c = null;
public static int _saving = 0;
public static int _pfee = 0;
public static String _compname = "";
public static String _loantittle = "";
public static String _till = "";
public static String _titname = "";
public static String _bal = "";
public static String _ball = "";
public static String _balance = "";
public static String _balances = "";
public static String _calc = "";
public static String _limit = "";
public static String _rate = "";
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
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
 //BA.debugLineNum = 41;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
 //BA.debugLineNum = 42;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return false;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim saving As Int=Rnd(100,120)";
_saving = anywheresoftware.b4a.keywords.Common.Rnd((int) (100),(int) (120));
 //BA.debugLineNum = 10;BA.debugLine="Dim pfee As Int=Rnd(30,50)";
_pfee = anywheresoftware.b4a.keywords.Common.Rnd((int) (30),(int) (50));
 //BA.debugLineNum = 12;BA.debugLine="Dim compname As String=\"Acelords Foundation\"";
_compname = "Acelords Foundation";
 //BA.debugLineNum = 13;BA.debugLine="Dim Loantittle As String=\" Vukash\"";
_loantittle = " Vukash";
 //BA.debugLineNum = 14;BA.debugLine="Dim Till As String=\"5355179\"";
_till = "5355179";
 //BA.debugLineNum = 15;BA.debugLine="Dim titname As String=\"WELCOME TO ACELORDS FOUNDA";
_titname = "WELCOME TO ACELORDS FOUNDATION!!";
 //BA.debugLineNum = 16;BA.debugLine="Dim bal,ball,balance,balances,calc,limit As Strin";
_bal = "";
_ball = "";
_balance = "";
_balances = "";
_calc = "";
_limit = "";
 //BA.debugLineNum = 17;BA.debugLine="Dim rate As String=100";
_rate = BA.NumberToString(100);
 //BA.debugLineNum = 18;BA.debugLine="balance=pfee";
_balance = BA.NumberToString(_pfee);
 //BA.debugLineNum = 19;BA.debugLine="ball=(pfee/2)";
_ball = BA.NumberToString((_pfee/(double)2));
 //BA.debugLineNum = 20;BA.debugLine="calc=(saving-30)";
_calc = BA.NumberToString((_saving-30));
 //BA.debugLineNum = 21;BA.debugLine="limit=(calc*rate)";
_limit = BA.NumberToString(((double)(Double.parseDouble(_calc))*(double)(Double.parseDouble(_rate))));
 //BA.debugLineNum = 22;BA.debugLine="balances=saving";
_balances = BA.NumberToString(_saving);
 //BA.debugLineNum = 23;BA.debugLine="bal=(ball+balances)";
_bal = BA.NumberToString(((double)(Double.parseDouble(_ball))+(double)(Double.parseDouble(_balances))));
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 45;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public static String  _service_taskremoved() throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Sub Service_TaskRemoved";
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
}
