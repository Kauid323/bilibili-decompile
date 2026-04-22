package tv.danmaku.bili.wauth;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WAuthErrorMsg.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/bili/wauth/WAuthErrorMsg;", "", "<init>", "()V", "Companion", "networkauth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WAuthErrorMsg {
    public static final String CODE_CALL_SUCCESS = "C0000000";
    public static final String CODE_CANCEL = "1";
    public static final String CODE_SUCCESS = "0";
    public static final String CODE_WAUTH_CANCEL = "C0412003";
    public static final String ERROR_CODE_UNINSTALLED = "-2";
    public static final String ERROR_INTERNAL_CODE = "-1";
    public static final String ERROR_INTERNAL_MESSAGE = "内部错误";
    public static final String ERROR_MESSAGE_CALL = "wauth";
    public static final String ERROR_MESSAGE_REQUEST = "request";
    public static final Companion Companion = new Companion(null);
    private static final String ERROR_MESSAGE_TEMP_NULL = "TempCode is null";
    private static final String ERROR_MESSAGE_INTENT_NULL = "Intent is null";
    private static final String ERROR_MESSAGE_CODE_NULL = "Code is null";

    /* compiled from: WAuthErrorMsg.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/wauth/WAuthErrorMsg$Companion;", "", "<init>", "()V", "CODE_SUCCESS", "", "CODE_CANCEL", "CODE_CALL_SUCCESS", "CODE_WAUTH_CANCEL", "ERROR_MESSAGE_CALL", "ERROR_MESSAGE_REQUEST", "ERROR_INTERNAL_CODE", "ERROR_CODE_UNINSTALLED", "ERROR_INTERNAL_MESSAGE", "ERROR_MESSAGE_TEMP_NULL", "getERROR_MESSAGE_TEMP_NULL", "()Ljava/lang/String;", "ERROR_MESSAGE_INTENT_NULL", "getERROR_MESSAGE_INTENT_NULL", "ERROR_MESSAGE_CODE_NULL", "getERROR_MESSAGE_CODE_NULL", "networkauth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getERROR_MESSAGE_TEMP_NULL() {
            return WAuthErrorMsg.ERROR_MESSAGE_TEMP_NULL;
        }

        public final String getERROR_MESSAGE_INTENT_NULL() {
            return WAuthErrorMsg.ERROR_MESSAGE_INTENT_NULL;
        }

        public final String getERROR_MESSAGE_CODE_NULL() {
            return WAuthErrorMsg.ERROR_MESSAGE_CODE_NULL;
        }
    }
}