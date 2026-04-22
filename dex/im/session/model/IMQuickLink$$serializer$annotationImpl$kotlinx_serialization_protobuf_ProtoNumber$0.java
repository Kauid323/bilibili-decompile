package im.session.model;

import com.tencent.smtt.sdk.TbsListener;
import kotlin.Metadata;
import kotlinx.serialization.protobuf.ProtoNumber;

/* compiled from: IMQuickLink.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final /* synthetic */ class IMQuickLink$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0 implements ProtoNumber {
    private final /* synthetic */ int number;

    public IMQuickLink$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(int i2) {
        this.number = i2;
    }

    public final /* synthetic */ Class annotationType() {
        return ProtoNumber.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ProtoNumber) && number() == ((ProtoNumber) obj).number();
    }

    public final int hashCode() {
        return ("number".hashCode() * TbsListener.ErrorCode.STARTDOWNLOAD_OUT_OF_MAXTIME) ^ this.number;
    }

    public final /* synthetic */ int number() {
        return this.number;
    }

    public final String toString() {
        return "@kotlinx.serialization.protobuf.ProtoNumber(number=" + this.number + ")";
    }
}