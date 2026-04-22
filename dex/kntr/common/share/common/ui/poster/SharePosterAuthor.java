package kntr.common.share.common.ui.poster;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharePosterParams.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/common/share/common/ui/poster/SharePosterAuthor;", "", "face", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getFace", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SharePosterAuthor {
    public static final int $stable = 0;
    private final String face;
    private final String name;

    public static /* synthetic */ SharePosterAuthor copy$default(SharePosterAuthor sharePosterAuthor, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sharePosterAuthor.face;
        }
        if ((i & 2) != 0) {
            str2 = sharePosterAuthor.name;
        }
        return sharePosterAuthor.copy(str, str2);
    }

    public final String component1() {
        return this.face;
    }

    public final String component2() {
        return this.name;
    }

    public final SharePosterAuthor copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "face");
        Intrinsics.checkNotNullParameter(str2, "name");
        return new SharePosterAuthor(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SharePosterAuthor) {
            SharePosterAuthor sharePosterAuthor = (SharePosterAuthor) obj;
            return Intrinsics.areEqual(this.face, sharePosterAuthor.face) && Intrinsics.areEqual(this.name, sharePosterAuthor.name);
        }
        return false;
    }

    public int hashCode() {
        return (this.face.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        String str = this.face;
        return "SharePosterAuthor(face=" + str + ", name=" + this.name + ")";
    }

    public SharePosterAuthor(String face, String name) {
        Intrinsics.checkNotNullParameter(face, "face");
        Intrinsics.checkNotNullParameter(name, "name");
        this.face = face;
        this.name = name;
    }

    public final String getFace() {
        return this.face;
    }

    public final String getName() {
        return this.name;
    }
}