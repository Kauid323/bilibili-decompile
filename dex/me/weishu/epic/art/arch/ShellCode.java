package me.weishu.epic.art.arch;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class ShellCode {
    public abstract byte[] createDirectJump(long j);

    public abstract String getName();

    public abstract int sizeOfBridgeJump();

    public abstract int sizeOfDirectJump();

    public abstract long toMem(long j);

    public abstract long toPC(long j);

    public byte[] createCallOrigin(long originalAddress, byte[] originalPrologue) {
        byte[] callOriginal = new byte[sizeOfCallOrigin()];
        System.arraycopy(originalPrologue, 0, callOriginal, 0, sizeOfDirectJump());
        byte[] directJump = createDirectJump(toPC(sizeOfDirectJump() + originalAddress));
        System.arraycopy(directJump, 0, callOriginal, sizeOfDirectJump(), directJump.length);
        return callOriginal;
    }

    public int sizeOfCallOrigin() {
        return sizeOfDirectJump() * 2;
    }

    public byte[] createBridgeJump(long targetAddress, long targetEntry, long srcAddress, long structAddress) {
        throw new RuntimeException("not impled");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeInt(int i, ByteOrder order, byte[] target, int pos) {
        System.arraycopy(ByteBuffer.allocate(4).order(order).putInt(i).array(), 0, target, pos, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeLong(long i, ByteOrder order, byte[] target, int pos) {
        System.arraycopy(ByteBuffer.allocate(8).order(order).putLong(i).array(), 0, target, pos, 8);
    }
}