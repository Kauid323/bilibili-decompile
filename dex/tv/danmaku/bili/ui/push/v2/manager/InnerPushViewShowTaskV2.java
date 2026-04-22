package tv.danmaku.bili.ui.push.v2.manager;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.image2.bean.ImageInfo;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.module.main.innerpush.InnerPush;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.push.innerpush.model.InnerPushExtensionKt;
import tv.danmaku.bili.ui.push.v2.InnerPushView;
import tv.danmaku.bili.utils.UniversalHelper;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: InnerPushViewShowTaskV2.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0013\u001a\u00020\tH\u0002J\u0006\u0010\u0014\u001a\u00020\tJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001cJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ \u0010 \u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\"H\u0002J4\u0010#\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010\u001e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0086@¢\u0006\u0002\u0010%J4\u0010&\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010\u001e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0086@¢\u0006\u0002\u0010%J\u001e\u0010'\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\"H\u0002J\u001e\u0010(\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\"H\u0002J\n\u0010)\u001a\u0004\u0018\u00010*H\u0002J\b\u0010+\u001a\u00020\tH\u0002J\"\u0010,\u001a\u00020\t2\b\b\u0001\u0010-\u001a\u00020\u00162\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\"H\u0002J\u0018\u0010\u0014\u001a\u00020\t2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\"H\u0002J\u001e\u00100\u001a\u00020\t2\u0006\u00101\u001a\u0002022\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\"H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Ltv/danmaku/bili/ui/push/v2/manager/InnerPushViewShowTaskV2;", "", "push", "Lcom/bilibili/module/main/innerpush/InnerPush;", "viewStatusListener", "Ltv/danmaku/bili/ui/push/v2/manager/InnerPushStatusListener;", "pushClickListener", "Lkotlin/Function1;", "Landroid/content/Context;", "", "<init>", "(Lcom/bilibili/module/main/innerpush/InnerPush;Ltv/danmaku/bili/ui/push/v2/manager/InnerPushStatusListener;Lkotlin/jvm/functions/Function1;)V", "mInnerPushView", "Ltv/danmaku/bili/ui/push/v2/InnerPushView;", "mWindowManager", "Landroid/view/WindowManager;", "mReportExtra", "", "", "registerOrientation", "dismiss", "bizType", "", "reportExtra", "show", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContainerView", "Landroid/view/View;", "getCurrentContainerView", "setupContainer", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "replaceBizView", "bizView", "(Landroidx/appcompat/app/AppCompatActivity;Landroid/view/View;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showBizView", "setUpFrame", "setupWidgets", "generateSlideInAnimator", "Landroid/animation/ObjectAnimator;", "animateIn", "animateOut", "way", "animateOutRunnable", "Ljava/lang/Runnable;", "startCountDown", "timeMillis", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class InnerPushViewShowTaskV2 {
    public static final int $stable = 8;
    private Runnable animateOutRunnable;
    private InnerPushView mInnerPushView;
    private Map<String, String> mReportExtra;
    private WindowManager mWindowManager;
    private final InnerPush push;
    private final Function1<Context, Unit> pushClickListener;
    private final InnerPushStatusListener viewStatusListener;

    /* JADX WARN: Multi-variable type inference failed */
    public InnerPushViewShowTaskV2(InnerPush push, InnerPushStatusListener viewStatusListener, Function1<? super Context, Unit> function1) {
        Intrinsics.checkNotNullParameter(push, "push");
        Intrinsics.checkNotNullParameter(viewStatusListener, "viewStatusListener");
        Intrinsics.checkNotNullParameter(function1, "pushClickListener");
        this.push = push;
        this.viewStatusListener = viewStatusListener;
        this.pushClickListener = function1;
        this.mReportExtra = MapsKt.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerOrientation() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new InnerPushViewShowTaskV2$registerOrientation$1(this, null), 3, (Object) null);
    }

    public final void dismiss() {
        dismiss(null);
    }

    public final int bizType() {
        return this.push.getType();
    }

    public final Map<String, String> reportExtra() {
        return this.mReportExtra;
    }

    public final Object show(AppCompatActivity activity, Continuation<? super Boolean> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation continuation2 = cancellableContinuationImpl;
        setUpFrame(activity, continuation2);
        setupWidgets(this.push, continuation2);
        startCountDown(InnerPushExtensionKt.getDurationMs(this.push), continuation2);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final Object getContainerView(AppCompatActivity activity, Continuation<? super View> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation continuation2 = cancellableContinuationImpl;
        registerOrientation();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new InnerPushViewShowTaskV2$getContainerView$2$1(this, activity, continuation2, null), 3, (Object) null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final View getCurrentContainerView() {
        return this.mInnerPushView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupContainer(final AppCompatActivity activity, CancellableContinuation<? super View> cancellableContinuation) {
        View contentView = activity.findViewById(16908290);
        if (contentView == null) {
            Result.Companion companion = Result.Companion;
            ((Continuation) cancellableContinuation).resumeWith(Result.constructor-impl((Object) null));
            return;
        }
        activity.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: tv.danmaku.bili.ui.push.v2.manager.InnerPushViewShowTaskV2$setupContainer$1
            public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.-CC.$default$onCreate(this, lifecycleOwner);
            }

            public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.-CC.$default$onDestroy(this, lifecycleOwner);
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

            public void onPause(LifecycleOwner owner) {
                WindowManager windowManager;
                Intrinsics.checkNotNullParameter(owner, "owner");
                activity.getLifecycle().removeObserver((LifecycleObserver) this);
                BLog.i("[InnerPush]InnerPushViewShowTaskV2", "dismiss, dismiss by activity stop");
                InnerPushView innerPushView = this.mInnerPushView;
                if (innerPushView != null && innerPushView.getWindowToken() != null) {
                    InnerPushViewShowTaskV2 innerPushViewShowTaskV2 = this;
                    try {
                        windowManager = innerPushViewShowTaskV2.mWindowManager;
                        if (windowManager != null) {
                            windowManager.removeViewImmediate(innerPushViewShowTaskV2.mInnerPushView);
                            Unit unit = Unit.INSTANCE;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            }
        });
        this.mInnerPushView = new InnerPushView((Context) activity, true, null, 0, 12, null);
        Result.Companion companion2 = Result.Companion;
        ((Continuation) cancellableContinuation).resumeWith(Result.constructor-impl(this.mInnerPushView));
    }

    public final Object replaceBizView(AppCompatActivity activity, View bizView, Map<String, String> map, Continuation<? super Boolean> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation continuation2 = cancellableContinuationImpl;
        View contentView = activity.findViewById(16908290);
        if (contentView == null) {
            dismiss(continuation2);
        } else {
            this.mReportExtra = map;
            BLog.i("[InnerPush]InnerPushViewShowTaskV2", "replaceBizView");
            InnerPushView innerPushView = this.mInnerPushView;
            if (innerPushView != null) {
                innerPushView.replaceBizView(bizView);
            }
            Runnable it = this.animateOutRunnable;
            if (it != null) {
                HandlerThreads.getHandler(0).removeCallbacks(it);
                startCountDown(InnerPushExtensionKt.getDurationMs(this.push), continuation2);
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final Object showBizView(AppCompatActivity activity, View bizView, Map<String, String> map, Continuation<? super Boolean> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation continuation2 = cancellableContinuationImpl;
        View contentView = activity.findViewById(16908290);
        if (contentView == null) {
            dismiss(continuation2);
        } else {
            this.mReportExtra = map;
            BLog.i("[InnerPush]InnerPushViewShowTaskV2", "showBizView");
            final WindowManager.LayoutParams $this$showBizView_u24lambda_u240_u240 = new WindowManager.LayoutParams(-1, -2, 0, 0, -2);
            $this$showBizView_u24lambda_u240_u240.flags = 65832;
            $this$showBizView_u24lambda_u240_u240.x = 0;
            $this$showBizView_u24lambda_u240_u240.y = 0;
            $this$showBizView_u24lambda_u240_u240.gravity = 51;
            $this$showBizView_u24lambda_u240_u240.type = IjkMediaCodecInfo.RANK_MAX;
            Object systemService = activity.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            this.mWindowManager = (WindowManager) systemService;
            InnerPushView innerPushView = this.mInnerPushView;
            if (innerPushView != null) {
                innerPushView.addBizView(bizView, this.viewStatusListener);
            }
            InnerPushView innerPushView2 = this.mInnerPushView;
            if (innerPushView2 != null) {
                innerPushView2.setVisibility(8);
            }
            contentView.post(new Runnable() { // from class: tv.danmaku.bili.ui.push.v2.manager.InnerPushViewShowTaskV2$showBizView$2$1
                @Override // java.lang.Runnable
                public final void run() {
                    WindowManager windowManager;
                    try {
                        BLog.i("[InnerPush]InnerPushViewShowTaskV2", "setUpFrame, do add view");
                        windowManager = InnerPushViewShowTaskV2.this.mWindowManager;
                        if (windowManager != null) {
                            windowManager.addView(InnerPushViewShowTaskV2.this.mInnerPushView, $this$showBizView_u24lambda_u240_u240);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        InnerPushViewShowTaskV2.this.dismiss(continuation2);
                    }
                }
            });
            final Function1 action = this.pushClickListener;
            InnerPushView innerPushView3 = this.mInnerPushView;
            if (innerPushView3 != null) {
                innerPushView3.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.push.v2.manager.InnerPushViewShowTaskV2$showBizView$2$2$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View v) {
                        InnerPushViewShowTaskV2.this.animateOut(-1, continuation2);
                        Function1<Context, Unit> function1 = action;
                        Context context = v.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        function1.invoke(context);
                    }
                });
            }
            InnerPushView innerPushView4 = this.mInnerPushView;
            if (innerPushView4 != null) {
                innerPushView4.setOffScreenCallback(new Function0<Unit>() { // from class: tv.danmaku.bili.ui.push.v2.manager.InnerPushViewShowTaskV2$showBizView$2$3
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1440invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: collision with other method in class */
                    public final void m1440invoke() {
                        BLog.i("[InnerPush]InnerPushViewShowTaskV2", "dismiss, dismiss cause by offscreen");
                        InnerPushViewShowTaskV2.this.dismiss(continuation2);
                    }
                });
            }
            animateIn();
            startCountDown(InnerPushExtensionKt.getDurationMs(this.push), continuation2);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUpFrame(final AppCompatActivity activity, final CancellableContinuation<? super Boolean> cancellableContinuation) {
        View contentView = activity.findViewById(16908290);
        if (contentView == null) {
            dismiss(cancellableContinuation);
            return;
        }
        activity.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: tv.danmaku.bili.ui.push.v2.manager.InnerPushViewShowTaskV2$setUpFrame$1
            public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.-CC.$default$onCreate(this, lifecycleOwner);
            }

            public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.-CC.$default$onDestroy(this, lifecycleOwner);
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

            public void onPause(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                activity.getLifecycle().removeObserver((LifecycleObserver) this);
                BLog.i("[InnerPush]InnerPushViewShowTaskV2", "dismiss, dismiss by activity stop");
                this.dismiss(cancellableContinuation);
            }
        });
        final WindowManager.LayoutParams $this$setUpFrame_u24lambda_u240 = new WindowManager.LayoutParams(-1, -2, 0, 0, -2);
        $this$setUpFrame_u24lambda_u240.flags = 65832;
        $this$setUpFrame_u24lambda_u240.x = 0;
        $this$setUpFrame_u24lambda_u240.y = 0;
        $this$setUpFrame_u24lambda_u240.gravity = 51;
        $this$setUpFrame_u24lambda_u240.type = IjkMediaCodecInfo.RANK_MAX;
        Object systemService = activity.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.mWindowManager = (WindowManager) systemService;
        this.mInnerPushView = new InnerPushView((Context) activity, false, null, 0, 14, null);
        InnerPushView innerPushView = this.mInnerPushView;
        if (innerPushView != null) {
            innerPushView.setVisibility(8);
        }
        contentView.post(new Runnable() { // from class: tv.danmaku.bili.ui.push.v2.manager.InnerPushViewShowTaskV2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                InnerPushViewShowTaskV2.setUpFrame$lambda$1(InnerPushViewShowTaskV2.this, $this$setUpFrame_u24lambda_u240, cancellableContinuation);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpFrame$lambda$1(InnerPushViewShowTaskV2 this$0, WindowManager.LayoutParams $layoutParams, CancellableContinuation $continuation) {
        try {
            BLog.i("[InnerPush]InnerPushViewShowTaskV2", "setUpFrame, do add view");
            WindowManager windowManager = this$0.mWindowManager;
            if (windowManager != null) {
                windowManager.addView(this$0.mInnerPushView, $layoutParams);
            }
        } catch (Exception e) {
            e.printStackTrace();
            this$0.dismiss($continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupWidgets(final InnerPush push, final CancellableContinuation<? super Boolean> cancellableContinuation) {
        InnerPushView innerPushView = this.mInnerPushView;
        if (innerPushView != null) {
            innerPushView.update(push, this.viewStatusListener, new ImageLoadingListener() { // from class: tv.danmaku.bili.ui.push.v2.manager.InnerPushViewShowTaskV2$setupWidgets$1
                public /* synthetic */ void onImageLoading(Uri uri) {
                    ImageLoadingListener.-CC.$default$onImageLoading(this, uri);
                }

                public /* synthetic */ void onImageSet(ImageInfo imageInfo, Bitmap bitmap) {
                    ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo, bitmap);
                }

                public /* synthetic */ void onIntermediateImageSet(ImageInfo imageInfo) {
                    ImageLoadingListener.-CC.$default$onIntermediateImageSet(this, imageInfo);
                }

                public void onImageSet(ImageInfo imageInfo) {
                    ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo);
                    if (InnerPushExtensionKt.isImageType(push)) {
                        this.animateIn();
                    }
                }

                public void onImageLoadFailed(Throwable err) {
                    ImageLoadingListener.-CC.$default$onImageLoadFailed(this, err);
                    if (InnerPushExtensionKt.isImageType(push)) {
                        BLog.i("[InnerPush]InnerPushViewShowTaskV2", "dismiss, dismiss by image load failed");
                        this.dismiss(cancellableContinuation);
                    }
                }
            });
        }
        final Function1 action = this.pushClickListener;
        InnerPushView innerPushView2 = this.mInnerPushView;
        if (innerPushView2 != null) {
            innerPushView2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.push.v2.manager.InnerPushViewShowTaskV2$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    InnerPushViewShowTaskV2.setupWidgets$lambda$0$0(InnerPushViewShowTaskV2.this, cancellableContinuation, action, view2);
                }
            });
        }
        InnerPushView innerPushView3 = this.mInnerPushView;
        if (innerPushView3 != null) {
            innerPushView3.setOffScreenCallback(new Function0() { // from class: tv.danmaku.bili.ui.push.v2.manager.InnerPushViewShowTaskV2$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit unit;
                    unit = InnerPushViewShowTaskV2.setupWidgets$lambda$1(InnerPushViewShowTaskV2.this, cancellableContinuation);
                    return unit;
                }
            });
        }
        if (!InnerPushExtensionKt.isImageType(push)) {
            animateIn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupWidgets$lambda$0$0(InnerPushViewShowTaskV2 this$0, CancellableContinuation $continuation, Function1 $action, View v) {
        this$0.animateOut(-1, $continuation);
        Context context = v.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        $action.invoke(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupWidgets$lambda$1(InnerPushViewShowTaskV2 this$0, CancellableContinuation $continuation) {
        BLog.i("[InnerPush]InnerPushViewShowTaskV2", "dismiss, dismiss cause by offscreen");
        this$0.dismiss($continuation);
        return Unit.INSTANCE;
    }

    private final ObjectAnimator generateSlideInAnimator() {
        int i;
        InnerPushView pushView = this.mInnerPushView;
        if (pushView == null) {
            return null;
        }
        pushView.measure(0, 0);
        int popType = this.push.getPopType();
        i = InnerPushViewShowTaskV2Kt.SLIDE_FROM_RIGHT;
        if (popType == i) {
            return ObjectAnimator.ofFloat(pushView, "translationX", UniversalHelper.getScreenWidth(BiliContext.application()), DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        }
        return ObjectAnimator.ofFloat(pushView, "translationY", -pushView.getMeasuredHeight(), DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateIn() {
        BLog.i("[InnerPush]InnerPushViewShowTaskV2", "animateIn");
        ObjectAnimator animator = generateSlideInAnimator();
        if (animator == null) {
            return;
        }
        animator.setDuration(300L);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.addListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.bili.ui.push.v2.manager.InnerPushViewShowTaskV2$animateIn$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                InnerPushView innerPushView = InnerPushViewShowTaskV2.this.mInnerPushView;
                if (innerPushView != null) {
                    innerPushView.setVisibility(0);
                }
                InnerPushStatusListener innerPushStatusListener = InnerPushViewShowTaskV2.this.viewStatusListener;
                InnerPushView innerPushView2 = InnerPushViewShowTaskV2.this.mInnerPushView;
                innerPushStatusListener.onShow(innerPushView2 != null ? innerPushView2.getContext() : null);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateOut(@DismissWay final int way, final CancellableContinuation<? super Boolean> cancellableContinuation) {
        final InnerPushView pushView = this.mInnerPushView;
        if (pushView == null) {
            return;
        }
        ObjectAnimator animator = ObjectAnimator.ofFloat(pushView, "translationY", DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, -pushView.getHeight());
        Intrinsics.checkNotNullExpressionValue(animator, "ofFloat(...)");
        animator.setDuration(300L);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.addListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.bili.ui.push.v2.manager.InnerPushViewShowTaskV2$animateOut$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                InnerPushView.this.setVisibility(8);
                BLog.i("[InnerPush]InnerPushViewShowTaskV2", "dismiss, dismiss cause animation end");
                this.dismiss(cancellableContinuation);
                if (way != -1) {
                    this.viewStatusListener.onDismiss(InnerPushView.this.getContext(), way);
                }
            }
        });
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismiss(CancellableContinuation<? super Boolean> cancellableContinuation) {
        this.animateOutRunnable = null;
        InnerPushView innerPushView = this.mInnerPushView;
        if (innerPushView != null && innerPushView.getWindowToken() != null) {
            try {
                WindowManager windowManager = this.mWindowManager;
                if (windowManager != null) {
                    windowManager.removeViewImmediate(this.mInnerPushView);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Exception e) {
                e.printStackTrace();
                Unit unit2 = Unit.INSTANCE;
            }
        }
        boolean z = false;
        if (cancellableContinuation != null && cancellableContinuation.isActive()) {
            z = true;
        }
        if (z) {
            Result.Companion companion = Result.Companion;
            ((Continuation) cancellableContinuation).resumeWith(Result.constructor-impl(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startCountDown(long timeMillis, final CancellableContinuation<? super Boolean> cancellableContinuation) {
        final Handler handler = HandlerThreads.getHandler(0);
        final Runnable block = new Runnable() { // from class: tv.danmaku.bili.ui.push.v2.manager.InnerPushViewShowTaskV2$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                InnerPushViewShowTaskV2.this.animateOut(0, cancellableContinuation);
            }
        };
        this.animateOutRunnable = block;
        Runnable runnable = this.animateOutRunnable;
        if (runnable != null) {
            if (handler.postDelayed(runnable, timeMillis)) {
                cancellableContinuation.invokeOnCancellation(new Function1() { // from class: tv.danmaku.bili.ui.push.v2.manager.InnerPushViewShowTaskV2$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit startCountDown$lambda$1$0;
                        startCountDown$lambda$1$0 = InnerPushViewShowTaskV2.startCountDown$lambda$1$0(handler, block, (Throwable) obj);
                        return startCountDown$lambda$1$0;
                    }
                });
            } else {
                dismiss(cancellableContinuation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startCountDown$lambda$1$0(Handler $handler, Runnable $block, Throwable it) {
        $handler.removeCallbacks($block);
        return Unit.INSTANCE;
    }
}