package me.weishu.epic.art.method;

import android.os.Build;
import android.util.Log;
import com.taobao.android.dexposed.utility.Logger;
import com.taobao.android.dexposed.utility.NeverCalled;
import de.robv.android.xposed.XposedHelpers;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.Arrays;
import me.weishu.epic.art.EpicNative;

public class ArtMethod {
    private static final String TAG = "ArtMethod";
    private static int artMethodSize = -1;
    private long address;
    private Constructor constructor;
    private Method method;
    private ArtMethod origin;

    private ArtMethod(Constructor constructor) {
        if (constructor == null) {
            throw new IllegalArgumentException("constructor can not be null");
        }
        this.constructor = constructor;
        init();
    }

    private ArtMethod(Method method, long address) {
        if (method == null) {
            throw new IllegalArgumentException("method can not be null");
        }
        this.method = method;
        if (address != -1) {
            this.address = address;
        } else {
            init();
        }
    }

    private void init() {
        if (this.constructor != null) {
            this.address = EpicNative.getMethodAddress(this.constructor);
        } else {
            this.address = EpicNative.getMethodAddress(this.method);
        }
    }

    public static ArtMethod of(Method method) {
        return new ArtMethod(method, -1L);
    }

    public static ArtMethod of(Method method, long address) {
        return new ArtMethod(method, address);
    }

    public static ArtMethod of(Constructor constructor) {
        return new ArtMethod(constructor);
    }

    public ArtMethod backup() {
        Field[] declaredFields;
        try {
            Class<?> abstractMethodClass = Method.class.getSuperclass();
            Object executable = getExecutable();
            Constructor<Method> constructor = Method.class.getDeclaredConstructor(new Class[0]);
            Field override = AccessibleObject.class.getDeclaredField(Build.VERSION.SDK_INT == 23 ? "flag" : "override");
            override.setAccessible(true);
            override.set(constructor, true);
            Method m = constructor.newInstance(new Object[0]);
            m.setAccessible(true);
            for (Field field : abstractMethodClass.getDeclaredFields()) {
                field.setAccessible(true);
                field.set(m, field.get(executable));
            }
            Field artMethodField = abstractMethodClass.getDeclaredField("artMethod");
            artMethodField.setAccessible(true);
            int artMethodSize2 = getArtMethodSize();
            long memoryAddress = EpicNative.map(artMethodSize2);
            byte[] data = EpicNative.get(this.address, artMethodSize2);
            EpicNative.put(data, memoryAddress);
            artMethodField.set(m, Long.valueOf(memoryAddress));
            ArtMethod artMethod = of(m, memoryAddress);
            artMethod.makePrivate();
            artMethod.setAccessible(true);
            artMethod.origin = this;
            return artMethod;
        } catch (Throwable e) {
            Log.e(TAG, "backup method error:", e);
            throw new IllegalStateException("Cannot create backup method from :: " + getExecutable(), e);
        }
    }

    public boolean isAccessible() {
        if (this.constructor != null) {
            return this.constructor.isAccessible();
        }
        return this.method.isAccessible();
    }

    public void setAccessible(boolean accessible) {
        if (this.constructor != null) {
            this.constructor.setAccessible(accessible);
        } else {
            this.method.setAccessible(accessible);
        }
    }

    public String getName() {
        if (this.constructor != null) {
            return this.constructor.getName();
        }
        return this.method.getName();
    }

    public Class<?> getDeclaringClass() {
        if (this.constructor != null) {
            return this.constructor.getDeclaringClass();
        }
        return this.method.getDeclaringClass();
    }

    public boolean compile() {
        if (this.constructor != null) {
            return EpicNative.compileMethod(this.constructor);
        }
        return EpicNative.compileMethod(this.method);
    }

    public Object invoke(Object receiver, Object... args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if (Build.VERSION.SDK_INT >= 24 && this.origin != null) {
            byte[] currentAddress = EpicNative.get(this.origin.address, 4);
            byte[] backupAddress = EpicNative.get(this.address, 4);
            if (!Arrays.equals(currentAddress, backupAddress)) {
                EpicNative.put(currentAddress, this.address);
                return invokeInternal(receiver, args);
            }
            Logger.i(TAG, "the address is same with last invoke, not moved by gc");
        }
        return invokeInternal(receiver, args);
    }

    private Object invokeInternal(Object receiver, Object... args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if (this.constructor != null) {
            return this.constructor.newInstance(args);
        }
        return this.method.invoke(receiver, args);
    }

    public int getModifiers() {
        if (this.constructor != null) {
            return this.constructor.getModifiers();
        }
        return this.method.getModifiers();
    }

