package edu.itsco.mytasks.data.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DaoTask {

    @Query("SELECT * FROM tasks")
    fun getAllTask(): LiveData<List<Task>>

    @Insert
    fun insert(vararg task: Task)

    @Update
    fun update(vararg task: Task)

    @Delete
    fun delete(task: Task)

}