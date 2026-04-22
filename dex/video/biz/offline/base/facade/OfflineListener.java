package video.biz.offline.base.facade;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineListener.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lvideo/biz/offline/base/facade/OfflineListener;", "", "<init>", "()V", "Companion", "facade_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineListener {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    /* compiled from: OfflineListener.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u0005H\u0087@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lvideo/biz/offline/base/facade/OfflineListener$Companion;", "", "<init>", "()V", "addListener", "Lkotlinx/coroutines/Job;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "facade_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Object addListener(Continuation<? super Job> continuation) {
            return CoroutineScopeKt.coroutineScope(new OfflineListener$Companion$addListener$2(null), continuation);
        }
    }
}