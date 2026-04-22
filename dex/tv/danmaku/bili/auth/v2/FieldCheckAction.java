package tv.danmaku.bili.auth.v2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: AuthV2ViewModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/auth/v2/FieldCheckAction;", "", "field", "Ltv/danmaku/bili/auth/v2/ContentField;", "content", "", "<init>", "(Ltv/danmaku/bili/auth/v2/ContentField;Ljava/lang/String;)V", "getField", "()Ltv/danmaku/bili/auth/v2/ContentField;", "getContent", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FieldCheckAction {
    private final String content;
    private final ContentField field;

    public static /* synthetic */ FieldCheckAction copy$default(FieldCheckAction fieldCheckAction, ContentField contentField, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            contentField = fieldCheckAction.field;
        }
        if ((i & 2) != 0) {
            str = fieldCheckAction.content;
        }
        return fieldCheckAction.copy(contentField, str);
    }

    public final ContentField component1() {
        return this.field;
    }

    public final String component2() {
        return this.content;
    }

    public final FieldCheckAction copy(ContentField contentField, String str) {
        Intrinsics.checkNotNullParameter(contentField, "field");
        Intrinsics.checkNotNullParameter(str, "content");
        return new FieldCheckAction(contentField, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FieldCheckAction) {
            FieldCheckAction fieldCheckAction = (FieldCheckAction) obj;
            return this.field == fieldCheckAction.field && Intrinsics.areEqual(this.content, fieldCheckAction.content);
        }
        return false;
    }

    public int hashCode() {
        return (this.field.hashCode() * 31) + this.content.hashCode();
    }

    public String toString() {
        ContentField contentField = this.field;
        return "FieldCheckAction(field=" + contentField + ", content=" + this.content + ")";
    }

    public FieldCheckAction(ContentField field, String content) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(content, "content");
        this.field = field;
        this.content = content;
    }

    public /* synthetic */ FieldCheckAction(ContentField contentField, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(contentField, (i & 2) != 0 ? "" : str);
    }

    public final ContentField getField() {
        return this.field;
    }

    public final String getContent() {
        return this.content;
    }
}