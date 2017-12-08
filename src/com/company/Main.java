package com.company;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import static sun.management.jmxremote.ConnectorBootstrap.DefaultValues.PORT;
import static sun.management.jmxremote.ConnectorBootstrap.PropertyNames.HOST;

public class Main {
        public static final String HOST = "192.168.0.62";
        public static final int PORT = 7000;

    public static void main(String[] args) {

        try {
            Socket kanalas = new Socket(HOST, PORT);
            boolean testi = true;
            ObjectOutputStream isvedimas = new ObjectOutputStream(kanalas.getOutputStream());
            ObjectInputStream ivedimas = new ObjectInputStream(kanalas.getInputStream());
            Scanner skaitytuvas = new Scanner(System.in);
            while (testi){
                if (ivedimas.available()>0){
                    System.out.println(ivedimas.readUTF());
                }
                String tekstas = skaitytuvas.nextLine();
                if(!tekstas.isEmpty()) {
                    isvedimas.writeUTF(tekstas);
                    isvedimas.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // write your code here
    }
}
