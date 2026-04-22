package tv.danmaku.bili.ui.watchlater.data;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WLState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/ToastType;", "", "NetworkError", "OperateSuccess", "OperateFailed", "Ltv/danmaku/bili/ui/watchlater/data/ToastType$NetworkError;", "Ltv/danmaku/bili/ui/watchlater/data/ToastType$OperateFailed;", "Ltv/danmaku/bili/ui/watchlater/data/ToastType$OperateSuccess;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface ToastType {

    /* compiled from: WLState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/ToastType$NetworkError;", "Ltv/danmaku/bili/ui/watchlater/data/ToastType;", "<init>", "()V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class NetworkError implements ToastType {
        public static final int $stable = 0;
        public static final NetworkError INSTANCE = new NetworkError();

        private NetworkError() {
        }
    }

    /* compiled from: WLState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/ToastType$OperateSuccess;", "Ltv/danmaku/bili/ui/watchlater/data/ToastType;", "<init>", "()V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class OperateSuccess implements ToastType {
        public static final int $stable = 0;
        public static final OperateSuccess INSTANCE = new OperateSuccess();

        private OperateSuccess() {
        }
    }

    /* compiled from: WLState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/ToastType$OperateFailed;", "Ltv/danmaku/bili/ui/watchlater/data/ToastType;", "<init>", "()V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class OperateFailed implements ToastType {
        public static final int $stable = 0;
        public static final OperateFailed INSTANCE = new OperateFailed();

        private OperateFailed() {
        }
    }
}