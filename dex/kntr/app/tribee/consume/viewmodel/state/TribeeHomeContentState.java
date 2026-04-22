package kntr.app.tribee.consume.viewmodel.state;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.app.dynamic.v2.KTribeeBaseInfo;
import com.bapis.bilibili.app.dynamic.v2.KTribeeCategory;
import com.bapis.bilibili.app.dynamic.v2.KTribeeInteraction;
import com.bapis.bilibili.app.dynamic.v2.KTribeeNavigation;
import java.util.Map;
import java.util.Set;
import kntr.app.tribee.consume.page.model.TribeeDynListState;
import kntr.app.tribee.consume.page.model.TribeeFetchModel;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.TribeeHomeUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeHomeState.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0015\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tHÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003J\t\u0010,\u001a\u00020\u000fHÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0014HÆ\u0003Js\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u000207HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00068"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "baseInfo", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeBaseInfo;", "interaction", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInteraction;", "navigation", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeNavigation;", "categoryList", "", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeCategory;", "Lkntr/app/tribee/consume/page/model/TribeeDynListState;", "categoryId", "", "fetchModel", "Lkntr/app/tribee/consume/page/model/TribeeFetchModel;", "observedRequestingActions", "", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "uiAction", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeBaseInfo;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInteraction;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeNavigation;Ljava/util/Map;JLkntr/app/tribee/consume/page/model/TribeeFetchModel;Ljava/util/Set;Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;)V", "getBaseInfo", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeBaseInfo;", "getInteraction", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInteraction;", "getNavigation", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeNavigation;", "getCategoryList", "()Ljava/util/Map;", "getCategoryId", "()J", "getFetchModel", "()Lkntr/app/tribee/consume/page/model/TribeeFetchModel;", "getObservedRequestingActions", "()Ljava/util/Set;", "getUiAction", "()Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeHomeContentState extends TribeeHomeState {
    public static final int $stable = 0;
    private final KTribeeBaseInfo baseInfo;
    private final long categoryId;
    private final Map<KTribeeCategory, TribeeDynListState> categoryList;
    private final TribeeFetchModel fetchModel;
    private final KTribeeInteraction interaction;
    private final KTribeeNavigation navigation;
    private final Set<TribeeHomeStateAction> observedRequestingActions;
    private final TribeeHomeUIAction uiAction;

    public final KTribeeBaseInfo component1() {
        return this.baseInfo;
    }

    public final KTribeeInteraction component2() {
        return this.interaction;
    }

    public final KTribeeNavigation component3() {
        return this.navigation;
    }

    public final Map<KTribeeCategory, TribeeDynListState> component4() {
        return this.categoryList;
    }

    public final long component5() {
        return this.categoryId;
    }

    public final TribeeFetchModel component6() {
        return this.fetchModel;
    }

    public final Set<TribeeHomeStateAction> component7() {
        return this.observedRequestingActions;
    }

    public final TribeeHomeUIAction component8() {
        return this.uiAction;
    }

    public final TribeeHomeContentState copy(KTribeeBaseInfo kTribeeBaseInfo, KTribeeInteraction kTribeeInteraction, KTribeeNavigation kTribeeNavigation, Map<KTribeeCategory, TribeeDynListState> map, long j, TribeeFetchModel tribeeFetchModel, Set<? extends TribeeHomeStateAction> set, TribeeHomeUIAction tribeeHomeUIAction) {
        Intrinsics.checkNotNullParameter(map, "categoryList");
        Intrinsics.checkNotNullParameter(tribeeFetchModel, "fetchModel");
        Intrinsics.checkNotNullParameter(set, "observedRequestingActions");
        return new TribeeHomeContentState(kTribeeBaseInfo, kTribeeInteraction, kTribeeNavigation, map, j, tribeeFetchModel, set, tribeeHomeUIAction);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TribeeHomeContentState) {
            TribeeHomeContentState tribeeHomeContentState = (TribeeHomeContentState) obj;
            return Intrinsics.areEqual(this.baseInfo, tribeeHomeContentState.baseInfo) && Intrinsics.areEqual(this.interaction, tribeeHomeContentState.interaction) && Intrinsics.areEqual(this.navigation, tribeeHomeContentState.navigation) && Intrinsics.areEqual(this.categoryList, tribeeHomeContentState.categoryList) && this.categoryId == tribeeHomeContentState.categoryId && Intrinsics.areEqual(this.fetchModel, tribeeHomeContentState.fetchModel) && Intrinsics.areEqual(this.observedRequestingActions, tribeeHomeContentState.observedRequestingActions) && Intrinsics.areEqual(this.uiAction, tribeeHomeContentState.uiAction);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((this.baseInfo == null ? 0 : this.baseInfo.hashCode()) * 31) + (this.interaction == null ? 0 : this.interaction.hashCode())) * 31) + (this.navigation == null ? 0 : this.navigation.hashCode())) * 31) + this.categoryList.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.categoryId)) * 31) + this.fetchModel.hashCode()) * 31) + this.observedRequestingActions.hashCode()) * 31) + (this.uiAction != null ? this.uiAction.hashCode() : 0);
    }

    public String toString() {
        KTribeeBaseInfo kTribeeBaseInfo = this.baseInfo;
        KTribeeInteraction kTribeeInteraction = this.interaction;
        KTribeeNavigation kTribeeNavigation = this.navigation;
        Map<KTribeeCategory, TribeeDynListState> map = this.categoryList;
        long j = this.categoryId;
        TribeeFetchModel tribeeFetchModel = this.fetchModel;
        Set<TribeeHomeStateAction> set = this.observedRequestingActions;
        return "TribeeHomeContentState(baseInfo=" + kTribeeBaseInfo + ", interaction=" + kTribeeInteraction + ", navigation=" + kTribeeNavigation + ", categoryList=" + map + ", categoryId=" + j + ", fetchModel=" + tribeeFetchModel + ", observedRequestingActions=" + set + ", uiAction=" + this.uiAction + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeeHomeContentState(KTribeeBaseInfo baseInfo, KTribeeInteraction interaction, KTribeeNavigation navigation, Map<KTribeeCategory, TribeeDynListState> map, long categoryId, TribeeFetchModel fetchModel, Set<? extends TribeeHomeStateAction> set, TribeeHomeUIAction uiAction) {
        super(categoryId, fetchModel, null, null, 12, null);
        Intrinsics.checkNotNullParameter(map, "categoryList");
        Intrinsics.checkNotNullParameter(fetchModel, "fetchModel");
        Intrinsics.checkNotNullParameter(set, "observedRequestingActions");
        this.baseInfo = baseInfo;
        this.interaction = interaction;
        this.navigation = navigation;
        this.categoryList = map;
        this.categoryId = categoryId;
        this.fetchModel = fetchModel;
        this.observedRequestingActions = set;
        this.uiAction = uiAction;
    }

    public /* synthetic */ TribeeHomeContentState(KTribeeBaseInfo kTribeeBaseInfo, KTribeeInteraction kTribeeInteraction, KTribeeNavigation kTribeeNavigation, Map map, long j, TribeeFetchModel tribeeFetchModel, Set set, TribeeHomeUIAction tribeeHomeUIAction, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : kTribeeBaseInfo, (i & 2) != 0 ? null : kTribeeInteraction, (i & 4) != 0 ? null : kTribeeNavigation, (i & 8) != 0 ? MapsKt.emptyMap() : map, j, (i & 32) != 0 ? new TribeeFetchModel(null, 0, 3, null) : tribeeFetchModel, (i & 64) != 0 ? SetsKt.emptySet() : set, (i & 128) != 0 ? null : tribeeHomeUIAction);
    }

    public final KTribeeBaseInfo getBaseInfo() {
        return this.baseInfo;
    }

    public final KTribeeInteraction getInteraction() {
        return this.interaction;
    }

    public final KTribeeNavigation getNavigation() {
        return this.navigation;
    }

    public final Map<KTribeeCategory, TribeeDynListState> getCategoryList() {
        return this.categoryList;
    }

    @Override // kntr.app.tribee.consume.viewmodel.state.TribeeHomeState
    public long getCategoryId() {
        return this.categoryId;
    }

    @Override // kntr.app.tribee.consume.viewmodel.state.TribeeHomeState
    public TribeeFetchModel getFetchModel() {
        return this.fetchModel;
    }

    @Override // kntr.app.tribee.consume.viewmodel.state.TribeeHomeState
    public Set<TribeeHomeStateAction> getObservedRequestingActions() {
        return this.observedRequestingActions;
    }

    @Override // kntr.app.tribee.consume.viewmodel.state.TribeeHomeState
    public TribeeHomeUIAction getUiAction() {
        return this.uiAction;
    }
}