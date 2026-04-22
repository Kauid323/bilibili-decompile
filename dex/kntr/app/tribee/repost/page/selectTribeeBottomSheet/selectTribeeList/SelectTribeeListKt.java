package kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.common.compose.list.LoadMoreListStateKt;
import kntr.common.compose.list.ReachedEdgeState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: SelectTribeeList.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0004\u001a}\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00052\u001c\u0010\b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0015\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u0015\u001a\u0083\u0001\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u001b\u001a\u00020\u00192\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00102\u001c\b\u0002\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u001f\u001aI\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010$\u001aQ\u0010%\u001a\u00020\u00012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0'2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0010H\u0007¢\u0006\u0002\u0010(\u001a)\u0010)\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010*¨\u0006+"}, d2 = {"SelectTribeeList", "", "listState", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectTribeeListState;", "onTirbeeItemExposure", "Lkotlin/Function2;", "", "", "onTribeeOrPartitionSelect", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeeItem;", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeePartition;", "modifier", "Landroidx/compose/ui/Modifier;", "onLoadMore", "Lkotlin/Function0;", "onDispose", "Lkotlin/Function1;", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectTribeeListScrollPosition;", "(Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectTribeeListState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "SelectTribeeListIndicator", "indicatorText", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "SelectTribeeListItem", "tribeeItem", "isSelected", "", "selectedPartition", "showDivider", "onItemClick", "onPartitionClick", "onItemExposure", "(Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeeItem;Landroidx/compose/ui/Modifier;ZLkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeePartition;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SelectTribeeListItemImageTextArea", "imageUrl", "title", "subtitle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SelectPartitionList", "partitions", "", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeePartition;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "SelectPartitionListItem", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "repost_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SelectTribeeListKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectPartitionList$lambda$2(List list, Modifier modifier, String str, SelectableTribeePartition selectableTribeePartition, Function1 function1, int i, int i2, Composer composer, int i3) {
        SelectPartitionList(list, modifier, str, selectableTribeePartition, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectPartitionListItem$lambda$1(String str, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        SelectPartitionListItem(str, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectTribeeList$lambda$6(SelectTribeeListState selectTribeeListState, Function2 function2, Function2 function22, Modifier modifier, Function0 function0, Function1 function1, int i, int i2, Composer composer, int i3) {
        SelectTribeeList(selectTribeeListState, function2, function22, modifier, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectTribeeListIndicator$lambda$1(String str, int i, Composer composer, int i2) {
        SelectTribeeListIndicator(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectTribeeListItem$lambda$4(SelectableTribeeItem selectableTribeeItem, Modifier modifier, boolean z, SelectableTribeePartition selectableTribeePartition, boolean z2, Function0 function0, Function1 function1, Function2 function2, int i, int i2, Composer composer, int i3) {
        SelectTribeeListItem(selectableTribeeItem, modifier, z, selectableTribeePartition, z2, function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectTribeeListItemImageTextArea$lambda$3(String str, String str2, String str3, Modifier modifier, boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        SelectTribeeListItemImageTextArea(str, str2, str3, modifier, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectTribeeList$lambda$1$0(SelectTribeeListScrollPosition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0228, code lost:
        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02a2, code lost:
        if (r5 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L93;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02df  */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SelectTribeeList(final SelectTribeeListState listState, final Function2<? super Long, ? super String, Unit> function2, final Function2<? super SelectableTribeeItem, ? super SelectableTribeePartition, Unit> function22, Modifier modifier, Function0<Unit> function0, Function1<? super SelectTribeeListScrollPosition, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 function12;
        int $dirty;
        Function0 onLoadMore;
        Modifier modifier3;
        Function1 onDispose;
        Function0 onLoadMore2;
        final Function1 onDispose2;
        int $dirty2;
        boolean invalid$iv;
        boolean invalid$iv2;
        Intrinsics.checkNotNullParameter(listState, "listState");
        Intrinsics.checkNotNullParameter(function2, "onTirbeeItemExposure");
        Intrinsics.checkNotNullParameter(function22, "onTribeeOrPartitionSelect");
        Composer $composer2 = $composer.startRestartGroup(-452577287);
        ComposerKt.sourceInformation($composer2, "C(SelectTribeeList)N(listState,onTirbeeItemExposure,onTribeeOrPartitionSelect,modifier,onLoadMore,onDispose)49@2235L2,50@2297L2,53@2337L210,57@2573L33,61@2687L119,59@2626L187,68@2842L279,68@2819L302,84@3269L6,87@3361L1327,79@3127L1561:SelectTribeeList.kt#mscztr");
        int $dirty3 = $changed;
        if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changed(listState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty3 |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty3 |= $composer2.changedInstance(function22) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty3 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty3 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty3 |= $composer2.changedInstance(function0) ? 16384 : 8192;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty3 |= 196608;
            function12 = function1;
        } else if (($changed & 196608) == 0) {
            function12 = function1;
            $dirty3 |= $composer2.changedInstance(function12) ? 131072 : 65536;
        } else {
            function12 = function1;
        }
        if ($composer2.shouldExecute(($dirty3 & 74899) != 74898, $dirty3 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1135067397, "CC(remember):SelectTribeeList.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda14
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onLoadMore3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onLoadMore2 = onLoadMore3;
            } else {
                onLoadMore2 = function0;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1135065413, "CC(remember):SelectTribeeList.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda15
                        public final Object invoke(Object obj) {
                            Unit SelectTribeeList$lambda$1$0;
                            SelectTribeeList$lambda$1$0 = SelectTribeeListKt.SelectTribeeList$lambda$1$0((SelectTribeeListScrollPosition) obj);
                            return SelectTribeeList$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                onDispose2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onDispose2 = function12;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-452577287, $dirty3, -1, "kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeList (SelectTribeeList.kt:51)");
            }
            SelectTribeeListScrollPosition listScrollPosition = listState.getListScrollPosition();
            int index = listScrollPosition != null ? listScrollPosition.getIndex() : 0;
            SelectTribeeListScrollPosition listScrollPosition2 = listState.getListScrollPosition();
            final LazyListState lazyListState = LazyListStateKt.rememberLazyListState(index, listScrollPosition2 != null ? listScrollPosition2.getOffset() : 0, $composer2, 0, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, -1135056550, "CC(remember):SelectTribeeList.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Set) new LinkedHashSet();
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final Set exposedItemIds = (Set) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1135052816, "CC(remember):SelectTribeeList.kt#9igjgp");
            boolean invalid$iv3 = (($dirty3 & 14) == 4) | ((57344 & $dirty3) == 16384);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv3) {
                $dirty2 = $dirty3;
            } else {
                $dirty2 = $dirty3;
                if (it$iv4 != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    LoadMoreListStateKt.applyLoadMoreEffects(lazyListState, 2, (Function1<? super ReachedEdgeState, Boolean>) null, (Function1) it$iv4, $composer2, 48, 2);
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1135047696, "CC(remember):SelectTribeeList.kt#9igjgp");
                    $dirty = $dirty2;
                    invalid$iv = $composer2.changed(lazyListState) | ((458752 & $dirty) != 131072);
                    Object it$iv5 = $composer2.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv4 = new Function1() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda16
                        public final Object invoke(Object obj) {
                            DisposableEffectResult SelectTribeeList$lambda$4$0;
                            SelectTribeeList$lambda$4$0 = SelectTribeeListKt.SelectTribeeList$lambda$4$0(onDispose2, lazyListState, (DisposableEffectScope) obj);
                            return SelectTribeeList$lambda$4$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv4);
                    it$iv5 = value$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.DisposableEffect(unit, (Function1) it$iv5, $composer2, 6);
                    Modifier modifier5 = BackgroundKt.background-bw27NRU(modifier4, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)));
                    ComposerKt.sourceInformationMarkerStart($composer2, -1135030040, "CC(remember):SelectTribeeList.kt#9igjgp");
                    invalid$iv2 = (($dirty & 896) != 256) | (($dirty & 14) != 4) | $composer2.changedInstance(exposedItemIds) | (($dirty & 112) == 32);
                    Object it$iv6 = $composer2.rememberedValue();
                    if (invalid$iv2) {
                        onDispose = onDispose2;
                    } else {
                        onDispose = onDispose2;
                    }
                    Object value$iv5 = new Function1() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda17
                        public final Object invoke(Object obj) {
                            Unit SelectTribeeList$lambda$5$0;
                            SelectTribeeList$lambda$5$0 = SelectTribeeListKt.SelectTribeeList$lambda$5$0(SelectTribeeListState.this, function22, exposedItemIds, function2, (LazyListScope) obj);
                            return SelectTribeeList$lambda$5$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv5);
                    it$iv6 = value$iv5;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Function0 onLoadMore4 = onLoadMore2;
                    Modifier modifier6 = modifier4;
                    LazyDslKt.LazyColumn(modifier5, lazyListState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv6, $composer2, 0, 508);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    onLoadMore = onLoadMore4;
                    modifier3 = modifier6;
                }
            }
            Object value$iv6 = (Function1) new SelectTribeeListKt$SelectTribeeList$3$1(listState, onLoadMore2, null);
            $composer2.updateRememberedValue(value$iv6);
            it$iv4 = value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LoadMoreListStateKt.applyLoadMoreEffects(lazyListState, 2, (Function1<? super ReachedEdgeState, Boolean>) null, (Function1) it$iv4, $composer2, 48, 2);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1135047696, "CC(remember):SelectTribeeList.kt#9igjgp");
            $dirty = $dirty2;
            invalid$iv = $composer2.changed(lazyListState) | ((458752 & $dirty) != 131072);
            Object it$iv52 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv42 = new Function1() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj) {
                    DisposableEffectResult SelectTribeeList$lambda$4$0;
                    SelectTribeeList$lambda$4$0 = SelectTribeeListKt.SelectTribeeList$lambda$4$0(onDispose2, lazyListState, (DisposableEffectScope) obj);
                    return SelectTribeeList$lambda$4$0;
                }
            };
            $composer2.updateRememberedValue(value$iv42);
            it$iv52 = value$iv42;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(unit2, (Function1) it$iv52, $composer2, 6);
            Modifier modifier52 = BackgroundKt.background-bw27NRU(modifier4, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)));
            ComposerKt.sourceInformationMarkerStart($composer2, -1135030040, "CC(remember):SelectTribeeList.kt#9igjgp");
            if (($dirty & 14) != 4) {
            }
            invalid$iv2 = (($dirty & 896) != 256) | (($dirty & 14) != 4) | $composer2.changedInstance(exposedItemIds) | (($dirty & 112) == 32);
            Object it$iv62 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv52 = new Function1() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj) {
                    Unit SelectTribeeList$lambda$5$0;
                    SelectTribeeList$lambda$5$0 = SelectTribeeListKt.SelectTribeeList$lambda$5$0(SelectTribeeListState.this, function22, exposedItemIds, function2, (LazyListScope) obj);
                    return SelectTribeeList$lambda$5$0;
                }
            };
            $composer2.updateRememberedValue(value$iv52);
            it$iv62 = value$iv52;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Function0 onLoadMore42 = onLoadMore2;
            Modifier modifier62 = modifier4;
            LazyDslKt.LazyColumn(modifier52, lazyListState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv62, $composer2, 0, 508);
            if (ComposerKt.isTraceInProgress()) {
            }
            onLoadMore = onLoadMore42;
            modifier3 = modifier62;
        } else {
            $dirty = $dirty3;
            $composer2.skipToGroupEnd();
            onLoadMore = function0;
            modifier3 = modifier2;
            onDispose = function12;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final Function0 function02 = onLoadMore;
            final Function1 function13 = onDispose;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectTribeeList$lambda$6;
                    SelectTribeeList$lambda$6 = SelectTribeeListKt.SelectTribeeList$lambda$6(SelectTribeeListState.this, function2, function22, modifier7, function02, function13, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectTribeeList$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult SelectTribeeList$lambda$4$0(final Function1 $onDispose, final LazyListState $lazyListState, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$SelectTribeeList$lambda$4$0$$inlined$onDispose$1
            public void dispose() {
                $onDispose.invoke(new SelectTribeeListScrollPosition($lazyListState.getFirstVisibleItemIndex(), $lazyListState.getFirstVisibleItemScrollOffset()));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectTribeeList$lambda$5$0(final SelectTribeeListState $listState, final Function2 $onTribeeOrPartitionSelect, final Set $exposedItemIds, final Function2 $onTirbeeItemExposure, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final List items$iv = $listState.getItems();
        final Function2 key$iv = new Function2() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda9
            public final Object invoke(Object obj, Object obj2) {
                Object SelectTribeeList$lambda$5$0$0;
                SelectTribeeList$lambda$5$0$0 = SelectTribeeListKt.SelectTribeeList$lambda$5$0$0(((Integer) obj).intValue(), (SelectableTribeeItem) obj2);
                return SelectTribeeList$lambda$5$0$0;
            }
        };
        $this$LazyColumn.items(items$iv.size(), new Function1<Integer, Object>() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$SelectTribeeList$lambda$5$0$$inlined$itemsIndexed$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return key$iv.invoke(Integer.valueOf(index), items$iv.get(index));
            }
        }, new Function1<Integer, Object>() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$SelectTribeeList$lambda$5$0$$inlined$itemsIndexed$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                items$iv.get(index);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$SelectTribeeList$lambda$5$0$$inlined$itemsIndexed$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:77:0x01af  */
            /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                boolean invalid$iv;
                ComposerKt.sourceInformation($composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if ($composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2039820996, $dirty, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                    }
                    int $changed2 = ($dirty & 14) | ($dirty & 112);
                    final SelectableTribeeItem tribeeItem = (SelectableTribeeItem) items$iv.get(it);
                    $composer.startReplaceGroup(1838547071);
                    ComposerKt.sourceInformation($composer, "CN(index,tribeeItem)*99@3850L83,102@3970L101,105@4106L158,94@3573L706:SelectTribeeList.kt#mscztr");
                    boolean showDivider = it < $listState.getItems().size() - 1;
                    SelectableTribeeItem selectedTribee = $listState.getSelectedTribee();
                    boolean z = selectedTribee != null && selectedTribee.getId() == tribeeItem.getId();
                    SelectableTribeePartition selectedPartition = $listState.getSelectedPartition();
                    ComposerKt.sourceInformationMarkerStart($composer, -2018891787, "CC(remember):SelectTribeeList.kt#9igjgp");
                    boolean invalid$iv2 = (((($changed2 & 896) ^ 384) > 256 && $composer.changed(tribeeItem)) || ($changed2 & 384) == 256) | $composer.changed($onTribeeOrPartitionSelect);
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                        final Function2 function2 = $onTribeeOrPartitionSelect;
                        Object value$iv = (Function0) new Function0<Unit>() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$SelectTribeeList$5$1$2$1$1
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m1033invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m1033invoke() {
                                function2.invoke(tribeeItem, (Object) null);
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    Function0 function0 = (Function0) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, -2018887929, "CC(remember):SelectTribeeList.kt#9igjgp");
                    boolean invalid$iv3 = $composer.changed($onTribeeOrPartitionSelect) | (((($changed2 & 896) ^ 384) > 256 && $composer.changed(tribeeItem)) || ($changed2 & 384) == 256);
                    Object it$iv2 = $composer.rememberedValue();
                    if (!invalid$iv3 && it$iv2 != Composer.Companion.getEmpty()) {
                        Function1 function1 = (Function1) it$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerStart($composer, -2018883520, "CC(remember):SelectTribeeList.kt#9igjgp");
                        invalid$iv = $composer.changedInstance($exposedItemIds) | $composer.changed($onTirbeeItemExposure);
                        Object it$iv3 = $composer.rememberedValue();
                        if (!invalid$iv && it$iv3 != Composer.Companion.getEmpty()) {
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            SelectTribeeListKt.SelectTribeeListItem(tribeeItem, null, z, selectedPartition, showDivider, function0, function1, (Function2) it$iv3, $composer, ($changed2 >> 6) & 14, 2);
                            $composer.endReplaceGroup();
                            if (!ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        final Set set = $exposedItemIds;
                        final Function2 function22 = $onTirbeeItemExposure;
                        Object value$iv2 = (Function2) new Function2<Long, String, Unit>() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$SelectTribeeList$5$1$2$3$1
                            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                                invoke(((Number) p1).longValue(), (String) p2);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(long id, String name) {
                                Intrinsics.checkNotNullParameter(name, "name");
                                if (set.add(Long.valueOf(id))) {
                                    function22.invoke(Long.valueOf(id), name);
                                }
                            }
                        };
                        $composer.updateRememberedValue(value$iv2);
                        it$iv3 = value$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        SelectTribeeListKt.SelectTribeeListItem(tribeeItem, null, z, selectedPartition, showDivider, function0, function1, (Function2) it$iv3, $composer, ($changed2 >> 6) & 14, 2);
                        $composer.endReplaceGroup();
                        if (!ComposerKt.isTraceInProgress()) {
                        }
                    }
                    final Function2 function23 = $onTribeeOrPartitionSelect;
                    Object value$iv3 = (Function1) new Function1<SelectableTribeePartition, Unit>() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$SelectTribeeList$5$1$2$2$1
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            invoke((SelectableTribeePartition) p1);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SelectableTribeePartition partition) {
                            Intrinsics.checkNotNullParameter(partition, "partition");
                            function23.invoke(tribeeItem, partition);
                        }
                    };
                    $composer.updateRememberedValue(value$iv3);
                    it$iv2 = value$iv3;
                    Function1 function12 = (Function1) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, -2018883520, "CC(remember):SelectTribeeList.kt#9igjgp");
                    invalid$iv = $composer.changedInstance($exposedItemIds) | $composer.changed($onTirbeeItemExposure);
                    Object it$iv32 = $composer.rememberedValue();
                    if (!invalid$iv) {
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        SelectTribeeListKt.SelectTribeeListItem(tribeeItem, null, z, selectedPartition, showDivider, function0, function12, (Function2) it$iv32, $composer, ($changed2 >> 6) & 14, 2);
                        $composer.endReplaceGroup();
                        if (!ComposerKt.isTraceInProgress()) {
                        }
                    }
                    final Set<Long> set2 = $exposedItemIds;
                    final Function2<? super Long, ? super String, Unit> function222 = $onTirbeeItemExposure;
                    Object value$iv22 = (Function2) new Function2<Long, String, Unit>() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$SelectTribeeList$5$1$2$3$1
                        public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                            invoke(((Number) p1).longValue(), (String) p2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(long id, String name) {
                            Intrinsics.checkNotNullParameter(name, "name");
                            if (set2.add(Long.valueOf(id))) {
                                function222.invoke(Long.valueOf(id), name);
                            }
                        }
                    };
                    $composer.updateRememberedValue(value$iv22);
                    it$iv32 = value$iv22;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    SelectTribeeListKt.SelectTribeeListItem(tribeeItem, null, z, selectedPartition, showDivider, function0, function12, (Function2) it$iv32, $composer, ($changed2 >> 6) & 14, 2);
                    $composer.endReplaceGroup();
                    if (!ComposerKt.isTraceInProgress()) {
                    }
                } else {
                    $composer.skipToGroupEnd();
                }
            }
        }));
        if ($listState.isLoadingMore()) {
            LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableSingletons$SelectTribeeListKt.INSTANCE.m1021getLambda$1260419895$repost_debug(), 3, (Object) null);
        }
        if (!$listState.getHasMore() && !$listState.getItems().isEmpty()) {
            LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableSingletons$SelectTribeeListKt.INSTANCE.getLambda$2092654514$repost_debug(), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SelectTribeeList$lambda$5$0$0(int i, SelectableTribeeItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return Long.valueOf(item.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectTribeeListIndicator(final String indicatorText, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-1164467527);
        ComposerKt.sourceInformation($composer3, "C(SelectTribeeListIndicator)N(indicatorText)129@4771L322:SelectTribeeList.kt#mscztr");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(indicatorText) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1164467527, $dirty2, -1, "kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListIndicator (SelectTribeeList.kt:128)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(24), 5, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -371456247, "C139@5064L6,136@4964L123:SelectTribeeList.kt#mscztr");
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(indicatorText, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, ($dirty2 & 14) | 24576, 0, 262122);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectTribeeListIndicator$lambda$1;
                    SelectTribeeListIndicator$lambda$1 = SelectTribeeListKt.SelectTribeeListIndicator$lambda$1(indicatorText, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectTribeeListIndicator$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectTribeeListItem$lambda$1$0(SelectableTribeePartition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v20 */
    public static final void SelectTribeeListItem(final SelectableTribeeItem tribeeItem, Modifier modifier, boolean isSelected, SelectableTribeePartition selectedPartition, boolean showDivider, Function0<Unit> function0, Function1<? super SelectableTribeePartition, Unit> function1, Function2<? super Long, ? super String, Unit> function2, Composer $composer, final int $changed, final int i) {
        boolean isSelected2;
        SelectableTribeePartition selectedPartition2;
        boolean showDivider2;
        int $dirty;
        Composer $composer2;
        Modifier modifier2;
        Function0 onItemClick;
        Function1 onPartitionClick;
        Function2 onItemExposure;
        boolean isSelected3;
        SelectableTribeePartition selectedPartition3;
        Function0 onItemClick2;
        Function1<? super SelectableTribeePartition, Unit> onPartitionClick2;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(tribeeItem, "tribeeItem");
        Composer $composer3 = $composer.startRestartGroup(1980324421);
        ComposerKt.sourceInformation($composer3, "C(SelectTribeeListItem)N(tribeeItem,modifier,isSelected,selectedPartition,showDivider,onItemClick,onPartitionClick,onItemExposure)151@5362L2,152@5426L2,155@5522L70,155@5492L100,159@5598L1117:SelectTribeeList.kt#mscztr");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(tribeeItem) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            isSelected2 = isSelected;
        } else if (($changed & 384) == 0) {
            isSelected2 = isSelected;
            $dirty2 |= $composer3.changed(isSelected2) ? 256 : 128;
        } else {
            isSelected2 = isSelected;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            selectedPartition2 = selectedPartition;
        } else if (($changed & 3072) == 0) {
            selectedPartition2 = selectedPartition;
            $dirty2 |= $composer3.changed(selectedPartition2) ? 2048 : 1024;
        } else {
            selectedPartition2 = selectedPartition;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            showDivider2 = showDivider;
        } else if (($changed & 24576) == 0) {
            showDivider2 = showDivider;
            $dirty2 |= $composer3.changed(showDivider2) ? 16384 : 8192;
        } else {
            showDivider2 = showDivider;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ($composer3.shouldExecute(($dirty2 & 4793491) != 4793490, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            if (i3 != 0) {
                isSelected2 = false;
            }
            if (i4 != 0) {
                selectedPartition2 = null;
            }
            if (i5 != 0) {
                showDivider2 = true;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 421264551, "CC(remember):SelectTribeeList.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onItemClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onItemClick2 = function0;
            }
            if (i7 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 421266599, "CC(remember):SelectTribeeList.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj) {
                            Unit SelectTribeeListItem$lambda$1$0;
                            SelectTribeeListItem$lambda$1$0 = SelectTribeeListKt.SelectTribeeListItem$lambda$1$0((SelectableTribeePartition) obj);
                            return SelectTribeeListItem$lambda$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                onPartitionClick2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onPartitionClick2 = function1;
            }
            Function2 onItemExposure2 = i8 != 0 ? null : function2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1980324421, $dirty2, -1, "kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListItem (SelectTribeeList.kt:154)");
            }
            Long valueOf = Long.valueOf(tribeeItem.getId());
            ComposerKt.sourceInformationMarkerStart($composer3, 421269739, "CC(remember):SelectTribeeList.kt#9igjgp");
            boolean invalid$iv = ((29360128 & $dirty2) == 8388608) | (($dirty2 & 14) == 4);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new SelectTribeeListKt$SelectTribeeListItem$3$1(onItemExposure2, tribeeItem, null);
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv3, $composer3, 0);
            Modifier modifier$iv$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), Dp.constructor-impl(16), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            onItemExposure = onItemExposure2;
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            modifier2 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i10 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 348478335, "C165@5740L41,166@5790L241,182@6393L43:SelectTribeeList.kt#mscztr");
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
            SelectTribeeListItemImageTextArea(tribeeItem.getImageUrl(), tribeeItem.getName(), tribeeItem.getDesc(), null, isSelected2, onItemClick2, $composer3, (($dirty2 << 6) & 57344) | (458752 & $dirty2), 8);
            if (!isSelected2 || tribeeItem.getPartitions().isEmpty()) {
                onItemClick = onItemClick2;
                $composer3.startReplaceGroup(342753223);
            } else {
                $composer3.startReplaceGroup(348826712);
                ComposerKt.sourceInformation($composer3, "175@6127L40,176@6180L194");
                onItemClick = onItemClick2;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer3, 6);
                SelectPartitionList(tribeeItem.getPartitions(), null, null, selectedPartition2, onPartitionClick2, $composer3, ($dirty2 & 7168) | (($dirty2 >> 6) & 57344), 6);
            }
            $composer3.endReplaceGroup();
            $dirty = $dirty2;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) 11.5d)), $composer3, 6);
            if (showDivider2) {
                $composer3.startReplaceGroup(349173137);
                ComposerKt.sourceInformation($composer3, "190@6664L6,185@6477L222");
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl((float) 0.5d)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_regular-0d7_KjU(), (Shape) null, 2, (Object) null), $composer3, 0);
            } else {
                $composer3.startReplaceGroup(342753223);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onPartitionClick = onPartitionClick2;
            isSelected3 = isSelected2;
            selectedPartition3 = selectedPartition2;
        } else {
            $dirty = $dirty2;
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            onItemClick = function0;
            onPartitionClick = function1;
            onItemExposure = function2;
            isSelected3 = isSelected2;
            selectedPartition3 = selectedPartition2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final boolean z = isSelected3;
            final SelectableTribeePartition selectableTribeePartition = selectedPartition3;
            final boolean z2 = showDivider2;
            final Function0 function02 = onItemClick;
            final Function1 function12 = onPartitionClick;
            final Function2 function22 = onItemExposure;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectTribeeListItem$lambda$4;
                    SelectTribeeListItem$lambda$4 = SelectTribeeListKt.SelectTribeeListItem$lambda$4(SelectableTribeeItem.this, modifier4, z, selectableTribeePartition, z2, function02, function12, function22, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectTribeeListItem$lambda$4;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v9 */
    public static final void SelectTribeeListItemImageTextArea(final String imageUrl, final String title, final String subtitle, Modifier modifier, boolean isSelected, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        boolean z;
        Function0 onItemClick;
        Composer $composer2;
        Modifier modifier2;
        boolean isSelected2;
        boolean isSelected3;
        final Function0 onItemClick2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv$iv$iv;
        long j;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Composer $composer4 = $composer.startRestartGroup(-415228723);
        ComposerKt.sourceInformation($composer4, "C(SelectTribeeListItemImageTextArea)N(imageUrl,title,subtitle,modifier,isSelected,onItemClick)203@6931L2,210@7078L17,205@6943L1727:SelectTribeeList.kt#mscztr");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(imageUrl) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(title) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changed(subtitle) ? 256 : 128;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            z = isSelected;
        } else if (($changed & 24576) == 0) {
            z = isSelected;
            $dirty |= $composer4.changed(z) ? 16384 : 8192;
        } else {
            z = isSelected;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= 196608;
            onItemClick = function0;
        } else if ((196608 & $changed) == 0) {
            onItemClick = function0;
            $dirty |= $composer4.changedInstance(onItemClick) ? 131072 : 65536;
        } else {
            onItemClick = function0;
        }
        if (!$composer4.shouldExecute((73875 & $dirty) != 73874, $dirty & 1)) {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            isSelected2 = z;
        } else {
            if ((i & 8) != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (i2 == 0) {
                isSelected3 = z;
            } else {
                isSelected3 = false;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, 397162127, "CC(remember):SelectTribeeList.kt#9igjgp");
                Object it$iv = $composer4.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onItemClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer4);
            } else {
                onItemClick2 = onItemClick;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-415228723, $dirty, -1, "kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListItemImageTextArea (SelectTribeeList.kt:204)");
            }
            Modifier modifier3 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(40));
            ComposerKt.sourceInformationMarkerStart($composer4, 397166846, "CC(remember):SelectTribeeList.kt#9igjgp");
            boolean invalid$iv = (458752 & $dirty) == 131072;
            Object it$iv2 = $composer4.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit SelectTribeeListItemImageTextArea$lambda$1$0;
                        SelectTribeeListItemImageTextArea$lambda$1$0 = SelectTribeeListKt.SelectTribeeListItemImageTextArea$lambda$1$0(onItemClick2);
                        return SelectTribeeListItemImageTextArea$lambda$1$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier3, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            Function0 onItemClick3 = onItemClick2;
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i5 = ((384 >> 6) & 112) | 6;
            RowScope $this$SelectTribeeListItemImageTextArea_u24lambda_u242 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -1053823677, "C213@7169L198,220@7376L39,221@7424L917:SelectTribeeList.kt#mscztr");
            Modifier clip = ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6)));
            ImageRequest imageRequest = new ImageRequest(imageUrl);
            Unit unit = Unit.INSTANCE;
            BiliImageKt.BiliImage(imageRequest.build(), clip, null, null, null, null, null, null, null, $composer4, 0, 508);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer4, 6);
            Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
            Modifier modifier$iv2 = SizeKt.fillMaxHeight$default(RowScope.-CC.weight$default($this$SelectTribeeListItemImageTextArea_u24lambda_u242, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = center;
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv2 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            $composer2 = $composer4;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 1046638417, "C228@7628L296:SelectTribeeList.kt#mscztr");
            long sp = TextUnitKt.getSp(14);
            if (isSelected3) {
                $composer$iv$iv$iv = $composer4;
                $composer4.startReplaceGroup(587955229);
                ComposerKt.sourceInformation($composer4, "231@7748L6");
                j = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU();
            } else {
                $composer$iv$iv$iv = $composer4;
                $composer4.startReplaceGroup(587956280);
                ComposerKt.sourceInformation($composer4, "231@7781L6");
                j = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU();
            }
            $composer4.endReplaceGroup();
            Composer $composer$iv$iv$iv2 = $composer$iv$iv$iv;
            TextKt.Text-Nvy7gAk(title, (Modifier) null, j, (TextAutoSize) null, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(20), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer4, (($dirty >> 3) & 14) | 24576, 25008, 239594);
            if (subtitle.length() > 0) {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(1046961312);
                ComposerKt.sourceInformation($composer3, "237@7982L40,241@8158L6,238@8039L278");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer3, 6);
                TextKt.Text-Nvy7gAk(subtitle, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(17), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, (($dirty >> 6) & 14) | 24576, 25008, 239594);
            } else {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(1039048655);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer$iv$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (isSelected3) {
                $composer4.startReplaceGroup(-1052673361);
                ComposerKt.sourceInformation($composer4, "249@8380L39,252@8520L18,253@8573L6,250@8432L222");
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer4, 6);
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getCheckmark_line_800($composer4, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU(), $composer4, Painter.$stable | 432, 0);
            } else {
                $composer4.startReplaceGroup(-1060982663);
            }
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            isSelected2 = isSelected3;
            onItemClick = onItemClick3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final boolean z2 = isSelected2;
            final Function0 function02 = onItemClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectTribeeListItemImageTextArea$lambda$3;
                    SelectTribeeListItemImageTextArea$lambda$3 = SelectTribeeListKt.SelectTribeeListItemImageTextArea$lambda$3(imageUrl, title, subtitle, modifier4, z2, function02, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectTribeeListItemImageTextArea$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectTribeeListItemImageTextArea$lambda$1$0(Function0 $onItemClick) {
        $onItemClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectPartitionList$lambda$0$0(SelectableTribeePartition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    public static final void SelectPartitionList(final List<SelectableTribeePartition> list, Modifier modifier, String title, SelectableTribeePartition selectedPartition, Function1<? super SelectableTribeePartition, Unit> function1, Composer $composer, final int $changed, final int i) {
        String title2;
        SelectableTribeePartition selectableTribeePartition;
        final Function1 onPartitionClick;
        Composer $composer2;
        Modifier modifier2;
        String title3;
        SelectableTribeePartition selectedPartition2;
        Function1 onPartitionClick2;
        Modifier modifier3;
        SelectableTribeePartition selectedPartition3;
        Function0 factory$iv$iv$iv;
        int i2;
        Intrinsics.checkNotNullParameter(list, "partitions");
        Composer $composer3 = $composer.startRestartGroup(-1498021758);
        ComposerKt.sourceInformation($composer3, "C(SelectPartitionList)N(partitions,modifier,title,selectedPartition,onPartitionClick)273@9150L6,268@9003L1269:SelectTribeeList.kt#mscztr");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                title2 = title;
                if ($composer3.changed(title2)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                title2 = title;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            title2 = title;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            selectableTribeePartition = selectedPartition;
        } else if (($changed & 3072) == 0) {
            selectableTribeePartition = selectedPartition;
            $dirty |= $composer3.changed(selectableTribeePartition) ? 2048 : 1024;
        } else {
            selectableTribeePartition = selectedPartition;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            onPartitionClick = function1;
        } else if (($changed & 24576) == 0) {
            onPartitionClick = function1;
            $dirty |= $composer3.changedInstance(onPartitionClick) ? 16384 : 8192;
        } else {
            onPartitionClick = function1;
        }
        if ($composer3.shouldExecute(($dirty & 9347) != 9346, $dirty & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "264@8815L56,266@8991L2");
            if (($changed & 1) != 0 && !$composer3.getDefaultsInvalid()) {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier3 = modifier;
                selectedPartition3 = selectableTribeePartition;
            } else {
                if ((i & 2) != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if ((i & 4) != 0) {
                    title2 = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_56(TribeeRes.INSTANCE.getString()), $composer3, 0);
                    $dirty &= -897;
                }
                if (i3 == 0) {
                    selectedPartition3 = selectableTribeePartition;
                } else {
                    selectedPartition3 = null;
                }
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -784855516, "CC(remember):SelectTribeeList.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function1() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda10
                            public final Object invoke(Object obj) {
                                Unit SelectPartitionList$lambda$0$0;
                                SelectPartitionList$lambda$0$0 = SelectTribeeListKt.SelectPartitionList$lambda$0$0((SelectableTribeePartition) obj);
                                return SelectPartitionList$lambda$0$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    Function1 onPartitionClick3 = it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    onPartitionClick = onPartitionClick3;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1498021758, $dirty, -1, "kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectPartitionList (SelectTribeeList.kt:267)");
            }
            final SelectableTribeePartition selectedPartition4 = selectedPartition3;
            Modifier modifier$iv = BackgroundKt.background-bw27NRU(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg2-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            modifier2 = modifier3;
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1744987956, "C277@9251L41,281@9393L6,278@9301L249,287@9559L40,295@9887L329,288@9608L608,304@10225L41:SelectTribeeList.kt#mscztr");
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
            String str = title2;
            TextKt.Text-Nvy7gAk(str, PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, (($dirty >> 6) & 14) | 24624, 0, 262120);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer3, 6);
            FlowLayoutKt.FlowRow(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), (Alignment.Vertical) null, 0, 0, ComposableLambdaKt.rememberComposableLambda(-328562147, true, new Function3() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SelectPartitionList$lambda$1$0;
                    SelectPartitionList$lambda$1$0 = SelectTribeeListKt.SelectPartitionList$lambda$1$0(list, selectedPartition4, onPartitionClick, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SelectPartitionList$lambda$1$0;
                }
            }, $composer3, 54), $composer3, 1573302, 56);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onPartitionClick2 = onPartitionClick;
            selectedPartition2 = selectedPartition4;
            title3 = title2;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            title3 = title2;
            selectedPartition2 = selectableTribeePartition;
            onPartitionClick2 = onPartitionClick;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final String str2 = title3;
            final SelectableTribeePartition selectableTribeePartition2 = selectedPartition2;
            final Function1 function12 = onPartitionClick2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectPartitionList$lambda$2;
                    SelectPartitionList$lambda$2 = SelectTribeeListKt.SelectPartitionList$lambda$2(list, modifier4, str2, selectableTribeePartition2, function12, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectPartitionList$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectPartitionList$lambda$1$0(List $partitions, SelectableTribeePartition $selectedPartition, final Function1 $onPartitionClick, FlowRowScope $this$FlowRow, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation($composer, "C*300@10142L31,297@9951L241:SelectTribeeList.kt#mscztr");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-328562147, $changed, -1, "kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectPartitionList.<anonymous>.<anonymous> (SelectTribeeList.kt:296)");
            }
            List $this$forEach$iv = $partitions;
            for (Object element$iv : $this$forEach$iv) {
                final SelectableTribeePartition partition = (SelectableTribeePartition) element$iv;
                String name = partition.getName();
                boolean z = $selectedPartition != null && $selectedPartition.getId() == partition.getId();
                Modifier modifier = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer, -1800849502, "CC(remember):SelectTribeeList.kt#9igjgp");
                boolean invalid$iv = $composer.changed($onPartitionClick) | $composer.changed(partition);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda7
                        public final Object invoke() {
                            Unit SelectPartitionList$lambda$1$0$0$0$0;
                            SelectPartitionList$lambda$1$0$0$0$0 = SelectTribeeListKt.SelectPartitionList$lambda$1$0$0$0$0($onPartitionClick, partition);
                            return SelectPartitionList$lambda$1$0$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                SelectPartitionListItem(name, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), z, $composer, 0, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectPartitionList$lambda$1$0$0$0$0(Function1 $onPartitionClick, SelectableTribeePartition $partition) {
        $onPartitionClick.invoke($partition);
        return Unit.INSTANCE;
    }

    public static final void SelectPartitionListItem(final String title, Modifier modifier, boolean isSelected, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Composer $composer2;
        Modifier modifier3;
        boolean isSelected2;
        Modifier modifier4;
        long j;
        long j2;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer3 = $composer.startRestartGroup(-944985237);
        ComposerKt.sourceInformation($composer3, "C(SelectPartitionListItem)N(title,modifier,isSelected)314@10412L555:SelectTribeeList.kt#mscztr");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            z = isSelected;
        } else if (($changed & 384) == 0) {
            z = isSelected;
            $dirty |= $composer3.changed(z) ? 256 : 128;
        } else {
            z = isSelected;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            isSelected2 = z;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                isSelected2 = z;
            } else {
                isSelected2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-944985237, $dirty2, -1, "kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectPartitionListItem (SelectTribeeList.kt:313)");
            }
            if (isSelected2) {
                $composer3.startReplaceGroup(-1892704998);
                ComposerKt.sourceInformation($composer3, "318@10540L6");
                j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink_thin-0d7_KjU();
            } else {
                $composer3.startReplaceGroup(-1892703794);
                ComposerKt.sourceInformation($composer3, "318@10578L6");
                j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU();
            }
            $composer3.endReplaceGroup();
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(modifier4, j, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(20))), Dp.constructor-impl(12), Dp.constructor-impl(4));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1427748370, "C322@10725L236:SelectTribeeList.kt#mscztr");
            long sp = TextUnitKt.getSp(12);
            if (isSelected2) {
                $composer3.startReplaceGroup(-2032150129);
                ComposerKt.sourceInformation($composer3, "325@10833L6");
                j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU();
            } else {
                $composer3.startReplaceGroup(-2032149078);
                ComposerKt.sourceInformation($composer3, "325@10866L6");
                j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU();
            }
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            modifier3 = modifier4;
            TextKt.Text-Nvy7gAk(title, (Modifier) null, j2, (TextAutoSize) null, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, ($dirty2 & 14) | 24576, 24960, 241642);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = isSelected2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectPartitionListItem$lambda$1;
                    SelectPartitionListItem$lambda$1 = SelectTribeeListKt.SelectPartitionListItem$lambda$1(title, modifier5, z2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectPartitionListItem$lambda$1;
                }
            });
        }
    }
}