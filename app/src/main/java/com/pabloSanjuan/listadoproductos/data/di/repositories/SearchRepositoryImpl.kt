package com.pabloSanjuan.listadoproductos.data.di.repositories

import com.pabloSanjuan.listadoproductos.data.models.Products
import com.pabloSanjuan.listadoproductos.data.service.ProductsService
import com.pabloSanjuan.listadoproductos.domain.repositories.SearchRepository
import retrofit2.Response

/**
 * Pablo Sanjuan
 *
 * Implementacion del patron Repository que permite crear instancias del Service
 * y crean un puente entre la capa de Dominio y de Data
 */

class SearchRepositoryImpl (
    private val productsService: ProductsService
): SearchRepository {
    override suspend fun getSearchData(query: HashMap<String, String>): Response<Products> {
        return productsService.searchByQuery(query)
    }
}