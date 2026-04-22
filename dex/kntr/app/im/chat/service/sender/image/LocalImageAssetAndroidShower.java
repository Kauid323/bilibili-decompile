package kntr.app.im.chat.service.sender.image;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.lifecycle.Lifecycle;
import java.util.Set;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.AnimateStrategy;
import kntr.base.imageloader.BiliImageOptions;
import kntr.base.imageloader.BiliImagePainterKt;
import kntr.base.imageloader.BiliImage_androidKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImageSource;
import kntr.base.imageloader.Pixel;
import kntr.base.imageloader.ResizeOption;
import kntr.base.imageloader.cache.CachePolicy;
import kntr.common.photonic.Asset;
import kntr.common.photonic.Resolution;
import kntr.common.photonic.shower.AssetShower;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: LocalImageAsset.android.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0017¢\u0006\u0002\u0010\u0016R\"\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00070\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lkntr/app/im/chat/service/sender/image/LocalImageAssetAndroidShower;", "Lkntr/common/photonic/shower/AssetShower;", "Lkntr/app/im/chat/service/sender/image/LocalImageAsset;", "<init>", "()V", "acceptType", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/reflect/KClass;", "getAcceptType", "()Ljava/util/Set;", "getImageSource", "Lkntr/base/imageloader/ImageSource;", "asset", "expectResolution", "Lkntr/common/photonic/Resolution;", "animated", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/im/chat/service/sender/image/LocalImageAsset;Lkntr/common/photonic/Resolution;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Content", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/im/chat/service/sender/image/LocalImageAsset;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;I)V", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LocalImageAssetAndroidShower implements AssetShower<LocalImageAsset> {
    public static final int $stable = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$1(LocalImageAssetAndroidShower localImageAssetAndroidShower, LocalImageAsset localImageAsset, Modifier modifier, boolean z, int i, Composer composer, int i2) {
        localImageAssetAndroidShower.Content(localImageAsset, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public /* bridge */ /* synthetic */ Object getImageSource(Asset asset, Resolution expectResolution, boolean animated, Continuation $completion) {
        return getImageSource((LocalImageAsset) asset, expectResolution, animated, (Continuation<? super ImageSource>) $completion);
    }

    public Set<KClass<? extends LocalImageAsset>> getAcceptType() {
        return SetsKt.setOf(Reflection.getOrCreateKotlinClass(LocalImageAsset.class));
    }

    public Object getImageSource(LocalImageAsset asset, Resolution expectResolution, boolean animated, Continuation<? super ImageSource> continuation) {
        String $this$asRequest$iv = LocalImageAsset_androidKt.imagePathForDisplay(asset);
        ImageRequest $this$getImageSource_u24lambda_u240 = new ImageRequest($this$asRequest$iv);
        $this$getImageSource_u24lambda_u240.autoPlay(animated);
        if (expectResolution != null && !Intrinsics.areEqual(expectResolution, Resolution.Companion.getZero())) {
            $this$getImageSource_u24lambda_u240.resizeOption(ResizeOption.Companion.getAUTO());
            $this$getImageSource_u24lambda_u240.requestWidth-3VbuI34(Pixel.constructor-impl(expectResolution.getWidthPx()));
            $this$getImageSource_u24lambda_u240.requestHeight-3VbuI34(Pixel.constructor-impl(expectResolution.getHeightPx()));
        }
        return BiliImage_androidKt.loadImage$default($this$getImageSource_u24lambda_u240.build(), (Lifecycle) null, continuation, 2, (Object) null);
    }

    public void Content(final LocalImageAsset asset, final Modifier modifier, final boolean animated, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer $composer2 = $composer.startRestartGroup(-1759346059);
        ComposerKt.sourceInformation($composer2, "C(Content)N(asset,modifier,animated)118@4469L1062,118@4440L1091:LocalImageAsset.android.kt#yyg2hr");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(asset) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(animated) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(this) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1759346059, $dirty2, -1, "kntr.app.im.chat.service.sender.image.LocalImageAssetAndroidShower.Content (LocalImageAsset.android.kt:117)");
            }
            BoxWithConstraintsKt.BoxWithConstraints(modifier, (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(-1690695457, true, new Function3() { // from class: kntr.app.im.chat.service.sender.image.LocalImageAssetAndroidShower$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit Content$lambda$0;
                    Content$lambda$0 = LocalImageAssetAndroidShower.Content$lambda$0(LocalImageAsset.this, this, animated, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return Content$lambda$0;
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 3) & 14) | 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.service.sender.image.LocalImageAssetAndroidShower$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$1;
                    Content$lambda$1 = LocalImageAssetAndroidShower.Content$lambda$1(LocalImageAssetAndroidShower.this, asset, modifier, animated, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0(LocalImageAsset $asset, LocalImageAssetAndroidShower this$0, boolean $animated, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C119@4501L47,120@4583L585,120@4561L607,135@5195L95:LocalImageAsset.android.kt#yyg2hr");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1690695457, $dirty2, -1, "kntr.app.im.chat.service.sender.image.LocalImageAssetAndroidShower.Content.<anonymous> (LocalImageAsset.android.kt:119)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1260695218, "CC(remember):LocalImageAsset.android.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableState imageSource = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1260692056, "CC(remember):LocalImageAsset.android.kt#9igjgp");
            boolean invalid$iv = $composer.changed(this$0) | $composer.changed($asset) | (($dirty2 & 14) == 4) | $composer.changed($animated);
            Object value$iv2 = $composer.rememberedValue();
            if (invalid$iv || value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = new LocalImageAssetAndroidShower$Content$1$1$1(imageSource, this$0, $asset, $this$BoxWithConstraints, $animated, null);
                $composer.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect($asset, (Function2) value$iv2, $composer, 0);
            Painter painter = BiliImagePainterKt.rememberBiliImagePainter((ImageSource) imageSource.getValue(), new BiliImageOptions(false, 0, false, false, false, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, (AnimateStrategy) null, ResizeOption.Companion.getAUTO(), (CachePolicy) null, (CachePolicy) null, 7167, (DefaultConstructorMarker) null), $composer, 0);
            if (painter != null) {
                $composer.startReplaceGroup(-426008162);
                ComposerKt.sourceInformation($composer, "137@5342L165");
                ImageKt.Image(painter, (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 432, 120);
            } else {
                $composer.startReplaceGroup(-431313533);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}