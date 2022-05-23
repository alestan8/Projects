package business;

import java.io.*;
import java.util.ArrayList;

public class DeSerialization {
	
	static String filename = "serialization.ser";
	
	public static void serialization() {
		try
        {   ArrayList<Order> comenzi = main.Controller.getComenzi();
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
              
            // Method for serialization of object
            out.writeObject(comenzi);
              
            out.close();
            file.close();
              
            System.out.println("Object has been serialized");
  
        }
          
        catch(IOException ex)
        {
            System.out.println("aici e problemaa");
        }
	}
	
	public static void deserialization() {
		try
        {   ArrayList<Order> comenzi = new ArrayList<Order>();
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
             
            // Method for deserialization of object
            comenzi = (ArrayList<Order>)in.readObject();
              
            in.close();
            file.close();
            main.Controller.setComenzi(comenzi);  
            System.out.println("Object has been deserialized ");
            comenzi.forEach(i -> {System.out.println(i);});
        }
          
        catch(IOException ex)
        {
            System.out.println("aici");
        }
          
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
  
	}
}
