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

	Private Label1 As Label
	Private edtCode As EditText
	Private BtnBack As Button
	Private Panel1 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("Member")
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
	Panel1.Background=page
	
	BtnBack.Color=btn
	BtnBack.Text="Back"
	BtnBack.TextColor=Colors.Black
	BtnBack.TextSize=15
	
	edtCode.Hint="PASTE THE MPESA CODE RECIEVED HERE"
	edtCode.HintColor=Colors.Magenta
	edtCode.TextColor=Colors.Black
	edtCode.TextSize=14
	edtCode.Color=Colors.White
	
	Label1.Text=$"Welcome to ${Starter.compname}. Join us and unlock your potentials!
Being a member enables you to qualify for higher loans and reduces the interest rates.
To be a member,the company wants your to pay a membership of Ksh.30 To Till No. And paste the MPESA code received To the space below."$
	Label1.TextSize=14
	Label1.TextColor=Colors.Black
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnBack_Click
	
	'Dim listz As List
	'listz.Initialize
	'listz
	
	Dim Mcode As String
	Mcode = edtCode.Text.Trim
	
	If Mcode = "" Or Mcode.Length > 142 Then
		
		StartActivity(Directory)
		Return
	Else If Mcode.Length < 142 Then'Or Mcode.Length >170 Then
		edtCode.Text = ""
		edtCode.Hint = "INVALID MPESA CODE!"
		edtCode.HintColor = Colors.Red
		edtCode.Gravity = Gravity.CENTER
		Return
	
		
	End If
	
End Sub