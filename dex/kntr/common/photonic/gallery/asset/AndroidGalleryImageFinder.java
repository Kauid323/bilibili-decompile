package kntr.common.photonic.gallery.asset;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.AnimateStrategy;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.BiliImage_androidKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImageSource;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.imageloader.Pixel;
import kntr.base.imageloader.ResizeOption;
import kntr.common.photonic.Resolution;
import kntr.common.photonic.finder.AssetFinder;
import kntr.common.photonic.gallery.entity.AndroidImage;
import kntr.common.photonic.gallery.internal.AndroidImageGallery;
import kntr.common.photonic.shower.AssetShower;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.JobKt;

/* compiled from: AndroidGalleryImageFinder.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J*\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0017H\u0017¢\u0006\u0002\u0010\u001dR\"\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\b0\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u001e"}, d2 = {"Lkntr/common/photonic/gallery/asset/AndroidGalleryImageFinder;", "Lkntr/common/photonic/finder/AssetFinder;", "Lkntr/common/photonic/gallery/entity/AndroidImage;", "Lkntr/common/photonic/shower/AssetShower;", "<init>", "()V", "acceptType", "", "Lkotlin/reflect/KClass;", "getAcceptType", "()Ljava/util/Set;", "findAssetByIdentifier", "Lkotlin/Result;", "identifier", "", "findAssetByIdentifier-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageSource", "Lkntr/base/imageloader/ImageSource;", "asset", "expectResolution", "Lkntr/common/photonic/Resolution;", "animated", "", "(Lkntr/common/photonic/gallery/entity/AndroidImage;Lkntr/common/photonic/Resolution;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Content", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/common/photonic/gallery/entity/AndroidImage;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;I)V", "gallery_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AndroidGalleryImageFinder implements AssetFinder<AndroidImage>, AssetShower<AndroidImage> {
    public static final int $stable = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$2(AndroidGalleryImageFinder androidGalleryImageFinder, AndroidImage androidImage, Modifier modifier, boolean z, int i, Composer composer, int i2) {
        androidGalleryImageFinder.Content(androidImage, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    @Override // kntr.common.photonic.shower.AssetShower
    public /* bridge */ /* synthetic */ Object getImageSource(AndroidImage androidImage, Resolution expectResolution, boolean animated, Continuation $completion) {
        return getImageSource2(androidImage, expectResolution, animated, (Continuation<? super ImageSource>) $completion);
    }

    @Override // kntr.common.photonic.finder.AssetFinder, kntr.common.photonic.shower.AssetShower
    public Set<KClass<? extends AndroidImage>> getAcceptType() {
        return SetsKt.setOf(Reflection.getOrCreateKotlinClass(AndroidImage.class));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|8|15|(3:17|18|19)(2:20|21)))|29|6|7|8|15|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0077, code lost:
        r4 = kotlin.Result.Companion;
        r2 = kotlin.Result.m2636constructorimpl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0058 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:13:0x0035, B:20:0x0054, B:22:0x0058, B:23:0x005d, B:24:0x0075, B:16:0x003e), top: B:29:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005d A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:13:0x0035, B:20:0x0054, B:22:0x0058, B:23:0x005d, B:24:0x0075, B:16:0x003e), top: B:29:0x0021 }] */
    @Override // kntr.common.photonic.finder.AssetFinder
    /* renamed from: findAssetByIdentifier-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo2332findAssetByIdentifiergIAlus(String identifier, Continuation<? super Result<? extends AndroidImage>> continuation) {
        AndroidGalleryImageFinder$findAssetByIdentifier$1 androidGalleryImageFinder$findAssetByIdentifier$1;
        Object loadAssetWithContentUri;
        AndroidImage androidImage;
        if (continuation instanceof AndroidGalleryImageFinder$findAssetByIdentifier$1) {
            androidGalleryImageFinder$findAssetByIdentifier$1 = (AndroidGalleryImageFinder$findAssetByIdentifier$1) continuation;
            if ((androidGalleryImageFinder$findAssetByIdentifier$1.label & Integer.MIN_VALUE) != 0) {
                androidGalleryImageFinder$findAssetByIdentifier$1.label -= Integer.MIN_VALUE;
                Object $result = androidGalleryImageFinder$findAssetByIdentifier$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (androidGalleryImageFinder$findAssetByIdentifier$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Result.Companion companion = Result.Companion;
                        AndroidImageGallery androidImageGallery = AndroidImageGallery.INSTANCE;
                        androidGalleryImageFinder$findAssetByIdentifier$1.L$0 = identifier;
                        androidGalleryImageFinder$findAssetByIdentifier$1.I$0 = 0;
                        androidGalleryImageFinder$findAssetByIdentifier$1.I$1 = 0;
                        androidGalleryImageFinder$findAssetByIdentifier$1.label = 1;
                        loadAssetWithContentUri = androidImageGallery.loadAssetWithContentUri(identifier, androidGalleryImageFinder$findAssetByIdentifier$1);
                        if (loadAssetWithContentUri != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = androidGalleryImageFinder$findAssetByIdentifier$1.I$1;
                        int i2 = androidGalleryImageFinder$findAssetByIdentifier$1.I$0;
                        identifier = (String) androidGalleryImageFinder$findAssetByIdentifier$1.L$0;
                        ResultKt.throwOnFailure($result);
                        loadAssetWithContentUri = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                androidImage = (AndroidImage) loadAssetWithContentUri;
                if (androidImage == null) {
                    Object m2636constructorimpl = Result.m2636constructorimpl(androidImage);
                    JobKt.ensureActive(androidGalleryImageFinder$findAssetByIdentifier$1.getContext());
                    return m2636constructorimpl;
                }
                throw new NullPointerException("Asset not found for identifier: " + identifier);
            }
        }
        androidGalleryImageFinder$findAssetByIdentifier$1 = new AndroidGalleryImageFinder$findAssetByIdentifier$1(this, continuation);
        Object $result2 = androidGalleryImageFinder$findAssetByIdentifier$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (androidGalleryImageFinder$findAssetByIdentifier$1.label) {
        }
        androidImage = (AndroidImage) loadAssetWithContentUri;
        if (androidImage == null) {
        }
    }

    /* renamed from: getImageSource  reason: avoid collision after fix types in other method */
    public Object getImageSource2(AndroidImage asset, Resolution expectResolution, boolean animated, Continuation<? super ImageSource> continuation) {
        String $this$asRequest$iv = asset.getUri().toString();
        Intrinsics.checkNotNullExpressionValue($this$asRequest$iv, "toString(...)");
        ImageRequest $this$getImageSource_u24lambda_u240 = new ImageRequest($this$asRequest$iv);
        $this$getImageSource_u24lambda_u240.resizeOption(ResizeOption.Companion.getAUTO());
        $this$getImageSource_u24lambda_u240.autoPlay(animated);
        if (expectResolution != null) {
            $this$getImageSource_u24lambda_u240.m1493requestWidth3VbuI34(Pixel.m1517constructorimpl(expectResolution.getWidthPx()));
            $this$getImageSource_u24lambda_u240.m1488requestHeight3VbuI34(Pixel.m1517constructorimpl(expectResolution.getHeightPx()));
            $this$getImageSource_u24lambda_u240.useOrigin(true);
        }
        $this$getImageSource_u24lambda_u240.animateStrategy(AnimateStrategy.Balance.INSTANCE);
        ImmutableImageRequest it = $this$getImageSource_u24lambda_u240.build();
        Object loadImage$default = BiliImage_androidKt.loadImage$default(it, null, continuation, 2, null);
        return loadImage$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? loadImage$default : (ImageSource) loadImage$default;
    }

    @Override // kntr.common.photonic.shower.AssetShower
    public void Content(final AndroidImage asset, final Modifier modifier, final boolean animated, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer $composer2 = $composer.startRestartGroup(-1058396180);
        ComposerKt.sourceInformation($composer2, "C(Content)N(asset,modifier,animated)67@2407L116,72@2532L300:AndroidGalleryImageFinder.kt#wr9wsy");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(asset) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(animated) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1058396180, $dirty2, -1, "kntr.common.photonic.gallery.asset.AndroidGalleryImageFinder.Content (AndroidGalleryImageFinder.kt:65)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 788524928, "CC(remember):AndroidGalleryImageFinder.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = ZIndexModifierKt.zIndex(SizeKt.fillMaxSize$default(modifier, 0.0f, 1, (Object) null), 0.0f);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Modifier imageModifier = (Modifier) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            String $this$asRequest$iv = asset.getUri().toString();
            Intrinsics.checkNotNullExpressionValue($this$asRequest$iv, "toString(...)");
            ImageRequest $this$Content_u24lambda_u241 = new ImageRequest($this$asRequest$iv);
            $this$Content_u24lambda_u241.resizeOption(ResizeOption.Companion.getAUTO());
            $this$Content_u24lambda_u241.autoPlay(animated);
            $this$Content_u24lambda_u241.animateStrategy(AnimateStrategy.Balance.INSTANCE);
            BiliImageKt.BiliImage($this$Content_u24lambda_u241.build(), imageModifier, null, null, null, null, null, null, null, $composer2, 48, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.gallery.asset.AndroidGalleryImageFinder$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$2;
                    Content$lambda$2 = AndroidGalleryImageFinder.Content$lambda$2(AndroidGalleryImageFinder.this, asset, modifier, animated, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$2;
                }
            });
        }
    }
}