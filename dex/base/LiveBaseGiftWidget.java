package base;

import ability.ILiveGiftGlobalService;
import ability.LiveGiftGlobalServiceImpl;
import com.bilibili.bililive.biz.uicommon.beans.BiliLiveGiftConfig;
import com.bilibili.bililive.infra.arch.jetpack.liveData.SafeMutableLiveData;
import com.bilibili.bililive.infra.log.LiveLogger;
import com.bilibili.bililive.lego.BaseWidget;
import com.bilibili.bililive.lego.livedata.LegoDataCenter;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.roominfo.BiliLiveRoomInfo;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.roominfo.BiliLiveRoomStudioInfo;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.userinfo.BiliLiveRoomUserInfo;
import com.bilibili.bililive.videoliveplayer.net.beans.gift.BiliLivePackage;
import com.bilibili.bililive.videoliveplayer.net.beans.gift.BiliLiveRoomGift;
import com.bilibili.bililive.videoliveplayer.net.beans.gift.LiveGiftPanelMicUserInfo;
import com.bilibili.bililive.videoliveplayer.net.beans.gift.LiveRoomBaseGift;
import com.bilibili.bililive.videoliveplayer.ui.roomv3.panel.LiveRoomDispatchUri;
import com.bilibili.upper.BR;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import proxy.GiftParentBizContextImpl;
import proxy.H5PageType;
import proxy.IGiftParentBizContext;

