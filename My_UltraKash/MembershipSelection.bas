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
	Private Label1 As Label
	Private RadGold As RadioButton
	Private RdDiamond As RadioButton
	Private RdSilver As RadioButton
	Private RdSteel As RadioButton
	Private BtnJoinUs As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("MembershipPage")
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
	Panel1.Background=page
	
	Label1.TextSize=14
	Label1.TextColor=Colors.Black
	Label1.Text="Some desc"
	
	RadGold.Text="Gold"
	RadGold.TextColor=Colors.Black
	RadGold.TextSize=14
	
	RdDiamond.Text="Diamond"
	RdDiamond.TextColor=Colors.Black
	RdDiamond.TextSize=14
	
	RdSilver.Text="Silver"
	RdSilver.TextColor=Colors.Black
	RdSilver.TextSize=14
	
	RdSteel.Text="Steel"
	RdSteel.TextColor=Colors.Black
	RdSteel.TextSize=14
    
	BtnJoinUs.Color=btn
	BtnJoinUs.Text="Proceed"
	BtnJoinUs.TextColor=Colors.Black
	BtnJoinUs.TextSize=15
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub RadGold_CheckedChange(Checked As Boolean)
	
End Sub

Sub RdDiamond_CheckedChange(Checked As Boolean)
	
End Sub

Sub RdSilver_CheckedChange(Checked As Boolean)
	
End Sub

Sub RdSteel_CheckedChange(Checked As Boolean)
	
End Sub

Sub BtnJoinUs_Click
	StartActivity(Membership)
End Sub