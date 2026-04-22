package kntr.app.ad.ui.uikit.components;

import android.content.Context;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.core.content.ContextCompat;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.view.BiliImageView;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdNativeImage.android.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"AdNativeImage", RoomRecommendViewModel.EMPTY_CURSOR, "url", RoomRecommendViewModel.EMPTY_CURSOR, "size", "Landroidx/compose/ui/unit/Dp;", "corner", "placeholderRes", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "AdNativeImage-o3XDK20", "(Ljava/lang/String;FFILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "uikit_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdNativeImage_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdNativeImage_o3XDK20$lambda$1(String str, float f, float f2, int i, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        m485AdNativeImageo3XDK20(str, f, f2, i, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* renamed from: AdNativeImage-o3XDK20  reason: not valid java name */
    public static final void m485AdNativeImageo3XDK20(final String url, final float f, final float f2, final int placeholderRes, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(url, "url");
        Composer $composer2 = $composer.startRestartGroup(-27662267);
        ComposerKt.sourceInformation($composer2, "C(AdNativeImage)N(url,size:c#ui.unit.Dp,corner:c#ui.unit.Dp,placeholderRes,modifier)23@710L470,22@679L627:AdNativeImage.android.kt#oqm2gb");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(url) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(f) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(f2) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(placeholderRes) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if ((i & 16) != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-27662267, $dirty2, -1, "kntr.app.ad.ui.uikit.components.AdNativeImage (AdNativeImage.android.kt:21)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -813629413, "CC(remember):AdNativeImage.android.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 7168) == 2048) | (($dirty2 & 14) == 4);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.ad.ui.uikit.components.AdNativeImage_androidKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        BiliImageView AdNativeImage_o3XDK20$lambda$0$0;
                        AdNativeImage_o3XDK20$lambda$0$0 = AdNativeImage_androidKt.AdNativeImage_o3XDK20$lambda$0$0(placeholderRes, url, (Context) obj);
                        return AdNativeImage_o3XDK20$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AndroidView_androidKt.AndroidView((Function1) it$iv, ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, f), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(f2)), (Function1) null, $composer2, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.uikit.components.AdNativeImage_androidKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdNativeImage_o3XDK20$lambda$1;
                    AdNativeImage_o3XDK20$lambda$1 = AdNativeImage_androidKt.AdNativeImage_o3XDK20$lambda$1(url, f, f2, placeholderRes, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AdNativeImage_o3XDK20$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BiliImageView AdNativeImage_o3XDK20$lambda$0$0(int $placeholderRes, String $url, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BiliImageView it = new BiliImageView(context);
        ImageRequestBuilder with = BiliImageLoader.INSTANCE.with(context);
        ScaleType scaleType = ScaleType.FIT_CENTER;
        Intrinsics.checkNotNullExpressionValue(scaleType, "FIT_CENTER");
        ImageRequestBuilder.placeholderImageDrawable$default(ImageRequestBuilder.enableAutoPlayAnimation$default(with.actualImageScaleType(scaleType), true, false, 2, (Object) null).animationPlayEndlessLoop(true), ContextCompat.getDrawable(context, $placeholderRes), (ScaleType) null, 2, (Object) null).url($url).into(it);
        return it;
    }
}