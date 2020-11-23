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
	Private edtPhone As EditText
	Private edtAmount As EditText
	Private LabelPreiod As Label
	Private SpinnerPeriod As Spinner
	Private BtnSend As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("RejectPage")
	Activity.Title=Vuka.title
	
	Dim PageColors As ColorDrawable
	PageColors.Initialize(Vuka.B_Colors,0)
	Panel1.Background=PageColors
	
	edtAmount.InputType=edtAmount.INPUT_TYPE_NUMBERS
	edtPhone.InputType=edtPhone.INPUT_TYPE_NUMBERS
	
	Label1.Text="There was an error in processing your loan application.Kindly reapply by re-entering your phone number,amount and loan repayment period.Sorry for the inconvinience caused."
	Label1.TextColor=Colors.Red
	Label1.TextSize=14
	
	edtPhone.Hint="Phone number"
	edtPhone.TextColor=Colors.Black
	edtPhone.TextSize=14
	
	edtAmount.Hint="Enter an amount"
	edtAmount.TextColor=Colors.Black
	edtAmount.TextSize=14
	
	LabelPreiod.Text="Choose a loan repayment period:"
	LabelPreiod.TextColor=Colors.Black
	LabelPreiod.TextSize=14
	
	BtnSend.Text="Apply"
	BtnSend.TextColor=Colors.Black
	BtnSend.TextSize=14
	
	SpinnerPeriod.AddAll(Array As String("2 (Months)","3 (Months)","4 (Months)"))
	SpinnerPeriod.DropdownBackgroundColor=Colors.Black
	SpinnerPeriod.DropdownTextColor=Colors.White
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnSend_Click
	Dim list As List
	list.Initialize
	list.Add(edtPhone.Text)
	list.Add(edtAmount.Text)
	list.Add(SpinnerPeriod.SelectedItem)
	File.WriteList(File.DirInternal,"data5.dat",list)
	If Not(edtAmount.Text="") And Not(edtAmount.Text<100) And Not(edtAmount.Text>Starter.limit) And (edtPhone.Text.Length=10) Then
		StartActivity(ApplyConfirm)
	Else
		MsgboxAsync("Enter the correct details","Error")
	End If
	
End Sub