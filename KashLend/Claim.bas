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
	Private edtPin As EditText
	Private BtnClaim As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("ClaimPage")
	Activity.Title=Vuka.title
	
	Dim PageColors As ColorDrawable
	PageColors.Initialize(Vuka.B_Colors,0)
	Panel1.Background=PageColors
	
	BtnClaim.Text="Claim"
	BtnClaim.TextColor=Colors.Black
	BtnClaim.TextSize=15
	
	edtPhone.Hint="Enter the phone number to be credited"
	edtPhone.TextColor=Colors.Black
	edtPhone.TextSize=14
	
	edtPhone.InputType=edtPhone.INPUT_TYPE_NUMBERS
	edtPin.InputType=edtPin.INPUT_TYPE_NUMBERS
	
	edtPin.Hint="Enter password"
	edtPin.TextColor=Colors.Black
	edtPin.TextSize=14
	
	Label1.Text="Note that claiming your savings stops the entire loan processing"
	Label1.TextColor=Colors.Black
	Label1.TextSize=14
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnClaim_Click
	Dim list As List
	list.Initialize
	list.Add(edtPhone.Text)
	File.WriteList(File.DirInternal,"data6.dat",list)
	
	Dim lists As List
	Dim password As String
	lists.Initialize
	If File.Exists(File.DirInternal,"data1.dat")Then
		lists=File.ReadList(File.DirInternal,"data1.dat")
		password=lists.Get(0)
	End If
	If Not(edtPhone.Text="") And (edtPhone.Text.Length=10) And Not(edtPin.Text="") And (edtPin.Text=password) Then
		ProgressDialogShow("Sending request...")
		Sleep(4000)
		ProgressDialogHide
		Activity.Finish
	Else
		MsgboxAsync("Enter the correct details","Error")
	End If
End Sub