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
	Dim kin,kinphon,kinloc As String
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Label1 As Label
	Private edtNames As EditText
	Private edtPhone As EditText
	Private edtLocation As EditText
	Private BtnNext As Button
	Private Panel1 As Panel
	
'	Dim interstial As FacebookInterstitial
End Sub
Sub detailss
	
	
End Sub
Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("KinPage")
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
	Panel1.Background=page
	
	'interstial.Initialize(Inuka.InterstialUnit,"Interstial")
	'interstial.loadAd
	
	edtPhone.InputType=edtPhone.INPUT_TYPE_NUMBERS
	
	Label1.TextColor=Colors.Black
	Label1.TextSize=15
	
	'BtnNext.Color=btn
	BtnNext.Text="Next"
	BtnNext.TextColor=Colors.Black
	BtnNext.TextSize=15 
	
	Label1.Text="Provide your next of kin's details"
	
	edtNames.Hint="Names"
	edtNames.HintColor=btn
	edtNames.TextSize=14
	edtNames.TextColor=Colors.Black
	
	edtPhone.Hint="Phone number"
	edtPhone.HintColor=btn
	edtPhone.TextSize=14
	edtPhone.TextColor=Colors.Black
	
	edtLocation.Hint="Relationship (Brother/Sister....)"
	edtLocation.HintColor=btn
	edtLocation.TextSize=14
	edtLocation.TextColor=Colors.Black
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
Sub Errorfun(msg As String)
	Dim error As String
	Dim title As String="Error"
	Select msg
		Case "name"
			error="Enter the correct names"
		Case "phone"
			error="Enter a valid phone number"
		Case "loc"
			error="Enter the correct country"
		Case "nameEmp"
			error="Enter your name"
		Case "phoneEmp"
			error="Enter your phone number"
		Case "locEmp"
			error="Enter your location"
		Case "Emp"
			error="Enter your details"
	End Select
	   MsgboxAsync(error,title)
End Sub
Sub BtnNext_Click
	
	kin=edtNames.Text
	kinphon=edtPhone.Text
	kinloc=edtLocation.Text
	
	Dim nem,loc,phone As String
	Dim match As Matcher
	
	nem=edtNames.Text
	match=Regex.Matcher("\d",nem)
	If(nem.IndexOf(" ")= -1) Or (nem="") Or (match.Find) Or (nem.Length<5)Then
		Errorfun("name")
		edtNames.RequestFocus
		Return
	End If
	
	nem=edtPhone.Text
	If Not(Regex.IsMatch("\d+",nem)) Or (nem="") Or (nem.Length<>10)Then
		Errorfun("phone")
		edtPhone.RequestFocus
		Return
	End If
	
	nem=edtLocation.Text
	match=Regex.Matcher("\d",nem)
	If(nem.Length<5) Or (nem="") Or (nem.Length>12)Then
		Errorfun("loc")
		edtLocation.RequestFocus
		Return
	End If
	
	detailss
	'If interstial.adReady Then
	'	interstial.showAd
	'Else
		StartActivity(DetailsOverView)
	'End If
	
End Sub