package br.com.app.futebolnatv.di

import br.com.app.futebolnatv.channel.data.datasource.ChannelApiDataSource
import br.com.app.futebolnatv.team.data.datasource.TeamApiDataSource
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiDataSourceModule {
    @Provides
    fun provideBaseUrl() = "https://futebolnatv.free.beeceptor.com"

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder().add(KotlinJsonAdapterFactory())
            .build()
    @Provides
    @Singleton
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun provideOkHttpClient() =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()


    @Singleton
    @Provides
    fun provideRetrofit(
        oktHttpClient: OkHttpClient,
        moshi: Moshi,
        baseUrl: String
    ): Retrofit =
        Retrofit.Builder()
            .client(oktHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Provides
    @Singleton
    fun providesTeamService(
        retrofit: Retrofit,
    ): TeamApiDataSource = retrofit.create(TeamApiDataSource::class.java)

    @Provides
    @Singleton
    fun providesChannelService(
        retrofit: Retrofit,
    ): ChannelApiDataSource = retrofit.create(ChannelApiDataSource::class.java)

}