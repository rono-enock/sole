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
	Dim GAmount As String
	Dim GPeriod As String
	
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Label1 As Label
	Private LabelAmount As Label
	Private edtAmount As EditText
	Private LabelDueDate As Label
	'Private edtDueDate As EditText
	Private LabelInterest As Label
	Private BtnContinue As Button
	Private Panel1 As Panel
	Private edtDueDates As EditText
	
	'Dim interstial As FacebookInterstitial
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("ApplyPage")
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
	Panel1.Background=page
	'BtnContinue.Color=btn
	
	'interstial.Initialize(Inuka.InterstialUnit,"Interstial")
	'interstial.loadAd
	
	edtAmount.InputType=edtAmount.INPUT_TYPE_NUMBERS
	edtDueDates.InputType=edtDueDates.INPUT_TYPE_NUMBERS
	
	Label1.Text="Loan description"
	Label1.TextColor=Colors.Black
	Label1.TextSize=14
	
    LabelAmount.Text="Amount"
	LabelAmount.TextColor=Colors.Black
	LabelAmount.TextSize=14
	
	edtAmount.TextColor=Colors.Black
	edtAmount.TextSize=14
	edtAmount.Hint="Ksh"
	edtAmount.HintColor=btn
	
	LabelDueDate.Text="Period"
	LabelDueDate.TextColor=Colors.Black
	LabelDueDate.TextSize=14
	
	edtDueDates.TextColor=Colors.Black
	edtDueDates.TextSize=14
	edtDueDates.Hint="Months (3-6)"
	edtDueDates.HintColor=btn
	
	LabelInterest.Text=$"Loan interest is calculated as per the period entered a bove.
Interest rate is 0.025%"$
	LabelInterest.TextColor=Colors.Black
	LabelInterest.TextSize=14
	
	BtnContinue.Text="Continue"
	BtnContinue.TextColor=Colors.Black
	BtnContinue.TextSize=15
	
	
		
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnContinue_Click
	
	
	Dim lists As List
	lists.Initialize
	Dim names,phon As String
	If File.Exists(File.DirInternal,"data.dat")Then
		lists=File.ReadList(File.DirInternal,"data.dat")
		names=lists.Get(0)
		phon=lists.Get(1)
	End If
	
	Dim list4 As List
	list4.Initialize
	list4.Add(names)
	list4.Add(phon)
	list4.Add(edtAmount.Text)
	list4.Add(edtDueDates.Text)
	

	File.WriteList(File.DirInternal,"data1.dat",list4)
	GAmount=edtAmount.Text
	GPeriod=edtDueDates.Text
	
	If(GAmount ="") Or (GPeriod ="") Then
		MsgboxAsync("Enter valid details","Invalid choice")
	Else If (GAmount > Starter.limit) Then
		MsgboxAsync("You can't qualify for that amount","Invalid choice")
	Else If (GAmount < 100)Then
		MsgboxAsync("Ksh.100 is the minimum amount you can apply","Invalid choice")
	Else If (GPeriod < 3) Or (GPeriod.Length <> 1) Or(GPeriod>6) Then
		MsgboxAsync("Enter a valid period","Invalid choice")
	Else If Not(GAmount ="") And Not(GPeriod ="") And Not(GAmount > Starter.limit) And Not(GPeriod < 3) And (GPeriod.Length = 1) And Not(GAmount <100) And Not(GPeriod > 10) Then
		'If interstial.adReady Then
		'	interstial.showAd
		'Else
			StartActivity(ApplicationConfirm)
		'End If
			
		
	End If
	
	
End Sub