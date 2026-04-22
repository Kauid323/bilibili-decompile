package kntr.app.ad.common.model;

import BottomSheetItemData$;
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

/* compiled from: AdAndroidGameInfo.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0002=>B{\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000f\u0010\u0010B{\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003J}\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u00101\u001a\u00020\u00032\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0012HÖ\u0001J\t\u00104\u001a\u00020\u0007HÖ\u0001J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001d¨\u0006?"}, d2 = {"Lkntr/app/ad/common/model/AdGameApkInfoModule;", RoomRecommendViewModel.EMPTY_CURSOR, "display", RoomRecommendViewModel.EMPTY_CURSOR, "pkgSize", RoomRecommendViewModel.EMPTY_CURSOR, "pkgName", RoomRecommendViewModel.EMPTY_CURSOR, "customerService", "website", "authority", "privacy", "developerName", "updateTime", "gameVersion", "<init>", "(ZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDisplay", "()Z", "getPkgSize", "()J", "getPkgName$annotations", "()V", "getPkgName", "()Ljava/lang/String;", "getCustomerService$annotations", "getCustomerService", "getWebsite", "getAuthority", "getPrivacy", "getDeveloperName", "getUpdateTime", "getGameVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdGameApkInfoModule {
    public static final Companion Companion = new Companion(null);
    private final String authority;
    private final String customerService;
    private final String developerName;
    private final boolean display;
    private final String gameVersion;
    private final String pkgName;
    private final long pkgSize;
    private final String privacy;
    private final String updateTime;
    private final String website;

    public AdGameApkInfoModule() {
        this(false, 0L, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 1023, (DefaultConstructorMarker) null);
    }

    @SerialName("customer_service")
    public static /* synthetic */ void getCustomerService$annotations() {
    }

    @SerialName("android_pkg_name")
    public static /* synthetic */ void getPkgName$annotations() {
    }

    public final boolean component1() {
        return this.display;
    }

    public final String component10() {
        return this.gameVersion;
    }

    public final long component2() {
        return this.pkgSize;
    }

    public final String component3() {
        return this.pkgName;
    }

    public final String component4() {
        return this.customerService;
    }

    public final String component5() {
        return this.website;
    }

    public final String component6() {
        return this.authority;
    }

    public final String component7() {
        return this.privacy;
    }

    public final String component8() {
        return this.developerName;
    }

    public final String component9() {
        return this.updateTime;
    }

    public final AdGameApkInfoModule copy(boolean z, long j2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return new AdGameApkInfoModule(z, j2, str, str2, str3, str4, str5, str6, str7, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdGameApkInfoModule) {
            AdGameApkInfoModule adGameApkInfoModule = (AdGameApkInfoModule) obj;
            return this.display == adGameApkInfoModule.display && this.pkgSize == adGameApkInfoModule.pkgSize && Intrinsics.areEqual(this.pkgName, adGameApkInfoModule.pkgName) && Intrinsics.areEqual(this.customerService, adGameApkInfoModule.customerService) && Intrinsics.areEqual(this.website, adGameApkInfoModule.website) && Intrinsics.areEqual(this.authority, adGameApkInfoModule.authority) && Intrinsics.areEqual(this.privacy, adGameApkInfoModule.privacy) && Intrinsics.areEqual(this.developerName, adGameApkInfoModule.developerName) && Intrinsics.areEqual(this.updateTime, adGameApkInfoModule.updateTime) && Intrinsics.areEqual(this.gameVersion, adGameApkInfoModule.gameVersion);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.display) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.pkgSize)) * 31) + (this.pkgName == null ? 0 : this.pkgName.hashCode())) * 31) + (this.customerService == null ? 0 : this.customerService.hashCode())) * 31) + (this.website == null ? 0 : this.website.hashCode())) * 31) + (this.authority == null ? 0 : this.authority.hashCode())) * 31) + (this.privacy == null ? 0 : this.privacy.hashCode())) * 31) + (this.developerName == null ? 0 : this.developerName.hashCode())) * 31) + (this.updateTime == null ? 0 : this.updateTime.hashCode())) * 31) + (this.gameVersion != null ? this.gameVersion.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.display;
        long j2 = this.pkgSize;
        String str = this.pkgName;
        String str2 = this.customerService;
        String str3 = this.website;
        String str4 = this.authority;
        String str5 = this.privacy;
        String str6 = this.developerName;
        String str7 = this.updateTime;
        return "AdGameApkInfoModule(display=" + z + ", pkgSize=" + j2 + ", pkgName=" + str + ", customerService=" + str2 + ", website=" + str3 + ", authority=" + str4 + ", privacy=" + str5 + ", developerName=" + str6 + ", updateTime=" + str7 + ", gameVersion=" + this.gameVersion + ")";
    }

    /* compiled from: AdAndroidGameInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdGameApkInfoModule$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdGameApkInfoModule;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdGameApkInfoModule> serializer() {
            return AdGameApkInfoModule$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdGameApkInfoModule(int seen0, boolean display, long pkgSize, String pkgName, String customerService, String website, String authority, String privacy, String developerName, String updateTime, String gameVersion, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.display = true;
        } else {
            this.display = display;
        }
        if ((seen0 & 2) == 0) {
            this.pkgSize = 0L;
        } else {
            this.pkgSize = pkgSize;
        }
        if ((seen0 & 4) == 0) {
            this.pkgName = null;
        } else {
            this.pkgName = pkgName;
        }
        if ((seen0 & 8) == 0) {
            this.customerService = null;
        } else {
            this.customerService = customerService;
        }
        if ((seen0 & 16) == 0) {
            this.website = null;
        } else {
            this.website = website;
        }
        if ((seen0 & 32) == 0) {
            this.authority = null;
        } else {
            this.authority = authority;
        }
        if ((seen0 & 64) == 0) {
            this.privacy = null;
        } else {
            this.privacy = privacy;
        }
        if ((seen0 & 128) == 0) {
            this.developerName = null;
        } else {
            this.developerName = developerName;
        }
        if ((seen0 & 256) == 0) {
            this.updateTime = null;
        } else {
            this.updateTime = updateTime;
        }
        if ((seen0 & 512) == 0) {
            this.gameVersion = null;
        } else {
            this.gameVersion = gameVersion;
        }
    }

    public AdGameApkInfoModule(boolean display, long pkgSize, String pkgName, String customerService, String website, String authority, String privacy, String developerName, String updateTime, String gameVersion) {
        this.display = display;
        this.pkgSize = pkgSize;
        this.pkgName = pkgName;
        this.customerService = customerService;
        this.website = website;
        this.authority = authority;
        this.privacy = privacy;
        this.developerName = developerName;
        this.updateTime = updateTime;
        this.gameVersion = gameVersion;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdGameApkInfoModule self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !self.display) {
            output.encodeBooleanElement(serialDesc, 0, self.display);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.pkgSize != 0) {
            output.encodeLongElement(serialDesc, 1, self.pkgSize);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.pkgName != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.pkgName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.customerService != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.customerService);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.website != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.website);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.authority != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.authority);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.privacy != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.privacy);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.developerName != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.developerName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.updateTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.updateTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.gameVersion != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.gameVersion);
        }
    }

    public /* synthetic */ AdGameApkInfoModule(boolean z, long j2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? 0L : j2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) == 0 ? str8 : null);
    }

    public final boolean getDisplay() {
        return this.display;
    }

    public final long getPkgSize() {
        return this.pkgSize;
    }

    public final String getPkgName() {
        return this.pkgName;
    }

    public final String getCustomerService() {
        return this.customerService;
    }

    public final String getWebsite() {
        return this.website;
    }

    public final String getAuthority() {
        return this.authority;
    }

    public final String getPrivacy() {
        return this.privacy;
    }

    public final String getDeveloperName() {
        return this.developerName;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final String getGameVersion() {
        return this.gameVersion;
    }
}