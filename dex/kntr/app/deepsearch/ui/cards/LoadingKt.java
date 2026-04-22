package kntr.app.deepsearch.ui.cards;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import com.bapis.bilibili.broadcast.message.deepsearch.KChatStatus;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchResponse;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.deepsearch.ui.key.ListKeyScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Loading.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010\f\u001a\u00020\u000bX\u008a\u0084\u0002"}, d2 = {"loading", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/deepsearch/ui/key/ListKeyScope;", "item", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryItem;", "Loading", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "compose_debug", "targetAlpha", RoomRecommendViewModel.EMPTY_CURSOR, "alpha"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class LoadingKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Loading$lambda$5(Modifier modifier, int i, int i2, Composer composer, int i3) {
        Loading(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void loading(ListKeyScope $this$loading, KChatHistoryItem item) {
        KDeepSearchResponse content;
        Intrinsics.checkNotNullParameter($this$loading, "<this>");
        if (Intrinsics.areEqual((item == null || (content = item.getContent()) == null) ? null : content.getStatus(), KChatStatus.PLACEHOLDER.INSTANCE)) {
            ListKeyScope.item$default($this$loading, item, null, ComposableSingletons$LoadingKt.INSTANCE.getLambda$1266484395$compose_debug(), 2, null);
        }
    }

    public static final void Loading(Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(-283641318);
        ComposerKt.sourceInformation($composer2, "C(Loading)N(modifier)50@1698L50,54@1790L195,63@2013L198,63@1991L220,78@2416L6,71@2217L312:Loading.kt#pp6rt");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-283641318, $dirty2, -1, "kntr.app.deepsearch.ui.cards.Loading (Loading.kt:47)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1996363348, "CC(remember):Loading.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.05f);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableFloatState targetAlpha$delegate = (MutableFloatState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            State alpha$delegate = AnimateAsStateKt.animateFloatAsState(Loading$lambda$1(targetAlpha$delegate), AnimationSpecKt.tween$default(1000, 0, (Easing) null, 6, (Object) null), 1.0E-4f, (String) null, (Function1) null, $composer2, 432, 24);
            Float valueOf = Float.valueOf(Loading$lambda$3(alpha$delegate));
            ComposerKt.sourceInformationMarkerStart($composer2, -1996353120, "CC(remember):Loading.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(alpha$delegate);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new LoadingKt$Loading$1$1(0.05f, 1.0E-4f, 0.02f, alpha$delegate, targetAlpha$delegate, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv2, $composer2, 0);
            BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), Dp.constructor-impl(80)), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), Loading$lambda$3(alpha$delegate), 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.cards.LoadingKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit Loading$lambda$5;
                    Loading$lambda$5 = LoadingKt.Loading$lambda$5(modifier3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Loading$lambda$5;
                }
            });
        }
    }

    private static final float Loading$lambda$1(MutableFloatState $targetAlpha$delegate) {
        FloatState $this$getValue$iv = (FloatState) $targetAlpha$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Loading$lambda$3(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }
}