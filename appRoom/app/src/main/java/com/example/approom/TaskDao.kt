package com.example.approom

import androidx.room.*
import kotlinx.coroutines.runBlocking

@Dao
interface TaskDao {
    @Query("SELECT * FROM task_entity")
    suspend fun getAllTasks(): MutableList<TaskEntity>
    @Query("SELECT * FROM task_entity WHERE id = :id")
    suspend fun findById(id: Int): TaskEntity

   @Insert
    suspend fun addTask (task:TaskEntity)
    @Update
    suspend fun updateTask(task: TaskEntity)
    @Delete
    suspend fun deleteTask(task: TaskEntity)
}
