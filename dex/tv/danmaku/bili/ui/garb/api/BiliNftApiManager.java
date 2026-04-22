package tv.danmaku.bili.ui.garb.api;

import com.alibaba.fastjson.JSONObject;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Callback;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.api.collection.BiliCollectionAllData;
import tv.danmaku.bili.ui.garb.api.collection.BiliCollectionData;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: BiliNftApiManager.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ$\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fJ$\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fJ3\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00180\u000f¢\u0006\u0002\u0010\u0019J6\u0010\u001a\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cJ$\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000fJ=\u0010 \u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020#0\u000f¢\u0006\u0002\u0010$J-\u0010%\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020&0\u000f¢\u0006\u0002\u0010'J\u001c\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020+0\u000fJW\u0010,\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\r2\b\u0010.\u001a\u0004\u0018\u00010\u000b2\b\u0010/\u001a\u0004\u0018\u00010\u00072\b\u00100\u001a\u0004\u0018\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002010\u000f¢\u0006\u0002\u00102¨\u00063"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/BiliNftApiManager;", "", "<init>", "()V", "loadDLCItem", "", "actId", "", "mid", "lotteryId", "lotteryNum", "", "bizInfo", "", "cb", "Lcom/bilibili/okretro/BiliApiDataCallback;", "Ltv/danmaku/bili/ui/garb/api/BillDLCRespInfo;", "loadCardDetail", "actionId", "cardTypeId", "Ltv/danmaku/bili/ui/garb/api/BiliCardDetail;", "loadDLCCardDetail", "loadDrawCard", "roundIndex", "Ltv/danmaku/bili/ui/garb/api/BiliDrawCard;", "(IJLjava/lang/Integer;Lcom/bilibili/okretro/BiliApiDataCallback;)V", "bgEdit", "cardId", "Lretrofit2/Callback;", "Lcom/alibaba/fastjson/JSONObject;", "transfer", "Ltv/danmaku/bili/ui/garb/api/BiliNftTransfer;", "detail", "vmid", "useScene", "Ltv/danmaku/bili/ui/garb/api/DigitalCardDetail;", "(Ljava/lang/Long;Ljava/lang/Long;JILcom/bilibili/okretro/BiliApiDataCallback;)V", "getCollectionData", "Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionData;", "(Ljava/lang/Long;Ljava/lang/Long;Lcom/bilibili/okretro/BiliApiDataCallback;)V", "setCollectionVisible", ReportEvent.EVENT_TYPE_SHOW, "", "Ltv/danmaku/bili/ui/garb/api/CollectionSetting;", "getCollectionPageData", "source", "ps", "lastId", "lastType", "Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionAllData;", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Lcom/bilibili/okretro/BiliApiDataCallback;)V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliNftApiManager {
    public static final int $stable = 0;
    public static final BiliNftApiManager INSTANCE = new BiliNftApiManager();

    private BiliNftApiManager() {
    }

    public final void loadDLCItem(long actId, long mid, long lotteryId, int lotteryNum, String bizInfo, BiliApiDataCallback<BillDLCRespInfo> biliApiDataCallback) {
        Intrinsics.checkNotNullParameter(biliApiDataCallback, "cb");
        ((BiliNftApiService) ServiceGenerator.createService(BiliNftApiService.class)).drawDLCItem(actId, mid, lotteryId, lotteryNum, bizInfo).enqueue((Callback) biliApiDataCallback);
    }

    public final void loadCardDetail(int actionId, long cardTypeId, BiliApiDataCallback<BiliCardDetail> biliApiDataCallback) {
        Intrinsics.checkNotNullParameter(biliApiDataCallback, "cb");
        ((BiliNftApiService) ServiceGenerator.createService(BiliNftApiService.class)).loadCardDetail(actionId, cardTypeId).enqueue((Callback) biliApiDataCallback);
    }

    public final void loadDLCCardDetail(int actionId, long cardTypeId, BiliApiDataCallback<BiliCardDetail> biliApiDataCallback) {
        Intrinsics.checkNotNullParameter(biliApiDataCallback, "cb");
        ((BiliNftApiService) ServiceGenerator.createService(BiliNftApiService.class)).loadDLCCardDetail(actionId, cardTypeId).enqueue((Callback) biliApiDataCallback);
    }

    public final void loadDrawCard(int actionId, long mid, Integer roundIndex, BiliApiDataCallback<BiliDrawCard> biliApiDataCallback) {
        Intrinsics.checkNotNullParameter(biliApiDataCallback, "cb");
        ((BiliNftApiService) ServiceGenerator.createService(BiliNftApiService.class)).loadDrawCard(actionId, mid, roundIndex).enqueue((Callback) biliApiDataCallback);
    }

    public final void bgEdit(long mid, long cardTypeId, long cardId, int actId, Callback<JSONObject> callback) {
        Intrinsics.checkNotNullParameter(callback, "cb");
        ((BiliNftApiService) ServiceGenerator.createService(BiliNftApiService.class)).bgEdit(mid, String.valueOf(cardTypeId), String.valueOf(cardId), String.valueOf(actId)).enqueue(callback);
    }

    public final void transfer(int actId, long cardId, BiliApiDataCallback<BiliNftTransfer> biliApiDataCallback) {
        Intrinsics.checkNotNullParameter(biliApiDataCallback, "cb");
        ((BiliNftApiService) ServiceGenerator.createService(BiliNftApiService.class)).isAllowTransfer(actId, cardId).enqueue((Callback) biliApiDataCallback);
    }

    public final void detail(Long mid, Long vmid, long cardId, int useScene, BiliApiDataCallback<DigitalCardDetail> biliApiDataCallback) {
        Intrinsics.checkNotNullParameter(biliApiDataCallback, "cb");
        ((BiliNftApiService) ServiceGenerator.createService(BiliNftApiService.class)).detailInfo(mid, vmid, cardId, useScene).enqueue((Callback) biliApiDataCallback);
    }

    public final void getCollectionData(Long mid, Long vmid, BiliApiDataCallback<BiliCollectionData> biliApiDataCallback) {
        Intrinsics.checkNotNullParameter(biliApiDataCallback, "cb");
        ((BiliNftApiService) ServiceGenerator.createService(BiliNftApiService.class)).getCollectionData(mid, vmid).enqueue((Callback) biliApiDataCallback);
    }

    public final void setCollectionVisible(boolean show, BiliApiDataCallback<CollectionSetting> biliApiDataCallback) {
        Intrinsics.checkNotNullParameter(biliApiDataCallback, "cb");
        ((BiliNftApiService) ServiceGenerator.createService(BiliNftApiService.class)).setCollectionVisible(show ? 1 : 0).enqueue((Callback) biliApiDataCallback);
    }

    public final void getCollectionPageData(Long mid, Long vmid, String source, Integer ps, Long lastId, Integer lastType, BiliApiDataCallback<BiliCollectionAllData> biliApiDataCallback) {
        Intrinsics.checkNotNullParameter(biliApiDataCallback, "cb");
        ((BiliNftApiService) ServiceGenerator.createService(BiliNftApiService.class)).getCollectionPageData(mid, vmid, source, ps, lastId, lastType).enqueue((Callback) biliApiDataCallback);
    }
}