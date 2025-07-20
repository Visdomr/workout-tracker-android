package com.workouttracker.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \'2\u00020\u0001:\u0003&\'(B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020!R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00060\fR\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006)"}, d2 = {"Lcom/workouttracker/data/api/ApiClient;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "api", "Lcom/workouttracker/data/api/WorkoutApi;", "getApi", "()Lcom/workouttracker/data/api/WorkoutApi;", "api$delegate", "Lkotlin/Lazy;", "cookieJar", "Lcom/workouttracker/data/api/ApiClient$PersistentCookieJar;", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "preferences", "Landroid/content/SharedPreferences;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "retrofit$delegate", "clearSession", "", "createLoggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "getBaseUrl", "", "isConnected", "", "setBaseUrl", "baseUrl", "AuthInterceptor", "Companion", "PersistentCookieJar", "app_release"})
public final class ApiClient {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREF_NAME = "workout_tracker_prefs";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_BASE_URL = "base_url";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_SESSION_COOKIE = "session_cookie";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DEFAULT_BASE_URL = "http://192.168.1.100:8080/";
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.workouttracker.data.api.ApiClient INSTANCE;
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences preferences = null;
    @org.jetbrains.annotations.NotNull()
    private final com.workouttracker.data.api.ApiClient.PersistentCookieJar cookieJar = null;
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy okHttpClient$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy retrofit$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy api$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.workouttracker.data.api.ApiClient.Companion Companion = null;
    
    private ApiClient(android.content.Context context) {
        super();
    }
    
    private final okhttp3.OkHttpClient getOkHttpClient() {
        return null;
    }
    
    private final retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.workouttracker.data.api.WorkoutApi getApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBaseUrl() {
        return null;
    }
    
    public final void setBaseUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String baseUrl) {
    }
    
    private final okhttp3.logging.HttpLoggingInterceptor createLoggingInterceptor() {
        return null;
    }
    
    public final void clearSession() {
    }
    
    public final boolean isConnected() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/workouttracker/data/api/ApiClient$AuthInterceptor;", "Lokhttp3/Interceptor;", "(Lcom/workouttracker/data/api/ApiClient;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_release"})
    final class AuthInterceptor implements okhttp3.Interceptor {
        
        public AuthInterceptor() {
            super();
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull()
        okhttp3.Interceptor.Chain chain) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/workouttracker/data/api/ApiClient$Companion;", "", "()V", "DEFAULT_BASE_URL", "", "INSTANCE", "Lcom/workouttracker/data/api/ApiClient;", "KEY_BASE_URL", "KEY_SESSION_COOKIE", "PREF_NAME", "getInstance", "context", "Landroid/content/Context;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.workouttracker.data.api.ApiClient getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/workouttracker/data/api/ApiClient$PersistentCookieJar;", "Lokhttp3/CookieJar;", "(Lcom/workouttracker/data/api/ApiClient;)V", "cookies", "", "", "", "Lokhttp3/Cookie;", "clearCookies", "", "loadForRequest", "url", "Lokhttp3/HttpUrl;", "saveFromResponse", "app_release"})
    final class PersistentCookieJar implements okhttp3.CookieJar {
        @org.jetbrains.annotations.NotNull()
        private final java.util.Map<java.lang.String, java.util.List<okhttp3.Cookie>> cookies = null;
        
        public PersistentCookieJar() {
            super();
        }
        
        @java.lang.Override()
        public void saveFromResponse(@org.jetbrains.annotations.NotNull()
        okhttp3.HttpUrl url, @org.jetbrains.annotations.NotNull()
        java.util.List<okhttp3.Cookie> cookies) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.util.List<okhttp3.Cookie> loadForRequest(@org.jetbrains.annotations.NotNull()
        okhttp3.HttpUrl url) {
            return null;
        }
        
        public final void clearCookies() {
        }
    }
}