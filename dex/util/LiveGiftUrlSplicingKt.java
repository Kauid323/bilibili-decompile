package util;

import android.net.Uri;
import com.alibaba.fastjson.JSON;
import com.bilibili.bililive.videoliveplayer.net.beans.gift.LiveGiftPanelMicUserInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LiveGiftUrlSplicing.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001¨\u0006\b"}, d2 = {"attachLiveRoomParamsFromGiftPanelJumpUrl", "", "data", "Lutil/GiftPanelUrlParamsData;", "appendUri", "url", "key", "value", "giftCommon_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LiveGiftUrlSplicingKt {
    public static final String attachLiveRoomParamsFromGiftPanelJumpUrl(GiftPanelUrlParamsData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String url = data.getUrl();
        List $this$attachLiveRoomParamsFromGiftPanelJumpUrl_u24lambda_u240 = CollectionsKt.createListBuilder();
        $this$attachLiveRoomParamsFromGiftPanelJumpUrl_u24lambda_u240.add(TuplesKt.to("clickGiftBannerForGiftId", String.valueOf(data.getGiftId())));
        Long originGiftId = data.getOriginGiftId();
        if ((originGiftId != null ? originGiftId.longValue() : 0L) > 0) {
            $this$attachLiveRoomParamsFromGiftPanelJumpUrl_u24lambda_u240.add(TuplesKt.to("originalGiftId", String.valueOf(data.getOriginGiftId())));
        }
        if (data.isMultiVoice()) {
            List $this$attachLiveRoomParamsFromGiftPanelJumpUrl_u24lambda_u240_u240 = CollectionsKt.createListBuilder();
            for (LiveGiftPanelMicUserInfo user : data.getSelectedUsers()) {
                $this$attachLiveRoomParamsFromGiftPanelJumpUrl_u24lambda_u240_u240.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("uid", String.valueOf(user.getUid())), TuplesKt.to("room_id", String.valueOf(user.getRoomId()))}));
            }
            List users = CollectionsKt.build($this$attachLiveRoomParamsFromGiftPanelJumpUrl_u24lambda_u240_u240);
            $this$attachLiveRoomParamsFromGiftPanelJumpUrl_u24lambda_u240.add(TuplesKt.to("current_selected_seatUsers", JSON.toJSONString(users)));
            $this$attachLiveRoomParamsFromGiftPanelJumpUrl_u24lambda_u240.add(TuplesKt.to("roomType", "1"));
        }
        Map $this$forEach$iv = data.getExtraParams();
        if ($this$forEach$iv != null) {
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                String k = element$iv.getKey();
                String v = element$iv.getValue();
                $this$attachLiveRoomParamsFromGiftPanelJumpUrl_u24lambda_u240.add(TuplesKt.to(k, v));
            }
        }
        Iterable<Pair> params = CollectionsKt.build($this$attachLiveRoomParamsFromGiftPanelJumpUrl_u24lambda_u240);
        for (Pair it : params) {
            String $this$toUri$iv = url;
            String uri = Uri.parse($this$toUri$iv).buildUpon().appendQueryParameter((String) it.getFirst(), it.getSecond().toString()).build().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
            url = uri;
        }
        return url;
    }

    public static final String appendUri(String url, String key, String value) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        String uri = Uri.parse(url).buildUpon().appendQueryParameter(key, value).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        return uri;
    }
}