package kntr.app.deepsearch.base.model.biz;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.blens.Lens;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchSessionEndModel.kt */
@Lens
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\f¨\u0006!"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchSessionEndModel;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "query", "queryId", "timestamp", RoomRecommendViewModel.EMPTY_CURSOR, "timeString", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "getQuery", "getQueryId", "getTimestamp", "()J", "getTimeString$annotations", "()V", "getTimeString", "component1", "component2", "component3", "component4", "component5", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchSessionEndModel {
    public static final Companion Companion = new Companion(null);
    private final String query;
    private final String queryId;
    private final String sessionId;
    private final String timeString;
    private final long timestamp;

    public DeepSearchSessionEndModel() {
        this(null, null, null, 0L, null, 31, null);
    }

    public static /* synthetic */ DeepSearchSessionEndModel copy$default(DeepSearchSessionEndModel deepSearchSessionEndModel, String str, String str2, String str3, long j2, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deepSearchSessionEndModel.sessionId;
        }
        if ((i & 2) != 0) {
            str2 = deepSearchSessionEndModel.query;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = deepSearchSessionEndModel.queryId;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            j2 = deepSearchSessionEndModel.timestamp;
        }
        long j3 = j2;
        if ((i & 16) != 0) {
            str4 = deepSearchSessionEndModel.timeString;
        }
        return deepSearchSessionEndModel.copy(str, str5, str6, j3, str4);
    }

    public static /* synthetic */ void getTimeString$annotations() {
    }

    public final String component1() {
        return this.sessionId;
    }

    public final String component2() {
        return this.query;
    }

    public final String component3() {
        return this.queryId;
    }

    public final long component4() {
        return this.timestamp;
    }

    public final String component5() {
        return this.timeString;
    }

    public final DeepSearchSessionEndModel copy(String str, String str2, String str3, long j2, String str4) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(str2, "query");
        Intrinsics.checkNotNullParameter(str3, "queryId");
        Intrinsics.checkNotNullParameter(str4, "timeString");
        return new DeepSearchSessionEndModel(str, str2, str3, j2, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeepSearchSessionEndModel) {
            DeepSearchSessionEndModel deepSearchSessionEndModel = (DeepSearchSessionEndModel) obj;
            return Intrinsics.areEqual(this.sessionId, deepSearchSessionEndModel.sessionId) && Intrinsics.areEqual(this.query, deepSearchSessionEndModel.query) && Intrinsics.areEqual(this.queryId, deepSearchSessionEndModel.queryId) && this.timestamp == deepSearchSessionEndModel.timestamp && Intrinsics.areEqual(this.timeString, deepSearchSessionEndModel.timeString);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.sessionId.hashCode() * 31) + this.query.hashCode()) * 31) + this.queryId.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.timestamp)) * 31) + this.timeString.hashCode();
    }

    public String toString() {
        String str = this.sessionId;
        String str2 = this.query;
        String str3 = this.queryId;
        long j2 = this.timestamp;
        return "DeepSearchSessionEndModel(sessionId=" + str + ", query=" + str2 + ", queryId=" + str3 + ", timestamp=" + j2 + ", timeString=" + this.timeString + ")";
    }

    public DeepSearchSessionEndModel(String sessionId, String query, String queryId, long timestamp, String timeString) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        Intrinsics.checkNotNullParameter(timeString, "timeString");
        this.sessionId = sessionId;
        this.query = query;
        this.queryId = queryId;
        this.timestamp = timestamp;
        this.timeString = timeString;
    }

    public /* synthetic */ DeepSearchSessionEndModel(String str, String str2, String str3, long j2, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i & 8) != 0 ? 0L : j2, (i & 16) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str4);
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getQueryId() {
        return this.queryId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getTimeString() {
        return this.timeString;
    }

    /* compiled from: DeepSearchSessionEndModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchSessionEndModel$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}