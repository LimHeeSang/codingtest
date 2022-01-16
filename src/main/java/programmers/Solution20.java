package programmers;

//level1-20 2016년
class Solution20 {
    public String solution(int month, int date) {
        String answer = "";

        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int sum = 0;

        if(month == 1){
            sum = date-1;
        }else{
            for(int i=month-1; i>0; i--){
                sum += dateByMonth(i);
            }
            sum += date-1;
        }

        return day[sum%7];
    }

    public int dateByMonth(int month){
        int[] dates = {31, 29, 31, 30,
                31, 30, 31, 31,
                30, 31, 30, 31};

        return dates[month-1];
    }
}
