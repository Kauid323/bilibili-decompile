package kotlinx.serialization.protobuf;

import kotlin.Metadata;
import kotlinx.serialization.ExperimentalSerializationApi;

/* compiled from: ProtoTypes.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lkotlinx/serialization/protobuf/ProtoIntegerType;", "", "signature", "", "(Ljava/lang/String;IJ)V", "getSignature$kotlinx_serialization_protobuf", "()J", "DEFAULT", "SIGNED", "FIXED", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalSerializationApi
public enum ProtoIntegerType {
    DEFAULT(0),
    SIGNED(8589934592L),
    FIXED(17179869184L);
    
    private final long signature;

    ProtoIntegerType(long signature) {
        this.signature = signature;
    }

    public final long getSignature$kotlinx_serialization_protobuf() {
        return this.signature;
    }
}