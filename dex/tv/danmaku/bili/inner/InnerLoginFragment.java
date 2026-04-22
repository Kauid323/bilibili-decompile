package tv.danmaku.bili.inner;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.compose.ui.semantics.Role;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.droid.BundleUtil;
import com.bilibili.lib.accountsui.captcha.CaptchaDialogV2;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.blrouter.extra.ActivityResult;
import com.bilibili.lib.blrouter.extra.BLRouterStartActivityForResult;
import com.bilibili.lib.ui.mixin.IFragmentShowHideKt;
import com.bilibili.pvtracker.IPvTracker;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.eula.EulaLinkItemListener;
import tv.danmaku.bili.eula.EulaLinkType;
import tv.danmaku.bili.fullscreen.CountryCodeSelectActivity;
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;
import tv.danmaku.bili.fullscreen.route.ValidLoginType;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.stat.Facebook;
import tv.danmaku.bili.fullscreen.stat.Google;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginPhoneIdlePage;
import tv.danmaku.bili.fullscreen.state.FullscreenOverseaPage;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginReportAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginState;
import tv.danmaku.bili.fullscreen.state.ISmsLoginAction;
import tv.danmaku.bili.fullscreen.state.SmsLoginInput;
import tv.danmaku.bili.httpdns.api.ConstsKt;
import tv.danmaku.bili.inner.ui.InnerLoginPageKt;
import tv.danmaku.bili.normal.ui.EulaTriggerType;

