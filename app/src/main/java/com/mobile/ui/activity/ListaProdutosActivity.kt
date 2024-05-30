package com.mobile.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mobile.R
import com.mobile.database.dao.ProdutosDao
import com.mobile.ui.adapter.ListaProdutosAdapter

class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {

    private val dao =ProdutosDao()
    private val adapter= ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Loja")
        configuraRecyclewView()

    }
    //O CODIGO PRECISA ESTAR NO ON RESUME PARA SER 'REEXECUTADO'
    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
        configuraFAB()
    }

    private fun configuraFAB() {
        val fabAbrirFormulario = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fabAbrirFormulario.setOnClickListener {
            val intent = Intent(this, FormularioActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configuraRecyclewView() {
        val dao = ProdutosDao()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
    }
}