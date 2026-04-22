package kntr.app.ad.ad.biz.search.vm;

import androidx.compose.ui.graphics.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kntr.app.ad.ad.biz.base.interfaces.IAdFeedback;
import kntr.app.ad.ad.biz.search.interfaces.IAdSearchReporter;
import kntr.app.ad.ad.biz.search.state.AdSearch150CardState;
import kntr.app.ad.common.model.AdButton;
import kntr.app.ad.common.model.AdCover;
import kntr.app.ad.common.model.AdSearchBean;
import kntr.app.ad.common.protocol.IExtraInfo;
import kntr.app.ad.common.protocol.IRenderable;
import kntr.app.ad.domain.click.ClickService;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.ad.protocol.IMotion;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AdSearch150CardModel.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J5\u0010 \u001a\u00020\u001a2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010%¢\u0006\u0002\b&J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H\u0016J\u0016\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010+0*H\u0016J\u0016\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010+0*H\u0016J\u0016\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010+0*H\u0016J\u001e\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010+0*2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lkntr/app/ad/ad/biz/search/vm/AdSearch150CardModel;", "Lkntr/app/ad/ad/biz/search/vm/AdSearchCardModel;", "Lkntr/app/ad/ad/biz/search/state/AdSearch150CardState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "adSearchInfo", "Lkntr/app/ad/common/model/AdSearchBean;", "iAdFeedback", "Lkntr/app/ad/ad/biz/base/interfaces/IAdFeedback;", "clickService", "Lkntr/app/ad/domain/click/ClickService;", "immerseColor", "Landroidx/compose/ui/graphics/Color;", "adSearchReporter", "Lkntr/app/ad/ad/biz/search/interfaces/IAdSearchReporter;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkntr/app/ad/common/model/AdSearchBean;Lkntr/app/ad/ad/biz/base/interfaces/IAdFeedback;Lkntr/app/ad/domain/click/ClickService;JLkntr/app/ad/ad/biz/search/interfaces/IAdSearchReporter;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getAdSearchInfo", "()Lkntr/app/ad/common/model/AdSearchBean;", "getIAdFeedback", "()Lkntr/app/ad/ad/biz/base/interfaces/IAdFeedback;", "J", "createInitialState", "handleCardClick", RoomRecommendViewModel.EMPTY_CURSOR, "motion", "Lkntr/app/ad/protocol/IMotion;", "onChooseButtonClick", "index", RoomRecommendViewModel.EMPTY_CURSOR, "updateState", "coverUrl", RoomRecommendViewModel.EMPTY_CURSOR, "bgColor", "buttonLabels", RoomRecommendViewModel.EMPTY_CURSOR, "updateState-bi-UJ9A", "copy", "currentState", "commonFeeParams", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "commonUIParams", "cardClickArgParams", "chooseButtonClickParams", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdSearch150CardModel extends AdSearchCardModel<AdSearch150CardState> {
    public static final int $stable = 8;
    private final AdSearchBean adSearchInfo;
    private final IAdSearchReporter adSearchReporter;
    private final ClickService clickService;
    private final CoroutineScope coroutineScope;
    private final IAdFeedback iAdFeedback;
    private final long immerseColor;

    public /* synthetic */ AdSearch150CardModel(CoroutineScope coroutineScope, AdSearchBean adSearchBean, IAdFeedback iAdFeedback, ClickService clickService, long j2, IAdSearchReporter iAdSearchReporter, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, adSearchBean, iAdFeedback, clickService, j2, iAdSearchReporter);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private AdSearch150CardModel(CoroutineScope coroutineScope, AdSearchBean adSearchInfo, IAdFeedback iAdFeedback, ClickService clickService, long immerseColor, IAdSearchReporter adSearchReporter) {
        super(coroutineScope, adSearchInfo, iAdFeedback, clickService);
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
        this.adSearchInfo = adSearchInfo;
        this.iAdFeedback = iAdFeedback;
        this.clickService = clickService;
        this.immerseColor = immerseColor;
        this.adSearchReporter = adSearchReporter;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ AdSearch150CardModel(CoroutineScope coroutineScope, AdSearchBean adSearchBean, IAdFeedback iAdFeedback, ClickService clickService, long j2, IAdSearchReporter iAdSearchReporter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, adSearchBean, iAdFeedback, clickService, j2, r8, null);
        IAdSearchReporter iAdSearchReporter2;
        if ((i & 32) == 0) {
            iAdSearchReporter2 = iAdSearchReporter;
        } else {
            iAdSearchReporter2 = null;
        }
    }

    @Override // kntr.app.ad.ad.biz.search.vm.AdSearchCardModel
    public CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @Override // kntr.app.ad.ad.biz.search.vm.AdSearchCardModel
    public AdSearchBean getAdSearchInfo() {
        return this.adSearchInfo;
    }

    @Override // kntr.app.ad.ad.biz.search.vm.AdSearchCardModel
    public IAdFeedback getIAdFeedback() {
        return this.iAdFeedback;
    }

    @Override // kntr.app.ad.ad.biz.base.BaseAdCardModel
    public AdSearch150CardState createInitialState() {
        String str;
        List emptyList;
        IExtraInfo extra;
        IRenderable card;
        Iterable chooseBtnList;
        IExtraInfo extra2;
        IRenderable card2;
        List<AdCover> covers;
        AdCover adCover;
        AdSearchBean adSearchInfo = getAdSearchInfo();
        if (adSearchInfo == null || (extra2 = adSearchInfo.getExtra()) == null || (card2 = extra2.getCard()) == null || (covers = card2.getCovers()) == null || (adCover = (AdCover) CollectionsKt.firstOrNull(covers)) == null || (str = adCover.getUrl()) == null) {
            str = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        Color color = Color.box-impl(this.immerseColor);
        AdSearchBean adSearchInfo2 = getAdSearchInfo();
        if (adSearchInfo2 == null || (extra = adSearchInfo2.getExtra()) == null || (card = extra.getCard()) == null || (chooseBtnList = card.getChooseBtnList()) == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            Iterable $this$mapNotNull$iv = chooseBtnList;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                AdButton it = (AdButton) element$iv$iv$iv;
                String text = it != null ? it.getText() : null;
                if (text != null) {
                    destination$iv$iv.add(text);
                }
            }
            emptyList = (List) destination$iv$iv;
        }
        return new AdSearch150CardState(str, color, emptyList, null);
    }

    @Override // kntr.app.ad.ad.biz.base.BaseAdCardModel
    public void handleCardClick(IMotion motion) {
        String str;
        IExtraInfo extra;
        IRenderable card;
        super.handleCardClick(motion);
        IAdSearchReporter iAdSearchReporter = this.adSearchReporter;
        if (iAdSearchReporter != null) {
            AdSearchBean adSearchInfo = getAdSearchInfo();
            if (adSearchInfo == null || (extra = adSearchInfo.getExtra()) == null || (card = extra.getCard()) == null || (str = card.getJumpUrl()) == null) {
                str = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            iAdSearchReporter.reportCardClickForPegasus(str);
        }
    }

    @Override // kntr.app.ad.ad.biz.search.vm.AdSearchCardModel
    public void onChooseButtonClick(int index) {
        String str;
        IExtraInfo extra;
        IRenderable card;
        List<AdButton> chooseBtnList;
        AdButton adButton;
        String text;
        IExtraInfo extra2;
        IRenderable card2;
        List<AdButton> chooseBtnList2;
        AdButton adButton2;
        super.onChooseButtonClick(index);
        IAdSearchReporter iAdSearchReporter = this.adSearchReporter;
        if (iAdSearchReporter != null) {
            AdSearchBean adSearchInfo = getAdSearchInfo();
            String str2 = RoomRecommendViewModel.EMPTY_CURSOR;
            if (adSearchInfo == null || (extra2 = adSearchInfo.getExtra()) == null || (card2 = extra2.getCard()) == null || (chooseBtnList2 = card2.getChooseBtnList()) == null || (adButton2 = (AdButton) CollectionsKt.getOrNull(chooseBtnList2, index)) == null || (str = adButton2.getJumpUrl()) == null) {
                str = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            AdSearchBean adSearchInfo2 = getAdSearchInfo();
            if (adSearchInfo2 != null && (extra = adSearchInfo2.getExtra()) != null && (card = extra.getCard()) != null && (chooseBtnList = card.getChooseBtnList()) != null && (adButton = (AdButton) CollectionsKt.getOrNull(chooseBtnList, index)) != null && (text = adButton.getText()) != null) {
                str2 = text;
            }
            iAdSearchReporter.reportChooseButtonClickForPegasus(index, str, str2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: updateState-bi-UJ9A$default  reason: not valid java name */
    public static /* synthetic */ void m112updateStatebiUJ9A$default(AdSearch150CardModel adSearch150CardModel, String str, Color color, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            color = null;
        }
        if ((i & 4) != 0) {
            list = null;
        }
        adSearch150CardModel.m113updateStatebiUJ9A(str, color, list);
    }

    /* renamed from: updateState-bi-UJ9A  reason: not valid java name */
    public final void m113updateStatebiUJ9A(String coverUrl, Color bgColor, List<String> list) {
        AdSearch150CardState currentState = (AdSearch150CardState) getInternalUiState().getValue();
        getInternalUiState().setValue(currentState.m109copybiUJ9A(coverUrl == null ? currentState.getCoverUrl() : coverUrl, bgColor == null ? currentState.m110getBgColorQN2ZGVo() : bgColor, list == null ? currentState.getButtonLabels() : list));
    }

    @Override // kntr.app.ad.ad.biz.base.BaseAdCardModel
    public AdSearch150CardState copy(AdSearch150CardState currentState) {
        Intrinsics.checkNotNullParameter(currentState, "currentState");
        return AdSearch150CardState.m107copybiUJ9A$default(currentState, null, null, null, 7, null);
    }

    @Override // kntr.app.ad.ad.biz.search.vm.AdSearchCardModel, kntr.app.ad.ad.biz.base.BaseAdCardModel
    public Map<String, Object> commonFeeParams() {
        return MapsKt.plus(super.commonFeeParams(), MapsKt.mapOf(TuplesKt.to(ReportBuildInParam.IS_SEARCH_150_VM, "1")));
    }

    @Override // kntr.app.ad.ad.biz.search.vm.AdSearchCardModel, kntr.app.ad.ad.biz.base.BaseAdCardModel
    public Map<String, Object> commonUIParams() {
        return MapsKt.plus(super.commonUIParams(), MapsKt.mapOf(TuplesKt.to(ReportBuildInParam.IS_SEARCH_150_VM, "1")));
    }

    @Override // kntr.app.ad.ad.biz.base.BaseAdCardModel
    public Map<String, Object> cardClickArgParams() {
        return MapsKt.mapOf(TuplesKt.to("event_from", "search_brand_cover"));
    }

    @Override // kntr.app.ad.ad.biz.search.vm.AdSearchCardModel
    public Map<String, Object> chooseButtonClickParams(int index) {
        return MapsKt.mapOf(TuplesKt.to("event_from", "bottom_button_" + (index + 1)));
    }
}