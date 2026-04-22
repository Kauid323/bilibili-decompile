package kntr.app.tribee.steam.page.share;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: TribeeSteamShareParams.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 $2\u00020\u0001:\u0002#$B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB=\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lkntr/app/tribee/steam/page/share/TribeeSteamShareSid;", "", "tribeeId", "", "appId", "", "hostMid", "shareType", "", "<init>", "(JLjava/lang/String;JI)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;JILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTribeeId$annotations", "()V", "getTribeeId", "()J", "getAppId$annotations", "getAppId", "()Ljava/lang/String;", "getHostMid$annotations", "getHostMid", "getShareType$annotations", "getShareType", "()I", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$consume_debug", "$serializer", "Companion", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class TribeeSteamShareSid {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String appId;
    private final long hostMid;
    private final int shareType;
    private final long tribeeId;

    @SerialName("app_id")
    public static /* synthetic */ void getAppId$annotations() {
    }

    @SerialName("host_mid")
    public static /* synthetic */ void getHostMid$annotations() {
    }

    @SerialName("share_type")
    public static /* synthetic */ void getShareType$annotations() {
    }

    @SerialName("tribee_id")
    public static /* synthetic */ void getTribeeId$annotations() {
    }

    /* compiled from: TribeeSteamShareParams.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/tribee/steam/page/share/TribeeSteamShareSid$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/tribee/steam/page/share/TribeeSteamShareSid;", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TribeeSteamShareSid> serializer() {
            return TribeeSteamShareSid$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ TribeeSteamShareSid(int seen0, long tribeeId, String appId, long hostMid, int shareType, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (seen0 & 15)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 15, TribeeSteamShareSid$$serializer.INSTANCE.getDescriptor());
        }
        this.tribeeId = tribeeId;
        this.appId = appId;
        this.hostMid = hostMid;
        this.shareType = shareType;
    }

    public TribeeSteamShareSid(long tribeeId, String appId, long hostMid, int shareType) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.tribeeId = tribeeId;
        this.appId = appId;
        this.hostMid = hostMid;
        this.shareType = shareType;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$consume_debug(TribeeSteamShareSid self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.tribeeId);
        output.encodeStringElement(serialDesc, 1, self.appId);
        output.encodeLongElement(serialDesc, 2, self.hostMid);
        output.encodeIntElement(serialDesc, 3, self.shareType);
    }

    public final long getTribeeId() {
        return this.tribeeId;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final long getHostMid() {
        return this.hostMid;
    }

    public final int getShareType() {
        return this.shareType;
    }
}