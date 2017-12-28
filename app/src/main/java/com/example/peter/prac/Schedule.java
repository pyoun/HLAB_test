package com.example.peter.prac;

/**
 * Created by Peter on 12/26/2017.
 */

public class Schedule implements Comparable<Schedule> {
    public int eventId;
    public String startTime;
    public String endTime;
    public String eventName;
    public String eventLocation;
    public String eventInfo;

    public Schedule(int eventId, String startTime, String endTime,
                    String eventName, String eventLocation, String eventInfo) {
        this.eventId = eventId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventInfo = eventInfo;
    }

    public int getEventId() { return this.eventId; }
    public String getDuration() {
        String[] time1 = this.startTime.split(":");
        String[] time2 = this.endTime.split(":");
        int time1_h = Integer.parseInt(time1[0]);
        int time1_m = Integer.parseInt(time1[1]);
        int time2_h = Integer.parseInt(time2[0]);
        int time2_m = Integer.parseInt(time2[1]);
        int startx = time1_h * 60 + time1_m;
        int endx = time2_h * 60 + time2_m;
        int duration = endx - startx;
        if (duration < 0) {
            duration = duration + 1440;
        }
        String hours = Integer.toString(duration / 60);
        String minutes = Integer.toString(duration % 60);
        return hours+" hours and " + minutes + " minutes.";
    }
    public int getStartTimeMins() {
        return (Integer.parseInt(this.startTime.split(":")[0])*60
                + Integer.parseInt(this.startTime.split(":")[1]));
    }

    @Override
    public int compareTo(Schedule compEvent) {
        // sorting by EventId
        //int compId = ((Schedule) compEvent).getEventId();
        //return this.getEventId()-compId;

        // sorting by startTime
        int compTimeAbsMin = ((Schedule) compEvent).getStartTimeMins();
        return this.getStartTimeMins() - compTimeAbsMin;
    }
}
