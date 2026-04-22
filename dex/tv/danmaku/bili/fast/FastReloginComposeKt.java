package tv.danmaku.bili.fast;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.ClickableTextKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import bili.resource.account.R;
import com.bilibili.app.accountui.databinding.BiliAppDialogLoginEulaBinding;
import com.bilibili.compose.theme.BiliTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.normal.ui.LoginEulaDialogViewDelegate;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.AgreementLinkHelper;

/* compiled from: FastReloginCompose.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\u001a§\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\t2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\u0010\u001aE\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010\u0015\u001a+\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0018\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019²\u0006\f\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u008a\u008e\u0002"}, d2 = {"FastReLoginDialog", "", "pageState", "Ltv/danmaku/bili/fast/FastReLoginState;", "showClose", "", "onClose", "Lkotlin/Function0;", "onLoginClick", "Lkotlin/Function1;", "onAgreementChecked", "onAgreementConfirmClicked", "onAgreementDismissClicked", "onSwitchClick", "onAgreementClick", "", "(Ltv/danmaku/bili/fast/FastReLoginState;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "EulaPage", "modifier", "Landroidx/compose/ui/Modifier;", "dismiss", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "AgreementText", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "URL_TAG", "accountui_apinkDebug", "delegate", "Ltv/danmaku/bili/normal/ui/LoginEulaDialogViewDelegate;"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FastReloginComposeKt {
    private static final String URL_TAG = "URL";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AgreementText$lambda$2(Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        AgreementText(modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EulaPage$lambda$5(Modifier modifier, Function0 function0, Function0 function02, Function1 function1, int i, Composer composer, int i2) {
        EulaPage(modifier, function0, function02, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FastReLoginDialog$lambda$8(FastReLoginState fastReLoginState, boolean z, Function0 function0, Function1 function1, Function1 function12, Function0 function02, Function0 function03, Function1 function13, Function1 function14, int i, int i2, Composer composer, int i3) {
        FastReLoginDialog(fastReLoginState, z, function0, function1, function12, function02, function03, function13, function14, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FastReLoginDialog$lambda$1$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FastReLoginDialog$lambda$2$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FastReLoginDialog$lambda$5$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FastReLoginDialog$lambda$6$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -128
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    public static final void FastReLoginDialog(tv.danmaku.bili.fast.FastReLoginState r121, boolean r122, kotlin.jvm.functions.Function0<kotlin.Unit> r123, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r124, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r125, kotlin.jvm.functions.Function0<kotlin.Unit> r126, kotlin.jvm.functions.Function0<kotlin.Unit> r127, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r128, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r129, androidx.compose.runtime.Composer r130, int r131, int r132) {
        /*
            Method dump skipped, instructions count: 3330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.bili.fast.FastReloginComposeKt.FastReLoginDialog(tv.danmaku.bili.fast.FastReLoginState, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FastReLoginDialog$lambda$7$0$0(Function0 $onClose) {
        $onClose.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FastReLoginDialog$lambda$7$1$0$0(Function1 $onLoginClick, boolean $agreement) {
        $onLoginClick.invoke(Boolean.valueOf($agreement));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FastReLoginDialog$lambda$7$1$1(FastReLoginState $pageState, RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C:FastReloginCompose.kt#gr7clh");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1541971308, $changed, -1, "tv.danmaku.bili.fast.FastReLoginDialog.<anonymous>.<anonymous>.<anonymous> (FastReloginCompose.kt:137)");
            }
            if ($pageState.getLoginProcessing()) {
                $composer.startReplaceGroup(-2102905059);
                ComposerKt.sourceInformation($composer, "140@5408L6,138@5282L209");
                ProgressIndicatorKt.CircularProgressIndicator-LxG7B9w(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU(), Dp.constructor-impl(2), 0L, 0, $composer, (int) BR.nickTextColor, 24);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-2102655850);
                ComposerKt.sourceInformation($composer, "144@5549L75,144@5537L88");
                TextKt.Text--4IGK_g(StringResources_androidKt.stringResource(R.string.account_global_string_9, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 0, 0, 131070);
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FastReLoginDialog$lambda$7$1$2$0(Function1 $onSwitchClick, boolean $agreement) {
        $onSwitchClick.invoke(Boolean.valueOf($agreement));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FastReLoginDialog$lambda$7$1$3$0$0(Function1 $onAgreementChecked, boolean it) {
        $onAgreementChecked.invoke(Boolean.valueOf(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FastReLoginDialog$lambda$7$2$0$0(Function0 $onAgreementConfirmClicked) {
        $onAgreementConfirmClicked.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FastReLoginDialog$lambda$7$2$1$0(Function0 $onAgreementDismissClicked) {
        $onAgreementDismissClicked.invoke();
        return Unit.INSTANCE;
    }

    private static final void EulaPage(final Modifier modifier, final Function0<Unit> function0, final Function0<Unit> function02, final Function1<? super String, Unit> function1, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1850985885);
        ComposerKt.sourceInformation($composer2, "C(EulaPage)N(modifier,onLoginClick,dismiss,onAgreementClick)204@7484L75,209@7638L185,207@7564L265:FastReloginCompose.kt#gr7clh");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer2.changedInstance(function02) ? BR.hallEnterHotText : BR.cover;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        if (!$composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1850985885, $dirty, -1, "tv.danmaku.bili.fast.EulaPage (FastReloginCompose.kt:203)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 680980040, "CC(remember):FastReloginCompose.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState delegate$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier2 = SizeKt.width-3ABfNKs(modifier, Dp.constructor-impl((float) BR.headerTitle));
            ComposerKt.sourceInformationMarkerStart($composer2, 680985078, "CC(remember):FastReloginCompose.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: tv.danmaku.bili.fast.FastReloginComposeKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj) {
                        ConstraintLayout EulaPage$lambda$3$0;
                        EulaPage$lambda$3$0 = FastReloginComposeKt.EulaPage$lambda$3$0(delegate$delegate, (Context) obj);
                        return EulaPage$lambda$3$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AndroidView_androidKt.AndroidView((Function1) it$iv2, modifier2, (Function1) null, $composer2, 6, 4);
            if (EulaPage$lambda$1(delegate$delegate) != null) {
                $composer2.startReplaceGroup(-364064018);
                ComposerKt.sourceInformation($composer2, "217@7892L718,217@7867L743");
                LoginEulaDialogViewDelegate EulaPage$lambda$1 = EulaPage$lambda$1(delegate$delegate);
                ComposerKt.sourceInformationMarkerStart($composer2, 680993739, "CC(remember):FastReloginCompose.kt#9igjgp");
                boolean invalid$iv = (($dirty & BR.containerVisible) == 32) | (($dirty & 7168) == 2048) | (($dirty & 896) == 256);
                Object value$iv3 = $composer2.rememberedValue();
                if (invalid$iv || value$iv3 == Composer.Companion.getEmpty()) {
                    value$iv3 = new FastReloginComposeKt$EulaPage$2$1(function0, function02, delegate$delegate, function1, null);
                    $composer2.updateRememberedValue(value$iv3);
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(EulaPage$lambda$1, (Function2) value$iv3, $composer2, 0);
            } else {
                $composer2.startReplaceGroup(-371882683);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fast.FastReloginComposeKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit EulaPage$lambda$5;
                    EulaPage$lambda$5 = FastReloginComposeKt.EulaPage$lambda$5(modifier, function0, function02, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return EulaPage$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LoginEulaDialogViewDelegate EulaPage$lambda$1(MutableState<LoginEulaDialogViewDelegate> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (LoginEulaDialogViewDelegate) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstraintLayout EulaPage$lambda$3$0(MutableState $delegate$delegate, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BiliAppDialogLoginEulaBinding binding = BiliAppDialogLoginEulaBinding.inflate(LayoutInflater.from(it));
        Intrinsics.checkNotNullExpressionValue(binding, "inflate(...)");
        $delegate$delegate.setValue(new LoginEulaDialogViewDelegate(binding));
        return binding.getRoot();
    }

    private static final void AgreementText(Modifier modifier, final Function1<? super String, Unit> function1, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2 = $composer.startRestartGroup(-1726598372);
        ComposerKt.sourceInformation($composer2, "C(AgreementText)N(modifier,onAgreementClick)265@9786L9,267@9848L170,263@9719L306:FastReloginCompose.kt#gr7clh");
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
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1726598372, $dirty2, -1, "tv.danmaku.bili.fast.AgreementText (FastReloginCompose.kt:240)");
            }
            $composer2.startReplaceGroup(-1403654845);
            ComposerKt.sourceInformation($composer2, "*242@8808L6,243@8838L76,248@9079L6,249@9113L77,252@9232L77,256@9474L6,257@9508L77,260@9629L64");
            AnnotatedString.Builder $this$AgreementText_u24lambda_u240 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            $this$AgreementText_u24lambda_u240.pushStyle(new SpanStyle(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null));
            $this$AgreementText_u24lambda_u240.append(StringResources_androidKt.stringResource(R.string.account_global_string_63, $composer2, 0));
            int privacyTag = $this$AgreementText_u24lambda_u240.pushStringAnnotation("URL", AgreementLinkHelper.DEFAULT_PRIVACY_POLICY_URL);
            $this$AgreementText_u24lambda_u240.pushStyle(new SpanStyle(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_link-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null));
            $this$AgreementText_u24lambda_u240.append(StringResources_androidKt.stringResource(R.string.account_global_string_109, $composer2, 0));
            $this$AgreementText_u24lambda_u240.pop(privacyTag);
            $this$AgreementText_u24lambda_u240.append(StringResources_androidKt.stringResource(R.string.account_global_string_159, $composer2, 0));
            int agreementTag = $this$AgreementText_u24lambda_u240.pushStringAnnotation("URL", AgreementLinkHelper.DEFAULT_USER_PROTOCOL_URL);
            $this$AgreementText_u24lambda_u240.pushStyle(new SpanStyle(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_link-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null));
            $this$AgreementText_u24lambda_u240.append(StringResources_androidKt.stringResource(R.string.account_global_string_174, $composer2, 0));
            $this$AgreementText_u24lambda_u240.pop(agreementTag);
            $this$AgreementText_u24lambda_u240.append(StringResources_androidKt.stringResource(com.bilibili.app.accountui.R.string.account_fast_login_agreement_part5, $composer2, 0));
            $this$AgreementText_u24lambda_u240.pop();
            final AnnotatedString annotated = $this$AgreementText_u24lambda_u240.toAnnotatedString();
            $composer2.endReplaceGroup();
            TextStyle t12 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12();
            ComposerKt.sourceInformationMarkerStart($composer2, -1403620410, "CC(remember):FastReloginCompose.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(annotated) | (($dirty2 & BR.containerVisible) == 32);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: tv.danmaku.bili.fast.FastReloginComposeKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj) {
                        Unit AgreementText$lambda$1$0;
                        AgreementText$lambda$1$0 = FastReloginComposeKt.AgreementText$lambda$1$0(annotated, function1, ((Integer) obj).intValue());
                        return AgreementText$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ClickableTextKt.ClickableText-4YKlhWE(annotated, modifier3, t12, false, 0, 0, (Function1) null, (Function1) it$iv, $composer2, ($dirty2 << 3) & BR.containerVisible, 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fast.FastReloginComposeKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit AgreementText$lambda$2;
                    AgreementText$lambda$2 = FastReloginComposeKt.AgreementText$lambda$2(modifier2, function1, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AgreementText$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AgreementText$lambda$1$0(AnnotatedString $annotated, Function1 $onAgreementClick, int it) {
        AnnotatedString.Range annotation = (AnnotatedString.Range) CollectionsKt.firstOrNull($annotated.getStringAnnotations("URL", it, it));
        if (annotation != null) {
            $onAgreementClick.invoke(annotation.getItem());
        }
        return Unit.INSTANCE;
    }
}