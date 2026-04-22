package tv.danmaku.biliplayerv2.service.report.heartbeat;

import com.bilibili.lib.gson.GsonKt;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.report.heartbeat.ReportStrategy;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IHeartbeatService.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010U\u001a\u00020V2\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110LJ\u0016\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u00112\u0006\u0010X\u001a\u00020\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u001a\u0010(\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015R\u001a\u0010+\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R\u001a\u0010.\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0013\"\u0004\b0\u0010\u0015R\u001a\u00101\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0013\"\u0004\b3\u0010\u0015R\u001a\u00104\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0013\"\u0004\b6\u0010\u0015R\u001a\u00107\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\"\"\u0004\b9\u0010$R\u001a\u0010:\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0013\"\u0004\bA\u0010\u0015R\u001a\u0010B\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0013\"\u0004\bD\u0010\u0015R\u001a\u0010E\u001a\u00020FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR(\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010S\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010L8F¢\u0006\u0006\u001a\u0004\bT\u0010N¨\u0006Y"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/heartbeat/ReportMetaInfo;", "", "<init>", "()V", "avid", "", "getAvid", "()J", "setAvid", "(J)V", "cid", "getCid", "setCid", "roomId", "getRoomId", "setRoomId", "jumpFrom", "", "getJumpFrom", "()Ljava/lang/String;", "setJumpFrom", "(Ljava/lang/String;)V", "spmid", "getSpmid", "setSpmid", "fromSpmid", "getFromSpmid", "setFromSpmid", "seasonId", "getSeasonId", "setSeasonId", "type", "", "getType", "()I", "setType", "(I)V", "subType", "getSubType", "setSubType", "epId", "getEpId", "setEpId", "fromAutoPlay", "getFromAutoPlay", "setFromAutoPlay", "playType", "getPlayType", "setPlayType", "epStatus", "getEpStatus", "setEpStatus", "playStatus", "getPlayStatus", "setPlayStatus", "page", "getPage", "setPage", "isListPlay", "", "()Z", "setListPlay", "(Z)V", "playMode", "getPlayMode", "setPlayMode", "trackId", "getTrackId", "setTrackId", "reportStrategy", "Ltv/danmaku/biliplayerv2/service/report/heartbeat/ReportStrategy;", "getReportStrategy", "()Ltv/danmaku/biliplayerv2/service/report/heartbeat/ReportStrategy;", "setReportStrategy", "(Ltv/danmaku/biliplayerv2/service/report/heartbeat/ReportStrategy;)V", "legacyExtra", "", "getLegacyExtra", "()Ljava/util/Map;", "setLegacyExtra", "(Ljava/util/Map;)V", "_extra", "", "extraParams", "getExtraParams", "addExtra", "", "key", "jsonValue", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class ReportMetaInfo {
    private Map<String, String> _extra;
    private long avid;
    private long cid;
    private int fromAutoPlay;
    private boolean isListPlay;
    private Map<String, String> legacyExtra;
    private int page;
    private String playMode;
    private long roomId;
    private long seasonId;
    private int subType;
    private int type;
    private String jumpFrom = "";
    private String spmid = "";
    private String fromSpmid = "";
    private String epId = "";
    private String playType = "";
    private String epStatus = "";
    private String playStatus = "";
    private String trackId = "";
    private ReportStrategy reportStrategy = ReportStrategy.NORMAL.INSTANCE;

    public final long getAvid() {
        return this.avid;
    }

    public final void setAvid(long j) {
        this.avid = j;
    }

    public final long getCid() {
        return this.cid;
    }

    public final void setCid(long j) {
        this.cid = j;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final void setRoomId(long j) {
        this.roomId = j;
    }

    public final String getJumpFrom() {
        return this.jumpFrom;
    }

    public final void setJumpFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpFrom = str;
    }

    public final String getSpmid() {
        return this.spmid;
    }

    public final void setSpmid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spmid = str;
    }

    public final String getFromSpmid() {
        return this.fromSpmid;
    }

    public final void setFromSpmid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fromSpmid = str;
    }

    public final long getSeasonId() {
        return this.seasonId;
    }

    public final void setSeasonId(long j) {
        this.seasonId = j;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final int getSubType() {
        return this.subType;
    }

    public final void setSubType(int i) {
        this.subType = i;
    }

    public final String getEpId() {
        return this.epId;
    }

    public final void setEpId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.epId = str;
    }

    public final int getFromAutoPlay() {
        return this.fromAutoPlay;
    }

    public final void setFromAutoPlay(int i) {
        this.fromAutoPlay = i;
    }

    public final String getPlayType() {
        return this.playType;
    }

    public final void setPlayType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playType = str;
    }

    public final String getEpStatus() {
        return this.epStatus;
    }

    public final void setEpStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.epStatus = str;
    }

    public final String getPlayStatus() {
        return this.playStatus;
    }

    public final void setPlayStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playStatus = str;
    }

    public final int getPage() {
        return this.page;
    }

    public final void setPage(int i) {
        this.page = i;
    }

    public final boolean isListPlay() {
        return this.isListPlay;
    }

    public final void setListPlay(boolean z) {
        this.isListPlay = z;
    }

    public final String getPlayMode() {
        return this.playMode;
    }

    public final void setPlayMode(String str) {
        this.playMode = str;
    }

    public final String getTrackId() {
        return this.trackId;
    }

    public final void setTrackId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.trackId = str;
    }

    public final ReportStrategy getReportStrategy() {
        return this.reportStrategy;
    }

    public final void setReportStrategy(ReportStrategy reportStrategy) {
        Intrinsics.checkNotNullParameter(reportStrategy, "<set-?>");
        this.reportStrategy = reportStrategy;
    }

    public final Map<String, String> getLegacyExtra() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.legacyExtra);
    }

    public final void setLegacyExtra(Map<String, String> map) {
        this.legacyExtra = map;
    }

    public final Map<String, String> getExtraParams() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this._extra);
    }

    public final void addExtra(Map<String, String> map) {
        Map extraParams = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(extraParams, "extraParams");
        if (extraParams.isEmpty()) {
            return;
        }
        if (IHeartbeatServiceKt.getHitPlayExtraMerge()) {
            if (this._extra == null) {
                this._extra = new LinkedHashMap();
            }
            Map<String, String> map2 = this._extra;
            if (map2 != null) {
                map2.putAll(extraParams);
                return;
            }
            return;
        }
        if (this.legacyExtra == null) {
            this.legacyExtra = new LinkedHashMap();
        }
        Map<String, String> map3 = this.legacyExtra;
        Intrinsics.checkNotNull(map3);
        Map $this$addExtra_u24lambda_u240 = MapsKt.toMutableMap(map3);
        try {
            $this$addExtra_u24lambda_u240.put("extra", GsonKt.toJsonString(extraParams));
        } catch (Exception e) {
            BLog.e("ReportMetaInfo", "addExtra toJsonString error: " + e.getMessage());
        }
        this.legacyExtra = $this$addExtra_u24lambda_u240;
    }

    public final void addExtra(String key, String jsonValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
        if (IHeartbeatServiceKt.getHitPlayExtraMerge()) {
            if (this._extra == null) {
                this._extra = new LinkedHashMap();
            }
            Map<String, String> map = this._extra;
            if (map != null) {
                map.put(key, jsonValue);
            }
        }
    }
}