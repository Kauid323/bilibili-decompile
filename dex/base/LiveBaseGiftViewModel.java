package base;

import ability.ILiveGiftGlobalService;
import ability.LiveGiftGlobalServiceImpl;
import com.bilibili.bililive.biz.uicommon.beans.BiliLiveGiftConfig;
import com.bilibili.bililive.infra.arch.jetpack.liveData.SafeMutableLiveData;
import com.bilibili.bililive.infra.log.LiveLogger;
import com.bilibili.bililive.lego.livedata.LegoDataCenter;
import com.bilibili.bililive.lego.livedata.LegoViewModel;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.roominfo.BiliLiveRoomInfo;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.roominfo.BiliLiveRoomStudioInfo;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.userinfo.BiliLiveRoomUserInfo;
import com.bilibili.bililive.videoliveplayer.net.beans.gift.BiliLivePackage;
import com.bilibili.bililive.videoliveplayer.net.beans.gift.BiliLiveRoomGift;
import com.bilibili.bililive.videoliveplayer.net.beans.gift.LiveGiftPanelMicUserInfo;
import com.bilibili.bililive.videoliveplayer.net.beans.gift.LiveRoomBaseGift;
import com.bilibili.bililive.videoliveplayer.net.beans.gift.LiveRoomGiftSpecial;
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

