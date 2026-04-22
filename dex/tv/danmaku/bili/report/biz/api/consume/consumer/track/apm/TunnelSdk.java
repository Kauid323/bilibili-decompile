package tv.danmaku.bili.report.biz.api.consume.consumer.track.apm;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Protocols.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/report/biz/api/consume/consumer/track/apm/TunnelSdk;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "OKHTTP", "BBC_SOCKET", "OKHTTP_CRONET", "OKHTTP_IGNET", "MOSS_CRONET", "MOSS_OKHTTP", "MOSS_DOWNGRADE_OKHTTP", "MOSS_STREAM_CRONET", "MOSS_OKHTTP_CRONET", "MOSS_DOWNGRADE_OKHTTP_CRONET", "MOSS_GRPC_IGNET", "MOSS_STREAM_IGNET", "HTTPDNS_CHROMIUM_NET", "CRONET", "CRONET_JAVA", "IJK_HTTP", "IJK_P2P", "MOSS_REST_OKHTTP", "MOSS_REST_OKHTTP_CRONET", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum TunnelSdk {
    OKHTTP("2000"),
    BBC_SOCKET("2001"),
    OKHTTP_CRONET("2002"),
    OKHTTP_IGNET("2003"),
    MOSS_CRONET("2100"),
    MOSS_OKHTTP("2101"),
    MOSS_DOWNGRADE_OKHTTP("2102"),
    MOSS_STREAM_CRONET("2103"),
    MOSS_OKHTTP_CRONET("2104"),
    MOSS_DOWNGRADE_OKHTTP_CRONET("2105"),
    MOSS_GRPC_IGNET("2106"),
    MOSS_STREAM_IGNET("2107"),
    HTTPDNS_CHROMIUM_NET("2200"),
    CRONET("2300"),
    CRONET_JAVA("2301"),
    IJK_HTTP("3000"),
    IJK_P2P("3001"),
    MOSS_REST_OKHTTP("2400"),
    MOSS_REST_OKHTTP_CRONET("2401");
    
    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<TunnelSdk> getEntries() {
        return $ENTRIES;
    }

    TunnelSdk(String value) {
        this.value = value;
    }

    public final String getValue() {
        return this.value;
    }
}