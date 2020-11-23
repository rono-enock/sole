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
	Private LabelCountry As Label
	Private Spinner1 As Spinner
	Private LabelGender As Label
	Private RdMale As RadioButton
	Private RdFemale As RadioButton
	Private RdOther As RadioButton
	Private BtnNext As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("LocationPage")
	Activity.Title=Vuka.title
	
	Dim PageColors As ColorDrawable
	PageColors.Initialize(Vuka.B_Colors,0)
	Panel1.Background=PageColors
	
	LabelCountry.Text="Select your country"
	LabelCountry.TextColor=Colors.Black
	LabelCountry.TextSize=14
	
	LabelGender.Text="Select your gender:"
	LabelGender.TextColor=Colors.Black
	LabelGender.TextSize=14
	
	RdFemale.Text="Female"
	RdFemale.TextColor=Colors.Black
	RdFemale.TextSize=14
	
	RdMale.Text="Male"
	RdMale.TextColor=Colors.Black
	RdMale.TextSize=14
	
	RdOther.Text="Other"
	RdOther.TextColor=Colors.Black
	RdOther.TextSize=14
	
	BtnNext.Text="Next"
	BtnNext.TextColor=Colors.Black
	BtnNext.TextSize=15
	
	Spinner1.AddAll(Array As String("Afghanistan","Albania","Algeria","Andorra","Angola","Antigua and Barbuda","Argentina", _
	                                  "Armenia","Australia","Austria","Azerbaijan","The Bahamas","Bahrain","Bangladesh","Barbados", _
									  "Belarus","Belgium","Belize","Benin","Bhutan","Bolivia","Bosnia and Herzegovina","Botswana", _
									  "Brazil","Brunei","Bulgaria","Burkina Faso","Burundi","Cabo Verde","Cambodia","Cameroon", _
									  "Canada","Central African Republic","Chad","Chile","China","Colombia","Comoros"," Democratic Republic of the Congo", _
									  "Costa Rica","Côte d’Ivoire","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Djibouti", _
									  "Dominica","Dominican Republic","East Timor (Timor-Leste)","Ecuador","Egypt","El Salvador", _
									  "Equatorial Guinea","Eritrea","Estonia","Ethiopia","Fiji","Finland","France","Gabon","The Gambia", _
									  "Georgia","Germany","Ghana","Greece","Grenada","Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti", _
									  "Honduras","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Israel","Italy","Jamaica", _
									  "Japan","Jordan","Kazakhstan","Kenya","Kiribati","Korea, North","Korea, South","Kosovo","Kuwait","Kyrgyzstan", _
									  "Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macedonia", _
									  "Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Mauritania","Mauritius", _
									  "Mexico","Micronesia, Federated States of","Moldova","Monaco","Mongolia","Montenegro","Morocco","Mozambique", _
									  "Myanmar (Burma)","Namibia","Nauru","Nepal","Netherlands","New Zealand","Nicaragua","Niger","Nigeria","Norway", _
									  "Oman","Pakistan","Palau","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Qatar", _
									  "Romania","Russia","Rwanda","Saint Kitts and Nevis","Saint Lucia","Saint Vincent and the Grenadines","Samoa", _
									  "San Marino","Sao Tome and Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore", _
									  "Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","Spain","Sri Lanka","Sudan","Sudan, South", _
									  "Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Togo","Tonga", _
									  "Trinidad and Tobago","Tunisia","Turkey","Turkmenistan","Tuvalu","Uganda","Ukraine","United Arab Emirates", _
									  "United Kingdom","United States","Uruguay","Uzbekistan","Vanuatu","Vatican City","Venezuela","Vietnam","Yemen", _
									  "Zambia","Zimbabwe"))
	Spinner1.DropdownBackgroundColor=Colors.Black
	Spinner1.DropdownTextColor=Colors.White
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub RdMale_CheckedChange(Checked As Boolean)
	
End Sub

Sub RdFemale_CheckedChange(Checked As Boolean)
	
End Sub

Sub RdOther_CheckedChange(Checked As Boolean)
	
End Sub

Sub BtnNext_Click
	Dim country As String
	Dim list As List
	list.Initialize
	list.Add(Spinner1.SelectedItem)
	File.WriteList(File.DirInternal,"data2.dat",list)
	
	If  RdFemale.Checked=True Or RdMale.Checked=True Or RdOther.Checked=True Then
		StartActivity(EducLev)
	Else
		MsgboxAsync("You must select your gender","Error")
	End If
	
	
End Sub