package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RpcException.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/RpcException;", "", "<init>", "()V", "PACKAGE_MSG_FORMAT_ERROR", "", "PACKAGE_MSG_NOT_SUPPORT_METHOD", "NATIVE_RUNTIME_ERROR", "RESPONSE_PROCESS_RESULT_ERROR", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RpcException {
    public static final RpcException INSTANCE = new RpcException();
    public static final int NATIVE_RUNTIME_ERROR = -7000;
    public static final int PACKAGE_MSG_FORMAT_ERROR = -6000;
    public static final int PACKAGE_MSG_NOT_SUPPORT_METHOD = -6001;
    public static final int RESPONSE_PROCESS_RESULT_ERROR = -8000;

    private RpcException() {
    }
}