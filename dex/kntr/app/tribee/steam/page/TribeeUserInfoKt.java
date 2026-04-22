package kntr.app.tribee.steam.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeUserInfo;
import com.bapis.bilibili.dagw.component.avatar.v1.KAvatarItem;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.tribee.steam.track.SteamTrackerKt;
import kntr.app.tribee.steam.viewmodel.TribeeSteamUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.compose.avatar.AvatarKt;
import kntr.compose.avatar.AvatarScope;
import kntr.compose.avatar.AvatarSizeConfig;
import kntr.compose.avatar.AvatarState;
import kntr.compose.avatar.internal.AvatarContentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeUserInfo.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aY\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"TribeeUserInfo", "", "userInfo", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeUserInfo;", "modifier", "Landroidx/compose/ui/Modifier;", "normalSize", "Landroidx/compose/ui/unit/Dp;", "onUpdateHeight", "Lkotlin/Function1;", "", "onUIAction", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "TribeeUserInfo-TN_CM5M", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeUserInfo;Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeUserInfoKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeUserInfo_TN_CM5M$lambda$4(KTribeeSteamHomeUserInfo kTribeeSteamHomeUserInfo, Modifier modifier, float f, Function1 function1, Function1 function12, int i, int i2, Composer composer, int i3) {
        m1152TribeeUserInfoTN_CM5M(kTribeeSteamHomeUserInfo, modifier, f, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeUserInfo_TN_CM5M$lambda$0$0(int it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeUserInfo_TN_CM5M$lambda$1$0(TribeeSteamUIAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:0x0305, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L71;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* renamed from: TribeeUserInfo-TN_CM5M  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1152TribeeUserInfoTN_CM5M(final KTribeeSteamHomeUserInfo userInfo, Modifier modifier, float f, Function1<? super Integer, Unit> function1, Function1<? super TribeeSteamUIAction, Unit> function12, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f2;
        final Function1 onUpdateHeight;
        final Function1 onUIAction;
        Modifier modifier3;
        float f3;
        Function1 onUpdateHeight2;
        Modifier modifier4;
        float f4;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv$iv;
        final KTribeeSteamHomeUserInfo kTribeeSteamHomeUserInfo;
        boolean z;
        long j;
        Object it$iv;
        Function0 factory$iv$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(927959961);
        ComposerKt.sourceInformation($composer2, "C(TribeeUserInfo)N(userInfo,modifier,normalSize:c#ui.unit.Dp,onUpdateHeight,onUIAction)36@1419L2,37@1471L2,42@1569L70,39@1483L2079:TribeeUserInfo.kt#k3l5ii");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(userInfo) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            f2 = f;
        } else if (($changed & 384) == 0) {
            f2 = f;
            $dirty |= $composer2.changed(f2) ? 256 : 128;
        } else {
            f2 = f;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            onUpdateHeight = function1;
        } else if (($changed & 3072) == 0) {
            onUpdateHeight = function1;
            $dirty |= $composer2.changedInstance(onUpdateHeight) ? 2048 : 1024;
        } else {
            onUpdateHeight = function1;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            onUIAction = function12;
        } else if (($changed & 24576) == 0) {
            onUIAction = function12;
            $dirty |= $composer2.changedInstance(onUIAction) ? 16384 : 8192;
        } else {
            onUIAction = function12;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                f4 = f2;
            } else {
                f4 = Dp.constructor-impl(56);
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1583669925, "CC(remember):TribeeUserInfo.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeUserInfoKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit TribeeUserInfo_TN_CM5M$lambda$0$0;
                            TribeeUserInfo_TN_CM5M$lambda$0$0 = TribeeUserInfoKt.TribeeUserInfo_TN_CM5M$lambda$0$0(((Integer) obj).intValue());
                            return TribeeUserInfo_TN_CM5M$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv2 = value$iv;
                }
                Function1 onUpdateHeight3 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onUpdateHeight = onUpdateHeight3;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1583668261, "CC(remember):TribeeUserInfo.kt#9igjgp");
                Object it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeUserInfoKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit TribeeUserInfo_TN_CM5M$lambda$1$0;
                            TribeeUserInfo_TN_CM5M$lambda$1$0 = TribeeUserInfoKt.TribeeUserInfo_TN_CM5M$lambda$1$0((TribeeSteamUIAction) obj);
                            return TribeeUserInfo_TN_CM5M$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv3 = value$iv2;
                }
                Function1 onUIAction2 = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onUIAction = onUIAction2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(927959961, $dirty2, -1, "kntr.app.tribee.steam.page.TribeeUserInfo (TribeeUserInfo.kt:38)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1583665057, "CC(remember):TribeeUserInfo.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 7168) == 2048;
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeUserInfoKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit TribeeUserInfo_TN_CM5M$lambda$2$0;
                        TribeeUserInfo_TN_CM5M$lambda$2$0 = TribeeUserInfoKt.TribeeUserInfo_TN_CM5M$lambda$2$0(onUpdateHeight, (LayoutCoordinates) obj);
                        return TribeeUserInfo_TN_CM5M$lambda$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv4 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier4, (Function1) it$iv4);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            onUpdateHeight2 = onUpdateHeight;
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
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -678712143, "C82@3263L293:TribeeUserInfo.kt#k3l5ii");
            KAvatarItem avatarItem = userInfo != null ? userInfo.getAvatar() : null;
            if (avatarItem != null) {
                $composer2.startReplaceGroup(-678667256);
                ComposerKt.sourceInformation($composer2, "50@1829L58,55@2084L39,57@2210L272,49@1797L727");
                AvatarState state$iv = AvatarKt.m2455rememberAvatarStateziNgDLE(kntr.compose.avatar.parser.protobuf.AvatarKt.toAvatarItem(avatarItem), f4, $composer2, ($dirty2 >> 3) & 112);
                AvatarSizeConfig sizeConfig$iv = AvatarSizeConfig.Largest;
                Modifier modifier5 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer2, -1961546646, "CC(remember):TribeeUserInfo.kt#9igjgp");
                Object it$iv5 = $composer2.rememberedValue();
                if (it$iv5 == Composer.Companion.getEmpty()) {
                    Object MutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
                    $composer2.updateRememberedValue(MutableInteractionSource);
                    it$iv = MutableInteractionSource;
                } else {
                    it$iv = it$iv5;
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1961542381, "CC(remember):TribeeUserInfo.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changedInstance(userInfo) | ((57344 & $dirty2) == 16384);
                Object it$iv6 = $composer2.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv4 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeUserInfoKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit TribeeUserInfo_TN_CM5M$lambda$3$1$0;
                        TribeeUserInfo_TN_CM5M$lambda$3$1$0 = TribeeUserInfoKt.TribeeUserInfo_TN_CM5M$lambda$3$1$0(userInfo, onUIAction);
                        return TribeeUserInfo_TN_CM5M$lambda$3$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
                it$iv6 = value$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv2 = ClickableKt.clickable-O2vRcR0$default(modifier5, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv6, 28, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, -1812324423, "CC(Avatar)N(state,modifier,sizeConfig)20@712L229:Avatar.kt#v7x95u");
                Modifier modifier$iv$iv$iv = modifier$iv2.then(SizeKt.size-3ABfNKs(Modifier.Companion, sizeConfig$iv.m2498constraintSizeu2uoSUM(state$iv)));
                Alignment contentAlignment$iv$iv = Alignment.Companion.getTopStart();
                $composer$iv$iv$iv = $composer2;
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv$iv, false);
                int $changed$iv$iv$iv2 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv$iv);
                Function0 factory$iv$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv$iv = (($changed$iv$iv$iv2 << 6) & 896) | 6;
                $composer$iv = $composer2;
                Function1 onUIAction3 = onUIAction;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv$iv = factory$iv$iv$iv$iv2;
                    $composer2.createNode(factory$iv$iv$iv$iv);
                } else {
                    factory$iv$iv$iv$iv = factory$iv$iv$iv$iv2;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv$iv = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, localMap$iv$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, materialized$iv$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i8 = ($changed$iv$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i9 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -60560984, "C24@868L21:Avatar.kt#v7x95u");
                $composer2.startReplaceGroup(-833237573);
                ComposerKt.sourceInformation($composer2, "*25@905L20");
                AvatarScope $this$Avatar_u24lambda_u240_u240$iv = AvatarKt.rememberAvatarScope($composer2, 0);
                AvatarContentKt.AvatarContent($this$Avatar_u24lambda_u240_u240$iv, state$iv, $composer2, (384 << 3) & 112);
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
                z = false;
                kTribeeSteamHomeUserInfo = userInfo;
                onUIAction = onUIAction3;
            } else {
                $composer$iv = $composer2;
                $composer$iv$iv$iv = $composer2;
                Function1 onUIAction4 = onUIAction;
                $composer2.startReplaceGroup(-677930634);
                ComposerKt.sourceInformation($composer2, "70@2782L39,72@2908L293,65@2554L689");
                Modifier modifier6 = SizeKt.size-3ABfNKs(Modifier.Companion, AvatarSizeConfig.Largest.m2497constraintSize5rwHm24(f4));
                ComposerKt.sourceInformationMarkerStart($composer2, -1961524310, "CC(remember):TribeeUserInfo.kt#9igjgp");
                Object it$iv7 = $composer2.rememberedValue();
                if (it$iv7 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = InteractionSourceKt.MutableInteractionSource();
                    $composer2.updateRememberedValue(value$iv5);
                    it$iv7 = value$iv5;
                }
                MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) it$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1961520024, "CC(remember):TribeeUserInfo.kt#9igjgp");
                kTribeeSteamHomeUserInfo = userInfo;
                boolean invalid$iv3 = $composer2.changedInstance(kTribeeSteamHomeUserInfo) | (($dirty2 & 57344) == 16384);
                Object it$iv8 = $composer2.rememberedValue();
                if (invalid$iv3 || it$iv8 == Composer.Companion.getEmpty()) {
                    onUIAction = onUIAction4;
                    Object value$iv6 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeUserInfoKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit TribeeUserInfo_TN_CM5M$lambda$3$3$0;
                            TribeeUserInfo_TN_CM5M$lambda$3$3$0 = TribeeUserInfoKt.TribeeUserInfo_TN_CM5M$lambda$3$3$0(kTribeeSteamHomeUserInfo, onUIAction);
                            return TribeeUserInfo_TN_CM5M$lambda$3$3$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv6);
                    it$iv8 = value$iv6;
                } else {
                    onUIAction = onUIAction4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                z = false;
                BoxKt.Box(ClickableKt.clickable-O2vRcR0$default(modifier6, mutableInteractionSource2, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv8, 28, (Object) null), $composer2, 0);
                $composer2.endReplaceGroup();
            }
            String name = kTribeeSteamHomeUserInfo != null ? userInfo.getName() : null;
            if (name == null) {
                name = "";
            }
            String str = name;
            long sp = TextUnitKt.getSp(17);
            if (kTribeeSteamHomeUserInfo != null && userInfo.isVip()) {
                z = true;
            }
            if (z) {
                $composer2.startReplaceGroup(-1961504243);
                ComposerKt.sourceInformation($composer2, "85@3403L6");
                j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
            } else {
                $composer2.startReplaceGroup(-1961503192);
                ComposerKt.sourceInformation($composer2, "85@3436L6");
                j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU();
            }
            $composer2.endReplaceGroup();
            TextKt.Text-Nvy7gAk(str, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(4), 0.0f, 0.0f, 13, (Object) null), j, (TextAutoSize) null, sp, (FontStyle) null, FontWeight.Companion.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer2, 1597488, 0, 262056);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f3 = f4;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            f3 = f2;
            onUpdateHeight2 = onUpdateHeight;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final float f5 = f3;
            final Function1 function13 = onUpdateHeight2;
            final Function1 function14 = onUIAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TribeeUserInfoKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeUserInfo_TN_CM5M$lambda$4;
                    TribeeUserInfo_TN_CM5M$lambda$4 = TribeeUserInfoKt.TribeeUserInfo_TN_CM5M$lambda$4(userInfo, modifier7, f5, function13, function14, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeUserInfo_TN_CM5M$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeUserInfo_TN_CM5M$lambda$2$0(Function1 $onUpdateHeight, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $onUpdateHeight.invoke(Integer.valueOf((int) (4294967295L & it.getSize-YbymL2g())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeUserInfo_TN_CM5M$lambda$3$1$0(KTribeeSteamHomeUserInfo $userInfo, Function1 $onUIAction) {
        SteamTrackerKt.reportSteamPageClick("icon");
        KLog_androidKt.getKLog().i("TribeeUserInfo", "onClick: " + $userInfo.getJumpUrl());
        $onUIAction.invoke(new TribeeSteamUIAction.RouterTo($userInfo.getJumpUrl()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeUserInfo_TN_CM5M$lambda$3$3$0(KTribeeSteamHomeUserInfo $userInfo, Function1 $onUIAction) {
        String it;
        KLog_androidKt.getKLog().i("TribeeUserInfo", "onClick: " + ($userInfo != null ? $userInfo.getJumpUrl() : null));
        if ($userInfo != null && (it = $userInfo.getJumpUrl()) != null) {
            $onUIAction.invoke(new TribeeSteamUIAction.RouterTo(it));
        }
        return Unit.INSTANCE;
    }
}