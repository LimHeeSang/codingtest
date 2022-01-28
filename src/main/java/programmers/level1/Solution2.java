package programmers.level1;

//level1-2 신규 아이디 추천
class Solution2 {
    public String solution(String new_id) {
        String id = new_id.toLowerCase(); // 1단계

        id = id.replaceAll("[^-_.a-z0-9]", ""); // 2단계
        id = id.replaceAll("[.]{2,}", "."); // 3단계
        id = id.replaceAll("^[.]|[.]$", "");    // 4단계

        if (id.equals("")) {    // 5단계
            id += "a";
        }

        if (id.length() >= 16) {     // 6단계
            id = id.substring(0, 15);
            id = id.replaceAll("[.]$","");
        }

        if (id.length() <= 2) {  // 7단계
            while (id.length() < 3) {
                id += id.charAt(id.length()-1);
            }
        }

        return id;
    }
}
