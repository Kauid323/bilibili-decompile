package kntr.app.ad.ad.biz.liveroom.vm;

import java.util.List;
import java.util.Map;
import kntr.app.ad.ad.biz.liveroom.AdLiveRoomBrandCardUIState;
import kntr.app.ad.ad.biz.liveroom.respository.LiveRoomBigCardRepository;
import kntr.app.ad.common.model.AdInfoCard;
import kntr.app.ad.common.model.AdInfoExtra;
import kntr.app.ad.common.model.AdSourceContent;
import kntr.app.ad.common.model.AdWhiteApk;
import kntr.app.ad.common.model.AdWxProgramInfo;
import kntr.app.ad.domain.click.ClickArg;
import kntr.app.ad.domain.click.ClickArgBuilder;
import kntr.app.ad.domain.click.ClickArgKt;
import kntr.app.ad.domain.click.ClickService;
import kntr.app.ad.domain.report.AdReportHub;
import kntr.app.ad.domain.report.internal.ReportBuildInEvent;
import kntr.app.ad.protocol.report.IReportExtraHandler;
import kntr.app.ad.protocol.report.IReportFee;
import kntr.app.ad.protocol.report.IReportMMA;
import kntr.app.ad.protocol.report.IReportUI;
import kntr.app.ad.protocol.report.IReportable;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: AdLiveRoomBrandCardViewModel.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0007J\b\u0010\u001f\u001a\u00020\u001eH\u0007J\b\u0010 \u001a\u00020\u001eH\u0007J\u0006\u0010!\u001a\u00020\u001eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00188FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\"\u001a\u00020#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lkntr/app/ad/ad/biz/liveroom/vm/AdLiveRoomBrandCardViewModel;", RoomRecommendViewModel.EMPTY_CURSOR, "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "clickerService", "Lkntr/app/ad/domain/click/ClickService;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkntr/app/ad/domain/click/ClickService;)V", "getClickerService", "()Lkntr/app/ad/domain/click/ClickService;", "setClickerService", "(Lkntr/app/ad/domain/click/ClickService;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkntr/app/ad/ad/biz/liveroom/AdLiveRoomBrandCardUIState;", "_repository", "Lkntr/app/ad/ad/biz/liveroom/respository/LiveRoomBigCardRepository;", "value", "repository", "getRepository", "()Lkntr/app/ad/ad/biz/liveroom/respository/LiveRoomBigCardRepository;", "setRepository", "(Lkntr/app/ad/ad/biz/liveroom/respository/LiveRoomBigCardRepository;)V", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState$annotations", "()V", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "updateState", RoomRecommendViewModel.EMPTY_CURSOR, "clickCard", "reportAdBrandCardShow", "reportClose", "cardClickArg", "Lkntr/app/ad/domain/click/ClickArg;", "getCardClickArg", "()Lkntr/app/ad/domain/click/ClickArg;", "liveroom_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdLiveRoomBrandCardViewModel {
    public static final int $stable = 8;
    private LiveRoomBigCardRepository _repository;
    private MutableStateFlow<AdLiveRoomBrandCardUIState> _uiState = StateFlowKt.MutableStateFlow((Object) null);
    private ClickService clickerService;
    private final CoroutineScope lifecycleScope;

    public static /* synthetic */ void getUiState$annotations() {
    }

    public AdLiveRoomBrandCardViewModel(CoroutineScope lifecycleScope, ClickService clickerService) {
        this.lifecycleScope = lifecycleScope;
        this.clickerService = clickerService;
    }

    public final ClickService getClickerService() {
        return this.clickerService;
    }

    public final void setClickerService(ClickService clickService) {
        this.clickerService = clickService;
    }

    public final LiveRoomBigCardRepository getRepository() {
        return this._repository;
    }

    public final void setRepository(LiveRoomBigCardRepository value) {
        this._repository = value;
    }

    public final StateFlow<AdLiveRoomBrandCardUIState> getUiState() {
        return FlowKt.asStateFlow(this._uiState);
    }

    public final void updateState(AdLiveRoomBrandCardUIState uiState) {
        this._uiState.setValue(uiState);
    }

    public final void clickCard() {
        CoroutineScope coroutineScope = this.lifecycleScope;
        if (coroutineScope != null) {
            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AdLiveRoomBrandCardViewModel$clickCard$1(this, null), 3, (Object) null);
        }
    }

    public final void reportAdBrandCardShow() {
        List<String> list;
        AdSourceContent sourceContent;
        AdSourceContent.AdContent adContent;
        AdInfoExtra extra;
        IReportFee fee = AdReportHub.Companion.getFee();
        LiveRoomBigCardRepository repository = getRepository();
        IReportFee.CC.exposed$default(fee, repository != null ? repository.getReportable() : null, false, null, new Function1() { // from class: kntr.app.ad.ad.biz.liveroom.vm.AdLiveRoomBrandCardViewModel$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit reportAdBrandCardShow$lambda$0;
                reportAdBrandCardShow$lambda$0 = AdLiveRoomBrandCardViewModel.reportAdBrandCardShow$lambda$0(AdLiveRoomBrandCardViewModel.this, (IReportExtraHandler) obj);
                return reportAdBrandCardShow$lambda$0;
            }
        }, 6, null);
        IReportMMA mma = AdReportHub.Companion.getMma();
        LiveRoomBigCardRepository repository2 = getRepository();
        IReportable reportable = repository2 != null ? repository2.getReportable() : null;
        LiveRoomBigCardRepository repository3 = getRepository();
        if (repository3 == null || (sourceContent = repository3.getSourceContent()) == null || (adContent = sourceContent.getAdContent()) == null || (extra = adContent.getExtra()) == null) {
            list = null;
        } else {
            list = extra.getShowUrls();
        }
        IReportMMA.CC.exposed$default(mma, reportable, list, false, null, null, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportAdBrandCardShow$lambda$0(AdLiveRoomBrandCardViewModel this$0, IReportExtraHandler $this$exposed) {
        Map $this$forEach$iv;
        Intrinsics.checkNotNullParameter($this$exposed, "$this$exposed");
        LiveRoomBigCardRepository repository = this$0.getRepository();
        if (repository != null && ($this$forEach$iv = repository.getAdCommonParams()) != null) {
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                String k = element$iv.getKey();
                String v = element$iv.getValue();
                $this$exposed.put(k, v);
            }
        }
        return Unit.INSTANCE;
    }

    public final void reportClose() {
        IReportUI ui = AdReportHub.Companion.getUi();
        LiveRoomBigCardRepository repository = getRepository();
        IReportUI.CC.event$default(ui, ReportBuildInEvent.CLOSE, repository != null ? repository.getReportable() : null, false, null, new Function1() { // from class: kntr.app.ad.ad.biz.liveroom.vm.AdLiveRoomBrandCardViewModel$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit reportClose$lambda$0;
                reportClose$lambda$0 = AdLiveRoomBrandCardViewModel.reportClose$lambda$0(AdLiveRoomBrandCardViewModel.this, (IReportExtraHandler) obj);
                return reportClose$lambda$0;
            }
        }, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportClose$lambda$0(AdLiveRoomBrandCardViewModel this$0, IReportExtraHandler $this$event) {
        Map $this$forEach$iv;
        Intrinsics.checkNotNullParameter($this$event, "$this$event");
        LiveRoomBigCardRepository repository = this$0.getRepository();
        if (repository != null && ($this$forEach$iv = repository.getAdCommonParams()) != null) {
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                $this$event.put(element$iv.getKey(), element$iv.getValue());
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClickArg getCardClickArg() {
        return ClickArgKt.clickArg(new Function1() { // from class: kntr.app.ad.ad.biz.liveroom.vm.AdLiveRoomBrandCardViewModel$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit _get_cardClickArg_$lambda$0;
                _get_cardClickArg_$lambda$0 = AdLiveRoomBrandCardViewModel._get_cardClickArg_$lambda$0(AdLiveRoomBrandCardViewModel.this, (ClickArgBuilder) obj);
                return _get_cardClickArg_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_cardClickArg_$lambda$0(AdLiveRoomBrandCardViewModel this$0, ClickArgBuilder $this$clickArg) {
        AdWxProgramInfo adWxProgramInfo;
        String str;
        String str2;
        String str3;
        List<String> list;
        List<AdWhiteApk> list2;
        AdSourceContent sourceContent;
        AdSourceContent.AdContent adContent;
        AdInfoExtra extra;
        AdSourceContent sourceContent2;
        AdSourceContent.AdContent adContent2;
        AdInfoExtra extra2;
        AdSourceContent sourceContent3;
        AdSourceContent.AdContent adContent3;
        AdInfoExtra extra3;
        AdSourceContent sourceContent4;
        AdSourceContent.AdContent adContent4;
        AdInfoExtra extra4;
        AdSourceContent sourceContent5;
        AdSourceContent.AdContent adContent5;
        AdInfoExtra extra5;
        AdSourceContent sourceContent6;
        AdSourceContent.AdContent adContent6;
        AdInfoExtra extra6;
        AdSourceContent sourceContent7;
        AdSourceContent.AdContent adContent7;
        AdInfoExtra extra7;
        AdSourceContent sourceContent8;
        AdSourceContent.AdContent adContent8;
        AdInfoExtra extra8;
        AdSourceContent sourceContent9;
        AdSourceContent.AdContent adContent9;
        AdInfoExtra extra9;
        AdSourceContent sourceContent10;
        AdSourceContent.AdContent adContent10;
        AdInfoExtra extra10;
        AdInfoCard card;
        AdSourceContent sourceContent11;
        AdSourceContent.AdContent adContent11;
        AdInfoExtra extra11;
        AdInfoCard card2;
        AdSourceContent sourceContent12;
        AdSourceContent.AdContent adContent12;
        AdInfoExtra extra12;
        Intrinsics.checkNotNullParameter($this$clickArg, "$this$clickArg");
        LiveRoomBigCardRepository repository = this$0.getRepository();
        List<String> list3 = null;
        if (repository == null || (sourceContent12 = repository.getSourceContent()) == null || (adContent12 = sourceContent12.getAdContent()) == null || (extra12 = adContent12.getExtra()) == null) {
            adWxProgramInfo = null;
        } else {
            adWxProgramInfo = extra12.getWxProgramInfo();
        }
        $this$clickArg.setWxInfo(adWxProgramInfo);
        LiveRoomBigCardRepository repository2 = this$0.getRepository();
        if (repository2 == null || (sourceContent11 = repository2.getSourceContent()) == null || (adContent11 = sourceContent11.getAdContent()) == null || (extra11 = adContent11.getExtra()) == null || (card2 = extra11.getCard()) == null) {
            str = null;
        } else {
            str = card2.getCallUpUrl();
        }
        $this$clickArg.setCallUpUrl(str);
        LiveRoomBigCardRepository repository3 = this$0.getRepository();
        if (repository3 == null || (sourceContent10 = repository3.getSourceContent()) == null || (adContent10 = sourceContent10.getAdContent()) == null || (extra10 = adContent10.getExtra()) == null || (card = extra10.getCard()) == null) {
            str2 = null;
        } else {
            str2 = card.getJumpUrl();
        }
        $this$clickArg.setJumpUrl(str2);
        LiveRoomBigCardRepository repository4 = this$0.getRepository();
        if (repository4 == null || (sourceContent9 = repository4.getSourceContent()) == null || (adContent9 = sourceContent9.getAdContent()) == null || (extra9 = adContent9.getExtra()) == null) {
            str3 = null;
        } else {
            str3 = extra9.getUserCancelJumpUrl();
        }
        $this$clickArg.setCancelUrl(str3);
        LiveRoomBigCardRepository repository5 = this$0.getRepository();
        boolean z = false;
        $this$clickArg.setEnableCallUpCancelToJumpUrl((repository5 == null || (sourceContent8 = repository5.getSourceContent()) == null || (adContent8 = sourceContent8.getAdContent()) == null || (extra8 = adContent8.getExtra()) == null || extra8.getUserCancelJumpType() != 1) ? false : true);
        LiveRoomBigCardRepository repository6 = this$0.getRepository();
        $this$clickArg.setEnableDoubleJump((repository6 == null || (sourceContent7 = repository6.getSourceContent()) == null || (adContent7 = sourceContent7.getAdContent()) == null || (extra7 = adContent7.getExtra()) == null) ? false : extra7.getEnableDoubleJump());
        LiveRoomBigCardRepository repository7 = this$0.getRepository();
        $this$clickArg.setUseAdWeb((repository7 == null || (sourceContent6 = repository7.getSourceContent()) == null || (adContent6 = sourceContent6.getAdContent()) == null || (extra6 = adContent6.getExtra()) == null) ? false : extra6.getUseAdWebV2());
        LiveRoomBigCardRepository repository8 = this$0.getRepository();
        if (repository8 == null || (sourceContent5 = repository8.getSourceContent()) == null || (adContent5 = sourceContent5.getAdContent()) == null || (extra5 = adContent5.getExtra()) == null) {
            list = null;
        } else {
            list = extra5.getOpenWhitelist();
        }
        $this$clickArg.setOpenWhiteList(list);
        LiveRoomBigCardRepository repository9 = this$0.getRepository();
        if (repository9 == null || (sourceContent4 = repository9.getSourceContent()) == null || (adContent4 = sourceContent4.getAdContent()) == null || (extra4 = adContent4.getExtra()) == null) {
            list2 = null;
        } else {
            list2 = extra4.getDownloadWhitelist();
        }
        $this$clickArg.setDownloadWhiteList(list2);
        $this$clickArg.setDlSucCallUpUrl(null);
        LiveRoomBigCardRepository repository10 = this$0.getRepository();
        if ((repository10 == null || (sourceContent3 = repository10.getSourceContent()) == null || (adContent3 = sourceContent3.getAdContent()) == null || (extra3 = adContent3.getExtra()) == null || !extra3.getEnableMarketDownloadWhenFirstJump()) ? false : true) {
            LiveRoomBigCardRepository repository11 = this$0.getRepository();
            if ((repository11 == null || (sourceContent2 = repository11.getSourceContent()) == null || (adContent2 = sourceContent2.getAdContent()) == null || (extra2 = adContent2.getExtra()) == null || extra2.getStoreDirectLaunch() != 1) ? false : true) {
                z = true;
            }
        }
        $this$clickArg.setEnableAppStore(z);
        $this$clickArg.setEnableAppDownload(true);
        LiveRoomBigCardRepository repository12 = this$0.getRepository();
        if (repository12 != null && (sourceContent = repository12.getSourceContent()) != null && (adContent = sourceContent.getAdContent()) != null && (extra = adContent.getExtra()) != null) {
            list3 = extra.getClickUrls();
        }
        $this$clickArg.setClickUrls(list3);
        return Unit.INSTANCE;
    }
}