package kntr.app.digital.preview;

import kntr.app.digital.preview.api.CardPreviewModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CardPreviewPageModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/app/digital/preview/PageState;", RoomRecommendViewModel.EMPTY_CURSOR, "Initial", "Ready", "Lkntr/app/digital/preview/PageState$Initial;", "Lkntr/app/digital/preview/PageState$Ready;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PageState {

    /* compiled from: CardPreviewPageModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/digital/preview/PageState$Initial;", "Lkntr/app/digital/preview/PageState;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Initial implements PageState {
        public static final int $stable = 0;
        public static final Initial INSTANCE = new Initial();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Initial) {
                Initial initial = (Initial) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 584492482;
        }

        public String toString() {
            return "Initial";
        }

        private Initial() {
        }
    }

    /* compiled from: CardPreviewPageModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/app/digital/preview/PageState$Ready;", "Lkntr/app/digital/preview/PageState;", "pageData", "Lkntr/app/digital/preview/api/CardPreviewModel;", "<init>", "(Lkntr/app/digital/preview/api/CardPreviewModel;)V", "getPageData", "()Lkntr/app/digital/preview/api/CardPreviewModel;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Ready implements PageState {
        public static final int $stable = 8;
        private final CardPreviewModel pageData;

        public Ready(CardPreviewModel pageData) {
            Intrinsics.checkNotNullParameter(pageData, "pageData");
            this.pageData = pageData;
        }

        public final CardPreviewModel getPageData() {
            return this.pageData;
        }
    }
}