package kntr.app.ad.ad.biz.search.state;

import androidx.compose.ui.graphics.Color;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdSearch150CardState.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\b\u0012J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J4\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001¢\u0006\u0002\b\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lkntr/app/ad/ad/biz/search/state/AdSearch150CardState;", "Lkntr/app/ad/ad/biz/search/state/AdSearchUIState;", "coverUrl", RoomRecommendViewModel.EMPTY_CURSOR, "bgColor", "Landroidx/compose/ui/graphics/Color;", "buttonLabels", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Landroidx/compose/ui/graphics/Color;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCoverUrl", "()Ljava/lang/String;", "getBgColor-QN2ZGVo", "()Landroidx/compose/ui/graphics/Color;", "getButtonLabels", "()Ljava/util/List;", "component1", "component2", "component2-QN2ZGVo", "component3", "copy", "copy-bi-UJ9A", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdSearch150CardState extends AdSearchUIState {
    public static final int $stable = 8;
    private final Color bgColor;
    private final List<String> buttonLabels;
    private final String coverUrl;

    public /* synthetic */ AdSearch150CardState(String str, Color color, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, color, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-bi-UJ9A$default  reason: not valid java name */
    public static /* synthetic */ AdSearch150CardState m107copybiUJ9A$default(AdSearch150CardState adSearch150CardState, String str, Color color, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adSearch150CardState.coverUrl;
        }
        if ((i & 2) != 0) {
            color = adSearch150CardState.bgColor;
        }
        if ((i & 4) != 0) {
            list = adSearch150CardState.buttonLabels;
        }
        return adSearch150CardState.m109copybiUJ9A(str, color, list);
    }

    public final String component1() {
        return this.coverUrl;
    }

    /* renamed from: component2-QN2ZGVo  reason: not valid java name */
    public final Color m108component2QN2ZGVo() {
        return this.bgColor;
    }

    public final List<String> component3() {
        return this.buttonLabels;
    }

    /* renamed from: copy-bi-UJ9A  reason: not valid java name */
    public final AdSearch150CardState m109copybiUJ9A(String str, Color color, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "coverUrl");
        Intrinsics.checkNotNullParameter(list, "buttonLabels");
        return new AdSearch150CardState(str, color, list, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdSearch150CardState) {
            AdSearch150CardState adSearch150CardState = (AdSearch150CardState) obj;
            return Intrinsics.areEqual(this.coverUrl, adSearch150CardState.coverUrl) && Intrinsics.areEqual(this.bgColor, adSearch150CardState.bgColor) && Intrinsics.areEqual(this.buttonLabels, adSearch150CardState.buttonLabels);
        }
        return false;
    }

    public int hashCode() {
        return (((this.coverUrl.hashCode() * 31) + (this.bgColor == null ? 0 : Color.hashCode-impl(this.bgColor.unbox-impl()))) * 31) + this.buttonLabels.hashCode();
    }

    public String toString() {
        String str = this.coverUrl;
        Color color = this.bgColor;
        return "AdSearch150CardState(coverUrl=" + str + ", bgColor=" + color + ", buttonLabels=" + this.buttonLabels + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private AdSearch150CardState(String coverUrl, Color bgColor, List<String> list) {
        super(coverUrl, RoomRecommendViewModel.EMPTY_CURSOR, null);
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(list, "buttonLabels");
        this.coverUrl = coverUrl;
        this.bgColor = bgColor;
        this.buttonLabels = list;
    }

    public /* synthetic */ AdSearch150CardState(String str, Color color, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? null : color, (i & 4) != 0 ? CollectionsKt.emptyList() : list, null);
    }

    @Override // kntr.app.ad.ad.biz.search.state.AdSearchUIState, kntr.app.ad.ad.biz.base.BaseAdUiState
    public String getCoverUrl() {
        return this.coverUrl;
    }

    /* renamed from: getBgColor-QN2ZGVo  reason: not valid java name */
    public final Color m110getBgColorQN2ZGVo() {
        return this.bgColor;
    }

    public final List<String> getButtonLabels() {
        return this.buttonLabels;
    }
}