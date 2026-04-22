package kntr.app.live.room.multivideo;

import com.bapis.bilibili.live.app.room.v1.KUniversalInfoResp;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiVideoStoreV2.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lkntr/app/live/room/multivideo/LiveRoomMultiVideoStateV2;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Content", "multivideo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class LiveRoomMultiVideoStateV2 {

    /* compiled from: MultiVideoStoreV2.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lkntr/app/live/room/multivideo/LiveRoomMultiVideoStateV2$Content;", "Lkntr/app/live/room/multivideo/LiveRoomMultiVideoStateV2;", "info", "Lcom/bapis/bilibili/live/app/room/v1/KUniversalInfoResp;", "<init>", "(Lcom/bapis/bilibili/live/app/room/v1/KUniversalInfoResp;)V", "getInfo$annotations", "()V", "getInfo", "()Lcom/bapis/bilibili/live/app/room/v1/KUniversalInfoResp;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "multivideo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Content extends LiveRoomMultiVideoStateV2 {
        private final KUniversalInfoResp info;

        public static /* synthetic */ Content copy$default(Content content, KUniversalInfoResp kUniversalInfoResp, int i, Object obj) {
            if ((i & 1) != 0) {
                kUniversalInfoResp = content.info;
            }
            return content.copy(kUniversalInfoResp);
        }

        public static /* synthetic */ void getInfo$annotations() {
        }

        public final KUniversalInfoResp component1() {
            return this.info;
        }

        public final Content copy(KUniversalInfoResp kUniversalInfoResp) {
            Intrinsics.checkNotNullParameter(kUniversalInfoResp, "info");
            return new Content(kUniversalInfoResp);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Content) && Intrinsics.areEqual(this.info, ((Content) obj).info);
        }

        public int hashCode() {
            return this.info.hashCode();
        }

        public String toString() {
            return "Content(info=" + this.info + ")";
        }

        public Content(KUniversalInfoResp info) {
            Intrinsics.checkNotNullParameter(info, "info");
            this.info = info;
        }

        public final KUniversalInfoResp getInfo() {
            return this.info;
        }
    }
}