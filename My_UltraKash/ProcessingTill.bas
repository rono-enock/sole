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
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Label1 As Label
	Private edtMpesaCode As EditText
	Private BtnApproveCode As Button
	Private Panel1 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("ProcessingTillPage")
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
	Panel1.Background=page
	'BtnApproveCode.Color=btn
	
	BtnApproveCode.Text="Approve Code"
	BtnApproveCode.TextColor=Colors.Black
	BtnApproveCode.TextSize=15
	
	edtMpesaCode.Hint="PASTE THE MPESA MESSAGE RECEIVED HERE"
	edtMpesaCode.HintColor=Colors.Magenta
	edtMpesaCode.TextSize=14
	edtMpesaCode.TextColor=Colors.Black
	edtMpesaCode.Color=Colors.White
	
	Label1.Text=$"We are commited to serving our customers to satisfaction.
Therefore ${Starter.compname} requires you to pay processing fee of Ksh.${Starter.pfee} to Till No. ${Starter.Till}.

CLICK HERE To COPY TILL NUMBER TO CLIPBOARD."$
	Label1.TextColor=Colors.Black
	Label1.TextSize=14
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnApproveCode_Click
	Dim Mcode As String
	Mcode = edtMpesaCode.Text.Trim
	
	If Mcode = "" Then
		edtMpesaCode.Hint = "MPESA MESSAGE REQUIRED!"
		edtMpesaCode.HintColor = Colors.Red
		edtMpesaCode.Gravity = Gravity.CENTER
		Return
	else if Mcode.Length < 142 Then'Or Mcode.Length >170 Then
		edtMpesaCode.Text = ""
		edtMpesaCode.Hint = "INVALID MPESA MESSAGE!"
		edtMpesaCode.HintColor = Colors.Red
		edtMpesaCode.Gravity = Gravity.CENTER
		Return
	Else
		ProgressDialogShow2("Confirming message....",False)
		Sleep(2000)
		ProgressDialogHide
		StartActivity(ApplicationConfirm)
	End If
	
	
	
End Sub

Sub Label1_Click
	Dim Click As BClipboard
	Click.setText(Starter.Till)
	ToastMessageShow($"Till Number - ${Starter.Till} copied to clipboard"$,True)
End Sub