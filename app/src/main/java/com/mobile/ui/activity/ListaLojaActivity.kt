package com.mobile.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.R
import com.mobile.model.Produto
import com.mobile.ui.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class ListaLojaActivity : AppCompatActivity(R.layout.activity_lista_loja) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Loja")

//        val nome = findViewById<TextView>(R.id.lista_nome_item)
//        nome.text = "Cesta de Frutas"
//
//        val desc = findViewById<TextView>(R.id.lista_descricao)
//        desc.text = "laranja, manga e maça"
//
//        val valor = findViewById<TextView>(R.id.lista_valor)
//        valor.text = "19.99"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = listOf(
            Produto(
                nome = "teste1", descricao = "descricao do item 1", valor = BigDecimal("19.99")
            ),
            Produto(
                nome = "teste2", descricao = "descricao do item 2", valor = BigDecimal("29.99"),
            )
        ))
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}