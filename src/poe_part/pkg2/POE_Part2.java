/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poe_part.pkg2;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
/**
 *
 * @author RC_Student_lab
 */
public class POE_Part2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String[] options = {"Add Task", "Show Report (Coming Soon)", "Cancel"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Please Select an Option",
                "Task Options",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                0);

        while (choice != 2) {
            if (choice == 0) {
                if (!addTask()) {
                    JOptionPane.showMessageDialog(null, "Task addition cancelled.");
                }
            } else if (choice == 1) {
                // Implement show report functionality
                JOptionPane.showMessageDialog(null, "Report functionality coming soon.");
            }

            choice = JOptionPane.showOptionDialog(
                    null,
                    "Please Select an Option",
                    "Task Options",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    0);
        }
    }

    public static boolean addTask() {
        String taskCountStr = JOptionPane.showInputDialog("Please enter the number of tasks:");
        if (taskCountStr == null) {
            return false;
        }

        int taskCount = Integer.parseInt(taskCountStr);

        for (int i = 0; i < taskCount; i++) {
            if (!createTask()) {
                return false;
            }
        }

        return true;
    }

    public static boolean createTask() {
        String taskName = JOptionPane.showInputDialog("Enter task name:");
        if (taskName == null) {
            return false;
        }

        String taskNumberStr = JOptionPane.showInputDialog("Enter task number:");
        if (taskNumberStr == null) {
            return false;
        }

        int taskNumber = Integer.parseInt(taskNumberStr);

        String description = JOptionPane.showInputDialog("Enter task description:");
        if (description == null) {
            return false;
        }

        if (description.length() > 50) {
            JOptionPane.showMessageDialog(null, "Task description should be less than 50 characters.");
            return false;
        }

        String developerDetails = JOptionPane.showInputDialog("Enter developer details (First Name and Last Name):");
        if (developerDetails == null) {
            return false;
        }

        String durationStr = JOptionPane.showInputDialog("Enter task duration (hours):");
        if (durationStr == null) {
            return false;
        }

        int duration = Integer.parseInt(durationStr);

        String taskID = (taskName.substring(0, 2) + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.length() - 3)).toUpperCase();

        String[] statusOptions = {"To Do", "Done"};
        int statusChoice = JOptionPane.showOptionDialog(
                null,
                "Please select task status",
                "Status",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                statusOptions,
                0);

        String status = statusOptions[statusChoice];

        JOptionPane.showMessageDialog(null,
                "Task ID: " + taskID + "\n" +
                        "Task Name: " + taskName + "\n" +
                        "Task Number: " + taskNumber + "\n" +
                        "Task Description: " + description + "\n" +
                        "Developer Details: " + developerDetails + "\n" +
                        "Task Duration: " + duration + " hours\n" +
                        "Task Status: " + status);

        return true;
    }
}
        
    
    

