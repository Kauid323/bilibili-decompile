package kntr.app.game.bean;

import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: SteamGameAchievementBean.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B-\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nB=\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J/\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Lkntr/app/game/bean/GameAchievementsData;", RoomRecommendViewModel.EMPTY_CURSOR, "header", "Lkntr/app/game/bean/AchievementHeader;", "totalCount", RoomRecommendViewModel.EMPTY_CURSOR, "achievements", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/game/bean/AchievementDetail;", "<init>", "(Lkntr/app/game/bean/AchievementHeader;ILjava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/game/bean/AchievementHeader;ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getHeader$annotations", "()V", "getHeader", "()Lkntr/app/game/bean/AchievementHeader;", "getTotalCount$annotations", "getTotalCount", "()I", "getAchievements$annotations", "getAchievements", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class GameAchievementsData {
    private final List<AchievementDetail> achievements;
    private final AchievementHeader header;
    private final int totalCount;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.game.bean.GameAchievementsData$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = GameAchievementsData._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public GameAchievementsData() {
        this((AchievementHeader) null, 0, (List) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GameAchievementsData copy$default(GameAchievementsData gameAchievementsData, AchievementHeader achievementHeader, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            achievementHeader = gameAchievementsData.header;
        }
        if ((i2 & 2) != 0) {
            i = gameAchievementsData.totalCount;
        }
        if ((i2 & 4) != 0) {
            list = gameAchievementsData.achievements;
        }
        return gameAchievementsData.copy(achievementHeader, i, list);
    }

    @SerialName("achievements")
    public static /* synthetic */ void getAchievements$annotations() {
    }

    @SerialName("header")
    public static /* synthetic */ void getHeader$annotations() {
    }

    @SerialName("total_count")
    public static /* synthetic */ void getTotalCount$annotations() {
    }

    public final AchievementHeader component1() {
        return this.header;
    }

    public final int component2() {
        return this.totalCount;
    }

    public final List<AchievementDetail> component3() {
        return this.achievements;
    }

    public final GameAchievementsData copy(AchievementHeader achievementHeader, int i, List<AchievementDetail> list) {
        Intrinsics.checkNotNullParameter(list, "achievements");
        return new GameAchievementsData(achievementHeader, i, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GameAchievementsData) {
            GameAchievementsData gameAchievementsData = (GameAchievementsData) obj;
            return Intrinsics.areEqual(this.header, gameAchievementsData.header) && this.totalCount == gameAchievementsData.totalCount && Intrinsics.areEqual(this.achievements, gameAchievementsData.achievements);
        }
        return false;
    }

    public int hashCode() {
        return ((((this.header == null ? 0 : this.header.hashCode()) * 31) + this.totalCount) * 31) + this.achievements.hashCode();
    }

    public String toString() {
        AchievementHeader achievementHeader = this.header;
        int i = this.totalCount;
        return "GameAchievementsData(header=" + achievementHeader + ", totalCount=" + i + ", achievements=" + this.achievements + ")";
    }

    /* compiled from: SteamGameAchievementBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/GameAchievementsData$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/GameAchievementsData;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<GameAchievementsData> serializer() {
            return GameAchievementsData$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ GameAchievementsData(int seen0, AchievementHeader header, int totalCount, List achievements, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.header = null;
        } else {
            this.header = header;
        }
        if ((seen0 & 2) == 0) {
            this.totalCount = 0;
        } else {
            this.totalCount = totalCount;
        }
        if ((seen0 & 4) == 0) {
            this.achievements = CollectionsKt.emptyList();
        } else {
            this.achievements = achievements;
        }
    }

    public GameAchievementsData(AchievementHeader header, int totalCount, List<AchievementDetail> list) {
        Intrinsics.checkNotNullParameter(list, "achievements");
        this.header = header;
        this.totalCount = totalCount;
        this.achievements = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(AchievementDetail$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(GameAchievementsData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.header != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, AchievementHeader$$serializer.INSTANCE, self.header);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.totalCount != 0) {
            output.encodeIntElement(serialDesc, 1, self.totalCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.achievements, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.achievements);
        }
    }

    public /* synthetic */ GameAchievementsData(AchievementHeader achievementHeader, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : achievementHeader, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final AchievementHeader getHeader() {
        return this.header;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final List<AchievementDetail> getAchievements() {
        return this.achievements;
    }
}