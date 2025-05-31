package org.example.com.hussain.todohighlighter2

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
//import com.intellij.openapi.wm.ToolWindowFactor
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory

class TodoToolWindowFactory : ToolWindowFactory {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Create your custom panel instead of using internal TodoPanel
        println("🛠️ ToolWindow created check this is wokring or not chekck ki thik se!")
        val panel = CustomTodoPanel(project)
        val content = ContentFactory.getInstance().createContent(panel, "", false)
        toolWindow.contentManager.addContent(content)

        // Load saved state from your custom state component
        TodoState.getInstance(project)?.let { state ->
            panel.updateTodos(state.todos)
        }
    }
}

