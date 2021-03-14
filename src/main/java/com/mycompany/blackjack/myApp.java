
package com.mycompany.blackjack;
import java.util.Scanner;

public class myApp {
    public static void main(String[] args) {
        int min=1;
        int max=10;
        int i;
        int userTotal=0, compTotal=0;
        
        System.out.println("Welcome to Blackjack!!");
        
        int userCard[]=new int[8];
        int compCard[]=new int[8];
        
        for (i=0; i<2; i++) {
            userCard[i] = (int)(Math.random() * (max - min + 1) + min);
            compCard[i] = (int)(Math.random() * (max - min + 1) + min);
        }
        userTotal = userCard[0]+userCard[1];
        compTotal = compCard[0]+compCard[1];
        
        Scanner sin = new Scanner(System.in);
        System.out.println("Your cards are " + userCard[0] + " and " + userCard[1] + "  (" + userTotal + ")");
        System.out.println("Host cards are " + compCard[0] + " and hidden");
        
        boolean game=true;
        while(game==true) {
            
        System.out.println("Would you like to hit or stand?");
        System.out.println("Enter 'H' or 'S'");
        String choice = sin.nextLine();
        
        int j=2;
        switch (choice) {
            case "H":
                userCard[i] = (int)(Math.random() * (max - min + 1) + min);
                userTotal += userCard[i];
                System.out.println("Your cards total " + userTotal);
                if (userTotal > 21) {
                    System.out.println("YOU LOSE: you bust  (" + userTotal + ")");
                    game=false;
                }
                break;
            
            case "S":
                while ((compTotal<userTotal) && (compTotal < 22)) {
                    compCard[j] = (int)(Math.random() * (max - min + 1) + min);
                    compTotal += compCard[i];
                }
                if (compTotal > 21) {
                    System.out.println("YOU WIN: host bust  (" + compTotal + ")");
                }
                else if (compTotal>userTotal) {
                    System.out.println("YOU LOSE: host wins with " + compTotal);
                }
                game=false;
                break;
            
        }
            
        }
        
        
        
    }
}
