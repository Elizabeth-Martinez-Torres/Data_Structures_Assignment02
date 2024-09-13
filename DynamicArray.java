
public class DynamicArray {

    private static final int DEFAULT_SIZE = 4;
    private String[] foundation;
    public static void main(String[] args) {
        final String PASS = "Pass";
        final String FAIL = "Fail";
        final String NON_EXISTING = "COBOL";
        String[] testData = {"Java", "Python", "C", "C++", "Fortran"};
        DynamicArray test = new DynamicArray(testData);
        DynamicArray tset = new DynamicArray(null);
        String testContainsNullTarget = (!test.contains(null)) ? PASS : FAIL;
        String testContainsEmptyData =  (!tset.contains("Java")) ? PASS : FAIL;
        String testContainsExisting = (test.contains(testData[1])) ? PASS : FAIL;
        String testContainsNonExisting = (!test.contains(NON_EXISTING)) ? PASS : FAIL;
        String testGetNegative = (test.get(-1) == null) ? PASS : FAIL;
        String testGet = (test.get(0).equals(testData[0])) ? PASS : FAIL;
        String testGetOutOfBounds = (test.get(testData.length+1)==null) ? PASS : FAIL;
        System.out.printf("\nTest for contains(null): ............... %s", testContainsNullTarget);
        System.out.printf("\nTest for contains on null foundation: .. %s", testContainsEmptyData);
        System.out.printf("\nTest for contains (existing): .......... %s", testContainsExisting);
        System.out.printf("\nTest for contains (non existing): ...... %s", testContainsNonExisting);
        System.out.printf("\nTest for get(-1): ...................... %s", testGetNegative);
        System.out.printf("\nTest for get(0): ....................... %s", testGet);
        System.out.printf("\nTest for get(out of bounds): ........... %s\n\n", testGetOutOfBounds);
    }

    public DynamicArray(int size) {
        size = (size > 0) ? size : DEFAULT_SIZE;
        this.foundation = new String[size];
    }

    public DynamicArray(String[] data) {
        this.foundation = data;
    }

    public DynamicArray() {
        this(DEFAULT_SIZE);
    }
    public boolean contains(String target) {
        if (foundation == null) {
            return false;
        }  //if loop to prevent a NullPointerException
        for (String element : foundation) {
            if (element != null && element.equals(target)) {
                return true;
            } //for loop to iterate over the elements that weren't null
        }
        return false;
    }

    public String get(int index) {
        if (index < 0 || index >= foundation.length) { //in case of no valid values
            return null;
        }
        return foundation[index];
    }
} // class DynamicArray