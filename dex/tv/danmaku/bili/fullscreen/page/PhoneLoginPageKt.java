package tv.danmaku.bili.fullscreen.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.TextKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import bili.resource.account.R;
import com.bilibili.compose.theme.BiliTheme;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import shark.AndroidResourceIdNames;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.eula.EulaLinkType;
import tv.danmaku.bili.fullscreen.service.IspCode;
import tv.danmaku.bili.fullscreen.state.IFullscreenAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginReportAction;
import tv.danmaku.bili.fullscreen.state.IPhoneOnePassState;
import tv.danmaku.bili.fullscreen.state.PhoneOnePassLoginLoadingState;
import tv.danmaku.bili.fullscreen.state.PhoneOnePassLoginState;
import tv.danmaku.bili.normal.ui.EulaTriggerType;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: PhoneLoginPage.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0095\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2#\b\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0011\u001a\u008c\u0001\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2#\b\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00010\u00052\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0017\u001a?\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"PhoneLoginPage", "", LoginReporterV2.PAGE_FROM_KEY, "Ltv/danmaku/bili/fullscreen/state/IPhoneOnePassState;", "onAction", "Lkotlin/Function1;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "onLoginClick", "", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "checked", "onSwitchClick", "Lkotlin/Function0;", "onAgreementCheckChanged", "routeTo", "", "(Ltv/danmaku/bili/fullscreen/state/IPhoneOnePassState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ActionPanel", "pageState", "Ltv/danmaku/bili/fullscreen/state/PhoneOnePassLoginState;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ltv/danmaku/bili/fullscreen/state/PhoneOnePassLoginState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "PhoneGroup", "phone", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PhoneLoginPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActionPanel$lambda$5(PhoneOnePassLoginState phoneOnePassLoginState, Modifier modifier, Function0 function0, Function0 function02, Function1 function1, Function1 function12, Function1 function13, int i, int i2, Composer composer, int i3) {
        ActionPanel(phoneOnePassLoginState, modifier, function0, function02, function1, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PhoneGroup$lambda$3(String str, Modifier modifier, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        PhoneGroup(str, modifier, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PhoneLoginPage$lambda$3(IPhoneOnePassState iPhoneOnePassState, Function1 function1, Function1 function12, Function0 function0, Function1 function13, Function1 function14, int i, int i2, Composer composer, int i3) {
        PhoneLoginPage(iPhoneOnePassState, function1, function12, function0, function13, function14, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PhoneLoginPage$lambda$1$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:99:0x02a6, code lost:
        if (r0 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L74;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PhoneLoginPage(final IPhoneOnePassState page, final Function1<? super IFullscreenAction, Unit> function1, final Function1<? super Boolean, Unit> function12, Function0<Unit> function0, Function1<? super Boolean, Unit> function13, final Function1<? super String, Unit> function14, Composer $composer, final int $changed, final int i) {
        Function0 onSwitchClick;
        Function1 function15;
        Function1 onAgreementCheckChanged;
        Function0 onSwitchClick2;
        Function1 onAgreementCheckChanged2;
        final PhoneOnePassLoginState pageState;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(page, LoginReporterV2.PAGE_FROM_KEY);
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Intrinsics.checkNotNullParameter(function12, "onLoginClick");
        Intrinsics.checkNotNullParameter(function14, "routeTo");
        Composer $composer2 = $composer.startRestartGroup(1648922842);
        ComposerKt.sourceInformation($composer2, "C(PhoneLoginPage)N(page,onAction,onLoginClick,onSwitchClick,onAgreementCheckChanged,routeTo)34@1315L2,35@1377L2,42@1557L503:PhoneLoginPage.kt#gqoihp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(page) : $composer2.changedInstance(page) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer2.changedInstance(function12) ? BR.hallEnterHotText : BR.cover;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            onSwitchClick = function0;
        } else if (($changed & 3072) == 0) {
            onSwitchClick = function0;
            $dirty |= $composer2.changedInstance(onSwitchClick) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        } else {
            onSwitchClick = function0;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            function15 = function13;
        } else if (($changed & 24576) == 0) {
            function15 = function13;
            $dirty |= $composer2.changedInstance(function15) ? RingBuffer.CONSUME_SIZE : 8192;
        } else {
            function15 = function13;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function14) ? 131072 : AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR;
        }
        if ($composer2.shouldExecute((74899 & $dirty) != 74898, $dirty & 1)) {
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -228075588, "CC(remember):PhoneLoginPage.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.PhoneLoginPageKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onSwitchClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onSwitchClick2 = onSwitchClick;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -228073604, "CC(remember):PhoneLoginPage.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.PhoneLoginPageKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj) {
                            Unit PhoneLoginPage$lambda$1$0;
                            PhoneLoginPage$lambda$1$0 = PhoneLoginPageKt.PhoneLoginPage$lambda$1$0(((Boolean) obj).booleanValue());
                            return PhoneLoginPage$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                onAgreementCheckChanged2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onAgreementCheckChanged2 = function15;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1648922842, $dirty, -1, "tv.danmaku.bili.fullscreen.page.PhoneLoginPage (PhoneLoginPage.kt:37)");
            }
            if (page instanceof PhoneOnePassLoginLoadingState) {
                pageState = ((PhoneOnePassLoginLoadingState) page).getOrigin();
            } else if (!(page instanceof PhoneOnePassLoginState)) {
                throw new NoWhenBranchMatchedException();
            } else {
                pageState = (PhoneOnePassLoginState) page;
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((BR.nickTextColor >> 3) & 14) | ((BR.nickTextColor >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.nickTextColor << 3) & BR.containerVisible;
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
            onAgreementCheckChanged = onAgreementCheckChanged2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i5 = ((BR.nickTextColor >> 6) & BR.containerVisible) | 6;
            ColumnScope $this$PhoneLoginPage_u24lambda_u242 = columnScope;
            ComposerKt.sourceInformationMarkerStart($composer2, 990196874, "C43@1661L41,47@1830L44,44@1711L343:PhoneLoginPage.kt#gqoihp");
            CommonKt.LogoGroup(ColumnScope.-CC.weight$default($this$PhoneLoginPage_u24lambda_u242, Modifier.Companion, 4.0f, false, 2, (Object) null), $composer2, 0);
            Modifier weight$default = ColumnScope.-CC.weight$default($this$PhoneLoginPage_u24lambda_u242, Modifier.Companion, 6.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -1630621092, "CC(remember):PhoneLoginPage.kt#9igjgp");
            boolean invalid$iv = (($dirty & 896) == 256) | $composer2.changedInstance(pageState);
            Object value$iv3 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            value$iv3 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.PhoneLoginPageKt$$ExternalSyntheticLambda6
                public final Object invoke() {
                    Unit PhoneLoginPage$lambda$2$0$0;
                    PhoneLoginPage$lambda$2$0$0 = PhoneLoginPageKt.PhoneLoginPage$lambda$2$0$0(function12, pageState);
                    return PhoneLoginPage$lambda$2$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ActionPanel(pageState, weight$default, (Function0) value$iv3, onSwitchClick2, onAgreementCheckChanged, function14, function1, $composer2, ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (($dirty << 15) & 3670016), 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onSwitchClick = onSwitchClick2;
        } else {
            $composer2.skipToGroupEnd();
            onAgreementCheckChanged = function15;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function0 function02 = onSwitchClick;
            final Function1 function16 = onAgreementCheckChanged;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.PhoneLoginPageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit PhoneLoginPage$lambda$3;
                    PhoneLoginPage$lambda$3 = PhoneLoginPageKt.PhoneLoginPage$lambda$3(IPhoneOnePassState.this, function1, function12, function02, function16, function14, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PhoneLoginPage$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PhoneLoginPage$lambda$2$0$0(Function1 $onLoginClick, PhoneOnePassLoginState $pageState) {
        $onLoginClick.invoke(Boolean.valueOf($pageState.getAgreementChecked()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActionPanel$lambda$2$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActionPanel$lambda$3$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:126:0x0470, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L86;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ActionPanel(final PhoneOnePassLoginState pageState, final Modifier modifier, Function0<Unit> function0, Function0<Unit> function02, Function1<? super Boolean, Unit> function1, Function1<? super String, Unit> function12, final Function1<? super IFullscreenAction, Unit> function13, Composer $composer, final int $changed, final int i) {
        Function0 onSwitchClick;
        Function1 onAgreementCheckChanged;
        Function1 routeTo;
        Composer $composer2;
        Function0 onLoginClick;
        Function0 onSwitchClick2;
        Function1 onAgreementCheckChanged2;
        Function1 routeTo2;
        Function0 onLoginClick2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(function13, "onAction");
        Composer $composer3 = $composer.startRestartGroup(-164376620);
        ComposerKt.sourceInformation($composer3, "C(ActionPanel)N(pageState,modifier,onLoginClick,onSwitchClick,onAgreementCheckChanged,routeTo,onAction)60@2187L2,61@2223L2,62@2285L2,63@2321L2,66@2376L919:PhoneLoginPage.kt#gqoihp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer3.changed(pageState) : $composer3.changedInstance(pageState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(modifier) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= BR.negativeBtnVisible;
        } else if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? BR.hallEnterHotText : BR.cover;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            onSwitchClick = function02;
        } else if (($changed & 3072) == 0) {
            onSwitchClick = function02;
            $dirty |= $composer3.changedInstance(onSwitchClick) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        } else {
            onSwitchClick = function02;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            onAgreementCheckChanged = function1;
        } else if (($changed & 24576) == 0) {
            onAgreementCheckChanged = function1;
            $dirty |= $composer3.changedInstance(onAgreementCheckChanged) ? RingBuffer.CONSUME_SIZE : 8192;
        } else {
            onAgreementCheckChanged = function1;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= 196608;
            routeTo = function12;
        } else if ((196608 & $changed) == 0) {
            routeTo = function12;
            $dirty |= $composer3.changedInstance(routeTo) ? 131072 : AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR;
        } else {
            routeTo = function12;
        }
        if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function13) ? 1048576 : 524288;
        }
        if (!$composer3.shouldExecute(($dirty & 599187) != 599186, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            onLoginClick = function0;
            onSwitchClick2 = onSwitchClick;
            onAgreementCheckChanged2 = onAgreementCheckChanged;
            routeTo2 = routeTo;
        } else {
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 947861686, "CC(remember):PhoneLoginPage.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.PhoneLoginPageKt$$ExternalSyntheticLambda11
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onLoginClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onLoginClick2 = function0;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 947862838, "CC(remember):PhoneLoginPage.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.PhoneLoginPageKt$$ExternalSyntheticLambda12
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 onSwitchClick3 = (Function0) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onSwitchClick = onSwitchClick3;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 947864822, "CC(remember):PhoneLoginPage.kt#9igjgp");
                Object it$iv3 = $composer3.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.PhoneLoginPageKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit ActionPanel$lambda$2$0;
                            ActionPanel$lambda$2$0 = PhoneLoginPageKt.ActionPanel$lambda$2$0(((Boolean) obj).booleanValue());
                            return ActionPanel$lambda$2$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                Function1 onAgreementCheckChanged3 = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onAgreementCheckChanged = onAgreementCheckChanged3;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 947865974, "CC(remember):PhoneLoginPage.kt#9igjgp");
                Object it$iv4 = $composer3.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.PhoneLoginPageKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit ActionPanel$lambda$3$0;
                            ActionPanel$lambda$3$0 = PhoneLoginPageKt.ActionPanel$lambda$3$0((String) obj);
                            return ActionPanel$lambda$3$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                Function1 routeTo3 = it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                routeTo = routeTo3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-164376620, $dirty, -1, "tv.danmaku.bili.fullscreen.page.ActionPanel (PhoneLoginPage.kt:65)");
            }
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            int $changed$iv = (($dirty >> 3) & 14) | 48;
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            $composer2 = $composer3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            routeTo2 = routeTo;
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
            onAgreementCheckChanged2 = onAgreementCheckChanged;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i7 = (($changed$iv >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1274752896, "C67@2448L841:PhoneLoginPage.kt#gqoihp");
            Modifier modifier$iv = SizeKt.widthIn-VpY3zN4$default(PaddingKt.padding-VpY3zN4$default(modifier, Dp.constructor-impl(24), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl((float) BR.headerTitle), 1, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((BR.negativeBtnVisible >> 3) & 14) | ((BR.negativeBtnVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv2 = (BR.negativeBtnVisible << 3) & BR.containerVisible;
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
            int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i9 = ((BR.negativeBtnVisible >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1144461190, "C71@2626L169,76@2808L41,82@3110L154,77@2862L417:PhoneLoginPage.kt#gqoihp");
            PhoneGroup(pageState.getPhone().getSecurePhone(), null, onLoginClick2, onSwitchClick, $composer3, ($dirty & 896) | ($dirty & 7168), 2);
            onLoginClick = onLoginClick2;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), $composer3, 6);
            boolean agreementChecked = pageState.getAgreementChecked();
            IspCode ispCode = pageState.getPhone().getIspCode();
            ComposerKt.sourceInformationMarkerStart($composer3, -1902729558, "CC(remember):PhoneLoginPage.kt#9igjgp");
            boolean invalid$iv = (3670016 & $dirty) == 1048576;
            Object it$iv5 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv5 = new Function3() { // from class: tv.danmaku.bili.fullscreen.page.PhoneLoginPageKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ActionPanel$lambda$4$0$0$0;
                    ActionPanel$lambda$4$0$0$0 = PhoneLoginPageKt.ActionPanel$lambda$4$0$0$0(function13, (EulaLinkType) obj, ((Boolean) obj2).booleanValue(), (EulaTriggerType) obj3);
                    return ActionPanel$lambda$4$0$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv5);
            it$iv5 = value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CommonKt.LoginAgreement(null, agreementChecked, ispCode, onAgreementCheckChanged2, routeTo2, (Function3) it$iv5, null, $composer3, (($dirty >> 3) & 7168) | (57344 & ($dirty >> 3)), 65);
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
            onSwitchClick2 = onSwitchClick;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function0 function03 = onLoginClick;
            final Function0 function04 = onSwitchClick2;
            final Function1 function14 = onAgreementCheckChanged2;
            final Function1 function15 = routeTo2;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.PhoneLoginPageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit ActionPanel$lambda$5;
                    ActionPanel$lambda$5 = PhoneLoginPageKt.ActionPanel$lambda$5(PhoneOnePassLoginState.this, modifier, function03, function04, function14, function15, function13, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ActionPanel$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActionPanel$lambda$4$0$0$0(Function1 $onAction, EulaLinkType type, boolean inDialog, EulaTriggerType triggerType) {
        Intrinsics.checkNotNullParameter(type, "type");
        $onAction.invoke(new IFullscreenLoginReportAction.EulaLinkClicked(type, inDialog, triggerType));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r9v10 */
    public static final void PhoneGroup(final String phone, Modifier modifier, Function0<Unit> function0, Function0<Unit> function02, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function03;
        Function0 function04;
        Composer $composer2;
        Modifier modifier3;
        Function0 onLoginClick;
        Function0 onSwitchClick;
        Intrinsics.checkNotNullParameter(phone, "phone");
        Composer $composer3 = $composer.startRestartGroup(-1518445172);
        ComposerKt.sourceInformation($composer3, "C(PhoneGroup)N(phone,modifier,onLoginClick,onSwitchClick)94@3412L2,95@3448L2,97@3460L648:PhoneLoginPage.kt#gqoihp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(phone) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= BR.negativeBtnVisible;
            function03 = function0;
        } else if (($changed & BR.negativeBtnVisible) == 0) {
            function03 = function0;
            $dirty |= $composer3.changedInstance(function03) ? BR.hallEnterHotText : BR.cover;
        } else {
            function03 = function0;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            function04 = function02;
        } else if (($changed & 3072) == 0) {
            function04 = function02;
            $dirty |= $composer3.changedInstance(function04) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        } else {
            function04 = function02;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1063073582, "CC(remember):PhoneLoginPage.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.PhoneLoginPageKt$$ExternalSyntheticLambda8
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onLoginClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onLoginClick = onLoginClick2;
            } else {
                onLoginClick = function03;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1063074734, "CC(remember):PhoneLoginPage.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.PhoneLoginPageKt$$ExternalSyntheticLambda9
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 onSwitchClick2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onSwitchClick = onSwitchClick2;
            } else {
                onSwitchClick = function04;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1518445172, $dirty2, -1, "tv.danmaku.bili.fullscreen.page.PhoneGroup (PhoneLoginPage.kt:96)");
            }
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(24));
            int $changed$iv = (($dirty2 >> 3) & 14) | BR.pendentVisible;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & BR.containerVisible));
            int $changed$iv$iv = ($changed$iv << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = (($changed$iv >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1238491927, "C104@3694L6,105@3738L9,102@3632L131,109@3806L71,108@3773L155,115@3972L77,114@3939L163:PhoneLoginPage.kt#gqoihp");
            $composer2 = $composer3;
            TextKt.Text--4IGK_g(phone, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT22b(), $composer3, $dirty2 & 14, 0, 65530);
            CommonKt.LoginButton(StringResources_androidKt.stringResource(R.string.account_global_string_28, $composer3, 0), false, null, onLoginClick, $composer3, ($dirty2 << 3) & 7168, 6);
            CommonKt.SwitchLogin(StringResources_androidKt.stringResource(R.string.account_global_string_160, $composer3, 0), null, onSwitchClick, $composer3, ($dirty2 >> 3) & 896, 2);
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
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onLoginClick = function03;
            onSwitchClick = function04;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function0 function05 = onLoginClick;
            final Function0 function06 = onSwitchClick;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.PhoneLoginPageKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit PhoneGroup$lambda$3;
                    PhoneGroup$lambda$3 = PhoneLoginPageKt.PhoneGroup$lambda$3(phone, modifier4, function05, function06, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PhoneGroup$lambda$3;
                }
            });
        }
    }
}