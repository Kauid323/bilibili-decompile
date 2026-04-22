package kntr.base.moss.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KMossBroadcast.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u0005\"\f\b\u0000\u0010\u0006*\u00060\u0001j\u0002`\u0007\"\f\b\u0001\u0010\b*\u00060\u0001j\u0002`\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\b0\n¨\u0006\u000b"}, d2 = {"Lkntr/base/moss/api/KMossBroadcast;", "", "<init>", "()V", "unregister", "", "KReqT", "Lkntr/base/moss/api/KProtoMessage;", "KRespT", "method", "Lkntr/base/moss/api/KMethodDescriptor;", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KMossBroadcast {
    public static final KMossBroadcast INSTANCE = new KMossBroadcast();

    private KMossBroadcast() {
    }

    public final <KReqT, KRespT> void unregister(KMethodDescriptor<KReqT, KRespT> kMethodDescriptor) {
        Intrinsics.checkNotNullParameter(kMethodDescriptor, "method");
        throw KMossException.Companion.getUNSUPPORTED();
    }
}