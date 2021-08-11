import java.util.*;

class Solution {
    public String solution(int[][] scores) {
        String answer = "";
        List<Integer> grades = new ArrayList<>();
        
        int studentCount = scores.length;
        for (int i = 0; i < studentCount; i++) {
            int sum = 0;
            int min = 100;
            int max = 0;
            int myScore = scores[i][i];
            
            for (int j = 0; j < studentCount; j++) {
                int score = scores[j][i];
                sum += score;
                
                if (i == j) continue;
                max = Math.max(max, score);
                min = Math.min(min, score);
            }
            
            if (myScore > max || myScore < min) {
                sum -= myScore;  
                grades.add(sum / studentCount);
                continue;
            } 
            grades.add(sum / studentCount);
        }
        
        for (int score : grades) {
            answer += getGrades(score);
        }
        return answer;
    }
    
    private String getGrades(int score) {
        if (score >= 90) {
            return "A";
        }
        if (score >= 80) {
            return "B";
        }
        if (score >= 70) {
            return "C";
        }
        if (score >= 50) {
            return "D";
        }
        return "F";
    }
}
