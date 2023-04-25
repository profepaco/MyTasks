package edu.itsco.mytasks.ui.screens

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import edu.itsco.mytasks.data.persistence.DatabaseTask
import edu.itsco.mytasks.data.persistence.Task
import edu.itsco.mytasks.data.repositories.TaskRepository

class TaskViewModel(application: Application): ViewModel() {

    private val taskRepository: TaskRepository
    val allTask: LiveData<List<Task>>

    init{
        val taskDB = DatabaseTask.getInstance(
            application.applicationContext)

        taskRepository = TaskRepository(taskDB.getDaoTask())
        allTask = taskRepository.allTask
    }

    fun createTask(task: Task){
        taskRepository.createTask(task)
    }

    fun updateTask(task: Task){
        taskRepository.updateTask(task)
    }

    fun deleteTask(task: Task){
        taskRepository.deleteTask(task)
    }
}