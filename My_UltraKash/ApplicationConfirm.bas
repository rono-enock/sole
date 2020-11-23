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
	Dim btn As Int = Colors.ARGB(182,223,255,255)
	
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Panel1 As Panel
	'Private Label1 As Label
	Private BtnRate As Button
	Private Label2 As Label
	'Dim interstial As FacebookInterstitial
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("ApplicationConfirmPage")
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
	Panel1.Background=page
	
	
	'interstial.Initialize(Inuka.InterstialUnit,"Inter")
	'interstial.loadAd
	
	Dim lists As List
	lists.Initialize
	Dim names,phon As String
	If File.Exists(File.DirInternal,"data.dat")Then
		lists=File.ReadList(File.DirInternal,"data.dat")
		names=lists.Get(0)
		phon=lists.Get(1)
	End If
	
	BtnRate.Text="Reward"
	BtnRate.TextColor=Colors.Black
	BtnRate.TextSize=15
	
	Label2.TextColor=Colors.Black
	Label2.TextSize=14
	
	
	
	Dim texts As String=$"Your loan request has been received successfully and is being processed.It may take upto 48 hours for your account to be credited.
Your account balace is Ksh.${Starter.saving}
Name: ${names}
Phone number: ${phon}
Amount: Ksh.${Apply.GAmount}
Period: ${Apply.GPeriod} Months


Rate and share our App to qualify for our weekly reward program"$
	Label2.Text=texts
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnRate_Click
	'If interstial.adReady Then
	'	interstial.showAd
	'Else
		StartActivity(Reward)
	'End If
	
End Sub