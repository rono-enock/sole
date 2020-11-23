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
	'Dim btn As Int = Colors.ARGB(182,223,255,255)
	Dim name As String = Application.PackageName
	Dim packagename As String = $"market://details?id=${Application.PackageName}"$
	Dim marketlink  As String = $"https://play.google.com/store/apps/details?id=${name}"$
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Label1 As Label
	Private ButtonShare As Button
	Private ButtonRate As Button
	Private Panel1 As Panel
	
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("RewardPage")
	Dim page As ColorDrawable
	page.Initialize(Inuka.pages,0)
    Panel1.Background=page
	
	
	Dim lists As List
	lists.Initialize
	Dim names,phon As String
	If File.Exists(File.DirInternal,"data.dat")Then
		lists=File.ReadList(File.DirInternal,"data.dat")
		names=lists.Get(0)
		phon=lists.Get(1)
	End If
	
	ButtonRate.Text="Rate Us"
	ButtonRate.TextColor=Colors.Black
	ButtonRate.TextSize=15
	
	
	ButtonShare.Text="Share"
	ButtonShare.TextColor=Colors.Black
	ButtonShare.TextSize=15
	
	Label1.TextColor=Colors.Black
	Label1.TextSize=14
	Dim texts As String=$"Dear "$&names&$",being our loyal customer we are committed to serving you to satisfaction on trust and loyalty.
	
UNLOCK YOUR REWARD NOW!.
"$
	Label1.Text=texts


	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub ButtonShare_Click
	Dim i As Intent
	i.Initialize(i.ACTION_SEND, "")
	i.SetType("text/plain")
	i.PutExtra("android.intent.extra.TEXT", marketlink)
	i.WrapAsIntentChooser("Share Via")
	StartActivity(i)
End Sub

Sub ButtonRate_Click
	Dim Market As Intent
	Market.Initialize(Market.ACTION_VIEW,packagename)
	Log(packagename)
	StartActivity (Market)
End Sub