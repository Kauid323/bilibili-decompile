package kntr.app.ad.common.model;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdWhiteApk.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 L2\u00020\u0001:\u0002KLB\u00ad\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0012\u0010\u0013B!\b\u0017\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0012\u0010\u0014B¥\u0001\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0012\u0010\u0019J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J¯\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0016HÖ\u0001J\t\u0010B\u001a\u00020\u0005HÖ\u0001J%\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0001¢\u0006\u0002\bJR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u001d\u001a\u0004\b,\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001f¨\u0006M"}, d2 = {"Lkntr/app/ad/common/model/AdWhiteApk;", RoomRecommendViewModel.EMPTY_CURSOR, "size", RoomRecommendViewModel.EMPTY_CURSOR, "displayName", RoomRecommendViewModel.EMPTY_CURSOR, "apkName", "url", "biliURL", "md5", "icon", "devName", "authUrl", "version", "updateTime", "authDesc", "privacyUrl", "privacyName", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSize", "()J", "getDisplayName$annotations", "()V", "getDisplayName", "()Ljava/lang/String;", "getApkName", "getUrl$annotations", "getUrl", "getBiliURL$annotations", "getBiliURL", "getMd5", "getIcon", "getDevName", "getAuthUrl", "getVersion", "getUpdateTime", "getAuthDesc$annotations", "getAuthDesc", "getPrivacyUrl", "getPrivacyName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdWhiteApk {
    public static final Companion Companion = new Companion(null);
    private final String apkName;
    private final String authDesc;
    private final String authUrl;
    private final String biliURL;
    private final String devName;
    private final String displayName;
    private final String icon;
    private final String md5;
    private final String privacyName;
    private final String privacyUrl;
    private final long size;
    private final String updateTime;
    private final String url;
    private final String version;

    public AdWhiteApk() {
        this(0L, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16383, (DefaultConstructorMarker) null);
    }

    @SerialName("auth_name")
    public static /* synthetic */ void getAuthDesc$annotations() {
    }

    @SerialName("bili_url")
    public static /* synthetic */ void getBiliURL$annotations() {
    }

    public static /* synthetic */ void getDisplayName$annotations() {
    }

    public static /* synthetic */ void getUrl$annotations() {
    }

    public final long component1() {
        return this.size;
    }

    public final String component10() {
        return this.version;
    }

    public final String component11() {
        return this.updateTime;
    }

    public final String component12() {
        return this.authDesc;
    }

    public final String component13() {
        return this.privacyUrl;
    }

    public final String component14() {
        return this.privacyName;
    }

    public final String component2() {
        return this.displayName;
    }

    public final String component3() {
        return this.apkName;
    }

    public final String component4() {
        return this.url;
    }

    public final String component5() {
        return this.biliURL;
    }

    public final String component6() {
        return this.md5;
    }

    public final String component7() {
        return this.icon;
    }

    public final String component8() {
        return this.devName;
    }

    public final String component9() {
        return this.authUrl;
    }

    public final AdWhiteApk copy(long j2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        return new AdWhiteApk(j2, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdWhiteApk) {
            AdWhiteApk adWhiteApk = (AdWhiteApk) obj;
            return this.size == adWhiteApk.size && Intrinsics.areEqual(this.displayName, adWhiteApk.displayName) && Intrinsics.areEqual(this.apkName, adWhiteApk.apkName) && Intrinsics.areEqual(this.url, adWhiteApk.url) && Intrinsics.areEqual(this.biliURL, adWhiteApk.biliURL) && Intrinsics.areEqual(this.md5, adWhiteApk.md5) && Intrinsics.areEqual(this.icon, adWhiteApk.icon) && Intrinsics.areEqual(this.devName, adWhiteApk.devName) && Intrinsics.areEqual(this.authUrl, adWhiteApk.authUrl) && Intrinsics.areEqual(this.version, adWhiteApk.version) && Intrinsics.areEqual(this.updateTime, adWhiteApk.updateTime) && Intrinsics.areEqual(this.authDesc, adWhiteApk.authDesc) && Intrinsics.areEqual(this.privacyUrl, adWhiteApk.privacyUrl) && Intrinsics.areEqual(this.privacyName, adWhiteApk.privacyName);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.size) * 31) + (this.displayName == null ? 0 : this.displayName.hashCode())) * 31) + (this.apkName == null ? 0 : this.apkName.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.biliURL == null ? 0 : this.biliURL.hashCode())) * 31) + (this.md5 == null ? 0 : this.md5.hashCode())) * 31) + (this.icon == null ? 0 : this.icon.hashCode())) * 31) + (this.devName == null ? 0 : this.devName.hashCode())) * 31) + (this.authUrl == null ? 0 : this.authUrl.hashCode())) * 31) + (this.version == null ? 0 : this.version.hashCode())) * 31) + (this.updateTime == null ? 0 : this.updateTime.hashCode())) * 31) + (this.authDesc == null ? 0 : this.authDesc.hashCode())) * 31) + (this.privacyUrl == null ? 0 : this.privacyUrl.hashCode())) * 31) + (this.privacyName != null ? this.privacyName.hashCode() : 0);
    }

    public String toString() {
        long j2 = this.size;
        String str = this.displayName;
        String str2 = this.apkName;
        String str3 = this.url;
        String str4 = this.biliURL;
        String str5 = this.md5;
        String str6 = this.icon;
        String str7 = this.devName;
        String str8 = this.authUrl;
        String str9 = this.version;
        String str10 = this.updateTime;
        String str11 = this.authDesc;
        String str12 = this.privacyUrl;
        return "AdWhiteApk(size=" + j2 + ", displayName=" + str + ", apkName=" + str2 + ", url=" + str3 + ", biliURL=" + str4 + ", md5=" + str5 + ", icon=" + str6 + ", devName=" + str7 + ", authUrl=" + str8 + ", version=" + str9 + ", updateTime=" + str10 + ", authDesc=" + str11 + ", privacyUrl=" + str12 + ", privacyName=" + this.privacyName + ")";
    }

    /* compiled from: AdWhiteApk.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdWhiteApk$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdWhiteApk;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdWhiteApk> serializer() {
            return AdWhiteApk$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdWhiteApk(int seen0, long size, String displayName, String apkName, String url, String biliURL, String md5, String icon, String devName, String authUrl, String version, String updateTime, String authDesc, String privacyUrl, String privacyName, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.size = 0L;
        } else {
            this.size = size;
        }
        if ((seen0 & 2) == 0) {
            this.displayName = null;
        } else {
            this.displayName = displayName;
        }
        if ((seen0 & 4) == 0) {
            this.apkName = null;
        } else {
            this.apkName = apkName;
        }
        if ((seen0 & 8) == 0) {
            this.url = null;
        } else {
            this.url = url;
        }
        if ((seen0 & 16) == 0) {
            this.biliURL = null;
        } else {
            this.biliURL = biliURL;
        }
        if ((seen0 & 32) == 0) {
            this.md5 = null;
        } else {
            this.md5 = md5;
        }
        if ((seen0 & 64) == 0) {
            this.icon = null;
        } else {
            this.icon = icon;
        }
        if ((seen0 & 128) == 0) {
            this.devName = null;
        } else {
            this.devName = devName;
        }
        if ((seen0 & 256) == 0) {
            this.authUrl = null;
        } else {
            this.authUrl = authUrl;
        }
        if ((seen0 & 512) == 0) {
            this.version = null;
        } else {
            this.version = version;
        }
        if ((seen0 & 1024) == 0) {
            this.updateTime = null;
        } else {
            this.updateTime = updateTime;
        }
        if ((seen0 & 2048) == 0) {
            this.authDesc = null;
        } else {
            this.authDesc = authDesc;
        }
        if ((seen0 & 4096) == 0) {
            this.privacyUrl = null;
        } else {
            this.privacyUrl = privacyUrl;
        }
        if ((seen0 & 8192) == 0) {
            this.privacyName = null;
        } else {
            this.privacyName = privacyName;
        }
    }

    public AdWhiteApk(long size, String displayName, String apkName, String url, String biliURL, String md5, String icon, String devName, String authUrl, String version, String updateTime, String authDesc, String privacyUrl, String privacyName) {
        this.size = size;
        this.displayName = displayName;
        this.apkName = apkName;
        this.url = url;
        this.biliURL = biliURL;
        this.md5 = md5;
        this.icon = icon;
        this.devName = devName;
        this.authUrl = authUrl;
        this.version = version;
        this.updateTime = updateTime;
        this.authDesc = authDesc;
        this.privacyUrl = privacyUrl;
        this.privacyName = privacyName;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdWhiteApk self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.size != 0) {
            output.encodeLongElement(serialDesc, 0, self.size);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.displayName != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.displayName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.apkName != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.apkName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.url != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.biliURL != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.biliURL);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.md5 != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.md5);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.icon != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.icon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.devName != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.devName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.authUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.authUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.version != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.version);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.updateTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.updateTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.authDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.authDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.privacyUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.privacyUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.privacyName != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.privacyName);
        }
    }

    public /* synthetic */ AdWhiteApk(long j2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j2, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : str11, (i & 4096) != 0 ? null : str12, (i & 8192) == 0 ? str13 : null);
    }

    public final long getSize() {
        return this.size;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getApkName() {
        return this.apkName;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getBiliURL() {
        return this.biliURL;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getDevName() {
        return this.devName;
    }

    public final String getAuthUrl() {
        return this.authUrl;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final String getAuthDesc() {
        return this.authDesc;
    }

    public final String getPrivacyUrl() {
        return this.privacyUrl;
    }

    public final String getPrivacyName() {
        return this.privacyName;
    }

    public /* synthetic */ AdWhiteApk(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public AdWhiteApk(String displayName, String url) {
        this(0L, displayName, null, url, null, null, null, null, null, null, null, null, null, null);
    }
}