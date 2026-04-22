package kntr.app.game.bean;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: SteamGameAchievementBean.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 D2\u00020\u0001:\u0002CDBW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fBe\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0013J\u0006\u0010,\u001a\u00020\u0003J\u0006\u0010-\u001a\u00020\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\t\u00104\u001a\u00020\u000bHÆ\u0003J\t\u00105\u001a\u00020\rHÆ\u0003JY\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u00107\u001a\u00020\u000b2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\tHÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001J%\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0001¢\u0006\u0002\bBR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017R\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\"R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0015\u001a\u0004\b\n\u0010$R\u001c\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0015\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b)\u0010$R\u0011\u0010*\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b+\u0010\u0017¨\u0006E"}, d2 = {"Lkntr/app/game/bean/AchievementDetail;", RoomRecommendViewModel.EMPTY_CURSOR, "achievementApi", RoomRecommendViewModel.EMPTY_CURSOR, "achievementName", "achievementDesc", "icon", "achievePercent", "achievedInt", RoomRecommendViewModel.EMPTY_CURSOR, "isRare", RoomRecommendViewModel.EMPTY_CURSOR, "unlockTime", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZJ)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAchievementApi$annotations", "()V", "getAchievementApi", "()Ljava/lang/String;", "getAchievementName$annotations", "getAchievementName", "getAchievementDesc$annotations", "getAchievementDesc", "getIcon$annotations", "getIcon", "getAchievePercent$annotations", "getAchievePercent", "getAchievedInt$annotations", "getAchievedInt", "()I", "isRare$annotations", "()Z", "getUnlockTime$annotations", "getUnlockTime", "()J", "achieved", "getAchieved", "achievePercentFormatted", "getAchievePercentFormatted", "getUnlockTimeFormatted", "getIconUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AchievementDetail {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String achievePercent;
    private final int achievedInt;
    private final String achievementApi;
    private final String achievementDesc;
    private final String achievementName;
    private final String icon;
    private final boolean isRare;
    private final long unlockTime;

    public AchievementDetail() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 0, false, 0L, 255, (DefaultConstructorMarker) null);
    }

    @SerialName("achieve_percent")
    public static /* synthetic */ void getAchievePercent$annotations() {
    }

    @SerialName("achieved")
    public static /* synthetic */ void getAchievedInt$annotations() {
    }

    @SerialName("achievement_api")
    public static /* synthetic */ void getAchievementApi$annotations() {
    }

    @SerialName("description")
    public static /* synthetic */ void getAchievementDesc$annotations() {
    }

    @SerialName("achievement_name")
    public static /* synthetic */ void getAchievementName$annotations() {
    }

    @SerialName("icon")
    public static /* synthetic */ void getIcon$annotations() {
    }

    @SerialName("unlock_time")
    public static /* synthetic */ void getUnlockTime$annotations() {
    }

    @SerialName("is_rare")
    public static /* synthetic */ void isRare$annotations() {
    }

    public final String component1() {
        return this.achievementApi;
    }

    public final String component2() {
        return this.achievementName;
    }

    public final String component3() {
        return this.achievementDesc;
    }

    public final String component4() {
        return this.icon;
    }

    public final String component5() {
        return this.achievePercent;
    }

    public final int component6() {
        return this.achievedInt;
    }

    public final boolean component7() {
        return this.isRare;
    }

    public final long component8() {
        return this.unlockTime;
    }

    public final AchievementDetail copy(String str, String str2, String str3, String str4, String str5, int i, boolean z, long j2) {
        Intrinsics.checkNotNullParameter(str, "achievementApi");
        Intrinsics.checkNotNullParameter(str2, "achievementName");
        Intrinsics.checkNotNullParameter(str3, "achievementDesc");
        Intrinsics.checkNotNullParameter(str4, "icon");
        Intrinsics.checkNotNullParameter(str5, "achievePercent");
        return new AchievementDetail(str, str2, str3, str4, str5, i, z, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AchievementDetail) {
            AchievementDetail achievementDetail = (AchievementDetail) obj;
            return Intrinsics.areEqual(this.achievementApi, achievementDetail.achievementApi) && Intrinsics.areEqual(this.achievementName, achievementDetail.achievementName) && Intrinsics.areEqual(this.achievementDesc, achievementDetail.achievementDesc) && Intrinsics.areEqual(this.icon, achievementDetail.icon) && Intrinsics.areEqual(this.achievePercent, achievementDetail.achievePercent) && this.achievedInt == achievementDetail.achievedInt && this.isRare == achievementDetail.isRare && this.unlockTime == achievementDetail.unlockTime;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.achievementApi.hashCode() * 31) + this.achievementName.hashCode()) * 31) + this.achievementDesc.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.achievePercent.hashCode()) * 31) + this.achievedInt) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isRare)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.unlockTime);
    }

    public String toString() {
        String str = this.achievementApi;
        String str2 = this.achievementName;
        String str3 = this.achievementDesc;
        String str4 = this.icon;
        String str5 = this.achievePercent;
        int i = this.achievedInt;
        boolean z = this.isRare;
        return "AchievementDetail(achievementApi=" + str + ", achievementName=" + str2 + ", achievementDesc=" + str3 + ", icon=" + str4 + ", achievePercent=" + str5 + ", achievedInt=" + i + ", isRare=" + z + ", unlockTime=" + this.unlockTime + ")";
    }

    /* compiled from: SteamGameAchievementBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/AchievementDetail$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/AchievementDetail;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AchievementDetail> serializer() {
            return AchievementDetail$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AchievementDetail(int seen0, String achievementApi, String achievementName, String achievementDesc, String icon, String achievePercent, int achievedInt, boolean isRare, long unlockTime, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.achievementApi = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.achievementApi = achievementApi;
        }
        if ((seen0 & 2) == 0) {
            this.achievementName = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.achievementName = achievementName;
        }
        if ((seen0 & 4) == 0) {
            this.achievementDesc = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.achievementDesc = achievementDesc;
        }
        if ((seen0 & 8) == 0) {
            this.icon = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.icon = icon;
        }
        if ((seen0 & 16) == 0) {
            this.achievePercent = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.achievePercent = achievePercent;
        }
        if ((seen0 & 32) == 0) {
            this.achievedInt = 0;
        } else {
            this.achievedInt = achievedInt;
        }
        if ((seen0 & 64) == 0) {
            this.isRare = false;
        } else {
            this.isRare = isRare;
        }
        if ((seen0 & 128) == 0) {
            this.unlockTime = 0L;
        } else {
            this.unlockTime = unlockTime;
        }
    }

    public AchievementDetail(String achievementApi, String achievementName, String achievementDesc, String icon, String achievePercent, int achievedInt, boolean isRare, long unlockTime) {
        Intrinsics.checkNotNullParameter(achievementApi, "achievementApi");
        Intrinsics.checkNotNullParameter(achievementName, "achievementName");
        Intrinsics.checkNotNullParameter(achievementDesc, "achievementDesc");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(achievePercent, "achievePercent");
        this.achievementApi = achievementApi;
        this.achievementName = achievementName;
        this.achievementDesc = achievementDesc;
        this.icon = icon;
        this.achievePercent = achievePercent;
        this.achievedInt = achievedInt;
        this.isRare = isRare;
        this.unlockTime = unlockTime;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(AchievementDetail self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.achievementApi, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 0, self.achievementApi);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.achievementName, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 1, self.achievementName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.achievementDesc, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.achievementDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.icon, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 3, self.icon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.achievePercent, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 4, self.achievePercent);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.achievedInt != 0) {
            output.encodeIntElement(serialDesc, 5, self.achievedInt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.isRare) {
            output.encodeBooleanElement(serialDesc, 6, self.isRare);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.unlockTime != 0) {
            output.encodeLongElement(serialDesc, 7, self.unlockTime);
        }
    }

    public /* synthetic */ AchievementDetail(String str, String str2, String str3, String str4, String str5, int i, boolean z, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i2 & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i2 & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i2 & 8) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str4, (i2 & 16) == 0 ? str5 : RoomRecommendViewModel.EMPTY_CURSOR, (i2 & 32) != 0 ? 0 : i, (i2 & 64) == 0 ? z : false, (i2 & 128) != 0 ? 0L : j2);
    }

    public final String getAchievementApi() {
        return this.achievementApi;
    }

    public final String getAchievementName() {
        return this.achievementName;
    }

    public final String getAchievementDesc() {
        return this.achievementDesc;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getAchievePercent() {
        return this.achievePercent;
    }

    public final int getAchievedInt() {
        return this.achievedInt;
    }

    public final boolean isRare() {
        return this.isRare;
    }

    public final long getUnlockTime() {
        return this.unlockTime;
    }

    public final boolean getAchieved() {
        return this.achievedInt == 1;
    }

    public final String getAchievePercentFormatted() {
        return this.achievePercent;
    }

    public final String getUnlockTimeFormatted() {
        if (this.unlockTime <= 0) {
            return RoomRecommendViewModel.EMPTY_CURSOR;
        }
        Instant instant = Instant.Companion.fromEpochSeconds$default(Instant.Companion, this.unlockTime, 0L, 2, (Object) null);
        LocalDateTime dateTime = TimeZoneKt.toLocalDateTime(instant, TimeZone.Companion.currentSystemDefault());
        String month = StringsKt.padStart(String.valueOf(dateTime.getMonthNumber()), 2, '0');
        String day = StringsKt.padStart(String.valueOf(dateTime.getDayOfMonth()), 2, '0');
        String hour = StringsKt.padStart(String.valueOf(dateTime.getHour()), 2, '0');
        String minute = StringsKt.padStart(String.valueOf(dateTime.getMinute()), 2, '0');
        return dateTime.getYear() + "." + month + "." + day + " " + hour + ":" + minute;
    }

    public final String getIconUrl() {
        return this.icon;
    }
}