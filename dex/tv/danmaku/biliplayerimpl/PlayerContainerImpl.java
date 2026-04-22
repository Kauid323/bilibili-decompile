package tv.danmaku.biliplayerimpl;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tv.danmaku.biliplayerimpl.PlayerContainerImpl;
import tv.danmaku.biliplayerimpl.core.IPlayerRenderContextService;
import tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2;
import tv.danmaku.biliplayerimpl.panel.PanelContainer;
import tv.danmaku.biliplayerimpl.report.share.SharedPlayReportService;
import tv.danmaku.biliplayerv2.ControlContainerConfig;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.DirectorVersion;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerParamsV2;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.ProjectionCallback;
import tv.danmaku.biliplayerv2.panel.BuiltInLayer;
import tv.danmaku.biliplayerv2.panel.IPanelContainer;
import tv.danmaku.biliplayerv2.panel.IPlayerLayer;
import tv.danmaku.biliplayerv2.panel.VideoInset;
import tv.danmaku.biliplayerv2.profiler.PlayerProfiler;
import tv.danmaku.biliplayerv2.profiler.ProfilerHandler;
import tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService;
import tv.danmaku.biliplayerv2.service.IActivityStateService;
import tv.danmaku.biliplayerv2.service.IControlContainerService;
import tv.danmaku.biliplayerv2.service.IPlayDirectorServiceV3;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.IPlayerServiceManager;
import tv.danmaku.biliplayerv2.service.IRenderContainerService;
import tv.danmaku.biliplayerv2.service.IToastService;
import tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.IWithViewPlayerService;
import tv.danmaku.biliplayerv2.service.LifecycleState;
import tv.danmaku.biliplayerv2.service.PlayerDataSource;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.audio.AudioFocusService;
import tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService;
import tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService;
import tv.danmaku.biliplayerv2.service.interact.log.DanmakuLogger;
import tv.danmaku.biliplayerv2.service.network.PlayerNetworkMonitor;
import tv.danmaku.biliplayerv2.service.report.IReporterService;
import tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatServiceInner;
import tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: PlayerContainerImpl.kt */
@Metadata(d1 = {"\u0000Ð\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\u0018\u0000 ®\u00012\u00020\u0001:\u0006¬\u0001\u00ad\u0001®\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J$\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u001a\u0010M\u001a\u00020D2\u0006\u0010N\u001a\u00020H2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0018\u0010O\u001a\u00020D2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0016J\u0010\u0010T\u001a\u00020D2\u0006\u0010P\u001a\u00020QH\u0016J\b\u0010U\u001a\u00020DH\u0016J\b\u0010V\u001a\u00020DH\u0016J\b\u0010W\u001a\u00020DH\u0016J\b\u0010X\u001a\u00020DH\u0016J\b\u0010Y\u001a\u00020DH\u0016J\b\u0010Z\u001a\u00020DH\u0016J\u0010\u0010[\u001a\u00020D2\u0006\u0010\\\u001a\u00020]H\u0016J\b\u0010^\u001a\u000204H\u0016J\b\u0010_\u001a\u00020DH\u0002J%\u0010`\u001a\u0002Ha\"\b\b\u0000\u0010a*\u00020b2\f\u0010c\u001a\b\u0012\u0004\u0012\u0002Ha0dH\u0002¢\u0006\u0002\u0010eJ\u0010\u0010f\u001a\u00020D2\u0006\u0010g\u001a\u00020hH\u0016J\u0010\u0010i\u001a\u00020D2\u0006\u0010g\u001a\u00020hH\u0016J\b\u0010j\u001a\u00020kH\u0016J\b\u0010l\u001a\u00020\u0019H\u0016J\b\u0010m\u001a\u000200H\u0016J\b\u0010n\u001a\u00020\u001bH\u0016J\b\u0010o\u001a\u00020\u0015H\u0016J\b\u0010p\u001a\u00020\u0017H\u0016J\b\u0010v\u001a\u00020\u0013H\u0016J\b\u0010w\u001a\u00020DH\u0002J\b\u0010x\u001a\u00020\u0011H\u0016J\b\u0010y\u001a\u00020\u001dH\u0016J\b\u0010z\u001a\u00020\u001fH\u0016J\b\u0010{\u001a\u00020!H\u0016J\b\u0010|\u001a\u00020#H\u0016J\b\u0010}\u001a\u00020%H\u0016J\b\u0010~\u001a\u00020'H\u0016J\u001c\u0010\u007f\u001a\u00020D2\u0007\u0010\u0080\u0001\u001a\u00020+2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010\u0082\u0001\u001a\u00020D2\u0007\u0010\u0080\u0001\u001a\u00020+H\u0016J\u0013\u0010\u0083\u0001\u001a\u00020D2\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0016J\t\u0010\u0086\u0001\u001a\u000204H\u0016J\u001d\u0010\u0087\u0001\u001a\u00020D2\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0016J\u001f\u0010\u008c\u0001\u001a\u00020D2\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0016J\u0013\u0010\u008e\u0001\u001a\u00020D2\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0016J\u0013\u0010\u0091\u0001\u001a\u00020D2\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0016J\u0015\u0010\u0092\u0001\u001a\u0002042\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001H\u0016JC\u0010\u0095\u0001\u001a\u00020D2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u00012\u0010\u0010\u0098\u0001\u001a\u000b\u0012\u0004\u0012\u00020Q\u0018\u00010\u0099\u00012\u0011\u0010\u009a\u0001\u001a\f\u0012\u0005\u0012\u00030\u009b\u0001\u0018\u00010\u0099\u00012\u0007\u0010\u009c\u0001\u001a\u000204H\u0016J\u001f\u0010\u009d\u0001\u001a\u00020D2\u0007\u0010\u009e\u0001\u001a\u00020Q2\u000b\u0010P\u001a\u0007\u0012\u0002\b\u00030\u009f\u0001H\u0016J$\u0010\u009d\u0001\u001a\u00020D2\f\u0010\u009e\u0001\u001a\u0007\u0012\u0002\b\u00030\u009f\u00012\u000b\u0010P\u001a\u0007\u0012\u0002\b\u00030\u009f\u0001H\u0016J\u0016\u0010 \u0001\u001a\u00020D2\u000b\u0010P\u001a\u0007\u0012\u0002\b\u00030\u009f\u0001H\u0016J\u001a\u0010¡\u0001\u001a\u00020D2\u0006\u0010P\u001a\u00020Q2\u0007\u0010¢\u0001\u001a\u000204H\u0016J1\u0010£\u0001\u001a\u00020D2\b\u0010¤\u0001\u001a\u00030¥\u00012\u0016\u0010¦\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030\u009b\u00010§\u0001\"\u00030\u009b\u0001H\u0016¢\u0006\u0003\u0010¨\u0001J\u000b\u0010©\u0001\u001a\u0004\u0018\u000102H\u0016J\u0012\u0010ª\u0001\u001a\u00020D2\u0007\u0010«\u0001\u001a\u000204H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00105\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u00108\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R$\u0010?\u001a\u0002042\u0006\u0010>\u001a\u0002048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u000e\u0010q\u001a\u00020rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010s\u001a\u00020r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bt\u0010u¨\u0006¯\u0001"}, d2 = {"Ltv/danmaku/biliplayerimpl/PlayerContainerImpl;", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mContext", "Landroid/content/Context;", "mPlayerParams", "Ltv/danmaku/biliplayerv2/PlayerParamsV2;", "controlContainerConfig", "", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "Ltv/danmaku/biliplayerv2/ControlContainerConfig;", "<init>", "(Landroid/content/Context;Ltv/danmaku/biliplayerv2/PlayerParamsV2;Ljava/util/Map;)V", "mPanelContainer", "Ltv/danmaku/biliplayerv2/panel/IPanelContainer;", "mPlayerServiceManager", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager;", "mActivityStateService", "Ltv/danmaku/biliplayerv2/service/IActivityStateService;", "mPlayerCoreService", "Ltv/danmaku/biliplayerv2/service/IPlayerCoreService;", "mRenderContainerService", "Ltv/danmaku/biliplayerv2/service/IRenderContainerService;", "mInteractLayerService", "Ltv/danmaku/biliplayerv2/service/interact/biz/IInteractLayerService;", "mReporterService", "Ltv/danmaku/biliplayerv2/service/report/IReporterService;", "mHeartbeatService", "Ltv/danmaku/biliplayerv2/service/report/heartbeat/IHeartbeatServiceInner;", "mControlContainerService", "Ltv/danmaku/biliplayerv2/service/IControlContainerService;", "mVideosPlayDirectorService", "Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService;", "mPlayDirectorServiceV3", "Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3;", "mFunctionWidgetService", "Ltv/danmaku/biliplayerv2/service/AbsFunctionWidgetService;", "mToastService", "Ltv/danmaku/biliplayerv2/service/IToastService;", "mPlayerSettingService", "Ltv/danmaku/biliplayerv2/service/setting/IPlayerSettingService;", "mPendingSwitchControlContainerType", "mProjectionCallback", "Ljava/util/HashMap;", "", "Ltv/danmaku/biliplayerv2/ProjectionCallback;", "mCalmTaskExecutor", "Ltv/danmaku/biliplayerimpl/PlayerContainerImpl$CalmTaskExecutor;", "mPlayerNetworkMonitor", "Ltv/danmaku/biliplayerv2/service/network/PlayerNetworkMonitor;", "mPlayerProfiler", "Ltv/danmaku/biliplayerv2/profiler/PlayerProfiler;", "mIsShared", "", "panelContainer", "getPanelContainer", "()Ltv/danmaku/biliplayerv2/panel/IPanelContainer;", "playerParams", "getPlayerParams", "()Ltv/danmaku/biliplayerv2/PlayerParamsV2;", "context", "getContext", "()Landroid/content/Context;", "value", "isSharing", "()Z", "setSharing", "(Z)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "addBuiltInLayer", "layer", "Ltv/danmaku/biliplayerv2/panel/BuiltInLayer;", "service", "Ltv/danmaku/biliplayerv2/service/IWithViewPlayerService;", "removeBuiltInLayer", "onStart", "onResume", "onPause", "onStop", "onDestroyView", "onDestroy", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onBackPressed", "initCorePlayerServices", "getCorePlayerService", "T", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ltv/danmaku/biliplayerv2/service/IPlayerService;", "runCalmTask", "task", "Ljava/lang/Runnable;", "removeCalmTask", "getPlayerServiceManager", "Ltv/danmaku/biliplayerv2/service/IPlayerServiceManager;", "getReporterService", "getPlayerNetworkMonitor", "getHeartbeatService", "getRenderContainerService", "getInteractLayerService", "_playerRenderContextService", "Ltv/danmaku/biliplayerimpl/core/IPlayerRenderContextService;", "playerRenderContextService", "getPlayerRenderContextService$biliplayerimpl_debug", "()Ltv/danmaku/biliplayerimpl/core/IPlayerRenderContextService;", "getPlayerCoreService", "ensurePlayerCoreService", "getActivityStateService", "getControlContainerService", "getVideoPlayDirectorService", "getPlayDirectorServiceV3", "getFunctionWidgetService", "getToastService", "getPlayerSettingService", "setProjectionCallback", "businessType", "callback", "dispatchProjectionCallback", "dispatchVideoInsetChanged", "inset", "Ltv/danmaku/biliplayerv2/panel/VideoInset;", "changeOrientationEnable", "collectShareParams", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "sharingBundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "attachByShared", "bundle", "addOnKeyListener", "listener", "Landroid/view/View$OnKeyListener;", "removeOnKeyListener", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "updateViewPort", "viewPort", "Landroid/graphics/Rect;", "builtInLayers", "", "customerLayers", "", "immediately", "addPlayerLayer", "over", "Ltv/danmaku/biliplayerv2/panel/IPlayerLayer;", "removePlayerLayer", "setBuiltInLayerVisibility", "visibility", "setProfilerHandler", "handler", "Ltv/danmaku/biliplayerv2/profiler/ProfilerHandler;", "scopes", "", "(Ltv/danmaku/biliplayerv2/profiler/ProfilerHandler;[Ljava/lang/String;)V", "getPlayerProfiler", "setHeartBeatEnable", "enable", "CalmTaskExecutor", "CoreServiceDependenceChecker", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerContainerImpl extends PlayerContainer {
    public static final Companion Companion = new Companion(null);
    private static final List<PlayerServiceManager.ServiceDescriptor<?>> sCommServices = CollectionsKt.mutableListOf(new PlayerServiceManager.ServiceDescriptor[]{PlayerServiceManager.ServiceDescriptor.Companion.obtain(AudioFocusService.class), PlayerServiceManager.ServiceDescriptor.Companion.obtain(SharedPlayReportService.class)});
    private IPlayerRenderContextService _playerRenderContextService;
    private final Map<ControlContainerType, ControlContainerConfig> controlContainerConfig;
    private IActivityStateService mActivityStateService;
    private final CalmTaskExecutor mCalmTaskExecutor;
    private final Context mContext;
    private IControlContainerService mControlContainerService;
    private AbsFunctionWidgetService mFunctionWidgetService;
    private IHeartbeatServiceInner mHeartbeatService;
    private IInteractLayerService mInteractLayerService;
    private boolean mIsShared;
    private IPanelContainer mPanelContainer;
    private ControlContainerType mPendingSwitchControlContainerType;
    private IPlayDirectorServiceV3 mPlayDirectorServiceV3;
    private IPlayerCoreService mPlayerCoreService;
    private final PlayerNetworkMonitor mPlayerNetworkMonitor;
    private PlayerParamsV2 mPlayerParams;
    private PlayerProfiler mPlayerProfiler;
    private PlayerServiceManager mPlayerServiceManager;
    private IPlayerSettingService mPlayerSettingService;
    private HashMap<Integer, ProjectionCallback> mProjectionCallback;
    private IRenderContainerService mRenderContainerService;
    private IReporterService mReporterService;
    private IToastService mToastService;
    private IVideosPlayDirectorService mVideosPlayDirectorService;

    /* compiled from: PlayerContainerImpl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DirectorVersion.values().length];
            try {
                iArr[DirectorVersion.V1.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DirectorVersion.V3.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PlayerSharingType.values().length];
            try {
                iArr2[PlayerSharingType.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr2[PlayerSharingType.PLAYER_CORE.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public PlayerContainerImpl(Context mContext, PlayerParamsV2 mPlayerParams, Map<ControlContainerType, ControlContainerConfig> map) {
        Map controlContainerConfig = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mPlayerParams, "mPlayerParams");
        Intrinsics.checkNotNullParameter(controlContainerConfig, "controlContainerConfig");
        this.mContext = mContext;
        this.mPlayerParams = mPlayerParams;
        this.controlContainerConfig = controlContainerConfig;
        this.mProjectionCallback = new HashMap<>();
        this.mCalmTaskExecutor = new CalmTaskExecutor();
        this.mPlayerNetworkMonitor = new PlayerNetworkMonitor();
        this.mPlayerProfiler = new PlayerProfiler();
    }

    @Override // tv.danmaku.biliplayerv2.PlayerContainer
    public IPanelContainer getPanelContainer() {
        return this.mPanelContainer;
    }

    @Override // tv.danmaku.biliplayerv2.PlayerContainer
    public PlayerParamsV2 getPlayerParams() {
        return this.mPlayerParams;
    }

    @Override // tv.danmaku.biliplayerv2.PlayerContainer
    public Context getContext() {
        return this.mContext;
    }

    @Override // tv.danmaku.biliplayerv2.PlayerContainer
    public boolean isSharing() {
        return this.mIsShared && this.mPlayerParams.getSharingBundle() != null;
    }

    @Override // tv.danmaku.biliplayerv2.PlayerContainer
    public void setSharing(boolean value) {
        this.mIsShared = value;
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void onCreate(Bundle savedInstanceState) {
        IVideosPlayDirectorService iVideosPlayDirectorService;
        PlayerDataSource it;
        PlayerLog.i("new player container create");
        initCorePlayerServices();
        Iterable $this$forEach$iv = sCommServices;
        Iterator<T> it2 = $this$forEach$iv.iterator();
        while (true) {
            iVideosPlayDirectorService = null;
            PlayerServiceManager playerServiceManager = null;
            if (!it2.hasNext()) {
                break;
            }
            Object element$iv = it2.next();
            PlayerServiceManager.ServiceDescriptor descriptor = (PlayerServiceManager.ServiceDescriptor) element$iv;
            PlayerServiceManager playerServiceManager2 = this.mPlayerServiceManager;
            if (playerServiceManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerServiceManager");
            } else {
                playerServiceManager = playerServiceManager2;
            }
            playerServiceManager.startService(descriptor);
        }
        this.mIsShared = this.mPlayerParams.getSharingBundle() != null;
        IActivityStateService iActivityStateService = this.mActivityStateService;
        if (iActivityStateService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivityStateService");
            iActivityStateService = null;
        }
        iActivityStateService.setLifecycleState(LifecycleState.ACTIVITY_CREATE);
        if (getPlayerParams().getConfig().getDirectorVersion() == DirectorVersion.V1 && (it = getPlayerParams().getPlayerDataSource()) != null) {
            IVideosPlayDirectorService iVideosPlayDirectorService2 = this.mVideosPlayDirectorService;
            if (iVideosPlayDirectorService2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideosPlayDirectorService");
            } else {
                iVideosPlayDirectorService = iVideosPlayDirectorService2;
            }
            iVideosPlayDirectorService.setPlayerDataSource(it);
        }
        this.mPlayerNetworkMonitor.start();
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        IActivityStateService iActivityStateService = this.mActivityStateService;
        if (iActivityStateService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivityStateService");
            iActivityStateService = null;
        }
        iActivityStateService.setLifecycleState(LifecycleState.FRAGMENT_CREATE_VIEW);
        if (getPanelContainer() == null) {
            Context context = inflater.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            PanelContainer $this$onCreateView_u24lambda_u240 = new PanelContainer(context);
            $this$onCreateView_u24lambda_u240.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            $this$onCreateView_u24lambda_u240.setBackground(new ColorDrawable(-16777216));
            this.mPanelContainer = $this$onCreateView_u24lambda_u240;
            IPanelContainer panelContainer = getPanelContainer();
            if (panelContainer != null) {
                panelContainer.init(this, this.controlContainerConfig);
            }
        }
        IPanelContainer panelContainer2 = getPanelContainer();
        Intrinsics.checkNotNull(panelContainer2);
        return panelContainer2.getView();
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void onViewCreated(View view2, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view2, "view");
        IActivityStateService iActivityStateService = this.mActivityStateService;
        if (iActivityStateService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivityStateService");
            iActivityStateService = null;
        }
        iActivityStateService.setLifecycleState(LifecycleState.FRAGMENT_VIEW_CREATED);
        IPanelContainer panelContainer = getPanelContainer();
        Intrinsics.checkNotNull(panelContainer);
        panelContainer.onViewCreated(view2, savedInstanceState);
        this.mPendingSwitchControlContainerType = getPlayerParams().getConfig().getInitialControlContainerType();
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void addBuiltInLayer(BuiltInLayer layer, IWithViewPlayerService service) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        Intrinsics.checkNotNullParameter(service, "service");
        IPanelContainer panelContainer = getPanelContainer();
        if (panelContainer != null) {
            panelContainer.addBuiltInLayer(layer, service);
        }
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void removeBuiltInLayer(BuiltInLayer layer) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        IPanelContainer panelContainer = getPanelContainer();
        if (panelContainer != null) {
            panelContainer.removeBuiltInLayer(layer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void onStart() {
        IActivityStateService iActivityStateService = null;
        if (this.mPendingSwitchControlContainerType != null) {
            if (this.mPendingSwitchControlContainerType != ControlContainerType.NONE) {
                Map<ControlContainerType, ControlContainerConfig> map = this.controlContainerConfig;
                if (!(map == null || map.isEmpty())) {
                    IControlContainerService iControlContainerService = this.mControlContainerService;
                    if (iControlContainerService == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mControlContainerService");
                        iControlContainerService = null;
                    }
                    ControlContainerType controlContainerType = this.mPendingSwitchControlContainerType;
                    Intrinsics.checkNotNull(controlContainerType);
                    iControlContainerService.switchTo(controlContainerType);
                }
            }
            this.mPendingSwitchControlContainerType = null;
        }
        IActivityStateService iActivityStateService2 = this.mActivityStateService;
        if (iActivityStateService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivityStateService");
        } else {
            iActivityStateService = iActivityStateService2;
        }
        iActivityStateService.setLifecycleState(LifecycleState.ACTIVITY_START);
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void onResume() {
        IActivityStateService iActivityStateService = this.mActivityStateService;
        if (iActivityStateService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivityStateService");
            iActivityStateService = null;
        }
        iActivityStateService.setLifecycleState(LifecycleState.ACTIVITY_RESUME);
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void onPause() {
        IActivityStateService iActivityStateService = this.mActivityStateService;
        if (iActivityStateService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivityStateService");
            iActivityStateService = null;
        }
        iActivityStateService.setLifecycleState(LifecycleState.ACTIVITY_PAUSE);
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void onStop() {
        IActivityStateService iActivityStateService = this.mActivityStateService;
        if (iActivityStateService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivityStateService");
            iActivityStateService = null;
        }
        iActivityStateService.setLifecycleState(LifecycleState.ACTIVITY_STOP);
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void onDestroyView() {
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void onDestroy() {
        this.mCalmTaskExecutor.release();
        IActivityStateService iActivityStateService = this.mActivityStateService;
        if (iActivityStateService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivityStateService");
            iActivityStateService = null;
        }
        iActivityStateService.setLifecycleState(LifecycleState.ACTIVITY_DESTROY);
        PlayerServiceManager playerServiceManager = this.mPlayerServiceManager;
        if (playerServiceManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerServiceManager");
            playerServiceManager = null;
        }
        playerServiceManager.release();
        this.mPlayerNetworkMonitor.stop();
        this.mPlayerProfiler = null;
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        IActivityStateService iActivityStateService = this.mActivityStateService;
        if (iActivityStateService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivityStateService");
            iActivityStateService = null;
        }
        iActivityStateService.setActivityOrientation(newConfig);
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public boolean onBackPressed() {
        AbsFunctionWidgetService absFunctionWidgetService = this.mFunctionWidgetService;
        if (absFunctionWidgetService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFunctionWidgetService");
            absFunctionWidgetService = null;
        }
        if (absFunctionWidgetService.onBackPressed()) {
            return true;
        }
        return false;
    }

    private final void initCorePlayerServices() {
        PlayerServiceManagerImpl impl = new PlayerServiceManagerImpl(this);
        this.mPlayerServiceManager = new PlayerServiceManager(impl);
        getPlayerCoreService();
        getHeartbeatService();
        getReporterService();
        getActivityStateService();
        switch (WhenMappings.$EnumSwitchMapping$0[getPlayerParams().getConfig().getDirectorVersion().ordinal()]) {
            case 1:
                getVideoPlayDirectorService();
                break;
            case 2:
                getPlayDirectorServiceV3();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        getPlayerSettingService();
    }

    private final <T extends IPlayerService> T getCorePlayerService(Class<T> cls) {
        if (!CorePlayerServicesConfig.INSTANCE.isCoreService((Class<?>) cls)) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("class=%s is not core service", Arrays.copyOf(new Object[]{cls.getName()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            throw new IllegalArgumentException(format);
        }
        PlayerServiceManager.Client client = new PlayerServiceManager.Client();
        PlayerServiceManager playerServiceManager = this.mPlayerServiceManager;
        if (playerServiceManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerServiceManager");
            playerServiceManager = null;
        }
        playerServiceManager.bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(cls), client);
        if (BuildConfig.DEBUG) {
            StackTraceElement threadStack = Thread.currentThread().getStackTrace()[4];
            String className = threadStack.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
            HandlerThreads.post(2, new CoreServiceDependenceChecker(className, cls));
        }
        T service = client.getService();
        Intrinsics.checkNotNull(service, "null cannot be cast to non-null type T of tv.danmaku.biliplayerimpl.PlayerContainerImpl.getCorePlayerService");
        return service;
    }

    @Override // tv.danmaku.biliplayerv2.PlayerContainer
    public void runCalmTask(Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.mCalmTaskExecutor.addTask(task);
    }

    @Override // tv.danmaku.biliplayerv2.PlayerContainer
    public void removeCalmTask(Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.mCalmTaskExecutor.removeTask(task);
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public IPlayerServiceManager getPlayerServiceManager() {
        PlayerServiceManager playerServiceManager = this.mPlayerServiceManager;
        if (playerServiceManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerServiceManager");
            playerServiceManager = null;
        }
        return playerServiceManager;
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public IReporterService getReporterService() {
        if (this.mReporterService == null) {
            this.mReporterService = (IReporterService) getCorePlayerService(CorePlayerServicesConfig.INSTANCE.getReport_Service());
        }
        IReporterService iReporterService = this.mReporterService;
        if (iReporterService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReporterService");
            return null;
        }
        return iReporterService;
    }

    @Override // tv.danmaku.biliplayerv2.PlayerContainer
    public PlayerNetworkMonitor getPlayerNetworkMonitor() {
        return this.mPlayerNetworkMonitor;
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public IHeartbeatServiceInner getHeartbeatService() {
        if (this.mHeartbeatService == null) {
            this.mHeartbeatService = (IHeartbeatServiceInner) getCorePlayerService(CorePlayerServicesConfig.INSTANCE.getHeartbeat_Service());
        }
        IHeartbeatServiceInner iHeartbeatServiceInner = this.mHeartbeatService;
        if (iHeartbeatServiceInner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeartbeatService");
            return null;
        }
        return iHeartbeatServiceInner;
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public IRenderContainerService getRenderContainerService() {
        if (this.mRenderContainerService == null) {
            this.mRenderContainerService = (IRenderContainerService) getCorePlayerService(CorePlayerServicesConfig.INSTANCE.getRender_Container_Service());
        }
        IRenderContainerService iRenderContainerService = this.mRenderContainerService;
        if (iRenderContainerService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRenderContainerService");
            return null;
        }
        return iRenderContainerService;
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public IInteractLayerService getInteractLayerService() {
        if (this.mInteractLayerService == null) {
            DanmakuLogger.INSTANCE.logService("interact service init");
            PlayerServiceManager.Client client = new PlayerServiceManager.Client();
            PlayerServiceManager playerServiceManager = this.mPlayerServiceManager;
            if (playerServiceManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerServiceManager");
                playerServiceManager = null;
            }
            playerServiceManager.bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(InteractLayerService.class), client);
            IPlayerService service = client.getService();
            Intrinsics.checkNotNull(service, "null cannot be cast to non-null type tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService");
            this.mInteractLayerService = (IInteractLayerService) service;
        }
        IInteractLayerService iInteractLayerService = this.mInteractLayerService;
        if (iInteractLayerService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractLayerService");
            return null;
        }
        return iInteractLayerService;
    }

    public final IPlayerRenderContextService getPlayerRenderContextService$biliplayerimpl_debug() {
        ensurePlayerCoreService();
        IPlayerRenderContextService iPlayerRenderContextService = this._playerRenderContextService;
        if (iPlayerRenderContextService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_playerRenderContextService");
            return null;
        }
        return iPlayerRenderContextService;
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public IPlayerCoreService getPlayerCoreService() {
        ensurePlayerCoreService();
        IPlayerCoreService iPlayerCoreService = this.mPlayerCoreService;
        if (iPlayerCoreService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
            return null;
        }
        return iPlayerCoreService;
    }

    private final void ensurePlayerCoreService() {
        if (this.mPlayerCoreService == null) {
            PlayerCoreServiceV2 impl = (PlayerCoreServiceV2) getCorePlayerService(CorePlayerServicesConfig.INSTANCE.getPlayer_Core_Service());
            this._playerRenderContextService = impl;
            Function1 decorator = getPlayerParams().getPlayerCoreServiceDecorator();
            this.mPlayerCoreService = decorator == null ? impl : (IPlayerCoreService) decorator.invoke(impl);
        }
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public IActivityStateService getActivityStateService() {
        if (this.mActivityStateService == null) {
            this.mActivityStateService = (IActivityStateService) getCorePlayerService(CorePlayerServicesConfig.INSTANCE.getActivity_State_Service());
        }
        IActivityStateService iActivityStateService = this.mActivityStateService;
        if (iActivityStateService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivityStateService");
            return null;
        }
        return iActivityStateService;
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public IControlContainerService getControlContainerService() {
        if (this.mControlContainerService == null) {
            this.mControlContainerService = (IControlContainerService) getCorePlayerService(CorePlayerServicesConfig.INSTANCE.getController_Service());
        }
        IControlContainerService iControlContainerService = this.mControlContainerService;
        if (iControlContainerService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mControlContainerService");
            return null;
        }
        return iControlContainerService;
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public IVideosPlayDirectorService getVideoPlayDirectorService() {
        if (!(getPlayerParams().getConfig().getDirectorVersion() == DirectorVersion.V1)) {
            throw new IllegalArgumentException(("illegal useVideoDirectorV2:" + getPlayerParams().getConfig().getDirectorVersion()).toString());
        }
        if (this.mVideosPlayDirectorService == null) {
            this.mVideosPlayDirectorService = (IVideosPlayDirectorService) getCorePlayerService(CorePlayerServicesConfig.INSTANCE.getVideos_Play_Director_Service());
        }
        IVideosPlayDirectorService iVideosPlayDirectorService = this.mVideosPlayDirectorService;
        if (iVideosPlayDirectorService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideosPlayDirectorService");
            return null;
        }
        return iVideosPlayDirectorService;
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public IPlayDirectorServiceV3 getPlayDirectorServiceV3() {
        if (!(getPlayerParams().getConfig().getDirectorVersion() == DirectorVersion.V3)) {
            throw new IllegalArgumentException(("illegal useVideoDirectorV3:" + getPlayerParams().getConfig().getDirectorVersion()).toString());
        }
        if (this.mPlayDirectorServiceV3 == null) {
            this.mPlayDirectorServiceV3 = (IPlayDirectorServiceV3) getCorePlayerService(CorePlayerServicesConfig.INSTANCE.getPlay_Director_Service3());
        }
        IPlayDirectorServiceV3 iPlayDirectorServiceV3 = this.mPlayDirectorServiceV3;
        if (iPlayDirectorServiceV3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayDirectorServiceV3");
            return null;
        }
        return iPlayDirectorServiceV3;
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public AbsFunctionWidgetService getFunctionWidgetService() {
        if (this.mFunctionWidgetService == null) {
            this.mFunctionWidgetService = (AbsFunctionWidgetService) getCorePlayerService(CorePlayerServicesConfig.INSTANCE.getFunction_Widget_Service());
        }
        AbsFunctionWidgetService absFunctionWidgetService = this.mFunctionWidgetService;
        if (absFunctionWidgetService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFunctionWidgetService");
            return null;
        }
        return absFunctionWidgetService;
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public IToastService getToastService() {
        if (this.mToastService == null) {
            this.mToastService = (IToastService) getCorePlayerService(CorePlayerServicesConfig.INSTANCE.getToast_Service());
        }
        IToastService iToastService = this.mToastService;
        if (iToastService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToastService");
            return null;
        }
        return iToastService;
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public IPlayerSettingService getPlayerSettingService() {
        if (this.mPlayerSettingService == null) {
            this.mPlayerSettingService = (IPlayerSettingService) getCorePlayerService(CorePlayerServicesConfig.INSTANCE.getPlayer_Setting_Service());
        }
        IPlayerSettingService iPlayerSettingService = this.mPlayerSettingService;
        if (iPlayerSettingService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerSettingService");
            return null;
        }
        return iPlayerSettingService;
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void setProjectionCallback(int businessType, ProjectionCallback callback) {
        if (callback != null) {
            this.mProjectionCallback.put(Integer.valueOf(businessType), callback);
        } else {
            this.mProjectionCallback.remove(Integer.valueOf(businessType));
        }
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void dispatchProjectionCallback(int businessType) {
        ProjectionCallback callback = this.mProjectionCallback.get(Integer.valueOf(businessType));
        if (callback != null) {
            callback.onProjectionViewClick(businessType);
        }
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void dispatchVideoInsetChanged(VideoInset inset) {
        Intrinsics.checkNotNullParameter(inset, "inset");
        IPanelContainer panelContainer = getPanelContainer();
        if (panelContainer != null) {
            panelContainer.onVideoInsetChanged(inset);
        }
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public boolean changeOrientationEnable() {
        if (this.mFunctionWidgetService == null) {
            return false;
        }
        AbsFunctionWidgetService absFunctionWidgetService = this.mFunctionWidgetService;
        IRenderContainerService iRenderContainerService = null;
        if (absFunctionWidgetService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFunctionWidgetService");
            absFunctionWidgetService = null;
        }
        if (absFunctionWidgetService.changeOrientationEnable()) {
            IRenderContainerService iRenderContainerService2 = this.mRenderContainerService;
            if (iRenderContainerService2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRenderContainerService");
            } else {
                iRenderContainerService = iRenderContainerService2;
            }
            return !iRenderContainerService.isInWholeSceneMode();
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void collectShareParams(PlayerSharingType sharingType, PlayerSharingBundle sharingBundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        Intrinsics.checkNotNullParameter(sharingBundle, "sharingBundle");
        PlayerServiceManager playerServiceManager = null;
        switch (WhenMappings.$EnumSwitchMapping$1[sharingType.ordinal()]) {
            case 1:
                PlayerServiceManager playerServiceManager2 = this.mPlayerServiceManager;
                if (playerServiceManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerServiceManager");
                } else {
                    playerServiceManager = playerServiceManager2;
                }
                playerServiceManager.collectShareParams(sharingType, sharingBundle);
                break;
            case 2:
                IPlayerCoreService playerCoreService = getPlayerCoreService();
                IPlayerService iPlayerService = playerCoreService instanceof IPlayerService ? (IPlayerService) playerCoreService : null;
                if (iPlayerService != null) {
                    iPlayerService.onCollectSharedParams(PlayerSharingType.PLAYER_CORE, sharingBundle);
                    break;
                }
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        this.mIsShared = true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void attachByShared(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        if (!this.mIsShared) {
            return;
        }
        PlayerServiceManager playerServiceManager = null;
        switch (WhenMappings.$EnumSwitchMapping$1[sharingType.ordinal()]) {
            case 1:
                this.mPlayerParams.setSharingBundle(bundle);
                PlayerServiceManager playerServiceManager2 = this.mPlayerServiceManager;
                if (playerServiceManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerServiceManager");
                } else {
                    playerServiceManager = playerServiceManager2;
                }
                playerServiceManager.attachByShared(sharingType, bundle);
                switch (WhenMappings.$EnumSwitchMapping$0[getPlayerParams().getConfig().getDirectorVersion().ordinal()]) {
                    case 1:
                        getVideoPlayDirectorService().playFromShared();
                        break;
                    case 2:
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            case 2:
                IPlayerCoreService playerCoreService = getPlayerCoreService();
                IPlayerService iPlayerService = playerCoreService instanceof IPlayerService ? (IPlayerService) playerCoreService : null;
                if (iPlayerService != null) {
                    iPlayerService.onAttachByShared(sharingType, null);
                    break;
                }
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        this.mIsShared = false;
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void addOnKeyListener(View.OnKeyListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        IPanelContainer panelContainer = getPanelContainer();
        if (panelContainer != null) {
            panelContainer.addOnKeyListener(listener);
        }
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void removeOnKeyListener(View.OnKeyListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        IPanelContainer panelContainer = getPanelContainer();
        if (panelContainer != null) {
            panelContainer.removeOnKeyListener(listener);
        }
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public boolean dispatchKeyEvent(KeyEvent event) {
        IPanelContainer panelContainer = getPanelContainer();
        if (panelContainer != null) {
            return panelContainer.dispatchKeyEvent(event);
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void updateViewPort(Rect viewPort, List<? extends BuiltInLayer> list, List<String> list2, boolean immediately) {
        List builtInLayers = EnhancedUnmodifiabilityKt.unmodifiable(list);
        List customerLayers = EnhancedUnmodifiabilityKt.unmodifiable(list2);
        IPanelContainer panelContainer = getPanelContainer();
        if (panelContainer != null) {
            panelContainer.updateViewPort(viewPort, builtInLayers, customerLayers, immediately);
        }
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void addPlayerLayer(BuiltInLayer over, IPlayerLayer<?> iPlayerLayer) {
        Intrinsics.checkNotNullParameter(over, "over");
        Intrinsics.checkNotNullParameter(iPlayerLayer, "layer");
        IPanelContainer panelContainer = getPanelContainer();
        if (panelContainer != null) {
            panelContainer.addLayer(iPlayerLayer, over);
        }
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void addPlayerLayer(IPlayerLayer<?> iPlayerLayer, IPlayerLayer<?> iPlayerLayer2) {
        Intrinsics.checkNotNullParameter(iPlayerLayer, "over");
        Intrinsics.checkNotNullParameter(iPlayerLayer2, "layer");
        IPanelContainer panelContainer = getPanelContainer();
        if (panelContainer != null) {
            panelContainer.addLayer(iPlayerLayer2, iPlayerLayer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void removePlayerLayer(IPlayerLayer<?> iPlayerLayer) {
        Intrinsics.checkNotNullParameter(iPlayerLayer, "layer");
        IPanelContainer panelContainer = getPanelContainer();
        if (panelContainer != null) {
            panelContainer.removeLayer(iPlayerLayer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void setBuiltInLayerVisibility(BuiltInLayer layer, boolean visibility) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        IPanelContainer panelContainer = getPanelContainer();
        if (panelContainer != null) {
            panelContainer.setBuiltInLayerVisibility(layer, visibility);
        }
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void setProfilerHandler(ProfilerHandler handler, String... scopes) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        PlayerProfiler playerProfiler = this.mPlayerProfiler;
        if (playerProfiler != null) {
            playerProfiler.registerProfilerHandler(handler, (String[]) Arrays.copyOf(scopes, scopes.length));
        }
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public PlayerProfiler getPlayerProfiler() {
        return this.mPlayerProfiler;
    }

    @Override // tv.danmaku.biliplayerv2.IPlayerContainer
    public void setHeartBeatEnable(boolean enable) {
        IHeartbeatServiceInner iHeartbeatServiceInner = this.mHeartbeatService;
        if (iHeartbeatServiceInner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeartbeatService");
            iHeartbeatServiceInner = null;
        }
        iHeartbeatServiceInner.setEnable(enable);
    }

    /* compiled from: PlayerContainerImpl.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\u0006\u0010\u0012\u001a\u00020\rR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/biliplayerimpl/PlayerContainerImpl$CalmTaskExecutor;", "", "<init>", "()V", "mCalmTasks", "", "Ljava/lang/Runnable;", "mScheduled", "", "mTaskExecuteHandler", "Landroid/os/MessageQueue$IdleHandler;", "mTaskTimeoutHandler", "addTask", "", "task", "removeTask", "scheduleExecute", "executeTasks", "release", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class CalmTaskExecutor {
        private boolean mScheduled;
        private final List<Runnable> mCalmTasks = new LinkedList();
        private final MessageQueue.IdleHandler mTaskExecuteHandler = new MessageQueue.IdleHandler() { // from class: tv.danmaku.biliplayerimpl.PlayerContainerImpl$CalmTaskExecutor$$ExternalSyntheticLambda0
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean mTaskExecuteHandler$lambda$0;
                mTaskExecuteHandler$lambda$0 = PlayerContainerImpl.CalmTaskExecutor.mTaskExecuteHandler$lambda$0(PlayerContainerImpl.CalmTaskExecutor.this);
                return mTaskExecuteHandler$lambda$0;
            }
        };
        private final Runnable mTaskTimeoutHandler = new Runnable() { // from class: tv.danmaku.biliplayerimpl.PlayerContainerImpl$CalmTaskExecutor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PlayerContainerImpl.CalmTaskExecutor.this.executeTasks();
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean mTaskExecuteHandler$lambda$0(CalmTaskExecutor this$0) {
            this$0.executeTasks();
            return false;
        }

        public final void addTask(Runnable task) {
            Intrinsics.checkNotNullParameter(task, "task");
            this.mCalmTasks.add(task);
            scheduleExecute();
        }

        public final void removeTask(Runnable task) {
            Intrinsics.checkNotNullParameter(task, "task");
            this.mCalmTasks.remove(task);
        }

        private final void scheduleExecute() {
            if (this.mScheduled) {
                return;
            }
            Looper.myQueue().addIdleHandler(this.mTaskExecuteHandler);
            HandlerThreads.postDelayed(0, this.mTaskTimeoutHandler, 300L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void executeTasks() {
            this.mScheduled = false;
            HandlerThreads.remove(0, this.mTaskTimeoutHandler);
            Looper.myQueue().removeIdleHandler(this.mTaskExecuteHandler);
            PlayerLog.i("execute calm tasks:size = " + this.mCalmTasks.size());
            while (!this.mCalmTasks.isEmpty()) {
                Runnable t = this.mCalmTasks.remove(0);
                t.run();
            }
        }

        public final void release() {
            executeTasks();
            HandlerThreads.remove(0, this.mTaskTimeoutHandler);
            Looper.myQueue().removeIdleHandler(this.mTaskExecuteHandler);
            this.mScheduled = false;
        }
    }

    /* compiled from: PlayerContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/biliplayerimpl/PlayerContainerImpl$CoreServiceDependenceChecker;", "Ljava/lang/Runnable;", "callerName", "", "target", "Ljava/lang/Class;", "<init>", "(Ljava/lang/String;Ljava/lang/Class;)V", "run", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class CoreServiceDependenceChecker implements Runnable {
        private final String callerName;
        private final Class<?> target;

        public CoreServiceDependenceChecker(String callerName, Class<?> cls) {
            Intrinsics.checkNotNullParameter(callerName, "callerName");
            Intrinsics.checkNotNullParameter(cls, "target");
            this.callerName = callerName;
            this.target = cls;
        }

        @Override // java.lang.Runnable
        public void run() {
            Class caller = Class.forName(this.callerName);
            Class foundTarget = null;
            for (Class s : CorePlayerServicesConfig.INSTANCE.getSCorePlayerServices()) {
                if (Intrinsics.areEqual(s, caller) && foundTarget == null) {
                    throw new IllegalAccessException(caller + " could not depend on " + this.target);
                } else if (Intrinsics.areEqual(s, this.target)) {
                    foundTarget = s;
                }
            }
        }
    }

    /* compiled from: PlayerContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/biliplayerimpl/PlayerContainerImpl$Companion;", "", "<init>", "()V", "sCommServices", "", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceDescriptor;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}