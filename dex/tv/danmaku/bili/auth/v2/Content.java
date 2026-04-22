package tv.danmaku.bili.auth.v2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: AuthV2ViewModel.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J'\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013¨\u0006!"}, d2 = {"Ltv/danmaku/bili/auth/v2/Content;", "", "field", "Ltv/danmaku/bili/auth/v2/ContentField;", "content", "", "checkStatus", "Ltv/danmaku/bili/auth/v2/ContentCheckStatus;", "<init>", "(Ltv/danmaku/bili/auth/v2/ContentField;Ljava/lang/String;Ltv/danmaku/bili/auth/v2/ContentCheckStatus;)V", "getField", "()Ltv/danmaku/bili/auth/v2/ContentField;", "getContent", "()Ljava/lang/String;", "getCheckStatus", "()Ltv/danmaku/bili/auth/v2/ContentCheckStatus;", "loading", "", "getLoading", "()Z", "remoteValidChecked", "getRemoteValidChecked", "remoteValid", "getRemoteValid", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Content {
    private final ContentCheckStatus checkStatus;
    private final String content;
    private final ContentField field;

    public static /* synthetic */ Content copy$default(Content content, ContentField contentField, String str, ContentCheckStatus contentCheckStatus, int i, Object obj) {
        if ((i & 1) != 0) {
            contentField = content.field;
        }
        if ((i & 2) != 0) {
            str = content.content;
        }
        if ((i & 4) != 0) {
            contentCheckStatus = content.checkStatus;
        }
        return content.copy(contentField, str, contentCheckStatus);
    }

    public final ContentField component1() {
        return this.field;
    }

    public final String component2() {
        return this.content;
    }

    public final ContentCheckStatus component3() {
        return this.checkStatus;
    }

    public final Content copy(ContentField contentField, String str, ContentCheckStatus contentCheckStatus) {
        Intrinsics.checkNotNullParameter(contentField, "field");
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(contentCheckStatus, "checkStatus");
        return new Content(contentField, str, contentCheckStatus);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Content) {
            Content content = (Content) obj;
            return this.field == content.field && Intrinsics.areEqual(this.content, content.content) && this.checkStatus == content.checkStatus;
        }
        return false;
    }

    public int hashCode() {
        return (((this.field.hashCode() * 31) + this.content.hashCode()) * 31) + this.checkStatus.hashCode();
    }

    public String toString() {
        ContentField contentField = this.field;
        String str = this.content;
        return "Content(field=" + contentField + ", content=" + str + ", checkStatus=" + this.checkStatus + ")";
    }

    public Content(ContentField field, String content, ContentCheckStatus checkStatus) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(checkStatus, "checkStatus");
        this.field = field;
        this.content = content;
        this.checkStatus = checkStatus;
    }

    public /* synthetic */ Content(ContentField contentField, String str, ContentCheckStatus contentCheckStatus, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(contentField, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? ContentCheckStatus.NotChecked : contentCheckStatus);
    }

    public final ContentField getField() {
        return this.field;
    }

    public final String getContent() {
        return this.content;
    }

    public final ContentCheckStatus getCheckStatus() {
        return this.checkStatus;
    }

    public final boolean getLoading() {
        return this.checkStatus == ContentCheckStatus.Checking;
    }

    public final boolean getRemoteValidChecked() {
        return this.checkStatus == ContentCheckStatus.CheckedPass || this.checkStatus == ContentCheckStatus.CheckedFailed;
    }

    public final boolean getRemoteValid() {
        return this.checkStatus == ContentCheckStatus.CheckedPass;
    }
}