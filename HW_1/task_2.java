package HW_1;


public class task_2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 1001; i++) {
            
            boolean isPrime = true;  
            for (int j = 2; j <= Math.floor(Math.sqrt(i)); j++){
                
                if ((i % j) == 0) { 
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                System.out.print(i + " "); //если делителей нет, флаг = True, число на печать
            }
        }
    }
}
