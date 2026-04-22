package blink_stub.dalvik.system;

public class VMRuntime {
    public native void setHiddenApiExemptions(String[] strArr);

    public static VMRuntime getRuntime() {
        throw new IllegalArgumentException("stub");
    }
}