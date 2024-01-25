package CodeSoftPrgs;
import java.util.Scanner;
public class Task_2_new 
{
	
	
	
	    public static void main(String[] args) {
	        Scanner scanner=new Scanner(System.in);

	        
	        System.out.print("Enter the number of subjects: ");
	        int numSubjects=scanner.nextInt();

	        
	        int totalMarks=0;

	       
	        for (int i=1; i<=numSubjects; i++) {
	            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
	            int subjectMarks=scanner.nextInt();
	            totalMarks+=subjectMarks;
	        }
	       
	        double averagePercentage=(double) totalMarks / numSubjects;

	        
	        char grade=calculateGrade(averagePercentage);

	       
	        System.out.println("\nTotal Marks: " + totalMarks);
	        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
	        System.out.println("Grade: " + grade);

	       
	        scanner.close();
	    }

	    private static char calculateGrade(double averagePercentage) {
	        if (averagePercentage >= 90) {
	            return 'A';
	        } else if (averagePercentage>= 80) {
	            return 'B';
	        } else if (averagePercentage>= 70) {
	            return 'C';
	        } else if (averagePercentage>= 60) {
	            return 'D';
	        } else {
	            return 'F';
	        }
	    }
	}

