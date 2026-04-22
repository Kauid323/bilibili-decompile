package tv.danmaku.bili.ui.splash.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LoadingState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/splash/utils/LoadingState;", "", "<init>", "()V", "Loading", "Complete", "Error", "Ltv/danmaku/bili/ui/splash/utils/LoadingState$Complete;", "Ltv/danmaku/bili/ui/splash/utils/LoadingState$Error;", "Ltv/danmaku/bili/ui/splash/utils/LoadingState$Loading;", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class LoadingState {
    public static final int $stable = 0;

    public /* synthetic */ LoadingState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: LoadingState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/ui/splash/utils/LoadingState$Loading;", "Ltv/danmaku/bili/ui/splash/utils/LoadingState;", "<init>", "()V", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Loading extends LoadingState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    private LoadingState() {
    }

    /* compiled from: LoadingState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/ui/splash/utils/LoadingState$Complete;", "Ltv/danmaku/bili/ui/splash/utils/LoadingState;", "<init>", "()V", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Complete extends LoadingState {
        public static final int $stable = 0;
        public static final Complete INSTANCE = new Complete();

        private Complete() {
            super(null);
        }
    }

    /* compiled from: LoadingState.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/splash/utils/LoadingState$Error;", "Ltv/danmaku/bili/ui/splash/utils/LoadingState;", "t", "", "<init>", "(Ljava/lang/Throwable;)V", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Error extends LoadingState {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Throwable t) {
            super(null);
            Intrinsics.checkNotNullParameter(t, "t");
        }
    }
}