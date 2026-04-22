package kntr.app.tribee.steam.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.dynamic.v2.KTipsFootCard;
import com.bapis.bilibili.app.dynamic.v2.KToastDialog;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.tribee.steam.track.SteamTrackerKt;
import kntr.app.tribee.steam.viewmodel.TribeeSteamStateAction;
import kntr.app.tribee.steam.viewmodel.TribeeSteamUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TipsFootCard.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\u001aO\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\f\u001aC\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\b\b\u0002\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u0014¨\u0006\u0015²\u0006\n\u0010\u0016\u001a\u00020\u0017X\u008a\u008e\u0002"}, d2 = {"showKTipsFootCard", "", "Landroidx/compose/foundation/layout/BoxScope;", "tipsFootCard", "Lcom/bapis/bilibili/app/dynamic/v2/KTipsFootCard;", "onStateAction", "Lkotlin/Function1;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "modifier", "Landroidx/compose/ui/Modifier;", "onUIAction", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "(Landroidx/compose/foundation/layout/BoxScope;Lcom/bapis/bilibili/app/dynamic/v2/KTipsFootCard;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "KTipsFootCard", "title", "", "confirmButtonText", "onGoToSteamBindClick", "Lkotlin/Function0;", "onCloseClick", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "consume_debug", "isShowTipFootCard", ""}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TipsFootCardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KTipsFootCard$lambda$2(String str, String str2, Function0 function0, Function0 function02, Modifier modifier, int i, int i2, Composer composer, int i3) {
        KTipsFootCard(str, str2, function0, function02, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showKTipsFootCard$lambda$5(BoxScope boxScope, KTipsFootCard kTipsFootCard, Function1 function1, Modifier modifier, Function1 function12, int i, int i2, Composer composer, int i3) {
        showKTipsFootCard(boxScope, kTipsFootCard, function1, modifier, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showKTipsFootCard$lambda$0$0(TribeeSteamUIAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x0190, code lost:
        if (r1 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L77;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void showKTipsFootCard(final BoxScope $this$showKTipsFootCard, final KTipsFootCard tipsFootCard, final Function1<? super TribeeSteamStateAction, Unit> function1, Modifier modifier, Function1<? super TribeeSteamUIAction, Unit> function12, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 onUIAction;
        int $dirty;
        Modifier modifier3;
        Modifier modifier4;
        final Function1 onUIAction2;
        Intrinsics.checkNotNullParameter($this$showKTipsFootCard, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onStateAction");
        Composer $composer2 = $composer.startRestartGroup(987361109);
        ComposerKt.sourceInformation($composer2, "C(showKTipsFootCard)N(tipsFootCard,onStateAction,modifier,onUIAction)46@2062L2,48@2099L61:TipsFootCard.kt#k3l5ii");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed($this$showKTipsFootCard) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(tipsFootCard) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 24576;
            onUIAction = function12;
        } else if (($changed & 24576) == 0) {
            onUIAction = function12;
            $dirty2 |= $composer2.changedInstance(onUIAction) ? 16384 : 8192;
        } else {
            onUIAction = function12;
        }
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -333740201, "CC(remember):TipsFootCard.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.page.TipsFootCardKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit showKTipsFootCard$lambda$0$0;
                            showKTipsFootCard$lambda$0$0 = TipsFootCardKt.showKTipsFootCard$lambda$0$0((TribeeSteamUIAction) obj);
                            return showKTipsFootCard$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onUIAction2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onUIAction2 = onUIAction;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(987361109, $dirty2, -1, "kntr.app.tribee.steam.page.showKTipsFootCard (TipsFootCard.kt:47)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -333738958, "CC(remember):TipsFootCard.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(tipsFootCard != null), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableState isShowTipFootCard$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (showKTipsFootCard$lambda$2(isShowTipFootCard$delegate)) {
                $composer2.startReplaceGroup(-333734286);
                ComposerKt.sourceInformation($composer2, "");
                if (tipsFootCard == null) {
                    $composer2.startReplaceGroup(-1755828273);
                    $composer2.endReplaceGroup();
                    $dirty = $dirty2;
                } else {
                    $composer2.startReplaceGroup(-1755828272);
                    ComposerKt.sourceInformation($composer2, "*57@2383L552,71@2968L65,54@2239L1049");
                    String title = tipsFootCard.getTitle();
                    String confirmText = tipsFootCard.getConfirmText();
                    ComposerKt.sourceInformationMarkerStart($composer2, 1820261670, "CC(remember):TipsFootCard.kt#9igjgp");
                    boolean invalid$iv = $composer2.changedInstance(tipsFootCard) | (($dirty2 & 896) == 256) | ((57344 & $dirty2) == 16384);
                    $dirty = $dirty2;
                    Object value$iv3 = $composer2.rememberedValue();
                    if (invalid$iv) {
                    }
                    value$iv3 = new Function0() { // from class: kntr.app.tribee.steam.page.TipsFootCardKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit showKTipsFootCard$lambda$4$0$0;
                            showKTipsFootCard$lambda$4$0$0 = TipsFootCardKt.showKTipsFootCard$lambda$4$0$0(tipsFootCard, function1, onUIAction2);
                            return showKTipsFootCard$lambda$4$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    Function0 function0 = value$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, 1820279903, "CC(remember):TipsFootCard.kt#9igjgp");
                    Object it$iv3 = $composer2.rememberedValue();
                    if (it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv4 = new Function0() { // from class: kntr.app.tribee.steam.page.TipsFootCardKt$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                Unit showKTipsFootCard$lambda$4$1$0;
                                showKTipsFootCard$lambda$4$1$0 = TipsFootCardKt.showKTipsFootCard$lambda$4$1$0(isShowTipFootCard$delegate);
                                return showKTipsFootCard$lambda$4$1$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv4);
                        it$iv3 = value$iv4;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    KTipsFootCard(title, confirmText, function0, (Function0) it$iv3, PaddingKt.padding-qDBjuR0$default(WindowInsetsPadding_androidKt.navigationBarsPadding($this$showKTipsFootCard.align(modifier4, Alignment.Companion.getBottomCenter())), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(28), 7, (Object) null), $composer2, 3072, 0);
                    $composer2.endReplaceGroup();
                }
            } else {
                $dirty = $dirty2;
                $composer2.startReplaceGroup(-1758058195);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            onUIAction = onUIAction2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function1 function13 = onUIAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TipsFootCardKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit showKTipsFootCard$lambda$5;
                    showKTipsFootCard$lambda$5 = TipsFootCardKt.showKTipsFootCard$lambda$5($this$showKTipsFootCard, tipsFootCard, function1, modifier5, function13, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return showKTipsFootCard$lambda$5;
                }
            });
        }
    }

    private static final boolean showKTipsFootCard$lambda$2(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void showKTipsFootCard$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showKTipsFootCard$lambda$4$0$0(KTipsFootCard $card, Function1 $onStateAction, Function1 $onUIAction) {
        if ($card.getToast() == null) {
            SteamTrackerKt.reportSteamPageFloatClick("bind");
            $onStateAction.invoke(new TribeeSteamStateAction.GoToSteamBind($card.getConfirmTextJumpUrl(), null, 2, null));
        } else {
            KToastDialog it = $card.getToast();
            if (it != null) {
                $onUIAction.invoke(new TribeeSteamUIAction.ToastDialog(it));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showKTipsFootCard$lambda$4$1$0(MutableState $isShowTipFootCard$delegate) {
        showKTipsFootCard$lambda$3($isShowTipFootCard$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x04f7, code lost:
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L62;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void KTipsFootCard(final String title, final String confirmButtonText, final Function0<Unit> function0, final Function0<Unit> function02, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Composer $composer2;
        Modifier modifier$iv$iv;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(-549468738);
        ComposerKt.sourceInformation($composer3, "C(KTipsFootCard)N(title,confirmButtonText,onGoToSteamBindClick,onCloseClick,modifier)93@3529L43,93@3508L64,112@4122L6,96@3577L2143:TipsFootCard.kt#k3l5ii");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(confirmButtonText) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changedInstance(function02) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty2 |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        if ($composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-549468738, $dirty2, -1, "kntr.app.tribee.steam.page.KTipsFootCard (TipsFootCard.kt:92)");
            }
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 241526665, "CC(remember):TipsFootCard.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new TipsFootCardKt$KTipsFootCard$1$1(null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer3, 6);
            Modifier modifier$iv$iv2 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(ShadowKt.shadow-s4CzXII$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(modifier3, Dp.constructor-impl(12), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(48)), Dp.constructor-impl(8), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)), false, 0L, Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 12, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1_float-0d7_KjU(), (Shape) null, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            modifier$iv$iv = modifier3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv$iv2);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((384 >> 6) & 112) | 6;
            RowScope $this$KTipsFootCard_u24lambda_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -2004664586, "C118@4293L9,119@4339L6,116@4231L187,122@4427L38,132@4834L6,131@4775L95,134@4882L180,123@4474L588,141@5071L643:TipsFootCard.kt#k3l5ii");
            TextKt.Text-Nvy7gAk(title, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14b(), $composer3, ($dirty2 & 14) | 48, 0, 131064);
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$KTipsFootCard_u24lambda_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
            ButtonKt.Button(function0, ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(72)), Dp.constructor-impl(24)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), false, (Shape) null, ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(0L, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0L, 0L, $composer3, ButtonDefaults.$stable << 12, 13), (ButtonElevation) null, (BorderStroke) null, PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0)), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-1542263790, true, new Function3() { // from class: kntr.app.tribee.steam.page.TipsFootCardKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit KTipsFootCard$lambda$1$0;
                    KTipsFootCard$lambda$1$0 = TipsFootCardKt.KTipsFootCard$lambda$1$0(confirmButtonText, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return KTipsFootCard$lambda$1$0;
                }
            }, $composer3, 54), $composer3, (($dirty2 >> 6) & 14) | 817889280, 364);
            Modifier modifier$iv = SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(30)), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i6 = ((6 >> 6) & 112) | 6;
            BoxScope $this$KTipsFootCard_u24lambda_u241_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 700932663, "C148@5265L20,150@5371L6,156@5619L70,147@5220L484:TipsFootCard.kt#k3l5ii");
            Painter xmark_close_line_900 = BiliIconfont.INSTANCE.getXmark_close_line_900($composer3, 6);
            long j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU();
            Modifier align = $this$KTipsFootCard_u24lambda_u241_u241.align(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(6), Dp.constructor-impl(6), 0.0f, 9, (Object) null), Dp.constructor-impl(12)), Alignment.Companion.getTopEnd());
            ComposerKt.sourceInformationMarkerStart($composer3, 1131001742, "CC(remember):TipsFootCard.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 7168) == 2048;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv) {
                $dirty = $dirty2;
            } else {
                $dirty = $dirty2;
            }
            Object value$iv2 = new Function0() { // from class: kntr.app.tribee.steam.page.TipsFootCardKt$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit KTipsFootCard$lambda$1$1$0$0;
                    KTipsFootCard$lambda$1$1$0$0 = TipsFootCardKt.KTipsFootCard$lambda$1$1$0$0(function02);
                    return KTipsFootCard$lambda$1$1$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            IconKt.Icon-ww6aTOc(xmark_close_line_900, "close icon", ClickableKt.clickable-oSLSa3U$default(align, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), j, $composer3, Painter.$stable | 48, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
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
            $dirty = $dirty2;
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier$iv$iv = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier$iv$iv;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TipsFootCardKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit KTipsFootCard$lambda$2;
                    KTipsFootCard$lambda$2 = TipsFootCardKt.KTipsFootCard$lambda$2(title, confirmButtonText, function0, function02, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return KTipsFootCard$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KTipsFootCard$lambda$1$0(String $confirmButtonText, RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C137@4971L9,138@5020L6,135@4896L156:TipsFootCard.kt#k3l5ii");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1542263790, $changed, -1, "kntr.app.tribee.steam.page.KTipsFootCard.<anonymous>.<anonymous> (TipsFootCard.kt:135)");
            }
            TextKt.Text-Nvy7gAk($confirmButtonText, (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT13(), $composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KTipsFootCard$lambda$1$1$0$0(Function0 $onCloseClick) {
        $onCloseClick.invoke();
        return Unit.INSTANCE;
    }
}