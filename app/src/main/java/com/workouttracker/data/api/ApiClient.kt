package com.workouttracker.data.api

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.GsonBuilder
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient private constructor(private val context: Context) {
    
    companion object {
        private const val PREF_NAME = "workout_tracker_prefs"
        private const val KEY_BASE_URL = "base_url"
        private const val KEY_SESSION_COOKIE = "session_cookie"
        private const val DEFAULT_BASE_URL = "http://192.168.1.100:8080/" // Change to your server IP
        
        @Volatile
        private var INSTANCE: ApiClient? = null
        
        fun getInstance(context: Context): ApiClient {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: ApiClient(context.applicationContext).also { INSTANCE = it }
            }
        }
    }
    
    private val preferences: SharedPreferences = 
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    
    private val cookieJar = PersistentCookieJar()
    
    private val gson = GsonBuilder()
        .setLenient()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        .create()
    
    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .addInterceptor(createLoggingInterceptor())
            .cookieJar(cookieJar)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }
    
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(getBaseUrl())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
    
    val api: WorkoutApi by lazy {
        retrofit.create(WorkoutApi::class.java)
    }
    
    fun getBaseUrl(): String {
        return preferences.getString(KEY_BASE_URL, DEFAULT_BASE_URL) ?: DEFAULT_BASE_URL
    }
    
    fun setBaseUrl(baseUrl: String) {
        preferences.edit().putString(KEY_BASE_URL, baseUrl).apply()
        // Force recreation of retrofit instance
        INSTANCE = null
    }
    
    private fun createLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    
    private inner class AuthInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            val originalRequest = chain.request()
            
            // Add any auth headers if needed
            val requestBuilder = originalRequest.newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
            
            return chain.proceed(requestBuilder.build())
        }
    }
    
    private inner class PersistentCookieJar : CookieJar {
        private val cookies = mutableMapOf<String, List<Cookie>>()
        
        override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
            this.cookies[url.host] = cookies
            
            // Save session cookie to preferences for persistence
            cookies.find { it.name.contains("session", ignoreCase = true) }?.let { sessionCookie ->
                preferences.edit()
                    .putString(KEY_SESSION_COOKIE, "${sessionCookie.name}=${sessionCookie.value}")
                    .apply()
            }
        }
        
        override fun loadForRequest(url: HttpUrl): List<Cookie> {
            return cookies[url.host] ?: emptyList()
        }
        
        fun clearCookies() {
            cookies.clear()
            preferences.edit().remove(KEY_SESSION_COOKIE).apply()
        }
    }
    
    fun clearSession() {
        cookieJar.clearCookies()
    }
    
    fun isConnected(): Boolean {
        // Simple connectivity check - you might want to implement a ping endpoint
        return try {
            val runtime = Runtime.getRuntime()
            val process = runtime.exec("/system/bin/ping -c 1 ${getBaseUrl().substringAfter("://").substringBefore(":")}")
            val exitValue = process.waitFor()
            exitValue == 0
        } catch (e: Exception) {
            false
        }
    }
}
