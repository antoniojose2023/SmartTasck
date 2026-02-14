package br.com.antoniodev.smarttasck.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import br.com.antoniodev.smarttasck.ui.theme.BLACK

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaTarefas(navController: NavController){

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
                  Image(imageVector = Icons.Default.Add, contentDescription = "Add")

              }
          },
          containerColor = BLACK
    ) {

    }

}