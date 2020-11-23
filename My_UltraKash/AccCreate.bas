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
	Dim naming As String
	Dim phones As String
	Dim namings As String
	'Dim namins As String
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private edtName As EditText
	Private edtMail As EditText
	Private edtPhone As EditText
	Private edtID As EditText
	Private BtnNext As Button
	Private Panel1 As Panel
	
	'Dim interstial As FacebookInterstitial
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("AccCreatePage1")
	
	'interstial.Initialize(Inuka.Interstials, "Interstial")
	'interstial.enableTesting(True, Inuka.devicetest)
	'interstial.loadAd
	
	'interstial.Initialize(Inuka.InterstialUnit,"Interstial")
	'interstial.loadAd
	
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
    Panel1.Background=page
	
	'BtnNext.Color=btn
	BtnNext.Text="Next"
	BtnNext.TextColor=Colors.Black
	BtnNext.TextSize=15
	
	edtPhone.InputType=edtPhone.INPUT_TYPE_PHONE
	edtID.InputType=edtID.INPUT_TYPE_PHONE
	
	edtName.Hint="Full Names"
	edtName.TextColor=Colors.Black
	edtName.TextSize=14
	edtName.HintColor=btn
	
	edtMail.Hint="E-mail Address"
	edtMail.TextColor=Colors.Black
	edtMail.TextSize=14
	edtMail.HintColor=btn
	
	edtPhone.Hint="Phone number"
	edtPhone.TextColor=Colors.Black
	edtPhone.TextSize=14
	edtPhone.HintColor=btn
	
	edtID.Hint="ID Number"
	edtID.TextColor=Colors.Black
	edtID.TextSize=14
	edtID.HintColor=btn
	'namins=edtName.Text.Trim
	'namings=namins.Trim
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub Displayerror(msg As String)
	Dim error As String
	Dim title As String="Error"
	Select msg
		Case "name"
			error="Enter correct names"
		Case "ID"
			error="Enter correct National ID"
		Case "phone"
			error="Enter a valid phone number"	
		Case "email"
			error="Enter a valid e-mail"
	End Select
	MsgboxAsync(error, title)
End Sub
Sub BtnNext_Click
	
	naming=edtName.Text
	phones=edtPhone.Text
	Dim list1 As List
	list1.Initialize
	list1.Add(edtName.Text)
	'list1.Add(edtID.Text)
	list1.Add(edtPhone.Text)
	File.WriteList(File.DirInternal,"data.dat",list1)
	
	
	Dim nem,nam As String
	Dim match As Matcher
	nem=edtName.Text
	match=Regex.Matcher("\d",nem)
	If(nem.IndexOf(" ")= -1) Or (match.Find) Or (nem.Length<5)Then
		Displayerror("name")
		edtName.RequestFocus
		Return
	End If
	
	nem = edtMail.Text.Trim
	If Not(Regex.IsMatch("\S+@\S+\.\S+",nem)) Then
		Displayerror("email")
		edtMail.RequestFocus
		Return
	End If
	
	nem=edtID.Text
	If Not(Regex.IsMatch("\d+",nem)) Or (nem.Length <7) Or (nem.Length > 8) Then
		Displayerror("ID")
		edtID.RequestFocus
		Return
	End If
	
	
	
	nem=edtPhone.Text
	If Not(Regex.IsMatch("\d+",nem)) Or (nem.Length <> 10) Then
		Displayerror("phone")
		edtPhone.RequestFocus
		Return
	End If
	
	
	'DetailsFetch
'	If interstial.adReady Then
'		interstial.showAd
'	Else
		StartActivity(AccCreate2)
'	End If
	
End Sub

Sub Inter_onAdDismissed
	StartActivity(AccCreate2)
End Sub