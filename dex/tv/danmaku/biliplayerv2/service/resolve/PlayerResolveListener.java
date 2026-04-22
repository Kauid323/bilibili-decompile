package tv.danmaku.biliplayerv2.service.resolve;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IPlayerResolveService.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0003"}, d2 = {"Ltv/danmaku/biliplayerv2/service/resolve/PlayerResolveListener;", "", "onStart", "", "task", "Ltv/danmaku/biliplayerv2/service/resolve/Task;", "onError", "onProgress", "onSucceed", "onCancel", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface PlayerResolveListener {
    void onCancel(Task<?, ?> task);

    void onError(Task<?, ?> task);

    void onProgress(Task<?, ?> task);

    void onStart(Task<?, ?> task);

    void onSucceed(Task<?, ?> task);

    /* compiled from: IPlayerResolveService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.resolve.PlayerResolveListener$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
    }

    /* compiled from: IPlayerResolveService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static void onStart(PlayerResolveListener $this, Task<?, ?> task) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(task, "task");
        }

        @Deprecated
        public static void onError(PlayerResolveListener $this, Task<?, ?> task) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(task, "task");
        }

        @Deprecated
        public static void onProgress(PlayerResolveListener $this, Task<?, ?> task) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(task, "task");
        }

        @Deprecated
        public static void onSucceed(PlayerResolveListener $this, Task<?, ?> task) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(task, "task");
        }

        @Deprecated
        public static void onCancel(PlayerResolveListener $this, Task<?, ?> task) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(task, "task");
        }
    }
}