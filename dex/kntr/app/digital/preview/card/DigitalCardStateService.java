package kntr.app.digital.preview.card;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import com.bilibili.ktor.KApiResponse;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kntr.app.digital.preview.BusinessCoroutineScope;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.FromParams;
import kntr.app.digital.preview.VMid;
import kntr.app.digital.preview.api.CardPreviewModel;
import kntr.app.digital.preview.api.GetCardList;
import kntr.app.digital.preview.card.DigitalCardListUIService;
import kntr.app.digital.preview.card.web.WebCard;
import kntr.app.digital.preview.cardlistmapper.CardItem;
import kntr.app.digital.preview.lock.LockStateService;
import kntr.app.digital.preview.shop.ShopPreviewPageDataModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: DigitalCardStateService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u009e\u0001\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0015\u0010\u0004\u001a\u0011\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0006¢\u0006\u0002\b\u00070\u0005\u0012\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0001\u0010\u0014\u001a\u00020\n\u0012\b\b\u0001\u0010\u0015\u001a\u00020\n\u0012\b\b\u0001\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010>\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\fJ\u000e\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020\nJ\u000e\u0010A\u001a\u00020B2\u0006\u0010.\u001a\u00020\fJ\u001a\u0010C\u001a\u00020D2\u0010\u0010E\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R?\u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00052\u0010\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010%\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001b\u0010.\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b/\u00100R+\u00104\u001a\u0002032\u0006\u0010\u001d\u001a\u0002038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010$\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001f\u0010:\u001a\u0006\u0012\u0002\b\u00030\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u00102\u001a\u0004\b;\u0010<¨\u0006F"}, d2 = {"Lkntr/app/digital/preview/card/DigitalCardStateService;", RoomRecommendViewModel.EMPTY_CURSOR, "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "initialCardItems", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/cardlistmapper/CardItem;", "Lkotlin/jvm/JvmSuppressWildcards;", "fromParams", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "initialPage", RoomRecommendViewModel.EMPTY_CURSOR, "requestParams", "Lkntr/app/digital/preview/api/GetCardList$RequestParams;", "vMid", RoomRecommendViewModel.EMPTY_CURSOR, "initialFrontHasMore", RoomRecommendViewModel.EMPTY_CURSOR, "initialBackHasMore", "extraParams", "frontAnchorId", "backAnchorId", "getCardList", "Lkntr/app/digital/preview/api/GetCardList;", "lockStateService", "Lkntr/app/digital/preview/lock/LockStateService;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Ljava/util/List;Ljava/util/Map;ILkntr/app/digital/preview/api/GetCardList$RequestParams;JZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/digital/preview/api/GetCardList;Lkntr/app/digital/preview/lock/LockStateService;)V", "<set-?>", "cardItems", "getCardItems", "()Ljava/util/List;", "setCardItems", "(Ljava/util/List;)V", "cardItems$delegate", "Landroidx/compose/runtime/MutableState;", "nextRequestExtraParams", "nextRequestFrontAnchorId", "nextRequestBackAnchorId", "frontHasMore", "backHasMore", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "getPagerState", "()Landroidx/compose/foundation/pager/PagerState;", "index", "getIndex", "()I", "index$delegate", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/unit/Dp;", "maxWidth", "getMaxWidth-D9Ej5fM", "()F", "setMaxWidth-0680j_4", "(F)V", "maxWidth$delegate", "currentCardItem", "getCurrentCardItem", "()Lkntr/app/digital/preview/cardlistmapper/CardItem;", "currentCardItem$delegate", "isWebCard", "indexByCardId", "cardId", "cardItemBasicInfo", "Lkntr/app/digital/preview/card/CardBasic;", "markLockState", RoomRecommendViewModel.EMPTY_CURSOR, "cards", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalCardStateService {
    public static final int $stable = 8;
    private final String backAnchorId;
    private boolean backHasMore;
    private final MutableState cardItems$delegate;
    private final CoroutineScope coroutineScope;
    private final State currentCardItem$delegate;
    private final String extraParams;
    private final Map<String, String> fromParams;
    private final String frontAnchorId;
    private boolean frontHasMore;
    private final GetCardList getCardList;
    private final State index$delegate;
    private final boolean initialBackHasMore;
    private final boolean initialFrontHasMore;
    private final LockStateService lockStateService;
    private final MutableState maxWidth$delegate;
    private String nextRequestBackAnchorId;
    private String nextRequestExtraParams;
    private String nextRequestFrontAnchorId;
    private final PagerState pagerState;
    private final GetCardList.RequestParams requestParams;
    private final long vMid;

    @Inject
    public DigitalCardStateService(@BusinessCoroutineScope CoroutineScope coroutineScope, List<CardItem<?>> list, @FromParams Map<String, String> map, @DigitalCardListUIService.InitialPage int initialPage, GetCardList.RequestParams requestParams, @VMid long vMid, @InitialFrontHasMore boolean initialFrontHasMore, @InitialBackHasMore boolean initialBackHasMore, @InitialRequestExtraParams String extraParams, @InitialFrontAnchorId String frontAnchorId, @InitialBackAnchorId String backAnchorId, GetCardList getCardList, LockStateService lockStateService) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(list, "initialCardItems");
        Intrinsics.checkNotNullParameter(map, "fromParams");
        Intrinsics.checkNotNullParameter(requestParams, "requestParams");
        Intrinsics.checkNotNullParameter(extraParams, "extraParams");
        Intrinsics.checkNotNullParameter(frontAnchorId, "frontAnchorId");
        Intrinsics.checkNotNullParameter(backAnchorId, "backAnchorId");
        Intrinsics.checkNotNullParameter(getCardList, "getCardList");
        Intrinsics.checkNotNullParameter(lockStateService, "lockStateService");
        this.coroutineScope = coroutineScope;
        this.fromParams = map;
        this.requestParams = requestParams;
        this.vMid = vMid;
        this.initialFrontHasMore = initialFrontHasMore;
        this.initialBackHasMore = initialBackHasMore;
        this.extraParams = extraParams;
        this.frontAnchorId = frontAnchorId;
        this.backAnchorId = backAnchorId;
        this.getCardList = getCardList;
        this.lockStateService = lockStateService;
        this.cardItems$delegate = SnapshotStateKt.mutableStateOf$default(list, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.nextRequestExtraParams = this.extraParams;
        this.nextRequestFrontAnchorId = this.frontAnchorId;
        this.nextRequestBackAnchorId = this.backAnchorId;
        this.frontHasMore = this.initialFrontHasMore;
        this.backHasMore = this.initialBackHasMore;
        this.pagerState = PagerStateKt.PagerState$default(initialPage, 0.0f, new Function0() { // from class: kntr.app.digital.preview.card.DigitalCardStateService$$ExternalSyntheticLambda0
            public final Object invoke() {
                int pagerState$lambda$0;
                pagerState$lambda$0 = DigitalCardStateService.pagerState$lambda$0(DigitalCardStateService.this);
                return Integer.valueOf(pagerState$lambda$0);
            }
        }, 2, (Object) null);
        this.index$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.digital.preview.card.DigitalCardStateService$$ExternalSyntheticLambda1
            public final Object invoke() {
                int index_delegate$lambda$0;
                index_delegate$lambda$0 = DigitalCardStateService.index_delegate$lambda$0(DigitalCardStateService.this);
                return Integer.valueOf(index_delegate$lambda$0);
            }
        });
        this.maxWidth$delegate = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.constructor-impl(0)), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.currentCardItem$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.digital.preview.card.DigitalCardStateService$$ExternalSyntheticLambda2
            public final Object invoke() {
                CardItem currentCardItem_delegate$lambda$0;
                currentCardItem_delegate$lambda$0 = DigitalCardStateService.currentCardItem_delegate$lambda$0(DigitalCardStateService.this);
                return currentCardItem_delegate$lambda$0;
            }
        });
        markLockState(list);
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCardItems(List<? extends CardItem<?>> list) {
        MutableState $this$setValue$iv = this.cardItems$delegate;
        $this$setValue$iv.setValue(list);
    }

    public final List<CardItem<?>> getCardItems() {
        State $this$getValue$iv = this.cardItems$delegate;
        return (List) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int pagerState$lambda$0(DigitalCardStateService this$0) {
        return this$0.getCardItems().size();
    }

    public final PagerState getPagerState() {
        return this.pagerState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int index_delegate$lambda$0(DigitalCardStateService this$0) {
        return this$0.pagerState.getCurrentPage();
    }

    public final int getIndex() {
        State $this$getValue$iv = this.index$delegate;
        return ((Number) $this$getValue$iv.getValue()).intValue();
    }

    /* renamed from: getMaxWidth-D9Ej5fM  reason: not valid java name */
    public final float m930getMaxWidthD9Ej5fM() {
        State $this$getValue$iv = this.maxWidth$delegate;
        return ((Dp) $this$getValue$iv.getValue()).unbox-impl();
    }

    /* renamed from: setMaxWidth-0680j_4  reason: not valid java name */
    public final void m931setMaxWidth0680j_4(float f) {
        MutableState $this$setValue$iv = this.maxWidth$delegate;
        Object value$iv = Dp.box-impl(f);
        $this$setValue$iv.setValue(value$iv);
    }

    public final CardItem<?> getCurrentCardItem() {
        State $this$getValue$iv = this.currentCardItem$delegate;
        return (CardItem) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardItem currentCardItem_delegate$lambda$0(DigitalCardStateService this$0) {
        return this$0.getCardItems().get(this$0.getIndex());
    }

    public final boolean isWebCard(int index) {
        return getCardItems().get(index).getData() instanceof WebCard;
    }

    public final int indexByCardId(String cardId) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        List $this$indexOfFirst$iv = getCardItems();
        int index$iv = 0;
        for (CardItem item$iv : $this$indexOfFirst$iv) {
            CardItem cardItem = item$iv;
            if (Intrinsics.areEqual(cardItem.getBasic().getUniqueId(), cardId)) {
                return index$iv;
            }
            index$iv++;
        }
        return -1;
    }

    public final CardBasic cardItemBasicInfo(int index) {
        return getCardItems().get(index).getBasic();
    }

    /* compiled from: DigitalCardStateService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.digital.preview.card.DigitalCardStateService$1", f = "DigitalCardStateService.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.digital.preview.card.DigitalCardStateService$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DigitalCardStateService.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "it", RoomRecommendViewModel.EMPTY_CURSOR}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "kntr.app.digital.preview.card.DigitalCardStateService$1$2", f = "DigitalCardStateService.kt", i = {0, 1}, l = {93, 124}, m = "invokeSuspend", n = {"it", "it"}, s = {"I$0", "I$0"}, v = 1)
        /* renamed from: kntr.app.digital.preview.card.DigitalCardStateService$1$2  reason: invalid class name */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
            /* synthetic */ int I$0;
            int label;
            final /* synthetic */ DigitalCardStateService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DigitalCardStateService digitalCardStateService, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = digitalCardStateService;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.I$0 = ((Number) obj).intValue();
                return anonymousClass2;
            }

            public final Object invoke(int i, Continuation<? super Unit> continuation) {
                return create(Integer.valueOf(i), continuation).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Number) obj).intValue(), (Continuation) obj2);
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
            /* JADX WARN: Removed duplicated region for block: B:18:0x00bf  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x0189  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x01c6  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object $result) {
                GetCardList.RequestParams copy;
                Object invoke;
                GetCardList.RequestParams copy2;
                Object invoke2;
                KApiResponse.BusinessFailure businessFailure;
                KApiResponse.BusinessFailure businessFailure2;
                int it = this.I$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (it == CollectionsKt.getLastIndex(this.this$0.getCardItems()) && this.this$0.frontHasMore) {
                            GetCardList getCardList = this.this$0.getCardList;
                            copy2 = r8.copy((r20 & 1) != 0 ? r8.actId : 0, (r20 & 2) != 0 ? r8.vmid : 0L, (r20 & 4) != 0 ? r8.lotteryId : 0L, (r20 & 8) != 0 ? r8.frontAnchorId : this.this$0.nextRequestFrontAnchorId, (r20 & 16) != 0 ? r8.backAnchorId : null, (r20 & 32) != 0 ? r8.extra : this.this$0.nextRequestExtraParams, (r20 & 64) != 0 ? this.this$0.requestParams.direction : 0);
                            this.I$0 = it;
                            this.label = 1;
                            invoke2 = getCardList.invoke(copy2, (Continuation) this);
                            if (invoke2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            businessFailure = (KApiResponse) invoke2;
                            DigitalCardStateService digitalCardStateService = this.this$0;
                            if (!(businessFailure instanceof KApiResponse.BusinessFailure)) {
                                int code = businessFailure.getCode();
                                Exception e = new IllegalStateException("code:" + code + ",message:" + businessFailure.getMessage());
                                KLog_androidKt.getKLog().e("digitalCardsPagingService", e.toString());
                            } else if (businessFailure instanceof KApiResponse.ServiceUnavailable) {
                                Exception e2 = ((KApiResponse.ServiceUnavailable) businessFailure).getException();
                                KLog_androidKt.getKLog().e("digitalCardsPagingService", e2.toString());
                            } else if (businessFailure instanceof KApiResponse.Success) {
                                CardPreviewModel data = (CardPreviewModel) ((KApiResponse.Success) businessFailure).getData();
                                digitalCardStateService.nextRequestExtraParams = data.extraJsonString();
                                digitalCardStateService.nextRequestFrontAnchorId = data.getFrontAnchorId();
                                digitalCardStateService.frontHasMore = data.getFrontHasMore();
                                digitalCardStateService.backHasMore = data.getBackHasMore();
                                List cardItems = ShopPreviewPageDataModule.INSTANCE.provideDigitalCardList(digitalCardStateService.vMid, digitalCardStateService.fromParams, data);
                                digitalCardStateService.markLockState(cardItems);
                                List $this$invokeSuspend_u24lambda_u240_u240 = CollectionsKt.createListBuilder();
                                $this$invokeSuspend_u24lambda_u240_u240.addAll(digitalCardStateService.getCardItems());
                                $this$invokeSuspend_u24lambda_u240_u240.addAll(cardItems);
                                digitalCardStateService.setCardItems(CollectionsKt.build($this$invokeSuspend_u24lambda_u240_u240));
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                            return Unit.INSTANCE;
                        }
                        if (it == 0 && this.this$0.backHasMore) {
                            GetCardList getCardList2 = this.this$0.getCardList;
                            copy = r9.copy((r20 & 1) != 0 ? r9.actId : 0, (r20 & 2) != 0 ? r9.vmid : 0L, (r20 & 4) != 0 ? r9.lotteryId : 0L, (r20 & 8) != 0 ? r9.frontAnchorId : null, (r20 & 16) != 0 ? r9.backAnchorId : this.this$0.nextRequestBackAnchorId, (r20 & 32) != 0 ? r9.extra : this.this$0.nextRequestExtraParams, (r20 & 64) != 0 ? this.this$0.requestParams.direction : 1);
                            this.I$0 = it;
                            this.label = 2;
                            invoke = getCardList2.invoke(copy, (Continuation) this);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            businessFailure2 = (KApiResponse) invoke;
                            DigitalCardStateService digitalCardStateService2 = this.this$0;
                            if (!(businessFailure2 instanceof KApiResponse.BusinessFailure)) {
                                int code2 = businessFailure2.getCode();
                                Exception e3 = new IllegalStateException("code:" + code2 + ",message:" + businessFailure2.getMessage());
                                KLog_androidKt.getKLog().e("digitalCardsPagingService", e3.toString());
                            } else if (businessFailure2 instanceof KApiResponse.ServiceUnavailable) {
                                Exception e4 = ((KApiResponse.ServiceUnavailable) businessFailure2).getException();
                                KLog_androidKt.getKLog().e("digitalCardsPagingService", e4.toString());
                            } else if (businessFailure2 instanceof KApiResponse.Success) {
                                CardPreviewModel data2 = (CardPreviewModel) ((KApiResponse.Success) businessFailure2).getData();
                                digitalCardStateService2.nextRequestExtraParams = data2.extraJsonString();
                                digitalCardStateService2.nextRequestBackAnchorId = data2.getBackAnchorId();
                                digitalCardStateService2.frontHasMore = data2.getFrontHasMore();
                                digitalCardStateService2.backHasMore = data2.getBackHasMore();
                                String currentCardId = digitalCardStateService2.getCurrentCardItem().getBasic().getUniqueId();
                                List cardItems2 = ShopPreviewPageDataModule.INSTANCE.provideDigitalCardList(digitalCardStateService2.vMid, digitalCardStateService2.fromParams, data2);
                                digitalCardStateService2.markLockState(cardItems2);
                                List $this$invokeSuspend_u24lambda_u242_u240 = CollectionsKt.createListBuilder();
                                $this$invokeSuspend_u24lambda_u242_u240.addAll(cardItems2);
                                $this$invokeSuspend_u24lambda_u242_u240.addAll(digitalCardStateService2.getCardItems());
                                digitalCardStateService2.setCardItems(CollectionsKt.build($this$invokeSuspend_u24lambda_u242_u240));
                                PagerState.requestScrollToPage$default(digitalCardStateService2.getPagerState(), digitalCardStateService2.indexByCardId(currentCardId), 0.0f, 2, (Object) null);
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        invoke2 = $result;
                        businessFailure = (KApiResponse) invoke2;
                        DigitalCardStateService digitalCardStateService3 = this.this$0;
                        if (!(businessFailure instanceof KApiResponse.BusinessFailure)) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        invoke = $result;
                        businessFailure2 = (KApiResponse) invoke;
                        DigitalCardStateService digitalCardStateService22 = this.this$0;
                        if (!(businessFailure2 instanceof KApiResponse.BusinessFailure)) {
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final DigitalCardStateService digitalCardStateService = DigitalCardStateService.this;
                    this.label = 1;
                    if (FlowKt.collectLatest(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.digital.preview.card.DigitalCardStateService$1$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            int index;
                            index = DigitalCardStateService.this.getIndex();
                            return Integer.valueOf(index);
                        }
                    }), new AnonymousClass2(DigitalCardStateService.this, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markLockState(List<? extends CardItem<?>> list) {
        List<? extends CardItem<?>> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            CardItem it = (CardItem) element$iv;
            this.lockStateService.mark(it.getBasic().getUniqueId(), it.getBasic().getCardLockStatus());
        }
    }
}