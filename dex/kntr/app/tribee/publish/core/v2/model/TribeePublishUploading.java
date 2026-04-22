package kntr.app.tribee.publish.core.v2.model;

import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.Lens;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishState.kt */
@Lens
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lkntr/app/tribee/publish/core/v2/model/TribeePublishUploading;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;", "content", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;", "<init>", "(Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;)V", "getContent", "()Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;", "getPublishContent", "editToast", "Lcom/bilibili/blens/BSimpleLens;", "", "getEditToast$annotations", "()V", "getEditToast", "()Lcom/bilibili/blens/BSimpleLens;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishUploading implements TribeePublishState {
    public static final Companion Companion = new Companion(null);
    private final TribeePublishContent content;

    public static /* synthetic */ TribeePublishUploading copy$default(TribeePublishUploading tribeePublishUploading, TribeePublishContent tribeePublishContent, int i, Object obj) {
        if ((i & 1) != 0) {
            tribeePublishContent = tribeePublishUploading.content;
        }
        return tribeePublishUploading.copy(tribeePublishContent);
    }

    public static /* synthetic */ void getEditToast$annotations() {
    }

    public final TribeePublishContent component1() {
        return this.content;
    }

    public final TribeePublishUploading copy(TribeePublishContent tribeePublishContent) {
        Intrinsics.checkNotNullParameter(tribeePublishContent, "content");
        return new TribeePublishUploading(tribeePublishContent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TribeePublishUploading) && Intrinsics.areEqual(this.content, ((TribeePublishUploading) obj).content);
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    public String toString() {
        return "TribeePublishUploading(content=" + this.content + ")";
    }

    public TribeePublishUploading(TribeePublishContent content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
    }

    public final TribeePublishContent getContent() {
        return this.content;
    }

    /* compiled from: TribeePublishState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/tribee/publish/core/v2/model/TribeePublishUploading$Companion;", "", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
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
        return this.content;
    }

    @Override // kntr.app.tribee.publish.core.v2.model.TribeePublishState
    public BSimpleLens<TribeePublishState, String> getEditToast() {
        BSimpleLens<TribeePublishState, String> toast = TribeePublishContentLensKt.getToast(TribeePublishUploadingLensKt.getContent(TribeePublishUploadingLensKt.getLens(Companion)));
        Intrinsics.checkNotNull(toast, "null cannot be cast to non-null type com.bilibili.blens.BSimpleLens<kntr.app.tribee.publish.core.v2.model.TribeePublishState, kotlin.String?>");
        return toast;
    }
}