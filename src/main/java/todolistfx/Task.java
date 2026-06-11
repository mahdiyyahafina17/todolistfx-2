/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todolistfx;

/**
 *
 * @author user
 */
public class Task {
     private int taskID;
    private String title;
    private String status;
    private String type;
    private String username;

    public Task(int taskID, String username, String title, String status, String type) { 

        this.taskID = taskID;
        this.username = username;
        this.title = title;
        this.status = status;
        this.type = type;
        
    }
    public int getTaskID() {
        return taskID;
    }
        public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }
        public void setUsername(String username) {
        this.username = username;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}