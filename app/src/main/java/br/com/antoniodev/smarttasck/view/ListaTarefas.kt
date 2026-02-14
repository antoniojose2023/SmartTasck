package br.com.antoniodev.smarttasck.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ListaTarefas(navController: NavController){

    Text(
        text = "Lista de Tarefas",
         fontSize = 25.sp
    )

}