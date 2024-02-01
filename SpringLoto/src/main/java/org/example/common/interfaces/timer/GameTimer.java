package org.example.common.interfaces.timer;

import java.time.Duration;

public interface GameTimer {

    Duration getCurrent();

    void reset();

    void start();

    Duration stop();
}