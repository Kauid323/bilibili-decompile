package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local;

import android.net.Uri;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.bilibili.okretro.GeneralResponse;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.FetchBusinessData;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetOnlineInfo;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetWorkInfo;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.InvokeCommandDetailPanel;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.OpenUrlScheme;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.ReportSubtitle;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateCurrentWork;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateFullscreenState;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdatePreference;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateShipChain;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateVideoDetailState;
import tv.danmaku.biliplayerv2.service.interact.biz.model.DanmakuFeedbackInfo;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LocalServiceHandler.kt */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0014H\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0014H\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0014H\u0016J\b\u0010#\u001a\u00020\tH\u0016J\u0012\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010&H\u0017J\u001c\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010,\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020*H\u0016J\u0010\u00101\u001a\u00020\t2\u0006\u00100\u001a\u00020*H\u0016J\u001a\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016JE\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u00020*2\n\b\u0002\u00109\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0002\u0010=J\n\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u001a\u0010@\u001a\u00020\t2\b\u0010A\u001a\u0004\u0018\u00010*2\u0006\u0010B\u001a\u00020\u0014H\u0016J{\u0010C\u001a\u00020\t2\b\u0010D\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00142J\u0010G\u001aF\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(\u0015\u0012!\u0012\u001f\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020L\u0018\u00010K¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\t0Hj\u0002`MH\u0016¢\u0006\u0002\u0010NJ\u0012\u0010O\u001a\u00020\t2\b\u0010P\u001a\u0004\u0018\u00010*H\u0016J#\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010\u00142\b\u0010T\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010UJ\u001c\u0010V\u001a\u00020\u00142\b\u0010W\u001a\u0004\u0018\u00010X2\b\u0010Y\u001a\u0004\u0018\u00010XH\u0016J(\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020*2\u0006\u0010\\\u001a\u00020*2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020*H\u0016J\n\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u001c\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010d\u001a\u00020*2\b\u0010e\u001a\u0004\u0018\u00010\u0001H\u0016Jð\u0001\u0010f\u001a\u00020\t2\u0006\u0010g\u001a\u00020h2\u0006\u00100\u001a\u00020*2\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0K2Á\u0001\u0010j\u001a¼\u0001\u0012\u0013\u0012\u00110\u0014¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0014¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(l\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(m\u0012\u0013\u0012\u00110*¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b([\u0012\u0013\u0012\u00110*¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(n\u0012\u0013\u0012\u00110*¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(o\u0012\u0015\u0012\u0013\u0018\u00010*¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(p\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020*\u0018\u00010q¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(r\u0012\u0004\u0012\u00020\t0kH\u0016Jè\u0001\u0010s\u001a\u00020\t2\u0006\u00100\u001a\u00020*2\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0K2Á\u0001\u0010j\u001a¼\u0001\u0012\u0013\u0012\u00110\u0014¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0014¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(l\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(m\u0012\u0013\u0012\u00110*¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b([\u0012\u0013\u0012\u00110*¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(n\u0012\u0013\u0012\u00110*¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(o\u0012\u0015\u0012\u0013\u0018\u00010*¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(p\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020*\u0018\u00010q¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(r\u0012\u0004\u0012\u00020\t0kH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/RpcInvokeObserver;", "", "onRpcGetWorkInfo", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetWorkInfo$Response;", "onRpcGetCurrentWork", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateCurrentWork$Response;", "getRelationshipChain", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateShipChain$Response;", "onUpdateStaffFollowState", "", "followStateList", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateVideoDetailState$FollowState;", "onUpdateReserveState", "reserveState", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateVideoDetailState$ReserveState;", "onUpdateClockInState", "clockInState", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateVideoDetailState$CheckInState;", "onUpdateCurrentWork", "", "result", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateCurrentWork$Request;", "onUpdateLikeState", "like", "onUpdateDislikeState", "dislike", "onUpdateCoinState", "coin", "onUpdateFavoState", "favo", "onUpdateFollowState", "follow", "onUpdateSeasonFollowState", "state", "onTriggerTripleLike", "onUpdateRelationshipChain", "req", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateShipChain$Request;", "updatePreference", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdatePreference$Response;", "key", "", "value", "onInvokeDanmakuInputPanel", "params", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/InvokeCommandDetailPanel$CommandDetailParams;", "showPlayerWebView", "url", "showPlayerNaPage", "openURLSchema", "scheme", "Landroid/net/Uri;", "extra", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/OpenUrlScheme$BizParams;", "openURLScheme", "actUrl", "biz", "containerType", "", "screenState", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/OpenUrlScheme$BizParams;Ljava/lang/Integer;)Z", "getPlayerComponentsHeight", "", "notifyDanmakuExperiment", "experimentName", "isHit", "updateDanmakuInputPanel", "inputText", "showInputPanel", "getDmProperty", "onComplete", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosHandlerComplete;", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;)V", "notifyDanmakuSent", "cid", "updateFullscreenState", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateFullscreenState$Response;", "fullscreen", "lock", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateFullscreenState$Response;", "showSubtitleReportDialog", "subtitleMain", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/ReportSubtitle$SubtitleMeta;", "subtitleVice", "onDanmakuReply", "dmId", "content", "progress", "", "midHash", "getOnlineInfo", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetOnlineInfo$Response;", "fetchBusinessData", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/FetchBusinessData$Response;", "businessData", "data", "onShowDanmakuFeedback", "info", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/DanmakuFeedbackInfo;", "config", "onDanmakuReportCallback", "Lkotlin/Function8;", "blockUser", "shieldUser", "reason", "shieldUserId", "oid", "Lcom/bilibili/okretro/GeneralResponse;", "rResponse", "showDanmakuFeedbackWebview", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface RpcInvokeObserver {
    FetchBusinessData.Response fetchBusinessData(String str, Object obj);

    GetOnlineInfo.Response getOnlineInfo();

    int[] getPlayerComponentsHeight();

    UpdateShipChain.Response getRelationshipChain();

    void notifyDanmakuExperiment(String str, boolean z);

    void notifyDanmakuSent(String str);

    void onDanmakuReply(String str, String str2, long j, String str3);

    void onInvokeDanmakuInputPanel(InvokeCommandDetailPanel.CommandDetailParams commandDetailParams);

    UpdateCurrentWork.Response onRpcGetCurrentWork();

    GetWorkInfo.Response onRpcGetWorkInfo();

    void onShowDanmakuFeedback(DanmakuFeedbackInfo danmakuFeedbackInfo, String str, Map<String, String> map, Function8<? super Boolean, ? super Boolean, ? super Boolean, ? super String, ? super String, ? super String, ? super String, ? super GeneralResponse<String>, Unit> function8);

    void onTriggerTripleLike();

    void onUpdateClockInState(UpdateVideoDetailState.CheckInState checkInState);

    void onUpdateCoinState(boolean z);

    boolean onUpdateCurrentWork(UpdateCurrentWork.Request request);

    void onUpdateDislikeState(boolean z);

    void onUpdateFavoState(boolean z);

    void onUpdateFollowState(boolean z);

    void onUpdateLikeState(boolean z);

    @Deprecated(message = "使用明确的行为定义，而不是使用这个聚合体")
    void onUpdateRelationshipChain(UpdateShipChain.Request request);

    void onUpdateReserveState(UpdateVideoDetailState.ReserveState reserveState);

    void onUpdateSeasonFollowState(boolean z);

    void onUpdateStaffFollowState(List<UpdateVideoDetailState.FollowState> list);

    boolean openURLSchema(Uri uri, OpenUrlScheme.BizParams bizParams);

    boolean openURLScheme(String str, String str2, Integer num, OpenUrlScheme.BizParams bizParams, Integer num2);

    void showDanmakuFeedbackWebview(String str, Map<String, String> map, Function8<? super Boolean, ? super Boolean, ? super Boolean, ? super String, ? super String, ? super String, ? super String, ? super GeneralResponse<String>, Unit> function8);

    void showPlayerNaPage(String str);

    void showPlayerWebView(String str);

    boolean showSubtitleReportDialog(ReportSubtitle.SubtitleMeta subtitleMeta, ReportSubtitle.SubtitleMeta subtitleMeta2);

    void updateDanmakuInputPanel(String str, Boolean bool, Boolean bool2, Function2<Object, ? super Map<String, byte[]>, Unit> function2);

    UpdateFullscreenState.Response updateFullscreenState(Boolean bool, Boolean bool2);

    UpdatePreference.Response updatePreference(String str, String str2);

    /* compiled from: LocalServiceHandler.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static void $default$onUpdateStaffFollowState(RpcInvokeObserver _this, List list) {
            List followStateList = EnhancedUnmodifiabilityKt.unmodifiable(list);
            Intrinsics.checkNotNullParameter(followStateList, "followStateList");
        }

        public static void $default$onUpdateLikeState(RpcInvokeObserver _this, boolean like) {
        }

        public static void $default$onUpdateDislikeState(RpcInvokeObserver _this, boolean dislike) {
        }

        public static void $default$onUpdateCoinState(RpcInvokeObserver _this, boolean coin) {
        }

        public static void $default$onUpdateFavoState(RpcInvokeObserver _this, boolean favo) {
        }

        public static void $default$onUpdateFollowState(RpcInvokeObserver _this, boolean follow) {
        }

        public static void $default$onUpdateSeasonFollowState(RpcInvokeObserver _this, boolean state) {
        }

        public static void $default$onTriggerTripleLike(RpcInvokeObserver _this) {
        }

        @Deprecated(message = "使用明确的行为定义，而不是使用这个聚合体")
        public static void $default$onUpdateRelationshipChain(RpcInvokeObserver _this, UpdateShipChain.Request req) {
        }

        public static UpdatePreference.Response $default$updatePreference(RpcInvokeObserver _this, String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            return null;
        }

        public static void $default$onInvokeDanmakuInputPanel(RpcInvokeObserver _this, InvokeCommandDetailPanel.CommandDetailParams params) {
        }

        public static boolean $default$openURLSchema(RpcInvokeObserver _this, Uri scheme, OpenUrlScheme.BizParams extra) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            return false;
        }

        public static /* synthetic */ boolean openURLScheme$default(RpcInvokeObserver rpcInvokeObserver, String str, String str2, Integer num, OpenUrlScheme.BizParams bizParams, Integer num2, int i, Object obj) {
            if (obj == null) {
                return rpcInvokeObserver.openURLScheme(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : bizParams, (i & 16) != 0 ? null : num2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openURLScheme");
        }

        public static boolean $default$openURLScheme(RpcInvokeObserver _this, String actUrl, String biz, Integer containerType, OpenUrlScheme.BizParams extra, Integer screenState) {
            Intrinsics.checkNotNullParameter(actUrl, "actUrl");
            return false;
        }

        public static int[] $default$getPlayerComponentsHeight(RpcInvokeObserver _this) {
            return null;
        }

        public static void $default$notifyDanmakuExperiment(RpcInvokeObserver _this, String experimentName, boolean isHit) {
        }

        public static /* synthetic */ void updateDanmakuInputPanel$default(RpcInvokeObserver rpcInvokeObserver, String str, Boolean bool, Boolean bool2, Function2 function2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateDanmakuInputPanel");
            }
            if ((i & 2) != 0) {
                bool = null;
            }
            if ((i & 4) != 0) {
                bool2 = null;
            }
            rpcInvokeObserver.updateDanmakuInputPanel(str, bool, bool2, function2);
        }

        public static void $default$notifyDanmakuSent(RpcInvokeObserver _this, String cid) {
        }

        public static UpdateFullscreenState.Response $default$updateFullscreenState(RpcInvokeObserver _this, Boolean fullscreen, Boolean lock) {
            return null;
        }

        public static boolean $default$showSubtitleReportDialog(RpcInvokeObserver _this, ReportSubtitle.SubtitleMeta subtitleMain, ReportSubtitle.SubtitleMeta subtitleVice) {
            return false;
        }

        public static void $default$onDanmakuReply(RpcInvokeObserver _this, String dmId, String content, long progress, String midHash) {
            Intrinsics.checkNotNullParameter(dmId, "dmId");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(midHash, "midHash");
        }

        public static GetOnlineInfo.Response $default$getOnlineInfo(RpcInvokeObserver _this) {
            return null;
        }

        public static FetchBusinessData.Response $default$fetchBusinessData(RpcInvokeObserver _this, String businessData, Object data) {
            Intrinsics.checkNotNullParameter(businessData, "businessData");
            return null;
        }

        public static void $default$onShowDanmakuFeedback(RpcInvokeObserver _this, DanmakuFeedbackInfo info, String url, Map map, Function8 onDanmakuReportCallback) {
            Map config = EnhancedUnmodifiabilityKt.unmodifiable(map);
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(onDanmakuReportCallback, "onDanmakuReportCallback");
        }

        public static void $default$showDanmakuFeedbackWebview(RpcInvokeObserver _this, String url, Map map, Function8 onDanmakuReportCallback) {
            Map config = EnhancedUnmodifiabilityKt.unmodifiable(map);
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(onDanmakuReportCallback, "onDanmakuReportCallback");
        }
    }
}