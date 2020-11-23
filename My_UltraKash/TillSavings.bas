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
	Dim calc,limit As String
	Dim rate As String=100
	Dim GetLimit As String
	Dim limits As String
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Label1 As Label
	Private edtCode As EditText
	Private BtnConfirmcode As Button
	Private Panel1 As Panel
	
	'Dim interstial As FacebookInterstitial
	'Private LblGetAmount As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("TillSavingsPage")
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
	Panel1.Background=page
	
	'interstial.Initialize(Inuka.InterstialUnit,"Interstial")
	'interstial.loadAd
	
	Dim lists As List
	lists.Initialize
	Dim names As String
	If File.Exists(File.DirInternal,"data.dat")Then
		lists=File.ReadList(File.DirInternal,"data.dat")
		names=lists.Get(0)
	End If
	calc=Starter.saving
	limit=(calc-30)
	limits=(limit*rate)
	Label1.Text=$"Dear "$&names&$" your loan limit is Kshs. ${Starter.limit} ,you are required to save Ksh.${Starter.saving} to Till No. ${Starter.Till} (PayTech Inc.) which will act As security fee.
The savings will be refunded upon loan repayment.

CLICK HERE TO COPY TILL NUMBER TO CLIPBOARD.


PAYMENT STEPS
1. Go to Mpesa
2. Lipa na Mpesa
3. Buy Goods and Services
4. Enter ${Starter.Till}
5. Enter Kshs. ${Starter.saving}
6. Enter Your PIN."$
	Label1.Color=Colors.Transparent
	Label1.TextColor=Colors.Black
	'Label1.Text=$"Paste the MPESA CODE to the space below."$
	Label1.TextSize=12
	
	
'	LblGetAmount.TextColor=Colors.Black
'	LblGetAmount.TextSize=14
	
	'BtnConfirmcode.Color=btn
	BtnConfirmcode.Text="Confirm Message"
	BtnConfirmcode.TextColor=Colors.Black
	BtnConfirmcode.TextSize=17
	
	edtCode.Color=btn
	edtCode.HintColor=Colors.Magenta
	edtCode.Hint="Enter MPESA MESSAGE Received"
	edtCode.TextColor=Colors.Black
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnConfirmcode_Click
	
	Dim Mcode As String
	Mcode = edtCode.Text.Trim
	
	If Mcode = "" Then
		edtCode.Hint = "MPESA MESSAGE REQUIRED!"
		edtCode.HintColor = Colors.Red
		edtCode.Gravity = Gravity.CENTER
		Return
	else if Mcode.Length < 142 Then'Or Mcode.Length >170 Then
		edtCode.Text = ""
		edtCode.Hint = "INVALID MPESA MESSAGE!"
		edtCode.HintColor = Colors.Red
		edtCode.Gravity = Gravity.CENTER
		Return
	Else
		ProgressDialogShow2("Confirming message....",False)
		Sleep(4000)
		ProgressDialogHide
		'If interstial.adReady Then
		'	interstial.showAd
		'Else
			StartActivity(SaveConfirmPage)
		'End If
		
	End If
	
	
End Sub

Sub Label1_Click
	Dim Click As BClipboard
	Click.setText(Starter.Till)
	ToastMessageShow($"Till Number - ${Starter.Till} copied to clipboard"$,True)
End Sub