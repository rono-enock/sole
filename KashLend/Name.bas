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
	Private edtName As EditText
	Private edtPhone As EditText
	Private BtnNext As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("NamesPage")
	Activity.Title=Vuka.title
	Dim PageColors As ColorDrawable
	PageColors.Initialize(Vuka.B_Colors,0)
	Panel1.Background=PageColors
	
	edtName.Hint="Full names"
	edtName.TextColor=Colors.Black
	edtName.TextSize=14
	
	edtPhone.InputType=edtPhone.INPUT_TYPE_NUMBERS
	
	edtPhone.Hint="Phone number"
	edtPhone.TextColor=Colors.Black
	edtPhone.TextSize=14
	
	BtnNext.Text="Next"
	BtnNext.TextColor=Colors.Black
	BtnNext.TextSize=15
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnNext_Click
	
	Dim list As List
	list.Initialize
	list.Add(edtName.Text)
	list.Add(edtPhone.Text)
	File.WriteList(File.DirInternal,"data.dat",list)
	
	If Not (edtName.Text="") And (edtName.Text.Length>6) And Not (edtPhone.Text="") And (edtPhone.Text.Length=10) Then
		StartActivity(Id_Number)
		
	Else
		MsgboxAsync("Enter the correct details","Error")
	End If
	
	
End Sub