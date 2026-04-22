package tv.danmaku.bili.fullscreen.service;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseType;
import tv.danmaku.bili.quick.core.OnePassLoginPhoneData;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: interface.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/TechTrackService;", "", "updateData", "", FavoritesConstsKt.SPMID, "", "data", "Ltv/danmaku/bili/quick/core/OnePassLoginPhoneData;", "onPhase", "phaseType", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;", "stopWithReason", "reason", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface TechTrackService {
    void onPhase(String str, OnePassLoginPhaseType onePassLoginPhaseType);

    void stopWithReason(String str, String str2);

    void updateData(String str, OnePassLoginPhoneData onePassLoginPhoneData);
}