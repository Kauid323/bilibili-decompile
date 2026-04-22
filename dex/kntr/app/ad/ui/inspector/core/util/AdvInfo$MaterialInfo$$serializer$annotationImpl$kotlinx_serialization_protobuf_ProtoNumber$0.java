package kntr.app.ad.ui.inspector.core.util;

import kotlin.Metadata;
import kotlinx.serialization.protobuf.ProtoNumber;

/* compiled from: AdvInfo.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final /* synthetic */ class AdvInfo$MaterialInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0 implements ProtoNumber {
    private final /* synthetic */ int number;

    public AdvInfo$MaterialInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(int i) {
        this.number = i;
    }

    public final /* synthetic */ Class annotationType() {
        return ProtoNumber.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ProtoNumber) && number() == ((ProtoNumber) obj).number();
    }

    public final int hashCode() {
        return ("number".hashCode() * 127) ^ this.number;
    }

    public final /* synthetic */ int number() {
        return this.number;
    }

    public final String toString() {
        return "@kotlinx.serialization.protobuf.ProtoNumber(number=" + this.number + ")";
    }
}