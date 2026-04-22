package tv.danmaku.biliplayerv2.service.resolve.danmaku;

import com.bapis.bilibili.community.service.dm.v1.DMMoss;
import com.bapis.bilibili.community.service.dm.v1.DmViewReply;
import com.bapis.bilibili.community.service.dm.v1.DmViewReq;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.moss.api.CallOptions;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.interact.log.DanmakuLogger;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DanmakuRpcWrapper.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\bH\u0002J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001cJ\n\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0007J\b\u0010\u001e\u001a\u00020\u001fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Ltv/danmaku/biliplayerv2/service/resolve/danmaku/DanmakuRpcWrapper;", "", "<init>", "()V", "TYPE_VIDEO", "", "TYPE_LIVE", "DEFAULT_OID", "", "EXT_LINKED_ID", "", "EXT_CREATIVE_ID", "EXT_REQUEST_ID", "EXT_TRACK_ID", "EXT_SOURCE_ID", "EXT_FRAGMENTS", "EXT_AID", "EXT_CID", "EXT_FRAGMENTS_DURATION", "EXT_FRAGMENTS_TYPE", "EXT_PLAYER_DURATION", "EXT_VIDEO_TYPE", "EXT_FROM_SCENE", "getRpcTimeout", "requestDmView", "Lcom/bapis/bilibili/community/service/dm/v1/DmViewReply;", "params", "Ltv/danmaku/biliplayerv2/service/Video$DanmakuResolveParams;", "(Ltv/danmaku/biliplayerv2/service/Video$DanmakuResolveParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestDefaultDanmakuView", "getDefaultDanmakuViewReq", "Lcom/bapis/bilibili/community/service/dm/v1/DmViewReq;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuRpcWrapper {
    private static final long DEFAULT_OID = -2233;
    public static final String EXT_AID = "aid";
    public static final String EXT_CID = "cid";
    public static final String EXT_CREATIVE_ID = "linked_creative_id";
    public static final String EXT_FRAGMENTS = "fragments";
    public static final String EXT_FRAGMENTS_DURATION = "duration";
    public static final String EXT_FRAGMENTS_TYPE = "type";
    public static final String EXT_FROM_SCENE = "from_scene";
    public static final String EXT_LINKED_ID = "linked_id";
    public static final String EXT_PLAYER_DURATION = "duration";
    public static final String EXT_REQUEST_ID = "linked_request_id";
    public static final String EXT_SOURCE_ID = "linked_source_id";
    public static final String EXT_TRACK_ID = "linked_track_id";
    public static final String EXT_VIDEO_TYPE = "video_type";
    public static final DanmakuRpcWrapper INSTANCE = new DanmakuRpcWrapper();
    public static final int TYPE_LIVE = 5;
    public static final int TYPE_VIDEO = 1;

    private DanmakuRpcWrapper() {
    }

    private final long getRpcTimeout() {
        String str = (String) ConfigManager.Companion.config().get("danmaku_grpc_timeout", "30");
        if (str != null) {
            return Long.parseLong(str);
        }
        return 30L;
    }

    public final Object requestDmView(Video.DanmakuResolveParams params, Continuation<? super DmViewReply> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new DanmakuRpcWrapper$requestDmView$2(params, null), continuation);
    }

    @JvmStatic
    public static final DmViewReply requestDefaultDanmakuView() {
        DanmakuLogger.INSTANCE.logReq("request default dmView");
        try {
            DmViewReq request = getDefaultDanmakuViewReq();
            CallOptions callOptions = new CallOptions().withTimeout(Long.valueOf(INSTANCE.getRpcTimeout()), TimeUnit.SECONDS);
            return new DMMoss("IGNORED IN 5.46 AS PLACEHOLDER", 443, callOptions).executeDmView(request);
        } catch (Throwable th) {
            return null;
        }
    }

    @JvmStatic
    public static final DmViewReq getDefaultDanmakuViewReq() {
        DmViewReq request = DmViewReq.newBuilder().setType(1).setOid((long) DEFAULT_OID).setIsHardBoot(1).build();
        Intrinsics.checkNotNull(request);
        return request;
    }
}