package kntr.app.cheese.space;

import BottomSheetItemData$;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kntr.app.cheese.space.api.PageData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PageState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/app/cheese/space/PageState;", RoomRecommendViewModel.EMPTY_CURSOR, "Loading", "Ready", "Failure", "Lkntr/app/cheese/space/PageState$Failure;", "Lkntr/app/cheese/space/PageState$Loading;", "Lkntr/app/cheese/space/PageState$Ready;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PageState {

    /* compiled from: PageState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/cheese/space/PageState$Loading;", "Lkntr/app/cheese/space/PageState;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Loading implements PageState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Loading) {
                Loading loading = (Loading) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -157590869;
        }

        public String toString() {
            return "Loading";
        }

        private Loading() {
        }
    }

    /* compiled from: PageState.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R+\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkntr/app/cheese/space/PageState$Ready;", "Lkntr/app/cheese/space/PageState;", "pageData", "Lkntr/app/cheese/space/api/PageData;", "<init>", "(Lkntr/app/cheese/space/api/PageData;)V", "getPageData", "()Lkntr/app/cheese/space/api/PageData;", "<set-?>", RoomRecommendViewModel.EMPTY_CURSOR, "refreshing", "getRefreshing", "()Z", "setRefreshing", "(Z)V", "refreshing$delegate", "Landroidx/compose/runtime/MutableState;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Ready implements PageState {
        public static final int $stable = 8;
        private final PageData pageData;
        private final MutableState refreshing$delegate;

        public Ready(PageData pageData) {
            Intrinsics.checkNotNullParameter(pageData, "pageData");
            this.pageData = pageData;
            this.refreshing$delegate = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        }

        public final PageData getPageData() {
            return this.pageData;
        }

        public final boolean getRefreshing() {
            State $this$getValue$iv = this.refreshing$delegate;
            return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
        }

        public final void setRefreshing(boolean z) {
            MutableState $this$setValue$iv = this.refreshing$delegate;
            Object value$iv = Boolean.valueOf(z);
            $this$setValue$iv.setValue(value$iv);
        }
    }

    /* compiled from: PageState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lkntr/app/cheese/space/PageState$Failure;", "Lkntr/app/cheese/space/PageState;", "isNetworkError", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Failure implements PageState {
        public static final int $stable = 0;
        private final boolean isNetworkError;

        public static /* synthetic */ Failure copy$default(Failure failure, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = failure.isNetworkError;
            }
            return failure.copy(z);
        }

        public final boolean component1() {
            return this.isNetworkError;
        }

        public final Failure copy(boolean z) {
            return new Failure(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failure) && this.isNetworkError == ((Failure) obj).isNetworkError;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isNetworkError);
        }

        public String toString() {
            return "Failure(isNetworkError=" + this.isNetworkError + ")";
        }

        public Failure(boolean isNetworkError) {
            this.isNetworkError = isNetworkError;
        }

        public final boolean isNetworkError() {
            return this.isNetworkError;
        }
    }
}