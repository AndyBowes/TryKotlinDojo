package dojo.leeds.problem6

import com.github.kittinunf.fuel.httpGet
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Test


data class Pokemon(val id: Int, val order: Int, val name:String, val weight:Int, val height:Int, val sprites: Map<String,String?>)

fun readJson(fileName: String): String{
    return String.javaClass.classLoader.getResourceAsStream(fileName)
            .bufferedReader().readLines().joinToString("")
}

class PokemonDAO {
    val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    val pokemonAdapter = moshi.adapter(Pokemon::class.java)

    fun getPokemonById(id: Int): Pokemon? {
        val headers = mapOf("User-Agent" to "Mozilla/5.0")
        val (request, response, result) = "https://pokeapi.co/api/v2/pokemon/$id/"
                .httpGet().header(headers).responseString()
        println( request.cUrlString())
        val json = result.get()
        val pokemon = pokemonAdapter.fromJson(json)
        return pokemon
    }

    @Test
    fun `given a valid pokemon id then a populated Pokemon should be returned`(){
        val pokemon = getPokemonById(2)
        assertThat(pokemon, not(nullValue()))
        if (pokemon != null){
            pokemon.apply {
                assertThat(id, equalTo(2))
                assertThat(order, equalTo(2))
                assertThat(name, equalTo("ivysaur"))
                assertThat(height, equalTo(10))
                assertThat(weight, equalTo(130))
                assertThat(sprites, not(nullValue()))
                assertThat(sprites.size, equalTo(8))
            }
        }
    }
}

