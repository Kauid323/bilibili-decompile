package im.contact.model;

import kotlin.Metadata;
import kotlinx.serialization.protobuf.ProtoPacked;

/* compiled from: ContactReply.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final /* synthetic */ class ContactsReply$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoPacked$0 implements ProtoPacked {
    public final /* synthetic */ Class annotationType() {
        return ProtoPacked.class;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ProtoPacked) {
            ProtoPacked protoPacked = (ProtoPacked) obj;
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "@kotlinx.serialization.protobuf.ProtoPacked()";
    }
}