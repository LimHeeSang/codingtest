package wootaecopractice;

import java.util.*;

public class Solution6 {

    private List<String> result = new ArrayList<>();
    private int totalTicketCount;

    public String[] solution(int totalTicket, String[] logs) {
        totalTicketCount = totalTicket;

        Log leaveLog = new Log(8, 59, 0);
        for (int i = 0; i < logs.length; i++) {
            Log nowLog = new Log(logs[i]);

            if (nowLog.isLaterThan(new Log(10, 0, 0)) || totalTicketCount == 0) {
                break;
            }

            if (i == logs.length - 1) {
                if (nowLog.action.equals("request") && nowLog.isLaterThan(leaveLog) &&
                        !new Log(nowLog.hour, nowLog.minute + 1, nowLog.second).isLaterThan(new Log(10, 0, 0))) {
                    successTicketing(nowLog.id);
                }
                break;
            }

            Log nextLog = new Log(logs[i + 1]);

            if (nowLog.action.equals("request")) {
                if (!nextLog.action.equals("leave") && nowLog.isLaterThan(leaveLog)) {
                    if (nowLog.isLaterThan(new Log(10, 0, 0))) {
                        break;
                    }
                    successTicketing(nowLog.id);

                    leaveLog = new Log(nowLog.hour, nowLog.minute + 1, nowLog.second);
                }
            } else if (nowLog.action.equals("leave")) {
                leaveLog = new Log(nowLog.hour, nowLog.minute, nowLog.second);
            }
        }

        String[] resultArray = new String[result.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = result.get(i);
        }
        Arrays.sort(resultArray);
        return resultArray;
    }

    public void successTicketing(String id) {
        if (!result.contains(id)) {
            result.add(id);
            totalTicketCount--;
        }
    }

    class Log {
        String id;
        String action;
        int hour;
        int minute;
        int second;

        public Log(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        public Log(String log) {
            String[] splited = log.split(" ");
            this.id = splited[0];
            this.action = splited[1];
            parseTime(splited[2]);
        }

        private void parseTime(String time) {
            String[] splited = time.split(":");
            this.hour = Integer.parseInt(splited[0]);
            this.minute = Integer.parseInt(splited[1]);
            this.second = Integer.parseInt(splited[2]);
        }

        public boolean isLaterThan(Log leaveLog) {
            if (this.hour > leaveLog.hour) {
                return true;
            } else if (this.hour < leaveLog.hour) {
                return false;
            } else {
                if (this.minute > leaveLog.minute) {
                    return true;
                } else if (this.minute < leaveLog.minute) {
                    return false;
                } else {
                    if (this.second > leaveLog.second) {
                        return true;
                    } else if (this.second < leaveLog.second) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();

        String[] logs = {
                "woni request 09:12:29",
                "brown request 09:23:11",
                "brown leave 09:23:44",
                "jason request 09:33:51",
                "jun request 09:33:56",
                "cu request 09:34:02"
        };

        String[] result = solution6.solution(2000, logs);
        System.out.println(Arrays.toString(result));
    }
}
