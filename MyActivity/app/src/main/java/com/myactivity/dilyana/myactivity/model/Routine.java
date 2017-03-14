package com.myactivity.dilyana.myactivity.model;

import org.joda.time.Period;

/**
 * Created by Dilyana on 3/14/2017.
 */

public class Routine extends Task{

    private int repeatDays;

    public Routine(boolean hasNotification, String name, String description, String time, String date, int repeatDays) {
        super(hasNotification, name, description, time, date);
        // TODO validation
        this.repeatDays = repeatDays;
        this.taskType = TaskType.Routine;
    }

    @Override
    protected void calcNextDate() {
        if (this.repeatDays >= 0) {
            this.date = this.date.plus(Period.days(1));
            --this.repeatDays;
        }
    }

    @Override
    public String toString() {
        // TODO print info for task and days left to repeat
         return null;
    }
}

