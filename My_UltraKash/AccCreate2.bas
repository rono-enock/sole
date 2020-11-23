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
	Dim locates As String
	Dim pss As String
	Dim col As Int=Colors.ARGB(147,107,228,255)
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private edtLoc As EditText
	Private edtpass As EditText
	Private edtcpass As EditText
	Private edtday As EditText
	Private edtmonth As EditText
	Private edtyear As EditText
	Private Btnsubmit As Button
	Private Panel1 As Panel
	'Dim interstial As FacebookInterstitial
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("AccCreatePage2")
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
	Panel1.Background=page
	
	'interstial.Initialize(Inuka.InterstialUnit,"interstial")
	'interstial.loadAd
	
	edtcpass.InputType=edtcpass.INPUT_TYPE_NUMBERS
	edtpass.InputType=edtpass.INPUT_TYPE_NUMBERS
	
	edtday.InputType=edtday.INPUT_TYPE_NUMBERS
	edtmonth.InputType=edtmonth.INPUT_TYPE_NUMBERS
	edtyear.InputType=edtyear.INPUT_TYPE_NUMBERS
	
	'Btnsubmit.Color=btn
	Btnsubmit.Text="Next"
	Btnsubmit.TextColor=Colors.Black
	Btnsubmit.TextSize=15
	
	edtpass.Hint="Enter Password"
	edtpass.HintColor=btn
	edtpass.TextColor=Colors.Black
	edtpass.TextSize=14
	
	edtcpass.Hint="Confirm Password"
	edtcpass.HintColor=btn
	edtcpass.TextColor=Colors.Black
	edtcpass.TextSize=14
	
	edtLoc.Hint="Location (Country)"
	edtLoc.HintColor=btn
	edtLoc.TextColor=Colors.Black
	edtLoc.TextSize=14
	
	edtday.Hint="Day"
	edtday.HintColor=btn
	edtday.TextColor=Colors.Black
	edtday.TextSize=14
	
	edtmonth.Hint="Month"
	edtmonth.HintColor=btn
	edtmonth.TextColor=Colors.Black
	edtmonth.TextSize=14
	
	edtyear.Hint="Year"
	edtyear.HintColor=btn
	edtyear.TextColor=Colors.Black
	edtyear.TextSize=14
	
	
	
	
End Sub

Sub Activity_Resume

	
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub edtLoc_EnterPressed
	
End Sub

Sub edtpass_EnterPressed
	
End Sub

Sub edtcpass_EnterPressed
	
End Sub

Sub edtday_EnterPressed
	
End Sub

Sub edtmonth_EnterPressed
	
End Sub

Sub edtyear_EnterPressed
	
End Sub
Sub ErrorMeth(msg As String)
	Dim error As String
	Dim title As String="Error"
	Select msg
		Case "loc"
			error="Enter the correct country"
		Case "pass"
			error="Enter password of more than five characters "
		Case "passmatch"
			error="Passsword does not match"
		Case "passEmpt"
			error="First set password"
		Case "day"
			error="Enter the correct day"
		Case "month"
			error="Enter the correct month"
		Case "year"
			error="Applicant must be above 18 years"
		Case "yearerror"
			error="Applicant must be above 18 years"
	End Select
	MsgboxAsync(error,title)
End Sub
Sub Btnsubmit_Click
	Dim loc,pass,pass2,time As String
	Dim match As Matcher
	
	
	
	loc = edtLoc.Text
	match=Regex.Matcher("\d",loc)
	If(loc.Length<5) Or (loc="") Or (loc.Length>12)Then
		ErrorMeth("loc")
		edtLoc.RequestFocus
		Return
	End If
	
	pass=edtpass.Text
	If Not(Regex.IsMatch("\d+",pass)) Or (pass.Length<6) Then
		ErrorMeth("pass")
		edtLoc.RequestFocus
		Return
	End If
	
	pass2=edtcpass.Text
	If (pass="")Then
		ErrorMeth("passEmpt")
		edtcpass.RequestFocus
		Return
	End If
	
	pass2=edtcpass.Text
	If (pass<>pass2) Or ((pass=""))Then
		ErrorMeth("passmatch")
		edtcpass.RequestFocus
		Return
	End If
	
	time=edtday.Text
	If Not(Regex.IsMatch("\d+",time)) Or (time.Length<1) Or (time.Length>2) Or (time>31) Or (time<1)Then
		ErrorMeth("day")
		edtday.RequestFocus
		Return
		End If
		
	time=edtmonth.Text
	If Not(Regex.IsMatch("\d+",time)) Or (time.Length<1) Or (time.Length>2) Or (time>12) Or (time<1)Then
	ErrorMeth("month")
		edtmonth.RequestFocus
		Return
	End If
	
	time=edtyear.Text
	If Not(Regex.IsMatch("\d+",time)) Or (time.Length<>4) Or (time>2002) Then
		ErrorMeth("year")
		edtyear.RequestFocus
		Return
	End If
	time=edtyear.Text
	If (time>2002) Then
		ErrorMeth("yearerror")
		edtyear.RequestFocus
		Return
	End If
	
	pss=edtcpass.Text
	locates=edtLoc.Text
	
	
	Dim list2 As List
	list2.Initialize
	Dim names,ID,Phon As String
	If File.Exists(File.DirInternal,"data.dat")Then
		list2=File.ReadList(File.DirInternal,"data.dat")
		names=list2.Get(0)
		'ID=list2.Get(1)
		Phon=list2.Get(1)
	End If
	
	Dim list2 As List
	list2.Initialize
	list2.Add(names)
	'list2.Add(ID)
	list2.Add(Phon)
	'list2.Add(edtLoc.Text)
	File.WriteList(File.DirInternal,"data.dat",list2)
	'If interstial.adReady Then
	'	interstial.showAd
	'Else
		StartActivity(NextOfKin)
	'End If
	
End Sub