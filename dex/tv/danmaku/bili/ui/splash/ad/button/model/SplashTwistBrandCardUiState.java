package tv.danmaku.bili.ui.splash.ad.button.model;

import android.graphics.drawable.Drawable;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: SplashTwistBrandCardUiState.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010$\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b%\u0010\u001aJ\u0010\u0010&\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b'\u0010\u001aJ\u0010\u0010(\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b)\u0010\u001aJ\u0010\u0010*\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b+\u0010\u001aJp\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b-\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\r\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001aR\u0013\u0010\u000e\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001e\u0010\u001a¨\u00065"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/button/model/SplashTwistBrandCardUiState;", "", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "desc", "topIcon", "Landroidx/compose/ui/graphics/ImageBitmap;", "bottomIcon", "descBgImage", "Landroid/graphics/drawable/Drawable;", "topHeight", "Landroidx/compose/ui/unit/Dp;", "bottomHeight", "topIconSize", "bottomIconSize", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/graphics/ImageBitmap;Landroid/graphics/drawable/Drawable;FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTitle", "()Ljava/lang/String;", "getDesc", "getTopIcon", "()Landroidx/compose/ui/graphics/ImageBitmap;", "getBottomIcon", "getDescBgImage", "()Landroid/graphics/drawable/Drawable;", "getTopHeight-D9Ej5fM", "()F", "F", "getBottomHeight-D9Ej5fM", "getTopIconSize-D9Ej5fM", "getBottomIconSize-D9Ej5fM", "component1", "component2", "component3", "component4", "component5", "component6", "component6-D9Ej5fM", "component7", "component7-D9Ej5fM", "component8", "component8-D9Ej5fM", "component9", "component9-D9Ej5fM", "copy", "copy-sVvNISY", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/graphics/ImageBitmap;Landroid/graphics/drawable/Drawable;FFFF)Ltv/danmaku/bili/ui/splash/ad/button/model/SplashTwistBrandCardUiState;", "equals", "", "other", "hashCode", "", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashTwistBrandCardUiState {
    public static final int $stable = 0;
    private final float bottomHeight;
    private final ImageBitmap bottomIcon;
    private final float bottomIconSize;
    private final String desc;
    private final Drawable descBgImage;
    private final String title;
    private final float topHeight;
    private final ImageBitmap topIcon;
    private final float topIconSize;

    public /* synthetic */ SplashTwistBrandCardUiState(String str, String str2, ImageBitmap imageBitmap, ImageBitmap imageBitmap2, Drawable drawable, float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, imageBitmap, imageBitmap2, drawable, f, f2, f3, f4);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.desc;
    }

    public final ImageBitmap component3() {
        return this.topIcon;
    }

    public final ImageBitmap component4() {
        return this.bottomIcon;
    }

    public final Drawable component5() {
        return this.descBgImage;
    }

    /* renamed from: component6-D9Ej5fM  reason: not valid java name */
    public final float m1484component6D9Ej5fM() {
        return this.topHeight;
    }

    /* renamed from: component7-D9Ej5fM  reason: not valid java name */
    public final float m1485component7D9Ej5fM() {
        return this.bottomHeight;
    }

    /* renamed from: component8-D9Ej5fM  reason: not valid java name */
    public final float m1486component8D9Ej5fM() {
        return this.topIconSize;
    }

    /* renamed from: component9-D9Ej5fM  reason: not valid java name */
    public final float m1487component9D9Ej5fM() {
        return this.bottomIconSize;
    }

    /* renamed from: copy-sVvNISY  reason: not valid java name */
    public final SplashTwistBrandCardUiState m1488copysVvNISY(String str, String str2, ImageBitmap imageBitmap, ImageBitmap imageBitmap2, Drawable drawable, float f, float f2, float f3, float f4) {
        Intrinsics.checkNotNullParameter(str, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(str2, "desc");
        return new SplashTwistBrandCardUiState(str, str2, imageBitmap, imageBitmap2, drawable, f, f2, f3, f4, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashTwistBrandCardUiState) {
            SplashTwistBrandCardUiState splashTwistBrandCardUiState = (SplashTwistBrandCardUiState) obj;
            return Intrinsics.areEqual(this.title, splashTwistBrandCardUiState.title) && Intrinsics.areEqual(this.desc, splashTwistBrandCardUiState.desc) && Intrinsics.areEqual(this.topIcon, splashTwistBrandCardUiState.topIcon) && Intrinsics.areEqual(this.bottomIcon, splashTwistBrandCardUiState.bottomIcon) && Intrinsics.areEqual(this.descBgImage, splashTwistBrandCardUiState.descBgImage) && Dp.equals-impl0(this.topHeight, splashTwistBrandCardUiState.topHeight) && Dp.equals-impl0(this.bottomHeight, splashTwistBrandCardUiState.bottomHeight) && Dp.equals-impl0(this.topIconSize, splashTwistBrandCardUiState.topIconSize) && Dp.equals-impl0(this.bottomIconSize, splashTwistBrandCardUiState.bottomIconSize);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.title.hashCode() * 31) + this.desc.hashCode()) * 31) + (this.topIcon == null ? 0 : this.topIcon.hashCode())) * 31) + (this.bottomIcon == null ? 0 : this.bottomIcon.hashCode())) * 31) + (this.descBgImage != null ? this.descBgImage.hashCode() : 0)) * 31) + Dp.hashCode-impl(this.topHeight)) * 31) + Dp.hashCode-impl(this.bottomHeight)) * 31) + Dp.hashCode-impl(this.topIconSize)) * 31) + Dp.hashCode-impl(this.bottomIconSize);
    }

    public String toString() {
        String str = this.title;
        String str2 = this.desc;
        ImageBitmap imageBitmap = this.topIcon;
        ImageBitmap imageBitmap2 = this.bottomIcon;
        Drawable drawable = this.descBgImage;
        String str3 = Dp.toString-impl(this.topHeight);
        String str4 = Dp.toString-impl(this.bottomHeight);
        String str5 = Dp.toString-impl(this.topIconSize);
        return "SplashTwistBrandCardUiState(title=" + str + ", desc=" + str2 + ", topIcon=" + imageBitmap + ", bottomIcon=" + imageBitmap2 + ", descBgImage=" + drawable + ", topHeight=" + str3 + ", bottomHeight=" + str4 + ", topIconSize=" + str5 + ", bottomIconSize=" + Dp.toString-impl(this.bottomIconSize) + ")";
    }

    private SplashTwistBrandCardUiState(String title, String desc, ImageBitmap topIcon, ImageBitmap bottomIcon, Drawable descBgImage, float topHeight, float bottomHeight, float topIconSize, float bottomIconSize) {
        Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.title = title;
        this.desc = desc;
        this.topIcon = topIcon;
        this.bottomIcon = bottomIcon;
        this.descBgImage = descBgImage;
        this.topHeight = topHeight;
        this.bottomHeight = bottomHeight;
        this.topIconSize = topIconSize;
        this.bottomIconSize = bottomIconSize;
    }

    public /* synthetic */ SplashTwistBrandCardUiState(String str, String str2, ImageBitmap imageBitmap, ImageBitmap imageBitmap2, Drawable drawable, float f, float f2, float f3, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) == 0 ? str2 : "", (i & 4) != 0 ? null : imageBitmap, (i & 8) != 0 ? null : imageBitmap2, (i & 16) == 0 ? drawable : null, (i & 32) != 0 ? Dp.constructor-impl(50) : f, (i & 64) != 0 ? Dp.constructor-impl(72) : f2, (i & 128) != 0 ? Dp.constructor-impl(32) : f3, (i & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? Dp.constructor-impl(52) : f4, null);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final ImageBitmap getTopIcon() {
        return this.topIcon;
    }

    public final ImageBitmap getBottomIcon() {
        return this.bottomIcon;
    }

    public final Drawable getDescBgImage() {
        return this.descBgImage;
    }

    /* renamed from: getTopHeight-D9Ej5fM  reason: not valid java name */
    public final float m1491getTopHeightD9Ej5fM() {
        return this.topHeight;
    }

    /* renamed from: getBottomHeight-D9Ej5fM  reason: not valid java name */
    public final float m1489getBottomHeightD9Ej5fM() {
        return this.bottomHeight;
    }

    /* renamed from: getTopIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1492getTopIconSizeD9Ej5fM() {
        return this.topIconSize;
    }

    /* renamed from: getBottomIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1490getBottomIconSizeD9Ej5fM() {
        return this.bottomIconSize;
    }
}