package video.biz.offline.base.model.error;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ErrorCode.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lvideo/biz/offline/base/model/error/OfflineErrorType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DATA_ERROR", "DOWNLOAD_ERROR", "BANDWIDTH_ERROR", "Companion", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum OfflineErrorType {
    UNKNOWN(0),
    DATA_ERROR(1),
    DOWNLOAD_ERROR(2),
    BANDWIDTH_ERROR(3);
    
    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);

    public static EnumEntries<OfflineErrorType> getEntries() {
        return $ENTRIES;
    }

    OfflineErrorType(int value) {
        this.value = value;
    }

    public final int getValue() {
        return this.value;
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lvideo/biz/offline/base/model/error/OfflineErrorType$Companion;", "", "<init>", "()V", "from", "Lvideo/biz/offline/base/model/error/OfflineErrorType;", "value", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OfflineErrorType from(int value) {
            Object element$iv;
            boolean z;
            Iterable $this$firstOrNull$iv = OfflineErrorType.getEntries();
            Iterator it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    OfflineErrorType it2 = (OfflineErrorType) element$iv;
                    if (it2.getValue() == value) {
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
            OfflineErrorType offlineErrorType = (OfflineErrorType) element$iv;
            return offlineErrorType == null ? OfflineErrorType.UNKNOWN : offlineErrorType;
        }
    }
}