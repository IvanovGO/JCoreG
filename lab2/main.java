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
//import org.json.*;

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
	 String Phone;
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
         Phone=in.nextLine();
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
 	    
  public boolean equals(Student st){
       if(
       this.LastName==st.LastName &
       this.FirstName==st.FirstName &
       this.Phone==st.Phone &
       this.yy==st.yy &
       this.mm==st.mm &
       this.dd==st.dd &
       this.Street==st.Street &
       this.House==st.House &
       this.Appartament==st.Appartament 
       ) return true; else return false;
  }
	
/*	 public JSONObject JSON_export(){
	
	}*/
	 	      }  //Student
	 	      
	static  void PrintJournal(Student stdnt){
    System.out.printf("surname:%15s ", stdnt.LastName );
    System.out.printf("name:%15s ", stdnt.FirstName );
    System.out.printf("phone number:%10s ", stdnt.Phone );
    System.out.printf("date of birth: %4d/%2d/%2d ", stdnt.yy, stdnt.mm, stdnt.dd );
    System.out.printf("adress: %s,%3d,%3d%n", stdnt.Street, stdnt.House, stdnt.Appartament );
 	 }
 	 
 	 

   
public static void main(String[] args){

    ArrayList<Student>   journal = new ArrayList<>();
    
    
    Scanner in = new Scanner(System.in);
    
  while(false==false) {  
        
         System.out.print("n - New record; l - list journal; r-load; r - test eq; c - clear; q - quit  What is your choise? ");  
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
           	  Integer readcount = 0;
           	  if(jcsv.exists()) {
		            System.out.println("File exists");
			    try (FileReader jcsv_reader = new FileReader(jcsv)){
			    Scanner jcsv_scanner = new Scanner (jcsv_reader);
			    while(jcsv_scanner.hasNextLine()){
			    readcount++;
			    Student tst = new Student(true);
			    String[] tokens = jcsv_scanner.nextLine().split(";");
			    tst.FirstName=tokens[0];
			    tst.LastName=tokens[1];
			    tst.Phone=tokens[2];
	  		    tst.yy=Integer.parseInt(tokens[3]);
			    tst.mm=Integer.parseInt(tokens[4]);
			    tst.dd=Integer.parseInt(tokens[5]);
    			    tst.Street=tokens[6];
			    tst.House=Integer.parseInt(tokens[7]);
			    tst.Appartament=Integer.parseInt(tokens[8]);			    
			    journal.add(tst); 
			    }  System.out.printf("%d records readed %n",readcount);
			      }
			    catch (IOException ex){
			       System.out.println(ex.getMessage());
			    }
		            }
			        else
			            System.out.println("File not found");


	
           	break;
           	case ("e"):
           	for (Student st:journal ){
           	System.out.printf("%s %b %n",st.FirstName,st.equals(st));
           	}
           	break;
           	case("c"):
		    System.out.print("Are you shure?(type - 1 if ya)");
		 
		 if (in.nextInt()==1)   	 journal.clear();
           	break;
           	case("q"):
           	return;
                      	
           
           }
           
           
           
           }
}

}
