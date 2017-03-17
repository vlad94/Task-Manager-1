package com.myactivity.dilyana.myactivity.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import com.myactivity.dilyana.myactivity.model.Task.TaskType;

import org.joda.time.LocalDate;

/**
 * Created by Dilyana on 3/14/2017.
 */

public class TaskManager {

    private HashMap<Task.TaskType, TreeSet<Task>> allTasks;
    private HashMap<Task.TaskType, Integer> numOfFinishedTasks;
    private HashMap<Task.TaskType, Integer> numOfUnfinishedTasks;
    private HashMap<TaskType, TreeSet<Task>> missedTasks;
    private int countRoutine;
    private int countReminder;
    private int countFinishedRoutine;
    private int countFinishedReminder;

    public TaskManager() {
        this.allTasks = new HashMap<Task.TaskType, TreeSet<Task>>();
        this.numOfFinishedTasks = new HashMap<Task.TaskType, Integer>();
        this.numOfUnfinishedTasks = new HashMap<Task.TaskType, Integer>();
    }

    public void addTask(Task task){
        if(!this.allTasks.containsKey(task.getTaskType())){
            this.allTasks.put(task.getTaskType(), new TreeSet<Task>());
        }
        this.allTasks.get(task.getTaskType()).add(task);
        if(task.getTaskType()==TaskType.Routine){
            this.numOfUnfinishedTasks.put(task.getTaskType(),++countRoutine);
        }
        else
            this.numOfUnfinishedTasks.put(task.getTaskType(),++countReminder);
    }

    public void removeTask(Task task){
        allTasks.get(task.getTaskType()).remove(task);
        //TODO remove task from allTasks
        if(task.getTaskType()==TaskType.Routine){
            this.numOfUnfinishedTasks.put(task.getTaskType(),--countRoutine);
        }
        else
            this.numOfUnfinishedTasks.put(task.getTaskType(),--countReminder);
    }

    public void printHelpInfo(){
        System.out.println(""
                + "Hello to work with Task manager must make zadacha- added task\n"
                + "You must add that for every day or for a day\n"
                + "and add an hour if you want to see tasks press see tasks");
    }

    public void printTodayTasks(){
        for(Iterator<Map.Entry<TaskType, TreeSet<Task>>> it = allTasks.entrySet().iterator(); it.hasNext();){
            Map.Entry<TaskType, TreeSet<Task>> e=it.next();
            for(Iterator<Task> et=e.getValue().iterator();et.hasNext();){
                Task t=et.next();

                if(t.getDate().equals(LocalDate.now())){
                    System.out.print(t.getName()+" / ");
                    System.out.print(t.getTaskType()+" / ");
                    System.out.print(t.getDate()+" / ");
                    System.out.print(t.getTime());
                    System.out.println();
                    System.out.println(t.getDescription());
                }
            }
        }
    }

    public void printChartReminder(){
        int numReminder=getTypeList(TaskType.Reminder);
        int numReminderFinish=getTypeListFinish(TaskType.Reminder);
        System.out.println("from  -"+numReminder+"-has completed-"+numReminderFinish);
    }

    public void printChartRoutine(){
        int numRoutine=getTypeList(TaskType.Routine);
        int numRoutineFinish=getTypeListFinish(TaskType.Routine);
        System.out.println("from  -"+numRoutine+"-has completed-"+numRoutineFinish);

    }

    public void setCompleteness(boolean isCompleted, Task task){
        if(isCompleted){
            if(allTasks.containsKey(task.getTaskType())){
                allTasks.get(task.getTaskType()).remove(task);
                if(task.getTaskType()==TaskType.Routine){
                    this.numOfUnfinishedTasks.put(task.getTaskType(), --countRoutine);
                    this.numOfFinishedTasks.put(task.getTaskType(),++countFinishedRoutine);
                    //	count--;
                }
                else{
                    this.numOfUnfinishedTasks.put(task.getTaskType(), --countReminder);
                    this.numOfFinishedTasks.put(task.getTaskType(),++countFinishedReminder);
                }

                //		countFinish++;
                //		this.numOfFinishedTasks.put(task.getTaskType(),countFinish);
            }
        }
    }

    private int getTypeList(TaskType t){
        int c1=0;
        for(Iterator<Map.Entry<TaskType, Integer>> it = numOfUnfinishedTasks.entrySet().iterator(); it.hasNext();){

            Map.Entry<TaskType, Integer> et=it.next();
            if(et.getKey()==t){
                c1+=et.getValue();
            }
        }return c1;
    }

    private int getTypeListFinish(TaskType t){
        int a=0;
        for(Iterator<Map.Entry<TaskType, Integer>> it = numOfFinishedTasks.entrySet().iterator(); it.hasNext();){

            Map.Entry<TaskType, Integer> et=it.next();
            if(et.getKey()==t){
                a+=et.getValue();
            }
        }return a;
    }

	public void addMissedTasks(){
        for(Iterator<Map.Entry<TaskType, TreeSet<Task>>> it = allTasks.entrySet().iterator(); it.hasNext();){
            Map.Entry<TaskType, TreeSet<Task>> e = it.next();
            for(Iterator<Task> it2 = e.getValue().iterator(); it2.hasNext();){
                Task e2 = it2.next();
                if(e2.getDate().compareTo(LocalDate.now())<0){
                    if(!this.missedTasks.containsKey(e2.getTaskType())){
                        this.missedTasks.put(e2.getTaskType(), new TreeSet<Task>());
                    }
                    this.missedTasks.get(e2.getTaskType()).add(e2);
                }
            }
        }

    }

	public void printMissedTasks(){
        for(Iterator<Map.Entry<TaskType, TreeSet<Task>>> it = missedTasks.entrySet().iterator(); it.hasNext();){
            Map.Entry<TaskType, TreeSet<Task>> e = it.next();
            System.out.println("---"+e.getKey()+"---");
            for(Iterator<Task> it2 = e.getValue().iterator(); it2.hasNext();){
                Task e2 = it2.next();
                System.out.println("    "+e2.toString());
            }
        }
    }
	
	public void printAllTasks(){
        for(Iterator<Map.Entry<TaskType, TreeSet<Task>>> it = allTasks.entrySet().iterator(); it.hasNext();){
            Map.Entry<TaskType, TreeSet<Task>> e = it.next();
            System.out.println("---"+e.getKey()+"---");
            for(Iterator<Task> it2 = e.getValue().iterator(); it2.hasNext();){
                Task e2 = it2.next();
                System.out.println("    "+e2.toString());
            }
        }
    }
}
