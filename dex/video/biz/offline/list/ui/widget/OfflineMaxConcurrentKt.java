package video.biz.offline.list.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.ModalBottomSheetProperties;
import androidx.compose.material3.SheetState;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
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
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.Res;
import bili.resource.playerbaseres.String2_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.StringResourcesKt;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.model.MaxConcurrentModel;
import video.biz.offline.list.logic.model.MaxConcurrentModelKt;
import video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine;

/* compiled from: OfflineMaxConcurrent.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0003¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"OfflineMaxConcurrent", "", "currentMax", "", "machine", "Lvideo/biz/offline/list/logic/statemachine/OfflineBaseListStateMachine;", "(ILvideo/biz/offline/list/logic/statemachine/OfflineBaseListStateMachine;Landroidx/compose/runtime/Composer;I)V", "OptionRow", "model", "Lvideo/biz/offline/list/logic/model/MaxConcurrentModel;", "onClick", "Lkotlin/Function0;", "(Lvideo/biz/offline/list/logic/model/MaxConcurrentModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineMaxConcurrentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineMaxConcurrent$lambda$3(int i, OfflineBaseListStateMachine offlineBaseListStateMachine, int i2, Composer composer, int i3) {
        OfflineMaxConcurrent(i, offlineBaseListStateMachine, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OptionRow$lambda$2(MaxConcurrentModel maxConcurrentModel, Function0 function0, int i, Composer composer, int i2) {
        OptionRow(maxConcurrentModel, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void OfflineMaxConcurrent(final int currentMax, final OfflineBaseListStateMachine machine, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(machine, "machine");
        Composer $composer3 = $composer.startRestartGroup(1181001386);
        ComposerKt.sourceInformation($composer3, "C(OfflineMaxConcurrent)N(currentMax,machine)57@2547L24,59@2654L31,68@2950L6,63@2800L113,73@3072L2802,60@2690L3184:OfflineMaxConcurrent.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(currentMax) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer3.changed(machine) : $composer3.changedInstance(machine) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        boolean z = false;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1181001386, $dirty2, -1, "video.biz.offline.list.ui.widget.OfflineMaxConcurrent (OfflineMaxConcurrent.kt:56)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final List models = MaxConcurrentModelKt.maxConcurrentModels(currentMax);
            SheetState sheetState = ModalBottomSheetKt.rememberModalBottomSheetState(false, (Function1) null, $composer3, 0, 3);
            Shape rectangleShape = RectangleShapeKt.getRectangleShape();
            long j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg2_float-0d7_KjU();
            ComposerKt.sourceInformationMarkerStart($composer3, 1070977499, "CC(remember):OfflineMaxConcurrent.kt#9igjgp");
            boolean changedInstance = $composer3.changedInstance(scope);
            if (($dirty2 & 112) == 32 || (($dirty2 & 64) != 0 && $composer3.changedInstance(machine))) {
                z = true;
            }
            boolean invalid$iv = changedInstance | z;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineMaxConcurrentKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit OfflineMaxConcurrent$lambda$0$0;
                        OfflineMaxConcurrent$lambda$0$0 = OfflineMaxConcurrentKt.OfflineMaxConcurrent$lambda$0$0(scope, machine);
                        return OfflineMaxConcurrent$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            ModalBottomSheetKt.ModalBottomSheet-YbuCTN8((Function0) it$iv, (Modifier) null, sheetState, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, false, rectangleShape, j, 0L, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0L, (Function2) null, new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineMaxConcurrentKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    WindowInsets OfflineMaxConcurrent$lambda$1;
                    OfflineMaxConcurrent$lambda$1 = OfflineMaxConcurrentKt.OfflineMaxConcurrent$lambda$1((Composer) obj, ((Integer) obj2).intValue());
                    return OfflineMaxConcurrent$lambda$1;
                }
            }, (ModalBottomSheetProperties) null, ComposableLambdaKt.rememberComposableLambda(-2005726584, true, new Function3() { // from class: video.biz.offline.list.ui.widget.OfflineMaxConcurrentKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OfflineMaxConcurrent$lambda$2;
                    OfflineMaxConcurrent$lambda$2 = OfflineMaxConcurrentKt.OfflineMaxConcurrent$lambda$2(models, scope, machine, currentMax, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OfflineMaxConcurrent$lambda$2;
                }
            }, $composer3, 54), $composer2, 196608, 3078, 5018);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineMaxConcurrentKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineMaxConcurrent$lambda$3;
                    OfflineMaxConcurrent$lambda$3 = OfflineMaxConcurrentKt.OfflineMaxConcurrent$lambda$3(currentMax, machine, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineMaxConcurrent$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineMaxConcurrent$lambda$0$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineMaxConcurrentKt$OfflineMaxConcurrent$1$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets OfflineMaxConcurrent$lambda$1(Composer $composer, int $changed) {
        $composer.startReplaceGroup(1387491668);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1387491668, $changed, -1, "video.biz.offline.list.ui.widget.OfflineMaxConcurrent.<anonymous> (OfflineMaxConcurrent.kt:71)");
        }
        WindowInsets WindowInsets$default = WindowInsetsKt.WindowInsets$default(0, 0, 0, 0, 14, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return WindowInsets$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0260, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0373, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit OfflineMaxConcurrent$lambda$2(List $models, final CoroutineScope $scope, final OfflineBaseListStateMachine $machine, int $currentMax, ColumnScope $this$ModalBottomSheet, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        final int i = $currentMax;
        Intrinsics.checkNotNullParameter($this$ModalBottomSheet, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation($composer, "C77@3190L12,79@3284L17,74@3082L2786:OfflineMaxConcurrent.kt#uys4uf");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2005726584, $changed, -1, "video.biz.offline.list.ui.widget.OfflineMaxConcurrent.<anonymous> (OfflineMaxConcurrent.kt:74)");
            }
            Modifier modifier$iv = PaddingKt.padding(Modifier.Companion, WindowInsetsKt.asPaddingValues(WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM()), $composer, 0));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int i3 = ((0 >> 6) & 112) | 6;
            ColumnScope $this$OfflineMaxConcurrent_u24lambda_u242_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 673552993, "C85@3529L6,82@3346L346,90@3758L6,89@3705L114,119@4917L6,118@4864L112,125@5122L6,124@5057L104,132@5386L145,122@4989L869:OfflineMaxConcurrent.kt#uys4uf");
            TextKt.Text-Nvy7gAk(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2179(PlayerbaseresRes.INSTANCE.getString())), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(14), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(14), 4, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.Companion.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 1597488, 0, 262056);
            DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, Dp.constructor-impl((float) 0.8d), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa2-0d7_KjU(), $composer, 48, 1);
            $composer.startReplaceGroup(-1917920858);
            ComposerKt.sourceInformation($composer, "*96@3952L574,94@3875L670");
            List $this$forEach$iv = $models;
            boolean z = false;
            Iterator it = $this$forEach$iv.iterator();
            while (true) {
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                if (!it.hasNext()) {
                    break;
                }
                Object element$iv = it.next();
                boolean z2 = z;
                final MaxConcurrentModel option = (MaxConcurrentModel) element$iv;
                Iterator it2 = it;
                ComposerKt.sourceInformationMarkerStart($composer, 69373283, "CC(remember):OfflineMaxConcurrent.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance(option) | $composer.changed(i) | $composer.changedInstance($scope) | $composer.changedInstance($machine);
                CompositionLocalMap localMap$iv$iv2 = localMap$iv$iv;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineMaxConcurrentKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit OfflineMaxConcurrent$lambda$2$0$0$0$0;
                        OfflineMaxConcurrent$lambda$2$0$0$0$0 = OfflineMaxConcurrentKt.OfflineMaxConcurrent$lambda$2$0$0$0$0(MaxConcurrentModel.this, i, $scope, $machine);
                        return OfflineMaxConcurrent$lambda$2$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                OptionRow(option, (Function0) it$iv, $composer, MaxConcurrentModel.$stable);
                if (Intrinsics.areEqual(option, CollectionsKt.last($models))) {
                    $composer.startReplaceGroup(2146632605);
                } else {
                    $composer.startReplaceGroup(-2143751217);
                    ComposerKt.sourceInformation($composer, "112@4674L6,111@4613L206");
                    DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 14, (Object) null), Dp.constructor-impl((float) 0.8d), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa2-0d7_KjU(), $composer, 54, 0);
                }
                $composer.endReplaceGroup();
                i = $currentMax;
                $this$forEach$iv = $this$forEach$iv2;
                z = z2;
                it = it2;
                localMap$iv$iv = localMap$iv$iv2;
            }
            $composer.endReplaceGroup();
            DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, Dp.constructor-impl(5), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa2-0d7_KjU(), $composer, 48, 1);
            ButtonColors buttonColors = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2_float-0d7_KjU(), 0L, 0L, 0L, $composer, ButtonDefaults.$stable << 12, 14);
            Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default($this$OfflineMaxConcurrent_u24lambda_u242_u240.align(Modifier.Companion, Alignment.Companion.getCenterHorizontally()), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(44));
            ComposerKt.sourceInformationMarkerStart($composer, -1917872221, "CC(remember):OfflineMaxConcurrent.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($scope) | $composer.changedInstance($machine);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineMaxConcurrentKt$$ExternalSyntheticLambda7
                public final Object invoke() {
                    Unit OfflineMaxConcurrent$lambda$2$0$1$0;
                    OfflineMaxConcurrent$lambda$2$0$1$0 = OfflineMaxConcurrentKt.OfflineMaxConcurrent$lambda$2$0$1$0($scope, $machine);
                    return OfflineMaxConcurrent$lambda$2$0$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) it$iv2, modifier, false, (Shape) null, buttonColors, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$OfflineMaxConcurrentKt.INSTANCE.m2902getLambda$1158002462$ui_debug(), $composer, 805306368, 492);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineMaxConcurrent$lambda$2$0$0$0$0(MaxConcurrentModel $option, int $currentMax, CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        if ($option.getCount() != $currentMax) {
            $option.setSelected(true);
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineMaxConcurrentKt$OfflineMaxConcurrent$3$1$1$1$1$1($machine, $option, null), 3, (Object) null);
        } else {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineMaxConcurrentKt$OfflineMaxConcurrent$3$1$1$1$1$2($machine, null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineMaxConcurrent$lambda$2$0$1$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineMaxConcurrentKt$OfflineMaxConcurrent$3$1$2$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    private static final void OptionRow(final MaxConcurrentModel model, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(-1390596344);
        ComposerKt.sourceInformation($composer3, "C(OptionRow)N(model,onClick)159@6112L49,154@5977L1169:OfflineMaxConcurrent.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer3.changed(model) : $composer3.changedInstance(model) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1390596344, $dirty, -1, "video.biz.offline.list.ui.widget.OptionRow (OfflineMaxConcurrent.kt:153)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(44)), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -628250631, "CC(remember):OfflineMaxConcurrent.kt#9igjgp");
            boolean invalid$iv = ($dirty & 112) == 32;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineMaxConcurrentKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit OptionRow$lambda$0$0;
                        OptionRow$lambda$0$0 = OfflineMaxConcurrentKt.OptionRow$lambda$0$0(function0);
                        return OptionRow$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(fillMaxWidth$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(12), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -915623148, "C166@6337L512:OfflineMaxConcurrent.kt#uys4uf");
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv2 = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            int $changed$iv = ((384 >> 3) & 14) | ((384 >> 3) & 112);
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, $changed$iv);
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer2 = $composer3;
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
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i4 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1690525633, "C168@6449L87,170@6608L6,167@6403L231,172@6647L39,175@6773L6,173@6699L140:OfflineMaxConcurrent.kt#uys4uf");
            TextKt.Text-Nvy7gAk(model.getCount() + StringResourcesKt.stringResource(String2_commonMainKt.getPlayerbaseres_global_string_2281(Res.string.INSTANCE), $composer3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24576, 0, 262122);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer3, 6);
            TextKt.Text-Nvy7gAk(model.getTip(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24576, 0, 262122);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (model.getSelected()) {
                $composer3.startReplaceGroup(-915074728);
                ComposerKt.sourceInformation($composer3, "182@6953L18,183@7006L6,181@6908L222");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getCheckmark_line_800($composer3, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(22)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), $composer3, Painter.$stable | 432, 0);
            } else {
                $composer3.startReplaceGroup(-921935338);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineMaxConcurrentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit OptionRow$lambda$2;
                    OptionRow$lambda$2 = OfflineMaxConcurrentKt.OptionRow$lambda$2(MaxConcurrentModel.this, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return OptionRow$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OptionRow$lambda$0$0(Function0 $onClick) {
        $onClick.invoke();
        return Unit.INSTANCE;
    }
}