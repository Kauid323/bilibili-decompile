package me.weishu.epic.art;

import android.util.Log;
import com.taobao.android.dexposed.DeviceCheck;
import com.taobao.android.dexposed.utility.Debug;
import com.taobao.android.dexposed.utility.Logger;
import com.taobao.android.dexposed.utility.Unsafe;
import de.robv.android.xposed.XposedHelpers;
import java.lang.reflect.Member;

public final class EpicNative {
    private static final String TAG = "EpicNative";
    private static volatile boolean useUnsafe;

    public static native void MakeInitializedClassVisibilyInitialized(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean activateNative(long j, long j2, long j3, long j4, byte[] bArr);

    public static native boolean cacheflush(long j, long j2);

    public static native boolean compileMethod(Member member, long j);

    public static native void disableMovingGc(int i);

    public static native long getMethodAddress(Member member);

    public static native Object getObjectNative(long j, long j2);

    private static native boolean isGetObjectAvailable();

    public static native long malloc(int i);

    public static native void memcpy(long j, long j2, int i);

    public static native byte[] memget(long j, int i);

    public static native void memput(byte[] bArr, long j);

    public static native long mmap(int i);

    public static native boolean munmap(long j, int i);

    public static native boolean munprotect(long j, long j2);

    public static native void resumeAll(long j);

    public static native void startJit(long j);

    public static native long stopJit();

    public static native long suspendAll();

    static {
        boolean z = false;
        useUnsafe = false;
        try {
            System.loadLibrary("epic");
            useUnsafe = (DeviceCheck.isYunOS() || !isGetObjectAvailable()) ? true : true;
            Log.i(TAG, "use unsafe ? " + useUnsafe);
        } catch (Throwable e) {
            Log.e(TAG, "init EpicNative error", e);
        }
    }

    public static Object getObject(long self, long address) {
        if (useUnsafe) {
            return Unsafe.getObject(address);
        }
        return getObjectNative(self, address);
    }

    private EpicNative() {
    }

    public static boolean compileMethod(Member method) {
        long nativePeer = XposedHelpers.getLongField(Thread.currentThread(), "nativePeer");
        return compileMethod(method, nativePeer);
    }

    public static Object getObject(long address) {
        long nativePeer = XposedHelpers.getLongField(Thread.currentThread(), "nativePeer");
        return getObject(nativePeer, address);
    }

    public static void MakeInitializedClassVisibilyInitialized() {
        long nativePeer = XposedHelpers.getLongField(Thread.currentThread(), "nativePeer");
        MakeInitializedClassVisibilyInitialized(nativePeer);
    }

    public static long map(int length) {
        long m = mmap(length);
        Logger.i(TAG, "Mapped memory of size " + length + " at " + Debug.addrHex(m));
        return m;
    }

    public static boolean unmap(long address, int length) {
        Logger.d(TAG, "Removing mapped memory of size " + length + " at " + Debug.addrHex(address));
        return munmap(address, length);
    }

    public static void put(byte[] bytes, long dest) {
        memput(bytes, dest);
    }

    public static byte[] get(long src, int length) {
        Logger.d(TAG, "Reading " + length + " bytes from: " + Debug.addrHex(src));
        byte[] bytes = memget(src, length);
        Logger.d(TAG, Debug.hexdump(bytes, src));
        return bytes;
    }

    public static boolean unprotect(long addr, long len) {
        Logger.d(TAG, "Disabling mprotect from " + Debug.addrHex(addr));
        return munprotect(addr, len);
    }

    public static void copy(long src, long dst, int length) {
        Logger.d(TAG, "Copy " + length + " bytes form " + Debug.addrHex(src) + " to " + Debug.addrHex(dst));
        memcpy(src, dst, length);
    }
}