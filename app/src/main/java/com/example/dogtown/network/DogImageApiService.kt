package com.example.dogtown.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://dog.ceo/api/breeds/image/"

// Added to print out network requests and responses in Logcat
// Available via the dependency added in build.gradle: com.squareup.okhttp3:logging-interceptor:4.7.2
private val networkLoggingInterceptor =
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

<<<<<<< HEAD:app/src/main/java/com/example/dogtown/network/DogImageApiService.kt
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

=======
/**
 * Build the Moshi object with Kotlin adapter factory that Retrofit will be using.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
/**
 * The Retrofit object with the Moshi converter.
 */
>>>>>>> e456e34330306de82125850b9fa3ba83e7481ab0:app/src/main/java/com/example/dogtown/network/DogApiService.kt
private val retrofit = Retrofit.Builder()
    .client(OkHttpClient.Builder().addInterceptor(networkLoggingInterceptor).build())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

<<<<<<< HEAD:app/src/main/java/com/example/dogtown/network/DogImageApiService.kt
=======
/**
 * https://zenquotes.io/#docs
 */
/**
 * A public interface that exposes the [getRandomDogImage] method
 */
interface DogApiService {

    @GET("breeds/image/random")
    suspend fun getRandomDogImage(): RandomDogApiResponse
>>>>>>> e456e34330306de82125850b9fa3ba83e7481ab0:app/src/main/java/com/example/dogtown/network/DogApiService.kt

interface DogImageApiService {

    @GET("random")
    suspend fun getRandomDogImage(): DogImage
}
/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */

object DogImageApi
{
    val retrofitService: DogImageApiService by lazy { retrofit.create(DogImageApiService::class.java) }
}