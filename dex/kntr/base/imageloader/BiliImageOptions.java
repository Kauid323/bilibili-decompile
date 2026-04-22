package kntr.base.imageloader;

import BottomSheetItemData$;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.AnimateStrategy;
import kntr.base.imageloader.cache.CachePolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BiliImageOptions.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u0010\u00103\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b4\u0010\u001dJ\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\nHÆ\u0003J\t\u00109\u001a\u00020\fHÆ\u0003J\u0010\u0010:\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b;\u0010'J\u000b\u0010<\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010=\u001a\u00020\u0012HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u0010?\u001a\u00020\u0016HÆ\u0003J\t\u0010@\u001a\u00020\u0016HÆ\u0003J\u0096\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0016HÆ\u0001¢\u0006\u0004\bB\u0010CJ\u0013\u0010D\u001a\u00020\u00032\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010F\u001a\u00020GHÖ\u0001J\t\u0010H\u001a\u00020IHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\r\u001a\u00020\u000e¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0017\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b1\u00100¨\u0006J"}, d2 = {"Lkntr/base/imageloader/BiliImageOptions;", "", "enableAnimate", "", "animateLoopCount", "Lkntr/base/imageloader/LoopCount;", "autoPlay", "useRaw", "useOrigin", "align", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "Lkntr/base/imageloader/Alpha;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "animateStrategy", "Lkntr/base/imageloader/AnimateStrategy;", "resizeOption", "Lkntr/base/imageloader/ResizeOption;", "memoryCachePolicy", "Lkntr/base/imageloader/cache/CachePolicy;", "diskCachePolicy", "<init>", "(ZIZZZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Lkntr/base/imageloader/AnimateStrategy;Lkntr/base/imageloader/ResizeOption;Lkntr/base/imageloader/cache/CachePolicy;Lkntr/base/imageloader/cache/CachePolicy;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEnableAnimate", "()Z", "getAnimateLoopCount--v08q-k", "()I", "I", "getAutoPlay", "getUseRaw", "getUseOrigin", "getAlign", "()Landroidx/compose/ui/Alignment;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getAlpha-_AzBSks", "()F", "F", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "getAnimateStrategy", "()Lkntr/base/imageloader/AnimateStrategy;", "getResizeOption", "()Lkntr/base/imageloader/ResizeOption;", "getMemoryCachePolicy", "()Lkntr/base/imageloader/cache/CachePolicy;", "getDiskCachePolicy", "component1", "component2", "component2--v08q-k", "component3", "component4", "component5", "component6", "component7", "component8", "component8-_AzBSks", "component9", "component10", "component11", "component12", "component13", "copy", "copy-SsDZD_g", "(ZIZZZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Lkntr/base/imageloader/AnimateStrategy;Lkntr/base/imageloader/ResizeOption;Lkntr/base/imageloader/cache/CachePolicy;Lkntr/base/imageloader/cache/CachePolicy;)Lkntr/base/imageloader/BiliImageOptions;", "equals", "other", "hashCode", "", "toString", "", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BiliImageOptions {
    public static final int $stable = 0;
    private final Alignment align;
    private final float alpha;
    private final int animateLoopCount;
    private final AnimateStrategy animateStrategy;
    private final boolean autoPlay;
    private final ColorFilter colorFilter;
    private final ContentScale contentScale;
    private final CachePolicy diskCachePolicy;
    private final boolean enableAnimate;
    private final CachePolicy memoryCachePolicy;
    private final ResizeOption resizeOption;
    private final boolean useOrigin;
    private final boolean useRaw;

    public /* synthetic */ BiliImageOptions(boolean z, int i, boolean z2, boolean z3, boolean z4, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, AnimateStrategy animateStrategy, ResizeOption resizeOption, CachePolicy cachePolicy, CachePolicy cachePolicy2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, z2, z3, z4, alignment, contentScale, f, colorFilter, animateStrategy, resizeOption, cachePolicy, cachePolicy2);
    }

    /* renamed from: copy-SsDZD_g$default */
    public static /* synthetic */ BiliImageOptions m1431copySsDZD_g$default(BiliImageOptions biliImageOptions, boolean z, int i, boolean z2, boolean z3, boolean z4, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, AnimateStrategy animateStrategy, ResizeOption resizeOption, CachePolicy cachePolicy, CachePolicy cachePolicy2, int i2, Object obj) {
        return biliImageOptions.m1434copySsDZD_g((i2 & 1) != 0 ? biliImageOptions.enableAnimate : z, (i2 & 2) != 0 ? biliImageOptions.animateLoopCount : i, (i2 & 4) != 0 ? biliImageOptions.autoPlay : z2, (i2 & 8) != 0 ? biliImageOptions.useRaw : z3, (i2 & 16) != 0 ? biliImageOptions.useOrigin : z4, (i2 & 32) != 0 ? biliImageOptions.align : alignment, (i2 & 64) != 0 ? biliImageOptions.contentScale : contentScale, (i2 & 128) != 0 ? biliImageOptions.alpha : f, (i2 & 256) != 0 ? biliImageOptions.colorFilter : colorFilter, (i2 & 512) != 0 ? biliImageOptions.animateStrategy : animateStrategy, (i2 & 1024) != 0 ? biliImageOptions.resizeOption : resizeOption, (i2 & 2048) != 0 ? biliImageOptions.memoryCachePolicy : cachePolicy, (i2 & 4096) != 0 ? biliImageOptions.diskCachePolicy : cachePolicy2);
    }

    public final boolean component1() {
        return this.enableAnimate;
    }

    public final AnimateStrategy component10() {
        return this.animateStrategy;
    }

    public final ResizeOption component11() {
        return this.resizeOption;
    }

    public final CachePolicy component12() {
        return this.memoryCachePolicy;
    }

    public final CachePolicy component13() {
        return this.diskCachePolicy;
    }

    /* renamed from: component2--v08q-k */
    public final int m1432component2v08qk() {
        return this.animateLoopCount;
    }

    public final boolean component3() {
        return this.autoPlay;
    }

    public final boolean component4() {
        return this.useRaw;
    }

    public final boolean component5() {
        return this.useOrigin;
    }

    public final Alignment component6() {
        return this.align;
    }

    public final ContentScale component7() {
        return this.contentScale;
    }

    /* renamed from: component8-_AzBSks */
    public final float m1433component8_AzBSks() {
        return this.alpha;
    }

    public final ColorFilter component9() {
        return this.colorFilter;
    }

    /* renamed from: copy-SsDZD_g */
    public final BiliImageOptions m1434copySsDZD_g(boolean z, int i, boolean z2, boolean z3, boolean z4, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, AnimateStrategy animateStrategy, ResizeOption resizeOption, CachePolicy cachePolicy, CachePolicy cachePolicy2) {
        Intrinsics.checkNotNullParameter(alignment, "align");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(animateStrategy, "animateStrategy");
        Intrinsics.checkNotNullParameter(cachePolicy, "memoryCachePolicy");
        Intrinsics.checkNotNullParameter(cachePolicy2, "diskCachePolicy");
        return new BiliImageOptions(z, i, z2, z3, z4, alignment, contentScale, f, colorFilter, animateStrategy, resizeOption, cachePolicy, cachePolicy2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BiliImageOptions) {
            BiliImageOptions biliImageOptions = (BiliImageOptions) obj;
            return this.enableAnimate == biliImageOptions.enableAnimate && LoopCount.m1497equalsimpl0(this.animateLoopCount, biliImageOptions.animateLoopCount) && this.autoPlay == biliImageOptions.autoPlay && this.useRaw == biliImageOptions.useRaw && this.useOrigin == biliImageOptions.useOrigin && Intrinsics.areEqual(this.align, biliImageOptions.align) && Intrinsics.areEqual(this.contentScale, biliImageOptions.contentScale) && Alpha.m1403equalsimpl0(this.alpha, biliImageOptions.alpha) && Intrinsics.areEqual(this.colorFilter, biliImageOptions.colorFilter) && Intrinsics.areEqual(this.animateStrategy, biliImageOptions.animateStrategy) && Intrinsics.areEqual(this.resizeOption, biliImageOptions.resizeOption) && this.memoryCachePolicy == biliImageOptions.memoryCachePolicy && this.diskCachePolicy == biliImageOptions.diskCachePolicy;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableAnimate) * 31) + LoopCount.m1498hashCodeimpl(this.animateLoopCount)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.autoPlay)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.useRaw)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.useOrigin)) * 31) + this.align.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Alpha.m1404hashCodeimpl(this.alpha)) * 31) + (this.colorFilter == null ? 0 : this.colorFilter.hashCode())) * 31) + this.animateStrategy.hashCode()) * 31) + (this.resizeOption != null ? this.resizeOption.hashCode() : 0)) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode();
    }

    public String toString() {
        boolean z = this.enableAnimate;
        String m1499toStringimpl = LoopCount.m1499toStringimpl(this.animateLoopCount);
        boolean z2 = this.autoPlay;
        boolean z3 = this.useRaw;
        boolean z4 = this.useOrigin;
        Alignment alignment = this.align;
        ContentScale contentScale = this.contentScale;
        String m1405toStringimpl = Alpha.m1405toStringimpl(this.alpha);
        ColorFilter colorFilter = this.colorFilter;
        AnimateStrategy animateStrategy = this.animateStrategy;
        ResizeOption resizeOption = this.resizeOption;
        CachePolicy cachePolicy = this.memoryCachePolicy;
        return "BiliImageOptions(enableAnimate=" + z + ", animateLoopCount=" + m1499toStringimpl + ", autoPlay=" + z2 + ", useRaw=" + z3 + ", useOrigin=" + z4 + ", align=" + alignment + ", contentScale=" + contentScale + ", alpha=" + m1405toStringimpl + ", colorFilter=" + colorFilter + ", animateStrategy=" + animateStrategy + ", resizeOption=" + resizeOption + ", memoryCachePolicy=" + cachePolicy + ", diskCachePolicy=" + this.diskCachePolicy + ")";
    }

    private BiliImageOptions(boolean enableAnimate, int animateLoopCount, boolean autoPlay, boolean useRaw, boolean useOrigin, Alignment align, ContentScale contentScale, float alpha, ColorFilter colorFilter, AnimateStrategy animateStrategy, ResizeOption resizeOption, CachePolicy memoryCachePolicy, CachePolicy diskCachePolicy) {
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(animateStrategy, "animateStrategy");
        Intrinsics.checkNotNullParameter(memoryCachePolicy, "memoryCachePolicy");
        Intrinsics.checkNotNullParameter(diskCachePolicy, "diskCachePolicy");
        this.enableAnimate = enableAnimate;
        this.animateLoopCount = animateLoopCount;
        this.autoPlay = autoPlay;
        this.useRaw = useRaw;
        this.useOrigin = useOrigin;
        this.align = align;
        this.contentScale = contentScale;
        this.alpha = alpha;
        this.colorFilter = colorFilter;
        this.animateStrategy = animateStrategy;
        this.resizeOption = resizeOption;
        this.memoryCachePolicy = memoryCachePolicy;
        this.diskCachePolicy = diskCachePolicy;
    }

    public /* synthetic */ BiliImageOptions(boolean z, int i, boolean z2, boolean z3, boolean z4, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, AnimateStrategy animateStrategy, ResizeOption resizeOption, CachePolicy cachePolicy, CachePolicy cachePolicy2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? LoopCount.Companion.m1501getINFINITEv08qk() : i, (i2 & 4) == 0 ? z2 : true, (i2 & 8) != 0 ? false : z3, (i2 & 16) == 0 ? z4 : false, (i2 & 32) != 0 ? Alignment.Companion.getCenter() : alignment, (i2 & 64) != 0 ? ContentScale.Companion.getCrop() : contentScale, (i2 & 128) != 0 ? Alpha.Companion.m1407getUNSET_AzBSks() : f, (i2 & 256) != 0 ? null : colorFilter, (i2 & 512) != 0 ? AnimateStrategy.Balance.INSTANCE : animateStrategy, (i2 & 1024) == 0 ? resizeOption : null, (i2 & 2048) != 0 ? CachePolicy.ENABLED : cachePolicy, (i2 & 4096) != 0 ? CachePolicy.ENABLED : cachePolicy2, null);
    }

    public final boolean getEnableAnimate() {
        return this.enableAnimate;
    }

    /* renamed from: getAnimateLoopCount--v08q-k */
    public final int m1436getAnimateLoopCountv08qk() {
        return this.animateLoopCount;
    }

    public final boolean getAutoPlay() {
        return this.autoPlay;
    }

    public final boolean getUseRaw() {
        return this.useRaw;
    }

    public final boolean getUseOrigin() {
        return this.useOrigin;
    }

    public final Alignment getAlign() {
        return this.align;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    /* renamed from: getAlpha-_AzBSks */
    public final float m1435getAlpha_AzBSks() {
        return this.alpha;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final AnimateStrategy getAnimateStrategy() {
        return this.animateStrategy;
    }

    public final ResizeOption getResizeOption() {
        return this.resizeOption;
    }

    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }
}