package com.atilsamancioglu.artbookhilttesting.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.atilsamancioglu.artbookhilttesting.R
import com.atilsamancioglu.artbookhilttesting.adapter.ArtRecyclerAdapter
import com.atilsamancioglu.artbookhilttesting.adapter.ImageRecyclerAdapter
import com.atilsamancioglu.artbookhilttesting.api.RetrofitAPI
import com.atilsamancioglu.artbookhilttesting.repo.ArtRepository
import com.atilsamancioglu.artbookhilttesting.repo.ArtRepositoryInterface
import com.atilsamancioglu.artbookhilttesting.roomdb.ArtDao
import com.atilsamancioglu.artbookhilttesting.roomdb.ArtDatabase
import com.atilsamancioglu.artbookhilttesting.util.Util.BASE_URL
import com.atilsamancioglu.artbookhilttesting.view.ArtFragmentFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun injectRoomDatabase(
            @ApplicationContext context: Context
    ) = Room.databaseBuilder(context,ArtDatabase::class.java,"ArtBookDB").build()

    @Singleton
    @Provides
    fun injectDao(
        database: ArtDatabase
    ) = database.artDao()

    @Singleton
    @Provides
    fun injectRetrofitAPI() : RetrofitAPI {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL).build().create(RetrofitAPI::class.java)
    }

    @Singleton
    @Provides
    fun injectNormalRepo(dao : ArtDao, api: RetrofitAPI) = ArtRepository(dao,api) as ArtRepositoryInterface

    @Singleton
    @Provides
    fun injectGlide(@ApplicationContext context: Context) = Glide
            .with(context).setDefaultRequestOptions(
                    RequestOptions().placeholder(R.drawable.ic_launcher_foreground)
                            .error(R.drawable.ic_launcher_foreground)
            )

}