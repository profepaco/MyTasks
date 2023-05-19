package edu.itsco.mytasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import edu.itsco.mytasks.ui.navigation.SetupNavGraph
import edu.itsco.mytasks.ui.screens.HomeScreen
import edu.itsco.mytasks.ui.screens.TaskViewModel
import edu.itsco.mytasks.ui.screens.TaskViewModelFactory
import edu.itsco.mytasks.ui.theme.MyTasksTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val owner =
                LocalViewModelStoreOwner.current
            val navHost = rememberNavController()
            MyTasksTheme {
                owner?.let{
                    val viewModel: TaskViewModel =
                        viewModel(
                            it,
                            "TaskViewModel",
                            TaskViewModelFactory(
                                application = this.application)
                        )
                    //HomeScreen(viewModel = viewModel,
                    //    navHost = navHost)
                    SetupNavGraph(
                        navHost = navHost,
                        viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyTasksTheme {
        Greeting("Android")
    }
}