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

	Private Label1 As Label
	Private Panel1 As Panel
	Private B1 As Button
	Private B2 As Button
	Private B3 As Button
	Private B4 As Button
	Private B5 As Button
	Private B6 As Button
	Private B7 As Button
	Private B_X As Button
	Private B8 As Button
	Private B9 As Button
	Private B0 As Button
	Private B_OK As Button
	Private PasswordLabel As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("AccLoginsPage")
	Activity.Title=Vuka.title
	
	Dim PageColors As ColorDrawable
	PageColors.Initialize(Vuka.B_Colors,0)
	Panel1.Background=PageColors
	
	Label1.Text="Enter your password"
	Label1.TextColor=Colors.Black
	Label1.TextSize=18
	
	PasswordLabel.Color=Colors.White
	Label1.TextColor=Colors.Black
	Label1.TextSize=14
	
	B_OK.Text="OK"
	B_OK.TextColor=Colors.Black
	B_OK.TextSize=15
	
	B1.Text="1"
	B1.TextColor=Colors.Black
	B1.TextSize=15
	
	B2.Text="2"
	B2.TextColor=Colors.Black
	B2.TextSize=15
	
	B3.Text="3"
	B3.TextColor=Colors.Black
	B3.TextSize=15
	
	B4.Text="4"
	B4.TextColor=Colors.Black
	B4.TextSize=15
	
	B5.Text="5"
	B5.TextColor=Colors.Black
	B5.TextSize=15
	
	B6.Text="6"
	B6.TextColor=Colors.Black
	B6.TextSize=15
	
	B7.Text="7"
	B7.TextColor=Colors.Black
	B7.TextSize=15
	
	B8.Text="8"
	B8.TextColor=Colors.Black
	B8.TextSize=15
	
	B9.Text="9"
	B9.TextColor=Colors.Black
	B9.TextSize=15
	
	B0.Text="0"
	B0.TextColor=Colors.Black
	B0.TextSize=15
	
	B_X.Text="DEL"
	B_X.TextColor=Colors.Black
	B_X.TextSize=15
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub B1_Click
	PasswordLabel.Text=PasswordLabel.Text& B1.Text
End Sub

Sub B2_Click
	PasswordLabel.Text=PasswordLabel.Text& B2.Text
End Sub

Sub B3_Click
	PasswordLabel.Text=PasswordLabel.Text& B3.Text
End Sub

Sub B4_Click
	PasswordLabel.Text=PasswordLabel.Text& B4.Text
End Sub

Sub B5_Click
	PasswordLabel.Text=PasswordLabel.Text& B5.Text
End Sub

Sub B6_Click
	PasswordLabel.Text=PasswordLabel.Text& B6.Text
End Sub

Sub B7_Click
	PasswordLabel.Text=PasswordLabel.Text& B7.Text
End Sub

Sub B_X_Click
	PasswordLabel.Text=""
End Sub

Sub B8_Click
	PasswordLabel.Text=PasswordLabel.Text& B8.Text
End Sub

Sub B9_Click
	PasswordLabel.Text=PasswordLabel.Text& B9.Text
End Sub

Sub B0_Click
	PasswordLabel.Text=PasswordLabel.Text& B0.Text
End Sub

Sub B_OK_Click
	
	Dim password As String
	Dim list As List
	list.Initialize
	If File.Exists(File.DirInternal,"data1.dat")Then
		list=File.ReadList(File.DirInternal,"data1.dat")
		password=list.Get(0)
	End If
	
	If PasswordLabel.Text=password Then
		If File.Exists(File.DirInternal,"data4.dat")Then
			StartActivity(Reviews)
		Else
			StartActivity(Directory)
		End If
		
	Else
		MsgboxAsync("Enter the correct password","Error")
	End If
	
End Sub