package video.biz.offline.base.model.model;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AuthCode.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0087\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lvideo/biz/offline/base/model/model/AuthCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "Pass", "EpOffline", "EpFreeQnVip", "EpVip", "EpPayOrVip", "EpPayOrVipFirst", "EpPay", "EpPayFirst", "EpPayPack", "EpTicketWhite", "ChargeError", "Companion", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum AuthCode {
    Pass(0),
    EpOffline(1),
    EpFreeQnVip(2),
    EpVip(3),
    EpPayOrVip(4),
    EpPayOrVipFirst(5),
    EpPay(6),
    EpPayFirst(7),
    EpPayPack(8),
    EpTicketWhite(9),
    ChargeError(100);
    
    private final int code;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);

    public static EnumEntries<AuthCode> getEntries() {
        return $ENTRIES;
    }

    AuthCode(int code) {
        this.code = code;
    }

    public final int getCode() {
        return this.code;
    }

    /* compiled from: AuthCode.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lvideo/biz/offline/base/model/model/AuthCode$Companion;", "", "<init>", "()V", "enumOf", "Lvideo/biz/offline/base/model/model/AuthCode;", "value", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AuthCode enumOf(int value) {
            Object element$iv;
            boolean z;
            Iterable $this$firstOrNull$iv = AuthCode.getEntries();
            Iterator it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    AuthCode it2 = (AuthCode) element$iv;
                    if (it2.getCode() == value) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            AuthCode authCode = (AuthCode) element$iv;
            return authCode == null ? AuthCode.Pass : authCode;
        }
    }
}