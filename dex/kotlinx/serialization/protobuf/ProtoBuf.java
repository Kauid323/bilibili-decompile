package kotlinx.serialization.protobuf;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;
import kotlinx.serialization.protobuf.internal.ByteArrayInput;
import kotlinx.serialization.protobuf.internal.ByteArrayOutput;
import kotlinx.serialization.protobuf.internal.ProtobufDecoder;
import kotlinx.serialization.protobuf.internal.ProtobufEncoder;
import kotlinx.serialization.protobuf.internal.ProtobufReader;
import kotlinx.serialization.protobuf.internal.ProtobufWriter;

/* compiled from: ProtoBuf.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J)\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J)\u0010\u0012\u001a\u00020\u0010\"\u0004\b\u0000\u0010\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\f0\u00142\u0006\u0010\u0015\u001a\u0002H\fH\u0016¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0001\u0002\u0018\u0019¨\u0006\u001a"}, d2 = {"Lkotlinx/serialization/protobuf/ProtoBuf;", "Lkotlinx/serialization/BinaryFormat;", "encodeDefaults", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "(ZLkotlinx/serialization/modules/SerializersModule;)V", "getEncodeDefaults$kotlinx_serialization_protobuf", "()Z", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "decodeFromByteArray", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "bytes", "", "(Lkotlinx/serialization/DeserializationStrategy;[B)Ljava/lang/Object;", "encodeToByteArray", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)[B", "Default", "Lkotlinx/serialization/protobuf/ProtoBuf$Default;", "Lkotlinx/serialization/protobuf/ProtoBufImpl;", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalSerializationApi
public abstract class ProtoBuf implements BinaryFormat {
    public static final Default Default = new Default(null);
    private final boolean encodeDefaults;
    private final SerializersModule serializersModule;

    public /* synthetic */ ProtoBuf(boolean z, SerializersModule serializersModule, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, serializersModule);
    }

    private ProtoBuf(boolean encodeDefaults, SerializersModule serializersModule) {
        this.encodeDefaults = encodeDefaults;
        this.serializersModule = serializersModule;
    }

    public final boolean getEncodeDefaults$kotlinx_serialization_protobuf() {
        return this.encodeDefaults;
    }

    @Override // kotlinx.serialization.SerialFormat
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    /* compiled from: ProtoBuf.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/serialization/protobuf/ProtoBuf$Default;", "Lkotlinx/serialization/protobuf/ProtoBuf;", "()V", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Default extends ProtoBuf {
        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Default() {
            super(false, SerializersModuleBuildersKt.EmptySerializersModule(), null);
        }
    }

    @Override // kotlinx.serialization.BinaryFormat
    public <T> byte[] encodeToByteArray(SerializationStrategy<? super T> serializer, T t) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        ByteArrayOutput output = new ByteArrayOutput();
        ProtobufEncoder encoder = new ProtobufEncoder(this, new ProtobufWriter(output), serializer.getDescriptor());
        encoder.encodeSerializableValue(serializer, t);
        return output.toByteArray();
    }

    @Override // kotlinx.serialization.BinaryFormat
    public <T> T decodeFromByteArray(DeserializationStrategy<? extends T> deserializer, byte[] bytes) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        ByteArrayInput input = new ByteArrayInput(bytes, 0, 2, null);
        ProtobufDecoder decoder = new ProtobufDecoder(this, new ProtobufReader(input), deserializer.getDescriptor());
        return (T) decoder.decodeSerializableValue(deserializer);
    }
}