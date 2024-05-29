package com.mobile.ui.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.mobile.R
import com.mobile.ui.adapter.ListaProdutosAdapter

class ListaLojaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Loja")
        setContentView(R.layout.activity_lista_loja)

        val nome = findViewById<TextView>(R.id.lista_nome_item)
        nome.text = "Cesta de Frutas"

        val desc = findViewById<TextView>(R.id.lista_descricao)
        desc.text = "laranja, manga e maça"

        val valor = findViewById<TextView>(R.id.lista_valor)
        valor.text = "19.99"

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.adapter = ListaProdutosAdapter()
    }
}