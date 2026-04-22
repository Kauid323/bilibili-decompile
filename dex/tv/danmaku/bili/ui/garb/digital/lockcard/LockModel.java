package tv.danmaku.bili.ui.garb.digital.lockcard;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.api.CardLockStatus;

/* compiled from: CreateLockModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&R\u0018\u0010\f\u001a\u00020\rX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/lockcard/LockModel;", "", "toggleLockCard", "", "toggleCardLocked", "", "actId", "", "cardId", "cardTypeId", "cardNo", "", "lockStatus", "Ltv/danmaku/bili/ui/garb/api/CardLockStatus;", "getLockStatus", "()Ltv/danmaku/bili/ui/garb/api/CardLockStatus;", "setLockStatus", "(Ltv/danmaku/bili/ui/garb/api/CardLockStatus;)V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface LockModel {
    CardLockStatus getLockStatus();

    void setLockStatus(CardLockStatus cardLockStatus);

    void toggleLockCard(boolean z, long j, long j2, long j3, String str);
}