package org.example.com.hussain.todohighlighter2

import com.intellij.util.xmlb.annotations.Attribute
import java.io.Serializable

//
//data class CustomTodoItem(
//    val text: String,
//    val filePath: String,
//    val lineNumber: Int
//) {
//    override fun toString(): String {
//        val fileName = filePath.substringAfterLast('/')
//        return "$fileName:$lineNumber - ${text.take(60)}..."
//    }
//}


//data class CustomTodoItem(
//    val text: String,
//    val filePath: String,
//    val lineNumber: Int
//) : Serializable



data class CustomTodoItem(
    @Attribute
    val text: String,

    @Attribute
    val filePath: String,

    @Attribute
    val lineNumber: Int
) : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }
}