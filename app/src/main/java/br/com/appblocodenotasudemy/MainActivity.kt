package br.com.appblocodenotasudemy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import br.com.appblocodenotasudemy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    //ApplicationContext ta recuperando o contexto (dados) da classe Preferência.
    val preferencia = PreferenciaAnotacao(applicationContext)

    val buttonfab = binding.fab
        buttonfab.setOnClickListener {
            val editAnotacao = binding.editAnotacao.etBlocoDeNotas.text.toString()

            if (editAnotacao.isEmpty()) {
                Toast.makeText(this,"Insira uma anotação", Toast.LENGTH_SHORT).show()
            } else {
                preferencia.salvarAnotacao(editAnotacao)
                Toast.makeText(this,"Anotação salva com sucesso", Toast.LENGTH_SHORT).show()
            }
        }
        val anotacao = preferencia.recuperarAnotacao()

        if (anotacao != "") {
            binding.editAnotacao.etBlocoDeNotas.setText(anotacao)
        }
    }
}