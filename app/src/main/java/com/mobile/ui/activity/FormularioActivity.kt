package com.mobile.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.mobile.R
import com.mobile.model.Produto
import java.math.BigDecimal

class FormularioActivity : AppCompatActivity(R.layout.activity_formulario) {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val botaoSalvar = findViewById<Button>(R.id.form_botao_salvar)
        botaoSalvar.setOnClickListener {
            val campoNome = findViewById<EditText>(R.id.form_nome_produto)
            val nome = campoNome.text.toString()

            val campoDescricao = findViewById<EditText>(R.id.form_descricao_produto)
            val descricao = campoDescricao.text.toString()

            val campoValor = findViewById<EditText>(R.id.form_valor_produto)
            val valorEmText = campoValor.text.toString()
            val valor = if(valorEmText.isBlank()){
                BigDecimal.ZERO
            }else{
                BigDecimal(valorEmText)
            }
            Produto(
                nome=nome,
                descricao=descricao,
                valor= valor
            )
        }

    }

}