package com.myapp.cuniwarts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.myapp.cuniwarts.features.housepointscalculator.presentation.globalview.GlobalFragment
import com.myapp.cuniwarts.ui.theme.CuniwartsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    companion object {
        const val GLOBAL_FRAGMENT = "GLOBAL FRAGMENT"
        const val RESULTS_FRAGMENT = "RESULTS_FRAGMENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuniwartsTheme {
                val navController = rememberNavController()
                
                NavHost(navController = navController, startDestination = GLOBAL_FRAGMENT ){
                    composable(GLOBAL_FRAGMENT){ GlobalFragment()}
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
    CuniwartsTheme {
        Greeting("Android")
    }
}