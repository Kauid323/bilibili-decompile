package kntr.app.ad.common.model;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdGameInfo.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000245Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rBu\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ju\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u000fHÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J%\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014¨\u00066"}, d2 = {"Lkntr/app/ad/common/model/AdGameInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "gameLogo", RoomRecommendViewModel.EMPTY_CURSOR, "gameName", "gameDesc", "privacyName", "privacyUrl", "authorName", "authorUrl", "developerName", "gameVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGameLogo", "()Ljava/lang/String;", "getGameName", "getGameDesc", "getPrivacyName", "getPrivacyUrl", "getAuthorName", "getAuthorUrl", "getDeveloperName", "getGameVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdGameInfo {
    public static final Companion Companion = new Companion(null);
    private final String authorName;
    private final String authorUrl;
    private final String developerName;
    private final String gameDesc;
    private final String gameLogo;
    private final String gameName;
    private final String gameVersion;
    private final String privacyName;
    private final String privacyUrl;

    public AdGameInfo() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 511, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.gameLogo;
    }

    public final String component2() {
        return this.gameName;
    }

    public final String component3() {
        return this.gameDesc;
    }

    public final String component4() {
        return this.privacyName;
    }

    public final String component5() {
        return this.privacyUrl;
    }

    public final String component6() {
        return this.authorName;
    }

    public final String component7() {
        return this.authorUrl;
    }

    public final String component8() {
        return this.developerName;
    }

    public final String component9() {
        return this.gameVersion;
    }

    public final AdGameInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        return new AdGameInfo(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdGameInfo) {
            AdGameInfo adGameInfo = (AdGameInfo) obj;
            return Intrinsics.areEqual(this.gameLogo, adGameInfo.gameLogo) && Intrinsics.areEqual(this.gameName, adGameInfo.gameName) && Intrinsics.areEqual(this.gameDesc, adGameInfo.gameDesc) && Intrinsics.areEqual(this.privacyName, adGameInfo.privacyName) && Intrinsics.areEqual(this.privacyUrl, adGameInfo.privacyUrl) && Intrinsics.areEqual(this.authorName, adGameInfo.authorName) && Intrinsics.areEqual(this.authorUrl, adGameInfo.authorUrl) && Intrinsics.areEqual(this.developerName, adGameInfo.developerName) && Intrinsics.areEqual(this.gameVersion, adGameInfo.gameVersion);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((this.gameLogo == null ? 0 : this.gameLogo.hashCode()) * 31) + (this.gameName == null ? 0 : this.gameName.hashCode())) * 31) + (this.gameDesc == null ? 0 : this.gameDesc.hashCode())) * 31) + (this.privacyName == null ? 0 : this.privacyName.hashCode())) * 31) + (this.privacyUrl == null ? 0 : this.privacyUrl.hashCode())) * 31) + (this.authorName == null ? 0 : this.authorName.hashCode())) * 31) + (this.authorUrl == null ? 0 : this.authorUrl.hashCode())) * 31) + (this.developerName == null ? 0 : this.developerName.hashCode())) * 31) + (this.gameVersion != null ? this.gameVersion.hashCode() : 0);
    }

    public String toString() {
        String str = this.gameLogo;
        String str2 = this.gameName;
        String str3 = this.gameDesc;
        String str4 = this.privacyName;
        String str5 = this.privacyUrl;
        String str6 = this.authorName;
        String str7 = this.authorUrl;
        String str8 = this.developerName;
        return "AdGameInfo(gameLogo=" + str + ", gameName=" + str2 + ", gameDesc=" + str3 + ", privacyName=" + str4 + ", privacyUrl=" + str5 + ", authorName=" + str6 + ", authorUrl=" + str7 + ", developerName=" + str8 + ", gameVersion=" + this.gameVersion + ")";
    }

    /* compiled from: AdGameInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdGameInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdGameInfo;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdGameInfo> serializer() {
            return AdGameInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdGameInfo(int seen0, String gameLogo, String gameName, String gameDesc, String privacyName, String privacyUrl, String authorName, String authorUrl, String developerName, String gameVersion, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.gameLogo = null;
        } else {
            this.gameLogo = gameLogo;
        }
        if ((seen0 & 2) == 0) {
            this.gameName = null;
        } else {
            this.gameName = gameName;
        }
        if ((seen0 & 4) == 0) {
            this.gameDesc = null;
        } else {
            this.gameDesc = gameDesc;
        }
        if ((seen0 & 8) == 0) {
            this.privacyName = null;
        } else {
            this.privacyName = privacyName;
        }
        if ((seen0 & 16) == 0) {
            this.privacyUrl = null;
        } else {
            this.privacyUrl = privacyUrl;
        }
        if ((seen0 & 32) == 0) {
            this.authorName = null;
        } else {
            this.authorName = authorName;
        }
        if ((seen0 & 64) == 0) {
            this.authorUrl = null;
        } else {
            this.authorUrl = authorUrl;
        }
        if ((seen0 & 128) == 0) {
            this.developerName = null;
        } else {
            this.developerName = developerName;
        }
        if ((seen0 & 256) == 0) {
            this.gameVersion = null;
        } else {
            this.gameVersion = gameVersion;
        }
    }

    public AdGameInfo(String gameLogo, String gameName, String gameDesc, String privacyName, String privacyUrl, String authorName, String authorUrl, String developerName, String gameVersion) {
        this.gameLogo = gameLogo;
        this.gameName = gameName;
        this.gameDesc = gameDesc;
        this.privacyName = privacyName;
        this.privacyUrl = privacyUrl;
        this.authorName = authorName;
        this.authorUrl = authorUrl;
        this.developerName = developerName;
        this.gameVersion = gameVersion;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdGameInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.gameLogo != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.gameLogo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.gameName != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.gameName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.gameDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.gameDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.privacyName != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.privacyName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.privacyUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.privacyUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.authorName != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.authorName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.authorUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.authorUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.developerName != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.developerName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.gameVersion != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.gameVersion);
        }
    }

    public /* synthetic */ AdGameInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) == 0 ? str9 : null);
    }

    public final String getGameLogo() {
        return this.gameLogo;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final String getGameDesc() {
        return this.gameDesc;
    }

    public final String getPrivacyName() {
        return this.privacyName;
    }

    public final String getPrivacyUrl() {
        return this.privacyUrl;
    }

    public final String getAuthorName() {
        return this.authorName;
    }

    public final String getAuthorUrl() {
        return this.authorUrl;
    }

    public final String getDeveloperName() {
        return this.developerName;
    }

    public final String getGameVersion() {
        return this.gameVersion;
    }
}