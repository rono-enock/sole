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
	Private edtPin As EditText
	Private edtID As EditText
	Private BtnNext As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("IDPage")
	Activity.Title=Vuka.title
	
	Dim PageColors As ColorDrawable
	PageColors.Initialize(Vuka.B_Colors,0)
	Panel1.Background=PageColors
	
	edtID.InputType=edtID.INPUT_TYPE_NUMBERS
	edtPin.InputType=edtPin.INPUT_TYPE_NUMBERS
	
	edtPin.Hint="Enter password"
	edtPin.TextColor=Colors.Black
	edtPin.TextSize=14
	
	edtID.Hint="Enter ID number"
	edtID.TextColor=Colors.Black
	edtID.TextSize=14
	
	BtnNext.Text="Next"
	BtnNext.TextColor=Colors.Black
	BtnNext.TextSize=15
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnNext_Click
	Dim password As String
	Dim list As List
	list.Initialize
	list.Add(edtPin.Text)
	File.WriteList(File.DirInternal,"data1.dat",list)
	
	If Not(edtPin.Text="") And Not(edtPin.Text.Length<6) And Not(edtID.Text="") And Not(edtID.Text.Length<7 Or edtID.Text.Length>8) Then
		StartActivity(Location)
	Else
		MsgboxAsync("Enter the correct details","Error")
	End If
	
	
End Sub