import java.io.*;
public class CreateFile {
	public static void main(String []args) {
		String dir = "MyDir";
		String file = dir+"/"+ "MyFile.txt";
		
		File d = new File(dir);
		File f = new File(file);
		
		if(d.mkdir() == true) {
			try {
				f.createNewFile();
			}
			catch(Exception e) {
				System.out.println("File not Created!!");
			}
			finally {
				System.out.println(f.getAbsolutePath());
			}
		} else {
			System.out.println("Directory not created!!");
		}
	}
}