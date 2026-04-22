package kntr.app.tribee.invite.page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bapis.bilibili.app.dynamic.v2.KTribeeInviteCodeShareConfig;
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

/* compiled from: TribeeInviteShare.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aG\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"TribeeInviteShare", "", "shareParams", "Lkntr/common/share/common/ShareParams;", "shareConfig", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInviteCodeShareConfig;", "tribeeTitle", "", "tribeeFaceUrl", "tribeeId", "", "onPanelDismiss", "Lkotlin/Function0;", "(Lkntr/common/share/common/ShareParams;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInviteCodeShareConfig;Ljava/lang/String;Ljava/lang/String;JLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeInviteShareKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInviteShare$lambda$1(ShareParams shareParams, KTribeeInviteCodeShareConfig kTribeeInviteCodeShareConfig, String str, String str2, long j, Function0 function0, int i, int i2, Composer composer, int i3) {
        TribeeInviteShare(shareParams, kTribeeInviteCodeShareConfig, str, str2, j, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void TribeeInviteShare(final ShareParams shareParams, final KTribeeInviteCodeShareConfig shareConfig, final String tribeeTitle, final String tribeeFaceUrl, final long tribeeId, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Function0 function02;
        Composer $composer2;
        Function0 onPanelDismiss;
        int $dirty;
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        Intrinsics.checkNotNullParameter(shareConfig, "shareConfig");
        Intrinsics.checkNotNullParameter(tribeeTitle, "tribeeTitle");
        Intrinsics.checkNotNullParameter(tribeeFaceUrl, "tribeeFaceUrl");
        Composer $composer3 = $composer.startRestartGroup(-86228639);
        ComposerKt.sourceInformation($composer3, "C(TribeeInviteShare)N(shareParams,shareConfig,tribeeTitle,tribeeFaceUrl,tribeeId,onPanelDismiss)36@1418L55,39@1551L89,41@1673L7,42@1706L24,43@1759L1961,43@1735L1985:TribeeInviteShare.kt#8mvn07");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= ($changed & 8) == 0 ? $composer3.changed(shareParams) : $composer3.changedInstance(shareParams) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changedInstance(shareConfig) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(tribeeTitle) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(tribeeFaceUrl) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changed(tribeeId) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty2 |= 196608;
            function02 = function0;
        } else if (($changed & 196608) == 0) {
            function02 = function0;
            $dirty2 |= $composer3.changedInstance(function02) ? 131072 : 65536;
        } else {
            function02 = function0;
        }
        if ($composer3.shouldExecute(($dirty2 & 74899) != 74898, $dirty2 & 1)) {
            onPanelDismiss = i2 != 0 ? null : function02;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-86228639, $dirty2, -1, "kntr.app.tribee.invite.page.TribeeInviteShare (TribeeInviteShare.kt:34)");
            }
            final String shareTargetUrl = shareConfig.getJumpUrl();
            final String shareTitle = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_4(TribeeRes.INSTANCE.getString()), $composer3, 0);
            final String shareDesc = shareConfig.getText();
            final String shareSubtitleWithLink = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_9(TribeeRes.INSTANCE.getString()), new Object[]{tribeeTitle, shareConfig.getJumpUrl()}, $composer3, 0);
            CompositionLocal this_$iv = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Toaster toaster = (Toaster) consume;
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer3.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1261321494, "CC(remember):TribeeInviteShare.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(shareConfig) | $composer3.changed(shareTitle) | $composer3.changed(shareSubtitleWithLink) | $composer3.changed(shareDesc) | (($dirty2 & 14) == 4 || (($dirty2 & 8) != 0 && $composer3.changedInstance(shareParams))) | (($dirty2 & 7168) == 2048) | ((57344 & $dirty2) == 16384) | $composer3.changed(shareTargetUrl) | $composer3.changedInstance(coroutineScope) | $composer3.changedInstance(toaster) | ((458752 & $dirty2) == 131072);
            Object value$iv = $composer3.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                $dirty = $dirty2;
                final Function0 function03 = onPanelDismiss;
                $composer2 = $composer3;
                value$iv = new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteShareKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit TribeeInviteShare$lambda$0$0;
                        TribeeInviteShare$lambda$0$0 = TribeeInviteShareKt.TribeeInviteShare$lambda$0$0(function03, shareConfig, shareTitle, shareSubtitleWithLink, shareDesc, shareParams, tribeeFaceUrl, tribeeId, shareTargetUrl, coroutineScope, toaster, (SharePanelHandler) obj);
                        return TribeeInviteShare$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                $dirty = $dirty2;
                $composer2 = $composer3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SharePanelKt.SharePanel(shareParams, null, (Function1) value$iv, $composer2, ShareParams.$stable | ($dirty & 14), 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            onPanelDismiss = function02;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function0 function04 = onPanelDismiss;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.invite.page.TribeeInviteShareKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeInviteShare$lambda$1;
                    TribeeInviteShare$lambda$1 = TribeeInviteShareKt.TribeeInviteShare$lambda$1(ShareParams.this, shareConfig, tribeeTitle, tribeeFaceUrl, tribeeId, function04, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeInviteShare$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInviteShare$lambda$0$0(Function0 $onPanelDismiss, final KTribeeInviteCodeShareConfig $shareConfig, final String $shareTitle, final String $shareSubtitleWithLink, final String $shareDesc, final ShareParams $shareParams, final String $tribeeFaceUrl, final long $tribeeId, final String $shareTargetUrl, final CoroutineScope $coroutineScope, final Toaster $toaster, SharePanelHandler $this$SharePanel) {
        Intrinsics.checkNotNullParameter($this$SharePanel, "$this$SharePanel");
        $this$SharePanel.setOnProvideContent(new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteShareKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                ShareContent TribeeInviteShare$lambda$0$0$0;
                TribeeInviteShare$lambda$0$0$0 = TribeeInviteShareKt.TribeeInviteShare$lambda$0$0$0($shareConfig, $shareTitle, $shareSubtitleWithLink, $shareDesc, $shareParams, $tribeeFaceUrl, $tribeeId, $shareTargetUrl, (ShareTarget) obj);
                return TribeeInviteShare$lambda$0$0$0;
            }
        });
        $this$SharePanel.setOnShare(new Function2() { // from class: kntr.app.tribee.invite.page.TribeeInviteShareKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2) {
                Unit TribeeInviteShare$lambda$0$0$1;
                TribeeInviteShare$lambda$0$0$1 = TribeeInviteShareKt.TribeeInviteShare$lambda$0$0$1($coroutineScope, $toaster, (ShareTarget) obj, (ShareResult) obj2);
                return TribeeInviteShare$lambda$0$0$1;
            }
        });
        $this$SharePanel.setOnPanelDismiss($onPanelDismiss);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShareContent TribeeInviteShare$lambda$0$0$0(KTribeeInviteCodeShareConfig $shareConfig, String $shareTitle, String $shareSubtitleWithLink, String $shareDesc, ShareParams $shareParams, String $tribeeFaceUrl, long $tribeeId, String $shareTargetUrl, ShareTarget target) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(target, "target");
        if (target instanceof ShareTarget.Dynamic) {
            str = $shareConfig.getDynamicTitle();
        } else if (target instanceof ShareTarget.IM) {
            str = $shareConfig.getMessageTitle();
        } else {
            str = $shareTitle;
        }
        if (target instanceof ShareTarget.WeiBo) {
            str2 = $shareSubtitleWithLink;
        } else {
            str2 = $shareDesc;
        }
        return new ShareContent(null, str, str2, $shareTargetUrl, null, $tribeeFaceUrl, null, null, null, ProviderIMShareContent_androidKt.getInviteShareIMContent($shareParams, $shareConfig, $tribeeFaceUrl, $tribeeId), ProviderDynamicShareContent_androidKt.getInviteShareDynamicContent($shareParams, $shareConfig, $tribeeFaceUrl, $tribeeId), null, 2513, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInviteShare$lambda$0$0$1(CoroutineScope $coroutineScope, Toaster $toaster, ShareTarget shareTarget, ShareResult result) {
        Intrinsics.checkNotNullParameter(shareTarget, "<unused var>");
        Intrinsics.checkNotNullParameter(result, "result");
        BuildersKt.launch$default($coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new TribeeInviteShareKt$TribeeInviteShare$1$1$2$1(result, $toaster, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}