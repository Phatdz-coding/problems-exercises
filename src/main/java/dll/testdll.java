package dll;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class testdll {
    /**
     * Interface to represent your DLL. 
     * JNA will dynamically map the methods in this interface to the exported functions in the DLL.
     */
    public interface ExtraMathLibrary extends Library {
        // "extra_maht_function" is the name of the DLL file (without the .dll extension).
        // JNA will look for extra_maht_function.dll in the project root or system PATH.
        ExtraMathLibrary INSTANCE = (ExtraMathLibrary) Native.loadLibrary("src/main/java/dll/extra_maht_function", ExtraMathLibrary.class);

        // Example method signatures. 
        // You MUST match the name and argument types exactly as they are exported in the C/C++ DLL.
        int add(int a, int b);
        int subtract(int a, int b);
    }

    public static void main(String[] args) {
        try {
            System.out.println("Calling DLL functions...");
            
            int sum = ExtraMathLibrary.INSTANCE.add(20, 22);
            System.out.println("Result of add(20, 22): " + sum);
            
            int diff = ExtraMathLibrary.INSTANCE.subtract(50, 8);
            System.out.println("Result of subtract(50, 8): " + diff);
            
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Error: Could not load the DLL.");
            System.err.println("Message: " + e.getMessage());
            System.err.println("\nTroubleshooting:");
            System.err.println("1. Ensure 'extra_maht_function.dll' is in the root directory: /home/phatlinux/Desktop/Java-Project/");
            System.err.println("2. On Linux, DLLs are .so files. If this is a Windows DLL, it will only work on Windows.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
