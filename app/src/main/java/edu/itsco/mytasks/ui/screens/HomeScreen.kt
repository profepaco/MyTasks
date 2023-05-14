package edu.itsco.mytasks.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.itsco.mytasks.data.persistence.Task
import edu.itsco.mytasks.ui.theme.MyTasksTheme

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(viewModel: TaskViewModel) {
    val listTask: List<Task> by
        viewModel.allTask.observeAsState(listOf())
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Lista de Tareas")})
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { /*TODO*/ }){
                Text(text = "Add")
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        LazyColumn(modifier =
            Modifier.padding(it).fillMaxSize()){
            items(listTask){ item ->
                ItemTask(item)
            }
        }
    }
}

@Composable
fun ItemTask(item: Task){
    ElevatedCard(
        modifier = Modifier
            .padding(
                horizontal = 8.dp, vertical = 4.dp
            )
            .fillMaxWidth()
    ){
        Row() {
            Icon(
                imageVector = Icons.Outlined.CheckCircle,
                contentDescription = "Tarea realizada"
            )
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ItemTaskPreview(){
    ItemTask(Task(id = 0,title = "My Task",
        description = "", isCompleted = false))
}
@ExperimentalMaterial3Api
@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    MyTasksTheme {
        //HomeScreen(viewModel)
    }
}