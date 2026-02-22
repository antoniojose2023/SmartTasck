package br.com.antoniodev.smarttasck.data.repository

import br.com.antoniodev.smarttasck.data.datasource.Autentication
import br.com.antoniodev.smarttasck.listerners.Listerner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RepositoryAuth {
    val auth = Autentication()

    fun cadastro(nome: String, email: String, password: String, listener: Listerner) {
            auth.cadastro(nome, email, password, listener)
    }

    fun login(email: String, password: String, listener: Listerner) {
        auth.login(email, password, listener)
    }

    fun verificarUsuarioLogado(): Flow<Boolean> {
          return auth.verificarUsuarioLogado()
    }

    fun recuperDadosUsuarioLogado(): Flow<String>{
         return auth.recuperDadosUsuarioLogado()
    }

}