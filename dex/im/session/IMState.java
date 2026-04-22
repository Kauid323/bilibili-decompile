package im.session;

import BottomSheetItemData$;
import com.bapis.bilibili.app.im.v1.KPaginationParams;
import com.bapis.bilibili.app.im.v1.KSessionPageType;
import com.bilibili.blens.Lens;
import com.tencent.smtt.sdk.TbsListener;
import im.base.ContentStatus;
import im.base.EmptyContent;
import im.base.ErrorContent;
import im.base.IMToast;
import im.base.IdleContent;
import im.base.LoadingContent;
import im.session.RequestStatus;
import im.session.model.IMSessionCard;
import im.session.model.IMSessionPageData;
import im.session.track.IMSessionLoadTimeTrack;
import im.setting.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMState.kt */
@Lens
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 G2\u00020\u0001:\u0001GBY\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\u000e\u00109\u001a\u00020\u000bHÀ\u0003¢\u0006\u0002\b:J\u000b\u0010;\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000e\u0010<\u001a\u00020\tHÀ\u0003¢\u0006\u0002\b=J\u000e\u0010>\u001a\u00020\u0010HÀ\u0003¢\u0006\u0002\b?J]\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010A\u001a\u00020\t2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020DHÖ\u0001J\t\u0010E\u001a\u00020FHÖ\u0001R\u0017\u0010\u0002\u001a\u00020\u0003¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\b\u001a\u00020\t¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\b\u0010\u001eR\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0019\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010#R\u0014\u0010\u000e\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010'\u001a\u00020(8F¢\u0006\f\u0012\u0004\b)\u0010\u0014\u001a\u0004\b*\u0010+R\u0017\u0010,\u001a\u00020(8F¢\u0006\f\u0012\u0004\b-\u0010\u0014\u001a\u0004\b.\u0010+R\u0017\u0010/\u001a\u00020(8F¢\u0006\f\u0012\u0004\b0\u0010\u0014\u001a\u0004\b1\u0010+R\u0017\u00102\u001a\u00020(8F¢\u0006\f\u0012\u0004\b3\u0010\u0014\u001a\u0004\b4\u0010+¨\u0006H"}, d2 = {"Lim/session/IMState;", "", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", UtilsKt.DATA_KEY, "Lim/session/model/IMSessionPageData;", "toast", "Lim/base/IMToast;", "isLoggedIn", "", "type", "Lim/session/RequestStatus;", "clickedSession", "Lim/session/model/IMSessionCard;", "firstLoad", "techTrack", "Lim/session/track/IMSessionLoadTimeTrack;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionPageType;Lim/session/model/IMSessionPageData;Lim/base/IMToast;ZLim/session/RequestStatus;Lim/session/model/IMSessionCard;ZLim/session/track/IMSessionLoadTimeTrack;)V", "getPageType$annotations", "()V", "getPageType", "()Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "getData$annotations", "getData", "()Lim/session/model/IMSessionPageData;", "getToast$annotations", "getToast", "()Lim/base/IMToast;", "isLoggedIn$annotations", "()Z", "getType$session_debug", "()Lim/session/RequestStatus;", "getClickedSession$annotations", "getClickedSession", "()Lim/session/model/IMSessionCard;", "getFirstLoad$session_debug", "getTechTrack$session_debug", "()Lim/session/track/IMSessionLoadTimeTrack;", "pageContentStatus", "Lim/base/ContentStatus;", "getPageContentStatus$annotations", "getPageContentStatus", "()Lim/base/ContentStatus;", "partialContentStatus", "getPartialContentStatus$annotations", "getPartialContentStatus", "tailContentStatus", "getTailContentStatus$annotations", "getTailContentStatus", "headStatus", "getHeadStatus$annotations", "getHeadStatus", "component1", "component2", "component3", "component4", "component5", "component5$session_debug", "component6", "component7", "component7$session_debug", "component8", "component8$session_debug", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMState {
    public static final Companion Companion = new Companion(null);
    private final IMSessionCard clickedSession;
    private final IMSessionPageData data;
    private final boolean firstLoad;
    private final boolean isLoggedIn;
    private final KSessionPageType pageType;
    private final IMSessionLoadTimeTrack techTrack;
    private final IMToast toast;
    private final RequestStatus type;

    public static /* synthetic */ IMState copy$default(IMState iMState, KSessionPageType kSessionPageType, IMSessionPageData iMSessionPageData, IMToast iMToast, boolean z, RequestStatus requestStatus, IMSessionCard iMSessionCard, boolean z2, IMSessionLoadTimeTrack iMSessionLoadTimeTrack, int i2, Object obj) {
        return iMState.copy((i2 & 1) != 0 ? iMState.pageType : kSessionPageType, (i2 & 2) != 0 ? iMState.data : iMSessionPageData, (i2 & 4) != 0 ? iMState.toast : iMToast, (i2 & 8) != 0 ? iMState.isLoggedIn : z, (i2 & 16) != 0 ? iMState.type : requestStatus, (i2 & 32) != 0 ? iMState.clickedSession : iMSessionCard, (i2 & 64) != 0 ? iMState.firstLoad : z2, (i2 & 128) != 0 ? iMState.techTrack : iMSessionLoadTimeTrack);
    }

    public static /* synthetic */ void getClickedSession$annotations() {
    }

    public static /* synthetic */ void getData$annotations() {
    }

    public static /* synthetic */ void getHeadStatus$annotations() {
    }

    public static /* synthetic */ void getPageContentStatus$annotations() {
    }

    public static /* synthetic */ void getPageType$annotations() {
    }

    public static /* synthetic */ void getPartialContentStatus$annotations() {
    }

    public static /* synthetic */ void getTailContentStatus$annotations() {
    }

    public static /* synthetic */ void getToast$annotations() {
    }

    public static /* synthetic */ void isLoggedIn$annotations() {
    }

    public final KSessionPageType component1() {
        return this.pageType;
    }

    public final IMSessionPageData component2() {
        return this.data;
    }

    public final IMToast component3() {
        return this.toast;
    }

    public final boolean component4() {
        return this.isLoggedIn;
    }

    public final RequestStatus component5$session_debug() {
        return this.type;
    }

    public final IMSessionCard component6() {
        return this.clickedSession;
    }

    public final boolean component7$session_debug() {
        return this.firstLoad;
    }

    public final IMSessionLoadTimeTrack component8$session_debug() {
        return this.techTrack;
    }

    public final IMState copy(KSessionPageType kSessionPageType, IMSessionPageData iMSessionPageData, IMToast iMToast, boolean z, RequestStatus requestStatus, IMSessionCard iMSessionCard, boolean z2, IMSessionLoadTimeTrack iMSessionLoadTimeTrack) {
        Intrinsics.checkNotNullParameter(kSessionPageType, "pageType");
        Intrinsics.checkNotNullParameter(iMSessionPageData, UtilsKt.DATA_KEY);
        Intrinsics.checkNotNullParameter(requestStatus, "type");
        Intrinsics.checkNotNullParameter(iMSessionLoadTimeTrack, "techTrack");
        return new IMState(kSessionPageType, iMSessionPageData, iMToast, z, requestStatus, iMSessionCard, z2, iMSessionLoadTimeTrack);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMState) {
            IMState iMState = (IMState) obj;
            return Intrinsics.areEqual(this.pageType, iMState.pageType) && Intrinsics.areEqual(this.data, iMState.data) && Intrinsics.areEqual(this.toast, iMState.toast) && this.isLoggedIn == iMState.isLoggedIn && Intrinsics.areEqual(this.type, iMState.type) && Intrinsics.areEqual(this.clickedSession, iMState.clickedSession) && this.firstLoad == iMState.firstLoad && Intrinsics.areEqual(this.techTrack, iMState.techTrack);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.pageType.hashCode() * 31) + this.data.hashCode()) * 31) + (this.toast == null ? 0 : this.toast.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLoggedIn)) * 31) + this.type.hashCode()) * 31) + (this.clickedSession != null ? this.clickedSession.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.firstLoad)) * 31) + this.techTrack.hashCode();
    }

    public String toString() {
        KSessionPageType kSessionPageType = this.pageType;
        IMSessionPageData iMSessionPageData = this.data;
        IMToast iMToast = this.toast;
        boolean z = this.isLoggedIn;
        RequestStatus requestStatus = this.type;
        IMSessionCard iMSessionCard = this.clickedSession;
        boolean z2 = this.firstLoad;
        return "IMState(pageType=" + kSessionPageType + ", data=" + iMSessionPageData + ", toast=" + iMToast + ", isLoggedIn=" + z + ", type=" + requestStatus + ", clickedSession=" + iMSessionCard + ", firstLoad=" + z2 + ", techTrack=" + this.techTrack + ")";
    }

    public IMState(KSessionPageType pageType, IMSessionPageData data, IMToast toast, boolean isLoggedIn, RequestStatus type, IMSessionCard clickedSession, boolean firstLoad, IMSessionLoadTimeTrack techTrack) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(data, UtilsKt.DATA_KEY);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(techTrack, "techTrack");
        this.pageType = pageType;
        this.data = data;
        this.toast = toast;
        this.isLoggedIn = isLoggedIn;
        this.type = type;
        this.clickedSession = clickedSession;
        this.firstLoad = firstLoad;
        this.techTrack = techTrack;
    }

    public /* synthetic */ IMState(KSessionPageType kSessionPageType, IMSessionPageData iMSessionPageData, IMToast iMToast, boolean z, RequestStatus requestStatus, IMSessionCard iMSessionCard, boolean z2, IMSessionLoadTimeTrack iMSessionLoadTimeTrack, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSessionPageType, iMSessionPageData, (i2 & 4) != 0 ? null : iMToast, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? RequestStatus.Idle.INSTANCE : requestStatus, (i2 & 32) != 0 ? null : iMSessionCard, (i2 & 64) != 0 ? true : z2, (i2 & 128) != 0 ? new IMSessionLoadTimeTrack(kSessionPageType, null, null, null, null, null, false, null, null, TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBSUCCESS, null) : iMSessionLoadTimeTrack);
    }

    public final KSessionPageType getPageType() {
        return this.pageType;
    }

    public final IMSessionPageData getData() {
        return this.data;
    }

    public final IMToast getToast() {
        return this.toast;
    }

    public final boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    public final RequestStatus getType$session_debug() {
        return this.type;
    }

    public final IMSessionCard getClickedSession() {
        return this.clickedSession;
    }

    public final boolean getFirstLoad$session_debug() {
        return this.firstLoad;
    }

    public final IMSessionLoadTimeTrack getTechTrack$session_debug() {
        return this.techTrack;
    }

    /* compiled from: IMState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lim/session/IMState$Companion;", "", "<init>", "()V", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final ContentStatus getPageContentStatus() {
        return (this.data.getHasContent() || !(this.type instanceof RequestStatus.Loading)) ? (this.data.getHasContent() || !(this.type instanceof RequestStatus.Error)) ? (this.data.getHasContent() || !(this.type instanceof RequestStatus.Idle)) ? IdleContent.INSTANCE : EmptyContent.INSTANCE : new ErrorContent(((RequestStatus.Error) this.type).getError()) : LoadingContent.INSTANCE;
    }

    public final ContentStatus getPartialContentStatus() {
        return (this.data.getHasContent() && this.data.getSessions().isEmpty() && (this.type instanceof RequestStatus.Loading)) ? LoadingContent.INSTANCE : (this.data.getHasContent() && this.data.getSessions().isEmpty() && (this.type instanceof RequestStatus.Error)) ? new ErrorContent(((RequestStatus.Error) this.type).getError()) : (this.data.getHasContent() && this.data.getSessions().isEmpty() && (this.type instanceof RequestStatus.Idle)) ? EmptyContent.INSTANCE : IdleContent.INSTANCE;
    }

    public final ContentStatus getTailContentStatus() {
        if (!this.data.getHasContent() || this.data.isCache() || this.data.getSessions().isEmpty() || !(this.type instanceof RequestStatus.Loading)) {
            if (!this.data.getHasContent() || this.data.isCache() || this.data.getSessions().isEmpty() || !(this.type instanceof RequestStatus.Error)) {
                if (this.data.getHasContent() && !this.data.isCache() && !this.data.getSessions().isEmpty() && (this.type instanceof RequestStatus.Idle)) {
                    KPaginationParams paginationParams$session_debug = this.data.getPaginationParams$session_debug();
                    boolean z = false;
                    if (paginationParams$session_debug != null && paginationParams$session_debug.getHasMore()) {
                        z = true;
                    }
                    if (!z) {
                        return EmptyContent.INSTANCE;
                    }
                }
                return IdleContent.INSTANCE;
            }
            return new ErrorContent(((RequestStatus.Error) this.type).getError());
        }
        return LoadingContent.INSTANCE;
    }

    public final ContentStatus getHeadStatus() {
        return (this.data.getHasContent() && this.data.isCache() && (this.type instanceof RequestStatus.Error)) ? new ErrorContent(((RequestStatus.Error) this.type).getError()) : IdleContent.INSTANCE;
    }
}