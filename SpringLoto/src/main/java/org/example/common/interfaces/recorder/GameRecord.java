package org.example.common.interfaces.recorder;

import java.io.Serializable;
import java.time.Duration;

public record GameRecord(String playerName, Duration duration) implements Serializable {

}
