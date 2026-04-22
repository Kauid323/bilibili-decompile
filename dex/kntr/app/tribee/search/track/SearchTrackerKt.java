package kntr.app.tribee.search.track;

import com.bapis.bilibili.app.dynamic.v2.KTraceParam;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.KNeuron;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SearchTracker.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n\u001a2\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n\u001a\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001\u001a\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001\u001a\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001\u001a\u001e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001\u001a\u001e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001\u001a\u001e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001\u001aJ\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u001aJ\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"SEARCH_DISCOVER_SPMID", "", "SEARCH_DISCOVER_PV", "SEARCH_RESULT_PV", "SEARCH_CARD_SPMID", "searchDiscoverHistoryExposure", "", "tribeeId", "query", "pagePos", "", "modulePos", "searchDiscoverHistoryClick", "clickArea", "searchDiscoverBackClick", "searchDiscoverSearchClick", "searchDiscoverMainSearchClick", "searchResultSearchClick", "trackId", "searchResultBackClick", "searchResultMainSearchClick", "searchResultCardExposure", "spmid", "pageNum", "isShouping", "", "traceParams", "Lcom/bapis/bilibili/app/dynamic/v2/KTraceParam;", "searchResultCardClick", "search_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SearchTrackerKt {
    public static final String SEARCH_CARD_SPMID = "tribee.search-result.search-card.0";
    public static final String SEARCH_DISCOVER_PV = "tribee.search-discover.0.0.pv";
    public static final String SEARCH_DISCOVER_SPMID = "tribee.search-discover.0.0";
    public static final String SEARCH_RESULT_PV = "tribee.search-result.0.0.pv";

    public static /* synthetic */ void searchDiscoverHistoryExposure$default(String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 1;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        searchDiscoverHistoryExposure(str, str2, i, i2);
    }

    public static final void searchDiscoverHistoryExposure(String tribeeId, String query, int pagePos, int modulePos) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(query, "query");
        KNeuron.INSTANCE.reportExposure(false, "tribee.search-discover.search-history.all.show", MapsKt.mapOf(new Pair[]{TuplesKt.to("tribee_id", tribeeId), TuplesKt.to("query", query), TuplesKt.to("page_pos", String.valueOf(pagePos)), TuplesKt.to("module_pos", String.valueOf(modulePos))}));
    }

    public static /* synthetic */ void searchDiscoverHistoryClick$default(String str, String str2, String str3, int i, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i = 1;
        }
        if ((i3 & 16) != 0) {
            i2 = 0;
        }
        searchDiscoverHistoryClick(str, str2, str3, i, i2);
    }

    public static final void searchDiscoverHistoryClick(String tribeeId, String query, String clickArea, int pagePos, int modulePos) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(clickArea, "clickArea");
        KNeuron.INSTANCE.reportClick(false, "tribee.search-discover.search-history.all.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("tribee_id", tribeeId), TuplesKt.to("query", query), TuplesKt.to("page_pos", String.valueOf(pagePos)), TuplesKt.to("module_pos", String.valueOf(modulePos)), TuplesKt.to("click_area", clickArea)}));
    }

    public static final void searchDiscoverBackClick(String tribeeId, String query) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(query, "query");
        KNeuron.INSTANCE.reportClick(false, "tribee.search-discover.button-back.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("tribee_id", tribeeId), TuplesKt.to("query", query)}));
    }

    public static final void searchDiscoverSearchClick(String tribeeId, String query) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(query, "query");
        KNeuron.INSTANCE.reportClick(false, "tribee.search-discover.search.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("tribee_id", tribeeId), TuplesKt.to("query", query)}));
    }

    public static final void searchDiscoverMainSearchClick(String tribeeId, String query) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(query, "query");
        KNeuron.INSTANCE.reportClick(false, "tribee.search-discover.main-search.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("tribee_id", tribeeId), TuplesKt.to("query", query)}));
    }

    public static final void searchResultSearchClick(String tribeeId, String query, String trackId) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(trackId, "trackId");
        KNeuron.INSTANCE.reportClick(false, "tribee.search-result.search.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("tribee_id", tribeeId), TuplesKt.to("query", query), TuplesKt.to("track_id", trackId)}));
    }

    public static final void searchResultBackClick(String tribeeId, String query, String trackId) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(trackId, "trackId");
        KNeuron.INSTANCE.reportClick(false, "tribee.search-result.button-back.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("tribee_id", tribeeId), TuplesKt.to("query", query), TuplesKt.to("track_id", trackId)}));
    }

    public static final void searchResultMainSearchClick(String tribeeId, String query, String trackId) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(trackId, "trackId");
        KNeuron.INSTANCE.reportClick(false, "tribee.search-result.main-search.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("tribee_id", tribeeId), TuplesKt.to("query", query), TuplesKt.to("track_id", trackId)}));
    }

    public static /* synthetic */ void searchResultCardExposure$default(String str, String str2, String str3, String str4, int i, int i2, boolean z, KTraceParam kTraceParam, int i3, Object obj) {
        String str5;
        if ((i3 & 8) == 0) {
            str5 = str4;
        } else {
            str5 = SEARCH_CARD_SPMID;
        }
        searchResultCardExposure(str, str2, str3, str5, i, i2, z, kTraceParam);
    }

    public static final void searchResultCardExposure(String tribeeId, String query, String trackId, String spmid, int pageNum, int pagePos, boolean isShouping, KTraceParam traceParams) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(trackId, "trackId");
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        KNeuron kNeuron = KNeuron.INSTANCE;
        Pair[] pairArr = new Pair[10];
        pairArr[0] = TuplesKt.to("tribee_id", tribeeId);
        pairArr[1] = TuplesKt.to("query", query);
        pairArr[2] = TuplesKt.to("track_id", trackId);
        pairArr[3] = TuplesKt.to("spmid", spmid);
        pairArr[4] = TuplesKt.to("page_num", String.valueOf(pageNum));
        pairArr[5] = TuplesKt.to("page_pos", String.valueOf(pagePos));
        pairArr[6] = TuplesKt.to("is_shouping", isShouping ? "1" : "0");
        pairArr[7] = TuplesKt.to("module_type", String.valueOf(traceParams != null ? Long.valueOf(traceParams.getModuleType()) : null));
        pairArr[8] = TuplesKt.to("module_id", String.valueOf(traceParams != null ? Long.valueOf(traceParams.getModuleId()) : null));
        pairArr[9] = TuplesKt.to("qv_id", trackId);
        kNeuron.reportExposure(false, "tribee.search-result.search-card.all.show", MapsKt.mapOf(pairArr));
    }

    public static /* synthetic */ void searchResultCardClick$default(String str, String str2, String str3, String str4, int i, int i2, boolean z, KTraceParam kTraceParam, int i3, Object obj) {
        String str5;
        if ((i3 & 8) == 0) {
            str5 = str4;
        } else {
            str5 = SEARCH_CARD_SPMID;
        }
        searchResultCardClick(str, str2, str3, str5, i, i2, z, kTraceParam);
    }

    public static final void searchResultCardClick(String tribeeId, String query, String trackId, String spmid, int pageNum, int pagePos, boolean isShouping, KTraceParam traceParams) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(trackId, "trackId");
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        KNeuron kNeuron = KNeuron.INSTANCE;
        Pair[] pairArr = new Pair[10];
        pairArr[0] = TuplesKt.to("tribee_id", tribeeId);
        pairArr[1] = TuplesKt.to("query", query);
        pairArr[2] = TuplesKt.to("track_id", trackId);
        pairArr[3] = TuplesKt.to("spmid", spmid);
        pairArr[4] = TuplesKt.to("page_num", String.valueOf(pageNum));
        pairArr[5] = TuplesKt.to("page_pos", String.valueOf(pagePos));
        pairArr[6] = TuplesKt.to("is_shouping", isShouping ? "1" : "0");
        pairArr[7] = TuplesKt.to("module_type", String.valueOf(traceParams != null ? Long.valueOf(traceParams.getModuleType()) : null));
        pairArr[8] = TuplesKt.to("module_id", String.valueOf(traceParams != null ? Long.valueOf(traceParams.getModuleId()) : null));
        pairArr[9] = TuplesKt.to("qv_id", trackId);
        kNeuron.reportClick(false, "tribee.search-result.search-card.all.click", MapsKt.mapOf(pairArr));
    }
}