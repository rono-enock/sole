B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=10
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	'Dim Name As String = $"Application.PackageName"$
	Dim packagename As String = $"market://details?id=${Application.PackageName}"$
	Dim marketlink  As String = $"https://play.google.com/store/apps/details?id=${Application.PackageName}"$
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Panel1 As Panel
	Private Label1 As Label
	Private BtnShare As Button
	Private BtnRate As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("ApplyConfirmPage")
	Activity.Title=Vuka.title
	
	Dim PageColors As ColorDrawable
	PageColors.Initialize(Vuka.B_Colors,0)
	Panel1.Background=PageColors
	
	BtnRate.Text="Rate"
	BtnRate.TextColor=Colors.Black
	BtnRate.TextSize=15
	
	BtnShare.Text="Share"
	BtnShare.TextColor=Colors.Black
	BtnShare.TextSize=15
	
	Label1.Text="Your loan application has been received successfully.Rate and share our application to help us improve our performance"
	Label1.TextColor=Colors.Black
	Label1.TextSize=15
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnShare_Click	
	Dim i As Intent
	i.Initialize(i.ACTION_SEND, "")
	i.SetType("text/plain")
	i.PutExtra("android.intent.extra.TEXT", marketlink)
	i.WrapAsIntentChooser("Share Via")
	StartActivity(i)
End Sub

Sub BtnRate_Click
	Dim Market As Intent
	Market.Initialize(Market.ACTION_VIEW,packagename)
	Log(packagename)
	StartActivity (Market)
End Sub