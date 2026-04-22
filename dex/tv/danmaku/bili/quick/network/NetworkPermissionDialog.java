package tv.danmaku.bili.quick.network;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.accountui.R;
import com.bilibili.lib.accounts.model.TInfoLogin;
import com.bilibili.lib.accountsui.utils.ILoginLimitUpdate;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.gson.GsonKt;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.theme.ThemeWatcher;
import com.bilibili.magicasakura.widgets.Tintable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.network.NetworkDialogResult;
import tv.danmaku.bili.report.LoginReportHelper;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: NetworkPermissionDialog.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J;\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00160(J \u0010,\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0086@¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\tH\u0002J\b\u0010/\u001a\u00020\u0016H\u0002J\u0010\u00100\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\tH\u0003J\b\u00101\u001a\u00020\u0016H\u0016J\u0010\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020\u0016H\u0016J\b\u00106\u001a\u00020\u0016H\u0002J\u0010\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020\u0016H\u0002J\u0010\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u00020=H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Ltv/danmaku/bili/quick/network/NetworkPermissionDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "mTopBanner", "Lcom/bilibili/lib/image2/view/BiliImageView;", "mOtherBtn", "Landroid/widget/TextView;", "mHasOpenBtn", "Landroid/view/View;", "mProgressBar", "Landroid/widget/ProgressBar;", "mHasOpenTv", "mInfo", "Lcom/bilibili/lib/accounts/model/TInfoLogin;", "mDialogResult", "Ltv/danmaku/bili/quick/network/NetworkDialogResult;", "isRetrying", "", "observer", "Lcom/bilibili/lib/ui/theme/ThemeWatcher$Observer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "showProgressBar", "hideProgressBar", "showNow", "manager", "Landroidx/fragment/app/FragmentManager;", AppConfig.HOST_TAG, "", "onResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "result", "suspendShow", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initBanner", "updateBanner", "doTint", "onStart", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDestroyView", "increaseSmsShowTimes", "getPhoneInfo", "context", "Landroid/content/Context;", "reportShow", "reportClick", "button", "", "Companion", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NetworkPermissionDialog extends DialogFragment {
    private static final String DD_BG_IMAGE = "dd_login_network_dialog_background_gif";
    private static final String KEY_T_INFO_STRING = "tInfo_String";
    private static final String TAG = "NetworkPermissionDialog";
    private boolean isRetrying;
    private View mHasOpenBtn;
    private TextView mHasOpenTv;
    private TInfoLogin mInfo;
    private TextView mOtherBtn;
    private ProgressBar mProgressBar;
    private BiliImageView mTopBanner;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private NetworkDialogResult mDialogResult = NetworkDialogResult.Default.INSTANCE;
    private final ThemeWatcher.Observer observer = new ThemeWatcher.Observer() { // from class: tv.danmaku.bili.quick.network.NetworkPermissionDialog$$ExternalSyntheticLambda0
        public final void onThemeChanged() {
            NetworkPermissionDialog.observer$lambda$0(NetworkPermissionDialog.this);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observer$lambda$0(NetworkPermissionDialog this$0) {
        this$0.updateBanner();
        View it = this$0.getView();
        if (it != null) {
            this$0.doTint(it);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        String it;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        this.mInfo = (arguments == null || (it = arguments.getString(KEY_T_INFO_STRING)) == null) ? null : (TInfoLogin) GsonKt.getSGlobalGson().fromJson(it, TInfoLogin.class);
        increaseSmsShowTimes();
        reportShow();
        setStyle(0, R.style.LoginNetworkDialog);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.bili_app_dialog_login_network_permission, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initBanner(view);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.network_has_open_progress_bar);
        ProgressBar $this$onViewCreated_u24lambda_u240 = this.mProgressBar;
        if ($this$onViewCreated_u24lambda_u240 != null) {
            $this$onViewCreated_u24lambda_u240.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor($this$onViewCreated_u24lambda_u240.getContext(), com.bilibili.lib.theme.R.color.Text_white), PorterDuff.Mode.SRC_IN);
        }
        this.mHasOpenTv = (TextView) view.findViewById(R.id.network_has_open_tv);
        hideProgressBar();
        this.mOtherBtn = (TextView) view.findViewById(R.id.network_btn_other);
        TextView textView = this.mOtherBtn;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.quick.network.NetworkPermissionDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NetworkPermissionDialog.onViewCreated$lambda$1(NetworkPermissionDialog.this, view2);
                }
            });
        }
        this.mHasOpenBtn = view.findViewById(R.id.network_btn_has_open);
        View view2 = this.mHasOpenBtn;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.quick.network.NetworkPermissionDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    NetworkPermissionDialog.onViewCreated$lambda$2(NetworkPermissionDialog.this, view3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(NetworkPermissionDialog this$0, View it) {
        this$0.reportClick(1);
        this$0.mDialogResult = NetworkDialogResult.OtherWays.INSTANCE;
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(NetworkPermissionDialog this$0, View it) {
        if (!this$0.isRetrying) {
            this$0.isRetrying = true;
            this$0.reportClick(2);
            this$0.showProgressBar();
            Context context = it.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this$0.getPhoneInfo(context);
        }
    }

    private final void showProgressBar() {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        TextView textView = this.mHasOpenTv;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private final void hideProgressBar() {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        TextView textView = this.mHasOpenTv;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public final void showNow(FragmentManager manager, String tag, final Function1<? super NetworkDialogResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(function1, "onResult");
        try {
            showNow(manager, tag);
            getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: tv.danmaku.bili.quick.network.NetworkPermissionDialog$showNow$1
                public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
                    DefaultLifecycleObserver.-CC.$default$onCreate(this, lifecycleOwner);
                }

                public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                    DefaultLifecycleObserver.-CC.$default$onPause(this, lifecycleOwner);
                }

                public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
                    DefaultLifecycleObserver.-CC.$default$onResume(this, lifecycleOwner);
                }

                public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                    DefaultLifecycleObserver.-CC.$default$onStart(this, lifecycleOwner);
                }

                public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                    DefaultLifecycleObserver.-CC.$default$onStop(this, lifecycleOwner);
                }

                public void onDestroy(LifecycleOwner owner) {
                    NetworkDialogResult networkDialogResult;
                    Intrinsics.checkNotNullParameter(owner, "owner");
                    DefaultLifecycleObserver.-CC.$default$onDestroy(this, owner);
                    NetworkPermissionDialog.this.getLifecycle().removeObserver((LifecycleObserver) this);
                    Function1<NetworkDialogResult, Unit> function12 = function1;
                    networkDialogResult = NetworkPermissionDialog.this.mDialogResult;
                    function12.invoke(networkDialogResult);
                }
            });
        } catch (Throwable t) {
            BLog.e(TAG, "showNow, error = " + t.getMessage());
            function1.invoke(NetworkDialogResult.Default.INSTANCE);
        }
    }

    public final Object suspendShow(FragmentManager manager, String tag, Continuation<? super NetworkDialogResult> continuation) {
        Continuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Continuation it = safeContinuation;
        showNow(manager, tag, new NetworkPermissionDialog$suspendShow$2$1(it));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final void initBanner(View view) {
        this.mTopBanner = view.findViewById(R.id.network_top_banner);
        BiliImageView biliImageView = this.mTopBanner;
        if (biliImageView != null) {
            biliImageView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: tv.danmaku.bili.quick.network.NetworkPermissionDialog$initBanner$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v) {
                    ThemeWatcher.Observer observer;
                    Intrinsics.checkNotNullParameter(v, "v");
                    ThemeWatcher themeWatcher = ThemeWatcher.getInstance();
                    observer = NetworkPermissionDialog.this.observer;
                    themeWatcher.subscribe(observer);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View v) {
                    ThemeWatcher.Observer observer;
                    Intrinsics.checkNotNullParameter(v, "v");
                    ThemeWatcher themeWatcher = ThemeWatcher.getInstance();
                    observer = NetworkPermissionDialog.this.observer;
                    themeWatcher.unSubscribe(observer);
                }
            });
        }
        updateBanner();
    }

    private final void updateBanner() {
        BiliImageView topBanner;
        Context ctx = getContext();
        if (ctx == null || (topBanner = this.mTopBanner) == null) {
            return;
        }
        String bg = DeviceDecision.INSTANCE.dd(DD_BG_IMAGE, (String) null);
        topBanner.setBackground(ResourcesCompat.getDrawable(topBanner.getResources(), R.drawable.shape_bg_network_permission, ctx.getTheme()));
        ImageRequestBuilder.enableAutoPlayAnimation$default(BiliImageLoader.INSTANCE.with(ctx).url(bg), true, false, 2, (Object) null).animationPlayLoopCount(1).into(topBanner);
    }

    private final void doTint(View view) {
        RecyclerView.Adapter adapter;
        if (view instanceof Tintable) {
            ((Tintable) view).tint();
        }
        if (view instanceof ViewGroup) {
            Sequence $this$forEach$iv = ViewGroupKt.getChildren((ViewGroup) view);
            for (Object element$iv : $this$forEach$iv) {
                View it = (View) element$iv;
                doTint(it);
            }
            if (!(view instanceof RecyclerView) || (adapter = ((RecyclerView) view).getAdapter()) == null) {
                return;
            }
            adapter.notifyDataSetChanged();
        }
    }

    public void onStart() {
        Window $this$onStart_u24lambda_u240;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && ($this$onStart_u24lambda_u240 = dialog.getWindow()) != null) {
            WindowManager.LayoutParams attributes = $this$onStart_u24lambda_u240.getAttributes();
            if (attributes != null) {
                attributes.gravity = 80;
            }
            $this$onStart_u24lambda_u240.setLayout(-1, -2);
            $this$onStart_u24lambda_u240.setWindowAnimations(16973910);
            $this$onStart_u24lambda_u240.addFlags(Integer.MIN_VALUE);
            $this$onStart_u24lambda_u240.setNavigationBarColor(getResources().getColor(com.bilibili.lib.theme.R.color.Bg1_float));
        }
    }

    public void onCancel(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    private final void increaseSmsShowTimes() {
        ILoginLimitUpdate iLoginLimitUpdate;
        Context context = getContext();
        if (context == null) {
            return;
        }
        String fromSpmid = LoginReportHelper.INSTANCE.getFromSpmid();
        if (Intrinsics.areEqual(fromSpmid, "enter_homepage")) {
            ILoginLimitUpdate iLoginLimitUpdate2 = (ILoginLimitUpdate) BLRouter.INSTANCE.get(ILoginLimitUpdate.class, "homepage");
            if (iLoginLimitUpdate2 != null) {
                iLoginLimitUpdate2.updateSms(context);
            }
        } else if (!Intrinsics.areEqual(fromSpmid, LoginReporterV2.Error.SP_MID_ENTER_MY_INFO) || (iLoginLimitUpdate = (ILoginLimitUpdate) BLRouter.INSTANCE.get(ILoginLimitUpdate.class, "home_user_center")) == null) {
        } else {
            iLoginLimitUpdate.updateSms(context);
        }
    }

    private final void getPhoneInfo(Context context) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new NetworkPermissionDialog$getPhoneInfo$1(this, context, null), 3, (Object) null);
    }

    private final void reportShow() {
        String spmid = LoginReportHelper.INSTANCE.getFromSpmid();
        Neurons.reportExposure$default(false, "app.login.net-guide.0.show", MapsKt.mapOf(TuplesKt.to("spm_id", spmid)), (List) null, 8, (Object) null);
    }

    private final void reportClick(int button) {
        String spmid = LoginReportHelper.INSTANCE.getFromSpmid();
        Neurons.reportClick(false, "app.login.net-guide.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("spm_id", spmid), TuplesKt.to("button", String.valueOf(button))}));
    }

    /* compiled from: NetworkPermissionDialog.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/quick/network/NetworkPermissionDialog$Companion;", "", "<init>", "()V", "TAG", "", "KEY_T_INFO_STRING", "DD_BG_IMAGE", "newInstance", "Ltv/danmaku/bili/quick/network/NetworkPermissionDialog;", "tInfo", "Lcom/bilibili/lib/accounts/model/TInfoLogin;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NetworkPermissionDialog newInstance(TInfoLogin tInfo) {
            NetworkPermissionDialog $this$newInstance_u24lambda_u240 = new NetworkPermissionDialog();
            Bundle $this$newInstance_u24lambda_u240_u240 = new Bundle();
            $this$newInstance_u24lambda_u240_u240.putString(NetworkPermissionDialog.KEY_T_INFO_STRING, tInfo != null ? GsonKt.toJsonString(tInfo) : null);
            $this$newInstance_u24lambda_u240.setArguments($this$newInstance_u24lambda_u240_u240);
            return $this$newInstance_u24lambda_u240;
        }
    }
}