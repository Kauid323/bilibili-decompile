package kntr.common.ouro.common.ui.toolPanel;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.bilibili.emoticon.CollectionEmoticonPackageUiProvider;
import com.bilibili.emoticon.Emote;
import com.bilibili.emoticon.EmoticonPanelKt;
import com.bilibili.emoticon.EmoticonPanelParams;
import com.bilibili.emoticon.EmoticonType;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.komponent.UiComposableLike;
import kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelKt;
import kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelState;
import kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelStateKt;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.action.OuroDeleteByLengthAction;
import kntr.common.ouro.core.action.OuroInsertAction;
import kntr.common.ouro.core.action.OuroInsertStoragesAction;
import kntr.common.ouro.core.plugin.textStyle.OuroTextStyle;
import kntr.common.ouro.core.utils.EmoteHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StickerPanel.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001a[\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"StickerPanel", "", "businessType", "", "userId", "", "textStyle", "Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyle;", "onAction", "Lkotlin/Function1;", "Lkntr/common/ouro/core/action/OuroAction;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;JLkntr/common/ouro/core/plugin/textStyle/OuroTextStyle;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "onDismiss", "Lkotlin/Function0;", "expandablePanelState", "Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState;", "(Ljava/lang/String;JLkntr/common/ouro/core/plugin/textStyle/OuroTextStyle;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class StickerPanelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerPanel$lambda$1(String str, long j, OuroTextStyle ouroTextStyle, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        StickerPanel(str, j, ouroTextStyle, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerPanel$lambda$3(String str, long j, OuroTextStyle ouroTextStyle, Function1 function1, Function0 function0, Modifier modifier, ExpandablePanelState expandablePanelState, int i, int i2, Composer composer, int i3) {
        StickerPanel(str, j, ouroTextStyle, function1, function0, modifier, expandablePanelState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void StickerPanel(final String businessType, final long userId, final OuroTextStyle textStyle, final Function1<? super OuroAction, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Modifier modifier5;
        int $dirty;
        Intrinsics.checkNotNullParameter(businessType, "businessType");
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer2 = $composer.startRestartGroup(673297198);
        ComposerKt.sourceInformation($composer2, "C(StickerPanel)N(businessType,userId,textStyle,onAction,modifier)29@1208L834,53@2072L31,54@2108L38:StickerPanel.kt#wsnt7k");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(businessType) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(userId) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(textStyle) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty2 |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty3 = $dirty2;
        if ($composer2.shouldExecute(($dirty3 & 9363) != 9362, $dirty3 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(673297198, $dirty3, -1, "kntr.common.ouro.common.ui.toolPanel.StickerPanel (StickerPanel.kt:27)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1501447440, "CC(remember):StickerPanel.kt#9igjgp");
            Object value$iv = $composer2.rememberedValue();
            if (value$iv == Composer.Companion.getEmpty()) {
                modifier5 = modifier4;
                $dirty = $dirty3;
                value$iv = new EmoticonPanelParams(businessType, Long.valueOf(userId), (Long) null, new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.StickerPanelKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit StickerPanel$lambda$0$0;
                        StickerPanel$lambda$0$0 = StickerPanelKt.StickerPanel$lambda$0$0(function1);
                        return StickerPanel$lambda$0$0;
                    }
                }, new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.StickerPanelKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit StickerPanel$lambda$0$1;
                        StickerPanel$lambda$0$1 = StickerPanelKt.StickerPanel$lambda$0$1(function1, textStyle, (Emote) obj);
                        return StickerPanel$lambda$0$1;
                    }
                }, (CollectionEmoticonPackageUiProvider) null, 32, (DefaultConstructorMarker) null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                modifier5 = modifier4;
                $dirty = $dirty3;
            }
            EmoticonPanelParams params = (EmoticonPanelParams) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            UiComposableLike emoticonComponent = EmoticonPanelKt.rememberEmoticonPanelUi(params, $composer2, EmoticonPanelParams.$stable);
            Modifier modifier6 = modifier5;
            emoticonComponent.invoke(modifier6, $composer2, ($dirty >> 12) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.common.ui.toolPanel.StickerPanelKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit StickerPanel$lambda$1;
                    StickerPanel$lambda$1 = StickerPanelKt.StickerPanel$lambda$1(businessType, userId, textStyle, function1, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return StickerPanel$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerPanel$lambda$0$0(Function1 $onAction) {
        $onAction.invoke(new OuroDeleteByLengthAction(1, null, null, 6, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerPanel$lambda$0$1(Function1 $onAction, OuroTextStyle $textStyle, Emote emote) {
        Intrinsics.checkNotNullParameter(emote, "emote");
        if (EmoticonType.equals-impl0(emote.getType-qKOx0pE(), EmoticonType.Companion.getTEXT-qKOx0pE())) {
            $onAction.invoke(new OuroInsertAction(emote.getName(), null, null, $textStyle.getMarks(), null, false, null, ConstantsKt.RECOMMEND_RESERVATION_CARD_HEIGHT, null));
        } else {
            $onAction.invoke(new OuroInsertStoragesAction(CollectionsKt.listOf(EmoteHelperKt.nodeStorage$default(emote, null, 1, null)), null, null, 6, null));
        }
        return Unit.INSTANCE;
    }

    public static final void StickerPanel(final String businessType, final long userId, final OuroTextStyle textStyle, final Function1<? super OuroAction, Unit> function1, final Function0<Unit> function0, Modifier modifier, ExpandablePanelState expandablePanelState, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ExpandablePanelState expandablePanelState2;
        Modifier modifier3;
        ExpandablePanelState expandablePanelState3;
        int $dirty;
        int i2;
        Intrinsics.checkNotNullParameter(businessType, "businessType");
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Composer $composer2 = $composer.startRestartGroup(1741141455);
        ComposerKt.sourceInformation($composer2, "C(StickerPanel)N(businessType,userId,textStyle,onAction,onDismiss,modifier,expandablePanelState)71@2569L248,67@2441L376:StickerPanel.kt#wsnt7k");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(businessType) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(userId) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(textStyle) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 16384 : 8192;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty2 |= 196608;
            modifier2 = modifier;
        } else if ((196608 & $changed) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                expandablePanelState2 = expandablePanelState;
                if ($composer2.changed(expandablePanelState2)) {
                    i2 = 1048576;
                    $dirty2 |= i2;
                }
            } else {
                expandablePanelState2 = expandablePanelState;
            }
            i2 = 524288;
            $dirty2 |= i2;
        } else {
            expandablePanelState2 = expandablePanelState;
        }
        int $dirty3 = $dirty2;
        if ($composer2.shouldExecute(($dirty3 & 599187) != 599186, $dirty3 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "65@2401L30");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty3 &= -3670017;
                }
                modifier3 = modifier2;
                $dirty = $dirty3;
            } else {
                if (i3 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i & 64) == 0) {
                    expandablePanelState2 = expandablePanelState;
                    $dirty = $dirty3;
                } else {
                    expandablePanelState2 = ExpandablePanelStateKt.rememberExpandablePanelState(null, false, null, null, $composer2, 0, 15);
                    $dirty = $dirty3 & (-3670017);
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1741141455, $dirty, -1, "kntr.common.ouro.common.ui.toolPanel.StickerPanel (StickerPanel.kt:66)");
            }
            ExpandablePanelKt.ExpandablePanel(modifier3, expandablePanelState2, function0, ComposableLambdaKt.rememberComposableLambda(-1917734415, true, new Function2() { // from class: kntr.common.ouro.common.ui.toolPanel.StickerPanelKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit StickerPanel$lambda$2;
                    StickerPanel$lambda$2 = StickerPanelKt.StickerPanel$lambda$2(businessType, userId, textStyle, function1, (Composer) obj, ((Integer) obj2).intValue());
                    return StickerPanel$lambda$2;
                }
            }, $composer2, 54), $composer2, (($dirty >> 15) & 14) | 3072 | (($dirty >> 15) & 112) | (($dirty >> 6) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            expandablePanelState3 = expandablePanelState2;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            expandablePanelState3 = expandablePanelState;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final ExpandablePanelState expandablePanelState4 = expandablePanelState3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.common.ui.toolPanel.StickerPanelKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit StickerPanel$lambda$3;
                    StickerPanel$lambda$3 = StickerPanelKt.StickerPanel$lambda$3(businessType, userId, textStyle, function1, function0, modifier4, expandablePanelState4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return StickerPanel$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerPanel$lambda$2(String $businessType, long $userId, OuroTextStyle $textStyle, Function1 $onAction, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C72@2579L232:StickerPanel.kt#wsnt7k");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1917734415, $changed, -1, "kntr.common.ouro.common.ui.toolPanel.StickerPanel.<anonymous> (StickerPanel.kt:72)");
            }
            StickerPanel($businessType, $userId, $textStyle, $onAction, WindowInsetsPadding_androidKt.navigationBarsPadding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null)), $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}