package tv.danmaku.bili.fullscreen.service;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.OnePassLoginPathLinkManager;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseType;
import tv.danmaku.bili.quick.core.OnePassLoginPhoneData;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: TechTrackServiceImpl.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/TechTrackServiceImpl;", "Ltv/danmaku/bili/fullscreen/service/TechTrackService;", "<init>", "()V", "updateData", "", FavoritesConstsKt.SPMID, "", "data", "Ltv/danmaku/bili/quick/core/OnePassLoginPhoneData;", "onPhase", "phaseType", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;", "stopWithReason", "reason", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TechTrackServiceImpl implements TechTrackService {
    public static final int $stable = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnePassLoginPhoneData updateData$lambda$0(OnePassLoginPhoneData $data, OnePassLoginPhoneData it) {
        return $data;
    }

    @Override // tv.danmaku.bili.fullscreen.service.TechTrackService
    public void updateData(String spmid, final OnePassLoginPhoneData data) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(data, "data");
        OnePassLoginPathLinkManager.INSTANCE.updateData(spmid, new Function1() { // from class: tv.danmaku.bili.fullscreen.service.TechTrackServiceImpl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                OnePassLoginPhoneData updateData$lambda$0;
                updateData$lambda$0 = TechTrackServiceImpl.updateData$lambda$0(OnePassLoginPhoneData.this, (OnePassLoginPhoneData) obj);
                return updateData$lambda$0;
            }
        });
    }

    @Override // tv.danmaku.bili.fullscreen.service.TechTrackService
    public void onPhase(String spmid, OnePassLoginPhaseType phaseType) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(phaseType, "phaseType");
        OnePassLoginPathLinkManager.INSTANCE.onPhase(spmid, phaseType);
    }

    @Override // tv.danmaku.bili.fullscreen.service.TechTrackService
    public void stopWithReason(String spmid, String reason) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(reason, "reason");
        OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, reason);
    }
}