package Programmers;

public class 숫자문자열과영단어 {
	public static void main(String[] args) {
		  solution("one4seveneight");
	}
	
	public static int solution(String s) {
        int answer = 0;
        String[] num = {"0","1","2","3","4","5","6","7","8","9"};
        String[] word = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String answerStr = s;
        for(int i=0;i<word.length;i++){
            if(answerStr.contains(word[i])){
            	answerStr = answerStr.replaceAll(word[i],num[i]);
            }
        }
        System.out.println(answerStr);
        return answer;
    }
}
