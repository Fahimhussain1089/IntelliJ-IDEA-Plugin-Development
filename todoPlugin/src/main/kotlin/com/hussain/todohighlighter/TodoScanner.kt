package org.example.com.hussain.todohighlighter


data class TodoEntry(val text: String, val line: Int, val offset: Int)

object TodoScanner {
    fun findTodos(fileText: String): List<TodoEntry> {
        return fileText.lines().mapIndexedNotNull { index, line ->
            val todoIndex = line.indexOf("TODO")
            if (todoIndex != -1) {
                TodoEntry(line.trim(), index + 1, line.indexOf("//"))
            } else null
        }
    }
}