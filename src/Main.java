import handler.SellerRequestHandler;

import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("If you are seller, press 1 else press 2");

        String input = scanner.next();
        if(input.equals("1")) {
            System.out.println("You have selected seller");
            System.out.println("What do you want to do?");
            System.out.println("Press 1 for creating a deal");
            System.out.println("Press 2 for ending a deal");
            System.out.println("Press 3 for updating a deal");
        }
    }
}