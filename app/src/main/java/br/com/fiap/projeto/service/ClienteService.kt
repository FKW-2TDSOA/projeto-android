package br.com.fiap.projeto.service

import br.com.fiap.projeto.model.Cliente
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ClienteService {
    @GET("cliente")
    fun getClientes(): Call<List<Cliente?>?>?

    @POST("cliente")
    fun criarCliente(@Body cliente: Cliente?): Call<Cliente?>?
}