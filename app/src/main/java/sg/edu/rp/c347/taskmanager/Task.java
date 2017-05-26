package sg.edu.rp.c347.taskmanager;

import java.io.Serializable;

/**
 * Created by 15017199 on 26/5/2017.
 */

public class Task implements Serializable {
    private int id;
    private String name;
    private String description;

    public Task(int id, String name, String description){
        this.name = name;
        this.description = description;
        this.id = this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }
}
