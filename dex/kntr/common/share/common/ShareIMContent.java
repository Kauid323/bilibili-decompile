package kntr.common.share.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareContent.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/common/share/common/ShareIMContent;", "", "content", "Lkntr/common/share/common/ShareBiliContent;", "extraInfo", "", "<init>", "(Lkntr/common/share/common/ShareBiliContent;Ljava/lang/String;)V", "getContent", "()Lkntr/common/share/common/ShareBiliContent;", "getExtraInfo", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareIMContent {
    public static final int $stable = 0;
    private final ShareBiliContent content;
    private final String extraInfo;

    public ShareIMContent() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ ShareIMContent copy$default(ShareIMContent shareIMContent, ShareBiliContent shareBiliContent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            shareBiliContent = shareIMContent.content;
        }
        if ((i & 2) != 0) {
            str = shareIMContent.extraInfo;
        }
        return shareIMContent.copy(shareBiliContent, str);
    }

    public final ShareBiliContent component1() {
        return this.content;
    }

    public final String component2() {
        return this.extraInfo;
    }

    public final ShareIMContent copy(ShareBiliContent shareBiliContent, String str) {
        return new ShareIMContent(shareBiliContent, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShareIMContent) {
            ShareIMContent shareIMContent = (ShareIMContent) obj;
            return Intrinsics.areEqual(this.content, shareIMContent.content) && Intrinsics.areEqual(this.extraInfo, shareIMContent.extraInfo);
        }
        return false;
    }

    public int hashCode() {
        return ((this.content == null ? 0 : this.content.hashCode()) * 31) + (this.extraInfo != null ? this.extraInfo.hashCode() : 0);
    }

    public String toString() {
        ShareBiliContent shareBiliContent = this.content;
        return "ShareIMContent(content=" + shareBiliContent + ", extraInfo=" + this.extraInfo + ")";
    }

    public ShareIMContent(ShareBiliContent content, String extraInfo) {
        this.content = content;
        this.extraInfo = extraInfo;
    }

    public /* synthetic */ ShareIMContent(ShareBiliContent shareBiliContent, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : shareBiliContent, (i & 2) != 0 ? null : str);
    }

    public final ShareBiliContent getContent() {
        return this.content;
    }

    public final String getExtraInfo() {
        return this.extraInfo;
    }
}