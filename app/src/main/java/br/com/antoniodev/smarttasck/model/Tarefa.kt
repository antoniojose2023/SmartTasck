package br.com.antoniodev.smarttasck.model

data class Tarefa(
      val titulo: String? = null,
      val descricao: String? = null,
      val prioridade: Int? = null,
      val status: Boolean? = null
)