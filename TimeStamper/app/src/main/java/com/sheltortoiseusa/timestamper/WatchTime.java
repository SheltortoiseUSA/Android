package com.sheltortoiseusa.timestamper;

public class WatchTime {
    private long startTime;
    private long timeUpdate;
    private long storedTime;

    public WatchTime() {
        startTime = 0L;
        storedTime = 0L;
        timeUpdate = 0L;
    }
    public void resetWatchTime() {
        startTime = 0L;
        storedTime = 0L;
        timeUpdate = 0L;
    }
    public void setStartTime(long lng) {
        startTime = lng;
    }
    public long getStartTime() {
        return startTime;
    }
    public void setTimeUpdate(long lng) {
        timeUpdate = lng;
    }
    public long getTimeUpdate() {
        return timeUpdate;
    }
    public void addStoredTime(long timeInMilliseconds) {
        storedTime += timeInMilliseconds;
    }
    public long getStoredTime() {
        return storedTime;
    }
}