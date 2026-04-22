package tv.danmaku.bili.ui.garb.api;

import BottomSheetItemData$;
import com.bilibili.bson.common.Bson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BiliDLCCardItem.kt */
@Bson
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001:\u0003!\"#B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006$"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/WebCard;", "", "hasSmelted", "", "isSmeltCard", "smeltResource", "Ltv/danmaku/bili/ui/garb/api/WebCard$SmeltResource;", "smeltJump", "Ltv/danmaku/bili/ui/garb/api/WebCard$SmeltUrl;", "smeltTag", "Ltv/danmaku/bili/ui/garb/api/WebCard$SmeltTag;", "<init>", "(ZZLtv/danmaku/bili/ui/garb/api/WebCard$SmeltResource;Ltv/danmaku/bili/ui/garb/api/WebCard$SmeltUrl;Ltv/danmaku/bili/ui/garb/api/WebCard$SmeltTag;)V", "getHasSmelted", "()Z", "getSmeltResource", "()Ltv/danmaku/bili/ui/garb/api/WebCard$SmeltResource;", "getSmeltJump", "()Ltv/danmaku/bili/ui/garb/api/WebCard$SmeltUrl;", "getSmeltTag", "()Ltv/danmaku/bili/ui/garb/api/WebCard$SmeltTag;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "SmeltResource", "SmeltTag", "SmeltUrl", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class WebCard {
    public static final int $stable = 0;
    private final boolean hasSmelted;
    private final boolean isSmeltCard;
    private final SmeltUrl smeltJump;
    private final SmeltResource smeltResource;
    private final SmeltTag smeltTag;

    public static /* synthetic */ WebCard copy$default(WebCard webCard, boolean z, boolean z2, SmeltResource smeltResource, SmeltUrl smeltUrl, SmeltTag smeltTag, int i, Object obj) {
        if ((i & 1) != 0) {
            z = webCard.hasSmelted;
        }
        if ((i & 2) != 0) {
            z2 = webCard.isSmeltCard;
        }
        boolean z3 = z2;
        if ((i & 4) != 0) {
            smeltResource = webCard.smeltResource;
        }
        SmeltResource smeltResource2 = smeltResource;
        if ((i & 8) != 0) {
            smeltUrl = webCard.smeltJump;
        }
        SmeltUrl smeltUrl2 = smeltUrl;
        if ((i & 16) != 0) {
            smeltTag = webCard.smeltTag;
        }
        return webCard.copy(z, z3, smeltResource2, smeltUrl2, smeltTag);
    }

    public final boolean component1() {
        return this.hasSmelted;
    }

    public final boolean component2() {
        return this.isSmeltCard;
    }

    public final SmeltResource component3() {
        return this.smeltResource;
    }

    public final SmeltUrl component4() {
        return this.smeltJump;
    }

    public final SmeltTag component5() {
        return this.smeltTag;
    }

    public final WebCard copy(boolean z, boolean z2, SmeltResource smeltResource, SmeltUrl smeltUrl, SmeltTag smeltTag) {
        Intrinsics.checkNotNullParameter(smeltResource, "smeltResource");
        Intrinsics.checkNotNullParameter(smeltUrl, "smeltJump");
        Intrinsics.checkNotNullParameter(smeltTag, "smeltTag");
        return new WebCard(z, z2, smeltResource, smeltUrl, smeltTag);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WebCard) {
            WebCard webCard = (WebCard) obj;
            return this.hasSmelted == webCard.hasSmelted && this.isSmeltCard == webCard.isSmeltCard && Intrinsics.areEqual(this.smeltResource, webCard.smeltResource) && Intrinsics.areEqual(this.smeltJump, webCard.smeltJump) && Intrinsics.areEqual(this.smeltTag, webCard.smeltTag);
        }
        return false;
    }

    public int hashCode() {
        return (((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasSmelted) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isSmeltCard)) * 31) + this.smeltResource.hashCode()) * 31) + this.smeltJump.hashCode()) * 31) + this.smeltTag.hashCode();
    }

    public String toString() {
        boolean z = this.hasSmelted;
        boolean z2 = this.isSmeltCard;
        SmeltResource smeltResource = this.smeltResource;
        SmeltUrl smeltUrl = this.smeltJump;
        return "WebCard(hasSmelted=" + z + ", isSmeltCard=" + z2 + ", smeltResource=" + smeltResource + ", smeltJump=" + smeltUrl + ", smeltTag=" + this.smeltTag + ")";
    }

    public WebCard(boolean hasSmelted, boolean isSmeltCard, SmeltResource smeltResource, SmeltUrl smeltJump, SmeltTag smeltTag) {
        Intrinsics.checkNotNullParameter(smeltResource, "smeltResource");
        Intrinsics.checkNotNullParameter(smeltJump, "smeltJump");
        Intrinsics.checkNotNullParameter(smeltTag, "smeltTag");
        this.hasSmelted = hasSmelted;
        this.isSmeltCard = isSmeltCard;
        this.smeltResource = smeltResource;
        this.smeltJump = smeltJump;
        this.smeltTag = smeltTag;
    }

    public final boolean getHasSmelted() {
        return this.hasSmelted;
    }

    public final boolean isSmeltCard() {
        return this.isSmeltCard;
    }

    public final SmeltResource getSmeltResource() {
        return this.smeltResource;
    }

    public final SmeltUrl getSmeltJump() {
        return this.smeltJump;
    }

    public final SmeltTag getSmeltTag() {
        return this.smeltTag;
    }

    /* compiled from: BiliDLCCardItem.kt */
    @Bson
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/WebCard$SmeltResource;", "", "dynamicImage", "", "staticImage", "cardImage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDynamicImage", "()Ljava/lang/String;", "getStaticImage", "getCardImage", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SmeltResource {
        public static final int $stable = 0;
        private final String cardImage;
        private final String dynamicImage;
        private final String staticImage;

        public static /* synthetic */ SmeltResource copy$default(SmeltResource smeltResource, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = smeltResource.dynamicImage;
            }
            if ((i & 2) != 0) {
                str2 = smeltResource.staticImage;
            }
            if ((i & 4) != 0) {
                str3 = smeltResource.cardImage;
            }
            return smeltResource.copy(str, str2, str3);
        }

        public final String component1() {
            return this.dynamicImage;
        }

        public final String component2() {
            return this.staticImage;
        }

        public final String component3() {
            return this.cardImage;
        }

        public final SmeltResource copy(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "dynamicImage");
            Intrinsics.checkNotNullParameter(str2, "staticImage");
            Intrinsics.checkNotNullParameter(str3, "cardImage");
            return new SmeltResource(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SmeltResource) {
                SmeltResource smeltResource = (SmeltResource) obj;
                return Intrinsics.areEqual(this.dynamicImage, smeltResource.dynamicImage) && Intrinsics.areEqual(this.staticImage, smeltResource.staticImage) && Intrinsics.areEqual(this.cardImage, smeltResource.cardImage);
            }
            return false;
        }

        public int hashCode() {
            return (((this.dynamicImage.hashCode() * 31) + this.staticImage.hashCode()) * 31) + this.cardImage.hashCode();
        }

        public String toString() {
            String str = this.dynamicImage;
            String str2 = this.staticImage;
            return "SmeltResource(dynamicImage=" + str + ", staticImage=" + str2 + ", cardImage=" + this.cardImage + ")";
        }

        public SmeltResource(String dynamicImage, String staticImage, String cardImage) {
            Intrinsics.checkNotNullParameter(dynamicImage, "dynamicImage");
            Intrinsics.checkNotNullParameter(staticImage, "staticImage");
            Intrinsics.checkNotNullParameter(cardImage, "cardImage");
            this.dynamicImage = dynamicImage;
            this.staticImage = staticImage;
            this.cardImage = cardImage;
        }

        public final String getDynamicImage() {
            return this.dynamicImage;
        }

        public final String getStaticImage() {
            return this.staticImage;
        }

        public final String getCardImage() {
            return this.cardImage;
        }
    }

    /* compiled from: BiliDLCCardItem.kt */
    @Bson
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/WebCard$SmeltTag;", "", "image", "", "<init>", "(Ljava/lang/String;)V", "getImage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SmeltTag {
        public static final int $stable = 0;
        private final String image;

        public static /* synthetic */ SmeltTag copy$default(SmeltTag smeltTag, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = smeltTag.image;
            }
            return smeltTag.copy(str);
        }

        public final String component1() {
            return this.image;
        }

        public final SmeltTag copy(String str) {
            Intrinsics.checkNotNullParameter(str, "image");
            return new SmeltTag(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SmeltTag) && Intrinsics.areEqual(this.image, ((SmeltTag) obj).image);
        }

        public int hashCode() {
            return this.image.hashCode();
        }

        public String toString() {
            return "SmeltTag(image=" + this.image + ")";
        }

        public SmeltTag(String image) {
            Intrinsics.checkNotNullParameter(image, "image");
            this.image = image;
        }

        public final String getImage() {
            return this.image;
        }
    }

    /* compiled from: BiliDLCCardItem.kt */
    @Bson
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/WebCard$SmeltUrl;", "", "reshapeUrl", "", "renderUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getReshapeUrl", "()Ljava/lang/String;", "getRenderUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SmeltUrl {
        public static final int $stable = 0;
        private final String renderUrl;
        private final String reshapeUrl;

        public static /* synthetic */ SmeltUrl copy$default(SmeltUrl smeltUrl, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = smeltUrl.reshapeUrl;
            }
            if ((i & 2) != 0) {
                str2 = smeltUrl.renderUrl;
            }
            return smeltUrl.copy(str, str2);
        }

        public final String component1() {
            return this.reshapeUrl;
        }

        public final String component2() {
            return this.renderUrl;
        }

        public final SmeltUrl copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "reshapeUrl");
            Intrinsics.checkNotNullParameter(str2, "renderUrl");
            return new SmeltUrl(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SmeltUrl) {
                SmeltUrl smeltUrl = (SmeltUrl) obj;
                return Intrinsics.areEqual(this.reshapeUrl, smeltUrl.reshapeUrl) && Intrinsics.areEqual(this.renderUrl, smeltUrl.renderUrl);
            }
            return false;
        }

        public int hashCode() {
            return (this.reshapeUrl.hashCode() * 31) + this.renderUrl.hashCode();
        }

        public String toString() {
            String str = this.reshapeUrl;
            return "SmeltUrl(reshapeUrl=" + str + ", renderUrl=" + this.renderUrl + ")";
        }

        public SmeltUrl(String reshapeUrl, String renderUrl) {
            Intrinsics.checkNotNullParameter(reshapeUrl, "reshapeUrl");
            Intrinsics.checkNotNullParameter(renderUrl, "renderUrl");
            this.reshapeUrl = reshapeUrl;
            this.renderUrl = renderUrl;
        }

        public final String getReshapeUrl() {
            return this.reshapeUrl;
        }

        public final String getRenderUrl() {
            return this.renderUrl;
        }
    }
}