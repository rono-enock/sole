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
	Private Label1 As Label
	Private LabelReviewName As Label
	Private LabelAmountName As Label
	Private BtnBack As Button
	Private BtnReapply As Button
	Private LabelAmountPhone As Label
	Private LabelReview As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("ReviewPage")
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
	Panel1.Background=page
	
	
	
Dim lists As List
lists.Initialize
Dim names,phon As String
If File.Exists(File.DirInternal,"data.dat")Then
	lists=File.ReadList(File.DirInternal,"data.dat")
	names=lists.Get(2)
	phon=lists.Get(3)
	
	LabelAmountPhone.Text=$"Ksh."$&names&$" will be credited to phone No."$&phon&$" within 24 hours"$
	LabelAmountPhone.Color=Colors.White
	LabelAmountPhone.TextSize=14
	LabelAmountPhone.TextColor=Colors.Black
	Else
		LabelAmountPhone.Text="You have not applied for any loan"
End If
		
		
		
	
		'names=Apply.GAmount
		'phon=Apply.GPeriod
		LabelReview.Text="Reviewing :"
		LabelReview.Color=Colors.White
		LabelReview.TextSize=14
		LabelReview.TextColor=Colors
	
		
	
		
		
	
		
		
     
	
	Label1.TextSize=14
	Label1.TextColor=Colors.Black
	Label1.Text=$"Your loan application is in review.Due to the on going system update and maintenace,your loan will be processed within 48 hours.
We are sorry for the inconvinience caused."$
	
	
	LabelAmountName.Text="Loan Details :"
	LabelAmountName.TextSize=14
	LabelAmountName.TextColor=Colors.Black
	
	LabelReviewName.Text="Loan Status :"
	LabelReviewName.TextSize=14
	LabelReviewName.TextColor=Colors.Black
	
	BtnBack.Text="Back:"
	BtnBack.TextSize=15
	BtnBack.Color=btn
	BtnBack.TextColor=Colors.Black
	
	BtnReapply.Text="Reapply:"
	BtnReapply.Color=btn
	BtnReapply.TextSize=15
	BtnReapply.TextColor=Colors.Black
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnReapply_Click
	StartActivity(Apply)
End Sub

Sub BtnBack_Click
	StartActivity(Directory)
End Sub