package kntr.app.digital.preview.api;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.ktor.KApiResponse;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetCardList.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bà\u0080\u0001\u0018\u00002\u00020\u0001:\u0001\bJ\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦B¢\u0006\u0002\u0010\u0007¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/app/digital/preview/api/GetCardList;", RoomRecommendViewModel.EMPTY_CURSOR, "invoke", "Lcom/bilibili/ktor/KApiResponse;", "Lkntr/app/digital/preview/api/CardPreviewModel;", "params", "Lkntr/app/digital/preview/api/GetCardList$RequestParams;", "(Lkntr/app/digital/preview/api/GetCardList$RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "RequestParams", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface GetCardList {
    Object invoke(RequestParams requestParams, Continuation<? super KApiResponse<CardPreviewModel>> continuation);

    /* compiled from: GetCardList.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006%"}, d2 = {"Lkntr/app/digital/preview/api/GetCardList$RequestParams;", RoomRecommendViewModel.EMPTY_CURSOR, "actId", RoomRecommendViewModel.EMPTY_CURSOR, "vmid", RoomRecommendViewModel.EMPTY_CURSOR, "lotteryId", "frontAnchorId", RoomRecommendViewModel.EMPTY_CURSOR, "backAnchorId", "extra", "direction", "<init>", "(IJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getActId", "()I", "getVmid", "()J", "getLotteryId", "getFrontAnchorId", "()Ljava/lang/String;", "getBackAnchorId", "getExtra", "getDirection", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class RequestParams {
        public static final int $stable = 0;
        private final int actId;
        private final String backAnchorId;
        private final int direction;
        private final String extra;
        private final String frontAnchorId;
        private final long lotteryId;
        private final long vmid;

        public final int component1() {
            return this.actId;
        }

        public final long component2() {
            return this.vmid;
        }

        public final long component3() {
            return this.lotteryId;
        }

        public final String component4() {
            return this.frontAnchorId;
        }

        public final String component5() {
            return this.backAnchorId;
        }

        public final String component6() {
            return this.extra;
        }

        public final int component7() {
            return this.direction;
        }

        public final RequestParams copy(int i, long j2, long j3, String str, String str2, String str3, int i2) {
            Intrinsics.checkNotNullParameter(str, "frontAnchorId");
            Intrinsics.checkNotNullParameter(str2, "backAnchorId");
            Intrinsics.checkNotNullParameter(str3, "extra");
            return new RequestParams(i, j2, j3, str, str2, str3, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RequestParams) {
                RequestParams requestParams = (RequestParams) obj;
                return this.actId == requestParams.actId && this.vmid == requestParams.vmid && this.lotteryId == requestParams.lotteryId && Intrinsics.areEqual(this.frontAnchorId, requestParams.frontAnchorId) && Intrinsics.areEqual(this.backAnchorId, requestParams.backAnchorId) && Intrinsics.areEqual(this.extra, requestParams.extra) && this.direction == requestParams.direction;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((this.actId * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.vmid)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.lotteryId)) * 31) + this.frontAnchorId.hashCode()) * 31) + this.backAnchorId.hashCode()) * 31) + this.extra.hashCode()) * 31) + this.direction;
        }

        public String toString() {
            int i = this.actId;
            long j2 = this.vmid;
            long j3 = this.lotteryId;
            String str = this.frontAnchorId;
            String str2 = this.backAnchorId;
            String str3 = this.extra;
            return "RequestParams(actId=" + i + ", vmid=" + j2 + ", lotteryId=" + j3 + ", frontAnchorId=" + str + ", backAnchorId=" + str2 + ", extra=" + str3 + ", direction=" + this.direction + ")";
        }

        public RequestParams(int actId, long vmid, long lotteryId, String frontAnchorId, String backAnchorId, String extra, int direction) {
            Intrinsics.checkNotNullParameter(frontAnchorId, "frontAnchorId");
            Intrinsics.checkNotNullParameter(backAnchorId, "backAnchorId");
            Intrinsics.checkNotNullParameter(extra, "extra");
            this.actId = actId;
            this.vmid = vmid;
            this.lotteryId = lotteryId;
            this.frontAnchorId = frontAnchorId;
            this.backAnchorId = backAnchorId;
            this.extra = extra;
            this.direction = direction;
        }

        public final int getActId() {
            return this.actId;
        }

        public final long getVmid() {
            return this.vmid;
        }

        public final long getLotteryId() {
            return this.lotteryId;
        }

        public final String getFrontAnchorId() {
            return this.frontAnchorId;
        }

        public final String getBackAnchorId() {
            return this.backAnchorId;
        }

        public final String getExtra() {
            return this.extra;
        }

        public final int getDirection() {
            return this.direction;
        }
    }
}