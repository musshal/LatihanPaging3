package com.dicoding.myunlimitedquotes.data

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dicoding.myunlimitedquotes.network.QuoteResponseItem

@Dao
interface QuoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(quote: List<QuoteResponseItem>)

    @Query("SELECT * FROM quote")
    fun getAllQuote(): PagingSource<Int, QuoteResponseItem>

    @Query("DELETE FROM quote")
    suspend fun deleteAll()
}