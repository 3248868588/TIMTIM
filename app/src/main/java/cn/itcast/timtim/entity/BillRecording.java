package cn.itcast.timtim.entity;

import java.util.Date;

public class BillRecording {
    private String RecordingTime;
    private String Gridviews;
    private Double Money;

    public String getRecordingTime() {
        return RecordingTime;
    }

    public void setRecordingTime(String recordingTime) {
        RecordingTime = recordingTime;
    }

    public String getGridviews() {
        return Gridviews;
    }

    public void setGridviews(String gridviews) {
        Gridviews = gridviews;
    }

    public Double getMoney() {
        return Money;
    }

    public void setMoney(Double money) {
        Money = money;
    }

    public BillRecording(String recordingTime, String gridviews, Double money) {
        RecordingTime = recordingTime;
        Gridviews = gridviews;
        Money = money;
    }
}
