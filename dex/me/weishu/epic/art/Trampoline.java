package me.weishu.epic.art;

import com.taobao.android.dexposed.utility.Debug;
import com.taobao.android.dexposed.utility.Logger;
import com.taobao.android.dexposed.utility.Runtime;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import me.weishu.epic.art.Epic;
import me.weishu.epic.art.arch.ShellCode;
import me.weishu.epic.art.entry.Entry;
import me.weishu.epic.art.entry.Entry64;
import me.weishu.epic.art.method.ArtMethod;

class Trampoline {
    private static final String TAG = "Trampoline";
    private boolean active;
    private final long jumpToAddress;
    private final byte[] originalCode;
    private Set<ArtMethod> segments = new HashSet();
    private final ShellCode shellCode;
    private long trampolineAddress;
    private int trampolineSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Trampoline(ShellCode shellCode, long entryPoint) {
        this.shellCode = shellCode;
        this.jumpToAddress = shellCode.toMem(entryPoint);
        this.originalCode = EpicNative.get(this.jumpToAddress, shellCode.sizeOfDirectJump());
    }

    public boolean install(ArtMethod originMethod) {
        boolean modified = this.segments.add(originMethod);
        if (!modified) {
            Logger.d(TAG, originMethod + " is already hooked, return.");
            return true;
        }
        byte[] page = create();
        EpicNative.put(page, getTrampolineAddress());
        int quickCompiledCodeSize = Epic.getQuickCompiledCodeSize(originMethod);
        int sizeOfDirectJump = this.shellCode.sizeOfDirectJump();
        if (quickCompiledCodeSize < sizeOfDirectJump) {
            Logger.w(TAG, originMethod.toGenericString() + " quickCompiledCodeSize: " + quickCompiledCodeSize);
            originMethod.setEntryPointFromQuickCompiledCode(getTrampolinePc());
            return true;
        }
        return activate();
    }

    private long getTrampolineAddress() {
        if (getSize() != this.trampolineSize) {
            alloc();
        }
        return this.trampolineAddress;
    }

    private long getTrampolinePc() {
        return this.shellCode.toPC(getTrampolineAddress());
    }

    private void alloc() {
        if (this.trampolineAddress != 0) {
            free();
        }
        this.trampolineSize = getSize();
        this.trampolineAddress = EpicNative.map(this.trampolineSize);
        Logger.d(TAG, "Trampoline alloc:" + this.trampolineSize + ", addr: 0x" + Long.toHexString(this.trampolineAddress));
    }

    private void free() {
        if (this.trampolineAddress != 0) {
            EpicNative.unmap(this.trampolineAddress, this.trampolineSize);
            this.trampolineAddress = 0L;
            this.trampolineSize = 0;
        }
        if (this.active) {
            EpicNative.put(this.originalCode, this.jumpToAddress);
        }
    }

    private int getSize() {
        int count = 0 + (this.shellCode.sizeOfBridgeJump() * this.segments.size());
        return count + this.shellCode.sizeOfCallOrigin();
    }

    private byte[] create() {
        Logger.d(TAG, "create trampoline." + this.segments);
        byte[] mainPage = new byte[getSize()];
        int offset = 0;
        for (ArtMethod method : this.segments) {
            byte[] bridgeJump = createTrampoline(method);
            int length = bridgeJump.length;
            System.arraycopy(bridgeJump, 0, mainPage, offset, length);
            offset += length;
        }
        byte[] callOriginal = this.shellCode.createCallOrigin(this.jumpToAddress, this.originalCode);
        System.arraycopy(callOriginal, 0, mainPage, offset, callOriginal.length);
        return mainPage;
    }

    private boolean activate() {
        boolean activateNative;
        long pc = getTrampolinePc();
        Logger.d(TAG, "Writing direct jump entry " + Debug.addrHex(pc) + " to origin entry: 0x" + Debug.addrHex(this.jumpToAddress));
        synchronized (Trampoline.class) {
            activateNative = EpicNative.activateNative(this.jumpToAddress, pc, this.shellCode.sizeOfDirectJump(), this.shellCode.sizeOfBridgeJump(), this.shellCode.createDirectJump(pc));
        }
        return activateNative;
    }

    protected void finalize() throws Throwable {
        free();
        super.finalize();
    }

    private byte[] createTrampoline(ArtMethod source) {
        Epic.MethodInfo methodInfo = Epic.getMethodInfo(source.getAddress());
        Class<?> returnType = methodInfo.returnType;
        Method bridgeMethod = Runtime.is64Bit() ? Entry64.getBridgeMethod(returnType) : Entry.getBridgeMethod(returnType);
        ArtMethod target = ArtMethod.of(bridgeMethod);
        long targetAddress = target.getAddress();
        long targetEntry = target.getEntryPointFromQuickCompiledCode();
        long sourceAddress = source.getAddress();
        long structAddress = EpicNative.malloc(4);
        Logger.d(TAG, "targetAddress:" + Debug.longHex(targetAddress));
        Logger.d(TAG, "sourceAddress:" + Debug.longHex(sourceAddress));
        Logger.d(TAG, "targetEntry:" + Debug.longHex(targetEntry));
        Logger.d(TAG, "structAddress:" + Debug.longHex(structAddress));
        return this.shellCode.createBridgeJump(targetAddress, targetEntry, sourceAddress, structAddress);
    }
}