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
	'Dim namings As String
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Label1 As Label
	Private BtnCheckLimit As Button
	Private BtnMember As Button
	Private BtnProceed As Button
	Private Panel1 As Panel
	
	'Dim interstial As FacebookInterstitial
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("DirectoryPage")
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
    Dim nem As String
	nem=names
	Label1.Text=$"Dear "$&names&$" your details has been saved successfully."$
	Label1.TextColor=Colors.Black
	Label1.TextSize=20
	
	BtnProceed.Text="Proceed to Loan Application"
	BtnProceed.TextColor=Colors.Black
	BtnProceed.TextSize=15
	'BtnProceed.Color=btn

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub BtnProceed_Click
'	If interstial.adReady Then
'		interstial.showAd
'	Else
		StartActivity(EducLevel)
'	End If
	
End Sub