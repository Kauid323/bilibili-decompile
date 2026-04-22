package tv.danmaku.biliplayerv2.profiler;

import android.os.SystemClock;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerProfiler.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0016\"\u00020\u0006¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bJ$\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00062\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0013R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Ltv/danmaku/biliplayerv2/profiler/PlayerProfiler;", "", "<init>", "()V", "mHandlerTagMap", "", "", "", "Ltv/danmaku/biliplayerv2/profiler/ProfilerHandler;", "mPendingHandleMessages", "Ljava/util/LinkedList;", "Ltv/danmaku/biliplayerv2/profiler/PlayerProfiler$Message;", "mIsDispatching", "", "mSpinLock", "Ltv/danmaku/biliplayerv2/profiler/PlayerProfiler$SpinLockLite;", "mDispatchMessageRunnable", "Ljava/lang/Runnable;", "registerProfilerHandler", "", "handler", "tags", "", "(Ltv/danmaku/biliplayerv2/profiler/ProfilerHandler;[Ljava/lang/String;)V", "unregisterProfilerHandler", "doProfile", "tag", "argsMap", "", "release", "SpinLockLite", "Message", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerProfiler {
    private volatile boolean mIsDispatching;
    private Map<String, List<ProfilerHandler>> mHandlerTagMap = new LinkedHashMap();
    private final LinkedList<Message> mPendingHandleMessages = new LinkedList<>();
    private final SpinLockLite mSpinLock = new SpinLockLite();
    private final Runnable mDispatchMessageRunnable = new Runnable() { // from class: tv.danmaku.biliplayerv2.profiler.PlayerProfiler$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            PlayerProfiler.mDispatchMessageRunnable$lambda$0(PlayerProfiler.this);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mDispatchMessageRunnable$lambda$0(PlayerProfiler this$0) {
        while (true) {
            this$0.mSpinLock.lock();
            LinkedList messages = new LinkedList(this$0.mPendingHandleMessages);
            this$0.mPendingHandleMessages.clear();
            this$0.mSpinLock.unlock();
            if (!messages.isEmpty()) {
                while (!messages.isEmpty()) {
                    Message msg = (Message) messages.removeFirst();
                    Iterable iterable = (List) this$0.mHandlerTagMap.get(msg.getTag());
                    if (iterable != null) {
                        Iterable $this$forEach$iv = iterable;
                        for (Object element$iv : $this$forEach$iv) {
                            ProfilerHandler it = (ProfilerHandler) element$iv;
                            Intrinsics.checkNotNull(msg);
                            it.handleMessage(msg);
                        }
                    }
                }
            } else {
                this$0.mIsDispatching = false;
                return;
            }
        }
    }

    public final void registerProfilerHandler(ProfilerHandler handler, String... tags) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Iterable $this$forEach$iv = ArraysKt.asList(tags);
        for (Object element$iv : $this$forEach$iv) {
            String it = (String) element$iv;
            List handlers = this.mHandlerTagMap.get(it);
            if (handlers == null) {
                handlers = new ArrayList();
                this.mHandlerTagMap.put(it, handlers);
            }
            handlers.add(handler);
        }
    }

    public final void unregisterProfilerHandler(ProfilerHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        ArrayList pendingRemoveTags = new ArrayList();
        Map $this$forEach$iv = this.mHandlerTagMap;
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            element$iv.getValue().remove(handler);
            if (element$iv.getValue().isEmpty()) {
                pendingRemoveTags.add(element$iv.getKey());
            }
        }
        ArrayList<String> $this$forEach$iv2 = pendingRemoveTags;
        for (String it : $this$forEach$iv2) {
            this.mHandlerTagMap.remove(it);
        }
    }

    public final void doProfile(String tag, Map<String, String> map) {
        Map argsMap = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (!this.mHandlerTagMap.containsKey(tag)) {
            return;
        }
        Message msg = new Message(tag, argsMap, SystemClock.elapsedRealtime(), System.currentTimeMillis());
        this.mSpinLock.lock();
        this.mPendingHandleMessages.add(msg);
        this.mSpinLock.unlock();
        if (!this.mIsDispatching) {
            this.mIsDispatching = true;
            HandlerThreads.runOn(0, this.mDispatchMessageRunnable);
        }
    }

    public final void release() {
        HandlerThreads.remove(0, this.mDispatchMessageRunnable);
    }

    /* compiled from: PlayerProfiler.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/biliplayerv2/profiler/PlayerProfiler$SpinLockLite;", "", "<init>", "()V", "mState", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "", "unlock", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class SpinLockLite {
        private final AtomicBoolean mState = new AtomicBoolean();

        public final void lock() {
            while (!this.mState.compareAndSet(false, true)) {
                Thread.yield();
            }
        }

        public final void unlock() {
            while (!this.mState.compareAndSet(true, false)) {
                Thread.yield();
            }
        }
    }

    /* compiled from: PlayerProfiler.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Ltv/danmaku/biliplayerv2/profiler/PlayerProfiler$Message;", "", "tag", "", "params", "", "elapsedRealTimestamp", "", "timestamp", "<init>", "(Ljava/lang/String;Ljava/util/Map;JJ)V", "getTag", "()Ljava/lang/String;", "getParams", "()Ljava/util/Map;", "getElapsedRealTimestamp", "()J", "getTimestamp", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Message {
        private final long elapsedRealTimestamp;
        private final Map<String, String> params;
        private final String tag;
        private final long timestamp;

        public Message(String tag, Map<String, String> map, long elapsedRealTimestamp, long timestamp) {
            Map params = EnhancedUnmodifiabilityKt.unmodifiable(map);
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.tag = tag;
            this.params = params;
            this.elapsedRealTimestamp = elapsedRealTimestamp;
            this.timestamp = timestamp;
        }

        public final String getTag() {
            return this.tag;
        }

        public final Map<String, String> getParams() {
            return EnhancedUnmodifiabilityKt.unmodifiable(this.params);
        }

        public final long getElapsedRealTimestamp() {
            return this.elapsedRealTimestamp;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }
    }
}