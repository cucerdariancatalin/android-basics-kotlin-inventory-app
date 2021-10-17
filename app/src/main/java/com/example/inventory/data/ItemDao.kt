package com.example.inventory.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * FROM item WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query("SELECT * FROM item")
    fun getItems(): Flow<List<Item>>
}