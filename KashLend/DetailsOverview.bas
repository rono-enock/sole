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

	Private Panel1 As Panel
	Private Label1 As Label
	Private Label2 As Label
	Private edtName As EditText
	Private Label3 As Label
	Private edtPhone As EditText
	Private Label4 As Label
	Private edtCountry As EditText
	Private Label5 As Label
	Private edtKinName As EditText
	Private Label6 As Label
	Private edtKinPhone As EditText
	Private Label7 As Label
	Private edtKinCountry As EditText
	Private BtnFinish As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("OverviewPage")
	Activity.Title=Vuka.title
	
	Dim PageColors As ColorDrawable
	PageColors.Initialize(Vuka.B_Colors,0)
	Panel1.Background=PageColors
	
	Label1.Text="Confirm that this are the correct details"
	Label1.TextColor=Colors.Black
	Label1.TextSize=16
	
	Label2.Text="Your name:"
	Label2.TextColor=Colors.Black
	Label2.TextSize=14
	
	Label3.Text="Your phone number:"
	Label3.TextColor=Colors.Black
	Label3.TextSize=14
	
	Label4.Text="Your country:"
	Label4.TextColor=Colors.Black
	Label4.TextSize=14
	
	Label5.Text="Kin's name:"
	Label5.TextColor=Colors.Black
	Label5.TextSize=14
	
	Label6.Text="Kin's phone number:"
	Label6.TextColor=Colors.Black
	Label6.TextSize=14
	
	Label7.Text="Kin's Country:"
	Label7.TextColor=Colors.Black
	Label7.TextSize=14
	
	BtnFinish.Text="Continue"
	BtnFinish.TextColor=Colors.Black
	BtnFinish.TextSize=15
	
	Dim names,phone As String
	Dim list As List
	list.Initialize
	If File.Exists(File.DirInternal,"data.dat")Then
		list=File.ReadList(File.DirInternal,"data.dat")
		names=list.Get(0)
		phone=list.Get(1)
	End If
	
	Dim country As String
	Dim listz As List
	listz.Initialize
	If File.Exists(File.DirInternal,"data2.dat")Then
		listz=File.ReadList(File.DirInternal,"data2.dat")
		country=listz.Get(0)
	End If
	
	Dim kinnames,kinphone,kincountry As String
	Dim lists As List
	lists.Initialize
	If File.Exists(File.DirInternal,"data3.dat")Then
		lists=File.ReadList(File.DirInternal,"data3.dat")
		kinnames=lists.Get(0)
		kinphone=lists.Get(1)
		kincountry=lists.Get(2)
	End If
	
	edtName.Text=names
	edtPhone.Text=phone
	edtCountry.Text=country
	edtKinName.Text=kinnames
	edtKinPhone.Text=kinphone
	edtKinCountry.Text=kincountry
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub BtnFinish_Click
	StartActivity(AccLogin)
End Sub