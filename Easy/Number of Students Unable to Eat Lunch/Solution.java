import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        List<Integer> studentsList = Arrays.stream(students).boxed().collect(Collectors.toList());
        List<Integer> sandwichesList = Arrays.stream(sandwiches).boxed().collect(Collectors.toList());

        Iterator<Integer> sandwichesIter = sandwichesList.iterator();
        List<Integer> tempList;

        while (sandwichesIter.hasNext()) {
            Iterator<Integer> studentsIter = studentsList.iterator();
            Integer currentSandwich = sandwichesIter.next();
            boolean shouldBreak = false;
            tempList = new ArrayList<Integer>();

            while (studentsIter.hasNext() && !shouldBreak) {
                Integer currentStudent = studentsIter.next();
                if (currentSandwich.equals(currentStudent)) {
                    sandwichesIter.remove();
                    studentsIter.remove();
                    shouldBreak = true;
                } else {
                    studentsIter.remove();
                    tempList.add(currentStudent);
                }
            }

            studentsList.addAll(tempList);
            if (shouldBreak == false)
                return studentsList.size();
        }
        return 0;
    }
}