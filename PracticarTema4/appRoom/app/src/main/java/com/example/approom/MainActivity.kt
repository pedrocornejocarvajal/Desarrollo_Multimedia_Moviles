package com.example.approom

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var tasks: MutableList<TaskEntity>
    lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tasks = ArrayList()
        getTasks()
        findViewById<Button>(R.id.btnAddTask).setOnClickListener {
            addTask(TaskEntity(name = findViewById<EditText>(R.id.etTask).text.toString()))
        }
    }

    fun getTasks() = runBlocking {
        launch {
            tasks = MisNotasApp.database.TaskDao().getAllTasks()
            setUpRecyclerView(tasks)
        }
    }

    fun setUpRecyclerView(tasks: List<TaskEntity>) {
        adapter = TaskAdapter(tasks, { updateTask(it) }, { deleteTask(it) })
        recyclerView = findViewById(R.id.rvTask)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    fun updateTask(task: TaskEntity) = runBlocking {
        launch {
            task.isDone = !task.isDone
            MisNotasApp.database.TaskDao().updateTask(task)
        }
    }

    fun deleteTask(task: TaskEntity) = runBlocking {
        launch {
            val position = tasks.indexOf(task)
            MisNotasApp.database.TaskDao().deleteTask(task)
            tasks.remove(task)
            adapter.notifyItemRemoved(position)
        }
    }

    fun clearFocus() {
        findViewById<EditText>(R.id.etTask).setText("")
    }

    fun Context.hideKeyboard() {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)

    }

    fun addTask(task: TaskEntity) = runBlocking {
        launch {
            val id = MisNotasApp.database.TaskDao().addTask(task)
            val recoveryTask = MisNotasApp.database.TaskDao().getTaskById(id)
            tasks.add(recoveryTask)
            adapter.notifyItemInserted(tasks.size)
            clearFocus()
            hideKeyboard()
        }
    }
}
