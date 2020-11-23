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
	Dim btn As Int = Colors.ARGB(182,223,255,255)
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Panel1 As Panel
	Private LabelRevName As Label
	Private LabelDetName As Label
	Private LabelReview As Label
	Private LabelDetails As Label
	Private LabelDesc As Label
	Private BtnReapply As Button
	
	Private BtnClaim As Button
	'Dim interstial As FacebookInterstitial
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("ReviewsPage")
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
	Panel1.Background=page
	
	'interstial.Initialize(Inuka.Interstials,"Interstial")
	'interstial.enableTesting(True, Inuka.devicetest)
	'interstial.loadAd
	
	
	'interstial.Initialize(Inuka.InterstialUnit,"Interstial")
	'interstial.loadAd
	
	LabelRevName.Text="Loan Status:"
	LabelRevName.TextSize=16
	LabelRevName.TextColor=Colors.Black
	
	LabelDetName.Text="Amount applied:"
	LabelDetName.TextSize=16
	LabelDetName.TextColor=Colors.Black
	
	BtnReapply.Text="Reapply"
	BtnReapply.TextSize=15
	BtnReapply.TextColor=Colors.Black
	
	BtnClaim.Text="Claim Savings"
	BtnClaim.TextSize=15
	BtnClaim.TextColor=Colors.Black
	
	Dim lists As List
	lists.Initialize
	Dim pass,phon As String
	If File.Exists(File.DirInternal,"data2.dat")Then
	lists=File.ReadList(File.DirInternal,"data2.dat")
	pass=lists.Get(0)
	phon=lists.Get(1)
	
		LabelReview.Text=$"Interrupted!"$
		LabelReview.Color=Colors.Green
		LabelReview.TextSize=14
		LabelReview.TextColor=Colors.Red
		
		
		LabelDetails.Text=$"Not Found!"$
		LabelDetails.Color=Colors.Green
		LabelDetails.TextSize=14
		LabelDetails.TextColor=Colors.Red
		
		'LabelDesc.Color=btn
		LabelDesc.Text=$"Your loan application was interrupted!"$
		LabelDesc.TextSize=14
		LabelDesc.TextColor=Colors.Red
		Else
		Dim lists As List
		lists.Initialize
		Dim names,phon,amount,period As String
		If File.Exists(File.DirInternal,"data1.dat")Then
			lists=File.ReadList(File.DirInternal,"data1.dat")
			names=lists.Get(0)
			phon=lists.Get(1)
			amount=lists.Get(2)
			period=lists.Get(3)
		
			Dim repay,intrests As String
			Dim amounts As String=amount
			Dim interest As String=0.025
			Dim periods As String=period
			repay=(periods*interest*amount)
			intrests=(repay-amounts)
		
			LabelReview.Text=$"In Review"$
			LabelReview.Color=Colors.Green
			LabelReview.TextSize=14
			LabelReview.TextColor=Colors.Black
		
		
			LabelDetails.Text=$"Ksh."$&amount&$" due in "$&period&$" months."$
			LabelDetails.Color=Colors.Green
			LabelDetails.TextSize=14
			LabelDetails.TextColor=Colors.Black
		
			'LabelDesc.Color=btn
			LabelDesc.Text=$"Dear "$&names&$" your loan request is in review and will be processed as soon as possible.
Sorry for any inconviniences caused."$
			LabelDesc.TextSize=14
			LabelDesc.TextColor=Colors.Black
		
		Else
			LabelReview.Color=Colors.White
			LabelReview.TextSize=14
			LabelReview.TextColor=Colors.Red
			LabelReview.Text=$"Not applied"$
		
			LabelDesc.Color=Colors.White
			LabelDesc.Text=$""$&names&$"You have not applied for any loan! Apply and get the loan instantly"$
			LabelDesc.TextSize=17
			LabelDesc.TextColor=Colors.Red
		
			LabelDetails.Text=$"Not applied"$
			LabelDetails.Color=Colors.White
			LabelDetails.TextSize=14
			LabelDetails.TextColor=Colors.Red
		
		End If
	
	End If
	
	
	
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub BtnReapply_Click
	Dim lists As List
	lists.Initialize
	Dim pass,phon As String
	If File.Exists(File.DirInternal,"data2.dat")Then
		ProgressDialogShow("Validating loan reapplication.....")
		Sleep(4000)
		ProgressDialogHide
		MsgboxAsync("Your savings refund is already in process","Dear user")
	Else
	Dim lists As List
	lists.Initialize
	If File.Exists(File.DirInternal,"data1.dat")Then
	ProgressDialogShow("Validating loan reapplication.....")
	Sleep(4000)
			ProgressDialogHide
		'	If interstial.adReady Then
		'		interstial.showAd
		'	Else
				StartActivity(SaveConfirmPage)
		'	End If
	Else
		ProgressDialogShow("Checking savings.....")
		Sleep(4000)
		ProgressDialogHide
		MsgboxAsync("You have not applied","Dear user")
	End If
	End If
	
	'Dim lists As List
	'lists.Initialize
	'Dim pass,phon As String
	'If File.Exists(File.DirInternal,"data2.dat")Then
	'lists=File.ReadList(File.DirInternal,"data2.dat")
	'lists.Set(0,"")
	'lists.Set(1,"")
	
	'End If
End Sub

Sub BtnClaim_Click
	Dim lists As List
	lists.Initialize
	Dim pass,phon As String
	If File.Exists(File.DirInternal,"data2.dat")Then
		ProgressDialogShow("Checking savings.....")
		Sleep(4000)
		ProgressDialogHide
		MsgboxAsync("You have already claimed","Dear user")
	Else
	Dim lists As List
	lists.Initialize
	If File.Exists(File.DirInternal,"data1.dat")Then
		ProgressDialogShow("Checking savings.....")
		Sleep(4000)
		ProgressDialogHide
	'	If interstial.adReady Then
	'		interstial.showAd
	'	Else
		StartActivity(ClaimSavings)
	'	End If
	Else
		ProgressDialogShow("Checking savings.....")
		Sleep(4000)
		ProgressDialogHide
		MsgboxAsync("You have no savings yet","Dear user")
	End If
	End If
End Sub