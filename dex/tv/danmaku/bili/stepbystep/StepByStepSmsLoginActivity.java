package tv.danmaku.bili.stepbystep;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
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
import com.bilibili.app.accountui.R;
import com.bilibili.app.comm.list.widget.statement.LittleTVLoadingStateKt;
import com.bilibili.app.comm.list.widget.statement.TVPageState;
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
import com.bilibili.pvtracker.IPvTracker;
import com.google.accompanist.drawablepainter.DrawablePainterKt;
import com.google.accompanist.systemuicontroller.SystemUiController;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.normal.ui.RouteUtilKt;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.stepbystep.IStepByStepLoginAction;
import tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState;
import tv.danmaku.bili.stepbystep.sms.StepByStepComposePaddingMap;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginIdlePage;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginPageTransitionState;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginPhonePage;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginVerifyPage;
import tv.danmaku.bili.ui.AgreementLinkHelper;

/* compiled from: StepByStepSmsLoginActivity.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J7\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0018H\u0003¢\u0006\u0002\u0010\u0019J?\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\u00152\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0018H\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u000eH\u0002J\u001c\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\"\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010&H\u0002J\b\u0010'\u001a\u00020\u000eH\u0002J\b\u0010(\u001a\u00020\u000eH\u0002J\b\u0010)\u001a\u00020\u000eH\u0002J\b\u0010*\u001a\u00020\u000eH\u0002J\b\u0010+\u001a\u00020\u000eH\u0002J\b\u0010,\u001a\u00020\u000eH\u0002J\u0012\u0010-\u001a\u00020\u000e*\u00020.H\u0082@¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020$H\u0016J\b\u00101\u001a\u00020\u0010H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u00062²\u0006\n\u00103\u001a\u000204X\u008a\u0084\u0002"}, d2 = {"Ltv/danmaku/bili/stepbystep/StepByStepSmsLoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/bilibili/pvtracker/IPvTracker;", "<init>", "()V", "viewModel", "Ltv/danmaku/bili/stepbystep/StepByStepLoginViewModel;", "getViewModel", "()Ltv/danmaku/bili/stepbystep/StepByStepLoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getResources", "Landroid/content/res/Resources;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "PhonePage", "pageState", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "onAction", "Lkotlin/Function1;", "Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction;", "onFinish", "Lkotlin/Function0;", "(Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "VerifyPage", "modifier", "Landroidx/compose/ui/Modifier;", "onBackToLast", "(Landroidx/compose/ui/Modifier;Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "dispatch", "action", "routeToPassword", "routeTo", "url", "", "args", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "registerLoginListener", "registerToast", "registerRedirect", "registerLoggedInState", "registerEulaDialog", "registerCaptchaDialog", "showCaptchaDialog", "Lcom/bilibili/lib/accountsui/captcha/CaptchaDialogV2;", "(Lcom/bilibili/lib/accountsui/captcha/CaptchaDialogV2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPvEventId", "getPvExtra", "accountui_apinkDebug", "verifyOffsetAnimate", ""}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@AndroidEntryPoint
public final class StepByStepSmsLoginActivity extends Hilt_StepByStepSmsLoginActivity implements IPvTracker {
    public static final int $stable = 8;
    private final Lazy viewModel$delegate;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PhonePage$lambda$1(StepByStepSmsLoginActivity stepByStepSmsLoginActivity, IStepByStepSmsLoginPageState iStepByStepSmsLoginPageState, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        stepByStepSmsLoginActivity.PhonePage(iStepByStepSmsLoginPageState, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerifyPage$lambda$1(StepByStepSmsLoginActivity stepByStepSmsLoginActivity, Modifier modifier, IStepByStepSmsLoginPageState iStepByStepSmsLoginPageState, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        stepByStepSmsLoginActivity.VerifyPage(modifier, iStepByStepSmsLoginPageState, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

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

    public StepByStepSmsLoginActivity() {
        final ComponentActivity $this$viewModels_u24default$iv = (ComponentActivity) this;
        final Function0 extrasProducer$iv = new Function0() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$$ExternalSyntheticLambda3
            public final Object invoke() {
                CreationExtras viewModel_delegate$lambda$0;
                viewModel_delegate$lambda$0 = StepByStepSmsLoginActivity.viewModel_delegate$lambda$0(StepByStepSmsLoginActivity.this);
                return viewModel_delegate$lambda$0;
            }
        };
        Function0 factoryPromise$iv = new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$special$$inlined$viewModels$default$1
            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1502invoke() {
                return $this$viewModels_u24default$iv.getDefaultViewModelProviderFactory();
            }
        };
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(StepByStepLoginViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$special$$inlined$viewModels$default$2
            /* renamed from: invoke */
            public final ViewModelStore m1503invoke() {
                return $this$viewModels_u24default$iv.getViewModelStore();
            }
        }, factoryPromise$iv, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$special$$inlined$viewModels$default$3
            /* renamed from: invoke */
            public final CreationExtras m1504invoke() {
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
    public static final CreationExtras viewModel_delegate$lambda$0(StepByStepSmsLoginActivity this$0) {
        CreationExtras mutableCreationExtras = new MutableCreationExtras(this$0.getDefaultViewModelCreationExtras());
        CreationExtras.Key key = SavedStateHandleSupport.DEFAULT_ARGS_KEY;
        Bundle $this$viewModel_delegate_u24lambda_u240_u240_u240 = this$0.getIntent().getExtras();
        if ($this$viewModel_delegate_u24lambda_u240_u240_u240 != null) {
            $this$viewModel_delegate_u24lambda_u240_u240_u240.putString(StepByStepBottomSheetLoginActivityKt.REPORT_LOGIN_TYPE, "sms_fullscreen_v1");
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

    @Override // tv.danmaku.bili.stepbystep.Hilt_StepByStepSmsLoginActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (BiliAccounts.get(FoundationAlias.getFapp().getBaseContext()).isLogin()) {
            finish();
            return;
        }
        ComponentActivityKt.setContent$default((ComponentActivity) this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(147959800, true, new Function2() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$$ExternalSyntheticLambda14
            public final Object invoke(Object obj, Object obj2) {
                Unit onCreate$lambda$0;
                onCreate$lambda$0 = StepByStepSmsLoginActivity.onCreate$lambda$0(StepByStepSmsLoginActivity.this, (Composer) obj, ((Integer) obj2).intValue());
                return onCreate$lambda$0;
            }
        }), 1, (Object) null);
        registerLoginListener();
        registerEulaDialog();
        registerCaptchaDialog();
        registerToast();
        registerLoggedInState();
        registerRedirect();
        Violet.INSTANCE.ofChannel(PhoneCountryCode.class).observe((LifecycleOwner) this, new Observer() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$$ExternalSyntheticLambda15
            public final void onChanged(Object obj) {
                StepByStepSmsLoginActivity.onCreate$lambda$1(StepByStepSmsLoginActivity.this, (PhoneCountryCode) obj);
            }
        });
        getOnBackPressedDispatcher().addCallback((LifecycleOwner) this, new OnBackPressedCallback() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$onCreate$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            public void handleOnBackPressed() {
                if (!(StepByStepSmsLoginActivity.this.getViewModel().getStateSmsFlow().getValue() instanceof StepByStepSmsLoginPhonePage)) {
                    StepByStepSmsLoginActivity.this.getViewModel().dispatchAction(StepByStepSmsLoginAction.PageTransitionAction.INSTANCE);
                } else {
                    StepByStepSmsLoginActivity.this.finish();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(final StepByStepSmsLoginActivity this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C119@5352L34,120@5413L2032,120@5403L2042:StepByStepSmsLoginActivity.kt#c84q0i");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(147959800, $changed, -1, "tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity.onCreate.<anonymous> (StepByStepSmsLoginActivity.kt:119)");
            }
            final SystemUiController controller = SystemUiControllerKt.rememberSystemUiController(this$0.getWindow(), $composer, 0, 0);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(37229488, true, new Function2() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreate$lambda$0$0;
                    onCreate$lambda$0$0 = StepByStepSmsLoginActivity.onCreate$lambda$0$0(controller, this$0, (Composer) obj, ((Integer) obj2).intValue());
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
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01f1, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x023a, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0277, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x02d3, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x030c, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L54;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit onCreate$lambda$0$0(SystemUiController $controller, final StepByStepSmsLoginActivity this$0, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C121@5459L6,122@5511L85,122@5490L106,126@5656L16,130@5841L6,127@5699L1728:StepByStepSmsLoginActivity.kt#c84q0i");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(37229488, $changed, -1, "tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity.onCreate.<anonymous>.<anonymous> (StepByStepSmsLoginActivity.kt:121)");
            }
            long bgColor = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU();
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1417802821, "CC(remember):StepByStepSmsLoginActivity.kt#9igjgp");
            boolean invalid$iv = $composer.changed($controller) | $composer.changed(bgColor);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new StepByStepSmsLoginActivity$onCreate$1$1$1$1($controller, bgColor, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer, 6);
            final IStepByStepSmsLoginPageState stateSms = (IStepByStepSmsLoginPageState) SnapshotStateKt.collectAsState(this$0.getViewModel().getStateSmsFlow(), (CoroutineContext) null, $composer, 0, 1).getValue();
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & BR.containerVisible;
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
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 348279609, "C138@6432L280,134@6155L583,146@6863L10,147@6914L12,144@6763L164,151@7144L10,152@7199L205,148@6952L453:StepByStepSmsLoginActivity.kt#c84q0i");
            boolean displayVerifyPage = (stateSms instanceof StepByStepSmsLoginVerifyPage) || ((stateSms instanceof StepByStepSmsLoginPageTransitionState) && (((StepByStepSmsLoginPageTransitionState) stateSms).getTargetPage() instanceof StepByStepSmsLoginVerifyPage));
            float f = displayVerifyPage ? 0.0f : 1.0f;
            AnimationSpec tween$default = AnimationSpecKt.tween$default((int) BR.guideBarHeight, 0, (Easing) null, 6, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 11250594, "CC(remember):StepByStepSmsLoginActivity.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance(stateSms) | $composer.changedInstance(this$0);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function1() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit onCreate$lambda$0$0$1$0$0;
                    onCreate$lambda$0$0$1$0$0 = StepByStepSmsLoginActivity.onCreate$lambda$0$0$1$0$0(IStepByStepSmsLoginPageState.this, this$0, ((Float) obj).floatValue());
                    return onCreate$lambda$0$0$1$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            State verifyOffsetAnimate$delegate = AnimateAsStateKt.animateFloatAsState(f, tween$default, 0.0f, "dialog show or hide", (Function1) it$iv2, $composer, 3120, 4);
            ComposerKt.sourceInformationMarkerStart($composer, 11264116, "CC(remember):StepByStepSmsLoginActivity.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance(this$0);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv3 = (KFunction) new StepByStepSmsLoginActivity$onCreate$1$1$2$1$1(this$0);
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Function1<? super IStepByStepLoginAction, Unit> function1 = (Function1) ((KFunction) it$iv3);
            ComposerKt.sourceInformationMarkerStart($composer, 11265750, "CC(remember):StepByStepSmsLoginActivity.kt#9igjgp");
            boolean invalid$iv4 = $composer.changedInstance(this$0);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv4 = new Function0() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit onCreate$lambda$0$0$1$3$0;
                    onCreate$lambda$0$0$1$3$0 = StepByStepSmsLoginActivity.onCreate$lambda$0$0$1$3$0(StepByStepSmsLoginActivity.this);
                    return onCreate$lambda$0$0$1$3$0;
                }
            };
            $composer.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            this$0.PhonePage(stateSms, function1, it$iv4, $composer, 0);
            Modifier percentageOffset$default = ParentRelativeOffsetModifierKt.percentageOffset$default(Modifier.Companion, onCreate$lambda$0$0$1$1(verifyOffsetAnimate$delegate), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 11273108, "CC(remember):StepByStepSmsLoginActivity.kt#9igjgp");
            boolean invalid$iv5 = $composer.changedInstance(this$0);
            Object it$iv5 = $composer.rememberedValue();
            if (invalid$iv5) {
            }
            Object value$iv5 = (KFunction) new StepByStepSmsLoginActivity$onCreate$1$1$2$3$1(this$0);
            $composer.updateRememberedValue(value$iv5);
            it$iv5 = value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Function1<? super IStepByStepLoginAction, Unit> function12 = (Function1) ((KFunction) it$iv5);
            ComposerKt.sourceInformationMarkerStart($composer, 11275063, "CC(remember):StepByStepSmsLoginActivity.kt#9igjgp");
            boolean invalid$iv6 = $composer.changedInstance(this$0);
            Object it$iv6 = $composer.rememberedValue();
            if (invalid$iv6) {
            }
            Object value$iv6 = new Function0() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit onCreate$lambda$0$0$1$5$0;
                    onCreate$lambda$0$0$1$5$0 = StepByStepSmsLoginActivity.onCreate$lambda$0$0$1$5$0(StepByStepSmsLoginActivity.this);
                    return onCreate$lambda$0$0$1$5$0;
                }
            };
            $composer.updateRememberedValue(value$iv6);
            it$iv6 = value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer);
            this$0.VerifyPage(percentageOffset$default, stateSms, function12, (Function0) it$iv6, $composer, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final float onCreate$lambda$0$0$1$1(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$1$0$0(IStepByStepSmsLoginPageState $stateSms, StepByStepSmsLoginActivity this$0, float it) {
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
    public static final Unit onCreate$lambda$0$0$1$3$0(StepByStepSmsLoginActivity this$0) {
        this$0.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$1$5$0(StepByStepSmsLoginActivity this$0) {
        this$0.getViewModel().dispatchAction(StepByStepSmsLoginAction.PageTransitionAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(StepByStepSmsLoginActivity this$0, PhoneCountryCode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getViewModel().dispatchAction(new StepByStepSmsLoginAction.SelectCountryCodeAction(it));
    }

    /* JADX WARN: Code restructure failed: missing block: B:147:0x098b, code lost:
        if (r12 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0339, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x03dc, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0983  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x098f  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0a20  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void PhonePage(final IStepByStepSmsLoginPageState pageState, final Function1<? super IStepByStepLoginAction, Unit> function1, final Function0<Unit> function0, Composer $composer, final int $changed) {
        int $dirty;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        StepByStepSmsLoginPhonePage phonePage;
        Composer $composer$iv$iv$iv;
        String str;
        Composer $composer$iv$iv;
        CompositionLocalMap localMap$iv$iv;
        Composer $composer2;
        String str2;
        float f;
        Composer $composer$iv$iv2;
        Composer $composer$iv$iv3;
        String str3;
        Function0 factory$iv$iv$iv4;
        Object value$iv;
        boolean invalid$iv;
        Composer $composer3 = $composer.startRestartGroup(-676252518);
        ComposerKt.sourceInformation($composer3, "C(PhonePage)N(pageState,onAction,onFinish)193@8608L6,190@8499L4846:StepByStepSmsLoginActivity.kt#c84q0i");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= ($changed & 8) == 0 ? $composer3.changed(pageState) : $composer3.changedInstance(pageState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? BR.hallEnterHotText : BR.cover;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changedInstance(this) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        if ($composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-676252518, $dirty2, -1, "tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity.PhonePage (StepByStepSmsLoginActivity.kt:189)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & BR.containerVisible));
            int $changed$iv$iv = (0 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1568937748, "C195@8644L1245,221@9903L3432:StepByStepSmsLoginActivity.kt#c84q0i");
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & BR.containerVisible));
            int $changed$iv$iv2 = (6 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((6 >> 6) & BR.containerVisible) | 6;
            RowScope $this$PhonePage_u24lambda_u240_u240 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer3, 675759310, "C198@8811L7,197@8738L157,201@8979L6,205@9165L66,196@8702L547,209@9266L38,210@9333L77,211@9450L6,212@9502L9,215@9664L210,210@9321L554:StepByStepSmsLoginActivity.kt#c84q0i");
            CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Painter rememberDrawablePainter = DrawablePainterKt.rememberDrawablePainter(KtxKt.getAppCompatDrawable((Context) consume, R.drawable.ic_bottom_login_close), $composer3, 0);
            long j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_medium-0d7_KjU();
            Modifier modifier = SizeKt.size-3ABfNKs(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), Dp.constructor-impl(24));
            ComposerKt.sourceInformationMarkerStart($composer3, 1822927714, "CC(remember):StepByStepSmsLoginActivity.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 896) == 256;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$$ExternalSyntheticLambda7
                public final Object invoke() {
                    Unit PhonePage$lambda$0$0$0$0;
                    PhonePage$lambda$0$0$0$0 = StepByStepSmsLoginActivity.PhonePage$lambda$0$0$0$0(function0);
                    return PhonePage$lambda$0$0$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv2);
            it$iv = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            IconKt.Icon-ww6aTOc(rememberDrawablePainter, "", ModifierUtilsKt.clickableNoInteraction$default(modifier, false, (Function0) it$iv, 1, (Object) null), j, $composer3, Painter.$stable | 48, 0);
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$PhonePage_u24lambda_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
            String stringResource = StringResources_androidKt.stringResource(bili.resource.account.R.string.account_global_string_103, $composer3, 0);
            long j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU();
            TextStyle t16 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16();
            Modifier modifier2 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 9, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1822943826, "CC(remember):StepByStepSmsLoginActivity.kt#9igjgp");
            boolean invalid$iv3 = $composer3.changedInstance(this);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv3 = new Function0() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$$ExternalSyntheticLambda8
                public final Object invoke() {
                    Unit PhonePage$lambda$0$0$1$0;
                    PhonePage$lambda$0$0$1$0 = StepByStepSmsLoginActivity.PhonePage$lambda$0$0$1$0(StepByStepSmsLoginActivity.this);
                    return PhonePage$lambda$0$0$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            it$iv2 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextKt.Text--4IGK_g(stringResource, ModifierUtilsKt.clickableNoInteraction$default(modifier2, false, (Function0) it$iv2, 1, (Object) null), j2, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t16, $composer3, 0, 0, 65528);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(36), 0.0f, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((BR.nickTextColor >> 3) & 14) | ((BR.nickTextColor >> 3) & BR.containerVisible));
            int $changed$iv$iv3 = (BR.nickTextColor << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i6 = ((BR.nickTextColor >> 6) & BR.containerVisible) | 6;
            Composer $composer4 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer4, -635584225, "C262@11676L1645:StepByStepSmsLoginActivity.kt#c84q0i");
            if (pageState instanceof StepByStepSmsLoginIdlePage) {
                $composer4.startReplaceGroup(-635608685);
                ComposerKt.sourceInformation($composer4, "229@10229L49");
                LittleTVLoadingStateKt.LittleTVLoadStatus(new TVPageState.Loading(0, 1, (DefaultConstructorMarker) null), (Modifier) null, $composer4, TVPageState.Loading.$stable, 2);
                $composer4.endReplaceGroup();
                $composer$iv$iv$iv = $composer3;
                str = "CC(remember):StepByStepSmsLoginActivity.kt#9igjgp";
                $composer$iv$iv = $composer3;
                localMap$iv$iv = localMap$iv$iv2;
                $composer2 = $composer3;
                str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                f = 0.0f;
                $composer$iv$iv2 = $composer3;
                $composer$iv$iv3 = $composer3;
            } else if ((pageState instanceof StepByStepSmsLoginPhonePage) || (pageState instanceof StepByStepSmsLoginPageTransitionState)) {
                $composer4.startReplaceGroup(-635381579);
                ComposerKt.sourceInformation($composer4, "");
                if (pageState instanceof StepByStepSmsLoginPhonePage) {
                    phonePage = (StepByStepSmsLoginPhonePage) pageState;
                } else if (pageState instanceof StepByStepSmsLoginPageTransitionState) {
                    Object $this$asTo$iv = ((StepByStepSmsLoginPageTransitionState) pageState).getCurrentPage();
                    if (!($this$asTo$iv instanceof StepByStepSmsLoginPhonePage)) {
                        $this$asTo$iv = null;
                    }
                    phonePage = (StepByStepSmsLoginPhonePage) $this$asTo$iv;
                    if (phonePage == null) {
                        Object $this$asTo$iv2 = ((StepByStepSmsLoginPageTransitionState) pageState).getTargetPage();
                        if (!($this$asTo$iv2 instanceof StepByStepSmsLoginPhonePage)) {
                            $this$asTo$iv2 = null;
                        }
                        phonePage = (StepByStepSmsLoginPhonePage) $this$asTo$iv2;
                    }
                } else {
                    phonePage = null;
                }
                if (phonePage != null) {
                    $composer4.startReplaceGroup(-634713250);
                    ComposerKt.sourceInformation($composer4, "251@11266L9,254@11489L9,248@11095L438");
                    ComposerKt.sourceInformationMarkerStart($composer4, 1087909079, "CC(remember):StepByStepSmsLoginActivity.kt#9igjgp");
                    boolean invalid$iv4 = $composer3.changedInstance(this);
                    Object it$iv3 = $composer4.rememberedValue();
                    if (invalid$iv4 || it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv4 = (KFunction) new StepByStepSmsLoginActivity$PhonePage$1$2$1$1(this);
                        $composer4.updateRememberedValue(value$iv4);
                        it$iv3 = value$iv4;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer$iv$iv$iv = $composer3;
                    StepByStepSmsLoginPhonePage stepByStepSmsLoginPhonePage = phonePage;
                    str = "CC(remember):StepByStepSmsLoginActivity.kt#9igjgp";
                    $composer$iv$iv = $composer3;
                    f = 0.0f;
                    str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    localMap$iv$iv = localMap$iv$iv2;
                    $composer2 = $composer3;
                    $composer$iv$iv2 = $composer3;
                    $composer$iv$iv3 = $composer3;
                    str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    StepByStepSmsLoginComposeKt.LoginSmsPhonePage(StepByStepComposePaddingMap.InFullscreen.INSTANCE, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT22b(), stepByStepSmsLoginPhonePage, function1, (KFunction) it$iv3, false, $composer4, (($dirty2 << 6) & 7168) | 196614, 0);
                    $composer4.endReplaceGroup();
                    $composer4 = $composer4;
                } else {
                    $composer$iv$iv$iv = $composer3;
                    str = "CC(remember):StepByStepSmsLoginActivity.kt#9igjgp";
                    $composer$iv$iv = $composer3;
                    localMap$iv$iv = localMap$iv$iv2;
                    $composer2 = $composer3;
                    str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    f = 0.0f;
                    $composer$iv$iv2 = $composer3;
                    $composer$iv$iv3 = $composer3;
                    str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    $composer4.startReplaceGroup(-645734060);
                    $composer4.endReplaceGroup();
                }
                $composer4.endReplaceGroup();
            } else if (!(pageState instanceof StepByStepSmsLoginVerifyPage)) {
                $composer4.startReplaceGroup(1087874277);
                $composer4.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            } else {
                $composer4.startReplaceGroup(-634188110);
                $composer4.endReplaceGroup();
                $composer$iv$iv$iv = $composer3;
                str = "CC(remember):StepByStepSmsLoginActivity.kt#9igjgp";
                $composer$iv$iv = $composer3;
                localMap$iv$iv = localMap$iv$iv2;
                $composer2 = $composer3;
                str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                f = 0.0f;
                $composer$iv$iv2 = $composer3;
                $composer$iv$iv3 = $composer3;
            }
            Modifier modifier$iv4 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, f, 1, (Object) null), 0.0f, Dp.constructor-impl(24), 0.0f, 0.0f, 13, (Object) null);
            Composer $composer$iv = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer$iv, ((6 >> 3) & 14) | ((6 >> 3) & BR.containerVisible));
            int $changed$iv$iv4 = (6 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, str3);
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv4);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, str2);
            if (!($composer$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer$iv.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i8 = ((6 >> 6) & BR.containerVisible) | 6;
            RowScope $this$PhonePage_u24lambda_u240_u241_u241 = rowScope2;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -479704280, "C268@11886L83,270@12061L6,267@11846L310,273@12189L76,274@12309L9,275@12366L6,278@12531L113,273@12177L468,281@12666L38,282@12737L77,283@12858L9,284@12915L6,287@13080L222,282@12725L578:StepByStepSmsLoginActivity.kt#c84q0i");
            IconKt.Icon-ww6aTOc(PainterResources_androidKt.painterResource(com.bilibili.app.comm.list.common.R.drawable.ic_switch_column, $composer$iv, 0), "", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getText_link-0d7_KjU(), $composer$iv, Painter.$stable | BR.pendentVisible, 0);
            String stringResource2 = StringResources_androidKt.stringResource(bili.resource.account.R.string.account_global_string_17, $composer$iv, 0);
            TextStyle t13 = BiliTheme.INSTANCE.getTextStyle($composer$iv, BiliTheme.$stable).getT13();
            long j3 = BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getText_link-0d7_KjU();
            Modifier modifier3 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(2), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            String str4 = str;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1400927077, str4);
            $dirty = $dirty2;
            boolean invalid$iv5 = ($dirty2 & BR.containerVisible) == 32;
            Object it$iv4 = $composer$iv.rememberedValue();
            if (!invalid$iv5 && it$iv4 != Composer.Companion.getEmpty()) {
                value$iv = it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                TextKt.Text--4IGK_g(stringResource2, ModifierUtilsKt.clickableNoInteraction$default(modifier3, false, (Function0) value$iv, 1, (Object) null), j3, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t13, $composer$iv, 0, 0, 65528);
                SpacerKt.Spacer(RowScope.-CC.weight$default($this$PhonePage_u24lambda_u240_u241_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer$iv, 0);
                String stringResource3 = StringResources_androidKt.stringResource(bili.resource.account.R.string.account_global_string_126, $composer$iv, 0);
                TextStyle t132 = BiliTheme.INSTANCE.getTextStyle($composer$iv, BiliTheme.$stable).getT13();
                long j4 = BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getText_link-0d7_KjU();
                Modifier modifier4 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(2), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer$iv, -1400909400, str4);
                invalid$iv = $composer3.changedInstance(this);
                Object it$iv5 = $composer$iv.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv5 = new Function0() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        Unit PhonePage$lambda$0$1$1$1$0;
                        PhonePage$lambda$0$1$1$1$0 = StepByStepSmsLoginActivity.PhonePage$lambda$0$1$1$1$0(StepByStepSmsLoginActivity.this);
                        return PhonePage$lambda$0$1$1$1$0;
                    }
                };
                $composer$iv.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                TextKt.Text--4IGK_g(stringResource3, ModifierUtilsKt.clickableNoInteraction$default(modifier4, false, (Function0) it$iv5, 1, (Object) null), j4, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t132, $composer$iv, 0, 0, 65528);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer$iv$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            value$iv = new Function0() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$$ExternalSyntheticLambda9
                public final Object invoke() {
                    Unit PhonePage$lambda$0$1$1$0$0;
                    PhonePage$lambda$0$1$1$0$0 = StepByStepSmsLoginActivity.PhonePage$lambda$0$1$1$0$0(function1);
                    return PhonePage$lambda$0$1$1$0$0;
                }
            };
            $composer$iv.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            TextKt.Text--4IGK_g(stringResource2, ModifierUtilsKt.clickableNoInteraction$default(modifier3, false, (Function0) value$iv, 1, (Object) null), j3, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t13, $composer$iv, 0, 0, 65528);
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$PhonePage_u24lambda_u240_u241_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer$iv, 0);
            String stringResource32 = StringResources_androidKt.stringResource(bili.resource.account.R.string.account_global_string_126, $composer$iv, 0);
            TextStyle t1322 = BiliTheme.INSTANCE.getTextStyle($composer$iv, BiliTheme.$stable).getT13();
            long j42 = BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getText_link-0d7_KjU();
            Modifier modifier42 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(2), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1400909400, str4);
            invalid$iv = $composer3.changedInstance(this);
            Object it$iv52 = $composer$iv.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv52 = new Function0() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$$ExternalSyntheticLambda10
                public final Object invoke() {
                    Unit PhonePage$lambda$0$1$1$1$0;
                    PhonePage$lambda$0$1$1$1$0 = StepByStepSmsLoginActivity.PhonePage$lambda$0$1$1$1$0(StepByStepSmsLoginActivity.this);
                    return PhonePage$lambda$0$1$1$1$0;
                }
            };
            $composer$iv.updateRememberedValue(value$iv52);
            it$iv52 = value$iv52;
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            TextKt.Text--4IGK_g(stringResource32, ModifierUtilsKt.clickableNoInteraction$default(modifier42, false, (Function0) it$iv52, 1, (Object) null), j42, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t1322, $composer$iv, 0, 0, 65528);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer$iv$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $dirty = $dirty2;
            $composer3.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit PhonePage$lambda$1;
                    PhonePage$lambda$1 = StepByStepSmsLoginActivity.PhonePage$lambda$1(StepByStepSmsLoginActivity.this, pageState, function1, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return PhonePage$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PhonePage$lambda$0$0$0$0(Function0 $onFinish) {
        $onFinish.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PhonePage$lambda$0$0$1$0(StepByStepSmsLoginActivity this$0) {
        this$0.getViewModel().dispatchAction(StepByStepSmsLoginAction.ReportAction.ClickHelp.INSTANCE);
        routeTo$default(this$0, AgreementLinkHelper.LINK_ACCOUNT_CHECK_HELP, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PhonePage$lambda$0$1$1$0$0(Function1 $onAction) {
        $onAction.invoke(IStepByStepLoginAction.SwitchToPassword.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PhonePage$lambda$0$1$1$1$0(StepByStepSmsLoginActivity this$0) {
        this$0.getViewModel().dispatchAction(StepByStepSmsLoginAction.ReportAction.ClickHelp.INSTANCE);
        routeTo$default(this$0, AgreementLinkHelper.LINK_ACCOUNT_CHECK_HELP, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0347, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x03e9, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L71;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void VerifyPage(final Modifier modifier, final IStepByStepSmsLoginPageState pageState, final Function1<? super IStepByStepLoginAction, Unit> function1, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        StepByStepSmsLoginVerifyPage verifyPage;
        Composer $composer$iv;
        Composer $composer$iv2;
        Composer $composer2 = $composer.startRestartGroup(332319748);
        ComposerKt.sourceInformation($composer2, "C(VerifyPage)N(modifier,pageState,onAction,onBackToLast)306@13684L6,303@13575L3231:StepByStepSmsLoginActivity.kt#c84q0i");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer2.changed(pageState) : $composer2.changedInstance(pageState) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? BR.hallEnterHotText : BR.cover;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(this) ? RingBuffer.CONSUME_SIZE : 8192;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(332319748, $dirty2, -1, "tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity.VerifyPage (StepByStepSmsLoginActivity.kt:302)");
            }
            Modifier modifier$iv$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & BR.containerVisible));
            int $changed$iv$iv = (0 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
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
            int i2 = ((0 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1985445327, "C308@13720L1288,334@15022L1774:StepByStepSmsLoginActivity.kt#c84q0i");
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            int $i$f$Row = ((0 >> 3) & 14) | ((0 >> 3) & BR.containerVisible);
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, $i$f$Row);
            int $changed$iv$iv2 = (0 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & BR.containerVisible) | 6;
            RowScope $this$VerifyPage_u24lambda_u240_u240 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer2, 764344793, "C311@13887L7,310@13814L196,314@14094L6,318@14280L70,309@13778L590,322@14385L38,323@14452L77,324@14569L6,325@14621L9,328@14783L210,323@14440L554:StepByStepSmsLoginActivity.kt#c84q0i");
            CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Painter rememberDrawablePainter = DrawablePainterKt.rememberDrawablePainter(KtxKt.getAppCompatDrawable((Context) consume, com.bilibili.app.comm.list.common.R.drawable.ic_arrow_back_left_line_24), $composer2, 0);
            long j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_medium-0d7_KjU();
            Modifier modifier2 = SizeKt.size-3ABfNKs(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), Dp.constructor-impl(24));
            ComposerKt.sourceInformationMarkerStart($composer2, -1637896784, "CC(remember):StepByStepSmsLoginActivity.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 7168) == 2048;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$$ExternalSyntheticLambda4
                public final Object invoke() {
                    Unit VerifyPage$lambda$0$0$0$0;
                    VerifyPage$lambda$0$0$0$0 = StepByStepSmsLoginActivity.VerifyPage$lambda$0$0$0$0(function0);
                    return VerifyPage$lambda$0$0$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            IconKt.Icon-ww6aTOc(rememberDrawablePainter, "", ModifierUtilsKt.clickableNoInteraction$default(modifier2, false, (Function0) it$iv, 1, (Object) null), j, $composer2, Painter.$stable | 48, 0);
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$VerifyPage_u24lambda_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer2, 0);
            String stringResource = StringResources_androidKt.stringResource(bili.resource.account.R.string.account_global_string_103, $composer2, 0);
            long j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU();
            TextStyle t16 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16();
            Modifier modifier3 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 9, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -1637880548, "CC(remember):StepByStepSmsLoginActivity.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(this);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit VerifyPage$lambda$0$0$1$0;
                    VerifyPage$lambda$0$0$1$0 = StepByStepSmsLoginActivity.VerifyPage$lambda$0$0$1$0(StepByStepSmsLoginActivity.this);
                    return VerifyPage$lambda$0$0$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            TextKt.Text--4IGK_g(stringResource, ModifierUtilsKt.clickableNoInteraction$default(modifier3, false, (Function0) it$iv2, 1, (Object) null), j2, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t16, $composer2, 0, 0, 65528);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(36), 0.0f, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer2, ((BR.nickTextColor >> 3) & 14) | ((BR.nickTextColor >> 3) & BR.containerVisible));
            int $changed$iv$iv3 = (BR.nickTextColor << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $i$f$Column = $changed$iv$iv3 << 6;
            int $changed$iv$iv$iv3 = ($i$f$Column & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer2.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i6 = ((BR.nickTextColor >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1345272239, "C:StepByStepSmsLoginActivity.kt#c84q0i");
            if (pageState instanceof StepByStepSmsLoginIdlePage) {
                $composer2.startReplaceGroup(1345299177);
                ComposerKt.sourceInformation($composer2, "342@15348L49");
                LittleTVLoadingStateKt.LittleTVLoadStatus(new TVPageState.Loading(0, 1, (DefaultConstructorMarker) null), (Modifier) null, $composer2, TVPageState.Loading.$stable, 2);
                $composer2.endReplaceGroup();
                $composer$iv = $composer2;
                $composer$iv2 = $composer2;
            } else if ((pageState instanceof StepByStepSmsLoginVerifyPage) || (pageState instanceof StepByStepSmsLoginPageTransitionState)) {
                $composer2.startReplaceGroup(1345527430);
                ComposerKt.sourceInformation($composer2, "");
                if (pageState instanceof StepByStepSmsLoginVerifyPage) {
                    verifyPage = (StepByStepSmsLoginVerifyPage) pageState;
                } else if (pageState instanceof StepByStepSmsLoginPageTransitionState) {
                    Object $this$asTo$iv = ((StepByStepSmsLoginPageTransitionState) pageState).getCurrentPage();
                    if (!($this$asTo$iv instanceof StepByStepSmsLoginVerifyPage)) {
                        $this$asTo$iv = null;
                    }
                    verifyPage = (StepByStepSmsLoginVerifyPage) $this$asTo$iv;
                    if (verifyPage == null) {
                        Object $this$asTo$iv2 = ((StepByStepSmsLoginPageTransitionState) pageState).getTargetPage();
                        if (!($this$asTo$iv2 instanceof StepByStepSmsLoginVerifyPage)) {
                            $this$asTo$iv2 = null;
                        }
                        verifyPage = (StepByStepSmsLoginVerifyPage) $this$asTo$iv2;
                    }
                } else {
                    verifyPage = null;
                }
                if (verifyPage != null) {
                    $composer2.startReplaceGroup(1346230355);
                    ComposerKt.sourceInformation($composer2, "366@16614L9,361@16251L407");
                    $composer$iv = $composer2;
                    $composer$iv2 = $composer2;
                    StepByStepSmsLoginComposeKt.LoginSmsVerifyPage(StepByStepComposePaddingMap.InFullscreen.INSTANCE, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT22b(), verifyPage, function1, (int) Duration.getInWholeSeconds-impl(pageState.mo1508getCountingUwyO8pc()), $composer2, (($dirty2 << 3) & 7168) | 6, 0);
                } else {
                    $composer$iv = $composer2;
                    $composer$iv2 = $composer2;
                    $composer2.startReplaceGroup(1330095754);
                }
                $composer2.endReplaceGroup();
                $composer2.endReplaceGroup();
            } else if (pageState instanceof StepByStepSmsLoginPhonePage) {
                $composer2.startReplaceGroup(1346724712);
                $composer2.endReplaceGroup();
                $composer$iv = $composer2;
                $composer$iv2 = $composer2;
            } else {
                $composer2.startReplaceGroup(1567416532);
                $composer2.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit VerifyPage$lambda$1;
                    VerifyPage$lambda$1 = StepByStepSmsLoginActivity.VerifyPage$lambda$1(StepByStepSmsLoginActivity.this, modifier, pageState, function1, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return VerifyPage$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerifyPage$lambda$0$0$0$0(Function0 $onBackToLast) {
        $onBackToLast.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerifyPage$lambda$0$0$1$0(StepByStepSmsLoginActivity this$0) {
        this$0.getViewModel().dispatchAction(StepByStepSmsLoginAction.ReportAction.ClickHelp.INSTANCE);
        routeTo$default(this$0, AgreementLinkHelper.LINK_ACCOUNT_CHECK_HELP, null, 2, null);
        return Unit.INSTANCE;
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

    static /* synthetic */ void routeTo$default(StepByStepSmsLoginActivity stepByStepSmsLoginActivity, String str, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        stepByStepSmsLoginActivity.routeTo(str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void routeTo(String url, final Bundle args) {
        BLRouter.routeTo$default(new RouteRequest.Builder(url).extras(new Function1() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                Unit routeTo$lambda$0;
                routeTo$lambda$0 = StepByStepSmsLoginActivity.routeTo$lambda$0(args, (MutableBundleLike) obj);
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

    private final void registerLoginListener() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new StepByStepSmsLoginActivity$registerLoginListener$1(this, null), 3, (Object) null);
    }

    private final void registerToast() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new StepByStepSmsLoginActivity$registerToast$1(this, null), 3, (Object) null);
    }

    private final void registerRedirect() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new StepByStepSmsLoginActivity$registerRedirect$1(this, null), 3, (Object) null);
    }

    private final void registerLoggedInState() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new StepByStepSmsLoginActivity$registerLoggedInState$1(this, null), 3, (Object) null);
    }

    private final void registerEulaDialog() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new StepByStepSmsLoginActivity$registerEulaDialog$1(this, null), 3, (Object) null);
    }

    private final void registerCaptchaDialog() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new StepByStepSmsLoginActivity$registerCaptchaDialog$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showCaptchaDialog(final CaptchaDialogV2 $this$showCaptchaDialog, Continuation<? super Unit> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation it = cancellableContinuationImpl;
        getViewModel().dispatchAction(StepByStepSmsLoginAction.ReportAction.ShowCaptureDialog.INSTANCE);
        it.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$showCaptchaDialog$2$1
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
}