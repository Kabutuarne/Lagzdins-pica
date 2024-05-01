package Pizzeria;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.io.*;
import java.util.ArrayList;

public class FileFunctions {
    public static void serializeOrders(ArrayList<PizzaOrderS> orders, String path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/data/"+path+".ser"))) {
            objectOutputStream.writeObject(orders);
        } catch (IOException e) {
            System.out.println( e.getMessage());
        }
    }

    public static ArrayList<PizzaOrderS> returnOrders(String path) {
        ArrayList<PizzaOrderS> orders = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/data/"+path+".ser"))) {
            Object obj = in.readObject();
            if (obj instanceof ArrayList) {
                orders = (ArrayList<PizzaOrderS>) obj;
            } else {
                
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return orders;
    }
}

