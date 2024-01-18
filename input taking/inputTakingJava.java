import java.util.Scanner;

public class inputTakingJava {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Enter your age:");
//        int age = scanner.nextInt();
//        System.out.println("Enter your first and last name:");
//        String firstName = scanner.next();
//        String lastName = scanner.next();
//
//        System.out.println(firstName + " "+ lastName + "is of age " + age);

        System.out.println("Enter list size:");
        int listSize = scanner.nextInt();
        int[] arr = new int[listSize];
        int count = 0;

        System.out.println("Enter the list number separated by space");
        while (listSize > count){
            arr[count] = scanner.nextInt();
            count++;
        }

        for(int i=0; i<arr.length; i++){
            if (i == arr.length-1){
                System.out.print(arr[i]+ " and done");
            }
            else {
                System.out.print(arr[i] + ", ");
            }
        }
    }
}