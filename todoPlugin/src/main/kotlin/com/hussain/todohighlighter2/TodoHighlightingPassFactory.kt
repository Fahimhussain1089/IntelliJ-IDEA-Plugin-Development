package org.example.com.hussain.todohighlighter2

import com.intellij.codeHighlighting.TextEditorHighlightingPass
import com.intellij.codeHighlighting.TextEditorHighlightingPassFactory
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile

class TodoHighlightingPassFactory : TextEditorHighlightingPassFactory {
    override fun createHighlightingPass(file: PsiFile, editor: Editor): TextEditorHighlightingPass? {
        return TodoHighlightingPass(file, editor, file.project)
    }
}