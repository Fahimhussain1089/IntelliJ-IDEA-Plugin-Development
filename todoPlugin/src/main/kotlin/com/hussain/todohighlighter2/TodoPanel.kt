package org.example.com.hussain.todohighlighter2

import com.intellij.openapi.externalSystem.autoimport.AutoImportProjectTracker
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.TextEditor
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.psi.search.TodoItem
import java.awt.BorderLayout
import javax.swing.DefaultListModel
import javax.swing.JList
import javax.swing.JPanel
import javax.swing.JScrollPane


import javax.swing.*

class TodoPanel : JPanel(BorderLayout()) {
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