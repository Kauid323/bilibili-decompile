package j$.sun.misc;

import j$.com.android.tools.r8.DesugarVarHandle$$ExternalSyntheticBackportWithForwarding0;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import sun.misc.Unsafe;

public final class DesugarUnsafe {
    private static final DesugarUnsafe theUnsafeWrapper;
    private final Unsafe theUnsafe;

    static {
        Field field = getUnsafeField();
        field.setAccessible(true);
        try {
            theUnsafeWrapper = new DesugarUnsafe((Unsafe) field.get(null));
        } catch (IllegalAccessException e) {
            throw new AssertionError("Couldn't get the Unsafe", e);
        }
    }

    DesugarUnsafe(Unsafe theUnsafe) {
        this.theUnsafe = theUnsafe;
    }

    private static Field getUnsafeField() {
        Field[] declaredFields;
        try {
            return Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e) {
            for (Field f : Unsafe.class.getDeclaredFields()) {
                if (Modifier.isStatic(f.getModifiers()) && Unsafe.class.isAssignableFrom(f.getType())) {
                    return f;
                }
            }
            throw new AssertionError("Couldn't find the Unsafe", e);
        }
    }

    public static DesugarUnsafe getUnsafe() {
        return theUnsafeWrapper;
    }

    public int getAndAddInt(Object o, long offset, int delta) {
        int v;
        do {
            v = this.theUnsafe.getIntVolatile(o, offset);
        } while (!this.theUnsafe.compareAndSwapInt(o, offset, v, v + delta));
        return v;
    }

    public long getAndAddLong(Object o, long offset, long delta) {
        long v;
        do {
            v = this.theUnsafe.getLongVolatile(o, offset);
        } while (!this.theUnsafe.compareAndSwapLong(o, offset, v, v + delta));
        return v;
    }

    public int getAndSetInt(Object o, long offset, int newValue) {
        int v;
        do {
            v = this.theUnsafe.getIntVolatile(o, offset);
        } while (!this.theUnsafe.compareAndSwapInt(o, offset, v, newValue));
        return v;
    }

    public long getAndSetLong(Object o, long offset, long newValue) {
        long v;
        do {
            v = this.theUnsafe.getLongVolatile(o, offset);
        } while (!this.theUnsafe.compareAndSwapLong(o, offset, v, newValue));
        return v;
    }

    public Object getAndSetObject(Object o, long offset, Object newValue) {
        Object v;
        do {
            v = this.theUnsafe.getObjectVolatile(o, offset);
        } while (!DesugarVarHandle$$ExternalSyntheticBackportWithForwarding0.m(this.theUnsafe, o, offset, v, newValue));
        return v;
    }

    public long objectFieldOffset(Field f) {
        return this.theUnsafe.objectFieldOffset(f);
    }

    public long objectFieldOffset(Class<?> c, String name) {
        if (c == null || name == null) {
            throw new NullPointerException();
        }
        try {
            return objectFieldOffset(c.getDeclaredField(name));
        } catch (NoSuchFieldException e) {
            throw new AssertionError("Cannot find field:", e);
        }
    }

    public int arrayBaseOffset(Class<?> arrayClass) {
        return this.theUnsafe.arrayBaseOffset(arrayClass);
    }

    public int arrayIndexScale(Class<?> arrayClass) {
        return this.theUnsafe.arrayIndexScale(arrayClass);
    }

    public Object getObjectAcquire(Object o, long offset) {
        return this.theUnsafe.getObjectVolatile(o, offset);
    }

    public void putObjectRelease(Object o, long offset, Object x) {
        this.theUnsafe.putObjectVolatile(o, offset, x);
    }

    public boolean compareAndSetInt(Object o, long offset, int expected, int x) {
        return this.theUnsafe.compareAndSwapInt(o, offset, expected, x);
    }

    public boolean compareAndSetLong(Object o, long offset, long expected, long x) {
        return this.theUnsafe.compareAndSwapLong(o, offset, expected, x);
    }

    public boolean compareAndSetObject(Object o, long offset, Object expected, Object x) {
        return DesugarVarHandle$$ExternalSyntheticBackportWithForwarding0.m(this.theUnsafe, o, offset, expected, x);
    }

    public long allocateMemory(long bytes) {
        return this.theUnsafe.allocateMemory(bytes);
    }

    public void freeMemory(long address) {
        this.theUnsafe.allocateMemory(address);
    }

    public void setMemory(long address, long bytes, byte value) {
        this.theUnsafe.setMemory(address, bytes, value);
    }

    public void copyMemory(long srcAddr, long dstAddr, long bytes) {
        this.theUnsafe.copyMemory(srcAddr, dstAddr, bytes);
    }

    public void copyMemory(Object srcBase, long srcOffset, Object destBase, long destOffset, long bytes) {
        for (int i = 0; i < bytes; i++) {
            long j = i + srcOffset;
            byte value = srcBase == null ? getByte(j) : getByte(srcBase, j);
            if (destBase == null) {
                putByte(i + destOffset, value);
            } else {
                putByte(destBase, i + destOffset, value);
            }
        }
    }

    public int getInt(Object o, long offset) {
        return this.theUnsafe.getInt(o, offset);
    }

    public void putInt(Object o, long offset, int x) {
        this.theUnsafe.putInt(o, offset, x);
    }

