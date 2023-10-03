package io.github.xoanaraujo;

import java.io.Serializable;

public class Runner implements Serializable {
    private String name;
    private Integer dorsal;
    private Integer time;
    private Boolean isDeleted;

    public Runner(String name, Integer dorsal, Integer time) {
        this.name = name;
        this.dorsal = dorsal;
        this.time = time;
        isDeleted = false;
    }

    public void delete() {
        isDeleted = true;
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
}
