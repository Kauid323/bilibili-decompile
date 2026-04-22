package tv.danmaku.bili.push.pushsetting.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.droid.WindowManagerHelper;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.RoundingParams;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.ui.theme.ThemeWatcher;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.magicasakura.widgets.Tintable;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import tv.danmaku.android.log.BLog;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.push.pushsetting.model.PushBanner;
import tv.danmaku.bili.push.pushsetting.model.PushCallBackInfo;
import tv.danmaku.bili.push.pushsetting.model.PushDialogType;
import tv.danmaku.bili.push.pushsetting.model.PushNotice;
import tv.danmaku.bili.push.pushsetting.reporter.PushSettingReporterKt;
import tv.danmaku.bili.push.pushsetting.service.PushSettingServiceHelperKt;
import tv.danmaku.bili.push.pushsetting.system.SystemPushDialogHelperKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: BasePushSettingDialog.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH&J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J&\u0010#\u001a\u0004\u0018\u00010\u00152\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J(\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u000bH\u0086@¢\u0006\u0002\u00100J\b\u00101\u001a\u00020 H\u0002J\u0010\u00102\u001a\u00020 2\u0006\u0010)\u001a\u00020\u0015H\u0002J\b\u00103\u001a\u00020 H\u0002J\u0010\u00104\u001a\u00020 2\u0006\u0010)\u001a\u00020\u0015H\u0003J\b\u00105\u001a\u00020 H\u0002J\b\u00106\u001a\u00020 H\u0002J\b\u00107\u001a\u00020 H\u0016J\u0010\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020 H\u0016J\b\u0010<\u001a\u00020\u000bH\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Ltv/danmaku/bili/push/pushsetting/ui/BasePushSettingDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "mPushData", "Ltv/danmaku/bili/push/pushsetting/model/PushCallBackInfo;", "getMPushData", "()Ltv/danmaku/bili/push/pushsetting/model/PushCallBackInfo;", "setMPushData", "(Ltv/danmaku/bili/push/pushsetting/model/PushCallBackInfo;)V", "mTypeFrom", "", "mFromSpmid", "mInDialogManager", "", "mTopBanner", "Lcom/bilibili/lib/image2/view/BiliImageView;", "mTitle", "Landroid/widget/TextView;", "mOpenButton", "mCloseBtn", "Landroid/view/View;", "getMCloseBtn", "()Landroid/view/View;", "setMCloseBtn", "(Landroid/view/View;)V", "observer", "Lcom/bilibili/lib/ui/theme/ThemeWatcher$Observer;", "showSystemDialogWhenDismiss", "getLayoutResId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "suspendShow", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/appcompat/app/AppCompatActivity;", "manager", "Landroidx/fragment/app/FragmentManager;", AppConfig.HOST_TAG, "(Landroidx/appcompat/app/AppCompatActivity;Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureChecked", "initBanner", "updateBanner", "doTint", "reportConfirmClick", "handleOpenClick", "onStart", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDestroyView", "getClickMsg", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class BasePushSettingDialog extends DialogFragment {
    public static final int $stable = 8;
    private View mCloseBtn;
    private TextView mOpenButton;
    private PushCallBackInfo mPushData;
    private TextView mTitle;
    private BiliImageView mTopBanner;
    private String mTypeFrom;
    private boolean showSystemDialogWhenDismiss;
    private String mFromSpmid = "";
    private boolean mInDialogManager = true;
    private final ThemeWatcher.Observer observer = new ThemeWatcher.Observer() { // from class: tv.danmaku.bili.push.pushsetting.ui.BasePushSettingDialog$$ExternalSyntheticLambda2
        public final void onThemeChanged() {
            BasePushSettingDialog.observer$lambda$0(BasePushSettingDialog.this);
        }
    };

    public abstract int getLayoutResId();

    /* JADX INFO: Access modifiers changed from: protected */
    public final PushCallBackInfo getMPushData() {
        return this.mPushData;
    }

    protected final void setMPushData(PushCallBackInfo pushCallBackInfo) {
        this.mPushData = pushCallBackInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View getMCloseBtn() {
        return this.mCloseBtn;
    }

    protected final void setMCloseBtn(View view) {
        this.mCloseBtn = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observer$lambda$0(BasePushSettingDialog this$0) {
        this$0.updateBanner();
        View it = this$0.getView();
        if (it != null) {
            this$0.doTint(it);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        Object obj = arguments != null ? arguments.get(PushSettingDialogFactoryKt.KEY_PUSH_CARD) : null;
        this.mPushData = obj instanceof PushCallBackInfo ? (PushCallBackInfo) obj : null;
        Bundle arguments2 = getArguments();
        this.mInDialogManager = arguments2 != null ? arguments2.getBoolean(PushSettingDialogFactoryKt.KEY_SHOW_DIALOG_MANAGER, true) : true;
        Bundle arguments3 = getArguments();
        Object obj2 = arguments3 != null ? arguments3.get(PushSettingDialogFactoryKt.KEY_TYPE_FROM) : null;
        this.mTypeFrom = obj2 instanceof String ? (String) obj2 : null;
        Bundle arguments4 = getArguments();
        Object obj3 = arguments4 != null ? arguments4.get(PushSettingDialogFactoryKt.KEY_PUSH_SPMID) : null;
        String str = obj3 instanceof String ? (String) obj3 : null;
        if (str == null) {
            str = "";
        }
        this.mFromSpmid = str;
        ensureChecked();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(getLayoutResId(), container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initBanner(view);
        this.mTitle = (TextView) view.findViewById(R.id.title);
        TextView textView = this.mTitle;
        if (textView != null) {
            PushCallBackInfo pushCallBackInfo = this.mPushData;
            textView.setText(pushCallBackInfo != null ? pushCallBackInfo.title : null);
        }
        this.mOpenButton = (TextView) view.findViewById(R.id.open);
        TextView textView2 = this.mOpenButton;
        if (textView2 != null) {
            PushCallBackInfo pushCallBackInfo2 = this.mPushData;
            textView2.setText(pushCallBackInfo2 != null ? pushCallBackInfo2.openButton : null);
        }
        TextView textView3 = this.mOpenButton;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.push.pushsetting.ui.BasePushSettingDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BasePushSettingDialog.onViewCreated$lambda$0(BasePushSettingDialog.this, view2);
                }
            });
        }
        this.mCloseBtn = view.findViewById(R.id.close);
        View view2 = this.mCloseBtn;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.push.pushsetting.ui.BasePushSettingDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    BasePushSettingDialog.onViewCreated$lambda$1(BasePushSettingDialog.this, view3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(BasePushSettingDialog this$0, View it) {
        this$0.reportConfirmClick();
        PushCallBackInfo pushCallBackInfo = this$0.mPushData;
        if (pushCallBackInfo != null && pushCallBackInfo.confirmAction == 1) {
            Activity activity = this$0.getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            if (SystemPushDialogHelperKt.canShowSystemPushDialog((AppCompatActivity) activity)) {
                this$0.showSystemDialogWhenDismiss = true;
                this$0.dismissAllowingStateLoss();
                return;
            }
        }
        this$0.showSystemDialogWhenDismiss = false;
        this$0.handleOpenClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(BasePushSettingDialog this$0, View it) {
        PushDialogType pushDialogType = PushDialogType.DIY;
        String str = this$0.mTypeFrom;
        if (str == null) {
            str = "0";
        }
        String str2 = this$0.mFromSpmid;
        String clickMsg = this$0.getClickMsg();
        PushCallBackInfo pushCallBackInfo = this$0.mPushData;
        PushSettingReporterKt.reportPushDialogClick(pushDialogType, str, str2, "0", (r14 & 16) != 0 ? "" : clickMsg, (r14 & 32) != 0 ? null : pushCallBackInfo != null ? pushCallBackInfo.abMsg : null, (r14 & 64) != 0 ? 1 : 0);
        BLog.i("[Push]BasePushSettingDialog", "setListener, close button clicked");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object suspendShow(AppCompatActivity activity, FragmentManager manager, String tag, Continuation<? super Unit> continuation) {
        Continuation $continuation;
        AppCompatActivity activity2;
        BasePushSettingDialog basePushSettingDialog;
        if (continuation instanceof BasePushSettingDialog$suspendShow$1) {
            $continuation = (BasePushSettingDialog$suspendShow$1) continuation;
            if (($continuation.label & Integer.MIN_VALUE) != 0) {
                $continuation.label -= Integer.MIN_VALUE;
                Object $result = $continuation.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $continuation.L$0 = activity;
                        $continuation.L$1 = manager;
                        $continuation.L$2 = tag;
                        $continuation.label = 1;
                        Continuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted($continuation));
                        final Continuation it = safeContinuation;
                        try {
                            showNow(manager, tag);
                            getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: tv.danmaku.bili.push.pushsetting.ui.BasePushSettingDialog$suspendShow$2$1
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
                                    Intrinsics.checkNotNullParameter(owner, "owner");
                                    DefaultLifecycleObserver.-CC.$default$onDestroy(this, owner);
                                    BasePushSettingDialog.this.getLifecycle().removeObserver((LifecycleObserver) this);
                                    Continuation<Unit> continuation2 = it;
                                    Result.Companion companion = Result.Companion;
                                    continuation2.resumeWith(Result.constructor-impl(Unit.INSTANCE));
                                }
                            });
                        } catch (Throwable t) {
                            BLog.e("[Push]BasePushSettingDialog", "suspendShow, error = " + t.getMessage());
                            Result.Companion companion = Result.Companion;
                            it.resumeWith(Result.constructor-impl(ResultKt.createFailure(t)));
                        }
                        Object orThrow = safeContinuation.getOrThrow();
                        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended($continuation);
                        }
                        if (orThrow == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        activity2 = activity;
                        basePushSettingDialog = this;
                        if (basePushSettingDialog.showSystemDialogWhenDismiss) {
                            basePushSettingDialog.showSystemDialogWhenDismiss = false;
                            String str = basePushSettingDialog.mTypeFrom;
                            if (str == null) {
                                str = "";
                            }
                            String str2 = basePushSettingDialog.mFromSpmid;
                            $continuation.L$0 = null;
                            $continuation.L$1 = null;
                            $continuation.L$2 = null;
                            $continuation.label = 2;
                            if (SystemPushDialogHelperKt.showSystemPushDialogSuspend(activity2, str, str2, 2, $continuation) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        basePushSettingDialog = this;
                        String str3 = (String) $continuation.L$2;
                        FragmentManager fragmentManager = (FragmentManager) $continuation.L$1;
                        activity2 = (AppCompatActivity) $continuation.L$0;
                        ResultKt.throwOnFailure($result);
                        if (basePushSettingDialog.showSystemDialogWhenDismiss) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        $continuation = new BasePushSettingDialog$suspendShow$1(this, continuation);
        Object $result2 = $continuation.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
        }
    }

    private final void ensureChecked() {
        Object obj;
        PushCallBackInfo pushCallBackInfo = this.mPushData;
        Object obj2 = null;
        List notices = pushCallBackInfo != null ? pushCallBackInfo.notices : null;
        List it = notices;
        List list = it;
        if (list == null || list.isEmpty()) {
            notices = null;
        }
        if (notices == null) {
            return;
        }
        Iterator<T> it2 = notices.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            PushNotice it3 = (PushNotice) obj;
            if (it3.isChecked()) {
                break;
            }
        }
        if (obj != null) {
            return;
        }
        Iterator<T> it4 = notices.iterator();
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            Object next = it4.next();
            PushNotice it5 = (PushNotice) next;
            if (it5.getDefault()) {
                obj2 = next;
                break;
            }
        }
        PushNotice notice = (PushNotice) obj2;
        if (notice == null) {
            notice = notices.get(0);
        }
        if (notice != null) {
            notice.setChecked(true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
        if (r3.templateType == 1) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initBanner(View view) {
        boolean z;
        ViewGroup.LayoutParams layoutParams;
        this.mTopBanner = view.findViewById(R.id.top_banner);
        PushCallBackInfo pushCallBackInfo = this.mPushData;
        ViewGroup.LayoutParams $this$initBanner_u24lambda_u240 = null;
        PushBanner banner = pushCallBackInfo != null ? pushCallBackInfo.banner : null;
        if (banner == null || banner.getWidth() == 0) {
            BiliImageView biliImageView = this.mTopBanner;
            if (biliImageView != null) {
                biliImageView.setVisibility(8);
                return;
            }
            return;
        }
        int displayWidth = WindowManagerHelper.getDisplayWidth(getContext());
        PushCallBackInfo pushCallBackInfo2 = this.mPushData;
        if (pushCallBackInfo2 != null) {
            z = true;
        }
        z = false;
        int bannerWidth = displayWidth - (z ? ListExtentionsKt.toPx(96) : 0);
        int bannerHeight = (int) ((banner.getHeight() / banner.getWidth()) * bannerWidth);
        BiliImageView biliImageView2 = this.mTopBanner;
        if (biliImageView2 != null) {
            BiliImageView biliImageView3 = this.mTopBanner;
            if (biliImageView3 != null && (layoutParams = biliImageView3.getLayoutParams()) != null) {
                $this$initBanner_u24lambda_u240 = layoutParams;
                $this$initBanner_u24lambda_u240.height = bannerHeight;
            }
            biliImageView2.setLayoutParams($this$initBanner_u24lambda_u240);
        }
        BiliImageView biliImageView4 = this.mTopBanner;
        if (biliImageView4 != null) {
            biliImageView4.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: tv.danmaku.bili.push.pushsetting.ui.BasePushSettingDialog$initBanner$2
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v) {
                    ThemeWatcher.Observer observer;
                    Intrinsics.checkNotNullParameter(v, "v");
                    ThemeWatcher themeWatcher = ThemeWatcher.getInstance();
                    observer = BasePushSettingDialog.this.observer;
                    themeWatcher.subscribe(observer);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View v) {
                    ThemeWatcher.Observer observer;
                    Intrinsics.checkNotNullParameter(v, "v");
                    ThemeWatcher themeWatcher = ThemeWatcher.getInstance();
                    observer = BasePushSettingDialog.this.observer;
                    themeWatcher.unSubscribe(observer);
                }
            });
        }
        updateBanner();
    }

    private final void updateBanner() {
        BiliImageView topBanner;
        PushBanner pushBanner;
        String url;
        PushBanner pushBanner2;
        Context ctx = getContext();
        if (ctx == null || (topBanner = this.mTopBanner) == null) {
            return;
        }
        if (MultipleThemeUtils.isNightTheme(ctx)) {
            PushCallBackInfo pushCallBackInfo = this.mPushData;
            url = (pushCallBackInfo == null || (pushBanner2 = pushCallBackInfo.banner) == null) ? null : pushBanner2.getNightImage();
        } else {
            PushCallBackInfo pushCallBackInfo2 = this.mPushData;
            if (pushCallBackInfo2 == null || (pushBanner = pushCallBackInfo2.banner) == null || (url = pushBanner.getDayImage()) == null) {
                return;
            }
        }
        PushCallBackInfo pushCallBackInfo3 = this.mPushData;
        float radius = ListExtentionsKt.toPx(pushCallBackInfo3 != null && pushCallBackInfo3.templateType == 1 ? 8 : 12);
        RoundingParams roundingParams = RoundingParams.Companion.fromCornersRadii(radius, radius, 0.0f, 0.0f);
        ImageRequestBuilder.enableAutoPlayAnimation$default(BiliImageLoader.INSTANCE.with(ctx).url(url).roundingParams(roundingParams), true, false, 2, (Object) null).into(topBanner);
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

    private final void reportConfirmClick() {
        PushDialogType pushDialogType = PushDialogType.DIY;
        String str = this.mTypeFrom;
        if (str == null) {
            str = "0";
        }
        String str2 = this.mFromSpmid;
        String clickMsg = getClickMsg();
        PushCallBackInfo pushCallBackInfo = this.mPushData;
        PushSettingReporterKt.reportPushDialogClick(pushDialogType, str, str2, "1", (r14 & 16) != 0 ? "" : clickMsg, (r14 & 32) != 0 ? null : pushCallBackInfo != null ? pushCallBackInfo.abMsg : null, (r14 & 64) != 0 ? 1 : 0);
    }

    private final void handleOpenClick() {
        BLog.i("[Push]BasePushSettingDialog", "handleOpenClick, open clicked");
        Intent intent = new Intent();
        intent.setFlags(268435456);
        if (Build.VERSION.SDK_INT >= 26) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", requireActivity().getPackageName());
        } else {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", requireActivity().getPackageName());
            intent.putExtra("app_uid", requireActivity().getApplicationInfo().uid);
        }
        startActivity(intent);
        PushCallBackInfo pushCallBackInfo = this.mPushData;
        boolean z = false;
        if (pushCallBackInfo != null && pushCallBackInfo.noticeQuery) {
            z = true;
        }
        if (z) {
            PushCallBackInfo pushCallBackInfo2 = this.mPushData;
            PushSettingServiceHelperKt.updatePushSetting(pushCallBackInfo2 != null ? pushCallBackInfo2.notices : null);
        }
        dismissAllowingStateLoss();
    }

    public void onStart() {
        Window window;
        Window window2;
        Window window3;
        WindowManager.LayoutParams attributes;
        Window window4;
        super.onStart();
        PushCallBackInfo pushCallBackInfo = this.mPushData;
        boolean z = true;
        int gravity = pushCallBackInfo != null && pushCallBackInfo.templateType == 1 ? 17 : 80;
        PushCallBackInfo pushCallBackInfo2 = this.mPushData;
        if (pushCallBackInfo2 == null || pushCallBackInfo2.templateType != 1) {
            z = false;
        }
        int showAnimationResId = z ? 16973826 : 16973910;
        Dialog dialog = getDialog();
        if (dialog != null && (window4 = dialog.getWindow()) != null) {
            window4.setBackgroundDrawable(new ColorDrawable(0));
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window3 = dialog2.getWindow()) != null && (attributes = window3.getAttributes()) != null) {
            attributes.gravity = gravity;
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null && (window2 = dialog3.getWindow()) != null) {
            window2.setLayout(-1, -2);
        }
        Dialog dialog4 = getDialog();
        if (dialog4 == null || (window = dialog4.getWindow()) == null) {
            return;
        }
        window.setWindowAnimations(showAnimationResId);
    }

    public void onCancel(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        PushDialogType pushDialogType = PushDialogType.DIY;
        String str = this.mTypeFrom;
        if (str == null) {
            str = "0";
        }
        String str2 = str;
        String str3 = this.mFromSpmid;
        String clickMsg = getClickMsg();
        PushCallBackInfo pushCallBackInfo = this.mPushData;
        PushSettingReporterKt.reportPushDialogClick(pushDialogType, str2, str3, "0", (r14 & 16) != 0 ? "" : clickMsg, (r14 & 32) != 0 ? null : pushCallBackInfo != null ? pushCallBackInfo.abMsg : null, (r14 & 64) != 0 ? 1 : 0);
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.mInDialogManager) {
            MainDialogManager.showNextDialog("push_guide", false, getContext());
        }
    }

    private final String getClickMsg() {
        List<PushNotice> list;
        Object obj;
        PushCallBackInfo pushCallBackInfo = this.mPushData;
        if (pushCallBackInfo == null || (list = pushCallBackInfo.notices) == null) {
            return "";
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            PushNotice it2 = (PushNotice) obj;
            if (it2.isChecked()) {
                break;
            }
        }
        PushNotice notice = (PushNotice) obj;
        if (notice == null) {
            return "";
        }
        String json = new Gson().toJson(MapsKt.mapOf(new Pair[]{TuplesKt.to("types", notice.getTypes()), TuplesKt.to("text", notice.getText())}));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }
}