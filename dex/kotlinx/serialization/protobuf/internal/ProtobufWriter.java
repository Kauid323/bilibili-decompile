package kotlinx.serialization.protobuf.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.protobuf.ProtoIntegerType;

/* compiled from: ProtobufWriter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000fJ\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nJ\u001e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0014J\u001e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0003J\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0018J\u0016\u0010\u0017\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u0019\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0002J\u001e\u0010\u001b\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00142\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0002J\f\u0010\u001c\u001a\u00020\u0014*\u00020\rH\u0002J\f\u0010\u001c\u001a\u00020\n*\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlinx/serialization/protobuf/internal/ProtobufWriter;", "", "out", "Lkotlinx/serialization/protobuf/internal/ByteArrayOutput;", "(Lkotlinx/serialization/protobuf/internal/ByteArrayOutput;)V", "writeBytes", "", "bytes", "", "tag", "", "writeDouble", "value", "", "writeFloat", "", "writeInt", "format", "Lkotlinx/serialization/protobuf/ProtoIntegerType;", "writeLong", "", "writeOutput", "output", "writeString", "", "encode32", "number", "encode64", "reverseBytes", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProtobufWriter {
    private final ByteArrayOutput out;

    /* compiled from: ProtobufWriter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProtoIntegerType.values().length];
            try {
                iArr[ProtoIntegerType.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ProtoIntegerType.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ProtoIntegerType.SIGNED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ProtobufWriter(ByteArrayOutput out) {
        Intrinsics.checkNotNullParameter(out, "out");
        this.out = out;
    }

    public final void writeBytes(byte[] bytes, int tag) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        encode32$default(this, this.out, (tag << 3) | 2, null, 2, null);
        writeBytes(bytes);
    }

    public final void writeBytes(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        encode32$default(this, this.out, bytes.length, null, 2, null);
        this.out.write(bytes);
    }

    public final void writeOutput(ByteArrayOutput output, int tag) {
        Intrinsics.checkNotNullParameter(output, "output");
        encode32$default(this, this.out, (tag << 3) | 2, null, 2, null);
        writeOutput(output);
    }

    public final void writeOutput(ByteArrayOutput output) {
        Intrinsics.checkNotNullParameter(output, "output");
        encode32$default(this, this.out, output.size(), null, 2, null);
        this.out.write(output);
    }

    public final void writeInt(int value, int tag, ProtoIntegerType format) {
        Intrinsics.checkNotNullParameter(format, "format");
        int wireType = format == ProtoIntegerType.FIXED ? 5 : 0;
        encode32$default(this, this.out, (tag << 3) | wireType, null, 2, null);
        encode32(this.out, value, format);
    }

    public final void writeInt(int value) {
        encode32$default(this, this.out, value, null, 2, null);
    }

    public final void writeLong(long value, int tag, ProtoIntegerType format) {
        Intrinsics.checkNotNullParameter(format, "format");
        int wireType = format == ProtoIntegerType.FIXED ? 1 : 0;
        encode32$default(this, this.out, (tag << 3) | wireType, null, 2, null);
        encode64(this.out, value, format);
    }

    public final void writeLong(long value) {
        encode64$default(this, this.out, value, null, 2, null);
    }

    public final void writeString(String value, int tag) {
        Intrinsics.checkNotNullParameter(value, "value");
        byte[] bytes = StringsKt.encodeToByteArray(value);
        writeBytes(bytes, tag);
    }

    public final void writeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        byte[] bytes = StringsKt.encodeToByteArray(value);
        writeBytes(bytes);
    }

    public final void writeDouble(double value, int tag) {
        encode32$default(this, this.out, (tag << 3) | 1, null, 2, null);
        this.out.writeLong(reverseBytes(value));
    }

    public final void writeDouble(double value) {
        this.out.writeLong(reverseBytes(value));
    }

    public final void writeFloat(float value, int tag) {
        encode32$default(this, this.out, (tag << 3) | 5, null, 2, null);
        this.out.writeInt(reverseBytes(value));
    }

    public final void writeFloat(float value) {
        this.out.writeInt(reverseBytes(value));
    }

    static /* synthetic */ void encode32$default(ProtobufWriter protobufWriter, ByteArrayOutput byteArrayOutput, int i, ProtoIntegerType protoIntegerType, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            protoIntegerType = ProtoIntegerType.DEFAULT;
        }
        protobufWriter.encode32(byteArrayOutput, i, protoIntegerType);
    }

    private final void encode32(ByteArrayOutput $this$encode32, int number, ProtoIntegerType format) {
        switch (WhenMappings.$EnumSwitchMapping$0[format.ordinal()]) {
            case 1:
                this.out.writeInt(BytesKt.reverseBytes(number));
                return;
            case 2:
                $this$encode32.encodeVarint64(number);
                return;
            case 3:
                $this$encode32.encodeVarint32((number << 1) ^ (number >> 31));
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void encode64$default(ProtobufWriter protobufWriter, ByteArrayOutput byteArrayOutput, long j, ProtoIntegerType protoIntegerType, int i, Object obj) {
        if ((i & 2) != 0) {
            protoIntegerType = ProtoIntegerType.DEFAULT;
        }
        protobufWriter.encode64(byteArrayOutput, j, protoIntegerType);
    }

    private final void encode64(ByteArrayOutput $this$encode64, long number, ProtoIntegerType format) {
        switch (WhenMappings.$EnumSwitchMapping$0[format.ordinal()]) {
            case 1:
                this.out.writeLong(BytesKt.reverseBytes(number));
                return;
            case 2:
                $this$encode64.encodeVarint64(number);
                return;
            case 3:
                $this$encode64.encodeVarint64((number << 1) ^ (number >> 63));
                return;
            default:
                return;
        }
    }

    private final int reverseBytes(float $this$reverseBytes) {
        return BytesKt.reverseBytes(Float.floatToRawIntBits($this$reverseBytes));
    }

    private final long reverseBytes(double $this$reverseBytes) {
        return BytesKt.reverseBytes(Double.doubleToRawLongBits($this$reverseBytes));
    }
}