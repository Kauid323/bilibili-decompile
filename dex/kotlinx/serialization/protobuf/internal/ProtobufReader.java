package kotlinx.serialization.protobuf.internal;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.protobuf.ProtoIntegerType;

/* compiled from: ProtobufReader.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0082\bJ\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u0012\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\u001a\u001a\u00020\u0003J\u0006\u0010\u001b\u001a\u00020\u0003J\u0006\u0010\u001c\u001a\u00020\u000fJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\u000e\u0010&\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010'\u001a\u00020\u0006J\b\u0010(\u001a\u00020\u0006H\u0002J\u000e\u0010)\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010*\u001a\u00020\u0017H\u0002J\u0006\u0010+\u001a\u00020\u0017J\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020-J\u0006\u0010/\u001a\u00020\u0006J\u0006\u00100\u001a\u00020\u000fJ\u0010\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0002R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lkotlinx/serialization/protobuf/internal/ProtobufReader;", "", "input", "Lkotlinx/serialization/protobuf/internal/ByteArrayInput;", "(Lkotlinx/serialization/protobuf/internal/ByteArrayInput;)V", "currentId", "", "currentType", "eof", "", "getEof", "()Z", "pushBack", "pushBackHeader", "assertWireType", "", "expected", "checkLength", "length", "decode32", "format", "Lkotlinx/serialization/protobuf/ProtoIntegerType;", "decode64", "", "decodeSignedVarintInt", "decodeSignedVarintLong", "objectInput", "objectTaglessInput", "pushBackTag", "readByteArray", "", "readByteArrayNoTag", "readDouble", "", "readDoubleNoTag", "readFloat", "", "readFloatNoTag", "readInt", "readInt32NoTag", "readIntLittleEndian", "readLong", "readLongLittleEndian", "readLongNoTag", "readString", "", "readStringNoTag", "readTag", "skipElement", "updateIdAndType", "header", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProtobufReader {
    public int currentId;
    public int currentType;
    private final ByteArrayInput input;
    private boolean pushBack;
    private int pushBackHeader;

    /* compiled from: ProtobufReader.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProtoIntegerType.values().length];
            try {
                iArr[ProtoIntegerType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ProtoIntegerType.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ProtoIntegerType.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ProtobufReader(ByteArrayInput input) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.input = input;
        this.currentId = -1;
        this.currentType = -1;
    }

    public final boolean getEof() {
        return !this.pushBack && this.input.getAvailableBytes() == 0;
    }

    public final int readTag() {
        if (this.pushBack) {
            this.pushBack = false;
            int previousHeader = (this.currentId << 3) | this.currentType;
            int updateIdAndType = updateIdAndType(this.pushBackHeader);
            this.pushBackHeader = previousHeader;
            return updateIdAndType;
        }
        int previousHeader2 = this.currentId;
        this.pushBackHeader = (previousHeader2 << 3) | this.currentType;
        int header = (int) this.input.readVarint64(true);
        return updateIdAndType(header);
    }

    private final int updateIdAndType(int header) {
        if (header == -1) {
            this.currentId = -1;
            this.currentType = -1;
            return -1;
        }
        this.currentId = header >>> 3;
        this.currentType = header & 7;
        return this.currentId;
    }

    public final void pushBackTag() {
        this.pushBack = true;
        int nextHeader = (this.currentId << 3) | this.currentType;
        updateIdAndType(this.pushBackHeader);
        this.pushBackHeader = nextHeader;
    }

    public final void skipElement() {
        switch (this.currentType) {
            case 0:
                readInt(ProtoIntegerType.DEFAULT);
                return;
            case 1:
                readLong(ProtoIntegerType.FIXED);
                return;
            case 2:
                readByteArray();
                return;
            case 3:
            case 4:
            default:
                throw new ProtobufDecodingException("Unsupported start group or end group wire type: " + this.currentType);
            case 5:
                readInt(ProtoIntegerType.FIXED);
                return;
        }
    }

    private final void assertWireType(int expected) {
        if (this.currentType != expected) {
            throw new ProtobufDecodingException("Expected wire type " + expected + ", but found " + this.currentType);
        }
    }

    public final byte[] readByteArray() {
        if (this.currentType == 2) {
            return readByteArrayNoTag();
        }
        throw new ProtobufDecodingException("Expected wire type 2, but found " + this.currentType);
    }

    public final byte[] readByteArrayNoTag() {
        int length = decode32$default(this, null, 1, null);
        checkLength(length);
        return this.input.readExactNBytes(length);
    }

    public final ByteArrayInput objectInput() {
        if (this.currentType == 2) {
            return objectTaglessInput();
        }
        throw new ProtobufDecodingException("Expected wire type 2, but found " + this.currentType);
    }

    public final ByteArrayInput objectTaglessInput() {
        int length = decode32$default(this, null, 1, null);
        checkLength(length);
        return this.input.slice(length);
    }

    public final int readInt(ProtoIntegerType format) {
        Intrinsics.checkNotNullParameter(format, "format");
        int wireType = format == ProtoIntegerType.FIXED ? 5 : 0;
        if (this.currentType == wireType) {
            return decode32(format);
        }
        throw new ProtobufDecodingException("Expected wire type " + wireType + ", but found " + this.currentType);
    }

    public final int readInt32NoTag() {
        return decode32$default(this, null, 1, null);
    }

    public final long readLong(ProtoIntegerType format) {
        Intrinsics.checkNotNullParameter(format, "format");
        int wireType = format == ProtoIntegerType.FIXED ? 1 : 0;
        if (this.currentType == wireType) {
            return decode64(format);
        }
        throw new ProtobufDecodingException("Expected wire type " + wireType + ", but found " + this.currentType);
    }

    public final long readLongNoTag() {
        return decode64(ProtoIntegerType.DEFAULT);
    }

    public final float readFloat() {
        if (this.currentType == 5) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat(readIntLittleEndian());
        }
        throw new ProtobufDecodingException("Expected wire type 5, but found " + this.currentType);
    }

    public final float readFloatNoTag() {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(readIntLittleEndian());
    }

    private final int readIntLittleEndian() {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result |= (this.input.read() & 255) << (i * 8);
        }
        return result;
    }

    private final long readLongLittleEndian() {
        long result = 0;
        for (int i = 0; i < 8; i++) {
            result |= (this.input.read() & 255) << (i * 8);
        }
        return result;
    }

    public final double readDouble() {
        if (this.currentType == 1) {
            DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
            return Double.longBitsToDouble(readLongLittleEndian());
        }
        throw new ProtobufDecodingException("Expected wire type 1, but found " + this.currentType);
    }

    public final double readDoubleNoTag() {
        DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
        return Double.longBitsToDouble(readLongLittleEndian());
    }

    public final String readString() {
        if (this.currentType == 2) {
            int length = decode32$default(this, null, 1, null);
            checkLength(length);
            return this.input.readString(length);
        }
        throw new ProtobufDecodingException("Expected wire type 2, but found " + this.currentType);
    }

    public final String readStringNoTag() {
        int length = decode32$default(this, null, 1, null);
        checkLength(length);
        return this.input.readString(length);
    }

    private final void checkLength(int length) {
        if (length < 0) {
            throw new ProtobufDecodingException("Unexpected negative length: " + length);
        }
    }

    private final int decode32(ProtoIntegerType format) {
        switch (WhenMappings.$EnumSwitchMapping$0[format.ordinal()]) {
            case 1:
                return (int) this.input.readVarint64(false);
            case 2:
                return decodeSignedVarintInt(this.input);
            case 3:
                return readIntLittleEndian();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    static /* synthetic */ int decode32$default(ProtobufReader protobufReader, ProtoIntegerType protoIntegerType, int i, Object obj) {
        if ((i & 1) != 0) {
            protoIntegerType = ProtoIntegerType.DEFAULT;
        }
        return protobufReader.decode32(protoIntegerType);
    }

    private final long decode64(ProtoIntegerType format) {
        switch (WhenMappings.$EnumSwitchMapping$0[format.ordinal()]) {
            case 1:
                return this.input.readVarint64(false);
            case 2:
                return decodeSignedVarintLong(this.input);
            case 3:
                return readLongLittleEndian();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    static /* synthetic */ long decode64$default(ProtobufReader protobufReader, ProtoIntegerType protoIntegerType, int i, Object obj) {
        if ((i & 1) != 0) {
            protoIntegerType = ProtoIntegerType.DEFAULT;
        }
        return protobufReader.decode64(protoIntegerType);
    }

    private final int decodeSignedVarintInt(ByteArrayInput input) {
        int raw = input.readVarint32();
        int temp = (((raw << 31) >> 31) ^ raw) >> 1;
        return (Integer.MIN_VALUE & raw) ^ temp;
    }

    private final long decodeSignedVarintLong(ByteArrayInput input) {
        long raw = input.readVarint64(false);
        long temp = (((raw << 63) >> 63) ^ raw) >> 1;
        return (Long.MIN_VALUE & raw) ^ temp;
    }
}