package me.weishu.epic.art.arch;

import java.nio.ByteOrder;
import org.msgpack.core.MessagePack;

public class Thumb2 extends ShellCode {
    @Override // me.weishu.epic.art.arch.ShellCode
    public int sizeOfDirectJump() {
        return 12;
    }

    @Override // me.weishu.epic.art.arch.ShellCode
    public byte[] createDirectJump(long targetAddress) {
        byte[] instructions = {MessagePack.Code.MAP32, -8, 0, -16, 0, 0, 0, 0};
        writeInt((int) targetAddress, ByteOrder.LITTLE_ENDIAN, instructions, instructions.length - 4);
        return instructions;
    }

    @Override // me.weishu.epic.art.arch.ShellCode
    public byte[] createBridgeJump(long targetAddress, long targetEntry, long srcAddress, long structAddress) {
        byte[] instructions = {MessagePack.Code.MAP32, -8, 48, MessagePack.Code.NIL, 96, 69, 64, -16, 25, Byte.MIN_VALUE, 8, 72, MessagePack.Code.MAP32, -8, 40, MessagePack.Code.NIL, MessagePack.Code.UINT8, -8, 0, MessagePack.Code.INT8, MessagePack.Code.UINT8, -8, 4, 32, MessagePack.Code.UINT8, -8, 8, 48, 99, 70, 5, 74, MessagePack.Code.UINT8, -8, 12, 32, 74, 70, 74, 70, MessagePack.Code.MAP32, -8, 4, -16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        writeInt((int) targetAddress, ByteOrder.LITTLE_ENDIAN, instructions, instructions.length - 16);
        writeInt((int) targetEntry, ByteOrder.LITTLE_ENDIAN, instructions, instructions.length - 12);
        writeInt((int) srcAddress, ByteOrder.LITTLE_ENDIAN, instructions, instructions.length - 8);
        writeInt((int) structAddress, ByteOrder.LITTLE_ENDIAN, instructions, instructions.length - 4);
        return instructions;
    }

    @Override // me.weishu.epic.art.arch.ShellCode
    public int sizeOfBridgeJump() {
        return 60;
    }

    @Override // me.weishu.epic.art.arch.ShellCode
    public long toPC(long code) {
        return toMem(code) + 1;
    }

    @Override // me.weishu.epic.art.arch.ShellCode
    public long toMem(long pc) {
        return (-2) & pc;
    }

    @Override // me.weishu.epic.art.arch.ShellCode
    public String getName() {
        return "Thumb2";
    }
}