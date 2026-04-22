package video.biz.offline.list.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import video.biz.offline.list.logic.model.OfflinePageOperation;
import video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine;

/* compiled from: OfflineOperationComponent.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u001aD\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\tH\u0001¢\u0006\u0002\u0010\n\u001a!\u0010\u000b\u001a\u00020\u0001*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0002\u0010\u0011\u001a)\u0010\u0012\u001a\u00020\u0001*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0001¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"OfflineOperation", "", "modifier", "Landroidx/compose/ui/Modifier;", "isEnable", "", "onclick", "Lkotlin/Function0;", "content", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "mapToHeaderComponent", "Lvideo/biz/offline/list/logic/model/OfflinePageOperation;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "machine", "Lvideo/biz/offline/list/logic/statemachine/OfflineBaseListStateMachine;", "(Lvideo/biz/offline/list/logic/model/OfflinePageOperation;Lkotlinx/coroutines/CoroutineScope;Lvideo/biz/offline/list/logic/statemachine/OfflineBaseListStateMachine;Landroidx/compose/runtime/Composer;I)V", "mapToFooterComponent", "selectedCount", "", "(Lvideo/biz/offline/list/logic/model/OfflinePageOperation;Lkotlinx/coroutines/CoroutineScope;Lvideo/biz/offline/list/logic/statemachine/OfflineBaseListStateMachine;ILandroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineOperationComponentKt {

    /* compiled from: OfflineOperationComponent.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfflinePageOperation.values().length];
            try {
                iArr[OfflinePageOperation.SEARCH_ICON.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[OfflinePageOperation.SETTING_ICON.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[OfflinePageOperation.EDIT_ICON.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[OfflinePageOperation.EDIT_TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[OfflinePageOperation.SETTING_TEXT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[OfflinePageOperation.CONTINUOUS_PLAY_ICON_TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[OfflinePageOperation.MANAGE_TEXT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[OfflinePageOperation.DELETE_TEXT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[OfflinePageOperation.DANMAKU_TEXT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineOperation$lambda$3(Modifier modifier, boolean z, Function0 function0, Function2 function2, int i, int i2, Composer composer, int i3) {
        OfflineOperation(modifier, z, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mapToFooterComponent$lambda$2(OfflinePageOperation offlinePageOperation, CoroutineScope coroutineScope, OfflineBaseListStateMachine offlineBaseListStateMachine, int i, int i2, Composer composer, int i3) {
        mapToFooterComponent(offlinePageOperation, coroutineScope, offlineBaseListStateMachine, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mapToHeaderComponent$lambda$7(OfflinePageOperation offlinePageOperation, CoroutineScope coroutineScope, OfflineBaseListStateMachine offlineBaseListStateMachine, int i, Composer composer, int i2) {
        mapToHeaderComponent(offlinePageOperation, coroutineScope, offlineBaseListStateMachine, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v6 */
    public static final void OfflineOperation(Modifier modifier, boolean isEnable, Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        final Function0 onclick;
        Modifier modifier3;
        boolean isEnable2;
        Modifier modifier4;
        boolean isEnable3;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(-253617442);
        ComposerKt.sourceInformation($composer2, "C(OfflineOperation)N(modifier,isEnable,onclick,content)44@2118L2,51@2310L13,47@2167L252:OfflineOperationComponent.kt#uys4uf");
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
            z = isEnable;
        } else if (($changed & 48) == 0) {
            z = isEnable;
            $dirty |= $composer2.changed(z) ? 32 : 16;
        } else {
            z = isEnable;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            onclick = function0;
        } else if (($changed & 384) == 0) {
            onclick = function0;
            $dirty |= $composer2.changedInstance(onclick) ? 256 : 128;
        } else {
            onclick = function0;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            isEnable2 = z;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                isEnable3 = z;
            } else {
                isEnable3 = true;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1086777728, "CC(remember):OfflineOperationComponent.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineOperationComponentKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onclick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onclick = onclick2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-253617442, $dirty2, -1, "video.biz.offline.list.ui.widget.OfflineOperation (OfflineOperationComponent.kt:46)");
            }
            Modifier alpha = AlphaKt.alpha(modifier4, isEnable3 ? 1.0f : 0.5f);
            ComposerKt.sourceInformationMarkerStart($composer2, 1086783883, "CC(remember):OfflineOperationComponent.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineOperationComponentKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit OfflineOperation$lambda$1$0;
                        OfflineOperation$lambda$1$0 = OfflineOperationComponentKt.OfflineOperation$lambda$1$0(onclick);
                        return OfflineOperation$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(alpha, isEnable3, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 14, (Object) null), Dp.constructor-impl(10), Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            boolean isEnable4 = isEnable3;
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
            Function0 onclick3 = onclick;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -716216842, "C54@2404L9:OfflineOperationComponent.kt#uys4uf");
            function2.invoke($composer2, Integer.valueOf(($dirty2 >> 9) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            isEnable2 = isEnable4;
            onclick = onclick3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = isEnable2;
            final Function0 function02 = onclick;
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineOperationComponentKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineOperation$lambda$3;
                    OfflineOperation$lambda$3 = OfflineOperationComponentKt.OfflineOperation$lambda$3(modifier5, z2, function02, function2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineOperation$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineOperation$lambda$1$0(Function0 $onclick) {
        $onclick.invoke();
        return Unit.INSTANCE;
    }

    public static final void mapToHeaderComponent(final OfflinePageOperation $this$mapToHeaderComponent, final CoroutineScope scope, final OfflineBaseListStateMachine machine, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter($this$mapToHeaderComponent, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(machine, "machine");
        Composer $composer2 = $composer.startRestartGroup(-336962074);
        ComposerKt.sourceInformation($composer2, "C(mapToHeaderComponent)N(scope,machine):OfflineOperationComponent.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$mapToHeaderComponent.ordinal()) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(scope) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= ($changed & 512) == 0 ? $composer2.changed(machine) : $composer2.changedInstance(machine) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        boolean z = false;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-336962074, $dirty2, -1, "video.biz.offline.list.ui.widget.mapToHeaderComponent (OfflineOperationComponent.kt:62)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[$this$mapToHeaderComponent.ordinal()]) {
                case 1:
                    $composer2.startReplaceGroup(-1098389935);
                    ComposerKt.sourceInformation($composer2, "65@2668L114,64@2628L411");
                    ComposerKt.sourceInformationMarkerStart($composer2, -1697998632, "CC(remember):OfflineOperationComponent.kt#9igjgp");
                    boolean changedInstance = $composer2.changedInstance(scope);
                    if (($dirty2 & 896) == 256 || (($dirty2 & 512) != 0 && $composer2.changedInstance(machine))) {
                        z = true;
                    }
                    boolean invalid$iv = changedInstance | z;
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineOperationComponentKt$$ExternalSyntheticLambda11
                            public final Object invoke() {
                                Unit mapToHeaderComponent$lambda$0$0;
                                mapToHeaderComponent$lambda$0$0 = OfflineOperationComponentKt.mapToHeaderComponent$lambda$0$0(scope, machine);
                                return mapToHeaderComponent$lambda$0$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    OfflineOperation(null, false, (Function0) it$iv, ComposableSingletons$OfflineOperationComponentKt.INSTANCE.m2909getLambda$1536010278$ui_debug(), $composer2, 3072, 3);
                    $composer2.endReplaceGroup();
                    break;
                case 2:
                    $composer2.startReplaceGroup(-1097923819);
                    ComposerKt.sourceInformation($composer2, "82@3138L115,81@3098L407");
                    ComposerKt.sourceInformationMarkerStart($composer2, -1697983591, "CC(remember):OfflineOperationComponent.kt#9igjgp");
                    boolean changedInstance2 = $composer2.changedInstance(scope);
                    if (($dirty2 & 896) == 256 || (($dirty2 & 512) != 0 && $composer2.changedInstance(machine))) {
                        z = true;
                    }
                    boolean invalid$iv2 = changedInstance2 | z;
                    Object it$iv2 = $composer2.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineOperationComponentKt$$ExternalSyntheticLambda12
                            public final Object invoke() {
                                Unit mapToHeaderComponent$lambda$1$0;
                                mapToHeaderComponent$lambda$1$0 = OfflineOperationComponentKt.mapToHeaderComponent$lambda$1$0(scope, machine);
                                return mapToHeaderComponent$lambda$1$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    OfflineOperation(null, false, (Function0) it$iv2, ComposableSingletons$OfflineOperationComponentKt.INSTANCE.getLambda$1647529681$ui_debug(), $composer2, 3072, 3);
                    $composer2.endReplaceGroup();
                    break;
                case 3:
                    $composer2.startReplaceGroup(-1097463934);
                    ComposerKt.sourceInformation($composer2, "99@3601L134,98@3561L426");
                    ComposerKt.sourceInformationMarkerStart($composer2, -1697968756, "CC(remember):OfflineOperationComponent.kt#9igjgp");
                    boolean changedInstance3 = $composer2.changedInstance(scope);
                    if (($dirty2 & 896) == 256 || (($dirty2 & 512) != 0 && $composer2.changedInstance(machine))) {
                        z = true;
                    }
                    boolean invalid$iv3 = changedInstance3 | z;
                    Object it$iv3 = $composer2.rememberedValue();
                    if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineOperationComponentKt$$ExternalSyntheticLambda13
                            public final Object invoke() {
                                Unit mapToHeaderComponent$lambda$2$0;
                                mapToHeaderComponent$lambda$2$0 = OfflineOperationComponentKt.mapToHeaderComponent$lambda$2$0(scope, machine);
                                return mapToHeaderComponent$lambda$2$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv3);
                        it$iv3 = value$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    OfflineOperation(null, false, (Function0) it$iv3, ComposableSingletons$OfflineOperationComponentKt.INSTANCE.m2910getLambda$175657582$ui_debug(), $composer2, 3072, 3);
                    $composer2.endReplaceGroup();
                    break;
                case 4:
                    $composer2.startReplaceGroup(-1096983124);
                    ComposerKt.sourceInformation($composer2, "116@4083L134,115@4043L512");
                    ComposerKt.sourceInformationMarkerStart($composer2, -1697953332, "CC(remember):OfflineOperationComponent.kt#9igjgp");
                    boolean changedInstance4 = $composer2.changedInstance(scope);
                    if (($dirty2 & 896) == 256 || (($dirty2 & 512) != 0 && $composer2.changedInstance(machine))) {
                        z = true;
                    }
                    boolean invalid$iv4 = changedInstance4 | z;
                    Object it$iv4 = $composer2.rememberedValue();
                    if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv4 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineOperationComponentKt$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                Unit mapToHeaderComponent$lambda$3$0;
                                mapToHeaderComponent$lambda$3$0 = OfflineOperationComponentKt.mapToHeaderComponent$lambda$3$0(scope, machine);
                                return mapToHeaderComponent$lambda$3$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv4);
                        it$iv4 = value$iv4;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    OfflineOperation(null, false, (Function0) it$iv4, ComposableSingletons$OfflineOperationComponentKt.INSTANCE.m2911getLambda$1998844845$ui_debug(), $composer2, 3072, 3);
                    $composer2.endReplaceGroup();
                    break;
                case 5:
                    $composer2.startReplaceGroup(-1096417312);
                    ComposerKt.sourceInformation($composer2, "134@4654L115,133@4614L492");
                    ComposerKt.sourceInformationMarkerStart($composer2, -1697935079, "CC(remember):OfflineOperationComponent.kt#9igjgp");
                    boolean changedInstance5 = $composer2.changedInstance(scope);
                    if (($dirty2 & 896) == 256 || (($dirty2 & 512) != 0 && $composer2.changedInstance(machine))) {
                        z = true;
                    }
                    boolean invalid$iv5 = changedInstance5 | z;
                    Object it$iv5 = $composer2.rememberedValue();
                    if (invalid$iv5 || it$iv5 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineOperationComponentKt$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                Unit mapToHeaderComponent$lambda$4$0;
                                mapToHeaderComponent$lambda$4$0 = OfflineOperationComponentKt.mapToHeaderComponent$lambda$4$0(scope, machine);
                                return mapToHeaderComponent$lambda$4$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv5);
                        it$iv5 = value$iv5;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    OfflineOperation(null, false, (Function0) it$iv5, ComposableSingletons$OfflineOperationComponentKt.INSTANCE.getLambda$472935188$ui_debug(), $composer2, 3072, 3);
                    $composer2.endReplaceGroup();
                    break;
                case 6:
                    $composer2.startReplaceGroup(-1095844370);
                    ComposerKt.sourceInformation($composer2, "152@5218L122,151@5178L926");
                    ComposerKt.sourceInformationMarkerStart($composer2, -1697917024, "CC(remember):OfflineOperationComponent.kt#9igjgp");
                    boolean changedInstance6 = $composer2.changedInstance(scope);
                    if (($dirty2 & 896) == 256 || (($dirty2 & 512) != 0 && $composer2.changedInstance(machine))) {
                        z = true;
                    }
                    boolean invalid$iv6 = changedInstance6 | z;
                    Object it$iv6 = $composer2.rememberedValue();
                    if (invalid$iv6 || it$iv6 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineOperationComponentKt$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                Unit mapToHeaderComponent$lambda$5$0;
                                mapToHeaderComponent$lambda$5$0 = OfflineOperationComponentKt.mapToHeaderComponent$lambda$5$0(scope, machine);
                                return mapToHeaderComponent$lambda$5$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv6);
                        it$iv6 = value$iv6;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    OfflineOperation(null, false, (Function0) it$iv6, ComposableSingletons$OfflineOperationComponentKt.INSTANCE.m2907getLambda$1350252075$ui_debug(), $composer2, 3072, 3);
                    $composer2.endReplaceGroup();
                    break;
                case 7:
                    $composer2.startReplaceGroup(-1094881107);
                    ComposerKt.sourceInformation($composer2, "179@6202L134,178@6162L511");
                    ComposerKt.sourceInformationMarkerStart($composer2, -1697885524, "CC(remember):OfflineOperationComponent.kt#9igjgp");
                    boolean changedInstance7 = $composer2.changedInstance(scope);
                    if (($dirty2 & 896) == 256 || (($dirty2 & 512) != 0 && $composer2.changedInstance(machine))) {
                        z = true;
                    }
                    boolean invalid$iv7 = changedInstance7 | z;
                    Object it$iv7 = $composer2.rememberedValue();
                    if (invalid$iv7 || it$iv7 == Composer.Companion.getEmpty()) {
                        Object value$iv7 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineOperationComponentKt$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                Unit mapToHeaderComponent$lambda$6$0;
                                mapToHeaderComponent$lambda$6$0 = OfflineOperationComponentKt.mapToHeaderComponent$lambda$6$0(scope, machine);
                                return mapToHeaderComponent$lambda$6$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv7);
                        it$iv7 = value$iv7;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    OfflineOperation(null, false, (Function0) it$iv7, ComposableSingletons$OfflineOperationComponentKt.INSTANCE.getLambda$1121527958$ui_debug(), $composer2, 3072, 3);
                    $composer2.endReplaceGroup();
                    break;
                default:
                    $composer2.startReplaceGroup(-1094360710);
                    $composer2.endReplaceGroup();
                    break;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineOperationComponentKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit mapToHeaderComponent$lambda$7;
                    mapToHeaderComponent$lambda$7 = OfflineOperationComponentKt.mapToHeaderComponent$lambda$7(OfflinePageOperation.this, scope, machine, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return mapToHeaderComponent$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mapToHeaderComponent$lambda$0$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineOperationComponentKt$mapToHeaderComponent$1$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mapToHeaderComponent$lambda$1$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineOperationComponentKt$mapToHeaderComponent$2$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mapToHeaderComponent$lambda$2$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineOperationComponentKt$mapToHeaderComponent$3$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mapToHeaderComponent$lambda$3$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineOperationComponentKt$mapToHeaderComponent$4$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mapToHeaderComponent$lambda$4$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineOperationComponentKt$mapToHeaderComponent$5$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mapToHeaderComponent$lambda$5$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineOperationComponentKt$mapToHeaderComponent$6$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mapToHeaderComponent$lambda$6$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineOperationComponentKt$mapToHeaderComponent$7$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    public static final void mapToFooterComponent(final OfflinePageOperation $this$mapToFooterComponent, final CoroutineScope scope, final OfflineBaseListStateMachine machine, final int selectedCount, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter($this$mapToFooterComponent, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(machine, "machine");
        Composer $composer2 = $composer.startRestartGroup(1477646231);
        ComposerKt.sourceInformation($composer2, "C(mapToFooterComponent)N(scope,machine,selectedCount):OfflineOperationComponent.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$mapToFooterComponent.ordinal()) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(scope) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= ($changed & 512) == 0 ? $composer2.changed(machine) : $composer2.changedInstance(machine) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(selectedCount) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1477646231, $dirty2, -1, "video.biz.offline.list.ui.widget.mapToFooterComponent (OfflineOperationComponent.kt:203)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[$this$mapToFooterComponent.ordinal()]) {
                case 8:
                    $composer2.startReplaceGroup(1439262563);
                    ComposerKt.sourceInformation($composer2, "207@7010L129,205@6928L472");
                    boolean z = selectedCount > 0;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1616137576, "CC(remember):OfflineOperationComponent.kt#9igjgp");
                    boolean invalid$iv = $composer2.changedInstance(scope) | (($dirty2 & 896) == 256 || (($dirty2 & 512) != 0 && $composer2.changedInstance(machine)));
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineOperationComponentKt$$ExternalSyntheticLambda8
                            public final Object invoke() {
                                Unit mapToFooterComponent$lambda$0$0;
                                mapToFooterComponent$lambda$0$0 = OfflineOperationComponentKt.mapToFooterComponent$lambda$0$0(scope, machine);
                                return mapToFooterComponent$lambda$0$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    OfflineOperation(null, z, (Function0) it$iv, ComposableSingletons$OfflineOperationComponentKt.INSTANCE.getLambda$929363851$ui_debug(), $composer2, 3072, 1);
                    $composer2.endReplaceGroup();
                    break;
                case 9:
                    $composer2.startReplaceGroup(1439796755);
                    ComposerKt.sourceInformation($composer2, "222@7486L7,225@7584L326,223@7502L669");
                    CompositionLocal this_$iv = ToasterKt.getLocalToaster();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(this_$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    final Toaster toaster = (Toaster) consume;
                    boolean z2 = selectedCount > 0;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1616119011, "CC(remember):OfflineOperationComponent.kt#9igjgp");
                    boolean invalid$iv2 = $composer2.changedInstance(scope) | (($dirty2 & 896) == 256 || (($dirty2 & 512) != 0 && $composer2.changedInstance(machine))) | $composer2.changedInstance(toaster);
                    Object it$iv2 = $composer2.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineOperationComponentKt$$ExternalSyntheticLambda9
                            public final Object invoke() {
                                Unit mapToFooterComponent$lambda$1$0;
                                mapToFooterComponent$lambda$1$0 = OfflineOperationComponentKt.mapToFooterComponent$lambda$1$0(scope, machine, toaster);
                                return mapToFooterComponent$lambda$1$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    OfflineOperation(null, z2, (Function0) it$iv2, ComposableSingletons$OfflineOperationComponentKt.INSTANCE.m2908getLambda$1387029758$ui_debug(), $composer2, 3072, 1);
                    $composer2.endReplaceGroup();
                    break;
                default:
                    $composer2.startReplaceGroup(1440510313);
                    $composer2.endReplaceGroup();
                    break;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineOperationComponentKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit mapToFooterComponent$lambda$2;
                    mapToFooterComponent$lambda$2 = OfflineOperationComponentKt.mapToFooterComponent$lambda$2(OfflinePageOperation.this, scope, machine, selectedCount, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return mapToFooterComponent$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mapToFooterComponent$lambda$0$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineOperationComponentKt$mapToFooterComponent$1$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mapToFooterComponent$lambda$1$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine, Toaster $toaster) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineOperationComponentKt$mapToFooterComponent$2$1$1($machine, $toaster, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}