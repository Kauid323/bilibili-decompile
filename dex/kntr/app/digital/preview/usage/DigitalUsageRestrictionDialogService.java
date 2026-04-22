package kntr.app.digital.preview.usage;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
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
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import com.bilibili.compose.theme.BiliTheme;
import javax.inject.Inject;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.DialogScope;
import kntr.app.digital.preview.DialogService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DigitalUsageRestrictionDialogService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fH\u0003¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/digital/preview/usage/DigitalUsageRestrictionDialogService;", RoomRecommendViewModel.EMPTY_CURSOR, "dialogService", "Lkntr/app/digital/preview/DialogService;", "<init>", "(Lkntr/app/digital/preview/DialogService;)V", "UsingLimitedDialog", RoomRecommendViewModel.EMPTY_CURSOR, "title", RoomRecommendViewModel.EMPTY_CURSOR, "limitedTime", "onDismissRequest", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "keepShowing", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalUsageRestrictionDialogService {
    public static final int $stable = 0;
    private final DialogService dialogService;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UsingLimitedDialog$lambda$1(DigitalUsageRestrictionDialogService digitalUsageRestrictionDialogService, String str, String str2, Function0 function0, int i, Composer composer, int i2) {
        digitalUsageRestrictionDialogService.UsingLimitedDialog(str, str2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    @Inject
    public DigitalUsageRestrictionDialogService(DialogService dialogService) {
        Intrinsics.checkNotNullParameter(dialogService, "dialogService");
        this.dialogService = dialogService;
    }

    private final void UsingLimitedDialog(final String title, final String limitedTime, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(468482989);
        ComposerKt.sourceInformation($composer2, "C(UsingLimitedDialog)N(title,limitedTime,onDismissRequest)43@1586L2112,36@1315L2383:DigitalUsageRestrictionDialogService.kt#q4jl6d");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(limitedTime) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(468482989, $dirty2, -1, "kntr.app.digital.preview.usage.DigitalUsageRestrictionDialogService.UsingLimitedDialog (DigitalUsageRestrictionDialogService.kt:35)");
            }
            AndroidDialog_androidKt.Dialog(function0, new DialogProperties(true, false, false, 4, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-1119837706, true, new Function2() { // from class: kntr.app.digital.preview.usage.DigitalUsageRestrictionDialogService$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit UsingLimitedDialog$lambda$0;
                    UsingLimitedDialog$lambda$0 = DigitalUsageRestrictionDialogService.UsingLimitedDialog$lambda$0(title, function0, limitedTime, (Composer) obj, ((Integer) obj2).intValue());
                    return UsingLimitedDialog$lambda$0;
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 6) & 14) | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.usage.DigitalUsageRestrictionDialogService$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit UsingLimitedDialog$lambda$1;
                    UsingLimitedDialog$lambda$1 = DigitalUsageRestrictionDialogService.UsingLimitedDialog$lambda$1(DigitalUsageRestrictionDialogService.this, title, limitedTime, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return UsingLimitedDialog$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UsingLimitedDialog$lambda$0(String $title, Function0 $onDismissRequest, String $limitedTime, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        ComposerKt.sourceInformation($composer, "C44@1604L2080:DigitalUsageRestrictionDialogService.kt#q4jl6d");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1119837706, $changed, -1, "kntr.app.digital.preview.usage.DigitalUsageRestrictionDialogService.UsingLimitedDialog.<anonymous> (DigitalUsageRestrictionDialogService.kt:44)");
            }
            Modifier modifier$iv = SizeKt.width-3ABfNKs(BackgroundKt.background-bw27NRU(Modifier.Companion, Color.Companion.getWhite-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), Dp.constructor-impl(280));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int i2 = ((0 >> 6) & 112) | 6;
            ColumnScope $this$UsingLimitedDialog_u24lambda_u240_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 599843922, "C59@2269L9,52@1921L384,62@2327L567,79@3003L9,77@2916L750:DigitalUsageRestrictionDialogService.kt#q4jl6d");
            TextKt.Text-Nvy7gAk($title, $this$UsingLimitedDialog_u24lambda_u240_u240.align(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(24), 0.0f, Dp.constructor-impl(6), 5, (Object) null), Alignment.Companion.getCenterHorizontally()), ColorKt.Color(4279769372L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16(), $composer, 384, 0, 131064);
            Modifier modifier$iv2 = $this$UsingLimitedDialog_u24lambda_u240_u240.align(Modifier.Companion, Alignment.Companion.getCenterHorizontally());
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1833529516, "C68@2612L9,65@2461L191,73@2832L9,70@2677L195:DigitalUsageRestrictionDialogService.kt#q4jl6d");
            TextKt.Text-Nvy7gAk("到期时间：", (Modifier) null, ColorKt.Color(4284573293L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT13(), $composer, 390, 0, 131066);
            TextKt.Text-Nvy7gAk($limitedTime, (Modifier) null, ColorKt.Color(4294928025L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT13(), $composer, 384, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextStyle t14 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14();
            long j2 = Color.Companion.getWhite-0d7_KjU();
            int i5 = TextAlign.Companion.getCenter-e0LSkKk();
            TextKt.Text-Nvy7gAk("我知道了", ClickableKt.clickable-oSLSa3U$default(PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.constructor-impl(16), Dp.constructor-impl(24), Dp.constructor-impl(16), Dp.constructor-impl(16)), 0.0f, 1, (Object) null), ColorKt.Color(4294928025L), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), 0.0f, Dp.constructor-impl(12), 1, (Object) null), false, (String) null, (Role) null, (MutableInteractionSource) null, $onDismissRequest, 15, (Object) null), j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i5), 0L, 0, false, 0, 0, (Function1) null, t14, $composer, 390, 0, 130040);
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

    public final Object keepShowing(final String title, final String limitedTime, Continuation<? super Unit> continuation) {
        Object keepDialogShowing = this.dialogService.keepDialogShowing((Function3) ComposableLambdaKt.composableLambdaInstance(-1745282506, true, new Function3() { // from class: kntr.app.digital.preview.usage.DigitalUsageRestrictionDialogService$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit keepShowing$lambda$0;
                keepShowing$lambda$0 = DigitalUsageRestrictionDialogService.keepShowing$lambda$0(DigitalUsageRestrictionDialogService.this, title, limitedTime, (DialogScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return keepShowing$lambda$0;
            }
        }), continuation);
        return keepDialogShowing == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? keepDialogShowing : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit keepShowing$lambda$0(DigitalUsageRestrictionDialogService this$0, String $title, String $limitedTime, DialogScope $this$keepDialogShowing, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$keepDialogShowing, "$this$keepDialogShowing");
        ComposerKt.sourceInformation($composer, "C101@3877L176:DigitalUsageRestrictionDialogService.kt#q4jl6d");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer.changed($this$keepDialogShowing) : $composer.changedInstance($this$keepDialogShowing) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1745282506, $dirty, -1, "kntr.app.digital.preview.usage.DigitalUsageRestrictionDialogService.keepShowing.<anonymous> (DigitalUsageRestrictionDialogService.kt:101)");
            }
            this$0.UsingLimitedDialog($title, $limitedTime, $this$keepDialogShowing.getOnDismissRequest(), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}