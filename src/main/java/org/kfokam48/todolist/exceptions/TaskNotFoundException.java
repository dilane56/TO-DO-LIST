package org.kfokam48.todolist.exceptions;

public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException( String message ) {

        super( message );
    }
}
