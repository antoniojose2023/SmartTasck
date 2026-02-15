package br.com.antoniodev.smarttasck.itemlistagem

import android.text.Layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.R
import br.com.antoniodev.smarttasck.ui.theme.Shapes
import br.com.antoniodev.smarttasck.ui.theme.VERDE100
import br.com.antoniodev.smarttasck.ui.theme.WHITE

@Composable
fun ItemTarefa(){

    Card(
         modifier = Modifier.fillMaxWidth().height(180.dp).padding(16.dp),
         shape = Shapes.medium,
         colors = androidx.compose.material3.CardDefaults.cardColors(
                containerColor = WHITE
         )
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Atividade 1",
                modifier = Modifier.align(Alignment.Start).padding(8.dp)
            )
            Text(
                text = " is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
                modifier = Modifier.padding(8.dp)
            )

            Row(
                 modifier = Modifier.fillMaxWidth().padding(8.dp),
                 verticalAlignment = Alignment.CenterVertically,
                 horizontalArrangement = Arrangement.Start
            ) {

                Text(
                    text = "Níveis de prioridade",
                    modifier = Modifier.padding(8.dp)
                )

                Card(
                      modifier = Modifier.width(30.dp).height(30.dp).padding(8.dp),
                      colors = CardDefaults.cardColors(
                            containerColor = VERDE100
                      ),
                      shape = Shapes.extraLarge
                ) {

                }

                Image(
                    imageVector = ImageVector.vectorResource(br.com.antoniodev.smarttasck.R.drawable.ic_delete),
                    contentDescription = "",
                    //Modifier.padding(8.dp).align(Alignment.End)

                )

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun ItemTarefaPreview(){
    ItemTarefa()
}