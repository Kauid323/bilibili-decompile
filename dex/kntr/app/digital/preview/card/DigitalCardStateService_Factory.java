package kntr.app.digital.preview.card;

import dagger.internal.Factory;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;
import kntr.app.digital.preview.api.GetCardList;
import kntr.app.digital.preview.cardlistmapper.CardItem;
import kntr.app.digital.preview.lock.LockStateService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DigitalCardStateService_Factory.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fBÓ\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00070\u0004\u0012\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkntr/app/digital/preview/card/DigitalCardStateService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "coroutineScopeProvider", "Ljavax/inject/Provider;", "Lkotlinx/coroutines/CoroutineScope;", "initialCardItemsProvider", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/cardlistmapper/CardItem;", "fromParamsProvider", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "initialPageProvider", RoomRecommendViewModel.EMPTY_CURSOR, "requestParamsProvider", "Lkntr/app/digital/preview/api/GetCardList$RequestParams;", "vMidProvider", RoomRecommendViewModel.EMPTY_CURSOR, "initialFrontHasMoreProvider", RoomRecommendViewModel.EMPTY_CURSOR, "initialBackHasMoreProvider", "extraParamsProvider", "frontAnchorIdProvider", "backAnchorIdProvider", "getCardListProvider", "Lkntr/app/digital/preview/api/GetCardList;", "lockStateServiceProvider", "Lkntr/app/digital/preview/lock/LockStateService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalCardStateService_Factory implements Factory<DigitalCardStateService> {
    private final Provider<String> backAnchorIdProvider;
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<String> extraParamsProvider;
    private final Provider<Map<String, String>> fromParamsProvider;
    private final Provider<String> frontAnchorIdProvider;
    private final Provider<GetCardList> getCardListProvider;
    private final Provider<Boolean> initialBackHasMoreProvider;
    private final Provider<List<CardItem<?>>> initialCardItemsProvider;
    private final Provider<Boolean> initialFrontHasMoreProvider;
    private final Provider<Integer> initialPageProvider;
    private final Provider<LockStateService> lockStateServiceProvider;
    private final Provider<GetCardList.RequestParams> requestParamsProvider;
    private final Provider<Long> vMidProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public DigitalCardStateService_Factory(Provider<CoroutineScope> provider, Provider<List<CardItem<?>>> provider2, Provider<Map<String, String>> provider3, Provider<Integer> provider4, Provider<GetCardList.RequestParams> provider5, Provider<Long> provider6, Provider<Boolean> provider7, Provider<Boolean> provider8, Provider<String> provider9, Provider<String> provider10, Provider<String> provider11, Provider<GetCardList> provider12, Provider<LockStateService> provider13) {
        Intrinsics.checkNotNullParameter(provider, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(provider2, "initialCardItemsProvider");
        Intrinsics.checkNotNullParameter(provider3, "fromParamsProvider");
        Intrinsics.checkNotNullParameter(provider4, "initialPageProvider");
        Intrinsics.checkNotNullParameter(provider5, "requestParamsProvider");
        Intrinsics.checkNotNullParameter(provider6, "vMidProvider");
        Intrinsics.checkNotNullParameter(provider7, "initialFrontHasMoreProvider");
        Intrinsics.checkNotNullParameter(provider8, "initialBackHasMoreProvider");
        Intrinsics.checkNotNullParameter(provider9, "extraParamsProvider");
        Intrinsics.checkNotNullParameter(provider10, "frontAnchorIdProvider");
        Intrinsics.checkNotNullParameter(provider11, "backAnchorIdProvider");
        Intrinsics.checkNotNullParameter(provider12, "getCardListProvider");
        Intrinsics.checkNotNullParameter(provider13, "lockStateServiceProvider");
        this.coroutineScopeProvider = provider;
        this.initialCardItemsProvider = provider2;
        this.fromParamsProvider = provider3;
        this.initialPageProvider = provider4;
        this.requestParamsProvider = provider5;
        this.vMidProvider = provider6;
        this.initialFrontHasMoreProvider = provider7;
        this.initialBackHasMoreProvider = provider8;
        this.extraParamsProvider = provider9;
        this.frontAnchorIdProvider = provider10;
        this.backAnchorIdProvider = provider11;
        this.getCardListProvider = provider12;
        this.lockStateServiceProvider = provider13;
    }

    public DigitalCardStateService get() {
        Companion companion = Companion;
        CoroutineScope coroutineScope = this.coroutineScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(coroutineScope, "get(...)");
        List<CardItem<?>> list = this.initialCardItemsProvider.get();
        Intrinsics.checkNotNullExpressionValue(list, "get(...)");
        Map<String, String> map = this.fromParamsProvider.get();
        Intrinsics.checkNotNullExpressionValue(map, "get(...)");
        Integer num = this.initialPageProvider.get();
        Intrinsics.checkNotNullExpressionValue(num, "get(...)");
        int intValue = num.intValue();
        GetCardList.RequestParams requestParams = this.requestParamsProvider.get();
        Intrinsics.checkNotNullExpressionValue(requestParams, "get(...)");
        Long l = this.vMidProvider.get();
        Intrinsics.checkNotNullExpressionValue(l, "get(...)");
        long longValue = l.longValue();
        Boolean bool = this.initialFrontHasMoreProvider.get();
        Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        boolean booleanValue = bool.booleanValue();
        Boolean bool2 = this.initialBackHasMoreProvider.get();
        Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
        boolean booleanValue2 = bool2.booleanValue();
        String str = this.extraParamsProvider.get();
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        String str2 = this.frontAnchorIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        String str3 = this.backAnchorIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
        GetCardList getCardList = this.getCardListProvider.get();
        Intrinsics.checkNotNullExpressionValue(getCardList, "get(...)");
        GetCardList getCardList2 = getCardList;
        LockStateService lockStateService = this.lockStateServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(lockStateService, "get(...)");
        return companion.newInstance(coroutineScope, list, map, intValue, requestParams, longValue, booleanValue, booleanValue2, str, str2, str3, getCardList2, lockStateService);
    }

    /* compiled from: DigitalCardStateService_Factory.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JÔ\u0001\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0016\u0010\t\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\n0\u00072\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0007H\u0007J\u0086\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\b2\u0010\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\n2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001eH\u0007¨\u0006."}, d2 = {"Lkntr/app/digital/preview/card/DigitalCardStateService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/card/DigitalCardStateService_Factory;", "coroutineScopeProvider", "Ljavax/inject/Provider;", "Lkotlinx/coroutines/CoroutineScope;", "initialCardItemsProvider", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/cardlistmapper/CardItem;", "fromParamsProvider", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "initialPageProvider", RoomRecommendViewModel.EMPTY_CURSOR, "requestParamsProvider", "Lkntr/app/digital/preview/api/GetCardList$RequestParams;", "vMidProvider", RoomRecommendViewModel.EMPTY_CURSOR, "initialFrontHasMoreProvider", RoomRecommendViewModel.EMPTY_CURSOR, "initialBackHasMoreProvider", "extraParamsProvider", "frontAnchorIdProvider", "backAnchorIdProvider", "getCardListProvider", "Lkntr/app/digital/preview/api/GetCardList;", "lockStateServiceProvider", "Lkntr/app/digital/preview/lock/LockStateService;", "newInstance", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "coroutineScope", "initialCardItems", "fromParams", "initialPage", "requestParams", "vMid", "initialFrontHasMore", "initialBackHasMore", "extraParams", "frontAnchorId", "backAnchorId", "getCardList", "lockStateService", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DigitalCardStateService_Factory create(Provider<CoroutineScope> provider, Provider<List<CardItem<?>>> provider2, Provider<Map<String, String>> provider3, Provider<Integer> provider4, Provider<GetCardList.RequestParams> provider5, Provider<Long> provider6, Provider<Boolean> provider7, Provider<Boolean> provider8, Provider<String> provider9, Provider<String> provider10, Provider<String> provider11, Provider<GetCardList> provider12, Provider<LockStateService> provider13) {
            Intrinsics.checkNotNullParameter(provider, "coroutineScopeProvider");
            Intrinsics.checkNotNullParameter(provider2, "initialCardItemsProvider");
            Intrinsics.checkNotNullParameter(provider3, "fromParamsProvider");
            Intrinsics.checkNotNullParameter(provider4, "initialPageProvider");
            Intrinsics.checkNotNullParameter(provider5, "requestParamsProvider");
            Intrinsics.checkNotNullParameter(provider6, "vMidProvider");
            Intrinsics.checkNotNullParameter(provider7, "initialFrontHasMoreProvider");
            Intrinsics.checkNotNullParameter(provider8, "initialBackHasMoreProvider");
            Intrinsics.checkNotNullParameter(provider9, "extraParamsProvider");
            Intrinsics.checkNotNullParameter(provider10, "frontAnchorIdProvider");
            Intrinsics.checkNotNullParameter(provider11, "backAnchorIdProvider");
            Intrinsics.checkNotNullParameter(provider12, "getCardListProvider");
            Intrinsics.checkNotNullParameter(provider13, "lockStateServiceProvider");
            return new DigitalCardStateService_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
        }

        @JvmStatic
        public final DigitalCardStateService newInstance(CoroutineScope coroutineScope, List<? extends CardItem<?>> list, Map<String, String> map, int initialPage, GetCardList.RequestParams requestParams, long vMid, boolean initialFrontHasMore, boolean initialBackHasMore, String extraParams, String frontAnchorId, String backAnchorId, GetCardList getCardList, LockStateService lockStateService) {
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(list, "initialCardItems");
            Intrinsics.checkNotNullParameter(map, "fromParams");
            Intrinsics.checkNotNullParameter(requestParams, "requestParams");
            Intrinsics.checkNotNullParameter(extraParams, "extraParams");
            Intrinsics.checkNotNullParameter(frontAnchorId, "frontAnchorId");
            Intrinsics.checkNotNullParameter(backAnchorId, "backAnchorId");
            Intrinsics.checkNotNullParameter(getCardList, "getCardList");
            Intrinsics.checkNotNullParameter(lockStateService, "lockStateService");
            return new DigitalCardStateService(coroutineScope, list, map, initialPage, requestParams, vMid, initialFrontHasMore, initialBackHasMore, extraParams, frontAnchorId, backAnchorId, getCardList, lockStateService);
        }
    }

    @JvmStatic
    public static final DigitalCardStateService_Factory create(Provider<CoroutineScope> provider, Provider<List<CardItem<?>>> provider2, Provider<Map<String, String>> provider3, Provider<Integer> provider4, Provider<GetCardList.RequestParams> provider5, Provider<Long> provider6, Provider<Boolean> provider7, Provider<Boolean> provider8, Provider<String> provider9, Provider<String> provider10, Provider<String> provider11, Provider<GetCardList> provider12, Provider<LockStateService> provider13) {
        return Companion.create(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    @JvmStatic
    public static final DigitalCardStateService newInstance(CoroutineScope coroutineScope, List<? extends CardItem<?>> list, Map<String, String> map, int initialPage, GetCardList.RequestParams requestParams, long vMid, boolean initialFrontHasMore, boolean initialBackHasMore, String extraParams, String frontAnchorId, String backAnchorId, GetCardList getCardList, LockStateService lockStateService) {
        return Companion.newInstance(coroutineScope, list, map, initialPage, requestParams, vMid, initialFrontHasMore, initialBackHasMore, extraParams, frontAnchorId, backAnchorId, getCardList, lockStateService);
    }
}