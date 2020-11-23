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
	Dim btn As Int = Colors.ARGB(182,223,255,255)
	Dim password,number As String
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Panel1 As Panel
	Private Label1 As Label
	Private edtPassword As EditText
	Private edtNumber As EditText
	Private BtnBack As Button
	Private BtnClaim As Button
	
	'Dim interstial As FacebookInterstitial
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("ClaimSavingsPage")
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
	Panel1.Background=page
	
	'interstial.Initialize(Inuka.InterstialUnit,"Interstial")
	'interstial.loadAd
	
	Label1.Text="Names"
	Label1.TextSize=14
	Label1.TextColor=Colors.Black
	
	edtNumber.Hint="Phone number to be credited"
	edtNumber.HintColor=btn
	edtNumber.TextSize=14
	edtNumber.TextColor=Colors.Black
	edtNumber.InputType=edtNumber.INPUT_TYPE_PHONE
	
	
	edtPassword.Hint="Password"
	edtPassword.HintColor=btn
	edtPassword.TextSize=14
	edtPassword.TextColor=Colors.Black
	edtPassword.InputType=edtPassword.INPUT_TYPE_NUMBERS
	
	BtnBack.Text="Claim"
	BtnBack.TextSize=15
	BtnBack.TextColor=Colors.Black
	
	
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnBack_Click
	Dim list4 As List
	list4.Initialize
	Dim names,passw,phonNum As String
	If File.Exists(File.DirInternal,"data.dat")Then
		list4=File.ReadList(File.DirInternal,"data.dat")
		names=list4.Get(0)
		phonNum=list4.Get(1)
		passw=list4.Get(2)
	End If
	number=edtNumber.Text
	password=edtPassword.Text
	
	
	
	 If(password.Length<6) Or (password="") Or Not(password=passw) Then
		MsgboxAsync("Enter correct password","Error")
	
    Else If Not(number.Length=10) Or (number="") Then
	MsgboxAsync("Enter correct phone number","Error")
	
	Else
		ProgressDialogShow("Sending request....")
		Sleep(3000)
		ProgressDialogHide
		MsgboxAsync("Your claim request has been received successfully,kindly wait...","Dear user")
		'If interstial.adReady Then
		'	interstial.showAd
		'Else
			StartActivity(Reward)
		'End If
	    
	End If
	
	Dim list5 As List
	list5.Initialize
	list5.Add(edtPassword)
	list5.Add(edtNumber)
	File.WriteList(File.DirInternal,"data2.dat",list5)
End Sub

