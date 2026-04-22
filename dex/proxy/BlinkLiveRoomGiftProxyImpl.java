package proxy;

import com.bilibili.bililive.componentbridge.BridgeInterface;
import com.bilibili.bililive.componentbridge.BridgeObserver;
import com.bilibili.bililive.infra.arch.jetpack.liveData.SafeMutableLiveData;
import com.bilibili.bililive.infra.widget.theme.ThemeWrapper;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.roominfo.BiliLiveRoomInfo;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.userinfo.BiliLiveRoomUserInfo;
import com.bilibili.bililive.videoliveplayer.ui.roomv3.panel.LiveRoomDispatchUri;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BlinkLiveRoomGiftProxyImpl.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\u000f\u0010 \u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u0010\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\"H\u0016J\n\u0010#\u001a\u0004\u0018\u00010$H\u0016J\n\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0018\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00110(j\b\u0012\u0004\u0012\u00020\u0011`)H\u0016J$\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0+j\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c`,H\u0016J\b\u0010-\u001a\u00020\u001aH\u0016J\b\u0010.\u001a\u00020\u001aH\u0016J\b\u0010/\u001a\u00020\u001aH\u0016J8\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u001c2&\u00103\u001a\"\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010+j\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u0001`,H\u0016J8\u00104\u001a\u0002012\u0006\u00102\u001a\u00020\u001c2&\u00103\u001a\"\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010+j\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u0001`,H\u0016J8\u00105\u001a\u0002012\u0006\u00102\u001a\u00020\u001c2&\u00103\u001a\"\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010+j\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u0001`,H\u0016J\u0018\u00106\u001a\u0002012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000201H\u0016J\u0017\u0010<\u001a\u0002012\b\u0010=\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010>J\u0018\u0010?\u001a\u0002012\u0006\u0010@\u001a\u00020\u00142\u0006\u0010A\u001a\u00020\u001cH\u0016J\b\u0010B\u001a\u000201H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006C"}, d2 = {"Lproxy/BlinkLiveRoomGiftProxyImpl;", "Lproxy/IBlinkLiveRoomGiftProxy;", "<init>", "()V", "blinkRoomAbilityProvider", "Lproxy/IBLinkLiveRoomAbilityProvider;", "getBlinkRoomAbilityProvider", "()Lproxy/IBLinkLiveRoomAbilityProvider;", "setBlinkRoomAbilityProvider", "(Lproxy/IBLinkLiveRoomAbilityProvider;)V", "blinkRoomDataProvider", "Lproxy/IBLinkLiveRoomDataProvider;", "getBlinkRoomDataProvider", "()Lproxy/IBLinkLiveRoomDataProvider;", "setBlinkRoomDataProvider", "(Lproxy/IBLinkLiveRoomDataProvider;)V", "getRoomIdentifier", "", "()Ljava/lang/Integer;", "getRoomId", "", "()Ljava/lang/Long;", "getAnchorId", "getParentAreaId", "getAreaId", "isLandscape", "", "getUserFace", "", "getAnchorFace", "isLogin", "getAnchorName", "getLoginUserId", "observeScreenMode", "Lcom/bilibili/bililive/infra/arch/jetpack/liveData/SafeMutableLiveData;", "getRoomInfo", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gateway/roominfo/BiliLiveRoomInfo;", "getRoomUserInfo", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gateway/userinfo/BiliLiveRoomUserInfo;", "getSpecialTypeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getRoomReportInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "isOfficialRoom", "isOfficialShowing", "isLiving", "reportClick", "", "eventId", "bizData", "reportShow", "reportTech", "dispatchUrl", "dispatchUri", "Lcom/bilibili/bililive/videoliveplayer/ui/roomv3/panel/LiveRoomDispatchUri;", "h5PageType", "Lproxy/H5PageType;", "dismissPanel", "openUserCard", "userUid", "(Ljava/lang/Long;)V", "openAnchorCard", "uid", "source", "onClear", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BlinkLiveRoomGiftProxyImpl implements IBlinkLiveRoomGiftProxy {
    private IBLinkLiveRoomAbilityProvider blinkRoomAbilityProvider;
    private IBLinkLiveRoomDataProvider blinkRoomDataProvider;

    @Override // proxy.IGiftCommonDataProxy
    public /* synthetic */ boolean isNightMode() {
        boolean isNightTheme;
        isNightTheme = ThemeWrapper.isNightTheme();
        return isNightTheme;
    }

    public /* synthetic */ Unit notifyDataChanged(String str, Object obj) {
        return BridgeInterface.-CC.$default$notifyDataChanged(this, str, obj);
    }

    public /* synthetic */ Unit notifyDataChangedNullable(String str, Object obj) {
        return BridgeInterface.-CC.$default$notifyDataChangedNullable(this, str, obj);
    }

    public /* synthetic */ Unit notifyIfDataChanged(String str, Object obj) {
        return BridgeInterface.-CC.$default$notifyIfDataChanged(this, str, obj);
    }

    public /* synthetic */ Unit observe(String str, BridgeObserver bridgeObserver) {
        return BridgeInterface.-CC.$default$observe(this, str, bridgeObserver);
    }

    public /* synthetic */ Unit observe(String[] strArr, BridgeObserver bridgeObserver) {
        return BridgeInterface.-CC.$default$observe(this, strArr, bridgeObserver);
    }

    public /* synthetic */ void onCreate() {
        BridgeInterface.-CC.$default$onCreate(this);
    }

    public /* synthetic */ Unit removeBridges(String str) {
        return BridgeInterface.-CC.$default$removeBridges(this, str);
    }

    @Override // proxy.IBlinkLiveRoomGiftProxy
    public IBLinkLiveRoomAbilityProvider getBlinkRoomAbilityProvider() {
        return this.blinkRoomAbilityProvider;
    }

    @Override // proxy.IBlinkLiveRoomGiftProxy
    public void setBlinkRoomAbilityProvider(IBLinkLiveRoomAbilityProvider iBLinkLiveRoomAbilityProvider) {
        this.blinkRoomAbilityProvider = iBLinkLiveRoomAbilityProvider;
    }

    @Override // proxy.IBlinkLiveRoomGiftProxy
    public IBLinkLiveRoomDataProvider getBlinkRoomDataProvider() {
        return this.blinkRoomDataProvider;
    }

    @Override // proxy.IBlinkLiveRoomGiftProxy
    public void setBlinkRoomDataProvider(IBLinkLiveRoomDataProvider iBLinkLiveRoomDataProvider) {
        this.blinkRoomDataProvider = iBLinkLiveRoomDataProvider;
    }

    @Override // proxy.IGiftCommonDataProxy
    public Integer getRoomIdentifier() {
        IBLinkLiveRoomDataProvider blinkRoomDataProvider = getBlinkRoomDataProvider();
        if (blinkRoomDataProvider != null) {
            return blinkRoomDataProvider.getRoomIdentifier();
        }
        return null;
    }

    @Override // proxy.IGiftCommonDataProxy
    public Long getRoomId() {
        IBLinkLiveRoomDataProvider blinkRoomDataProvider = getBlinkRoomDataProvider();
        if (blinkRoomDataProvider != null) {
            return blinkRoomDataProvider.getRoomId();
        }
        return null;
    }

    @Override // proxy.IGiftCommonDataProxy
    public Long getAnchorId() {
        IBLinkLiveRoomDataProvider blinkRoomDataProvider = getBlinkRoomDataProvider();
        if (blinkRoomDataProvider != null) {
            return blinkRoomDataProvider.getAnchorId();
        }
        return null;
    }

    @Override // proxy.IGiftCommonDataProxy
    public Long getParentAreaId() {
        IBLinkLiveRoomDataProvider blinkRoomDataProvider = getBlinkRoomDataProvider();
        if (blinkRoomDataProvider != null) {
            return blinkRoomDataProvider.getParentAreaId();
        }
        return null;
    }

    @Override // proxy.IGiftCommonDataProxy
    public Long getAreaId() {
        IBLinkLiveRoomDataProvider blinkRoomDataProvider = getBlinkRoomDataProvider();
        if (blinkRoomDataProvider != null) {
            return blinkRoomDataProvider.getAreaId();
        }
        return null;
    }

    @Override // proxy.IGiftCommonDataProxy
    public boolean isLandscape() {
        IBLinkLiveRoomDataProvider blinkRoomDataProvider = getBlinkRoomDataProvider();
        if (blinkRoomDataProvider != null) {
            return blinkRoomDataProvider.isLandscape();
        }
        return false;
    }

    @Override // proxy.IGiftCommonDataProxy
    public String getUserFace() {
        String face;
        IBLinkLiveRoomDataProvider blinkRoomDataProvider = getBlinkRoomDataProvider();
        return (blinkRoomDataProvider == null || (face = blinkRoomDataProvider.getFace()) == null) ? "" : face;
    }

    @Override // proxy.IGiftCommonDataProxy
    public String getAnchorFace() {
        String face;
        IBLinkLiveRoomDataProvider blinkRoomDataProvider = getBlinkRoomDataProvider();
        return (blinkRoomDataProvider == null || (face = blinkRoomDataProvider.getFace()) == null) ? "" : face;
    }

    @Override // proxy.IGiftCommonDataProxy
    public boolean isLogin() {
        IBLinkLiveRoomDataProvider blinkRoomDataProvider = getBlinkRoomDataProvider();
        if (blinkRoomDataProvider != null) {
            return blinkRoomDataProvider.isLogin();
        }
        return true;
    }

    @Override // proxy.IGiftCommonDataProxy
    public String getAnchorName() {
        String anchorName;
        IBLinkLiveRoomDataProvider blinkRoomDataProvider = getBlinkRoomDataProvider();
        return (blinkRoomDataProvider == null || (anchorName = blinkRoomDataProvider.getAnchorName()) == null) ? "" : anchorName;
    }

    @Override // proxy.IGiftCommonDataProxy
    public Long getLoginUserId() {
        IBLinkLiveRoomDataProvider blinkRoomDataProvider = getBlinkRoomDataProvider();
        if (blinkRoomDataProvider != null) {
            return blinkRoomDataProvider.getLoginUserId();
        }
        return null;
    }

    @Override // proxy.IGiftCommonDataProxy
    public SafeMutableLiveData<Boolean> observeScreenMode() {
        return null;
    }

    @Override // proxy.IGiftCommonDataProxy
    public BiliLiveRoomInfo getRoomInfo() {
        return null;
    }

    @Override // proxy.IGiftCommonDataProxy
    public BiliLiveRoomUserInfo getRoomUserInfo() {
        return null;
    }

    @Override // proxy.IGiftCommonDataProxy
    public ArrayList<Integer> getSpecialTypeList() {
        return new ArrayList<>();
    }

    @Override // proxy.IGiftCommonDataProxy
    public HashMap<String, String> getRoomReportInfo() {
        return new HashMap<>();
    }

    @Override // proxy.IGiftCommonDataProxy
    public boolean isOfficialRoom() {
        return false;
    }

    @Override // proxy.IGiftCommonDataProxy
    public boolean isOfficialShowing() {
        return false;
    }

    @Override // proxy.IGiftCommonDataProxy
    public boolean isLiving() {
        return false;
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void reportClick(String eventId, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        IBLinkLiveRoomAbilityProvider blinkRoomAbilityProvider = getBlinkRoomAbilityProvider();
        if (blinkRoomAbilityProvider != null) {
            blinkRoomAbilityProvider.reportClick(eventId, hashMap);
        }
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void reportShow(String eventId, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        IBLinkLiveRoomAbilityProvider blinkRoomAbilityProvider = getBlinkRoomAbilityProvider();
        if (blinkRoomAbilityProvider != null) {
            blinkRoomAbilityProvider.reportShow(eventId, hashMap);
        }
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void reportTech(String eventId, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        IBLinkLiveRoomAbilityProvider blinkRoomAbilityProvider = getBlinkRoomAbilityProvider();
        if (blinkRoomAbilityProvider != null) {
            blinkRoomAbilityProvider.reportTech(eventId, hashMap);
        }
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void dispatchUrl(LiveRoomDispatchUri dispatchUri, H5PageType h5PageType) {
        Intrinsics.checkNotNullParameter(dispatchUri, "dispatchUri");
        Intrinsics.checkNotNullParameter(h5PageType, "h5PageType");
        IBLinkLiveRoomAbilityProvider blinkRoomAbilityProvider = getBlinkRoomAbilityProvider();
        if (blinkRoomAbilityProvider != null) {
            blinkRoomAbilityProvider.dispatchUrl(dispatchUri, h5PageType);
        }
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void dismissPanel() {
        IBLinkLiveRoomAbilityProvider blinkRoomAbilityProvider = getBlinkRoomAbilityProvider();
        if (blinkRoomAbilityProvider != null) {
            blinkRoomAbilityProvider.dismissPanel();
        }
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void openUserCard(Long userUid) {
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void openAnchorCard(long uid, String source) {
        Intrinsics.checkNotNullParameter(source, "source");
    }

    public void onClear() {
    }
}