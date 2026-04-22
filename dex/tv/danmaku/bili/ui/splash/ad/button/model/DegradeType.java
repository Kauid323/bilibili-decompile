package tv.danmaku.bili.ui.splash.ad.button.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DegradeType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/button/model/DegradeType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "INVALID_RES", "DEVICE_SENSOR_VALID", "SENSOR_DISABLE", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum DegradeType {
    INVALID_RES(1),
    DEVICE_SENSOR_VALID(2),
    SENSOR_DISABLE(3);
    
    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<DegradeType> getEntries() {
        return $ENTRIES;
    }

    DegradeType(int value) {
        this.value = value;
    }

    public final int getValue() {
        return this.value;
    }
}