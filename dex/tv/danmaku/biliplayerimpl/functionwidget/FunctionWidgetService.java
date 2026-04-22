package tv.danmaku.biliplayerimpl.functionwidget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.media.resource.ExtraInfo;
import com.bilibili.lib.media.resource.MediaResource;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerimpl.AbsCorePlayerService;
import tv.danmaku.biliplayerimpl.BuildConfig;
import tv.danmaku.biliplayerimpl.PlayerContainerImpl;
import tv.danmaku.biliplayerimpl.core.LoadingFunctionWidget;
import tv.danmaku.biliplayerimpl.core.PlayLimitFunctionWidget;
import tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.injection.PlayerServiceInjector;
import tv.danmaku.biliplayerv2.panel.BuiltInLayer;
import tv.danmaku.biliplayerv2.panel.IPanelContainer;
import tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService;
import tv.danmaku.biliplayerv2.service.BufferingObserver;
import tv.danmaku.biliplayerv2.service.FunctionWidgetConfig;
import tv.danmaku.biliplayerv2.service.FunctionWidgetInsetConfig;
import tv.danmaku.biliplayerv2.service.FunctionWidgetToken;
import tv.danmaku.biliplayerv2.service.IMediaResourceObserver;
import tv.danmaku.biliplayerv2.service.IRenderStartObserver;
import tv.danmaku.biliplayerv2.service.LifecycleState;
import tv.danmaku.biliplayerv2.service.OnWidgetStateChangeListener;
import tv.danmaku.biliplayerv2.widget.AbsFunctionWidget;
import tv.danmaku.biliplayerv2.widget.IFunctionContainer;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.log.PlayerLogModule;

