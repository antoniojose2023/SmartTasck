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
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import br.com.antoniodev.smarttasck.data.repository.RepositoryTarefa
import br.com.antoniodev.smarttasck.itemlistagem.ItemTarefa
import br.com.antoniodev.smarttasck.model.Tarefa
import br.com.antoniodev.smarttasck.ui.theme.BLACK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaTarefas(navController: NavController){

    val repositoryTarefa = RepositoryTarefa()
    val coroutineScope = rememberCoroutineScope()

    var tarefas by remember{ mutableStateOf(emptyList<Tarefa>())}


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
                      Image(imageVector = ImageVector.vectorResource(id = drawable.ic_add), contentDescription = "Add")
              }
          },
          containerColor = BLACK
    ) {paddingValues ->

        tarefas = repositoryTarefa.getTarefas().collectAsState(mutableListOf()).value

        LazyColumn(
              modifier = Modifier.padding( paddingValues )
        ) {

                items(tarefas.size){index ->
                    val tarefa = tarefas[index]
                    ItemTarefa( tarefa, navController )
                }

        }


    }

}