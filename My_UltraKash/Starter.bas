B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=8
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim saving As Int=Rnd(100,120)
	Dim pfee As Int=Rnd(30,50)
	'Dim membfee As Int=Rnd(30,50)
	Dim compname As String="Acelords Foundation"
	Dim Loantittle As String=" Vukash"
	Dim Till As String="5355179"
	Dim titname As String="WELCOME TO ACELORDS FOUNDATION!!"
	Dim bal,ball,balance,balances,calc,limit As String
	Dim rate As String=100
	balance=pfee
	ball=(pfee/2)
	calc=(saving-30)
	limit=(calc*rate)
	balances=saving
	bal=(ball+balances)
	'This is the program entry point.
	'This is a good place to load resources that are not specific to a single activity.

	

End Sub

Sub Service_Start (StartingIntent As Intent)
	

End Sub

Sub Service_TaskRemoved
	'This event will be raised when the user removes the app from the recent apps list.
End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy

End Sub
