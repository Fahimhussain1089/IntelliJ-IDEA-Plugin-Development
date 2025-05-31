package org.example.com.hussain.todohighlighter2

import java.io.Serializable


data class TodoItem(
    val text: String,
    val filePath: String,
    val lineNumber: Int
) : Serializable