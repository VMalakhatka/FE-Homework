package org.example.model.recorder;

import org.example.common.interfaces.recorder.GameRecord;
import org.example.common.interfaces.recorder.RecordHolder;

public class Recorder implements RecordHolder {
    @Override
    public boolean isNewRecord(GameRecord record) {
        return false;
    }

    @Override
    public void setNewRecord(GameRecord record) {

    }
}
