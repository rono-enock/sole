B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=8
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	'Dim page As Int = Colors.ARGB(147,107,228,255)
	Dim btn As Int = Colors.ARGB(182,223,255,255)
	
	Dim password As String
	
	Dim number As String
	
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private edtName As EditText
	Private edtPass As EditText
	Private Btnlogin As Button
	Private Panel1 As Panel
	
	'Dim interstial As FacebookInterstitial
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("loginsPage")
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
	Panel1.Background=page
	
	'interstial.Initialize(Inuka.Interstials,"Interstial")
	'interstial.enableTesting(True, Inuka.Interstials)
	'interstial.loadAd
	
	'interstial.Initialize(Inuka.InterstialUnit,"Interstial")
	'interstial.loadAd
	
	edtName.InputType=edtName.INPUT_TYPE_NUMBERS
	edtPass.InputType=edtPass.INPUT_TYPE_NUMBERS
	
	edtName.TextSize=14
	edtName.Hint="Phone number"
	edtName.HintColor=btn
	edtName.TextColor=Colors.Black
	
	edtPass.Hint="Password"
	edtPass.HintColor=btn
	edtPass.TextColor=Colors.Black
	edtPass.TextSize=14
	
	'Btnlogin.Color=btn
	Btnlogin.Text="Login"
	Btnlogin.TextColor=Colors.Black
	Btnlogin.TextSize=15
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub Btnlogin_Click
	Dim list4 As List
	list4.Initialize
	Dim names,passw,phonNum As String
	If File.Exists(File.DirInternal,"data.dat")Then
		list4=File.ReadList(File.DirInternal,"data.dat")
		names=list4.Get(0)
		phonNum=list4.Get(1)
		passw=list4.Get(2)
		
		End If
	number=edtName.Text
	password=edtPass.Text
	If (number = phonNum ) And (password = passw) And Not(password = "") And Not(number = "") And (number.Length=10) Then
		ProgressDialogShow2("",False)
		Sleep(5000)
		ProgressDialogHide
'		If interstial.adReady Then
'			interstial.showAd
'		Else
			StartActivity(Directory)
'		End If
		
	Else 
		MsgboxAsync("Enter the correct login information", "Details Missing")
	End If

	
	
	
	
	
End Sub

