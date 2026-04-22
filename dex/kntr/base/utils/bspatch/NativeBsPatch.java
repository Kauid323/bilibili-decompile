package kntr.base.utils.bspatch;

public class NativeBsPatch {
    public static native int patch(String str, String str2, String str3);

    static {
        System.loadLibrary("bspatch");
    }
}