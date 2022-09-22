package note.time;

import java.io.IOException;

public class TimeImplement {

    static class Time {
        int hour;   //0~24시
        int minute; //0~59분 -> 60이 될 때 minute은 0, hour는 + 1
        int second; //0~59분 -> 60이 될 때 second는 0, minute은 + 1

        public Time(String time) {
            String[] splited = time.split(":");
            hour = Integer.parseInt(splited[0]);
            minute = Integer.parseInt(splited[1]);
            second = Integer.parseInt(splited[2]);
        }

        public Time(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        public void addSecond(int addSecond) {
            second += addSecond;
            if (second >= 60) {
                addMinute(second / 60);
                second %= 60;
            }
        }

        public void addMinute(int addMinute) {
            minute += addMinute;
            if (minute >= 60) {
                addHour(minute / 60);
                minute %= 60;
            }
        }

        public void addHour(int addHour) {
            hour += addHour;
        }

        public boolean isSameTime(Time otherTime) {
            return hour == otherTime.hour &&
                    minute == otherTime.minute &&
                    second == otherTime.second;
        }

        public boolean isLaterThan(Time otherTime) {
            if (hour > otherTime.hour) {    //hour 비교
                return true;
            } else if (hour < otherTime.hour) {
                return false;
            } else {    //hour는 같고, minute 비교
                if (minute > otherTime.minute) {
                    return true;
                } else if (minute < otherTime.minute) {
                    return false;
                } else {    //minute은 같고, second 비교
                    if (second > otherTime.second) {
                        return true;
                    } else if (second < otherTime.second) {
                        return false;
                    } else {
                        return isSameTime(otherTime);
                    }
                }
            }
        }

        public boolean isEarlyThan(Time otherTime) {
            return !isLaterThan(otherTime);
        }

        public Time subTime(Time otherTime) {
            //두 시간의 시간 차 계산
            Time bigTime;
            Time smallTime;
            if (this.isSameTime(otherTime)) {
                return new Time(0, 0, 0);
            } else if (this.isEarlyThan(otherTime)) {
                smallTime = this;
                bigTime = otherTime;
            } else {
                smallTime = otherTime;
                bigTime = this;
            }

            int resultHour = bigTime.hour;
            int resultMinute = bigTime.minute;
            int resultSecond= bigTime.second;

            if (resultSecond >= smallTime.second) {
                resultSecond -= smallTime.second;
            } else {
                resultMinute -= 1;
                resultSecond += 60;
                resultSecond -= smallTime.second;
            }

            if (resultMinute >= smallTime.minute) {
                resultMinute -= smallTime.minute;
            } else {
                resultHour -= 1;
                resultMinute += 60;
                resultMinute -= smallTime.minute;
            }

            resultHour -= smallTime.hour;

            return new Time(resultHour, resultMinute, resultSecond);
        }

        public String getTime() {
            StringBuilder sb = new StringBuilder();
            return sb.append(hour).append(":").append(minute).append(":").append(second).toString();
        }
    }

    public static void main(String[] args) throws IOException {
        String strTime1 = "12:59:01";
        String strTime2 = "12:59:02";
        String strTime3 = "12:59:01";

        Time time1 = new Time(strTime1);
        Time time2 = new Time(strTime2);
        Time time3 = new Time(strTime3);

        System.out.println(time3.subTime(time1).getTime());
    }


}