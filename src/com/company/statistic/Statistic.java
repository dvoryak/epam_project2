package com.company.statistic;

import java.util.Date;

public class Statistic {
    private Date start;
    private Date timeSpent;

    public Statistic() {
    }

    public void start(Date date) {
        date = new Date();
    }

    public void finish() {
        timeSpent = new Date(start.getTime() - new Date().getTime());
    }

    public Date getTimeSpent() {
        return timeSpent;
    }
}
