package edu.itsco.mytasks.ui.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.itsco.mytasks.ui.theme.MyTasksTheme

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(){
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
        Column(modifier = Modifier.padding(it)) {

        }
    }
}

@Composable
fun ItemTask(){
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
                text = "Titulo",
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ItemTaskPreview(){
    ItemTask()
}
@ExperimentalMaterial3Api
@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    MyTasksTheme {
        HomeScreen()
    }
}