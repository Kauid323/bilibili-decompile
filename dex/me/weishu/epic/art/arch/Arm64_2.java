package me.weishu.epic.art.arch;

import java.nio.ByteOrder;
import org.msgpack.core.MessagePack;

public class Arm64_2 extends ShellCode {
    @Override // me.weishu.epic.art.arch.ShellCode
    public int sizeOfDirectJump() {
        return 16;
    }

    @Override // me.weishu.epic.art.arch.ShellCode
    public byte[] createDirectJump(long targetAddress) {
        byte[] instructions = {80, 0, 0, 88, 0, 2, 31, MessagePack.Code.FIXEXT4, 0, 0, 0, 0, 0, 0, 0, 0};
        writeLong(targetAddress, ByteOrder.LITTLE_ENDIAN, instructions, instructions.length - 8);
        return instructions;
    }

    @Override // me.weishu.epic.art.arch.ShellCode
    public byte[] createBridgeJump(long targetAddress, long targetEntry, long srcAddress, long structAddress) {
        byte[] instructions = {31, 32, 3, MessagePack.Code.FIXEXT2, 49, 2, 0, 88, 31, 0, 17, -21, 97, 2, 0, 84, 64, 1, 0, 88, -15, 1, 0, 88, -16, 3, 0, -111, 48, 2, 0, -7, 34, 6, 0, -7, 48, 1, 0, 88, 48, 10, 0, -7, -30, 3, 17, -86, -111, 0, 0, 88, 32, 2, 31, MessagePack.Code.FIXEXT4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        writeLong(targetAddress, ByteOrder.LITTLE_ENDIAN, instructions, instructions.length - 32);
        writeLong(targetEntry, ByteOrder.LITTLE_ENDIAN, instructions, instructions.length - 24);
        writeLong(srcAddress, ByteOrder.LITTLE_ENDIAN, instructions, instructions.length - 16);
        writeLong(structAddress, ByteOrder.LITTLE_ENDIAN, instructions, instructions.length - 8);
        return instructions;
    }

    @Override // me.weishu.epic.art.arch.ShellCode
    public int sizeOfBridgeJump() {
        return 88;
    }

    @Override // me.weishu.epic.art.arch.ShellCode
    public long toPC(long code) {
        return code;
    }

    @Override // me.weishu.epic.art.arch.ShellCode
    public long toMem(long pc) {
        return pc;
    }

    @Override // me.weishu.epic.art.arch.ShellCode
    public String getName() {
        return "64-bit ARM(Android M)";
    }
}