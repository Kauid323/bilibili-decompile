package tv.danmaku.bili.stepbystep;

import ComposableSingletons$CustomBottomSheetKt$;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.material.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import com.bilibili.app.comm.list.common.R;
import com.bilibili.bus.Violet;
import com.bilibili.compose.layout.ParentRelativeOffsetModifierKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.compose.utils.ModifierUtilsKt;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.text.LimitTextSizeUtil;
import com.bilibili.iconfont.KtxKt;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accountsui.captcha.CaptchaDialogV2;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.pvtracker.IPvTracker;
import com.google.accompanist.drawablepainter.DrawablePainterKt;
import com.google.accompanist.systemuicontroller.SystemUiController;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.normal.ui.RouteUtilKt;
import tv.danmaku.bili.stepbystep.IStepByStepLoginAction;
import tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState;
import tv.danmaku.bili.stepbystep.sms.StepByStepComposePaddingMap;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginPageStateKt;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginPageTransitionState;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginPhonePage;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginVerifyPage;

/* compiled from: StepByStepBottomSheetLoginActivity.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u001a\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\u0012\u0010 \u001a\u00020\u000e*\u00020!H\u0082@¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u0013H\u0016J\b\u0010$\u001a\u00020\u0010H\u0016J\b\u0010%\u001a\u00020\u000eH\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006&²\u0006\n\u0010'\u001a\u00020(X\u008a\u0084\u0002"}, d2 = {"Ltv/danmaku/bili/stepbystep/StepByStepBottomSheetLoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/bilibili/pvtracker/IPvTracker;", "<init>", "()V", "viewModel", "Ltv/danmaku/bili/stepbystep/StepByStepLoginViewModel;", "getViewModel", "()Ltv/danmaku/bili/stepbystep/StepByStepLoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getResources", "Landroid/content/res/Resources;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "routeTo", "url", "", "args", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "dispatch", "action", "Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction;", "routeToPassword", "registerLoginListener", "registerToast", "registerRedirect", "registerLoggedInState", "registerEulaDialog", "registerCaptchaDialog", "showCaptchaDialog", "Lcom/bilibili/lib/accountsui/captcha/CaptchaDialogV2;", "(Lcom/bilibili/lib/accountsui/captcha/CaptchaDialogV2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPvEventId", "getPvExtra", "onResume", "accountui_apinkDebug", "offsetAnimate", ""}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@AndroidEntryPoint
public final class StepByStepBottomSheetLoginActivity extends Hilt_StepByStepBottomSheetLoginActivity implements IPvTracker {
    public static final int $stable = 8;
    private final Lazy viewModel$delegate;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    public StepByStepBottomSheetLoginActivity() {
        final ComponentActivity $this$viewModels_u24default$iv = (ComponentActivity) this;
        final Function0 extrasProducer$iv = new Function0() { // from class: tv.danmaku.bili.stepbystep.StepByStepBottomSheetLoginActivity$$ExternalSyntheticLambda3
            public final Object invoke() {
                CreationExtras viewModel_delegate$lambda$0;
                viewModel_delegate$lambda$0 = StepByStepBottomSheetLoginActivity.viewModel_delegate$lambda$0(StepByStepBottomSheetLoginActivity.this);
                return viewModel_delegate$lambda$0;
            }
        };
        Function0 factoryPromise$iv = new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.stepbystep.StepByStepBottomSheetLoginActivity$special$$inlined$viewModels$default$1
            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1489invoke() {
                return $this$viewModels_u24default$iv.getDefaultViewModelProviderFactory();
            }
        };
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(StepByStepLoginViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.stepbystep.StepByStepBottomSheetLoginActivity$special$$inlined$viewModels$default$2
            /* renamed from: invoke */
            public final ViewModelStore m1490invoke() {
                return $this$viewModels_u24default$iv.getViewModelStore();
            }
        }, factoryPromise$iv, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.stepbystep.StepByStepBottomSheetLoginActivity$special$$inlined$viewModels$default$3
            /* renamed from: invoke */
            public final CreationExtras m1491invoke() {
                CreationExtras creationExtras;
                Function0 function0 = extrasProducer$iv;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$viewModels_u24default$iv.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        getDelegate().setLocalNightMode(MultipleThemeUtils.getCurrentNightMode((Context) this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StepByStepLoginViewModel getViewModel() {
        return (StepByStepLoginViewModel) this.viewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
        if (r4 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final CreationExtras viewModel_delegate$lambda$0(StepByStepBottomSheetLoginActivity this$0) {
        CreationExtras mutableCreationExtras = new MutableCreationExtras(this$0.getDefaultViewModelCreationExtras());
        CreationExtras.Key key = SavedStateHandleSupport.DEFAULT_ARGS_KEY;
        Bundle $this$viewModel_delegate_u24lambda_u240_u240_u240 = this$0.getIntent().getExtras();
        if ($this$viewModel_delegate_u24lambda_u240_u240_u240 != null) {
            $this$viewModel_delegate_u24lambda_u240_u240_u240.putString(StepByStepBottomSheetLoginActivityKt.REPORT_LOGIN_TYPE, StepByStepSmsLoginPageStateKt.SmsLoginType);
            String string = $this$viewModel_delegate_u24lambda_u240_u240_u240.getString("from_spmid");
            if (string == null || StringsKt.isBlank(string)) {
                Bundle bundle = $this$viewModel_delegate_u24lambda_u240_u240_u240.getBundle(BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE);
                $this$viewModel_delegate_u24lambda_u240_u240_u240.putString("from_spmid", bundle != null ? bundle.getString("from_spmid") : null);
            }
            Unit unit = Unit.INSTANCE;
        }
        $this$viewModel_delegate_u24lambda_u240_u240_u240 = Bundle.EMPTY;
        mutableCreationExtras.set(key, $this$viewModel_delegate_u24lambda_u240_u240_u240);
        return mutableCreationExtras;
    }

    public Resources getResources() {
        LimitTextSizeUtil limitTextSizeUtil = LimitTextSizeUtil.INSTANCE;
        Resources resources = super.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return limitTextSizeUtil.limitTextSize(resources);
    }

    @Override // tv.danmaku.bili.stepbystep.Hilt_StepByStepBottomSheetLoginActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (BiliAccounts.get(FoundationAlias.getFapp().getBaseContext()).isLogin()) {
            finish();
            return;
        }
        ComponentActivityKt.setContent$default((ComponentActivity) this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(-1057102952, true, new Function2() { // from class: tv.danmaku.bili.stepbystep.StepByStepBottomSheetLoginActivity$$ExternalSyntheticLambda9
            public final Object invoke(Object obj, Object obj2) {
                Unit onCreate$lambda$0;
                onCreate$lambda$0 = StepByStepBottomSheetLoginActivity.onCreate$lambda$0(StepByStepBottomSheetLoginActivity.this, (Composer) obj, ((Integer) obj2).intValue());
                return onCreate$lambda$0;
            }
        }), 1, (Object) null);
        registerLoginListener();
        registerEulaDialog();
        registerCaptchaDialog();
        registerToast();
        registerLoggedInState();
        registerRedirect();
        Violet.INSTANCE.ofChannel(PhoneCountryCode.class).observe((LifecycleOwner) this, new Observer() { // from class: tv.danmaku.bili.stepbystep.StepByStepBottomSheetLoginActivity$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                StepByStepBottomSheetLoginActivity.onCreate$lambda$1(StepByStepBottomSheetLoginActivity.this, (PhoneCountryCode) obj);
            }
        });
        getOnBackPressedDispatcher().addCallback((LifecycleOwner) this, new OnBackPressedCallback() { // from class: tv.danmaku.bili.stepbystep.StepByStepBottomSheetLoginActivity$onCreate$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            public void handleOnBackPressed() {
                if (!(StepByStepBottomSheetLoginActivity.this.getViewModel().getStateSmsFlow().getValue() instanceof StepByStepSmsLoginPhonePage)) {
                    StepByStepBottomSheetLoginActivity.this.getViewModel().dispatchAction(StepByStepSmsLoginAction.PageTransitionAction.INSTANCE);
                } else {
                    StepByStepBottomSheetLoginActivity.this.finish();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(final StepByStepBottomSheetLoginActivity this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C115@5177L4956,115@5167L4966:StepByStepBottomSheetLoginActivity.kt#c84q0i");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1057102952, $changed, -1, "tv.danmaku.bili.stepbystep.StepByStepBottomSheetLoginActivity.onCreate.<anonymous> (StepByStepBottomSheetLoginActivity.kt:115)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-648685744, true, new Function2() { // from class: tv.danmaku.bili.stepbystep.StepByStepBottomSheetLoginActivity$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreate$lambda$0$0;
                    onCreate$lambda$0$0 = StepByStepBottomSheetLoginActivity.onCreate$lambda$0$0(StepByStepBottomSheetLoginActivity.this, (Composer) obj, ((Integer) obj2).intValue());
                    return onCreate$lambda$0$0;
                }
            }, $composer, 54), $composer, (int) BR.negativeBtnVisible, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x011b, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0212, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0544, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0616, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0668, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x069e, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L64;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit onCreate$lambda$0$0(final StepByStepBottomSheetLoginActivity this$0, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        ComposerKt.sourceInformation($composer, "C116@5216L34,117@5294L6,118@5370L84,118@5347L107,122@5514L16,123@5614L7,124@5664L34,125@5738L130,132@6161L264,128@5910L537,142@6648L30,143@6731L275,138@6468L3647:StepByStepBottomSheetLoginActivity.kt#c84q0i");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-648685744, $changed, -1, "tv.danmaku.bili.stepbystep.StepByStepBottomSheetLoginActivity.onCreate.<anonymous>.<anonymous> (StepByStepBottomSheetLoginActivity.kt:116)");
            }
            SystemUiController controller = SystemUiControllerKt.rememberSystemUiController(this$0.getWindow(), $composer, 0, 0);
            long shadow = Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getShadow-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            Color color = Color.box-impl(shadow);
            ComposerKt.sourceInformationMarkerStart($composer, -616735804, "CC(remember):StepByStepBottomSheetLoginActivity.kt#9igjgp");
            boolean invalid$iv = $composer.changed(controller) | $composer.changed(shadow);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new StepByStepBottomSheetLoginActivity$onCreate$1$1$1$1(controller, shadow, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(color, (Function2) it$iv, $composer, 0);
            final IStepByStepSmsLoginPageState stateSms = (IStepByStepSmsLoginPageState) SnapshotStateKt.collectAsState(this$0.getViewModel().getStateSmsFlow(), (CoroutineContext) null, $composer, 0, 1).getValue();
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            final SoftwareKeyboardController keyboardController = (SoftwareKeyboardController) consume;
            ComposerKt.sourceInformationMarkerStart($composer, -616726446, "CC(remember):StepByStepBottomSheetLoginActivity.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableState keyboardVisible = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            float pageOffsetTarget = stateSms.getPageOffsetTarget();
            ComposerKt.sourceInformationMarkerStart($composer, -616723982, "CC(remember):StepByStepBottomSheetLoginActivity.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed(pageOffsetTarget);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(stateSms.getPageOffsetTarget());
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            MutableFloatState targetOffset = (MutableFloatState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            float floatValue = targetOffset.getFloatValue();
            AnimationSpec tween$default = AnimationSpecKt.tween$default((int) BR.guideBarHeight, 0, (Easing) null, 6, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -616710312, "CC(remember):StepByStepBottomSheetLoginActivity.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance(stateSms) | $composer.changedInstance(this$0);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv3 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function1() { // from class: tv.danmaku.bili.stepbystep.StepByStepBottomSheetLoginActivity$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit onCreate$lambda$0$0$3$0;
                        onCreate$lambda$0$0$3$0 = StepByStepBottomSheetLoginActivity.onCreate$lambda$0$0$3$0(IStepByStepSmsLoginPageState.this, this$0, ((Float) obj).floatValue());
                        return onCreate$lambda$0$0$3$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            State offsetAnimate$delegate = AnimateAsStateKt.animateFloatAsState(floatValue, tween$default, 0.0f, "dialog show or hide", (Function1) it$iv4, $composer, 3120, 4);
            Modifier modifier = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), shadow, (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -616694962, "CC(remember):StepByStepBottomSheetLoginActivity.kt#9igjgp");
            Object it$iv5 = $composer.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = new Function1() { // from class: tv.danmaku.bili.stepbystep.StepByStepBottomSheetLoginActivity$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit onCreate$lambda$0$0$5$0;
                        onCreate$lambda$0$0$5$0 = StepByStepBottomSheetLoginActivity.onCreate$lambda$0$0$5$0(keyboardVisible, ((Boolean) obj).booleanValue());
                        return onCreate$lambda$0$0$5$0;
                    }
                };
                $composer.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier observeIme = StepByStepSmsLoginComposeKt.observeIme(modifier, (Function1) it$iv5);
            ComposerKt.sourceInformationMarkerStart($composer, -616692061, "CC(remember):StepByStepBottomSheetLoginActivity.kt#9igjgp");
            boolean invalid$iv4 = $composer.changed(keyboardController) | $composer.changedInstance(this$0);
            Object it$iv6 = $composer.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv6 = new Function0() { // from class: tv.danmaku.bili.stepbystep.StepByStepBottomSheetLoginActivity$$ExternalSyntheticLambda6
                public final Object invoke() {
                    Unit onCreate$lambda$0$0$6$0;
                    onCreate$lambda$0$0$6$0 = StepByStepBottomSheetLoginActivity.onCreate$lambda$0$0$6$0(keyboardVisible, keyboardController, this$0);
                    return onCreate$lambda$0$0$6$0;
                }
            };
            $composer.updateRememberedValue(value$iv6);
            it$iv6 = value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = ParentRelativeOffsetModifierKt.percentageOffset$default(ModifierUtilsKt.clickableNoInteraction$default(observeIme, false, (Function0) it$iv6, 1, (Object) null), 0.0f, onCreate$lambda$0$0$4(offsetAnimate$delegate), 1, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getBottomCenter();
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & BR.containerVisible;
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
            int i2 = ((48 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1541032287, "C158@7438L6,153@7187L2906:StepByStepBottomSheetLoginActivity.kt#c84q0i");
            Modifier modifier$iv2 = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl((float) BR.imageBadge)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(16), Dp.constructor-impl(16), Dp.constructor-impl(0), Dp.constructor-impl(0)));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & BR.containerVisible));
            int $changed$iv$iv2 = (0 << 3) & BR.containerVisible;
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
            int i4 = ((0 >> 6) & BR.containerVisible) | 6;
            ColumnScope $this$onCreate_u24lambda_u240_u240_u247_u240 = columnScope;
            ComposerKt.sourceInformationMarkerStart($composer, -348449937, "C198@9832L10,200@9942L9,196@9681L386:StepByStepBottomSheetLoginActivity.kt#c84q0i");
            if (stateSms instanceof StepByStepSmsLoginVerifyPage) {
                $composer.startReplaceGroup(-348414412);
                ComposerKt.sourceInformation($composer, "165@7856L7,164@7767L228,168@8111L6,173@8446L253,163@7715L1018");
                CompositionLocal this_$iv2 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume2 = $composer.consume(this_$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Painter rememberDrawablePainter = DrawablePainterKt.rememberDrawablePainter(KtxKt.getAppCompatDrawable((Context) consume2, R.drawable.ic_arrow_back_left_line_24), $composer, 0);
                long j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_medium-0d7_KjU();
                Modifier align = $this$onCreate_u24lambda_u240_u240_u247_u240.align(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null), Dp.constructor-impl(24)), Alignment.Companion.getStart());
                ComposerKt.sourceInformationMarkerStart($composer, 681520113, "CC(remember):StepByStepBottomSheetLoginActivity.kt#9igjgp");
                boolean invalid$iv5 = $composer.changedInstance(this$0);
                Object it$iv7 = $composer.rememberedValue();
                if (invalid$iv5) {
                }
                Object value$iv7 = new Function0() { // from class: tv.danmaku.bili.stepbystep.StepByStepBottomSheetLoginActivity$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit onCreate$lambda$0$0$7$0$0$0;
                        onCreate$lambda$0$0$7$0$0$0 = StepByStepBottomSheetLoginActivity.onCreate$lambda$0$0$7$0$0$0(StepByStepBottomSheetLoginActivity.this);
                        return onCreate$lambda$0$0$7$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv7);
                it$iv7 = value$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer);
                IconKt.Icon-ww6aTOc(rememberDrawablePainter, "", ModifierUtilsKt.clickableNoInteraction$default(align, false, (Function0) it$iv7, 1, (Object) null), j, $composer, Painter.$stable | 48, 0);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-347341316);
                ComposerKt.sourceInformation($composer, "182@8944L7,181@8855L189,185@9160L6,190@9491L96,180@8803L818");
                CompositionLocal this_$iv3 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume3 = $composer.consume(this_$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Painter rememberDrawablePainter2 = DrawablePainterKt.rememberDrawablePainter(KtxKt.getAppCompatDrawable((Context) consume3, com.bilibili.app.accountui.R.drawable.ic_bottom_login_close), $composer, 0);
                long j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_medium-0d7_KjU();
                Modifier align2 = $this$onCreate_u24lambda_u240_u240_u247_u240.align(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 9, (Object) null), Dp.constructor-impl(24)), Alignment.Companion.getEnd());
                ComposerKt.sourceInformationMarkerStart($composer, 681553396, "CC(remember):StepByStepBottomSheetLoginActivity.kt#9igjgp");
                boolean invalid$iv6 = $composer.changedInstance(this$0);
                Object it$iv8 = $composer.rememberedValue();
                if (invalid$iv6) {
                }
                Object value$iv8 = new Function0() { // from class: tv.danmaku.bili.stepbystep.StepByStepBottomSheetLoginActivity$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        Unit onCreate$lambda$0$0$7$0$1$0;
                        onCreate$lambda$0$0$7$0$1$0 = StepByStepBottomSheetLoginActivity.onCreate$lambda$0$0$7$0$1$0(StepByStepBottomSheetLoginActivity.this);
                        return onCreate$lambda$0$0$7$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv8);
                it$iv8 = value$iv8;
                ComposerKt.sourceInformationMarkerEnd($composer);
                IconKt.Icon-ww6aTOc(rememberDrawablePainter2, "", ModifierUtilsKt.clickableNoInteraction$default(align2, false, (Function0) it$iv8, 1, (Object) null), j2, $composer, Painter.$stable | 48, 0);
                $composer.endReplaceGroup();
            }
            StepByStepComposePaddingMap.InFloat inFloat = StepByStepComposePaddingMap.InFloat.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 681564222, "CC(remember):StepByStepBottomSheetLoginActivity.kt#9igjgp");
            boolean invalid$iv7 = $composer.changedInstance(this$0);
            Object it$iv9 = $composer.rememberedValue();
            if (invalid$iv7) {
            }
            Object value$iv9 = (KFunction) new StepByStepBottomSheetLoginActivity$onCreate$1$1$4$1$3$1(this$0);
            $composer.updateRememberedValue(value$iv9);
            it$iv9 = value$iv9;
            Function1 function1 = (KFunction) it$iv9;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 681567741, "CC(remember):StepByStepBottomSheetLoginActivity.kt#9igjgp");
            boolean invalid$iv8 = $composer.changedInstance(this$0);
            Object it$iv10 = $composer.rememberedValue();
            if (invalid$iv8) {
            }
            Object value$iv10 = (KFunction) new StepByStepBottomSheetLoginActivity$onCreate$1$1$4$1$4$1(this$0);
            $composer.updateRememberedValue(value$iv10);
            it$iv10 = value$iv10;
            ComposerKt.sourceInformationMarkerEnd($composer);
            StepByStepSmsLoginComposeKt.StepByStepSmsLogin(inFloat, function1, (KFunction) it$iv10, stateSms, (int) Duration.getInWholeSeconds-impl(stateSms.mo1508getCountingUwyO8pc()), $composer, 6);
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

    private static final float onCreate$lambda$0$0$4(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$3$0(IStepByStepSmsLoginPageState $stateSms, StepByStepBottomSheetLoginActivity this$0, float it) {
        Object $this$asTo$iv = $stateSms;
        if (!($this$asTo$iv instanceof StepByStepSmsLoginPageTransitionState)) {
            $this$asTo$iv = null;
        }
        StepByStepSmsLoginPageTransitionState it2 = (StepByStepSmsLoginPageTransitionState) $this$asTo$iv;
        if (it2 != null) {
            this$0.getViewModel().dispatchAction(new StepByStepSmsLoginAction.OverrideTransitionStateAction(it2));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$5$0(MutableState $keyboardVisible, boolean it) {
        $keyboardVisible.setValue(Boolean.valueOf(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$6$0(MutableState $keyboardVisible, SoftwareKeyboardController $keyboardController, StepByStepBottomSheetLoginActivity this$0) {
        if (((Boolean) $keyboardVisible.getValue()).booleanValue()) {
            if ($keyboardController != null) {
                $keyboardController.hide();
            }
        } else {
            this$0.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$7$0$0$0(StepByStepBottomSheetLoginActivity this$0) {
        this$0.getViewModel().dispatchAction(StepByStepSmsLoginAction.PageTransitionAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$7$0$1$0(StepByStepBottomSheetLoginActivity this$0) {
        this$0.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(StepByStepBottomSheetLoginActivity this$0, PhoneCountryCode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getViewModel().dispatchAction(new StepByStepSmsLoginAction.SelectCountryCodeAction(it));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void routeTo(String url, final Bundle args) {
        BLRouter.routeTo$default(new RouteRequest.Builder(url).extras(new Function1() { // from class: tv.danmaku.bili.stepbystep.StepByStepBottomSheetLoginActivity$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit routeTo$lambda$0;
                routeTo$lambda$0 = StepByStepBottomSheetLoginActivity.routeTo$lambda$0(args, (MutableBundleLike) obj);
                return routeTo$lambda$0;
            }
        }).build(), (Context) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit routeTo$lambda$0(Bundle $args, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        if ($args != null) {
            String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
            Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
            $this$extras.put(str, $args);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void routeTo(IAccountRedirect url) {
        Intent it;
        if (url != null && (it = url.getIntent((Context) this)) != null) {
            startActivity(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatch(IStepByStepLoginAction action) {
        if (Intrinsics.areEqual(action, IStepByStepLoginAction.SwitchToPassword.INSTANCE)) {
            getViewModel().dispatchAction(StepByStepSmsLoginAction.ReportAction.ClickSwitchToPassword.INSTANCE);
            routeToPassword();
            return;
        }
        getViewModel().dispatchAction(action);
    }

    private final void routeToPassword() {
        RouteUtilKt.routeToLoginOriginActivityV2$default((Context) this, true, false, null, null, null, null, null, true, BR.guestPureEnjoyMsgList, null);
    }

    private final void registerLoginListener() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new StepByStepBottomSheetLoginActivity$registerLoginListener$1(this, null), 3, (Object) null);
    }

    private final void registerToast() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new StepByStepBottomSheetLoginActivity$registerToast$1(this, null), 3, (Object) null);
    }

    private final void registerRedirect() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new StepByStepBottomSheetLoginActivity$registerRedirect$1(this, null), 3, (Object) null);
    }

    private final void registerLoggedInState() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new StepByStepBottomSheetLoginActivity$registerLoggedInState$1(this, null), 3, (Object) null);
    }

    private final void registerEulaDialog() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new StepByStepBottomSheetLoginActivity$registerEulaDialog$1(this, null), 3, (Object) null);
    }

    private final void registerCaptchaDialog() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new StepByStepBottomSheetLoginActivity$registerCaptchaDialog$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showCaptchaDialog(final CaptchaDialogV2 $this$showCaptchaDialog, Continuation<? super Unit> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation it = cancellableContinuationImpl;
        getViewModel().dispatchAction(StepByStepSmsLoginAction.ReportAction.ShowCaptureDialog.INSTANCE);
        it.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: tv.danmaku.bili.stepbystep.StepByStepBottomSheetLoginActivity$showCaptchaDialog$2$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((Throwable) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable it2) {
                if ($this$showCaptchaDialog.isShowing()) {
                    $this$showCaptchaDialog.dismiss();
                }
            }
        });
        $this$showCaptchaDialog.show();
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    public String getPvEventId() {
        return "app.login.0.0.pv";
    }

    public Bundle getPvExtra() {
        Bundle $this$getPvExtra_u24lambda_u240 = new Bundle();
        Map it = LoginReportService.getReportParamMap$default(getViewModel().getLoginReportService(), getViewModel().getLoginType(), null, 2, null);
        Iterable $this$forEach$iv = it.keySet();
        for (Object element$iv : $this$forEach$iv) {
            String k = (String) element$iv;
            $this$getPvExtra_u24lambda_u240.putString(k, (String) it.get(k));
        }
        return $this$getPvExtra_u24lambda_u240;
    }

    protected void onResume() {
        super.onResume();
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(getColor(com.bilibili.app.comm.baseres.R.color.black_alpha50));
        }
        if (!MultipleThemeUtils.isNightTheme((Context) this) && MultipleThemeUtils.isWhiteTheme((Context) this)) {
            StatusBarCompat.setStatusBarDarkMode((Activity) this);
        } else {
            StatusBarCompat.setStatusBarLightMode((Activity) this);
        }
    }
}