package br.com.antoniodev.smarttasck.view

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.antoniodev.smarttasck.componentes.Botao
import br.com.antoniodev.smarttasck.componentes.CampoEntradaTexto
import br.com.antoniodev.smarttasck.data.repository.RepositoryTarefa
import br.com.antoniodev.smarttasck.ui.theme.AMARELO100
import br.com.antoniodev.smarttasck.ui.theme.AMARELO50
import br.com.antoniodev.smarttasck.ui.theme.AZUL100
import br.com.antoniodev.smarttasck.ui.theme.AZUL50
import br.com.antoniodev.smarttasck.ui.theme.BLACK
import br.com.antoniodev.smarttasck.ui.theme.Purple40
import br.com.antoniodev.smarttasck.ui.theme.VERDE100
import br.com.antoniodev.smarttasck.ui.theme.VERDE50
import br.com.antoniodev.smarttasck.ui.theme.WHITE
import br.com.antoniodev.smarttasck.util.Constantes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SalvarTarefas(navController: NavController){

    val repositoryTarefa = RepositoryTarefa()

    val context = LocalContext.current

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    var prioridadeBaixa by remember { mutableStateOf(false) }
    var prioridadeMedia by remember { mutableStateOf(false) }
    var prioridadeAlta by remember { mutableStateOf(false) }
    var semPrioridade by remember { mutableStateOf(true) }

    var mensagem by remember { mutableStateOf(true) }

    val coroutineScope = rememberCoroutineScope()


    Scaffold(
        topBar = {
            TopAppBar(
                { Text(text = "Salvar terafas") },
                 colors = TopAppBarDefaults.topAppBarColors(
                      containerColor = Purple40,
                      titleContentColor = WHITE
                 )
            )
        },
        containerColor = WHITE
    ){

        Column(
               modifier = Modifier.fillMaxSize(),
               horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.Center
        ) {

            CampoEntradaTexto(
                value = title,
                onValueChange = { it ->
                    title = it
                },
                label = "Titulo",
                1,
                KeyboardType.Text,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 10.dp, 16.dp, 0.dp)
            )

            CampoEntradaTexto(
                value = description,
                onValueChange = { it ->
                    description = it
                },
                label = "Descrição",
                4,
                KeyboardType.Text,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .padding(16.dp, 10.dp, 16.dp, 0.dp)
            )

            Row(
                 modifier = Modifier.fillMaxWidth(),
                 verticalAlignment = Alignment.CenterVertically,
                 horizontalArrangement = Arrangement.Center
            ) {

                Text(text = "Níveis de Prioridades")

                RadioButton(
                    selected = prioridadeBaixa,
                    onClick = {
                        prioridadeBaixa = !prioridadeBaixa
                    },
                    colors = RadioButtonDefaults.colors(
                           selectedColor = VERDE100,
                           unselectedColor = VERDE50,
                    )
                )

                RadioButton(
                    selected = prioridadeMedia,
                    onClick = {
                        prioridadeMedia = !prioridadeMedia
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = AMARELO100,
                        unselectedColor = AMARELO50,
                    )
                )

                RadioButton(
                    selected = prioridadeAlta,
                    onClick = {
                        prioridadeAlta = !prioridadeAlta
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = AZUL100,
                        unselectedColor = AZUL50,
                    )
                )

            }

            Botao(
                "Adicionar",
                modifier =  Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 10.dp, 16.dp, 0.dp)
            ){
                //chamar a função de salvar tarefas

                coroutineScope.launch(Dispatchers.IO){
                    if(title.isEmpty()){
                        mensagem = false
                    }else if(title.isNotEmpty() && description.isNotEmpty() && prioridadeBaixa){
                        repositoryTarefa.salvarTarefa(title, description, Constantes.PRIORIDADE_BAIXA, false)
                        mensagem = true
                    }else if(title.isNotEmpty() && description.isNotEmpty() && prioridadeMedia){
                        repositoryTarefa.salvarTarefa(title, description, Constantes.PRIORIDADE_MEDIA, false)
                        mensagem = true
                    }else if(title.isNotEmpty() && description.isNotEmpty() && prioridadeAlta){
                        repositoryTarefa.salvarTarefa(title, description, Constantes.PRIORIDADE_ALTA, false)
                        mensagem = true
                    }else if(title.isNotEmpty() && description.isEmpty() && prioridadeBaixa){
                        repositoryTarefa.salvarTarefa(title, description, Constantes.PRIORIDADE_BAIXA, false)
                        mensagem = true
                    }else if(title.isNotEmpty() && description.isEmpty() && prioridadeMedia){
                        repositoryTarefa.salvarTarefa(title, description, Constantes.PRIORIDADE_MEDIA, false)
                        mensagem = true
                    }else if(title.isNotEmpty() && description.isEmpty() && prioridadeAlta){
                        repositoryTarefa.salvarTarefa(title, description, Constantes.PRIORIDADE_ALTA, false)
                        mensagem = true
                    }else if(title.isNotEmpty() && description.isEmpty() && semPrioridade){
                        repositoryTarefa.salvarTarefa(title, description, Constantes.SEM_PRIORIDADE, false)
                        mensagem = true
                    }else if(title.isNotEmpty() && description.isNotEmpty() && semPrioridade){
                        repositoryTarefa.salvarTarefa(title, description, Constantes.SEM_PRIORIDADE, false)
                        mensagem = true
                    }

                }

                coroutineScope.launch(Dispatchers.Main){
                    if(mensagem){
                        context.exibirToast("Tarefa salva com sucesso")
                        navController.navigate("listarTarefas")
                    }else{
                        context.exibirToast("O campo tarefa é obrigatório")
                    }
                }

            }

        }

    }

}

private fun Context.exibirToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

