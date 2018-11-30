public class BrainfuckRunner {
    Tape tape;
    String code;
    int pos;
    public final boolean debugging;

    public BrainfuckRunner(String code, boolean debugging) {
        if(!(new BrainfuckParser(code).check())) {
        	throw new RuntimeException();
        }
        this.code = code;
        this.tape = new Tape(this);
        this.debugging = debugging;
        System.out.println("BF runner initialized");
    }

    public void run() {
        System.out.println("BF runner starting\n\n");
    	while (pos < code.length()) {
    		execNext();
    	}
    }
    
	private void execNext() {
		switch (code.charAt(pos)) {
			case '+':
				if (debugging) {
		        	System.out.println("BF runner +");
				}
				tape.plus();
				pos++;
				break;
			case '-':
				if (debugging) {
		        	System.out.println("BF runner -");
				}
				tape.minus();
				pos++;
				break;
			case '<':
				if (debugging) {
		        	System.out.println("BF runner <");
				}
				tape.bkw();
				pos++;
				break;
			case '>':
				if (debugging) {
		        	System.out.println("BF runner >");
				}
				tape.fwd();
				pos++;
				break;
			case '.':
				if (debugging) {
		        	System.out.println("BF runner .");
				}
				print(tape.get());
				pos++;
				break;
			case ',':
				if (debugging) {
		        	System.out.println("BF runner ,");
				}
				read();
				pos++;
				break;
			case '[':
				pos++;
				if (debugging) {
		        	System.out.println("BF runner [");
				}
				loop(pos);
				break;
		}
	}

    private void loop(int startPos) {
		while (code.charAt(pos) != ']') {
			execNext();
		}
		if (tape.get() != 0) {
			pos = startPos-1;
		} else {
			pos++;
		}
	}

	void print(int symbol) {
        System.out.print((char) symbol);
    }

    private void read() {
        tape.set((int) StdIn.readChar());
    }
}