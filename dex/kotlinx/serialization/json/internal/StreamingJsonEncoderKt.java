package kotlinx.serialization.json.internal;

import java.util.Set;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonElementKt;

/* compiled from: StreamingJsonEncoder.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0018\u0010\b\u001a\u00020\u0006*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"unsignedNumberDescriptors", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getUnsignedNumberDescriptors$annotations", "()V", "isUnquotedLiteral", "", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "isUnsignedNumber", "kotlinx-serialization-json"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StreamingJsonEncoderKt {
    private static final Set<SerialDescriptor> unsignedNumberDescriptors = SetsKt.setOf((Object[]) new SerialDescriptor[]{BuiltinSerializersKt.serializer(UInt.Companion).getDescriptor(), BuiltinSerializersKt.serializer(ULong.Companion).getDescriptor(), BuiltinSerializersKt.serializer(UByte.Companion).getDescriptor(), BuiltinSerializersKt.serializer(UShort.Companion).getDescriptor()});

    private static /* synthetic */ void getUnsignedNumberDescriptors$annotations() {
    }

    public static final boolean isUnsignedNumber(SerialDescriptor $this$isUnsignedNumber) {
        Intrinsics.checkNotNullParameter($this$isUnsignedNumber, "<this>");
        return $this$isUnsignedNumber.isInline() && unsignedNumberDescriptors.contains($this$isUnsignedNumber);
    }

    public static final boolean isUnquotedLiteral(SerialDescriptor $this$isUnquotedLiteral) {
        Intrinsics.checkNotNullParameter($this$isUnquotedLiteral, "<this>");
        return $this$isUnquotedLiteral.isInline() && Intrinsics.areEqual($this$isUnquotedLiteral, JsonElementKt.getJsonUnquotedLiteralDescriptor());
    }
}