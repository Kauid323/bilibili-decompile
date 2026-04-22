package tv.danmaku.bili.ui.main2.mine.modularvip;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: MineVipModel.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;", "", "colorInLight", "", "colorInNight", "<init>", "(JJ)V", "getColorInLight", "()J", "getColorInNight", "getColorInt", "", "context", "Landroid/content/Context;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ColorResource {
    public static final int $stable = 0;
    private final long colorInLight;
    private final long colorInNight;

    public static /* synthetic */ ColorResource copy$default(ColorResource colorResource, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = colorResource.colorInLight;
        }
        if ((i & 2) != 0) {
            j2 = colorResource.colorInNight;
        }
        return colorResource.copy(j, j2);
    }

    public final long component1() {
        return this.colorInLight;
    }

    public final long component2() {
        return this.colorInNight;
    }

    public final ColorResource copy(long j, long j2) {
        return new ColorResource(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ColorResource) {
            ColorResource colorResource = (ColorResource) obj;
            return this.colorInLight == colorResource.colorInLight && this.colorInNight == colorResource.colorInNight;
        }
        return false;
    }

    public int hashCode() {
        return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.colorInLight) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.colorInNight);
    }

    public String toString() {
        long j = this.colorInLight;
        return "ColorResource(colorInLight=" + j + ", colorInNight=" + this.colorInNight + ")";
    }

    public ColorResource(long colorInLight, long colorInNight) {
        this.colorInLight = colorInLight;
        this.colorInNight = colorInNight;
    }

    public final long getColorInLight() {
        return this.colorInLight;
    }

    public final long getColorInNight() {
        return this.colorInNight;
    }

    public final int getColorInt(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Garb garb = GarbManager.getGarbWithNightMode(context);
        return (int) (garb.isNightTheme(context) ? this.colorInNight : this.colorInLight);
    }
}