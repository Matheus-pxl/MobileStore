package com.mobile.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.mobile.R
import com.mobile.database.dao.ProdutosDao
import com.mobile.model.Produto
import java.math.BigDecimal

class FormularioActivity : AppCompatActivity(R.layout.activity_formulario) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Cadastrar um produto")
        configuraBotaoSalvar()

    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.form_botao_salvar)
        val dao = ProdutosDao()
        botaoSalvar.setOnClickListener {
            //bind
            val produtoNovo = criaProduto()
            dao.adiciona(produtoNovo)
            finish()
        }
    }

    private fun criaProduto(): Produto {
        val campoNome = findViewById<EditText>(R.id.form_nome_produto)
        val nome = campoNome.text.toString()

        val campoDescricao = findViewById<EditText>(R.id.form_descricao_produto)
        val descricao = campoDescricao.text.toString()

        val campoValor = findViewById<EditText>(R.id.form_valor_produto)
        val valorEmText = campoValor.text.toString()
        //verificar se o valor nao esta em branco e salvando na variavel
        val valor = if (valorEmText.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmText)
        }

        return Produto(
            nome = nome,
            descricao = descricao,
            valor = valor
        )
    }

}