package video.biz.offline.list.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ProgressIndicatorKt;
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
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import bili.resource.others.Res;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.Res;
import bili.resource.playerbaseres.String2_commonMainKt;
import bili.resource.playerbaseres.String3_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import kntr.common.compose.res.CommonRes;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.common.compose.res.generated.resources.String0_commonMainKt;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.model.DialogType;
import video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine;

/* compiled from: OfflinePopup.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"OfflinePopup", "", "dialogType", "Lvideo/biz/offline/list/logic/model/DialogType;", "machine", "Lvideo/biz/offline/list/logic/statemachine/OfflineBaseListStateMachine;", "(Lvideo/biz/offline/list/logic/model/DialogType;Lvideo/biz/offline/list/logic/statemachine/OfflineBaseListStateMachine;Landroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflinePopupKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinePopup$lambda$15(DialogType dialogType, OfflineBaseListStateMachine offlineBaseListStateMachine, int i, Composer composer, int i2) {
        OfflinePopup(dialogType, offlineBaseListStateMachine, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void OfflinePopup(final DialogType dialogType, final OfflineBaseListStateMachine machine, Composer $composer, final int $changed) {
        int i;
        String content;
        String subTitle;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(dialogType, "dialogType");
        Intrinsics.checkNotNullParameter(machine, "machine");
        Composer $composer2 = $composer.startRestartGroup(-1007330061);
        ComposerKt.sourceInformation($composer2, "C(OfflinePopup)N(dialogType,machine)45@2253L24:OfflinePopup.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(dialogType) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer2.changed(machine) : $composer2.changedInstance(machine) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1007330061, $dirty2, -1, "video.biz.offline.list.ui.widget.OfflinePopup (OfflinePopup.kt:44)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (Intrinsics.areEqual(dialogType, DialogType.Loading.INSTANCE)) {
                $composer2.startReplaceGroup(-433154456);
                ComposerKt.sourceInformation($composer2, "49@2420L3,48@2346L303");
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, -1676538218, "CC(remember):OfflinePopup.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = (PointerInputEventHandler) new PointerInputEventHandler() { // from class: video.biz.offline.list.ui.widget.OfflinePopupKt$OfflinePopup$1$1
                        public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
                            return Unit.INSTANCE;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv = SuspendingPointerInputFilterKt.pointerInput(fillMaxSize$default, unit, (PointerInputEventHandler) it$iv);
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
                int i2 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i3 = ((0 >> 6) & 112) | 6;
                BoxScope $this$OfflinePopup_u24lambda_u241 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, -887012100, "C53@2599L6,51@2457L178:OfflinePopup.kt#uys4uf");
                ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8($this$OfflinePopup_u24lambda_u241.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(36)), Alignment.Companion.getCenter()), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0L, 0, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, $composer2, 0, 60);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else if (Intrinsics.areEqual(dialogType, DialogType.VipOnlyAlert.INSTANCE)) {
                $composer2.startReplaceGroup(-432780534);
                ComposerKt.sourceInformation($composer2, "62@2995L39,63@3064L169,68@3262L150,59@2710L717");
                String string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2274(PlayerbaseresRes.INSTANCE.getString()));
                String string2 = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_630(PlayerbaseresRes.INSTANCE.getString()));
                String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getCancel(CommonRes.INSTANCE.getString()), $composer2, 0);
                ComposerKt.sourceInformationMarkerStart($composer2, -1676517444, "CC(remember):OfflinePopup.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance(scope) | (($dirty2 & 112) == 32 || (($dirty2 & 64) != 0 && $composer2.changedInstance(machine)));
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflinePopupKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            Unit OfflinePopup$lambda$2$0;
                            OfflinePopup$lambda$2$0 = OfflinePopupKt.OfflinePopup$lambda$2$0(scope, machine);
                            return OfflinePopup$lambda$2$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 function0 = (Function0) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1676511127, "CC(remember):OfflinePopup.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changedInstance(scope) | (($dirty2 & 112) == 32 || (($dirty2 & 64) != 0 && $composer2.changedInstance(machine)));
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflinePopupKt$$ExternalSyntheticLambda11
                        public final Object invoke() {
                            Unit OfflinePopup$lambda$3$0;
                            OfflinePopup$lambda$3$0 = OfflinePopupKt.OfflinePopup$lambda$3$0(scope, machine);
                            return OfflinePopup$lambda$3$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                OfflineCommonDialogKt.OfflineCommonDialog(string, false, null, string2, stringResource, function0, (Function0) it$iv3, $composer2, 0, 6);
                $composer2.endReplaceGroup();
            } else if (dialogType instanceof DialogType.VipExpiredAlert) {
                $composer2.startReplaceGroup(-432001628);
                ComposerKt.sourceInformation($composer2, "82@3820L39,83@3889L166,88@4084L150,77@3494L755");
                String string3 = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2205(PlayerbaseresRes.INSTANCE.getString()));
                String string4 = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2195(PlayerbaseresRes.INSTANCE.getString()));
                String stringResource2 = StringResourcesKt.stringResource(String0_commonMainKt.getCancel(CommonRes.INSTANCE.getString()), $composer2, 0);
                ComposerKt.sourceInformationMarkerStart($composer2, -1676491047, "CC(remember):OfflinePopup.kt#9igjgp");
                boolean invalid$iv3 = $composer2.changedInstance(scope) | (($dirty2 & 112) == 32 || (($dirty2 & 64) != 0 && $composer2.changedInstance(machine))) | $composer2.changedInstance(dialogType);
                Object it$iv4 = $composer2.rememberedValue();
                if (invalid$iv3 || it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflinePopupKt$$ExternalSyntheticLambda12
                        public final Object invoke() {
                            Unit OfflinePopup$lambda$4$0;
                            OfflinePopup$lambda$4$0 = OfflinePopupKt.OfflinePopup$lambda$4$0(scope, machine, dialogType);
                            return OfflinePopup$lambda$4$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                Function0 function02 = (Function0) it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1676484823, "CC(remember):OfflinePopup.kt#9igjgp");
                boolean invalid$iv4 = $composer2.changedInstance(scope) | (($dirty2 & 112) == 32 || (($dirty2 & 64) != 0 && $composer2.changedInstance(machine)));
                Object it$iv5 = $composer2.rememberedValue();
                if (invalid$iv4 || it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflinePopupKt$$ExternalSyntheticLambda13
                        public final Object invoke() {
                            Unit OfflinePopup$lambda$5$0;
                            OfflinePopup$lambda$5$0 = OfflinePopupKt.OfflinePopup$lambda$5$0(scope, machine);
                            return OfflinePopup$lambda$5$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv5);
                    it$iv5 = value$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                OfflineCommonDialogKt.OfflineCommonDialog(string3, false, null, string4, stringResource2, function02, (Function0) it$iv5, $composer2, 0, 6);
                $composer2.endReplaceGroup();
            } else if (Intrinsics.areEqual(dialogType, DialogType.VipParallelDownloadAlert.INSTANCE)) {
                $composer2.startReplaceGroup(-431180624);
                ComposerKt.sourceInformation($composer2, "101@4627L39,102@4696L175,107@4900L150,97@4322L743");
                String string5 = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2258(PlayerbaseresRes.INSTANCE.getString()));
                String string6 = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_630(PlayerbaseresRes.INSTANCE.getString()));
                String stringResource3 = StringResourcesKt.stringResource(String0_commonMainKt.getCancel(CommonRes.INSTANCE.getString()), $composer2, 0);
                ComposerKt.sourceInformationMarkerStart($composer2, -1676465214, "CC(remember):OfflinePopup.kt#9igjgp");
                boolean invalid$iv5 = $composer2.changedInstance(scope) | (($dirty2 & 112) == 32 || (($dirty2 & 64) != 0 && $composer2.changedInstance(machine)));
                Object it$iv6 = $composer2.rememberedValue();
                if (invalid$iv5 || it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv6 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflinePopupKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit OfflinePopup$lambda$6$0;
                            OfflinePopup$lambda$6$0 = OfflinePopupKt.OfflinePopup$lambda$6$0(scope, machine);
                            return OfflinePopup$lambda$6$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv6);
                    it$iv6 = value$iv6;
                }
                Function0 function03 = (Function0) it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1676458711, "CC(remember):OfflinePopup.kt#9igjgp");
                boolean invalid$iv6 = $composer2.changedInstance(scope) | (($dirty2 & 112) == 32 || (($dirty2 & 64) != 0 && $composer2.changedInstance(machine)));
                Object it$iv7 = $composer2.rememberedValue();
                if (invalid$iv6 || it$iv7 == Composer.Companion.getEmpty()) {
                    Object value$iv7 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflinePopupKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit OfflinePopup$lambda$7$0;
                            OfflinePopup$lambda$7$0 = OfflinePopupKt.OfflinePopup$lambda$7$0(scope, machine);
                            return OfflinePopup$lambda$7$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv7);
                    it$iv7 = value$iv7;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                OfflineCommonDialogKt.OfflineCommonDialog(string5, false, null, string6, stringResource3, function03, (Function0) it$iv7, $composer2, 0, 6);
                $composer2.endReplaceGroup();
            } else if (Intrinsics.areEqual(dialogType, DialogType.VipPreviewAlert.INSTANCE)) {
                $composer2.startReplaceGroup(-430379894);
                ComposerKt.sourceInformation($composer2, "120@5434L39,121@5503L181,126@5713L150,116@5129L749");
                String string7 = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2230(PlayerbaseresRes.INSTANCE.getString()));
                String string8 = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_630(PlayerbaseresRes.INSTANCE.getString()));
                String stringResource4 = StringResourcesKt.stringResource(String0_commonMainKt.getCancel(CommonRes.INSTANCE.getString()), $composer2, 0);
                ComposerKt.sourceInformationMarkerStart($composer2, -1676439384, "CC(remember):OfflinePopup.kt#9igjgp");
                boolean invalid$iv7 = $composer2.changedInstance(scope) | (($dirty2 & 112) == 32 || (($dirty2 & 64) != 0 && $composer2.changedInstance(machine)));
                Object it$iv8 = $composer2.rememberedValue();
                if (invalid$iv7 || it$iv8 == Composer.Companion.getEmpty()) {
                    Object value$iv8 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflinePopupKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit OfflinePopup$lambda$8$0;
                            OfflinePopup$lambda$8$0 = OfflinePopupKt.OfflinePopup$lambda$8$0(scope, machine);
                            return OfflinePopup$lambda$8$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv8);
                    it$iv8 = value$iv8;
                }
                Function0 function04 = (Function0) it$iv8;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1676432695, "CC(remember):OfflinePopup.kt#9igjgp");
                boolean invalid$iv8 = $composer2.changedInstance(scope) | (($dirty2 & 112) == 32 || (($dirty2 & 64) != 0 && $composer2.changedInstance(machine)));
                Object it$iv9 = $composer2.rememberedValue();
                if (invalid$iv8 || it$iv9 == Composer.Companion.getEmpty()) {
                    Object value$iv9 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflinePopupKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit OfflinePopup$lambda$9$0;
                            OfflinePopup$lambda$9$0 = OfflinePopupKt.OfflinePopup$lambda$9$0(scope, machine);
                            return OfflinePopup$lambda$9$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv9);
                    it$iv9 = value$iv9;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                OfflineCommonDialogKt.OfflineCommonDialog(string7, false, null, string8, stringResource4, function04, (Function0) it$iv9, $composer2, 0, 6);
                $composer2.endReplaceGroup();
            } else if (Intrinsics.areEqual(dialogType, DialogType.ResourceInvalid.INSTANCE)) {
                $composer2.startReplaceGroup(-429580683);
                ComposerKt.sourceInformation($composer2, "141@6291L150,135@5942L514");
                String string9 = PlayerbaseresRes.INSTANCE.getString(String3_commonMainKt.getPlayerbaseres_global_string_889(PlayerbaseresRes.INSTANCE.getString()));
                String string10 = PlayerbaseresRes.INSTANCE.getString(bili.resource.playerbaseres.String0_commonMainKt.getPlayerbaseres_global_string_1248(PlayerbaseresRes.INSTANCE.getString()));
                ComposerKt.sourceInformationMarkerStart($composer2, -1676414199, "CC(remember):OfflinePopup.kt#9igjgp");
                boolean invalid$iv9 = $composer2.changedInstance(scope) | (($dirty2 & 112) == 32 || (($dirty2 & 64) != 0 && $composer2.changedInstance(machine)));
                Object it$iv10 = $composer2.rememberedValue();
                if (invalid$iv9 || it$iv10 == Composer.Companion.getEmpty()) {
                    Object value$iv10 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflinePopupKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit OfflinePopup$lambda$10$0;
                            OfflinePopup$lambda$10$0 = OfflinePopupKt.OfflinePopup$lambda$10$0(scope, machine);
                            return OfflinePopup$lambda$10$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv10);
                    it$iv10 = value$iv10;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                OfflineCommonDialogKt.OfflineCommonDialog(string9, false, null, string10, null, (Function0) it$iv10, null, $composer2, 0, 86);
                $composer2.endReplaceGroup();
            } else if (dialogType instanceof DialogType.MaxConcurrentSheet) {
                $composer2.startReplaceGroup(-429013414);
                ComposerKt.sourceInformation($composer2, "150@6526L125");
                OfflineMaxConcurrentKt.OfflineMaxConcurrent(((DialogType.MaxConcurrentSheet) dialogType).getMaxConcurrent(), machine, $composer2, (OfflineBaseListStateMachine.$stable << 3) | ($dirty2 & 112));
                $composer2.endReplaceGroup();
            } else if (dialogType instanceof DialogType.DeleteAlert) {
                $composer2.startReplaceGroup(-428801343);
                ComposerKt.sourceInformation($composer2, "164@6999L84,166@7159L40,167@7232L39,168@7301L169,173@7499L150,163@6948L716");
                if (((DialogType.DeleteAlert) dialogType).getHasVideoGroup()) {
                    $composer2.startReplaceGroup(-428753665);
                    ComposerKt.sourceInformation($composer2, "159@6797L72");
                    String stringResource5 = StringResourcesKt.stringResource(bili.resource.others.String0_commonMainKt.getOthers_global_string_369(Res.string.INSTANCE), $composer2, 0);
                    $composer2.endReplaceGroup();
                    subTitle = stringResource5;
                } else {
                    $composer2.startReplaceGroup(-428638779);
                    $composer2.endReplaceGroup();
                    subTitle = "";
                }
                String stringResource6 = StringResourcesKt.stringResource(String2_commonMainKt.getPlayerbaseres_global_string_3(Res.string.INSTANCE), $composer2, 0);
                String stringResource7 = StringResourcesKt.stringResource(String0_commonMainKt.getConfirm(CommonRes.INSTANCE.getString()), $composer2, 0);
                String stringResource8 = StringResourcesKt.stringResource(String0_commonMainKt.getCancel(CommonRes.INSTANCE.getString()), $composer2, 0);
                ComposerKt.sourceInformationMarkerStart($composer2, -1676381860, "CC(remember):OfflinePopup.kt#9igjgp");
                boolean invalid$iv10 = $composer2.changedInstance(scope) | (($dirty2 & 112) == 32 || (($dirty2 & 64) != 0 && $composer2.changedInstance(machine))) | $composer2.changedInstance(dialogType);
                Object it$iv11 = $composer2.rememberedValue();
                if (invalid$iv10 || it$iv11 == Composer.Companion.getEmpty()) {
                    Object value$iv11 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflinePopupKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit OfflinePopup$lambda$11$0;
                            OfflinePopup$lambda$11$0 = OfflinePopupKt.OfflinePopup$lambda$11$0(scope, machine, dialogType);
                            return OfflinePopup$lambda$11$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv11);
                    it$iv11 = value$iv11;
                }
                Function0 function05 = (Function0) it$iv11;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1676375543, "CC(remember):OfflinePopup.kt#9igjgp");
                boolean invalid$iv11 = $composer2.changedInstance(scope) | (($dirty2 & 112) == 32 || (($dirty2 & 64) != 0 && $composer2.changedInstance(machine)));
                Object it$iv12 = $composer2.rememberedValue();
                if (invalid$iv11 || it$iv12 == Composer.Companion.getEmpty()) {
                    Object value$iv12 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflinePopupKt$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            Unit OfflinePopup$lambda$12$0;
                            OfflinePopup$lambda$12$0 = OfflinePopupKt.OfflinePopup$lambda$12$0(scope, machine);
                            return OfflinePopup$lambda$12$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv12);
                    it$iv12 = value$iv12;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                OfflineCommonDialogKt.OfflineCommonDialog(stringResource6, false, subTitle, stringResource7, stringResource8, function05, (Function0) it$iv12, $composer2, 0, 2);
                $composer2.endReplaceGroup();
            } else if (dialogType instanceof DialogType.BandWidthAlert) {
                $composer2.startReplaceGroup(-427769539);
                ComposerKt.sourceInformation($composer2, "184@7800L72,185@7904L6,191@8056L72,192@8160L6,193@8197L225,202@8496L87,203@8615L6,204@8652L150,217@9187L86,216@9142L310");
                DialogBtn continueDownload = new DialogBtn(StringResourcesKt.stringResource(bili.resource.others.String0_commonMainKt.getOthers_global_string_118(Res.string.INSTANCE), $composer2, 0), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), ((DialogType.BandWidthAlert) dialogType).getAction(), null);
                String stringResource9 = StringResourcesKt.stringResource(bili.resource.others.String0_commonMainKt.getOthers_global_string_252(Res.string.INSTANCE), $composer2, 0);
                long j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                ComposerKt.sourceInformationMarkerStart($composer2, -1676353132, "CC(remember):OfflinePopup.kt#9igjgp");
                boolean invalid$iv12 = $composer2.changedInstance(scope) | (($dirty2 & 112) == 32 || (($dirty2 & 64) != 0 && $composer2.changedInstance(machine)));
                Object it$iv13 = $composer2.rememberedValue();
                if (invalid$iv12 || it$iv13 == Composer.Companion.getEmpty()) {
                    Object value$iv13 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflinePopupKt$$ExternalSyntheticLambda7
                        public final Object invoke() {
                            Unit OfflinePopup$lambda$13$0;
                            OfflinePopup$lambda$13$0 = OfflinePopupKt.OfflinePopup$lambda$13$0(scope, machine);
                            return OfflinePopup$lambda$13$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv13);
                    it$iv13 = value$iv13;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                DialogBtn bandwidth = new DialogBtn(stringResource9, j, (Function0) it$iv13, null);
                String stringResource10 = StringResourcesKt.stringResource(bili.resource.playerbaseres.String0_commonMainKt.getPlayerbaseres_global_string_1569(Res.string.INSTANCE), $composer2, 0);
                long j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                ComposerKt.sourceInformationMarkerStart($composer2, -1676338647, "CC(remember):OfflinePopup.kt#9igjgp");
                boolean invalid$iv13 = $composer2.changedInstance(scope) | (($dirty2 & 112) == 32 || (($dirty2 & 64) != 0 && $composer2.changedInstance(machine)));
                Object it$iv14 = $composer2.rememberedValue();
                if (invalid$iv13 || it$iv14 == Composer.Companion.getEmpty()) {
                    Object value$iv14 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflinePopupKt$$ExternalSyntheticLambda8
                        public final Object invoke() {
                            Unit OfflinePopup$lambda$14$0;
                            OfflinePopup$lambda$14$0 = OfflinePopupKt.OfflinePopup$lambda$14$0(scope, machine);
                            return OfflinePopup$lambda$14$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv14);
                    it$iv14 = value$iv14;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                DialogBtn cancel = new DialogBtn(stringResource10, j2, (Function0) it$iv14, null);
                if (((DialogType.BandWidthAlert) dialogType).getHasFreeBandwidthError()) {
                    $composer2.startReplaceGroup(-426662064);
                    ComposerKt.sourceInformation($composer2, "211@8905L87");
                    String stringResource11 = StringResourcesKt.stringResource(String2_commonMainKt.getPlayerbaseres_global_string_2401(Res.string.INSTANCE), $composer2, 0);
                    $composer2.endReplaceGroup();
                    content = stringResource11;
                    i = 0;
                } else {
                    $composer2.startReplaceGroup(-426530593);
                    ComposerKt.sourceInformation($composer2, "213@9038L72");
                    i = 0;
                    String stringResource12 = StringResourcesKt.stringResource(bili.resource.others.String0_commonMainKt.getOthers_global_string_307(Res.string.INSTANCE), $composer2, 0);
                    $composer2.endReplaceGroup();
                    content = stringResource12;
                }
                String stringResource13 = StringResourcesKt.stringResource(String2_commonMainKt.getPlayerbaseres_global_string_509(Res.string.INSTANCE), $composer2, i);
                DialogBtn[] dialogBtnArr = new DialogBtn[3];
                dialogBtnArr[i] = continueDownload;
                dialogBtnArr[1] = bandwidth;
                dialogBtnArr[2] = cancel;
                OfflineCommonDialogKt.OfflineDialog(stringResource13, CollectionsKt.listOf(dialogBtnArr), null, content, true, null, $composer2, 24576, 36);
                $composer2.endReplaceGroup();
            } else if (!Intrinsics.areEqual(dialogType, DialogType.None.INSTANCE)) {
                $composer2.startReplaceGroup(-1676535420);
                $composer2.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            } else {
                $composer2.startReplaceGroup(-426062803);
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
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflinePopupKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflinePopup$lambda$15;
                    OfflinePopup$lambda$15 = OfflinePopupKt.OfflinePopup$lambda$15(DialogType.this, machine, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflinePopup$lambda$15;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinePopup$lambda$2$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflinePopupKt$OfflinePopup$3$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinePopup$lambda$3$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflinePopupKt$OfflinePopup$4$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinePopup$lambda$4$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine, DialogType $dialogType) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflinePopupKt$OfflinePopup$5$1$1($machine, $dialogType, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinePopup$lambda$5$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflinePopupKt$OfflinePopup$6$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinePopup$lambda$6$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflinePopupKt$OfflinePopup$7$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinePopup$lambda$7$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflinePopupKt$OfflinePopup$8$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinePopup$lambda$8$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflinePopupKt$OfflinePopup$9$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinePopup$lambda$9$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflinePopupKt$OfflinePopup$10$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinePopup$lambda$10$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflinePopupKt$OfflinePopup$11$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinePopup$lambda$11$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine, DialogType $dialogType) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflinePopupKt$OfflinePopup$12$1$1($machine, $dialogType, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinePopup$lambda$12$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflinePopupKt$OfflinePopup$13$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinePopup$lambda$13$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflinePopupKt$OfflinePopup$bandwidth$1$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinePopup$lambda$14$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflinePopupKt$OfflinePopup$cancel$1$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}