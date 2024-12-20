package quiz;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class participant {
		private String name;
		private int age;
		private String email;
		private long pno;
		private String address;
		private int count = 0;
	    private boolean isFiftyFiftyUsed = false;
	    private boolean isAudiencePollUsed = false;
		public void SetName(String name) {
			this.name=name;
		}
		public String getName() {
			return name;
		}
		public void SetAge(int age) {
			this.age=age;
		}
		public int getAge() {
			return age;
		}
		public void SetEmail(String email) {
			this.email=email;
		}
		public String getEmail() {
			return email;
		}
		public void SetPno(long pno) {
			this.pno=pno;
		}
		public long getPno() {
			return pno;
		}
		public void SetAddress(String address) {
			this.address=address;
		}
		public String getAddress() {
			return address;
		}
	
	public void displayrules() {
		try {
		
		System.out.println("Welcome to the Quiz Game! Your goal is to answer all the questions correctly and score the highest points.");
	    System.out.println("1. Each question has four options: A, B, C, and D. Choose the correct answer by typing the corresponding letter.");
	    System.out.println("2. For every correct answer, you will earn 10 points. There are no points for incorrect answers.");
	    System.out.println("3. You have two lifelines to assist you during the game:");
	    System.out.println("   - The 50-50 Lifeline removes two incorrect options, leaving one correct and one incorrect option.");
	    System.out.println("   - The Audience Poll Lifeline shows audience voting percentages for each option to help you decide.");
	    System.out.println("4. Each lifeline can only be used once during the game.");
	    System.out.println("5. If you answer incorrectly, the game ends immediately, and your final score will be displayed.");
	    System.out.println("6. Try your best and enjoy the game! Good luck!");
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
			
		}


	}
	 public void useFiftyFifty(String[] options, String correctAnswer) {
		 try {
	        if (isFiftyFiftyUsed) {
	            System.out.println("You have already used the 50-50 lifeline.");
	            return;
	        }

	        Random random = new Random();
	        int correctIndex = -1;
	        for (int i = 0; i < options.length; i++) {
	            if (options[i].equalsIgnoreCase(correctAnswer)) {
	                correctIndex = i;
	                break;
	            }
	        }

	        boolean[] toShow = new boolean[options.length];
	        toShow[correctIndex] = true;
	        int removed = 0;

	        while (removed < 2) {
	            int randomIndex = random.nextInt(options.length);
	            if (randomIndex != correctIndex && !toShow[randomIndex]) {
	                toShow[randomIndex] = true;
	                removed++;
	            }
	        }

	        System.out.println("50-50 Lifeline Used. Remaining options:");
	        for (int i = 0; i < options.length; i++) {
	            if (toShow[i]) {
	                System.out.println("Option " + (char) ('A' + i) + ": " + options[i]);
	            }
	        }

	        isFiftyFiftyUsed = true;
		 }
		 catch(InputMismatchException e) {
				e.printStackTrace();
				
			}
	    }
	 public void useAudiencePoll(String[] options, String correctAnswer) {
		 try {
	        if (isAudiencePollUsed) {
	            System.out.println("You have already used the Audience Poll lifeline.");
	            return;
	        }

	        Random random = new Random();
	        int correctIndex = -1;
	        for (int i = 0; i < options.length; i++) {
	            if (options[i].equalsIgnoreCase(correctAnswer)) {
	                correctIndex = i;
	                break;
	            }
	        }

	        int[] poll = new int[options.length];
	        int remaining = 100;
	        for (int i = 0; i < poll.length; i++) {
	            if (i == correctIndex) {
	                poll[i] = 50 + random.nextInt(21); // 50-70% for the correct answer
	            } else {
	                poll[i] = random.nextInt(remaining / 2);
	            }
	            remaining -= poll[i];
	        }

	        poll[correctIndex] += remaining; // Ensure percentages add to 100

	        System.out.println("Audience Poll Results:");
	        for (int i = 0; i < options.length; i++) {
	            System.out.println("Option " + (char) ('A' + i) + ": " + poll[i] + "%");
	        }

	        isAudiencePollUsed = true;
		 }
		 catch(InputMismatchException e) {
				e.printStackTrace();
				
			}
	    }

	 public void askQuestion(String question, String[] options, String correctAnswer) {
		 try {
	        System.out.println(question);
	        Scanner sc=new Scanner(System.in);
	        for (int i = 0; i < options.length; i++) {
	            System.out.println("Option " + (char) ('A' + i) + ": " + options[i]);
	        }

	        System.out.println("Enter your answer or type '50-50' or 'Poll' to use a lifeline:");
	        String answer = sc.nextLine().trim();

	        if (answer.equalsIgnoreCase("50-50")) {
	            useFiftyFifty(options, correctAnswer);
	            askQuestion(question, options, correctAnswer); // Re-ask the question
	        } else if (answer.equalsIgnoreCase("Poll")) {
	            useAudiencePoll(options, correctAnswer);
	            askQuestion(question, options, correctAnswer); // Re-ask the question
	        } else if (answer.equalsIgnoreCase(correctAnswer)) {
	            System.out.println("Correct!");
	            count += 10;
	            System.out.println("You have scored " + count + " points.");
	        } else {
	            System.out.println("Incorrect! The correct answer was: " + correctAnswer);
	            System.out.println("Game over! You are leaving with " + count + " points.");
	            System.exit(0);
	        }
		 }
		 catch(InputMismatchException e) {
				e.printStackTrace();
				
			}
	    }
	 public void playgame() {
			try {
			 askQuestion("Which car company uses the slogan 'The Ultimate Driving Machine'?", new String[]{"BMW", "Mercedes-Benz", "Audi", "Lexus"}, "BMW");
		     askQuestion("What is the primary color of the Facebook logo?", new String[]{"Blue", "Green", "Red", "Yellow"}, "Blue");
			 askQuestion("Which brand is known for its 'Just Do It' slogan?", new String[]{"Nike", "Adidas", "Reebok", "Under Armour"}, "Nike");
			 askQuestion("Which company makes the iPhone?", new String[]{"Apple", "Samsung", "Google", "Nokia"}, "Apple");
		     askQuestion("Which video game company created the Mario franchise?", new String[]{"Nintendo", "Sony", "Microsoft", "SEGA"}, "Nintendo");
		     askQuestion("Which tech company is known for the Windows operating system?", new String[]{"Microsoft", "Apple", "IBM", "Dell"}, "Microsoft");
	         askQuestion("Which beverage brand is famous for its polar bear commercials?", new String[]{"Coca-Cola", "Pepsi", "Dr Pepper", "Sprite"}, "Coca-Cola");
			 askQuestion("Which airline is known for its kangaroo logo?", new String[]{"Qantas", "Emirates", "Delta", "British Airways"}, "Qantas");
			 askQuestion("Which chocolate company uses the slogan 'Have a break, have a KitKat'?", new String[]{"Nestle", "Mars", "Hershey's", "Cadbury"}, "Nestle");
			 askQuestion("Which search engine company owns YouTube?", new String[]{"Google", "Yahoo", "Bing", "DuckDuckGo"}, "Google");
			}
			catch(InputMismatchException e) {
				e.printStackTrace();
				
			}
		}
}