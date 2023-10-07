package ru.panas.spring.models;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class Person {
    private int id;

    @NotEmpty(message = "description should not be empty")
    private String reason;

    private LocalDate startDate;

    @Min(value = 1, message = "duration should be greater than 0")
    @Digits(integer = 2, fraction = 0)
    private int duration;

    private boolean discounted;

    @NotEmpty(message = "description should not be empty")
    @Size(min = 1, max = 1024, message = "description should be between 2 and 1024 characters")
    private String description;

    public Person() {

    }

    public Person(int id, String reason, LocalDate startDate, int duration, boolean discounted, String description) {
        this.id = id;
        this.reason = reason;
        this.startDate = startDate;
        this.duration = duration;
        this.discounted = discounted;
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isDiscounted() {
        return discounted;
    }

    public void setDiscounted(boolean discounted) {
        this.discounted = discounted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
