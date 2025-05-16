package org.knit.solutions;


import org.knit.TaskDescription;
import org.knit.solutions.ClassesTask.Task19.Merge;

import java.util.Arrays;


@TaskDescription(taskNumber = 19,
        taskDescription = "JUnit тесты для проверки слияния двух отсортированных массивов",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task19 implements Solution {
    public void execute() {
        Merge merge = new Merge();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge.merge(nums1, m, nums2, n);
        System.out.println("Merged array: " + Arrays.toString(nums1));
    }
}