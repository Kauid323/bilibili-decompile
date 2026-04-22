package kntr.app.tribee.publish.core.v2.model;

import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.Lens;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishState.kt */
@Lens
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lkntr/app/tribee/publish/core/v2/model/TribeePublishEditContent;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishInitLoading;", "tribeeInfo", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "contentId", "", "<init>", "(Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;Ljava/lang/String;)V", "getTribeeInfo", "()Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "getContentId", "()Ljava/lang/String;", "getPublishContent", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;", "editToast", "Lcom/bilibili/blens/BSimpleLens;", "getEditToast", "()Lcom/bilibili/blens/BSimpleLens;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishEditContent implements TribeePublishState, TribeePublishInitLoading {
    public static final Companion Companion = new Companion(null);
    private final String contentId;
    private final TribeeInfo tribeeInfo;

    public static /* synthetic */ TribeePublishEditContent copy$default(TribeePublishEditContent tribeePublishEditContent, TribeeInfo tribeeInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            tribeeInfo = tribeePublishEditContent.tribeeInfo;
        }
        if ((i & 2) != 0) {
            str = tribeePublishEditContent.contentId;
        }
        return tribeePublishEditContent.copy(tribeeInfo, str);
    }

    public final TribeeInfo component1() {
        return this.tribeeInfo;
    }

    public final String component2() {
        return this.contentId;
    }

    public final TribeePublishEditContent copy(TribeeInfo tribeeInfo, String str) {
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        Intrinsics.checkNotNullParameter(str, "contentId");
        return new TribeePublishEditContent(tribeeInfo, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TribeePublishEditContent) {
            TribeePublishEditContent tribeePublishEditContent = (TribeePublishEditContent) obj;
            return Intrinsics.areEqual(this.tribeeInfo, tribeePublishEditContent.tribeeInfo) && Intrinsics.areEqual(this.contentId, tribeePublishEditContent.contentId);
        }
        return false;
    }

    public int hashCode() {
        return (this.tribeeInfo.hashCode() * 31) + this.contentId.hashCode();
    }

    public String toString() {
        TribeeInfo tribeeInfo = this.tribeeInfo;
        return "TribeePublishEditContent(tribeeInfo=" + tribeeInfo + ", contentId=" + this.contentId + ")";
    }

    public TribeePublishEditContent(TribeeInfo tribeeInfo, String contentId) {
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        this.tribeeInfo = tribeeInfo;
        this.contentId = contentId;
    }

    public final TribeeInfo getTribeeInfo() {
        return this.tribeeInfo;
    }

    public final String getContentId() {
        return this.contentId;
    }

    /* compiled from: TribeePublishState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/tribee/publish/core/v2/model/TribeePublishEditContent$Companion;", "", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
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