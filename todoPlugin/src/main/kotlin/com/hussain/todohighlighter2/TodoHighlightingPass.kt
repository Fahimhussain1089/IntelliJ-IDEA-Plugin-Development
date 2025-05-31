package org.example.com.hussain.todohighlighter2

import com.intellij.codeHighlighting.TextEditorHighlightingPass
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindowManager
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiRecursiveElementVisitor
import org.jetbrains.kotlin.psi.KtFile

class TodoHighlightingPass(
    file: PsiFile,
    editor: Editor,
    private val project: Project // Mark as private val to make it available class-wide
) : TextEditorHighlightingPass(project, editor.document) {

    private val document = editor.document
    private val todos = mutableListOf<CustomTodoItem>()
    private val ktFile = file as? KtFile

    override fun doCollectInformation(progress: ProgressIndicator) {
        println("🔍 Scanning file: ${progress}")
        ktFile?.accept(object : PsiRecursiveElementVisitor() {
            override fun visitComment(comment: PsiComment) {
                println("💬 Found comment check kro: ${comment.text}")
                val text = comment.text
                if (text.contains("TODO")) {
                    val lineNumber = document.getLineNumber(comment.textRange.startOffset)
                    todos.add(
                        CustomTodoItem(
                            text = text.trim(),
                            filePath = ktFile.virtualFile?.path ?: "unknown",
                            lineNumber = lineNumber + 1
                        )
                    )
                }
                super.visitComment(comment)
            }
        })
    }

    override fun doApplyInformationToEditor() {
        ToolWindowManager.getInstance(project)
            .getToolWindow("TODO Viewer")
            ?.contentManager
            ?.contents
            ?.firstOrNull()
            ?.component
            ?.let { panel ->
                (panel as? TodoPanel)?.updateTodos(todos)
            }
    }
}