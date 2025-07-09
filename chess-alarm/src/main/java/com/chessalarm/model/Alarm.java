package com.chessalarm.model;

import java.time.LocalDateTime;

public class Alarm {
    private Long id;
    private LocalDateTime time;
    private boolean active;
    private boolean ringing;
    private int movesRequired = 3;
    private int movesMade = 0;

    public Alarm() {}

    public Alarm(Long id, LocalDateTime time) {
        this.id = id;
        this.time = time;
        this.active = true;
        this.ringing = false;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isRinging() {
        return ringing;
    }

    public void setRinging(boolean ringing) {
        this.ringing = ringing;
    }

    public int getMovesRequired() {
        return movesRequired;
    }

    public int getMovesMade() {
        return movesMade;
    }

    public void setMovesMade(int movesMade) {
        this.movesMade = movesMade;
    }

    public void incrementMovesMade() {
        this.movesMade++;
    }
}
