/*Задание 2.1 создать сущность "Запись в журнале куратора" содержащую поля:
-фамилия студента
-имя студента
-дата рождения студента
-телефон студента
-домашний адрес (улица, дом, квартира)

реализовать:
 введение данных с командной строки
 валидация
 вывод результатов

Выполнил студент гр. КМ-19 (Прикладная математика) ДВНЗ "ПГТУ" Иванов Григорий  mailto: ivanov_g_o@pstu.edu
*/

import java.util.*;
import java.io.*;

public class JournalNote{
	
 /*      	class Date {
        int yy;
        int mm;
        int dd;
        }  
	
	 class Adress {
	 String Street;
   	 int    House;
 	 int    Appartament;
	             }
	
 		*/
 		
 	static class Student {
 	
         String LastName;
         String FirstName;
	 int    Phone;
	// Date   Birth;
        int yy;
        int mm;
        int dd;
	// Adress Addr;
        String Street;
   	int    House;
 	int    Appartament;
 	
 	    Student(boolean isEmpty){
   if  (!isEmpty) {
    Scanner in = new Scanner(System.in);

    System.out.print("Input surname: ");
         LastName=in.nextLine();
    System.out.print("Input name: ");
         FirstName=in.nextLine();
    System.out.print("Input phone: ");
         Phone=in.nextInt();
       System.out.print("Input year of birth: ");
         yy=in.nextInt();
    System.out.print("Input month of birth: ");
         mm=in.nextInt();
    System.out.print("Input day of birth: ");
         dd=in.nextInt();
         in.nextLine();
    System.out.print("Input street: ");
         Street=in.nextLine();
    System.out.print("Input house No: ");
         House=in.nextInt();
    System.out.print("Input appartament`s No: ");
         Appartament=in.nextInt(); 	    
 	    }
 	    }
 	    
	
	 	      }  
	static  void PrintJournal(Student stdnt){
    System.out.printf("surname:%15s ", stdnt.LastName );
    System.out.printf("name:%15s ", stdnt.FirstName );
    System.out.printf("phone number:%10d ", stdnt.Phone );
    System.out.printf("date of birth: %4d/%2d/%2d ", stdnt.yy, stdnt.mm, stdnt.dd );
    System.out.printf("adress: %s b%3d f%3d%n", stdnt.Street, stdnt.House, stdnt.Appartament );
 	 }
 	 

   
public static void main(String[] args){

    ArrayList<Student>   journal = new ArrayList<>();
    
    
    Scanner in = new Scanner(System.in);
    
  while(false==false) {  
        
         System.out.print("n - New record; l - list journal; r-load; q - quit  What is your choise? ");  
           switch (in.nextLine()){
           	case("n"):
           	Student tmp_stnt = new Student(false);
                journal.add(tmp_stnt); 
           	break;
           	case("l"):
	 	Iterator<Student> iter = journal.iterator();
           	 while (iter.hasNext()) PrintJournal(iter.next());
           	break;
           	
           	case ("r"):
           	 System.out.print("Input file name:");
           	  File jcsv = new File(in.nextLine());
           	  if(jcsv.exists()) {
		            System.out.println("File exists");
			    try (FileReader jcsv_reader = new FileReader(jcsv)){
			    Scanner jcsv_scanner = new Scanner (jcsv_reader);
			    while(jcsv_scanner.hasNextLine()){
			    Student tst = new Student(true);
			    String[] tokens = jcsv_scanner.nextLine().split(";");
			    tst.LastName=tokens[0];
			    tst.FirstName=tokens[1];
			    tst.Phone=Integer.parseInt(tokens[2]);
	  		    tst.yy=Integer.parseInt(tokens[3]);
			    tst.mm=Integer.parseInt(tokens[4]);
			    tst.dd=Integer.parseInt(tokens[5]);
    			    tst.Street=tokens[6];
			    tst.House=Integer.parseInt(tokens[7]);
			    tst.Appartament=Integer.parseInt(tokens[8]);			    
			    }}
			    catch (IOException ex){
			       System.out.println(ex.getMessage());
			    }
		            }
			        else
			            System.out.println("File not found");

           	  
	
           	break;
           	case("q"):
           	return;
                      	
           
           }
           
           
           
           }
}

}
