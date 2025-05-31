//package org.example.com.hussain.todohighlighter
package com.hussain.todoHighlighter

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.psi.*
import com.intellij.openapi.application.ApplicationManager
import com.intellij.ui.content.ContentFactory
import org.example.com.hussain.todohighlighter.TodoToolWindowPanel

class TodoToolWindowFactory : ToolWindowFactory {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val panel = TodoToolWindowPanel(project)
        val contentManager = toolWindow.contentManager
        val content = contentManager.factory.createContent(panel, "", false)
        contentManager.addContent(content)

        // Add listener for file open/change
        PsiManager.getInstance(project).addPsiTreeChangeListener(object : PsiTreeChangeAdapter() {
            override fun childrenChanged(event: PsiTreeChangeEvent) {
                val file = event.file ?: return
                if (file.name.endsWith(".kt")) {
                    ApplicationManager.getApplication().invokeLater {
                        panel.updateTodos(file)
                    }
                }
            }
        }, project)
    }

    override fun shouldBeAvailable(project: Project) = true
}
