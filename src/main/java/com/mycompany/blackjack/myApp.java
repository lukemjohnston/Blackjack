
package com.mycompany.blackjack;

public class myApp {
    public static void main(String[] args) {
        int min=1;
        int max=10;
        
        System.out.println("Welcome to Blackjack!!");
        
        int userCards[]=new int[8];
        int compCards[]=new int[8];
        
        for (int i=0; i<2; i++) {
            userCards[i] = (int)(Math.random() * (max - min + 1) + min);
            compCards[i] = (int)(Math.random() * (max - min + 1) + min);
        }
        
        System.out.println("Your cards are " + userCards[0] + " and " + userCards[1]);
        System.out.println("Host cards are " + compCards[0] + " and hidden");
        
    }
}
