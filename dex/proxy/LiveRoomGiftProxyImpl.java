package proxy;

import com.bilibili.bililive.componentbridge.BridgeInterface;
import com.bilibili.bililive.componentbridge.BridgeObserver;
import com.bilibili.bililive.infra.arch.jetpack.liveData.SafeMutableLiveData;
import com.bilibili.bililive.infra.log.LiveLog;
import com.bilibili.bililive.infra.log.LiveLogDelegate;
import com.bilibili.bililive.infra.log.LiveLogger;
import com.bilibili.bililive.infra.widget.theme.ThemeWrapper;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.roominfo.BiliLiveRoomInfo;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.userinfo.BiliLiveRoomUserInfo;
import com.bilibili.bililive.videoliveplayer.ui.roomv3.panel.LiveRoomDispatchUri;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;

/* compiled from: LiveRoomGiftProxyImpl.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\u0006H\u0016J\u0010\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010%H\u0016J8\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00062&\u0010)\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010*j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`+H\u0016J8\u0010,\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00062&\u0010)\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010*j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`+H\u0016J8\u0010-\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00062&\u0010)\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010*j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`+H\u0016J\u0018\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020'H\u0016J\u0017\u00104\u001a\u00020'2\b\u00105\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u00106J\u0018\u00107\u001a\u00020'2\u0006\u00108\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u0006H\u0016J\u0014\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060*H\u0016J\b\u0010;\u001a\u00020\u001fH\u0016J\b\u0010<\u001a\u00020\u001fH\u0016J\b\u0010=\u001a\u00020\u001fH\u0016J\u000f\u0010>\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\n\u0010?\u001a\u0004\u0018\u00010@H\u0016J\n\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0018\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u00160Dj\b\u0012\u0004\u0012\u00020\u0016`EH\u0016J\u0006\u0010F\u001a\u00020'J\b\u0010G\u001a\u00020'H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006I"}, d2 = {"Lproxy/LiveRoomGiftProxyImpl;", "Lproxy/ILiveRoomGiftProxy;", "Lcom/bilibili/bililive/infra/log/LiveLogger;", "<init>", "()V", "logTag", "", "getLogTag", "()Ljava/lang/String;", "roomAbilityProvider", "Lproxy/ILiveRoomAbilityProvider;", "getRoomAbilityProvider", "()Lproxy/ILiveRoomAbilityProvider;", "setRoomAbilityProvider", "(Lproxy/ILiveRoomAbilityProvider;)V", "roomDataProvider", "Lproxy/ILiveRoomDataProvider;", "getRoomDataProvider", "()Lproxy/ILiveRoomDataProvider;", "setRoomDataProvider", "(Lproxy/ILiveRoomDataProvider;)V", "getRoomIdentifier", "", "()Ljava/lang/Integer;", "getRoomId", "", "()Ljava/lang/Long;", "getAnchorId", "getParentAreaId", "getAreaId", "isLandscape", "", "getUserFace", "getAnchorFace", "isLogin", "getAnchorName", "observeScreenMode", "Lcom/bilibili/bililive/infra/arch/jetpack/liveData/SafeMutableLiveData;", "reportClick", "", "eventId", "bizData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "reportShow", "reportTech", "dispatchUrl", "dispatchUri", "Lcom/bilibili/bililive/videoliveplayer/ui/roomv3/panel/LiveRoomDispatchUri;", "h5PageType", "Lproxy/H5PageType;", "dismissPanel", "openUserCard", "userUid", "(Ljava/lang/Long;)V", "openAnchorCard", "uid", "source", "getRoomReportInfo", "isOfficialRoom", "isOfficialShowing", "isLiving", "getLoginUserId", "getRoomInfo", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gateway/roominfo/BiliLiveRoomInfo;", "getRoomUserInfo", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gateway/userinfo/BiliLiveRoomUserInfo;", "getSpecialTypeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "startUp", "onClear", "Companion", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LiveRoomGiftProxyImpl implements ILiveRoomGiftProxy, LiveLogger {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "LiveRoomGiftProxyImpl";
    private ILiveRoomAbilityProvider roomAbilityProvider;
    private ILiveRoomDataProvider roomDataProvider;

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

    public String getLogTag() {
        return TAG;
    }

    @Override // proxy.ILiveRoomGiftProxy
    public ILiveRoomAbilityProvider getRoomAbilityProvider() {
        return this.roomAbilityProvider;
    }

    @Override // proxy.ILiveRoomGiftProxy
    public void setRoomAbilityProvider(ILiveRoomAbilityProvider iLiveRoomAbilityProvider) {
        this.roomAbilityProvider = iLiveRoomAbilityProvider;
    }

    @Override // proxy.ILiveRoomGiftProxy
    public ILiveRoomDataProvider getRoomDataProvider() {
        return this.roomDataProvider;
    }

    @Override // proxy.ILiveRoomGiftProxy
    public void setRoomDataProvider(ILiveRoomDataProvider iLiveRoomDataProvider) {
        this.roomDataProvider = iLiveRoomDataProvider;
    }

    @Override // proxy.IGiftCommonDataProxy
    public Integer getRoomIdentifier() {
        ILiveRoomDataProvider roomDataProvider = getRoomDataProvider();
        if (roomDataProvider != null) {
            return roomDataProvider.getRoomIdentifier();
        }
        return null;
    }

    @Override // proxy.IGiftCommonDataProxy
    public Long getRoomId() {
        ILiveRoomDataProvider roomDataProvider = getRoomDataProvider();
        if (roomDataProvider != null) {
            return roomDataProvider.getRoomId();
        }
        return null;
    }

    @Override // proxy.IGiftCommonDataProxy
    public Long getAnchorId() {
        ILiveRoomDataProvider roomDataProvider = getRoomDataProvider();
        if (roomDataProvider != null) {
            return roomDataProvider.getAnchorId();
        }
        return null;
    }

    @Override // proxy.IGiftCommonDataProxy
    public Long getParentAreaId() {
        ILiveRoomDataProvider roomDataProvider = getRoomDataProvider();
        if (roomDataProvider != null) {
            return roomDataProvider.getParentAreaId();
        }
        return null;
    }

    @Override // proxy.IGiftCommonDataProxy
    public Long getAreaId() {
        ILiveRoomDataProvider roomDataProvider = getRoomDataProvider();
        if (roomDataProvider != null) {
            return roomDataProvider.getAreaId();
        }
        return null;
    }

    @Override // proxy.IGiftCommonDataProxy
    public boolean isLandscape() {
        ILiveRoomDataProvider roomDataProvider = getRoomDataProvider();
        if (roomDataProvider != null) {
            return roomDataProvider.isLandscape();
        }
        return false;
    }

    @Override // proxy.IGiftCommonDataProxy
    public String getUserFace() {
        String userFace;
        ILiveRoomDataProvider roomDataProvider = getRoomDataProvider();
        return (roomDataProvider == null || (userFace = roomDataProvider.getUserFace()) == null) ? "" : userFace;
    }

    @Override // proxy.IGiftCommonDataProxy
    public String getAnchorFace() {
        String anchorFace;
        ILiveRoomDataProvider roomDataProvider = getRoomDataProvider();
        return (roomDataProvider == null || (anchorFace = roomDataProvider.getAnchorFace()) == null) ? "" : anchorFace;
    }

    @Override // proxy.IGiftCommonDataProxy
    public boolean isLogin() {
        ILiveRoomDataProvider roomDataProvider = getRoomDataProvider();
        if (roomDataProvider != null) {
            return roomDataProvider.isLogin();
        }
        return false;
    }

    @Override // proxy.IGiftCommonDataProxy
    public String getAnchorName() {
        String anchorName;
        ILiveRoomDataProvider roomDataProvider = getRoomDataProvider();
        return (roomDataProvider == null || (anchorName = roomDataProvider.getAnchorName()) == null) ? "" : anchorName;
    }

    @Override // proxy.IGiftCommonDataProxy
    public SafeMutableLiveData<Boolean> observeScreenMode() {
        ILiveRoomDataProvider roomDataProvider = getRoomDataProvider();
        if (roomDataProvider != null) {
            return roomDataProvider.observeScreenMode();
        }
        return null;
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void reportClick(String eventId, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        ILiveRoomAbilityProvider roomAbilityProvider = getRoomAbilityProvider();
        if (roomAbilityProvider != null) {
            roomAbilityProvider.reportClick(eventId, hashMap);
        }
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void reportShow(String eventId, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        ILiveRoomAbilityProvider roomAbilityProvider = getRoomAbilityProvider();
        if (roomAbilityProvider != null) {
            roomAbilityProvider.reportShow(eventId, hashMap);
        }
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void reportTech(String eventId, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        ILiveRoomAbilityProvider roomAbilityProvider = getRoomAbilityProvider();
        if (roomAbilityProvider != null) {
            roomAbilityProvider.reportTech(eventId, hashMap);
        }
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void dispatchUrl(LiveRoomDispatchUri dispatchUri, H5PageType h5PageType) {
        Intrinsics.checkNotNullParameter(dispatchUri, "dispatchUri");
        Intrinsics.checkNotNullParameter(h5PageType, "h5PageType");
        ILiveRoomAbilityProvider roomAbilityProvider = getRoomAbilityProvider();
        if (roomAbilityProvider != null) {
            roomAbilityProvider.dispatchUrl(dispatchUri);
        }
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void dismissPanel() {
        ILiveRoomAbilityProvider roomAbilityProvider = getRoomAbilityProvider();
        if (roomAbilityProvider != null) {
            roomAbilityProvider.dismissPanel();
        }
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void openUserCard(Long userUid) {
        ILiveRoomAbilityProvider roomAbilityProvider = getRoomAbilityProvider();
        if (roomAbilityProvider != null) {
            roomAbilityProvider.openUserCard(userUid);
        }
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void openAnchorCard(long uid, String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        ILiveRoomAbilityProvider roomAbilityProvider = getRoomAbilityProvider();
        if (roomAbilityProvider != null) {
            roomAbilityProvider.openAnchorCard(uid, source);
        }
    }

    @Override // proxy.IGiftCommonDataProxy
    public HashMap<String, String> getRoomReportInfo() {
        HashMap<String, String> roomReportInfo;
        ILiveRoomDataProvider roomDataProvider = getRoomDataProvider();
        return (roomDataProvider == null || (roomReportInfo = roomDataProvider.getRoomReportInfo()) == null) ? new HashMap<>() : roomReportInfo;
    }

    @Override // proxy.IGiftCommonDataProxy
    public boolean isOfficialRoom() {
        ILiveRoomDataProvider roomDataProvider = getRoomDataProvider();
        if (roomDataProvider != null) {
            return roomDataProvider.isOfficialRoom();
        }
        return false;
    }

    @Override // proxy.IGiftCommonDataProxy
    public boolean isOfficialShowing() {
        ILiveRoomDataProvider roomDataProvider = getRoomDataProvider();
        if (roomDataProvider != null) {
            return roomDataProvider.isOfficialShowing();
        }
        return false;
    }

    @Override // proxy.IGiftCommonDataProxy
    public boolean isLiving() {
        ILiveRoomDataProvider roomDataProvider = getRoomDataProvider();
        if (roomDataProvider != null) {
            return roomDataProvider.isLiving();
        }
        return false;
    }

    @Override // proxy.IGiftCommonDataProxy
    public Long getLoginUserId() {
        ILiveRoomDataProvider roomDataProvider = getRoomDataProvider();
        if (roomDataProvider != null) {
            return roomDataProvider.getLoginUserId();
        }
        return null;
    }

    @Override // proxy.IGiftCommonDataProxy
    public BiliLiveRoomInfo getRoomInfo() {
        ILiveRoomDataProvider roomDataProvider = getRoomDataProvider();
        if (roomDataProvider != null) {
            return roomDataProvider.getRoomInfo();
        }
        return null;
    }

    @Override // proxy.IGiftCommonDataProxy
    public BiliLiveRoomUserInfo getRoomUserInfo() {
        ILiveRoomDataProvider roomDataProvider = getRoomDataProvider();
        if (roomDataProvider != null) {
            return roomDataProvider.getRoomUserInfo();
        }
        return null;
    }

    @Override // proxy.IGiftCommonDataProxy
    public ArrayList<Integer> getSpecialTypeList() {
        ArrayList<Integer> specialTypeList;
        ILiveRoomDataProvider roomDataProvider = getRoomDataProvider();
        return (roomDataProvider == null || (specialTypeList = roomDataProvider.getSpecialTypeList()) == null) ? new ArrayList<>() : specialTypeList;
    }

    public final void startUp() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onClear() {
        String str;
        LiveLogger $this$logInfo_u24default$iv;
        LiveLogger $this$logInfo_u24default$iv2;
        LiveRoomGiftProxyImpl $this$logInfo_u24default$iv3 = this;
        LiveLog.Companion this_$iv$iv = LiveLog.Companion;
        String tag$iv$iv = $this$logInfo_u24default$iv3.getLogTag();
        if (this_$iv$iv.matchLevel(3)) {
            try {
                str = "onClear roomAbilityProvider = " + getRoomAbilityProvider() + ", roomDataProvider = " + getRoomDataProvider();
            } catch (Exception e$iv$iv$iv) {
                BLog.e("LiveLog", "getLogMessage", e$iv$iv$iv);
                str = null;
            }
            String msg$iv$iv$iv = str;
            if (msg$iv$iv$iv == null) {
                msg$iv$iv$iv = "";
            }
            LiveLogDelegate logDelegate = this_$iv$iv.getLogDelegate();
            if (logDelegate != null) {
                $this$logInfo_u24default$iv = null;
                LiveLogDelegate.-CC.onLog$default(logDelegate, 3, tag$iv$iv, msg$iv$iv$iv, (Throwable) null, 8, (Object) null);
            } else {
                $this$logInfo_u24default$iv = null;
            }
            BLog.i(tag$iv$iv, msg$iv$iv$iv);
            $this$logInfo_u24default$iv2 = $this$logInfo_u24default$iv;
        } else {
            $this$logInfo_u24default$iv2 = null;
        }
        setRoomAbilityProvider($this$logInfo_u24default$iv2);
        setRoomDataProvider($this$logInfo_u24default$iv2);
    }

    /* compiled from: LiveRoomGiftProxyImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lproxy/LiveRoomGiftProxyImpl$Companion;", "", "<init>", "()V", "TAG", "", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}