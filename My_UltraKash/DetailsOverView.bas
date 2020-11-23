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
	Dim btn As Int = Colors.ARGB(182,223,255,255)
	Dim col As Int = Colors.ARGB(147,107,228,255)
	
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Label1 As Label
	Private edtNames As EditText
	Private edtPhone As EditText
	Private edtLocate As EditText
	Private edtNextOfKin As EditText
	Private edtKinPhone As EditText
	Private edtLocation As EditText
	Private BtnConfirm As Button
	Private Panel1 As Panel
	Private Label2 As Label
	Private Label4 As Label
	Private Label3 As Label
	
	'Dim interstial As FacebookInterstitial
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("OverViewPage")
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
	Panel1.Background=page
	
	'interstial.Initialize(Inuka.InterstialUnit,"interstial")
	'interstial.loadAd
	
	Label2.TextColor=col
	Label2.TextSize=0
	
	edtLocation.TextColor=Colors.Black
	edtLocation.TextSize=14
	
	edtNames.TextColor=Colors.Black
	edtNames.TextSize=14
	
	edtNextOfKin.TextColor=Colors.Black
	edtNextOfKin.TextSize=14
	
	edtPhone.TextColor=Colors.Black
	edtPhone.TextSize=14
	
	edtLocate.TextColor=Colors.Black
	edtLocate.TextSize=14
	
	edtKinPhone.TextColor=Colors.Black
	edtKinPhone.TextSize=14
	
	Label1.Text="Confirm that this are the correct details:"
	Label1.TextColor=Colors.Black
	Label1.TextSize=15
	
	Label3.Text=""
	Label3.TextColor=Colors.Black
	Label3.TextSize=15
	
	Label4.Text="Your next of kin:"
	Label4.TextColor=Colors.Black
	Label4.TextSize=15
	
    'BtnConfirm.Color=btn
	BtnConfirm.Text="Confirm"
	BtnConfirm.TextColor=Colors.Black
	BtnConfirm.TextSize=15
	
End Sub

Sub Activity_Resume
	
	'edtNames.Text=AccCreate.naming
	'edtPhone.Text=AccCreate.phones
	
	'edtLocation.Text=AccCreate2.locates
	
	
	
	Dim list3 As List
	list3.Initialize
	Dim names As String 
	Dim phone As String 
	Dim locaton As String 
	If File.Exists(File.DirInternal,"data.dat")Then
		list3=File.ReadList(File.DirInternal,"data.dat")
		names=list3.Get(0)
		phone=list3.Get(1)
		'locaton=list3.Get(2)
	End If
	edtNames.Text=names
	edtPhone.Text=phone
	'edtLocate.Text=locaton
	edtLocate.Text=$"${AccCreate2.locates}"$
	edtKinPhone.Text=$"${NextOfKin.kinphon}"$
	edtLocation.Text=$"${NextOfKin.kinloc}"$
	edtNextOfKin.Text=$"${NextOfKin.kin}"$
	
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub BtnConfirm_Click
	
	Label2.Text=AccCreate2.pss
	Dim list4 As List
	list4.Initialize
	list4.Add(edtNames.Text)
	list4.Add(edtPhone.Text)
	'list4.Add(edtLocate.Text)
	'list4.Add(edtNextOfKin.Text)
	'list4.Add(edtKinPhone.Text)
	'list4.Add(edtLocation.Text)
	list4.Add(Label2.Text)
	File.WriteList(File.DirInternal,"data.dat",list4)
	ProgressDialogShow2("Saving your details...", False)
	Sleep(2000)
	ProgressDialogHide
	'If interstial.adReady Then
	'	interstial.showAd
	'Else
		StartActivity(AccLogins)
	'End If
	
End Sub