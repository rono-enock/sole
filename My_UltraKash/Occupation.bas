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
	Dim paging As Int= Colors.ARGB(147,107,228,255)
	Dim reason As String
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Panel1 As Panel
	Private Label1 As Label
	Private Label2 As Label
	'Private ListOccupation As ListView
	'Private ListSalaryRange As ListView
	Private edtReason As EditText
	Private BtnNext As Button
	Private SpinOccupation As Spinner
	Private SpinSalary As Spinner
	
	'Dim interstial As FacebookInterstitial
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("OccupationPage")
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
	Panel1.Background=page
	
'	interstial.Initialize(Inuka.InterstialUnit,"Interstial")
'	interstial.showAd
	
	'BtnNext.Color=btn
	BtnNext.Text="Next"
	BtnNext.TextColor=Colors.Black
	BtnNext.TextSize=15
	
	Label1.Text="Occupation:"
	Label1.TextColor=Colors.Black
	Label1.TextSize=14
	
	Label2.Text="Range of salary:"
	Label2.TextColor=Colors.Black
	Label2.TextSize=14
	
	SpinOccupation.Color=btn
	SpinOccupation.TextColor=Colors.Black
	SpinOccupation.TextSize=14
	SpinOccupation.DropdownBackgroundColor=Colors.Black
	SpinOccupation.DropdownTextColor=paging
	
	SpinSalary.Color=btn
	SpinSalary.TextColor=Colors.Black
	SpinSalary.TextSize=14
	SpinSalary.DropdownTextColor=paging
	SpinSalary.DropdownBackgroundColor=Colors.Black
	SpinSalary.Visible=True
	
	edtReason.Hint="Give a brief reason for loan application"
	edtReason.HintColor=Colors.Blue
	edtReason.Color=btn
	edtReason.TextColor=Colors.Black
	
	SpinOccupation.AddAll(Array As String("Employed", "Self-employed", "Unemployed"))
	SpinOccupation.SelectedIndex = 0
	
	SpinSalary.AddAll(Array As String("1,000-5,000", "5,000-10,000", "10,000-15,000","15,000-20,000","Above 20,000"))
	SpinSalary.SelectedIndex = 0
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnNext_Click
	reason=edtReason.Text
	If Not(reason = " ") And Not(reason.Length<40) Then
	'	If interstial.adReady Then
	'		interstial.showAd
	'	Else
			StartActivity(TillSavings)
	'	End If
		
	Else If(reason = "")Then
		MsgboxAsync("You must give a reason","Details Missing")
	Else If(reason.Length<40)Then
		MsgboxAsync("Give a good reason","Invalid Reason")
	End If
	
End Sub