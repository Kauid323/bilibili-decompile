package kntr.common.share.common.ui;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareLocalContext;
import kntr.common.share.common.ShareLog;
import kntr.common.share.common.ui.ShareChannelList;
import kntr.common.share.common.ui.ShareMenuViewAction;
import kntr.common.share.common.ui.ShareMenuViewStyle;
import kntr.common.share.common.ui.internal.ShareMenuViewContentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareMenuView.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a\u0089\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072^\b\u0002\u0010\b\u001aX\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u0084\u0002"}, d2 = {"ShareMenuView", "", "viewModel", "Lkntr/common/share/common/ui/ShareMenuVM;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Lkntr/common/share/common/ui/ShareMenuViewStyle;", "itemContent", "Lkotlin/Function3;", "Lkntr/common/share/common/ui/ShareChannelList$Item;", "Lkotlin/ParameterName;", "name", "item", "Lkotlin/Function1;", "onClick", "Landroidx/compose/runtime/Composable;", "(Lkntr/common/share/common/ui/ShareMenuVM;Landroidx/compose/ui/Modifier;Lkntr/common/share/common/ui/ShareMenuViewStyle;Lkotlin/jvm/functions/Function5;Landroidx/compose/runtime/Composer;II)V", "common-ui_debug", "state", "Lkntr/common/share/common/ui/ShareMenuViewState;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareMenuViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareMenuView$lambda$4(ShareMenuVM shareMenuVM, Modifier modifier, ShareMenuViewStyle shareMenuViewStyle, Function5 function5, int i, int i2, Composer composer, int i3) {
        ShareMenuView(shareMenuVM, modifier, shareMenuViewStyle, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ShareMenuView(final ShareMenuVM viewModel, Modifier modifier, ShareMenuViewStyle style, Function5<? super ShareChannelList.Item, ? super Modifier, ? super Function1<? super ShareChannelList.Item, Unit>, ? super Composer, ? super Integer, Unit> function5, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function5 function52;
        ShareMenuViewStyle style2;
        Function5 itemContent;
        Modifier modifier3;
        Modifier modifier4;
        final Function5 itemContent2;
        int i2;
        final ShareMenuViewStyle.Horizontal style3 = style;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer $composer2 = $composer.startRestartGroup(-846291286);
        ComposerKt.sourceInformation($composer2, "C(ShareMenuView)N(viewModel,modifier,style,itemContent)33@1212L16,43@1500L96,43@1477L119:ShareMenuView.kt#y4rqem");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(viewModel) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                if (($changed & 512) == 0 ? $composer2.changed(style3) : $composer2.changedInstance(style3)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            }
            i2 = 128;
            $dirty |= i2;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            function52 = function5;
        } else if (($changed & 3072) == 0) {
            function52 = function5;
            $dirty |= $composer2.changedInstance(function52) ? 2048 : 1024;
        } else {
            function52 = function5;
        }
        if ($composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier4 = modifier2;
                itemContent2 = function52;
            } else {
                if (i3 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 4) != 0) {
                    style3 = new ShareMenuViewStyle.Horizontal(false, 0.0f, null, 0L, 0.0f, 31, null);
                    $dirty &= -897;
                }
                itemContent2 = i4 != 0 ? ComposableSingletons$ShareMenuViewKt.INSTANCE.m2362getLambda$2108017961$common_ui_debug() : function52;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-846291286, $dirty, -1, "kntr.common.share.common.ui.ShareMenuView (ShareMenuView.kt:32)");
            }
            State state$delegate = SnapshotStateKt.collectAsState(viewModel.getState(), (CoroutineContext) null, $composer2, 0, 1);
            if (ShareMenuView$lambda$0(state$delegate).isLoadedChannelList()) {
                $composer2.startReplaceGroup(-406407784);
            } else {
                $composer2.startReplaceGroup(-405121501);
                ComposerKt.sourceInformation($composer2, "38@1384L81,38@1363L102");
                ShareLog.Companion.i("MenuView", "has not loaded channel list.");
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, -1537086181, "CC(remember):ShareMenuView.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance(viewModel);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = (Function2) new ShareMenuViewKt$ShareMenuView$1$1(viewModel, null);
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer2, 6);
            }
            $composer2.endReplaceGroup();
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1537082454, "CC(remember):ShareMenuView.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(viewModel);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.common.share.common.ui.ShareMenuViewKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        DisposableEffectResult ShareMenuView$lambda$2$0;
                        ShareMenuView$lambda$2$0 = ShareMenuViewKt.ShareMenuView$lambda$2$0(ShareMenuVM.this, (DisposableEffectScope) obj);
                        return ShareMenuView$lambda$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(unit2, (Function1) it$iv2, $composer2, 6);
            if (ShareMenuView$lambda$0(state$delegate).isLoadedChannelList()) {
                $composer2.startReplaceGroup(-404766458);
                ComposerKt.sourceInformation($composer2, "53@1717L21,54@1801L174,54@1747L228");
                viewModel.dispatch(ShareMenuViewAction.Show.INSTANCE);
                final ShareLocalContext ctx = SharePannel_androidKt.provideLocalContext($composer2, 0);
                ShareMenuViewContentKt.ShareMenuViewContent(ShareMenuView$lambda$0(state$delegate).getChannels(), style3, modifier4, ComposableLambdaKt.rememberComposableLambda(-460025307, true, new Function3() { // from class: kntr.common.share.common.ui.ShareMenuViewKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit ShareMenuView$lambda$3;
                        ShareMenuView$lambda$3 = ShareMenuViewKt.ShareMenuView$lambda$3(itemContent2, style3, viewModel, ctx, (ShareChannelList.Item) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return ShareMenuView$lambda$3;
                    }
                }, $composer2, 54), $composer2, (($dirty >> 3) & 112) | 3072 | (($dirty << 3) & 896), 0);
            } else {
                $composer2.startReplaceGroup(-406407784);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            style2 = style3;
            modifier3 = modifier4;
            itemContent = itemContent2;
        } else {
            $composer2.skipToGroupEnd();
            style2 = style3;
            itemContent = function52;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final ShareMenuViewStyle shareMenuViewStyle = style2;
            final Function5 function53 = itemContent;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.ShareMenuViewKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShareMenuView$lambda$4;
                    ShareMenuView$lambda$4 = ShareMenuViewKt.ShareMenuView$lambda$4(ShareMenuVM.this, modifier5, shareMenuViewStyle, function53, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ShareMenuView$lambda$4;
                }
            });
        }
    }

    private static final ShareMenuViewState ShareMenuView$lambda$0(State<ShareMenuViewState> state) {
        Object thisObj$iv = state.getValue();
        return (ShareMenuViewState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ShareMenuView$lambda$2$0(final ShareMenuVM $viewModel, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: kntr.common.share.common.ui.ShareMenuViewKt$ShareMenuView$lambda$2$0$$inlined$onDispose$1
            public void dispose() {
                ShareMenuVM.this.dispatch(ShareMenuViewAction.Hidden.INSTANCE);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareMenuView$lambda$3(Function5 $itemContent, ShareMenuViewStyle $style, final ShareMenuVM $viewModel, final ShareLocalContext $ctx, ShareChannelList.Item it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)55@1862L103,55@1815L150:ShareMenuView.kt#y4rqem");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-460025307, $changed, -1, "kntr.common.share.common.ui.ShareMenuView.<anonymous> (ShareMenuView.kt:55)");
        }
        Modifier modifier = SizeKt.size-6HolHcs(Modifier.Companion, $style.mo2370getItemSizeMYxV2XQ());
        ComposerKt.sourceInformationMarkerStart($composer, 297313516, "CC(remember):ShareMenuView.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance($viewModel) | $composer.changedInstance($ctx);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: kntr.common.share.common.ui.ShareMenuViewKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit ShareMenuView$lambda$3$0$0;
                    ShareMenuView$lambda$3$0$0 = ShareMenuViewKt.ShareMenuView$lambda$3$0$0(ShareMenuVM.this, $ctx, (ShareChannelList.Item) obj);
                    return ShareMenuView$lambda$3$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        $itemContent.invoke(it, modifier, (Function1) it$iv, $composer, Integer.valueOf($changed & 14));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareMenuView$lambda$3$0$0(ShareMenuVM $viewModel, ShareLocalContext $ctx, ShareChannelList.Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        $viewModel.dispatch(new ShareMenuViewAction.Click(item.getTarget(), $ctx));
        return Unit.INSTANCE;
    }
}