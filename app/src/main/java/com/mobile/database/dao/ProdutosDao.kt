package com.mobile.database.dao

import com.mobile.model.Produto
import java.math.BigDecimal

class ProdutosDao {
    fun adiciona(produto: Produto) {
        produtos.add(produto)
    }

    fun buscaTodos(): List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>(

            //exemplo para nao ter q  adicionar um item toda hora
            Produto(
                nome = "salada de frutas",
                descricao = "laranja,maça, pera e uva",
                valor = BigDecimal("19.55")
            )
        )
    }
}