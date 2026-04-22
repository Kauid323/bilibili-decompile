package im.session.model;

import BottomSheetItemData$;
import com.bapis.bilibili.app.im.v1.KAlertToastType;
import com.bapis.bilibili.app.im.v1.KBehaviorAlertToast;
import com.bapis.bilibili.app.im.v1.KGetQuickLinkUnreadReply;
import com.bapis.bilibili.app.im.v1.KPaginationParams;
import com.bapis.bilibili.app.im.v1.KSessionFilterType;
import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bapis.bilibili.app.im.v1.KSessionListExtraInfo;
import com.bapis.bilibili.app.im.v1.KSessionOperation;
import com.bapis.bilibili.app.im.v1.KThreeDotItemType;
import com.bapis.bilibili.app.im.v1.KUnread;
import com.bapis.bilibili.app.im.v1.KUpdateSessionParams;
import com.bilibili.blens.Lens;
import im.session.service.IMSummaryCacheService;
import im.session.service.PinResult;
import im.session.service.Summary;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Transient;

/* compiled from: IMSessionPageData.kt */
@Lens
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 z2\u00020\u0001:\u0001zB\u0099\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u0000H\u0000¢\u0006\u0002\b<J\u0015\u0010=\u001a\u00020\u00002\u0006\u0010;\u001a\u00020>H\u0000¢\u0006\u0002\b?J\u0015\u0010=\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\fH\u0000¢\u0006\u0002\b?J&\u0010A\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0015\u0010C\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\fH\u0000¢\u0006\u0002\bDJ\u001d\u0010E\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\f2\u0006\u0010F\u001a\u00020GH\u0000¢\u0006\u0002\bHJ\u001d\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0016H\u0000¢\u0006\u0002\bMJ\u0018\u0010N\u001a\u00020\u00002\u0006\u0010O\u001a\u00020PH\u0080@¢\u0006\u0004\bQ\u0010RJ\u0015\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020UH\u0000¢\u0006\u0002\bVJ\u0015\u0010W\u001a\u00020\u00002\u0006\u0010X\u001a\u00020YH\u0000¢\u0006\u0002\bZJ\u0015\u0010[\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\\H\u0000¢\u0006\u0002\b]J\u001f\u0010^\u001a\u00020\u00002\u0006\u0010J\u001a\u00020K2\b\u0010_\u001a\u0004\u0018\u00010`H\u0000¢\u0006\u0002\baJ\u0015\u0010b\u001a\u00020\u00002\u0006\u0010c\u001a\u00020\u000eH\u0000¢\u0006\u0002\bdJ\u0010\u0010e\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\bfJ\u0010\u0010g\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0002\bhJ\u000b\u0010i\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010\tHÀ\u0003¢\u0006\u0002\bkJ\u000f\u0010l\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000f\u0010m\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bHÆ\u0003J\u000f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bHÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00140\u000bHÆ\u0003J\t\u0010r\u001a\u00020\u0016HÆ\u0003J\u009b\u0001\u0010s\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u0016HÆ\u0001J\u0013\u0010t\u001a\u00020\u00162\b\u0010u\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010v\u001a\u00020wHÖ\u0001J\t\u0010x\u001a\u00020yHÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010*\u001a\u0004\b+\u0010\"R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010,R\u001c\u0010-\u001a\u00020.8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010*\u001a\u0004\b0\u00101R\u0011\u00102\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b3\u0010,R\u0011\u00104\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b5\u0010,R\u0016\u00106\u001a\u0004\u0018\u0001078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006{"}, d2 = {"Lim/session/model/IMSessionPageData;", "", "paginationParams", "Lcom/bapis/bilibili/app/im/v1/KPaginationParams;", "updateSessionParams", "Lcom/bapis/bilibili/app/im/v1/KUpdateSessionParams;", "quickLinks", "Lim/session/model/IMQuickLink;", "filterConfig", "Lim/session/model/IMSessionFilterConfig;", "sessions", "", "Lim/session/model/IMSessionCard;", "threeDots", "Lim/session/model/IMThreeDotItem;", "outsideActions", "extraInfo", "Lcom/bapis/bilibili/app/im/v1/KSessionListExtraInfo;", "sessionToDelete", "filters", "Lim/session/model/IMSessionFilter;", "isCache", "", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KPaginationParams;Lcom/bapis/bilibili/app/im/v1/KUpdateSessionParams;Lim/session/model/IMQuickLink;Lim/session/model/IMSessionFilterConfig;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/bapis/bilibili/app/im/v1/KSessionListExtraInfo;Lim/session/model/IMSessionCard;Ljava/util/List;Z)V", "getPaginationParams$session_debug", "()Lcom/bapis/bilibili/app/im/v1/KPaginationParams;", "getUpdateSessionParams$session_debug", "()Lcom/bapis/bilibili/app/im/v1/KUpdateSessionParams;", "getQuickLinks", "()Lim/session/model/IMQuickLink;", "getFilterConfig$session_debug", "()Lim/session/model/IMSessionFilterConfig;", "getSessions", "()Ljava/util/List;", "getThreeDots", "getOutsideActions", "getExtraInfo", "()Lcom/bapis/bilibili/app/im/v1/KSessionListExtraInfo;", "getSessionToDelete", "()Lim/session/model/IMSessionCard;", "getFilters$annotations", "()V", "getFilters", "()Z", "extraData", "Lim/session/model/IMSessionPageExtraData;", "getExtraData$annotations", "getExtraData", "()Lim/session/model/IMSessionPageExtraData;", "hasContent", "getHasContent", "hasThreeDotsRedDot", "getHasThreeDotsRedDot", "alert", "Lim/session/model/IMSessionAlert;", "getAlert$session_debug", "()Lim/session/model/IMSessionAlert;", "append", "response", "append$session_debug", "update", "Lim/session/model/IMSessionPartialPage;", "update$session_debug", "session", "updateFrom", "resp", "delete", "delete$session_debug", "pinOrNot", "result", "Lim/session/service/PinResult;", "pinOrNot$session_debug", "mute", "sessionID", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "isMuted", "mute$session_debug", "clearAllUnread", "summaryService", "Lim/session/service/IMSummaryCacheService;", "clearAllUnread$session_debug", "(Lim/session/service/IMSummaryCacheService;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearQuickLinkUnread", "item", "Lim/session/model/IMQuickLinkItem;", "clearQuickLinkUnread$session_debug", "changeFilter", "filterType", "Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;", "changeFilter$session_debug", "updateQuickLinkUnread", "Lcom/bapis/bilibili/app/im/v1/KGetQuickLinkUnreadReply;", "updateQuickLinkUnread$session_debug", "updateSummary", "newSummary", "Lim/session/service/Summary;", "updateSummary$session_debug", "clearRedDot", "threeDotItem", "clearRedDot$session_debug", "component1", "component1$session_debug", "component2", "component2$session_debug", "component3", "component4", "component4$session_debug", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionPageData {
    public static final Companion Companion = new Companion(null);
    private final IMSessionPageExtraData extraData;
    private final KSessionListExtraInfo extraInfo;
    private final IMSessionFilterConfig filterConfig;
    private final List<IMSessionFilter> filters;
    private final boolean isCache;
    private final List<IMThreeDotItem> outsideActions;
    private final KPaginationParams paginationParams;
    private final IMQuickLink quickLinks;
    private final IMSessionCard sessionToDelete;
    private final List<IMSessionCard> sessions;
    private final List<IMThreeDotItem> threeDots;
    private final KUpdateSessionParams updateSessionParams;

    public IMSessionPageData() {
        this(null, null, null, null, null, null, null, null, null, null, false, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IMSessionPageData copy$default(IMSessionPageData iMSessionPageData, KPaginationParams kPaginationParams, KUpdateSessionParams kUpdateSessionParams, IMQuickLink iMQuickLink, IMSessionFilterConfig iMSessionFilterConfig, List list, List list2, List list3, KSessionListExtraInfo kSessionListExtraInfo, IMSessionCard iMSessionCard, List list4, boolean z, int i2, Object obj) {
        return iMSessionPageData.copy((i2 & 1) != 0 ? iMSessionPageData.paginationParams : kPaginationParams, (i2 & 2) != 0 ? iMSessionPageData.updateSessionParams : kUpdateSessionParams, (i2 & 4) != 0 ? iMSessionPageData.quickLinks : iMQuickLink, (i2 & 8) != 0 ? iMSessionPageData.filterConfig : iMSessionFilterConfig, (i2 & 16) != 0 ? iMSessionPageData.sessions : list, (i2 & 32) != 0 ? iMSessionPageData.threeDots : list2, (i2 & 64) != 0 ? iMSessionPageData.outsideActions : list3, (i2 & 128) != 0 ? iMSessionPageData.extraInfo : kSessionListExtraInfo, (i2 & 256) != 0 ? iMSessionPageData.sessionToDelete : iMSessionCard, (i2 & 512) != 0 ? iMSessionPageData.filters : list4, (i2 & 1024) != 0 ? iMSessionPageData.isCache : z);
    }

    @Transient
    public static /* synthetic */ void getExtraData$annotations() {
    }

    @Transient
    public static /* synthetic */ void getFilters$annotations() {
    }

    public final KPaginationParams component1$session_debug() {
        return this.paginationParams;
    }

    public final List<IMSessionFilter> component10() {
        return this.filters;
    }

    public final boolean component11() {
        return this.isCache;
    }

    public final KUpdateSessionParams component2$session_debug() {
        return this.updateSessionParams;
    }

    public final IMQuickLink component3() {
        return this.quickLinks;
    }

    public final IMSessionFilterConfig component4$session_debug() {
        return this.filterConfig;
    }

    public final List<IMSessionCard> component5() {
        return this.sessions;
    }

    public final List<IMThreeDotItem> component6() {
        return this.threeDots;
    }

    public final List<IMThreeDotItem> component7() {
        return this.outsideActions;
    }

    public final KSessionListExtraInfo component8() {
        return this.extraInfo;
    }

    public final IMSessionCard component9() {
        return this.sessionToDelete;
    }

    public final IMSessionPageData copy(KPaginationParams kPaginationParams, KUpdateSessionParams kUpdateSessionParams, IMQuickLink iMQuickLink, IMSessionFilterConfig iMSessionFilterConfig, List<IMSessionCard> list, List<IMThreeDotItem> list2, List<IMThreeDotItem> list3, KSessionListExtraInfo kSessionListExtraInfo, IMSessionCard iMSessionCard, List<IMSessionFilter> list4, boolean z) {
        Intrinsics.checkNotNullParameter(list, "sessions");
        Intrinsics.checkNotNullParameter(list2, "threeDots");
        Intrinsics.checkNotNullParameter(list3, "outsideActions");
        Intrinsics.checkNotNullParameter(list4, "filters");
        return new IMSessionPageData(kPaginationParams, kUpdateSessionParams, iMQuickLink, iMSessionFilterConfig, list, list2, list3, kSessionListExtraInfo, iMSessionCard, list4, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMSessionPageData) {
            IMSessionPageData iMSessionPageData = (IMSessionPageData) obj;
            return Intrinsics.areEqual(this.paginationParams, iMSessionPageData.paginationParams) && Intrinsics.areEqual(this.updateSessionParams, iMSessionPageData.updateSessionParams) && Intrinsics.areEqual(this.quickLinks, iMSessionPageData.quickLinks) && Intrinsics.areEqual(this.filterConfig, iMSessionPageData.filterConfig) && Intrinsics.areEqual(this.sessions, iMSessionPageData.sessions) && Intrinsics.areEqual(this.threeDots, iMSessionPageData.threeDots) && Intrinsics.areEqual(this.outsideActions, iMSessionPageData.outsideActions) && Intrinsics.areEqual(this.extraInfo, iMSessionPageData.extraInfo) && Intrinsics.areEqual(this.sessionToDelete, iMSessionPageData.sessionToDelete) && Intrinsics.areEqual(this.filters, iMSessionPageData.filters) && this.isCache == iMSessionPageData.isCache;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((this.paginationParams == null ? 0 : this.paginationParams.hashCode()) * 31) + (this.updateSessionParams == null ? 0 : this.updateSessionParams.hashCode())) * 31) + (this.quickLinks == null ? 0 : this.quickLinks.hashCode())) * 31) + (this.filterConfig == null ? 0 : this.filterConfig.hashCode())) * 31) + this.sessions.hashCode()) * 31) + this.threeDots.hashCode()) * 31) + this.outsideActions.hashCode()) * 31) + (this.extraInfo == null ? 0 : this.extraInfo.hashCode())) * 31) + (this.sessionToDelete != null ? this.sessionToDelete.hashCode() : 0)) * 31) + this.filters.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isCache);
    }

    public String toString() {
        KPaginationParams kPaginationParams = this.paginationParams;
        KUpdateSessionParams kUpdateSessionParams = this.updateSessionParams;
        IMQuickLink iMQuickLink = this.quickLinks;
        IMSessionFilterConfig iMSessionFilterConfig = this.filterConfig;
        List<IMSessionCard> list = this.sessions;
        List<IMThreeDotItem> list2 = this.threeDots;
        List<IMThreeDotItem> list3 = this.outsideActions;
        KSessionListExtraInfo kSessionListExtraInfo = this.extraInfo;
        IMSessionCard iMSessionCard = this.sessionToDelete;
        List<IMSessionFilter> list4 = this.filters;
        return "IMSessionPageData(paginationParams=" + kPaginationParams + ", updateSessionParams=" + kUpdateSessionParams + ", quickLinks=" + iMQuickLink + ", filterConfig=" + iMSessionFilterConfig + ", sessions=" + list + ", threeDots=" + list2 + ", outsideActions=" + list3 + ", extraInfo=" + kSessionListExtraInfo + ", sessionToDelete=" + iMSessionCard + ", filters=" + list4 + ", isCache=" + this.isCache + ")";
    }

    public IMSessionPageData(KPaginationParams paginationParams, KUpdateSessionParams updateSessionParams, IMQuickLink quickLinks, IMSessionFilterConfig filterConfig, List<IMSessionCard> list, List<IMThreeDotItem> list2, List<IMThreeDotItem> list3, KSessionListExtraInfo extraInfo, IMSessionCard sessionToDelete, List<IMSessionFilter> list4, boolean isCache) {
        Intrinsics.checkNotNullParameter(list, "sessions");
        Intrinsics.checkNotNullParameter(list2, "threeDots");
        Intrinsics.checkNotNullParameter(list3, "outsideActions");
        Intrinsics.checkNotNullParameter(list4, "filters");
        this.paginationParams = paginationParams;
        this.updateSessionParams = updateSessionParams;
        this.quickLinks = quickLinks;
        this.filterConfig = filterConfig;
        this.sessions = list;
        this.threeDots = list2;
        this.outsideActions = list3;
        this.extraInfo = extraInfo;
        this.sessionToDelete = sessionToDelete;
        this.filters = list4;
        this.isCache = isCache;
        this.extraData = IMSessionPageExtraData_androidKt.IMSessionPageExtraData(this);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ IMSessionPageData(KPaginationParams kPaginationParams, KUpdateSessionParams kUpdateSessionParams, IMQuickLink iMQuickLink, IMSessionFilterConfig iMSessionFilterConfig, List list, List list2, List list3, KSessionListExtraInfo kSessionListExtraInfo, IMSessionCard iMSessionCard, List list4, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r4, r5, (i2 & 16) != 0 ? CollectionsKt.emptyList() : list, (i2 & 32) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 64) != 0 ? CollectionsKt.emptyList() : list3, (i2 & 128) != 0 ? null : kSessionListExtraInfo, (i2 & 256) == 0 ? iMSessionCard : null, (i2 & 512) != 0 ? IMSessionFilterKt.filters(r5) : list4, (i2 & 1024) != 0 ? false : z);
        KPaginationParams kPaginationParams2 = (i2 & 1) != 0 ? null : kPaginationParams;
        KUpdateSessionParams kUpdateSessionParams2 = (i2 & 2) != 0 ? null : kUpdateSessionParams;
        IMQuickLink iMQuickLink2 = (i2 & 4) != 0 ? null : iMQuickLink;
        IMSessionFilterConfig iMSessionFilterConfig2 = (i2 & 8) != 0 ? null : iMSessionFilterConfig;
    }

    public final KPaginationParams getPaginationParams$session_debug() {
        return this.paginationParams;
    }

    public final KUpdateSessionParams getUpdateSessionParams$session_debug() {
        return this.updateSessionParams;
    }

    public final IMQuickLink getQuickLinks() {
        return this.quickLinks;
    }

    public final IMSessionFilterConfig getFilterConfig$session_debug() {
        return this.filterConfig;
    }

    public final List<IMSessionCard> getSessions() {
        return this.sessions;
    }

    public final List<IMThreeDotItem> getThreeDots() {
        return this.threeDots;
    }

    public final List<IMThreeDotItem> getOutsideActions() {
        return this.outsideActions;
    }

    public final KSessionListExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public final IMSessionCard getSessionToDelete() {
        return this.sessionToDelete;
    }

    public final List<IMSessionFilter> getFilters() {
        return this.filters;
    }

    public final boolean isCache() {
        return this.isCache;
    }

    /* compiled from: IMSessionPageData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lim/session/model/IMSessionPageData$Companion;", "", "<init>", "()V", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final IMSessionPageExtraData getExtraData() {
        return this.extraData;
    }

    public final boolean getHasContent() {
        IMQuickLink iMQuickLink = this.quickLinks;
        List<IMQuickLinkItem> items = iMQuickLink != null ? iMQuickLink.getItems() : null;
        return ((items == null || items.isEmpty()) && this.sessions.isEmpty() && this.filters.isEmpty()) ? false : true;
    }

    public final boolean getHasThreeDotsRedDot() {
        Iterable $this$any$iv = this.threeDots;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            IMThreeDotItem it = (IMThreeDotItem) element$iv;
            if (it.getHasRedDot()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final IMSessionAlert getAlert$session_debug() {
        boolean z;
        KBehaviorAlertToast behaviorAlertToast;
        String title;
        KSessionListExtraInfo kSessionListExtraInfo = this.extraInfo;
        boolean z2 = true;
        if (kSessionListExtraInfo != null && (behaviorAlertToast = kSessionListExtraInfo.getBehaviorAlertToast()) != null && (title = behaviorAlertToast.getTitle()) != null) {
            if (title.length() > 0) {
                z = true;
                if (!z) {
                    KBehaviorAlertToast behaviorAlertToast2 = this.extraInfo.getBehaviorAlertToast();
                    if (behaviorAlertToast2 == null) {
                        behaviorAlertToast2 = new KBehaviorAlertToast((String) null, (String) null, (String) null, (KAlertToastType) null, 15, (DefaultConstructorMarker) null);
                    }
                    return new IMSessionBehaviorAlert(behaviorAlertToast2);
                }
                KSessionListExtraInfo kSessionListExtraInfo2 = this.extraInfo;
                if (kSessionListExtraInfo2 == null || !kSessionListExtraInfo2.getShowAntiHarassmentPopup()) {
                    z2 = false;
                }
                if (z2) {
                    return IMSessionAntiHarassmentAlert.INSTANCE;
                }
                return null;
            }
        }
        z = false;
        if (!z) {
        }
    }

    public final IMSessionPageData append$session_debug(IMSessionPageData response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return copy$default(this, response.paginationParams, null, null, null, updateFrom(this.sessions, response.sessions), null, null, null, null, null, false, 2030, null);
    }

    public final IMSessionPageData update$session_debug(IMSessionPartialPage response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return copy$default(this, null, response.getUpdateSessionParams(), null, null, updateFrom(this.sessions, response.getItems()), null, null, null, null, null, false, 2029, null);
    }

    public final IMSessionPageData update$session_debug(IMSessionCard session) {
        Intrinsics.checkNotNullParameter(session, "session");
        return copy$default(this, null, null, null, null, IMSessionPageDataKt.uniqueAndSort(updateFrom(this.sessions, CollectionsKt.listOf(session))), null, null, null, null, null, false, 2031, null);
    }

    private final List<IMSessionCard> updateFrom(List<IMSessionCard> list, List<IMSessionCard> list2) {
        Object obj;
        IMSessionCard it;
        List<IMSessionCard> $this$map$iv = list2;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            IMSessionCard newCard = (IMSessionCard) item$iv$iv;
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (Intrinsics.areEqual(((IMSessionCard) obj).getId(), newCard.getId())) {
                    break;
                }
            }
            IMSessionCard it3 = (IMSessionCard) obj;
            if (it3 != null && (it = newCard.mergeFrom(it3)) != null) {
                newCard = it;
            }
            destination$iv$iv.add(newCard);
        }
        List updateList = (List) destination$iv$iv;
        return IMSessionPageDataKt.uniqueAndSort(CollectionsKt.plus(updateList, list));
    }

    public final IMSessionPageData delete$session_debug(IMSessionCard session) {
        Intrinsics.checkNotNullParameter(session, "session");
        List sessions = CollectionsKt.toMutableList(this.sessions);
        sessions.remove(session);
        return copy$default(this, null, null, null, null, sessions, null, null, null, null, null, false, 2031, null);
    }

    public final IMSessionPageData pinOrNot$session_debug(IMSessionCard session, PinResult result) {
        IMSessionCard iMSessionCard;
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(result, "result");
        Iterable $this$map$iv = this.sessions;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            IMSessionCard it = (IMSessionCard) item$iv$iv;
            if (Intrinsics.areEqual(it.getId(), session.getId())) {
                boolean nowPinned = result.getNowPinned();
                long newSequenceNumber = result.getNewSequenceNumber();
                KSessionOperation operation$session_debug = it.getOperation$session_debug();
                iMSessionCard = IMSessionCard.copy$default(it, null, null, null, null, null, nowPinned, newSequenceNumber, false, null, operation$session_debug != null ? IMSessionCardKt.updatePinState(operation$session_debug, result.getNowPinned()) : null, null, null, 3487, null);
            } else {
                iMSessionCard = it;
            }
            destination$iv$iv.add(iMSessionCard);
        }
        return copy$default(this, null, null, null, null, IMSessionPageDataKt.uniqueAndSort((List) destination$iv$iv), null, null, null, null, null, false, 2031, null);
    }

    public final IMSessionPageData mute$session_debug(KSessionId sessionID, boolean isMuted) {
        IMSessionCard iMSessionCard;
        Intrinsics.checkNotNullParameter(sessionID, "sessionID");
        Iterable $this$map$iv = this.sessions;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            IMSessionCard it = (IMSessionCard) item$iv$iv;
            if (Intrinsics.areEqual(it.getId(), sessionID)) {
                iMSessionCard = IMSessionCard.copy$default(it, null, null, null, null, null, false, 0L, isMuted, null, null, null, null, 3967, null);
            } else {
                iMSessionCard = it;
            }
            destination$iv$iv.add(iMSessionCard);
        }
        return copy$default(this, null, null, null, null, (List) destination$iv$iv, null, null, null, null, null, false, 2031, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0186  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0156 -> B:60:0x016f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object clearAllUnread$session_debug(IMSummaryCacheService summaryService, Continuation<? super IMSessionPageData> continuation) {
        IMSessionPageData$clearAllUnread$1 iMSessionPageData$clearAllUnread$1;
        IMQuickLink iMQuickLink;
        Iterable $this$map$iv;
        Iterable $this$mapTo$iv$iv;
        IMSessionPageData iMSessionPageData;
        IMQuickLink iMQuickLink2;
        Collection destination$iv$iv;
        Iterator it;
        KPaginationParams kPaginationParams;
        IMSessionFilterConfig iMSessionFilterConfig;
        KUpdateSessionParams kUpdateSessionParams;
        IMSummaryCacheService summaryService2;
        Object obj;
        Object $result;
        IMSessionPageData$clearAllUnread$1 iMSessionPageData$clearAllUnread$12;
        Continuation $continuation;
        int $i$f$mapTo;
        int $i$f$mapTo2;
        IMSessionFilterConfig iMSessionFilterConfig2;
        Iterator it2;
        KUpdateSessionParams kUpdateSessionParams2;
        Iterable $this$map$iv2;
        KPaginationParams kPaginationParams2;
        IMQuickLink iMQuickLink3;
        Object obj2;
        int $i$f$map;
        Collection collection;
        IMSessionPageData iMSessionPageData2;
        IMSessionPageData$clearAllUnread$1 iMSessionPageData$clearAllUnread$13;
        if (continuation instanceof IMSessionPageData$clearAllUnread$1) {
            iMSessionPageData$clearAllUnread$1 = (IMSessionPageData$clearAllUnread$1) continuation;
            if ((iMSessionPageData$clearAllUnread$1.label & Integer.MIN_VALUE) != 0) {
                iMSessionPageData$clearAllUnread$1.label -= Integer.MIN_VALUE;
                Object $result2 = iMSessionPageData$clearAllUnread$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionPageData$clearAllUnread$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        IMQuickLink iMQuickLink4 = this.quickLinks;
                        if (iMQuickLink4 != null) {
                            Iterable<IMQuickLinkItem> $this$map$iv3 = this.quickLinks.getItems();
                            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                            for (IMQuickLinkItem it3 : $this$map$iv3) {
                                destination$iv$iv2.add(IMQuickLinkItem.copy$default(it3, null, null, null, null, IMSessionPageDataKt.none(KUnread.Companion), null, 47, null));
                            }
                            iMQuickLink = IMQuickLink.copy$default(iMQuickLink4, (List) destination$iv$iv2, null, false, 6, null);
                        } else {
                            iMQuickLink = null;
                        }
                        $this$map$iv = this.sessions;
                        $this$mapTo$iv$iv = $this$map$iv;
                        iMSessionPageData = this;
                        iMQuickLink2 = iMQuickLink;
                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        it = $this$mapTo$iv$iv.iterator();
                        kPaginationParams = null;
                        iMSessionFilterConfig = null;
                        kUpdateSessionParams = null;
                        summaryService2 = summaryService;
                        obj = coroutine_suspended;
                        $result = $result2;
                        iMSessionPageData$clearAllUnread$12 = iMSessionPageData$clearAllUnread$1;
                        $continuation = continuation;
                        $i$f$mapTo = 0;
                        $i$f$mapTo2 = 0;
                        break;
                    case 1:
                        int i2 = iMSessionPageData$clearAllUnread$1.I$2;
                        $i$f$mapTo2 = iMSessionPageData$clearAllUnread$1.I$1;
                        int $i$f$map2 = iMSessionPageData$clearAllUnread$1.I$0;
                        collection = (Collection) iMSessionPageData$clearAllUnread$1.L$9;
                        IMSessionCard iMSessionCard = (IMSessionCard) iMSessionPageData$clearAllUnread$1.L$6;
                        Object obj3 = iMSessionPageData$clearAllUnread$1.L$5;
                        Collection destination$iv$iv3 = (Collection) iMSessionPageData$clearAllUnread$1.L$3;
                        $this$map$iv2 = (Iterable) iMSessionPageData$clearAllUnread$1.L$1;
                        summaryService2 = (IMSummaryCacheService) iMSessionPageData$clearAllUnread$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        iMSessionPageData$clearAllUnread$13 = iMSessionPageData$clearAllUnread$1;
                        it2 = (Iterator) iMSessionPageData$clearAllUnread$1.L$4;
                        kPaginationParams2 = null;
                        iMSessionFilterConfig2 = null;
                        kUpdateSessionParams2 = null;
                        $continuation = continuation;
                        iMSessionPageData2 = (IMSessionPageData) iMSessionPageData$clearAllUnread$1.L$7;
                        destination$iv$iv = destination$iv$iv3;
                        iMQuickLink3 = (IMQuickLink) iMSessionPageData$clearAllUnread$1.L$8;
                        $i$f$map = $i$f$map2;
                        $this$mapTo$iv$iv = (Iterable) iMSessionPageData$clearAllUnread$1.L$2;
                        obj2 = coroutine_suspended;
                        $result = $result2;
                        collection.add((IMSessionCard) $result2);
                        iMSessionPageData$clearAllUnread$12 = iMSessionPageData$clearAllUnread$13;
                        obj = obj2;
                        $i$f$mapTo = $i$f$map;
                        iMSessionPageData = iMSessionPageData2;
                        iMQuickLink2 = iMQuickLink3;
                        kPaginationParams = kPaginationParams2;
                        $this$map$iv = $this$map$iv2;
                        iMSessionFilterConfig = iMSessionFilterConfig2;
                        it = it2;
                        kUpdateSessionParams = kUpdateSessionParams2;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (it.hasNext()) {
                    Object item$iv$iv = it.next();
                    IMSessionCard it4 = (IMSessionCard) item$iv$iv;
                    Continuation $completion = $continuation;
                    iMSessionPageData$clearAllUnread$12.L$0 = summaryService2;
                    Object $result3 = $result;
                    iMSessionPageData$clearAllUnread$12.L$1 = SpillingKt.nullOutSpilledVariable($this$map$iv);
                    iMSessionPageData$clearAllUnread$12.L$2 = SpillingKt.nullOutSpilledVariable($this$mapTo$iv$iv);
                    iMSessionPageData$clearAllUnread$12.L$3 = destination$iv$iv;
                    iMSessionPageData$clearAllUnread$12.L$4 = it;
                    iMSessionPageData$clearAllUnread$12.L$5 = SpillingKt.nullOutSpilledVariable(item$iv$iv);
                    iMSessionPageData$clearAllUnread$12.L$6 = SpillingKt.nullOutSpilledVariable(it4);
                    iMSessionPageData$clearAllUnread$12.L$7 = iMSessionPageData;
                    iMSessionPageData$clearAllUnread$12.L$8 = iMQuickLink2;
                    iMSessionPageData$clearAllUnread$12.L$9 = destination$iv$iv;
                    iMSessionPageData$clearAllUnread$12.I$0 = $i$f$mapTo;
                    iMSessionPageData$clearAllUnread$12.I$1 = $i$f$mapTo2;
                    iMSessionPageData$clearAllUnread$12.I$2 = 0;
                    iMSessionPageData$clearAllUnread$12.label = 1;
                    Object markAsRead = summaryService2.markAsRead(it4, iMSessionPageData$clearAllUnread$12);
                    if (markAsRead == obj) {
                        return obj;
                    }
                    iMSessionFilterConfig2 = iMSessionFilterConfig;
                    it2 = it;
                    kUpdateSessionParams2 = kUpdateSessionParams;
                    $this$map$iv2 = $this$map$iv;
                    kPaginationParams2 = kPaginationParams;
                    iMQuickLink3 = iMQuickLink2;
                    obj2 = obj;
                    $i$f$map = $i$f$mapTo;
                    collection = destination$iv$iv;
                    iMSessionPageData2 = iMSessionPageData;
                    iMSessionPageData$clearAllUnread$13 = iMSessionPageData$clearAllUnread$12;
                    $result2 = markAsRead;
                    $continuation = $completion;
                    $result = $result3;
                    collection.add((IMSessionCard) $result2);
                    iMSessionPageData$clearAllUnread$12 = iMSessionPageData$clearAllUnread$13;
                    obj = obj2;
                    $i$f$mapTo = $i$f$map;
                    iMSessionPageData = iMSessionPageData2;
                    iMQuickLink2 = iMQuickLink3;
                    kPaginationParams = kPaginationParams2;
                    $this$map$iv = $this$map$iv2;
                    iMSessionFilterConfig = iMSessionFilterConfig2;
                    it = it2;
                    kUpdateSessionParams = kUpdateSessionParams2;
                    if (it.hasNext()) {
                        return copy$default(iMSessionPageData, kPaginationParams, kUpdateSessionParams, iMQuickLink2, iMSessionFilterConfig, IMSessionPageDataKt.uniqueAndSort((List) destination$iv$iv), null, null, null, null, null, false, 2027, null);
                    }
                }
            }
        }
        iMSessionPageData$clearAllUnread$1 = new IMSessionPageData$clearAllUnread$1(this, continuation);
        Object $result22 = iMSessionPageData$clearAllUnread$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionPageData$clearAllUnread$1.label) {
        }
        if (it.hasNext()) {
        }
    }

    public final IMSessionPageData clearQuickLinkUnread$session_debug(IMQuickLinkItem item) {
        IMQuickLink iMQuickLink;
        IMQuickLinkItem iMQuickLinkItem;
        Intrinsics.checkNotNullParameter(item, "item");
        IMQuickLink iMQuickLink2 = this.quickLinks;
        if (iMQuickLink2 != null) {
            Iterable $this$map$iv = this.quickLinks.getItems();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                IMQuickLinkItem it = (IMQuickLinkItem) item$iv$iv;
                if (Intrinsics.areEqual(item, it)) {
                    iMQuickLinkItem = IMQuickLinkItem.copy$default(it, null, null, null, null, IMSessionPageDataKt.none(KUnread.Companion), null, 47, null);
                } else {
                    iMQuickLinkItem = it;
                }
                destination$iv$iv.add(iMQuickLinkItem);
            }
            iMQuickLink = IMQuickLink.copy$default(iMQuickLink2, (List) destination$iv$iv, null, false, 6, null);
        } else {
            iMQuickLink = null;
        }
        return copy$default(this, null, null, iMQuickLink, null, null, null, null, null, null, null, false, 2043, null);
    }

    public final IMSessionPageData changeFilter$session_debug(KSessionFilterType filterType) {
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        Iterable $this$map$iv = this.filters;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            IMSessionFilter it = (IMSessionFilter) item$iv$iv;
            destination$iv$iv.add(IMSessionFilter.copy$default(it, null, null, Intrinsics.areEqual(filterType, it.getType()), 3, null));
        }
        List newFilters = (List) destination$iv$iv;
        return copy$default(this, null, null, null, null, CollectionsKt.emptyList(), null, null, null, null, newFilters, false, 1516, null);
    }

    public final IMSessionPageData updateQuickLinkUnread$session_debug(KGetQuickLinkUnreadReply response) {
        Intrinsics.checkNotNullParameter(response, "response");
        IMQuickLink iMQuickLink = this.quickLinks;
        return copy$default(this, null, null, iMQuickLink != null ? IMSessionPageDataKt.updateUnread(iMQuickLink, response) : null, null, null, null, null, null, null, null, false, 2043, null);
    }

    public final IMSessionPageData updateSummary$session_debug(KSessionId sessionID, Summary newSummary) {
        IMSessionCard iMSessionCard;
        Intrinsics.checkNotNullParameter(sessionID, "sessionID");
        Iterable $this$map$iv = this.sessions;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            IMSessionCard it = (IMSessionCard) item$iv$iv;
            if (Intrinsics.areEqual(it.getId(), sessionID)) {
                iMSessionCard = IMSessionCard.copy$default(it, null, null, null, null, null, false, 0L, false, null, null, null, newSummary, 2047, null);
            } else {
                iMSessionCard = it;
            }
            destination$iv$iv.add(iMSessionCard);
        }
        return copy$default(this, null, null, null, null, (List) destination$iv$iv, null, null, null, null, null, false, 2031, null);
    }

    public final IMSessionPageData clearRedDot$session_debug(IMThreeDotItem threeDotItem) {
        Intrinsics.checkNotNullParameter(threeDotItem, "threeDotItem");
        Iterable $this$map$iv = this.outsideActions;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            IMThreeDotItem it = (IMThreeDotItem) item$iv$iv;
            if (Intrinsics.areEqual(it.getType(), threeDotItem.getType())) {
                it = IMThreeDotItem.copy$default(it, null, null, null, null, false, true, 31, null);
            }
            destination$iv$iv.add(it);
        }
        List newOutsideActions = (List) destination$iv$iv;
        Iterable $this$map$iv2 = this.threeDots;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            IMThreeDotItem it2 = (IMThreeDotItem) item$iv$iv2;
            if (Intrinsics.areEqual(it2.getType(), threeDotItem.getType())) {
                it2 = IMThreeDotItem.copy$default(it2, null, null, null, null, false, true, 31, null);
            }
            destination$iv$iv2.add(it2);
        }
        List newThreeDots = (List) destination$iv$iv2;
        if (Intrinsics.areEqual(threeDotItem.getType(), KThreeDotItemType.THREE_DOT_ITEM_TYPE_CONTRIBUTION_PUSH.INSTANCE)) {
            new ThreeDotPreference().setHasVisitPushMsg(true);
        }
        return copy$default(this, null, null, null, null, null, newThreeDots, newOutsideActions, null, null, null, false, 1951, null);
    }
}