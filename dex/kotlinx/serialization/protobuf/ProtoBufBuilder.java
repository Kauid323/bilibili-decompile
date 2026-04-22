package kotlinx.serialization.protobuf;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: ProtoBuf.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkotlinx/serialization/protobuf/ProtoBufBuilder;", "", "proto", "Lkotlinx/serialization/protobuf/ProtoBuf;", "(Lkotlinx/serialization/protobuf/ProtoBuf;)V", "encodeDefaults", "", "getEncodeDefaults", "()Z", "setEncodeDefaults", "(Z)V", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "setSerializersModule", "(Lkotlinx/serialization/modules/SerializersModule;)V", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalSerializationApi
public final class ProtoBufBuilder {
    private boolean encodeDefaults;
    private SerializersModule serializersModule;

    public ProtoBufBuilder(ProtoBuf proto) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        this.encodeDefaults = proto.getEncodeDefaults$kotlinx_serialization_protobuf();
        this.serializersModule = proto.getSerializersModule();
    }

    public final boolean getEncodeDefaults() {
        return this.encodeDefaults;
    }

    public final void setEncodeDefaults(boolean z) {
        this.encodeDefaults = z;
    }

    public final SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    public final void setSerializersModule(SerializersModule serializersModule) {
        Intrinsics.checkNotNullParameter(serializersModule, "<set-?>");
        this.serializersModule = serializersModule;
    }
}