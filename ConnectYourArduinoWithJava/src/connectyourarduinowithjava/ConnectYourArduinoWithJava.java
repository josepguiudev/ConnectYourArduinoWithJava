/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connectyourarduinowithjava;

import connectyourarduinowithjava.ArduinoConnection.ArduinoConnection;

/**
 * In this project we are going to make a connection between java and arduino. 
 * The intention is that java communicates to arduino and arduino responds to it.
 * by:
 * 
 * @author josep
 */
public class ConnectYourArduinoWithJava {

    /**
     * In the main method we are going to initialize a function to create the 
     * communication
     */
    public static void main(String[] args) {
        //This is the function to initialize
        //If it does not connect within two seconds it will give an error
        ArduinoConnection.conexionArduino();
    }
    
}
