package org.example.com.hussain.todohighlighter2

import com.intellij.openapi.project.Project
import javax.swing.*
import java.awt.BorderLayout

class CustomTodoPanel(private val project: Project) : JPanel(BorderLayout()) {
    private val model = DefaultListModel<CustomTodoItem>()
    private val list = JList(model)

    init {
        add(JScrollPane(list), BorderLayout.CENTER)
    }

    fun updateTodos(todos: List<CustomTodoItem>) {
        model.clear()
        todos.forEach { model.addElement(it) }
    }
}