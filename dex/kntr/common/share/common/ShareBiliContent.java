package kntr.common.share.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareContent.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009e\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\bHÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013¨\u00064"}, d2 = {"Lkntr/common/share/common/ShareBiliContent;", "", "title", "", "description", "contentId", "contentUrl", "contentType", "", "coverUrl", "imageUrl", "authorId", "authorName", "shareCallbackUrl", "shareFrom", "bizName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getDescription", "getContentId", "getContentUrl", "getContentType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCoverUrl", "getImageUrl", "getAuthorId", "getAuthorName", "getShareCallbackUrl", "getShareFrom", "getBizName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/common/share/common/ShareBiliContent;", "equals", "", "other", "hashCode", "toString", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareBiliContent {
    public static final int $stable = 0;
    private final String authorId;
    private final String authorName;
    private final String bizName;
    private final String contentId;
    private final Integer contentType;
    private final String contentUrl;
    private final String coverUrl;
    private final String description;
    private final String imageUrl;
    private final String shareCallbackUrl;
    private final String shareFrom;
    private final String title;

    public ShareBiliContent() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public final String component1() {
        return this.title;
    }

    public final String component10() {
        return this.shareCallbackUrl;
    }

    public final String component11() {
        return this.shareFrom;
    }

    public final String component12() {
        return this.bizName;
    }

    public final String component2() {
        return this.description;
    }

    public final String component3() {
        return this.contentId;
    }

    public final String component4() {
        return this.contentUrl;
    }

    public final Integer component5() {
        return this.contentType;
    }

    public final String component6() {
        return this.coverUrl;
    }

    public final String component7() {
        return this.imageUrl;
    }

    public final String component8() {
        return this.authorId;
    }

    public final String component9() {
        return this.authorName;
    }

    public final ShareBiliContent copy(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        return new ShareBiliContent(str, str2, str3, str4, num, str5, str6, str7, str8, str9, str10, str11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShareBiliContent) {
            ShareBiliContent shareBiliContent = (ShareBiliContent) obj;
            return Intrinsics.areEqual(this.title, shareBiliContent.title) && Intrinsics.areEqual(this.description, shareBiliContent.description) && Intrinsics.areEqual(this.contentId, shareBiliContent.contentId) && Intrinsics.areEqual(this.contentUrl, shareBiliContent.contentUrl) && Intrinsics.areEqual(this.contentType, shareBiliContent.contentType) && Intrinsics.areEqual(this.coverUrl, shareBiliContent.coverUrl) && Intrinsics.areEqual(this.imageUrl, shareBiliContent.imageUrl) && Intrinsics.areEqual(this.authorId, shareBiliContent.authorId) && Intrinsics.areEqual(this.authorName, shareBiliContent.authorName) && Intrinsics.areEqual(this.shareCallbackUrl, shareBiliContent.shareCallbackUrl) && Intrinsics.areEqual(this.shareFrom, shareBiliContent.shareFrom) && Intrinsics.areEqual(this.bizName, shareBiliContent.bizName);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.contentId == null ? 0 : this.contentId.hashCode())) * 31) + (this.contentUrl == null ? 0 : this.contentUrl.hashCode())) * 31) + (this.contentType == null ? 0 : this.contentType.hashCode())) * 31) + (this.coverUrl == null ? 0 : this.coverUrl.hashCode())) * 31) + (this.imageUrl == null ? 0 : this.imageUrl.hashCode())) * 31) + (this.authorId == null ? 0 : this.authorId.hashCode())) * 31) + (this.authorName == null ? 0 : this.authorName.hashCode())) * 31) + (this.shareCallbackUrl == null ? 0 : this.shareCallbackUrl.hashCode())) * 31) + (this.shareFrom == null ? 0 : this.shareFrom.hashCode())) * 31) + (this.bizName != null ? this.bizName.hashCode() : 0);
    }

    public String toString() {
        String str = this.title;
        String str2 = this.description;
        String str3 = this.contentId;
        String str4 = this.contentUrl;
        Integer num = this.contentType;
        String str5 = this.coverUrl;
        String str6 = this.imageUrl;
        String str7 = this.authorId;
        String str8 = this.authorName;
        String str9 = this.shareCallbackUrl;
        String str10 = this.shareFrom;
        return "ShareBiliContent(title=" + str + ", description=" + str2 + ", contentId=" + str3 + ", contentUrl=" + str4 + ", contentType=" + num + ", coverUrl=" + str5 + ", imageUrl=" + str6 + ", authorId=" + str7 + ", authorName=" + str8 + ", shareCallbackUrl=" + str9 + ", shareFrom=" + str10 + ", bizName=" + this.bizName + ")";
    }

    public ShareBiliContent(String title, String description, String contentId, String contentUrl, Integer contentType, String coverUrl, String imageUrl, String authorId, String authorName, String shareCallbackUrl, String shareFrom, String bizName) {
        this.title = title;
        this.description = description;
        this.contentId = contentId;
        this.contentUrl = contentUrl;
        this.contentType = contentType;
        this.coverUrl = coverUrl;
        this.imageUrl = imageUrl;
        this.authorId = authorId;
        this.authorName = authorName;
        this.shareCallbackUrl = shareCallbackUrl;
        this.shareFrom = shareFrom;
        this.bizName = bizName;
    }

    public /* synthetic */ ShareBiliContent(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) == 0 ? str11 : null);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getContentUrl() {
        return this.contentUrl;
    }

    public final Integer getContentType() {
        return this.contentType;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getAuthorName() {
        return this.authorName;
    }

    public final String getShareCallbackUrl() {
        return this.shareCallbackUrl;
    }

    public final String getShareFrom() {
        return this.shareFrom;
    }

    public final String getBizName() {
        return this.bizName;
    }
}