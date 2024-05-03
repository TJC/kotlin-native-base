import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.curl.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking

@Serializable
data class FooBar(val text: String, val channel: String)

fun main()  {
    runBlocking {
        println("Hello world")
        val postBody = Json.encodeToString(FooBar("hello world", "random"))
        val client = HttpClient(Curl)
        val res = client.request("http://localhost:8080/test.json") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            setBody(postBody)
        }

        val r = Json.decodeFromString<FooBar>(res.body())

        println(r)

        client.close()
    }
}
