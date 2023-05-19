package edu.itsco.mytasks.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import edu.itsco.mytasks.data.persistence.Task
import edu.itsco.mytasks.ui.navigation.Screens
import edu.itsco.mytasks.ui.theme.MyTasksTheme

@ExperimentalMaterial3Api
@Composable
fun AddTaskScreen(
    navHost: NavHostController,
    viewModel: TaskViewModel)
{
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "New Task") },
                navigationIcon = {
                    IconButton(onClick = {
                        navHost.navigate(
                            route = Screens.HomeScreen.url
                        )
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                }
            )
        },
    ) {
        Surface(modifier = Modifier.padding(it)) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                OutlinedTextField(
                    label = { Text("Title") },
                    value = title,
                    onValueChange = { value ->  title = value },
                    modifier =  Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    label = { Text("Description") },
                    value = description,
                    onValueChange = { value ->  description = value},
                    modifier =  Modifier.fillMaxWidth()
                )
                ElevatedButton(
                    onClick = {
                         val task:Task = Task(
                             id = 0,
                             title = title,
                             description = description,
                             isCompleted = false
                         )
                         viewModel.createTask(task)
                         //Regresa a Home
                         navHost.navigate(
                             route = Screens.HomeScreen.url
                         )
                    },
                    modifier =  Modifier.padding(vertical= 8.dp)
                ) {
                    Text("Add Task")
                }
            }
        }
    }
}
/*
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AddTaskScreenPreview(){
    MyTasksTheme {
        AddTaskScreen(navHost, viewModel)
    }
} */
