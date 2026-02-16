package br.com.antoniodev.smarttasck.itemlistagem

import android.app.AlertDialog
import android.text.Layout
import android.widget.Toast
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.R
import androidx.navigation.NavController
import br.com.antoniodev.smarttasck.data.repository.RepositoryTarefa
import br.com.antoniodev.smarttasck.model.Tarefa
import br.com.antoniodev.smarttasck.ui.theme.AMARELO100
import br.com.antoniodev.smarttasck.ui.theme.AZUL100
import br.com.antoniodev.smarttasck.ui.theme.BLACK
import br.com.antoniodev.smarttasck.ui.theme.Shapes
import br.com.antoniodev.smarttasck.ui.theme.VERDE100
import br.com.antoniodev.smarttasck.ui.theme.WHITE

@Composable
fun ItemTarefa(item: Tarefa, navController: NavController){

    val context = LocalContext.current
    val repositoryTarefa = RepositoryTarefa()

    val prioridade = when(item.prioridade){
         0 -> "Sem prioridade"
         1 -> "Prioridade baixa"
         2 -> "Prioridade média"
         else -> "Prioridade alta"
    }

    val corCardPrioridade = when(item.prioridade){
         0 -> BLACK
         1 -> VERDE100
         2 -> AMARELO100
         else -> AZUL100
    }

    fun exibirDialog(){
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle("Atenção")
        alertDialog.setMessage("Deseja excluir a tarefa?")
        alertDialog.setPositiveButton("Sim"){_,_ ->
            repositoryTarefa.deletarTarefa(item.titulo.toString())
            navController.navigate("listarTarefas")
        }.setNegativeButton("Não"){_,_ ->

        }
        alertDialog.show()
    }

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
                text = item.titulo.toString(),
                modifier = Modifier.align(Alignment.Start).padding(8.dp)
            )
            Text(
                text = item.descricao.toString(),
                modifier =  Modifier.align(Alignment.Start).padding(8.dp)
            )

            Row(
                 modifier = Modifier.fillMaxWidth().padding(8.dp),
                 verticalAlignment = Alignment.CenterVertically,
                 horizontalArrangement = Arrangement.Start
            ) {

                Text(
                    text = prioridade,
                    modifier = Modifier.padding(8.dp)
                )

                Card(
                      modifier = Modifier.width(30.dp).height(30.dp).padding(8.dp),
                      colors = CardDefaults.cardColors(
                            containerColor = corCardPrioridade
                      ),
                      shape = Shapes.extraLarge
                ) {

                }

                IconButton(
                     onClick = {
                         exibirDialog()
                     }
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(br.com.antoniodev.smarttasck.R.drawable.ic_delete),
                        contentDescription = "",
                        //Modifier.padding(8.dp).align(Alignment.End)

                    )
                }

            }

        }

    }

}

