package kntr.app.ad.ad.biz.videodetail.endpage;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: VDEndPageStore.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageEvent;", RoomRecommendViewModel.EMPTY_CURSOR, "OnShown", "OnStrictShown", "CardClick", "ButtonClick", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageEvent$ButtonClick;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageEvent$CardClick;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageEvent$OnShown;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageEvent$OnStrictShown;", "videodetail_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface VDEndPageEvent {

    /* compiled from: VDEndPageStore.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageEvent$OnShown;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageEvent;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "videodetail_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class OnShown implements VDEndPageEvent {
        public static final int $stable = 0;
        public static final OnShown INSTANCE = new OnShown();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof OnShown) {
                OnShown onShown = (OnShown) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 967777981;
        }

        public String toString() {
            return "OnShown";
        }

        private OnShown() {
        }
    }

    /* compiled from: VDEndPageStore.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageEvent$OnStrictShown;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageEvent;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "videodetail_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class OnStrictShown implements VDEndPageEvent {
        public static final int $stable = 0;
        public static final OnStrictShown INSTANCE = new OnStrictShown();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof OnStrictShown) {
                OnStrictShown onStrictShown = (OnStrictShown) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 169391220;
        }

        public String toString() {
            return "OnStrictShown";
        }

        private OnStrictShown() {
        }
    }

    /* compiled from: VDEndPageStore.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageEvent$CardClick;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageEvent;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "videodetail_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CardClick implements VDEndPageEvent {
        public static final int $stable = 0;
        public static final CardClick INSTANCE = new CardClick();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CardClick) {
                CardClick cardClick = (CardClick) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1353014813;
        }

        public String toString() {
            return "CardClick";
        }

        private CardClick() {
        }
    }

    /* compiled from: VDEndPageStore.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageEvent$ButtonClick;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageEvent;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "videodetail_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ButtonClick implements VDEndPageEvent {
        public static final int $stable = 0;
        public static final ButtonClick INSTANCE = new ButtonClick();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ButtonClick) {
                ButtonClick buttonClick = (ButtonClick) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -2087320511;
        }

        public String toString() {
            return "ButtonClick";
        }

        private ButtonClick() {
        }
    }
}