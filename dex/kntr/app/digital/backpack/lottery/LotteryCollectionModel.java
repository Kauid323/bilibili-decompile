package kntr.app.digital.backpack.lottery;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LotteryCollectionModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/app/digital/backpack/lottery/LotteryCollectionModel;", RoomRecommendViewModel.EMPTY_CURSOR, "list", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/backpack/lottery/LotteryCollectionModel$CardPool;", "<init>", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "CardPool", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LotteryCollectionModel {
    public static final int $stable = 8;
    private final List<CardPool> list;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LotteryCollectionModel copy$default(LotteryCollectionModel lotteryCollectionModel, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = lotteryCollectionModel.list;
        }
        return lotteryCollectionModel.copy(list);
    }

    public final List<CardPool> component1() {
        return this.list;
    }

    public final LotteryCollectionModel copy(List<CardPool> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return new LotteryCollectionModel(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LotteryCollectionModel) && Intrinsics.areEqual(this.list, ((LotteryCollectionModel) obj).list);
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    public String toString() {
        return "LotteryCollectionModel(list=" + this.list + ")";
    }

    public LotteryCollectionModel(List<CardPool> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
    }

    public final List<CardPool> getList() {
        return this.list;
    }

    /* compiled from: LotteryCollectionModel.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/app/digital/backpack/lottery/LotteryCollectionModel$CardPool;", RoomRecommendViewModel.EMPTY_CURSOR, "lotteryId", RoomRecommendViewModel.EMPTY_CURSOR, "lotteryName", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(JLjava/lang/String;)V", "getLotteryId", "()J", "getLotteryName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CardPool {
        public static final int $stable = 0;
        private final long lotteryId;
        private final String lotteryName;

        public static /* synthetic */ CardPool copy$default(CardPool cardPool, long j2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j2 = cardPool.lotteryId;
            }
            if ((i & 2) != 0) {
                str = cardPool.lotteryName;
            }
            return cardPool.copy(j2, str);
        }

        public final long component1() {
            return this.lotteryId;
        }

        public final String component2() {
            return this.lotteryName;
        }

        public final CardPool copy(long j2, String str) {
            Intrinsics.checkNotNullParameter(str, "lotteryName");
            return new CardPool(j2, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CardPool) {
                CardPool cardPool = (CardPool) obj;
                return this.lotteryId == cardPool.lotteryId && Intrinsics.areEqual(this.lotteryName, cardPool.lotteryName);
            }
            return false;
        }

        public int hashCode() {
            return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.lotteryId) * 31) + this.lotteryName.hashCode();
        }

        public String toString() {
            long j2 = this.lotteryId;
            return "CardPool(lotteryId=" + j2 + ", lotteryName=" + this.lotteryName + ")";
        }

        public CardPool(long lotteryId, String lotteryName) {
            Intrinsics.checkNotNullParameter(lotteryName, "lotteryName");
            this.lotteryId = lotteryId;
            this.lotteryName = lotteryName;
        }

        public final long getLotteryId() {
            return this.lotteryId;
        }

        public final String getLotteryName() {
            return this.lotteryName;
        }
    }
}