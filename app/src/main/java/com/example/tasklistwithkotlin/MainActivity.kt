package com.example.tasklistwithkotlin

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.DialogFragment
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewTaskDialogFragment.NewTaskDialogListener {

    private var todoListItems = arrayListOf<Any>()
    private var listView: ListView? = null
    private var listAdapter: ArrayAdapter<Any>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        listView = findViewById(R.id.list_view)
        populateListView()
        fab.setOnClickListener { showNewTaskUI() }
    }

    fun showNewTaskUI() {
        val newFragment = NewTaskDialogFragment.newInstance(R.string.add_new_task_dialog_title)
        newFragment.show(fragmentManager, "newtask")
    }

    private fun populateListView() {
        listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todoListItems)
        listView?.adapter = listAdapter
    }

    override fun onDialogPositiveClick(dialog: android.app.DialogFragment, task: String) {
        todoListItems.add(task)
        listAdapter?.notifyDataSetChanged()
        Snackbar.make(fab, "Task Added Successfully", Snackbar.LENGTH_LONG).setAction("Action", null).show()
    }

    override fun onDialogNegativeClick(dialog: android.app.DialogFragment) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

