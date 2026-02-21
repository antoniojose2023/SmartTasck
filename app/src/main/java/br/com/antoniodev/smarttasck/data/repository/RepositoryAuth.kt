package br.com.antoniodev.smarttasck.data.repository

import br.com.antoniodev.smarttasck.data.datasource.Autentication
import br.com.antoniodev.smarttasck.listerners.Listerner

class RepositoryAuth {
    val auth = Autentication()

    fun cadastro(nome: String, email: String, password: String, listener: Listerner) {
            auth.cadastro(nome, email, password, listener)
    }

    fun login(email: String, password: String, listener: Listerner) {
        auth.login(email, password, listener)
    }


}