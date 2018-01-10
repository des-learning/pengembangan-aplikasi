/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengenalan;

import java.util.Scanner;

/**
 *
 * @author david
 */
public class HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Input name: ");
        
        Scanner input = new Scanner(System.in);        
        String name = input.nextLine();        
        if (name.equals(""))
            name = "world";
        
        System.out.println(String.format("Hello %s", name));             
    }
    
}
