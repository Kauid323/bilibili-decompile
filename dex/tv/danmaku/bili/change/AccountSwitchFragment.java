package tv.danmaku.bili.change;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import bili.resource.account.R;
import com.bilibili.app.comm.list.widget.dialog.LoadingDialog;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.spy.generated.androidx_fragment_app_Fragment;
import com.bilibili.pvtracker.IPvTracker;
import com.google.accompanist.systemuicontroller.SystemUiController;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.helper.LoginLifecycleObserver;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;
import tv.danmaku.bili.report.LoginReportHelper;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: AccountSwitchFragment.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\u0012\u0010\"\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011¨\u0006%"}, d2 = {"Ltv/danmaku/bili/change/AccountSwitchFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bilibili/pvtracker/IPvTracker;", "Lcom/bilibili/lib/accounts/subscribe/PassportObserver;", "<init>", "()V", FavoritesConstsKt.SPMID, "", "viewModel", "Ltv/danmaku/bili/change/AccountSwitchViewModel;", "getViewModel", "()Ltv/danmaku/bili/change/AccountSwitchViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "loadingDialog", "Lcom/bilibili/app/comm/list/widget/dialog/LoadingDialog;", "getLoadingDialog", "()Lcom/bilibili/app/comm/list/widget/dialog/LoadingDialog;", "loadingDialog$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroy", "getPvEventId", "getPvExtra", "onChange", "topic", "Lcom/bilibili/lib/accounts/subscribe/Topic;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AccountSwitchFragment extends androidx_fragment_app_Fragment implements IPvTracker, PassportObserver {
    public static final int $stable = 8;
    private final Lazy loadingDialog$delegate;
    private final String spmid = OnePassLoginReportManagerKt.SPM_ID_CHANGE_ACCOUNT;
    private final Lazy viewModel$delegate;

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    public AccountSwitchFragment() {
        final Fragment $this$viewModels_u24default$iv = (Fragment) this;
        final Function0 ownerProducer$iv = new Function0<Fragment>() { // from class: tv.danmaku.bili.change.AccountSwitchFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final Fragment m754invoke() {
                return $this$viewModels_u24default$iv;
            }
        };
        final Lazy owner$delegate$iv = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: tv.danmaku.bili.change.AccountSwitchFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStoreOwner m755invoke() {
                return (ViewModelStoreOwner) ownerProducer$iv.invoke();
            }
        });
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$viewModels_u24default$iv, Reflection.getOrCreateKotlinClass(AccountSwitchViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.change.AccountSwitchFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m756invoke() {
                return FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.change.AccountSwitchFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m757invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                if (function0 != null && (creationExtras = (CreationExtras) function0.invoke()) != null) {
                    return creationExtras;
                }
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                return hasDefaultViewModelProviderFactory2 != null ? hasDefaultViewModelProviderFactory2.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.change.AccountSwitchFragment$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m758invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                if (hasDefaultViewModelProviderFactory2 != null && (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory2.getDefaultViewModelProviderFactory()) != null) {
                    return defaultViewModelProviderFactory;
                }
                return $this$viewModels_u24default$iv.getDefaultViewModelProviderFactory();
            }
        });
        this.loadingDialog$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.change.AccountSwitchFragment$$ExternalSyntheticLambda2
            public final Object invoke() {
                LoadingDialog loadingDialog_delegate$lambda$0;
                loadingDialog_delegate$lambda$0 = AccountSwitchFragment.loadingDialog_delegate$lambda$0(AccountSwitchFragment.this);
                return loadingDialog_delegate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AccountSwitchViewModel getViewModel() {
        return (AccountSwitchViewModel) this.viewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoadingDialog getLoadingDialog() {
        return (LoadingDialog) this.loadingDialog$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LoadingDialog loadingDialog_delegate$lambda$0(AccountSwitchFragment this$0) {
        LoadingDialog.Companion companion = LoadingDialog.Companion;
        Context context = this$0.getContext();
        return companion.withContent((context == null || (r1 = context.getString(R.string.account_global_string_89)) == null) ? "" : "");
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLifecycle().addObserver(LoginLifecycleObserver.INSTANCE);
        LoginReportHelper.INSTANCE.setFromSpmid(this.spmid);
        BiliAccounts.get(getContext()).subscribe(this, new Topic[]{Topic.SIGN_IN, Topic.ACCOUNT_SWITCH, Topic.ACCOUNT_INFO_UPDATE});
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        View composeView = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        composeView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1190849191, true, new Function2() { // from class: tv.danmaku.bili.change.AccountSwitchFragment$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit onCreateView$lambda$0$0;
                onCreateView$lambda$0$0 = AccountSwitchFragment.onCreateView$lambda$0$0(AccountSwitchFragment.this, (Composer) obj, ((Integer) obj2).intValue());
                return onCreateView$lambda$0$0;
            }
        }));
        return composeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0(final AccountSwitchFragment this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C96@3769L343,96@3759L353:AccountSwitchFragment.kt#khrci7");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1190849191, $changed, -1, "tv.danmaku.bili.change.AccountSwitchFragment.onCreateView.<anonymous>.<anonymous> (AccountSwitchFragment.kt:96)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-440747937, true, new Function2() { // from class: tv.danmaku.bili.change.AccountSwitchFragment$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreateView$lambda$0$0$0;
                    onCreateView$lambda$0$0$0 = AccountSwitchFragment.onCreateView$lambda$0$0$0(AccountSwitchFragment.this, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final Unit onCreateView$lambda$0$0$0(AccountSwitchFragment this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C97@3791L28,101@4001L16,102@4049L23,100@3934L160:AccountSwitchFragment.kt#khrci7");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-440747937, $changed, -1, "tv.danmaku.bili.change.AccountSwitchFragment.onCreateView.<anonymous>.<anonymous>.<anonymous> (AccountSwitchFragment.kt:97)");
            }
            $composer.startReplaceGroup(1642996572);
            ComposerKt.sourceInformation($composer, "*98@3880L6");
            SystemUiController $this$onCreateView_u24lambda_u240_u240_u240_u240 = SystemUiControllerKt.rememberSystemUiController((Window) null, $composer, 0, 1);
            SystemUiController.-CC.setStatusBarColor-ek8zF_U$default($this$onCreateView_u24lambda_u240_u240_u240_u240, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), false, (Function1) null, 6, (Object) null);
            $composer.endReplaceGroup();
            AccountSwitchPage accountSwitchPage = (AccountSwitchPage) SnapshotStateKt.collectAsState(this$0.getViewModel().getPageStateFlow(), (CoroutineContext) null, $composer, 0, 1).getValue();
            AccountSwitchViewModel viewModel = this$0.getViewModel();
            ComposerKt.sourceInformationMarkerStart($composer, 1643003830, "CC(remember):AccountSwitchFragment.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(viewModel);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (KFunction) new AccountSwitchFragment$onCreateView$1$1$1$2$1(viewModel);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            AccountSwitchComposeKt.AccountSwitchPage(accountSwitchPage, (KFunction) it$iv, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(requireActivity().getWindow(), false);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new AccountSwitchFragment$onViewCreated$1(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), (CoroutineContext) null, (CoroutineStart) null, new AccountSwitchFragment$onViewCreated$2(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), (CoroutineContext) null, (CoroutineStart) null, new AccountSwitchFragment$onViewCreated$3(this, null), 3, (Object) null);
    }

    public void onDestroy() {
        super.onDestroy();
        BiliAccounts.get(getContext()).unsubscribeAllWithSwitch(this);
    }

    public String getPvEventId() {
        return "main.change-account.0.0.pv";
    }

    public Bundle getPvExtra() {
        return new Bundle();
    }

    public void onChange(Topic topic) {
        if (topic == Topic.ACCOUNT_INFO_UPDATE) {
            getViewModel().handleAction(new LoginFinishAction(true));
        }
    }
}