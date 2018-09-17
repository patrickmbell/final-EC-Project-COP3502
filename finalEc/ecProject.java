

import java.io.Console;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;  
import java.lang.Math; 


public class ecProject{

	static HashMap<String, String> definitions = new HashMap<String, String>();

	static HashMap<Integer, String> cAnswers = new HashMap<>();

	static ArrayList<String> answerBank_ = new ArrayList<String >();

	static ArrayList<String> qBank = new ArrayList<String>();

	static int correctQ = 0;
	static int questions = 0;


	public static Object getKey(Map map, Object obj)
	{
		for(Object o: map.keySet())
		{
			if(map.get(o).equals(obj))
			{
				return o;
			}
		}
		return null;
	}

	public static String randomQuestion(String[] check)
	{
		int x = 1 + (int) (Math.random()*(24));

		for(int i = 1; i < check.length; i++)
		{
			if(check[i] != null && check[i] == check[i-1])
			{
				x = 1+ (int) Math.random()*(24);
				return answerBank_.get(x);
			}
		}

		return answerBank_.get(x);
	}

	public static void answerBank()
	{
		for(String keys: definitions.keySet())
		{
			answerBank_.add(keys);
		}

		for (String vals: definitions.values())
		{
			qBank.add(vals);
		}

		return;
	}

	public static char randomAnswers(int qNum, String x)	//which question number I'm on
	{
		int y = (int) (Math.random() * answerBank_.size()-1) + 1;
		int correctNum = 1 + (int) (Math.random()*(3));

		String[] answers = new String[3];


		char ch = ' ';
		System.out.println(" ");
		switch(correctNum)
		{			
			case 1:
				System.out.println("A) " + getKey(definitions, x));
				System.out.println("B) " + (answers[0] = randomQuestion(answers)));
				System.out.println("C) " +(answers[1] = randomQuestion(answers)));
				System.out.println("D) " +(answers[2] = randomQuestion(answers)));
				ch = 'a';
				break;


			case 2:
				System.out.println("A) " + (answers[0] = randomQuestion(answers)));
				System.out.println("B) " + getKey(definitions,x));
				System.out.println("C) " + (answers[1] = randomQuestion(answers)));
				System.out.println("D) " +(answers[2] = randomQuestion(answers)));
				ch = 'b';
				break;


			case 3:
				System.out.println("A) "+(answers[0] = randomQuestion(answers)));
				System.out.println("B) " +(answers[1] = randomQuestion(answers)));
				System.out.println("C) " + getKey(definitions,x));
				System.out.println("D) " +(answers[2] = randomQuestion(answers)));
				ch = 'c';
				break;


			case 4:
				System.out.println("A) "+(answers[0] = randomQuestion(answers)));
				System.out.println("B) " + (answers[1] = randomQuestion(answers)));
				System.out.println("C) "+(answers[2] = randomQuestion(answers)));
				System.out.println("D) " + getKey(definitions,x));
				ch = 'd';
				break;
		}

		return ch;

	}

	
	public static void main(String args[])
	{
	 	
		Scanner input = new Scanner(System.in); 		

		try
		{
		BufferedReader reader = new BufferedReader(new FileReader("words.txt"));

		String line = " ";
		int i = 0;
		while((line = reader.readLine()) != null)
		{
			if(line.contains(":"))
			{
				definitions.put(line.substring(0,line.indexOf(":")), line.substring((line.indexOf(":")+1),line.indexOf(".")));
			}
			//definitions.put("Whyyy", line);
			line = reader.readLine();

		}


//	System.out.println("Using the get function: " + definitions.get("Public"));
//	System.out.println("Using the keyset function: " + definitions.keySet());


	answerBank();

	Collections.shuffle(qBank);

	int count = 1;
	char answer = ' ';
	for(String values: qBank)
	{
		questions+=1;

		System.out.println("Question " + count + ")"+ values);
		count++;



	char correctAnswer = randomAnswers(count, values);
 
	System.out.print("\nAnswer: ");
	answer =  input.next().charAt(0);




	if(answer == correctAnswer || answer == Character.toUpperCase(correctAnswer))
	{
		correctQ+=1;
	continue;
	}
	else
	{
		String s1 =(String) getKey(definitions, values);
		cAnswers.put(questions, s1);
	}


		if(questions == 5 || questions == 10 || questions == 15 || questions == 20 || questions == 25)
		{

			double x = ((double) correctQ / (double) questions)*100;
			System.out.println("***********SCORE***********");
			System.out.println("# of Correct Answers: " + correctQ);
			System.out.println("# of Total Questions: " + questions);
			System.out.format("\nPercent Score: %.2f",x);
			System.out.println("\n***********SCORE***********");
			System.out.println("\n******CORRECT ANSWERS******");
			for(Map.Entry<Integer,String> ent: cAnswers.entrySet())
			{
				System.out.println("# " + ent.getKey() + " Correct Answer: " + ent.getValue());
			}
			System.out.println("******CORRECT ANSWERS******");
			System.out.println(" ");


			cAnswers.clear();
		}

	}
}

	catch(IOException e)
	{System.err.println("Don't touch me you motherfucker get ouuuut!");}


	}

}
