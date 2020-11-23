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
	
	Dim mywifi As MLwifi
	
	Dim job1 As HttpJob
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Label1 As Label
	Private BtnLogin As Button
	Private BtnSignUp As Button
	Private Panel1 As Panel
	
	Private Label2 As Label
	
	'Dim interstial As FacebookInterstitial
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("loginPage")
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
	Panel1.Background=page
	
	'interstial.Initialize(Inuka.Interstials,"Interstial")
	'interstial.enableTesting(True, Inuka.Interstials)
	'interstial.loadAd
	
	'interstial.Initialize(Inuka.InterstialUnit,"Interstial")
	'interstial.loadAd
	job1.Initialize("Downloader", Me)
	
	Dim lists As List
	lists.Initialize
	Dim names As String
	If File.Exists(File.DirInternal,"data.dat")Then
		lists=File.ReadList(File.DirInternal,"data.dat")
		names=lists.Get(0)
		Label2.TextSize=15
		Label2.TextColor=Colors.Black
		Label2.Text=$"${Starter.titname}"$ & $" You have successfully created your account as "$ &names&$"
Sign In and apply for a loan now!"$
	End If
	
	
	
    'BtnLogin.Color=btn
	BtnLogin.Text="Sign In"
	BtnLogin.TextColor=Colors.Black
	BtnLogin.TextSize=15
	
	'BtnSignUp.Color=btn
	BtnSignUp.TextSize=15
	BtnSignUp.TextColor=Colors.Black
	BtnSignUp.Text="Create Account"
	
	
	Label1.TextSize=15
	Label1.TextColor=Colors.Black
	Label1.Text=$"${Starter.Loantittle} makes it easy for you to access loans to finance your activities.
Create your account to proceed.
	"$
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnLogin_Click
	Dim number,password As String
	Dim list4 As List
	list4.Initialize
	Dim names,passw,phonNum As String
	If File.Exists(File.DirInternal,"data.dat")Then
		list4=File.ReadList(File.DirInternal,"data.dat")
		
		
		
			ProgressDialogShow2("",False)
			Sleep(3000)
			ProgressDialogHide
		'If interstial.adReady Then
		'	interstial.showAd
		'	Else
			StartActivity(AccLogins)
		'End If
			
		Else
			MsgboxAsync("First create your account","Details Missing")
		End If
	
End Sub

Sub BtnSignUp_Click
	'If interstial.adReady Then
	'	interstial.showAd
	'Else
		StartActivity(AccCreate)
	'End If
	
End Sub