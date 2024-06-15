package com.mobile.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.mobile.R
import com.mobile.database.dao.ProdutosDao
import com.mobile.databinding.ActivityListaProdutosBinding
import com.mobile.ui.adapter.ListaProdutosAdapter

class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {

    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())

    private val binding by lazy {
        ActivityListaProdutosBinding.inflate(layoutInflater)
    }

    //codigo no onCreate so sera executado na hora da criação
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Loja")
        setContentView(binding.root)
        configuraRecyclewView()
        configuraFAB()

    }

    //O CODIGO PRECISA ESTAR NO ON RESUME PARA SER 'REEXECUTADO'
    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun configuraFAB() {
//        val fabAbrirFormulario = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        val fab = binding.floatingActionButtonAdicionarProduto
        fab.setOnClickListener {
            vaiParaFormularioProduto()
        }
    }

    private fun vaiParaFormularioProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclewView() {
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val recyclerView = binding.activityListaRecyclerviewProdutos
        val dao = ProdutosDao()
        recyclerView.adapter = adapter
    }
}