package com.docker.application.dockerinttoroman.entity;

public class IntegerToRomanResponse {
    private Integer input;
    private String output;

    public IntegerToRomanResponse(Integer input, String output) {
        this.input = input;
        this.output = output;
    }

    public Integer getInput() {
        return input;
    }

    public void setInput(Integer input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