/* compiled from: LiveBaseGiftWidget.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u0011\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0018H\u0096\u0001J\t\u0010\u001f\u001a\u00020\u0016H\u0096\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0001J\t\u0010\"\u001a\u00020\u0018H\u0096\u0001J\u0010\u0010#\u001a\u0004\u0018\u00010\bH\u0096\u0001¢\u0006\u0002\u0010\nJ\t\u0010$\u001a\u00020\u0018H\u0096\u0001J\u0010\u0010%\u001a\u0004\u0018\u00010\bH\u0096\u0001¢\u0006\u0002\u0010\nJ\t\u0010&\u001a\u00020\u0018H\u0096\u0001J\u0010\u0010'\u001a\u0004\u0018\u00010\bH\u0096\u0001¢\u0006\u0002\u0010\nJ\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0096\u0001J\u0010\u0010+\u001a\u0004\u0018\u00010\bH\u0096\u0001¢\u0006\u0002\u0010\nJ\u0010\u0010,\u001a\u0004\u0018\u00010\bH\u0096\u0001¢\u0006\u0002\u0010\nJ\u0010\u0010-\u001a\u0004\u0018\u00010\u001aH\u0096\u0001¢\u0006\u0002\u0010.J\u000b\u0010/\u001a\u0004\u0018\u000100H\u0096\u0001J%\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001802j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018`3H\u0096\u0001J\u000b\u00104\u001a\u0004\u0018\u000105H\u0096\u0001J\u0019\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u001a07j\b\u0012\u0004\u0012\u00020\u001a`8H\u0096\u0001J\t\u00109\u001a\u00020\u0018H\u0096\u0001J\t\u0010:\u001a\u00020\u0013H\u0096\u0001J\t\u0010;\u001a\u00020\u0013H\u0096\u0001J\t\u0010<\u001a\u00020\u0013H\u0096\u0001J\t\u0010=\u001a\u00020\u0013H\u0096\u0001J\t\u0010>\u001a\u00020\u0013H\u0096\u0001J\t\u0010?\u001a\u00020\u0013H\u0096\u0001J\t\u0010@\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010A\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0096\u0001J\u0011\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010CH\u0096\u0001J\u0019\u0010D\u001a\u00020\u00162\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u0018H\u0096\u0001J\u0018\u0010G\u001a\u00020\u00162\b\u0010H\u001a\u0004\u0018\u00010\bH\u0096\u0001¢\u0006\u0002\u0010IJ\u001f\u0010J\u001a\u00020\u00162\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00160L2\u0006\u0010M\u001a\u00020\bH\u0096\u0001J\u0017\u0010N\u001a\u00020\u00162\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00160LH\u0096\u0001J\t\u0010O\u001a\u00020\u0016H\u0096\u0001J\u0017\u0010P\u001a\u00020\u00162\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00160LH\u0096\u0001J\u0011\u0010Q\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0018H\u0096\u0001J9\u0010R\u001a\u00020\u00162\u0006\u0010S\u001a\u00020\u00182&\u0010T\u001a\"\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u000102j\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u0001`3H\u0096\u0001J9\u0010U\u001a\u00020\u00162\u0006\u0010S\u001a\u00020\u00182&\u0010T\u001a\"\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u000102j\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u0001`3H\u0096\u0001J9\u0010V\u001a\u00020\u00162\u0006\u0010S\u001a\u00020\u00182&\u0010T\u001a\"\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u000102j\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u0001`3H\u0096\u0001J\u0011\u0010W\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0018H\u0096\u0001J\u0013\u0010X\u001a\u00020\u00162\b\u0010Y\u001a\u0004\u0018\u00010\u0018H\u0096\u0001J\u0013\u0010X\u001a\u00020\u00162\b\b\u0001\u0010Z\u001a\u00020\u001aH\u0096\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR*\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014¨\u0006["}, d2 = {"Lbase/LiveBaseGiftWidget;", "Lcom/bilibili/bililive/lego/BaseWidget;", "Lability/ILiveGiftGlobalService;", "Lproxy/IGiftParentBizContext;", "Lcom/bilibili/bililive/infra/log/LiveLogger;", "<init>", "()V", "currentSelectGiftId", "", "getCurrentSelectGiftId", "()Ljava/lang/Long;", "value", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/LiveRoomBaseGift;", "currentSelectGift", "getCurrentSelectGift", "()Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/LiveRoomBaseGift;", "setCurrentSelectGift", "(Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/LiveRoomBaseGift;)V", "isStudio", "", "()Z", "dispatchUrl", "", "webUrl", "", "requestCode", "", "h5PageType", "Lproxy/H5PageType;", "addSocketDuplicate", "duplicate", "dismissPanel", "dispatchUri", "Lcom/bilibili/bililive/videoliveplayer/ui/roomv3/panel/LiveRoomDispatchUri;", "getAnchorFace", "getAnchorId", "getAnchorName", "getAreaId", "getBizSource", "getLoginUserId", "getMicAreaMicUserList", "", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/LiveGiftPanelMicUserInfo;", "getParentAreaId", "getRoomId", "getRoomIdentifier", "()Ljava/lang/Integer;", "getRoomInfo", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gateway/roominfo/BiliLiveRoomInfo;", "getRoomReportInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getRoomUserInfo", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gateway/userinfo/BiliLiveRoomUserInfo;", "getSpecialTypeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getUserFace", "isLandscape", "isLiveStream", "isLiving", "isLogin", "isNightMode", "isOfficialRoom", "isOfficialShowing", "jumpToLogin", "observeScreenMode", "Lcom/bilibili/bililive/infra/arch/jetpack/liveData/SafeMutableLiveData;", "openAnchorCard", "uid", "source", "openUserCard", "userUid", "(Ljava/lang/Long;)V", "postDelayedOnUiThread", "block", "Lkotlin/Function0;", "delay", "postOnUiThread", "removeAllMsgs", "removeCallbacks", "removeSocketDuplicate", "reportClick", "eventId", "bizData", "reportShow", "reportTech", "socketContainDuplicate", "toast", "message", "stringId", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class LiveBaseGiftWidget extends BaseWidget implements ILiveGiftGlobalService, IGiftParentBizContext, LiveLogger {
    private final /* synthetic */ LiveGiftGlobalServiceImpl $$delegate_0 = new LiveGiftGlobalServiceImpl();
    private final /* synthetic */ GiftParentBizContextImpl $$delegate_1 = new GiftParentBizContextImpl();
    private LiveRoomBaseGift currentSelectGift;

    public void addSocketDuplicate(String str) {
        Intrinsics.checkNotNullParameter(str, "duplicate");
        this.$$delegate_1.addSocketDuplicate(str);
    }

    public void dismissPanel() {
        this.$$delegate_1.dismissPanel();
    }

    public void dispatchUrl(LiveRoomDispatchUri liveRoomDispatchUri, H5PageType h5PageType) {
        Intrinsics.checkNotNullParameter(liveRoomDispatchUri, "dispatchUri");
        Intrinsics.checkNotNullParameter(h5PageType, "h5PageType");
        this.$$delegate_1.dispatchUrl(liveRoomDispatchUri, h5PageType);
    }

    public String getAnchorFace() {
        return this.$$delegate_1.getAnchorFace();
    }

    public Long getAnchorId() {
        return this.$$delegate_1.getAnchorId();
    }

    public String getAnchorName() {
        return this.$$delegate_1.getAnchorName();
    }

    public Long getAreaId() {
        return this.$$delegate_1.getAreaId();
    }

    public String getBizSource() {
        return this.$$delegate_1.getBizSource();
    }

    public Long getLoginUserId() {
        return this.$$delegate_1.getLoginUserId();
    }

    public List<LiveGiftPanelMicUserInfo> getMicAreaMicUserList() {
        return this.$$delegate_1.getMicAreaMicUserList();
    }

    public Long getParentAreaId() {
        return this.$$delegate_1.getParentAreaId();
    }

    public Long getRoomId() {
        return this.$$delegate_1.getRoomId();
    }

    public Integer getRoomIdentifier() {
        return this.$$delegate_1.getRoomIdentifier();
    }

    public BiliLiveRoomInfo getRoomInfo() {
        return this.$$delegate_1.getRoomInfo();
    }

    public HashMap<String, String> getRoomReportInfo() {
        return this.$$delegate_1.getRoomReportInfo();
    }

    public BiliLiveRoomUserInfo getRoomUserInfo() {
        return this.$$delegate_1.getRoomUserInfo();
    }

    public ArrayList<Integer> getSpecialTypeList() {
        return this.$$delegate_1.getSpecialTypeList();
    }

    public String getUserFace() {
        return this.$$delegate_1.getUserFace();
    }

    public boolean isLandscape() {
        return this.$$delegate_1.isLandscape();
    }

    public boolean isLiveStream() {
        return this.$$delegate_1.isLiveStream();
    }

    public boolean isLiving() {
        return this.$$delegate_1.isLiving();
    }

    public boolean isLogin() {
        return this.$$delegate_1.isLogin();
    }

    public boolean isNightMode() {
        return this.$$delegate_1.isNightMode();
    }

    public boolean isOfficialRoom() {
        return this.$$delegate_1.isOfficialRoom();
    }

    public boolean isOfficialShowing() {
        return this.$$delegate_1.isOfficialShowing();
    }

    public void jumpToLogin(int i) {
        this.$$delegate_0.jumpToLogin(i);
    }

    public SafeMutableLiveData<Boolean> observeScreenMode() {
        return this.$$delegate_1.observeScreenMode();
    }

    public void openAnchorCard(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "source");
        this.$$delegate_1.openAnchorCard(j, str);
    }

    public void openUserCard(Long l) {
        this.$$delegate_1.openUserCard(l);
    }

    public void postDelayedOnUiThread(Function0<Unit> function0, long j) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.$$delegate_0.postDelayedOnUiThread(function0, j);
    }

    public void postOnUiThread(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.$$delegate_0.postOnUiThread(function0);
    }

    public void removeAllMsgs() {
        this.$$delegate_0.removeAllMsgs();
    }

    public void removeCallbacks(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.$$delegate_0.removeCallbacks(function0);
    }

    public void removeSocketDuplicate(String str) {
        Intrinsics.checkNotNullParameter(str, "duplicate");
        this.$$delegate_1.removeSocketDuplicate(str);
    }

    public void reportClick(String str, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        this.$$delegate_1.reportClick(str, hashMap);
    }

    public void reportShow(String str, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        this.$$delegate_1.reportShow(str, hashMap);
    }

    public void reportTech(String str, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        this.$$delegate_1.reportTech(str, hashMap);
    }

    public boolean socketContainDuplicate(String str) {
        Intrinsics.checkNotNullParameter(str, "duplicate");
        return this.$$delegate_1.socketContainDuplicate(str);
    }

    public void toast(int i) {
        this.$$delegate_0.toast(i);
    }

    public void toast(String str) {
        this.$$delegate_0.toast(str);
    }

    public final Long getCurrentSelectGiftId() {
        LegoDataCenter dataCenter = getDataCenter();
        BiliLiveRoomGift currentSelectItem = dataCenter != null ? (LiveRoomBaseGift) dataCenter.get("key_data_current_select_gift_item") : null;
        if (currentSelectItem instanceof BiliLiveRoomGift) {
            BiliLiveGiftConfig giftConfig = currentSelectItem.getGiftConfig();
            return Long.valueOf(giftConfig != null ? giftConfig.mId : 0L);
        } else if (currentSelectItem instanceof BiliLivePackage) {
            return Long.valueOf(currentSelectItem.mGiftId);
        } else {
            return null;
        }
    }

    public final LiveRoomBaseGift getCurrentSelectGift() {
        LegoDataCenter dataCenter = getDataCenter();
        if (dataCenter != null) {
            return (LiveRoomBaseGift) dataCenter.get("key_data_current_select_gift_item");
        }
        return null;
    }

    public final void setCurrentSelectGift(LiveRoomBaseGift value) {
        LegoDataCenter dataCenter = getDataCenter();
        if (dataCenter != null) {
            dataCenter.put("key_data_current_select_gift_item", value);
        }
        this.currentSelectGift = value;
    }

    public final boolean isStudio() {
        BiliLiveRoomStudioInfo biliLiveRoomStudioInfo;
        BiliLiveRoomInfo roomInfo = getRoomInfo();
        return (roomInfo == null || (biliLiveRoomStudioInfo = roomInfo.studioInfo) == null || biliLiveRoomStudioInfo.status != 1) ? false : true;
    }

    public static /* synthetic */ void dispatchUrl$default(LiveBaseGiftWidget liveBaseGiftWidget, String str, int i, H5PageType h5PageType, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchUrl");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            h5PageType = H5PageType.HALF;
        }
        liveBaseGiftWidget.dispatchUrl(str, i, h5PageType);
    }

    public final void dispatchUrl(String webUrl, int requestCode, H5PageType h5PageType) {
        Intrinsics.checkNotNullParameter(webUrl, "webUrl");
        Intrinsics.checkNotNullParameter(h5PageType, "h5PageType");
        LiveRoomDispatchUri $this$dispatchUrl_u24lambda_u240 = new LiveRoomDispatchUri();
        $this$dispatchUrl_u24lambda_u240.setUrl(webUrl);
        $this$dispatchUrl_u24lambda_u240.setRequestCode(requestCode);
        dispatchUrl($this$dispatchUrl_u24lambda_u240, h5PageType);
    }
}