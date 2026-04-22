package tv.danmaku.bili.fullscreen;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.compose.ComponentActivityKt;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import bili.resource.account.R;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.H5UrlConfigHelper;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.text.LimitTextSizeUtil;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accountsui.captcha.CaptchaDialogV2;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.pvtracker.IPvTracker;
import com.google.accompanist.systemuicontroller.SystemUiController;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.eula.EulaLinkItemListener;
import tv.danmaku.bili.eula.EulaLinkType;
import tv.danmaku.bili.fullscreen.component.LoadingKt;
import tv.danmaku.bili.fullscreen.exp.LoginExpType;
import tv.danmaku.bili.fullscreen.page.FullscreenLoginPageKt;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginIdlePage;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginInvalidPage;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginPasswordPage;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginPhoneIdlePage;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginPhonePage;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginSmsPage;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginPageKt;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginReportAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginState;
import tv.danmaku.bili.normal.ui.EulaTriggerType;
import tv.danmaku.bili.ui.login.FindPasswordDialog;
import tv.danmaku.bili.ui.loginv2.LoginFragmentV2;

/* compiled from: FullscreenLoginActivity.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\u0012\u0010\"\u001a\u00020\u0016*\u00020#H\u0082@¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0016H\u0002J\b\u0010&\u001a\u00020\u0016H\u0016J\b\u0010/\u001a\u00020\u001eH\u0016J\b\u00100\u001a\u00020\u0018H\u0016J\b\u00101\u001a\u000202H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\f\u001a\u0004\b*\u0010+R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Ltv/danmaku/bili/fullscreen/FullscreenLoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/bilibili/pvtracker/IPvTracker;", "<init>", "()V", "getResources", "Landroid/content/res/Resources;", "viewModel", "Ltv/danmaku/bili/fullscreen/FullscreenLoginViewModel;", "getViewModel", "()Ltv/danmaku/bili/fullscreen/FullscreenLoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "forgetPwdDialog", "Ltv/danmaku/bili/ui/login/FindPasswordDialog;", "getForgetPwdDialog", "()Ltv/danmaku/bili/ui/login/FindPasswordDialog;", "forgetPwdDialog$delegate", "clickEulaLinkListener2", "Ltv/danmaku/bili/eula/EulaLinkItemListener;", "clickEulaLinkListener3", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "registerInterceptedAction", "onForgetPwdClick", "routeTo", "url", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "", "registerToast", "registerLoginListener", "registerCaptchaDialog", "showCaptchaDialog", "Lcom/bilibili/lib/accountsui/captcha/CaptchaDialogV2;", "(Lcom/bilibili/lib/accountsui/captcha/CaptchaDialogV2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerEulaDialog", "finish", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "launcher$delegate", "onFindPasswordItemClickListener", "Ltv/danmaku/bili/ui/login/FindPasswordDialog$OnItemClickListener;", "getPvEventId", "getPvExtra", "shouldReport", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@AndroidEntryPoint
public final class FullscreenLoginActivity extends Hilt_FullscreenLoginActivity implements IPvTracker {
    public static final int $stable = 8;
    private EulaLinkItemListener clickEulaLinkListener2;
    private EulaLinkItemListener clickEulaLinkListener3;
    private final Lazy forgetPwdDialog$delegate;
    private final Lazy launcher$delegate;
    private final FindPasswordDialog.OnItemClickListener onFindPasswordItemClickListener;
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

    public FullscreenLoginActivity() {
        getDelegate().setLocalNightMode(MultipleThemeUtils.getCurrentNightMode((Context) this));
        final ComponentActivity $this$viewModels_u24default$iv = (ComponentActivity) this;
        Function0 factoryPromise$iv = new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginActivity$special$$inlined$viewModels$default$1
            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1036invoke() {
                return $this$viewModels_u24default$iv.getDefaultViewModelProviderFactory();
            }
        };
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(FullscreenLoginViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginActivity$special$$inlined$viewModels$default$2
            /* renamed from: invoke */
            public final ViewModelStore m1037invoke() {
                return $this$viewModels_u24default$iv.getViewModelStore();
            }
        }, factoryPromise$iv, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginActivity$special$$inlined$viewModels$default$3
            /* renamed from: invoke */
            public final CreationExtras m1038invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r1;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$viewModels_u24default$iv.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.forgetPwdDialog$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginActivity$$ExternalSyntheticLambda1
            public final Object invoke() {
                FindPasswordDialog forgetPwdDialog_delegate$lambda$0;
                forgetPwdDialog_delegate$lambda$0 = FullscreenLoginActivity.forgetPwdDialog_delegate$lambda$0(FullscreenLoginActivity.this);
                return forgetPwdDialog_delegate$lambda$0;
            }
        });
        this.clickEulaLinkListener2 = new EulaLinkItemListener() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginActivity$$ExternalSyntheticLambda2
            @Override // tv.danmaku.bili.eula.EulaLinkItemListener
            public final void onItemLinkClick(EulaLinkType eulaLinkType) {
                FullscreenLoginActivity.clickEulaLinkListener2$lambda$0(FullscreenLoginActivity.this, eulaLinkType);
            }
        };
        this.clickEulaLinkListener3 = new EulaLinkItemListener() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginActivity$$ExternalSyntheticLambda3
            @Override // tv.danmaku.bili.eula.EulaLinkItemListener
            public final void onItemLinkClick(EulaLinkType eulaLinkType) {
                FullscreenLoginActivity.clickEulaLinkListener3$lambda$0(FullscreenLoginActivity.this, eulaLinkType);
            }
        };
        this.launcher$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginActivity$$ExternalSyntheticLambda4
            public final Object invoke() {
                ActivityResultLauncher launcher_delegate$lambda$0;
                launcher_delegate$lambda$0 = FullscreenLoginActivity.launcher_delegate$lambda$0(FullscreenLoginActivity.this);
                return launcher_delegate$lambda$0;
            }
        });
        this.onFindPasswordItemClickListener = new FindPasswordDialog.OnItemClickListener() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginActivity$$ExternalSyntheticLambda5
            @Override // tv.danmaku.bili.ui.login.FindPasswordDialog.OnItemClickListener
            public final void onSelected(int i) {
                FullscreenLoginActivity.onFindPasswordItemClickListener$lambda$0(FullscreenLoginActivity.this, i);
            }
        };
    }

    public Resources getResources() {
        LimitTextSizeUtil limitTextSizeUtil = LimitTextSizeUtil.INSTANCE;
        Resources resources = super.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return limitTextSizeUtil.limitTextSize(resources);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FullscreenLoginViewModel getViewModel() {
        return (FullscreenLoginViewModel) this.viewModel$delegate.getValue();
    }

    private final FindPasswordDialog getForgetPwdDialog() {
        return (FindPasswordDialog) this.forgetPwdDialog$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FindPasswordDialog forgetPwdDialog_delegate$lambda$0(FullscreenLoginActivity this$0) {
        return new FindPasswordDialog((Context) this$0, this$0.onFindPasswordItemClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clickEulaLinkListener2$lambda$0(FullscreenLoginActivity this$0, EulaLinkType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getViewModel().dispatchAction(new IFullscreenLoginReportAction.EulaLinkClicked(it, true, EulaTriggerType.GetSms));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clickEulaLinkListener3$lambda$0(FullscreenLoginActivity this$0, EulaLinkType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getViewModel().dispatchAction(new IFullscreenLoginReportAction.EulaLinkClicked(it, true, EulaTriggerType.Submit));
    }

    @Override // tv.danmaku.bili.fullscreen.Hilt_FullscreenLoginActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundleExtra = getIntent().getBundleExtra(BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE);
        boolean skipCheck = Intrinsics.areEqual(bundleExtra != null ? bundleExtra.getString("skip_check") : null, "1");
        if (!BiliAccounts.get((Context) this).isLogin() || skipCheck) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new FullscreenLoginActivity$onCreate$1(this, null), 3, (Object) null);
            ComponentActivityKt.setContent$default((ComponentActivity) this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(-472439962, true, new Function2() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginActivity$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreate$lambda$0;
                    onCreate$lambda$0 = FullscreenLoginActivity.onCreate$lambda$0(FullscreenLoginActivity.this, (Composer) obj, ((Integer) obj2).intValue());
                    return onCreate$lambda$0;
                }
            }), 1, (Object) null);
            registerCaptchaDialog();
            registerLoginListener();
            registerToast();
            registerEulaDialog();
            registerInterceptedAction();
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new FullscreenLoginActivity$onCreate$3(this, null), 3, (Object) null);
            getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginActivity$onCreate$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(true);
                }

                public void handleOnBackPressed() {
                    if (!((IFullscreenLoginState) FullscreenLoginActivity.this.getViewModel().getState().getValue()).isRoot()) {
                        FullscreenLoginActivity.this.getViewModel().dispatchAction(IFullscreenLoginAction.BackToLastPage.INSTANCE);
                    } else {
                        FullscreenLoginActivity.this.finish();
                    }
                }
            });
            return;
        }
        BLog.w(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Already logged in");
        ToastHelper.showToastShort((Context) this, R.string.account_global_string_33);
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(final FullscreenLoginActivity this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C139@5741L34,140@5815L44,141@5888L910,141@5878L920,166@6860L185,166@6811L234,173@7080L73,173@7059L94,177@7200L138,177@7167L171:FullscreenLoginActivity.kt#8ty1lm");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-472439962, $changed, -1, "tv.danmaku.bili.fullscreen.FullscreenLoginActivity.onCreate.<anonymous> (FullscreenLoginActivity.kt:139)");
            }
            final SystemUiController controller = SystemUiControllerKt.rememberSystemUiController(this$0.getWindow(), $composer, 0, 0);
            final IFullscreenLoginState page = (IFullscreenLoginState) SnapshotStateKt.collectAsState(this$0.getViewModel().getState(), FullscreenLoginPhoneIdlePage.INSTANCE, (CoroutineContext) null, $composer, 48, 2).getValue();
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(122022174, true, new Function2() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginActivity$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreate$lambda$0$0;
                    onCreate$lambda$0$0 = FullscreenLoginActivity.onCreate$lambda$0$0(controller, page, this$0, (Composer) obj, ((Integer) obj2).intValue());
                    return onCreate$lambda$0$0;
                }
            }, $composer, 54), $composer, (int) BR.negativeBtnVisible, 3);
            Boolean valueOf = Boolean.valueOf(page.getCurrentPage().getLoggedIn());
            ComposerKt.sourceInformationMarkerStart($composer, 1251766879, "CC(remember):FullscreenLoginActivity.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(page) | $composer.changedInstance(this$0);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new FullscreenLoginActivity$onCreate$2$2$1(page, this$0, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer, 0);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1251773807, "CC(remember):FullscreenLoginActivity.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new FullscreenLoginActivity$onCreate$2$3$1(null);
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer, 6);
            IFullscreenLoginPage currentPage = page.getCurrentPage();
            ComposerKt.sourceInformationMarkerStart($composer, 1251777712, "CC(remember):FullscreenLoginActivity.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance(page) | $composer.changedInstance(this$0);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new FullscreenLoginActivity$onCreate$2$4$1(page, this$0, null);
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(currentPage, (Function2) it$iv3, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x01ec, code lost:
        if (r7 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0227, code lost:
        if (r7 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit onCreate$lambda$0$0(SystemUiController $controller, IFullscreenLoginState $page, FullscreenLoginActivity this$0, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        boolean invalid$iv;
        boolean invalid$iv2;
        State loading;
        ComposerKt.sourceInformation($composer, "C142@5930L6,143@5978L77,143@5957L98,146@6072L712:FullscreenLoginActivity.kt#8ty1lm");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(122022174, $changed, -1, "tv.danmaku.bili.fullscreen.FullscreenLoginActivity.onCreate.<anonymous>.<anonymous> (FullscreenLoginActivity.kt:142)");
            }
            long bgColor = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU();
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1299195179, "CC(remember):FullscreenLoginActivity.kt#9igjgp");
            boolean invalid$iv3 = $composer.changed($controller) | $composer.changed(bgColor);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv3 || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new FullscreenLoginActivity$onCreate$2$1$1$1($controller, bgColor, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer, 6);
            Modifier modifier$iv = WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.background-bw27NRU$default(Modifier.Companion, bgColor, (Shape) null, 2, (Object) null));
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
            ComposerKt.sourceInformationMarkerStart($composer, -1268434484, "C153@6348L25,154@6409L9,155@6463L18,151@6255L248,158@6561L21:FullscreenLoginActivity.kt#8ty1lm");
            FullscreenLoginViewModel viewModel = this$0.getViewModel();
            ComposerKt.sourceInformationMarkerStart($composer, 513274577, "CC(remember):FullscreenLoginActivity.kt#9igjgp");
            boolean invalid$iv4 = $composer.changedInstance(viewModel);
            Object it$iv2 = $composer.rememberedValue();
            if (!invalid$iv4 && it$iv2 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer);
                Function1 function1 = (KFunction) it$iv2;
                ComposerKt.sourceInformationMarkerStart($composer, 513276513, "CC(remember):FullscreenLoginActivity.kt#9igjgp");
                invalid$iv = $composer.changedInstance(this$0);
                Object it$iv3 = $composer.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv2 = (KFunction) new FullscreenLoginActivity$onCreate$2$1$2$2$1(this$0);
                $composer.updateRememberedValue(value$iv2);
                it$iv3 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Function1 function12 = (KFunction) it$iv3;
                ComposerKt.sourceInformationMarkerStart($composer, 513278250, "CC(remember):FullscreenLoginActivity.kt#9igjgp");
                invalid$iv2 = $composer.changedInstance(this$0);
                Object it$iv4 = $composer.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv3 = (KFunction) new FullscreenLoginActivity$onCreate$2$1$2$3$1(this$0);
                $composer.updateRememberedValue(value$iv3);
                it$iv4 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer);
                FullscreenLoginPageKt.FullscreenLoginPage($page, function1, function12, (KFunction) it$iv4, $composer, 0);
                loading = SnapshotStateKt.collectAsState(this$0.getViewModel().getDialogState(), false, (CoroutineContext) null, $composer, 48, 2);
                if (((Boolean) loading.getValue()).booleanValue()) {
                    $composer.startReplaceGroup(-1274656278);
                } else {
                    $composer.startReplaceGroup(-1268081798);
                    ComposerKt.sourceInformation($composer, "160@6648L96");
                    LoadingKt.Loading(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, $composer, 6, 2);
                }
                $composer.endReplaceGroup();
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
            Object value$iv4 = (KFunction) new FullscreenLoginActivity$onCreate$2$1$2$1$1(viewModel);
            $composer.updateRememberedValue(value$iv4);
            it$iv2 = value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Function1 function13 = (KFunction) it$iv2;
            ComposerKt.sourceInformationMarkerStart($composer, 513276513, "CC(remember):FullscreenLoginActivity.kt#9igjgp");
            invalid$iv = $composer.changedInstance(this$0);
            Object it$iv32 = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv22 = (KFunction) new FullscreenLoginActivity$onCreate$2$1$2$2$1(this$0);
            $composer.updateRememberedValue(value$iv22);
            it$iv32 = value$iv22;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Function1 function122 = (KFunction) it$iv32;
            ComposerKt.sourceInformationMarkerStart($composer, 513278250, "CC(remember):FullscreenLoginActivity.kt#9igjgp");
            invalid$iv2 = $composer.changedInstance(this$0);
            Object it$iv42 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv32 = (KFunction) new FullscreenLoginActivity$onCreate$2$1$2$3$1(this$0);
            $composer.updateRememberedValue(value$iv32);
            it$iv42 = value$iv32;
            ComposerKt.sourceInformationMarkerEnd($composer);
            FullscreenLoginPageKt.FullscreenLoginPage($page, function13, function122, (KFunction) it$iv42, $composer, 0);
            loading = SnapshotStateKt.collectAsState(this$0.getViewModel().getDialogState(), false, (CoroutineContext) null, $composer, 48, 2);
            if (((Boolean) loading.getValue()).booleanValue()) {
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        return Unit.INSTANCE;
    }

    private final void registerInterceptedAction() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new FullscreenLoginActivity$registerInterceptedAction$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onForgetPwdClick() {
        getViewModel().dispatchAction(IFullscreenLoginReportAction.LoginForgetClick.INSTANCE);
        if (!getForgetPwdDialog().isShowing()) {
            getForgetPwdDialog().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void routeTo(IAccountRedirect url) {
        Intent it;
        BLog.i("FullscreenLoginActivity", "Route to " + url);
        if (url != null && (it = url.getIntent((Context) this)) != null) {
            startActivity(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void routeTo(String url) {
        BLog.i("FullscreenLoginActivity", "Route to " + url);
        BLRouter.routeTo(RouteRequestKt.toRouteRequest(url), (Context) this);
    }

    private final void registerToast() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new FullscreenLoginActivity$registerToast$1(this, null), 3, (Object) null);
    }

    private final void registerLoginListener() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new FullscreenLoginActivity$registerLoginListener$1(this, null), 3, (Object) null);
    }

    private final void registerCaptchaDialog() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new FullscreenLoginActivity$registerCaptchaDialog$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showCaptchaDialog(final CaptchaDialogV2 $this$showCaptchaDialog, Continuation<? super Unit> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation it = cancellableContinuationImpl;
        getViewModel().dispatchAction(IFullscreenLoginReportAction.ShowCaptchaDialog.INSTANCE);
        it.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginActivity$showCaptchaDialog$2$1
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

    private final void registerEulaDialog() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new FullscreenLoginActivity$registerEulaDialog$1(this, null), 3, (Object) null);
    }

    public void finish() {
        boolean canFinish;
        LoginExpType group = getViewModel().getLoginExpGroup();
        IFullscreenLoginState iFullscreenLoginState = (IFullscreenLoginState) getViewModel().getState().getValue();
        if (iFullscreenLoginState instanceof FullscreenLoginPasswordPage) {
            canFinish = group.getSmsSkippable();
        } else if (iFullscreenLoginState instanceof FullscreenLoginSmsPage) {
            canFinish = group.getSmsSkippable();
        } else if (iFullscreenLoginState instanceof FullscreenLoginPhonePage) {
            canFinish = false;
        } else if (Intrinsics.areEqual(iFullscreenLoginState, FullscreenLoginPhoneIdlePage.INSTANCE)) {
            canFinish = false;
        } else if (Intrinsics.areEqual(iFullscreenLoginState, FullscreenLoginInvalidPage.INSTANCE)) {
            canFinish = false;
        } else {
            canFinish = iFullscreenLoginState instanceof FullscreenLoginIdlePage ? group.getSmsSkippable() : true;
        }
        if (canFinish) {
            super.finish();
        }
    }

    private final ActivityResultLauncher<Intent> getLauncher() {
        return (ActivityResultLauncher) this.launcher$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActivityResultLauncher launcher_delegate$lambda$0(FullscreenLoginActivity this$0) {
        return this$0.registerForActivityResult((ActivityResultContract) new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginActivity$$ExternalSyntheticLambda6
            public final void onActivityResult(Object obj) {
                FullscreenLoginActivity.launcher_delegate$lambda$0$0((ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launcher_delegate$lambda$0$0(ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFindPasswordItemClickListener$lambda$0(FullscreenLoginActivity this$0, int itemId) {
        switch (itemId) {
            case 1:
                this$0.getViewModel().dispatchAction(new IFullscreenLoginAction.SwitchToSms(false));
                this$0.getViewModel().dispatchAction(IFullscreenLoginReportAction.FindPwdByPhone.INSTANCE);
                return;
            case 2:
                String url = H5UrlConfigHelper.INSTANCE.getUrl("account_ui", "url_find_password", LoginFragmentV2.URL_FIND_PASSWORD);
                this$0.getViewModel().dispatchAction(IFullscreenLoginReportAction.FindPwdByEMail.INSTANCE);
                Uri parse = Uri.parse(url);
                Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                BLRouter.routeTo(new RouteRequest.Builder(parse).build(), (Context) this$0);
                return;
            default:
                return;
        }
    }

    public String getPvEventId() {
        return "app.login.0.0.pv";
    }

    public Bundle getPvExtra() {
        Bundle $this$getPvExtra_u24lambda_u240 = new Bundle();
        Map it = LoginReportService.getReportParamMap$default(getViewModel().getLoginReportService(), ((IFullscreenLoginState) getViewModel().getState().getValue()).getLoginType(), null, 2, null);
        Iterable $this$forEach$iv = it.keySet();
        for (Object element$iv : $this$forEach$iv) {
            String k = (String) element$iv;
            $this$getPvExtra_u24lambda_u240.putString(k, (String) it.get(k));
        }
        return $this$getPvExtra_u24lambda_u240;
    }

    public boolean shouldReport() {
        return !(getViewModel().getState().getValue() instanceof FullscreenLoginPhoneIdlePage);
    }
}