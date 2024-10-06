package day1Workshop;


import java.util.Scanner;
import java.util.ArrayList;

public class ShoppingCart {
    
    public static void main (String[] args){
        
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean open = true;

        System.out.println("Welcome to your Shopping Cart");

         while(open){ 

            try{ 
                System.out.print(">");
                String input = scanner.nextLine();

                //Convert string input to lower case
                String inputString = input.trim().toLowerCase();

                if(inputString.contains("add")){
                //Because it will be like add apple,pear,coconut etc
                //                        01234
                //Substring to start reading from index 4 onwards and split them
                String[] addFruits = inputString.substring(4).split(",");
                    for(String fruits: addFruits){
                        if(!list.contains(fruits)){
                            list.add(fruits);
                            System.out.println(fruits + " added to cart");
                        } else {
                        System.out.println("You have already added " + fruits);
                        }   
                    }
                } else if(inputString.contains("list")){
                    if(!list.isEmpty()){
                        for(int i =0; i<list.size(); i++){
                            System.out.println((i+1)+ ". " + list.get(i));
                        }
                     } else {
                            System.out.println("Your cart is Empty"); 
                    }

                } else if (inputString.contains("delete")){ 
                    try {
                        int removeNumber = Integer.valueOf(inputString.substring(7));
                        System.out.println(list.get(removeNumber-1) + " has been removed from the cart");
                        list.remove(removeNumber-1);
                        
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Incorrect item index, enter a valid item index (Example delete 2)");
                    }

                }  else {
                    System.out.println("Exiting the program");
                    open=false;
                }

            } catch (Exception e){
                System.out.println("Please enter your product (Example add apple,pear)");

            }

        }

        scanner.close();

    }


}

