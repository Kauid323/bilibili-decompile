package tv.danmaku.biliplayerv2.service.interact.core.sender;

import android.content.Context;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.BuildConfig;
import tv.danmaku.biliplayerv2.IPlayerContainer;
import tv.danmaku.biliplayerv2.utils.DanmakuSendHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DefaultDanmakuSender.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J1\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u000fJE\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u0017J1\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/sender/DefaultDanmakuSender;", "Ltv/danmaku/biliplayerv2/service/interact/core/sender/IDanmakuSender;", "<init>", "()V", "send", "", "playerContainer", "Ltv/danmaku/biliplayerv2/IPlayerContainer;", "context", "Landroid/content/Context;", "params", "Ltv/danmaku/biliplayerv2/service/interact/core/sender/DanmakuSendParams;", "sendV2", LoginSceneProcessor.SCENE_KEY, "", "(Ltv/danmaku/biliplayerv2/IPlayerContainer;Landroid/content/Context;Ltv/danmaku/biliplayerv2/service/interact/core/sender/DanmakuSendParams;Ljava/lang/Long;)Z", "sendCommandDanmaku", "type", "", "content", "", "", "", "(Ltv/danmaku/biliplayerv2/IPlayerContainer;Landroid/content/Context;ILjava/util/Map;Ljava/lang/Long;)Z", "sendUpDanmaku", "(Ltv/danmaku/biliplayerv2/IPlayerContainer;Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;)Z", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DefaultDanmakuSender implements IDanmakuSender {
    @Override // tv.danmaku.biliplayerv2.service.interact.core.sender.IDanmakuSender
    public boolean send(IPlayerContainer playerContainer, Context context, DanmakuSendParams params) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        Intrinsics.checkNotNullParameter(params, "params");
        return DanmakuSendHelper.INSTANCE.sendDanmaku(playerContainer, context, params.getDanmaku(), params.getDanmakuType(), params.getDanmakuSize(), params.getDanmakuColor(), params.getNewType(), params.getParentDanmakuId());
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.sender.IDanmakuSender
    public boolean sendV2(IPlayerContainer playerContainer, Context context, DanmakuSendParams params, Long scene) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        Intrinsics.checkNotNullParameter(params, "params");
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.sender.IDanmakuSender
    public boolean sendCommandDanmaku(IPlayerContainer playerContainer, Context context, int type, Map<String, ? extends Object> map, Long scene) {
        Map content = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        Intrinsics.checkNotNullParameter(content, "content");
        if (BuildConfig.DEBUG) {
            throw new UnsupportedOperationException("DefaultDanmakuSender do not support command-danmaku");
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.sender.IDanmakuSender
    public boolean sendUpDanmaku(IPlayerContainer playerContainer, Context context, String content, Long scene) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        Intrinsics.checkNotNullParameter(content, "content");
        if (BuildConfig.DEBUG) {
            throw new UnsupportedOperationException("DefaultDanmakuSender do not support command-danmaku");
        }
        return false;
    }
}