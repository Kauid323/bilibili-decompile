package tv.danmaku.bili.ui.splash.common.search;

import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: QueryItem.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006!"}, d2 = {"Ltv/danmaku/bili/ui/splash/common/search/QueryItem;", "", "id", "", "query", "", "sTime", "eTime", "<init>", "(JLjava/lang/String;JJ)V", "getId", "()J", "setId", "(J)V", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "getSTime", "setSTime", "getETime", "setETime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class QueryItem {
    public static final int $stable = 8;
    @SerializedName("etime")
    private long eTime;
    @SerializedName("id")
    private long id;
    @SerializedName("query")
    private String query;
    @SerializedName("stime")
    private long sTime;

    public QueryItem() {
        this(0L, null, 0L, 0L, 15, null);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.query;
    }

    public final long component3() {
        return this.sTime;
    }

    public final long component4() {
        return this.eTime;
    }

    public final QueryItem copy(long j, String str, long j2, long j3) {
        return new QueryItem(j, str, j2, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QueryItem) {
            QueryItem queryItem = (QueryItem) obj;
            return this.id == queryItem.id && Intrinsics.areEqual(this.query, queryItem.query) && this.sTime == queryItem.sTime && this.eTime == queryItem.eTime;
        }
        return false;
    }

    public int hashCode() {
        return (((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + (this.query == null ? 0 : this.query.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.sTime)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.eTime);
    }

    public String toString() {
        long j = this.id;
        String str = this.query;
        long j2 = this.sTime;
        return "QueryItem(id=" + j + ", query=" + str + ", sTime=" + j2 + ", eTime=" + this.eTime + ")";
    }

    public QueryItem(long id, String query, long sTime, long eTime) {
        this.id = id;
        this.query = query;
        this.sTime = sTime;
        this.eTime = eTime;
    }

    public /* synthetic */ QueryItem(long j, String str, long j2, long j3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? 0L : j2, (i & 8) != 0 ? 0L : j3);
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final String getQuery() {
        return this.query;
    }

    public final void setQuery(String str) {
        this.query = str;
    }

    public final long getSTime() {
        return this.sTime;
    }

    public final void setSTime(long j) {
        this.sTime = j;
    }

    public final long getETime() {
        return this.eTime;
    }

    public final void setETime(long j) {
        this.eTime = j;
    }
}