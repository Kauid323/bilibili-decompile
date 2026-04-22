package tv.danmaku.bili.ui.garb;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bili.resource.homepage.R;
import com.bili.digital.common.data.BiliCollectionPreferenceData;
import com.bili.digital.common.data.CollectionBizType;
import com.bili.digital.common.data.SpaceBannerDigitalExtra;
import com.bili.digital.common.data.SpaceBannerExtra;
import com.bili.digital.common.data.SpaceBannerItem;
import com.bili.digital.common.data.SpaceBannerItemContent;
import com.bili.digital.common.data.SpaceBannerItemExtra;
import com.bili.digital.common.data.SpaceBannerTitle;
import com.bili.digital.common.data.SpaceBannerTop;
import com.bili.digital.common.data.SpaceHeaderRefreshMsg;
import com.bili.digital.common.player.DigitalCardPlayerManager;
import com.bili.digital.common.player.DigitalCardProgressCallback;
import com.bili.digital.common.player.VideoParams;
import com.bilibili.app.authorspace.ui.nft.utils.FixGridLayoutManager;
import com.bilibili.app.authorspace.ui.nft.utils.FooterLoadingWidget;
import com.bilibili.app.authorspace.ui.nft.utils.SpaceNftUtils;
import com.bilibili.app.authorspace.ui.nft.utils.SwipeLoadFragment;
import com.bilibili.base.BiliContext;
import com.bilibili.bililive.uam.view.UAMView;
import com.bilibili.bus.Violet;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.droid.ToastHelper;
import com.bilibili.framework.exposure.core.ExposureEntry;
import com.bilibili.framework.exposure.core.ExposureLayoutInfoReceiver;
import com.bilibili.framework.exposure.core.collecter.ComposeExposureLayoutInfoCollectorKt;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.json.JsonUtilKt;
import com.bilibili.okretro.response.BiliApiResponse;
import com.bilibili.pvtracker.IPvTracker;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ExposeFactory;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.databinding.BiliAppDialogDigitalCollectionRoomBinding;
import tv.danmaku.bili.flowcontrol.internal.config.FlowControlConfig;
import tv.danmaku.bili.ui.garb.CollectionNoticeUIState;
import tv.danmaku.bili.ui.garb.adapter.CollectionAllAdapter;
import tv.danmaku.bili.ui.garb.api.BiliNftApiManager;
import tv.danmaku.bili.ui.garb.api.CollectionReporterHelper;
import tv.danmaku.bili.ui.garb.api.CollectionRoomNoticeApiService;
import tv.danmaku.bili.ui.garb.api.Notice;
import tv.danmaku.bili.ui.garb.api.collection.BiliCollectionAllData;
import tv.danmaku.bili.ui.garb.api.collection.BiliCollectionData;
import tv.danmaku.bili.ui.garb.api.collection.BiliCollectionGlobalInfoData;
import tv.danmaku.bili.ui.garb.api.collection.BiliCollectionGlobalInfoSideBarData;
import tv.danmaku.bili.ui.garb.api.collection.BiliCollectionPageData;
import tv.danmaku.bili.ui.garb.api.collection.BiliCollectionUserData;
import tv.danmaku.bili.ui.garb.api.collection.TopCollectionSettingJumpUrlPageFrom;
import tv.danmaku.bili.ui.garb.digital.CollectionCardDetailCallback;
import tv.danmaku.bili.ui.garb.digital.base.view.DigitalFromType;
import tv.danmaku.bili.ui.garb.holder.FrontViewHolder;
import tv.danmaku.bili.ui.garb.manager.CollectionBackgroundManager;
import tv.danmaku.bili.ui.garb.manager.CollectionSideManager;
import tv.danmaku.bili.ui.garb.protocol.CardScrollListaner;
import tv.danmaku.bili.ui.garb.view.BackendRecycleView;
import tv.danmaku.bili.ui.garb.view.CollectionAllHeaderView;
import tv.danmaku.bili.ui.garb.view.CollectionFooterLoadingView;
import tv.danmaku.bili.ui.garb.view.FrontRecycleView;
import tv.danmaku.bili.ui.garb.view.NoticeBarUIKt;
import tv.danmaku.biliplayerv2.utils.DpUtils;

