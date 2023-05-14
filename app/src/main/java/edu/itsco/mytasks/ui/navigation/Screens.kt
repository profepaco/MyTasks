package edu.itsco.mytasks.ui.navigation

sealed class Screens(
    val url:String) {
    object HomeScreen:
        Screens(url = "home")
    object AddTaskScreen:
        Screens(url = "add_task")
}