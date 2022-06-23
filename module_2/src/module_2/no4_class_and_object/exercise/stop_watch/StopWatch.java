package module_2.no4_class_and_object.exercise.stop_watch;

import java.util.Date;

public class StopWatch {
    private Date startTime;
    private Date endTime;

    public StopWatch() {
        startTime = new Date();
    }

    void start() {
        startTime = new Date();
    }

    void end() {
        endTime = new Date();
    }

    long getElapsedTime() {
        return endTime.getTime() - startTime.getTime();
    }
}
