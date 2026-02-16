package br.com.antoniodev.smarttasck.data.repository

import br.com.antoniodev.smarttasck.data.datasource.DataSource

class RepositoryTarefa {
    val dataSource = DataSource()

    fun salvarTarefa(titulo: String, decsricao: String, prioridade: Int){
            dataSource.salvarTarefa(titulo, decsricao, prioridade)

    }

}