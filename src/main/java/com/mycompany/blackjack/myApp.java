
package com.mycompany.blackjack;
import java.util.Scanner;

public class myApp {
    public static void main(String[] args) {
        boolean playing=true;
        int chips = 1000;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Blackjack!!");
        while (playing==true)
        {
        int min=1;
        int max=13;
        int i, bet = 0;
        int userTotal=0, compTotal=0;
        int userCard[]=new int[8];
        int compCard[]=new int[8];
        boolean betting = true;
        
        while (betting) {
            System.out.println("You have " + chips + " chips");
            System.out.println("Enter an amount to bet: ");
            bet = scanner.nextInt();
            if ((bet > 0) && (bet <= chips)) {
                betting = false;
            }
            else {
                System.out.println("PLEASE ENTER A VALID BET");
            }
        }
        
        for (i=0; i<2; i++) {
            userCard[i] = (int)(Math.random() * (max - min + 1) + min);
            if (userCard[i] > 10) {userCard[i] = 10;}
            if (userCard[i] == 1) {userCard[i] = 11;}
            compCard[i] = (int)(Math.random() * (max - min + 1) + min);
            if (compCard[i] > 10) {compCard[i] = 10;}
            if (userCard[i] == 1) {userCard[i] = 11;}
        }
        userTotal = userCard[0]+userCard[1];
        compTotal = compCard[0]+compCard[1];
        
        System.out.println("");
        System.out.println("Your cards are " + userCard[0] + " and " + userCard[1] + "  (" + userTotal + ")");
        System.out.println("Host cards are " + compCard[0] + " and hidden");
        
        boolean game=true;
        while(game==true) {
            System.out.println("Would you like to hit or stand?");
            System.out.println("Enter 'H' or 'S': ");
            String choice = scanner.next();
        
            int j=2;
            switch (choice) {
                case "H":
                    userCard[i] = (int)(Math.random() * (max - min + 1) + min);
                    if (userCard[i] > 10) {userCard[i] = 10;}
                    userTotal += userCard[i];
                    System.out.println("Your cards total " + userTotal);
                    if (userTotal > 21) {
                        System.out.println("YOU LOSE: you bust  (" + userTotal + ")");
                        chips -= bet;
                        game=false;
                    }
                    break;
            
                case "S":
                    while ((compTotal<userTotal) && (compTotal < 22)) {
                        compCard[j] = (int)(Math.random() * (max - min + 1) + min);
                        if (compCard[i] > 10) {compCard[i] = 10;}
                        compTotal += compCard[i];
                    }
                    if (compTotal > 21) {
                        System.out.println("YOU WIN: host bust  (" + compTotal + ")");
                        chips += bet;
                    }
                    else if (compTotal>userTotal) {
                        System.out.println("YOU LOSE: host wins with " + compTotal);
                        chips -= bet;
                    }
                    else if (compTotal==userTotal) {
                        System.out.println("TIE: you have " + userTotal + " and host has " + compTotal);
                        System.out.println("Your bet is returned to you");
                    }
                    game=false;
                    break;
            }
        }
        System.out.println("");
        System.out.println("Would you like to play again? ('Y' or 'N')");
        String again = scanner.next();  
        switch (again) {
            case "Y": 
                break;
            case "N":
                System.out.println("Thanks For Playing!");
                playing=false;
                break;
        }
            
        }
        
    }
}
