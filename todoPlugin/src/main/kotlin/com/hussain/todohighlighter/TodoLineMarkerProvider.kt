package org.example.com.hussain.todohighlighter

import com.intellij.codeInsight.daemon.LineMarkerProvider

import com.intellij.codeHighlighting.*
import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiComment
import com.intellij.icons.AllIcons



class TodoLineMarkerProvider : LineMarkerProvider {
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        if (element is PsiComment && element.text.contains("TODO")) {
            return LineMarkerInfo(
                element,
                element.textRange,
                AllIcons.General.TodoDefault,
                { "TODO: ${element.text}" },
                null,
                GutterIconRenderer.Alignment.LEFT
            )
        }
        return null
    }
}
