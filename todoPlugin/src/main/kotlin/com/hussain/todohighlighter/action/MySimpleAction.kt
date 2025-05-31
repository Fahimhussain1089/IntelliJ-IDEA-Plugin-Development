package com.hussain.todoHighlighter

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class MySimpleAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            "Hello from TODO Highlighter Plugin!",
            "Greeting",
            Messages.getInformationIcon()
        )
    }
}
