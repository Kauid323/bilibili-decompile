package kntr.common.share.common.ui.internal;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ui.ShareChannelList;
import kntr.common.share.common.ui.ShareMenuViewStyle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: ShareMenuViewContent.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001aO\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\b\u001a\"\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001aO\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132&\u0010\b\u001a\"\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000eH\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001aW\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00132&\u0010\b\u001a\"\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000eH\u0003¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c²\u0006\n\u0010\u001d\u001a\u00020\u0019X\u008a\u008e\u0002"}, d2 = {"ShareMenuViewContent", "", "channels", "Lkntr/common/share/common/ui/ShareChannelList;", "style", "Lkntr/common/share/common/ui/ShareMenuViewStyle;", "modifier", "Landroidx/compose/ui/Modifier;", "itemContent", "Lkotlin/Function1;", "Lkntr/common/share/common/ui/ShareChannelList$Item;", "Lkotlin/ParameterName;", "name", "item", "Landroidx/compose/runtime/Composable;", "(Lkntr/common/share/common/ui/ShareChannelList;Lkntr/common/share/common/ui/ShareMenuViewStyle;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ShareMenuHorizontalView", "Lkntr/common/share/common/ui/ShareMenuViewStyle$Horizontal;", "itemSpacing", "Landroidx/compose/ui/unit/Dp;", "ShareMenuHorizontalView-6a0pyJM", "(Lkntr/common/share/common/ui/ShareChannelList;Lkntr/common/share/common/ui/ShareMenuViewStyle$Horizontal;FLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "ShareMenuVerticalView", "Lkntr/common/share/common/ui/ShareMenuViewStyle$Vertical;", "maxItemsPerRow", "", "ShareMenuVerticalView--jt2gSs", "(Lkntr/common/share/common/ui/ShareChannelList;Lkntr/common/share/common/ui/ShareMenuViewStyle$Vertical;IFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "common-ui_debug", "parentWidthPx"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareMenuViewContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareMenuHorizontalView_6a0pyJM$lambda$2(ShareChannelList shareChannelList, ShareMenuViewStyle.Horizontal horizontal, float f, Function3 function3, int i, Composer composer, int i2) {
        m2391ShareMenuHorizontalView6a0pyJM(shareChannelList, horizontal, f, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareMenuVerticalView__jt2gSs$lambda$2(ShareChannelList shareChannelList, ShareMenuViewStyle.Vertical vertical, int i, float f, Function3 function3, int i2, Composer composer, int i3) {
        m2392ShareMenuVerticalViewjt2gSs(shareChannelList, vertical, i, f, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareMenuViewContent$lambda$1(ShareChannelList shareChannelList, ShareMenuViewStyle shareMenuViewStyle, Modifier modifier, Function3 function3, int i, int i2, Composer composer, int i3) {
        ShareMenuViewContent(shareChannelList, shareMenuViewStyle, modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ShareMenuViewContent(final ShareChannelList channels, final ShareMenuViewStyle style, Modifier modifier, final Function3<? super ShareChannelList.Item, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(channels, "channels");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(function3, "itemContent");
        Composer $composer2 = $composer.startRestartGroup(-466665100);
        ComposerKt.sourceInformation($composer2, "C(ShareMenuViewContent)N(channels,style,modifier,itemContent)35@1446L1721,35@1436L1731:ShareMenuViewContent.kt#jnk1i1");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(channels) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer2.changed(style) : $composer2.changedInstance(style) ? 32 : 16;
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
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-466665100, $dirty2, -1, "kntr.common.share.common.ui.internal.ShareMenuViewContent (ShareMenuViewContent.kt:34)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(1004667068, true, new Function2() { // from class: kntr.common.share.common.ui.internal.ShareMenuViewContentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShareMenuViewContent$lambda$0;
                    ShareMenuViewContent$lambda$0 = ShareMenuViewContentKt.ShareMenuViewContent$lambda$0(modifier3, style, channels, function3, (Composer) obj, ((Integer) obj2).intValue());
                    return ShareMenuViewContent$lambda$0;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.internal.ShareMenuViewContentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShareMenuViewContent$lambda$1;
                    ShareMenuViewContent$lambda$1 = ShareMenuViewContentKt.ShareMenuViewContent$lambda$1(ShareChannelList.this, style, modifier4, function3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ShareMenuViewContent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareMenuViewContent$lambda$0(Modifier $modifier, ShareMenuViewStyle $style, ShareChannelList $channels, Function3 $itemContent, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C36@1477L33,37@1546L7,43@1687L82,39@1563L1598:ShareMenuViewContent.kt#jnk1i1");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1004667068, $changed, -1, "kntr.common.share.common.ui.internal.ShareMenuViewContent.<anonymous> (ShareMenuViewContent.kt:36)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -882588227, "CC(remember):ShareMenuViewContent.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableIntState parentWidthPx$delegate = (MutableIntState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density = (Density) consume;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default($modifier, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -882581458, "CC(remember):ShareMenuViewContent.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.common.share.common.ui.internal.ShareMenuViewContentKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit ShareMenuViewContent$lambda$0$3$0;
                        ShareMenuViewContent$lambda$0$3$0 = ShareMenuViewContentKt.ShareMenuViewContent$lambda$0$3$0(parentWidthPx$delegate, (IntSize) obj);
                        return ShareMenuViewContent$lambda$0$3$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = OnRemeasuredModifierKt.onSizeChanged(fillMaxWidth$default, (Function1) it$iv2);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1348194827, "C:ShareMenuViewContent.kt#jnk1i1");
            if (ShareMenuViewContent$lambda$0$1(parentWidthPx$delegate) > 0) {
                $composer.startReplaceGroup(-1348172725);
                ComposerKt.sourceInformation($composer, "");
                float itemWidthPx = density.toPx-0680j_4(DpSize.getWidth-D9Ej5fM($style.mo2370getItemSizeMYxV2XQ()));
                float minSpacingPx = density.toPx-0680j_4($style.mo2369getItemMinSpacingD9Ej5fM());
                float errorRadio = $style instanceof ShareMenuViewStyle.Horizontal ? 0.1f : 0.0f;
                int $changed$iv = ShareMenuViewContent$lambda$0$1(parentWidthPx$delegate);
                int maxItemsPerRow = RangesKt.coerceAtLeast((int) ((($changed$iv + minSpacingPx) / (itemWidthPx + minSpacingPx)) + errorRadio), 1);
                float spacingPx = maxItemsPerRow == 1 ? 0.0f : (ShareMenuViewContent$lambda$0$1(parentWidthPx$delegate) - (maxItemsPerRow * itemWidthPx)) / (maxItemsPerRow - 1);
                float spacing = density.toDp-u2uoSUM(spacingPx);
                if ($style instanceof ShareMenuViewStyle.Horizontal) {
                    $composer.startReplaceGroup(1896201515);
                    ComposerKt.sourceInformation($composer, "65@2738L201");
                    m2391ShareMenuHorizontalView6a0pyJM($channels, (ShareMenuViewStyle.Horizontal) $style, spacing, $itemContent, $composer, 0);
                    $composer.endReplaceGroup();
                } else if (!($style instanceof ShareMenuViewStyle.Vertical)) {
                    $composer.startReplaceGroup(1896198768);
                    $composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                } else {
                    $composer.startReplaceGroup(-1347042620);
                    ComposerKt.sourceInformation($composer, "73@3021L76");
                    m2392ShareMenuVerticalViewjt2gSs($channels, (ShareMenuViewStyle.Vertical) $style, maxItemsPerRow, spacing, $itemContent, $composer, 0);
                    $composer.endReplaceGroup();
                }
            } else {
                $composer.startReplaceGroup(-1350018496);
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final int ShareMenuViewContent$lambda$0$1(MutableIntState $parentWidthPx$delegate) {
        IntState $this$getValue$iv = (IntState) $parentWidthPx$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareMenuViewContent$lambda$0$3$0(MutableIntState $parentWidthPx$delegate, IntSize size) {
        $parentWidthPx$delegate.setIntValue((int) (size.unbox-impl() >> 32));
        return Unit.INSTANCE;
    }

    /* renamed from: ShareMenuHorizontalView-6a0pyJM  reason: not valid java name */
    private static final void m2391ShareMenuHorizontalView6a0pyJM(final ShareChannelList channels, final ShareMenuViewStyle.Horizontal style, final float f, final Function3<? super ShareChannelList.Item, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        boolean z;
        int $changed$iv$iv$iv;
        Modifier materialized$iv$iv;
        boolean z2;
        Composer $composer2 = $composer.startRestartGroup(-89902550);
        ComposerKt.sourceInformation($composer2, "C(ShareMenuHorizontalView)N(channels,style,itemSpacing:c#ui.unit.Dp,itemContent)88@3459L280:ShareMenuViewContent.kt#jnk1i1");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(channels) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(style) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(f) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-89902550, $dirty2, -1, "kntr.common.share.common.ui.internal.ShareMenuHorizontalView (ShareMenuViewContent.kt:87)");
            }
            Function3 row = ComposableLambdaKt.rememberComposableLambda(-812920242, true, new Function3() { // from class: kntr.common.share.common.ui.internal.ShareMenuViewContentKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ShareMenuHorizontalView_6a0pyJM$lambda$0;
                    ShareMenuHorizontalView_6a0pyJM$lambda$0 = ShareMenuViewContentKt.ShareMenuHorizontalView_6a0pyJM$lambda$0(f, function3, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ShareMenuHorizontalView_6a0pyJM$lambda$0;
                }
            }, $composer2, 54);
            if (!style.getMultiLine()) {
                $composer2.startReplaceGroup(1773685323);
                ComposerKt.sourceInformation($composer2, "111@4167L29");
                row.invoke(CollectionsKt.flatten(channels.getItems()), $composer2, 48);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(1773307030);
                ComposerKt.sourceInformation($composer2, "100@3775L370");
                ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Modifier modifier$iv = Modifier.Companion;
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv << 6) & 896) | 6;
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
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i = ($changed$iv$iv$iv2 >> 6) & 14;
                boolean z3 = false;
                ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i2 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -1629832587, "C:ShareMenuViewContent.kt#jnk1i1");
                $composer2.startReplaceGroup(-1299500769);
                ComposerKt.sourceInformation($composer2, "*107@4108L13");
                Iterable $this$forEachIndexed$iv = channels.getItems();
                boolean z4 = false;
                int index = 0;
                for (Object item$iv : $this$forEachIndexed$iv) {
                    int index$iv = index + 1;
                    if (index < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                    List rowItems = (List) item$iv;
                    if (index > 0) {
                        z = z4;
                        $composer2.startReplaceGroup(521551385);
                        ComposerKt.sourceInformation($composer2, "103@3900L57,104@3984L11,105@4016L57");
                        $changed$iv$iv$iv = $changed$iv$iv$iv2;
                        materialized$iv$iv = materialized$iv$iv2;
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(style.m2376getLineSpacingD9Ej5fM() / 2)), $composer2, 0);
                        style.getSeparator().invoke($composer2, 0);
                        z2 = z3;
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(style.m2376getLineSpacingD9Ej5fM() / 2)), $composer2, 0);
                    } else {
                        z = z4;
                        $changed$iv$iv$iv = $changed$iv$iv$iv2;
                        materialized$iv$iv = materialized$iv$iv2;
                        z2 = z3;
                        $composer2.startReplaceGroup(517696814);
                    }
                    $composer2.endReplaceGroup();
                    row.invoke(rowItems, $composer2, 48);
                    index = index$iv;
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    z4 = z;
                    $changed$iv$iv$iv2 = $changed$iv$iv$iv;
                    z3 = z2;
                    materialized$iv$iv2 = materialized$iv$iv;
                }
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.internal.ShareMenuViewContentKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShareMenuHorizontalView_6a0pyJM$lambda$2;
                    ShareMenuHorizontalView_6a0pyJM$lambda$2 = ShareMenuViewContentKt.ShareMenuHorizontalView_6a0pyJM$lambda$2(ShareChannelList.this, style, f, function3, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ShareMenuHorizontalView_6a0pyJM$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareMenuHorizontalView_6a0pyJM$lambda$0(float f, final Function3 $itemContent, final List it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)95@3680L53,89@3469L264:ShareMenuViewContent.kt#jnk1i1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-812920242, $changed, -1, "kntr.common.share.common.ui.internal.ShareMenuHorizontalView.<anonymous> (ShareMenuViewContent.kt:89)");
        }
        Modifier clipToBounds = ClipKt.clipToBounds(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null));
        Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(f);
        ComposerKt.sourceInformationMarkerStart($composer, 467702435, "CC(remember):ShareMenuViewContent.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(it) | $composer.changed($itemContent);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: kntr.common.share.common.ui.internal.ShareMenuViewContentKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    Unit ShareMenuHorizontalView_6a0pyJM$lambda$0$0$0;
                    ShareMenuHorizontalView_6a0pyJM$lambda$0$0$0 = ShareMenuViewContentKt.ShareMenuHorizontalView_6a0pyJM$lambda$0$0$0(it, $itemContent, (LazyListScope) obj);
                    return ShareMenuHorizontalView_6a0pyJM$lambda$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        LazyDslKt.LazyRow(clipToBounds, (LazyListState) null, (PaddingValues) null, false, horizontal, (Alignment.Vertical) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer, 6, 494);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareMenuHorizontalView_6a0pyJM$lambda$0$0$0(final List $it, final Function3 $itemContent, LazyListScope $this$LazyRow) {
        Intrinsics.checkNotNullParameter($this$LazyRow, "$this$LazyRow");
        final Function1 contentType$iv = new Function1() { // from class: kntr.common.share.common.ui.internal.ShareMenuViewContentKt$ShareMenuHorizontalView_6a0pyJM$lambda$0$0$0$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m2393invoke((ShareChannelList.Item) p1);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final Void m2393invoke(ShareChannelList.Item item) {
                return null;
            }
        };
        $this$LazyRow.items($it.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.common.share.common.ui.internal.ShareMenuViewContentKt$ShareMenuHorizontalView_6a0pyJM$lambda$0$0$0$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke($it.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.common.share.common.ui.internal.ShareMenuViewContentKt$ShareMenuHorizontalView_6a0pyJM$lambda$0$0$0$$inlined$items$default$4
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
                $composer.startReplaceGroup(1483735630);
                ComposerKt.sourceInformation($composer, "CN(it)*96@3706L15:ShareMenuViewContent.kt#jnk1i1");
                $itemContent.invoke((ShareChannelList.Item) $it.get(it), $composer, Integer.valueOf((($dirty & 14) >> 3) & 14));
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* renamed from: ShareMenuVerticalView--jt2gSs  reason: not valid java name */
    private static final void m2392ShareMenuVerticalViewjt2gSs(final ShareChannelList channels, final ShareMenuViewStyle.Vertical style, final int maxItemsPerRow, final float f, final Function3<? super ShareChannelList.Item, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1536182513);
        ComposerKt.sourceInformation($composer2, "C(ShareMenuVerticalView)N(channels,style,maxItemsPerRow,itemSpacing:c#ui.unit.Dp,itemContent)127@4645L421:ShareMenuViewContent.kt#jnk1i1");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(channels) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(style) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(maxItemsPerRow) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(f) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1536182513, $dirty2, -1, "kntr.common.share.common.ui.internal.ShareMenuVerticalView (ShareMenuViewContent.kt:122)");
            }
            List allItems = CollectionsKt.flatten(channels.getItems());
            List rows = CollectionsKt.chunked(allItems, maxItemsPerRow);
            final List displayRows = style.getScrollable() ? rows : CollectionsKt.take(rows, style.getMaxRows());
            Function2 content = ComposableLambdaKt.rememberComposableLambda(686293106, true, new Function2() { // from class: kntr.common.share.common.ui.internal.ShareMenuViewContentKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShareMenuVerticalView__jt2gSs$lambda$0;
                    ShareMenuVerticalView__jt2gSs$lambda$0 = ShareMenuViewContentKt.ShareMenuVerticalView__jt2gSs$lambda$0(ShareMenuViewStyle.Vertical.this, displayRows, f, function3, (Composer) obj, ((Integer) obj2).intValue());
                    return ShareMenuVerticalView__jt2gSs$lambda$0;
                }
            }, $composer2, 54);
            if (style.getScrollable() && rows.size() > style.getMaxRows()) {
                $composer2.startReplaceGroup(1537604688);
                ComposerKt.sourceInformation($composer2, "147@5339L21,143@5133L273");
                float f2 = DpSize.getHeight-D9Ej5fM(style.mo2370getItemSizeMYxV2XQ());
                int other$iv = style.getMaxRows();
                float f3 = Dp.constructor-impl(other$iv * f2);
                float m2382getLineSpacingD9Ej5fM = style.m2382getLineSpacingD9Ej5fM();
                int other$iv2 = style.getMaxRows() - 1;
                Modifier modifier$iv = ScrollKt.verticalScroll$default(SizeKt.heightIn-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(f3 + Dp.constructor-impl(other$iv2 * m2382getLineSpacingD9Ej5fM)), 1, (Object) null), ScrollKt.rememberScrollState(0, $composer2, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
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
                int i = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i2 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -326039352, "C149@5387L9:ShareMenuViewContent.kt#jnk1i1");
                content.invoke($composer2, 6);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(1537889144);
                ComposerKt.sourceInformation($composer2, "152@5428L9");
                content.invoke($composer2, 6);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.internal.ShareMenuViewContentKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShareMenuVerticalView__jt2gSs$lambda$2;
                    ShareMenuVerticalView__jt2gSs$lambda$2 = ShareMenuViewContentKt.ShareMenuVerticalView__jt2gSs$lambda$2(ShareChannelList.this, style, maxItemsPerRow, f, function3, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ShareMenuVerticalView__jt2gSs$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareMenuVerticalView__jt2gSs$lambda$0(ShareMenuViewStyle.Vertical $style, List $displayRows, float f, Function3 $itemContent, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        ComposerKt.sourceInformation($composer, "C128@4655L405:ShareMenuViewContent.kt#jnk1i1");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(686293106, $changed, -1, "kntr.common.share.common.ui.internal.ShareMenuVerticalView.<anonymous> (ShareMenuViewContent.kt:128)");
            }
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4($style.m2382getLineSpacingD9Ej5fM());
            Composer $composer$iv = $composer;
            boolean z = false;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer$iv, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv;
            Modifier modifier$iv$iv = modifier$iv;
            boolean z2 = false;
            String str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
            CompositionLocalMap localMap$iv$iv = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            String str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer$iv.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            boolean z3 = false;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            String str3 = "C:ShareMenuViewContent.kt#jnk1i1";
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1820140475, "C:ShareMenuViewContent.kt#jnk1i1");
            $composer$iv.startReplaceGroup(-772569412);
            ComposerKt.sourceInformation($composer$iv, "*132@4807L229");
            List $this$forEach$iv = $displayRows;
            for (Object element$iv : $this$forEach$iv) {
                Iterable row = (List) element$iv;
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                int compositeKeyHash$iv$iv2 = compositeKeyHash$iv$iv;
                Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(f);
                boolean z4 = z;
                boolean z5 = z3;
                int $changed$iv$iv2 = $changed$iv$iv;
                Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Arrangement.Horizontal horizontalArrangement$iv = horizontal;
                MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, str);
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
                String str4 = str;
                CompositionLocalMap localMap$iv$iv2 = $composer$iv.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = ((((6 << 3) & 112) << 6) & 896) | 6;
                Modifier modifier$iv$iv2 = modifier$iv$iv;
                boolean z6 = z2;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, str2);
                if (!($composer$iv.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv.startReusableNode();
                if ($composer$iv.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv.useNode();
                }
                String str5 = str2;
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv);
                Composer $composer$iv2 = $composer$iv;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i4 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -971950781, str3);
                $composer$iv.startReplaceGroup(-1001184452);
                ComposerKt.sourceInformation($composer$iv, "*136@5001L15");
                Iterable $this$forEach$iv3 = row;
                for (Object element$iv2 : $this$forEach$iv3) {
                    String str6 = str3;
                    ShareChannelList.Item it = (ShareChannelList.Item) element$iv2;
                    $itemContent.invoke(it, $composer$iv, 0);
                    str3 = str6;
                    $this$forEach$iv3 = $this$forEach$iv3;
                    localMap$iv$iv2 = localMap$iv$iv2;
                }
                $composer$iv.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                z2 = z6;
                $this$forEach$iv = $this$forEach$iv2;
                compositeKeyHash$iv$iv = compositeKeyHash$iv$iv2;
                z = z4;
                z3 = z5;
                $changed$iv$iv = $changed$iv$iv2;
                measurePolicy$iv$iv = measurePolicy$iv$iv2;
                str = str4;
                str2 = str5;
                modifier$iv$iv = modifier$iv$iv2;
                $composer$iv = $composer$iv2;
            }
            $composer$iv.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}