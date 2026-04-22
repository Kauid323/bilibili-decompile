package tv.danmaku.bili.ui.garb.api;

import com.bilibili.app.authorspace.api.BiliNftImage;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BiliDLCCardItem.kt */
@Bson
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/Content;", "", "image", "Lcom/bilibili/app/authorspace/api/BiliNftImage;", "animation", "Ltv/danmaku/bili/ui/garb/api/Animation;", "<init>", "(Lcom/bilibili/app/authorspace/api/BiliNftImage;Ltv/danmaku/bili/ui/garb/api/Animation;)V", "getImage", "()Lcom/bilibili/app/authorspace/api/BiliNftImage;", "getAnimation", "()Ltv/danmaku/bili/ui/garb/api/Animation;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Content {
    public static final int $stable = 8;
    @SerializedName("animation")
    private final Animation animation;
    @SerializedName("image")
    private final BiliNftImage image;

    public static /* synthetic */ Content copy$default(Content content, BiliNftImage biliNftImage, Animation animation, int i, Object obj) {
        if ((i & 1) != 0) {
            biliNftImage = content.image;
        }
        if ((i & 2) != 0) {
            animation = content.animation;
        }
        return content.copy(biliNftImage, animation);
    }

    public final BiliNftImage component1() {
        return this.image;
    }

    public final Animation component2() {
        return this.animation;
    }

    public final Content copy(BiliNftImage biliNftImage, Animation animation) {
        Intrinsics.checkNotNullParameter(biliNftImage, "image");
        Intrinsics.checkNotNullParameter(animation, "animation");
        return new Content(biliNftImage, animation);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Content) {
            Content content = (Content) obj;
            return Intrinsics.areEqual(this.image, content.image) && Intrinsics.areEqual(this.animation, content.animation);
        }
        return false;
    }

    public int hashCode() {
        return (this.image.hashCode() * 31) + this.animation.hashCode();
    }

    public String toString() {
        BiliNftImage biliNftImage = this.image;
        return "Content(image=" + biliNftImage + ", animation=" + this.animation + ")";
    }

    public Content(BiliNftImage image, Animation animation) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.image = image;
        this.animation = animation;
    }

    public final BiliNftImage getImage() {
        return this.image;
    }

    public final Animation getAnimation() {
        return this.animation;
    }
}