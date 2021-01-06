class Solution {
    public int[][] highFive(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> studenIdVsMark = new TreeMap<>();
        for (int i = 0; i < items.length; ++i) {
            int studentId = items[i][0];
            int mark = items[i][1];
            PriorityQueue<Integer> marks = studenIdVsMark.get(studentId);

            if (marks == null) {
                marks = new PriorityQueue<>();
                studenIdVsMark.put(studentId, marks);
            }

            marks.add(mark);
            if (marks.size() > 5)
                marks.poll();

        }
        int[][] highFive = new int[studenIdVsMark.size()][2];
        int i = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : studenIdVsMark.entrySet()) {
            highFive[i][0] = entry.getKey();
            highFive[i++][1] = entry.getValue().stream().reduce(0, (a, b) -> a + b) / 5;
        }
        return highFive;
    }
}