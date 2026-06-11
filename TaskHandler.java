/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todolistfx;

/**
 *
 * @author user
 */
public class PersonalTask extends Task { //child

    private String timeSlot;

    public PersonalTask(int taskID, String username, String title, String status, String timeSlot) {

        super(taskID,username,title, status, "Personal");

        this.timeSlot = timeSlot;
    }
    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
}