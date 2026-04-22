package tv.danmaku.bili.push.innerpush.v2;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.lib.image2.bean.ImageDataSubscriber;
import com.bilibili.lib.imageviewer.utils.ImageExtentionKt;
import com.bilibili.lib.ui.IDrawerHost;
import com.bilibili.module.main.innerpush.BizState;
import com.bilibili.module.main.innerpush.BizStateTrigger;
import com.bilibili.module.main.innerpush.InnerPush;
import com.bilibili.module.main.innerpush.InnerPushRule;
import com.bilibili.module.main.innerpush.PushContext;
import com.bilibili.module.main.innerpush.RuleParams;
import com.bilibili.module.main.innerpush.ShowContent;
import com.bilibili.module.main.innerpush.Style;
import com.bilibili.module.state.PlayState;
import com.bilibili.module.state.PlayStateUpdater;
import com.bilibili.module.state.ScreenState;
import com.bilibili.pvtracker.PageViewTracker;
import j$.util.Collection;
import j$.util.function.Predicate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.AppEventUploader;
import tv.danmaku.bili.push.innerpush.PushRpc;
import tv.danmaku.bili.push.innerpush.PushUpFilterType;
import tv.danmaku.bili.push.innerpush.PushUpType;
import tv.danmaku.bili.push.innerpush.config.InnerPushLocalStorage;
import tv.danmaku.bili.push.innerpush.model.InnerPushExtensionKt;
import tv.danmaku.bili.push.innerpush.reporter.InnerPushReportHelperKt;
import tv.danmaku.bili.push.innerpush.reporter.InnerPushTechReporterKt;
import tv.danmaku.bili.push.innerpush.v2.InnerPushType;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.router.MainRouteUris;
import tv.danmaku.bili.ui.DisplayUtils;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;
import tv.danmaku.bili.ui.push.v2.manager.InnerPushStatusListener;
import tv.danmaku.bili.ui.push.v2.manager.InnerPushViewShowTaskV2;

