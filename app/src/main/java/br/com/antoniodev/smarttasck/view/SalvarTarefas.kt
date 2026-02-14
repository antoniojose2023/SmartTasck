package br.com.antoniodev.smarttasck.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.antoniodev.smarttasck.componentes.Botao
import br.com.antoniodev.smarttasck.componentes.CampoEntradaTexto
import br.com.antoniodev.smarttasck.ui.theme.BLACK
import br.com.antoniodev.smarttasck.ui.theme.Purple40
import br.com.antoniodev.smarttasck.ui.theme.WHITE

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SalvarTarefas(navController: NavController){

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

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

            Botao(
                "Adicionar",
                modifier =  Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 10.dp, 16.dp, 0.dp),
            )

        }


    }

}