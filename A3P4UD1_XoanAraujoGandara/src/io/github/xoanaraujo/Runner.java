package io.github.xoanaraujo;

import java.io.Serializable;

public class Runner implements Serializable {
    private String name;
    private Integer dorsal;
    private Integer time;
    private Boolean deleted;

    public Runner(String name, Integer dorsal, Integer time) {
        this(name, dorsal, time, false);
    }

    public Runner(String name, int dorsal, int time, boolean deleted) {
        this.name = name;
        this.dorsal = dorsal;
        this.time = time;
        this.deleted = deleted;
    }

    public String getName() {
        return name;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public Integer getTime() {
        return time;
    }

    public Boolean isDeleted() {
        return deleted;
    }
}
