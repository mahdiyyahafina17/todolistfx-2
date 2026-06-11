/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todolistfx;

/**
 *
 * @author user
 */
public class AcademicTask extends Task { // child

    private String dueDate;

    public AcademicTask(int taskID, String username,String title, String status, String dueDate) {

        super(taskID,username, title, status, "Academic");

        this.dueDate = dueDate;
    }
    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}