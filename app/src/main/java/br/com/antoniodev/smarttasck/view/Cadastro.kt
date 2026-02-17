package br.com.antoniodev.smarttasck.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.antoniodev.smarttasck.R
import br.com.antoniodev.smarttasck.ui.theme.BLACK
import br.com.antoniodev.smarttasck.ui.theme.Purple80
import br.com.antoniodev.smarttasck.ui.theme.RED
import br.com.antoniodev.smarttasck.ui.theme.Shapes
import br.com.antoniodev.smarttasck.ui.theme.WHITE

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Cadastro(navController: NavController){

    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    var statusVisibility by remember { mutableStateOf(true) }

    val icon = if (statusVisibility)
        painterResource(R.drawable.ic_invisivel)
    else
        painterResource(R.drawable.ic_visivel)


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
                value = nome,
                onValueChange = {
                    nome = it
                },
                label = {
                    Text("Seu nome")
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
                    Image(imageVector = ImageVector.vectorResource(R.drawable.ic_user), contentDescription = null)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                )
            )

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                label = {
                    Text("Email")
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
                    Image(imageVector = ImageVector.vectorResource(R.drawable.ic_email), contentDescription = null)
                },
                keyboardOptions = KeyboardOptions(
                      keyboardType = KeyboardType.Email
                )
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
                text = "fdfdfdfd",
                color = RED,
                modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 0.dp).fillMaxWidth(),
                fontWeight = FontWeight.Bold
            )

            Button(
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Purple80
                ),
                modifier = Modifier.padding(16.dp, 4.dp, 16.dp, 6.dp).fillMaxWidth()
            ) {
                Text(
                    text = "Cadastro",
                    color = BLACK,
                )
            }

            Text(
                text = "Voltar ao login!",
                color = BLACK,
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .fillMaxWidth().clickable(
                        onClick = {
                            navController.navigate("login")
                        }
                    ),
                textAlign = TextAlign.End
            )


        }

    }

}