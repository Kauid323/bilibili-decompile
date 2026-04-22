package kotlinx.serialization.protobuf;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: ProtoBuf.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/serialization/protobuf/ProtoBufImpl;", "Lkotlinx/serialization/protobuf/ProtoBuf;", "encodeDefaults", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "(ZLkotlinx/serialization/modules/SerializersModule;)V", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalSerializationApi
final class ProtoBufImpl extends ProtoBuf {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProtoBufImpl(boolean encodeDefaults, SerializersModule serializersModule) {
        super(encodeDefaults, serializersModule, null);
        Intrinsics.checkNotNullParameter(serializersModule, "serializersModule");
    }
}