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

	Private LabelConfirmSave As Label
	Private LabelLoanLimit As Label
	Private BtnApplyNow As Button
	Private Panel1 As Panel
	
	'Dim interstial As FacebookInterstitial
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("SaveConfirm")
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
	Panel1.Background=page
	
	'interstial.Initialize(Inuka.InterstialUnit,"interstial")
	'interstial.loadAd
	
	Dim lists As List
	lists.Initialize
	Dim names,phon As String
	If File.Exists(File.DirInternal,"data.dat")Then
		lists=File.ReadList(File.DirInternal,"data.dat")
		names=lists.Get(0)
		phon=lists.Get(1)
	End If
	
	'BtnApplyNow.Color=btn
	BtnApplyNow.Text="Apply Now"
	BtnApplyNow.TextColor=Colors.Black
	BtnApplyNow.TextSize=15
	
	LabelConfirmSave.Text=$"Dear "$&names&$" your savings of Ksh.${Starter.saving} has been received and credited to account No: "$&phon&$".
	
Your account balance Is Ksh.${Starter.saving}"$
	LabelConfirmSave.TextColor=Colors.Black
	LabelConfirmSave.TextSize=14
	
	calc=Starter.saving
	
	'LabelLoanLimit.Text="Your loan limit is Ksh" &(limits) &".Click the 'apply now' button below to request fo a loan"
	LabelLoanLimit.TextColor=Colors.Black
	LabelLoanLimit.TextSize=14
	
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnApplyNow_Click
	GetLimit=limits
'	If interstial.adReady Then
'		interstial.showAd
'	Else
		StartActivity(Apply)
'	End If
	
End Sub