package defpackage;

import com.bilibili.lib.rpc.track.model.broadcast.Event;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.report.biz.broadcast.consume.consumer.misaka.apm.sample.LiveSamplerKt;
import tv.danmaku.bili.report.biz.broadcast.consume.consumer.misaka.apm.sample.SharedSamplerKt;
import tv.danmaku.bili.report.sample.Whitelist;

/* compiled from: MossBroadcastSampler.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0000¨\u0006\t"}, d2 = {"broadcastMisakaSample", "Lkotlin/Pair;", "", "", "event", "Lcom/bilibili/lib/rpc/track/model/broadcast/Event;", "targetPath", "", "shared", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* renamed from: MossBroadcastSamplerKt  reason: default package */
public final class MossBroadcastSamplerKt {
    public static final Pair<Boolean, Float> broadcastMisakaSample(Event event, String targetPath, boolean shared) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(targetPath, "targetPath");
        if (Whitelist.Companion.wl()) {
            return new Pair<>(true, Float.valueOf(1.0f));
        }
        if (shared) {
            return SharedSamplerKt.sampleShared(event, targetPath);
        }
        return LiveSamplerKt.sampleLive(event, targetPath);
    }
}