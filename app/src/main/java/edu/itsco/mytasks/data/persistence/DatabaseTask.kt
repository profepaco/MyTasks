package edu.itsco.mytasks.data.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1)
abstract class DatabaseTask: RoomDatabase() {
    abstract fun getDaoTask(): DaoTask

    companion object{
        private var INSTANCE: DatabaseTask? = null

        fun getInstance(context: Context): DatabaseTask{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room
                        .databaseBuilder(
                            context = context,
                            klass = DatabaseTask::class.java,
                            name = "db_tasks"
                        ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}