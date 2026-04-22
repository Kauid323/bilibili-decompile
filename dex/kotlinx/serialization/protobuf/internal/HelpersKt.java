package kotlinx.serialization.protobuf.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.protobuf.ProtoIntegerType;
import kotlinx.serialization.protobuf.ProtoNumber;
import kotlinx.serialization.protobuf.ProtoPacked;
import kotlinx.serialization.protobuf.ProtoType;

/* compiled from: Helpers.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a\u001d\u0010\u0016\u001a\u00060\u0001j\u0002`\n2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\tH\u0080\b\u001a%\u0010\u0016\u001a\u00060\u0001j\u0002`\n2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000eH\u0080\b\u001a \u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u000eH\u0000\u001a\u0018\u0010\u001d\u001a\u00060\u0001j\u0002`\n*\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u001c\u0010\b\u001a\u00020\t*\u00060\u0001j\u0002`\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0018\u0010\r\u001a\u00020\u000e*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0010\"\u001c\u0010\u0011\u001a\u00020\u000e*\u00060\u0001j\u0002`\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u001d\u0010\u0013\u001a\u00020\u0004*\u00060\u0001j\u0002`\n8À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015*\f\b\u0000\u0010\u0016\"\u00020\u00012\u00020\u0001¨\u0006\u001e"}, d2 = {"INTTYPEMASK", "", "PACKEDMASK", "SIZE_DELIMITED", "", "VARINT", "i32", "i64", "integerType", "Lkotlinx/serialization/protobuf/ProtoIntegerType;", "Lkotlinx/serialization/protobuf/internal/ProtoDesc;", "getIntegerType", "(J)Lkotlinx/serialization/protobuf/ProtoIntegerType;", "isPackable", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "isPacked", "(J)Z", "protoId", "getProtoId", "(J)I", "ProtoDesc", "type", "packed", "extractProtoId", "descriptor", "index", "zeroBasedDefault", "extractParameters", "kotlinx-serialization-protobuf"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HelpersKt {
    private static final long INTTYPEMASK = 9223372028264841216L;
    private static final long PACKEDMASK = 4294967296L;
    public static final int SIZE_DELIMITED = 2;
    public static final int VARINT = 0;
    public static final int i32 = 5;
    public static final int i64 = 1;

    public static final long ProtoDesc(int protoId, ProtoIntegerType type, boolean packed) {
        Intrinsics.checkNotNullParameter(type, "type");
        long packedBits = packed ? PACKEDMASK : 0L;
        long signature = type.getSignature$kotlinx_serialization_protobuf() | packedBits;
        return protoId | signature;
    }

    public static final long ProtoDesc(int protoId, ProtoIntegerType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return type.getSignature$kotlinx_serialization_protobuf() | protoId;
    }

    public static final int getProtoId(long $this$protoId) {
        return (int) (2147483647L & $this$protoId);
    }

    public static final ProtoIntegerType getIntegerType(long $this$integerType) {
        long j = INTTYPEMASK & $this$integerType;
        return j == ProtoIntegerType.DEFAULT.getSignature$kotlinx_serialization_protobuf() ? ProtoIntegerType.DEFAULT : j == ProtoIntegerType.SIGNED.getSignature$kotlinx_serialization_protobuf() ? ProtoIntegerType.SIGNED : ProtoIntegerType.FIXED;
    }

    public static final boolean isPackable(SerialDescriptor $this$isPackable) {
        boolean z;
        Intrinsics.checkNotNullParameter($this$isPackable, "<this>");
        SerialKind kind = $this$isPackable.getKind();
        if (Intrinsics.areEqual(kind, PrimitiveKind.STRING.INSTANCE)) {
            z = true;
        } else {
            z = !(kind instanceof PrimitiveKind);
        }
        return !z;
    }

    public static final boolean isPacked(long $this$isPacked) {
        return (PACKEDMASK & $this$isPacked) != 0;
    }

    public static final long extractParameters(SerialDescriptor $this$extractParameters, int index) {
        Intrinsics.checkNotNullParameter($this$extractParameters, "<this>");
        List annotations = $this$extractParameters.getElementAnnotations(index);
        int protoId = index + 1;
        ProtoIntegerType format = ProtoIntegerType.DEFAULT;
        boolean protoPacked = false;
        int size = annotations.size();
        for (int i = 0; i < size; i++) {
            Annotation annotation = annotations.get(i);
            if (annotation instanceof ProtoNumber) {
                protoId = ((ProtoNumber) annotation).number();
            } else if (annotation instanceof ProtoType) {
                format = ((ProtoType) annotation).type();
            } else if (annotation instanceof ProtoPacked) {
                protoPacked = true;
            }
        }
        long packedBits$iv = protoPacked ? PACKEDMASK : 0L;
        long signature$iv = format.getSignature$kotlinx_serialization_protobuf() | packedBits$iv;
        return signature$iv | protoId;
    }

    public static final int extractProtoId(SerialDescriptor descriptor, int index, boolean zeroBasedDefault) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        List annotations = descriptor.getElementAnnotations(index);
        int size = annotations.size();
        for (int i = 0; i < size; i++) {
            Annotation annotation = annotations.get(i);
            if (annotation instanceof ProtoNumber) {
                return ((ProtoNumber) annotation).number();
            }
        }
        return zeroBasedDefault ? index : index + 1;
    }
}