    public Class<?>[] getParameterTypes() {
        if (this.constructor != null) {
            return this.constructor.getParameterTypes();
        }
        return this.method.getParameterTypes();
    }

    public Class<?> getReturnType() {
        if (this.constructor != null) {
            return Object.class;
        }
        return this.method.getReturnType();
    }

    public Class<?>[] getExceptionTypes() {
        if (this.constructor != null) {
            return this.constructor.getExceptionTypes();
        }
        return this.method.getExceptionTypes();
    }

    public String toGenericString() {
        if (this.constructor != null) {
            return this.constructor.toGenericString();
        }
        return this.method.toGenericString();
    }

    public Object getExecutable() {
        if (this.constructor != null) {
            return this.constructor;
        }
        return this.method;
    }

    public long getAddress() {
        return this.address;
    }

    public String getIdentifier() {
        return String.valueOf(getAddress());
    }

    public void makePrivate() {
        int accessFlags = getAccessFlags();
        setAccessFlags((accessFlags & (-2)) | 2);
    }

    public void ensureResolved() {
        if (!Modifier.isStatic(getModifiers())) {
            Logger.d(TAG, "not static, ignore.");
            return;
        }
        try {
            invoke(null, new Object[0]);
            Logger.d(TAG, "ensure resolved");
        } catch (Exception e) {
        } catch (Throwable th) {
            EpicNative.MakeInitializedClassVisibilyInitialized();
            throw th;
        }
        EpicNative.MakeInitializedClassVisibilyInitialized();
    }

    public long getEntryPointFromQuickCompiledCode() {
        return Offset.read(this.address, Offset.ART_QUICK_CODE_OFFSET);
    }

    public void setEntryPointFromQuickCompiledCode(long pointer_entry_point_from_quick_compiled_code) {
        Offset.write(this.address, Offset.ART_QUICK_CODE_OFFSET, pointer_entry_point_from_quick_compiled_code);
    }

    public int getAccessFlags() {
        return (int) Offset.read(this.address, Offset.ART_ACCESS_FLAG_OFFSET);
    }

    public void setAccessFlags(int newFlags) {
        Offset.write(this.address, Offset.ART_ACCESS_FLAG_OFFSET, newFlags);
    }

    public void setEntryPointFromJni(long entryPointFromJni) {
        Offset.write(this.address, Offset.ART_JNI_ENTRY_OFFSET, entryPointFromJni);
    }

    public long getEntryPointFromJni() {
        return Offset.read(this.address, Offset.ART_JNI_ENTRY_OFFSET);
    }

    public static int getArtMethodSize() {
        if (artMethodSize > 0) {
            return artMethodSize;
        }
        Method rule1 = XposedHelpers.findMethodExact(ArtMethod.class, "rule1", new Class[0]);
        Method rule2 = XposedHelpers.findMethodExact(ArtMethod.class, "rule2", new Class[0]);
        long rule2Address = EpicNative.getMethodAddress(rule2);
        long rule1Address = EpicNative.getMethodAddress(rule1);
        long size = Math.abs(rule2Address - rule1Address);
        artMethodSize = (int) size;
        Logger.d(TAG, "art Method size: " + size);
        return artMethodSize;
    }

    private void rule1() {
        Log.i(TAG, "do not inline me!!");
    }

    private void rule2() {
        Log.i(TAG, "do not inline me!!");
    }

    public static long getQuickToInterpreterBridge() {
        if (Build.VERSION.SDK_INT < 24) {
            return -1L;
        }
        Method fake = XposedHelpers.findMethodExact(NeverCalled.class, "fake", new Class[]{Integer.TYPE});
        return of(fake).getEntryPointFromQuickCompiledCode();
    }

    public long getFieldOffset() {
        return 0L;
    }

    public static long searchOffset(long base, long range, int value) {
        long step = range / 4;
        for (long i = 0; i < step; i++) {
            long offset = i * 4;
            byte[] bytes = EpicNative.memget((i * 4) + base, 4);
            int valueInOffset = ByteBuffer.allocate(4).put(bytes).getInt();
            if (valueInOffset == value) {
                return offset;
            }
        }
        return -1L;
    }

    public static long searchOffset(long base, long range, long value) {
        long step = range / 4;
        for (long i = 0; i < step; i++) {
            long offset = i * 4;
            byte[] bytes = EpicNative.memget((i * 4) + base, 4);
            long valueInOffset = ByteBuffer.allocate(8).put(bytes).getLong();
            if (valueInOffset == value) {
                return offset;
            }
        }
        return -1L;
    }
}