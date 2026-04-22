package kotlinx.serialization.protobuf;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;

/* compiled from: ProtoBuf.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0007¨\u0006\b"}, d2 = {"ProtoBuf", "Lkotlinx/serialization/protobuf/ProtoBuf;", "from", "builderAction", "Lkotlin/Function1;", "Lkotlinx/serialization/protobuf/ProtoBufBuilder;", "", "Lkotlin/ExtensionFunctionType;", "kotlinx-serialization-protobuf"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ProtoBufKt {
    public static /* synthetic */ ProtoBuf ProtoBuf$default(ProtoBuf protoBuf, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            protoBuf = ProtoBuf.Default;
        }
        return ProtoBuf(protoBuf, function1);
    }

    @ExperimentalSerializationApi
    public static final ProtoBuf ProtoBuf(ProtoBuf from, Function1<? super ProtoBufBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        ProtoBufBuilder b = new ProtoBufBuilder(from);
        builderAction.invoke(b);
        return new ProtoBufImpl(b.getEncodeDefaults(), b.getSerializersModule());
    }
}