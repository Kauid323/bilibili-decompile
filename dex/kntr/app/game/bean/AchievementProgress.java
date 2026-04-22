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

/* compiled from: SteamGameBean.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002/0B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nBO\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u0015\u001a\u00020\u001cJ\u0006\u0010\u0012\u001a\u00020\u001cJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003JA\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\fHÖ\u0001J\t\u0010&\u001a\u00020\u001cHÖ\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0018¨\u00061"}, d2 = {"Lkntr/app/game/bean/AchievementProgress;", RoomRecommendViewModel.EMPTY_CURSOR, "rareProgress", "Lkntr/app/game/bean/ProgressInfo;", "commonProgress", "rareAchievements", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/game/bean/AchievementItem;", "commonAchievements", "<init>", "(Lkntr/app/game/bean/ProgressInfo;Lkntr/app/game/bean/ProgressInfo;Ljava/util/List;Ljava/util/List;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/game/bean/ProgressInfo;Lkntr/app/game/bean/ProgressInfo;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRareProgress$annotations", "()V", "getRareProgress", "()Lkntr/app/game/bean/ProgressInfo;", "getCommonProgress$annotations", "getCommonProgress", "getRareAchievements$annotations", "getRareAchievements", "()Ljava/util/List;", "getCommonAchievements$annotations", "getCommonAchievements", "getTotalProgress", RoomRecommendViewModel.EMPTY_CURSOR, "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AchievementProgress {
    private final List<AchievementItem> commonAchievements;
    private final ProgressInfo commonProgress;
    private final List<AchievementItem> rareAchievements;
    private final ProgressInfo rareProgress;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.game.bean.AchievementProgress$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AchievementProgress._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.game.bean.AchievementProgress$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = AchievementProgress._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    })};

    public AchievementProgress() {
        this((ProgressInfo) null, (ProgressInfo) null, (List) null, (List) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AchievementProgress copy$default(AchievementProgress achievementProgress, ProgressInfo progressInfo, ProgressInfo progressInfo2, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            progressInfo = achievementProgress.rareProgress;
        }
        if ((i & 2) != 0) {
            progressInfo2 = achievementProgress.commonProgress;
        }
        if ((i & 4) != 0) {
            list = achievementProgress.rareAchievements;
        }
        if ((i & 8) != 0) {
            list2 = achievementProgress.commonAchievements;
        }
        return achievementProgress.copy(progressInfo, progressInfo2, list, list2);
    }

    @SerialName("common_achievements")
    public static /* synthetic */ void getCommonAchievements$annotations() {
    }

    @SerialName("common_progress")
    public static /* synthetic */ void getCommonProgress$annotations() {
    }

    @SerialName("rare_achievements")
    public static /* synthetic */ void getRareAchievements$annotations() {
    }

    @SerialName("rare_progress")
    public static /* synthetic */ void getRareProgress$annotations() {
    }

    public final ProgressInfo component1() {
        return this.rareProgress;
    }

    public final ProgressInfo component2() {
        return this.commonProgress;
    }

    public final List<AchievementItem> component3() {
        return this.rareAchievements;
    }

    public final List<AchievementItem> component4() {
        return this.commonAchievements;
    }

    public final AchievementProgress copy(ProgressInfo progressInfo, ProgressInfo progressInfo2, List<AchievementItem> list, List<AchievementItem> list2) {
        Intrinsics.checkNotNullParameter(list, "rareAchievements");
        Intrinsics.checkNotNullParameter(list2, "commonAchievements");
        return new AchievementProgress(progressInfo, progressInfo2, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AchievementProgress) {
            AchievementProgress achievementProgress = (AchievementProgress) obj;
            return Intrinsics.areEqual(this.rareProgress, achievementProgress.rareProgress) && Intrinsics.areEqual(this.commonProgress, achievementProgress.commonProgress) && Intrinsics.areEqual(this.rareAchievements, achievementProgress.rareAchievements) && Intrinsics.areEqual(this.commonAchievements, achievementProgress.commonAchievements);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.rareProgress == null ? 0 : this.rareProgress.hashCode()) * 31) + (this.commonProgress != null ? this.commonProgress.hashCode() : 0)) * 31) + this.rareAchievements.hashCode()) * 31) + this.commonAchievements.hashCode();
    }

    public String toString() {
        ProgressInfo progressInfo = this.rareProgress;
        ProgressInfo progressInfo2 = this.commonProgress;
        List<AchievementItem> list = this.rareAchievements;
        return "AchievementProgress(rareProgress=" + progressInfo + ", commonProgress=" + progressInfo2 + ", rareAchievements=" + list + ", commonAchievements=" + this.commonAchievements + ")";
    }

    /* compiled from: SteamGameBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/AchievementProgress$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/AchievementProgress;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AchievementProgress> serializer() {
            return AchievementProgress$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AchievementProgress(int seen0, ProgressInfo rareProgress, ProgressInfo commonProgress, List rareAchievements, List commonAchievements, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.rareProgress = null;
        } else {
            this.rareProgress = rareProgress;
        }
        if ((seen0 & 2) == 0) {
            this.commonProgress = null;
        } else {
            this.commonProgress = commonProgress;
        }
        if ((seen0 & 4) == 0) {
            this.rareAchievements = CollectionsKt.emptyList();
        } else {
            this.rareAchievements = rareAchievements;
        }
        if ((seen0 & 8) == 0) {
            this.commonAchievements = CollectionsKt.emptyList();
        } else {
            this.commonAchievements = commonAchievements;
        }
    }

    public AchievementProgress(ProgressInfo rareProgress, ProgressInfo commonProgress, List<AchievementItem> list, List<AchievementItem> list2) {
        Intrinsics.checkNotNullParameter(list, "rareAchievements");
        Intrinsics.checkNotNullParameter(list2, "commonAchievements");
        this.rareProgress = rareProgress;
        this.commonProgress = commonProgress;
        this.rareAchievements = list;
        this.commonAchievements = list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(AchievementItem$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(AchievementItem$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(AchievementProgress self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.rareProgress != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, ProgressInfo$$serializer.INSTANCE, self.rareProgress);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.commonProgress != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, ProgressInfo$$serializer.INSTANCE, self.commonProgress);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.rareAchievements, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.rareAchievements);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.commonAchievements, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.commonAchievements);
        }
    }

    public /* synthetic */ AchievementProgress(ProgressInfo progressInfo, ProgressInfo progressInfo2, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : progressInfo, (i & 2) != 0 ? null : progressInfo2, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* renamed from: getRareProgress  reason: collision with other method in class */
    public final ProgressInfo m1145getRareProgress() {
        return this.rareProgress;
    }

    /* renamed from: getCommonProgress  reason: collision with other method in class */
    public final ProgressInfo m1144getCommonProgress() {
        return this.commonProgress;
    }

    public final List<AchievementItem> getRareAchievements() {
        return this.rareAchievements;
    }

    public final List<AchievementItem> getCommonAchievements() {
        return this.commonAchievements;
    }

    public final String getTotalProgress() {
        ProgressInfo progressInfo = this.rareProgress;
        int rare = progressInfo != null ? progressInfo.getCompletedCount() : 0;
        ProgressInfo progressInfo2 = this.commonProgress;
        int common = progressInfo2 != null ? progressInfo2.getCompletedCount() : 0;
        ProgressInfo progressInfo3 = this.rareProgress;
        int rareTotal = progressInfo3 != null ? progressInfo3.getTotalCount() : 0;
        ProgressInfo progressInfo4 = this.commonProgress;
        int commonTotal = progressInfo4 != null ? progressInfo4.getTotalCount() : 0;
        return (rare + common) + " / " + (rareTotal + commonTotal);
    }

    public final String getCommonProgress() {
        ProgressInfo progressInfo = this.commonProgress;
        int completed = progressInfo != null ? progressInfo.getCompletedCount() : 0;
        ProgressInfo progressInfo2 = this.commonProgress;
        int total = progressInfo2 != null ? progressInfo2.getTotalCount() : 0;
        return completed + " / " + total;
    }

    public final String getRareProgress() {
        ProgressInfo progressInfo = this.rareProgress;
        int completed = progressInfo != null ? progressInfo.getCompletedCount() : 0;
        ProgressInfo progressInfo2 = this.rareProgress;
        int total = progressInfo2 != null ? progressInfo2.getTotalCount() : 0;
        return completed + " / " + total;
    }
}