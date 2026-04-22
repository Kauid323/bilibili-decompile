package base;

import ability.ILiveGiftGlobalService;
import ability.LiveGiftGlobalServiceImpl;
import androidx.lifecycle.ViewModel;
import com.bilibili.bililive.infra.arch.jetpack.liveData.SafeMutableLiveData;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.roominfo.BiliLiveRoomInfo;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.roominfo.BiliLiveRoomStudioInfo;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.userinfo.BiliLiveRoomUserInfo;
import com.bilibili.bililive.videoliveplayer.net.beans.gift.LiveGiftPanelMicUserInfo;
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

/* compiled from: LiveBaseGiftViewVM.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\t\u0010\r\u001a\u00020\nH\u0096\u0001J\u0019\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0013\u001a\u00020\fH\u0096\u0001J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0001¢\u0006\u0002\u0010\u0016J\t\u0010\u0017\u001a\u00020\fH\u0096\u0001J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0096\u0001¢\u0006\u0002\u0010\u0016J\t\u0010\u0019\u001a\u00020\fH\u0096\u0001J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0015H\u0096\u0001¢\u0006\u0002\u0010\u0016J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0096\u0001J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0015H\u0096\u0001¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0015H\u0096\u0001¢\u0006\u0002\u0010\u0016J\u0010\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0001¢\u0006\u0002\u0010\"J\u000b\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0001J%\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0&j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`'H\u0096\u0001J\u000b\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0001J\u0019\u0010*\u001a\u0012\u0012\u0004\u0012\u00020!0+j\b\u0012\u0004\u0012\u00020!`,H\u0096\u0001J\t\u0010-\u001a\u00020\fH\u0096\u0001J\t\u0010.\u001a\u00020\u0007H\u0096\u0001J\t\u0010/\u001a\u00020\u0007H\u0096\u0001J\t\u00100\u001a\u00020\u0007H\u0096\u0001J\t\u00101\u001a\u00020\u0007H\u0096\u0001J\t\u00102\u001a\u00020\u0007H\u0096\u0001J\t\u00103\u001a\u00020\u0007H\u0096\u0001J\t\u00104\u001a\u00020\u0007H\u0096\u0001J\u0011\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020!H\u0096\u0001J\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u000108H\u0096\u0001J\u0019\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\fH\u0096\u0001J\u0018\u0010<\u001a\u00020\n2\b\u0010=\u001a\u0004\u0018\u00010\u0015H\u0096\u0001¢\u0006\u0002\u0010>J\u001f\u0010?\u001a\u00020\n2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\n0A2\u0006\u0010B\u001a\u00020\u0015H\u0096\u0001J\u0017\u0010C\u001a\u00020\n2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\n0AH\u0096\u0001J\t\u0010D\u001a\u00020\nH\u0096\u0001J\u0017\u0010E\u001a\u00020\n2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\n0AH\u0096\u0001J\u0011\u0010F\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J9\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u00020\f2&\u0010I\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010&j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u0001`'H\u0096\u0001J9\u0010J\u001a\u00020\n2\u0006\u0010H\u001a\u00020\f2&\u0010I\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010&j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u0001`'H\u0096\u0001J9\u0010K\u001a\u00020\n2\u0006\u0010H\u001a\u00020\f2&\u0010I\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010&j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u0001`'H\u0096\u0001J\u0011\u0010L\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0013\u0010M\u001a\u00020\n2\b\u0010N\u001a\u0004\u0018\u00010\fH\u0096\u0001J\u0013\u0010M\u001a\u00020\n2\b\b\u0001\u0010O\u001a\u00020!H\u0096\u0001R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\b¨\u0006P"}, d2 = {"Lbase/LiveBaseGiftViewVM;", "Landroidx/lifecycle/ViewModel;", "Lability/ILiveGiftGlobalService;", "Lproxy/IGiftParentBizContext;", "<init>", "()V", "isStudio", "", "()Z", "addSocketDuplicate", "", "duplicate", "", "dismissPanel", "dispatchUrl", "dispatchUri", "Lcom/bilibili/bililive/videoliveplayer/ui/roomv3/panel/LiveRoomDispatchUri;", "h5PageType", "Lproxy/H5PageType;", "getAnchorFace", "getAnchorId", "", "()Ljava/lang/Long;", "getAnchorName", "getAreaId", "getBizSource", "getLoginUserId", "getMicAreaMicUserList", "", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/LiveGiftPanelMicUserInfo;", "getParentAreaId", "getRoomId", "getRoomIdentifier", "", "()Ljava/lang/Integer;", "getRoomInfo", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gateway/roominfo/BiliLiveRoomInfo;", "getRoomReportInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getRoomUserInfo", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gateway/userinfo/BiliLiveRoomUserInfo;", "getSpecialTypeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getUserFace", "isLandscape", "isLiveStream", "isLiving", "isLogin", "isNightMode", "isOfficialRoom", "isOfficialShowing", "jumpToLogin", "requestCode", "observeScreenMode", "Lcom/bilibili/bililive/infra/arch/jetpack/liveData/SafeMutableLiveData;", "openAnchorCard", "uid", "source", "openUserCard", "userUid", "(Ljava/lang/Long;)V", "postDelayedOnUiThread", "block", "Lkotlin/Function0;", "delay", "postOnUiThread", "removeAllMsgs", "removeCallbacks", "removeSocketDuplicate", "reportClick", "eventId", "bizData", "reportShow", "reportTech", "socketContainDuplicate", "toast", "message", "stringId", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class LiveBaseGiftViewVM extends ViewModel implements ILiveGiftGlobalService, IGiftParentBizContext {
    private final /* synthetic */ LiveGiftGlobalServiceImpl $$delegate_0 = new LiveGiftGlobalServiceImpl();
    private final /* synthetic */ GiftParentBizContextImpl $$delegate_1 = new GiftParentBizContextImpl();

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

    public final boolean isStudio() {
        BiliLiveRoomStudioInfo biliLiveRoomStudioInfo;
        BiliLiveRoomInfo roomInfo = getRoomInfo();
        return (roomInfo == null || (biliLiveRoomStudioInfo = roomInfo.studioInfo) == null || biliLiveRoomStudioInfo.status != 1) ? false : true;
    }
}