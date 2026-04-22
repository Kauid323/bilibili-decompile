package kntr.app.tribee.publish;

import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.Lens;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishContent.kt */
@Lens
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lkntr/app/tribee/publish/TribeePublishClosing;", "Lkntr/app/tribee/publish/TribeePublishState;", "toast", "", "<init>", "(Ljava/lang/String;)V", "getToast", "()Ljava/lang/String;", "getPublishContent", "Lkntr/app/tribee/publish/TribeePublishContent;", "editToast", "Lcom/bilibili/blens/BSimpleLens;", "getEditToast$annotations", "()V", "getEditToast", "()Lcom/bilibili/blens/BSimpleLens;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishClosing implements TribeePublishState {
    public static final Companion Companion = new Companion(null);
    private final String toast;

    public TribeePublishClosing() {
        this(null, 1, null);
    }

    public static /* synthetic */ TribeePublishClosing copy$default(TribeePublishClosing tribeePublishClosing, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tribeePublishClosing.toast;
        }
        return tribeePublishClosing.copy(str);
    }

    public static /* synthetic */ void getEditToast$annotations() {
    }

    public final String component1() {
        return this.toast;
    }

    public final TribeePublishClosing copy(String str) {
        return new TribeePublishClosing(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TribeePublishClosing) && Intrinsics.areEqual(this.toast, ((TribeePublishClosing) obj).toast);
    }

    public int hashCode() {
        if (this.toast == null) {
            return 0;
        }
        return this.toast.hashCode();
    }

    public String toString() {
        return "TribeePublishClosing(toast=" + this.toast + ")";
    }

    public TribeePublishClosing(String toast) {
        this.toast = toast;
    }

    public /* synthetic */ TribeePublishClosing(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getToast() {
        return this.toast;
    }

    /* compiled from: TribeePublishContent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/tribee/publish/TribeePublishClosing$Companion;", "", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // kntr.app.tribee.publish.TribeePublishState
    public TribeePublishContent getPublishContent() {
        return null;
    }

    @Override // kntr.app.tribee.publish.TribeePublishState
    public BSimpleLens<TribeePublishState, String> getEditToast() {
        BSimpleLens<TribeePublishState, String> toast = TribeePublishClosingLensKt.getToast(TribeePublishClosingLensKt.getLens(Companion));
        Intrinsics.checkNotNull(toast, "null cannot be cast to non-null type com.bilibili.blens.BSimpleLens<kntr.app.tribee.publish.TribeePublishState, kotlin.String?>");
        return toast;
    }
}