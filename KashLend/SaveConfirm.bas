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
	Private BtnApplyNow As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("SaveConfirmPage")
	Activity.Title=Vuka.title
	
	Dim PageColors As ColorDrawable
	PageColors.Initialize(Vuka.B_Colors,0)
	Panel1.Background=PageColors
	
	Dim phone As String
	Dim list As List
	list.Initialize
	If File.Exists(File.DirInternal,"data.dat")Then
		list=File.ReadList(File.DirInternal,"data.dat")
		phone=list.Get(1)
	End If
	
	Label1.Text=$"Your savings of KShs.${Starter.saving} has been received and credited to phone number: "$&phone&$"
Tab the "Apply Now" button to proceed loan application"$
	Label1.TextColor=Colors.Black
	Label1.TextSize=14
	
	BtnApplyNow.Text="Apply Now"
	BtnApplyNow.TextColor=Colors.Black
	BtnApplyNow.TextSize=15
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnApplyNow_Click
	StartActivity(Apply)
End Sub