/* compiled from: FunctionWidgetService.kt */
@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t*\u0006'*-036\b\u0000\u0018\u0000 \u0082\u00012\u00020\u00012\u00020\u0002:\u0004\u0082\u0001\u0083\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\b\u0010<\u001a\u000209H\u0016J\b\u0010=\u001a\u000209H\u0016J+\u0010>\u001a\u0002092!\u0010?\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002090@H\u0002J\u001a\u0010D\u001a\u0004\u0018\u00010\u00072\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0015H\u0016J\u0010\u0010H\u001a\u0002092\u0006\u0010E\u001a\u00020FH\u0016J\u0018\u0010I\u001a\u0002092\u0006\u0010C\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u0015H\u0002J\"\u0010D\u001a\u0004\u0018\u00010\u00072\u000e\u0010J\u001a\n\u0012\u0006\b\u0001\u0012\u00020F0K2\u0006\u0010G\u001a\u00020\u0015H\u0016J,\u0010D\u001a\u0004\u0018\u00010\u00072\u000e\u0010J\u001a\n\u0012\u0006\b\u0001\u0012\u00020F0K2\u0006\u0010G\u001a\u00020\u00152\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u0010\u0010D\u001a\u0002092\u0006\u0010N\u001a\u00020\u0007H\u0016J\u001a\u0010D\u001a\u0002092\u0006\u0010N\u001a\u00020\u00072\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010O\u001a\u00020\u001aH\u0002J\"\u0010P\u001a\u0002092\u0006\u0010C\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u00152\b\u0010L\u001a\u0004\u0018\u00010MH\u0002J\u0010\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020RH\u0002J\u0012\u0010T\u001a\u0002092\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\b\u0010W\u001a\u000209H\u0016J\b\u0010X\u001a\u000209H\u0002J\u0010\u0010Y\u001a\u0002092\u0006\u0010Z\u001a\u00020\u000bH\u0016J\u0010\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^H\u0016J\u0018\u0010_\u001a\u0002092\u0006\u0010`\u001a\u00020a2\u0006\u0010U\u001a\u00020VH\u0016J\u0012\u0010b\u001a\u0002092\b\u0010c\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010d\u001a\u0002092\b\u0010c\u001a\u0004\u0018\u00010!H\u0016J\b\u0010e\u001a\u000209H\u0016J\u0010\u0010H\u001a\u0002092\u0006\u0010N\u001a\u00020\u0007H\u0016J\u0018\u0010f\u001a\u0002092\u0006\u0010N\u001a\u00020\u00072\u0006\u0010L\u001a\u00020MH\u0016J \u0010g\u001a\u0002092\u0006\u0010N\u001a\u00020\u00072\u0006\u0010h\u001a\u00020R2\u0006\u0010i\u001a\u00020\u001aH\u0016J\u0010\u0010j\u001a\u0002092\u0006\u0010k\u001a\u00020\u001aH\u0016J\b\u0010l\u001a\u00020\u001aH\u0016J\b\u0010m\u001a\u000209H\u0016J\b\u0010n\u001a\u000209H\u0016J\u0010\u0010o\u001a\u00020\u001a2\u0006\u0010p\u001a\u00020qH\u0016J\u001a\u0010r\u001a\u0002092\u0006\u0010C\u001a\u00020\b2\b\b\u0002\u0010s\u001a\u00020\u001aH\u0002J\b\u0010t\u001a\u000209H\u0002J\u0010\u0010u\u001a\u0002092\u0006\u0010v\u001a\u00020\u001aH\u0002J\u0010\u0010w\u001a\u0002092\u0006\u0010N\u001a\u00020\u0007H\u0016J\u001a\u0010x\u001a\u0004\u0018\u00010\b2\u000e\u0010J\u001a\n\u0012\u0006\b\u0001\u0012\u00020F0KH\u0002J\u0012\u0010x\u001a\u0004\u0018\u00010\b2\u0006\u0010E\u001a\u00020FH\u0002J\u0018\u0010y\u001a\u00020\u00072\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0015H\u0002J\"\u0010z\u001a\u0004\u0018\u00010F2\u0006\u0010Z\u001a\u00020{2\u000e\u0010|\u001a\n\u0012\u0006\b\u0001\u0012\u00020F0KH\u0002J\b\u0010}\u001a\u00020\u001aH\u0016J\b\u0010~\u001a\u00020RH\u0016J\b\u0010\u007f\u001a\u00020RH\u0016J\u0012\u0010\u0080\u0001\u001a\u0002092\u0007\u0010\u0081\u0001\u001a\u00020\u001aH\u0016R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\rj\b\u0012\u0004\u0012\u00020\b`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u001f\u001a&\u0012\f\u0012\n \"*\u0004\u0018\u00010!0! \"*\u0012\u0012\f\u0012\n \"*\u0004\u0018\u00010!0!\u0018\u00010 0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.R\u0010\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0004\n\u0002\u00101R\u0010\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0004\n\u0002\u00104R\u0010\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0004\n\u0002\u00107¨\u0006\u0084\u0001"}, d2 = {"Ltv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService;", "Ltv/danmaku/biliplayerv2/service/AbsFunctionWidgetService;", "Ltv/danmaku/biliplayerimpl/AbsCorePlayerService;", "<init>", "()V", "mFunctionWidgetByToken", "Ljava/util/HashMap;", "Ltv/danmaku/biliplayerv2/service/FunctionWidgetToken;", "Ltv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService$FunctionWidgetRecord;", "Lkotlin/collections/HashMap;", "mPlayerContainer", "Ltv/danmaku/biliplayerimpl/PlayerContainerImpl;", "mShowingWidget", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mShowingWidgetWithDisableOrientation", "Ljava/util/LinkedList;", "mFunctionContainer", "Ltv/danmaku/biliplayerv2/widget/IFunctionContainer;", "mLoadingToken", "mLoadingLayoutParams", "Ltv/danmaku/biliplayerv2/widget/IFunctionContainer$LayoutParams;", "mPlayLimitToken", "mPendingRemoveWidget", "", "mRemoveWidgetRunnableScheduled", "", "mVisitingFunctionWidgets", "mDisableBufferingView", "mDismissWidgetWhenVideoCompleted", "mIsAlive", "mOnWidgetStateChangeListeners", "Ltv/danmaku/biliplayerv2/collection/Collections$SafeIteratorList;", "Ltv/danmaku/biliplayerv2/service/OnWidgetStateChangeListener;", "kotlin.jvm.PlatformType", "mHideBufferingRunnable", "Ljava/lang/Runnable;", "mRemoveWidgetRunnable", "mPlayerStateObserver", "tv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService$mPlayerStateObserver$1", "Ltv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService$mPlayerStateObserver$1;", "mWindowInsetObserver", "tv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService$mWindowInsetObserver$1", "Ltv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService$mWindowInsetObserver$1;", "mActivityLifecycleObserver", "tv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService$mActivityLifecycleObserver$1", "Ltv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService$mActivityLifecycleObserver$1;", "mMediaResourceObserver", "tv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService$mMediaResourceObserver$1", "Ltv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService$mMediaResourceObserver$1;", "mBufferingObserver", "tv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService$mBufferingObserver$1", "Ltv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService$mBufferingObserver$1;", "mRenderStartObserver", "tv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService$mRenderStartObserver$1", "Ltv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService$mRenderStartObserver$1;", "showPlayLimitWidget", "", "playLimit", "Lcom/bilibili/lib/media/resource/ExtraInfo$PlayLimit;", "notifyControllerTypeChanged", "notifyVideoChanged", "visitFunctionWidgets", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "record", "showWidget", "widget", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;", "layoutParams", "hideWidget", "hideLowerLevelWidgetsIfSingleton", "clazz", "Ljava/lang/Class;", "configuration", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget$Configuration;", "token", "isVisitingFunctionWidgetsList", "showWidgetInternal", "lastIndexOfTypeInShowingRecords", "", "type", "onStart", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onStop", "ensureFunctionContainer", "bindPlayerContainer", "playerContainer", "createView", "Landroid/view/View;", "context", "Landroid/content/Context;", "onCollectSharedParams", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "addOnWidgetStateChangeListener", "listener", "removeOnWidgetStateChangeListener", "hideAllWidget", "updateFunctionWidgetConfiguration", "updateFunctionWidgetAttribute", "attribute", "usable", "disableBufferingView", "disable", "changeOrientationEnable", "showBufferingWidget", "hideBufferingWidget", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "hideWidgetInternal", "forceRemove", "scheduleRemoveFunctionWidget", "hideAllWidgetInternal", "release", "removeWidget", "findFunctionWidgetRecord", "generateToken", "createWidget", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "classObj", "onBackPressed", "getAvailableHeight", "getAvailableWidth", "setDismissWidgetWhenVideoCompleted", "dismiss", "Companion", "FunctionWidgetRecord", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FunctionWidgetService extends AbsCorePlayerService implements AbsFunctionWidgetService {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "FunctionWidgetService";
    private boolean mDisableBufferingView;
    private IFunctionContainer mFunctionContainer;
    private boolean mIsAlive;
    private IFunctionContainer.LayoutParams mLoadingLayoutParams;
    private FunctionWidgetToken mLoadingToken;
    private FunctionWidgetToken mPlayLimitToken;
    private PlayerContainerImpl mPlayerContainer;
    private boolean mRemoveWidgetRunnableScheduled;
    private boolean mVisitingFunctionWidgets;
    private final HashMap<FunctionWidgetToken, FunctionWidgetRecord> mFunctionWidgetByToken = new HashMap<>();
    private final ArrayList<FunctionWidgetRecord> mShowingWidget = new ArrayList<>();
    private final LinkedList<FunctionWidgetRecord> mShowingWidgetWithDisableOrientation = new LinkedList<>();
    private final List<FunctionWidgetRecord> mPendingRemoveWidget = new LinkedList();
    private boolean mDismissWidgetWhenVideoCompleted = true;
    private final Collections.SafeIteratorList<OnWidgetStateChangeListener> mOnWidgetStateChangeListeners = Collections.safeIteratorList(new LinkedList());
    private final Runnable mHideBufferingRunnable = new Runnable() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            FunctionWidgetService.this.hideBufferingWidget();
        }
    };
    private final Runnable mRemoveWidgetRunnable = new Runnable() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            FunctionWidgetService.mRemoveWidgetRunnable$lambda$0(FunctionWidgetService.this);
        }
    };
    private final FunctionWidgetService$mPlayerStateObserver$1 mPlayerStateObserver = new FunctionWidgetService$mPlayerStateObserver$1(this);
    private final FunctionWidgetService$mWindowInsetObserver$1 mWindowInsetObserver = new FunctionWidgetService$mWindowInsetObserver$1(this);
    private final FunctionWidgetService$mActivityLifecycleObserver$1 mActivityLifecycleObserver = new FunctionWidgetService$mActivityLifecycleObserver$1(this);
    private final FunctionWidgetService$mMediaResourceObserver$1 mMediaResourceObserver = new IMediaResourceObserver() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService$mMediaResourceObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IMediaResourceObserver
        public /* synthetic */ void onUpdated(MediaResource mediaResource) {
            IMediaResourceObserver.CC.$default$onUpdated(this, mediaResource);
        }

        @Override // tv.danmaku.biliplayerv2.service.IMediaResourceObserver
        public boolean onPrepared(MediaResource resource) {
            FunctionWidgetToken it;
            ExtraInfo extra = resource != null ? resource.getExtraInfo() : null;
            ExtraInfo.PlayLimit playLimit = extra != null ? extra.getPlayLimit() : null;
            if (playLimit == null) {
                it = FunctionWidgetService.this.mPlayLimitToken;
                if (it != null) {
                    FunctionWidgetService functionWidgetService = FunctionWidgetService.this;
                    functionWidgetService.hideWidget(it);
                    functionWidgetService.mPlayLimitToken = null;
                    return true;
                }
                return true;
            }
            PlayerLog.i(FunctionWidgetService.TAG, "limit play, can not play");
            FunctionWidgetService.this.showPlayLimitWidget(playLimit);
            return false;
        }
    };
    private final FunctionWidgetService$mBufferingObserver$1 mBufferingObserver = new BufferingObserver() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService$mBufferingObserver$1
        @Override // tv.danmaku.biliplayerv2.service.BufferingObserver
        public void onBufferingStart(int extra) {
            FunctionWidgetService.this.showBufferingWidget();
        }

        @Override // tv.danmaku.biliplayerv2.service.BufferingObserver
        public void onBufferingEnd() {
            FunctionWidgetService.this.hideBufferingWidget();
        }
    };
    private final FunctionWidgetService$mRenderStartObserver$1 mRenderStartObserver = new IRenderStartObserver() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService$mRenderStartObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IRenderStartObserver
        public void onVideoRenderStart() {
            Runnable runnable;
            runnable = FunctionWidgetService.this.mHideBufferingRunnable;
            HandlerThreads.post(0, runnable);
        }

        @Override // tv.danmaku.biliplayerv2.service.IRenderStartObserver
        public void onAudioRenderStart() {
            Runnable runnable;
            runnable = FunctionWidgetService.this.mHideBufferingRunnable;
            HandlerThreads.post(0, runnable);
        }
    };

    /* compiled from: FunctionWidgetService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mRemoveWidgetRunnable$lambda$0(FunctionWidgetService this$0) {
        this$0.mRemoveWidgetRunnableScheduled = false;
        Iterable pendingRemoveWidgets = new LinkedList(this$0.mPendingRemoveWidget);
        this$0.mPendingRemoveWidget.clear();
        Iterable $this$forEach$iv = pendingRemoveWidgets;
        for (Object element$iv : $this$forEach$iv) {
            FunctionWidgetRecord it = (FunctionWidgetRecord) element$iv;
            it.getWidget().onRelease();
            it.getPlayerServiceInjector().release();
            this$0.mFunctionWidgetByToken.remove(it.getToken());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPlayLimitWidget(ExtraInfo.PlayLimit playLimit) {
        IFunctionContainer.LayoutParams layoutParams = new IFunctionContainer.LayoutParams(-1, -1);
        layoutParams.setEnterAnim(-1);
        layoutParams.setExitAnim(-1);
        layoutParams.setLayoutType(32);
        layoutParams.setFunctionType(1);
        PlayLimitFunctionWidget.PlayLimitConfiguration config = new PlayLimitFunctionWidget.PlayLimitConfiguration(playLimit);
        this.mPlayLimitToken = showWidget(PlayLimitFunctionWidget.class, layoutParams, config);
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public void notifyControllerTypeChanged() {
        visitFunctionWidgets(new Function1() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit notifyControllerTypeChanged$lambda$0;
                notifyControllerTypeChanged$lambda$0 = FunctionWidgetService.notifyControllerTypeChanged$lambda$0(FunctionWidgetService.this, (FunctionWidgetService.FunctionWidgetRecord) obj);
                return notifyControllerTypeChanged$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notifyControllerTypeChanged$lambda$0(FunctionWidgetService this$0, FunctionWidgetRecord it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((it.getConfig().getFlag() & 1) != 0) {
            hideWidgetInternal$default(this$0, it, false, 2, null);
        }
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public void notifyVideoChanged() {
        visitFunctionWidgets(new Function1() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit notifyVideoChanged$lambda$0;
                notifyVideoChanged$lambda$0 = FunctionWidgetService.notifyVideoChanged$lambda$0(FunctionWidgetService.this, (FunctionWidgetService.FunctionWidgetRecord) obj);
                return notifyVideoChanged$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notifyVideoChanged$lambda$0(FunctionWidgetService this$0, FunctionWidgetRecord it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((it.getConfig().getFlag() & 8) != 0) {
            this$0.removeWidget(it.getToken());
            return Unit.INSTANCE;
        }
        if ((it.getConfig().getFlag() & 2) != 0) {
            hideWidgetInternal$default(this$0, it, false, 2, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void visitFunctionWidgets(Function1<? super FunctionWidgetRecord, Unit> function1) {
        this.mVisitingFunctionWidgets = true;
        Map $this$forEach$iv = this.mFunctionWidgetByToken;
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            function1.invoke(element$iv.getValue());
        }
        this.mVisitingFunctionWidgets = false;
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public FunctionWidgetToken showWidget(AbsFunctionWidget widget, IFunctionContainer.LayoutParams layoutParams) {
        IFunctionContainer.LayoutParams actualLayoutParams;
        Intrinsics.checkNotNullParameter(widget, "widget");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        if (isVisitingFunctionWidgetsList()) {
            return null;
        }
        if (!this.mIsAlive) {
            PlayerLog.i(PlayerLogModule.Function, "function service is not alive, but want to show:" + widget);
            return null;
        }
        FunctionWidgetRecord record = findFunctionWidgetRecord(widget);
        if (!Intrinsics.areEqual(layoutParams, AbsFunctionWidgetService.Companion.getEmptyLayoutParams()) || record == null || (actualLayoutParams = record.getLayoutParams()) == null) {
            actualLayoutParams = layoutParams;
        }
        if (record != null && !record.getConfig().getForceNewInstance()) {
            hideLowerLevelWidgetsIfSingleton(record, actualLayoutParams);
            showWidgetInternal(record, actualLayoutParams, null);
            return record.getToken();
        }
        FunctionWidgetToken token = generateToken(widget, layoutParams);
        widget.setToken(token);
        FunctionWidgetRecord record2 = new FunctionWidgetRecord(widget, widget.getFunctionWidgetConfig(), token);
        hideLowerLevelWidgetsIfSingleton(record2, actualLayoutParams);
        if (widget.getMembersInjector()) {
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            playerContainerImpl.getPlayerServiceManager().getMembersInjector().injectMembers(widget);
        } else {
            PlayerServiceInjector playerServiceInjector = record2.getPlayerServiceInjector();
            PlayerContainerImpl playerContainerImpl2 = this.mPlayerContainer;
            if (playerContainerImpl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl2 = null;
            }
            playerServiceInjector.injectPlayerServices(widget, playerContainerImpl2);
        }
        PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
        if (playerContainerImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl3 = null;
        }
        widget.bindPlayerContainer(playerContainerImpl3);
        showWidgetInternal(record2, actualLayoutParams, null);
        this.mFunctionWidgetByToken.put(token, record2);
        return record2.getToken();
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public void hideWidget(AbsFunctionWidget widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        FunctionWidgetRecord record = findFunctionWidgetRecord(widget);
        if (record == null || record.isRemoving()) {
            return;
        }
        hideWidgetInternal$default(this, record, false, 2, null);
    }

    private final void hideLowerLevelWidgetsIfSingleton(final FunctionWidgetRecord record, final IFunctionContainer.LayoutParams layoutParams) {
        if (record.getConfig().getLaunchType() == 1) {
            visitFunctionWidgets(new Function1() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService$$ExternalSyntheticLambda9
                public final Object invoke(Object obj) {
                    Unit hideLowerLevelWidgetsIfSingleton$lambda$0;
                    hideLowerLevelWidgetsIfSingleton$lambda$0 = FunctionWidgetService.hideLowerLevelWidgetsIfSingleton$lambda$0(FunctionWidgetService.FunctionWidgetRecord.this, layoutParams, this, (FunctionWidgetService.FunctionWidgetRecord) obj);
                    return hideLowerLevelWidgetsIfSingleton$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit hideLowerLevelWidgetsIfSingleton$lambda$0(FunctionWidgetRecord $record, IFunctionContainer.LayoutParams $layoutParams, FunctionWidgetService this$0, FunctionWidgetRecord it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!Intrinsics.areEqual(it, $record)) {
            IFunctionContainer.LayoutParams layoutParams = it.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams);
            if (layoutParams.getFunctionType() >= $layoutParams.getFunctionType()) {
                hideWidgetInternal$default(this$0, it, false, 2, null);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public FunctionWidgetToken showWidget(Class<? extends AbsFunctionWidget> cls, IFunctionContainer.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        return showWidget(cls, layoutParams, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public FunctionWidgetToken showWidget(Class<? extends AbsFunctionWidget> cls, IFunctionContainer.LayoutParams layoutParams, AbsFunctionWidget.Configuration configuration) {
        IFunctionContainer.LayoutParams actualLayoutParams;
        FunctionWidgetConfig config;
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        PlayerContainerImpl playerContainerImpl = null;
        if (isVisitingFunctionWidgetsList()) {
            return null;
        }
        if (!this.mIsAlive) {
            PlayerLog.i(PlayerLogModule.Function, "function service is not alive, but want to show:" + cls);
            return null;
        }
        FunctionWidgetRecord record = findFunctionWidgetRecord(cls);
        if (!Intrinsics.areEqual(layoutParams, AbsFunctionWidgetService.Companion.getEmptyLayoutParams()) || record == null || (actualLayoutParams = record.getLayoutParams()) == null) {
            actualLayoutParams = layoutParams;
        }
        if (record != null && !record.getConfig().getForceNewInstance()) {
            hideLowerLevelWidgetsIfSingleton(record, actualLayoutParams);
            showWidgetInternal(record, actualLayoutParams, configuration);
            return record.getToken();
        }
        boolean z = false;
        if (record != null && (config = record.getConfig()) != null && config.getForceNewInstance()) {
            z = true;
        }
        if (z) {
            PlayerLog.i(PlayerLogModule.Function, "forceNewInstance flag is true, so create a new instance");
        } else {
            PlayerLog.i(PlayerLogModule.Function, "widget is not created, create a new instance");
        }
        PlayerContainerImpl playerContainerImpl2 = this.mPlayerContainer;
        if (playerContainerImpl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl2 = null;
        }
        AbsFunctionWidget widget = createWidget(playerContainerImpl2, cls);
        if (widget == null) {
            return null;
        }
        FunctionWidgetToken token = generateToken(widget, layoutParams);
        widget.setToken(token);
        FunctionWidgetRecord record2 = new FunctionWidgetRecord(widget, widget.getFunctionWidgetConfig(), token);
        if (BuildConfig.DEBUG) {
            PlayerLog.i(PlayerLogModule.Function, "create widget: clazz=" + widget.getClass() + ", config=" + record2.getConfig());
        }
        hideLowerLevelWidgetsIfSingleton(record2, actualLayoutParams);
        if (widget.getMembersInjector()) {
            PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
            if (playerContainerImpl3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl3 = null;
            }
            playerContainerImpl3.getPlayerServiceManager().getMembersInjector().injectMembers(widget);
        } else {
            PlayerServiceInjector playerServiceInjector = record2.getPlayerServiceInjector();
            PlayerContainerImpl playerContainerImpl4 = this.mPlayerContainer;
            if (playerContainerImpl4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl4 = null;
            }
            playerServiceInjector.injectPlayerServices(widget, playerContainerImpl4);
        }
        PlayerContainerImpl playerContainerImpl5 = this.mPlayerContainer;
        if (playerContainerImpl5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainerImpl = playerContainerImpl5;
        }
        widget.bindPlayerContainer(playerContainerImpl);
        showWidgetInternal(record2, actualLayoutParams, configuration);
        this.mFunctionWidgetByToken.put(token, record2);
        return token;
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public void showWidget(FunctionWidgetToken token) {
        Intrinsics.checkNotNullParameter(token, "token");
        showWidget(token, (AbsFunctionWidget.Configuration) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public void showWidget(FunctionWidgetToken token, AbsFunctionWidget.Configuration configuration) {
        Intrinsics.checkNotNullParameter(token, "token");
        if (isVisitingFunctionWidgetsList()) {
            return;
        }
        FunctionWidgetRecord record = this.mFunctionWidgetByToken.get(token);
        if (record == null || record.isRemoving()) {
            PlayerLog.w(PlayerLogModule.Function, "not found a widget for token: " + token);
        } else if (record.isShowing()) {
            PlayerLog.w(PlayerLogModule.Function, "widget for token: " + token + " is already showing");
        } else {
            IFunctionContainer.LayoutParams layoutParams = record.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = AbsFunctionWidgetService.Companion.getEmptyLayoutParams();
            }
            showWidgetInternal(record, layoutParams, configuration);
        }
    }

    private final boolean isVisitingFunctionWidgetsList() {
        if (this.mVisitingFunctionWidgets) {
            if (BuildConfig.DEBUG) {
                throw new IllegalStateException("could not show widget when visiting function widgets");
            }
            PlayerLog.e(PlayerLogModule.Function, "could not show widget when visiting function widgets");
            return true;
        }
        return false;
    }

    private final void showWidgetInternal(final FunctionWidgetRecord record, IFunctionContainer.LayoutParams layoutParams, AbsFunctionWidget.Configuration configuration) {
        if (!this.mIsAlive) {
            PlayerLog.i(PlayerLogModule.Function, "function service is not alive, but want to show:" + record);
        } else if (record.isRemoving()) {
            PlayerLog.w(PlayerLogModule.Function, "wan to hideWidget, but this widget is removing, do nothing");
        } else if (record.isShowing() && !layoutParams.different(record.getLayoutParams())) {
            PlayerLog.i(PlayerLogModule.Function, "function widget already showing and layoutParams not changed, do nothing!!!");
        } else {
            this.mShowingWidget.remove(record);
            this.mShowingWidgetWithDisableOrientation.remove(record);
            int insertIndex = lastIndexOfTypeInShowingRecords(layoutParams.getFunctionType());
            if (insertIndex == -1) {
                if (BuildConfig.DEBUG) {
                    throw new IllegalStateException("something error, do not found a correct index: " + insertIndex);
                }
                PlayerLog.e(PlayerLogModule.Function, "something error, do not found a correct index: " + insertIndex);
                return;
            }
            this.mShowingWidget.add(insertIndex, record);
            if ((record.getConfig().getFlag() & 64) != 0 && !this.mShowingWidgetWithDisableOrientation.contains(record)) {
                this.mShowingWidgetWithDisableOrientation.add(record);
            }
            if (BuildConfig.DEBUG) {
                StringBuilder strBuilder = new StringBuilder();
                Iterable $this$forEach$iv = this.mShowingWidget;
                for (Object element$iv : $this$forEach$iv) {
                    FunctionWidgetRecord it = (FunctionWidgetRecord) element$iv;
                    IFunctionContainer.LayoutParams layoutParams2 = it.getLayoutParams();
                    strBuilder.append(layoutParams2 != null ? layoutParams2.getFunctionType() : -1);
                }
                PlayerLog.d(PlayerLogModule.Function, "showing record..." + ((Object) strBuilder));
            }
            record.setLayoutParams(layoutParams);
            ensureFunctionContainer();
            IFunctionContainer iFunctionContainer = this.mFunctionContainer;
            if (iFunctionContainer != null) {
                iFunctionContainer.showWidget(record.getWidget(), layoutParams);
            }
            if (record.isShowing()) {
                record.getWidget().onNewLayoutParams(layoutParams);
                record.setPendingDispatchConfiguration(configuration);
            } else {
                record.getWidget().onWidgetShow(configuration);
            }
            boolean z = true;
            record.setShowing(true);
            FunctionWidgetInsetConfig functionInsetConfig = record.getWidget().getFunctionInsetConfig();
            if ((functionInsetConfig == null || !functionInsetConfig.getSupport()) ? false : false) {
                AbsFunctionWidget widget = record.getWidget();
                PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
                if (playerContainerImpl == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainerImpl = null;
                }
                widget.onWindowInsetChanged(playerContainerImpl.getActivityStateService().getWindowInset());
            }
            if (record.getPendingDispatchConfiguration() != null) {
                AbsFunctionWidget widget2 = record.getWidget();
                AbsFunctionWidget.Configuration pendingDispatchConfiguration = record.getPendingDispatchConfiguration();
                Intrinsics.checkNotNull(pendingDispatchConfiguration);
                widget2.onConfigurationChanged(pendingDispatchConfiguration);
                record.setPendingDispatchConfiguration(null);
            }
            this.mOnWidgetStateChangeListeners.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService$$ExternalSyntheticLambda7
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    FunctionWidgetService.showWidgetInternal$lambda$1(FunctionWidgetService.FunctionWidgetRecord.this, (OnWidgetStateChangeListener) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showWidgetInternal$lambda$1(FunctionWidgetRecord $record, OnWidgetStateChangeListener it) {
        it.onWidgetShow($record.getToken());
    }

    private final int lastIndexOfTypeInShowingRecords(int type) {
        if (type != 0 && type != 1 && type != 2 && type != 3) {
            throw new IllegalArgumentException("illegal function type " + type);
        }
        if (this.mShowingWidget.size() == 0) {
            return 0;
        }
        for (int i = this.mShowingWidget.size() - 1; -1 < i; i--) {
            FunctionWidgetRecord functionWidgetRecord = this.mShowingWidget.get(i);
            Intrinsics.checkNotNullExpressionValue(functionWidgetRecord, "get(...)");
            FunctionWidgetRecord r = functionWidgetRecord;
            IFunctionContainer.LayoutParams layoutParams = r.getLayoutParams();
            if ((layoutParams != null ? layoutParams.getFunctionType() : 0) <= type) {
                return i + 1;
            }
        }
        return 0;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
        this.mIsAlive = true;
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        PlayerContainerImpl playerContainerImpl2 = null;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        playerContainerImpl.getActivityStateService().registerLifecycle(this.mActivityLifecycleObserver, LifecycleState.ACTIVITY_STOP);
        PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
        if (playerContainerImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl3 = null;
        }
        playerContainerImpl3.getActivityStateService().registerWindowInset(this.mWindowInsetObserver);
        PlayerContainerImpl playerContainerImpl4 = this.mPlayerContainer;
        if (playerContainerImpl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl4 = null;
        }
        playerContainerImpl4.getPlayerCoreService().registerState(this.mPlayerStateObserver, 6);
        PlayerContainerImpl playerContainerImpl5 = this.mPlayerContainer;
        if (playerContainerImpl5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl5 = null;
        }
        playerContainerImpl5.getPlayerCoreService().registerBufferingState(this.mBufferingObserver);
        PlayerContainerImpl playerContainerImpl6 = this.mPlayerContainer;
        if (playerContainerImpl6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl6 = null;
        }
        playerContainerImpl6.getPlayerCoreService().addRenderStartObserver(this.mRenderStartObserver);
        PlayerContainerImpl playerContainerImpl7 = this.mPlayerContainer;
        if (playerContainerImpl7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainerImpl2 = playerContainerImpl7;
        }
        playerContainerImpl2.getPlayerCoreService().addMediaResourceObserver(this.mMediaResourceObserver);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        this.mIsAlive = false;
        HandlerThreads.remove(0, this.mHideBufferingRunnable);
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        PlayerContainerImpl playerContainerImpl2 = null;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        playerContainerImpl.getActivityStateService().unregisterLifecycle(this.mActivityLifecycleObserver);
        PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
        if (playerContainerImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl3 = null;
        }
        playerContainerImpl3.getActivityStateService().unregisterWindowInset(this.mWindowInsetObserver);
        PlayerContainerImpl playerContainerImpl4 = this.mPlayerContainer;
        if (playerContainerImpl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl4 = null;
        }
        playerContainerImpl4.getPlayerCoreService().unregisterState(this.mPlayerStateObserver);
        PlayerContainerImpl playerContainerImpl5 = this.mPlayerContainer;
        if (playerContainerImpl5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl5 = null;
        }
        playerContainerImpl5.getPlayerCoreService().unregisterBufferingState(this.mBufferingObserver);
        PlayerContainerImpl playerContainerImpl6 = this.mPlayerContainer;
        if (playerContainerImpl6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl6 = null;
        }
        playerContainerImpl6.getPlayerCoreService().removeRenderStartObserver(this.mRenderStartObserver);
        PlayerContainerImpl playerContainerImpl7 = this.mPlayerContainer;
        if (playerContainerImpl7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainerImpl2 = playerContainerImpl7;
        }
        playerContainerImpl2.getPlayerCoreService().removeMediaResourceObserver(this.mMediaResourceObserver);
        hideAllWidgetInternal(true);
        this.mFunctionWidgetByToken.clear();
        IFunctionContainer iFunctionContainer = this.mFunctionContainer;
        if (iFunctionContainer != null) {
            iFunctionContainer.release();
        }
    }

    private final void ensureFunctionContainer() {
        if (this.mFunctionContainer == null) {
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            IPanelContainer panelContainer = playerContainerImpl.getPanelContainer();
            if (panelContainer != null) {
                panelContainer.ensureBuiltInLayer(BuiltInLayer.LayerFunction, this);
            }
        }
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService
    public void bindPlayerContainer(PlayerContainerImpl playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    @Override // tv.danmaku.biliplayerv2.service.IWithViewPlayerService
    public View createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FunctionContainer functionContainer = new FunctionContainer(context);
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        functionContainer.bindPlayerContainer(playerContainerImpl);
        this.mFunctionContainer = functionContainer;
        return functionContainer;
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService, tv.danmaku.biliplayerv2.service.IPlayerService
    public void onCollectSharedParams(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        hideAllWidget();
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public void addOnWidgetStateChangeListener(OnWidgetStateChangeListener listener) {
        if (this.mOnWidgetStateChangeListeners.contains(listener)) {
            return;
        }
        this.mOnWidgetStateChangeListeners.add(listener);
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public void removeOnWidgetStateChangeListener(OnWidgetStateChangeListener listener) {
        this.mOnWidgetStateChangeListeners.remove(listener);
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public void hideAllWidget() {
        hideAllWidgetInternal(false);
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public void hideWidget(FunctionWidgetToken token) {
        Intrinsics.checkNotNullParameter(token, "token");
        PlayerLog.i(PlayerLogModule.Function, "hide widget...");
        FunctionWidgetRecord record = this.mFunctionWidgetByToken.get(token);
        if (record == null || record.isRemoving()) {
            PlayerLog.i(PlayerLogModule.Function, "do not found a widget for token(" + token + ")");
        } else {
            hideWidgetInternal$default(this, record, false, 2, null);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public void updateFunctionWidgetConfiguration(FunctionWidgetToken token, AbsFunctionWidget.Configuration configuration) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        FunctionWidgetRecord r = this.mFunctionWidgetByToken.get(token);
        boolean z = true;
        if (r != null && r.isRemoving()) {
            PlayerLog.w(PlayerLogModule.Function, "wan to updateFunctionWidgetConfiguration, but this widget is removing, do nothing");
            return;
        }
        if (r == null || !r.isShowing()) {
            z = false;
        }
        if (z) {
            r.getWidget().onConfigurationChanged(configuration);
        } else if (r != null) {
            r.setPendingDispatchConfiguration(configuration);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public void updateFunctionWidgetAttribute(FunctionWidgetToken token, int attribute, boolean usable) {
        Intrinsics.checkNotNullParameter(token, "token");
        FunctionWidgetRecord record = this.mFunctionWidgetByToken.get(token);
        if (record == null) {
            PlayerLog.w(PlayerLogModule.Function, "wan to updateFunctionWidgetAttribute, not found");
        } else if (record.isRemoving()) {
            PlayerLog.w(PlayerLogModule.Function, "wan to updateFunctionWidgetAttribute, but this widget is removing, do nothing");
        } else if (usable && (record.getConfig().getFlag() & 64) != 0) {
            PlayerLog.w(PlayerLogModule.Function, "wan to updateFunctionWidgetAttribute, but this widget has open attribute, do nothing");
        } else if (!usable && (record.getConfig().getFlag() & 64) == 0) {
            PlayerLog.w(PlayerLogModule.Function, "wan to updateFunctionWidgetAttribute, but this widget has close attribute, do nothing");
        } else {
            switch (attribute) {
                case 4:
                    PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
                    if (playerContainerImpl == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                        playerContainerImpl = null;
                    }
                    LifecycleState state = playerContainerImpl.getActivityStateService().getLifecycleState();
                    if (usable && record.isShowing() && (state == LifecycleState.ACTIVITY_STOP || state == LifecycleState.ACTIVITY_DESTROY)) {
                        hideWidgetInternal$default(this, record, false, 2, null);
                        if (record.isRemoving()) {
                            PlayerLog.w(PlayerLogModule.Function, "wan to updateFunctionWidgetAttribute, has stop dismiss");
                            return;
                        }
                    }
                    break;
                case 32:
                    if (usable && record.isShowing()) {
                        PlayerContainerImpl playerContainerImpl2 = this.mPlayerContainer;
                        if (playerContainerImpl2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                            playerContainerImpl2 = null;
                        }
                        if (playerContainerImpl2.getPlayerCoreService().getState() == 6) {
                            hideWidgetInternal$default(this, record, false, 2, null);
                            if (record.isRemoving()) {
                                PlayerLog.w(PlayerLogModule.Function, "wan to updateFunctionWidgetAttribute, has complete dismiss");
                                return;
                            }
                        }
                    }
                    break;
                case 64:
                    if (usable && !this.mShowingWidgetWithDisableOrientation.contains(record)) {
                        this.mShowingWidgetWithDisableOrientation.add(record);
                        break;
                    } else if (!usable && this.mShowingWidgetWithDisableOrientation.contains(record)) {
                        this.mShowingWidgetWithDisableOrientation.remove(record);
                        break;
                    }
                    break;
            }
            if (usable) {
                record.getConfig().getFlag();
            } else {
                record.getConfig().getFlag();
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public void disableBufferingView(boolean disable) {
        this.mDisableBufferingView = disable;
        if (disable) {
            hideBufferingWidget();
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public boolean changeOrientationEnable() {
        return this.mShowingWidgetWithDisableOrientation.isEmpty();
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public void showBufferingWidget() {
        BLog.d(TAG, "showBufferingWidget: " + this.mDisableBufferingView);
        if (this.mDisableBufferingView) {
            return;
        }
        if (this.mLoadingLayoutParams == null) {
            this.mLoadingLayoutParams = new IFunctionContainer.LayoutParams(-2, -2);
            IFunctionContainer.LayoutParams layoutParams = this.mLoadingLayoutParams;
            Intrinsics.checkNotNull(layoutParams);
            layoutParams.setFunctionType(0);
            IFunctionContainer.LayoutParams layoutParams2 = this.mLoadingLayoutParams;
            Intrinsics.checkNotNull(layoutParams2);
            layoutParams2.setLayoutType(16);
            IFunctionContainer.LayoutParams layoutParams3 = this.mLoadingLayoutParams;
            Intrinsics.checkNotNull(layoutParams3);
            layoutParams3.setEnterAnim(-1);
            IFunctionContainer.LayoutParams layoutParams4 = this.mLoadingLayoutParams;
            Intrinsics.checkNotNull(layoutParams4);
            layoutParams4.setExitAnim(-1);
            IFunctionContainer.LayoutParams layoutParams5 = this.mLoadingLayoutParams;
            Intrinsics.checkNotNull(layoutParams5);
            layoutParams5.touchOutsideDismiss(false);
        }
        IFunctionContainer.LayoutParams layoutParams6 = this.mLoadingLayoutParams;
        Intrinsics.checkNotNull(layoutParams6);
        this.mLoadingToken = showWidget(LoadingFunctionWidget.class, layoutParams6);
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public void hideBufferingWidget() {
        FunctionWidgetToken it = this.mLoadingToken;
        if (it != null) {
            hideWidget(it);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public boolean dispatchTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        IFunctionContainer iFunctionContainer = this.mFunctionContainer;
        View view2 = iFunctionContainer instanceof View ? (View) iFunctionContainer : null;
        if (view2 != null) {
            return view2.dispatchTouchEvent(event);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void hideWidgetInternal$default(FunctionWidgetService functionWidgetService, FunctionWidgetRecord functionWidgetRecord, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        functionWidgetService.hideWidgetInternal(functionWidgetRecord, z);
    }

    private final void hideWidgetInternal(final FunctionWidgetRecord record, boolean forceRemove) {
        if (record.isRemoving()) {
            PlayerLog.w(PlayerLogModule.Function, "want to hideWidget, but this widget is removing, do nothing");
        } else if (!record.isShowing()) {
            PlayerLog.w(PlayerLogModule.Function, "want to hideWidget, but this widget is not showing, do nothing");
            if (forceRemove) {
                this.mPendingRemoveWidget.add(record);
                record.setRemoving(true);
                record.getToken().setRemoved(true);
                scheduleRemoveFunctionWidget();
            }
        } else {
            record.setShowing(false);
            record.getWidget().onWidgetDismiss();
            IFunctionContainer iFunctionContainer = this.mFunctionContainer;
            if (iFunctionContainer != null) {
                iFunctionContainer.hideWidget(record.getWidget());
            }
            if ((record.getConfig().getFlag() & 16) == 0 || forceRemove) {
                this.mPendingRemoveWidget.add(record);
                record.setRemoving(true);
                record.getToken().setRemoved(true);
                scheduleRemoveFunctionWidget();
            }
            this.mShowingWidget.remove(record);
            this.mShowingWidgetWithDisableOrientation.remove(record);
            if (BuildConfig.DEBUG) {
                StringBuilder strBuilder = new StringBuilder();
                Iterable $this$forEach$iv = this.mShowingWidget;
                for (Object element$iv : $this$forEach$iv) {
                    FunctionWidgetRecord it = (FunctionWidgetRecord) element$iv;
                    IFunctionContainer.LayoutParams layoutParams = it.getLayoutParams();
                    strBuilder.append(layoutParams != null ? layoutParams.getFunctionType() : -1);
                }
                PlayerLog.d(PlayerLogModule.Function, "hide record..." + ((Object) strBuilder));
            }
            this.mOnWidgetStateChangeListeners.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService$$ExternalSyntheticLambda2
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    FunctionWidgetService.hideWidgetInternal$lambda$1(FunctionWidgetService.FunctionWidgetRecord.this, (OnWidgetStateChangeListener) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideWidgetInternal$lambda$1(FunctionWidgetRecord $record, OnWidgetStateChangeListener it) {
        it.onWidgetDismiss($record.getToken());
    }

    private final void scheduleRemoveFunctionWidget() {
        if (this.mRemoveWidgetRunnableScheduled) {
            return;
        }
        this.mRemoveWidgetRunnableScheduled = true;
        HandlerThreads.getHandler(0).post(this.mRemoveWidgetRunnable);
    }

    private final void hideAllWidgetInternal(final boolean release) {
        visitFunctionWidgets(new Function1() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit hideAllWidgetInternal$lambda$0;
                hideAllWidgetInternal$lambda$0 = FunctionWidgetService.hideAllWidgetInternal$lambda$0(FunctionWidgetService.this, release, (FunctionWidgetService.FunctionWidgetRecord) obj);
                return hideAllWidgetInternal$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit hideAllWidgetInternal$lambda$0(FunctionWidgetService this$0, boolean $release, FunctionWidgetRecord it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.hideWidgetInternal(it, $release);
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public void removeWidget(FunctionWidgetToken token) {
        Intrinsics.checkNotNullParameter(token, "token");
        FunctionWidgetRecord record = this.mFunctionWidgetByToken.get(token);
        if (record == null) {
            PlayerLog.i(PlayerLogModule.Function, "do not found a widget for token(" + token + ")");
        } else {
            hideWidgetInternal(record, true);
        }
    }

    private final FunctionWidgetRecord findFunctionWidgetRecord(final Class<? extends AbsFunctionWidget> cls) {
        final Ref.ObjectRef result = new Ref.ObjectRef();
        visitFunctionWidgets(new Function1() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit findFunctionWidgetRecord$lambda$0;
                findFunctionWidgetRecord$lambda$0 = FunctionWidgetService.findFunctionWidgetRecord$lambda$0(cls, result, (FunctionWidgetService.FunctionWidgetRecord) obj);
                return findFunctionWidgetRecord$lambda$0;
            }
        });
        return (FunctionWidgetRecord) result.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit findFunctionWidgetRecord$lambda$0(Class $clazz, Ref.ObjectRef $result, FunctionWidgetRecord it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual(it.getWidget().getClass(), $clazz) && !it.isRemoving()) {
            PlayerLog.i(PlayerLogModule.Function, "found widget for clazz=" + $clazz.getName());
            $result.element = it;
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final FunctionWidgetRecord findFunctionWidgetRecord(final AbsFunctionWidget widget) {
        final Ref.ObjectRef result = new Ref.ObjectRef();
        visitFunctionWidgets(new Function1() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit findFunctionWidgetRecord$lambda$1;
                findFunctionWidgetRecord$lambda$1 = FunctionWidgetService.findFunctionWidgetRecord$lambda$1(AbsFunctionWidget.this, result, (FunctionWidgetService.FunctionWidgetRecord) obj);
                return findFunctionWidgetRecord$lambda$1;
            }
        });
        return (FunctionWidgetRecord) result.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit findFunctionWidgetRecord$lambda$1(AbsFunctionWidget $widget, Ref.ObjectRef $result, FunctionWidgetRecord it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual(it.getWidget(), $widget) && !it.isRemoving()) {
            PlayerLog.i(PlayerLogModule.Function, "found widget for clazz=" + $widget.getClass().getName());
            $result.element = it;
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final FunctionWidgetToken generateToken(AbsFunctionWidget widget, IFunctionContainer.LayoutParams layoutParams) {
        FunctionWidgetToken it = new FunctionWidgetToken(widget.hashCode(), widget.getClass());
        it.setFunctionType(layoutParams.getFunctionType());
        return it;
    }

    private final AbsFunctionWidget createWidget(PlayerContainer playerContainer, Class<? extends AbsFunctionWidget> cls) {
        try {
            Constructor constructor = cls.getConstructor(Context.class);
            if (constructor != null) {
                return constructor.newInstance(playerContainer.getContext());
            }
            return null;
        } catch (Exception e) {
            throw new IllegalStateException("create widget failed! " + e);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public boolean onBackPressed() {
        if (this.mShowingWidget.isEmpty()) {
            return false;
        }
        FunctionWidgetRecord functionWidgetRecord = this.mShowingWidget.get(this.mShowingWidget.size() - 1);
        Intrinsics.checkNotNullExpressionValue(functionWidgetRecord, "get(...)");
        FunctionWidgetRecord record = functionWidgetRecord;
        if (record.getWidget().onBackPressed()) {
            return true;
        }
        IFunctionContainer.LayoutParams layoutParams = record.getLayoutParams();
        int ftype = layoutParams != null ? layoutParams.getFunctionType() : 0;
        if (ftype <= 1) {
            return false;
        }
        hideWidget(record.getToken());
        return true;
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public int getAvailableHeight() {
        IFunctionContainer iFunctionContainer = this.mFunctionContainer;
        if (iFunctionContainer != null) {
            return iFunctionContainer.getAvailableHeight();
        }
        return 0;
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public int getAvailableWidth() {
        IFunctionContainer iFunctionContainer = this.mFunctionContainer;
        if (iFunctionContainer != null) {
            return iFunctionContainer.getAvailableWidth();
        }
        return 0;
    }

    @Override // tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService
    public void setDismissWidgetWhenVideoCompleted(boolean dismiss) {
        this.mDismissWidgetWhenVideoCompleted = dismiss;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FunctionWidgetService.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006."}, d2 = {"Ltv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService$FunctionWidgetRecord;", "", "widget", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;", "config", "Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig;", "token", "Ltv/danmaku/biliplayerv2/service/FunctionWidgetToken;", "<init>", "(Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig;Ltv/danmaku/biliplayerv2/service/FunctionWidgetToken;)V", "getWidget", "()Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;", "getConfig", "()Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig;", "getToken", "()Ltv/danmaku/biliplayerv2/service/FunctionWidgetToken;", "playerServiceInjector", "Ltv/danmaku/biliplayerv2/injection/PlayerServiceInjector;", "getPlayerServiceInjector", "()Ltv/danmaku/biliplayerv2/injection/PlayerServiceInjector;", "bindToViewJob", "Lkotlinx/coroutines/Job;", "getBindToViewJob", "()Lkotlinx/coroutines/Job;", "setBindToViewJob", "(Lkotlinx/coroutines/Job;)V", "value", "", "isShowing", "()Z", "setShowing", "(Z)V", "isRemoving", "setRemoving", "layoutParams", "Ltv/danmaku/biliplayerv2/widget/IFunctionContainer$LayoutParams;", "getLayoutParams", "()Ltv/danmaku/biliplayerv2/widget/IFunctionContainer$LayoutParams;", "setLayoutParams", "(Ltv/danmaku/biliplayerv2/widget/IFunctionContainer$LayoutParams;)V", "pendingDispatchConfiguration", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget$Configuration;", "getPendingDispatchConfiguration", "()Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget$Configuration;", "setPendingDispatchConfiguration", "(Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget$Configuration;)V", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class FunctionWidgetRecord {
        private Job bindToViewJob;
        private final FunctionWidgetConfig config;
        private boolean isRemoving;
        private boolean isShowing;
        private IFunctionContainer.LayoutParams layoutParams;
        private AbsFunctionWidget.Configuration pendingDispatchConfiguration;
        private final PlayerServiceInjector playerServiceInjector;
        private final FunctionWidgetToken token;
        private final AbsFunctionWidget widget;

        public FunctionWidgetRecord(AbsFunctionWidget widget, FunctionWidgetConfig config, FunctionWidgetToken token) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(token, "token");
            this.widget = widget;
            this.config = config;
            this.token = token;
            this.playerServiceInjector = new PlayerServiceInjector();
        }

        public final AbsFunctionWidget getWidget() {
            return this.widget;
        }

        public final FunctionWidgetConfig getConfig() {
            return this.config;
        }

        public final FunctionWidgetToken getToken() {
            return this.token;
        }

        public final PlayerServiceInjector getPlayerServiceInjector() {
            return this.playerServiceInjector;
        }

        public final Job getBindToViewJob() {
            return this.bindToViewJob;
        }

        public final void setBindToViewJob(Job job) {
            this.bindToViewJob = job;
        }

        public final boolean isShowing() {
            return this.isShowing;
        }

        public final void setShowing(boolean value) {
            this.isShowing = value;
            this.token.setShowing(value);
        }

        public final boolean isRemoving() {
            return this.isRemoving;
        }

        public final void setRemoving(boolean z) {
            this.isRemoving = z;
        }

        public final IFunctionContainer.LayoutParams getLayoutParams() {
            return this.layoutParams;
        }

        public final void setLayoutParams(IFunctionContainer.LayoutParams layoutParams) {
            this.layoutParams = layoutParams;
        }

        public final AbsFunctionWidget.Configuration getPendingDispatchConfiguration() {
            return this.pendingDispatchConfiguration;
        }

        public final void setPendingDispatchConfiguration(AbsFunctionWidget.Configuration configuration) {
            this.pendingDispatchConfiguration = configuration;
        }
    }
}