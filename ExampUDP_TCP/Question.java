
public class Question {
	
	String question;
	String answer[] = new String[4];
	String solution;
	
	public Question(String question, String a, String b, String c, String d, String solution) {
		this.question = question;
		answer[0] = a;
		answer[1] = b;
		answer[2] = c;
		answer[3] = d;
		this.solution = solution;
	}
}
