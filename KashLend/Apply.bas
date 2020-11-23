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
	Private LabelAmount As Label
	Private edtAmount As EditText
	Private LabelPeriod As Label
	Private SpinnerPeriod As Spinner
	Private Label4 As Label
	Private BtnApply As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("ApplyPage")
	Activity.Title=Vuka.title
	
	Dim PageColors As ColorDrawable
	PageColors.Initialize(Vuka.B_Colors,0)
	Panel1.Background=PageColors
	
	edtAmount.InputType=edtAmount.INPUT_TYPE_NUMBERS
	
	Label1.Text="Enter an amount you'll be able to repay!"
	Label1.TextColor=Colors.Black
	Label1.TextSize=15
	
	Label4.Text="Interest will be calculated as per the period selected above"
	Label4.TextColor=Colors.Black
	Label4.TextSize=15
	
	LabelAmount.Text="Amount:"
	LabelAmount.TextColor=Colors.Black
	LabelAmount.TextSize=14
	
	LabelPeriod.Text="Choose a repayment period:"
	LabelPeriod.TextColor=Colors.Black
	LabelPeriod.TextSize=14
	
	BtnApply.Text="Apply"
	BtnApply.TextColor=Colors.Black
	BtnApply.TextSize=15
	
	SpinnerPeriod.AddAll(Array As String("2 (Months)","3 (Months)","4 (Months)"))
	SpinnerPeriod.DropdownBackgroundColor=Colors.Black
	SpinnerPeriod.DropdownTextColor=Colors.White
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnApply_Click
	Dim list As List
	list.Initialize
	list.Add(edtAmount.Text)
	list.Add(SpinnerPeriod.SelectedItem)
	File.WriteList(File.DirInternal,"data4.dat",list)
	If Not(edtAmount.Text="") And Not(edtAmount.Text<100) And Not(edtAmount.Text>Starter.limit) Then
		StartActivity(ApplyConfirm)
	Else
		MsgboxAsync($"Enter the correct amount (between Kshs.100 and ${Starter.limit})"$,"Error")
	End If
	
End Sub