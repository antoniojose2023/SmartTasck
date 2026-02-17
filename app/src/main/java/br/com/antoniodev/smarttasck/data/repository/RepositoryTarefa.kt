package br.com.antoniodev.smarttasck.data.repository

import br.com.antoniodev.smarttasck.data.datasource.DataSource

class RepositoryTarefa {
    val dataSource = DataSource()

    fun salvarTarefa(titulo: String, decsricao: String, prioridade: Int, status: Boolean){
            dataSource.salvarTarefa(titulo, decsricao, prioridade, status)
    }

    fun getTarefas() = dataSource.getTarefas()

    fun deletarTarefa(title: String){
        dataSource.deletarTarefa( title )
    }

    fun atualizarStatusTarefa(title: String, status: Boolean){
        dataSource.AtualizarStatusTarefa(title, status)
    }


}