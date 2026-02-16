package br.com.antoniodev.smarttasck.data.datasource

import com.google.firebase.firestore.FirebaseFirestore

class DataSource {

    private val db = FirebaseFirestore.getInstance()

    fun salvarTarefa(titulo: String, decsricao: String, prioridade: Int){

          val tarefa = hashMapOf(
                "titulo" to titulo,
                "descricao" to decsricao,
                "prioridade" to prioridade
          )

          db.collection("tarefas").document().set(tarefa).addOnCompleteListener {

          }.addOnFailureListener {

          }

    }

}