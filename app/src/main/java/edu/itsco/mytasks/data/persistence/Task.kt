package edu.itsco.mytasks.data.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val description: String,
    @ColumnInfo(name = "is_completed") val isCompleted: Boolean
)