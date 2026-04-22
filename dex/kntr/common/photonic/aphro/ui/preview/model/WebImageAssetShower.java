package kntr.common.photonic.aphro.ui.preview.model;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.BiliImage_androidKt;
import kntr.base.imageloader.ImageSource;
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

/* compiled from: WebImageAsset.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0017¢\u0006\u0002\u0010\u0016R\"\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00070\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/model/WebImageAssetShower;", "Lkntr/common/photonic/shower/AssetShower;", "Lkntr/common/photonic/aphro/ui/preview/model/WebImageAsset;", "<init>", "()V", "acceptType", "", "Lkotlin/reflect/KClass;", "getAcceptType", "()Ljava/util/Set;", "getImageSource", "Lkntr/base/imageloader/ImageSource;", "asset", "expectResolution", "Lkntr/common/photonic/Resolution;", "animated", "", "(Lkntr/common/photonic/aphro/ui/preview/model/WebImageAsset;Lkntr/common/photonic/Resolution;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Content", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/common/photonic/aphro/ui/preview/model/WebImageAsset;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WebImageAssetShower implements AssetShower<WebImageAsset> {
    public static final int $stable = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0(WebImageAssetShower webImageAssetShower, WebImageAsset webImageAsset, Modifier modifier, boolean z, int i, Composer composer, int i2) {
        webImageAssetShower.Content(webImageAsset, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    @Override // kntr.common.photonic.shower.AssetShower
    public /* bridge */ /* synthetic */ Object getImageSource(WebImageAsset webImageAsset, Resolution expectResolution, boolean animated, Continuation $completion) {
        return getImageSource2(webImageAsset, expectResolution, animated, (Continuation<? super ImageSource>) $completion);
    }

    @Override // kntr.common.photonic.shower.AssetShower
    public Set<KClass<? extends WebImageAsset>> getAcceptType() {
        return SetsKt.setOf(Reflection.getOrCreateKotlinClass(WebImageAsset.class));
    }

    /* renamed from: getImageSource  reason: avoid collision after fix types in other method */
    public Object getImageSource2(WebImageAsset asset, Resolution expectResolution, boolean animated, Continuation<? super ImageSource> continuation) {
        return BiliImage_androidKt.loadImage$default(asset.request$ui_debug(expectResolution, animated).build(), null, continuation, 2, null);
    }

    @Override // kntr.common.photonic.shower.AssetShower
    public void Content(final WebImageAsset asset, final Modifier modifier, final boolean animated, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer $composer2 = $composer.startRestartGroup(392877868);
        ComposerKt.sourceInformation($composer2, "C(Content)N(asset,modifier,animated)96@3179L104:WebImageAsset.kt#z6tp37");
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
        if (!$composer2.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(392877868, $dirty, -1, "kntr.common.photonic.aphro.ui.preview.model.WebImageAssetShower.Content (WebImageAsset.kt:95)");
            }
            BiliImageKt.BiliImage(asset.request$ui_debug(null, animated).build(), modifier, null, null, null, null, null, null, null, $composer2, $dirty & 112, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.model.WebImageAssetShower$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$0;
                    Content$lambda$0 = WebImageAssetShower.Content$lambda$0(WebImageAssetShower.this, asset, modifier, animated, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$0;
                }
            });
        }
    }
}