package kntr.app.digital.preview.card.image;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImageState;
import kntr.base.imageloader.Style;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageModule.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"ImageUI", RoomRecommendViewModel.EMPTY_CURSOR, "url", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "onState", "Lkotlin/Function1;", "Lkntr/base/imageloader/ImageState;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ImageModuleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageUI$lambda$0(String str, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        ImageUI(str, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ImageUI(final String url, Modifier modifier, Function1<? super ImageState, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 function12;
        Function1 onState;
        Modifier modifier3;
        Modifier modifier4;
        Function1 onState2;
        Intrinsics.checkNotNullParameter(url, "url");
        Composer $composer2 = $composer.startRestartGroup(-145749974);
        ComposerKt.sourceInformation($composer2, "C(ImageUI)N(url,modifier,onState)20@646L537:ImageModule.kt#9sutw3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(url) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function12 = function1;
        } else if (($changed & 384) == 0) {
            function12 = function1;
            $dirty |= $composer2.changedInstance(function12) ? 256 : 128;
        } else {
            function12 = function1;
        }
        if (!$composer2.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            onState = function12;
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                onState2 = function12;
            } else {
                onState2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-145749974, $dirty, -1, "kntr.app.digital.preview.card.image.ImageUI (ImageModule.kt:19)");
            }
            BiliImageKt.BiliImage(new ImageRequest(url).requestStyle-R_Oh58k(Style.constructor-impl("common-ogv")).enableAnimate(true).autoPlay(true).contentScale(ContentScale.Companion.getFit()).build(), modifier4, (String) null, onState2, (Function1) null, (Function1) null, (Function1) null, (Function2) null, ComposableSingletons$ImageModuleKt.INSTANCE.m934getLambda$1210502821$preview_debug(), $composer2, ($dirty & 112) | 100663296 | (($dirty << 3) & 7168), 244);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            onState = onState2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function1 function13 = onState;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.card.image.ImageModuleKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit ImageUI$lambda$0;
                    ImageUI$lambda$0 = ImageModuleKt.ImageUI$lambda$0(url, modifier5, function13, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ImageUI$lambda$0;
                }
            });
        }
    }
}