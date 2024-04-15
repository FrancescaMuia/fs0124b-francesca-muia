import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        Scanner a= new Scanner(System.in);
        Scanner b= new Scanner(System.in);
        int risultato2= moltiplica(a.nextInt(),b.nextInt());
        System.out.println("il risultato della moltiplicazione è " + risultato2);
        int risultato= moltiplica(2,4);
        System.out.println("il risultato della moltiplicazione è " + risultato);

        Scanner a2 = new Scanner(System.in);
        while(true) {
            String input=a2.nextLine();
            if(input.equals("q")) {
                break;
            }
            int n2= a2.nextInt();
            int n1=Integer.parseInt(input);
            int risultato3 = moltiplica(n1, n2);
            System.out.println("il risultato della moltiplicazione è " + risultato3);
        }
    }

    public static int moltiplica(int num1, int num2){
        return num1*num2;
    }



}