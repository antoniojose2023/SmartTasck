package br.com.antoniodev.smarttasck.componentes

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.antoniodev.smarttasck.ui.theme.Purple40
import br.com.antoniodev.smarttasck.ui.theme.WHITE

@Composable
fun Botao(
    titulo: String,
    modifier: Modifier
){

    Button(
          onClick = {
              Log.i("TAG", "Botao clicado")
          },
          modifier = modifier,
          colors = ButtonDefaults.buttonColors(
                containerColor = Purple40,
                contentColor = WHITE
          )
    ) {

        Text(text =  titulo )

    }

}