package com.myactivity.dilyana.myactivity.model;

/**
 * Created by Dilyana on 3/14/2017.
 */

import org.joda.time.Period;

public class Reminder extends Task{

    public enum RepeatType {
        ONLY_ONCE(Period.days(0)), DAYLY(Period.days(1)), WEEKLY(Period.weeks(1)), MONTHLY(Period.months(1)), YEARLY(Period.years(1));
        private Period period;

        private RepeatType(Period period) {
            this.period = period;
        }
    }
    private RepeatType repeatType;

    public Reminder(boolean hasNotification, String name, String description, String time, String date, RepeatType repeatType) {
        super(hasNotification, name, description, time, date);
        this.taskType = TaskType.Reminder;
    }

    @Override
    protected void calcNextDate(){
        this.date = this.date.plus(this.repeatType.period);
    }

    @Override
   public String toString() {
        // TODO print info for task and the repeatType
       return null;
    }
}

