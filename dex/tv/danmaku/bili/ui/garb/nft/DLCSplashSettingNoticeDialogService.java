package tv.danmaku.bili.ui.garb.nft;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.graphics.ColorFilter;
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
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.ogv.infra.compose.DrawableResourceKt;
import com.bilibili.ogv.infra.coroutine.ContinuationResumeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.nft.DLCSplashSettingNoticeDialogService;

/* compiled from: DLCSplashSettingNoticeDialog.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0015R/\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/DLCSplashSettingNoticeDialogService;", "", "<init>", "()V", "<set-?>", "Ltv/danmaku/bili/ui/garb/nft/DLCSplashSettingNoticeDialogService$VM;", "vm", "getVm", "()Ltv/danmaku/bili/ui/garb/nft/DLCSplashSettingNoticeDialogService$VM;", "setVm", "(Ltv/danmaku/bili/ui/garb/nft/DLCSplashSettingNoticeDialogService$VM;)V", "vm$delegate", "Landroidx/compose/runtime/MutableState;", "keepDialogShowing", "", "onClick", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "DLCSplashSettingNoticeDialog", "(Ltv/danmaku/bili/ui/garb/nft/DLCSplashSettingNoticeDialogService$VM;Landroidx/compose/runtime/Composer;I)V", "VM", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCSplashSettingNoticeDialogService {
    public static final int $stable = 0;
    private final MutableState vm$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0(DLCSplashSettingNoticeDialogService dLCSplashSettingNoticeDialogService, int i, Composer composer, int i2) {
        dLCSplashSettingNoticeDialogService.Content(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DLCSplashSettingNoticeDialog$lambda$1(DLCSplashSettingNoticeDialogService dLCSplashSettingNoticeDialogService, VM vm, int i, Composer composer, int i2) {
        dLCSplashSettingNoticeDialogService.DLCSplashSettingNoticeDialog(vm, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private final VM getVm() {
        State $this$getValue$iv = this.vm$delegate;
        return (VM) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVm(VM vm) {
        MutableState $this$setValue$iv = this.vm$delegate;
        $this$setValue$iv.setValue(vm);
    }

    public final Object keepDialogShowing(final Function0<Unit> function0, Continuation<? super Unit> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation it = cancellableContinuationImpl;
        setVm(new VM(new Function0<Unit>() { // from class: tv.danmaku.bili.ui.garb.nft.DLCSplashSettingNoticeDialogService$keepDialogShowing$2$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m1772invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m1772invoke() {
                DLCSplashSettingNoticeDialogService.this.setVm(null);
                ContinuationResumeKt.resumeSafely(it, Unit.INSTANCE);
            }
        }, new Function0<Unit>() { // from class: tv.danmaku.bili.ui.garb.nft.DLCSplashSettingNoticeDialogService$keepDialogShowing$2$2
            public /* bridge */ /* synthetic */ Object invoke() {
                m1773invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m1773invoke() {
                function0.invoke();
                this.setVm(null);
                ContinuationResumeKt.resumeSafely(it, Unit.INSTANCE);
            }
        }));
        it.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: tv.danmaku.bili.ui.garb.nft.DLCSplashSettingNoticeDialogService$keepDialogShowing$2$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((Throwable) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable it2) {
                DLCSplashSettingNoticeDialogService.this.setVm(null);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DLCSplashSettingNoticeDialog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/DLCSplashSettingNoticeDialogService$VM;", "", "onDismissRequest", "Lkotlin/Function0;", "", "onClick", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnDismissRequest", "()Lkotlin/jvm/functions/Function0;", "getOnClick", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class VM {
        private final Function0<Unit> onClick;
        private final Function0<Unit> onDismissRequest;

        public VM(Function0<Unit> function0, Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
            Intrinsics.checkNotNullParameter(function02, "onClick");
            this.onDismissRequest = function0;
            this.onClick = function02;
        }

        public final Function0<Unit> getOnDismissRequest() {
            return this.onDismissRequest;
        }

        public final Function0<Unit> getOnClick() {
            return this.onClick;
        }
    }

    public final void Content(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1809899505);
        ComposerKt.sourceInformation($composer2, "C(Content):DLCSplashSettingNoticeDialog.kt#ur528d");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(this) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1809899505, $dirty, -1, "tv.danmaku.bili.ui.garb.nft.DLCSplashSettingNoticeDialogService.Content (DLCSplashSettingNoticeDialog.kt:61)");
            }
            VM tempVm = getVm();
            if (tempVm != null) {
                $composer2.startReplaceGroup(-303211056);
                ComposerKt.sourceInformation($composer2, "64@2239L41");
                DLCSplashSettingNoticeDialog(tempVm, $composer2, ($dirty << 3) & BR.containerVisible);
            } else {
                $composer2.startReplaceGroup(-305421263);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.garb.nft.DLCSplashSettingNoticeDialogService$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$0;
                    Content$lambda$0 = DLCSplashSettingNoticeDialogService.Content$lambda$0(DLCSplashSettingNoticeDialogService.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$0;
                }
            });
        }
    }

    private final void DLCSplashSettingNoticeDialog(final VM vm, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1837649673);
        ComposerKt.sourceInformation($composer2, "C(DLCSplashSettingNoticeDialog)N(vm)78@2609L2509,72@2391L2727:DLCSplashSettingNoticeDialog.kt#ur528d");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(vm) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1837649673, $dirty2, -1, "tv.danmaku.bili.ui.garb.nft.DLCSplashSettingNoticeDialogService.DLCSplashSettingNoticeDialog (DLCSplashSettingNoticeDialog.kt:71)");
            }
            AndroidDialog_androidKt.Dialog(vm.getOnDismissRequest(), new DialogProperties(true, false, false, 4, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(952936654, true, new Function2() { // from class: tv.danmaku.bili.ui.garb.nft.DLCSplashSettingNoticeDialogService$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit DLCSplashSettingNoticeDialog$lambda$0;
                    DLCSplashSettingNoticeDialog$lambda$0 = DLCSplashSettingNoticeDialogService.DLCSplashSettingNoticeDialog$lambda$0(DLCSplashSettingNoticeDialogService.VM.this, (Composer) obj, ((Integer) obj2).intValue());
                    return DLCSplashSettingNoticeDialog$lambda$0;
                }
            }, $composer2, 54), $composer2, (int) BR.pendentVisible, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.garb.nft.DLCSplashSettingNoticeDialogService$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DLCSplashSettingNoticeDialog$lambda$1;
                    DLCSplashSettingNoticeDialog$lambda$1 = DLCSplashSettingNoticeDialogService.DLCSplashSettingNoticeDialog$lambda$1(DLCSplashSettingNoticeDialogService.this, vm, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return DLCSplashSettingNoticeDialog$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DLCSplashSettingNoticeDialog$lambda$0(VM $vm, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        ComposerKt.sourceInformation($composer, "C83@2778L6,79@2623L2485:DLCSplashSettingNoticeDialog.kt#ur528d");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(952936654, $changed, -1, "tv.danmaku.bili.ui.garb.nft.DLCSplashSettingNoticeDialogService.DLCSplashSettingNoticeDialog.<anonymous> (DLCSplashSettingNoticeDialog.kt:79)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU(SizeKt.wrapContentSize$default(Modifier.Companion, (Alignment) null, false, 3, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & BR.containerVisible) | 6;
            BoxScope $this$DLCSplashSettingNoticeDialog_u24lambda_u240_u240 = boxScope;
            ComposerKt.sourceInformationMarkerStart($composer, 1488445511, "C88@2910L1627,131@4842L97,133@5057L6,125@4555L539:DLCSplashSettingNoticeDialog.kt#ur528d");
            Modifier modifier$iv2 = SizeKt.width-3ABfNKs(SizeKt.wrapContentHeight$default(Modifier.Companion, (Alignment.Vertical) null, false, 3, (Object) null), Dp.constructor-impl((float) BR.headerTitle));
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((BR.nickTextColor >> 3) & 14) | ((BR.nickTextColor >> 3) & BR.containerVisible));
            int $changed$iv$iv2 = (BR.nickTextColor << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((BR.nickTextColor >> 6) & BR.containerVisible) | 6;
            ColumnScope $this$DLCSplashSettingNoticeDialog_u24lambda_u240_u240_u240 = columnScope;
            ComposerKt.sourceInformationMarkerStart($composer, -705619355, "C100@3463L6,101@3519L9,94@3155L497,112@3957L6,117@4272L6,118@4333L9,107@3675L844:DLCSplashSettingNoticeDialog.kt#ur528d");
            TextKt.Text--4IGK_g("设置的开屏画面数量已达上限", $this$DLCSplashSettingNoticeDialog_u24lambda_u240_u240_u240.align(SizeKt.wrapContentSize$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(24), 1, (Object) null), (Alignment) null, false, 3, (Object) null), Alignment.Companion.getCenterHorizontally()), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16b(), $composer, 6, 3120, 55288);
            TextKt.Text--4IGK_g("去更改", ClickableKt.clickable-oSLSa3U$default($this$DLCSplashSettingNoticeDialog_u24lambda_u240_u240_u240.align(PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(16), 0.0f, Dp.constructor-impl(16), Dp.constructor-impl(16), 2, (Object) null), 0.0f, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(17))), 0.0f, Dp.constructor-impl(7), 1, (Object) null), Alignment.Companion.getCenterHorizontally()), false, (String) null, (Role) null, (MutableInteractionSource) null, $vm.getOnClick(), 15, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 6, 3120, 54776);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ImageKt.Image(DrawableResourceKt.rememberDrawableResourcePainter(R.drawable.ic_vector_general_close, $composer, 0), (String) null, ClickableKt.clickable-oSLSa3U$default($this$DLCSplashSettingNoticeDialog_u24lambda_u240_u240.align(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(8), Dp.constructor-impl(8), 0.0f, 9, (Object) null), Dp.constructor-impl(20)), Alignment.Companion.getTopEnd()), false, (String) null, (Role) null, (MutableInteractionSource) null, $vm.getOnDismissRequest(), 15, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_icon-0d7_KjU(), 0, 2, (Object) null), $composer, Painter.$stable | 48, 56);
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
}