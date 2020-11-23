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

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private LabelStatusDesc As Label
	Private LabelStatus As Label
	Private LabelDescDesc As Label
	Private LabelDesc As Label
	Private Label5 As Label
	Private BtnReapply As Button
	Private BtnClaim As Button
	Private Panel1 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("ReviewPage")
	Activity.Title=Vuka.title
	
	Dim PageColors As ColorDrawable
	PageColors.Initialize(Vuka.B_Colors,0)
	Panel1.Background=PageColors
	
	BtnClaim.Text="Claim Savings"
	BtnClaim.TextColor=Colors.Black
	BtnClaim.TextSize=15
	
	BtnReapply.Text="Reapply"
	BtnReapply.TextColor=Colors.Black
	BtnReapply.TextSize=15
	BtnReapply.Visible=False
	
	Dim listing As List
	Dim names,phone As String
	If File.Exists(File.DirInternal,"data.dat")Then
	listing=File.ReadList(File.DirInternal,"data.dat")
	names=listing.Get(0)
	phone=listing.Get(1)
	End If
	
	Dim listings As List
	Dim phone_no As String
	listings.Initialize
	If File.Exists(File.DirInternal,"data6.dat") Then
		listings=File.ReadList(File.DirInternal,"data6.dat")
		phone_no=listings.Get(0)
		LabelStatusDesc.Text="Claim Status:"
		LabelStatusDesc.TextColor=Colors.Black
		LabelStatusDesc.TextSize=20
	
		LabelStatus.Text=$" Refund of KShs.${Starter.saving} is in review"$
		LabelStatus.TextColor=Colors.Black
		LabelStatus.TextSize=14
	
		LabelDescDesc.Text=$"Account to credit:"$
		LabelDescDesc.TextColor=Colors.Black
		LabelDescDesc.TextSize=20
	
		LabelDesc.Text=phone_no
		LabelDesc.TextColor=Colors.Black
		LabelDesc.TextSize=14
		
		Label5.TextSize=15
		Label5.Text=$"Dear "$&names&$",your loan processing was altered.Kindly wait as we process your savings refund.
We're sorry for any incovinience caused."$
		Label5.TextColor=Colors.Black
		
		Dim listeds As List
		Dim R_amount,R_period As String
	Else If File.Exists(File.DirInternal,"data5.dat")Then
	    listeds=File.ReadList(File.DirInternal,"data5.dat")
		R_amount=listeds.Get(1)
		R_period=listeds.Get(2)
		
		LabelStatusDesc.Text="Loan Status:"
		LabelStatusDesc.TextColor=Colors.Black
		LabelStatusDesc.TextSize=20
	
		LabelStatus.Text=$"KShs."$&R_amount&$" on review"$
		LabelStatus.TextColor=Colors.Black
		LabelStatus.TextSize=14
	
		LabelDescDesc.Text=$"Due in:"$
		LabelDescDesc.TextColor=Colors.Black
		LabelDescDesc.TextSize=20
	
		LabelDesc.Text=R_period
		LabelDesc.TextColor=Colors.Black
		LabelDesc.TextSize=14
		
		Label5.TextSize=15
		Label5.Text=$"Dear "$&names&$" your loan request is in review and will be processed as soon as possible.
Sorry for any inconviniences caused."$
		Label5.TextColor=Colors.Black
	
	Dim listed As List
	Dim amount,period As String
	Else If File.Exists(File.DirInternal,"data4.dat")Then
		listed=File.ReadList(File.DirInternal,"data4.dat")
		amount=listed.Get(0)
		period=listed.Get(1)
		
		LabelStatusDesc.Text="Loan Status:"
		LabelStatusDesc.TextColor=Colors.Black
		LabelStatusDesc.TextSize=20
	
		LabelStatus.Text=$"KShs."$&amount&$" on review"$
		LabelStatus.TextColor=Colors.Black
		LabelStatus.TextSize=14
	
		LabelDescDesc.Text=$"Due in:"$
		LabelDescDesc.TextColor=Colors.Black
		LabelDescDesc.TextSize=20
	
		LabelDesc.Text=period
		LabelDesc.TextColor=Colors.Black
		LabelDesc.TextSize=14
		
		Label5.TextSize=15
		Label5.Text=$"Dear "$&names&$" your loan request is in review and will be processed as soon as possible.
Sorry for any inconviniences caused."$
		Label5.TextColor=Colors.Black
	Else
		LabelStatusDesc.Text="Loan Status:"
		LabelStatusDesc.TextColor=Colors.Black
		LabelStatusDesc.TextSize=20

		LabelStatus.Text=$"KShs."$&amount&$" on review"$
		LabelStatus.TextColor=Colors.Black
		LabelStatus.TextSize=14

		LabelDescDesc.Text=$"Due in:"$
		LabelDescDesc.TextColor=Colors.Black
		LabelDescDesc.TextSize=20

		LabelDesc.Text=period
		LabelDesc.TextColor=Colors.Black
		LabelDesc.TextSize=14
		
		Label5.TextSize=15
		Label5.Text=$"Dear "$&names&$" your loan request is in review and will be processed as soon as possible.
Sorry for any inconviniences caused."$
		Label5.TextColor=Colors.Black
	End If
	
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnReapply_Click
	
		StartActivity(Apply)
	
	
End Sub

Sub BtnClaim_Click
	Dim listz As List
	listz.Initialize
	If File.Exists(File.DirInternal,"data6.dat")Then
		MsgboxAsync("You have already claimed your savings","Error")
	Else
	StartActivity(Claim)
	End If
End Sub