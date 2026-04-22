package kntr.app.ad.ad.biz.base;

import java.util.List;
import java.util.Map;
import kntr.app.ad.ad.biz.base.BaseAdUiState;
import kntr.app.ad.ad.biz.base.interfaces.IAdFeedback;
import kntr.app.ad.common.model.AdButton;
import kntr.app.ad.common.protocol.IAdInfo;
import kntr.app.ad.common.protocol.IExtraInfo;
import kntr.app.ad.common.protocol.IRenderable;
import kntr.app.ad.domain.click.ClickArg;
import kntr.app.ad.domain.click.ClickArgBuilder;
import kntr.app.ad.domain.click.ClickArgKt;
import kntr.app.ad.domain.click.ClickService;
import kntr.app.ad.domain.click.Clicker;
import kntr.app.ad.protocol.IMotion;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: BaseAdCardModel.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\b'\u0018\u0000 :*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001:B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\r\u0010*\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0010J\u0006\u0010+\u001a\u00020,J\u0015\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0000H&¢\u0006\u0002\u0010/J\u0014\u00100\u001a\u00020,2\n\b\u0002\u00101\u001a\u0004\u0018\u000102H\u0016J\u0018\u00103\u001a\u0012\u0012\u0004\u0012\u000205\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u000104H&J\u0006\u00106\u001a\u00020,J\u0006\u00107\u001a\u00020,J\u0016\u00108\u001a\u0010\u0012\u0004\u0012\u000205\u0012\u0006\u0012\u0004\u0018\u00010\u000304H&J\u0016\u00109\u001a\u0010\u0012\u0004\u0012\u000205\u0012\u0006\u0012\u0004\u0018\u00010\u000304H&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00028\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006;"}, d2 = {"Lkntr/app/ad/ad/biz/base/BaseAdCardModel;", "S", "Lkntr/app/ad/ad/biz/base/BaseAdUiState;", RoomRecommendViewModel.EMPTY_CURSOR, "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "adInfo", "Lkntr/app/ad/common/protocol/IAdInfo;", "iAdFeedback", "Lkntr/app/ad/ad/biz/base/interfaces/IAdFeedback;", "clickService", "Lkntr/app/ad/domain/click/ClickService;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkntr/app/ad/common/protocol/IAdInfo;Lkntr/app/ad/ad/biz/base/interfaces/IAdFeedback;Lkntr/app/ad/domain/click/ClickService;)V", "initialState", "getInitialState", "()Lkntr/app/ad/ad/biz/base/BaseAdUiState;", "initialState$delegate", "Lkotlin/Lazy;", "internalUiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getInternalUiState$annotations", "()V", "getInternalUiState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState$annotations", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "supportSubCard", RoomRecommendViewModel.EMPTY_CURSOR, "cardClickArg", "Lkntr/app/ad/domain/click/ClickArg;", "getCardClickArg", "()Lkntr/app/ad/domain/click/ClickArg;", "buttonClickArg", "getButtonClickArg", "clicker", "Lkntr/app/ad/domain/click/Clicker;", "getClicker", "()Lkntr/app/ad/domain/click/Clicker;", "createInitialState", "handleMoreClick", RoomRecommendViewModel.EMPTY_CURSOR, "copy", "currentState", "(Lkntr/app/ad/ad/biz/base/BaseAdUiState;)Lkntr/app/ad/ad/biz/base/BaseAdUiState;", "handleCardClick", "motion", "Lkntr/app/ad/protocol/IMotion;", "cardClickArgParams", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "handleButtonClick", "handleOtherClick", "commonFeeParams", "commonUIParams", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BaseAdCardModel<S extends BaseAdUiState> {
    public static final String TAG = "BaseAdViewModel";
    private final IAdInfo adInfo;
    private final ClickService clickService;
    private final Clicker clicker;
    private final CoroutineScope coroutineScope;
    private final IAdFeedback iAdFeedback;
    private final Lazy initialState$delegate;
    private final MutableStateFlow<S> internalUiState;
    private final StateFlow<S> uiState;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ void getInternalUiState$annotations() {
    }

    public static /* synthetic */ void getUiState$annotations() {
    }

    public abstract Map<String, Object> cardClickArgParams();

    public abstract Map<String, Object> commonFeeParams();

    public abstract Map<String, Object> commonUIParams();

    public abstract S copy(S s);

    public abstract S createInitialState();

    public BaseAdCardModel(CoroutineScope coroutineScope, IAdInfo adInfo, IAdFeedback iAdFeedback, ClickService clickService) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
        this.adInfo = adInfo;
        this.iAdFeedback = iAdFeedback;
        this.clickService = clickService;
        this.initialState$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.ad.biz.base.BaseAdCardModel$$ExternalSyntheticLambda0
            public final Object invoke() {
                BaseAdUiState createInitialState;
                createInitialState = BaseAdCardModel.this.createInitialState();
                return createInitialState;
            }
        });
        this.internalUiState = StateFlowKt.MutableStateFlow(getInitialState());
        this.uiState = FlowKt.asStateFlow(this.internalUiState);
        ClickService it = this.clickService;
        this.clicker = it != null ? new Clicker(it) : null;
    }

    /* compiled from: BaseAdCardModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/app/ad/ad/biz/base/BaseAdCardModel$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "TAG", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final S getInitialState() {
        return (S) this.initialState$delegate.getValue();
    }

    public final MutableStateFlow<S> getInternalUiState() {
        return this.internalUiState;
    }

    public final StateFlow<S> getUiState() {
        return this.uiState;
    }

    public boolean supportSubCard() {
        return true;
    }

    public ClickArg getCardClickArg() {
        return ClickArgKt.clickArg(new Function1() { // from class: kntr.app.ad.ad.biz.base.BaseAdCardModel$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit _get_cardClickArg_$lambda$0;
                _get_cardClickArg_$lambda$0 = BaseAdCardModel._get_cardClickArg_$lambda$0(BaseAdCardModel.this, (ClickArgBuilder) obj);
                return _get_cardClickArg_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_cardClickArg_$lambda$0(BaseAdCardModel this$0, ClickArgBuilder $this$clickArg) {
        IExtraInfo extra;
        IExtraInfo extra2;
        IExtraInfo extra3;
        IExtraInfo extra4;
        IExtraInfo extra5;
        IExtraInfo extra6;
        IExtraInfo extra7;
        IExtraInfo extra8;
        IExtraInfo extra9;
        IRenderable card;
        IExtraInfo extra10;
        IRenderable card2;
        IExtraInfo extra11;
        Intrinsics.checkNotNullParameter($this$clickArg, "$this$clickArg");
        IAdInfo iAdInfo = this$0.adInfo;
        List<String> list = null;
        $this$clickArg.setWxInfo((iAdInfo == null || (extra11 = iAdInfo.getExtra()) == null) ? null : extra11.getWxProgramInfo());
        IAdInfo iAdInfo2 = this$0.adInfo;
        $this$clickArg.setCallUpUrl((iAdInfo2 == null || (extra10 = iAdInfo2.getExtra()) == null || (card2 = extra10.getCard()) == null) ? null : card2.getCallUpUrl());
        IAdInfo iAdInfo3 = this$0.adInfo;
        $this$clickArg.setJumpUrl((iAdInfo3 == null || (extra9 = iAdInfo3.getExtra()) == null || (card = extra9.getCard()) == null) ? null : card.getJumpUrl());
        IAdInfo iAdInfo4 = this$0.adInfo;
        $this$clickArg.setCancelUrl((iAdInfo4 == null || (extra8 = iAdInfo4.getExtra()) == null) ? null : extra8.getUserCancelJumpUrl());
        IAdInfo iAdInfo5 = this$0.adInfo;
        boolean z = false;
        $this$clickArg.setEnableCallUpCancelToJumpUrl((iAdInfo5 == null || (extra7 = iAdInfo5.getExtra()) == null || extra7.getUserCancelJumpType() != 1) ? false : true);
        IAdInfo iAdInfo6 = this$0.adInfo;
        $this$clickArg.setEnableDoubleJump((iAdInfo6 == null || (extra6 = iAdInfo6.getExtra()) == null) ? false : extra6.getEnableDoubleJump());
        IAdInfo iAdInfo7 = this$0.adInfo;
        $this$clickArg.setUseAdWeb((iAdInfo7 == null || (extra5 = iAdInfo7.getExtra()) == null) ? false : extra5.getUseAdWebV2());
        IAdInfo iAdInfo8 = this$0.adInfo;
        $this$clickArg.setOpenWhiteList((iAdInfo8 == null || (extra4 = iAdInfo8.getExtra()) == null) ? null : extra4.getOpenWhitelist());
        IAdInfo iAdInfo9 = this$0.adInfo;
        $this$clickArg.setDownloadWhiteList((iAdInfo9 == null || (extra3 = iAdInfo9.getExtra()) == null) ? null : extra3.getDownloadWhitelist());
        $this$clickArg.setDlSucCallUpUrl(null);
        IAdInfo iAdInfo10 = this$0.adInfo;
        if ((iAdInfo10 == null || (extra2 = iAdInfo10.getExtra()) == null || !extra2.getEnableMarketDownloadWhenFirstJump()) ? false : true) {
            IExtraInfo extra12 = this$0.adInfo.getExtra();
            if (extra12 != null && extra12.getStoreDirectLaunch() == 1) {
                z = true;
            }
        }
        $this$clickArg.setEnableAppStore(z);
        $this$clickArg.setEnableAppDownload(true);
        IAdInfo iAdInfo11 = this$0.adInfo;
        if (iAdInfo11 != null && (extra = iAdInfo11.getExtra()) != null) {
            list = extra.getClickUrls();
        }
        $this$clickArg.setClickUrls(list);
        return Unit.INSTANCE;
    }

    public ClickArg getButtonClickArg() {
        return ClickArgKt.clickArg(new Function1() { // from class: kntr.app.ad.ad.biz.base.BaseAdCardModel$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit _get_buttonClickArg_$lambda$0;
                _get_buttonClickArg_$lambda$0 = BaseAdCardModel._get_buttonClickArg_$lambda$0(BaseAdCardModel.this, (ClickArgBuilder) obj);
                return _get_buttonClickArg_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_buttonClickArg_$lambda$0(BaseAdCardModel this$0, ClickArgBuilder $this$clickArg) {
        String str;
        String str2;
        IExtraInfo extra;
        IExtraInfo extra2;
        IExtraInfo extra3;
        IExtraInfo extra4;
        IExtraInfo extra5;
        IExtraInfo extra6;
        IExtraInfo extra7;
        IExtraInfo extra8;
        IExtraInfo extra9;
        IRenderable card;
        AdButton button;
        IExtraInfo extra10;
        IRenderable card2;
        AdButton button2;
        IExtraInfo extra11;
        Intrinsics.checkNotNullParameter($this$clickArg, "$this$clickArg");
        IAdInfo iAdInfo = this$0.adInfo;
        List<String> list = null;
        $this$clickArg.setWxInfo((iAdInfo == null || (extra11 = iAdInfo.getExtra()) == null) ? null : extra11.getWxProgramInfo());
        IAdInfo iAdInfo2 = this$0.adInfo;
        if (iAdInfo2 == null || (extra10 = iAdInfo2.getExtra()) == null || (card2 = extra10.getCard()) == null || (button2 = card2.getButton()) == null) {
            str = null;
        } else {
            str = button2.getCallupUrl();
        }
        $this$clickArg.setCallUpUrl(str);
        IAdInfo iAdInfo3 = this$0.adInfo;
        if (iAdInfo3 == null || (extra9 = iAdInfo3.getExtra()) == null || (card = extra9.getCard()) == null || (button = card.getButton()) == null) {
            str2 = null;
        } else {
            str2 = button.getJumpUrl();
        }
        $this$clickArg.setJumpUrl(str2);
        IAdInfo iAdInfo4 = this$0.adInfo;
        $this$clickArg.setCancelUrl((iAdInfo4 == null || (extra8 = iAdInfo4.getExtra()) == null) ? null : extra8.getUserCancelJumpUrl());
        IAdInfo iAdInfo5 = this$0.adInfo;
        boolean z = false;
        $this$clickArg.setEnableCallUpCancelToJumpUrl((iAdInfo5 == null || (extra7 = iAdInfo5.getExtra()) == null || extra7.getUserCancelJumpType() != 1) ? false : true);
        IAdInfo iAdInfo6 = this$0.adInfo;
        $this$clickArg.setEnableDoubleJump((iAdInfo6 == null || (extra6 = iAdInfo6.getExtra()) == null) ? false : extra6.getEnableDoubleJump());
        IAdInfo iAdInfo7 = this$0.adInfo;
        $this$clickArg.setUseAdWeb((iAdInfo7 == null || (extra5 = iAdInfo7.getExtra()) == null) ? false : extra5.getUseAdWebV2());
        IAdInfo iAdInfo8 = this$0.adInfo;
        $this$clickArg.setOpenWhiteList((iAdInfo8 == null || (extra4 = iAdInfo8.getExtra()) == null) ? null : extra4.getOpenWhitelist());
        IAdInfo iAdInfo9 = this$0.adInfo;
        $this$clickArg.setDownloadWhiteList((iAdInfo9 == null || (extra3 = iAdInfo9.getExtra()) == null) ? null : extra3.getDownloadWhitelist());
        $this$clickArg.setDlSucCallUpUrl(null);
        IAdInfo iAdInfo10 = this$0.adInfo;
        if ((iAdInfo10 == null || (extra2 = iAdInfo10.getExtra()) == null || !extra2.getEnableMarketDownloadWhenFirstJump()) ? false : true) {
            IExtraInfo extra12 = this$0.adInfo.getExtra();
            if (extra12 != null && extra12.getStoreDirectLaunch() == 1) {
                z = true;
            }
        }
        $this$clickArg.setEnableAppStore(z);
        $this$clickArg.setEnableAppDownload(true);
        IAdInfo iAdInfo11 = this$0.adInfo;
        if (iAdInfo11 != null && (extra = iAdInfo11.getExtra()) != null) {
            list = extra.getClickUrls();
        }
        $this$clickArg.setClickUrls(list);
        return Unit.INSTANCE;
    }

    public final Clicker getClicker() {
        return this.clicker;
    }

    public final void handleMoreClick() {
        IAdFeedback iAdFeedback;
        if (!supportSubCard() || (iAdFeedback = this.iAdFeedback) == null) {
            return;
        }
        iAdFeedback.onMoreClick();
    }

    public static /* synthetic */ void handleCardClick$default(BaseAdCardModel baseAdCardModel, IMotion iMotion, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleCardClick");
        }
        if ((i & 1) != 0) {
            iMotion = null;
        }
        baseAdCardModel.handleCardClick(iMotion);
    }

    public void handleCardClick(IMotion motion) {
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BaseAdCardModel$handleCardClick$1(this, null), 3, (Object) null);
    }

    public final void handleButtonClick() {
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BaseAdCardModel$handleButtonClick$1(this, null), 3, (Object) null);
    }

    public final void handleOtherClick() {
    }
}