package br.com.antoniodev.smarttasck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.antoniodev.smarttasck.ui.theme.SmartTasckTheme
import br.com.antoniodev.smarttasck.view.Cadastro
import br.com.antoniodev.smarttasck.view.ListaTarefas
import br.com.antoniodev.smarttasck.view.Login
import br.com.antoniodev.smarttasck.view.SalvarTarefas
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartTasckTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "login"){
                    composable("login") {
                        Login(navController)
                    }

                    composable("cadastro") {
                        Cadastro(navController)
                    }

                    composable("listarTarefas") {
                         ListaTarefas(navController)
                     }

                     composable("salvarTarefas") {
                         SalvarTarefas(navController)
                     }
                }
            }
        }
    }
}


