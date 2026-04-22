package kntr.app.im.chat.core.model;

import BottomSheetItemData$;
import com.bilibili.blens.Lens;
import kntr.app.im.chat.core.RequestStatus;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatPageData.kt */
@Lens
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Lkntr/app/im/chat/core/model/PageStatus;", RoomRecommendViewModel.EMPTY_CURSOR, "initialized", RoomRecommendViewModel.EMPTY_CURSOR, "chatInfo", "Lkntr/app/im/chat/core/RequestStatus;", "earlierMessages", "laterMessages", "<init>", "(ZLkntr/app/im/chat/core/RequestStatus;Lkntr/app/im/chat/core/RequestStatus;Lkntr/app/im/chat/core/RequestStatus;)V", "getInitialized", "()Z", "getChatInfo", "()Lkntr/app/im/chat/core/RequestStatus;", "getEarlierMessages", "getLaterMessages", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PageStatus {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final RequestStatus chatInfo;
    private final RequestStatus earlierMessages;
    private final boolean initialized;
    private final RequestStatus laterMessages;

    public PageStatus() {
        this(false, null, null, null, 15, null);
    }

    public static /* synthetic */ PageStatus copy$default(PageStatus pageStatus, boolean z, RequestStatus requestStatus, RequestStatus requestStatus2, RequestStatus requestStatus3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = pageStatus.initialized;
        }
        if ((i & 2) != 0) {
            requestStatus = pageStatus.chatInfo;
        }
        if ((i & 4) != 0) {
            requestStatus2 = pageStatus.earlierMessages;
        }
        if ((i & 8) != 0) {
            requestStatus3 = pageStatus.laterMessages;
        }
        return pageStatus.copy(z, requestStatus, requestStatus2, requestStatus3);
    }

    public final boolean component1() {
        return this.initialized;
    }

    public final RequestStatus component2() {
        return this.chatInfo;
    }

    public final RequestStatus component3() {
        return this.earlierMessages;
    }

    public final RequestStatus component4() {
        return this.laterMessages;
    }

    public final PageStatus copy(boolean z, RequestStatus requestStatus, RequestStatus requestStatus2, RequestStatus requestStatus3) {
        Intrinsics.checkNotNullParameter(requestStatus, "chatInfo");
        Intrinsics.checkNotNullParameter(requestStatus2, "earlierMessages");
        Intrinsics.checkNotNullParameter(requestStatus3, "laterMessages");
        return new PageStatus(z, requestStatus, requestStatus2, requestStatus3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PageStatus) {
            PageStatus pageStatus = (PageStatus) obj;
            return this.initialized == pageStatus.initialized && Intrinsics.areEqual(this.chatInfo, pageStatus.chatInfo) && Intrinsics.areEqual(this.earlierMessages, pageStatus.earlierMessages) && Intrinsics.areEqual(this.laterMessages, pageStatus.laterMessages);
        }
        return false;
    }

    public int hashCode() {
        return (((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.initialized) * 31) + this.chatInfo.hashCode()) * 31) + this.earlierMessages.hashCode()) * 31) + this.laterMessages.hashCode();
    }

    public String toString() {
        boolean z = this.initialized;
        RequestStatus requestStatus = this.chatInfo;
        RequestStatus requestStatus2 = this.earlierMessages;
        return "PageStatus(initialized=" + z + ", chatInfo=" + requestStatus + ", earlierMessages=" + requestStatus2 + ", laterMessages=" + this.laterMessages + ")";
    }

    public PageStatus(boolean initialized, RequestStatus chatInfo, RequestStatus earlierMessages, RequestStatus laterMessages) {
        Intrinsics.checkNotNullParameter(chatInfo, "chatInfo");
        Intrinsics.checkNotNullParameter(earlierMessages, "earlierMessages");
        Intrinsics.checkNotNullParameter(laterMessages, "laterMessages");
        this.initialized = initialized;
        this.chatInfo = chatInfo;
        this.earlierMessages = earlierMessages;
        this.laterMessages = laterMessages;
    }

    public /* synthetic */ PageStatus(boolean z, RequestStatus.Idle idle, RequestStatus.Idle idle2, RequestStatus.Idle idle3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? RequestStatus.Idle.INSTANCE : idle, (i & 4) != 0 ? RequestStatus.Idle.INSTANCE : idle2, (i & 8) != 0 ? RequestStatus.Idle.INSTANCE : idle3);
    }

    public final boolean getInitialized() {
        return this.initialized;
    }

    public final RequestStatus getChatInfo() {
        return this.chatInfo;
    }

    public final RequestStatus getEarlierMessages() {
        return this.earlierMessages;
    }

    public final RequestStatus getLaterMessages() {
        return this.laterMessages;
    }

    /* compiled from: ChatPageData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/im/chat/core/model/PageStatus$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}