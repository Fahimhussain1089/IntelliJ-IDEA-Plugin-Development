package org.example.com.hussain.todohighlighter2

import com.intellij.openapi.components.BaseState
import com.intellij.openapi.externalSystem.autoimport.AutoImportProjectTracker
import com.intellij.psi.search.TodoItem

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.RoamingType
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.project.Project
import com.intellij.util.xmlb.annotations.Attribute
import com.intellij.util.xmlb.annotations.XMap
import com.intellij.openapi.components.*

import java.io.Serializable

@State(
    name = "TodoState",
    storages = [Storage(value = "todo-highlighter.xml", roamingType = RoamingType.DISABLED)]
)
@Service(Service.Level.PROJECT)
class TodoState : PersistentStateComponent<TodoState.State> {

    // Manual state management (alternative to property delegate)
    private var _todos: List<CustomTodoItem> = emptyList()

    // Public accessor with thread safety
    var todos: List<CustomTodoItem>
        get() = _todos
        set(value) {
            _todos = value.toList() // Create defensive copy
        }

    // State class with proper serialization
    data class State(
        @Attribute
        @XMap
        val todos: List<CustomTodoItem> = emptyList()
    )

    // Required state methods
    override fun getState(): State = State(_todos)
    override fun loadState(state: State) {
        _todos = state.todos
    }

    companion object {
        @JvmStatic
        fun getInstance(project: Project): TodoState {
            return project.getService(TodoState::class.java)
        }
    }
}

// Serializable Todo item

//
//@State(
//    name = "TodoState",
//    storages = [Storage("todo-highlighter.xml")]
//)
//class TodoState : PersistentStateComponent<TodoState.State> {
//    var todos: List<CustomTodoItem> = emptyList()
//
//    override fun getState(): State = State(todos)
//    override fun loadState(state: State) {
//        todos = state.todos
//    }
//
//    data class State(val todos: List<CustomTodoItem>)
//
//    companion object {
//        fun getInstance(project: Project): TodoState {
//            return project.getService(TodoState::class.java)
//        }
//    }
//}