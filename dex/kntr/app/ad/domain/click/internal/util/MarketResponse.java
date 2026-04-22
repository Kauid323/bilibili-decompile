package kntr.app.ad.domain.click.internal.util;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarketHelper.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lkntr/app/ad/domain/click/internal/util/MarketResponse;", RoomRecommendViewModel.EMPTY_CURSOR, "url", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "Success", "Failed", "Lkntr/app/ad/domain/click/internal/util/MarketResponse$Failed;", "Lkntr/app/ad/domain/click/internal/util/MarketResponse$Success;", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class MarketResponse {
    private final String url;

    public /* synthetic */ MarketResponse(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private MarketResponse(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    /* compiled from: MarketHelper.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lkntr/app/ad/domain/click/internal/util/MarketResponse$Success;", "Lkntr/app/ad/domain/click/internal/util/MarketResponse;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "marketPkg", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getMarketPkg", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Success extends MarketResponse {
        private final String marketPkg;
        private final String url;

        public static /* synthetic */ Success copy$default(Success success, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.url;
            }
            if ((i & 2) != 0) {
                str2 = success.marketPkg;
            }
            return success.copy(str, str2);
        }

        public final String component1() {
            return this.url;
        }

        public final String component2() {
            return this.marketPkg;
        }

        public final Success copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "url");
            return new Success(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Success) {
                Success success = (Success) obj;
                return Intrinsics.areEqual(this.url, success.url) && Intrinsics.areEqual(this.marketPkg, success.marketPkg);
            }
            return false;
        }

        public int hashCode() {
            return (this.url.hashCode() * 31) + (this.marketPkg == null ? 0 : this.marketPkg.hashCode());
        }

        public String toString() {
            String str = this.url;
            return "Success(url=" + str + ", marketPkg=" + this.marketPkg + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String url, String marketPkg) {
            super(url, null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            this.marketPkg = marketPkg;
        }

        public /* synthetic */ Success(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }

        @Override // kntr.app.ad.domain.click.internal.util.MarketResponse
        public String getUrl() {
            return this.url;
        }

        public final String getMarketPkg() {
            return this.marketPkg;
        }
    }

    /* compiled from: MarketHelper.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/ad/domain/click/internal/util/MarketResponse$Failed;", "Lkntr/app/ad/domain/click/internal/util/MarketResponse;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Failed extends MarketResponse {
        private final String url;

        public static /* synthetic */ Failed copy$default(Failed failed, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failed.url;
            }
            return failed.copy(str);
        }

        public final String component1() {
            return this.url;
        }

        public final Failed copy(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            return new Failed(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failed) && Intrinsics.areEqual(this.url, ((Failed) obj).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "Failed(url=" + this.url + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(String url) {
            super(url, null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        @Override // kntr.app.ad.domain.click.internal.util.MarketResponse
        public String getUrl() {
            return this.url;
        }
    }
}