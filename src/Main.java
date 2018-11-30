import java.io.*;

public class Main {
    
    public static void main(String[] args) {
    	System.out.println("enable debugging? ( Y | N ) and push enter");
    	boolean debugging = false;
    	if(StdIn.readString().toLowerCase().equals("y")) {
    		debugging = true;
    	}
    	String code = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.+++.";
    	System.out.println("Now running the following Brainfuck program:\n\n" + code);
        new BrainfuckRunner(code, debugging).run();
    }

    static String getFileContent(String path) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF8"))) {
            StringBuilder result = new StringBuilder();
			int lineNumber = 0;
			String line;
			while ((line = br.readLine()) != null) {
				lineNumber++;
				result.append(line);
			}
			return result.toString();
		} catch (IOException e) {
			e.printStackTrace();;
		}
        return "";
    }
}
