package tv.danmaku.biliplayerv2.service.interact.biz.chronos;

import bolts.CancellationToken;
import bolts.CancellationTokenSource;
import bolts.Continuation;
import bolts.Task;
import com.bapis.bilibili.app.viewunite.v1.ChronosParam;
import com.bapis.bilibili.app.viewunite.v1.FragmentParam;
import com.bapis.bilibili.app.viewunite.v1.UnionType;
import com.bapis.bilibili.app.viewunite.v1.ViewMoss;
import com.bapis.bilibili.app.viewunite.v1.ViewProgressReply;
import com.bapis.bilibili.app.viewunite.v1.ViewProgressReq;
import com.bapis.bilibili.playershared.PlayCtrl;
import com.bilibili.base.BiliContext;
import com.bilibili.common.chronoscommon.ChronosPackageManager;
import com.bilibili.common.chronoscommon.EnhancedChronosPackageRunner;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.service.AccessToken;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosApiResolver;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.loader.LocalPackageLoader;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.loader.RemotePackageLoader;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.Chronos;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.VideoGuide;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.VideoPoint;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.VideoViewPoint;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ViewProgressDetail;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ViewProgressDetailParser;
import tv.danmaku.biliplayerv2.service.interact.core.api.InteractApiService;
import tv.danmaku.biliplayerv2.service.interact.core.command.CommandsPanel;
import tv.danmaku.biliplayerv2.service.interact.log.DanmakuLogger;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.VideoBizType;

