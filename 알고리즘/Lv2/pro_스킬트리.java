 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-15
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/49993
  *
  */

class Solution {
    public int solution(String skill, String[] skill_trees) {
int answer = skill_trees.length;

        for (int i=0; i<skill_trees.length; i++) {
            String oneSkillTree = skill_trees[i];

            int prevIndex = -1;
            for (int j=0; j<oneSkillTree.length(); j++) {
                String oneSkill = String.valueOf(oneSkillTree.charAt(j));
                int currentIndex = skill.indexOf(oneSkill);
                if (currentIndex == -1) continue;

                if (currentIndex-1 == prevIndex) {
                    prevIndex = currentIndex;
                } else {
                    answer--;
                    break;
                }
            }

        }
    
        return answer;
    }
}