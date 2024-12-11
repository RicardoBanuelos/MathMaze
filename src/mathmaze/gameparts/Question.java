package mathmaze.gameparts;

import java.util.ArrayList;

public class Question {
	
	String question;
	String option1;
	String option2;
	String option3;
	char answer;
	public ArrayList<Question> qlist = new ArrayList<Question>(); 
	
	public Question() {
		setQuestions();
	}
	
	public Question(String question, String option1, String option2, String option3, char answer) {
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.answer = answer;
	}
	
	public void setQuestions() {
		//Sumas y restas con numeros de 1 y 2 digitos
		qlist.add(new Question("Q: 17 - 3","a) 14", "b) 15", "c) 13",'a'));
		qlist.add(new Question("Q: 8 + 4","a) 10", "b) 12", "c) 11",'b'));
		qlist.add(new Question("Q: 7 - 5","a) 1", "b) 5", "c) 2",'c'));
		qlist.add(new Question("Q: 18 - 5","a) 13", "b) 16", "c) 12",'a'));
		qlist.add(new Question("Q: 17 + 5","a) 21", "b) 22", "c) 19",'b'));
		qlist.add(new Question("Q: 2 + 13","a) 16", "b) 12", "c) 15",'c'));
		qlist.add(new Question("Q: 23 - 7 ","a) 16", "b) 18", "c) 15",'a'));
		qlist.add(new Question("Q: 34 - 17","a) 18", "b) 17", "c) 23",'b'));
		qlist.add(new Question("Q: 11 + 22","a) 32", "b) 31", "c) 33",'c'));
		qlist.add(new Question("Q: 17 + 19","a) 36", "b) 29", "c) 34",'a'));
		qlist.add(new Question("Q: 37 - 18","a) 21", "b) 19", "c) 20",'b'));
		qlist.add(new Question("Q: 66 - 39","a) 28", "b) 32", "c) 27",'c'));
		qlist.add(new Question("Q: 57 + 24","a) 76", "b) 81", "c) 83",'b'));
		qlist.add(new Question("Q: 23 + 24","a) 47", "b) 48", "c) 49",'a'));
		qlist.add(new Question("Q: 11 - 7","a) 4", "b) 3", "c) 5",'a'));
		qlist.add(new Question("Q: 50 - 27","a) 23", "b) 24", "c) 13",'a'));
		qlist.add(new Question("Q: 75 + 25","a) 90", "b) 110", "c) 100",'c'));
		qlist.add(new Question("Q: 87 + 27","a) 124", "b) 104", "c) 114",'c'));
		qlist.add(new Question("Q: 93 - 23","a) 60", "b) 70", "c) 71",'b'));
		qlist.add(new Question("Q: 97 - 68","a) 29", "b) 39", "c) 49",'a'));
		//Multiplicacion de decenas
		qlist.add(new Question("Q: 40 x 8","a)240 ", "b)160 ", "c)320 ",'c'));
		qlist.add(new Question("Q: 60 x 3","a)180 ", "b)190 ", "c)120 ",'a'));
		qlist.add(new Question("Q: 40 x 3","a)180 ", "b)240 ", "c)120 ",'c'));
		qlist.add(new Question("Q: 30 x 8","a)135 ", "b)240 ", "c)260 ",'b'));
		qlist.add(new Question("Q: 50 x 2","a)100", "b)125 ", "c)120 ",'a'));
		qlist.add(new Question("Q: 7 x 40","a)240 ", "b)280 ", "c)210 ",'b'));
		qlist.add(new Question("Q: 90 x 1","a)180 ", "b)91 ", "c)90 ",'c'));
		qlist.add(new Question("Q: 70 x 5","a)75 ", "b)300 ", "c)350 ",'c'));
		qlist.add(new Question("Q: 3 x 80","a)240 ", "b)260 ", "c)320 ",'a'));
		qlist.add(new Question("Q: 7 x 30","a)200 ", "b)210 ", "c)220 ",'b'));
		//Divisiones
		qlist.add(new Question("Q: 18 / 6","a)3 ", "b)4 ", "c)5 ",'a'));
		qlist.add(new Question("Q: 54 / 6","a)9 ", "b)5 ", "c)4 ",'a'));
		qlist.add(new Question("Q: 21 / 3","a)9 ", "b)7 ", "c)3 ",'b'));
		qlist.add(new Question("Q: 28 / 7","a)3 ", "b)4 ", "c)5 ",'b'));
		qlist.add(new Question("Q: 15 / 5","a)7 ", "b)5 ", "c)3 ",'c'));
		qlist.add(new Question("Q: 90 / 9","a)1 ", "b)9 ", "c)10 ",'c'));
		qlist.add(new Question("Q: 48 / 6","a)8 ", "b)7 ", "c)6 ",'a'));
		qlist.add(new Question("Q: 35 / 7","a)7 ", "b)5 ", "c)3 ",'b'));
		qlist.add(new Question("Q: 63 / 9","a)9 ", "b)8 ", "c)7 ",'c'));
		qlist.add(new Question("Q: 72 / 8","a)8 ", "b)7 ", "c)9 ",'c'));
		//Simbolos en ecuaciones de Multiplicacion y Division
		qlist.add(new Question("Q: 21 = 7 x Y , Y = ?","a)3 ", "b)4 ", "c)2 ",'a'));
		qlist.add(new Question("Q: 3 = Y / 9 , Y = ?","a)27 ", "b)28 ", "c)24 ",'a'));
		qlist.add(new Question("Q: Y = 48 / 6 , Y = ?","a)6 ", "b)8 ", "c)9 ",'b'));
		qlist.add(new Question("Q: 24 = Y x 3 , Y = ?","a)8 ", "b)6 ", "c)3 ",'a'));
		qlist.add(new Question("Q: Y x 9 = 54 , Y = ?","a)8 ", "b)7 ", "c)6 ",'c'));
		qlist.add(new Question("Q: Y / 4 = 4 , Y = ?","a)4 ", "b)8 ", "c)16 ",'c'));
		qlist.add(new Question("Q: Y / 6 = 6, Y = ?","a)38 ", "b)36 ", "c)32 ",'b'));
		qlist.add(new Question("Q: 6 x 7 = Y , Y = ?","a)41 ", "b)42 ", "c)43 ",'b'));
		qlist.add(new Question("Q: 90 = 9 x Y , Y = ? ","a)10 ", "b)9 ", "c)11 ",'a'));
		qlist.add(new Question("Q: Y = 49 / 7 , Y = ?","a)5 ", "b)6 ", "c)7 ",'c'));
		//Tiempo y masa
		qlist.add(new Question("Q: 3 minutos = ?","a)180 s ", "b)170 s", "c)160 s",'a'));
		qlist.add(new Question("Q: 1 minuto = ?","a)60 min ", "b)60 seg ", "c)59 seg",'b'));
		qlist.add(new Question("Q: 120 segundos = ?","a)1 min", "b)2 min ", "c)3 min ",'b'));
		qlist.add(new Question("Q: 60 minutos = ?","a)3 h ", "b)2 h", "c)1 h",'c'));
		qlist.add(new Question("Q: 300 minutos = ?","a)3 h ", "b)7 h", "c)5 h",'c'));
		qlist.add(new Question("Q: 3600 segundos = ?","a)1 h", "b)10 min", "c)2 h ",'a'));
		qlist.add(new Question("Q: 1 kilogramo = ?","a)10 gramos", "b)100 gramos", "c)1000 gramos",'c'));
		qlist.add(new Question("Q: 1 gramo = ? ","a)10 miligramos", "b)100 miligramos", "c)1000 miligramos",'c'));
		qlist.add(new Question("Q: 1000 gramos = ?","a)1 kilogramo", "b)1000 miligramos", "c)10 kilogramos",'a'));
		qlist.add(new Question("Q: 1 tonelada = ?","a)1000 kilogramos", "b)1000 gramos", "c)10000 miligramos",'a'));
		//Fracciones equivalentes
		qlist.add(new Question("Q: 1 entero equivalente a: ","a) 4/4", "b)3/2", "c)2/5",'a'));
		qlist.add(new Question("Q: 2/6 equivalente a:","a)2/3", "b)1/3", "c)2/2",'b'));
		qlist.add(new Question("Q: 2/3 equivalente a:","a)1/2", "b)4/7", "c)4/6",'c'));
		qlist.add(new Question("Q: 8/64 equivalente a:","a)1/8", "b)1/9", "c)1/7",'a'));
		qlist.add(new Question("Q: 2/4 equivalente a:","a)2/8", "b)1/2", "c)2",'b'));
		qlist.add(new Question("Q: 9/3 equivalente a:","a)1/9", "b)2", "c)3",'c'));
		qlist.add(new Question("Q: 5/20 equivalente a:","a)1/4", "b)1/3", "c)1/2",'a'));
		qlist.add(new Question("Q: 7/35 equivalente a:","a)1/4", "b)1/5", "c)1/6",'b'));
		qlist.add(new Question("Q: 3/27 equivalente a:","a)2/18", "b)1", "c)2/9",'a'));
		//Suma y resta de fracciones con denominador comun
		qlist.add(new Question("Q: 6/8 + 2/8","a)10/8", "b)8/8", "c)7/8",'b'));
		qlist.add(new Question("Q: 5/5 + 6/5","a)10/5", "b)11/6", "c)11/5",'c'));
		qlist.add(new Question("Q: 3/4 + 1/4","a)4/4", "b)5/4", "c)4/5",'a'));
		qlist.add(new Question("Q: 5/3 + 5/3","a)10/3", "b)10/5", "c)5/3",'a'));
		qlist.add(new Question("Q: 1/12 + 3/12 ","a)5/12", "b)4/12", "c)4/11",'b'));
		qlist.add(new Question("Q: 5/3 + 7/3","a)12/3", "b)3/12", "c)13/3",'a'));
		qlist.add(new Question("Q: 25/100 + 55/100","a)75/100", "b)80/100", "c)85/100",'b'));
		qlist.add(new Question("Q: 3/6 - 2/6","a)2/6", "b)1/6", "c)1/3",'b'));
		qlist.add(new Question("Q: 7/8 - 3/8","a)8/4", "b)3/8", "c)4/8",'c'));
		qlist.add(new Question("Q: 5/8 - 1/8","a)3/8", "b)1/2", "c)2/8",'b'));
		qlist.add(new Question("Q: 2/3 - 1/3","a)1/3", "b)1/4", "c)-1/3",'a'));
		qlist.add(new Question("Q: 9/12 - 4/12","a)5/12", "b)12/5", "c)5/112",'a'));
		qlist.add(new Question("Q: 4/12 - 2/12","a)12/2", "b)1/6", "c)2/11",'b'));
		qlist.add(new Question("Q: 5/10 - 4/10","a)10", "b)2/10", "c)1/10",'c'));
		//Poligonos
		qlist.add(new Question("Q: Un Cuadrado tiene ","a)4 lados", "b)3 lados", "c)2 lados",'a'));
		qlist.add(new Question("Q: Un Triangulo tiene","a)4 lados", "b)3 lados", "c)2 lados",'b'));
		qlist.add(new Question("Q: Un Rectangulo tiene","a)2 lados", "b)3 lados", "c)4 lados",'c'));
		qlist.add(new Question("Q: Un Pentagono tiene","a)3 lados", "b)4 lados", "c)5 lados",'c'));
		qlist.add(new Question("Q: Un Hexagono tiene","a)3 lados", "b)6 lados", "c)9 lados",'b'));
		qlist.add(new Question("Q: Un Octagono tiene","a)8 lados", "b)6 lados", "c)4 lados",'a'));
		//Sumas con numeros de 2 y 3 cifras
		qlist.add(new Question("Q: 143 + 745","a)888", "b)887", "c)788",'a'));
		qlist.add(new Question("Q: 247 + 22","a)368", "b)369", "c)370",'b'));
		qlist.add(new Question("Q: 622 + 305","a)928", "b)827", "c)927",'c'));
		qlist.add(new Question("Q: 136 + 54","a)190", "b)180", "c)189",'a'));
		qlist.add(new Question("Q: 94 + 123","a)217", "b)218", "c)219",'a'));
		qlist.add(new Question("Q: 89 + 64 ","a)164", "b)153", "c)155",'b'));
		qlist.add(new Question("Q: 256 + 16","a)282", "b)292", "c)272",'c'));
		qlist.add(new Question("Q: 639 + 27","a)666", "b)668", "c)766",'a'));
		qlist.add(new Question("Q: 333 + 254","a)577", "b)587", "c)687",'b'));
		qlist.add(new Question("Q: 555 + 222","a)677", "b)776", "c)777",'c'));
		//Restas con numeros de 2 y 3 cifras
		qlist.add(new Question("Q: 111-13","a)98", "b)99", "c)97",'a'));
		qlist.add(new Question("Q: 354 - 50","a)314", "b)304", "c)204",'b'));
		qlist.add(new Question("Q: 789 - 179","a)601", "b)160", "c)610",'c'));
		qlist.add(new Question("Q: 60 - 48","a)21", "b)22", "c)12",'c'));
		qlist.add(new Question("Q: 999 - 123","a)786", "b)876", "c)687",'b'));
		qlist.add(new Question("Q: 110 - 20","a)90", "b)91", "c)99",'a'));
		qlist.add(new Question("Q: 520 -201","a)139", "b)219", "c)319",'c'));
		qlist.add(new Question("Q: 827 - 19","a)888", "b)808", "c)708",'b'));
		qlist.add(new Question("Q: 114 - 41","a)73", "b)37", "c)74",'a'));
		qlist.add(new Question("Q: 225 -75","a)125", "b)150", "c)160",'b'));
		
	}
	
	public boolean check(char answer) {
		if(answer == this.answer) {
			return true;
		}
		else {
			return false;
		}
	}
}
