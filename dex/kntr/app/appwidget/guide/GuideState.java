package kntr.app.appwidget.guide;

import com.bapis.bilibili.app.show.mixture.v1.KGuideItem;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GuideState.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lkntr/app/appwidget/guide/GuideState;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Idle", "NoGuide", "PerformAction", "Dismiss", "Lkntr/app/appwidget/guide/GuideState$Dismiss;", "Lkntr/app/appwidget/guide/GuideState$Idle;", "Lkntr/app/appwidget/guide/GuideState$NoGuide;", "Lkntr/app/appwidget/guide/GuideState$PerformAction;", "guide_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class GuideState {
    public static final int $stable = 0;

    public /* synthetic */ GuideState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: GuideState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/appwidget/guide/GuideState$Idle;", "Lkntr/app/appwidget/guide/GuideState;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "guide_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Idle extends GuideState {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Idle) {
                Idle idle = (Idle) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 767732376;
        }

        public String toString() {
            return "Idle";
        }

        private Idle() {
            super(null);
        }
    }

    private GuideState() {
    }

    /* compiled from: GuideState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/appwidget/guide/GuideState$NoGuide;", "Lkntr/app/appwidget/guide/GuideState;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "guide_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class NoGuide extends GuideState {
        public static final int $stable = 0;
        public static final NoGuide INSTANCE = new NoGuide();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NoGuide) {
                NoGuide noGuide = (NoGuide) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1238244471;
        }

        public String toString() {
            return "NoGuide";
        }

        private NoGuide() {
            super(null);
        }
    }

    /* compiled from: GuideState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lkntr/app/appwidget/guide/GuideState$PerformAction;", "Lkntr/app/appwidget/guide/GuideState;", "item", "Lcom/bapis/bilibili/app/show/mixture/v1/KGuideItem;", "<init>", "(Lcom/bapis/bilibili/app/show/mixture/v1/KGuideItem;)V", "getItem$annotations", "()V", "getItem", "()Lcom/bapis/bilibili/app/show/mixture/v1/KGuideItem;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "guide_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class PerformAction extends GuideState {
        public static final int $stable = 8;
        private final KGuideItem item;

        public static /* synthetic */ PerformAction copy$default(PerformAction performAction, KGuideItem kGuideItem, int i, Object obj) {
            if ((i & 1) != 0) {
                kGuideItem = performAction.item;
            }
            return performAction.copy(kGuideItem);
        }

        public static /* synthetic */ void getItem$annotations() {
        }

        public final KGuideItem component1() {
            return this.item;
        }

        public final PerformAction copy(KGuideItem kGuideItem) {
            return new PerformAction(kGuideItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PerformAction) && Intrinsics.areEqual(this.item, ((PerformAction) obj).item);
        }

        public int hashCode() {
            if (this.item == null) {
                return 0;
            }
            return this.item.hashCode();
        }

        public String toString() {
            return "PerformAction(item=" + this.item + ")";
        }

        public PerformAction(KGuideItem item) {
            super(null);
            this.item = item;
        }

        public final KGuideItem getItem() {
            return this.item;
        }
    }

    /* compiled from: GuideState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/appwidget/guide/GuideState$Dismiss;", "Lkntr/app/appwidget/guide/GuideState;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "guide_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Dismiss extends GuideState {
        public static final int $stable = 0;
        public static final Dismiss INSTANCE = new Dismiss();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Dismiss) {
                Dismiss dismiss = (Dismiss) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 821764422;
        }

        public String toString() {
            return "Dismiss";
        }

        private Dismiss() {
            super(null);
        }
    }
}