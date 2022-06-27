package com.jxareas.cocktails.data.local.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.jxareas.cocktails.data.local.model.CachedEntity

interface BaseDao<T : CachedEntity> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entities: List<T>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(entity: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(entities: List<T>)

    @Delete
    fun delete(entity: T)

    @Delete
    fun delete(entities: List<T>)

}
