package com.atilsamancioglu.artbookhilttesting.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "arts")
data class Art(
    var name : String,
    var artistName : String,
    var year : Int,
    var imageUrl : String,
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null
)
