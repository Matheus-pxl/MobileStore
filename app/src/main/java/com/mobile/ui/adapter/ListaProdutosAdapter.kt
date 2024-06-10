package com.mobile.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.R
import com.mobile.databinding.ProdutoItemBinding
import com.mobile.model.Produto

class ListaProdutosAdapter(private val context: Context, produtos: List<Produto>) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val produtos = produtos.toMutableList()

    class ViewHolder(private val binding: ProdutoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun vincula(produto: Produto) {
//            val nome = itemView.findViewById<TextView>(R.id.lista_nome_item)
            val nome = binding.listaNomeItem
            nome.text=produto.nome

//            val descricao = itemView.findViewById<TextView>(R.id.lista_descricao)
            val descricao = binding.listaDescricao
            descricao.text=produto.descricao

//            val valor = itemView.findViewById<TextView>(R.id.lista_valor)
            val valor = binding.listaValor
            valor.text= produto.valor.toPlainString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = inflater.inflate(R.layout.produto_item, parent, false)
        val inflater = LayoutInflater.from(context)
        val binding = ProdutoItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = produtos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)


    }

    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }

}
