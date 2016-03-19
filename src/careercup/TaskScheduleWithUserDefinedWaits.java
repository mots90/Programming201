package careercup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
     Task schedule: given a sequence of task like A B C(means 3 different tasks), and a coldtime, which means you need to wait for that much time to start next [same] task. Now----

     Input: string, n
     Output: the best task-finishing sequence.

     eg. input: AAABBB, 2
     Output: AB_AB_AB
     ( "_" represents do nothing and wait)

 *
 * Created by moheet-dev on 3/7/2016.
 */
public class TaskScheduleWithUserDefinedWaits {

    private static final char WAIT = '_';

    public void schedule(String taskString, int wait) {

        char[] tasks = taskString.toCharArray();
        char[] scheduledTasks = new char[20];
        Set<Integer> occupied = new HashSet<Integer>();



        for (int i = 0; i< scheduledTasks.length; i++) {
            scheduledTasks[i] = WAIT;
        }

        Map<Character, Integer> nextIndices = new HashMap<Character, Integer>();

        int presentTaskIndex = 0;

        for (int i = 0; i < tasks.length; i++) {

            char currentTask = tasks[i];
            int nextIndex;
            if (nextIndices.get(currentTask) == null) {

                while(occupied.contains(presentTaskIndex)) {
                    presentTaskIndex++;
                }

                nextIndex = presentTaskIndex;
            }
            else {
                nextIndex = nextIndices.get(currentTask);
            }

            nextIndices.put(currentTask,nextIndex + wait + 1);
            scheduledTasks[nextIndex] = currentTask;
            occupied.add(nextIndex);
            if (nextIndex == presentTaskIndex)
                presentTaskIndex++;

        }
        System.out.println(" THE SCHEDULED TASKS ARE " + new String(scheduledTasks));
    }

    public static void main(String[] args) {

        String tasks = "AAABBB";
        int wait = 2;

        TaskScheduleWithUserDefinedWaits scheduler = new TaskScheduleWithUserDefinedWaits();
        scheduler.schedule(tasks, wait);
    }

}
