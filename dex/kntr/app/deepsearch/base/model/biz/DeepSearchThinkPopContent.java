package kntr.app.deepsearch.base.model.biz;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.broadcast.message.deepsearch.KThinking;
import com.bilibili.blens.Lens;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchThinkPopContent.kt */
@Lens
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0001#BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchThinkPopContent;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "thinkStatus", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KThinking$KStatus;", "windowTitle", "content", "timestamp", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bapis/bilibili/broadcast/message/deepsearch/KThinking$KStatus;Ljava/lang/String;Ljava/lang/String;J)V", "getSessionId", "()Ljava/lang/String;", "getQueryId", "getThinkStatus", "()Lcom/bapis/bilibili/broadcast/message/deepsearch/KThinking$KStatus;", "getWindowTitle", "getContent", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchThinkPopContent {
    public static final Companion Companion = new Companion(null);
    private final String content;
    private final String queryId;
    private final String sessionId;
    private final KThinking.KStatus thinkStatus;
    private final long timestamp;
    private final String windowTitle;

    public DeepSearchThinkPopContent() {
        this(null, null, null, null, null, 0L, 63, null);
    }

    public static /* synthetic */ DeepSearchThinkPopContent copy$default(DeepSearchThinkPopContent deepSearchThinkPopContent, String str, String str2, KThinking.KStatus kStatus, String str3, String str4, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deepSearchThinkPopContent.sessionId;
        }
        if ((i & 2) != 0) {
            str2 = deepSearchThinkPopContent.queryId;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            kStatus = deepSearchThinkPopContent.thinkStatus;
        }
        KThinking.KStatus kStatus2 = kStatus;
        if ((i & 8) != 0) {
            str3 = deepSearchThinkPopContent.windowTitle;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = deepSearchThinkPopContent.content;
        }
        String str7 = str4;
        if ((i & 32) != 0) {
            j2 = deepSearchThinkPopContent.timestamp;
        }
        return deepSearchThinkPopContent.copy(str, str5, kStatus2, str6, str7, j2);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final String component2() {
        return this.queryId;
    }

    public final KThinking.KStatus component3() {
        return this.thinkStatus;
    }

    public final String component4() {
        return this.windowTitle;
    }

    public final String component5() {
        return this.content;
    }

    public final long component6() {
        return this.timestamp;
    }

    public final DeepSearchThinkPopContent copy(String str, String str2, KThinking.KStatus kStatus, String str3, String str4, long j2) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(str2, "queryId");
        Intrinsics.checkNotNullParameter(kStatus, "thinkStatus");
        Intrinsics.checkNotNullParameter(str3, "windowTitle");
        Intrinsics.checkNotNullParameter(str4, "content");
        return new DeepSearchThinkPopContent(str, str2, kStatus, str3, str4, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeepSearchThinkPopContent) {
            DeepSearchThinkPopContent deepSearchThinkPopContent = (DeepSearchThinkPopContent) obj;
            return Intrinsics.areEqual(this.sessionId, deepSearchThinkPopContent.sessionId) && Intrinsics.areEqual(this.queryId, deepSearchThinkPopContent.queryId) && Intrinsics.areEqual(this.thinkStatus, deepSearchThinkPopContent.thinkStatus) && Intrinsics.areEqual(this.windowTitle, deepSearchThinkPopContent.windowTitle) && Intrinsics.areEqual(this.content, deepSearchThinkPopContent.content) && this.timestamp == deepSearchThinkPopContent.timestamp;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.sessionId.hashCode() * 31) + this.queryId.hashCode()) * 31) + this.thinkStatus.hashCode()) * 31) + this.windowTitle.hashCode()) * 31) + this.content.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.timestamp);
    }

    public String toString() {
        String str = this.sessionId;
        String str2 = this.queryId;
        KThinking.KStatus kStatus = this.thinkStatus;
        String str3 = this.windowTitle;
        String str4 = this.content;
        return "DeepSearchThinkPopContent(sessionId=" + str + ", queryId=" + str2 + ", thinkStatus=" + kStatus + ", windowTitle=" + str3 + ", content=" + str4 + ", timestamp=" + this.timestamp + ")";
    }

    public DeepSearchThinkPopContent(String sessionId, String queryId, KThinking.KStatus thinkStatus, String windowTitle, String content, long timestamp) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        Intrinsics.checkNotNullParameter(thinkStatus, "thinkStatus");
        Intrinsics.checkNotNullParameter(windowTitle, "windowTitle");
        Intrinsics.checkNotNullParameter(content, "content");
        this.sessionId = sessionId;
        this.queryId = queryId;
        this.thinkStatus = thinkStatus;
        this.windowTitle = windowTitle;
        this.content = content;
        this.timestamp = timestamp;
    }

    public /* synthetic */ DeepSearchThinkPopContent(String str, String str2, KThinking.KStatus kStatus, String str3, String str4, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i & 4) != 0 ? (KThinking.KStatus) KThinking.KStatus.INVALID.INSTANCE : kStatus, (i & 8) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i & 16) == 0 ? str4 : RoomRecommendViewModel.EMPTY_CURSOR, (i & 32) != 0 ? 0L : j2);
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getQueryId() {
        return this.queryId;
    }

    public final KThinking.KStatus getThinkStatus() {
        return this.thinkStatus;
    }

    public final String getWindowTitle() {
        return this.windowTitle;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    /* compiled from: DeepSearchThinkPopContent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchThinkPopContent$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}