package kntr.app.tribee.consume.page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.bapis.bilibili.app.dynamic.v2.KShareConfig;
import com.bapis.bilibili.app.dynamic.v2.KTribeeBaseInfo;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDesc;
import com.bapis.bilibili.app.dynamic.v2.KTribeeInteraction;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeContentState;
import kntr.app.tribee.share.ProviderDynamicShareContent_androidKt;
import kntr.app.tribee.share.ProviderIMShareContent_androidKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareContent;
import kntr.common.share.common.SharePanelHandler;
import kntr.common.share.common.ShareParams;
import kntr.common.share.common.ShareResult;
import kntr.common.share.common.ShareTarget;
import kntr.common.share.common.ui.SharePanelKt;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.tribee.consume.generated.resources.Res;
import srcs.app.tribee.consume.generated.resources.String0_commonMainKt;

/* compiled from: TribeeShareCompose.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"TribeeShare", "", "shareParams", "Lkntr/common/share/common/ShareParams;", "pageState", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;", "onPanelDismiss", "Lkotlin/Function0;", "(Lkntr/common/share/common/ShareParams;Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeShareComposeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeShare$lambda$0(ShareParams shareParams, TribeeHomeContentState tribeeHomeContentState, Function0 function0, int i, int i2, Composer composer, int i3) {
        TribeeShare(shareParams, tribeeHomeContentState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeShare$lambda$1(ShareParams shareParams, TribeeHomeContentState tribeeHomeContentState, Function0 function0, int i, int i2, Composer composer, int i3) {
        TribeeShare(shareParams, tribeeHomeContentState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeShare$lambda$3(ShareParams shareParams, TribeeHomeContentState tribeeHomeContentState, Function0 function0, int i, int i2, Composer composer, int i3) {
        TribeeShare(shareParams, tribeeHomeContentState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void TribeeShare(final ShareParams shareParams, final TribeeHomeContentState pageState, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Function0 function02;
        Function0 onPanelDismiss;
        final KTribeeDesc tribeeInfo;
        final KShareConfig shareConfig;
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Composer $composer2 = $composer.startRestartGroup(-1516114117);
        ComposerKt.sourceInformation($composer2, "C(TribeeShare)N(shareParams,pageState,onPanelDismiss)33@1448L41,35@1578L53,36@1666L7,37@1699L24,38@1752L1167,38@1728L1191:TribeeShareCompose.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(shareParams) : $composer2.changedInstance(shareParams) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(pageState) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            function02 = function0;
        } else if (($changed & 384) == 0) {
            function02 = function0;
            $dirty |= $composer2.changedInstance(function02) ? 256 : 128;
        } else {
            function02 = function0;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            onPanelDismiss = i2 != 0 ? null : function02;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1516114117, $dirty2, -1, "kntr.app.tribee.consume.page.TribeeShare (TribeeShareCompose.kt:30)");
            }
            KTribeeBaseInfo baseInfo = pageState.getBaseInfo();
            if (baseInfo == null || (tribeeInfo = baseInfo.getTribeeInfo()) == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    final Function0 function03 = onPanelDismiss;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeShareComposeKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TribeeShare$lambda$0;
                            TribeeShare$lambda$0 = TribeeShareComposeKt.TribeeShare$lambda$0(ShareParams.this, pageState, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return TribeeShare$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            KTribeeInteraction interaction = pageState.getInteraction();
            if (interaction == null || (shareConfig = interaction.getShare()) == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
                if (endRestartGroup2 != null) {
                    final Function0 function04 = onPanelDismiss;
                    endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeShareComposeKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TribeeShare$lambda$1;
                            TribeeShare$lambda$1 = TribeeShareComposeKt.TribeeShare$lambda$1(ShareParams.this, pageState, function04, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return TribeeShare$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            final String shareTitle = tribeeInfo.getTitle() + "｜bilibili" + StringResourcesKt.stringResource(String0_commonMainKt.getTribee_station(Res.string.INSTANCE), $composer2, 0);
            final String shareSubtitleWithLink = tribeeInfo.getTitle() + " " + tribeeInfo.getJumpUri() + " #" + StringResourcesKt.stringResource(String0_commonMainKt.getTribee_share_from_bilibili(Res.string.INSTANCE), $composer2, 0) + "#";
            CompositionLocal this_$iv = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Toaster toaster = (Toaster) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer2.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -991732374, "CC(remember):TribeeShareCompose.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(shareSubtitleWithLink) | $composer2.changedInstance(shareConfig) | $composer2.changedInstance(tribeeInfo) | (($dirty2 & 14) == 4 || (($dirty2 & 8) != 0 && $composer2.changedInstance(shareParams))) | $composer2.changed(shareTitle) | $composer2.changedInstance(coroutineScope) | $composer2.changedInstance(toaster) | (($dirty2 & 896) == 256);
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                final Function0 function05 = onPanelDismiss;
                value$iv = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeShareComposeKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit TribeeShare$lambda$2$0;
                        TribeeShare$lambda$2$0 = TribeeShareComposeKt.TribeeShare$lambda$2$0(function05, shareSubtitleWithLink, shareConfig, tribeeInfo, shareParams, shareTitle, coroutineScope, toaster, (SharePanelHandler) obj);
                        return TribeeShare$lambda$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SharePanelKt.SharePanel(shareParams, null, (Function1) value$iv, $composer2, ShareParams.$stable | ($dirty2 & 14), 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            onPanelDismiss = function02;
        }
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            final Function0 function06 = onPanelDismiss;
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeShareComposeKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeShare$lambda$3;
                    TribeeShare$lambda$3 = TribeeShareComposeKt.TribeeShare$lambda$3(ShareParams.this, pageState, function06, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeShare$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeShare$lambda$2$0(Function0 $onPanelDismiss, final String $shareSubtitleWithLink, final KShareConfig $shareConfig, final KTribeeDesc $tribeeInfo, final ShareParams $shareParams, final String $shareTitle, final CoroutineScope $coroutineScope, final Toaster $toaster, SharePanelHandler $this$SharePanel) {
        Intrinsics.checkNotNullParameter($this$SharePanel, "$this$SharePanel");
        $this$SharePanel.setOnProvideContent(new Function1() { // from class: kntr.app.tribee.consume.page.TribeeShareComposeKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                ShareContent TribeeShare$lambda$2$0$0;
                TribeeShare$lambda$2$0$0 = TribeeShareComposeKt.TribeeShare$lambda$2$0$0($shareSubtitleWithLink, $shareConfig, $tribeeInfo, $shareParams, $shareTitle, (ShareTarget) obj);
                return TribeeShare$lambda$2$0$0;
            }
        });
        $this$SharePanel.setOnShare(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeShareComposeKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2) {
                Unit TribeeShare$lambda$2$0$1;
                TribeeShare$lambda$2$0$1 = TribeeShareComposeKt.TribeeShare$lambda$2$0$1($coroutineScope, $toaster, (ShareTarget) obj, (ShareResult) obj2);
                return TribeeShare$lambda$2$0$1;
            }
        });
        $this$SharePanel.setOnPanelDismiss($onPanelDismiss);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShareContent TribeeShare$lambda$2$0$0(String $shareSubtitleWithLink, KShareConfig $shareConfig, KTribeeDesc $tribeeInfo, ShareParams $shareParams, String $shareTitle, ShareTarget target) {
        String subTitle;
        Intrinsics.checkNotNullParameter(target, "target");
        if (target instanceof ShareTarget.WeiBo) {
            subTitle = $shareSubtitleWithLink;
        } else {
            subTitle = $shareConfig.getSubTitle();
        }
        return new ShareContent(null, $shareTitle, subTitle, $shareConfig.getTargetUrl(), null, $tribeeInfo.getFaceUrl(), null, null, null, ProviderIMShareContent_androidKt.getConsumeShareIMContent($tribeeInfo, $shareParams, $shareConfig), ProviderDynamicShareContent_androidKt.getConsumeShareDynamicContent($tribeeInfo, $shareParams, $shareConfig), null, 2513, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeShare$lambda$2$0$1(CoroutineScope $coroutineScope, Toaster $toaster, ShareTarget shareTarget, ShareResult result) {
        Intrinsics.checkNotNullParameter(shareTarget, "<unused var>");
        Intrinsics.checkNotNullParameter(result, "result");
        BuildersKt.launch$default($coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new TribeeShareComposeKt$TribeeShare$1$1$2$1(result, $toaster, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}