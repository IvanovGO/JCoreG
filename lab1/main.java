/*Вариант 7. Задание: Среди простых чисел не более n найти котoрое в двоичной форме содержит максимум нулей.
Выполнил студент гр. КМ-19 (Прикладная математика) ДВНЗ "ПГТУ" Иванов Григорий  mailto: ivanov_g_o@pstu.edu
*/



class NullCount {

       static boolean isSimple(int num){
       for (int i=num-1;i>1;i-- )
         if (num%i==0) return false;
      return true;
      }

       static int ZeroCount(int i){
	int rez=0;
          while (i>0){
         	int d=i%2;
         	i/=2;
                  if (d==0) rez+=1;
         	}
       return rez;
       }
       
       static  String toBool(int i){
          String s="";
         while (i>0){
         	int d=i%2;
         	i/=2;
                  if (d==0) s+="0"; else s+="1";
         	}	
         	return s;}
    
    public static void main(String[] args) 
        {
    if (args.length==0) { 
    System.out.println("Incorrect input of N");
    return;
        } 
        
        int nrez=1;
        int zrez=0;
        
       for (int i=2;i<Integer.parseInt(args[0]);i++) 
       if (isSimple(i)) { System.out.println(i);
       if (ZeroCount(i)>zrez) { System.out.println("Catch!");
       				nrez=i;
       				zrez=ZeroCount(nrez);
       				}
       }
        System.out.printf("Search complete. %d zeros found in simple number - %d %n",zrez,nrez);
        }}
 
