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

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Panel1 As Panel
	Private Label1 As Label
	Private RdPrimary As RadioButton
	Private RdSecondary As RadioButton
	Private RdUndergraduate As RadioButton
	Private RdPostgraduate As RadioButton
	Private BtnNext As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("EducLevPage")
	Activity.Title=Vuka.title
	
	Dim PageColors As ColorDrawable
	PageColors.Initialize(Vuka.B_Colors,0)
	Panel1.Background=PageColors
	
	Label1.Text="Select your level of education"
	Label1.TextColor=Colors.Black
	Label1.TextSize=14
	
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
	
	BtnNext.Text="Next"
	BtnNext.TextColor=Colors.Black
	BtnNext.TextSize=15
	
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
	If RdPostgraduate.Checked=True Or RdPrimary.Checked=True Or RdUndergraduate.Checked=True Or RdSecondary.Checked=True Then
		StartActivity(Kin)
	Else
		MsgboxAsync("Select you level of education","Error")
	End If
	
End Sub