/* compiled from: CollectionRoomFragment.kt */
@Metadata(d1 = {"\u0000û\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0001P\b\u0007\u0018\u0000 \u0088\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0088\u0001\u0089\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J$\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020\u000eH\u0014J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u000208H\u0014J\b\u0010C\u001a\u00020AH\u0002J\b\u0010D\u001a\u00020AH\u0014J\u0010\u0010G\u001a\u00020H2\u0006\u0010B\u001a\u000208H\u0014J\u000e\u0010I\u001a\b\u0012\u0004\u0012\u00020K0JH\u0014J\u0010\u0010L\u001a\u00020M2\u0006\u0010B\u001a\u00020<H\u0014J\b\u0010N\u001a\u00020AH\u0016J\u001a\u0010T\u001a\u00020A2\u0006\u0010U\u001a\u00020V2\b\b\u0002\u0010W\u001a\u00020\u000eH\u0002J \u0010X\u001a\u00020A2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010Y\u001a\u00020\u000eH\u0002J\u0016\u0010i\u001a\u00020A2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020V0kH\u0002J\u001a\u0010l\u001a\u00020A2\u0006\u0010B\u001a\u0002082\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0010\u0010m\u001a\u00020A2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010n\u001a\u00020A2\u0006\u0010o\u001a\u00020\u000eH\u0002J\u0016\u0010p\u001a\u00020A2\u0006\u0010\u000b\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010qJ\b\u0010r\u001a\u00020AH\u0002J \u0010s\u001a\u00020A2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010t\u001a\u0004\u0018\u00010uH\u0002J\u0019\u0010v\u001a\u00020A2\n\b\u0002\u0010w\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010xJ\b\u0010y\u001a\u00020AH\u0002J.\u0010|\u001a\u00020A2\u000e\u0010}\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010~\u001a\u00020\n2\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010uH\u0002J-\u0010\u0080\u0001\u001a\u00020A2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010~\u001a\u00020\n2\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010uH\u0002J\t\u0010\u0081\u0001\u001a\u00020AH\u0016J\t\u0010\u0083\u0001\u001a\u00020AH\u0016J\t\u0010\u0084\u0001\u001a\u00020AH\u0016J\t\u0010\u0085\u0001\u001a\u00020AH\u0016J\t\u0010\u0086\u0001\u001a\u00020uH\u0016J\t\u0010\u0087\u0001\u001a\u00020>H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u001f\u001a\u0004\b&\u0010'R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u001f\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u001f\u001a\u0004\b0\u00101R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010O\u001a\u00020P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u001f\u001a\u0004\bQ\u0010RR\u001e\u0010Z\u001a\u0012\u0012\u0004\u0012\u00020\b0[j\b\u0012\u0004\u0012\u00020\b`\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010a\u001a\u00020`2\u0006\u0010_\u001a\u00020`8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u000e\u0010h\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020{X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0001\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008a\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/CollectionRoomFragment;", "Lcom/bilibili/app/authorspace/ui/nft/utils/SwipeLoadFragment;", "Ltv/danmaku/bili/ui/garb/digital/CollectionCardDetailCallback;", "Lcom/bilibili/pvtracker/IPvTracker;", "<init>", "()V", "initBanners", "", "Lcom/bili/digital/common/data/SpaceBannerItem;", "initPosition", "", "vmid", "", "collectionPublic", "", "initConfigurationData", "Ltv/danmaku/bili/ui/garb/InitConfigurationData;", "currentMid", "getCurrentMid", "()J", "isMe", "()Z", "mViewBinding", "Ltv/danmaku/bili/databinding/BiliAppDialogDigitalCollectionRoomBinding;", "mSideManager", "Ltv/danmaku/bili/ui/garb/manager/CollectionSideManager;", "mBackgroundManager", "Ltv/danmaku/bili/ui/garb/manager/CollectionBackgroundManager;", "getMBackgroundManager", "()Ltv/danmaku/bili/ui/garb/manager/CollectionBackgroundManager;", "mBackgroundManager$delegate", "Lkotlin/Lazy;", "playerManager", "Lcom/bili/digital/common/player/DigitalCardPlayerManager;", "noticeApiService", "Ltv/danmaku/bili/ui/garb/api/CollectionRoomNoticeApiService;", "mFrontRecycleView", "Ltv/danmaku/bili/ui/garb/view/FrontRecycleView;", "getMFrontRecycleView", "()Ltv/danmaku/bili/ui/garb/view/FrontRecycleView;", "mFrontRecycleView$delegate", "mBackendRecycleView", "Ltv/danmaku/bili/ui/garb/view/BackendRecycleView;", "getMBackendRecycleView", "()Ltv/danmaku/bili/ui/garb/view/BackendRecycleView;", "mBackendRecycleView$delegate", "mAllAdapter", "Ltv/danmaku/bili/ui/garb/adapter/CollectionAllAdapter;", "getMAllAdapter", "()Ltv/danmaku/bili/ui/garb/adapter/CollectionAllAdapter;", "mAllAdapter$delegate", "mAllData", "Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionData;", "passportObserver", "Lcom/bilibili/lib/accounts/subscribe/PassportObserver;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "isPullUpRefreshEnabled", "initRecyclerView", "", "view", "observerRefreshStateChange", "initHeadView", "mHeadView", "Ltv/danmaku/bili/ui/garb/view/CollectionAllHeaderView;", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "initAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "initFooterLoadingView", "Lcom/bilibili/app/authorspace/ui/nft/utils/FooterLoadingWidget;", "swipeUpLoadData", "mLoadNextCallback", "tv/danmaku/bili/ui/garb/CollectionRoomFragment$mLoadNextCallback$2$1", "getMLoadNextCallback", "()Ltv/danmaku/bili/ui/garb/CollectionRoomFragment$mLoadNextCallback$2$1;", "mLoadNextCallback$delegate", "loadDataSuccess", "data", "Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionAllData;", "loadFist", "updateData", "onlyAdded", "mAllListData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mLastPageData", "Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionPageData;", "<set-?>", "Ltv/danmaku/bili/ui/garb/CollectionNoticeUIState;", "noticeUiState", "getNoticeUiState", "()Ltv/danmaku/bili/ui/garb/CollectionNoticeUIState;", "setNoticeUiState", "(Ltv/danmaku/bili/ui/garb/CollectionNoticeUIState;)V", "noticeUiState$delegate", "Landroidx/compose/runtime/MutableState;", "noticeUiNeedRefresh", "requestData", "cb", "Lcom/bilibili/okretro/BiliApiDataCallback;", "onViewCreated", "initNoticeBar", "setNoticeBarVisibility", "visible", "refreshNoticeBar", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestApi", "displayInitBanners", "initCollectedFlagUrl", "", "refreshUI", "forceUpdate", "(Ljava/lang/Boolean;)V", "initViews", "mScrollListener", "Ltv/danmaku/bili/ui/garb/protocol/CardScrollListaner;", "renderTopBannerUI", "cardTypeList", "jumpToIndex", "collectedFlagUrl", "renderRecycleView", "onDestroyView", "isInited", "onResume", "onPause", "onDestroy", "getPvEventId", "getPvExtra", "Companion", "CollectionDecoration", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CollectionRoomFragment extends SwipeLoadFragment implements CollectionCardDetailCallback, IPvTracker {
    public static final int TITLE_MAX_ALPHA = 192;
    public static final int TITLE_MIN_ALPHA = 0;
    private boolean collectionPublic;
    private InitConfigurationData initConfigurationData;
    private int initPosition;
    private boolean isInited;
    private final Lazy mAllAdapter$delegate;
    private BiliCollectionData mAllData;
    private ArrayList<SpaceBannerItem> mAllListData;
    private final Lazy mBackendRecycleView$delegate;
    private final Lazy mFrontRecycleView$delegate;
    private CollectionAllHeaderView mHeadView;
    private BiliCollectionPageData mLastPageData;
    private final Lazy mLoadNextCallback$delegate;
    private final CardScrollListaner mScrollListener;
    private CollectionSideManager mSideManager;
    private BiliAppDialogDigitalCollectionRoomBinding mViewBinding;
    private final CollectionRoomNoticeApiService noticeApiService;
    private boolean noticeUiNeedRefresh;
    private final MutableState noticeUiState$delegate;
    private final PassportObserver passportObserver;
    private long vmid;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private List<SpaceBannerItem> initBanners = CollectionsKt.emptyList();
    private final Lazy mBackgroundManager$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda18
        public final Object invoke() {
            CollectionBackgroundManager mBackgroundManager_delegate$lambda$0;
            mBackgroundManager_delegate$lambda$0 = CollectionRoomFragment.mBackgroundManager_delegate$lambda$0();
            return mBackgroundManager_delegate$lambda$0;
        }
    });
    private final DigitalCardPlayerManager playerManager = DigitalCardPlayerManager.Companion.buildManager$default(DigitalCardPlayerManager.Companion, (Fragment) this, (FragmentActivity) null, false, 2, (Object) null);

    /* compiled from: CollectionRoomFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Topic.values().length];
            try {
                iArr[Topic.SIGN_IN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Topic.SIGN_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    @Override // tv.danmaku.bili.ui.garb.digital.CollectionCardDetailCallback
    public /* synthetic */ void onCardLoadSuccess(SpaceBannerItem spaceBannerItem) {
        CollectionCardDetailCallback.CC.$default$onCardLoadSuccess(this, spaceBannerItem);
    }

    @Override // tv.danmaku.bili.ui.garb.digital.CollectionCardDetailCallback
    public /* synthetic */ boolean onScrollEnd(SpaceBannerItem spaceBannerItem) {
        return CollectionCardDetailCallback.CC.$default$onScrollEnd(this, spaceBannerItem);
    }

    @Override // tv.danmaku.bili.ui.garb.digital.CollectionCardDetailCallback
    public /* synthetic */ void onScrollStart() {
        CollectionCardDetailCallback.CC.$default$onScrollStart(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    @Override // tv.danmaku.bili.ui.garb.digital.CollectionCardDetailCallback
    public /* synthetic */ void showCardInfo(SpaceBannerItem spaceBannerItem) {
        CollectionCardDetailCallback.CC.$default$showCardInfo(this, spaceBannerItem);
    }

    public CollectionRoomFragment() {
        Object createService = ServiceGenerator.createService(CollectionRoomNoticeApiService.class);
        Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
        this.noticeApiService = (CollectionRoomNoticeApiService) createService;
        this.mFrontRecycleView$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda19
            public final Object invoke() {
                FrontRecycleView mFrontRecycleView_delegate$lambda$0;
                mFrontRecycleView_delegate$lambda$0 = CollectionRoomFragment.mFrontRecycleView_delegate$lambda$0(CollectionRoomFragment.this);
                return mFrontRecycleView_delegate$lambda$0;
            }
        });
        this.mBackendRecycleView$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda20
            public final Object invoke() {
                BackendRecycleView mBackendRecycleView_delegate$lambda$0;
                mBackendRecycleView_delegate$lambda$0 = CollectionRoomFragment.mBackendRecycleView_delegate$lambda$0();
                return mBackendRecycleView_delegate$lambda$0;
            }
        });
        this.mAllAdapter$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda21
            public final Object invoke() {
                CollectionAllAdapter mAllAdapter_delegate$lambda$0;
                mAllAdapter_delegate$lambda$0 = CollectionRoomFragment.mAllAdapter_delegate$lambda$0(CollectionRoomFragment.this);
                return mAllAdapter_delegate$lambda$0;
            }
        });
        this.passportObserver = new PassportObserver() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda1
            public final void onChange(Topic topic) {
                CollectionRoomFragment.passportObserver$lambda$0(CollectionRoomFragment.this, topic);
            }
        };
        this.mLoadNextCallback$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda2
            public final Object invoke() {
                CollectionRoomFragment$mLoadNextCallback$2$1 mLoadNextCallback_delegate$lambda$0;
                mLoadNextCallback_delegate$lambda$0 = CollectionRoomFragment.mLoadNextCallback_delegate$lambda$0(CollectionRoomFragment.this);
                return mLoadNextCallback_delegate$lambda$0;
            }
        });
        this.mAllListData = new ArrayList<>();
        this.noticeUiState$delegate = SnapshotStateKt.mutableStateOf$default(CollectionNoticeUIState.Loading.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.mScrollListener = new CardScrollListaner() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$mScrollListener$1
            @Override // tv.danmaku.bili.ui.garb.protocol.CardScrollListaner
            public void onScrolled(int dx, int dy, int offset) {
                BackendRecycleView mBackendRecycleView;
                mBackendRecycleView = CollectionRoomFragment.this.getMBackendRecycleView();
                mBackendRecycleView.handleOnScrolledEvent(dx, dy, offset);
            }

            @Override // tv.danmaku.bili.ui.garb.protocol.CardScrollListaner
            public void onScrollStateChanged(int position) {
                BackendRecycleView mBackendRecycleView;
                mBackendRecycleView = CollectionRoomFragment.this.getMBackendRecycleView();
                mBackendRecycleView.handleOnScrollStateChangedEvent(position);
            }
        };
    }

    /* compiled from: CollectionRoomFragment.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JR\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J2\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/garb/CollectionRoomFragment$Companion;", "", "<init>", "()V", "TITLE_MAX_ALPHA", "", "TITLE_MIN_ALPHA", "newInstance", "Ltv/danmaku/bili/ui/garb/CollectionRoomFragment;", "initBanners", "", "Lcom/bili/digital/common/data/SpaceBannerItem;", "initPosition", "vmid", "", "collectionPublic", "", "trackParams", "", "", "initConfigurationData", "Ltv/danmaku/bili/ui/garb/InitConfigurationData;", "createTrackParams", "fSource", "from", "fromId", "part", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CollectionRoomFragment newInstance(List<SpaceBannerItem> list, int initPosition, long vmid, boolean collectionPublic, Map<String, String> map, InitConfigurationData initConfigurationData) {
            Intrinsics.checkNotNullParameter(list, "initBanners");
            Intrinsics.checkNotNullParameter(map, "trackParams");
            CollectionRoomFragment $this$newInstance_u24lambda_u240 = new CollectionRoomFragment();
            Bundle $this$newInstance_u24lambda_u240_u240 = new Bundle();
            $this$newInstance_u24lambda_u240_u240.putString("initBanners", JsonUtilKt.toJson(list));
            $this$newInstance_u24lambda_u240_u240.putInt("initPosition", initPosition);
            $this$newInstance_u24lambda_u240_u240.putLong("vmid", vmid);
            $this$newInstance_u24lambda_u240_u240.putBoolean("collectionPublic", collectionPublic);
            $this$newInstance_u24lambda_u240_u240.putString("trackParams", JsonUtilKt.toJson(map));
            $this$newInstance_u24lambda_u240_u240.putString("initConfigurationData", JsonUtilKt.toJson(initConfigurationData));
            $this$newInstance_u24lambda_u240.setArguments($this$newInstance_u24lambda_u240_u240);
            return $this$newInstance_u24lambda_u240;
        }

        public final Map<String, String> createTrackParams(String fSource, String from, String fromId, String part) {
            Intrinsics.checkNotNullParameter(fSource, "fSource");
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(fromId, "fromId");
            Intrinsics.checkNotNullParameter(part, "part");
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("f_source", fSource), TuplesKt.to("from", from), TuplesKt.to("from_id", fromId), TuplesKt.to("part", part)});
        }
    }

    private final long getCurrentMid() {
        return BiliAccounts.get(BiliContext.application()).mid();
    }

    private final boolean isMe() {
        return this.vmid == getCurrentMid();
    }

    private final CollectionBackgroundManager getMBackgroundManager() {
        return (CollectionBackgroundManager) this.mBackgroundManager$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CollectionBackgroundManager mBackgroundManager_delegate$lambda$0() {
        return new CollectionBackgroundManager();
    }

    private final FrontRecycleView getMFrontRecycleView() {
        return (FrontRecycleView) this.mFrontRecycleView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FrontRecycleView mFrontRecycleView_delegate$lambda$0(CollectionRoomFragment this$0) {
        VideoParams videoParams = new VideoParams(this$0.playerManager, (DigitalCardProgressCallback) null, 2, (DefaultConstructorMarker) null);
        Lifecycle lifecycle = this$0.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
        return new FrontRecycleView(videoParams, false, lifecycle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BackendRecycleView getMBackendRecycleView() {
        return (BackendRecycleView) this.mBackendRecycleView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BackendRecycleView mBackendRecycleView_delegate$lambda$0() {
        return new BackendRecycleView();
    }

    private final CollectionAllAdapter getMAllAdapter() {
        return (CollectionAllAdapter) this.mAllAdapter$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CollectionAllAdapter mAllAdapter_delegate$lambda$0(CollectionRoomFragment this$0) {
        Lifecycle lifecycle = this$0.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
        return new CollectionAllAdapter(lifecycle, this$0.isMe());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void passportObserver$lambda$0(CollectionRoomFragment this$0, Topic topic) {
        switch (topic == null ? -1 : WhenMappings.$EnumSwitchMapping$0[topic.ordinal()]) {
            case 1:
                if (this$0.vmid == 0) {
                    this$0.vmid = this$0.getCurrentMid();
                }
                this$0.requestApi();
                return;
            case 2:
            default:
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
        if (r0 != null) goto L7;
     */
    /* JADX WARN: Type inference failed for: r3v9, types: [tv.danmaku.bili.ui.garb.CollectionRoomFragment$onCreateView$$inlined$parseJson$1] */
    /* JADX WARN: Type inference failed for: r5v0, types: [tv.danmaku.bili.ui.garb.CollectionRoomFragment$onCreateView$$inlined$parseJson$2] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        List<SpaceBannerItem> emptyList;
        InitConfigurationData initConfigurationData;
        String $this$parseJson$iv;
        String $this$parseJson$iv2;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle arguments = getArguments();
        if (arguments != null && ($this$parseJson$iv2 = arguments.getString("initBanners")) != null) {
            Type type = new TypeToken<List<? extends SpaceBannerItem>>() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$onCreateView$$inlined$parseJson$1
            }.getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            emptyList = (List) JsonUtilKt.parseJson($this$parseJson$iv2, type);
        }
        emptyList = CollectionsKt.emptyList();
        this.initBanners = emptyList;
        Bundle arguments2 = getArguments();
        this.initPosition = arguments2 != null ? arguments2.getInt("initPosition") : 0;
        Bundle arguments3 = getArguments();
        this.vmid = arguments3 != null ? arguments3.getLong("vmid") : 0L;
        Bundle arguments4 = getArguments();
        this.collectionPublic = arguments4 != null ? arguments4.getBoolean("collectionPublic") : false;
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding = null;
        try {
            Bundle arguments5 = getArguments();
            if (arguments5 == null || ($this$parseJson$iv = arguments5.getString("initConfigurationData")) == null) {
                initConfigurationData = null;
            } else {
                Type type2 = new TypeToken<InitConfigurationData>() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$onCreateView$$inlined$parseJson$2
                }.getType();
                Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                initConfigurationData = (InitConfigurationData) JsonUtilKt.parseJson($this$parseJson$iv, type2);
            }
        } catch (Exception e) {
            initConfigurationData = null;
        }
        this.initConfigurationData = initConfigurationData;
        BiliAppDialogDigitalCollectionRoomBinding inflate = BiliAppDialogDigitalCollectionRoomBinding.inflate(LayoutInflater.from(getActivity()), container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.mViewBinding = inflate;
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding2 = this.mViewBinding;
        if (biliAppDialogDigitalCollectionRoomBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            biliAppDialogDigitalCollectionRoomBinding2 = null;
        }
        this.mSideManager = new CollectionSideManager(biliAppDialogDigitalCollectionRoomBinding2);
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding3 = this.mViewBinding;
        if (biliAppDialogDigitalCollectionRoomBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
        } else {
            biliAppDialogDigitalCollectionRoomBinding = biliAppDialogDigitalCollectionRoomBinding3;
        }
        View root = biliAppDialogDigitalCollectionRoomBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    protected boolean isPullUpRefreshEnabled() {
        return false;
    }

    protected void initRecyclerView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding = this.mViewBinding;
        if (biliAppDialogDigitalCollectionRoomBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            biliAppDialogDigitalCollectionRoomBinding = null;
        }
        final RecyclerView $this$initRecyclerView_u24lambda_u240 = biliAppDialogDigitalCollectionRoomBinding.collectionAllRecycleview;
        int vPadding = (ScreenUtil.getScreenWidth(requireContext()) - (ScreenUtil.dip2px(requireContext(), 164.0f) * 2)) / 6;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        final RecyclerView.LayoutManager fixGridLayoutManager = new FixGridLayoutManager(requireContext, 2);
        fixGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$initRecyclerView$1$1
            public int getSpanSize(int position) {
                RecyclerView.Adapter adapter = $this$initRecyclerView_u24lambda_u240.getAdapter();
                boolean z = false;
                if (adapter != null && adapter.getItemViewType(position) == 0) {
                    z = true;
                }
                if (z) {
                    return 1;
                }
                return fixGridLayoutManager.getSpanCount();
            }
        });
        $this$initRecyclerView_u24lambda_u240.setLayoutManager(fixGridLayoutManager);
        $this$initRecyclerView_u24lambda_u240.addItemDecoration(new CollectionDecoration(2, vPadding, vPadding));
        $this$initRecyclerView_u24lambda_u240.setItemAnimator((RecyclerView.ItemAnimator) null);
    }

    private final void observerRefreshStateChange() {
        Violet.INSTANCE.ofChannel(SpaceHeaderRefreshMsg.class).observeCachedInactive((LifecycleOwner) this, new Observer() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda10
            public final void onChanged(Object obj) {
                CollectionRoomFragment.observerRefreshStateChange$lambda$0(CollectionRoomFragment.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observerRefreshStateChange$lambda$0(CollectionRoomFragment this$0, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getMFrontRecycleView().onDestroyView();
        this$0.requestApi();
    }

    protected void initHeadView() {
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding = this.mViewBinding;
        CollectionAllHeaderView collectionAllHeaderView = null;
        if (biliAppDialogDigitalCollectionRoomBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            biliAppDialogDigitalCollectionRoomBinding = null;
        }
        ViewGroup viewGroup = biliAppDialogDigitalCollectionRoomBinding.collectionAllRecycleview;
        Intrinsics.checkNotNullExpressionValue(viewGroup, "collectionAllRecycleview");
        this.mHeadView = new CollectionAllHeaderView(viewGroup);
        CollectionAllHeaderView collectionAllHeaderView2 = this.mHeadView;
        if (collectionAllHeaderView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeadView");
        } else {
            collectionAllHeaderView = collectionAllHeaderView2;
        }
        addHeaderView(collectionAllHeaderView.getView());
    }

    protected RecyclerView getRecyclerView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding = this.mViewBinding;
        if (biliAppDialogDigitalCollectionRoomBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            biliAppDialogDigitalCollectionRoomBinding = null;
        }
        RecyclerView recyclerView = biliAppDialogDigitalCollectionRoomBinding.collectionAllRecycleview;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "collectionAllRecycleview");
        return recyclerView;
    }

    protected RecyclerView.Adapter<RecyclerView.ViewHolder> initAdapter() {
        return getMAllAdapter();
    }

    protected FooterLoadingWidget initFooterLoadingView(ViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return new CollectionFooterLoadingView(view, new Function1() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                Unit initFooterLoadingView$lambda$0;
                initFooterLoadingView$lambda$0 = CollectionRoomFragment.initFooterLoadingView$lambda$0(CollectionRoomFragment.this, (Integer) obj);
                return initFooterLoadingView$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initFooterLoadingView$lambda$0(CollectionRoomFragment this$0, Integer it) {
        BiliCollectionGlobalInfoData globalInfo;
        BiliCollectionGlobalInfoSideBarData sidebarInfo;
        if (it != null && it.intValue() == 1) {
            this$0.requestData(this$0.getMLoadNextCallback());
        } else if (it != null && it.intValue() == 2) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_bottom");
            map.put("f_source", "collection");
            SpaceNftUtils spaceNftUtils = SpaceNftUtils.INSTANCE;
            BiliCollectionData biliCollectionData = this$0.mAllData;
            spaceNftUtils.routeWithMap((biliCollectionData == null || (globalInfo = biliCollectionData.getGlobalInfo()) == null || (sidebarInfo = globalInfo.getSidebarInfo()) == null) ? null : sidebarInfo.getGarbMallJumpUrl(), map, this$0.getActivity());
            CollectionReporterHelper.INSTANCE.reportCollectionBottomClick(this$0.isMe());
        }
        return Unit.INSTANCE;
    }

    public void swipeUpLoadData() {
        requestData(getMLoadNextCallback());
    }

    private final CollectionRoomFragment$mLoadNextCallback$2$1 getMLoadNextCallback() {
        return (CollectionRoomFragment$mLoadNextCallback$2$1) this.mLoadNextCallback$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [tv.danmaku.bili.ui.garb.CollectionRoomFragment$mLoadNextCallback$2$1] */
    public static final CollectionRoomFragment$mLoadNextCallback$2$1 mLoadNextCallback_delegate$lambda$0(final CollectionRoomFragment this$0) {
        return new BiliApiDataCallback<BiliCollectionAllData>() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$mLoadNextCallback$2$1
            public void onError(Throwable t) {
                CollectionRoomFragment.this.setLoadNextFailed();
            }

            public void onDataSuccess(BiliCollectionAllData data) {
                if ((data != null ? data.getResult() : null) != null && !data.getResult().isEmpty()) {
                    CollectionRoomFragment.loadDataSuccess$default(CollectionRoomFragment.this, data, false, 2, null);
                } else {
                    onError(null);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void loadDataSuccess$default(CollectionRoomFragment collectionRoomFragment, BiliCollectionAllData biliCollectionAllData, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        collectionRoomFragment.loadDataSuccess(biliCollectionAllData, z);
    }

    private final void loadDataSuccess(BiliCollectionAllData data, boolean loadFist) {
        if (data.getResult() == null) {
            BLog.e("NftListFragment", "req api suc, but data is null");
            setLoadNextFailed();
            return;
        }
        BiliCollectionPageData page = data.getPage();
        boolean z = false;
        setLoadNextSuc(page != null && page.getHasMore());
        BiliCollectionPageData page2 = data.getPage();
        if (page2 != null && page2.getHasMore()) {
            z = true;
        }
        if (!z) {
            CollectionReporterHelper.INSTANCE.reportCollectionBottomShow(isMe());
        }
        List newData = data.getResult();
        this.mLastPageData = data.getPage();
        updateData(newData, !loadFist);
    }

    static /* synthetic */ void updateData$default(CollectionRoomFragment collectionRoomFragment, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        collectionRoomFragment.updateData(list, z);
    }

    private final void updateData(List<SpaceBannerItem> list, boolean onlyAdded) {
        if (list.isEmpty()) {
            return;
        }
        int oldSize = this.mAllListData.size();
        if (onlyAdded) {
            this.mAllListData.addAll(list);
            String ids = CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda16
                public final Object invoke(Object obj) {
                    CharSequence updateData$lambda$0;
                    updateData$lambda$0 = CollectionRoomFragment.updateData$lambda$0((SpaceBannerItem) obj);
                    return updateData$lambda$0;
                }
            }, 30, (Object) null);
            CollectionReporterHelper.INSTANCE.reportCollectionAllShow(ids, isMe());
            getMAllAdapter().updateData(this.mAllListData);
            getMAllAdapter().notifyItemRangeChanged(oldSize, list.size());
            return;
        }
        this.mAllListData.clear();
        getMAllAdapter().notifyItemRangeRemoved(0, oldSize);
        this.mAllListData.addAll(list);
        String ids2 = CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda17
            public final Object invoke(Object obj) {
                CharSequence updateData$lambda$1;
                updateData$lambda$1 = CollectionRoomFragment.updateData$lambda$1((SpaceBannerItem) obj);
                return updateData$lambda$1;
            }
        }, 30, (Object) null);
        CollectionReporterHelper.INSTANCE.reportCollectionAllShow(ids2, isMe());
        getMAllAdapter().updateData(this.mAllListData);
        getMAllAdapter().notifyItemRangeChanged(0, list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence updateData$lambda$0(SpaceBannerItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getItemId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence updateData$lambda$1(SpaceBannerItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getItemId();
    }

    private final CollectionNoticeUIState getNoticeUiState() {
        State $this$getValue$iv = this.noticeUiState$delegate;
        return (CollectionNoticeUIState) $this$getValue$iv.getValue();
    }

    private final void setNoticeUiState(CollectionNoticeUIState collectionNoticeUIState) {
        MutableState $this$setValue$iv = this.noticeUiState$delegate;
        $this$setValue$iv.setValue(collectionNoticeUIState);
    }

    private final void requestData(BiliApiDataCallback<BiliCollectionAllData> biliApiDataCallback) {
        BiliNftApiManager biliNftApiManager = BiliNftApiManager.INSTANCE;
        long currentMid = getCurrentMid();
        long j = this.vmid;
        BiliCollectionPageData biliCollectionPageData = this.mLastPageData;
        int ps = biliCollectionPageData != null ? biliCollectionPageData.getPs() : 0;
        BiliCollectionPageData biliCollectionPageData2 = this.mLastPageData;
        int lastType = biliCollectionPageData2 != null ? biliCollectionPageData2.getLastType() : 0;
        BiliCollectionPageData biliCollectionPageData3 = this.mLastPageData;
        BiliNftApiManager.getCollectionPageData$default(biliNftApiManager, Long.valueOf(currentMid), Long.valueOf(j), null, Integer.valueOf(ps), Long.valueOf(biliCollectionPageData3 != null ? biliCollectionPageData3.getLastId() : 0L), Integer.valueOf(lastType), biliApiDataCallback, 4, null);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        BiliAccounts.get(BiliContext.application()).subscribe(this.passportObserver, new Topic[]{Topic.SIGN_IN, Topic.SIGN_OUT});
        if (isMe() && !BiliAccounts.get(BiliContext.application()).isLogin()) {
            SpaceNftUtils.INSTANCE.routeTo("activity://main/login/", getContext());
        } else {
            requestApi();
        }
        initViews();
        if (!this.initBanners.isEmpty()) {
            List<SpaceBannerItem> list = this.initBanners;
            InitConfigurationData initConfigurationData = this.initConfigurationData;
            displayInitBanners(list, initConfigurationData != null ? initConfigurationData.getCollectionCompletedUrl() : null);
        }
        long vmid = isMe() ? 0L : this.vmid;
        initNoticeBar(vmid);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new CollectionRoomFragment$onViewCreated$1(this, vmid, null), 3, (Object) null);
    }

    private final void initNoticeBar(final long vmid) {
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding = this.mViewBinding;
        if (biliAppDialogDigitalCollectionRoomBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            biliAppDialogDigitalCollectionRoomBinding = null;
        }
        biliAppDialogDigitalCollectionRoomBinding.collectionNoticeBar.setContent(ComposableLambdaKt.composableLambdaInstance(1636624404, true, new Function2() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit initNoticeBar$lambda$0;
                initNoticeBar$lambda$0 = CollectionRoomFragment.initNoticeBar$lambda$0(CollectionRoomFragment.this, vmid, (Composer) obj, ((Integer) obj2).intValue());
                return initNoticeBar$lambda$0;
            }
        }));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new CollectionRoomFragment$initNoticeBar$2(this, vmid, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initNoticeBar$lambda$0(final CollectionRoomFragment this$0, final long $vmid, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:CollectionRoomFragment.kt#o7wau3");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1636624404, $changed, -1, "tv.danmaku.bili.ui.garb.CollectionRoomFragment.initNoticeBar.<anonymous> (CollectionRoomFragment.kt:358)");
            }
            CollectionNoticeUIState noticeUiState = this$0.getNoticeUiState();
            if (Intrinsics.areEqual(noticeUiState, CollectionNoticeUIState.Loading.INSTANCE)) {
                $composer.startReplaceGroup(208982572);
                $composer.endReplaceGroup();
            } else if (noticeUiState instanceof CollectionNoticeUIState.Failure) {
                $composer.startReplaceGroup(209039116);
                $composer.endReplaceGroup();
            } else if (!(noticeUiState instanceof CollectionNoticeUIState.Ready)) {
                $composer.startReplaceGroup(838024583);
                $composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            } else {
                $composer.startReplaceGroup(209155831);
                ComposerKt.sourceInformation($composer, "367@14332L239,374@14602L1360,374@14592L1370");
                final Notice notice = ((CollectionNoticeUIState.Ready) noticeUiState).getNotice();
                final Map $this$initNoticeBar_u24lambda_u240_u240 = new LinkedHashMap();
                $this$initNoticeBar_u24lambda_u240_u240.put("type", this$0.isMe() ? "1" : "2");
                $this$initNoticeBar_u24lambda_u240_u240.put("text_type", String.valueOf(notice.getNoticeTextType()));
                ExposeFactory exposeFactory = ExposeFactory.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 838040675, "CC(remember):CollectionRoomFragment.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($this$initNoticeBar_u24lambda_u240_u240);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda14
                        public final Object invoke() {
                            Unit initNoticeBar$lambda$0$1$0;
                            initNoticeBar$lambda$0$1$0 = CollectionRoomFragment.initNoticeBar$lambda$0$1$0($this$initNoticeBar_u24lambda_u240_u240);
                            return initNoticeBar$lambda$0$1$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                final ExposureEntry exposureEntry = exposeFactory.newExposureEntry((Function0) it$iv);
                BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(636678028, true, new Function2() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj, Object obj2) {
                        Unit initNoticeBar$lambda$0$2;
                        initNoticeBar$lambda$0$2 = CollectionRoomFragment.initNoticeBar$lambda$0$2(Notice.this, $this$initNoticeBar_u24lambda_u240_u240, this$0, $vmid, exposureEntry, (Composer) obj, ((Integer) obj2).intValue());
                        return initNoticeBar$lambda$0$2;
                    }
                }, $composer, 54), $composer, (int) BR.negativeBtnVisible, 3);
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initNoticeBar$lambda$0$1$0(Map $reportMap) {
        Neurons.reportExposure$default(false, "sqzz.dressing.collection.notice.show", $reportMap, (List) null, 8, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initNoticeBar$lambda$0$2(final Notice $notice, final Map $reportMap, final CollectionRoomFragment this$0, final long $vmid, ExposureEntry $exposureEntry, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C377@14730L480,387@15250L574,375@14628L1312:CollectionRoomFragment.kt#o7wau3");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(636678028, $changed, -1, "tv.danmaku.bili.ui.garb.CollectionRoomFragment.initNoticeBar.<anonymous>.<anonymous> (CollectionRoomFragment.kt:375)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1962233452, "CC(remember):CollectionRoomFragment.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($reportMap) | $composer.changed($notice) | $composer.changedInstance(this$0);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda12
                    public final Object invoke() {
                        Unit initNoticeBar$lambda$0$2$0$0;
                        initNoticeBar$lambda$0$2$0$0 = CollectionRoomFragment.initNoticeBar$lambda$0$2$0$0($reportMap, $notice, this$0);
                        return initNoticeBar$lambda$0$2$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function0 function0 = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1962250186, "CC(remember):CollectionRoomFragment.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance(this$0) | $composer.changed($vmid) | $composer.changedInstance($reportMap);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda13
                    public final Object invoke() {
                        Unit initNoticeBar$lambda$0$2$1$0;
                        initNoticeBar$lambda$0$2$1$0 = CollectionRoomFragment.initNoticeBar$lambda$0$2$1$0(CollectionRoomFragment.this, $reportMap, $vmid);
                        return initNoticeBar$lambda$0$2$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            NoticeBarUIKt.NoticeBarUI($notice, function0, (Function0) it$iv2, ComposeExposureLayoutInfoCollectorKt.collectExposureLayoutInfo(Modifier.Companion, (ExposureLayoutInfoReceiver) $exposureEntry), $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initNoticeBar$lambda$0$2$0$0(Map $reportMap, Notice $notice, CollectionRoomFragment this$0) {
        $reportMap.put("btn", "1");
        Neurons.reportClick(false, "sqzz.dressing.collection.notice.click", $reportMap);
        BLRouter.routeTo$default(RouteRequestKt.toRouteRequest($notice.getBtnUrl()), (Context) null, 2, (Object) null);
        this$0.noticeUiNeedRefresh = true;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initNoticeBar$lambda$0$2$1$0(CollectionRoomFragment this$0, Map $reportMap, long $vmid) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this$0), (CoroutineContext) null, (CoroutineStart) null, new CollectionRoomFragment$initNoticeBar$1$1$2$1$1(this$0, $vmid, null), 3, (Object) null);
        $reportMap.put("btn", "2");
        Neurons.reportClick(false, "sqzz.dressing.collection.notice.click", $reportMap);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setNoticeBarVisibility(boolean visible) {
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding = this.mViewBinding;
        if (biliAppDialogDigitalCollectionRoomBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            biliAppDialogDigitalCollectionRoomBinding = null;
        }
        View view = biliAppDialogDigitalCollectionRoomBinding.collectionNoticeBar;
        Intrinsics.checkNotNullExpressionValue(view, "collectionNoticeBar");
        View $this$isVisible$iv = view;
        $this$isVisible$iv.setVisibility(visible ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshNoticeBar(long vmid, Continuation<? super Unit> continuation) {
        CollectionRoomFragment$refreshNoticeBar$1 collectionRoomFragment$refreshNoticeBar$1;
        CollectionRoomFragment collectionRoomFragment;
        Object requestNotice;
        BiliApiResponse.BusinessFailure businessFailure;
        CollectionNoticeUIState.Failure failure;
        CollectionNoticeUIState.Failure failure2;
        if (continuation instanceof CollectionRoomFragment$refreshNoticeBar$1) {
            collectionRoomFragment$refreshNoticeBar$1 = (CollectionRoomFragment$refreshNoticeBar$1) continuation;
            if ((collectionRoomFragment$refreshNoticeBar$1.label & Integer.MIN_VALUE) != 0) {
                collectionRoomFragment$refreshNoticeBar$1.label -= Integer.MIN_VALUE;
                Object $result = collectionRoomFragment$refreshNoticeBar$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (collectionRoomFragment$refreshNoticeBar$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        collectionRoomFragment = this;
                        CollectionRoomNoticeApiService collectionRoomNoticeApiService = collectionRoomFragment.noticeApiService;
                        collectionRoomFragment$refreshNoticeBar$1.label = 1;
                        requestNotice = collectionRoomNoticeApiService.requestNotice(vmid, collectionRoomFragment$refreshNoticeBar$1);
                        if (requestNotice == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        collectionRoomFragment = this;
                        requestNotice = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                businessFailure = (BiliApiResponse) requestNotice;
                if (!(businessFailure instanceof BiliApiResponse.BusinessFailure)) {
                    failure2 = new CollectionNoticeUIState.Failure(false);
                } else if (businessFailure instanceof BiliApiResponse.ServiceUnavailable) {
                    ((BiliApiResponse.ServiceUnavailable) businessFailure).getException();
                    failure2 = new CollectionNoticeUIState.Failure(true);
                } else if (businessFailure instanceof BiliApiResponse.Success) {
                    Notice notice = (Notice) ((BiliApiResponse.Success) businessFailure).getData();
                    if (notice == null || notice.getNoticeTextType() == 0) {
                        failure = new CollectionNoticeUIState.Failure(false);
                    } else {
                        failure = new CollectionNoticeUIState.Ready(notice, collectionRoomFragment.isMe());
                    }
                    failure2 = failure;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                CollectionNoticeUIState uiState = failure2;
                collectionRoomFragment.setNoticeBarVisibility(uiState instanceof CollectionNoticeUIState.Ready);
                collectionRoomFragment.setNoticeUiState(uiState);
                return Unit.INSTANCE;
            }
        }
        collectionRoomFragment$refreshNoticeBar$1 = new CollectionRoomFragment$refreshNoticeBar$1(this, continuation);
        Object $result2 = collectionRoomFragment$refreshNoticeBar$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (collectionRoomFragment$refreshNoticeBar$1.label) {
        }
        businessFailure = (BiliApiResponse) requestNotice;
        if (!(businessFailure instanceof BiliApiResponse.BusinessFailure)) {
        }
        CollectionNoticeUIState uiState2 = failure2;
        collectionRoomFragment.setNoticeBarVisibility(uiState2 instanceof CollectionNoticeUIState.Ready);
        collectionRoomFragment.setNoticeUiState(uiState2);
        return Unit.INSTANCE;
    }

    private final void requestApi() {
        BiliNftApiManager.INSTANCE.getCollectionData(Long.valueOf(getCurrentMid()), Long.valueOf(this.vmid), new BiliApiDataCallback<BiliCollectionData>() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$requestApi$1
            public void onError(Throwable t) {
                ToastHelper.showToast(CollectionRoomFragment.this.getActivity(), "请求数据失败，请稍后重试", 0);
            }

            public void onDataSuccess(BiliCollectionData data) {
                boolean activityDie;
                BiliCollectionData biliCollectionData;
                BiliCollectionAllData all;
                BiliCollectionPageData page;
                activityDie = CollectionRoomFragment.this.activityDie();
                if (!activityDie && data != null) {
                    CollectionRoomFragment collectionRoomFragment = CollectionRoomFragment.this;
                    collectionRoomFragment.mAllData = data;
                    BiliCollectionAllData all2 = data.getAll();
                    collectionRoomFragment.setLoadNextSuc((all2 == null || (page = all2.getPage()) == null || !page.getHasMore()) ? false : true);
                    biliCollectionData = collectionRoomFragment.mAllData;
                    collectionRoomFragment.mLastPageData = (biliCollectionData == null || (all = biliCollectionData.getAll()) == null) ? null : all.getPage();
                    BiliCollectionPreferenceData preference = data.getPreference();
                    collectionRoomFragment.collectionPublic = preference != null ? preference.getCollectionPublic() : false;
                    CollectionRoomFragment.refreshUI$default(collectionRoomFragment, null, 1, null);
                }
            }
        });
    }

    private final void displayInitBanners(List<SpaceBannerItem> list, String initCollectedFlagUrl) {
        String str;
        BiliCollectionGlobalInfoData globalInfo;
        BiliCollectionPreferenceData preference;
        SpaceBannerItemExtra extra;
        if (this.collectionPublic || isMe()) {
            List<SpaceBannerItem> $this$filter$iv = list;
            Collection destination$iv$iv = new ArrayList();
            Iterator<T> it = $this$filter$iv.iterator();
            while (true) {
                boolean z = false;
                if (!it.hasNext()) {
                    break;
                }
                Object element$iv$iv = it.next();
                SpaceBannerItem it2 = (SpaceBannerItem) element$iv$iv;
                SpaceBannerItemContent item = it2.getItem();
                if (item != null && (extra = item.getExtra()) != null && extra.getShowInCollection()) {
                    z = true;
                }
                if (z) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            List collectionData = (List) destination$iv$iv;
            if (collectionData.isEmpty()) {
                BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding = null;
                if (isMe()) {
                    BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding2 = this.mViewBinding;
                    if (biliAppDialogDigitalCollectionRoomBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                        biliAppDialogDigitalCollectionRoomBinding2 = null;
                    }
                    biliAppDialogDigitalCollectionRoomBinding2.collectionTopContainer.setVisibility(0);
                    BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding3 = this.mViewBinding;
                    if (biliAppDialogDigitalCollectionRoomBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                        biliAppDialogDigitalCollectionRoomBinding3 = null;
                    }
                    biliAppDialogDigitalCollectionRoomBinding3.nftCardListBackend.setVisibility(8);
                    BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding4 = this.mViewBinding;
                    if (biliAppDialogDigitalCollectionRoomBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                        biliAppDialogDigitalCollectionRoomBinding4 = null;
                    }
                    biliAppDialogDigitalCollectionRoomBinding4.nftCardListFront.setVisibility(8);
                    BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding5 = this.mViewBinding;
                    if (biliAppDialogDigitalCollectionRoomBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                        biliAppDialogDigitalCollectionRoomBinding5 = null;
                    }
                    biliAppDialogDigitalCollectionRoomBinding5.collectionEmptyView.setVisibility(0);
                    BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding6 = this.mViewBinding;
                    if (biliAppDialogDigitalCollectionRoomBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                        biliAppDialogDigitalCollectionRoomBinding6 = null;
                    }
                    AppCompatTextView appCompatTextView = biliAppDialogDigitalCollectionRoomBinding6.collectionEmptyTime;
                    BiliCollectionData biliCollectionData = this.mAllData;
                    appCompatTextView.setText((biliCollectionData == null || (preference = biliCollectionData.getPreference()) == null || (r2 = preference.getGarbFirstGain()) == null) ? "曾经" : "曾经");
                    BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding7 = this.mViewBinding;
                    if (biliAppDialogDigitalCollectionRoomBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    } else {
                        biliAppDialogDigitalCollectionRoomBinding = biliAppDialogDigitalCollectionRoomBinding7;
                    }
                    biliAppDialogDigitalCollectionRoomBinding.collectionSetMyCollection.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda9
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CollectionRoomFragment.displayInitBanners$lambda$1(CollectionRoomFragment.this, view);
                        }
                    });
                    return;
                }
                BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding8 = this.mViewBinding;
                if (biliAppDialogDigitalCollectionRoomBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                } else {
                    biliAppDialogDigitalCollectionRoomBinding = biliAppDialogDigitalCollectionRoomBinding8;
                }
                biliAppDialogDigitalCollectionRoomBinding.collectionTopContainer.setVisibility(8);
                return;
            }
            int i = this.initPosition;
            BiliCollectionData biliCollectionData2 = this.mAllData;
            if (biliCollectionData2 == null || (globalInfo = biliCollectionData2.getGlobalInfo()) == null || (str = globalInfo.getCollectionCompletedUrl()) == null) {
                str = initCollectedFlagUrl;
            }
            renderTopBannerUI(list, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayInitBanners$lambda$1(CollectionRoomFragment this$0, View it) {
        BiliCollectionGlobalInfoData globalInfo;
        BiliCollectionGlobalInfoSideBarData sidebarInfo;
        String it2;
        BiliCollectionData biliCollectionData = this$0.mAllData;
        if (biliCollectionData != null && (globalInfo = biliCollectionData.getGlobalInfo()) != null && (sidebarInfo = globalInfo.getSidebarInfo()) != null && (it2 = sidebarInfo.getTopSettingJumpUrl()) != null) {
            SpaceNftUtils.INSTANCE.routeWithMap(it2, MapsKt.mapOf(TuplesKt.to("page_from", TopCollectionSettingJumpUrlPageFrom.EMPTY_STATE_SETTING_BUTTON.getReportValue())), this$0.getActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void refreshUI$default(CollectionRoomFragment collectionRoomFragment, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = false;
        }
        collectionRoomFragment.refreshUI(bool);
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0139, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r17, true) == false) goto L80;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void refreshUI(Boolean forceUpdate) {
        BiliCollectionPreferenceData preference;
        BiliCollectionGlobalInfoData globalInfo;
        BiliCollectionAllData all;
        BiliCollectionAllData all2;
        BiliCollectionUserData userInfo;
        String avatar;
        BiliCollectionAllData all3;
        List<SpaceBannerItem> result;
        BiliCollectionGlobalInfoData globalInfo2;
        SpaceBannerTop top;
        SpaceBannerTop top2;
        List result2;
        String str;
        BiliCollectionGlobalInfoData globalInfo3;
        BiliCollectionUserData userInfo2;
        BiliCollectionGlobalInfoData globalInfo4;
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding = this.mViewBinding;
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding2 = null;
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding3 = null;
        r3 = null;
        String str2 = null;
        if (biliAppDialogDigitalCollectionRoomBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            biliAppDialogDigitalCollectionRoomBinding = null;
        }
        biliAppDialogDigitalCollectionRoomBinding.collectionMenuButton.setVisibility(isMe() ? 0 : 8);
        CollectionSideManager collectionSideManager = this.mSideManager;
        if (collectionSideManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSideManager");
            collectionSideManager = null;
        }
        BiliCollectionData biliCollectionData = this.mAllData;
        BiliCollectionGlobalInfoSideBarData sidebarInfo = (biliCollectionData == null || (globalInfo4 = biliCollectionData.getGlobalInfo()) == null) ? null : globalInfo4.getSidebarInfo();
        BiliCollectionData biliCollectionData2 = this.mAllData;
        BiliCollectionPreferenceData preference2 = biliCollectionData2 != null ? biliCollectionData2.getPreference() : null;
        BiliCollectionData biliCollectionData3 = this.mAllData;
        String str3 = "";
        collectionSideManager.initData(sidebarInfo, preference2, (biliCollectionData3 == null || (userInfo2 = biliCollectionData3.getUserInfo()) == null || (r8 = userInfo2.getAvatar()) == null) ? "" : "");
        CollectionBackgroundManager mBackgroundManager = getMBackgroundManager();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding4 = this.mViewBinding;
        if (biliAppDialogDigitalCollectionRoomBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            biliAppDialogDigitalCollectionRoomBinding4 = null;
        }
        UAMView uAMView = biliAppDialogDigitalCollectionRoomBinding4.collectionUamAnim;
        Intrinsics.checkNotNullExpressionValue(uAMView, "collectionUamAnim");
        BiliCollectionData biliCollectionData4 = this.mAllData;
        mBackgroundManager.loadBg(requireContext, uAMView, (biliCollectionData4 == null || (globalInfo3 = biliCollectionData4.getGlobalInfo()) == null) ? null : globalInfo3.getCollectionBackgroundUrl());
        if (this.collectionPublic || isMe()) {
            BiliCollectionData biliCollectionData5 = this.mAllData;
            if (((biliCollectionData5 == null || (top2 = biliCollectionData5.getTop()) == null || (result2 = top2.getResult()) == null) ? 0 : result2.size()) > 0) {
                if (this.initBanners.isEmpty()) {
                }
                BiliCollectionData biliCollectionData6 = this.mAllData;
                List<SpaceBannerItem> result3 = (biliCollectionData6 == null || (top = biliCollectionData6.getTop()) == null) ? null : top.getResult();
                int i = this.initPosition;
                BiliCollectionData biliCollectionData7 = this.mAllData;
                renderTopBannerUI(result3, i, (biliCollectionData7 == null || (globalInfo2 = biliCollectionData7.getGlobalInfo()) == null) ? null : globalInfo2.getCollectionCompletedUrl());
                BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding5 = this.mViewBinding;
                if (biliAppDialogDigitalCollectionRoomBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    biliAppDialogDigitalCollectionRoomBinding5 = null;
                }
                biliAppDialogDigitalCollectionRoomBinding5.collectionEmptyView.setVisibility(8);
            } else if (isMe()) {
                BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding6 = this.mViewBinding;
                if (biliAppDialogDigitalCollectionRoomBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    biliAppDialogDigitalCollectionRoomBinding6 = null;
                }
                biliAppDialogDigitalCollectionRoomBinding6.collectionTopContainer.setVisibility(0);
                BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding7 = this.mViewBinding;
                if (biliAppDialogDigitalCollectionRoomBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    biliAppDialogDigitalCollectionRoomBinding7 = null;
                }
                biliAppDialogDigitalCollectionRoomBinding7.nftCardListBackend.setVisibility(8);
                BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding8 = this.mViewBinding;
                if (biliAppDialogDigitalCollectionRoomBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    biliAppDialogDigitalCollectionRoomBinding8 = null;
                }
                biliAppDialogDigitalCollectionRoomBinding8.nftCardListFront.setVisibility(8);
                BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding9 = this.mViewBinding;
                if (biliAppDialogDigitalCollectionRoomBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    biliAppDialogDigitalCollectionRoomBinding9 = null;
                }
                biliAppDialogDigitalCollectionRoomBinding9.collectionEmptyView.setVisibility(0);
                BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding10 = this.mViewBinding;
                if (biliAppDialogDigitalCollectionRoomBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    biliAppDialogDigitalCollectionRoomBinding10 = null;
                }
                AppCompatTextView appCompatTextView = biliAppDialogDigitalCollectionRoomBinding10.collectionEmptyTime;
                BiliCollectionData biliCollectionData8 = this.mAllData;
                appCompatTextView.setText((biliCollectionData8 == null || (preference = biliCollectionData8.getPreference()) == null || (r7 = preference.getGarbFirstGain()) == null) ? "曾经" : "曾经");
                BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding11 = this.mViewBinding;
                if (biliAppDialogDigitalCollectionRoomBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    biliAppDialogDigitalCollectionRoomBinding11 = null;
                }
                biliAppDialogDigitalCollectionRoomBinding11.collectionSetMyCollection.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CollectionRoomFragment.refreshUI$lambda$0(CollectionRoomFragment.this, view);
                    }
                });
                CollectionReporterHelper.INSTANCE.reportCollectionTopShow(null, null, null, "2");
            } else {
                BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding12 = this.mViewBinding;
                if (biliAppDialogDigitalCollectionRoomBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    biliAppDialogDigitalCollectionRoomBinding12 = null;
                }
                biliAppDialogDigitalCollectionRoomBinding12.collectionTopContainer.setVisibility(8);
            }
            BiliCollectionData biliCollectionData9 = this.mAllData;
            if (((biliCollectionData9 == null || (all3 = biliCollectionData9.getAll()) == null || (result = all3.getResult()) == null) ? 0 : result.size()) > 0) {
                BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding13 = this.mViewBinding;
                if (biliAppDialogDigitalCollectionRoomBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    biliAppDialogDigitalCollectionRoomBinding13 = null;
                }
                if (biliAppDialogDigitalCollectionRoomBinding13.collectionTopContainer.getVisibility() == 8) {
                    BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding14 = this.mViewBinding;
                    if (biliAppDialogDigitalCollectionRoomBinding14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                        biliAppDialogDigitalCollectionRoomBinding14 = null;
                    }
                    RecyclerView recyclerView = biliAppDialogDigitalCollectionRoomBinding14.collectionAllRecycleview;
                    BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding15 = this.mViewBinding;
                    if (biliAppDialogDigitalCollectionRoomBinding15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                        biliAppDialogDigitalCollectionRoomBinding15 = null;
                    }
                    ViewGroup.LayoutParams $this$refreshUI_u24lambda_u241 = biliAppDialogDigitalCollectionRoomBinding15.collectionAllRecycleview.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = $this$refreshUI_u24lambda_u241 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) $this$refreshUI_u24lambda_u241 : null;
                    if (marginLayoutParams != null) {
                        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding16 = this.mViewBinding;
                        if (biliAppDialogDigitalCollectionRoomBinding16 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                            biliAppDialogDigitalCollectionRoomBinding16 = null;
                        }
                        marginLayoutParams.setMargins(0, (int) DpUtils.dp2px(biliAppDialogDigitalCollectionRoomBinding16.getRoot().getContext(), 78.0f), 0, 0);
                    }
                    recyclerView.setLayoutParams($this$refreshUI_u24lambda_u241);
                }
                CollectionAllHeaderView collectionAllHeaderView = this.mHeadView;
                if (collectionAllHeaderView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeadView");
                    collectionAllHeaderView = null;
                }
                BiliCollectionData biliCollectionData10 = this.mAllData;
                if (biliCollectionData10 != null && (userInfo = biliCollectionData10.getUserInfo()) != null && (avatar = userInfo.getAvatar()) != null) {
                    str3 = avatar;
                }
                BiliCollectionData biliCollectionData11 = this.mAllData;
                collectionAllHeaderView.updateUI(str3, (biliCollectionData11 == null || (all2 = biliCollectionData11.getAll()) == null) ? 0 : all2.getTotal());
                BiliCollectionData biliCollectionData12 = this.mAllData;
                List<SpaceBannerItem> result4 = (biliCollectionData12 == null || (all = biliCollectionData12.getAll()) == null) ? null : all.getResult();
                ArrayList<SpaceBannerItem> arrayList = result4 instanceof ArrayList ? (ArrayList) result4 : null;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                this.mAllListData = arrayList;
                getMAllAdapter().updateData(this.mAllListData);
                String ids = CollectionsKt.joinToString$default(this.mAllListData, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        CharSequence refreshUI$lambda$2;
                        refreshUI$lambda$2 = CollectionRoomFragment.refreshUI$lambda$2((SpaceBannerItem) obj);
                        return refreshUI$lambda$2;
                    }
                }, 30, (Object) null);
                CollectionReporterHelper.INSTANCE.reportCollectionAllShow(ids, isMe());
                CollectionAllAdapter mAllAdapter = getMAllAdapter();
                BiliCollectionData biliCollectionData13 = this.mAllData;
                if (biliCollectionData13 != null && (globalInfo = biliCollectionData13.getGlobalInfo()) != null) {
                    str2 = globalInfo.getCollectionCompletedUrl();
                }
                mAllAdapter.setMCollectedImageUrl(str2);
                getMAllAdapter().notifyItemRangeChanged(0, this.mAllListData.size());
                return;
            }
            BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding17 = this.mViewBinding;
            if (biliAppDialogDigitalCollectionRoomBinding17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                biliAppDialogDigitalCollectionRoomBinding17 = null;
            }
            biliAppDialogDigitalCollectionRoomBinding17.collectionTopContainer.setVisibility(8);
            BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding18 = this.mViewBinding;
            if (biliAppDialogDigitalCollectionRoomBinding18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                biliAppDialogDigitalCollectionRoomBinding18 = null;
            }
            biliAppDialogDigitalCollectionRoomBinding18.collectionAllRecycleview.setVisibility(8);
            BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding19 = this.mViewBinding;
            if (biliAppDialogDigitalCollectionRoomBinding19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                biliAppDialogDigitalCollectionRoomBinding19 = null;
            }
            biliAppDialogDigitalCollectionRoomBinding19.collectionEmptyContainer.setVisibility(0);
            BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding20 = this.mViewBinding;
            if (biliAppDialogDigitalCollectionRoomBinding20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                biliAppDialogDigitalCollectionRoomBinding20 = null;
            }
            biliAppDialogDigitalCollectionRoomBinding20.collectionEmptyText.setText(R.string.homepage_global_string_400);
            BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding21 = this.mViewBinding;
            if (biliAppDialogDigitalCollectionRoomBinding21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                biliAppDialogDigitalCollectionRoomBinding21 = null;
            }
            biliAppDialogDigitalCollectionRoomBinding21.collectionGoStore.setVisibility(0);
            BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding22 = this.mViewBinding;
            if (biliAppDialogDigitalCollectionRoomBinding22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            } else {
                biliAppDialogDigitalCollectionRoomBinding2 = biliAppDialogDigitalCollectionRoomBinding22;
            }
            biliAppDialogDigitalCollectionRoomBinding2.collectionGoStore.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CollectionRoomFragment.refreshUI$lambda$3(CollectionRoomFragment.this, view);
                }
            });
            return;
        }
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding23 = this.mViewBinding;
        if (biliAppDialogDigitalCollectionRoomBinding23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            biliAppDialogDigitalCollectionRoomBinding23 = null;
        }
        biliAppDialogDigitalCollectionRoomBinding23.collectionTopContainer.setVisibility(8);
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding24 = this.mViewBinding;
        if (biliAppDialogDigitalCollectionRoomBinding24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            biliAppDialogDigitalCollectionRoomBinding24 = null;
        }
        biliAppDialogDigitalCollectionRoomBinding24.collectionAllRecycleview.setVisibility(8);
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding25 = this.mViewBinding;
        if (biliAppDialogDigitalCollectionRoomBinding25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            biliAppDialogDigitalCollectionRoomBinding25 = null;
        }
        biliAppDialogDigitalCollectionRoomBinding25.collectionEmptyContainer.setVisibility(0);
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding26 = this.mViewBinding;
        if (biliAppDialogDigitalCollectionRoomBinding26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            biliAppDialogDigitalCollectionRoomBinding26 = null;
        }
        AppCompatTextView appCompatTextView2 = biliAppDialogDigitalCollectionRoomBinding26.collectionEmptyText;
        if (isMe()) {
            Context context = getContext();
            str = context != null ? context.getString(R.string.homepage_global_string_400) : null;
        } else {
            str = "TA隐藏了收藏馆～";
        }
        appCompatTextView2.setText(str);
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding27 = this.mViewBinding;
        if (biliAppDialogDigitalCollectionRoomBinding27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            biliAppDialogDigitalCollectionRoomBinding27 = null;
        }
        biliAppDialogDigitalCollectionRoomBinding27.collectionGoStore.setVisibility(isMe() ? 0 : 8);
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding28 = this.mViewBinding;
        if (biliAppDialogDigitalCollectionRoomBinding28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
        } else {
            biliAppDialogDigitalCollectionRoomBinding3 = biliAppDialogDigitalCollectionRoomBinding28;
        }
        biliAppDialogDigitalCollectionRoomBinding3.collectionGoStore.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionRoomFragment.refreshUI$lambda$4(CollectionRoomFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshUI$lambda$0(CollectionRoomFragment this$0, View it) {
        BiliCollectionGlobalInfoData globalInfo;
        BiliCollectionGlobalInfoSideBarData sidebarInfo;
        String it2;
        BiliCollectionData biliCollectionData = this$0.mAllData;
        if (biliCollectionData != null && (globalInfo = biliCollectionData.getGlobalInfo()) != null && (sidebarInfo = globalInfo.getSidebarInfo()) != null && (it2 = sidebarInfo.getTopSettingJumpUrl()) != null) {
            SpaceNftUtils.INSTANCE.routeWithMap(it2, MapsKt.mapOf(TuplesKt.to("page_from", TopCollectionSettingJumpUrlPageFrom.EMPTY_STATE_SETTING_BUTTON.getReportValue())), this$0.getActivity());
            CollectionReporterHelper.INSTANCE.reportCollectionTopClick(null, null, null, "2");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence refreshUI$lambda$2(SpaceBannerItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getItemId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshUI$lambda$3(CollectionRoomFragment this$0, View it) {
        BiliCollectionGlobalInfoData globalInfo;
        BiliCollectionGlobalInfoSideBarData sidebarInfo;
        String it2;
        BiliCollectionData biliCollectionData = this$0.mAllData;
        if (biliCollectionData != null && (globalInfo = biliCollectionData.getGlobalInfo()) != null && (sidebarInfo = globalInfo.getSidebarInfo()) != null && (it2 = sidebarInfo.getGarbMallJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_btn");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.getActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshUI$lambda$4(CollectionRoomFragment this$0, View it) {
        BiliCollectionGlobalInfoData globalInfo;
        BiliCollectionGlobalInfoSideBarData sidebarInfo;
        String it2;
        BiliCollectionData biliCollectionData = this$0.mAllData;
        if (biliCollectionData != null && (globalInfo = biliCollectionData.getGlobalInfo()) != null && (sidebarInfo = globalInfo.getSidebarInfo()) != null && (it2 = sidebarInfo.getGarbMallJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_btn");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.getActivity());
        }
    }

    private final void initViews() {
        CollectionSideManager collectionSideManager = this.mSideManager;
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding = null;
        if (collectionSideManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSideManager");
            collectionSideManager = null;
        }
        collectionSideManager.initView();
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding2 = this.mViewBinding;
        if (biliAppDialogDigitalCollectionRoomBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
        } else {
            biliAppDialogDigitalCollectionRoomBinding = biliAppDialogDigitalCollectionRoomBinding2;
        }
        final BiliAppDialogDigitalCollectionRoomBinding it = biliAppDialogDigitalCollectionRoomBinding;
        it.collectionTitle.setText(isMe() ? getString(R.string.homepage_global_string_432) : "TA的收藏馆");
        it.collectionUamAnim.setLoop((int) FlowControlConfig.RETRY_MAX_TIMES);
        FrontRecycleView mFrontRecycleView = getMFrontRecycleView();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        mFrontRecycleView.init(it, (Context) requireActivity, Boolean.valueOf(isMe()), this, DigitalFromType.SEE, 0, true, this.mScrollListener);
        BackendRecycleView mBackendRecycleView = getMBackendRecycleView();
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
        mBackendRecycleView.init(it, (Context) requireActivity2, DigitalFromType.SEE, 0, true);
        it.collectionTitleContainer.getBackground().mutate().setAlpha(0);
        it.collectionNestScroollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda7
            public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                CollectionRoomFragment.initViews$lambda$0$0(BiliAppDialogDigitalCollectionRoomBinding.this, this, nestedScrollView, i, i2, i3, i4);
            }
        });
        it.collectionBack.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionRoomFragment.initViews$lambda$0$1(CollectionRoomFragment.this, view);
            }
        });
        observerRefreshStateChange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0$0(BiliAppDialogDigitalCollectionRoomBinding $it, CollectionRoomFragment this$0, NestedScrollView v, int i, int scrollY, int i2, int i3) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (scrollY < $it.collectionTitleContainer.getHeight()) {
            $it.collectionTitleContainer.getBackground().mutate().setAlpha((192 / $it.collectionTitleContainer.getHeight()) * scrollY);
        } else {
            $it.collectionTitleContainer.getBackground().mutate().setAlpha(192);
        }
        if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight() && !this$0.mAllListData.isEmpty()) {
            this$0.loadNext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0$1(CollectionRoomFragment this$0, View it) {
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* compiled from: CollectionRoomFragment.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/garb/CollectionRoomFragment$CollectionDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "", "horizontalPadding", "verticalPadding", "<init>", "(III)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", AuthResultCbHelper.ARGS_STATE, "Landroidx/recyclerview/widget/RecyclerView$State;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class CollectionDecoration extends RecyclerView.ItemDecoration {
        public static final int $stable = 8;
        private final int horizontalPadding;
        private final int spanCount;
        private final int verticalPadding;

        public CollectionDecoration(int spanCount, int horizontalPadding, int verticalPadding) {
            this.spanCount = spanCount;
            this.horizontalPadding = horizontalPadding;
            this.verticalPadding = verticalPadding;
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
            if (view.getId() == tv.danmaku.bili.R.id.collection_all_card_container) {
                int position = parent.getChildAdapterPosition(view);
                int column = position % this.spanCount;
                switch (column) {
                    case 0:
                        outRect.left = this.horizontalPadding;
                        outRect.right = this.horizontalPadding * 2;
                        break;
                    case 1:
                        outRect.left = this.horizontalPadding * 2;
                        outRect.right = this.horizontalPadding;
                        break;
                    default:
                        outRect.left = this.horizontalPadding;
                        outRect.right = this.horizontalPadding;
                        break;
                }
                outRect.bottom = this.verticalPadding * 2;
            }
        }
    }

    static /* synthetic */ void renderTopBannerUI$default(CollectionRoomFragment collectionRoomFragment, List list, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        collectionRoomFragment.renderTopBannerUI(list, i, str);
    }

    private final void renderTopBannerUI(List<SpaceBannerItem> list, int jumpToIndex, String collectedFlagUrl) {
        SpaceBannerItemExtra extra;
        if (list == null) {
            return;
        }
        SpaceBannerItem selected = list.get(jumpToIndex);
        List<SpaceBannerItem> $this$filter$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            SpaceBannerItemContent item = ((SpaceBannerItem) element$iv$iv).getItem();
            boolean z = false;
            if (item != null && (extra = item.getExtra()) != null && extra.getShowInCollection()) {
                z = true;
            }
            if (z) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List it = (List) destination$iv$iv;
        int jump = 0;
        List $this$forEachIndexed$iv = it;
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SpaceBannerItem spaceBannerItem = (SpaceBannerItem) item$iv;
            if (Intrinsics.areEqual(spaceBannerItem, selected)) {
                jump = index;
            }
            index = index$iv;
        }
        if (!it.isEmpty() && jump < it.size()) {
            getMBackendRecycleView().disableTouchEvent();
            renderRecycleView(it, jump, collectedFlagUrl);
        }
    }

    static /* synthetic */ void renderRecycleView$default(CollectionRoomFragment collectionRoomFragment, List list, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        collectionRoomFragment.renderRecycleView(list, i, str);
    }

    private final void renderRecycleView(List<SpaceBannerItem> list, int jumpToIndex, String collectedFlagUrl) {
        int seekPos;
        getMFrontRecycleView().updateCardData(list, jumpToIndex, collectedFlagUrl);
        getMFrontRecycleView().show();
        int totalSize = list.size();
        List reverseList = CollectionsKt.asReversed(list);
        List result = new ArrayList();
        switch (totalSize) {
            case 1:
            case 2:
                result.addAll(list);
                seekPos = 0;
                break;
            default:
                result.addAll(reverseList);
                result.add(new SpaceBannerItem(CollectionBizType.EMPTY, 0L, (String) null, (SpaceBannerItemContent) null, (SpaceBannerTitle) null, (SpaceBannerExtra) null, (String) null, (SpaceBannerDigitalExtra) null, (Integer) null, (int) BR.roleName, (DefaultConstructorMarker) null));
                result.add(new SpaceBannerItem(CollectionBizType.EMPTY, 0L, (String) null, (SpaceBannerItemContent) null, (SpaceBannerTitle) null, (SpaceBannerExtra) null, (String) null, (SpaceBannerDigitalExtra) null, (Integer) null, (int) BR.roleName, (DefaultConstructorMarker) null));
                result.addAll(reverseList);
                seekPos = (totalSize + 2) - jumpToIndex;
                break;
        }
        if (totalSize > 2) {
            BackendRecycleView mBackendRecycleView = getMBackendRecycleView();
            int size = list.size();
            List mutableList = CollectionsKt.toMutableList(result);
            Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type java.util.ArrayList<com.bili.digital.common.data.SpaceBannerItem>");
            mBackendRecycleView.updateCardData(size, (ArrayList) mutableList, seekPos, collectedFlagUrl);
            getMBackendRecycleView().show();
            return;
        }
        getMBackendRecycleView().hide();
    }

    public void onDestroyView() {
        super.onDestroyView();
        getMFrontRecycleView().onDestroyView();
    }

    public void onResume() {
        FragmentActivity activity;
        super.onResume();
        CollectionBackgroundManager mBackgroundManager = getMBackgroundManager();
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding = this.mViewBinding;
        if (biliAppDialogDigitalCollectionRoomBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            biliAppDialogDigitalCollectionRoomBinding = null;
        }
        UAMView uAMView = biliAppDialogDigitalCollectionRoomBinding.collectionUamAnim;
        Intrinsics.checkNotNullExpressionValue(uAMView, "collectionUamAnim");
        mBackgroundManager.onResume(uAMView);
        if (this.isInited) {
            if (BiliAccounts.get(BiliContext.application()).isLogin() || (activity = getActivity()) == null) {
                return;
            }
            activity.finish();
            return;
        }
        this.isInited = true;
    }

    public void onPause() {
        super.onPause();
        CollectionBackgroundManager mBackgroundManager = getMBackgroundManager();
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding = this.mViewBinding;
        if (biliAppDialogDigitalCollectionRoomBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            biliAppDialogDigitalCollectionRoomBinding = null;
        }
        UAMView uAMView = biliAppDialogDigitalCollectionRoomBinding.collectionUamAnim;
        Intrinsics.checkNotNullExpressionValue(uAMView, "collectionUamAnim");
        mBackgroundManager.onPause(uAMView);
    }

    public void onDestroy() {
        super.onDestroy();
        CollectionBackgroundManager mBackgroundManager = getMBackgroundManager();
        BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding = this.mViewBinding;
        if (biliAppDialogDigitalCollectionRoomBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            biliAppDialogDigitalCollectionRoomBinding = null;
        }
        UAMView uAMView = biliAppDialogDigitalCollectionRoomBinding.collectionUamAnim;
        Intrinsics.checkNotNullExpressionValue(uAMView, "collectionUamAnim");
        mBackgroundManager.onDestroy(uAMView);
        FrontViewHolder.Companion.setGlobalMute(null);
    }

    public String getPvEventId() {
        return CollectionReporterHelper.COLLECTION_ROOM_PV;
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [tv.danmaku.bili.ui.garb.CollectionRoomFragment$getPvExtra$lambda$0$$inlined$parseJson$1] */
    public Bundle getPvExtra() {
        String $this$parseJson$iv;
        SpaceBannerTop top;
        Bundle $this$getPvExtra_u24lambda_u240 = new Bundle();
        boolean isRemoteBannersEmpty = true;
        boolean isInitBannersEmpty = !this.initBanners.isEmpty();
        BiliCollectionData biliCollectionData = this.mAllData;
        List result = (biliCollectionData == null || (top = biliCollectionData.getTop()) == null) ? null : top.getResult();
        if (result != null && !result.isEmpty()) {
            isRemoteBannersEmpty = false;
        }
        String state = (isInitBannersEmpty && isRemoteBannersEmpty) ? "1" : "2";
        Bundle arguments = getArguments();
        if (arguments != null && ($this$parseJson$iv = arguments.getString("trackParams")) != null) {
            Type type = new TypeToken<Map<String, ? extends String>>() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$getPvExtra$lambda$0$$inlined$parseJson$1
            }.getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            Map $this$forEach$iv = (Map) JsonUtilKt.parseJson($this$parseJson$iv, type);
            if ($this$forEach$iv != null) {
                for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                    $this$getPvExtra_u24lambda_u240.putString((String) element$iv.getKey(), (String) element$iv.getValue());
                }
            }
        }
        $this$getPvExtra_u24lambda_u240.putString(AuthResultCbHelper.ARGS_STATE, state);
        $this$getPvExtra_u24lambda_u240.putString("hidden", this.collectionPublic ? "0" : "1");
        return $this$getPvExtra_u24lambda_u240;
    }
}