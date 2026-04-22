package me.weishu.epic.art.method;

import android.os.Build;
import com.taobao.android.dexposed.utility.Runtime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlinx.datetime.internal.DateCalculationsKt;
import leakcanary.internal.activity.db.LeaksDbHelper;
import me.weishu.epic.art.EpicNative;

/* JADX INFO: Access modifiers changed from: package-private */
public class Offset {
    static Offset ART_ACCESS_FLAG_OFFSET = null;
    static Offset ART_JNI_ENTRY_OFFSET = null;
    static Offset ART_QUICK_CODE_OFFSET = null;
    private static final String TAG = "Offset";
    private BitWidth length;
    private long offset;

    Offset() {
    }

    static {
        initFields();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public enum BitWidth {
        DWORD(4),
        QWORD(8);
        
        int width;

        BitWidth(int width) {
            this.width = width;
        }
    }

    public long getOffset() {
        return this.offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public BitWidth getLength() {
        return this.length;
    }

    public void setLength(BitWidth length) {
        this.length = length;
    }

    public static long read(long base, Offset offset) {
        long address = offset.offset + base;
        byte[] bytes = EpicNative.get(address, offset.length.width);
        if (offset.length == BitWidth.DWORD) {
            return ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getInt() & 4294967295L;
        }
        return ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getLong();
    }

    public static void write(long base, Offset offset, long value) {
        byte[] bytes;
        long address = offset.offset + base;
        if (offset.length == BitWidth.DWORD) {
            if (value > 4294967295L) {
                throw new IllegalStateException("overflow may occur");
            }
            bytes = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt((int) value).array();
        } else {
            bytes = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(value).array();
        }
        EpicNative.put(bytes, address);
    }

    private static void initFields() {
        ART_QUICK_CODE_OFFSET = new Offset();
        ART_ACCESS_FLAG_OFFSET = new Offset();
        ART_JNI_ENTRY_OFFSET = new Offset();
        ART_ACCESS_FLAG_OFFSET.setLength(BitWidth.DWORD);
        int apiLevel = Build.VERSION.SDK_INT;
        if (Runtime.is64Bit()) {
            ART_QUICK_CODE_OFFSET.setLength(BitWidth.QWORD);
            ART_JNI_ENTRY_OFFSET.setLength(BitWidth.QWORD);
            switch (apiLevel) {
                case 19:
                    ART_QUICK_CODE_OFFSET.setOffset(32L);
                    ART_ACCESS_FLAG_OFFSET.setOffset(28L);
                    return;
                case 20:
                default:
                    throw new RuntimeException("API LEVEL: " + apiLevel + " is not supported now : (");
                case 21:
                    ART_QUICK_CODE_OFFSET.setOffset(40L);
                    ART_QUICK_CODE_OFFSET.setLength(BitWidth.QWORD);
                    ART_JNI_ENTRY_OFFSET.setOffset(32L);
                    ART_JNI_ENTRY_OFFSET.setLength(BitWidth.QWORD);
                    ART_ACCESS_FLAG_OFFSET.setOffset(56L);
                    return;
                case 22:
                    ART_QUICK_CODE_OFFSET.setOffset(52L);
                    ART_JNI_ENTRY_OFFSET.setOffset(44L);
                    ART_ACCESS_FLAG_OFFSET.setOffset(20L);
                    return;
                case 23:
                    ART_QUICK_CODE_OFFSET.setOffset(48L);
                    ART_JNI_ENTRY_OFFSET.setOffset(40L);
                    ART_ACCESS_FLAG_OFFSET.setOffset(12L);
                    return;
                case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
                case LeaksDbHelper.VERSION /* 25 */:
                    ART_QUICK_CODE_OFFSET.setOffset(48L);
                    ART_JNI_ENTRY_OFFSET.setOffset(40L);
                    ART_ACCESS_FLAG_OFFSET.setOffset(4L);
                    return;
                case 26:
                case 27:
                    ART_QUICK_CODE_OFFSET.setOffset(40L);
                    ART_JNI_ENTRY_OFFSET.setOffset(32L);
                    ART_ACCESS_FLAG_OFFSET.setOffset(4L);
                    return;
                case 28:
                case 29:
                case 30:
                    ART_QUICK_CODE_OFFSET.setOffset(32L);
                    ART_JNI_ENTRY_OFFSET.setOffset(24L);
                    ART_ACCESS_FLAG_OFFSET.setOffset(4L);
                    return;
            }
        }
        ART_QUICK_CODE_OFFSET.setLength(BitWidth.DWORD);
        ART_JNI_ENTRY_OFFSET.setLength(BitWidth.DWORD);
        switch (apiLevel) {
            case 19:
                ART_QUICK_CODE_OFFSET.setOffset(32L);
                ART_ACCESS_FLAG_OFFSET.setOffset(28L);
                return;
            case 20:
            default:
                throw new RuntimeException("API LEVEL: " + apiLevel + " is not supported now : (");
            case 21:
                ART_QUICK_CODE_OFFSET.setOffset(40L);
                ART_QUICK_CODE_OFFSET.setLength(BitWidth.QWORD);
                ART_JNI_ENTRY_OFFSET.setOffset(32L);
                ART_JNI_ENTRY_OFFSET.setLength(BitWidth.QWORD);
                ART_ACCESS_FLAG_OFFSET.setOffset(56L);
                return;
            case 22:
                ART_QUICK_CODE_OFFSET.setOffset(44L);
                ART_JNI_ENTRY_OFFSET.setOffset(40L);
                ART_ACCESS_FLAG_OFFSET.setOffset(20L);
                return;
            case 23:
                ART_QUICK_CODE_OFFSET.setOffset(36L);
                ART_JNI_ENTRY_OFFSET.setOffset(32L);
                ART_ACCESS_FLAG_OFFSET.setOffset(12L);
                return;
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
                ART_QUICK_CODE_OFFSET.setOffset(32L);
                ART_JNI_ENTRY_OFFSET.setOffset(28L);
                ART_ACCESS_FLAG_OFFSET.setOffset(4L);
                return;
            case 26:
            case 27:
                ART_QUICK_CODE_OFFSET.setOffset(28L);
                ART_JNI_ENTRY_OFFSET.setOffset(24L);
                ART_ACCESS_FLAG_OFFSET.setOffset(4L);
                return;
            case 28:
            case 29:
                ART_QUICK_CODE_OFFSET.setOffset(24L);
                ART_JNI_ENTRY_OFFSET.setOffset(20L);
                ART_ACCESS_FLAG_OFFSET.setOffset(4L);
                return;
        }
    }
}