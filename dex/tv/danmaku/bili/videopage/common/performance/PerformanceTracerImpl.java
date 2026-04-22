package tv.danmaku.bili.videopage.common.performance;

import android.os.Handler;
import android.os.SystemClock;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.performance.BootOpt;
import com.bilibili.lib.performance.Scene;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.bili.videopage.common.BuildConfig;
import tv.danmaku.bili.videopage.common.callback.ShareIconObserverKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PerformanceTracerImpl.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\rH\u0002J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0018\u001a\u00020\u0010J\u0006\u0010\u0019\u001a\u00020\u0010J\u0006\u0010\u001a\u001a\u00020\u0010J\u0006\u0010\u001b\u001a\u00020\u0010J\u0006\u0010\u001c\u001a\u00020\u0010J\u0006\u0010\u001d\u001a\u00020\u0010J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Ltv/danmaku/bili/videopage/common/performance/PerformanceTracerImpl;", "", "mName", "", "<init>", "(Ljava/lang/String;)V", "mExtras", "Lcom/alibaba/fastjson/JSONObject;", "mMaxCount", "", "mWatchDog", "Ltv/danmaku/bili/videopage/common/performance/WatchDog;", "mIsCanceled", "", "mHasReportedImageShow", "start", "", "shouldTracingTime", "split", "entry", "Ltv/danmaku/bili/videopage/common/performance/PerformanceTracerImpl$Entry;", "splitInternal", "splitAndEnd", "splitOrEnd", ShareIconObserverKt.SHARE_FROM_END, "reset", "dump", "report", SplashCustomReporterKt.STATE_CANCEL, "traceImageLoading", "addExtra", "key", "value", "Companion", "Entry", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PerformanceTracerImpl {
    public static final String CLIENT_MULTI = "multi_page";
    public static final String CLIENT_UGC = "ugc_page";
    public static final String CLIENT_UNITED = "united_page";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "PerformanceTracerImpl";
    private final JSONObject mExtras;
    private boolean mHasReportedImageShow;
    private boolean mIsCanceled;
    private int mMaxCount;
    private final String mName;
    private WatchDog mWatchDog;

    /* compiled from: PerformanceTracerImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/videopage/common/performance/PerformanceTracerImpl$Companion;", "", "<init>", "()V", "CLIENT_UNITED", "", "CLIENT_UGC", "CLIENT_MULTI", "TAG", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PerformanceTracerImpl(String mName) {
        Intrinsics.checkNotNullParameter(mName, "mName");
        this.mName = mName;
        this.mExtras = new JSONObject();
    }

    /* compiled from: PerformanceTracerImpl.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b)\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u00100\u001a\u00020\u00002\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010/J\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010/J\u000e\u00103\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-¨\u00064"}, d2 = {"Ltv/danmaku/bili/videopage/common/performance/PerformanceTracerImpl$Entry;", "", "name", "", "timestamp", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;J)V", "getTimestamp", "()J", "setTimestamp", "(J)V", "ON_CREATE", "ON_RESUME", "ON_VIEW_CREATED", "ON_VIEW_TREE_LAYOUT", "ON_PLAYER_CLICK", "ON_PLAYER_PREPARED", "ON_PLAYER_FIRST_FRAME", "ON_DETAIL_DATA", "ON_DETAIL_IMAGE_BIND", "ON_START_BUSINESS_SERVICES", "ON_RESOLVE_PLAY_URL_FIRE", "ON_START_RESOLVE_PLAY_URL", "ON_END_RESOLVE_PLAY_URL", "ON_SET_MEDIA_ITEM", "ON_THESEUS_PAGE_COMPONENT_CREATED", "ON_THESEUS_PAGE_PLAYER_CONTAINER_CREATED", "ON_THESEUS_PAGE_PAGE_ANCHOR_CREATED", "ON_THESEUS_PAGE_DETAIL_VIEW_API_STARTED", "ON_THESEUS_PAGE_DETAIL_DATA_DISPATCHED", "ON_EXTRA_BIZ_END", "ON_PLAYER_CORE_START_CREATE", "ON_PLAYER_CORE_END_CREATE", "ON_COMMON_SERVICES_START_LAUNCH", "ON_COMMON_SERVICES_END_LAUNCH", "ON_EMPTY_PAGE_START_LOAD", "ON_EMPTY_PAGE_END_LOAD", "ON_MEDIALIST_API_START", "ON_MEDIALIST_API_END", "ON_MEDIALIST_INFO_API_START", "ON_MEDIALIST_INFO_API_END", "ON_UGC_PAGE_START_LOAD", "ON_UGC_PAGE_END_LOAD", "ON_START_LAUNCH_UGC_SERVICES", "ON_END_LAUNCH_UGC_SERVICES", "mExtras", "", "setExtras", "extras", "getExtras", "attach", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum Entry {
        ON_CREATE("on_create", 0, 2, null),
        ON_RESUME("on_resume", 0, 2, null),
        ON_VIEW_CREATED("on_view_created", 0, 2, null),
        ON_VIEW_TREE_LAYOUT("on_view_tree_layout", 0, 2, null),
        ON_PLAYER_CLICK("on_player_click", 0, 2, null),
        ON_PLAYER_PREPARED("on_player_prepared", 0, 2, null),
        ON_PLAYER_FIRST_FRAME("on_player_first_frame", 0, 2, null),
        ON_DETAIL_DATA("on_detail_data", 0, 2, null),
        ON_DETAIL_IMAGE_BIND("on_detail_image_bind", 0, 2, null),
        ON_START_BUSINESS_SERVICES("on_start_business_services", 0, 2, null),
        ON_RESOLVE_PLAY_URL_FIRE("on_resolve_play_url_fire", 0, 2, null),
        ON_START_RESOLVE_PLAY_URL("on_start_resolve_play_url", 0, 2, null),
        ON_END_RESOLVE_PLAY_URL("on_end_resolve_play_url", 0, 2, null),
        ON_SET_MEDIA_ITEM("on_set_media_item", 0, 2, null),
        ON_THESEUS_PAGE_COMPONENT_CREATED("on_theseus_page_component_created", 0, 2, null),
        ON_THESEUS_PAGE_PLAYER_CONTAINER_CREATED("on_theseus_page_play_container_created", 0, 2, null),
        ON_THESEUS_PAGE_PAGE_ANCHOR_CREATED("on_theseus_page_play_container_created", 0, 2, null),
        ON_THESEUS_PAGE_DETAIL_VIEW_API_STARTED("on_theseus_page_detail_view_api_started", 0, 2, null),
        ON_THESEUS_PAGE_DETAIL_DATA_DISPATCHED("on_theseus_page_detail_data_dispatched", 0, 2, null),
        ON_EXTRA_BIZ_END("on_extra_biz_end", 0, 2, null),
        ON_PLAYER_CORE_START_CREATE("on_playercore_start_create", 0, 2, null),
        ON_PLAYER_CORE_END_CREATE("on_playercore_end_create", 0, 2, null),
        ON_COMMON_SERVICES_START_LAUNCH("on_common_services_start_launch", 0, 2, null),
        ON_COMMON_SERVICES_END_LAUNCH("on_common_services_end_launch", 0, 2, null),
        ON_EMPTY_PAGE_START_LOAD("on_empty_page_start_load", 0, 2, null),
        ON_EMPTY_PAGE_END_LOAD("on_empty_page_end_laod", 0, 2, null),
        ON_MEDIALIST_API_START("on_medialist_api_start", 0, 2, null),
        ON_MEDIALIST_API_END("on_medialist_api_end", 0, 2, null),
        ON_MEDIALIST_INFO_API_START("on_medialist_info_api_start", 0, 2, null),
        ON_MEDIALIST_INFO_API_END("on_medialist_info_api_end", 0, 2, null),
        ON_UGC_PAGE_START_LOAD("on_ugc_page_start_load", 0, 2, null),
        ON_UGC_PAGE_END_LOAD("on_ugc_page_end_load", 0, 2, null),
        ON_START_LAUNCH_UGC_SERVICES("on_start_launch_ugc_services", 0, 2, null),
        ON_END_LAUNCH_UGC_SERVICES("on_end_launch_ugc_services", 0, 2, null);
        
        private Map<String, String> mExtras;
        private long timestamp;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Entry> getEntries() {
            return $ENTRIES;
        }

        Entry(String name, long timestamp) {
            this.timestamp = timestamp;
        }

        /* synthetic */ Entry(String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? 0L : j);
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final void setTimestamp(long j) {
            this.timestamp = j;
        }

        public final Entry setExtras(Map<String, String> map) {
            this.mExtras = map;
            return this;
        }

        public final Map<String, String> getExtras() {
            return this.mExtras;
        }

        public final Entry attach(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }
    }

    public final void start() {
        if (this.mWatchDog != null) {
            BLog.w("Watch dog is already working! Make sure it was ended correctly.");
            return;
        }
        Handler handler = HandlerThreads.getHandler(0);
        Intrinsics.checkNotNullExpressionValue(handler, "getHandler(...)");
        this.mWatchDog = new WatchDog(handler);
        WatchDog watchDog = this.mWatchDog;
        Intrinsics.checkNotNull(watchDog);
        watchDog.start();
        this.mMaxCount = Entry.values().length;
        this.mIsCanceled = false;
    }

    private final boolean shouldTracingTime() {
        if (this.mWatchDog != null) {
            WatchDog watchDog = this.mWatchDog;
            Intrinsics.checkNotNull(watchDog);
            if (!watchDog.isEnd()) {
                return true;
            }
        }
        return false;
    }

    public final void split(Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        splitInternal(entry);
    }

    private final void splitInternal(Entry entry) {
        Map $this$forEach$iv;
        WatchDog watchDog = this.mWatchDog;
        boolean z = false;
        if (watchDog != null && watchDog.isEnableAdd(entry.name())) {
            z = true;
        }
        if (z && ($this$forEach$iv = entry.getExtras()) != null) {
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                addExtra(element$iv.getKey(), element$iv.getValue());
            }
        }
        WatchDog watchDog2 = this.mWatchDog;
        if (watchDog2 != null) {
            watchDog2.split(entry.name(), entry.getTimestamp());
        }
    }

    private final void splitAndEnd(Entry entry) {
        splitInternal(entry);
        end();
    }

    public final void splitOrEnd(Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        WatchDog it = this.mWatchDog;
        if (it != null) {
            List records = it.getRecords();
            if (records.size() >= this.mMaxCount - 1) {
                splitAndEnd(entry);
            } else {
                split(entry);
            }
        }
    }

    public final void end() {
        if (this.mWatchDog == null) {
            BLog.w("Watch dog is not working! Make sure it was started correctly.");
            return;
        }
        WatchDog watchDog = this.mWatchDog;
        Intrinsics.checkNotNull(watchDog);
        watchDog.end();
    }

    public final void reset() {
        if (this.mWatchDog == null) {
            BLog.w("Watch dog is not working! Make sure it was started correctly.");
        } else {
            this.mWatchDog = null;
        }
    }

    public final void dump() {
        if (this.mWatchDog != null && BuildConfig.DEBUG) {
            String str = this.mName;
            BLog.d(TAG, str + " watchdog = " + this.mWatchDog);
        }
    }

    public final void report() {
        IProfilerReporter instance;
        if (this.mIsCanceled || this.mWatchDog == null) {
            return;
        }
        WatchDog watchDog = this.mWatchDog;
        Intrinsics.checkNotNull(watchDog);
        if (!watchDog.isEnd() || (instance = IProfilerReporter.Companion.instance(this.mName)) == null) {
            return;
        }
        WatchDog watchDog2 = this.mWatchDog;
        Intrinsics.checkNotNull(watchDog2);
        instance.reportPage(watchDog2, this.mExtras);
    }

    public final void cancel() {
        this.mIsCanceled = true;
    }

    public final void traceImageLoading() {
        if (shouldTracingTime() && !this.mHasReportedImageShow) {
            this.mHasReportedImageShow = true;
            split(Entry.ON_DETAIL_IMAGE_BIND.attach(SystemClock.elapsedRealtime()));
            BootOpt.reportAwakeTime$default(BootOpt.INSTANCE, Scene.UGC_VIDEO_FIRST_SCREEN, (Long) null, 2, (Object) null);
        }
    }

    public final void addExtra(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (value != null) {
            this.mExtras.put(key, value);
        }
    }
}