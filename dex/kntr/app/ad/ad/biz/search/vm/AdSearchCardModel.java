package kntr.app.ad.ad.biz.search.vm;

import java.util.List;
import java.util.Map;
import kntr.app.ad.ad.biz.base.BaseAdCardModel;
import kntr.app.ad.ad.biz.base.BaseAdUiState;
import kntr.app.ad.ad.biz.base.interfaces.IAdFeedback;
import kntr.app.ad.ad.biz.search.AdSearchSubCardType;
import kntr.app.ad.common.model.AdButton;
import kntr.app.ad.common.model.AdForwardReply;
import kntr.app.ad.common.model.AdFullText;
import kntr.app.ad.common.model.AdInfo;
import kntr.app.ad.common.model.AdInfoCard;
import kntr.app.ad.common.model.AdInfoExtra;
import kntr.app.ad.common.model.AdSearchBean;
import kntr.app.ad.common.model.AdSearchVideo;
import kntr.app.ad.common.model.AdSubCardModule;
import kntr.app.ad.common.model.AdWxProgramInfo;
import kntr.app.ad.domain.click.ClickArg;
import kntr.app.ad.domain.click.ClickService;
import kntr.app.ad.domain.click.IButtonClickListener;
import kntr.app.ad.domain.click.IClickContext;
import kntr.app.ad.domain.report.AdReportHub;
import kntr.app.ad.domain.report.internal.FeeEventFrom;
import kntr.app.ad.domain.report.internal.ReportBuildInEvent;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.ad.protocol.IMotion;
import kntr.app.ad.protocol.report.IReportExtraHandler;
import kntr.app.ad.protocol.report.IReportFee;
import kntr.app.ad.protocol.report.IReportMMA;
import kntr.app.ad.protocol.report.IReportUI;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: AdSearchCardModel.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u0015J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001e\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010#0!2\u0006\u0010\u001c\u001a\u00020\u001dH&J\u000e\u0010$\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001dJK\u0010&\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(2!\u0010)\u001a\u001d\u0012\u0013\u0012\u00110+¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u001b0*2\u0010\b\u0002\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"00J\u0010\u00101\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J<\u00102\u001a\u00020\u001b2\b\u00103\u001a\u0004\u0018\u00010\"2\b\u00104\u001a\u0004\u0018\u00010\"2\b\u00105\u001a\u0004\u0018\u0001062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0!H\u0002J\b\u00108\u001a\u00020\u0015H\u0014J\u001c\u00109\u001a\u00020\u001b2\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010#0!J\u0010\u0010:\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010(J\u001a\u0010;\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010<\u001a\u0004\u0018\u00010=J\u000e\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020\u001dJ\u0010\u0010@\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\u001dH\u0002J\u0016\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010#0!H\u0016J\u0016\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010#0!H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006D"}, d2 = {"Lkntr/app/ad/ad/biz/search/vm/AdSearchCardModel;", "S", "Lkntr/app/ad/ad/biz/base/BaseAdUiState;", "Lkntr/app/ad/ad/biz/base/BaseAdCardModel;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "adSearchInfo", "Lkntr/app/ad/common/model/AdSearchBean;", "iAdFeedback", "Lkntr/app/ad/ad/biz/base/interfaces/IAdFeedback;", "clickService", "Lkntr/app/ad/domain/click/ClickService;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkntr/app/ad/common/model/AdSearchBean;Lkntr/app/ad/ad/biz/base/interfaces/IAdFeedback;Lkntr/app/ad/domain/click/ClickService;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getAdSearchInfo", "()Lkntr/app/ad/common/model/AdSearchBean;", "getIAdFeedback", "()Lkntr/app/ad/ad/biz/base/interfaces/IAdFeedback;", "supportSubCard", RoomRecommendViewModel.EMPTY_CURSOR, "showSubCard", "checkSubCardData", "subCardModule", "Lkntr/app/ad/common/model/AdSubCardModule;", "onChooseButtonClick", RoomRecommendViewModel.EMPTY_CURSOR, "index", RoomRecommendViewModel.EMPTY_CURSOR, "clickChooseButtonListener", "Lkntr/app/ad/domain/click/IButtonClickListener;", "chooseButtonClickParams", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "getChooseButtonClickArg", "Lkntr/app/ad/domain/click/ClickArg;", "onVideoItemClick", "motion", "Lkntr/app/ad/protocol/IMotion;", "onVideoItemClickForPegasus", "Lkotlin/Function1;", "Lkntr/app/ad/common/model/AdSearchVideo;", "Lkotlin/ParameterName;", "name", "videoInfo", "fromAction", "Lkotlin/Function0;", "clickSubCard", "handleSubCardClick", "callUpUrl", "jumpUrl", "wxProgramInfo", "Lkntr/app/ad/common/model/AdWxProgramInfo;", "map", "supportFeedBack", "reportFeeClick", "reportMMAClick", "reportMMAButtonClick", "button", "Lkntr/app/ad/common/model/AdButton;", "reportCloseEvent", "reasonId", "reportShowSubCardFailure", "buttonCount", "commonFeeParams", "commonUIParams", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AdSearchCardModel<S extends BaseAdUiState> extends BaseAdCardModel<S> {
    public static final int $stable = 8;
    private final AdSearchBean adSearchInfo;
    private final CoroutineScope coroutineScope;
    private final IAdFeedback iAdFeedback;

    public abstract Map<String, Object> chooseButtonClickParams(int i);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdSearchCardModel(CoroutineScope coroutineScope, AdSearchBean adSearchInfo, IAdFeedback iAdFeedback, ClickService clickService) {
        super(coroutineScope, adSearchInfo, iAdFeedback, clickService);
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
        this.adSearchInfo = adSearchInfo;
        this.iAdFeedback = iAdFeedback;
    }

    public CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public AdSearchBean getAdSearchInfo() {
        return this.adSearchInfo;
    }

    public IAdFeedback getIAdFeedback() {
        return this.iAdFeedback;
    }

    @Override // kntr.app.ad.ad.biz.base.BaseAdCardModel
    public boolean supportSubCard() {
        return false;
    }

    public final boolean showSubCard() {
        AdSubCardModule adSubCardModule;
        AdInfo adInfo;
        AdInfoExtra extra;
        AdInfoCard card;
        if (supportSubCard()) {
            AdSearchBean adSearchInfo = getAdSearchInfo();
            if (adSearchInfo == null || (adInfo = adSearchInfo.getAdInfo()) == null || (extra = adInfo.getExtra()) == null || (card = extra.getCard()) == null) {
                adSubCardModule = null;
            } else {
                adSubCardModule = card.getSubCardModule();
            }
            if (checkSubCardData(adSubCardModule)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    private final boolean checkSubCardData(AdSubCardModule subCardModule) {
        String str;
        AdFullText it;
        AdForwardReply forwardReply;
        AdForwardReply forwardReply2;
        if (subCardModule == null || (str = subCardModule.getType()) == null) {
            str = AdSearchSubCardType.CARD_TYPE_NONE;
        }
        r2 = null;
        String str2 = null;
        switch (str.hashCode()) {
            case 49:
                if (!str.equals("1") || subCardModule == null || (it = subCardModule.getFullText()) == null) {
                    return false;
                }
                String text = it.getText();
                if (text != null) {
                    if ((text.length() > 0) == true) {
                        return true;
                    }
                }
                return false;
            case 50:
                if (str.equals(AdSearchSubCardType.CARD_TYPE_2)) {
                    List btnList = subCardModule != null ? subCardModule.getChooseBtnList() : null;
                    if ((btnList != null && (btnList.isEmpty() ^ true)) == true) {
                        return true;
                    }
                    reportShowSubCardFailure(btnList != null ? btnList.size() : 0);
                    return false;
                }
                break;
            case 51:
                if (str.equals(AdSearchSubCardType.CARD_TYPE_3)) {
                    String highlightText = (subCardModule == null || (forwardReply2 = subCardModule.getForwardReply()) == null) ? null : forwardReply2.getHighlightText();
                    if ((highlightText == null || StringsKt.isBlank(highlightText)) == false) {
                        if (subCardModule != null && (forwardReply = subCardModule.getForwardReply()) != null) {
                            str2 = forwardReply.getJumpUrl();
                        }
                        String str3 = str2;
                        if ((str3 == null || StringsKt.isBlank(str3)) == false) {
                            return true;
                        }
                    }
                    return false;
                }
                break;
            case 52:
                if (str.equals(AdSearchSubCardType.CARD_TYPE_4)) {
                    String title = subCardModule != null ? subCardModule.getTitle() : null;
                    if ((title == null || StringsKt.isBlank(title)) == false) {
                        String jumpUrl = subCardModule != null ? subCardModule.getJumpUrl() : null;
                        if ((jumpUrl == null || StringsKt.isBlank(jumpUrl)) == false) {
                            return true;
                        }
                    }
                    return false;
                }
                break;
            case 53:
                if (str.equals(AdSearchSubCardType.CARD_TYPE_5)) {
                    return true;
                }
                break;
            case 54:
                if (str.equals(AdSearchSubCardType.CARD_TYPE_6)) {
                    List btnList2 = subCardModule != null ? subCardModule.getChooseBtnList() : null;
                    if ((btnList2 != null && (btnList2.isEmpty() ^ true)) == true) {
                        return true;
                    }
                    reportShowSubCardFailure(btnList2 != null ? btnList2.size() : 0);
                    return false;
                }
                break;
        }
        return false;
    }

    public void onChooseButtonClick(int index) {
        BuildersKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new AdSearchCardModel$onChooseButtonClick$1(this, index, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IButtonClickListener clickChooseButtonListener(final int index) {
        return new IButtonClickListener(this) { // from class: kntr.app.ad.ad.biz.search.vm.AdSearchCardModel$clickChooseButtonListener$1
            final /* synthetic */ AdSearchCardModel<S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // kntr.app.ad.domain.click.IButtonClickListener
            public void onButtonStart(IClickContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
            }

            @Override // kntr.app.ad.domain.click.IButtonClickListener
            public void onButtonAnswered(IClickContext context) {
                AdButton adButton;
                AdInfo adInfo;
                AdInfoExtra extra;
                AdInfoCard card;
                List<AdButton> chooseBtnList;
                Intrinsics.checkNotNullParameter(context, "context");
                this.this$0.reportFeeClick(MapsKt.plus(this.this$0.commonFeeParams(), this.this$0.chooseButtonClickParams(index)));
                AdSearchCardModel<S> adSearchCardModel = this.this$0;
                AdSearchBean adSearchInfo = this.this$0.getAdSearchInfo();
                if (adSearchInfo == null || (adInfo = adSearchInfo.getAdInfo()) == null || (extra = adInfo.getExtra()) == null || (card = extra.getCard()) == null || (chooseBtnList = card.getChooseBtnList()) == null) {
                    adButton = null;
                } else {
                    adButton = (AdButton) CollectionsKt.getOrNull(chooseBtnList, index);
                }
                adSearchCardModel.reportMMAButtonClick(null, adButton);
            }

            @Override // kntr.app.ad.domain.click.IButtonClickListener
            public void onButtonLost(IClickContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
            }

            @Override // kntr.app.ad.domain.click.IButtonClickListener
            public void onCardStart(IClickContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
            }

            @Override // kntr.app.ad.domain.click.IButtonClickListener
            public void onCardAnswered(IClickContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
            }

            @Override // kntr.app.ad.domain.click.IButtonClickListener
            public void onCardLost(IClickContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
            }
        };
    }

    public final ClickArg getChooseButtonClickArg(int index) {
        String str;
        String str2;
        ClickArg copy;
        AdInfo adInfo;
        AdInfoExtra extra;
        AdInfoCard card;
        List<AdButton> chooseBtnList;
        AdButton adButton;
        AdInfo adInfo2;
        AdInfoExtra extra2;
        AdInfoCard card2;
        List<AdButton> chooseBtnList2;
        AdButton adButton2;
        ClickArg cardClickArg = getCardClickArg();
        AdSearchBean adSearchInfo = getAdSearchInfo();
        if (adSearchInfo == null || (adInfo2 = adSearchInfo.getAdInfo()) == null || (extra2 = adInfo2.getExtra()) == null || (card2 = extra2.getCard()) == null || (chooseBtnList2 = card2.getChooseBtnList()) == null || (adButton2 = (AdButton) CollectionsKt.getOrNull(chooseBtnList2, index)) == null) {
            str = null;
        } else {
            str = adButton2.getCallupUrl();
        }
        AdSearchBean adSearchInfo2 = getAdSearchInfo();
        if (adSearchInfo2 == null || (adInfo = adSearchInfo2.getAdInfo()) == null || (extra = adInfo.getExtra()) == null || (card = extra.getCard()) == null || (chooseBtnList = card.getChooseBtnList()) == null || (adButton = (AdButton) CollectionsKt.getOrNull(chooseBtnList, index)) == null) {
            str2 = null;
        } else {
            str2 = adButton.getJumpUrl();
        }
        copy = cardClickArg.copy((r36 & 1) != 0 ? cardClickArg.wxInfo : null, (r36 & 2) != 0 ? cardClickArg.callUpUrl : str, (r36 & 4) != 0 ? cardClickArg.jumpUrl : str2, (r36 & 8) != 0 ? cardClickArg.cancelUrl : null, (r36 & 16) != 0 ? cardClickArg.enableCallUpCancelToJumpUrl : false, (r36 & 32) != 0 ? cardClickArg.enableDoubleJump : false, (r36 & 64) != 0 ? cardClickArg.useAdWeb : false, (r36 & 128) != 0 ? cardClickArg.openWhiteList : null, (r36 & 256) != 0 ? cardClickArg.downloadWhiteList : null, (r36 & 512) != 0 ? cardClickArg.dlSucCallUpUrl : null, (r36 & 1024) != 0 ? cardClickArg.enableAppStore : false, (r36 & 2048) != 0 ? cardClickArg.enableAppDownload : false, (r36 & 4096) != 0 ? cardClickArg.clickUrls : null, (r36 & 8192) != 0 ? cardClickArg.universalApp : null, (r36 & 16384) != 0 ? cardClickArg.appStorePriority : 0, (r36 & 32768) != 0 ? cardClickArg.storeLink : null, (r36 & 65536) != 0 ? cardClickArg.downloadUrlType : 0, (r36 & 131072) != 0 ? cardClickArg.isFirstJump : false);
        return copy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onVideoItemClick$default(AdSearchCardModel adSearchCardModel, final int i, IMotion iMotion, Function1 function1, Function0 function0, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onVideoItemClick");
        }
        if ((i2 & 8) != 0) {
            function0 = new Function0() { // from class: kntr.app.ad.ad.biz.search.vm.AdSearchCardModel$$ExternalSyntheticLambda2
                public final Object invoke() {
                    String onVideoItemClick$lambda$0;
                    onVideoItemClick$lambda$0 = AdSearchCardModel.onVideoItemClick$lambda$0(i);
                    return onVideoItemClick$lambda$0;
                }
            };
        }
        adSearchCardModel.onVideoItemClick(i, iMotion, function1, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onVideoItemClick$lambda$0(int $index) {
        switch ($index) {
            case 0:
                return FeeEventFrom.MIDDLE_CARD_1;
            case 1:
                return FeeEventFrom.MIDDLE_CARD_2;
            case 2:
                return FeeEventFrom.MIDDLE_CARD_3;
            default:
                return null;
        }
    }

    public final void onVideoItemClick(int index, IMotion motion, Function1<? super AdSearchVideo, Unit> function1, Function0<String> function0) {
        AdSearchBean adSearchInfo;
        List<AdSearchVideo> adVideos;
        AdSearchVideo videoInfo;
        Intrinsics.checkNotNullParameter(motion, "motion");
        Intrinsics.checkNotNullParameter(function1, "onVideoItemClickForPegasus");
        Intrinsics.checkNotNullParameter(function0, "fromAction");
        String from = (String) function0.invoke();
        if (from == null || (adSearchInfo = getAdSearchInfo()) == null || (adVideos = adSearchInfo.getAdVideos()) == null || (videoInfo = (AdSearchVideo) CollectionsKt.getOrNull(adVideos, index)) == null) {
            return;
        }
        function1.invoke(videoInfo);
        reportFeeClick(MapsKt.mapOf(TuplesKt.to("event_from", from)));
        reportMMAClick(motion);
    }

    public final void clickSubCard(AdSubCardModule subCardModule) {
        String str;
        AdForwardReply $this$clickSubCard_u24lambda_u240;
        if (subCardModule == null || (str = subCardModule.getType()) == null) {
            str = AdSearchSubCardType.CARD_TYPE_NONE;
        }
        switch (str.hashCode()) {
            case 51:
                if (str.equals(AdSearchSubCardType.CARD_TYPE_3)) {
                    Map map = MapsKt.mapOf(TuplesKt.to("event_from", FeeEventFrom.SEARCH_SUBCARD_TYPE_3));
                    if (subCardModule != null && ($this$clickSubCard_u24lambda_u240 = subCardModule.getForwardReply()) != null) {
                        handleSubCardClick($this$clickSubCard_u24lambda_u240.getCallupUrl(), $this$clickSubCard_u24lambda_u240.getJumpUrl(), subCardModule.getWxProgramInfo(), map);
                        return;
                    }
                    return;
                }
                return;
            case 52:
                if (str.equals(AdSearchSubCardType.CARD_TYPE_4)) {
                    Map map2 = MapsKt.mapOf(TuplesKt.to("event_from", FeeEventFrom.SEARCH_SUBCARD_TYPE_4));
                    if (subCardModule != null) {
                        handleSubCardClick(subCardModule.getCallUpUrl(), subCardModule.getJumpUrl(), subCardModule.getWxProgramInfo(), map2);
                        return;
                    }
                    return;
                }
                return;
            case 53:
                if (str.equals(AdSearchSubCardType.CARD_TYPE_5)) {
                    Map map3 = MapsKt.mapOf(TuplesKt.to("event_from", FeeEventFrom.SEARCH_SUBCARD_TYPE_5));
                    if (subCardModule != null) {
                        handleSubCardClick(subCardModule.getCallUpUrl(), subCardModule.getJumpUrl(), subCardModule.getWxProgramInfo(), map3);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void handleSubCardClick$default(AdSearchCardModel adSearchCardModel, String str, String str2, AdWxProgramInfo adWxProgramInfo, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleSubCardClick");
        }
        if ((i & 8) != 0) {
            map = MapsKt.emptyMap();
        }
        adSearchCardModel.handleSubCardClick(str, str2, adWxProgramInfo, map);
    }

    private final void handleSubCardClick(String callUpUrl, String jumpUrl, AdWxProgramInfo wxProgramInfo, Map<String, String> map) {
    }

    protected boolean supportFeedBack() {
        return false;
    }

    public final void reportFeeClick(final Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        IReportFee.CC.click$default(AdReportHub.Companion.getFee(), getAdSearchInfo(), false, null, new Function1() { // from class: kntr.app.ad.ad.biz.search.vm.AdSearchCardModel$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit reportFeeClick$lambda$0;
                reportFeeClick$lambda$0 = AdSearchCardModel.reportFeeClick$lambda$0(AdSearchCardModel.this, map, (IReportExtraHandler) obj);
                return reportFeeClick$lambda$0;
            }
        }, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportFeeClick$lambda$0(AdSearchCardModel this$0, Map $map, IReportExtraHandler $this$click) {
        Intrinsics.checkNotNullParameter($this$click, "$this$click");
        Map feeParams = MapsKt.toMutableMap(this$0.commonFeeParams());
        feeParams.putAll($map);
        for (Map.Entry element$iv : feeParams.entrySet()) {
            $this$click.put((String) element$iv.getKey(), element$iv.getValue());
        }
        return Unit.INSTANCE;
    }

    public final void reportMMAClick(IMotion motion) {
        AdInfo adInfo;
        AdInfoExtra extra;
        IReportMMA mma = AdReportHub.Companion.getMma();
        AdSearchBean adSearchInfo = getAdSearchInfo();
        AdSearchBean adSearchInfo2 = getAdSearchInfo();
        IReportMMA.CC.click$default(mma, adSearchInfo, (adSearchInfo2 == null || (adInfo = adSearchInfo2.getAdInfo()) == null || (extra = adInfo.getExtra()) == null) ? null : extra.getClickUrls(), motion, false, null, null, 56, null);
    }

    public final void reportMMAButtonClick(IMotion motion, AdButton button) {
        List<String> reportUrls;
        AdInfo adInfo;
        AdInfoExtra extra;
        AdSearchBean adSearchInfo = getAdSearchInfo();
        List reportUrls2 = null;
        List clickUrls = (adSearchInfo == null || (adInfo = adSearchInfo.getAdInfo()) == null || (extra = adInfo.getExtra()) == null) ? null : extra.getClickUrls();
        if (button != null && (reportUrls = button.getReportUrls()) != null) {
            reportUrls2 = CollectionsKt.filterNotNull(reportUrls);
        }
        List list = reportUrls2;
        IReportMMA.CC.click$default(AdReportHub.Companion.getMma(), getAdSearchInfo(), !(list == null || list.isEmpty()) ? reportUrls2 : clickUrls, motion, false, null, null, 56, null);
    }

    public final void reportCloseEvent(final int reasonId) {
        IReportFee.CC.close$default(AdReportHub.Companion.getFee(), getAdSearchInfo(), false, null, new Function1() { // from class: kntr.app.ad.ad.biz.search.vm.AdSearchCardModel$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit reportCloseEvent$lambda$0;
                reportCloseEvent$lambda$0 = AdSearchCardModel.reportCloseEvent$lambda$0(reasonId, this, (IReportExtraHandler) obj);
                return reportCloseEvent$lambda$0;
            }
        }, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportCloseEvent$lambda$0(int $reasonId, AdSearchCardModel this$0, IReportExtraHandler $this$close) {
        Intrinsics.checkNotNullParameter($this$close, "$this$close");
        $this$close.put(ReportBuildInParam.CM_REASON_ID, String.valueOf($reasonId));
        Map commonFee = this$0.commonFeeParams();
        for (Map.Entry element$iv : commonFee.entrySet()) {
            $this$close.put(element$iv.getKey(), element$iv.getValue());
        }
        return Unit.INSTANCE;
    }

    private final void reportShowSubCardFailure(final int buttonCount) {
        IReportUI.CC.event$default(AdReportHub.Companion.getUi(), ReportBuildInEvent.AD_SEARCH_SUBCARD_SHOW_FAILED, getAdSearchInfo(), false, null, new Function1() { // from class: kntr.app.ad.ad.biz.search.vm.AdSearchCardModel$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit reportShowSubCardFailure$lambda$0;
                reportShowSubCardFailure$lambda$0 = AdSearchCardModel.reportShowSubCardFailure$lambda$0(AdSearchCardModel.this, buttonCount, (IReportExtraHandler) obj);
                return reportShowSubCardFailure$lambda$0;
            }
        }, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportShowSubCardFailure$lambda$0(AdSearchCardModel this$0, int $buttonCount, IReportExtraHandler $this$event) {
        Intrinsics.checkNotNullParameter($this$event, "$this$event");
        AdSearchBean adSearchInfo = this$0.getAdSearchInfo();
        $this$event.put(ReportBuildInParam.CARD_SEARCH_POS, String.valueOf(adSearchInfo != null ? Integer.valueOf(adSearchInfo.getPosition()) : null));
        $this$event.put(ReportBuildInParam.BUTTON_COUNT, String.valueOf($buttonCount));
        Map commonUI = this$0.commonUIParams();
        for (Map.Entry element$iv : commonUI.entrySet()) {
            $this$event.put(element$iv.getKey(), element$iv.getValue());
        }
        return Unit.INSTANCE;
    }

    @Override // kntr.app.ad.ad.biz.base.BaseAdCardModel
    public Map<String, Object> commonFeeParams() {
        AdSearchBean adSearchInfo = getAdSearchInfo();
        return MapsKt.mapOf(TuplesKt.to(ReportBuildInParam.CARD_SEARCH_POS, String.valueOf(adSearchInfo != null ? Integer.valueOf(adSearchInfo.getPosition()) : null)));
    }

    @Override // kntr.app.ad.ad.biz.base.BaseAdCardModel
    public Map<String, Object> commonUIParams() {
        return MapsKt.emptyMap();
    }
}