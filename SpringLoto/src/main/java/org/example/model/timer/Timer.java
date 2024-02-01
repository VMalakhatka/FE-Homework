package org.example.model.timer;

import org.example.common.interfaces.timer.GameTimer;
import org.springframework.stereotype.Component;
import java.time.Duration;
@Component
public class Timer implements GameTimer {
    @Override
    public Duration getCurrent() {
        return null;
    }

    @Override
    public void reset() {

    }

    @Override
    public void start() {

    }

    @Override
    public Duration stop() {
        return null;
    }
}
