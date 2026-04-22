package tv.danmaku.video.bilicardplayer;

import com.bilibili.cron.ChronosPackage;
import java.util.HashMap;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.AddCustomDanmaku;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CardDanmakuManager.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J@\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eH&J@\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Ltv/danmaku/video/bilicardplayer/CardDanmakuCallback;", "", "onResolveChronosPkgSuccess", "", "result", "Lcom/bilibili/cron/ChronosPackage;", "onLiveDanmakuComing", "dmId", "", "extra", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$LiveExtra;", "emoExtra", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "onLiveDanmakuComingV2", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface CardDanmakuCallback {
    void onLiveDanmakuComing(String str, AddCustomDanmaku.LiveExtra liveExtra, HashMap<String, byte[]> hashMap);

    void onLiveDanmakuComingV2(String str, Object obj, HashMap<String, byte[]> hashMap);

    void onResolveChronosPkgSuccess(ChronosPackage chronosPackage);
}