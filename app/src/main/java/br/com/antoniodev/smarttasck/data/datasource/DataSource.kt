package br.com.antoniodev.smarttasck.data.datasource

import br.com.antoniodev.smarttasck.model.Tarefa
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import java.util.Collections.emptyList

import kotlin.collections.mutableListOf

class DataSource {

    private val db = FirebaseFirestore.getInstance()

    private val _todasTarefas = MutableStateFlow<MutableList<Tarefa>>(mutableListOf())
    val todasTarefas: StateFlow<MutableList<Tarefa>> = _todasTarefas


    fun salvarTarefa(titulo: String, decsricao: String, prioridade: Int){

          val tarefa = hashMapOf(
                "titulo" to titulo,
                "descricao" to decsricao,
                "prioridade" to prioridade
          )

          db.collection("tarefas").document(titulo).set(tarefa).addOnCompleteListener {

          }.addOnFailureListener {

          }
    }


    fun getTarefas(): Flow<MutableList<Tarefa>>{

        var tarefas = mutableListOf<Tarefa>()

        db.collection("tarefas").addSnapshotListener { snapshot, error ->
            if(error != null){
                return@addSnapshotListener
            }

            if(snapshot != null){
                for(doc in snapshot){
                     val tarefa = doc.toObject(Tarefa::class.java)
                     tarefas.add( tarefa )
                }
                _todasTarefas.value = tarefas
            }
        }

        return todasTarefas
    }



}