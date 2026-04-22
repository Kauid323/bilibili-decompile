package me.weishu.epic.art;

import android.os.Build;
import com.taobao.android.dexposed.utility.Debug;
import com.taobao.android.dexposed.utility.Logger;
import com.taobao.android.dexposed.utility.Runtime;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import me.weishu.epic.art.arch.Arm64;
import me.weishu.epic.art.arch.ShellCode;
import me.weishu.epic.art.arch.Thumb2;
import me.weishu.epic.art.method.ArtMethod;

public final class Epic {
    private static ShellCode ShellCode = null;
    private static final String TAG = "Epic";
    private static final Map<String, ArtMethod> backupMethodsMapping = new ConcurrentHashMap();
    private static final Map<Long, MethodInfo> originSigs = new ConcurrentHashMap();
    private static final Map<Long, Trampoline> scripts = new HashMap();

    static {
        int apiLevel = Build.VERSION.SDK_INT;
        boolean thumb2 = true;
        if (1 != 0) {
            if (Runtime.is64Bit()) {
                ShellCode = new Arm64();
            } else if (Runtime.isThumb2()) {
                ShellCode = new Thumb2();
            } else {
                thumb2 = false;
                ShellCode = new Thumb2();
                Logger.w(TAG, "ARM32, not support now.");
            }
        }
        if (ShellCode != null) {
            Logger.i(TAG, "Using: " + ShellCode.getName());
            return;
        }
        throw new RuntimeException("Do not support this ARCH now!! API LEVEL:" + apiLevel + " thumb2 ? : " + thumb2);
    }

    public static boolean hookMethod(Constructor origin) {
        return hookMethod(ArtMethod.of(origin));
    }

    public static boolean hookMethod(Method origin) {
        ArtMethod artOrigin = ArtMethod.of(origin);
        return hookMethod(artOrigin);
    }

    private static boolean hookMethod(ArtMethod artOrigin) {
        boolean ret;
        MethodInfo methodInfo = new MethodInfo();
        methodInfo.isStatic = Modifier.isStatic(artOrigin.getModifiers());
        Class<?>[] parameterTypes = artOrigin.getParameterTypes();
        if (parameterTypes != null) {
            methodInfo.paramNumber = parameterTypes.length;
            methodInfo.paramTypes = parameterTypes;
        } else {
            methodInfo.paramNumber = 0;
            methodInfo.paramTypes = new Class[0];
        }
        methodInfo.returnType = artOrigin.getReturnType();
        methodInfo.method = artOrigin;
        originSigs.put(Long.valueOf(artOrigin.getAddress()), methodInfo);
        if (!artOrigin.isAccessible()) {
            artOrigin.setAccessible(true);
        }
        artOrigin.ensureResolved();
        long originEntry = artOrigin.getEntryPointFromQuickCompiledCode();
        if (originEntry == ArtMethod.getQuickToInterpreterBridge()) {
            Logger.i(TAG, "this method is not compiled, compile it now. current entry: 0x" + Long.toHexString(originEntry));
            boolean ret2 = artOrigin.compile();
            if (ret2) {
                originEntry = artOrigin.getEntryPointFromQuickCompiledCode();
                Logger.i(TAG, "compile method success, new entry: 0x" + Long.toHexString(originEntry));
            } else {
                Logger.e(TAG, "compile method failed...");
                return false;
            }
        }
        ArtMethod backupMethod = artOrigin.backup();
        Logger.i(TAG, "backup method address:" + Debug.addrHex(backupMethod.getAddress()));
        Logger.i(TAG, "backup method entry :" + Debug.addrHex(backupMethod.getEntryPointFromQuickCompiledCode()));
        ArtMethod backupList = getBackMethod(artOrigin);
        if (backupList == null) {
            setBackMethod(artOrigin, backupMethod);
        }
        long key = originEntry;
        EntryLock lock = EntryLock.obtain(originEntry);
        synchronized (lock) {
            if (!scripts.containsKey(Long.valueOf(key))) {
                scripts.put(Long.valueOf(key), new Trampoline(ShellCode, originEntry));
            }
            Trampoline trampoline = scripts.get(Long.valueOf(key));
            ret = trampoline.install(artOrigin);
        }
        return ret;
    }

    public static synchronized ArtMethod getBackMethod(ArtMethod origin) {
        ArtMethod artMethod;
        synchronized (Epic.class) {
            String identifier = origin.getIdentifier();
            artMethod = backupMethodsMapping.get(identifier);
        }
        return artMethod;
    }

    public static synchronized void setBackMethod(ArtMethod origin, ArtMethod backup) {
        synchronized (Epic.class) {
            String identifier = origin.getIdentifier();
            backupMethodsMapping.put(identifier, backup);
        }
    }

    public static MethodInfo getMethodInfo(long address) {
        return originSigs.get(Long.valueOf(address));
    }

    public static int getQuickCompiledCodeSize(ArtMethod method) {
        long entryPoint = ShellCode.toMem(method.getEntryPointFromQuickCompiledCode());
        long sizeInfo1 = entryPoint - 4;
        byte[] bytes = EpicNative.get(sizeInfo1, 4);
        int size = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getInt();
        Logger.d(TAG, "getQuickCompiledCodeSize: " + size);
        return size;
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class MethodInfo {
        public boolean isStatic;
        public ArtMethod method;
        public int paramNumber;
        public Class<?>[] paramTypes;
        public Class<?> returnType;

        public String toString() {
            return this.method.toGenericString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class EntryLock {
        static Map<Long, EntryLock> sLockPool = new HashMap();

        private EntryLock() {
        }

        static synchronized EntryLock obtain(long entry) {
            synchronized (EntryLock.class) {
                if (sLockPool.containsKey(Long.valueOf(entry))) {
                    return sLockPool.get(Long.valueOf(entry));
                }
                EntryLock entryLock = new EntryLock();
                sLockPool.put(Long.valueOf(entry), entryLock);
                return entryLock;
            }
        }
    }
}