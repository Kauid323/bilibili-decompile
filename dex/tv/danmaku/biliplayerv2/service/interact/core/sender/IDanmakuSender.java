package tv.danmaku.biliplayerv2.service.interact.core.sender;

import android.content.Context;
import java.util.Map;
import kotlin.Metadata;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.IPlayerContainer;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IDanmakuSender.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J1\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\rJG\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u00122\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\u0014J3\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00132\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/sender/IDanmakuSender;", "", "send", "", "playerContainer", "Ltv/danmaku/biliplayerv2/IPlayerContainer;", "context", "Landroid/content/Context;", "params", "Ltv/danmaku/biliplayerv2/service/interact/core/sender/DanmakuSendParams;", "sendV2", LoginSceneProcessor.SCENE_KEY, "", "(Ltv/danmaku/biliplayerv2/IPlayerContainer;Landroid/content/Context;Ltv/danmaku/biliplayerv2/service/interact/core/sender/DanmakuSendParams;Ljava/lang/Long;)Z", "sendCommandDanmaku", "type", "", "content", "", "", "(Ltv/danmaku/biliplayerv2/IPlayerContainer;Landroid/content/Context;ILjava/util/Map;Ljava/lang/Long;)Z", "sendUpDanmaku", "(Ltv/danmaku/biliplayerv2/IPlayerContainer;Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;)Z", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IDanmakuSender {
    boolean send(IPlayerContainer iPlayerContainer, Context context, DanmakuSendParams danmakuSendParams);

    boolean sendCommandDanmaku(IPlayerContainer iPlayerContainer, Context context, int i, Map<String, ? extends Object> map, Long l);

    boolean sendUpDanmaku(IPlayerContainer iPlayerContainer, Context context, String str, Long l);

    boolean sendV2(IPlayerContainer iPlayerContainer, Context context, DanmakuSendParams danmakuSendParams, Long l);

    /* compiled from: IDanmakuSender.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.interact.core.sender.IDanmakuSender$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ boolean sendCommandDanmaku$default(IDanmakuSender iDanmakuSender, IPlayerContainer iPlayerContainer, Context context, int i, Map map, Long l, int i2, Object obj) {
            Long l2;
            if (obj == null) {
                if ((i2 & 16) == 0) {
                    l2 = l;
                } else {
                    l2 = null;
                }
                return iDanmakuSender.sendCommandDanmaku(iPlayerContainer, context, i, map, l2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendCommandDanmaku");
        }

        public static /* synthetic */ boolean sendUpDanmaku$default(IDanmakuSender iDanmakuSender, IPlayerContainer iPlayerContainer, Context context, String str, Long l, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    l = null;
                }
                return iDanmakuSender.sendUpDanmaku(iPlayerContainer, context, str, l);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendUpDanmaku");
        }
    }
}