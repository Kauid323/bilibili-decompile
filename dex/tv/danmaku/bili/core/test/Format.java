package tv.danmaku.bili.core.test;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ButtonColors;
import androidx.compose.material.ButtonElevation;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.TextKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bilibili.base.util.NumberFormat;
import com.bilibili.list.test.AbsComposeItem;
import com.bilibili.video.story.extension.ToastToolsKt;
import kntr.base.localization.NumberFormat_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.YieldKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: CommonTestPage.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010\u000bJ\r\u0010\f\u001a\u00020\nH\u0017¢\u0006\u0002\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/core/test/测试大鸡儿的Format;", "Lcom/bilibili/list/test/AbsComposeItem;", "<init>", "()V", "isRunning", "", "()Z", "setRunning", "(Z)V", "testNumberFormat", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ContentImpl", "(Landroidx/compose/runtime/Composer;I)V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
/* renamed from: tv.danmaku.bili.core.test.测试大鸡儿的Format  reason: invalid class name */
public final class Format extends AbsComposeItem {
    public static final int $stable = 8;
    private boolean isRunning;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentImpl$lambda$1(Format format, int i, Composer composer, int i2) {
        format.ContentImpl(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public final boolean isRunning() {
        return this.isRunning;
    }

    public final void setRunning(boolean z) {
        this.isRunning = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005c -> B:22:0x006f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006b -> B:22:0x006f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object testNumberFormat(Continuation<? super Unit> continuation) {
        Format$testNumberFormat$1 format$testNumberFormat$1;
        int i;
        int failureTimes;
        long i2;
        if (continuation instanceof Format$testNumberFormat$1) {
            format$testNumberFormat$1 = (Format$testNumberFormat$1) continuation;
            if ((format$testNumberFormat$1.label & Integer.MIN_VALUE) != 0) {
                format$testNumberFormat$1.label -= Integer.MIN_VALUE;
                Object $result = format$testNumberFormat$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (format$testNumberFormat$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        int failureTimes2 = 1;
                        if (0 <= Long.MAX_VALUE) {
                            i = 1;
                            failureTimes = 0;
                            i2 = 0;
                            if (i2 % 100000 == 0) {
                                format$testNumberFormat$1.I$0 = i;
                                format$testNumberFormat$1.I$1 = failureTimes;
                                format$testNumberFormat$1.J$0 = i2;
                                format$testNumberFormat$1.label = 1;
                                if (YieldKt.yield(format$testNumberFormat$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            if (failureTimes >= 100) {
                                ToastToolsKt.showToast("失败次数过多, 停止测试，请查看日志,TAG: NumberFormatFailed");
                                return Unit.INSTANCE;
                            }
                            String result1 = NumberFormat.format(i2);
                            String result2 = NumberFormat_androidKt.format$default(Boxing.boxLong(i2), (String) null, 0, 3, (Object) null);
                            if (!Intrinsics.areEqual(result1, result2)) {
                                i = 0;
                                failureTimes++;
                                BLog.e("NumberFormatFailed", "value:" + i2 + " except = " + result1 + ", get = " + result2);
                            }
                            if (i2 != Long.MAX_VALUE) {
                                i2++;
                                if (i2 % 100000 == 0) {
                                }
                                if (failureTimes >= 100) {
                                }
                            } else {
                                failureTimes2 = i;
                            }
                        }
                        if (failureTimes2 != 0) {
                            ToastToolsKt.showToast("Format测试完成, 测试成功");
                        } else {
                            ToastToolsKt.showToast("Format测试完成, 测试失败, 请查看日志,TAG: NumberFormatFailed");
                        }
                        return Unit.INSTANCE;
                    case 1:
                        i2 = format$testNumberFormat$1.J$0;
                        failureTimes = format$testNumberFormat$1.I$1;
                        i = format$testNumberFormat$1.I$0;
                        ResultKt.throwOnFailure($result);
                        if (failureTimes >= 100) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        format$testNumberFormat$1 = new Format$testNumberFormat$1(this, continuation);
        Object $result2 = format$testNumberFormat$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (format$testNumberFormat$1.label) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0217, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ContentImpl(Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1969560989);
        ComposerKt.sourceInformation($composer2, "C(ContentImpl)124@4438L24,126@4472L930:CommonTestPage.kt#pxmn5u");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 4 : 2;
        }
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1969560989, $dirty, -1, "tv.danmaku.bili.core.test.测试大鸡儿的Format.ContentImpl (CommonTestPage.kt:123)");
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
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((6 >> 3) & 14) | ((6 >> 3) & BR.containerVisible));
            int $changed$iv$iv = (6 << 3) & BR.containerVisible;
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
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -2058323309, "C131@4601L60,132@4674L40,134@4761L366,133@4727L665:CommonTestPage.kt#pxmn5u");
            TextKt.Text--4IGK_g("大鸡儿NumberFormat测试(仅中文)", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer2, 196614, 0, 131038);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, -2006055481, "CC(remember):CommonTestPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(scope) | $composer2.changedInstance(this);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: tv.danmaku.bili.core.test.测试大鸡儿的Format$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit ContentImpl$lambda$0$0$0;
                    ContentImpl$lambda$0$0$0 = Format.ContentImpl$lambda$0$0$0(scope, this);
                    return ContentImpl$lambda$0$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ButtonKt.Button((Function0) it$iv, SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(56)), false, (MutableInteractionSource) null, (ButtonElevation) null, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)), (BorderStroke) null, (ButtonColors) null, (PaddingValues) null, ComposableSingletons$CommonTestPageKt.INSTANCE.getLambda$753842377$core_apinkDebug(), $composer2, 805306416, (int) BR.releaseDateShow);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.core.test.测试大鸡儿的Format$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit ContentImpl$lambda$1;
                    ContentImpl$lambda$1 = Format.ContentImpl$lambda$1(Format.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ContentImpl$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentImpl$lambda$0$0$0(CoroutineScope $scope, Format this$0) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new Format$ContentImpl$1$1$1$1(this$0, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}