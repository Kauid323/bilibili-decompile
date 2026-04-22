package kntr.app.game.bean;

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

/* compiled from: SteamGameBean.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 92\u00020\u0001:\u000289BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fB_\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003JO\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u000eHÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001J%\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0001¢\u0006\u0002\b7R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0015R\u001c\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u0015¨\u0006:"}, d2 = {"Lkntr/app/game/bean/RecentAchievementItem;", RoomRecommendViewModel.EMPTY_CURSOR, "apiname", RoomRecommendViewModel.EMPTY_CURSOR, "iconUrl", "achievementName", "description", "unlockTime", RoomRecommendViewModel.EMPTY_CURSOR, "unlockTimeFormatted", "achievePercentFormatted", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getApiname$annotations", "()V", "getApiname", "()Ljava/lang/String;", "getIconUrl$annotations", "getIconUrl", "getAchievementName$annotations", "getAchievementName", "getDescription$annotations", "getDescription", "getUnlockTime$annotations", "getUnlockTime", "()J", "getUnlockTimeFormatted$annotations", "getUnlockTimeFormatted", "getAchievePercentFormatted$annotations", "getAchievePercentFormatted", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class RecentAchievementItem {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String achievePercentFormatted;
    private final String achievementName;
    private final String apiname;
    private final String description;
    private final String iconUrl;
    private final long unlockTime;
    private final String unlockTimeFormatted;

    public RecentAchievementItem() {
        this((String) null, (String) null, (String) null, (String) null, 0L, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    @SerialName("achieve_percent_formatted")
    public static /* synthetic */ void getAchievePercentFormatted$annotations() {
    }

    @SerialName("achievement_name")
    public static /* synthetic */ void getAchievementName$annotations() {
    }

    @SerialName("apiname")
    public static /* synthetic */ void getApiname$annotations() {
    }

    @SerialName("description")
    public static /* synthetic */ void getDescription$annotations() {
    }

    @SerialName("icon_url")
    public static /* synthetic */ void getIconUrl$annotations() {
    }

    @SerialName("unlock_time")
    public static /* synthetic */ void getUnlockTime$annotations() {
    }

    @SerialName("unlock_time_formatted")
    public static /* synthetic */ void getUnlockTimeFormatted$annotations() {
    }

    public final String component1() {
        return this.apiname;
    }

    public final String component2() {
        return this.iconUrl;
    }

    public final String component3() {
        return this.achievementName;
    }

    public final String component4() {
        return this.description;
    }

    public final long component5() {
        return this.unlockTime;
    }

    public final String component6() {
        return this.unlockTimeFormatted;
    }

    public final String component7() {
        return this.achievePercentFormatted;
    }

    public final RecentAchievementItem copy(String str, String str2, String str3, String str4, long j2, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "apiname");
        Intrinsics.checkNotNullParameter(str2, "iconUrl");
        Intrinsics.checkNotNullParameter(str3, "achievementName");
        Intrinsics.checkNotNullParameter(str4, "description");
        Intrinsics.checkNotNullParameter(str5, "unlockTimeFormatted");
        Intrinsics.checkNotNullParameter(str6, "achievePercentFormatted");
        return new RecentAchievementItem(str, str2, str3, str4, j2, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RecentAchievementItem) {
            RecentAchievementItem recentAchievementItem = (RecentAchievementItem) obj;
            return Intrinsics.areEqual(this.apiname, recentAchievementItem.apiname) && Intrinsics.areEqual(this.iconUrl, recentAchievementItem.iconUrl) && Intrinsics.areEqual(this.achievementName, recentAchievementItem.achievementName) && Intrinsics.areEqual(this.description, recentAchievementItem.description) && this.unlockTime == recentAchievementItem.unlockTime && Intrinsics.areEqual(this.unlockTimeFormatted, recentAchievementItem.unlockTimeFormatted) && Intrinsics.areEqual(this.achievePercentFormatted, recentAchievementItem.achievePercentFormatted);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.apiname.hashCode() * 31) + this.iconUrl.hashCode()) * 31) + this.achievementName.hashCode()) * 31) + this.description.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.unlockTime)) * 31) + this.unlockTimeFormatted.hashCode()) * 31) + this.achievePercentFormatted.hashCode();
    }

    public String toString() {
        String str = this.apiname;
        String str2 = this.iconUrl;
        String str3 = this.achievementName;
        String str4 = this.description;
        long j2 = this.unlockTime;
        String str5 = this.unlockTimeFormatted;
        return "RecentAchievementItem(apiname=" + str + ", iconUrl=" + str2 + ", achievementName=" + str3 + ", description=" + str4 + ", unlockTime=" + j2 + ", unlockTimeFormatted=" + str5 + ", achievePercentFormatted=" + this.achievePercentFormatted + ")";
    }

    /* compiled from: SteamGameBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/RecentAchievementItem$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/RecentAchievementItem;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<RecentAchievementItem> serializer() {
            return RecentAchievementItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ RecentAchievementItem(int seen0, String apiname, String iconUrl, String achievementName, String description, long unlockTime, String unlockTimeFormatted, String achievePercentFormatted, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.apiname = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.apiname = apiname;
        }
        if ((seen0 & 2) == 0) {
            this.iconUrl = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.iconUrl = iconUrl;
        }
        if ((seen0 & 4) == 0) {
            this.achievementName = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.achievementName = achievementName;
        }
        if ((seen0 & 8) == 0) {
            this.description = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.description = description;
        }
        if ((seen0 & 16) == 0) {
            this.unlockTime = 0L;
        } else {
            this.unlockTime = unlockTime;
        }
        if ((seen0 & 32) == 0) {
            this.unlockTimeFormatted = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.unlockTimeFormatted = unlockTimeFormatted;
        }
        if ((seen0 & 64) == 0) {
            this.achievePercentFormatted = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.achievePercentFormatted = achievePercentFormatted;
        }
    }

    public RecentAchievementItem(String apiname, String iconUrl, String achievementName, String description, long unlockTime, String unlockTimeFormatted, String achievePercentFormatted) {
        Intrinsics.checkNotNullParameter(apiname, "apiname");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(achievementName, "achievementName");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(unlockTimeFormatted, "unlockTimeFormatted");
        Intrinsics.checkNotNullParameter(achievePercentFormatted, "achievePercentFormatted");
        this.apiname = apiname;
        this.iconUrl = iconUrl;
        this.achievementName = achievementName;
        this.description = description;
        this.unlockTime = unlockTime;
        this.unlockTimeFormatted = unlockTimeFormatted;
        this.achievePercentFormatted = achievePercentFormatted;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(RecentAchievementItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.apiname, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 0, self.apiname);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.iconUrl, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 1, self.iconUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.achievementName, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.achievementName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.description, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 3, self.description);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.unlockTime != 0) {
            output.encodeLongElement(serialDesc, 4, self.unlockTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.unlockTimeFormatted, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 5, self.unlockTimeFormatted);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.achievePercentFormatted, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 6, self.achievePercentFormatted);
        }
    }

    public /* synthetic */ RecentAchievementItem(String str, String str2, String str3, String str4, long j2, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i & 8) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str4, (i & 16) != 0 ? 0L : j2, (i & 32) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str5, (i & 64) == 0 ? str6 : RoomRecommendViewModel.EMPTY_CURSOR);
    }

    public final String getApiname() {
        return this.apiname;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getAchievementName() {
        return this.achievementName;
    }

    public final String getDescription() {
        return this.description;
    }

    public final long getUnlockTime() {
        return this.unlockTime;
    }

    public final String getUnlockTimeFormatted() {
        return this.unlockTimeFormatted;
    }

    public final String getAchievePercentFormatted() {
        return this.achievePercentFormatted;
    }
}