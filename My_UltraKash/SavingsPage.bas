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
	Dim GetAmount As Int
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Label1 As Label
	Private Btnsave As Button
	Private Panel1 As Panel
	Private edtAmount As EditText
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("SavingPage")
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
	Panel1.Background=page
	
	edtAmount.Hint=Starter.saving
	edtAmount.HintColor=Colors.Blue
	edtAmount.TextSize=14
	edtAmount.Color=btn
	edtAmount.TextColor=Colors.Black
	
	
	Label1.TextColor=Colors.Black
	Label1.Text=$" Dear ${AccCreate.naming} you are required to save ${Starter.saving} for you to qualify for a loan.
This will act As security fee.
The savings will be refunded upon loan repayment
Higher savings amount increases your chance To qualify For a higher loan"$
	
	Btnsave.Color=btn
	Btnsave.Text="Proceed"
	Btnsave.TextColor=Colors.Black
	Btnsave.TextSize=15
	
	'GetAmount=edtAmount.Text
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub Btnsave_Click
	StartActivity(TillSavings)
End Sub