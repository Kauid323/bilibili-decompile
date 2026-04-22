package java2jni_do_not_delete_this;

public class java2jni_do_not_delete_this_library_APSE_1J {
    private static boolean library_loaded = false;

    public static void main(String[] args) {
    }

    public static void loadLibrary() {
        if (library_loaded) {
            return;
        }
        try {
            System.out.println("java2jni java.library.path is: " + System.getProperty("java.library.path"));
            System.loadLibrary("APSE_J");
            library_loaded = true;
        } catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {
            localUnsatisfiedLinkError.printStackTrace();
        }
    }
}