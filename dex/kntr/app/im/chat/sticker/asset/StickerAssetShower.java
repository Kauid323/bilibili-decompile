package kntr.app.im.chat.sticker.asset;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.Lifecycle;
import java.util.Set;
import kntr.app.im.chat.sticker.asset.StickerAssetFinder;
import kntr.app.im.chat.sticker.model.StickerAsset;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.BiliImage_androidKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImageSource;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.imageloader.Pixel;
import kntr.base.imageloader.ResizeOption;
import kntr.common.photonic.Asset;
import kntr.common.photonic.Resolution;
import kntr.common.photonic.shower.AssetShower;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsKt;

/* compiled from: StickerAssetShower.android.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J*\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0017¢\u0006\u0002\u0010\u0016J'\u0010\u0017\u001a\u00020\u0018*\u00020\u00022\u0019\b\u0002\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00130\u001a¢\u0006\u0002\b\u001cH\u0002R\"\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00070\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001d"}, d2 = {"Lkntr/app/im/chat/sticker/asset/StickerAssetShower;", "Lkntr/common/photonic/shower/AssetShower;", "Lkntr/app/im/chat/sticker/model/StickerAsset;", "<init>", "()V", "acceptType", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/reflect/KClass;", "getAcceptType", "()Ljava/util/Set;", "getImageSource", "Lkntr/base/imageloader/ImageSource;", "asset", "expectResolution", "Lkntr/common/photonic/Resolution;", "animated", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/im/chat/sticker/model/StickerAsset;Lkntr/common/photonic/Resolution;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Content", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/im/chat/sticker/model/StickerAsset;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;I)V", "asRequest", "Lkntr/base/imageloader/ImmutableImageRequest;", "config", "Lkotlin/Function1;", "Lkntr/base/imageloader/ImageRequest;", "Lkotlin/ExtensionFunctionType;", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StickerAssetShower implements AssetShower<StickerAsset> {
    public static final int $stable = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$1(StickerAssetShower stickerAssetShower, StickerAsset stickerAsset, Modifier modifier, boolean z, int i, Composer composer, int i2) {
        stickerAssetShower.Content(stickerAsset, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public /* bridge */ /* synthetic */ Object getImageSource(Asset asset, Resolution expectResolution, boolean animated, Continuation $completion) {
        return getImageSource((StickerAsset) asset, expectResolution, animated, (Continuation<? super ImageSource>) $completion);
    }

    public Set<KClass<? extends StickerAsset>> getAcceptType() {
        return SetsKt.setOf(Reflection.getOrCreateKotlinClass(StickerAsset.class));
    }

    public Object getImageSource(StickerAsset asset, final Resolution expectResolution, final boolean animated, Continuation<? super ImageSource> continuation) {
        return BiliImage_androidKt.loadImage$default(asRequest(asset, new Function1() { // from class: kntr.app.im.chat.sticker.asset.StickerAssetShower$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit imageSource$lambda$0;
                imageSource$lambda$0 = StickerAssetShower.getImageSource$lambda$0(animated, expectResolution, (ImageRequest) obj);
                return imageSource$lambda$0;
            }
        }), (Lifecycle) null, continuation, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getImageSource$lambda$0(boolean $animated, Resolution $expectResolution, ImageRequest $this$asRequest) {
        Intrinsics.checkNotNullParameter($this$asRequest, "$this$asRequest");
        $this$asRequest.autoPlay($animated);
        if ($expectResolution != null && !Intrinsics.areEqual($expectResolution, Resolution.Companion.getZero())) {
            $this$asRequest.resizeOption(ResizeOption.Companion.getAUTO());
            $this$asRequest.requestWidth-3VbuI34(Pixel.constructor-impl($expectResolution.getWidthPx()));
            $this$asRequest.requestHeight-3VbuI34(Pixel.constructor-impl($expectResolution.getHeightPx()));
        }
        return Unit.INSTANCE;
    }

    public void Content(final StickerAsset asset, final Modifier modifier, final boolean animated, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer $composer2 = $composer.startRestartGroup(-1994826159);
        ComposerKt.sourceInformation($composer2, "C(Content)N(asset,modifier,animated)60@2039L113,59@2000L196:StickerAssetShower.android.kt#l1xaah");
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
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(this) ? 2048 : 1024;
        }
        if (!$composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1994826159, $dirty, -1, "kntr.app.im.chat.sticker.asset.StickerAssetShower.Content (StickerAssetShower.android.kt:58)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1472519806, "CC(remember):StickerAssetShower.android.kt#9igjgp");
            boolean invalid$iv = ($dirty & 896) == 256;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.im.chat.sticker.asset.StickerAssetShower$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$0$0;
                        Content$lambda$0$0 = StickerAssetShower.Content$lambda$0$0(animated, (ImageRequest) obj);
                        return Content$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BiliImageKt.BiliImage(asRequest(asset, (Function1) it$iv), modifier, (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer2, $dirty & 112, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.sticker.asset.StickerAssetShower$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$1;
                    Content$lambda$1 = StickerAssetShower.Content$lambda$1(StickerAssetShower.this, asset, modifier, animated, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0$0(boolean $animated, ImageRequest $this$asRequest) {
        Intrinsics.checkNotNullParameter($this$asRequest, "$this$asRequest");
        $this$asRequest.autoPlay($animated);
        $this$asRequest.resizeOption(ResizeOption.Companion.getAUTO());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ ImmutableImageRequest asRequest$default(StickerAssetShower stickerAssetShower, StickerAsset stickerAsset, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: kntr.app.im.chat.sticker.asset.StickerAssetShower$$ExternalSyntheticLambda3
                public final Object invoke(Object obj2) {
                    Unit asRequest$lambda$0;
                    asRequest$lambda$0 = StickerAssetShower.asRequest$lambda$0((ImageRequest) obj2);
                    return asRequest$lambda$0;
                }
            };
        }
        return stickerAssetShower.asRequest(stickerAsset, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit asRequest$lambda$0(ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "<this>");
        return Unit.INSTANCE;
    }

    private final ImmutableImageRequest asRequest(StickerAsset $this$asRequest, Function1<? super ImageRequest, Unit> function1) {
        Path path = PathsKt.Path(StickerAssetFinder.Companion.getStickerSaveRoot$default(StickerAssetFinder.Companion, null, 1, null), new String[]{$this$asRequest.getIdentifier()});
        String $this$asRequest$iv = "file://" + path;
        ImageRequest imageRequest = new ImageRequest($this$asRequest$iv);
        function1.invoke(imageRequest);
        return imageRequest.build();
    }
}