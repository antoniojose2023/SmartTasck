package br.com.antoniodev.smarttasck.listerners

interface Listerner {
    fun Sucesso(mensagen: String)
    fun Falha(mensagen: String)
}