package kntr.base.neuron.internal.model.pb;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlinx.serialization.protobuf.ProtoPacked;

/* compiled from: info_raw.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class KAppEvent$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoPacked$0 implements ProtoPacked {
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