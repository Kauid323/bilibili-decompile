package kntr.common.photonic.aphro.ui.preview.state;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImagePreviewState.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a5\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0001H\u0000¨\u0006\r"}, d2 = {"rememberImagePreviewState", "Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewState;", "dataSource", "", "Lkntr/common/photonic/aphro/ui/preview/model/PreviewableAsset;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "initialPage", "", "(Ljava/util/List;Landroidx/compose/animation/core/AnimationSpec;ILandroidx/compose/runtime/Composer;II)Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewState;", "hasThumbnailRect", "", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImagePreviewStateKt {
    public static final ImagePreviewState rememberImagePreviewState(final List<? extends PreviewableAsset> list, AnimationSpec<Float> animationSpec, int initialPage, Composer $composer, int $changed, int i) {
        AnimationSpec animationSpec2;
        int initialPage2;
        Intrinsics.checkNotNullParameter(list, "dataSource");
        ComposerKt.sourceInformationMarkerStart($composer, -537663042, "C(rememberImagePreviewState)N(dataSource,animationSpec,initialPage)35@1447L39,35@1401L85,39@1511L298,48@1855L169,48@1815L209:ImagePreviewState.kt#za7lpn");
        if ((i & 2) != 0) {
            animationSpec2 = (AnimationSpec) AnimationSpecKt.tween$default(300, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null);
        } else {
            animationSpec2 = animationSpec;
        }
        if ((i & 4) == 0) {
            initialPage2 = initialPage;
        } else {
            initialPage2 = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-537663042, $changed, -1, "kntr.common.photonic.aphro.ui.preview.state.rememberImagePreviewState (ImagePreviewState.kt:33)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1298096955, "CC(remember):ImagePreviewState.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(list);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.state.ImagePreviewStateKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    int size;
                    size = list.size();
                    return Integer.valueOf(size);
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        PagerState pagerState = PagerStateKt.rememberPagerState(initialPage2, 0.0f, (Function0) it$iv, $composer, ($changed >> 6) & 14, 2);
        ComposerKt.sourceInformationMarkerStart($composer, -1298094648, "CC(remember):ImagePreviewState.kt#9igjgp");
        boolean invalid$iv2 = false;
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.Companion.getEmpty()) {
            List<? extends PreviewableAsset> $this$map$iv = list;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                PreviewableAsset it = (PreviewableAsset) item$iv$iv;
                destination$iv$iv.add(new ImagePreviewItemState(it, null, null, 6, null));
                invalid$iv2 = invalid$iv2;
            }
            Object value$iv2 = new ImagePreviewState(SnapshotStateKt.toMutableStateList((List) destination$iv$iv), initialPage2, pagerState, animationSpec2);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ImagePreviewState state = (ImagePreviewState) it$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        Integer valueOf = Integer.valueOf(initialPage2);
        ComposerKt.sourceInformationMarkerStart($composer, -1298083769, "CC(remember):ImagePreviewState.kt#9igjgp");
        boolean invalid$iv3 = $composer.changedInstance(list) | (((($changed & 896) ^ 384) > 256 && $composer.changed(initialPage2)) || ($changed & 384) == 256);
        Object it$iv3 = $composer.rememberedValue();
        if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
            Object value$iv3 = (Function2) new ImagePreviewStateKt$rememberImagePreviewState$1$1(state, list, initialPage2, null);
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(list, valueOf, (Function2) it$iv3, $composer, ($changed & 14) | (($changed >> 3) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return state;
    }

    public static final boolean hasThumbnailRect(ImagePreviewState $this$hasThumbnailRect) {
        PreviewableAsset asset;
        Intrinsics.checkNotNullParameter($this$hasThumbnailRect, "<this>");
        ImagePreviewItemState currentItem = $this$hasThumbnailRect.getCurrentItem();
        return ((currentItem == null || (asset = currentItem.getAsset()) == null) ? null : asset.getThumbnailRect()) != null;
    }
}