    public Object getObject(Object o, long offset) {
        return this.theUnsafe.getObject(o, offset);
    }

    public void putObject(Object o, long offset, Object x) {
        this.theUnsafe.putObject(o, offset, x);
    }

    public boolean getBoolean(Object o, long offset) {
        return this.theUnsafe.getBoolean(o, offset);
    }

    public void putBoolean(Object o, long offset, boolean x) {
        this.theUnsafe.putBoolean(o, offset, x);
    }

    public byte getByte(Object o, long offset) {
        return this.theUnsafe.getByte(o, offset);
    }

    public void putByte(Object o, long offset, byte x) {
        this.theUnsafe.putByte(o, offset, x);
    }

    public short getShort(Object o, long offset) {
        return this.theUnsafe.getShort(o, offset);
    }

    public void putShort(Object o, long offset, short x) {
        this.theUnsafe.putShort(o, offset, x);
    }

    public char getChar(Object o, long offset) {
        return this.theUnsafe.getChar(o, offset);
    }

    public void putChar(Object o, long offset, char x) {
        this.theUnsafe.putChar(o, offset, x);
    }

    public long getLong(Object o, long offset) {
        return this.theUnsafe.getLong(o, offset);
    }

    public void putLong(Object o, long offset, long x) {
        this.theUnsafe.putLong(o, offset, x);
    }

    public float getFloat(Object o, long offset) {
        return this.theUnsafe.getFloat(o, offset);
    }

    public void putFloat(Object o, long offset, float x) {
        this.theUnsafe.putFloat(o, offset, x);
    }

    public double getDouble(Object o, long offset) {
        return this.theUnsafe.getDouble(o, offset);
    }

    public void putDouble(Object o, long offset, double x) {
        this.theUnsafe.putDouble(o, offset, x);
    }

    public byte getByte(long address) {
        return this.theUnsafe.getByte(address);
    }

    public void putByte(long address, byte x) {
        this.theUnsafe.putByte(address, x);
    }

    public short getShort(long address) {
        return this.theUnsafe.getShort(address);
    }

    public void putShort(long address, short x) {
        this.theUnsafe.putShort(address, x);
    }

    public char getChar(long address) {
        return this.theUnsafe.getChar(address);
    }

    public void putChar(long address, char x) {
        this.theUnsafe.putChar(address, x);
    }

    public int getInt(long address) {
        return this.theUnsafe.getInt(address);
    }

    public void putInt(long address, int x) {
        this.theUnsafe.putInt(address, x);
    }

    public long getLong(long address) {
        return this.theUnsafe.getLong(address);
    }

    public void putLong(long address, long x) {
        this.theUnsafe.putLong(address, x);
    }

    public float getFloat(long address) {
        return this.theUnsafe.getFloat(address);
    }

    public void putFloat(long address, float x) {
        this.theUnsafe.putFloat(address, x);
    }

    public double getDouble(long address) {
        return this.theUnsafe.getDouble(address);
    }

    public void putDouble(long address, double x) {
        this.theUnsafe.putDouble(address, x);
    }

    public int addressSize() {
        return this.theUnsafe.addressSize();
    }

    public int pageSize() {
        return this.theUnsafe.pageSize();
    }

    public Object allocateInstance(Class<?> cls) {
        return this.theUnsafe.allocateInstance(cls);
    }

    public boolean compareAndSwapObject(Object o, long offset, Object expected, Object x) {
        return DesugarVarHandle$$ExternalSyntheticBackportWithForwarding0.m(this.theUnsafe, o, offset, expected, x);
    }

    public boolean compareAndSwapInt(Object o, long offset, int expected, int x) {
        return this.theUnsafe.compareAndSwapInt(o, offset, expected, x);
    }

    public boolean compareAndSwapLong(Object o, long offset, long expected, long x) {
        return this.theUnsafe.compareAndSwapLong(o, offset, expected, x);
    }

    public Object getObjectVolatile(Object o, long offset) {
        return this.theUnsafe.getObjectVolatile(o, offset);
    }

    public void putObjectVolatile(Object o, long offset, Object x) {
        this.theUnsafe.putObjectVolatile(o, offset, x);
    }

    public int getIntVolatile(Object o, long offset) {
        return this.theUnsafe.getIntVolatile(o, offset);
    }

    public void putIntVolatile(Object o, long offset, int x) {
        this.theUnsafe.putIntVolatile(o, offset, x);
    }

    public long getLongVolatile(Object o, long offset) {
        return this.theUnsafe.getLongVolatile(o, offset);
    }

    public void putLongVolatile(Object o, long offset, long x) {
        this.theUnsafe.putLongVolatile(o, offset, x);
    }

    public void putOrderedObject(Object o, long offset, Object x) {
        this.theUnsafe.putOrderedObject(o, offset, x);
    }

    public void putOrderedInt(Object o, long offset, int x) {
        this.theUnsafe.putOrderedInt(o, offset, x);
    }

    public void putOrderedLong(Object o, long offset, long x) {
        this.theUnsafe.putOrderedLong(o, offset, x);
    }

    public void unpark(Object thread) {
        this.theUnsafe.unpark(thread);
    }

    public void park(boolean isAbsolute, long time) {
        this.theUnsafe.park(isAbsolute, time);
    }

    public void ensureClassInitialized(Class<?> c) {
        try {
            Class.forName(c.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}