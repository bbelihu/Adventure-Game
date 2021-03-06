package com.company.Betab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();
    private static Map<String, String> vocabulary = new HashMap<> ();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);



        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");
        vocabulary.put("QUIT", "Q");

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            //Show the available exits.
            System.out.print("Available exits are: ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();
            System.out.print("Enter direction based on available exits: ");
            String direction = input.nextLine().toUpperCase();
            if(direction.length() >1) {
                String[] words = direction.split(" ");
                for(String word: words){
                   if(vocabulary.containsKey(word)){
                       direction=vocabulary.get(word);
                       break;
                   }
                }

            }
            if(exits.containsKey(direction)){
                loc= exits.get(direction);
            }
            else{
                System.out.println("Invalid direction you can't go there");
            }
//        }

        }
    }
}


