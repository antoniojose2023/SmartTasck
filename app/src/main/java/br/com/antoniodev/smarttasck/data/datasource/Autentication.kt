package br.com.antoniodev.smarttasck.data.datasource

import br.com.antoniodev.smarttasck.listerners.Listerner
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.firestore.FirebaseFirestore

class Autentication {
    val auth = FirebaseAuth.getInstance()
    val firestore = FirebaseFirestore.getInstance()

    fun cadastro(nome: String, email: String, password: String, listener: Listerner) {
          if(nome.isEmpty() || email.isEmpty() || password.isEmpty()){
              listener.Falha("Preencha todos os campos")
          }else{
              auth.createUserWithEmailAndPassword( email, password ).addOnCompleteListener { task ->
                  if(task.isSuccessful){
                      val userId = auth.currentUser!!.uid

                      val user = mapOf(
                          "nome" to nome,
                          "userId" to userId,
                          "email" to email
                      )

                      firestore.collection("usuarios").document(userId).set(user).addOnCompleteListener {
                          listener.Sucesso("Cadastro realizado com sucesso")
                      }

                  }else{
                      val excecao = task.exception
                      val erro = when(excecao){
                          is  FirebaseNetworkException -> "Erro de conexão"
                          is  FirebaseAuthUserCollisionException -> "Email já cadastrado"
                          is  FirebaseAuthWeakPasswordException -> "Senha deve ter no minimo 6 caracteres"
                          else -> "Erro ao tentar realiza o cadastro"
                      }

                      listener.Falha( erro )
                  }
              }
          }
    }


    fun login(email: String, password: String, listener: Listerner) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                listener.Sucesso("Login realizado com sucesso")
            } else {
                val excecao = task.exception
                val erro = when (excecao) {
                    is FirebaseNetworkException -> "Erro de conexão"
                    is FirebaseAuthInvalidCredentialsException -> "Email ou senha incorretos"
                    is FirebaseAuthInvalidUserException -> "Usuário não cadastrado"
                    else -> "Erro ao tentar realizar o login"
                }

                listener.Falha( erro )
            }
        }
    }

}