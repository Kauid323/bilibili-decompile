package blink_stub.sun.misc;

import java.lang.reflect.Field;

public class Unsafe {
    public native int addressSize();

    public native byte getByte(long j);

    public native int getInt(long j);

    public native int getInt(Object obj, long j);

    public native long getLong(long j);

    public native long getLong(Object obj, long j);

    public native Object getObject(Object obj, long j);

    public native short getShort(Object obj, long j);

    public native void putByte(long j, byte b);

    public native void putInt(Object obj, long j, int i);

    public native void putLong(Object obj, long j, long j2);

    public native void putObject(Object obj, long j, Object obj2);

    public int arrayBaseOffset(Class clazz) {
        throw new RuntimeException("Stub!");
    }

    public long objectFieldOffset(Field field) {
        throw new RuntimeException("Stub!");
    }
}