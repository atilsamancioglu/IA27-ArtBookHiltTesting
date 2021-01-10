package com.atilsamancioglu.artbookhilttesting.repo

import androidx.lifecycle.LiveData
import com.atilsamancioglu.artbookhilttesting.model.ImageResponse
import com.atilsamancioglu.artbookhilttesting.model.ImageResult
import com.atilsamancioglu.artbookhilttesting.roomdb.Art
import com.atilsamancioglu.artbookhilttesting.util.Resource
import retrofit2.Response

interface ArtRepositoryInterface {

    suspend fun insertArt(art : Art)

    suspend fun deleteArt(art: Art)

    fun getArt() : LiveData<List<Art>>

    suspend fun searchImage(imageString : String) : Resource<ImageResponse>

}