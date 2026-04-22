package kntr.common.share.domain;

import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.KNeuron;
import kntr.common.share.common.ShareLog;
import kntr.common.share.common.ShareMode;
import kntr.common.share.common.ShareTarget;
import kntr.common.share.domain.model.HelperKt;
import kntr.common.share.domain.model.ShareSession;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareReporter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tJ8\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tJ\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u0011"}, d2 = {"Lkntr/common/share/domain/ShareReporter;", "", "<init>", "()V", "reportChannelsShow", "", "session", "Lkntr/common/share/domain/model/ShareSession;", "extraFields", "", "", "reportClickChannel", "target", "Lkntr/common/share/common/ShareTarget;", "mode", "Lkntr/common/share/common/ShareMode;", "isShare", "domain_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareReporter {
    public static final int $stable = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportChannelsShow$default(ShareReporter shareReporter, ShareSession shareSession, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        shareReporter.reportChannelsShow(shareSession, map);
    }

    public final void reportChannelsShow(ShareSession session, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(map, "extraFields");
        Map $this$reportChannelsShow_u24lambda_u240 = MapsKt.createMapBuilder();
        $this$reportChannelsShow_u24lambda_u240.putAll(HelperKt.asMap(session));
        $this$reportChannelsShow_u24lambda_u240.putAll(map);
        Map extra = MapsKt.build($this$reportChannelsShow_u24lambda_u240);
        KNeuron.INSTANCE.reportExposure(true, "main.public-community.share.all.show", extra);
        ShareLog.Companion.i("Reporter", "main.public-community.share.all.show " + extra);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportClickChannel$default(ShareReporter shareReporter, ShareSession shareSession, ShareTarget shareTarget, ShareMode shareMode, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            shareMode = null;
        }
        if ((i & 8) != 0) {
            map = MapsKt.emptyMap();
        }
        shareReporter.reportClickChannel(shareSession, shareTarget, shareMode, map);
    }

    public final void reportClickChannel(ShareSession session, ShareTarget target, ShareMode mode, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(map, "extraFields");
        Map $this$reportClickChannel_u24lambda_u240 = MapsKt.createMapBuilder();
        HelperKt.putIfNotBlank($this$reportClickChannel_u24lambda_u240, "otype", "");
        HelperKt.putIfNotBlank($this$reportClickChannel_u24lambda_u240, "triggerparameter", "");
        HelperKt.putIfNotBlank($this$reportClickChannel_u24lambda_u240, "share_float", "default");
        HelperKt.putIfNotBlank($this$reportClickChannel_u24lambda_u240, "is_share", isShare(target));
        HelperKt.putIfNotBlank($this$reportClickChannel_u24lambda_u240, "share_mode", mode == null ? "0" : HelperKt.toValue(mode));
        HelperKt.putIfNotBlank($this$reportClickChannel_u24lambda_u240, "share_channel", target.getName());
        $this$reportClickChannel_u24lambda_u240.putAll(HelperKt.asMap(session));
        $this$reportClickChannel_u24lambda_u240.putAll(map);
        Map extra = MapsKt.build($this$reportClickChannel_u24lambda_u240);
        KNeuron.INSTANCE.reportClick(true, "main.public-community.share.all.click", extra);
        ShareLog.Companion.i("Reporter", "main.public-community.share.all.click " + extra);
    }

    private final String isShare(ShareTarget target) {
        if ((target instanceof ShareTarget.Custom) || Intrinsics.areEqual(target, ShareTarget.Cancel.INSTANCE)) {
            return "0";
        }
        return "1";
    }
}