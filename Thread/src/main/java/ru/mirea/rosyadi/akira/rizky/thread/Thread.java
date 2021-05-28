package ru.mirea.muratov.thread;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Thread extends Thread {
    Map<String, Integer> lessons = new HashMap<>();
    double monthAverage = 0;
    Handler handler;

    @NonNull
    @Override
    public String toString() {
        return String.valueOf(monthAverage);
    }

    public LessonCounter(Handler handler) {
        this.handler = handler;
        lessons.put("FirstMonday", 2);
        lessons.put("FirstTuesday", 4);
        lessons.put("FirstWednesday", 2);
        lessons.put("FirstThursday", 2);
        lessons.put("FirstFriday", 2);
        lessons.put("FirstSaturday", 2);
        lessons.put("SecondMonday", 4);
        lessons.put("SecondTuesday", 4);
        lessons.put("SecondWednesday", 4);
        lessons.put("SecondThursday", 2);
        lessons.put("SecondFriday", 0);
        lessons.put("SecondSaturday", 0);
    }

    @Override
    public void run() {
        for (Map.Entry<String, Integer> entry : lessons.entrySet()) {
            monthAverage += entry.getValue();
        }
        monthAverage += monthAverage + 10;
        monthAverage /= 30;
        Message msg = new Message();
        msg.obj = monthAverage;
        handler.sendMessage(msg);
    }
}
