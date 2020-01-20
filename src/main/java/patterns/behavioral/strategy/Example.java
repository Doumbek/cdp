package patterns.behavioral.strategy;

import java.util.Scanner;

public class Example {

    public static void main(String[] args) {

        final Washer washer = new Washer();

        final Scanner scanner = new Scanner(System.in);
        System.out.println("Select washer program:");
        System.out.println("1 - wash silk");
        System.out.println("2 - wash cotton");

        final Integer programIndex = scanner.nextInt();

        washer.setCurrentProgram(programIndex);
        washer.wash();

    }

}
