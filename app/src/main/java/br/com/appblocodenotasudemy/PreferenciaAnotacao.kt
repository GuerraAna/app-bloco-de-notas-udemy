package br.com.appblocodenotasudemy

import android.content.Context
import android.content.SharedPreferences

//Classe de armazenamento e recuperação do texto.
//Necessita de um parâmetro com um contexto que é conteúdo inserido.
class PreferenciaAnotacao(private val context: Context) {

    //Cria um arquivo para salvar as alterações.
    private val ARQUIVO = "anotacao.preferences"
    //Chave para acessar o salvarAnotação.
    private val CHAVE = "nome"
    //editor armazena as alterações.
    private val editor: SharedPreferences.Editor
    //preferences recupera as alterações.
    private val preferences: SharedPreferences

    fun salvarAnotacao(anotacao: String?) {
        //Acessa o método salvaAnotacao.
        editor.putString(CHAVE, anotacao)
        //Salva a anotação.
        editor.commit()
    }

    fun recuperarAnotacao(): String? {
        return preferences.getString(CHAVE,"")
    }

    init {
        preferences = context.getSharedPreferences(ARQUIVO, 0)
        editor = preferences.edit()
    }
}