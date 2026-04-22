package kntr.app.mall.mallDynamicPage.component.base;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.app.mall.mallDynamicPage.bean.Props;
import kntr.app.mall.mallDynamicPage.bean.Style;
import kntr.app.mall.mallDynamicPage.parser.ModifierCreatorKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* compiled from: ImageComponent.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"ImageComponent", RoomRecommendViewModel.EMPTY_CURSOR, "props", "Lkntr/app/mall/mallDynamicPage/bean/Props;", "style", "Lkntr/app/mall/mallDynamicPage/bean/Style;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/mallDynamicPage/bean/Props;Lkntr/app/mall/mallDynamicPage/bean/Style;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "mallDynamicPage_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ImageComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageComponent$lambda$0(Props props, Style style, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ImageComponent(props, style, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ImageComponent(final Props props, final Style style, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Composer $composer2 = $composer.startRestartGroup(1411782900);
        ComposerKt.sourceInformation($composer2, "C(ImageComponent)N(props,style,modifier)20@622L21,16@492L190:ImageComponent.kt#ay1t0q");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(props) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(style) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1411782900, $dirty2, -1, "kntr.app.mall.mallDynamicPage.component.base.ImageComponent (ImageComponent.kt:15)");
            }
            String src = props != null ? props.getSrc() : null;
            if (src == null) {
                src = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            BiliImageKt.BiliImage(new ImageRequest(src).build(), ModifierCreatorKt.createModifier(Modifier.Companion, style, $composer2, ($dirty2 & 112) | 6).then(modifier4), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer2, 0, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.mallDynamicPage.component.base.ImageComponentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit ImageComponent$lambda$0;
                    ImageComponent$lambda$0 = ImageComponentKt.ImageComponent$lambda$0(Props.this, style, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ImageComponent$lambda$0;
                }
            });
        }
    }
}