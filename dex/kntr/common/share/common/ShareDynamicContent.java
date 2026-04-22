package kntr.common.share.common;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareContent.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006\""}, d2 = {"Lkntr/common/share/common/ShareDynamicContent;", "", "content", "Lkntr/common/share/common/ShareBiliContent;", "publish", "", "editContent", "", "repostCode", "sketch", "cid", "<init>", "(Lkntr/common/share/common/ShareBiliContent;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Lkntr/common/share/common/ShareBiliContent;", "getPublish", "()Z", "getEditContent", "()Ljava/lang/String;", "getRepostCode", "getSketch", "getCid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareDynamicContent {
    public static final int $stable = 0;
    private final String cid;
    private final ShareBiliContent content;
    private final String editContent;
    private final boolean publish;
    private final String repostCode;
    private final String sketch;

    public ShareDynamicContent() {
        this(null, false, null, null, null, null, 63, null);
    }

    public static /* synthetic */ ShareDynamicContent copy$default(ShareDynamicContent shareDynamicContent, ShareBiliContent shareBiliContent, boolean z, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            shareBiliContent = shareDynamicContent.content;
        }
        if ((i & 2) != 0) {
            z = shareDynamicContent.publish;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            str = shareDynamicContent.editContent;
        }
        String str5 = str;
        if ((i & 8) != 0) {
            str2 = shareDynamicContent.repostCode;
        }
        String str6 = str2;
        if ((i & 16) != 0) {
            str3 = shareDynamicContent.sketch;
        }
        String str7 = str3;
        if ((i & 32) != 0) {
            str4 = shareDynamicContent.cid;
        }
        return shareDynamicContent.copy(shareBiliContent, z2, str5, str6, str7, str4);
    }

    public final ShareBiliContent component1() {
        return this.content;
    }

    public final boolean component2() {
        return this.publish;
    }

    public final String component3() {
        return this.editContent;
    }

    public final String component4() {
        return this.repostCode;
    }

    public final String component5() {
        return this.sketch;
    }

    public final String component6() {
        return this.cid;
    }

    public final ShareDynamicContent copy(ShareBiliContent shareBiliContent, boolean z, String str, String str2, String str3, String str4) {
        return new ShareDynamicContent(shareBiliContent, z, str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShareDynamicContent) {
            ShareDynamicContent shareDynamicContent = (ShareDynamicContent) obj;
            return Intrinsics.areEqual(this.content, shareDynamicContent.content) && this.publish == shareDynamicContent.publish && Intrinsics.areEqual(this.editContent, shareDynamicContent.editContent) && Intrinsics.areEqual(this.repostCode, shareDynamicContent.repostCode) && Intrinsics.areEqual(this.sketch, shareDynamicContent.sketch) && Intrinsics.areEqual(this.cid, shareDynamicContent.cid);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((this.content == null ? 0 : this.content.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.publish)) * 31) + (this.editContent == null ? 0 : this.editContent.hashCode())) * 31) + (this.repostCode == null ? 0 : this.repostCode.hashCode())) * 31) + (this.sketch == null ? 0 : this.sketch.hashCode())) * 31) + (this.cid != null ? this.cid.hashCode() : 0);
    }

    public String toString() {
        ShareBiliContent shareBiliContent = this.content;
        boolean z = this.publish;
        String str = this.editContent;
        String str2 = this.repostCode;
        String str3 = this.sketch;
        return "ShareDynamicContent(content=" + shareBiliContent + ", publish=" + z + ", editContent=" + str + ", repostCode=" + str2 + ", sketch=" + str3 + ", cid=" + this.cid + ")";
    }

    public ShareDynamicContent(ShareBiliContent content, boolean publish, String editContent, String repostCode, String sketch, String cid) {
        this.content = content;
        this.publish = publish;
        this.editContent = editContent;
        this.repostCode = repostCode;
        this.sketch = sketch;
        this.cid = cid;
    }

    public /* synthetic */ ShareDynamicContent(ShareBiliContent shareBiliContent, boolean z, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : shareBiliContent, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
    }

    public final ShareBiliContent getContent() {
        return this.content;
    }

    public final boolean getPublish() {
        return this.publish;
    }

    public final String getEditContent() {
        return this.editContent;
    }

    public final String getRepostCode() {
        return this.repostCode;
    }

    public final String getSketch() {
        return this.sketch;
    }

    public final String getCid() {
        return this.cid;
    }
}