package kntr.common.photonic.aphro.ui.component;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.LongState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shape;
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
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.Asset;
import kntr.common.photonic.aphro.core.AphroAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: AlbumList.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\u001aM\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a3\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013²\u0006\f\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u008a\u008e\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0017X\u008a\u008e\u0002"}, d2 = {"AlbumList", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "albumList", "", "Lkntr/common/photonic/AlbumInfo;", "onAction", "Lkotlin/Function1;", "Lkntr/common/photonic/aphro/core/AphroAction;", "modifier", "Landroidx/compose/ui/Modifier;", "extraPadding", "Landroidx/compose/ui/unit/Dp;", "AlbumList-pHQ97Tc", "(JLjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;II)V", "AlbumItem", "album", "(Lkntr/common/photonic/AlbumInfo;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "thumbnail", "Lkntr/common/photonic/Asset;", "count", ""}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AlbumListKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlbumItem$lambda$2(AlbumInfo albumInfo, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AlbumItem(albumInfo, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlbumList_pHQ97Tc$lambda$1(long j, List list, Function1 function1, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        m2251AlbumListpHQ97Tc(j, list, function1, modifier, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* renamed from: AlbumList-pHQ97Tc  reason: not valid java name */
    public static final void m2251AlbumListpHQ97Tc(final long j, final List<? extends AlbumInfo> list, final Function1<? super AphroAction, Unit> function1, Modifier modifier, float f, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f2;
        float f3;
        Modifier modifier3;
        Modifier modifier4;
        float f4;
        Intrinsics.checkNotNullParameter(list, "albumList");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer2 = $composer.startRestartGroup(1848699540);
        ComposerKt.sourceInformation($composer2, "C(AlbumList)N(backgroundColor:c#ui.graphics.Color,albumList,onAction,modifier,extraPadding:c#ui.unit.Dp)56@2018L276,50@1815L479:AlbumList.kt#gh748z");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(j) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            f2 = f;
        } else if (($changed & 24576) == 0) {
            f2 = f;
            $dirty |= $composer2.changed(f2) ? 16384 : 8192;
        } else {
            f2 = f;
        }
        if (!$composer2.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            f3 = f2;
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                f4 = f2;
            } else {
                f4 = Dp.constructor-impl(0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1848699540, $dirty, -1, "kntr.common.photonic.aphro.ui.component.AlbumList (AlbumList.kt:49)");
            }
            Modifier modifier5 = PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), j, (Shape) null, 2, (Object) null), 0.0f, 0.0f, 0.0f, RangesKt.coerceAtLeast(Dp.box-impl(f4), Dp.box-impl(Dp.constructor-impl(0))).unbox-impl(), 7, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -1516189944, "CC(remember):AlbumList.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(list) | (($dirty & 896) == 256);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.common.photonic.aphro.ui.component.AlbumListKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit AlbumList_pHQ97Tc$lambda$0$0;
                        AlbumList_pHQ97Tc$lambda$0$0 = AlbumListKt.AlbumList_pHQ97Tc$lambda$0$0(list, function1, (LazyListScope) obj);
                        return AlbumList_pHQ97Tc$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyColumn(modifier5, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer2, 0, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            f3 = f4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final float f5 = f3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.component.AlbumListKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit AlbumList_pHQ97Tc$lambda$1;
                    AlbumList_pHQ97Tc$lambda$1 = AlbumListKt.AlbumList_pHQ97Tc$lambda$1(j, list, function1, modifier6, f5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AlbumList_pHQ97Tc$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlbumList_pHQ97Tc$lambda$0$0(final List $albumList, final Function1 $onAction, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final Function1 contentType$iv = new Function1() { // from class: kntr.common.photonic.aphro.ui.component.AlbumListKt$AlbumList_pHQ97Tc$lambda$0$0$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m2252invoke((AlbumInfo) p1);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final Void m2252invoke(AlbumInfo albumInfo) {
                return null;
            }
        };
        $this$LazyColumn.items($albumList.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.common.photonic.aphro.ui.component.AlbumListKt$AlbumList_pHQ97Tc$lambda$0$0$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke($albumList.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.common.photonic.aphro.ui.component.AlbumListKt$AlbumList_pHQ97Tc$lambda$0$0$$inlined$items$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                $composer.startReplaceGroup(1891867080);
                ComposerKt.sourceInformation($composer, "CN(it)*58@2059L23,60@2148L6,59@2095L183:AlbumList.kt#gh748z");
                AlbumListKt.AlbumItem((AlbumInfo) $albumList.get(it), $onAction, null, $composer, (($dirty & 14) >> 3) & 14, 4);
                DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer, 54, 0);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0275, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AlbumItem(final AlbumInfo album, final Function1<? super AphroAction, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(album, "album");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer2 = $composer.startRestartGroup(-935038151);
        ComposerKt.sourceInformation($composer2, "C(AlbumItem)N(album,onAction,modifier)78@2531L80,74@2427L1898:AlbumList.kt#gh748z");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(album) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
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
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-935038151, $dirty2, -1, "kntr.common.photonic.aphro.ui.component.AlbumItem (AlbumList.kt:73)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -923491095, "CC(remember):AlbumList.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(album) | (($dirty2 & 112) == 32);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.component.AlbumListKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit AlbumItem$lambda$0$0;
                        AlbumItem$lambda$0$0 = AlbumListKt.AlbumItem$lambda$0$0(function1, album);
                        return AlbumItem$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(fillMaxWidth$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(6));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((432 >> 6) & 112) | 6;
            RowScope $this$AlbumItem_u24lambda_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1374273980, "C84@2798L41,85@2861L35,86@2927L104,86@2905L126,119@4030L6,111@3730L367,126@4251L9,127@4296L6,122@4106L213:AlbumList.kt#gh748z");
            ComposerKt.sourceInformationMarkerStart($composer2, 1895330278, "CC(remember):AlbumList.kt#9igjgp");
            Object value$iv2 = $composer2.rememberedValue();
            if (value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
            }
            MutableState thumbnail$delegate = (MutableState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1895332288, "CC(remember):AlbumList.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotLongStateKt.mutableLongStateOf(0L);
                $composer2.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
            }
            MutableLongState count$delegate = (MutableLongState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1895334469, "CC(remember):AlbumList.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(album);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv4 = (Function2) new AlbumListKt$AlbumItem$2$1$1(album, thumbnail$delegate, count$delegate, null);
            $composer2.updateRememberedValue(value$iv4);
            it$iv3 = value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(album, (Function2) it$iv3, $composer2, $dirty2 & 14);
            $composer2.startReplaceGroup(1895338971);
            ComposerKt.sourceInformation($composer2, "");
            Asset it = AlbumItem$lambda$1$1(thumbnail$delegate);
            if (it != null) {
                $composer2.startReplaceGroup(2123209413);
                ComposerKt.sourceInformation($composer2, "98@3356L6,92@3103L294");
                MediaItemKt.Thumb(it, BackgroundKt.background-bw27NRU$default(SizeKt.size-3ABfNKs(ClipKt.clip(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), Dp.constructor-impl(60)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), (Shape) null, 2, (Object) null), $composer2, 0, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(2123537734);
                ComposerKt.sourceInformation($composer2, "106@3655L6,101@3435L261");
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.size-3ABfNKs(ClipKt.clip(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), Dp.constructor-impl(60)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), (Shape) null, 2, (Object) null), $composer2, 0);
                $composer2.endReplaceGroup();
            }
            $composer2.endReplaceGroup();
            TextKt.Text-Nvy7gAk(album.getTitle(), $this$AlbumItem_u24lambda_u241.weight(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(4), 0.0f, 10, (Object) null), 1.0f, false), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer2, 1572864, 24960, 241592);
            TextKt.Text-Nvy7gAk(String.valueOf(AlbumItem$lambda$1$4(count$delegate)), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 0, 24960, 110586);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.component.AlbumListKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit AlbumItem$lambda$2;
                    AlbumItem$lambda$2 = AlbumListKt.AlbumItem$lambda$2(AlbumInfo.this, function1, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AlbumItem$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlbumItem$lambda$0$0(Function1 $onAction, AlbumInfo $album) {
        $onAction.invoke(new AphroAction.SwitchAlbum($album));
        return Unit.INSTANCE;
    }

    private static final Asset AlbumItem$lambda$1$1(MutableState<Asset> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (Asset) $this$getValue$iv.getValue();
    }

    private static final long AlbumItem$lambda$1$4(MutableLongState $count$delegate) {
        LongState $this$getValue$iv = (LongState) $count$delegate;
        return $this$getValue$iv.getLongValue();
    }
}