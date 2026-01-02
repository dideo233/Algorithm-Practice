package das.structure.implementations.stack;

public class StackEx {
    public static void main (String[] args) {
        BracketValidator bv = new BracketValidator();
        System.out.println(bv.isValid("(())"));  // true
        System.out.println(bv.isValid("(()"));   // false
        System.out.println(bv.isValid("())"));   // false
    }
}
