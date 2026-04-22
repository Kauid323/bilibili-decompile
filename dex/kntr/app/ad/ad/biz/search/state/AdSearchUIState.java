package kntr.app.ad.ad.biz.search.state;

import kntr.app.ad.ad.biz.base.AdButtonState;
import kntr.app.ad.ad.biz.base.BaseAdUiState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: AdSearchUIState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lkntr/app/ad/ad/biz/search/state/AdSearchUIState;", "Lkntr/app/ad/ad/biz/base/BaseAdUiState;", "coverUrl", RoomRecommendViewModel.EMPTY_CURSOR, "title", "button", "Lkntr/app/ad/ad/biz/base/AdButtonState;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/ad/biz/base/AdButtonState;)V", "getCoverUrl", "()Ljava/lang/String;", "getTitle", "getButton", "()Lkntr/app/ad/ad/biz/base/AdButtonState;", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AdSearchUIState extends BaseAdUiState {
    public static final int $stable = BaseAdUiState.$stable | AdButtonState.$stable;
    private final AdButtonState button;
    private final String coverUrl;
    private final String title;

    public AdSearchUIState(String coverUrl, String title, AdButtonState button) {
        super(coverUrl, title, button);
        this.coverUrl = coverUrl;
        this.title = title;
        this.button = button;
    }

    @Override // kntr.app.ad.ad.biz.base.BaseAdUiState
    public String getCoverUrl() {
        return this.coverUrl;
    }

    @Override // kntr.app.ad.ad.biz.base.BaseAdUiState
    public String getTitle() {
        return this.title;
    }

    @Override // kntr.app.ad.ad.biz.base.BaseAdUiState
    public AdButtonState getButton() {
        return this.button;
    }
}