package tv.danmaku.bili.auth.v2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import bili.resource.account.R;
import com.bilibili.app.auth.databinding.FragmentAuthing2Binding;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.facialrecognition.FacialRecognitionHelper;
import com.bilibili.lib.facialrecognition.v2.FacialErrorInfo;
import com.bilibili.lib.ui.mixin.Flag;
import com.bilibili.magicasakura.widgets.TintEditText;
import com.bilibili.magicasakura.widgets.TintTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.api.bean.CardTypeBean;
import tv.danmaku.bili.api.bean.Gender;
import tv.danmaku.bili.auth.BiliAuthActivity;
import tv.danmaku.bili.auth.BiliAuthConstants;
import tv.danmaku.bili.auth.BiliAuthFragment;
import tv.danmaku.bili.auth.helper.AuthToastHelper;
import tv.danmaku.bili.auth.helper.EvokeFacialHelper;
import tv.danmaku.bili.auth.helper.RequestFacialData;
import tv.danmaku.bili.auth.v2.CertTypePickerDialogFragment;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.cb.AuthResultCbMsg;
import tv.danmaku.bili.quick.LoginQualityMonitor;
import tv.danmaku.bili.report.DefaultAuthReporter;
import tv.danmaku.bili.ui.widget.AuthBottomSheetDialog;
import tv.danmaku.bili.ui.widget.AuthBottomSheetItem;
import tv.danmaku.bili.ui.widget.wheel.BirthdayPickerDialogFragment;
import tv.danmaku.bili.ui.widget.wheel.OnBirthdayChooseListener;

