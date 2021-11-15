/*
Генератор  сущностей "Запись в журнале куратора".
-фамилия студента
-имя студента
-дата рождения студента
-телефон студента
-домашний адрес (улица, дом, квартира)
*/


import java.util.*;
import java.io.*;
import java.time.YearMonth;

class GenEntities {

static class GenStudent{
     
     ArrayList<String> NamesList= new ArrayList<>();
     
 GenStudent(String fname){
  Integer readcount = 0;
   File names = new File(fname);
           	  if(names.exists()) {
		           // System.out.println("Names file exists");
			    try (FileReader names_reader = new FileReader(names)){
			    Scanner names_scanner = new Scanner (names_reader);
			    while(names_scanner.hasNextLine()){
			    readcount++;
			    NamesList.add(names_scanner.nextLine());
			    } // System.out.printf("%d names readed %n",readcount);
			      }
			    catch (IOException ex){
			       System.out.println(ex.getMessage());
			    }
		            }
			        else
			            System.out.println("File not found");
 }
 
 String getRandom(){
 Random random = new Random();
 return NamesList.get(random.nextInt(NamesList.size()));}
 
/*неполиткорректный гендер))*/
  boolean isMale(String n){
 switch (n.charAt(n.length()-1)){
 case 'а':
 case 'я':
 return false;
  }  return true;
 }
 
   
  String makeSecName(String s){
  String sn = this.getRandom();
  while (!this.isMale(sn)) {sn=this.getRandom();}
    if (this.isMale(s))     return sn+"ов";
      else  return sn + "ова";
  }

  boolean isLeap(int yy){
  boolean b=false;
    if (yy%4==0) b=true;
    if (yy%400==0) {b=true;} 
    	else if (yy%100==0) {b=false;}
    return b;
  }
  
  
  String genBrthDate(){
  Random rnd = new Random();
  Integer yy=YearMonth.now().getYear()-16-rnd.nextInt(5);//regular student
  if (rnd.nextInt(10)==5) yy=YearMonth.now().getYear()-rnd.nextInt(65-16)+16;//mature student
  String s=Integer.toString(yy);//yy
  Integer mm = rnd.nextInt(12);
    s+=";"+Integer.toString(mm);//mm
    Integer md;
    switch (mm) {
    case 2: //february
    if (this.isLeap(yy)) {md=29;} else {md=28;} break;
    case (4):case (6):case (9):case (10):case (11): md=30;
    
    break;
    default: md=31;    }
    s+=";"+rnd.nextInt(md);//dd
  return s;
  }
  
  String genPhone(){
    Random rnd = new Random();
        switch (rnd.nextInt(3)){
        case 0:
        return "066"+Integer.toString(rnd.nextInt(8999999)+1000000);
        case 1:
        return "050"+Integer.toString(rnd.nextInt(8999999)+1000000);
        case 2:
        return "097"+Integer.toString(rnd.nextInt(8999999)+1000000);
        } return""; }
   
   String genAdress(){
    Random rnd = new Random();
    Integer house = rnd.nextInt(200)+1;
    Integer appartament = rnd.nextInt(100)+1;
    String s=this.getRandom();
    while (this.isMale(s)) s=this.getRandom();
    s="ул."+makeSecName(s)+";"+Integer.toString(house)+";"+Integer.toString(appartament);
    return s;
   }
}


public static void main (String[] param){

if (param.length==0) {
System.out.println("1st param - file with CR separated names, 2nd param - count students to geneate");
return;}
  GenStudent names = new GenStudent(param[0]);

  Random rnd = new Random();

//for (int yy=1150;yy<2150;yy++) System.out.printf("%d id %b %n",yy,names.isLeap(yy));

for (int i=0;i<Integer.parseInt(param[1]);i++){
    String s = new String(names.getRandom());
    System.out.printf("%s;%s;%s;%s;%s%n",
    s,//name
    names.makeSecName(s),//surename
    names.genPhone(),
    names.genBrthDate(),
  
    names.genAdress()
    ); 
    }
}
}
