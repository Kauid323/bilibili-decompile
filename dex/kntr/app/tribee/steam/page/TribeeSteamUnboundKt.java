package kntr.app.tribee.steam.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bapis.bilibili.app.dynamic.v2.KTipsCard;
import com.bapis.bilibili.app.dynamic.v2.KToastDialog;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeNotBindResp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.iconfont.BiliIconfontKt;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.tribee.steam.state.TribeeSteamState;
import kntr.app.tribee.steam.track.SteamTrackerKt;
import kntr.app.tribee.steam.viewmodel.TribeeSteamStateAction;
import kntr.app.tribee.steam.viewmodel.TribeeSteamUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.base.net.comm.imp.InitGMultiDomainKt;
import kntr.common.compose.res.CommonRes;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.ImageResourcesKt;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.common.compose.res.generated.resources.Drawable0_commonMainKt;

/* compiled from: TribeeSteamUnbound.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aO\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\u000b\u001ak\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u0015\u001a!\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"TribeeSteamUnboundPage", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Lkntr/app/tribee/steam/state/TribeeSteamState;", "onStateAction", "Lkotlin/Function1;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "onUIAction", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "(Landroidx/compose/ui/Modifier;Lkntr/app/tribee/steam/state/TribeeSteamState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "TribeeSteamUnboundContent", "picUrl", "", "text", "desc", "buttonString", "buttonUrl", "bindTribeeTialog", "Lcom/bapis/bilibili/app/dynamic/v2/KToastDialog;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bapis/bilibili/app/dynamic/v2/KToastDialog;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "TribeeSteamUnboundNavigation", "title", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamUnboundKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamUnboundContent$lambda$2(Modifier modifier, String str, String str2, String str3, String str4, String str5, KToastDialog kToastDialog, Function1 function1, int i, int i2, Composer composer, int i3) {
        TribeeSteamUnboundContent(modifier, str, str2, str3, str4, str5, kToastDialog, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamUnboundNavigation$lambda$2(Modifier modifier, String str, int i, int i2, Composer composer, int i3) {
        TribeeSteamUnboundNavigation(modifier, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamUnboundPage$lambda$4(Modifier modifier, TribeeSteamState tribeeSteamState, Function1 function1, Function1 function12, int i, int i2, Composer composer, int i3) {
        TribeeSteamUnboundPage(modifier, tribeeSteamState, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamUnboundPage$lambda$0$0(TribeeSteamStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamUnboundPage$lambda$1$0(TribeeSteamUIAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r13v8 */
    public static final void TribeeSteamUnboundPage(Modifier modifier, TribeeSteamState state, Function1<? super TribeeSteamStateAction, Unit> function1, Function1<? super TribeeSteamUIAction, Unit> function12, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        TribeeSteamState tribeeSteamState;
        Function1 onStateAction;
        Function1 onUIAction;
        Composer $composer2;
        Modifier modifier3;
        TribeeSteamState state2;
        Modifier modifier4;
        TribeeSteamState state3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        int i2;
        String str;
        String confirmTextJumpUrl;
        String picUrl;
        Composer $composer3 = $composer.startRestartGroup(37014548);
        ComposerKt.sourceInformation($composer3, "C(TribeeSteamUnboundPage)N(modifier,state,onStateAction,onUIAction)55@2624L2,56@2676L2,66@3323L41,66@3301L63,74@3484L6,70@3370L1064:TribeeSteamUnbound.kt#k3l5ii");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            tribeeSteamState = state;
        } else if (($changed & 48) == 0) {
            tribeeSteamState = state;
            $dirty |= $composer3.changed(tribeeSteamState) ? 32 : 16;
        } else {
            tribeeSteamState = state;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            onStateAction = function1;
        } else if (($changed & 384) == 0) {
            onStateAction = function1;
            $dirty |= $composer3.changedInstance(onStateAction) ? 256 : 128;
        } else {
            onStateAction = function1;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
            onUIAction = function12;
        } else if (($changed & 3072) == 0) {
            onUIAction = function12;
            $dirty |= $composer3.changedInstance(onUIAction) ? 2048 : 1024;
        } else {
            onUIAction = function12;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            state2 = tribeeSteamState;
        } else {
            if (i3 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i4 == 0) {
                state3 = tribeeSteamState;
            } else {
                state3 = null;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1211247190, "CC(remember):TribeeSteamUnbound.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamUnboundKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamUnboundPage$lambda$0$0;
                            TribeeSteamUnboundPage$lambda$0$0 = TribeeSteamUnboundKt.TribeeSteamUnboundPage$lambda$0$0((TribeeSteamStateAction) obj);
                            return TribeeSteamUnboundPage$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onStateAction2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onStateAction = onStateAction2;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1211248854, "CC(remember):TribeeSteamUnbound.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamUnboundKt$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamUnboundPage$lambda$1$0;
                            TribeeSteamUnboundPage$lambda$1$0 = TribeeSteamUnboundKt.TribeeSteamUnboundPage$lambda$1$0((TribeeSteamUIAction) obj);
                            return TribeeSteamUnboundPage$lambda$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function1 onUIAction2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onUIAction = onUIAction2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(37014548, $dirty2, -1, "kntr.app.tribee.steam.page.TribeeSteamUnboundPage (TribeeSteamUnbound.kt:57)");
            }
            Intrinsics.checkNotNull(state3, "null cannot be cast to non-null type kntr.app.tribee.steam.state.TribeeSteamState.UnbindSteamState");
            KTribeeSteamHomeNotBindResp response = ((TribeeSteamState.UnbindSteamState) state3).getUnbindResp();
            KTipsCard tips = response.getTips();
            String picUrl2 = (tips == null || (picUrl = tips.getPicUrl()) == null) ? "" : picUrl;
            KTipsCard tips2 = response.getTips();
            String title = tips2 != null ? tips2.getTitle() : null;
            if (title == null) {
                $composer3.startReplaceGroup(1211255692);
                ComposerKt.sourceInformation($composer3, "60@2888L56");
                title = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_14(TribeeRes.INSTANCE.getString()), $composer3, 0);
            } else {
                $composer3.startReplaceGroup(1211254948);
            }
            $composer3.endReplaceGroup();
            String text = title;
            KTipsCard tips3 = response.getTips();
            String desc = tips3 != null ? tips3.getDesc() : null;
            if (desc == null) {
                $composer3.startReplaceGroup(1211258988);
                ComposerKt.sourceInformation($composer3, "61@2991L56");
                desc = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_15(TribeeRes.INSTANCE.getString()), $composer3, 0);
            } else {
                $composer3.startReplaceGroup(1211258275);
            }
            $composer3.endReplaceGroup();
            String desc2 = desc;
            KTipsCard tips4 = response.getTips();
            String confirmText = tips4 != null ? tips4.getConfirmText() : null;
            if (confirmText == null) {
                $composer3.startReplaceGroup(1211262764);
                ComposerKt.sourceInformation($composer3, "62@3109L56");
                confirmText = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_16(TribeeRes.INSTANCE.getString()), $composer3, 0);
            } else {
                $composer3.startReplaceGroup(1211261834);
            }
            $composer3.endReplaceGroup();
            String buttonString = confirmText;
            KTipsCard tips5 = response.getTips();
            String buttonUrl = (tips5 == null || (confirmTextJumpUrl = tips5.getConfirmTextJumpUrl()) == null) ? "" : confirmTextJumpUrl;
            KToastDialog bindTribeeDialog = response.getBindTribee();
            ComposerKt.sourceInformationMarkerStart($composer3, 1211269597, "CC(remember):TribeeSteamUnbound.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new TribeeSteamUnboundKt$TribeeSteamUnboundPage$3$1(null);
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(state3, (Function2) it$iv3, $composer3, ($dirty2 >> 3) & 14);
            Modifier modifier$iv = WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int $changed2 = ((0 >> 6) & 112) | 6;
            BoxScope $this$TribeeSteamUnboundPage_u24lambda_u243 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1416993857, "C77@3554L709,95@4273L155:TribeeSteamUnbound.kt#k3l5ii");
            Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv2 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
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
            Function1 onUIAction3 = onUIAction;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i9 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1631207846, "C82@3748L122,83@3883L370:TribeeSteamUnbound.kt#k3l5ii");
            if (((TribeeSteamState.UnbindSteamState) state3).isMaster()) {
                $composer3.startReplaceGroup(1055760424);
                ComposerKt.sourceInformation($composer3, "82@3805L56");
                i2 = 0;
                str = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_13(TribeeRes.INSTANCE.getString()), $composer3, 0);
                $composer3.endReplaceGroup();
            } else {
                i2 = 0;
                $composer3.startReplaceGroup(-1631105394);
                $composer3.endReplaceGroup();
                str = "";
            }
            TribeeSteamUnboundNavigation(null, str, $composer3, i2, 1);
            TribeeSteamUnboundContent(OffsetKt.offset-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(90), 1, (Object) null), picUrl2, text, desc2, buttonString, buttonUrl, bindTribeeDialog, onStateAction, $composer3, (($dirty2 << 15) & 29360128) | 6, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TipsFootCardKt.showKTipsFootCard($this$TribeeSteamUnboundPage_u24lambda_u243, ((TribeeSteamState.UnbindSteamState) state3).getTipsFootCard(), onStateAction, null, onUIAction3, $composer3, ($changed2 & 14) | ($dirty2 & 896) | (57344 & ($dirty2 << 3)), 4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            state2 = state3;
            onUIAction = onUIAction3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final TribeeSteamState tribeeSteamState2 = state2;
            final Function1 function13 = onStateAction;
            final Function1 function14 = onUIAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TribeeSteamUnboundKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamUnboundPage$lambda$4;
                    TribeeSteamUnboundPage$lambda$4 = TribeeSteamUnboundKt.TribeeSteamUnboundPage$lambda$4(modifier5, tribeeSteamState2, function13, function14, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamUnboundPage$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamUnboundContent$lambda$0$0(TribeeSteamStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0598  */
    /* JADX WARN: Type inference failed for: r6v14 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void TribeeSteamUnboundContent(Modifier modifier, String picUrl, String text, String desc, String buttonString, String buttonUrl, KToastDialog bindTribeeTialog, Function1<? super TribeeSteamStateAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        String text2;
        String desc2;
        String buttonString2;
        Modifier modifier2;
        String picUrl2;
        String buttonUrl2;
        final KToastDialog bindTribeeTialog2;
        Function1 onStateAction;
        String text3;
        String desc3;
        Modifier modifier3;
        String picUrl3;
        final String buttonUrl3;
        KToastDialog bindTribeeTialog3;
        Function1 onStateAction2;
        Function0 factory$iv$iv$iv;
        final Function1 onStateAction3;
        Function0 factory$iv$iv$iv2;
        Composer $composer2 = $composer.startRestartGroup(949722236);
        ComposerKt.sourceInformation($composer2, "C(TribeeSteamUnboundContent)N(modifier,picUrl,text,desc,buttonString,buttonUrl,bindTribeeTialog,onStateAction)112@4752L2,114@4764L2798:TribeeSteamUnbound.kt#k3l5ii");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(picUrl) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            text2 = text;
        } else if (($changed & 384) == 0) {
            text2 = text;
            $dirty |= $composer2.changed(text2) ? 256 : 128;
        } else {
            text2 = text;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            desc2 = desc;
        } else if (($changed & 3072) == 0) {
            desc2 = desc;
            $dirty |= $composer2.changed(desc2) ? 2048 : 1024;
        } else {
            desc2 = desc;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            buttonString2 = buttonString;
        } else if (($changed & 24576) == 0) {
            buttonString2 = buttonString;
            $dirty |= $composer2.changed(buttonString2) ? 16384 : 8192;
        } else {
            buttonString2 = buttonString;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty |= $composer2.changed(buttonUrl) ? 131072 : 65536;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(bindTribeeTialog) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 8388608 : 4194304;
        }
        if (!$composer2.shouldExecute(($dirty & 4793491) != 4793490, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            picUrl2 = picUrl;
            buttonUrl2 = buttonUrl;
            bindTribeeTialog2 = bindTribeeTialog;
            onStateAction = function1;
            text3 = text2;
            desc3 = desc2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (i3 == 0) {
                picUrl3 = picUrl;
            } else {
                picUrl3 = "";
            }
            if (i4 != 0) {
                text2 = "";
            }
            if (i5 != 0) {
                desc2 = "";
            }
            if (i6 != 0) {
                buttonString2 = "";
            }
            if (i7 == 0) {
                buttonUrl3 = buttonUrl;
            } else {
                buttonUrl3 = "";
            }
            if (i8 == 0) {
                bindTribeeTialog3 = bindTribeeTialog;
            } else {
                bindTribeeTialog3 = null;
            }
            if (i9 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -2144955842, "CC(remember):TribeeSteamUnbound.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamUnboundKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamUnboundContent$lambda$0$0;
                            TribeeSteamUnboundContent$lambda$0$0 = TribeeSteamUnboundKt.TribeeSteamUnboundContent$lambda$0$0((TribeeSteamStateAction) obj);
                            return TribeeSteamUnboundContent$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onStateAction2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onStateAction2 = function1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(949722236, $dirty, -1, "kntr.app.tribee.steam.page.TribeeSteamUnboundContent (TribeeSteamUnbound.kt:113)");
            }
            modifier2 = modifier3;
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), Dp.constructor-impl(48), 0.0f, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            String buttonString3 = buttonString2;
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            onStateAction = onStateAction2;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            bindTribeeTialog2 = bindTribeeTialog3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i10 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i11 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1170212525, "C145@5742L6,146@5786L9,143@5681L172,152@5924L6,153@5968L9,150@5863L171:TribeeSteamUnbound.kt#k3l5ii");
            if (!StringsKt.isBlank(picUrl3)) {
                $composer2.startReplaceGroup(1170169465);
                ComposerKt.sourceInformation($composer2, "123@5063L319");
                String $this$asRequest$iv = picUrl3;
                picUrl2 = picUrl3;
                ImageRequest $this$TribeeSteamUnboundContent_u24lambda_u241_u240 = new ImageRequest($this$asRequest$iv);
                $this$TribeeSteamUnboundContent_u24lambda_u241_u240.contentScale(ContentScale.Companion.getInside());
                BiliImageKt.BiliImage($this$TribeeSteamUnboundContent_u24lambda_u241_u240.build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(140)), "unbound_image", null, null, null, null, null, null, $composer2, 432, InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
                $composer2.endReplaceGroup();
            } else {
                picUrl2 = picUrl3;
                $composer2.startReplaceGroup(1170513503);
                ComposerKt.sourceInformation($composer2, "135@5445L52,134@5412L249");
                ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_status_notice(CommonRes.INSTANCE.getDrawable()), $composer2, 0), "unbound_image", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(140)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 432, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
                $composer2.endReplaceGroup();
            }
            TextKt.Text-Nvy7gAk(text2, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16b(), $composer2, ($dirty >> 6) & 14, 0, 130042);
            TextKt.Text-Nvy7gAk(desc2, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, ($dirty >> 9) & 14, 0, 130042);
            if (StringsKt.isBlank(buttonUrl3)) {
                buttonUrl2 = buttonUrl3;
                text3 = text2;
                desc3 = desc2;
                $composer2.startReplaceGroup(1165149232);
            } else {
                $composer2.startReplaceGroup(1171219652);
                ComposerKt.sourceInformation($composer2, "164@6336L6,167@6503L39,169@6629L544,158@6086L1460");
                text3 = text2;
                Modifier modifier4 = BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(6), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(96), Dp.constructor-impl(30)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(15)));
                ComposerKt.sourceInformationMarkerStart($composer2, -1070585031, "CC(remember):TribeeSteamUnbound.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1070580494, "CC(remember):TribeeSteamUnbound.kt#9igjgp");
                boolean invalid$iv = ((29360128 & $dirty) == 8388608) | ((458752 & $dirty) == 131072) | $composer2.changedInstance(bindTribeeTialog2);
                Object it$iv3 = $composer2.rememberedValue();
                if (!invalid$iv && it$iv3 != Composer.Companion.getEmpty()) {
                    onStateAction3 = onStateAction;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifier$iv2 = ClickableKt.clickable-O2vRcR0$default(modifier4, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv3, 28, (Object) null);
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    buttonUrl2 = buttonUrl3;
                    bindTribeeTialog2 = bindTribeeTialog2;
                    onStateAction = onStateAction3;
                    ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                    int $changed$iv$iv2 = (432 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                    CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                    Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    desc3 = desc2;
                    ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if (!$composer2.getInserting()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv4;
                        $composer2.createNode(factory$iv$iv$iv2);
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv4;
                        $composer2.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i12 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    int i13 = ((432 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -259677011, "C187@7443L6,188@7500L9,185@7358L174:TribeeSteamUnbound.kt#k3l5ii");
                    TextKt.Text-Nvy7gAk(buttonString3, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, ($dirty >> 12) & 14, 0, 131066);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                }
                onStateAction3 = onStateAction;
                Object value$iv3 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeSteamUnboundKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit TribeeSteamUnboundContent$lambda$1$2$0;
                        TribeeSteamUnboundContent$lambda$1$2$0 = TribeeSteamUnboundKt.TribeeSteamUnboundContent$lambda$1$2$0(onStateAction3, buttonUrl3, bindTribeeTialog2);
                        return TribeeSteamUnboundContent$lambda$1$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv22 = ClickableKt.clickable-O2vRcR0$default(modifier4, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv3, 28, (Object) null);
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getCenter();
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                buttonUrl2 = buttonUrl3;
                bindTribeeTialog2 = bindTribeeTialog2;
                onStateAction = onStateAction3;
                ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv22 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv22 = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv22 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer2, modifier$iv22);
                Function0 factory$iv$iv$iv42 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
                desc3 = desc2;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                }
                $composer2.startReusableNode();
                if (!$composer2.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
                int i122 = ($changed$iv$iv$iv22 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i132 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -259677011, "C187@7443L6,188@7500L9,185@7358L174:TribeeSteamUnbound.kt#k3l5ii");
                TextKt.Text-Nvy7gAk(buttonString3, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, ($dirty >> 12) & 14, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            buttonString2 = buttonString3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            final String str = picUrl2;
            final String str2 = text3;
            final String str3 = desc3;
            final String str4 = buttonString2;
            final String str5 = buttonUrl2;
            final KToastDialog kToastDialog = bindTribeeTialog2;
            final Function1 function12 = onStateAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TribeeSteamUnboundKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamUnboundContent$lambda$2;
                    TribeeSteamUnboundContent$lambda$2 = TribeeSteamUnboundKt.TribeeSteamUnboundContent$lambda$2(modifier5, str, str2, str3, str4, str5, kToastDialog, function12, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamUnboundContent$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamUnboundContent$lambda$1$2$0(Function1 $onStateAction, String $buttonUrl, KToastDialog $bindTribeeTialog) {
        SteamTrackerKt.reportSteamUnboundClick("1", "bind");
        $onStateAction.invoke(new TribeeSteamStateAction.GoToSteamBind($buttonUrl, $bindTribeeTialog));
        return Unit.INSTANCE;
    }

    private static final void TribeeSteamUnboundNavigation(Modifier modifier, String title, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        final String title2;
        Modifier modifier3;
        String title3;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(3848016);
        ComposerKt.sourceInformation($composer2, "C(TribeeSteamUnboundNavigation)N(modifier,title)200@7734L7,202@7767L92,208@7865L1134:TribeeSteamUnbound.kt#k3l5ii");
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
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            title2 = title;
        } else if (($changed & 48) == 0) {
            title2 = title;
            $dirty |= $composer2.changed(title2) ? 32 : 16;
        } else {
            title2 = title;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                title3 = title2;
            } else {
                title3 = "";
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(3848016, $dirty, -1, "kntr.app.tribee.steam.page.TribeeSteamUnboundNavigation (TribeeSteamUnbound.kt:199)");
            }
            final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
            ComposerKt.sourceInformationMarkerStart($composer2, -597018036, "CC(remember):TribeeSteamUnbound.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeSteamUnboundKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit TribeeSteamUnboundNavigation$lambda$0$0;
                        TribeeSteamUnboundNavigation$lambda$0$0 = TribeeSteamUnboundKt.TribeeSteamUnboundNavigation$lambda$0$0(backHandler);
                        return TribeeSteamUnboundNavigation$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final Function0 onBack = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv$iv = SizeKt.height-3ABfNKs(WindowInsetsPadding_androidKt.statusBarsPadding(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null)), Dp.constructor-impl(44));
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            Modifier modifier4 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$TribeeSteamUnboundNavigation_u24lambda_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -857016281, "C216@8069L24,218@8170L6,224@8377L39,226@8495L224,215@8027L726,239@8882L6,240@8926L9,236@8763L230:TribeeSteamUnbound.kt#k3l5ii");
            Painter arrow_back_left_line_500 = BiliIconfont.INSTANCE.getArrow_back_left_line_500($composer2, 6);
            long j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU();
            Modifier modifier5 = PaddingKt.padding-3ABfNKs(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(44)), Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart($composer2, -1551656067, "CC(remember):TribeeSteamUnbound.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1551652106, "CC(remember):TribeeSteamUnbound.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeSteamUnboundKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit TribeeSteamUnboundNavigation$lambda$1$1$0;
                        TribeeSteamUnboundNavigation$lambda$1$1$0 = TribeeSteamUnboundKt.TribeeSteamUnboundNavigation$lambda$1$1$0(onBack);
                        return TribeeSteamUnboundNavigation$lambda$1$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BiliIconfontKt.BiliIcon-ww6aTOc(arrow_back_left_line_500, ClickableKt.clickable-O2vRcR0$default(modifier5, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv3, 28, (Object) null), "back icon", j, $composer2, Painter.$stable | 384, 0);
            TextKt.Text-Nvy7gAk(title3, $this$TribeeSteamUnboundNavigation_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getCenter()), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT17b(), $composer2, ($dirty >> 3) & 14, 0, 130040);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            title2 = title3;
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TribeeSteamUnboundKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamUnboundNavigation$lambda$2;
                    TribeeSteamUnboundNavigation$lambda$2 = TribeeSteamUnboundKt.TribeeSteamUnboundNavigation$lambda$2(modifier2, title2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamUnboundNavigation$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamUnboundNavigation$lambda$0$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamUnboundNavigation$lambda$1$1$0(Function0 $onBack) {
        SteamTrackerKt.reportSteamUnboundClick("1", "back");
        $onBack.invoke();
        return Unit.INSTANCE;
    }
}