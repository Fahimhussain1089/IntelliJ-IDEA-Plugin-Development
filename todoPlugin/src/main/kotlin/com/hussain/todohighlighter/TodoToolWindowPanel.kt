package org.example.com.hussain.todohighlighter

import java.awt.BorderLayout
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.DefaultListModel
import javax.swing.JList
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.ListSelectionModel


import com.intellij.openapi.editor.ScrollType
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile

import javax.swing.*

//
//class TodoToolWindowPanel {
//}

class TodoToolWindowPanel(private val project: Project) : JPanel(BorderLayout()) {
    private val listModel = DefaultListModel<TodoEntry>()
    private val todoList = JList(listModel)

    init {
        add(JScrollPane(todoList), BorderLayout.CENTER)
        todoList.selectionMode = ListSelectionModel.SINGLE_SELECTION

        todoList.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent?) {
                if (e?.clickCount == 2) {
                    val todo = todoList.selectedValue ?: return
                    val file = FileEditorManager.getInstance(project).selectedFiles.firstOrNull() ?: return
                    val editor = FileEditorManager.getInstance(project).selectedTextEditor ?: return
                    val document = editor.document
                    if (todo.line - 1 < document.lineCount) {
                        val offset = document.getLineStartOffset(todo.line - 1)
                        editor.caretModel.moveToOffset(offset)
                        editor.scrollingModel.scrollToCaret(ScrollType.CENTER)
                    }
                }
            }
        })
    }

    fun updateTodos(file: PsiFile) {
        val todos = TodoScanner.findTodos(file.text)
        listModel.clear()
        todos.forEach { listModel.addElement(it) }
    }
}
