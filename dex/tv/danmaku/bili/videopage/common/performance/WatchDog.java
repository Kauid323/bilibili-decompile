package tv.danmaku.bili.videopage.common.performance;

import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tv.danmaku.bili.videopage.common.callback.ShareIconObserverKt;
import tv.danmaku.bili.videopage.common.performance.PerformanceTracerImpl;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PerformanceTracerImpl.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0013\u001a\u00020\u0000J\u0006\u0010\u0014\u001a\u00020\u0007J\u0016\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0011J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0006\u0010\u001b\u001a\u00020\u001aJ\b\u0010\u001c\u001a\u00020\u0011H\u0016J$\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\"\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u001fJ\u001e\u0010 \u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00100!R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Ltv/danmaku/bili/videopage/common/performance/WatchDog;", "", "handler", "Landroid/os/Handler;", "<init>", "(Landroid/os/Handler;)V", "mIsEnd", "", "mStartTime", "", "mEndTime", "mTicker", "Ltv/danmaku/bili/videopage/common/performance/ITicker;", "mHandler", "mRecords", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Triple;", "", "mAddedRecords", "start", "isEnd", "split", "key", "splitTime", "isEnableAdd", "addRecord", "", ShareIconObserverKt.SHARE_FROM_END, "toString", "getRecord", "entry", "Ltv/danmaku/bili/videopage/common/performance/PerformanceTracerImpl$Entry;", "getRecords", "", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchDog {
    private CopyOnWriteArrayList<String> mAddedRecords;
    private long mEndTime;
    private final Handler mHandler;
    private boolean mIsEnd;
    private CopyOnWriteArrayList<Triple<String, Long, Long>> mRecords;
    private long mStartTime;
    private final ITicker mTicker;

    public WatchDog(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.mIsEnd = true;
        this.mTicker = new SystemClockMillisTicker();
        this.mHandler = handler;
        this.mRecords = new CopyOnWriteArrayList<>();
        this.mAddedRecords = new CopyOnWriteArrayList<>();
    }

    public final WatchDog start() {
        this.mIsEnd = false;
        this.mStartTime = this.mTicker.currentTime();
        this.mEndTime = this.mStartTime;
        return this;
    }

    public final boolean isEnd() {
        return this.mIsEnd;
    }

    public final WatchDog split(String key, long splitTime) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (isEnableAdd(key)) {
            addRecord(key, splitTime);
            this.mEndTime = splitTime;
        }
        return this;
    }

    public final boolean isEnableAdd(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (this.mIsEnd || this.mAddedRecords.contains(key)) ? false : true;
    }

    private final void addRecord(final String key, final long splitTime) {
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            this.mAddedRecords.add(key);
            this.mRecords.add(new Triple<>(key, Long.valueOf(this.mTicker.getInterval(this.mEndTime, splitTime)), Long.valueOf(this.mTicker.getInterval(this.mStartTime, splitTime))));
            return;
        }
        this.mHandler.post(new Runnable() { // from class: tv.danmaku.bili.videopage.common.performance.WatchDog$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                WatchDog.addRecord$lambda$0(WatchDog.this, key, splitTime);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addRecord$lambda$0(WatchDog this$0, String $key, long $splitTime) {
        this$0.mAddedRecords.add($key);
        this$0.mRecords.add(new Triple<>($key, Long.valueOf(this$0.mTicker.getInterval(this$0.mEndTime, $splitTime)), Long.valueOf(this$0.mTicker.getInterval(this$0.mStartTime, $splitTime))));
    }

    public final void end() {
        if (!this.mIsEnd) {
            this.mIsEnd = true;
            this.mEndTime = this.mTicker.currentTime();
        }
    }

    public String toString() {
        if (this.mIsEnd && this.mRecords.size() > 0) {
            long all = this.mEndTime - this.mStartTime;
            int size = this.mRecords.size();
            StringBuilder buffer = new StringBuilder(size * 24);
            buffer.append("WatchDog{start=").append(this.mStartTime).append(", ");
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    buffer.append(", ");
                }
                Triple<String, Long, Long> triple = this.mRecords.get(i);
                String key = (String) triple.component1();
                long second = ((Number) triple.component2()).longValue();
                long third = ((Number) triple.component3()).longValue();
                buffer.append(key);
                buffer.append('=');
                buffer.append(third);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.US, "(%.2f)", Arrays.copyOf(new Object[]{Float.valueOf(((float) second) / ((float) all))}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                buffer.append(format);
            }
            buffer.append(", end=").append(this.mEndTime).append(", all=").append(all).append('}');
            String sb = buffer.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
            return sb;
        }
        return "WatchDog{}";
    }

    private final Triple<String, Long, Long> getRecord(String key) {
        int size = this.mRecords.size();
        for (int i = 0; i < size; i++) {
            Triple item = this.mRecords.get(i);
            if (Intrinsics.areEqual(key, item.getFirst())) {
                return item;
            }
        }
        return null;
    }

    public final Triple<String, Long, Long> getRecord(PerformanceTracerImpl.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        return getRecord(entry.name());
    }

    public final List<Triple<String, Long, Long>> getRecords() {
        return this.mRecords;
    }
}