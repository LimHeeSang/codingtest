package programmers.level1;

//level1-21 최소직사각형
class Solution21 {
    public int solution(int[][] sizes) {
        int answer = 0;

        int maxW = 0;
        int maxH = 0;

        for(int i=0; i<sizes.length; i++){
            int tempW = Math.max(sizes[i][0], sizes[i][1]);
            int tempH = Math.min(sizes[i][0], sizes[i][1]);

            maxW = Math.max(tempW, maxW);
            maxH = Math.max(tempH, maxH);
        }

        return maxW*maxH;
    }
}