/* compiled from: InnerLoginFragment.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J0\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f*\u00020!2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002J\u0012\u0010'\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u001bH\u0002J\b\u0010.\u001a\u00020\u001bH\u0002J\b\u0010/\u001a\u00020\u001bH\u0002J\u0012\u00100\u001a\u00020\u001b*\u000201H\u0082@¢\u0006\u0002\u00102J\b\u00103\u001a\u00020\u001bH\u0002J\b\u00104\u001a\u00020\fH\u0016J\b\u00105\u001a\u00020\u0019H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Ltv/danmaku/bili/inner/InnerLoginFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bilibili/pvtracker/IPvTracker;", "<init>", "()V", "viewModel", "Ltv/danmaku/bili/inner/InnerLoginViewModel;", "getViewModel", "()Ltv/danmaku/bili/inner/InnerLoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "fromSpmid", "", "enableAutoFullscreenLogin", "", "clickEulaLinkListener2", "Ltv/danmaku/bili/eula/EulaLinkItemListener;", "clickEulaLinkListener3", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "routeToCountrySelect", "", "input", "Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "routerForResult", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/bilibili/lib/blrouter/RouteRequest;", "Landroidx/activity/ComponentActivity;", "requestKey", "request", AuthResultCbHelper.ARGS_CALLBACK, "Landroidx/activity/result/ActivityResultCallback;", "Lcom/bilibili/lib/blrouter/extra/ActivityResult;", "routeTo", "url", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "routeToLogin", "preferredType", "Ltv/danmaku/bili/fullscreen/route/ValidLoginType;", "registerToast", "registerLoadingDialog", "registerCaptchaDialog", "showCaptchaDialog", "Lcom/bilibili/lib/accountsui/captcha/CaptchaDialogV2;", "(Lcom/bilibili/lib/accountsui/captcha/CaptchaDialogV2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerEulaDialog", "getPvEventId", "getPvExtra", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@AndroidEntryPoint
public final class InnerLoginFragment extends Hilt_InnerLoginFragment implements IPvTracker {
    public static final int $stable = 8;
    private EulaLinkItemListener clickEulaLinkListener2;
    private EulaLinkItemListener clickEulaLinkListener3;
    private boolean enableAutoFullscreenLogin;
    private String fromSpmid;
    private final Lazy viewModel$delegate;

    /* compiled from: InnerLoginFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ValidLoginType.values().length];
            try {
                iArr[ValidLoginType.SmsLogin.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ValidLoginType.PwdLogin.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    public InnerLoginFragment() {
        final Fragment $this$viewModels_u24default$iv = (Fragment) this;
        final Function0 ownerProducer$iv = new Function0<Fragment>() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final Fragment m1148invoke() {
                return $this$viewModels_u24default$iv;
            }
        };
        final Lazy owner$delegate$iv = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStoreOwner m1149invoke() {
                return (ViewModelStoreOwner) ownerProducer$iv.invoke();
            }
        });
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$viewModels_u24default$iv, Reflection.getOrCreateKotlinClass(InnerLoginViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1150invoke() {
                return FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1151invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                if (function0 != null && (creationExtras = (CreationExtras) function0.invoke()) != null) {
                    return creationExtras;
                }
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                return hasDefaultViewModelProviderFactory2 != null ? hasDefaultViewModelProviderFactory2.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1152invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                if (hasDefaultViewModelProviderFactory2 != null && (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory2.getDefaultViewModelProviderFactory()) != null) {
                    return defaultViewModelProviderFactory;
                }
                return $this$viewModels_u24default$iv.getDefaultViewModelProviderFactory();
            }
        });
        this.clickEulaLinkListener2 = new EulaLinkItemListener() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$$ExternalSyntheticLambda4
            @Override // tv.danmaku.bili.eula.EulaLinkItemListener
            public final void onItemLinkClick(EulaLinkType eulaLinkType) {
                InnerLoginFragment.clickEulaLinkListener2$lambda$0(InnerLoginFragment.this, eulaLinkType);
            }
        };
        this.clickEulaLinkListener3 = new EulaLinkItemListener() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$$ExternalSyntheticLambda5
            @Override // tv.danmaku.bili.eula.EulaLinkItemListener
            public final void onItemLinkClick(EulaLinkType eulaLinkType) {
                InnerLoginFragment.clickEulaLinkListener3$lambda$0(InnerLoginFragment.this, eulaLinkType);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InnerLoginViewModel getViewModel() {
        return (InnerLoginViewModel) this.viewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clickEulaLinkListener2$lambda$0(InnerLoginFragment this$0, EulaLinkType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getViewModel().dispatchAction(new IFullscreenLoginReportAction.EulaLinkClicked(it, true, EulaTriggerType.GetSms));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clickEulaLinkListener3$lambda$0(InnerLoginFragment this$0, EulaLinkType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getViewModel().dispatchAction(new IFullscreenLoginReportAction.EulaLinkClicked(it, true, EulaTriggerType.Submit));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle arguments = getArguments();
        this.fromSpmid = arguments != null ? arguments.getString("from_spmid") : null;
        Bundle arguments2 = getArguments();
        this.enableAutoFullscreenLogin = arguments2 != null ? arguments2.getBoolean(InnerLoginFragmentKt.KEY_ENABLE_AUTO_FULLSCREEN_LOGIN) : false;
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        View composeView = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-1729536457, true, new Function2() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit onCreateView$lambda$0$0;
                onCreateView$lambda$0$0 = InnerLoginFragment.onCreateView$lambda$0$0(InnerLoginFragment.this, (Composer) obj, ((Integer) obj2).intValue());
                return onCreateView$lambda$0$0;
            }
        }));
        registerLoadingDialog();
        registerCaptchaDialog();
        registerToast();
        registerEulaDialog();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new InnerLoginFragment$onCreateView$1$2(this, null), 3, (Object) null);
        return composeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0(final InnerLoginFragment this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C121@4946L44,123@5024L4318,123@5014L4328:InnerLoginFragment.kt#m5nw15");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1729536457, $changed, -1, "tv.danmaku.bili.inner.InnerLoginFragment.onCreateView.<anonymous>.<anonymous> (InnerLoginFragment.kt:121)");
            }
            final IFullscreenLoginState page = (IFullscreenLoginState) SnapshotStateKt.collectAsState(this$0.getViewModel().getState(), FullscreenLoginPhoneIdlePage.INSTANCE, (CoroutineContext) null, $composer, 48, 2).getValue();
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(958730111, true, new Function2() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreateView$lambda$0$0$0;
                    onCreateView$lambda$0$0$0 = InnerLoginFragment.onCreateView$lambda$0$0$0(IFullscreenLoginState.this, this$0, (Composer) obj, ((Integer) obj2).intValue());
                    return onCreateView$lambda$0$0$0;
                }
            }, $composer, 54), $composer, (int) BR.negativeBtnVisible, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0238, code lost:
        if (r5 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0271, code lost:
        if (r5 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x02a8, code lost:
        if (r7 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit onCreateView$lambda$0$0$0(IFullscreenLoginState $page, final InnerLoginFragment this$0, Composer $composer, int $changed) {
        Object it$iv;
        boolean invalid$iv;
        boolean invalid$iv2;
        boolean invalid$iv3;
        ComposerKt.sourceInformation($composer, "C124@5070L6,130@5334L39,132@5455L72,125@5101L4223:InnerLoginFragment.kt#m5nw15");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(958730111, $changed, -1, "tv.danmaku.bili.inner.InnerLoginFragment.onCreateView.<anonymous>.<anonymous>.<anonymous> (InnerLoginFragment.kt:124)");
            }
            long bgColor = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU();
            Modifier modifier = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), bgColor, (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -2078322010, "CC(remember):InnerLoginFragment.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer.updateRememberedValue(value$iv);
                it$iv2 = value$iv;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -2078318105, "CC(remember):InnerLoginFragment.kt#9igjgp");
            Object it$iv3 = $composer.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv3 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = ClickableKt.clickable-O2vRcR0$default(modifier, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv3, 28, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                $composer.createNode(factory$iv$iv$iv);
            } else {
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
            ComposerKt.sourceInformationMarkerStart($composer, -1050042131, "C139@5733L25,140@5798L49,141@5892L1167,160@7116L156,164@7324L1952,137@5637L3665:InnerLoginFragment.kt#m5nw15");
            InnerLoginViewModel viewModel = this$0.getViewModel();
            ComposerKt.sourceInformationMarkerStart($composer, 935958430, "CC(remember):InnerLoginFragment.kt#9igjgp");
            boolean invalid$iv4 = $composer.changedInstance(viewModel);
            Object it$iv4 = $composer.rememberedValue();
            if (!invalid$iv4 && it$iv4 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer);
                Function1 function1 = (KFunction) it$iv4;
                ComposerKt.sourceInformationMarkerStart($composer, 935960534, "CC(remember):InnerLoginFragment.kt#9igjgp");
                it$iv = $composer.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$$ExternalSyntheticLambda10
                        public final Object invoke(Object obj) {
                            Unit onCreateView$lambda$0$0$0$2$1$0;
                            onCreateView$lambda$0$0$0$2$1$0 = InnerLoginFragment.onCreateView$lambda$0$0$0$2$1$0((String) obj);
                            return onCreateView$lambda$0$0$0$2$1$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv3);
                    it$iv = value$iv3;
                }
                Function1 function12 = (Function1) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 935964660, "CC(remember):InnerLoginFragment.kt#9igjgp");
                invalid$iv = $composer.changedInstance(this$0);
                Object it$iv5 = $composer.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv4 = new Function2() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$$ExternalSyntheticLambda11
                    public final Object invoke(Object obj, Object obj2) {
                        Unit onCreateView$lambda$0$0$0$2$2$0;
                        onCreateView$lambda$0$0$0$2$2$0 = InnerLoginFragment.onCreateView$lambda$0$0$0$2$2$0(InnerLoginFragment.this, (ValidLoginType) obj, ((Boolean) obj2).booleanValue());
                        return onCreateView$lambda$0$0$0$2$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv5 = value$iv4;
                Function2 function2 = (Function2) it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 936002817, "CC(remember):InnerLoginFragment.kt#9igjgp");
                invalid$iv2 = $composer.changedInstance(this$0);
                Object it$iv6 = $composer.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv5 = new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit onCreateView$lambda$0$0$0$2$3$0;
                        onCreateView$lambda$0$0$0$2$3$0 = InnerLoginFragment.onCreateView$lambda$0$0$0$2$3$0(InnerLoginFragment.this, (SmsLoginInput) obj);
                        return onCreateView$lambda$0$0$0$2$3$0;
                    }
                };
                $composer.updateRememberedValue(value$iv5);
                it$iv6 = value$iv5;
                Function1 function13 = (Function1) it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 936011269, "CC(remember):InnerLoginFragment.kt#9igjgp");
                invalid$iv3 = $composer.changedInstance(this$0);
                Object it$iv7 = $composer.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv6 = new Function2() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        Unit onCreateView$lambda$0$0$0$2$4$0;
                        onCreateView$lambda$0$0$0$2$4$0 = InnerLoginFragment.onCreateView$lambda$0$0$0$2$4$0(InnerLoginFragment.this, ((Boolean) obj).booleanValue(), (LoginWay) obj2);
                        return onCreateView$lambda$0$0$0$2$4$0;
                    }
                };
                $composer.updateRememberedValue(value$iv6);
                it$iv7 = value$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer);
                InnerLoginPageKt.InnerLoginPage($page, function1, function12, function2, function13, (Function2) it$iv7, $composer, BR.negativeBtnVisible, 0);
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
            Object value$iv7 = (KFunction) new InnerLoginFragment$onCreateView$1$1$1$3$1$1(viewModel);
            $composer.updateRememberedValue(value$iv7);
            it$iv4 = value$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Function1 function14 = (KFunction) it$iv4;
            ComposerKt.sourceInformationMarkerStart($composer, 935960534, "CC(remember):InnerLoginFragment.kt#9igjgp");
            it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
            }
            Function1 function122 = (Function1) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 935964660, "CC(remember):InnerLoginFragment.kt#9igjgp");
            invalid$iv = $composer.changedInstance(this$0);
            Object it$iv52 = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv42 = new Function2() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreateView$lambda$0$0$0$2$2$0;
                    onCreateView$lambda$0$0$0$2$2$0 = InnerLoginFragment.onCreateView$lambda$0$0$0$2$2$0(InnerLoginFragment.this, (ValidLoginType) obj, ((Boolean) obj2).booleanValue());
                    return onCreateView$lambda$0$0$0$2$2$0;
                }
            };
            $composer.updateRememberedValue(value$iv42);
            it$iv52 = value$iv42;
            Function2 function22 = (Function2) it$iv52;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 936002817, "CC(remember):InnerLoginFragment.kt#9igjgp");
            invalid$iv2 = $composer.changedInstance(this$0);
            Object it$iv62 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv52 = new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit onCreateView$lambda$0$0$0$2$3$0;
                    onCreateView$lambda$0$0$0$2$3$0 = InnerLoginFragment.onCreateView$lambda$0$0$0$2$3$0(InnerLoginFragment.this, (SmsLoginInput) obj);
                    return onCreateView$lambda$0$0$0$2$3$0;
                }
            };
            $composer.updateRememberedValue(value$iv52);
            it$iv62 = value$iv52;
            Function1 function132 = (Function1) it$iv62;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 936011269, "CC(remember):InnerLoginFragment.kt#9igjgp");
            invalid$iv3 = $composer.changedInstance(this$0);
            Object it$iv72 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv62 = new Function2() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreateView$lambda$0$0$0$2$4$0;
                    onCreateView$lambda$0$0$0$2$4$0 = InnerLoginFragment.onCreateView$lambda$0$0$0$2$4$0(InnerLoginFragment.this, ((Boolean) obj).booleanValue(), (LoginWay) obj2);
                    return onCreateView$lambda$0$0$0$2$4$0;
                }
            };
            $composer.updateRememberedValue(value$iv62);
            it$iv72 = value$iv62;
            ComposerKt.sourceInformationMarkerEnd($composer);
            InnerLoginPageKt.InnerLoginPage($page, function14, function122, function22, function132, (Function2) it$iv72, $composer, BR.negativeBtnVisible, 0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$2$1$0(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        BLRouter.routeTo$default(RouteRequestKt.toRouteRequest(url), (Context) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$2$2$0(InnerLoginFragment this$0, ValidLoginType type, boolean fromClick) {
        String str;
        Intrinsics.checkNotNullParameter(type, "type");
        if (fromClick) {
            LoginReportService loginReportService = this$0.getViewModel().getLoginReportService();
            String loginType = ((IFullscreenLoginState) this$0.getViewModel().getState().getValue()).getLoginType();
            Pair<String, String>[] pairArr = new Pair[2];
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    str = "sms";
                    break;
                case 2:
                    str = "pwd";
                    break;
                default:
                    str = "other";
                    break;
            }
            pairArr[0] = TuplesKt.to("type", str);
            pairArr[1] = TuplesKt.to("is_oversea", this$0.getViewModel().getState().getValue() instanceof FullscreenOverseaPage ? "1" : "0");
            loginReportService.report("app.login.switch-option.0.click", loginType, pairArr);
            this$0.routeToLogin(type);
        } else if (this$0.enableAutoFullscreenLogin && IFragmentShowHideKt.isFragmentShown((Fragment) this$0)) {
            this$0.routeToLogin(type);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$2$3$0(InnerLoginFragment this$0, SmsLoginInput input) {
        Intrinsics.checkNotNullParameter(input, "input");
        this$0.routeToCountrySelect(input);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$2$4$0(InnerLoginFragment this$0, boolean login, LoginWay way) {
        String str;
        IFullscreenLoginAction action;
        IFullscreenLoginAction action2;
        Intrinsics.checkNotNullParameter(way, "way");
        LoginReportService loginReportService = this$0.getViewModel().getLoginReportService();
        String loginType = ((IFullscreenLoginState) this$0.getViewModel().getState().getValue()).getLoginType();
        Pair<String, String>[] pairArr = new Pair[2];
        if (Intrinsics.areEqual(way, Google.GoogleLogin.INSTANCE)) {
            str = ConstsKt.SP_GOOGLE;
        } else {
            str = Intrinsics.areEqual(way, Facebook.FacebookLogin.INSTANCE) ? "facebook" : "other";
        }
        pairArr[0] = TuplesKt.to("type", str);
        pairArr[1] = TuplesKt.to("is_oversea", "1");
        loginReportService.report("app.login.switch-option.0.click", loginType, pairArr);
        if (Intrinsics.areEqual(way, Google.GoogleLogin.INSTANCE)) {
            if (login) {
                action2 = IFullscreenLoginAction.GoogleLogin.INSTANCE;
            } else {
                action2 = new IFullscreenLoginAction.ShowEulaAction(EulaTriggerType.Google);
            }
            this$0.getViewModel().dispatchAction(action2);
        } else if (Intrinsics.areEqual(way, Facebook.FacebookLogin.INSTANCE)) {
            if (login) {
                action = IFullscreenLoginAction.FacebookLogin.INSTANCE;
            } else {
                action = new IFullscreenLoginAction.ShowEulaAction(EulaTriggerType.Facebook);
            }
            this$0.getViewModel().dispatchAction(action);
        }
        return Unit.INSTANCE;
    }

    private final void routeToCountrySelect(final SmsLoginInput input) {
        final Bundle args = new Bundle();
        args.putParcelable(CountryCodeSelectActivity.KEY_COUNTRY_CODE, input.getAvailableCountryCode());
        getViewModel().dispatchAction(ISmsLoginAction.SelectCountryCode.INSTANCE);
        RouteRequest request = new RouteRequest.Builder(CountryCodeSelectActivity.ROUTE_COUNTRY_CODE_SELECT).extras(new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit routeToCountrySelect$lambda$0;
                routeToCountrySelect$lambda$0 = InnerLoginFragment.routeToCountrySelect$lambda$0(args, (MutableBundleLike) obj);
                return routeToCountrySelect$lambda$0;
            }
        }).build();
        FragmentActivity activity = getActivity();
        ComponentActivity componentActivity = activity instanceof ComponentActivity ? (ComponentActivity) activity : null;
        if (componentActivity == null || routerForResult(componentActivity, CountryCodeSelectActivity.KEY_COUNTRY_CODE, request, new ActivityResultCallback() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$$ExternalSyntheticLambda7
            public final void onActivityResult(Object obj) {
                InnerLoginFragment.routeToCountrySelect$lambda$1(InnerLoginFragment.this, input, (ActivityResult) obj);
            }
        }) == null) {
            getViewModel().dispatchAction(ISmsLoginAction.OnCountryCodeSelectCancel.INSTANCE);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit routeToCountrySelect$lambda$0(Bundle $args, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
        Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
        $this$extras.put(str, $args);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void routeToCountrySelect$lambda$1(InnerLoginFragment this$0, SmsLoginInput $input, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        boolean selected = false;
        if (it.getResultCode() == -1) {
            Intent data = it.getData();
            PhoneCountryCode code = data != null ? (PhoneCountryCode) data.getParcelableExtra(CountryCodeSelectActivity.KEY_COUNTRY_CODE) : null;
            if (code != null) {
                selected = true;
                this$0.getViewModel().dispatchAction(new ISmsLoginAction.OnCountryCodeSelected($input, code));
            }
        }
        if (!selected) {
            this$0.getViewModel().dispatchAction(ISmsLoginAction.OnCountryCodeSelectCancel.INSTANCE);
        }
    }

    private final ActivityResultLauncher<RouteRequest> routerForResult(final ComponentActivity $this$routerForResult, String requestKey, RouteRequest request, final ActivityResultCallback<ActivityResult> activityResultCallback) {
        ActivityResultLauncher launcher = $this$routerForResult.getActivityResultRegistry().register(requestKey, BLRouterStartActivityForResult.INSTANCE, new ActivityResultCallback() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$$ExternalSyntheticLambda3
            public final void onActivityResult(Object obj) {
                InnerLoginFragment.routerForResult$lambda$0($this$routerForResult, activityResultCallback, (ActivityResult) obj);
            }
        });
        launcher.launch(request);
        return launcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void routerForResult$lambda$0(ComponentActivity $this_routerForResult, ActivityResultCallback $callback, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!$this_routerForResult.isFinishing() && !$this_routerForResult.isDestroyed()) {
            $callback.onActivityResult(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void routeTo(IAccountRedirect url) {
        BLog.i(InnerLoginViewModelKt.TAG_INNER_LOGIN, "Route to " + url);
        if (url != null) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            Intent it = url.getIntent(requireContext);
            if (it != null) {
                startActivity(it);
            }
        }
    }

    private final void routeToLogin(ValidLoginType preferredType) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new InnerLoginFragment$routeToLogin$1(preferredType, this, null), 3, (Object) null);
    }

    private final void registerToast() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new InnerLoginFragment$registerToast$1(this, null), 3, (Object) null);
    }

    private final void registerLoadingDialog() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new InnerLoginFragment$registerLoadingDialog$1(this, null), 3, (Object) null);
    }

    private final void registerCaptchaDialog() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new InnerLoginFragment$registerCaptchaDialog$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showCaptchaDialog(final CaptchaDialogV2 $this$showCaptchaDialog, Continuation<? super Unit> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation it = cancellableContinuationImpl;
        getViewModel().dispatchAction(IFullscreenLoginReportAction.ShowCaptchaDialog.INSTANCE);
        it.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$showCaptchaDialog$2$1
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
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new InnerLoginFragment$registerEulaDialog$1(this, null), 3, (Object) null);
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
            String v = (String) it.get(k);
            if (!StringsKt.isBlank(k)) {
                boolean z = false;
                if (v != null && (!StringsKt.isBlank(v))) {
                    z = true;
                }
                if (z) {
                    $this$getPvExtra_u24lambda_u240.putString(k, (String) it.get(k));
                }
            }
        }
        return $this$getPvExtra_u24lambda_u240;
    }
}