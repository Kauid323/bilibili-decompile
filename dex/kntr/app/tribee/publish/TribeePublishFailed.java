package kntr.app.tribee.publish;

import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.Lens;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishContent.kt */
@Lens
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lkntr/app/tribee/publish/TribeePublishFailed;", "Lkntr/app/tribee/publish/TribeePublishState;", "content", "Lkntr/app/tribee/publish/TribeePublishContent;", "error", "", "<init>", "(Lkntr/app/tribee/publish/TribeePublishContent;Ljava/lang/Throwable;)V", "getContent", "()Lkntr/app/tribee/publish/TribeePublishContent;", "getError", "()Ljava/lang/Throwable;", "getPublishContent", "editToast", "Lcom/bilibili/blens/BSimpleLens;", "", "getEditToast$annotations", "()V", "getEditToast", "()Lcom/bilibili/blens/BSimpleLens;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishFailed implements TribeePublishState {
    public static final Companion Companion = new Companion(null);
    private final TribeePublishContent content;
    private final Throwable error;

    public static /* synthetic */ TribeePublishFailed copy$default(TribeePublishFailed tribeePublishFailed, TribeePublishContent tribeePublishContent, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            tribeePublishContent = tribeePublishFailed.content;
        }
        if ((i & 2) != 0) {
            th = tribeePublishFailed.error;
        }
        return tribeePublishFailed.copy(tribeePublishContent, th);
    }

    public static /* synthetic */ void getEditToast$annotations() {
    }

    public final TribeePublishContent component1() {
        return this.content;
    }

    public final Throwable component2() {
        return this.error;
    }

    public final TribeePublishFailed copy(TribeePublishContent tribeePublishContent, Throwable th) {
        Intrinsics.checkNotNullParameter(tribeePublishContent, "content");
        return new TribeePublishFailed(tribeePublishContent, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TribeePublishFailed) {
            TribeePublishFailed tribeePublishFailed = (TribeePublishFailed) obj;
            return Intrinsics.areEqual(this.content, tribeePublishFailed.content) && Intrinsics.areEqual(this.error, tribeePublishFailed.error);
        }
        return false;
    }

    public int hashCode() {
        return (this.content.hashCode() * 31) + (this.error == null ? 0 : this.error.hashCode());
    }

    public String toString() {
        TribeePublishContent tribeePublishContent = this.content;
        return "TribeePublishFailed(content=" + tribeePublishContent + ", error=" + this.error + ")";
    }

    public TribeePublishFailed(TribeePublishContent content, Throwable error) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        this.error = error;
    }

    public final TribeePublishContent getContent() {
        return this.content;
    }

    public final Throwable getError() {
        return this.error;
    }

    /* compiled from: TribeePublishContent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/tribee/publish/TribeePublishFailed$Companion;", "", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
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
        return this.content;
    }

    @Override // kntr.app.tribee.publish.TribeePublishState
    public BSimpleLens<TribeePublishState, String> getEditToast() {
        BSimpleLens<TribeePublishState, String> toast = TribeePublishContentLensKt.getToast(TribeePublishFailedLensKt.getContent(TribeePublishFailedLensKt.getLens(Companion)));
        Intrinsics.checkNotNull(toast, "null cannot be cast to non-null type com.bilibili.blens.BSimpleLens<kntr.app.tribee.publish.TribeePublishState, kotlin.String?>");
        return toast;
    }
}