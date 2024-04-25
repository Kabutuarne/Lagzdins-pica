package Pizzeria;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileFunctions {
	public static void serializeObject(Object object, String path) { //path - filename
        try {
        	
            FileOutputStream fileOut = new FileOutputStream("src/data/"+path+".ser", true);
            
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut) {
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            };
            objectOut.writeObject(object);
            
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public static ArrayList<PizzaOrderS> returnObjects(String path) {
        ArrayList<PizzaOrderS> orders = new ArrayList<>();
        
        try {
            FileInputStream fileIn = new FileInputStream("Data/"+path+".ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            while (true) {
                try {
                    orders.add((PizzaOrderS) objectIn.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
            
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return orders;
    }
	
}
