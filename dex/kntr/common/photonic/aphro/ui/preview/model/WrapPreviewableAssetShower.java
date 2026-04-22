package kntr.common.photonic.aphro.ui.preview.model;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageSource;
import kntr.common.photonic.Asset;
import kntr.common.photonic.AssetEntry;
import kntr.common.photonic.Resolution;
import kntr.common.photonic.shower.AssetShower;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: PreviewableAsset.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\u0002H\u0002J*\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013J%\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0017¢\u0006\u0002\u0010\u0018R\"\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00070\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/model/WrapPreviewableAssetShower;", "Lkntr/common/photonic/shower/AssetShower;", "Lkntr/common/photonic/aphro/ui/preview/model/WrapPreviewableAsset;", "<init>", "()V", "acceptType", "", "Lkotlin/reflect/KClass;", "getAcceptType", "()Ljava/util/Set;", "getShower", "Lkntr/common/photonic/Asset;", "asset", "getImageSource", "Lkntr/base/imageloader/ImageSource;", "expectResolution", "Lkntr/common/photonic/Resolution;", "animated", "", "(Lkntr/common/photonic/aphro/ui/preview/model/WrapPreviewableAsset;Lkntr/common/photonic/Resolution;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Content", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/common/photonic/aphro/ui/preview/model/WrapPreviewableAsset;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WrapPreviewableAssetShower implements AssetShower<WrapPreviewableAsset> {
    public static final int $stable = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0(WrapPreviewableAssetShower wrapPreviewableAssetShower, WrapPreviewableAsset wrapPreviewableAsset, Modifier modifier, boolean z, int i, Composer composer, int i2) {
        wrapPreviewableAssetShower.Content(wrapPreviewableAsset, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    @Override // kntr.common.photonic.shower.AssetShower
    public /* bridge */ /* synthetic */ Object getImageSource(WrapPreviewableAsset wrapPreviewableAsset, Resolution expectResolution, boolean animated, Continuation $completion) {
        return getImageSource2(wrapPreviewableAsset, expectResolution, animated, (Continuation<? super ImageSource>) $completion);
    }

    @Override // kntr.common.photonic.shower.AssetShower
    public Set<KClass<? extends WrapPreviewableAsset>> getAcceptType() {
        return SetsKt.setOf(Reflection.getOrCreateKotlinClass(WrapPreviewableAsset.class));
    }

    private final AssetShower<Asset> getShower(WrapPreviewableAsset asset) {
        AssetShower<Asset> showerForAssetType = AssetEntry.INSTANCE.getShower().getShowerForAssetType(Reflection.getOrCreateKotlinClass(asset.getAsset().getClass()));
        if (showerForAssetType instanceof AssetShower) {
            return showerForAssetType;
        }
        return null;
    }

    /* renamed from: getImageSource  reason: avoid collision after fix types in other method */
    public Object getImageSource2(WrapPreviewableAsset asset, Resolution expectResolution, boolean animated, Continuation<? super ImageSource> continuation) {
        AssetShower<Asset> shower = getShower(asset);
        if (shower != null) {
            return shower.getImageSource(asset.getAsset(), expectResolution, animated, continuation);
        }
        return null;
    }

    @Override // kntr.common.photonic.shower.AssetShower
    public void Content(final WrapPreviewableAsset asset, final Modifier modifier, final boolean animated, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer $composer2 = $composer.startRestartGroup(-721686639);
        ComposerKt.sourceInformation($composer2, "C(Content)N(asset,modifier,animated):PreviewableAsset.kt#z6tp37");
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
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-721686639, $dirty2, -1, "kntr.common.photonic.aphro.ui.preview.model.WrapPreviewableAssetShower.Content (PreviewableAsset.kt:73)");
            }
            AssetShower<Asset> shower = getShower(asset);
            if (shower == null) {
                $composer2.startReplaceGroup(839761386);
            } else {
                $composer2.startReplaceGroup(-2051120905);
                ComposerKt.sourceInformation($composer2, "74@2486L70");
                shower.Content(asset.getAsset(), modifier, animated, $composer2, ($dirty2 & 112) | ($dirty2 & 896));
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.model.WrapPreviewableAssetShower$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$0;
                    Content$lambda$0 = WrapPreviewableAssetShower.Content$lambda$0(WrapPreviewableAssetShower.this, asset, modifier, animated, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$0;
                }
            });
        }
    }
}