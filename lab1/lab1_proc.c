/*Вариант 7. Задание: Среди простых чисел не более n найти котoрое в двоичной форме содержит максимум нулей.
Выполнил студент гр. КМ-19 (Прикладная математика) ДВНЗ "ПГТУ" Иванов Григорий  mailto: ivanov_g_o@pstu.edu
реализация на языке Си
*/

#include <stdbool.h>
#include <stdio.h>



      bool isSimple(int num){
       for (int i=num-1;i>1;i-- )
         if (num%i==0) return false;
      return true;
      }

       int ZeroCount(int i){
	int rez=0;
          while (i>0){
         	int d=i%2;
         	i/=2;
                  if (d==0) rez+=1;
         	}
       return rez;
       }
       

    
int main(int argc,char * argv[]) 
        {
    if (argc==0) { 
   printf("Incorrect input of N\n");
     return -1;  }
        
        int nrez=1;
        int zrez=0;
        
       for (int i=2;i<atoi(argv[1]);i++) 
       if (isSimple(i)) { printf("%d \n",i);
       if (ZeroCount(i)>zrez) { printf("Catch!\n");
       				nrez=i;
       				zrez=ZeroCount(nrez);
       				}
       }
       printf("Search complete. %i zeros found in simple number - %i \n",zrez,nrez);
        }
 /*
 Search complete. 17 zeros found in simple number - 524353 

real	29m25,492s
user	29m16,798s
sys	0m1,439s

*/
 
