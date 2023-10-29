package com.myapp.cuniwarts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.myapp.cuniwarts.features.housepointscalculator.presentation.globalview.GlobalFragment
import com.myapp.cuniwarts.features.housepointscalculator.presentation.resultview.ResultFragment
import com.myapp.cuniwarts.ui.theme.CuniwartsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    companion object {
        const val GLOBAL_FRAGMENT = "GLOBAL FRAGMENT"
        const val RESULTS_FRAGMENT = "RESULTS_FRAGMENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            CuniwartsTheme {
                val navController = rememberNavController()
                
                NavHost(navController = navController, startDestination = GLOBAL_FRAGMENT ){
                    composable(GLOBAL_FRAGMENT){ GlobalFragment(){
                        navController.navigate(RESULTS_FRAGMENT)
                    } }
                    composable(RESULTS_FRAGMENT){ ResultFragment()}
                }
                
            }
        }
    }
}