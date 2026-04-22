package proxy;

import com.bilibili.bililive.componentbridge.provider.BridgeProviders;
import com.bilibili.bililive.infra.arch.jetpack.liveData.SafeMutableLiveData;
import com.bilibili.bililive.infra.log.LiveLog;
import com.bilibili.bililive.infra.log.LiveLogDelegate;
import com.bilibili.bililive.infra.log.LiveLogger;
import com.bilibili.bililive.infra.widget.theme.ThemeWrapper;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.roominfo.BiliLiveRoomInfo;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.userinfo.BiliLiveRoomUserInfo;
import com.bilibili.bililive.videoliveplayer.net.beans.gift.LiveGiftPanelMicUserInfo;
import com.bilibili.bililive.videoliveplayer.ui.roomv3.panel.LiveRoomDispatchUri;
import env.LiveGiftBizEnv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;

/* compiled from: GiftParentBizContextImpl.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001TB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u000f\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010!J\u000f\u0010#\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010!J\u000f\u0010$\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010!J\u000f\u0010%\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010!J\b\u0010&\u001a\u00020\u001eH\u0016J\u0010\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u0006H\u0016J\b\u0010*\u001a\u00020\u0006H\u0016J\b\u0010+\u001a\u00020\u001eH\u0016J\b\u0010,\u001a\u00020\u0006H\u0016J\n\u0010-\u001a\u0004\u0018\u00010.H\u0016J\n\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0018\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u001a02j\b\u0012\u0004\u0012\u00020\u001a`3H\u0016J$\u00104\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000605j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`6H\u0016J8\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00062&\u0010:\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u000105j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`6H\u0016J8\u0010;\u001a\u0002082\u0006\u00109\u001a\u00020\u00062&\u0010:\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u000105j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`6H\u0016J8\u0010<\u001a\u0002082\u0006\u00109\u001a\u00020\u00062&\u0010:\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u000105j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`6H\u0016J\u0018\u0010=\u001a\u0002082\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0016J\u0017\u0010B\u001a\u0002082\b\u0010C\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010DJ\u0018\u0010E\u001a\u0002082\u0006\u0010F\u001a\u00020 2\u0006\u0010G\u001a\u00020\u0006H\u0016J\b\u0010H\u001a\u00020\u001eH\u0016J\b\u0010I\u001a\u00020\u001eH\u0016J\b\u0010J\u001a\u00020\u001eH\u0016J\b\u0010K\u001a\u000208H\u0016J\u000e\u0010L\u001a\b\u0012\u0004\u0012\u00020N0MH\u0016J\u0010\u0010O\u001a\u0002082\u0006\u0010P\u001a\u00020\u0006H\u0016J\u0010\u0010Q\u001a\u0002082\u0006\u0010P\u001a\u00020\u0006H\u0016J\u0010\u0010R\u001a\u00020\u001e2\u0006\u0010P\u001a\u00020\u0006H\u0016J\u0010\u0010S\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0006H\u0002R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017¨\u0006U"}, d2 = {"Lproxy/GiftParentBizContextImpl;", "Lproxy/IGiftParentBizContext;", "Lcom/bilibili/bililive/infra/log/LiveLogger;", "<init>", "()V", "logTag", "", "getLogTag", "()Ljava/lang/String;", "mLiveRoomContextProxy", "Lproxy/ILiveRoomGiftProxy;", "getMLiveRoomContextProxy", "()Lproxy/ILiveRoomGiftProxy;", "mLiveRoomContextProxy$delegate", "Lkotlin/Lazy;", "mBlinkLiveRoomContextProxy", "Lproxy/IBlinkLiveRoomGiftProxy;", "getMBlinkLiveRoomContextProxy", "()Lproxy/IBlinkLiveRoomGiftProxy;", "mBlinkLiveRoomContextProxy$delegate", "mGiftParentBizType", "Lproxy/GiftParentBizType;", "getMGiftParentBizType", "()Lproxy/GiftParentBizType;", "mGiftParentBizType$delegate", "getRoomIdentifier", "", "()Ljava/lang/Integer;", "getBizSource", "isLiveStream", "", "getLoginUserId", "", "()Ljava/lang/Long;", "getRoomId", "getAnchorId", "getParentAreaId", "getAreaId", "isLandscape", "observeScreenMode", "Lcom/bilibili/bililive/infra/arch/jetpack/liveData/SafeMutableLiveData;", "getUserFace", "getAnchorFace", "isLogin", "getAnchorName", "getRoomUserInfo", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gateway/userinfo/BiliLiveRoomUserInfo;", "getRoomInfo", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gateway/roominfo/BiliLiveRoomInfo;", "getSpecialTypeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getRoomReportInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "reportClick", "", "eventId", "bizData", "reportShow", "reportTech", "dispatchUrl", "dispatchUri", "Lcom/bilibili/bililive/videoliveplayer/ui/roomv3/panel/LiveRoomDispatchUri;", "h5PageType", "Lproxy/H5PageType;", "openUserCard", "userUid", "(Ljava/lang/Long;)V", "openAnchorCard", "uid", "source", "isOfficialRoom", "isOfficialShowing", "isLiving", "dismissPanel", "getMicAreaMicUserList", "", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/LiveGiftPanelMicUserInfo;", "addSocketDuplicate", "duplicate", "removeSocketDuplicate", "socketContainDuplicate", "recombineEventId", "Companion", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GiftParentBizContextImpl implements IGiftParentBizContext, LiveLogger {
    private static final String BLINK_EVENT_ID_HEAD = "live.my-live-room-show.";
    private static final String BLINK_SOURCE = "live_link";
    public static final Companion Companion = new Companion(null);
    private static final String LIVE_EVENT_ID_HEAD = "live.live-room-detail.";
    private static final String LIVE_SOURCE = "live";
    private static final String TAG = "GiftParentBizContextImpl";
    private final Lazy mLiveRoomContextProxy$delegate = LazyKt.lazy(new Function0() { // from class: proxy.GiftParentBizContextImpl$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ILiveRoomGiftProxy mLiveRoomContextProxy_delegate$lambda$0;
            mLiveRoomContextProxy_delegate$lambda$0 = GiftParentBizContextImpl.mLiveRoomContextProxy_delegate$lambda$0();
            return mLiveRoomContextProxy_delegate$lambda$0;
        }
    });
    private final Lazy mBlinkLiveRoomContextProxy$delegate = LazyKt.lazy(new Function0() { // from class: proxy.GiftParentBizContextImpl$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy_delegate$lambda$0;
            mBlinkLiveRoomContextProxy_delegate$lambda$0 = GiftParentBizContextImpl.mBlinkLiveRoomContextProxy_delegate$lambda$0();
            return mBlinkLiveRoomContextProxy_delegate$lambda$0;
        }
    });
    private final Lazy mGiftParentBizType$delegate = LazyKt.lazy(new Function0() { // from class: proxy.GiftParentBizContextImpl$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            GiftParentBizType mGiftParentBizType_delegate$lambda$0;
            mGiftParentBizType_delegate$lambda$0 = GiftParentBizContextImpl.mGiftParentBizType_delegate$lambda$0();
            return mGiftParentBizType_delegate$lambda$0;
        }
    });

    /* compiled from: GiftParentBizContextImpl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GiftParentBizType.values().length];
            try {
                iArr[GiftParentBizType.LIVE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[GiftParentBizType.BLINK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // proxy.IGiftCommonDataProxy
    public /* synthetic */ boolean isNightMode() {
        boolean isNightTheme;
        isNightTheme = ThemeWrapper.isNightTheme();
        return isNightTheme;
    }

    public String getLogTag() {
        return TAG;
    }

    private final ILiveRoomGiftProxy getMLiveRoomContextProxy() {
        return (ILiveRoomGiftProxy) this.mLiveRoomContextProxy$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILiveRoomGiftProxy mLiveRoomContextProxy_delegate$lambda$0() {
        return (ILiveRoomGiftProxy) BridgeProviders.Companion.getInstance().getOrNull(ILiveRoomGiftProxy.class);
    }

    private final IBlinkLiveRoomGiftProxy getMBlinkLiveRoomContextProxy() {
        return (IBlinkLiveRoomGiftProxy) this.mBlinkLiveRoomContextProxy$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy_delegate$lambda$0() {
        return (IBlinkLiveRoomGiftProxy) BridgeProviders.Companion.getInstance().getOrNull(IBlinkLiveRoomGiftProxy.class);
    }

    private final GiftParentBizType getMGiftParentBizType() {
        return (GiftParentBizType) this.mGiftParentBizType$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GiftParentBizType mGiftParentBizType_delegate$lambda$0() {
        LiveGiftBizEnv companion = LiveGiftBizEnv.Companion.getInstance();
        if (companion != null) {
            return companion.getGiftParentBizType();
        }
        return null;
    }

    @Override // proxy.IGiftCommonDataProxy
    public Integer getRoomIdentifier() {
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                if (mLiveRoomContextProxy != null) {
                    return mLiveRoomContextProxy.getRoomIdentifier();
                }
                return null;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                if (mBlinkLiveRoomContextProxy != null) {
                    return mBlinkLiveRoomContextProxy.getRoomIdentifier();
                }
                return null;
            default:
                return null;
        }
    }

    @Override // proxy.IGiftParentBizContext
    public String getBizSource() {
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
            default:
                return LIVE_SOURCE;
            case 2:
                return BLINK_SOURCE;
        }
    }

    @Override // proxy.IGiftParentBizContext
    public boolean isLiveStream() {
        return LiveGiftBizEnv.Companion.isBlink();
    }

    @Override // proxy.IGiftCommonDataProxy
    public Long getLoginUserId() {
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                if (mLiveRoomContextProxy != null) {
                    return mLiveRoomContextProxy.getLoginUserId();
                }
                return null;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                if (mBlinkLiveRoomContextProxy != null) {
                    return mBlinkLiveRoomContextProxy.getLoginUserId();
                }
                return null;
            default:
                return null;
        }
    }

    @Override // proxy.IGiftCommonDataProxy
    public Long getRoomId() {
        String str;
        GiftParentBizContextImpl $this$logInfo_u24default$iv = this;
        LiveLog.Companion this_$iv$iv = LiveLog.Companion;
        String tag$iv$iv = $this$logInfo_u24default$iv.getLogTag();
        if (this_$iv$iv.matchLevel(3)) {
            try {
                str = "mLiveRoomContextProxy = " + getMLiveRoomContextProxy();
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
                LiveLogDelegate.-CC.onLog$default(logDelegate, 3, tag$iv$iv, msg$iv$iv$iv, (Throwable) null, 8, (Object) null);
            }
            BLog.i(tag$iv$iv, msg$iv$iv$iv);
        }
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                if (mLiveRoomContextProxy != null) {
                    return mLiveRoomContextProxy.getRoomId();
                }
                return null;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                if (mBlinkLiveRoomContextProxy != null) {
                    return mBlinkLiveRoomContextProxy.getRoomId();
                }
                return null;
            default:
                return null;
        }
    }

    @Override // proxy.IGiftCommonDataProxy
    public Long getAnchorId() {
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                if (mLiveRoomContextProxy != null) {
                    return mLiveRoomContextProxy.getAnchorId();
                }
                return null;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                if (mBlinkLiveRoomContextProxy != null) {
                    return mBlinkLiveRoomContextProxy.getLoginUserId();
                }
                return null;
            default:
                return null;
        }
    }

    @Override // proxy.IGiftCommonDataProxy
    public Long getParentAreaId() {
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                if (mLiveRoomContextProxy != null) {
                    return mLiveRoomContextProxy.getParentAreaId();
                }
                return null;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                if (mBlinkLiveRoomContextProxy != null) {
                    return mBlinkLiveRoomContextProxy.getParentAreaId();
                }
                return null;
            default:
                return null;
        }
    }

    @Override // proxy.IGiftCommonDataProxy
    public Long getAreaId() {
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                if (mLiveRoomContextProxy != null) {
                    return mLiveRoomContextProxy.getAreaId();
                }
                return null;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                if (mBlinkLiveRoomContextProxy != null) {
                    return mBlinkLiveRoomContextProxy.getAreaId();
                }
                return null;
            default:
                return null;
        }
    }

    @Override // proxy.IGiftCommonDataProxy
    public boolean isLandscape() {
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                if (mLiveRoomContextProxy != null) {
                    return mLiveRoomContextProxy.isLandscape();
                }
                return false;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                if (mBlinkLiveRoomContextProxy != null) {
                    return mBlinkLiveRoomContextProxy.isLandscape();
                }
                return false;
            default:
                return false;
        }
    }

    @Override // proxy.IGiftCommonDataProxy
    public SafeMutableLiveData<Boolean> observeScreenMode() {
        ILiveRoomGiftProxy mLiveRoomContextProxy;
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        if ((mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) != 1 || (mLiveRoomContextProxy = getMLiveRoomContextProxy()) == null) {
            return null;
        }
        return mLiveRoomContextProxy.observeScreenMode();
    }

    @Override // proxy.IGiftCommonDataProxy
    public String getUserFace() {
        String userFace;
        String userFace2;
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                return (mLiveRoomContextProxy == null || (userFace = mLiveRoomContextProxy.getUserFace()) == null) ? "" : userFace;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                return (mBlinkLiveRoomContextProxy == null || (userFace2 = mBlinkLiveRoomContextProxy.getUserFace()) == null) ? "" : userFace2;
            default:
                return "";
        }
    }

    @Override // proxy.IGiftCommonDataProxy
    public String getAnchorFace() {
        String anchorFace;
        String anchorFace2;
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                return (mLiveRoomContextProxy == null || (anchorFace = mLiveRoomContextProxy.getAnchorFace()) == null) ? "" : anchorFace;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                return (mBlinkLiveRoomContextProxy == null || (anchorFace2 = mBlinkLiveRoomContextProxy.getAnchorFace()) == null) ? "" : anchorFace2;
            default:
                return "";
        }
    }

    @Override // proxy.IGiftCommonDataProxy
    public boolean isLogin() {
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                if (mLiveRoomContextProxy != null) {
                    return mLiveRoomContextProxy.isLogin();
                }
                return false;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                if (mBlinkLiveRoomContextProxy != null) {
                    return mBlinkLiveRoomContextProxy.isLogin();
                }
                return false;
            default:
                return false;
        }
    }

    @Override // proxy.IGiftCommonDataProxy
    public String getAnchorName() {
        String anchorName;
        String anchorName2;
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                return (mLiveRoomContextProxy == null || (anchorName = mLiveRoomContextProxy.getAnchorName()) == null) ? "" : anchorName;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                return (mBlinkLiveRoomContextProxy == null || (anchorName2 = mBlinkLiveRoomContextProxy.getAnchorName()) == null) ? "" : anchorName2;
            default:
                return "";
        }
    }

    @Override // proxy.IGiftCommonDataProxy
    public BiliLiveRoomUserInfo getRoomUserInfo() {
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                if (mLiveRoomContextProxy != null) {
                    return mLiveRoomContextProxy.getRoomUserInfo();
                }
                return null;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                if (mBlinkLiveRoomContextProxy != null) {
                    return mBlinkLiveRoomContextProxy.getRoomUserInfo();
                }
                return null;
            default:
                return null;
        }
    }

    @Override // proxy.IGiftCommonDataProxy
    public BiliLiveRoomInfo getRoomInfo() {
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                if (mLiveRoomContextProxy != null) {
                    return mLiveRoomContextProxy.getRoomInfo();
                }
                return null;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                if (mBlinkLiveRoomContextProxy != null) {
                    return mBlinkLiveRoomContextProxy.getRoomInfo();
                }
                return null;
            default:
                return null;
        }
    }

    @Override // proxy.IGiftCommonDataProxy
    public ArrayList<Integer> getSpecialTypeList() {
        ArrayList<Integer> specialTypeList;
        ArrayList<Integer> specialTypeList2;
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                return (mLiveRoomContextProxy == null || (specialTypeList = mLiveRoomContextProxy.getSpecialTypeList()) == null) ? new ArrayList<>() : specialTypeList;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                return (mBlinkLiveRoomContextProxy == null || (specialTypeList2 = mBlinkLiveRoomContextProxy.getSpecialTypeList()) == null) ? new ArrayList<>() : specialTypeList2;
            default:
                return new ArrayList<>();
        }
    }

    @Override // proxy.IGiftCommonDataProxy
    public HashMap<String, String> getRoomReportInfo() {
        HashMap<String, String> roomReportInfo;
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                return (mLiveRoomContextProxy == null || (roomReportInfo = mLiveRoomContextProxy.getRoomReportInfo()) == null) ? new HashMap<>() : roomReportInfo;
            case 2:
                return new HashMap<>();
            default:
                return new HashMap<>();
        }
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void reportClick(String eventId, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                if (mLiveRoomContextProxy != null) {
                    mLiveRoomContextProxy.reportClick(recombineEventId(eventId), hashMap);
                    return;
                }
                return;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                if (mBlinkLiveRoomContextProxy != null) {
                    mBlinkLiveRoomContextProxy.reportClick(recombineEventId(eventId), hashMap);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void reportShow(String eventId, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                if (mLiveRoomContextProxy != null) {
                    mLiveRoomContextProxy.reportShow(recombineEventId(eventId), hashMap);
                    return;
                }
                return;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                if (mBlinkLiveRoomContextProxy != null) {
                    mBlinkLiveRoomContextProxy.reportShow(recombineEventId(eventId), hashMap);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void reportTech(String eventId, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                if (mLiveRoomContextProxy != null) {
                    mLiveRoomContextProxy.reportTech(eventId, hashMap);
                    return;
                }
                return;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                if (mBlinkLiveRoomContextProxy != null) {
                    mBlinkLiveRoomContextProxy.reportTech(eventId, hashMap);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void dispatchUrl(LiveRoomDispatchUri dispatchUri, H5PageType h5PageType) {
        ILiveRoomAbilityProvider roomAbilityProvider;
        IBLinkLiveRoomAbilityProvider blinkRoomAbilityProvider;
        Intrinsics.checkNotNullParameter(dispatchUri, "dispatchUri");
        Intrinsics.checkNotNullParameter(h5PageType, "h5PageType");
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                if (mLiveRoomContextProxy == null || (roomAbilityProvider = mLiveRoomContextProxy.getRoomAbilityProvider()) == null) {
                    return;
                }
                roomAbilityProvider.dispatchUrl(dispatchUri);
                return;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                if (mBlinkLiveRoomContextProxy == null || (blinkRoomAbilityProvider = mBlinkLiveRoomContextProxy.getBlinkRoomAbilityProvider()) == null) {
                    return;
                }
                blinkRoomAbilityProvider.dispatchUrl(dispatchUri, h5PageType);
                return;
            default:
                return;
        }
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void openUserCard(Long userUid) {
        ILiveRoomAbilityProvider roomAbilityProvider;
        IBLinkLiveRoomAbilityProvider blinkRoomAbilityProvider;
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                if (mLiveRoomContextProxy == null || (roomAbilityProvider = mLiveRoomContextProxy.getRoomAbilityProvider()) == null) {
                    return;
                }
                roomAbilityProvider.openUserCard(userUid);
                return;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                if (mBlinkLiveRoomContextProxy == null || (blinkRoomAbilityProvider = mBlinkLiveRoomContextProxy.getBlinkRoomAbilityProvider()) == null) {
                    return;
                }
                blinkRoomAbilityProvider.openUserCard(userUid);
                return;
            default:
                return;
        }
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void openAnchorCard(long uid, String source) {
        ILiveRoomGiftProxy mLiveRoomContextProxy;
        ILiveRoomAbilityProvider roomAbilityProvider;
        Intrinsics.checkNotNullParameter(source, "source");
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        if ((mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) != 1 || (mLiveRoomContextProxy = getMLiveRoomContextProxy()) == null || (roomAbilityProvider = mLiveRoomContextProxy.getRoomAbilityProvider()) == null) {
            return;
        }
        roomAbilityProvider.openAnchorCard(uid, source);
    }

    @Override // proxy.IGiftCommonDataProxy
    public boolean isOfficialRoom() {
        ILiveRoomDataProvider roomDataProvider;
        ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
        if (mLiveRoomContextProxy == null || (roomDataProvider = mLiveRoomContextProxy.getRoomDataProvider()) == null) {
            return false;
        }
        return roomDataProvider.isOfficialRoom();
    }

    @Override // proxy.IGiftCommonDataProxy
    public boolean isOfficialShowing() {
        ILiveRoomDataProvider roomDataProvider;
        ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
        if (mLiveRoomContextProxy == null || (roomDataProvider = mLiveRoomContextProxy.getRoomDataProvider()) == null) {
            return false;
        }
        return roomDataProvider.isOfficialShowing();
    }

    @Override // proxy.IGiftCommonDataProxy
    public boolean isLiving() {
        ILiveRoomDataProvider roomDataProvider;
        ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
        if (mLiveRoomContextProxy == null || (roomDataProvider = mLiveRoomContextProxy.getRoomDataProvider()) == null) {
            return false;
        }
        return roomDataProvider.isLiving();
    }

    @Override // proxy.IGiftCommonAbilityProxy
    public void dismissPanel() {
        ILiveRoomAbilityProvider roomAbilityProvider;
        IBLinkLiveRoomAbilityProvider blinkRoomAbilityProvider;
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
                if (mLiveRoomContextProxy == null || (roomAbilityProvider = mLiveRoomContextProxy.getRoomAbilityProvider()) == null) {
                    return;
                }
                roomAbilityProvider.dismissPanel();
                return;
            case 2:
                IBlinkLiveRoomGiftProxy mBlinkLiveRoomContextProxy = getMBlinkLiveRoomContextProxy();
                if (mBlinkLiveRoomContextProxy == null || (blinkRoomAbilityProvider = mBlinkLiveRoomContextProxy.getBlinkRoomAbilityProvider()) == null) {
                    return;
                }
                blinkRoomAbilityProvider.dismissPanel();
                return;
            default:
                return;
        }
    }

    @Override // proxy.IGiftParentBizContext
    public List<LiveGiftPanelMicUserInfo> getMicAreaMicUserList() {
        ILiveRoomAbilityProvider roomAbilityProvider;
        List<LiveGiftPanelMicUserInfo> micUserList;
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        if ((mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) == 1) {
            ILiveRoomGiftProxy mLiveRoomContextProxy = getMLiveRoomContextProxy();
            return (mLiveRoomContextProxy == null || (roomAbilityProvider = mLiveRoomContextProxy.getRoomAbilityProvider()) == null || (micUserList = roomAbilityProvider.getMicUserList()) == null) ? new ArrayList() : micUserList;
        }
        return new ArrayList();
    }

    @Override // proxy.IGiftParentBizContext
    public void addSocketDuplicate(String duplicate) {
        ILiveRoomGiftProxy mLiveRoomContextProxy;
        ILiveRoomAbilityProvider roomAbilityProvider;
        Intrinsics.checkNotNullParameter(duplicate, "duplicate");
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        if ((mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) != 1 || (mLiveRoomContextProxy = getMLiveRoomContextProxy()) == null || (roomAbilityProvider = mLiveRoomContextProxy.getRoomAbilityProvider()) == null) {
            return;
        }
        roomAbilityProvider.addSocketDuplicate(duplicate);
    }

    @Override // proxy.IGiftParentBizContext
    public void removeSocketDuplicate(String duplicate) {
        ILiveRoomGiftProxy mLiveRoomContextProxy;
        ILiveRoomAbilityProvider roomAbilityProvider;
        Intrinsics.checkNotNullParameter(duplicate, "duplicate");
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        if ((mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) != 1 || (mLiveRoomContextProxy = getMLiveRoomContextProxy()) == null || (roomAbilityProvider = mLiveRoomContextProxy.getRoomAbilityProvider()) == null) {
            return;
        }
        roomAbilityProvider.removeSocketDuplicate(duplicate);
    }

    @Override // proxy.IGiftParentBizContext
    public boolean socketContainDuplicate(String duplicate) {
        ILiveRoomGiftProxy mLiveRoomContextProxy;
        ILiveRoomAbilityProvider roomAbilityProvider;
        Intrinsics.checkNotNullParameter(duplicate, "duplicate");
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        if ((mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) != 1 || (mLiveRoomContextProxy = getMLiveRoomContextProxy()) == null || (roomAbilityProvider = mLiveRoomContextProxy.getRoomAbilityProvider()) == null) {
            return false;
        }
        return roomAbilityProvider.socketContainDuplicate(duplicate);
    }

    private final String recombineEventId(String eventId) {
        String temp = eventId;
        if (StringsKt.contains$default((CharSequence) temp, (CharSequence) LIVE_EVENT_ID_HEAD, false, 2, (Object) null)) {
            String substring = temp.substring(22);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            temp = substring;
        }
        GiftParentBizType mGiftParentBizType = getMGiftParentBizType();
        switch (mGiftParentBizType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mGiftParentBizType.ordinal()]) {
            case 1:
                return LIVE_EVENT_ID_HEAD + temp;
            case 2:
                return BLINK_EVENT_ID_HEAD + temp;
            default:
                return eventId;
        }
    }

    /* compiled from: GiftParentBizContextImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lproxy/GiftParentBizContextImpl$Companion;", "", "<init>", "()V", "TAG", "", "BLINK_EVENT_ID_HEAD", "LIVE_EVENT_ID_HEAD", "LIVE_SOURCE", "BLINK_SOURCE", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}