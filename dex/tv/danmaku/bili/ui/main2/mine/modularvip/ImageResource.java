package tv.danmaku.bili.ui.main2.mine.modularvip;

import android.content.Context;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: MineVipModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/ImageResource;", "", "imageInLight", "", "imageInNight", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getImageInLight", "()Ljava/lang/String;", "getImageInNight", "getResource", "context", "Landroid/content/Context;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ImageResource {
    public static final int $stable = 0;
    private final String imageInLight;
    private final String imageInNight;

    public static /* synthetic */ ImageResource copy$default(ImageResource imageResource, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageResource.imageInLight;
        }
        if ((i & 2) != 0) {
            str2 = imageResource.imageInNight;
        }
        return imageResource.copy(str, str2);
    }

    public final String component1() {
        return this.imageInLight;
    }

    public final String component2() {
        return this.imageInNight;
    }

    public final ImageResource copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "imageInLight");
        Intrinsics.checkNotNullParameter(str2, "imageInNight");
        return new ImageResource(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImageResource) {
            ImageResource imageResource = (ImageResource) obj;
            return Intrinsics.areEqual(this.imageInLight, imageResource.imageInLight) && Intrinsics.areEqual(this.imageInNight, imageResource.imageInNight);
        }
        return false;
    }

    public int hashCode() {
        return (this.imageInLight.hashCode() * 31) + this.imageInNight.hashCode();
    }

    public String toString() {
        String str = this.imageInLight;
        return "ImageResource(imageInLight=" + str + ", imageInNight=" + this.imageInNight + ")";
    }

    public ImageResource(String imageInLight, String imageInNight) {
        Intrinsics.checkNotNullParameter(imageInLight, "imageInLight");
        Intrinsics.checkNotNullParameter(imageInNight, "imageInNight");
        this.imageInLight = imageInLight;
        this.imageInNight = imageInNight;
    }

    public final String getImageInLight() {
        return this.imageInLight;
    }

    public final String getImageInNight() {
        return this.imageInNight;
    }

    public final String getResource(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Garb garb = GarbManager.getGarbWithNightMode(context);
        return garb.isNightTheme(context) ? this.imageInNight : this.imageInLight;
    }
}