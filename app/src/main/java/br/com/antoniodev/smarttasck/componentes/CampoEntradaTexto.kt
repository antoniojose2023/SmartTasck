package br.com.antoniodev.smarttasck.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.antoniodev.smarttasck.ui.theme.Shapes
import br.com.antoniodev.smarttasck.ui.theme.WHITE


@Composable
fun CampoEntradaTexto(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    maxLine: Int,
    keyboardType: KeyboardType,
    modifier: Modifier
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        },
        maxLines = maxLine,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        modifier = modifier,
        shape = Shapes.medium
    )
}


@Preview(showBackground = true)
@Composable
fun CampoEntradaTextoPreiew(){
      CampoEntradaTexto("atividade1",
          {},
          "Insira sua atividade",
          1, keyboardType = KeyboardType.Text,
          modifier = Modifier)

}