/* compiled from: LiveBaseGiftViewModel.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020)2\b\b\u0002\u00101\u001a\u000202J\b\u00103\u001a\u00020/H\u0016J\u0011\u00104\u001a\u00020/2\u0006\u00105\u001a\u00020)H\u0096\u0001J\t\u00106\u001a\u00020/H\u0096\u0001J\u0019\u0010.\u001a\u00020/2\u0006\u00107\u001a\u0002082\u0006\u00101\u001a\u000202H\u0096\u0001J\t\u00109\u001a\u00020)H\u0096\u0001J\u0010\u0010:\u001a\u0004\u0018\u00010\bH\u0096\u0001¢\u0006\u0002\u0010;J\t\u0010<\u001a\u00020)H\u0096\u0001J\u0010\u0010=\u001a\u0004\u0018\u00010\bH\u0096\u0001¢\u0006\u0002\u0010;J\t\u0010>\u001a\u00020)H\u0096\u0001J\u0010\u0010?\u001a\u0004\u0018\u00010\bH\u0096\u0001¢\u0006\u0002\u0010;J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AH\u0096\u0001J\u0010\u0010C\u001a\u0004\u0018\u00010\bH\u0096\u0001¢\u0006\u0002\u0010;J\u0010\u0010D\u001a\u0004\u0018\u00010\bH\u0096\u0001¢\u0006\u0002\u0010;J\u0010\u0010E\u001a\u0004\u0018\u00010\fH\u0096\u0001¢\u0006\u0002\u0010\u000eJ\u000b\u0010F\u001a\u0004\u0018\u00010GH\u0096\u0001J%\u0010H\u001a\u001e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0Ij\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)`JH\u0096\u0001J\u000b\u0010K\u001a\u0004\u0018\u00010LH\u0096\u0001J\u0019\u0010M\u001a\u0012\u0012\u0004\u0012\u00020\f0Nj\b\u0012\u0004\u0012\u00020\f`OH\u0096\u0001J\t\u0010P\u001a\u00020)H\u0096\u0001J\t\u0010Q\u001a\u00020\u001fH\u0096\u0001J\t\u0010R\u001a\u00020\u001fH\u0096\u0001J\t\u0010S\u001a\u00020\u001fH\u0096\u0001J\t\u0010T\u001a\u00020\u001fH\u0096\u0001J\t\u0010U\u001a\u00020\u001fH\u0096\u0001J\t\u0010V\u001a\u00020\u001fH\u0096\u0001J\t\u0010W\u001a\u00020\u001fH\u0096\u0001J\u0011\u0010X\u001a\u00020/2\u0006\u0010Y\u001a\u00020\fH\u0096\u0001J\u0011\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010[H\u0096\u0001J\u0019\u0010\\\u001a\u00020/2\u0006\u0010]\u001a\u00020\b2\u0006\u0010^\u001a\u00020)H\u0096\u0001J\u0018\u0010_\u001a\u00020/2\b\u0010`\u001a\u0004\u0018\u00010\bH\u0096\u0001¢\u0006\u0002\u0010aJ\u001f\u0010b\u001a\u00020/2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020/0d2\u0006\u0010e\u001a\u00020\bH\u0096\u0001J\u0017\u0010f\u001a\u00020/2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020/0dH\u0096\u0001J\t\u0010g\u001a\u00020/H\u0096\u0001J\u0017\u0010h\u001a\u00020/2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020/0dH\u0096\u0001J\u0011\u0010i\u001a\u00020/2\u0006\u00105\u001a\u00020)H\u0096\u0001J9\u0010j\u001a\u00020/2\u0006\u0010k\u001a\u00020)2&\u0010l\u001a\"\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u00010Ij\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u0001`JH\u0096\u0001J9\u0010m\u001a\u00020/2\u0006\u0010k\u001a\u00020)2&\u0010l\u001a\"\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u00010Ij\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u0001`JH\u0096\u0001J9\u0010n\u001a\u00020/2\u0006\u0010k\u001a\u00020)2&\u0010l\u001a\"\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u00010Ij\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u0001`JH\u0096\u0001J\u0011\u0010o\u001a\u00020\u001f2\u0006\u00105\u001a\u00020)H\u0096\u0001J\u0013\u0010p\u001a\u00020/2\b\u0010q\u001a\u0004\u0018\u00010)H\u0096\u0001J\u0013\u0010p\u001a\u00020/2\b\b\u0001\u0010r\u001a\u00020\fH\u0096\u0001R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR*\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010 R\u0011\u0010!\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0013\u0010$\u001a\u0004\u0018\u00010%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006s"}, d2 = {"Lbase/LiveBaseGiftViewModel;", "Lcom/bilibili/bililive/lego/livedata/LegoViewModel;", "Lcom/bilibili/bililive/infra/log/LiveLogger;", "Lability/ILiveGiftGlobalService;", "Lproxy/IGiftParentBizContext;", "<init>", "()V", "currentSelectGiftId", "", "getCurrentSelectGiftId", "()J", "currentSelectGiftSpecialType", "", "getCurrentSelectGiftSpecialType", "()Ljava/lang/Integer;", "value", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/LiveRoomBaseGift;", "currentSelectGift", "getCurrentSelectGift", "()Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/LiveRoomBaseGift;", "setCurrentSelectGift", "(Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/LiveRoomBaseGift;)V", "currentSelectBagGift", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/BiliLivePackage;", "getCurrentSelectBagGift", "()Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/BiliLivePackage;", "currentSelectRoomGift", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/BiliLiveRoomGift;", "getCurrentSelectRoomGift", "()Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/BiliLiveRoomGift;", "isStudio", "", "()Z", "giftItemPosition", "getGiftItemPosition", "()I", "giftLocation", "", "getGiftLocation", "()[I", "giftPanelSourceEvent", "", "getGiftPanelSourceEvent", "()Ljava/lang/String;", "setGiftPanelSourceEvent", "(Ljava/lang/String;)V", "dispatchUrl", "", "webUrl", "h5PageType", "Lproxy/H5PageType;", "updateGiftPanelHeight", "addSocketDuplicate", "duplicate", "dismissPanel", "dispatchUri", "Lcom/bilibili/bililive/videoliveplayer/ui/roomv3/panel/LiveRoomDispatchUri;", "getAnchorFace", "getAnchorId", "()Ljava/lang/Long;", "getAnchorName", "getAreaId", "getBizSource", "getLoginUserId", "getMicAreaMicUserList", "", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/LiveGiftPanelMicUserInfo;", "getParentAreaId", "getRoomId", "getRoomIdentifier", "getRoomInfo", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gateway/roominfo/BiliLiveRoomInfo;", "getRoomReportInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getRoomUserInfo", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gateway/userinfo/BiliLiveRoomUserInfo;", "getSpecialTypeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getUserFace", "isLandscape", "isLiveStream", "isLiving", "isLogin", "isNightMode", "isOfficialRoom", "isOfficialShowing", "jumpToLogin", "requestCode", "observeScreenMode", "Lcom/bilibili/bililive/infra/arch/jetpack/liveData/SafeMutableLiveData;", "openAnchorCard", "uid", "source", "openUserCard", "userUid", "(Ljava/lang/Long;)V", "postDelayedOnUiThread", "block", "Lkotlin/Function0;", "delay", "postOnUiThread", "removeAllMsgs", "removeCallbacks", "removeSocketDuplicate", "reportClick", "eventId", "bizData", "reportShow", "reportTech", "socketContainDuplicate", "toast", "message", "stringId", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class LiveBaseGiftViewModel extends LegoViewModel implements LiveLogger, ILiveGiftGlobalService, IGiftParentBizContext {
    private final /* synthetic */ LiveGiftGlobalServiceImpl $$delegate_0 = new LiveGiftGlobalServiceImpl();
    private final /* synthetic */ GiftParentBizContextImpl $$delegate_1 = new GiftParentBizContextImpl();
    private LiveRoomBaseGift currentSelectGift;
    private String giftPanelSourceEvent;

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

    public final long getCurrentSelectGiftId() {
        BiliLiveRoomGift currentSelectGift = getCurrentSelectGift();
        if (!(currentSelectGift instanceof BiliLiveRoomGift)) {
            if (currentSelectGift instanceof BiliLivePackage) {
                return ((BiliLivePackage) currentSelectGift).mGiftId;
            }
            return 0L;
        }
        BiliLiveGiftConfig giftConfig = currentSelectGift.getGiftConfig();
        if (giftConfig != null) {
            return giftConfig.mId;
        }
        return 0L;
    }

    public final Integer getCurrentSelectGiftSpecialType() {
        LiveRoomGiftSpecial liveRoomGiftSpecial;
        BiliLiveRoomGift currentSelectGift = getCurrentSelectGift();
        if (!(currentSelectGift instanceof BiliLiveRoomGift) || (liveRoomGiftSpecial = currentSelectGift.special) == null) {
            return null;
        }
        return Integer.valueOf(liveRoomGiftSpecial.specialType);
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

    public final BiliLivePackage getCurrentSelectBagGift() {
        BiliLivePackage currentSelectGift = getCurrentSelectGift();
        if (currentSelectGift instanceof BiliLivePackage) {
            return currentSelectGift;
        }
        return null;
    }

    public final BiliLiveRoomGift getCurrentSelectRoomGift() {
        BiliLiveRoomGift currentSelectGift = getCurrentSelectGift();
        if (currentSelectGift instanceof BiliLiveRoomGift) {
            return currentSelectGift;
        }
        return null;
    }

    public final boolean isStudio() {
        BiliLiveRoomStudioInfo biliLiveRoomStudioInfo;
        BiliLiveRoomInfo roomInfo = getRoomInfo();
        if (roomInfo == null || (biliLiveRoomStudioInfo = roomInfo.studioInfo) == null) {
            return false;
        }
        return biliLiveRoomStudioInfo.isOnlineStudio();
    }

    public final int getGiftItemPosition() {
        Integer num;
        LegoDataCenter dataCenter = getDataCenter();
        if (dataCenter == null || (num = (Integer) dataCenter.get("key_data_item_position")) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final int[] getGiftLocation() {
        LegoDataCenter dataCenter = getDataCenter();
        if (dataCenter != null) {
            return (int[]) dataCenter.get("key_data_gift_location");
        }
        return null;
    }

    public final String getGiftPanelSourceEvent() {
        return this.giftPanelSourceEvent;
    }

    public final void setGiftPanelSourceEvent(String str) {
        this.giftPanelSourceEvent = str;
    }

    public static /* synthetic */ void dispatchUrl$default(LiveBaseGiftViewModel liveBaseGiftViewModel, String str, H5PageType h5PageType, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchUrl");
        }
        if ((i & 2) != 0) {
            h5PageType = H5PageType.HALF;
        }
        liveBaseGiftViewModel.dispatchUrl(str, h5PageType);
    }

    public final void dispatchUrl(String webUrl, H5PageType h5PageType) {
        Intrinsics.checkNotNullParameter(webUrl, "webUrl");
        Intrinsics.checkNotNullParameter(h5PageType, "h5PageType");
        LiveRoomDispatchUri $this$dispatchUrl_u24lambda_u240 = new LiveRoomDispatchUri();
        $this$dispatchUrl_u24lambda_u240.setUrl(webUrl);
        dispatchUrl($this$dispatchUrl_u24lambda_u240, h5PageType);
    }

    public void updateGiftPanelHeight() {
    }
}