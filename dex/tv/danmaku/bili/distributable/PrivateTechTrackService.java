package tv.danmaku.bili.distributable;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.TechTrackService;
import tv.danmaku.bili.quick.core.OnePassLoginPathLinkManager;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseType;
import tv.danmaku.bili.quick.core.OnePassLoginPhoneData;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DistributableLogin.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/distributable/PrivateTechTrackService;", "Ltv/danmaku/bili/fullscreen/service/TechTrackService;", "Landroid/os/Parcelable;", "<init>", "()V", "updateData", "", FavoritesConstsKt.SPMID, "", "data", "Ltv/danmaku/bili/quick/core/OnePassLoginPhoneData;", "onPhase", "phaseType", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;", "stopWithReason", "reason", "describeContents", "", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PrivateTechTrackService implements TechTrackService, Parcelable {
    public static final Parcelable.Creator<PrivateTechTrackService> CREATOR = new Creator();

    /* compiled from: DistributableLogin.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Creator implements Parcelable.Creator<PrivateTechTrackService> {
        @Override // android.os.Parcelable.Creator
        public final PrivateTechTrackService createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return new PrivateTechTrackService();
        }

        @Override // android.os.Parcelable.Creator
        public final PrivateTechTrackService[] newArray(int i) {
            return new PrivateTechTrackService[i];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnePassLoginPhoneData updateData$lambda$0(OnePassLoginPhoneData $data, OnePassLoginPhoneData it) {
        return $data;
    }

    @Override // tv.danmaku.bili.fullscreen.service.TechTrackService
    public void updateData(String spmid, final OnePassLoginPhoneData data) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(data, "data");
        OnePassLoginPathLinkManager.INSTANCE.updateData(spmid, new Function1() { // from class: tv.danmaku.bili.distributable.PrivateTechTrackService$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                OnePassLoginPhoneData updateData$lambda$0;
                updateData$lambda$0 = PrivateTechTrackService.updateData$lambda$0(OnePassLoginPhoneData.this, (OnePassLoginPhoneData) obj);
                return updateData$lambda$0;
            }
        });
    }

    @Override // tv.danmaku.bili.fullscreen.service.TechTrackService
    public void onPhase(String spmid, OnePassLoginPhaseType phaseType) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(phaseType, "phaseType");
        if ((phaseType instanceof OnePassLoginPhaseType.DisplayLoginDialog) || Intrinsics.areEqual(phaseType, OnePassLoginPhaseType.Unknown.INSTANCE)) {
            OnePassLoginPathLinkManager.INSTANCE.onPhase(spmid, phaseType);
        }
    }

    @Override // tv.danmaku.bili.fullscreen.service.TechTrackService
    public void stopWithReason(String spmid, String reason) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(reason, "reason");
        OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, reason);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(1);
    }
}