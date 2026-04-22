package kntr.app.tribee.publish.core.v2.model;

import com.bilibili.blens.BSimpleLens;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishState.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lkntr/app/tribee/publish/core/v2/model/TribeePublishNewContent;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishInitLoading;", "tribeeInfo", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "<init>", "(Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;)V", "getTribeeInfo", "()Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "getPublishContent", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;", "editToast", "Lcom/bilibili/blens/BSimpleLens;", "", "getEditToast", "()Lcom/bilibili/blens/BSimpleLens;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishNewContent implements TribeePublishState, TribeePublishInitLoading {
    public static final Companion Companion = new Companion(null);
    private final TribeeInfo tribeeInfo;

    public static /* synthetic */ TribeePublishNewContent copy$default(TribeePublishNewContent tribeePublishNewContent, TribeeInfo tribeeInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            tribeeInfo = tribeePublishNewContent.tribeeInfo;
        }
        return tribeePublishNewContent.copy(tribeeInfo);
    }

    public final TribeeInfo component1() {
        return this.tribeeInfo;
    }

    public final TribeePublishNewContent copy(TribeeInfo tribeeInfo) {
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        return new TribeePublishNewContent(tribeeInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TribeePublishNewContent) && Intrinsics.areEqual(this.tribeeInfo, ((TribeePublishNewContent) obj).tribeeInfo);
    }

    public int hashCode() {
        return this.tribeeInfo.hashCode();
    }

    public String toString() {
        return "TribeePublishNewContent(tribeeInfo=" + this.tribeeInfo + ")";
    }

    public TribeePublishNewContent(TribeeInfo tribeeInfo) {
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        this.tribeeInfo = tribeeInfo;
    }

    public final TribeeInfo getTribeeInfo() {
        return this.tribeeInfo;
    }

    /* compiled from: TribeePublishState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/tribee/publish/core/v2/model/TribeePublishNewContent$Companion;", "", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // kntr.app.tribee.publish.core.v2.model.TribeePublishState
    public TribeePublishContent getPublishContent() {
        return null;
    }

    @Override // kntr.app.tribee.publish.core.v2.model.TribeePublishState
    public BSimpleLens<TribeePublishState, String> getEditToast() {
        return null;
    }
}