package com.myactivity.dilyana.myactivity.model;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * Created by Dilyana on 3/14/2017.
 */

public class TaskManager {

    private HashMap<Task.TaskType, TreeSet<Task>> allTasks;
    private HashMap<Task.TaskType, Integer> numOfFinishedTasks;
    private HashMap<Task.TaskType, Integer> numOfUnfinishedTasks;

    public TaskManager() {
        this.allTasks = new HashMap<Task.TaskType, TreeSet<Task>>();
        this.numOfFinishedTasks = new HashMap<Task.TaskType, Integer>();
        this.numOfUnfinishedTasks = new HashMap<Task.TaskType, Integer>();
    }

    public void addTask(Task task){
        //TODO - add task to allTasks
    }

    public void removeTask(Task task){
        //TODO remove task from allTasks
    }

    public void editTask(Task oldTask, Task newTask){
        //TODO - edit task
    }

    public void printHelpInfo(){
        //TODO - print description for the task manager
    }

    public void printTodayTasks(){
        //TODO - print all active tasks for today
    }

    public void printChart(){
     	//TODO - print percent of finished tasks and percent of unfinished tasks and their type
    }

    public void setCompleteness(boolean isCompleted, Task task){
    	// if isCompleted - add to numOfFinishedTasks and increment the integer
    	//else - add to numOfUninishedTasks and increment the integer
    }
}
