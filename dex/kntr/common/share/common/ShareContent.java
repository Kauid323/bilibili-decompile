package kntr.common.share.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareContent.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0097\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006="}, d2 = {"Lkntr/common/share/common/ShareContent;", "", "mode", "Lkntr/common/share/common/ShareMode;", "title", "", "content", "link", "image", "Lkntr/common/share/common/ShareImage;", "imageUrl", "audioLink", "schema", "programContent", "Lkntr/common/share/common/ShareMiniProgramContent;", "imContent", "Lkntr/common/share/common/ShareIMContent;", "dynamicContent", "Lkntr/common/share/common/ShareDynamicContent;", "markPointContent", "Lkntr/common/share/common/MarkPointContent;", "<init>", "(Lkntr/common/share/common/ShareMode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/common/share/common/ShareImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/common/share/common/ShareMiniProgramContent;Lkntr/common/share/common/ShareIMContent;Lkntr/common/share/common/ShareDynamicContent;Lkntr/common/share/common/MarkPointContent;)V", "getMode", "()Lkntr/common/share/common/ShareMode;", "getTitle", "()Ljava/lang/String;", "getContent", "getLink", "getImage", "()Lkntr/common/share/common/ShareImage;", "getImageUrl", "getAudioLink", "getSchema", "getProgramContent", "()Lkntr/common/share/common/ShareMiniProgramContent;", "getImContent", "()Lkntr/common/share/common/ShareIMContent;", "getDynamicContent", "()Lkntr/common/share/common/ShareDynamicContent;", "getMarkPointContent", "()Lkntr/common/share/common/MarkPointContent;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "", "toString", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareContent {
    public static final int $stable = 8;
    private final String audioLink;
    private final String content;
    private final ShareDynamicContent dynamicContent;
    private final ShareIMContent imContent;
    private final ShareImage image;
    private final String imageUrl;
    private final String link;
    private final MarkPointContent markPointContent;
    private final ShareMode mode;
    private final ShareMiniProgramContent programContent;
    private final String schema;
    private final String title;

    public ShareContent() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public final ShareMode component1() {
        return this.mode;
    }

    public final ShareIMContent component10() {
        return this.imContent;
    }

    public final ShareDynamicContent component11() {
        return this.dynamicContent;
    }

    public final MarkPointContent component12() {
        return this.markPointContent;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.link;
    }

    public final ShareImage component5() {
        return this.image;
    }

    public final String component6() {
        return this.imageUrl;
    }

    public final String component7() {
        return this.audioLink;
    }

    public final String component8() {
        return this.schema;
    }

    public final ShareMiniProgramContent component9() {
        return this.programContent;
    }

    public final ShareContent copy(ShareMode shareMode, String str, String str2, String str3, ShareImage shareImage, String str4, String str5, String str6, ShareMiniProgramContent shareMiniProgramContent, ShareIMContent shareIMContent, ShareDynamicContent shareDynamicContent, MarkPointContent markPointContent) {
        Intrinsics.checkNotNullParameter(shareMode, "mode");
        return new ShareContent(shareMode, str, str2, str3, shareImage, str4, str5, str6, shareMiniProgramContent, shareIMContent, shareDynamicContent, markPointContent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShareContent) {
            ShareContent shareContent = (ShareContent) obj;
            return this.mode == shareContent.mode && Intrinsics.areEqual(this.title, shareContent.title) && Intrinsics.areEqual(this.content, shareContent.content) && Intrinsics.areEqual(this.link, shareContent.link) && Intrinsics.areEqual(this.image, shareContent.image) && Intrinsics.areEqual(this.imageUrl, shareContent.imageUrl) && Intrinsics.areEqual(this.audioLink, shareContent.audioLink) && Intrinsics.areEqual(this.schema, shareContent.schema) && Intrinsics.areEqual(this.programContent, shareContent.programContent) && Intrinsics.areEqual(this.imContent, shareContent.imContent) && Intrinsics.areEqual(this.dynamicContent, shareContent.dynamicContent) && Intrinsics.areEqual(this.markPointContent, shareContent.markPointContent);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.mode.hashCode() * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.content == null ? 0 : this.content.hashCode())) * 31) + (this.link == null ? 0 : this.link.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.imageUrl == null ? 0 : this.imageUrl.hashCode())) * 31) + (this.audioLink == null ? 0 : this.audioLink.hashCode())) * 31) + (this.schema == null ? 0 : this.schema.hashCode())) * 31) + (this.programContent == null ? 0 : this.programContent.hashCode())) * 31) + (this.imContent == null ? 0 : this.imContent.hashCode())) * 31) + (this.dynamicContent == null ? 0 : this.dynamicContent.hashCode())) * 31) + (this.markPointContent != null ? this.markPointContent.hashCode() : 0);
    }

    public String toString() {
        ShareMode shareMode = this.mode;
        String str = this.title;
        String str2 = this.content;
        String str3 = this.link;
        ShareImage shareImage = this.image;
        String str4 = this.imageUrl;
        String str5 = this.audioLink;
        String str6 = this.schema;
        ShareMiniProgramContent shareMiniProgramContent = this.programContent;
        ShareIMContent shareIMContent = this.imContent;
        ShareDynamicContent shareDynamicContent = this.dynamicContent;
        return "ShareContent(mode=" + shareMode + ", title=" + str + ", content=" + str2 + ", link=" + str3 + ", image=" + shareImage + ", imageUrl=" + str4 + ", audioLink=" + str5 + ", schema=" + str6 + ", programContent=" + shareMiniProgramContent + ", imContent=" + shareIMContent + ", dynamicContent=" + shareDynamicContent + ", markPointContent=" + this.markPointContent + ")";
    }

    public ShareContent(ShareMode mode, String title, String content, String link, ShareImage image, String imageUrl, String audioLink, String schema, ShareMiniProgramContent programContent, ShareIMContent imContent, ShareDynamicContent dynamicContent, MarkPointContent markPointContent) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.mode = mode;
        this.title = title;
        this.content = content;
        this.link = link;
        this.image = image;
        this.imageUrl = imageUrl;
        this.audioLink = audioLink;
        this.schema = schema;
        this.programContent = programContent;
        this.imContent = imContent;
        this.dynamicContent = dynamicContent;
        this.markPointContent = markPointContent;
    }

    public /* synthetic */ ShareContent(ShareMode shareMode, String str, String str2, String str3, ShareImage shareImage, String str4, String str5, String str6, ShareMiniProgramContent shareMiniProgramContent, ShareIMContent shareIMContent, ShareDynamicContent shareDynamicContent, MarkPointContent markPointContent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ShareMode.Link : shareMode, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : shareImage, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : shareMiniProgramContent, (i & 512) != 0 ? null : shareIMContent, (i & 1024) != 0 ? null : shareDynamicContent, (i & 2048) == 0 ? markPointContent : null);
    }

    public final ShareMode getMode() {
        return this.mode;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getLink() {
        return this.link;
    }

    public final ShareImage getImage() {
        return this.image;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getAudioLink() {
        return this.audioLink;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final ShareMiniProgramContent getProgramContent() {
        return this.programContent;
    }

    public final ShareIMContent getImContent() {
        return this.imContent;
    }

    public final ShareDynamicContent getDynamicContent() {
        return this.dynamicContent;
    }

    public final MarkPointContent getMarkPointContent() {
        return this.markPointContent;
    }
}