package org.example.common.interfaces.game;

import org.example.model.field.Field;

public record GameState(FieldState field1,FieldState field2,int keg) {
}