/* compiled from: AppInnerPushManagerV2.kt */
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016*\u0002\u001f\"\b\u0007\u0018\u0000 z2\u00020\u0001:\u0003xyzB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010$\u001a\u00020\u001dJ\b\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020+H\u0002J\u0013\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0-H\u0000¢\u0006\u0002\b1J)\u00102\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u000204032\u0006\u00105\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\u000fH\u0000¢\u0006\u0002\b7J\u0015\u00108\u001a\u00020+2\u0006\u00106\u001a\u00020\u000fH\u0000¢\u0006\u0002\b9J\u0010\u0010:\u001a\u00020+2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020\u001d2\b\u0010;\u001a\u0004\u0018\u00010<JY\u0010>\u001a\u00020?2\u0006\u00106\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020A2<\u0010B\u001a8\b\u0001\u0012\u0004\u0012\u00020D\u0012\u0013\u0012\u00110E¢\u0006\f\bF\u0012\b\bG\u0012\u0004\b\b(H\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I\u0012\u0006\u0012\u0004\u0018\u00010K0C¢\u0006\u0002\bL¢\u0006\u0002\u0010MJ\u0010\u0010N\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\u000fH\u0002J\u0006\u0010O\u001a\u00020\u000fJ\u0012\u0010P\u001a\u0004\u0018\u00010\u00112\u0006\u00106\u001a\u00020\u000fH\u0002J6\u0010Q\u001a\u00020+2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u000f2\b\b\u0002\u0010U\u001a\u00020V2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020<0-H\u0082@¢\u0006\u0002\u0010XJ\u001c\u0010Y\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\u000f2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001a0-J\"\u0010[\u001a\u00020\u001d2\u0006\u0010\\\u001a\u00020\u000f2\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020+0^J\b\u0010_\u001a\u00020\u001dH\u0002J>\u0010`\u001a\u00020+2\u0006\u0010R\u001a\u00020S2\u0006\u0010\\\u001a\u00020a2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020<0-2\u0006\u00105\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010cJ<\u0010d\u001a\u00020+2\u0006\u0010R\u001a\u00020S2\u0006\u0010\\\u001a\u00020e2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020<0-2\u0006\u00105\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010fJ(\u0010g\u001a\u00020+2\u0006\u0010R\u001a\u00020S2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u00105\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010hJK\u0010i\u001a\u00020\u00132\u0006\u0010H\u001a\u00020S2\u0006\u0010j\u001a\u00020<2\u0006\u00105\u001a\u00020\u000f2#\b\u0002\u0010k\u001a\u001d\u0012\u0013\u0012\u001104¢\u0006\f\bF\u0012\b\bG\u0012\u0004\b\b(l\u0012\u0004\u0012\u00020\u001d0^H\u0082@¢\u0006\u0002\u0010mJk\u0010n\u001a\u00020\u00132\f\u0010b\u001a\b\u0012\u0004\u0012\u00020<0-2\u0006\u00105\u001a\u00020\u000f2\b\b\u0002\u0010o\u001a\u00020+2\u000e\b\u0002\u0010p\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2#\b\u0002\u0010k\u001a\u001d\u0012\u0013\u0012\u001104¢\u0006\f\bF\u0012\b\bG\u0012\u0004\b\b(q\u0012\u0004\u0012\u00020\u001d0^2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0010\u0010s\u001a\u00020\u001d2\u0006\u0010R\u001a\u00020\u0006H\u0016J\u0010\u0010t\u001a\u00020\u001d2\u0006\u0010R\u001a\u00020\u0006H\u0016J\u0010\u0010u\u001a\u00020\u001d2\u0006\u0010R\u001a\u00020\u0006H\u0016J\u0010\u0010v\u001a\u00020\u001d2\u0006\u0010R\u001a\u00020\u0006H\u0016J\b\u0010w\u001a\u00020\u001dH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R \u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010/\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006{"}, d2 = {"Ltv/danmaku/bili/push/innerpush/v2/AppInnerPushManagerV2;", "Lcom/bilibili/base/BiliContext$ActivityStateCallback;", "<init>", "()V", "mCurrentShowingActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "showJob", "Lkotlinx/coroutines/Job;", "contentId", "Ljava/util/concurrent/atomic/AtomicInteger;", "taskManager", "Ltv/danmaku/bili/push/innerpush/v2/PushTaskQueueManager;", "bizStateFlowMap", "", "", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/bilibili/module/main/innerpush/BizState;", "currentShowingTask", "Ltv/danmaku/bili/ui/push/v2/manager/InnerPushViewShowTaskV2;", "orientationStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bilibili/module/state/ScreenState;", "getOrientationStateFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "lastCheckTime", "", "onClickDefault", "Lkotlin/Function0;", "", "pvListener", "tv/danmaku/bili/push/innerpush/v2/AppInnerPushManagerV2$pvListener$1", "Ltv/danmaku/bili/push/innerpush/v2/AppInnerPushManagerV2$pvListener$1;", "componentCallback", "tv/danmaku/bili/push/innerpush/v2/AppInnerPushManagerV2$componentCallback$1", "Ltv/danmaku/bili/push/innerpush/v2/AppInnerPushManagerV2$componentCallback$1;", "init", "registerHomePageShow", "currentPlayState", "Lcom/bilibili/module/state/PlayState;", "onPlayStateChange", "info", "isLandscape", "", "bizRuleMap", "", "Ltv/danmaku/bili/push/innerpush/v2/AppInnerPushManagerV2$BizPushContent;", "bizClickMap", "currentRegisterBizType", "currentRegisterBizType$core_apinkDebug", "matchBizPush", "Lkotlin/Pair;", "", "pvId", "bizType", "matchBizPush$core_apinkDebug", "isRegisterBizPush", "isRegisterBizPush$core_apinkDebug", "isBizPush", "innerPush", "Lcom/bilibili/module/main/innerpush/InnerPush;", "onReceived", "registerBizPush", "Lcom/bilibili/module/main/innerpush/BizStateTrigger;", "cacheRule", "Lcom/bilibili/module/main/innerpush/InnerPushRule;", "onReceive", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/bilibili/module/main/innerpush/PushContext;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "context", "Lkotlin/coroutines/Continuation;", "Lcom/bilibili/module/main/innerpush/ShowContent;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Lcom/bilibili/module/main/innerpush/InnerPushRule;Lkotlin/jvm/functions/Function3;)Lcom/bilibili/module/main/innerpush/BizStateTrigger;", "saveRegisterProcess", "currentProcessName", "getBizState", "showViewDefault", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/appcompat/app/AppCompatActivity;", "pv", "style", "Lcom/bilibili/module/main/innerpush/Style;", "list", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Lcom/bilibili/module/main/innerpush/Style;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeBizPush", "jobs", "trimBizPush", "type", "predicate", "Lkotlin/Function1;", "tryShowInnerPush", "showTask", "Ltv/danmaku/bili/push/innerpush/v2/InnerPushType;", "pushList", "(Landroidx/appcompat/app/AppCompatActivity;Ltv/danmaku/bili/push/innerpush/v2/InnerPushType;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bizShowTask", "Ltv/danmaku/bili/push/innerpush/v2/InnerPushType$BizType;", "(Landroidx/appcompat/app/AppCompatActivity;Ltv/danmaku/bili/push/innerpush/v2/InnerPushType$BizType;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "innerShowTask", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/bilibili/module/main/innerpush/InnerPush;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFullCoverShowTask", "push", "onDismiss", "way", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/bilibili/module/main/innerpush/InnerPush;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createShowTask", "bizMixShow", "onShow", "how", "onClick", "onActivityResumed", "onActivityStarted", "onActivityPaused", "onActivityStopped", "unregisterCurrentPageViewIdListener", "BizPushContent", "IBizPushReceiver", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AppInnerPushManagerV2 extends BiliContext.ActivityStateCallback {
    private InnerPushViewShowTaskV2 currentShowingTask;
    private long lastCheckTime;
    private WeakReference<Activity> mCurrentShowingActivity;
    private Job showJob;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<AppInnerPushManagerV2> instance$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$$ExternalSyntheticLambda7
        public final Object invoke() {
            AppInnerPushManagerV2 instance_delegate$lambda$0;
            instance_delegate$lambda$0 = AppInnerPushManagerV2.instance_delegate$lambda$0();
            return instance_delegate$lambda$0;
        }
    });
    private final AtomicInteger contentId = new AtomicInteger(0);
    private final PushTaskQueueManager taskManager = new PushTaskQueueManager();
    private final Map<String, StateFlow<BizState>> bizStateFlowMap = new LinkedHashMap();
    private final MutableStateFlow<ScreenState> orientationStateFlow = StateFlowKt.MutableStateFlow(ScreenState.Undefined.INSTANCE);
    private final Function0<Unit> onClickDefault = new Function0() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$$ExternalSyntheticLambda1
        public final Object invoke() {
            Unit unit;
            unit = Unit.INSTANCE;
            return unit;
        }
    };
    private final AppInnerPushManagerV2$pvListener$1 pvListener = new PageViewTracker.OnReceiveCurrentEventIdListener() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$pvListener$1
        public void onGetCurrentId(String currentEventId) {
            BLog.d("[InnerPush]AppInnerPushManagerV2", "pvListener onGetCurrentId: " + currentEventId);
            AppInnerPushManagerV2.this.unregisterCurrentPageViewIdListener();
            String str = currentEventId;
            if (str == null || str.length() == 0) {
                return;
            }
            AppInnerPushManagerV2.this.tryShowInnerPush();
        }
    };
    private final AppInnerPushManagerV2$componentCallback$1 componentCallback = new ComponentCallbacks() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$componentCallback$1
        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration newConfig) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            if (newConfig.orientation == 2) {
                BLog.d("[InnerPush]AppInnerPushManagerV2", "onConfigurationChanged 横屏");
                if (!Intrinsics.areEqual(AppInnerPushManagerV2.this.getOrientationStateFlow().getValue(), ScreenState.Landscape.INSTANCE)) {
                    AppInnerPushManagerV2.this.getOrientationStateFlow().setValue(ScreenState.Landscape.INSTANCE);
                }
            } else if (newConfig.orientation == 1) {
                BLog.d("[InnerPush]AppInnerPushManagerV2", "onConfigurationChanged 竖屏");
                if (!Intrinsics.areEqual(AppInnerPushManagerV2.this.getOrientationStateFlow().getValue(), ScreenState.Portrait.INSTANCE)) {
                    AppInnerPushManagerV2.this.getOrientationStateFlow().setValue(ScreenState.Portrait.INSTANCE);
                }
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    };
    private final Map<String, List<BizPushContent>> bizRuleMap = new LinkedHashMap();
    private final Map<String, Function0<Unit>> bizClickMap = new LinkedHashMap();

    /* compiled from: AppInnerPushManagerV2.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/push/innerpush/v2/AppInnerPushManagerV2$IBizPushReceiver;", "", "onReceive", "Lcom/bilibili/module/main/innerpush/ShowContent;", "context", "Lcom/bilibili/module/main/innerpush/PushContext;", "(Lcom/bilibili/module/main/innerpush/PushContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface IBizPushReceiver {
        Object onReceive(PushContext pushContext, Continuation<? super ShowContent> continuation);
    }

    public final MutableStateFlow<ScreenState> getOrientationStateFlow() {
        return this.orientationStateFlow;
    }

    public final void init() {
        BLog.i("[InnerPush]AppInnerPushManagerV2", "init");
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        AppEventUploader.initialize();
        BiliContext.registerActivityStateCallback(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(InnerPushReceiverKt.getPushIntentAction(context));
        ContextCompat.registerReceiver(context, new AppInnerPushBroadcastReceiver(), intentFilter, 2);
        if (BiliContext.isMainProcess()) {
            InnerPushLocalStorage.INSTANCE.updateInnerPushConfig();
            InnerPushReceiverKt.registerInnerPushReceiver(context);
            registerHomePageShow();
        }
        if (BiliContext.isMainProcess()) {
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new AppInnerPushManagerV2$init$1(this, null), 3, (Object) null);
        }
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new AppInnerPushManagerV2$init$2(this, null), 3, (Object) null);
    }

    private final void registerHomePageShow() {
        BLog.i("[InnerPush]AppInnerPushManagerV2", "registerHomePageShow");
        MainDialogManager.addOnDialogEmptyListener(new MainDialogManager.IDialogShowListener() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$registerHomePageShow$1
            public void onShowNext(int priority) {
                BLog.i("[InnerPush]AppInnerPushManagerV2", "MainDialogManager onShowNext priority = " + priority);
                if (priority >= 2000) {
                    AppInnerPushManagerV2.this.tryShowInnerPush();
                }
            }

            public void onEmpty() {
                BLog.i("[InnerPush]AppInnerPushManagerV2", "MainDialogManager onEmpty");
                AppInnerPushManagerV2.this.tryShowInnerPush();
            }
        });
    }

    private final PlayState currentPlayState() {
        PlayState currentState;
        PlayStateUpdater playStateUpdater = (PlayStateUpdater) BLRouter.INSTANCE.getServices(PlayStateUpdater.class).get(MineReporter.MINE_ICON_TYPE_DEFAULT);
        return (playStateUpdater == null || (currentState = playStateUpdater.currentState()) == null) ? PlayState.IDLE.INSTANCE : currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPlayStateChange(PlayState info) {
        BLog.i("[InnerPush]AppInnerPushManagerV2", "onPlayStateChange: " + info);
        if (Intrinsics.areEqual(info, PlayState.IDLE.INSTANCE)) {
            tryShowInnerPush();
        }
    }

    private final boolean isLandscape() {
        Activity activity;
        WeakReference<Activity> weakReference = this.mCurrentShowingActivity;
        return (weakReference == null || (activity = weakReference.get()) == null || activity.getResources().getConfiguration().orientation != 2) ? false : true;
    }

    /* compiled from: AppInnerPushManagerV2.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/push/innerpush/v2/AppInnerPushManagerV2$BizPushContent;", "", "bizId", "", "contentId", "", "showRule", "Lcom/bilibili/module/main/innerpush/InnerPushRule;", "receiver", "Ltv/danmaku/bili/push/innerpush/v2/AppInnerPushManagerV2$IBizPushReceiver;", "<init>", "(Ljava/lang/String;ILcom/bilibili/module/main/innerpush/InnerPushRule;Ltv/danmaku/bili/push/innerpush/v2/AppInnerPushManagerV2$IBizPushReceiver;)V", "getBizId", "()Ljava/lang/String;", "getContentId", "()I", "getShowRule", "()Lcom/bilibili/module/main/innerpush/InnerPushRule;", "getReceiver", "()Ltv/danmaku/bili/push/innerpush/v2/AppInnerPushManagerV2$IBizPushReceiver;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class BizPushContent {
        public static final int $stable = 8;
        private final String bizId;
        private final int contentId;
        private final IBizPushReceiver receiver;
        private final InnerPushRule showRule;

        public BizPushContent(String bizId, int contentId, InnerPushRule showRule, IBizPushReceiver receiver) {
            Intrinsics.checkNotNullParameter(bizId, "bizId");
            Intrinsics.checkNotNullParameter(showRule, "showRule");
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            this.bizId = bizId;
            this.contentId = contentId;
            this.showRule = showRule;
            this.receiver = receiver;
        }

        public final String getBizId() {
            return this.bizId;
        }

        public final int getContentId() {
            return this.contentId;
        }

        public final InnerPushRule getShowRule() {
            return this.showRule;
        }

        public final IBizPushReceiver getReceiver() {
            return this.receiver;
        }
    }

    public final List<String> currentRegisterBizType$core_apinkDebug() {
        return CollectionsKt.toList(this.bizRuleMap.keySet());
    }

    public final Pair<Boolean, Integer> matchBizPush$core_apinkDebug(String pvId, String bizType) {
        Intrinsics.checkNotNullParameter(pvId, "pvId");
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        RuleParams pv = new RuleParams.Pv(pvId, 0, 2, (DefaultConstructorMarker) null);
        RuleParams play = new RuleParams.Play(currentPlayState(), 0, 2, (DefaultConstructorMarker) null);
        RuleParams screen = new RuleParams.Screen((ScreenState) (isLandscape() ? ScreenState.Landscape.INSTANCE : ScreenState.Portrait.INSTANCE), 0, 2, (DefaultConstructorMarker) null);
        BLog.i("[InnerPush]AppInnerPushManagerV2", "matchBizPush, pvParams = " + pv.getPv() + ", playStateParams = " + play.getState() + ", screenParams = " + screen.getScreen());
        ArrayList ruleParams = CollectionsKt.arrayListOf(new RuleParams[]{pv, play, screen});
        Iterable rules = (List) this.bizRuleMap.get(bizType);
        if (rules != null) {
            Iterable $this$forEach$iv = rules;
            for (Object element$iv : $this$forEach$iv) {
                BizPushContent it = (BizPushContent) element$iv;
                int contentId = it.getContentId();
                if (!it.getShowRule().match(ruleParams)) {
                    BizState bizState = getBizState(bizType);
                    boolean visibility = bizState != null ? bizState.getVisible() : false;
                    if (!visibility) {
                        BLog.i("[InnerPush]AppInnerPushManagerV2", "matchBizPush, match success and visible = false, show push");
                        return new Pair<>(true, Integer.valueOf(contentId));
                    }
                    BLog.i("[InnerPush]AppInnerPushManagerV2", "matchBizPush, match success but visible = true, continue cache push");
                    return new Pair<>(false, Integer.valueOf(contentId));
                }
            }
        }
        BLog.i("[InnerPush]AppInnerPushManagerV2", "matchBizPush, not match");
        return new Pair<>(false, 0);
    }

    public final boolean isRegisterBizPush$core_apinkDebug(String bizType) {
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        return this.bizRuleMap.keySet().contains(bizType);
    }

    private final boolean isBizPush(InnerPush innerPush) {
        Map $this$any$iv = this.bizRuleMap;
        if ($this$any$iv.isEmpty()) {
            return false;
        }
        for (Map.Entry element$iv : $this$any$iv.entrySet()) {
            String bizType = element$iv.getKey();
            if (Intrinsics.areEqual(bizType, String.valueOf(innerPush.getType()))) {
                return true;
            }
        }
        return false;
    }

    public final void onReceived(InnerPush innerPush) {
        BLog.i("[InnerPush]AppInnerPushManagerV2", "onReceived, push job = " + (innerPush != null ? Long.valueOf(innerPush.getJob()) : null));
        if (innerPush == null) {
            return;
        }
        if (!RestrictedMode.isRestrictedMode()) {
            InnerPushCacheManagerV2.Companion.getInstance().add(innerPush);
        } else if (BiliContext.isMainProcess()) {
            InnerPushExtensionKt.reportDiscardPush(innerPush, PushUpFilterType.RestrictedMode);
            BLog.i("[InnerPush]AppInnerPushManagerV2", "onReceived, in restricted mode, can't add to cache");
        }
        tryShowInnerPush();
    }

    public final BizStateTrigger registerBizPush(String bizType, InnerPushRule cacheRule, final Function3<? super CoroutineScope, ? super PushContext, ? super Continuation<? super ShowContent>, ? extends Object> function3) {
        List list;
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        Intrinsics.checkNotNullParameter(cacheRule, "cacheRule");
        Intrinsics.checkNotNullParameter(function3, "onReceive");
        if (BiliContext.isMainProcess() && this.bizRuleMap.isEmpty()) {
            InnerPushLocalStorage.INSTANCE.cleanBizPushRegisterProcess();
        }
        IBizPushReceiver iBizPushReceiver = new IBizPushReceiver() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$registerBizPush$receiver$1
            @Override // tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2.IBizPushReceiver
            public Object onReceive(PushContext context, Continuation<? super ShowContent> continuation) {
                return function3.invoke(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), context, continuation);
            }
        };
        int contentId = this.contentId.incrementAndGet();
        BizPushContent content = new BizPushContent(bizType, contentId, cacheRule, iBizPushReceiver);
        List<BizPushContent> list2 = this.bizRuleMap.get(bizType);
        if (list2 == null || (list = CollectionsKt.toMutableList(list2)) == null) {
            list = new ArrayList();
        }
        list.add(content);
        this.bizRuleMap.put(bizType, list);
        saveRegisterProcess(bizType);
        final StateFlow<BizState> MutableStateFlow = StateFlowKt.MutableStateFlow((Object) null);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new AppInnerPushManagerV2$registerBizPush$1(MutableStateFlow, this, null), 3, (Object) null);
        BizStateTrigger bizStateTrigger = new BizStateTrigger() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$registerBizPush$trigger$1
            public void visibilityChanged(boolean visible) {
                BizState state = new BizState(visible);
                MutableStateFlow.setValue(state);
            }
        };
        this.bizStateFlowMap.put(bizType, MutableStateFlow);
        return bizStateTrigger;
    }

    private final void saveRegisterProcess(String bizType) {
        String process = currentProcessName();
        InnerPushLocalStorage.INSTANCE.setBizPushRegisterProcess(bizType, process);
    }

    public final String currentProcessName() {
        return BiliContext.isMainProcess() ? MainRouteUris.MODULE_MAIN : BiliContext.currentProcessName();
    }

    private final BizState getBizState(String bizType) {
        StateFlow<BizState> stateFlow = this.bizStateFlowMap.get(bizType);
        if (stateFlow != null) {
            return (BizState) stateFlow.getValue();
        }
        return null;
    }

    static /* synthetic */ Object showViewDefault$default(AppInnerPushManagerV2 appInnerPushManagerV2, AppCompatActivity appCompatActivity, String str, Style style, List list, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            style = (Style) Style.Custom.INSTANCE;
        }
        return appInnerPushManagerV2.showViewDefault(appCompatActivity, str, style, list, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showViewDefault(AppCompatActivity activity, String pv, Style style, List<InnerPush> list, Continuation<? super Boolean> continuation) {
        Continuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Result.Companion companion = Result.Companion;
        ((CancellableContinuation) cancellableContinuationImpl).resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final void consumeBizPush(String bizType, List<Long> list) {
        List emptyList;
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        Intrinsics.checkNotNullParameter(list, "jobs");
        List localCache = InnerPushCacheManagerV2.Companion.getInstance().loadPushFromDisk();
        long lastShowJob = InnerPushLocalStorage.INSTANCE.getBizInnerPushShowLastJob(bizType);
        boolean lastJobRemoved = false;
        List<Long> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            final long job = ((Number) element$iv).longValue();
            if (job == lastShowJob) {
                lastJobRemoved = true;
            } else {
                final Function1 function1 = new Function1() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        boolean consumeBizPush$lambda$0$0;
                        consumeBizPush$lambda$0$0 = AppInnerPushManagerV2.consumeBizPush$lambda$0$0(job, (InnerPush) obj);
                        return Boolean.valueOf(consumeBizPush$lambda$0$0);
                    }
                };
                Collection.-EL.removeIf(localCache, new Predicate() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$$ExternalSyntheticLambda5
                    @Override // java.util.function.Predicate
                    public /* synthetic */ Predicate and(Predicate predicate) {
                        return Predicate.-CC.$default$and(this, predicate);
                    }

                    @Override // java.util.function.Predicate
                    public /* synthetic */ java.util.function.Predicate negate() {
                        return Predicate.-CC.$default$negate(this);
                    }

                    @Override // java.util.function.Predicate
                    public /* synthetic */ java.util.function.Predicate or(java.util.function.Predicate predicate) {
                        return Predicate.-CC.$default$or(this, predicate);
                    }

                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        boolean consumeBizPush$lambda$0$1;
                        consumeBizPush$lambda$0$1 = AppInnerPushManagerV2.consumeBizPush$lambda$0$1(function1, obj);
                        return consumeBizPush$lambda$0$1;
                    }
                });
            }
            InnerPushCacheManagerV2.remove$default(InnerPushCacheManagerV2.Companion.getInstance(), job, null, null, 6, null);
        }
        if (!lastJobRemoved) {
            emptyList = CollectionsKt.emptyList();
        } else {
            int index$iv = 0;
            Iterator<InnerPush> it = localCache.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object item$iv = it.next();
                    InnerPush it2 = (InnerPush) item$iv;
                    if (it2.getJob() == lastShowJob) {
                        break;
                    }
                    index$iv++;
                } else {
                    index$iv = -1;
                    break;
                }
            }
            int lastShowIndex = index$iv;
            if (lastShowIndex == -1) {
                emptyList = CollectionsKt.emptyList();
            } else {
                Iterable $this$map$iv = CollectionsKt.take(localCache, lastShowIndex);
                java.util.Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    InnerPush it3 = (InnerPush) item$iv$iv;
                    destination$iv$iv.add(Long.valueOf(it3.getJob()));
                }
                emptyList = (List) destination$iv$iv;
            }
        }
        List preShowJobs = emptyList;
        InnerPushCacheManagerV2.Companion.getInstance().updateLastJob(bizType, lastJobRemoved, preShowJobs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean consumeBizPush$lambda$0$0(long $job, InnerPush it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getJob() == $job;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean consumeBizPush$lambda$0$1(Function1 $tmp0, Object p0) {
        return ((Boolean) $tmp0.invoke(p0)).booleanValue();
    }

    public final void trimBizPush(String type, Function1<? super InnerPush, Boolean> function1) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new AppInnerPushManagerV2$trimBizPush$1(type, function1, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryShowInnerPush() {
        long now = System.currentTimeMillis();
        if (now - this.lastCheckTime < 1000) {
            BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, lastCheckTime too close, return");
            return;
        }
        this.lastCheckTime = now;
        if (RestrictedMode.isRestrictedMode()) {
            BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, interrupted by restricted mode");
            if (BiliContext.isMainProcess()) {
                InnerPushTechReporterKt.reportInnerPushFilterShow("restricted");
                return;
            }
            return;
        }
        WeakReference<Activity> weakReference = this.mCurrentShowingActivity;
        Activity activity = weakReference != null ? weakReference.get() : null;
        if (!(activity instanceof AppCompatActivity)) {
            BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, no running activity");
            InnerPushTechReporterKt.reportInnerPushFilterShow("no_valid_activity");
        } else if ((activity instanceof IDrawerHost) && !activity.isSplashFinish()) {
            BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, splash showing, can't show inner push");
            InnerPushTechReporterKt.reportInnerPushFilterShow(UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        } else {
            Job job = this.showJob;
            boolean z = false;
            if (job != null && job.isActive()) {
                z = true;
            }
            if (z) {
                BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, prevJobShowing");
                return;
            }
            InnerPushLocalStorage.INSTANCE.tryCleanInnerPushExposeRecord();
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new AppInnerPushManagerV2$tryShowInnerPush$1(activity, this, null), 3, (Object) null);
            this.showJob = LifecycleOwnerKt.getLifecycleScope(activity).launchWhenResumed(new AppInnerPushManagerV2$tryShowInnerPush$2(this, activity, null));
            Job job2 = this.showJob;
            if (job2 != null) {
                job2.invokeOnCompletion(new Function1() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit tryShowInnerPush$lambda$0;
                        tryShowInnerPush$lambda$0 = AppInnerPushManagerV2.tryShowInnerPush$lambda$0((Throwable) obj);
                        return tryShowInnerPush$lambda$0;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tryShowInnerPush$lambda$0(Throwable it) {
        BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, jobCompletion");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object showTask(AppCompatActivity activity, InnerPushType type, List<InnerPush> list, String pvId, String contentId, Continuation<? super Boolean> continuation) {
        Continuation<? super Boolean> appInnerPushManagerV2$showTask$1;
        boolean result;
        Object bizShowTask;
        if (continuation instanceof AppInnerPushManagerV2$showTask$1) {
            appInnerPushManagerV2$showTask$1 = (AppInnerPushManagerV2$showTask$1) continuation;
            if ((appInnerPushManagerV2$showTask$1.label & Integer.MIN_VALUE) != 0) {
                appInnerPushManagerV2$showTask$1.label -= Integer.MIN_VALUE;
                Object $result = appInnerPushManagerV2$showTask$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (appInnerPushManagerV2$showTask$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (type instanceof InnerPushType.BizType) {
                            appInnerPushManagerV2$showTask$1.label = 1;
                            bizShowTask = bizShowTask(activity, (InnerPushType.BizType) type, list, pvId, contentId, appInnerPushManagerV2$showTask$1);
                            if (bizShowTask == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            result = ((Boolean) bizShowTask).booleanValue();
                            BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, biz show result: " + result);
                            break;
                        } else if ((type instanceof InnerPushType.Normal) || Intrinsics.areEqual(type, InnerPushType.HighLevel.INSTANCE)) {
                            appInnerPushManagerV2$showTask$1.label = 2;
                            Object innerShowTask = innerShowTask(activity, (InnerPush) CollectionsKt.firstOrNull(list), pvId, appInnerPushManagerV2$showTask$1);
                            if (innerShowTask == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return innerShowTask;
                        } else if (type instanceof InnerPushType.Empty) {
                            result = false;
                            break;
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        bizShowTask = $result;
                        result = ((Boolean) bizShowTask).booleanValue();
                        BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, biz show result: " + result);
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Boxing.boxBoolean(result);
            }
        }
        appInnerPushManagerV2$showTask$1 = new AppInnerPushManagerV2$showTask$1(this, continuation);
        Object $result2 = appInnerPushManagerV2$showTask$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (appInnerPushManagerV2$showTask$1.label) {
        }
        return Boxing.boxBoolean(result);
    }

    static /* synthetic */ Object showTask$default(AppInnerPushManagerV2 appInnerPushManagerV2, AppCompatActivity appCompatActivity, InnerPushType innerPushType, List list, String str, String str2, Continuation continuation, int i, Object obj) {
        String str3;
        if ((i & 16) == 0) {
            str3 = str2;
        } else {
            str3 = "";
        }
        return appInnerPushManagerV2.showTask(appCompatActivity, innerPushType, list, str, str3, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object bizShowTask(AppCompatActivity activity, InnerPushType.BizType type, List<InnerPush> list, String pvId, String contentId, Continuation<? super Boolean> continuation) {
        Continuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Continuation continuation2 = (CancellableContinuation) cancellableContinuationImpl;
        Ref.BooleanRef hasResume = new Ref.BooleanRef();
        Iterable rules = (List) this.bizRuleMap.get(type.getBizType());
        BizPushContent bizPushContent = null;
        if (rules != null) {
            Iterable $this$firstOrNull$iv = rules;
            Iterator it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object element$iv = it.next();
                BizPushContent it2 = (BizPushContent) element$iv;
                if (Intrinsics.areEqual(String.valueOf(it2.getContentId()), contentId)) {
                    bizPushContent = element$iv;
                    break;
                }
            }
            bizPushContent = bizPushContent;
        }
        BizPushContent rule = bizPushContent;
        if (rule == null) {
            BLog.i("[InnerPush]AppInnerPushManagerV2", "bizShowTask, no valid rule");
            Result.Companion companion = Result.Companion;
            continuation2.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
        } else {
            List reverseList = CollectionsKt.reversed(list);
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new AppInnerPushManagerV2$bizShowTask$2$1(type, this, continuation2, rule, reverseList, pvId, activity, list, hasResume, null), 3, (Object) null);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object innerShowTask(AppCompatActivity activity, InnerPush innerPush, String pvId, Continuation<? super Boolean> continuation) {
        Continuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Continuation continuation2 = (CancellableContinuation) cancellableContinuationImpl;
        Ref.BooleanRef hasResume = new Ref.BooleanRef();
        BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, find push item.job = " + (innerPush != null ? Boxing.boxLong(innerPush.getJob()) : null) + ", pvId = " + pvId);
        if (innerPush == null) {
            Result.Companion companion = Result.Companion;
            continuation2.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
        } else if (activity.getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) {
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new AppInnerPushManagerV2$innerShowTask$2$1(innerPush, this, activity, pvId, continuation2, hasResume, null), 3, (Object) null);
        } else {
            BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, activity not on resume state");
            Result.Companion companion2 = Result.Companion;
            continuation2.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    static /* synthetic */ Object createFullCoverShowTask$default(AppInnerPushManagerV2 appInnerPushManagerV2, AppCompatActivity appCompatActivity, InnerPush innerPush, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        Function1 function12;
        if ((i & 8) == 0) {
            function12 = function1;
        } else {
            function12 = new Function1() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$$ExternalSyntheticLambda8
                public final Object invoke(Object obj2) {
                    Unit createFullCoverShowTask$lambda$0;
                    createFullCoverShowTask$lambda$0 = AppInnerPushManagerV2.createFullCoverShowTask$lambda$0(((Integer) obj2).intValue());
                    return createFullCoverShowTask$lambda$0;
                }
            };
        }
        return appInnerPushManagerV2.createFullCoverShowTask(appCompatActivity, innerPush, str, function12, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createFullCoverShowTask$lambda$0(int it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object createFullCoverShowTask(AppCompatActivity context, final InnerPush push, final String pvId, final Function1<? super Integer, Unit> function1, Continuation<? super InnerPushViewShowTaskV2> continuation) {
        Continuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final Continuation continuation2 = (CancellableContinuation) cancellableContinuationImpl;
        try {
            int width = DisplayUtils.getWindowWidth((Context) context) - ListExtentionsKt.toPx(24);
            int height = ListExtentionsKt.toPx(72);
            ImageExtentionKt.downloadImage((Context) context, push.getPureImage(), width, height, true, true, new ImageDataSubscriber<Unit>() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$createFullCoverShowTask$3$1
                public /* synthetic */ void onProgressUpdate(ImageDataSource imageDataSource) {
                    ImageDataSubscriber.-CC.$default$onProgressUpdate(this, imageDataSource);
                }

                public void onResult(ImageDataSource<Unit> imageDataSource) {
                    Function0 function0;
                    InnerPushViewShowTaskV2 createShowTask;
                    if (imageDataSource != null) {
                        BLog.i("[InnerPush]AppInnerPushManagerV2", "createFullCoverShowTask, onResult, image load success");
                        if (continuation2.isActive()) {
                            AppInnerPushManagerV2 appInnerPushManagerV2 = this;
                            InnerPush[] innerPushArr = {push};
                            String str = pvId;
                            Function1<Integer, Unit> function12 = function1;
                            function0 = this.onClickDefault;
                            createShowTask = appInnerPushManagerV2.createShowTask(CollectionsKt.arrayListOf(innerPushArr), str, (r14 & 4) != 0 ? false : false, (r14 & 8) != 0 ? new Function0() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$$ExternalSyntheticLambda2
                                public final Object invoke() {
                                    Unit unit;
                                    unit = Unit.INSTANCE;
                                    return unit;
                                }
                            } : null, (r14 & 16) != 0 ? new Function1() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$$ExternalSyntheticLambda3
                                public final Object invoke(Object obj) {
                                    Unit createShowTask$lambda$1;
                                    createShowTask$lambda$1 = AppInnerPushManagerV2.createShowTask$lambda$1(((Integer) obj).intValue());
                                    return createShowTask$lambda$1;
                                }
                            } : function12, function0);
                            Result.Companion companion = Result.Companion;
                            continuation2.resumeWith(Result.constructor-impl(createShowTask));
                            return;
                        }
                        return;
                    }
                    InnerPushCacheManagerV2.remove$default(InnerPushCacheManagerV2.Companion.getInstance(), push.getJob(), PushUpFilterType.LoadFail.getText(), null, 4, null);
                    BLog.e("[InnerPush]AppInnerPushManagerV2", "createFullCoverShowTask, onResult, image load failed, can't show");
                    if (continuation2.isActive()) {
                        Result.Companion companion2 = Result.Companion;
                        continuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure(new CancellationException("exception"))));
                    }
                }

                public void onFailure(ImageDataSource<Unit> imageDataSource) {
                    InnerPushCacheManagerV2.remove$default(InnerPushCacheManagerV2.Companion.getInstance(), push.getJob(), PushUpFilterType.LoadFail.getText(), null, 4, null);
                    BLog.e("[InnerPush]AppInnerPushManagerV2", "createFullCoverShowTask, onFailed, image load failed, can't show");
                    if (continuation2.isActive()) {
                        Result.Companion companion = Result.Companion;
                        continuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure(new CancellationException("exception"))));
                    }
                }

                public void onCancellation(ImageDataSource<Unit> imageDataSource) {
                    InnerPushCacheManagerV2.remove$default(InnerPushCacheManagerV2.Companion.getInstance(), push.getJob(), PushUpFilterType.LoadFail.getText(), null, 4, null);
                    BLog.e("[InnerPush]AppInnerPushManagerV2", "showInnerPushWithFullCover, onCancel, image load failed, can't show");
                    if (continuation2.isActive()) {
                        Result.Companion companion = Result.Companion;
                        continuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure(new CancellationException("exception"))));
                    }
                }
            });
        } catch (Exception e) {
            BLog.e("[InnerPush]AppInnerPushManagerV2", "showInnerPushWithFullCover, exception " + e.getMessage());
            if (continuation2.isActive()) {
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure(new CancellationException("exception"))));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createShowTask$lambda$1(int it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InnerPushViewShowTaskV2 createShowTask(List<InnerPush> list, final String pvId, final boolean bizMixShow, final Function0<Unit> function0, final Function1<? super Integer, Unit> function1, final Function0<Unit> function02) {
        final InnerPush push = (InnerPush) CollectionsKt.first(list);
        InnerPushStatusListener innerPushStatusListener = new InnerPushStatusListener() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$createShowTask$statusListener$1
            public void onDismiss(Context ctx, int how) {
                InnerPushViewShowTaskV2 innerPushViewShowTaskV2;
                Map it;
                BLog.i("[InnerPush]AppInnerPushManagerV2", "onDismiss, how = " + how);
                if (how == 1) {
                    PushRpc.pushUpStreamForClick(push.getTaskId(), how, push.getJob(), push.getBid(), push.getMsgSource(), push.getMetaData());
                    Map extra = new LinkedHashMap();
                    Map it2 = push.getMetaData();
                    if (it2 != null) {
                        extra.putAll(it2);
                    }
                    innerPushViewShowTaskV2 = this.currentShowingTask;
                    if (innerPushViewShowTaskV2 != null && (it = innerPushViewShowTaskV2.reportExtra()) != null) {
                        extra.putAll(it);
                    }
                    InnerPushReportHelperKt.reportClick(push.getTaskId(), String.valueOf(how), push.getMsgSource(), extra);
                }
                InnerPushLocalStorage.INSTANCE.setShowing(String.valueOf(push.getType()), false);
                this.currentShowingTask = null;
                function1.invoke(Integer.valueOf(how));
            }

            public void onShow(Context ctx) {
                InnerPushViewShowTaskV2 innerPushViewShowTaskV2;
                Map it;
                InnerPushViewShowTaskV2 innerPushViewShowTaskV22;
                Map it2;
                BLog.i("[InnerPush]AppInnerPushManagerV2", "onShow");
                InnerPushLocalStorage.INSTANCE.updateInnerPushShowTime();
                boolean bizPush = AppInnerPushManagerV2.Companion.getInstance().isRegisterBizPush$core_apinkDebug(String.valueOf(push.getType()));
                if (bizPush) {
                    if (!bizMixShow) {
                        InnerPushExtensionKt.increaseExposeCount(push);
                        Map extra = new LinkedHashMap();
                        Map it3 = push.getMetaData();
                        if (it3 != null) {
                            extra.putAll(it3);
                        }
                        innerPushViewShowTaskV22 = this.currentShowingTask;
                        if (innerPushViewShowTaskV22 != null && (it2 = innerPushViewShowTaskV22.reportExtra()) != null) {
                            extra.putAll(it2);
                        }
                        InnerPushReportHelperKt.reportShow(push.getTaskId(), push.getMsgSource(), extra, pvId);
                    }
                } else {
                    InnerPushCacheManagerV2.remove$default(InnerPushCacheManagerV2.Companion.getInstance(), push.getJob(), null, null, 6, null);
                    InnerPushExtensionKt.increaseExposeCount(push);
                    PushRpc.pushUpStream(push.getTaskId(), PushUpType.TYPE_SHOW, push.getJob(), push.getBid(), push.getMsgSource(), push.getMetaData());
                    Map extra2 = new LinkedHashMap();
                    Map it4 = push.getMetaData();
                    if (it4 != null) {
                        extra2.putAll(it4);
                    }
                    innerPushViewShowTaskV2 = this.currentShowingTask;
                    if (innerPushViewShowTaskV2 != null && (it = innerPushViewShowTaskV2.reportExtra()) != null) {
                        extra2.putAll(it);
                    }
                    InnerPushReportHelperKt.reportShow(push.getTaskId(), push.getMsgSource(), extra2, pvId);
                }
                InnerPushLocalStorage.INSTANCE.setShowing(String.valueOf(push.getType()), true);
                function0.invoke();
            }
        };
        Function1 pushClickListener = new Function1() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit createShowTask$lambda$2;
                createShowTask$lambda$2 = AppInnerPushManagerV2.createShowTask$lambda$2(push, function02, this, (Context) obj);
                return createShowTask$lambda$2;
            }
        };
        return new InnerPushViewShowTaskV2(push, innerPushStatusListener, pushClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createShowTask$lambda$2(InnerPush $push, Function0 $onClick, AppInnerPushManagerV2 this$0, Context ctx) {
        Map it;
        BLog.i("[InnerPush]AppInnerPushManagerV2", "pushClickListener onClick");
        String link = $push.getLink();
        if (!(link == null || StringsKt.isBlank(link))) {
            if ($onClick == this$0.onClickDefault) {
                Uri parse = Uri.parse($push.getLink());
                Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                RouteRequest request = new RouteRequest.Builder(parse).build();
                BLRouter.routeTo(request, ctx);
                PushRpc.pushUpStreamForClick($push.getTaskId(), 0, $push.getJob(), $push.getBid(), $push.getMsgSource(), $push.getMetaData());
                InnerPushReportHelperKt.reportClick($push.getTaskId(), "0", $push.getMsgSource(), $push.getMetaData());
                InnerPushReportHelperKt.reportClickTest($push.getLink());
            } else {
                $onClick.invoke();
                Map extra = new LinkedHashMap();
                Map it2 = $push.getMetaData();
                if (it2 != null) {
                    extra.putAll(it2);
                }
                InnerPushViewShowTaskV2 innerPushViewShowTaskV2 = this$0.currentShowingTask;
                if (innerPushViewShowTaskV2 != null && (it = innerPushViewShowTaskV2.reportExtra()) != null) {
                    extra.putAll(it);
                }
                InnerPushReportHelperKt.reportClick($push.getTaskId(), "0", $push.getMsgSource(), extra);
            }
        }
        return Unit.INSTANCE;
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        super.onActivityResumed(activity);
        WeakReference<Activity> weakReference = this.mCurrentShowingActivity;
        if (activity != (weakReference != null ? weakReference.get() : null)) {
            this.mCurrentShowingActivity = new WeakReference<>(activity);
        }
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new AppInnerPushManagerV2$onActivityResumed$1(this, null), 3, (Object) null);
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        super.onActivityStarted(activity);
        WeakReference<Activity> weakReference = this.mCurrentShowingActivity;
        if (activity != (weakReference != null ? weakReference.get() : null)) {
            this.mCurrentShowingActivity = new WeakReference<>(activity);
            try {
                activity.registerComponentCallbacks(this.componentCallback);
            } catch (Exception e) {
                BLog.e("[InnerPush]AppInnerPushManagerV2", "onActivityStarted registerComponentCallbacks: " + e.getMessage());
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        WeakReference<Activity> weakReference;
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        super.onActivityPaused(activity);
        WeakReference<Activity> weakReference2 = this.mCurrentShowingActivity;
        if (activity != (weakReference2 != null ? weakReference2.get() : null) || (weakReference = this.mCurrentShowingActivity) == null) {
            return;
        }
        weakReference.clear();
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        super.onActivityStopped(activity);
        WeakReference<Activity> weakReference = this.mCurrentShowingActivity;
        if (activity == (weakReference != null ? weakReference.get() : null)) {
            WeakReference<Activity> weakReference2 = this.mCurrentShowingActivity;
            if (weakReference2 != null) {
                weakReference2.clear();
            }
            try {
                activity.unregisterComponentCallbacks(this.componentCallback);
            } catch (Exception e) {
                BLog.e("[InnerPush]AppInnerPushManagerV2", "onActivityStopped unregisterComponentCallbacks: " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unregisterCurrentPageViewIdListener() {
        PageViewTracker.getInstance().unregisterReceiveCurrentEventIdListener(this.pvListener);
    }

    /* compiled from: AppInnerPushManagerV2.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/push/innerpush/v2/AppInnerPushManagerV2$Companion;", "", "<init>", "()V", "instance", "Ltv/danmaku/bili/push/innerpush/v2/AppInnerPushManagerV2;", "getInstance", "()Ltv/danmaku/bili/push/innerpush/v2/AppInnerPushManagerV2;", "instance$delegate", "Lkotlin/Lazy;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AppInnerPushManagerV2 getInstance() {
            return (AppInnerPushManagerV2) AppInnerPushManagerV2.instance$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppInnerPushManagerV2 instance_delegate$lambda$0() {
        return new AppInnerPushManagerV2();
    }
}