/* compiled from: BiliAuthFragmentV2.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001PB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\"\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0018\u0010)\u001a\u00020\u0017*\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,J\\\u0010-\u001a\u00020\u0017\"\b\b\u0000\u0010.*\u00020\u001b\"\u0004\b\u0001\u0010/*\u0002H.2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H/0,2-\u00100\u001a)\b\u0001\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H/\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001702\u0012\u0006\u0012\u0004\u0018\u00010301¢\u0006\u0002\b4¢\u0006\u0002\u00105J\b\u00106\u001a\u00020\u0017H\u0002J\u000e\u00107\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u00108J\b\u00109\u001a\u00020\u0017H\u0002J\u0012\u0010:\u001a\u00020\u00172\b\u0010;\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010<\u001a\u00020\u00172\b\u0010;\u001a\u0004\u0018\u00010\b2\u0006\u0010=\u001a\u00020\bH\u0016J\u001a\u0010:\u001a\u00020\u00172\b\u0010;\u001a\u0004\u0018\u00010\b2\u0006\u0010>\u001a\u00020\bH\u0016J\"\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020%2\b\u0010A\u001a\u0004\u0018\u00010\b2\u0006\u0010B\u001a\u00020%H\u0016J\u0012\u0010?\u001a\u00020\u00172\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\b\u0010E\u001a\u00020\u0017H\u0016J\b\u0010F\u001a\u00020\u0017H\u0016J\b\u0010G\u001a\u00020\u0017H\u0016J\b\u0010H\u001a\u00020\u0017H\u0016J\u0010\u0010I\u001a\u00020\u00172\u0006\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020\u0017H\u0016J \u0010M\u001a\u00020\u0017*\u00020*2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170OH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Ltv/danmaku/bili/auth/v2/BiliAuthFragmentV2;", "Ltv/danmaku/bili/auth/v2/BaseAuthFragmentV2;", "Lcom/bilibili/lib/facialrecognition/FacialRecognitionHelper$IFacialCallback;", "<init>", "()V", "isClick", "", "mTempCode", "", "isAfter14", "mEvokeFacialHelper", "Ltv/danmaku/bili/auth/helper/EvokeFacialHelper;", "mAuthToastHelper", "Ltv/danmaku/bili/auth/helper/AuthToastHelper;", "viewModel", "Ltv/danmaku/bili/auth/v2/AuthV2ViewModel;", "getViewModel", "()Ltv/danmaku/bili/auth/v2/AuthV2ViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/bilibili/app/auth/databinding/FragmentAuthing2Binding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "cacheTenRequestId", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "setContent", "Landroid/widget/TextView;", "flow", "Lkotlinx/coroutines/flow/Flow;", "collect", "T", "E", "observer", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroid/view/View;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)V", "openManualH5", "beforeFacial", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startFacial", "onSuccess", "requestID", "onSuccessForOverride", "overrideMid", "authCode", "onFailure", "errorCode", AuthResultCbHelper.ARGS_MSG, "causeCode", "errorInfo", "Lcom/bilibili/lib/facialrecognition/v2/FacialErrorInfo;", "onInitSuccess", "onRequestStart", "onRequestEnd", "onDetectStart", "onFragmentShow", "lastFlag", "Lcom/bilibili/lib/ui/mixin/Flag;", "onDestroyView", "watchText", "onChange", "Lkotlin/Function1;", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthFragmentV2 extends BaseAuthFragmentV2 implements FacialRecognitionHelper.IFacialCallback {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "BiliAuthFragmentV2";
    private FragmentAuthing2Binding binding;
    private String cacheTenRequestId;
    private boolean isAfter14;
    private boolean isClick;
    private AuthToastHelper mAuthToastHelper;
    private EvokeFacialHelper mEvokeFacialHelper;
    private String mTempCode = "";
    private final Lazy viewModel$delegate;

    public BiliAuthFragmentV2() {
        final Fragment $this$viewModels_u24default$iv = (Fragment) this;
        final Function0 ownerProducer$iv = new Function0<Fragment>() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final Fragment m726invoke() {
                return $this$viewModels_u24default$iv;
            }
        };
        final Lazy owner$delegate$iv = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStoreOwner m727invoke() {
                return (ViewModelStoreOwner) ownerProducer$iv.invoke();
            }
        });
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$viewModels_u24default$iv, Reflection.getOrCreateKotlinClass(AuthV2ViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m728invoke() {
                return FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m729invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                if (function0 != null && (creationExtras = (CreationExtras) function0.invoke()) != null) {
                    return creationExtras;
                }
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                return hasDefaultViewModelProviderFactory2 != null ? hasDefaultViewModelProviderFactory2.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m730invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                if (hasDefaultViewModelProviderFactory2 != null && (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory2.getDefaultViewModelProviderFactory()) != null) {
                    return defaultViewModelProviderFactory;
                }
                return $this$viewModels_u24default$iv.getDefaultViewModelProviderFactory();
            }
        });
        this.cacheTenRequestId = "";
    }

    /* compiled from: BiliAuthFragmentV2.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/v2/BiliAuthFragmentV2$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Ltv/danmaku/bili/auth/v2/BiliAuthFragmentV2;", "params", "Landroid/os/Bundle;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BiliAuthFragmentV2 newInstance(Bundle params) {
            BiliAuthFragmentV2 fragment = new BiliAuthFragmentV2();
            if (params != null) {
                fragment.setArguments(params);
            }
            return fragment;
        }
    }

    private final AuthV2ViewModel getViewModel() {
        return (AuthV2ViewModel) this.viewModel$delegate.getValue();
    }

    public void onCreate(Bundle savedInstanceState) {
        Intent intent;
        Intent intent2;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        Bundle bundle = null;
        this.isAfter14 = BundleUtil.getBoolean((activity == null || (intent2 = activity.getIntent()) == null) ? null : intent2.getExtras(), BiliAuthConstants.BUNDLE_KEY_AFTER_14, new boolean[]{false});
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            bundle = intent.getExtras();
        }
        String string = BundleUtil.getString(bundle, BiliAuthConstants.BUNDLE_KEY_TEMP_CODE, new String[]{""});
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.mTempCode = string;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.mEvokeFacialHelper = new EvokeFacialHelper(getContext());
        this.mAuthToastHelper = new AuthToastHelper(requireHostActivity());
        FragmentAuthing2Binding $this$onCreateView_u24lambda_u240 = FragmentAuthing2Binding.inflate(inflater, container, false);
        this.binding = $this$onCreateView_u24lambda_u240;
        return $this$onCreateView_u24lambda_u240.getRoot();
    }

    @Override // tv.danmaku.bili.auth.v2.BaseAuthFragmentV2
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final FragmentAuthing2Binding $this$onViewCreated_u24lambda_u240 = this.binding;
        if ($this$onViewCreated_u24lambda_u240 != null) {
            TintEditText tintEditText = $this$onViewCreated_u24lambda_u240.editName;
            Intrinsics.checkNotNullExpressionValue(tintEditText, "editName");
            watchText((TextView) tintEditText, new Function1() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda5
                public final Object invoke(Object obj) {
                    Unit onViewCreated$lambda$0$0;
                    onViewCreated$lambda$0$0 = BiliAuthFragmentV2.onViewCreated$lambda$0$0(BiliAuthFragmentV2.this, (String) obj);
                    return onViewCreated$lambda$0$0;
                }
            });
            TintEditText tintEditText2 = $this$onViewCreated_u24lambda_u240.editCard;
            Intrinsics.checkNotNullExpressionValue(tintEditText2, "editCard");
            watchText((TextView) tintEditText2, new Function1() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    Unit onViewCreated$lambda$0$1;
                    onViewCreated$lambda$0$1 = BiliAuthFragmentV2.onViewCreated$lambda$0$1(BiliAuthFragmentV2.this, (String) obj);
                    return onViewCreated$lambda$0$1;
                }
            });
            $this$onViewCreated_u24lambda_u240.btnAuthEnter.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BiliAuthFragmentV2.onViewCreated$lambda$0$2(BiliAuthFragmentV2.this, $this$onViewCreated_u24lambda_u240, view2);
                }
            });
            collect($this$onViewCreated_u24lambda_u240.certTypeContainer, getViewModel().getCanSelectCertType(), new BiliAuthFragmentV2$onViewCreated$1$4($this$onViewCreated_u24lambda_u240, null));
            $this$onViewCreated_u24lambda_u240.certTypeContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BiliAuthFragmentV2.onViewCreated$lambda$0$3(BiliAuthFragmentV2.this, view2);
                }
            });
            $this$onViewCreated_u24lambda_u240.genderContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BiliAuthFragmentV2.onViewCreated$lambda$0$4(BiliAuthFragmentV2.this, view2);
                }
            });
            $this$onViewCreated_u24lambda_u240.birthContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BiliAuthFragmentV2.onViewCreated$lambda$0$5(BiliAuthFragmentV2.this, view2);
                }
            });
            TintTextView tintTextView = $this$onViewCreated_u24lambda_u240.editBirth;
            Intrinsics.checkNotNullExpressionValue(tintTextView, "editBirth");
            final Flow $this$map$iv = getViewModel().getState();
            setContent((TextView) tintTextView, new Flow<String>() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$onViewCreated$lambda$0$$inlined$map$1
                public Object collect(FlowCollector collector, Continuation $completion) {
                    Object collect = $this$map$iv.collect(new AnonymousClass2(collector), $completion);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }

                /* compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                /* renamed from: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$onViewCreated$lambda$0$$inlined$map$1$2  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                    @DebugMetadata(c = "tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$onViewCreated$lambda$0$$inlined$map$1$2", f = "BiliAuthFragmentV2.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                    /* renamed from: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$onViewCreated$lambda$0$$inlined$map$1$2$1  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, (Continuation) this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object value, Continuation $completion) {
                        Continuation $continuation;
                        if ($completion instanceof AnonymousClass1) {
                            $continuation = (AnonymousClass1) $completion;
                            if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                $continuation.label -= Integer.MIN_VALUE;
                                Object $result = $continuation.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch ($continuation.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        FlowCollector flowCollector = this.$this_unsafeFlow;
                                        AuthState it = (AuthState) value;
                                        String birthdayString = it.getBirthdayString();
                                        $continuation.label = 1;
                                        if (flowCollector.emit(birthdayString, $continuation) != coroutine_suspended) {
                                            break;
                                        } else {
                                            return coroutine_suspended;
                                        }
                                    case 1:
                                        ResultKt.throwOnFailure($result);
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        $continuation = new AnonymousClass1($completion);
                        Object $result2 = $continuation.result;
                        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                        }
                        return Unit.INSTANCE;
                    }
                }
            });
            collect($this$onViewCreated_u24lambda_u240.ivCertTypeArrow, getViewModel().getCanSelectCertType(), new BiliAuthFragmentV2$onViewCreated$1$9(null));
            View.OnClickListener agreementClicker = new View.OnClickListener() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BiliAuthFragmentV2.onViewCreated$lambda$0$7($this$onViewCreated_u24lambda_u240, view2);
                }
            };
            $this$onViewCreated_u24lambda_u240.loginAgreement.facialAgCheckboxContainer.setOnClickListener(agreementClicker);
            $this$onViewCreated_u24lambda_u240.loginAgreement.facialAgCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    BiliAuthFragmentV2.onViewCreated$lambda$0$8(BiliAuthFragmentV2.this, compoundButton, z);
                }
            });
            $this$onViewCreated_u24lambda_u240.loginAgreement.tvFacialAgreement.setOnClickListener(agreementClicker);
            handleFacialAgreement($this$onViewCreated_u24lambda_u240.loginAgreement.tvFacialAgreement);
            collect($this$onViewCreated_u24lambda_u240.getRoot(), getViewModel().getCurrentCertType(), new BiliAuthFragmentV2$onViewCreated$1$11($this$onViewCreated_u24lambda_u240, null));
            collect($this$onViewCreated_u24lambda_u240.btnAuthEnter, getViewModel().getLocalValidChecked(), new BiliAuthFragmentV2$onViewCreated$1$12($this$onViewCreated_u24lambda_u240, null));
            TintTextView tintTextView2 = $this$onViewCreated_u24lambda_u240.tvGenderValue;
            Intrinsics.checkNotNullExpressionValue(tintTextView2, "tvGenderValue");
            final Flow $this$map$iv2 = getViewModel().getCurrentGender();
            setContent((TextView) tintTextView2, new Flow<String>() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$onViewCreated$lambda$0$$inlined$map$2
                public Object collect(FlowCollector collector, Continuation $completion) {
                    Object collect = $this$map$iv2.collect(new AnonymousClass2(collector, this), $completion);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }

                /* compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                /* renamed from: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$onViewCreated$lambda$0$$inlined$map$2$2  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ BiliAuthFragmentV2 this$0;

                    /* compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                    @DebugMetadata(c = "tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$onViewCreated$lambda$0$$inlined$map$2$2", f = "BiliAuthFragmentV2.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                    /* renamed from: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$onViewCreated$lambda$0$$inlined$map$2$2$1  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, (Continuation) this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, BiliAuthFragmentV2 biliAuthFragmentV2) {
                        this.$this_unsafeFlow = flowCollector;
                        this.this$0 = biliAuthFragmentV2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object value, Continuation $completion) {
                        Continuation $continuation;
                        if ($completion instanceof AnonymousClass1) {
                            $continuation = (AnonymousClass1) $completion;
                            if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                $continuation.label -= Integer.MIN_VALUE;
                                Object $result = $continuation.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch ($continuation.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        FlowCollector flowCollector = this.$this_unsafeFlow;
                                        Gender it = (Gender) value;
                                        Context requireContext = this.this$0.requireContext();
                                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                                        String genderContent = it.getGenderContent(requireContext);
                                        $continuation.label = 1;
                                        if (flowCollector.emit(genderContent, $continuation) != coroutine_suspended) {
                                            break;
                                        } else {
                                            return coroutine_suspended;
                                        }
                                    case 1:
                                        ResultKt.throwOnFailure($result);
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        $continuation = new AnonymousClass1($completion);
                        Object $result2 = $continuation.result;
                        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                        }
                        return Unit.INSTANCE;
                    }
                }
            });
            collect($this$onViewCreated_u24lambda_u240.getRoot(), getViewModel().getShowLoading(), new BiliAuthFragmentV2$onViewCreated$1$14(this, null));
        }
        EvokeFacialHelper $this$onViewCreated_u24lambda_u241 = this.mEvokeFacialHelper;
        if ($this$onViewCreated_u24lambda_u241 != null) {
            $this$onViewCreated_u24lambda_u241.setMDelayEnter(true);
            $this$onViewCreated_u24lambda_u241.setFacialListener(this);
            $this$onViewCreated_u24lambda_u241.initFacial();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$0(BiliAuthFragmentV2 this$0, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getViewModel().nameWith(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$1(BiliAuthFragmentV2 this$0, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getViewModel().cardWith(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$2(BiliAuthFragmentV2 this$0, FragmentAuthing2Binding $this_run, View it) {
        if (!this$0.isClick) {
            $this_run.editName.clearFocus();
            $this_run.editCard.clearFocus();
            LifecycleOwner viewLifecycleOwner = this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new BiliAuthFragmentV2$onViewCreated$1$3$1(this$0, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$3(final BiliAuthFragmentV2 this$0, View it) {
        CertTypePickerDialogFragment.Companion companion = CertTypePickerDialogFragment.Companion;
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        companion.show(childFragmentManager, ((AuthState) this$0.getViewModel().getState().getValue()).getTypeList(), new Function1() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$0$3$0;
                onViewCreated$lambda$0$3$0 = BiliAuthFragmentV2.onViewCreated$lambda$0$3$0(BiliAuthFragmentV2.this, (CardTypeBean) obj);
                return onViewCreated$lambda$0$3$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$3$0(BiliAuthFragmentV2 this$0, CardTypeBean type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (type.getOnlyManualVerification()) {
            this$0.openManualH5();
        } else {
            this$0.getViewModel().setCertType(type);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$4(final BiliAuthFragmentV2 this$0, View it) {
        FragmentManager fm = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(fm, "getChildFragmentManager(...)");
        final List genders = CollectionsKt.listOf(new Gender[]{Gender.MALE, Gender.FEMALE});
        AuthBottomSheetDialog.Companion companion = AuthBottomSheetDialog.Companion;
        List $this$map$iv = genders;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Gender gender = (Gender) item$iv$iv;
            Context context = it.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            destination$iv$iv.add(new AuthBottomSheetItem(gender.getGenderContent(context), 0, 2, (DefaultConstructorMarker) null));
            $this$map$iv = $this$map$iv;
        }
        companion.newInstance(new ArrayList((List) destination$iv$iv), new Function1() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda16
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$0$4$1;
                onViewCreated$lambda$0$4$1 = BiliAuthFragmentV2.onViewCreated$lambda$0$4$1(BiliAuthFragmentV2.this, genders, ((Integer) obj).intValue());
                return onViewCreated$lambda$0$4$1;
            }
        }).show(fm, "GenderPicker");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$4$1(BiliAuthFragmentV2 this$0, List $genders, int position) {
        AuthV2ViewModel viewModel = this$0.getViewModel();
        Gender gender = (Gender) CollectionsKt.getOrNull($genders, position);
        if (gender == null) {
            gender = Gender.UNKNOWN;
        }
        viewModel.setGender(gender);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$5(final BiliAuthFragmentV2 this$0, View it) {
        FragmentManager fm = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(fm, "getChildFragmentManager(...)");
        BirthdayPickerDialogFragment dialog = BirthdayPickerDialogFragment.Companion.newInstance();
        AuthDate date = ((AuthState) this$0.getViewModel().getState().getValue()).getBirth();
        if (date != null) {
            dialog.setInitDate(date.getYear(), date.getMonth(), date.getDay());
        }
        dialog.setOnChooseListener(new OnBirthdayChooseListener() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda3
            public final void onChoose(int i, int i2, int i3) {
                BiliAuthFragmentV2.onViewCreated$lambda$0$5$1(BiliAuthFragmentV2.this, i, i2, i3);
            }
        });
        dialog.safeShow(fm, "BirthdayPicker");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$5$1(BiliAuthFragmentV2 this$0, int y, int m, int d) {
        this$0.getViewModel().birthWith(new AuthDate(y, m, d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$7(FragmentAuthing2Binding $this_run, View it) {
        $this_run.loginAgreement.facialAgCheckbox.setChecked(!$this_run.loginAgreement.facialAgCheckbox.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$8(BiliAuthFragmentV2 this$0, CompoundButton compoundButton, boolean isChecked) {
        this$0.isClick = false;
        this$0.getViewModel().agree(isChecked);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        TintEditText tintEditText;
        TintEditText tintEditText2;
        String stringExtra;
        super.onActivityResult(requestCode, resultCode, data);
        BLog.i(BiliAuthFragment.TAG, "onActivityResult requestCode = " + requestCode);
        String str = "";
        switch (requestCode) {
            case 301:
                int result = data != null ? data.getIntExtra(BiliAuthConstants.AUTH_KEY_JS_RESULT, -200) : -200;
                int status = result > -200 ? result : -1;
                finishWithCallBack(new AuthResultCbMsg(status, ""));
                return;
            case 302:
                Activity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
                if (resultCode == -1) {
                    AuthResultCbHelper.setResultToActivityWithRequestId(requireActivity, 3, this.cacheTenRequestId);
                    requireActivity.finish();
                    return;
                }
                if (data != null && (stringExtra = data.getStringExtra(BiliAuthFragment.KEY_FAIL)) != null) {
                    str = stringExtra;
                }
                boolean not14 = Intrinsics.areEqual(str, BiliAuthFragment.FAIL_NOT_14);
                if (not14) {
                    final Bundle $this$onActivityResult_u24lambda_u240 = new Bundle();
                    FragmentAuthing2Binding fragmentAuthing2Binding = this.binding;
                    Editable editable = null;
                    String valueOf = String.valueOf((fragmentAuthing2Binding == null || (tintEditText2 = fragmentAuthing2Binding.editName) == null) ? null : tintEditText2.getText());
                    FragmentAuthing2Binding fragmentAuthing2Binding2 = this.binding;
                    if (fragmentAuthing2Binding2 != null && (tintEditText = fragmentAuthing2Binding2.editCard) != null) {
                        editable = tintEditText.getText();
                    }
                    Pair it = encipherUserInfo(valueOf, String.valueOf(editable));
                    $this$onActivityResult_u24lambda_u240.putString("key_real_name", (String) it.getFirst());
                    $this$onActivityResult_u24lambda_u240.putString("key_card", (String) it.getSecond());
                    HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda15
                        @Override // java.lang.Runnable
                        public final void run() {
                            BiliAuthFragmentV2.onActivityResult$lambda$1(BiliAuthFragmentV2.this, $this$onActivityResult_u24lambda_u240);
                        }
                    });
                    return;
                }
                AuthResultCbHelper.setResultToActivity(requireActivity, -1);
                requireActivity.finish();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActivityResult$lambda$1(BiliAuthFragmentV2 this$0, Bundle $bundle) {
        BLog.i(TAG, "FacialRecognition::toSuccessPage");
        AuthToastHelper authToastHelper = this$0.mAuthToastHelper;
        if (authToastHelper != null) {
            authToastHelper.dismissLoading();
        }
        this$0.showFragment(1, $bundle, (Fragment) this$0);
    }

    public final void setContent(TextView $this$setContent, Flow<String> flow) {
        Intrinsics.checkNotNullParameter($this$setContent, "<this>");
        Intrinsics.checkNotNullParameter(flow, "flow");
        collect($this$setContent, flow, new BiliAuthFragmentV2$setContent$1(null));
    }

    public final <T extends View, E> void collect(T t, Flow<? extends E> flow, Function3<? super T, ? super E, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(flow, "flow");
        Intrinsics.checkNotNullParameter(function3, "observer");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new BiliAuthFragmentV2$collect$1(flow, function3, t, null), 3, (Object) null);
    }

    private final void openManualH5() {
        RouteRequest request = RouteRequestKt.toRouteRequest(getViewModel().getManualUrl()).newBuilder().extras(new Function1() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda20
            public final Object invoke(Object obj) {
                Unit openManualH5$lambda$0;
                openManualH5$lambda$0 = BiliAuthFragmentV2.openManualH5$lambda$0(BiliAuthFragmentV2.this, (MutableBundleLike) obj);
                return openManualH5$lambda$0;
            }
        }).build();
        BLRouter.routeTo(request, requireContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openManualH5$lambda$0(BiliAuthFragmentV2 this$0, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put("tmp_token", this$0.mTempCode);
        $this$extras.put("from", "naRealname");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object beforeFacial(Continuation<? super Unit> continuation) {
        BiliAuthFragmentV2$beforeFacial$1 biliAuthFragmentV2$beforeFacial$1;
        Object first;
        BiliAuthFragmentV2 biliAuthFragmentV2;
        AuthState checked;
        FragmentAuthing2Binding fragmentAuthing2Binding;
        FragmentAuthing2Binding fragmentAuthing2Binding2;
        TintEditText tintEditText;
        TintEditText tintEditText2;
        if (continuation instanceof BiliAuthFragmentV2$beforeFacial$1) {
            biliAuthFragmentV2$beforeFacial$1 = (BiliAuthFragmentV2$beforeFacial$1) continuation;
            if ((biliAuthFragmentV2$beforeFacial$1.label & Integer.MIN_VALUE) != 0) {
                biliAuthFragmentV2$beforeFacial$1.label -= Integer.MIN_VALUE;
                Object $result = biliAuthFragmentV2$beforeFacial$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (biliAuthFragmentV2$beforeFacial$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        getViewModel().checkField(new FieldCheckAction(ContentField.Name, null, 2, null));
                        getViewModel().checkField(new FieldCheckAction(ContentField.Card, null, 2, null));
                        biliAuthFragmentV2$beforeFacial$1.label = 1;
                        first = FlowKt.first(getViewModel().getState(), new BiliAuthFragmentV2$beforeFacial$checked$1(null), biliAuthFragmentV2$beforeFacial$1);
                        if (first == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        biliAuthFragmentV2 = this;
                        break;
                    case 1:
                        biliAuthFragmentV2 = this;
                        ResultKt.throwOnFailure($result);
                        first = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                checked = (AuthState) first;
                if (!checked.getLocalValidChecked() && checked.getRemoteValid()) {
                    biliAuthFragmentV2.startFacial();
                } else {
                    fragmentAuthing2Binding = biliAuthFragmentV2.binding;
                    if (fragmentAuthing2Binding != null && (tintEditText2 = fragmentAuthing2Binding.editCard) != null) {
                        tintEditText2.clearFocus();
                    }
                    fragmentAuthing2Binding2 = biliAuthFragmentV2.binding;
                    if (fragmentAuthing2Binding2 != null && (tintEditText = fragmentAuthing2Binding2.editName) != null) {
                        tintEditText.clearFocus();
                    }
                    ToastHelper.showToastShort(biliAuthFragmentV2.getActivity(), R.string.account_global_string_429);
                }
                return Unit.INSTANCE;
            }
        }
        biliAuthFragmentV2$beforeFacial$1 = new BiliAuthFragmentV2$beforeFacial$1(this, continuation);
        Object $result2 = biliAuthFragmentV2$beforeFacial$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (biliAuthFragmentV2$beforeFacial$1.label) {
        }
        checked = (AuthState) first;
        if (!checked.getLocalValidChecked()) {
        }
        fragmentAuthing2Binding = biliAuthFragmentV2.binding;
        if (fragmentAuthing2Binding != null) {
            tintEditText2.clearFocus();
        }
        fragmentAuthing2Binding2 = biliAuthFragmentV2.binding;
        if (fragmentAuthing2Binding2 != null) {
            tintEditText.clearFocus();
        }
        ToastHelper.showToastShort(biliAuthFragmentV2.getActivity(), R.string.account_global_string_429);
        return Unit.INSTANCE;
    }

    private final void startFacial() {
        AuthToastHelper authToastHelper = this.mAuthToastHelper;
        if (authToastHelper != null) {
            authToastHelper.dismissLoading();
        }
        EvokeFacialHelper $this$startFacial_u24lambda_u240 = this.mEvokeFacialHelper;
        if ($this$startFacial_u24lambda_u240 != null) {
            $this$startFacial_u24lambda_u240.setMDelayEnter(false);
            this.isClick = true;
            $this$startFacial_u24lambda_u240.setFacialListener(this);
            AuthState state = (AuthState) getViewModel().getState().getValue();
            RequestFacialData $this$startFacial_u24lambda_u240_u240 = new RequestFacialData(state.getName().getContent(), state.getCard().getContent(), this.mTempCode, this.isAfter14, sourceEvent());
            $this$startFacial_u24lambda_u240_u240.setCardType(Integer.valueOf(state.getType().getId()));
            $this$startFacial_u24lambda_u240_u240.setGender(state.getGender().getCode());
            $this$startFacial_u24lambda_u240_u240.setBirthday(state.getBirthdayString());
            $this$startFacial_u24lambda_u240.startFacial($this$startFacial_u24lambda_u240_u240, (Activity) requireHostActivity());
        }
    }

    public void onSuccess(final String requestID) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onSuccess(this, requestID);
        this.cacheTenRequestId = "";
        moveToFrontIfNeed();
        setAuthStatus(1, requestID);
        if (isAdded()) {
            HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    BiliAuthFragmentV2.onSuccess$lambda$0(BiliAuthFragmentV2.this, requestID);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSuccess$lambda$0(BiliAuthFragmentV2 this$0, String $requestID) {
        Intent intent;
        EvokeFacialHelper evokeFacialHelper = this$0.mEvokeFacialHelper;
        if (evokeFacialHelper != null) {
            evokeFacialHelper.facialFinish();
        }
        FragmentActivity activity = this$0.getActivity();
        if (BundleUtil.getBoolean((activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras(), BiliAuthConstants.BUNDLE_KEY_AFTER_14, new boolean[]{false})) {
            this$0.cacheTenRequestId = $requestID == null ? "" : $requestID;
            BLRouter.routeTo(new RouteRequest.Builder("bilibili://main/teenagersmode/guardian-bind").requestCode(302).build(), (Fragment) this$0);
            return;
        }
        Bundle $this$onSuccess_u24lambda_u240_u240 = this$0.getArguments();
        if ($this$onSuccess_u24lambda_u240_u240 != null) {
            AuthState state = (AuthState) this$0.getViewModel().getState().getValue();
            Pair it = this$0.encipherUserInfo(state.getName().getContent(), state.getCard().getContent());
            $this$onSuccess_u24lambda_u240_u240.putString("key_real_name", (String) it.getFirst());
            $this$onSuccess_u24lambda_u240_u240.putString("key_card", (String) it.getSecond());
        }
        this$0.showFragment(1, this$0.getArguments(), (Fragment) this$0);
    }

    public void onSuccessForOverride(final String requestID, final String overrideMid) {
        Intrinsics.checkNotNullParameter(overrideMid, "overrideMid");
        moveToFrontIfNeed();
        setAuthStatus(4, requestID);
        if (isAdded()) {
            HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BiliAuthFragmentV2.onSuccessForOverride$lambda$0(BiliAuthFragmentV2.this, overrideMid, requestID);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSuccessForOverride$lambda$0(BiliAuthFragmentV2 this$0, String $overrideMid, String $requestID) {
        EvokeFacialHelper evokeFacialHelper = this$0.mEvokeFacialHelper;
        if (evokeFacialHelper != null) {
            evokeFacialHelper.facialFinish();
        }
        Bundle $this$onSuccessForOverride_u24lambda_u240_u240 = this$0.getArguments();
        if ($this$onSuccessForOverride_u24lambda_u240_u240 != null) {
            AuthState state = (AuthState) this$0.getViewModel().getState().getValue();
            Pair it = this$0.encipherUserInfo2(state.getName().getContent(), state.getCard().getContent());
            $this$onSuccessForOverride_u24lambda_u240_u240.putString("key_real_name", (String) it.getFirst());
            $this$onSuccessForOverride_u24lambda_u240_u240.putString("key_card", (String) it.getSecond());
            $this$onSuccessForOverride_u24lambda_u240_u240.putString(BiliAuthActivity.BUNDLE_KEY_OVERRIDE_MID, $overrideMid);
            $this$onSuccessForOverride_u24lambda_u240_u240.putString(BiliAuthActivity.BUNDLE_KEY_REQUEST_ID, $requestID == null ? "" : $requestID);
        }
        this$0.showFragment(4, this$0.getArguments(), (Fragment) this$0);
    }

    public void onSuccess(final String requestID, final String authCode) {
        Intrinsics.checkNotNullParameter(authCode, "authCode");
        this.cacheTenRequestId = "";
        setAuthStatus(1, requestID);
        BLog.i(BiliAuthFragment.TAG, "FacialRecognition:: onSuccess authCode, requestId = " + requestID);
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthFragmentV2.onSuccess$lambda$1(BiliAuthFragmentV2.this, authCode, requestID);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSuccess$lambda$1(BiliAuthFragmentV2 this$0, String $authCode, String $requestID) {
        EvokeFacialHelper evokeFacialHelper = this$0.mEvokeFacialHelper;
        if (evokeFacialHelper != null) {
            evokeFacialHelper.facialFinish();
        }
        this$0.successForLogin($authCode, $requestID);
    }

    public void onFailure(final int errorCode, final String msg, final int causeCode) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onFailure(this, errorCode, msg, causeCode);
        this.isClick = false;
        setAuthStatus(2, LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR);
        moveToFrontIfNeed();
        if (isAdded()) {
            HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    BiliAuthFragmentV2.onFailure$lambda$0(BiliAuthFragmentV2.this, errorCode, msg, causeCode);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFailure$lambda$0(BiliAuthFragmentV2 this$0, int $errorCode, String $msg, int $causeCode) {
        EvokeFacialHelper evokeFacialHelper = this$0.mEvokeFacialHelper;
        if (evokeFacialHelper != null) {
            evokeFacialHelper.facialFinish();
        }
        EvokeFacialHelper evokeFacialHelper2 = this$0.mEvokeFacialHelper;
        String message = evokeFacialHelper2 != null ? evokeFacialHelper2.code2Message($errorCode, $msg) : null;
        if ($errorCode < 5 || $errorCode == 7) {
            ToastHelper.showToastShort(this$0.getContext(), message);
            return;
        }
        Bundle bundle = new Bundle();
        AuthState state = (AuthState) this$0.getViewModel().getState().getValue();
        bundle.putString("key_fail_msg", message == null ? "" : message);
        bundle.putInt("key_error_code", $causeCode);
        bundle.putString("key_real_name", state.getName().getContent());
        bundle.putString("key_card", state.getCard().getContent());
        this$0.showFragment(2, bundle, (Fragment) this$0);
    }

    public void onFailure(FacialErrorInfo errorInfo) {
        this.isClick = false;
        setAuthStatus(2, LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR);
        moveToFrontIfNeed();
        if (isAdded()) {
            final int errorCode = errorInfo != null ? errorInfo.getErrorCode() : -1;
            final String errorMsg = (errorInfo == null || (errorMsg = errorInfo.getToastMsg()) == null) ? "" : "";
            final int causeCode = errorInfo != null ? errorInfo.getCauseCode() : -1;
            if (errorInfo != null && errorInfo.getCauseMsg() != null) {
            }
            HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    BiliAuthFragmentV2.onFailure$lambda$1(BiliAuthFragmentV2.this, errorCode, errorMsg, causeCode);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFailure$lambda$1(BiliAuthFragmentV2 this$0, int $errorCode, String $errorMsg, int $causeCode) {
        EvokeFacialHelper evokeFacialHelper = this$0.mEvokeFacialHelper;
        if (evokeFacialHelper != null) {
            evokeFacialHelper.facialFinish();
        }
        if ($errorCode < 5 || $errorCode == 7) {
            ToastHelper.showToastShort(this$0.getContext(), $errorMsg);
            return;
        }
        Bundle bundle = new Bundle();
        AuthState state = (AuthState) this$0.getViewModel().getState().getValue();
        bundle.putString("key_fail_msg", $errorMsg);
        bundle.putInt("key_error_code", $causeCode);
        bundle.putString("key_real_name", state.getName().getContent());
        bundle.putString("key_card", state.getCard().getContent());
        this$0.showFragment(2, bundle, (Fragment) this$0);
    }

    public void onInitSuccess() {
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthFragmentV2.onInitSuccess$lambda$0(BiliAuthFragmentV2.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitSuccess$lambda$0(BiliAuthFragmentV2 this$0) {
        BLog.i(BiliAuthFragment.TAG, "FacialRecognition::onInitSuccess");
        EvokeFacialHelper $this$onInitSuccess_u24lambda_u240_u240 = this$0.mEvokeFacialHelper;
        if ($this$onInitSuccess_u24lambda_u240_u240 != null) {
            $this$onInitSuccess_u24lambda_u240_u240.setMFacialInit(true);
            $this$onInitSuccess_u24lambda_u240_u240.enterFacial();
        }
    }

    public void onRequestStart() {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onRequestStart(this);
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthFragmentV2.onRequestStart$lambda$0(BiliAuthFragmentV2.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRequestStart$lambda$0(BiliAuthFragmentV2 this$0) {
        BLog.i(BiliAuthFragment.TAG, "FacialRecognition::onRequestStart");
        EvokeFacialHelper evokeFacialHelper = this$0.mEvokeFacialHelper;
        if (evokeFacialHelper != null) {
            evokeFacialHelper.facialStart();
        }
    }

    public void onRequestEnd() {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onRequestEnd(this);
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthFragmentV2.onRequestEnd$lambda$0(BiliAuthFragmentV2.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRequestEnd$lambda$0(BiliAuthFragmentV2 this$0) {
        BLog.i(BiliAuthFragment.TAG, "FacialRecognition::onRequestEnd");
        EvokeFacialHelper evokeFacialHelper = this$0.mEvokeFacialHelper;
        if (evokeFacialHelper != null) {
            evokeFacialHelper.facialFinish();
        }
    }

    public void onDetectStart() {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onDetectStart(this);
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthFragmentV2.onDetectStart$lambda$0(BiliAuthFragmentV2.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDetectStart$lambda$0(BiliAuthFragmentV2 this$0) {
        BLog.i(BiliAuthFragment.TAG, "FacialRecognition::onDetectStart");
        DefaultAuthReporter.INSTANCE.reportFaceScanShow(this$0.sourceEvent());
    }

    public void onFragmentShow(Flag lastFlag) {
        Intrinsics.checkNotNullParameter(lastFlag, "lastFlag");
        super.onFragmentShow(lastFlag);
        DefaultAuthReporter.INSTANCE.reportFaceCheckShow(sourceEvent());
        this.isClick = false;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    private final void watchText(TextView $this$watchText, Function1<? super String, Unit> function1) {
        $this$watchText.addTextChangedListener(new SimpleNotifyTextWatcher(function1));
    }
}