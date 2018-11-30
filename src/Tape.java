public class Tape {
    TapeElement current;
    BrainfuckRunner runner;

    public Tape(BrainfuckRunner runner) {
        current = new TapeElement(0, null, null);
        this.runner = runner;
    }

    public int get() {
        return current.val;
    }

    public void set(int val) {
        current.val = val;
    	printTape();
    }

    public void plus() {
        current.val++;
    	printTape();
    }

    public void minus() {
        current.val--;
    	printTape();
    }

    public void fwd() {
        if(current.next == null) {
            current.next = new TapeElement(0, current, null);
        }
        current = current.next;
    	printTape();
    }

    public void bkw() {
        if(current.prev == null) {
            current.prev = new TapeElement(0, null, current);
        }
        current = current.prev;
    	printTape();
    }
    
    private void printTape() {
    	if (runner.debugging) {
			TapeElement toPrint = current;
			while (toPrint.prev != null) {
				toPrint = toPrint.prev;
			}
			while (toPrint != current) {
				System.out.print(toPrint.val + " ");
				toPrint = toPrint.next;
			}
			System.out.print("{" + toPrint.val + "}");
			toPrint = toPrint.next;
			while (toPrint != null) {
				System.out.print(toPrint.val + " ");
				toPrint = toPrint.next;
			}
			System.out.print("\n");
		}
    }

    private class TapeElement {
        int val;
        TapeElement prev, next;

        TapeElement(int val, TapeElement prev, TapeElement next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}