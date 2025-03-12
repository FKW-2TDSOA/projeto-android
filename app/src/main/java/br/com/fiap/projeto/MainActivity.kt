package br.com.fiap.projeto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.navegandoentretelas.sreens.CadastroScreen
import br.com.fiap.projeto.screens.MenuScreen
import br.com.fiap.projeto.ui.theme.NavegaçãoTheme
import br.com.fiap.navegandoentretelas.sreens.LoginScreen
import br.com.fiap.projeto.screens.Curso1Screen
import br.com.fiap.projeto.screens.Curso2Screen
import br.com.fiap.projeto.screens.MenuLoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegaçãoTheme {
                Surface(modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "menuLogin"){
                        composable(route = "menuLogin") {
                            MenuLoginScreen(navController)
                        }
                        composable(route = "cadastro") {
                            CadastroScreen(navController)
                        }
                        composable(route = "login") {
                            LoginScreen(navController)
                        }
                        composable(route = "menu") {
                            MenuScreen(navController)
                        }
                        composable(route = "curso1") {
                            Curso1Screen(navController)
                        }
                        composable(route = "curso2") {
                            Curso2Screen(navController)
                        }
                    }
                }
            }
        }
    }
}
