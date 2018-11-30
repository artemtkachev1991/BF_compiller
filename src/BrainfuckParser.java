public class BrainfuckParser {
    int pos = 0;
    String code;

    public BrainfuckParser(String code) {
        this.code = code;
    }

    public boolean check() {
        while (pos < code.length()) {
        	if (!parseSymbol()) {
        		return false;
        	}
        }
        return true;
    }
    
    private boolean parseSymbol() {
        if(code.charAt(pos) == '[') {
            return parseLoop();
        } else if (code.charAt(pos) ==']') {
        	return false;
        } else {
            pos++;
            return true;
        }
    }

    private boolean parseLoop() {
        if(code.charAt(pos) != '[') {
            throw new RuntimeException();
        }
        try {
			while (code.charAt(pos) != ']') {
			    pos++;
			    if (code.charAt(pos) == '[') {
			        parseLoop();
			    }
			}
			pos++;
			return true;
		} catch (StringIndexOutOfBoundsException e) {
			return false;
		}
    }
}