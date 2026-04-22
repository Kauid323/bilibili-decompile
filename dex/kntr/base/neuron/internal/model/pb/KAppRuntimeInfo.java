package kntr.base.neuron.internal.model.pb;

import androidx.collection.DoubleList$;
import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.AppKey;
import kntr.common.upper.trace.config.CommonProjectType;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.protobuf.ProtoNumber;

/* compiled from: info_raw.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 B2\u00020\u0001:\u0002BCBa\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fBq\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000e\u0010\u0014J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003Jc\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0011HÖ\u0001J\t\u00109\u001a\u00020\u0005HÖ\u0001J%\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0001¢\u0006\u0002\bAR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u001eR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u001bR\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u001bR\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u001bR\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0016\u001a\u0004\b(\u0010\u001bR\u001c\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0016\u001a\u0004\b*\u0010\u001b¨\u0006D"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KAppRuntimeInfo;", "", CommonProjectType.NETWORK, "Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork;", "oid", "", "longitude", "", "latitude", AppKey.VERSION, "versionCode", "logver", "abtest", "ffVersion", "<init>", "(Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork;Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/base/neuron/internal/model/pb/KRuntimeNetWork;Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getNetwork$annotations", "()V", "getNetwork", "()Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork;", "getOid$annotations", "getOid", "()Ljava/lang/String;", "getLongitude$annotations", "getLongitude", "()D", "getLatitude$annotations", "getLatitude", "getVersion$annotations", "getVersion", "getVersionCode$annotations", "getVersionCode", "getLogver$annotations", "getLogver", "getAbtest$annotations", "getAbtest", "getFfVersion$annotations", "getFfVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$neuron_debug", "Companion", "$serializer", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class KAppRuntimeInfo {
    public static final Companion Companion = new Companion(null);
    public static final String targetPath = "/AppRuntimeInfo";
    private final String abtest;
    private final String ffVersion;
    private final double latitude;
    private final String logver;
    private final double longitude;
    private final KRuntimeNetWork network;
    private final String oid;
    private final String version;
    private final String versionCode;

    public KAppRuntimeInfo() {
        this((KRuntimeNetWork) null, (String) null, 0.0d, 0.0d, (String) null, (String) null, (String) null, (String) null, (String) null, 511, (DefaultConstructorMarker) null);
    }

    @SerialName("abtest")
    @ProtoNumber(number = 8)
    public static /* synthetic */ void getAbtest$annotations() {
    }

    @SerialName("ffVersion")
    @ProtoNumber(number = ConstantsKt.SPACER_9)
    public static /* synthetic */ void getFfVersion$annotations() {
    }

    @SerialName("latitude")
    @ProtoNumber(number = 4)
    public static /* synthetic */ void getLatitude$annotations() {
    }

    @SerialName("logver")
    @ProtoNumber(number = AdditionalButton.CLICK_TYPE_FIELD_NUMBER)
    public static /* synthetic */ void getLogver$annotations() {
    }

    @SerialName("longitude")
    @ProtoNumber(number = 3)
    public static /* synthetic */ void getLongitude$annotations() {
    }

    @SerialName(CommonProjectType.NETWORK)
    @ProtoNumber(number = 1)
    public static /* synthetic */ void getNetwork$annotations() {
    }

    @SerialName("oid")
    @ProtoNumber(number = 2)
    public static /* synthetic */ void getOid$annotations() {
    }

    @SerialName(AppKey.VERSION)
    @ProtoNumber(number = 5)
    public static /* synthetic */ void getVersion$annotations() {
    }

    @SerialName("versionCode")
    @ProtoNumber(number = 6)
    public static /* synthetic */ void getVersionCode$annotations() {
    }

    public final KRuntimeNetWork component1() {
        return this.network;
    }

    public final String component2() {
        return this.oid;
    }

    public final double component3() {
        return this.longitude;
    }

    public final double component4() {
        return this.latitude;
    }

    public final String component5() {
        return this.version;
    }

    public final String component6() {
        return this.versionCode;
    }

    public final String component7() {
        return this.logver;
    }

    public final String component8() {
        return this.abtest;
    }

    public final String component9() {
        return this.ffVersion;
    }

    public final KAppRuntimeInfo copy(KRuntimeNetWork kRuntimeNetWork, String str, double d, double d2, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(kRuntimeNetWork, CommonProjectType.NETWORK);
        Intrinsics.checkNotNullParameter(str, "oid");
        Intrinsics.checkNotNullParameter(str2, AppKey.VERSION);
        Intrinsics.checkNotNullParameter(str3, "versionCode");
        Intrinsics.checkNotNullParameter(str4, "logver");
        Intrinsics.checkNotNullParameter(str5, "abtest");
        Intrinsics.checkNotNullParameter(str6, "ffVersion");
        return new KAppRuntimeInfo(kRuntimeNetWork, str, d, d2, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KAppRuntimeInfo) {
            KAppRuntimeInfo kAppRuntimeInfo = (KAppRuntimeInfo) obj;
            return Intrinsics.areEqual(this.network, kAppRuntimeInfo.network) && Intrinsics.areEqual(this.oid, kAppRuntimeInfo.oid) && Double.compare(this.longitude, kAppRuntimeInfo.longitude) == 0 && Double.compare(this.latitude, kAppRuntimeInfo.latitude) == 0 && Intrinsics.areEqual(this.version, kAppRuntimeInfo.version) && Intrinsics.areEqual(this.versionCode, kAppRuntimeInfo.versionCode) && Intrinsics.areEqual(this.logver, kAppRuntimeInfo.logver) && Intrinsics.areEqual(this.abtest, kAppRuntimeInfo.abtest) && Intrinsics.areEqual(this.ffVersion, kAppRuntimeInfo.ffVersion);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.network.hashCode() * 31) + this.oid.hashCode()) * 31) + DoubleList$.ExternalSyntheticBackport0.m(this.longitude)) * 31) + DoubleList$.ExternalSyntheticBackport0.m(this.latitude)) * 31) + this.version.hashCode()) * 31) + this.versionCode.hashCode()) * 31) + this.logver.hashCode()) * 31) + this.abtest.hashCode()) * 31) + this.ffVersion.hashCode();
    }

    public String toString() {
        KRuntimeNetWork kRuntimeNetWork = this.network;
        String str = this.oid;
        double d = this.longitude;
        double d2 = this.latitude;
        String str2 = this.version;
        String str3 = this.versionCode;
        String str4 = this.logver;
        String str5 = this.abtest;
        return "KAppRuntimeInfo(network=" + kRuntimeNetWork + ", oid=" + str + ", longitude=" + d + ", latitude=" + d2 + ", version=" + str2 + ", versionCode=" + str3 + ", logver=" + str4 + ", abtest=" + str5 + ", ffVersion=" + this.ffVersion + ")";
    }

    public /* synthetic */ KAppRuntimeInfo(int seen0, KRuntimeNetWork network, String oid, double longitude, double latitude, String version, String versionCode, String logver, String abtest, String ffVersion, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.network = KRuntimeNetWork.Companion.fromValue(0);
        } else {
            this.network = network;
        }
        if ((seen0 & 2) == 0) {
            this.oid = "";
        } else {
            this.oid = oid;
        }
        if ((seen0 & 4) == 0) {
            this.longitude = 0.0d;
        } else {
            this.longitude = longitude;
        }
        if ((seen0 & 8) == 0) {
            this.latitude = 0.0d;
        } else {
            this.latitude = latitude;
        }
        if ((seen0 & 16) == 0) {
            this.version = "";
        } else {
            this.version = version;
        }
        if ((seen0 & 32) == 0) {
            this.versionCode = "";
        } else {
            this.versionCode = versionCode;
        }
        if ((seen0 & 64) == 0) {
            this.logver = "";
        } else {
            this.logver = logver;
        }
        if ((seen0 & 128) == 0) {
            this.abtest = "";
        } else {
            this.abtest = abtest;
        }
        if ((seen0 & 256) == 0) {
            this.ffVersion = "";
        } else {
            this.ffVersion = ffVersion;
        }
    }

    public KAppRuntimeInfo(KRuntimeNetWork network, String oid, double longitude, double latitude, String version, String versionCode, String logver, String abtest, String ffVersion) {
        Intrinsics.checkNotNullParameter(network, CommonProjectType.NETWORK);
        Intrinsics.checkNotNullParameter(oid, "oid");
        Intrinsics.checkNotNullParameter(version, AppKey.VERSION);
        Intrinsics.checkNotNullParameter(versionCode, "versionCode");
        Intrinsics.checkNotNullParameter(logver, "logver");
        Intrinsics.checkNotNullParameter(abtest, "abtest");
        Intrinsics.checkNotNullParameter(ffVersion, "ffVersion");
        this.network = network;
        this.oid = oid;
        this.longitude = longitude;
        this.latitude = latitude;
        this.version = version;
        this.versionCode = versionCode;
        this.logver = logver;
        this.abtest = abtest;
        this.ffVersion = ffVersion;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$neuron_debug(KAppRuntimeInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.network, KRuntimeNetWork.Companion.fromValue(0))) {
            output.encodeSerializableElement(serialDesc, 0, KRuntimeNetWorkSerializer.INSTANCE, self.network);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.oid, "")) {
            output.encodeStringElement(serialDesc, 1, self.oid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || Double.compare(self.longitude, 0.0d) != 0) {
            output.encodeDoubleElement(serialDesc, 2, self.longitude);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || Double.compare(self.latitude, 0.0d) != 0) {
            output.encodeDoubleElement(serialDesc, 3, self.latitude);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.version, "")) {
            output.encodeStringElement(serialDesc, 4, self.version);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.versionCode, "")) {
            output.encodeStringElement(serialDesc, 5, self.versionCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.logver, "")) {
            output.encodeStringElement(serialDesc, 6, self.logver);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.abtest, "")) {
            output.encodeStringElement(serialDesc, 7, self.abtest);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.ffVersion, "")) {
            output.encodeStringElement(serialDesc, 8, self.ffVersion);
        }
    }

    public /* synthetic */ KAppRuntimeInfo(KRuntimeNetWork kRuntimeNetWork, String str, double d, double d2, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? KRuntimeNetWork.Companion.fromValue(0) : kRuntimeNetWork, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? 0.0d : d, (i & 8) == 0 ? d2 : 0.0d, (i & 16) != 0 ? "" : str2, (i & 32) != 0 ? "" : str3, (i & 64) != 0 ? "" : str4, (i & 128) != 0 ? "" : str5, (i & 256) == 0 ? str6 : "");
    }

    public final KRuntimeNetWork getNetwork() {
        return this.network;
    }

    public final String getOid() {
        return this.oid;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public final String getLogver() {
        return this.logver;
    }

    public final String getAbtest() {
        return this.abtest;
    }

    public final String getFfVersion() {
        return this.ffVersion;
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KAppRuntimeInfo$Companion;", "", "<init>", "()V", "targetPath", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/neuron/internal/model/pb/KAppRuntimeInfo;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<KAppRuntimeInfo> serializer() {
            return KAppRuntimeInfo$$serializer.INSTANCE;
        }
    }
}