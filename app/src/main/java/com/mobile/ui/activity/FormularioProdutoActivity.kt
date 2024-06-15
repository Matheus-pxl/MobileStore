package com.mobile.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.mobile.R
import com.mobile.database.dao.ProdutosDao
import com.mobile.databinding.ActivityFormularioProdutoBinding
import com.mobile.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {
    private val binding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setTitle("Cadastrar um produto")
        configuraBotaoSalvar()
        binding.imageViewProduto.setOnClickListener{
            AlertDialog.Builder(this).setTitle("titulo do alert Dialog")
                .setPositiveButton("Confirmar") { _, _ -> }
                .setNegativeButton("Cancelar") { _, _ -> }
                .setView(R.layout.formulario_imagem)
                .setMessage("mensagem do Dialog alert").show()

        }

    }

    private fun configuraBotaoSalvar() {
//        val botaoSalvar = findViewById<Button>(R.id.form_botao_salvar)

        val botaoSalvar = binding.formBotaoSalvar
        val dao = ProdutosDao()
        botaoSalvar.setOnClickListener {
            //bind
            val produtoNovo = criaProduto()
            dao.adiciona(produtoNovo)
            finish()
        }
    }

    private fun criaProduto(): Produto {

//        val campoNome = findViewById<EditText>(R.id.form_nome_produto)
        val campoNome = binding.formNomeProduto
        val nome = campoNome.text.toString()

//        val campoDescricao = findViewById<EditText>(R.id.form_descricao_produto)
        val campoDescricao = binding.formDescricaoProduto
        val descricao = campoDescricao.text.toString()

//        val campoValor = findViewById<EditText>(R.id.form_valor_produto)
        val campoValor = binding.formValorProduto
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