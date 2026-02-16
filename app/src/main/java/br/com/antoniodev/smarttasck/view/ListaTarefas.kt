package br.com.antoniodev.smarttasck.view

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.R
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.antoniodev.smarttasck.ui.theme.Purple40
import br.com.antoniodev.smarttasck.ui.theme.WHITE
import br.com.antoniodev.smarttasck.R.drawable
import br.com.antoniodev.smarttasck.itemlistagem.ItemTarefa
import br.com.antoniodev.smarttasck.model.Tarefa
import br.com.antoniodev.smarttasck.ui.theme.BLACK

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaTarefas(navController: NavController){

    val tarefas = mutableListOf(
        Tarefa("Atividade1", "jhas hsjhajsah ahsjahsjajs", 0),
        Tarefa("Atividade2", "jhas hsjhajsah ahsjahsjajs", 1),
        Tarefa("Atividade3", "jhas hsjhajsah ahsjahsjajs", 2),
        Tarefa("Atividade4", "jhas hsjhajsah ahsjahsjajs", 3),
        Tarefa("Atividade5", "jhas hsjhajsah ahsjahsjajs", 4),
        Tarefa("Atividade6", "jhas hsjhajsah ahsjahsjajs", 2),
    )


    Scaffold(
          topBar = {
              TopAppBar(
                  {Text(
                      text = "Lista de tarefas",
                      fontSize = 16.sp,
                  )},
                  colors = TopAppBarDefaults.topAppBarColors(
                         containerColor = Purple40,
                         titleContentColor = WHITE
                  )
              )
          },
          floatingActionButton = {
              FloatingActionButton(
                  onClick = {
                      navController.navigate("salvarTarefas")
                  },
              ) {
                  //Image(Icons.Default.Add, contentDescription = "Add")
                  Image(imageVector = ImageVector.vectorResource(id = drawable.ic_add), contentDescription = "Add")

              }
          },
          containerColor = BLACK
    ) {paddingValues ->

        LazyColumn(
              modifier = Modifier.padding( paddingValues )
        ) {
             items(tarefas.size){ index ->
                 val item = tarefas[index]
                 ItemTarefa( item )
             }
        }


    }

}