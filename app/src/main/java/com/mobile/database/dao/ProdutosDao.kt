package com.mobile.database.dao

import com.mobile.model.Produto

class ProdutosDao {
    fun adiciona(produto: Produto){
        produtos.add(produto)
    }
    fun buscaTodos():List<Produto>{
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}