package tv.danmaku.bili.ui.garb.digital.lockcard;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
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
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.ogv.infra.coroutine.ContinuationResumeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import tv.danmaku.bili.ui.garb.digital.lockcard.UnlockCardDialogService;

/* compiled from: UnlockCardDialog.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0015R/\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/lockcard/UnlockCardDialogService;", "", "<init>", "()V", "<set-?>", "Ltv/danmaku/bili/ui/garb/digital/lockcard/UnlockCardDialogService$VM;", "vm", "getVm", "()Ltv/danmaku/bili/ui/garb/digital/lockcard/UnlockCardDialogService$VM;", "setVm", "(Ltv/danmaku/bili/ui/garb/digital/lockcard/UnlockCardDialogService$VM;)V", "vm$delegate", "Landroidx/compose/runtime/MutableState;", "keepDialogShowing", "", "onClick", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "UnlockCardDialog", "(Ltv/danmaku/bili/ui/garb/digital/lockcard/UnlockCardDialogService$VM;Landroidx/compose/runtime/Composer;I)V", "VM", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UnlockCardDialogService {
    public static final int $stable = 0;
    private final MutableState vm$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0(UnlockCardDialogService unlockCardDialogService, int i, Composer composer, int i2) {
        unlockCardDialogService.Content(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnlockCardDialog$lambda$1(UnlockCardDialogService unlockCardDialogService, VM vm, int i, Composer composer, int i2) {
        unlockCardDialogService.UnlockCardDialog(vm, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
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
        setVm(new VM(new Function0<Unit>() { // from class: tv.danmaku.bili.ui.garb.digital.lockcard.UnlockCardDialogService$keepDialogShowing$2$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m1743invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m1743invoke() {
                UnlockCardDialogService.this.setVm(null);
                ContinuationResumeKt.resumeSafely(it, Unit.INSTANCE);
            }
        }, new Function0<Unit>() { // from class: tv.danmaku.bili.ui.garb.digital.lockcard.UnlockCardDialogService$keepDialogShowing$2$2
            public /* bridge */ /* synthetic */ Object invoke() {
                m1744invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m1744invoke() {
                function0.invoke();
                this.setVm(null);
                ContinuationResumeKt.resumeSafely(it, Unit.INSTANCE);
            }
        }));
        it.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: tv.danmaku.bili.ui.garb.digital.lockcard.UnlockCardDialogService$keepDialogShowing$2$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((Throwable) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable it2) {
                UnlockCardDialogService.this.setVm(null);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UnlockCardDialog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/lockcard/UnlockCardDialogService$VM;", "", "onDismissRequest", "Lkotlin/Function0;", "", "onClick", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnDismissRequest", "()Lkotlin/jvm/functions/Function0;", "getOnClick", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
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
        Composer $composer2 = $composer.startRestartGroup(1240056916);
        ComposerKt.sourceInformation($composer2, "C(Content):UnlockCardDialog.kt#fsh0na");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(this) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1240056916, $dirty, -1, "tv.danmaku.bili.ui.garb.digital.lockcard.UnlockCardDialogService.Content (UnlockCardDialog.kt:63)");
            }
            VM tempVm = getVm();
            if (tempVm != null) {
                $composer2.startReplaceGroup(1521940606);
                ComposerKt.sourceInformation($composer2, "66@2268L24");
                UnlockCardDialog(tempVm, $composer2, ($dirty << 3) & BR.containerVisible);
            } else {
                $composer2.startReplaceGroup(1519702158);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.garb.digital.lockcard.UnlockCardDialogService$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$0;
                    Content$lambda$0 = UnlockCardDialogService.Content$lambda$0(UnlockCardDialogService.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$0;
                }
            });
        }
    }

    private final void UnlockCardDialog(final VM vm, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1780187204);
        ComposerKt.sourceInformation($composer2, "C(UnlockCardDialog)N(vm)78@2595L4027,72@2377L4245:UnlockCardDialog.kt#fsh0na");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(vm) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1780187204, $dirty2, -1, "tv.danmaku.bili.ui.garb.digital.lockcard.UnlockCardDialogService.UnlockCardDialog (UnlockCardDialog.kt:71)");
            }
            AndroidDialog_androidKt.Dialog(vm.getOnDismissRequest(), new DialogProperties(true, false, false, 4, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(1879428549, true, new Function2() { // from class: tv.danmaku.bili.ui.garb.digital.lockcard.UnlockCardDialogService$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit UnlockCardDialog$lambda$0;
                    UnlockCardDialog$lambda$0 = UnlockCardDialogService.UnlockCardDialog$lambda$0(UnlockCardDialogService.VM.this, (Composer) obj, ((Integer) obj2).intValue());
                    return UnlockCardDialog$lambda$0;
                }
            }, $composer2, 54), $composer2, (int) BR.pendentVisible, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.garb.digital.lockcard.UnlockCardDialogService$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit UnlockCardDialog$lambda$1;
                    UnlockCardDialog$lambda$1 = UnlockCardDialogService.UnlockCardDialog$lambda$1(UnlockCardDialogService.this, vm, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return UnlockCardDialog$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x051a, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit UnlockCardDialog$lambda$0(final VM $vm, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        ComposerKt.sourceInformation($composer, "C79@2609L4003:UnlockCardDialog.kt#fsh0na");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1879428549, $changed, -1, "tv.danmaku.bili.ui.garb.digital.lockcard.UnlockCardDialogService.UnlockCardDialog.<anonymous> (UnlockCardDialog.kt:79)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU(SizeKt.wrapContentSize$default(Modifier.Companion, (Alignment) null, false, 3, (Object) null), ColorKt.Color(4280690214L), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
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
            ComposerKt.sourceInformationMarkerStart($composer, -528548124, "C87@2886L3712:UnlockCardDialog.kt#fsh0na");
            Modifier modifier$iv2 = SizeKt.wrapContentHeight$default(SizeKt.width-3ABfNKs(PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.constructor-impl(16), Dp.constructor-impl(24), Dp.constructor-impl(16), Dp.constructor-impl(16)), Dp.constructor-impl((float) BR.headerTitle)), (Alignment.Vertical) null, false, 3, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((BR.negativeBtnVisible >> 3) & 14) | ((BR.negativeBtnVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv2 = (BR.negativeBtnVisible << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
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
            int i4 = ((BR.negativeBtnVisible >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 2145324315, "C100@3516L6,101@3577L9,94@3221L488,105@3730L40,113@4153L9,106@3791L398,115@4210L41,116@4272L2308:UnlockCardDialog.kt#fsh0na");
            TextKt.Text--4IGK_g("确认解锁这张卡牌吗？", SizeKt.wrapContentSize$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(4), 0.0f, 2, (Object) null), (Alignment) null, false, 3, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16(), $composer, 54, 3120, 54776);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer, 6);
            TextKt.Text--4IGK_g("卡牌解锁后，可前往\n背包-分解页面选择卡牌进行分解", SizeKt.wrapContentSize$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(4), 0.0f, 2, (Object) null), (Alignment) null, false, 3, (Object) null), ColorKt.Color(3019898879L), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT13(), $composer, (int) BR.playTimeText, 0, 65016);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), $composer, 6);
            Modifier modifier$iv3 = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((54 >> 3) & 14) | ((54 >> 3) & BR.containerVisible));
            int $changed$iv$iv3 = (54 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i6 = ((54 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -915957511, "C130@4974L93,133@5115L9,136@5275L6,122@4537L886,140@5448L40,152@6126L84,155@6258L9,141@5513L1045:UnlockCardDialog.kt#fsh0na");
            Modifier modifier = PaddingKt.padding-VpY3zN4(BorderKt.border-xT4_qwU(Modifier.Companion, Dp.constructor-impl((float) 0.5d), ColorKt.Color(2164260863L), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(48))), Dp.constructor-impl(44), Dp.constructor-impl(7));
            ComposerKt.sourceInformationMarkerStart($composer, -1553555614, "CC(remember):UnlockCardDialog.kt#9igjgp");
            boolean invalid$iv = $composer.changed($vm);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: tv.danmaku.bili.ui.garb.digital.lockcard.UnlockCardDialogService$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit UnlockCardDialog$lambda$0$0$0$0$0$0;
                    UnlockCardDialog$lambda$0$0$0$0$0$0 = UnlockCardDialogService.UnlockCardDialog$lambda$0$0$0$0$0$0(UnlockCardDialogService.VM.this);
                    return UnlockCardDialog$lambda$0$0$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextKt.Text--4IGK_g("取消", ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 6, 3120, 54776);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer, 6);
            Modifier modifier2 = PaddingKt.padding-VpY3zN4(BackgroundKt.background$default(Modifier.Companion, Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4294967295L)), Color.box-impl(ColorKt.Color(4294964413L))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(48)), 0.0f, 4, (Object) null), Dp.constructor-impl(30), Dp.constructor-impl(7));
            ComposerKt.sourceInformationMarkerStart($composer, -1553518759, "CC(remember):UnlockCardDialog.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($vm);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.ui.garb.digital.lockcard.UnlockCardDialogService$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit UnlockCardDialog$lambda$0$0$0$0$1$0;
                        UnlockCardDialog$lambda$0$0$0$0$1$0 = UnlockCardDialogService.UnlockCardDialog$lambda$0$0$0$0$1$0(UnlockCardDialogService.VM.this);
                        return UnlockCardDialog$lambda$0$0$0$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextKt.Text--4IGK_g("确认解锁", ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), ColorKt.Color(4279834905L), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, (int) BR.nickTextColor, 3120, 54776);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
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
    public static final Unit UnlockCardDialog$lambda$0$0$0$0$0$0(VM $vm) {
        $vm.getOnDismissRequest().invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnlockCardDialog$lambda$0$0$0$0$1$0(VM $vm) {
        $vm.getOnClick().invoke();
        return Unit.INSTANCE;
    }
}