package br.com.antoniodev.smarttasck.view


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.translation.ViewTranslationRequest
import android.widget.Toast
import androidx.compose.foundation.Image

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.antoniodev.smarttasck.R
import br.com.antoniodev.smarttasck.data.repository.RepositoryAuth
import br.com.antoniodev.smarttasck.listerners.Listerner
import br.com.antoniodev.smarttasck.ui.theme.BLACK
import br.com.antoniodev.smarttasck.ui.theme.Purple40
import br.com.antoniodev.smarttasck.ui.theme.Purple80
import br.com.antoniodev.smarttasck.ui.theme.RED
import br.com.antoniodev.smarttasck.ui.theme.Shapes
import br.com.antoniodev.smarttasck.ui.theme.WHITE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@Composable
fun Login(navController: NavController){

    val repositoryAuth = RepositoryAuth()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    var statusVisibility by remember { mutableStateOf(true) }

    val icon = if (statusVisibility)
        painterResource(R.drawable.ic_invisivel)
    else
        painterResource(R.drawable.ic_visivel)

    var statusLogado = repositoryAuth.verificarUsuarioLogado().collectAsState(initial = false).value
    LaunchedEffect(statusLogado) {
        if (statusLogado) navController.navigate("listarTarefas") else statusLogado = false
    }

    Scaffold(
        modifier = Modifier
    ) {

        Column(
              modifier = Modifier.fillMaxSize()
                  .background(
                      brush = Brush.verticalGradient(
                             colors = listOf(BLACK, Purple80)
                       )
                  ),
              verticalArrangement = Arrangement.Center,
              horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_email_senha),
                contentDescription = null,
                modifier = Modifier.size(70.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                label = {
                    Text("Email")
                },
                modifier = Modifier.fillMaxWidth().padding(16.dp, 16.dp, 16.dp, 4.dp),
                shape = Shapes.medium,
                colors = OutlinedTextFieldDefaults.colors(
                      focusedTextColor = BLACK,
                      focusedLabelColor = Purple80,
                      focusedContainerColor = WHITE,
                      cursorColor = Purple80,
                      unfocusedContainerColor = WHITE,
                ),
                trailingIcon = {
                     Image(imageVector = ImageVector.vectorResource(R.drawable.ic_email), contentDescription = null)
                }
            )

            OutlinedTextField(
                value = senha,
                onValueChange = {
                    senha = it
                },
                label = {
                    Text("Senha")
                },
                modifier = Modifier.fillMaxWidth().padding(16.dp, 4.dp, 16.dp, 4.dp),
                shape = Shapes.medium,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = BLACK,
                    focusedLabelColor = Purple80,
                    focusedContainerColor = WHITE,
                    cursorColor = Purple80,
                    unfocusedContainerColor = WHITE,
                ),
                trailingIcon = {
                    IconButton(
                        onClick = {
                             statusVisibility = !statusVisibility
                        }
                    ) {
                        Icon(painter = icon, contentDescription = null)
                    }
                },
                visualTransformation = if(statusVisibility) VisualTransformation.None else PasswordVisualTransformation()
            )

            Text(
                text = "",
                color = RED,
                modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 0.dp).fillMaxWidth(),
                fontWeight = FontWeight.Bold
            )

            Button(
                onClick = {
                      repositoryAuth.login( email, senha, object : Listerner{
                          override fun Sucesso(mensagen: String) {
                                Toast.makeText(context, mensagen, Toast.LENGTH_SHORT).show()
                                navController.navigate("listarTarefas")
                          }

                          override fun Falha(mensagen: String) {
                              Toast.makeText(context, mensagen, Toast.LENGTH_SHORT).show()
                          }

                      } )
                },
                colors = ButtonDefaults.buttonColors(
                        containerColor = Purple80
                ),
                modifier = Modifier.padding(16.dp, 4.dp, 16.dp, 6.dp).fillMaxWidth()
            ) {
                Text(
                    text = "Entrar",
                    color = BLACK,
                )
            }

            Text(
                text = "Ainda não tem uma conta? crie sua conta!",
                color = BLACK,
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .fillMaxWidth().clickable(
                        onClick = {
                            navController.navigate("cadastro")
                        }
                    ),
                textAlign = TextAlign.End
            )


        }

    }


}