package tv.danmaku.biliplayerv2.service.interact.biz.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.ReportDanmaku;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DanmakuFeedbackInfo.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"transform", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/DanmakuFeedbackInfo;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/ReportDanmaku$Request;", "avid", "", "(Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/ReportDanmaku$Request;Ljava/lang/Long;)Ltv/danmaku/biliplayerv2/service/interact/biz/model/DanmakuFeedbackInfo;", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuFeedbackInfoKt {
    public static final DanmakuFeedbackInfo transform(ReportDanmaku.Request $this$transform, Long avid) {
        Intrinsics.checkNotNullParameter($this$transform, "<this>");
        String danmakuId = $this$transform.getDanmakuId();
        String str = danmakuId == null ? "" : danmakuId;
        String content = $this$transform.getContent();
        String str2 = content == null ? "" : content;
        String nickname = $this$transform.getNickname();
        String str3 = nickname == null ? "" : nickname;
        Long mid = $this$transform.getMid();
        long longValue = mid != null ? mid.longValue() : 0L;
        Integer type = $this$transform.getType();
        int intValue = type != null ? type.intValue() : 0;
        Long duration = $this$transform.getDuration();
        long longValue2 = duration != null ? duration.longValue() : 0L;
        Long appearanceTime = $this$transform.getAppearanceTime();
        long longValue3 = appearanceTime != null ? appearanceTime.longValue() : 0L;
        String userHash = $this$transform.getUserHash();
        String str4 = userHash == null ? "" : userHash;
        String oid = $this$transform.getOid();
        return new DanmakuFeedbackInfo(str, str2, str3, longValue, intValue, longValue2, longValue3, str4, oid == null ? "" : oid, avid != null ? avid.longValue() : 0L);
    }
}