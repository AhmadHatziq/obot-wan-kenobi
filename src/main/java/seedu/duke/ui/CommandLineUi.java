package seedu.duke.ui;

import seedu.duke.task.Deadline;
import seedu.duke.task.Event;
import seedu.duke.task.Task;
import seedu.duke.task.Todo;
import seedu.duke.tasklist.TaskList;

public class CommandLineUi extends Ui {
    private static final String underscore = "    ____________________________________________________________" + "\n";

    public CommandLineUi(){
    }


    public static String getWelcomeString(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String intro = underscore
                + "      Hello! I'm Duke " + "\n"
                + "      What can I do for you?" + "\n"
                + underscore;
        return (logo + intro);
    }

    /**
     * Prints the Done Sequence, when the user command "done" is entered.
     *
     * @param tasks TaskList class, which contains a list of Task objects.
     * @param taskNum Integer index of the task which has been selected as "done".
     */
    public String getDoneSequence(TaskList tasks, int taskNum){
        String output = underscore + "     Nice! I've marked this task as done:\n"
                + "       [" + tasks.getTask(taskNum).getStatusIcon() + "] " + tasks.getTask(taskNum).getTaskName()
                + "\n" + underscore;
        return output;
    }

    /**
     * Returns the Todo Sequence, when the user command "Todo" is entered.
     *
     * @param tasks TaskList class, which contains a list of Task objects.
     * @param newTodo Todo class, which has been newly created.
     */
    public String getTodoSequence(TaskList tasks, Todo newTodo) {
        String output = underscore + "     Got it. I've added this task:\n       "
                + newTodo.toString() + getTasksRemainingSequence(tasks.getSize());
        return output;
    }

    /**
     * Returns the Deadline sequence, when the user command "deadline" is entered.
     *
     * @param tasks TaskList class, which contains a list of Task objects.
     * @param newDeadline Deadline class, which has been newly created.
     */
    public String getDeadlineSequence(TaskList tasks, Deadline newDeadline) {
        String output = underscore + "     Got it. I've added this task:\n       "
                + newDeadline.toString() + getTasksRemainingSequence(tasks.getSize());
        return output;
    }

    /**
     * Returns the Event sequence, when the user command "event" is entered.
     *
     * @param tasks TaskList class, which contains a list of Task objects.
     * @param newEvent Event class, which has been newly created.
     */
    public String getEventSequence(TaskList tasks, Event newEvent) {
        String output = underscore + "     Got it. I've added this task:\n       "
                + newEvent.toString() + getTasksRemainingSequence(tasks.getSize());
        return output;
    }

    /**
     * Returns the Delete sequence, when the user command "delete" is entered.
     *
     * @param tasks TaskList class, which contains a list of Task objects.
     * @param taskToDelete Task class, which will be deleted from the list.
     */
    public String getDeleteSequence(TaskList tasks, Task taskToDelete) {
        String output = underscore + "     Noted. I've removed this task.\n       "
                + taskToDelete.toString() + getTasksRemainingSequence(tasks.getSize());
       return output;
    }

    /**
     * Returns the Bye sequence, when the user command "bye" is entered.
     */
    public String getByeSequence() {
        String output = underscore + "\n" + "     " + "Bye. Hope to see you again soon!" + "\n" + underscore + "\n";
        return output;
    }

    /**
     * Returns the string containing tasks in a pre-formatted form.
     * Eg. "1.[E][✘] Run (at: ERC)
     *      2.[D][✓] IPPT (by: 21st of December 2004, 8.15am)
     *      3.[E][✓] Lecture (at: LT7A)".
     *
     * @param tasks TaskList object
     * @return String of tasks
     */
    public String getListSequence(TaskList tasks) {
        String output = "";
        for (int i = 0; i < tasks.getSize(); i++) {
            output += "     " + (i + 1) + "." + tasks.getTask(i).toString() + "\n";
        }
        output += underscore;
        return output;
    }

    /**
     * Returns the tasks which are similar for the "find" command.
     *
     * @param tasks TaskList object
     */
    public String getFoundTasks(TaskList tasks) {
        String output = underscore + "     Here are the matching tasks in your list:\n";
        output += getListSequence(tasks);
        return output;
    }

    public String getTasksRemainingSequence(int numOfTaskRemaining) {
        String output = "\n     Now you have "
                + numOfTaskRemaining + " tasks in the list.\n" + underscore;
        return output;
    }
}