/* compiled from: ChronosApiResolver.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u0001:\u0002-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JX\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00152\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u001f2\b\b\u0002\u0010!\u001a\u00020\"J\u001e\u0010#\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0015JR\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00152\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u001f2\b\b\u0002\u0010!\u001a\u00020\"H\u0002J\u001a\u0010'\u001a\u00020\u00132\b\u0010(\u001a\u0004\u0018\u00010&2\u0006\u0010)\u001a\u00020\u0015H\u0002J\u000e\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u0007J\u0006\u0010,\u001a\u00020\u0013R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006/"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosApiResolver;", "", "<init>", "()V", "mResolveToken", "Lbolts/CancellationTokenSource;", "mResolveCallback", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosApiResolver$ResolveCallback;", "mRemotePackageLoader", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/loader/RemotePackageLoader;", "mLocalPackageLoader", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/loader/LocalPackageLoader;", "mCommandApiService", "Ltv/danmaku/biliplayerv2/service/interact/core/api/InteractApiService;", "getMCommandApiService", "()Ltv/danmaku/biliplayerv2/service/interact/core/api/InteractApiService;", "mCommandApiService$delegate", "Lkotlin/Lazy;", "resolve", "", "aid", "", "cid", "bizType", "Ltv/danmaku/videoplayer/coreV2/VideoBizType;", "danmakuParams", "Ltv/danmaku/biliplayerv2/service/Video$DanmakuResolveParams;", "fragmentParam", "Lcom/bapis/bilibili/app/viewunite/v1/FragmentParam;", "videoPointOffset", "extra", "", "", "simplify", "", "resolveCommandPanels", "upMid", "requestViewProgress", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ViewProgressDetail;", "offsetVideoPoint", "viewProgressDetail", "offset", "setResolveCallback", "resolveCallback", "release", "Companion", "ResolveCallback", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChronosApiResolver {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "ChronosApiResolver";
    private ResolveCallback mResolveCallback;
    private CancellationTokenSource mResolveToken;
    private RemotePackageLoader mRemotePackageLoader = new RemotePackageLoader();
    private final LocalPackageLoader mLocalPackageLoader = new LocalPackageLoader();
    private final Lazy mCommandApiService$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosApiResolver$$ExternalSyntheticLambda4
        public final Object invoke() {
            InteractApiService mCommandApiService_delegate$lambda$0;
            mCommandApiService_delegate$lambda$0 = ChronosApiResolver.mCommandApiService_delegate$lambda$0();
            return mCommandApiService_delegate$lambda$0;
        }
    });

    /* compiled from: ChronosApiResolver.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\"\u0010\f\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosApiResolver$ResolveCallback;", "", "onViewProgressChange", "", "viewProgressDetail", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ViewProgressDetail;", "onPackageResolveSuccess", "result", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/PackageResult;", "aid", "", "cid", "onCommandPanelsResolveSuccess", "Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsPanel;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface ResolveCallback {
        void onCommandPanelsResolveSuccess(CommandsPanel commandsPanel, long j, long j2);

        void onPackageResolveSuccess(PackageResult packageResult, long j, long j2);

        void onViewProgressChange(ViewProgressDetail viewProgressDetail);
    }

    /* compiled from: ChronosApiResolver.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoBizType.values().length];
            try {
                iArr[VideoBizType.UGC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[VideoBizType.PGC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[VideoBizType.PUGV.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final InteractApiService getMCommandApiService() {
        return (InteractApiService) this.mCommandApiService$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InteractApiService mCommandApiService_delegate$lambda$0() {
        return (InteractApiService) ServiceGenerator.createService(InteractApiService.class);
    }

    /* compiled from: ChronosApiResolver.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosApiResolver$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void resolve$default(ChronosApiResolver chronosApiResolver, long j, long j2, VideoBizType videoBizType, Video.DanmakuResolveParams danmakuResolveParams, FragmentParam fragmentParam, long j3, Map map, boolean z, int i, Object obj) {
        boolean z2;
        if ((i & 128) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        chronosApiResolver.resolve(j, j2, videoBizType, danmakuResolveParams, fragmentParam, j3, map, z2);
    }

    public final void resolve(final long aid, final long cid, final VideoBizType bizType, final Video.DanmakuResolveParams danmakuParams, final FragmentParam fragmentParam, final long videoPointOffset, Map<String, String> map, final boolean simplify) {
        final CancellationToken token;
        final Map extra = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        Intrinsics.checkNotNullParameter(extra, "extra");
        CancellationTokenSource cancellationTokenSource = this.mResolveToken;
        if (cancellationTokenSource != null) {
            cancellationTokenSource.cancel();
        }
        this.mResolveToken = new CancellationTokenSource();
        CancellationTokenSource cancellationTokenSource2 = this.mResolveToken;
        if (cancellationTokenSource2 != null && (token = cancellationTokenSource2.getToken()) != null) {
            Task.callInBackground(new Callable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosApiResolver$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    ViewProgressDetail resolve$lambda$0;
                    resolve$lambda$0 = ChronosApiResolver.resolve$lambda$0(ChronosApiResolver.this, aid, cid, bizType, fragmentParam, videoPointOffset, extra, simplify);
                    return resolve$lambda$0;
                }
            }, token).continueWithTask(new Continuation() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosApiResolver$$ExternalSyntheticLambda1
                public final Object then(Task task) {
                    Task resolve$lambda$1;
                    resolve$lambda$1 = ChronosApiResolver.resolve$lambda$1(ChronosApiResolver.this, task);
                    return resolve$lambda$1;
                }
            }, Task.UI_THREAD_EXECUTOR, token).continueWithTask(new Continuation() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosApiResolver$$ExternalSyntheticLambda2
                public final Object then(Task task) {
                    Task resolve$lambda$2;
                    resolve$lambda$2 = ChronosApiResolver.resolve$lambda$2(ChronosApiResolver.this, token, task);
                    return resolve$lambda$2;
                }
            }, Task.BACKGROUND_EXECUTOR, token).continueWithTask(new Continuation() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosApiResolver$$ExternalSyntheticLambda3
                public final Object then(Task task) {
                    Task resolve$lambda$3;
                    resolve$lambda$3 = ChronosApiResolver.resolve$lambda$3(Video.DanmakuResolveParams.this, this, token, task);
                    return resolve$lambda$3;
                }
            }).continueWith(new Continuation<PackageResult, Unit>() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosApiResolver$resolve$5
                public /* bridge */ /* synthetic */ Object then(Task p0) {
                    m2248then((Task<PackageResult>) p0);
                    return Unit.INSTANCE;
                }

                /* renamed from: then  reason: collision with other method in class */
                public void m2248then(Task<PackageResult> task) {
                    ChronosApiResolver.ResolveCallback resolveCallback;
                    Intrinsics.checkNotNullParameter(task, "task");
                    if (task.isFaulted() || task.isCancelled()) {
                        return;
                    }
                    DanmakuLogger danmakuLogger = DanmakuLogger.INSTANCE;
                    long j = aid;
                    danmakuLogger.logChronos("resolve chronos package success, aid=" + j + ", cid=" + cid);
                    resolveCallback = this.mResolveCallback;
                    if (resolveCallback != null) {
                        Object result = task.getResult();
                        Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
                        resolveCallback.onPackageResolveSuccess((PackageResult) result, aid, cid);
                    }
                }
            }, Task.UI_THREAD_EXECUTOR, token);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewProgressDetail resolve$lambda$0(ChronosApiResolver this$0, long $aid, long $cid, VideoBizType $bizType, FragmentParam $fragmentParam, long $videoPointOffset, Map $extra, boolean $simplify) {
        try {
            return this$0.requestViewProgress($aid, $cid, $bizType, $fragmentParam, $videoPointOffset, $extra, $simplify);
        } catch (Exception e) {
            DanmakuLogger.INSTANCE.error("request viewProgress failed, cause " + e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task resolve$lambda$1(ChronosApiResolver this$0, Task it) {
        ResolveCallback resolveCallback = this$0.mResolveCallback;
        if (resolveCallback != null) {
            resolveCallback.onViewProgressChange((ViewProgressDetail) it.getResult());
        }
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task resolve$lambda$2(ChronosApiResolver this$0, CancellationToken $token, Task it) {
        final ViewProgressDetail res = (ViewProgressDetail) it.getResult();
        if (res != null) {
            new Function0() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosApiResolver$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit resolve$lambda$2$0$0;
                    resolve$lambda$2$0$0 = ChronosApiResolver.resolve$lambda$2$0$0(ViewProgressDetail.this);
                    return resolve$lambda$2$0$0;
                }
            };
        }
        return this$0.mRemotePackageLoader.getLoadTask((ViewProgressDetail) it.getResult(), $token);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resolve$lambda$2$0$0(ViewProgressDetail $res) {
        String file;
        DanmakuLogger danmakuLogger = DanmakuLogger.INSTANCE;
        Chronos chronos = $res.getChronos();
        String str = null;
        String md5 = chronos != null ? chronos.getMd5() : null;
        Chronos chronos2 = $res.getChronos();
        if (chronos2 != null && (file = chronos2.getFile()) != null) {
            str = StringsKt.replace$default(file, "http://", "https://", false, 4, (Object) null);
        }
        danmakuLogger.logReq("request viewProgress success, chronos md5=" + md5 + ", download site=" + str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if ((r0 != null ? r0.getChronosPackage() : null) == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Task resolve$lambda$3(Video.DanmakuResolveParams $danmakuParams, ChronosApiResolver this$0, CancellationToken $token, Task task) {
        if ($danmakuParams != null && Intrinsics.areEqual($danmakuParams.getFrom(), "downloaded")) {
            if (!task.isFaulted()) {
                PackageResult packageResult = (PackageResult) task.getResult();
                if ((packageResult != null ? packageResult.getViewProgressDetail() : null) == null) {
                    PackageResult packageResult2 = (PackageResult) task.getResult();
                }
            }
            this$0.mLocalPackageLoader.setDanmakuParams($danmakuParams);
            return this$0.mLocalPackageLoader.getLoadTask(((PackageResult) task.getResult()).getViewProgressDetail(), $token);
        }
        return task;
    }

    public final void resolveCommandPanels(final long aid, final long cid, long upMid) {
        String accessToken;
        AccessToken accessToken2 = BiliAccounts.get(BiliContext.application()).getAccessToken();
        if (accessToken2 != null && (accessToken = accessToken2.getAccessKey()) != null) {
            long userMid = BiliAccounts.get(BiliContext.application()).mid();
            if (userMid > 0 && upMid > 0 && userMid == upMid) {
                if (cid > 0) {
                    BiliCall biliCall = getMCommandApiService().getDanmakuCommandPanelList(accessToken, String.valueOf(aid), String.valueOf(cid));
                    DanmakuLogger.INSTANCE.logReq("request command panel list, aid=" + aid);
                    biliCall.enqueue(new BiliApiDataCallback<CommandsPanel>() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosApiResolver$resolveCommandPanels$1
                        public void onDataSuccess(CommandsPanel data) {
                            ChronosApiResolver.ResolveCallback resolveCallback;
                            DanmakuLogger danmakuLogger = DanmakuLogger.INSTANCE;
                            long j = aid;
                            danmakuLogger.logReq("request command panel list success, aid=" + j + ", cid=" + cid);
                            resolveCallback = this.mResolveCallback;
                            if (resolveCallback != null) {
                                resolveCallback.onCommandPanelsResolveSuccess(data, aid, cid);
                            }
                        }

                        public void onError(Throwable t) {
                            DanmakuLogger danmakuLogger = DanmakuLogger.INSTANCE;
                            long j = aid;
                            danmakuLogger.logReq("request command panel list failed, aid=" + j + ", cid=" + cid + ", cause " + (t != null ? t.getMessage() : null));
                        }

                        public boolean isCancel() {
                            ChronosApiResolver.ResolveCallback resolveCallback;
                            resolveCallback = this.mResolveCallback;
                            return resolveCallback == null;
                        }
                    });
                    return;
                }
            }
            DanmakuLogger.INSTANCE.error("request cancel: usermid -> " + userMid + ", upmid -> " + upMid + ", cid -> " + cid);
        }
    }

    static /* synthetic */ ViewProgressDetail requestViewProgress$default(ChronosApiResolver chronosApiResolver, long j, long j2, VideoBizType videoBizType, FragmentParam fragmentParam, long j3, Map map, boolean z, int i, Object obj) {
        boolean z2;
        if ((i & 64) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        return chronosApiResolver.requestViewProgress(j, j2, videoBizType, fragmentParam, j3, map, z2);
    }

    private final ViewProgressDetail requestViewProgress(long aid, long cid, VideoBizType bizType, FragmentParam fragmentParam, long videoPointOffset, Map<String, String> map, boolean simplify) {
        PlayCtrl playCtrl;
        UnionType unionType;
        Map extra = EnhancedUnmodifiabilityKt.unmodifiable(map);
        if (simplify) {
            playCtrl = PlayCtrl.PLAY_CTRL_SIMPLE;
        } else {
            playCtrl = PlayCtrl.PLAY_CTRL_DEFAULT;
        }
        ViewProgressReq.Builder chronosParam = ViewProgressReq.newBuilder().setAid(aid).setCid(cid).setUpMid(0L).setPlayCtrl(playCtrl).setChronosParam(ChronosParam.newBuilder().setServiceKey(ChronosPackageManager.Service.DFM.getKey()).setEngineVersion(EnhancedChronosPackageRunner.Companion.getVersion()).setMessageProtocol("0.0.1").build());
        switch (WhenMappings.$EnumSwitchMapping$0[bizType.ordinal()]) {
            case 1:
                unionType = UnionType.UGC;
                break;
            case 2:
                unionType = UnionType.OGV;
                break;
            case 3:
                unionType = UnionType.PUGV;
                break;
            default:
                unionType = UnionType.UGC;
                break;
        }
        ViewProgressReq.Builder it = chronosParam.setType(unionType).putAllExtraContent(extra);
        if (fragmentParam != null) {
            it.setFragmentParam(fragmentParam);
        }
        ViewProgressReq request = it.build();
        DanmakuLogger.INSTANCE.logReq("request unite viewProgress, aid=" + aid);
        ViewMoss viewMoss = new ViewMoss("IGNORED IN 5.46 AS PLACEHOLDER", 443, (CallOptions) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNull(request);
        ViewProgressReply it2 = viewMoss.executeViewProgress(request);
        ViewProgressDetail detail = it2 != null ? ViewProgressDetailParser.INSTANCE.generateUniteViewProgressDetail(it2) : null;
        offsetVideoPoint(detail, videoPointOffset);
        return detail;
    }

    private final void offsetVideoPoint(ViewProgressDetail viewProgressDetail, long offset) {
        VideoGuide videoGuide;
        VideoViewPoint videoPoint;
        Iterable videoPointList;
        if (viewProgressDetail == null || offset <= 0 || (videoGuide = viewProgressDetail.getVideoGuide()) == null || (videoPoint = videoGuide.getVideoPoint()) == null || (videoPointList = videoPoint.getVideoPointList()) == null) {
            return;
        }
        Iterable $this$forEach$iv = videoPointList;
        for (Object element$iv : $this$forEach$iv) {
            VideoPoint it = (VideoPoint) element$iv;
            it.setFrom(it.getFrom() + offset);
            it.setTo(it.getTo() + offset);
        }
    }

    public final void setResolveCallback(ResolveCallback resolveCallback) {
        Intrinsics.checkNotNullParameter(resolveCallback, "resolveCallback");
        this.mResolveCallback = resolveCallback;
    }

    public final void release() {
        DanmakuLogger.INSTANCE.logChronos("api resolver release");
        CancellationTokenSource cancellationTokenSource = this.mResolveToken;
        if (cancellationTokenSource != null) {
            cancellationTokenSource.cancel();
        }
        this.mResolveToken = null;
        this.mResolveCallback = null;
    }
}