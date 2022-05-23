package business;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
	
	static FileWriter fw;
	
	public FileWrite(String f) {
		try {
			fw= new FileWriter(f, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void scriere(String s) {
		try {
			fw.write(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void inchidere() {
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
