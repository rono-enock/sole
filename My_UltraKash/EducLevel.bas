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
	Dim choice As Int
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Label1 As Label
	Private RdPrimary As RadioButton
	Private RdSecondary As RadioButton
	Private RdUndergraduate As RadioButton
	Private RdPostgraduate As RadioButton
	Private BtnNext As Button
	Private Panel1 As Panel
	
	'Dim interstial As FacebookInterstitial
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("EducLevelPage")
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
	Panel1.Background=page
	
	'interstial.Initialize(Inuka.InterstialUnit,"Interstial")
	'interstial.loadAd
	
	RdPrimary.Text="Primary"
	RdPrimary.TextColor=Colors.Black
	RdPrimary.TextSize=14
	
	RdSecondary.Text="Secondary"
	RdSecondary.TextColor=Colors.Black
	RdSecondary.TextSize=14
	
	RdUndergraduate.Text="Undergraduate"
	RdUndergraduate.TextColor=Colors.Black
	RdUndergraduate.TextSize=14
	
	RdPostgraduate.Text="Postgraduate"
	RdPostgraduate.TextColor=Colors.Black
	RdPostgraduate.TextSize=14
	
	'BtnNext.Color=btn
	BtnNext.Text="Next"
	BtnNext.TextColor=Colors.Black
	BtnNext.TextSize=15
	
	Label1.Text="Select your level of education"
	Label1.TextColor=Colors.Black
	Label1.TextSize=14
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub RdPrimary_CheckedChange(Checked As Boolean)
	
End Sub

Sub RdSecondary_CheckedChange(Checked As Boolean)
	
End Sub

Sub RdUndergraduate_CheckedChange(Checked As Boolean)
	
End Sub

Sub RdPostgraduate_CheckedChange(Checked As Boolean)
	
End Sub

Sub BtnNext_Click
	If(RdPrimary.Checked=True) Or(RdSecondary.Checked=True) Or(RdUndergraduate.Checked=True) Or (RdPostgraduate.Checked=True) Then
'		If interstial.adReady Then
'			interstial.showAd
'		Else
			StartActivity(Occupation)
'		End If
		
	Else
		MsgboxAsync("Select your level of education","Details Missing")	
	End If
	
End Sub