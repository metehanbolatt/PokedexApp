package com.metehanbolat.pokedexappcompose.repository

import com.metehanbolat.pokedexappcompose.data.remote.PokeApi
import com.metehanbolat.pokedexappcompose.data.remote.responses.Pokemon
import com.metehanbolat.pokedexappcompose.data.remote.responses.PokemonList
import com.metehanbolat.pokedexappcompose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit = limit, offset = offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(name = pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }

}