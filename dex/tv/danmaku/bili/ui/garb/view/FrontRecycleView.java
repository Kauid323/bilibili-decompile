package tv.danmaku.bili.ui.garb.view;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bili.digital.common.data.SpaceBannerExtra;
import com.bili.digital.common.data.SpaceBannerItem;
import com.bili.digital.common.data.SpaceBannerItemAnimation;
import com.bili.digital.common.data.SpaceBannerItemContent;
import com.bili.digital.common.data.SpaceBannerItemForUI;
import com.bili.digital.common.player.AutoPlayScrollListener;
import com.bili.digital.common.player.CardAutoPlayManager;
import com.bili.digital.common.player.VideoParams;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.lib.image2.view.BiliImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.databinding.BiliAppDialogDigitalCollectionRoomBinding;
import tv.danmaku.bili.databinding.BiliAppViewHolderCollectionFrontBinding;
import tv.danmaku.bili.ui.garb.adapter.FrontAdapter;
import tv.danmaku.bili.ui.garb.api.CollectionReporterHelper;
import tv.danmaku.bili.ui.garb.digital.CollectionCardDetailCallback;
import tv.danmaku.bili.ui.garb.digital.base.view.DigitalFromType;
import tv.danmaku.bili.ui.garb.holder.FrontViewHolder;
import tv.danmaku.bili.ui.garb.manager.FrontLinearLayoutManager;
import tv.danmaku.bili.ui.garb.protocol.CardScrollListaner;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: FrontRecycleView.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 O2\u00020\u0001:\u0001OB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020+J\u0006\u0010-\u001a\u00020+J\b\u0010.\u001a\u00020\u000eH\u0002J:\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020 2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u000e\u00105\u001a\n\u0012\u0004\u0012\u000207\u0018\u0001062\b\b\u0002\u00108\u001a\u00020\u0005H\u0002J\u0018\u00109\u001a\u00020+2\u0006\u00100\u001a\u00020 2\u0006\u00101\u001a\u000202H\u0002JS\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u000b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D¢\u0006\u0002\u0010EJ\u0010\u0010G\u001a\u00020+2\u0006\u0010H\u001a\u00020\u000bH\u0002J*\u0010I\u001a\u00020+2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020K062\b\b\u0002\u0010L\u001a\u00020 2\n\b\u0002\u0010M\u001a\u0004\u0018\u000107J\u0006\u0010N\u001a\u00020+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Ltv/danmaku/bili/ui/garb/view/FrontRecycleView;", "", "videoParams", "Lcom/bili/digital/common/player/VideoParams;", "isHalfScreen", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "<init>", "(Lcom/bili/digital/common/player/VideoParams;ZLandroidx/lifecycle/Lifecycle;)V", "mContext", "Landroid/content/Context;", "mIsHalfScreen", "mAdapter", "Ltv/danmaku/bili/ui/garb/adapter/FrontAdapter;", "mInnerRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "mCallback", "Ltv/danmaku/bili/ui/garb/digital/CollectionCardDetailCallback;", "getMCallback", "()Ltv/danmaku/bili/ui/garb/digital/CollectionCardDetailCallback;", "setMCallback", "(Ltv/danmaku/bili/ui/garb/digital/CollectionCardDetailCallback;)V", "mBaseLineX", "", "mCardType", "Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;", "getMCardType", "()Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;", "setMCardType", "(Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;)V", "mActivityId", "", "getMActivityId", "()I", "setMActivityId", "(I)V", "mCurrentPosition", "isMe", "Ljava/lang/Boolean;", "cardAutoPlayManager", "Lcom/bili/digital/common/player/CardAutoPlayManager;", "hide", "", ReportEvent.EVENT_TYPE_SHOW, "onDestroyView", "getAdapter", "playVideo", "index", "card", "Lcom/bili/digital/common/data/SpaceBannerItemForUI;", "cardId", "", "videoList", "", "", "isMute", "showMusicAnimation", "mListener", "Lcom/bili/digital/common/player/AutoPlayScrollListener;", "init", "binding", "Ltv/danmaku/bili/databinding/BiliAppDialogDigitalCollectionRoomBinding;", "ctx", "cb", "cardType", "activityId", "listener", "Ltv/danmaku/bili/ui/garb/protocol/CardScrollListaner;", "(Ltv/danmaku/bili/databinding/BiliAppDialogDigitalCollectionRoomBinding;Landroid/content/Context;Ljava/lang/Boolean;Ltv/danmaku/bili/ui/garb/digital/CollectionCardDetailCallback;Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;IZLtv/danmaku/bili/ui/garb/protocol/CardScrollListaner;)V", "isInitDecoration", "addItemDecoration", "context", "updateCardData", "cardTypeList", "Lcom/bili/digital/common/data/SpaceBannerItem;", "jumpToIndex", "collectedFlagUrl", "clearData", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FrontRecycleView {
    public static final float MAX_ALPHA_SCALE = 1.0f;
    public static final float MAX_SCALE = 1.0f;
    public static final float MIN_ALPHA_SCALE = 0.7f;
    public static final float MIN_SCALE = 0.8333333f;
    public static final float NFT_CARD_CONTAINER_HEIGHT = 472.0f;
    public static final float NFT_CARD_CONTAINER_WIDTH = 216.0f;
    public static final float NFT_CARD_HEIGHT = 472.0f;
    public static final float NFT_CARD_WIDTH = 270.0f;
    public static final float SCROLL_CENTER_RATIO = 0.99f;
    public static final String TAG = "NftCardRecyclerView";
    private CardAutoPlayManager cardAutoPlayManager;
    private final boolean isHalfScreen;
    private boolean isInitDecoration;
    private Boolean isMe;
    private final Lifecycle lifecycle;
    private int mActivityId;
    private FrontAdapter mAdapter;
    private float mBaseLineX;
    public CollectionCardDetailCallback mCallback;
    private DigitalFromType mCardType;
    private Context mContext;
    private int mCurrentPosition;
    private RecyclerView mInnerRecycleView;
    private boolean mIsHalfScreen;
    private final AutoPlayScrollListener mListener;
    private final VideoParams videoParams;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public FrontRecycleView(VideoParams videoParams, boolean isHalfScreen, Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(videoParams, "videoParams");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        this.videoParams = videoParams;
        this.isHalfScreen = isHalfScreen;
        this.lifecycle = lifecycle;
        this.mCardType = DigitalFromType.SEE;
        this.mListener = new FrontRecycleView$mListener$1(this);
    }

    /* compiled from: FrontRecycleView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/garb/view/FrontRecycleView$Companion;", "", "<init>", "()V", "TAG", "", "SCROLL_CENTER_RATIO", "", "MAX_SCALE", "MIN_SCALE", "MAX_ALPHA_SCALE", "MIN_ALPHA_SCALE", "NFT_CARD_WIDTH", "NFT_CARD_HEIGHT", "NFT_CARD_CONTAINER_WIDTH", "NFT_CARD_CONTAINER_HEIGHT", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final CollectionCardDetailCallback getMCallback() {
        CollectionCardDetailCallback collectionCardDetailCallback = this.mCallback;
        if (collectionCardDetailCallback != null) {
            return collectionCardDetailCallback;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mCallback");
        return null;
    }

    public final void setMCallback(CollectionCardDetailCallback collectionCardDetailCallback) {
        Intrinsics.checkNotNullParameter(collectionCardDetailCallback, "<set-?>");
        this.mCallback = collectionCardDetailCallback;
    }

    public final DigitalFromType getMCardType() {
        return this.mCardType;
    }

    public final void setMCardType(DigitalFromType digitalFromType) {
        Intrinsics.checkNotNullParameter(digitalFromType, "<set-?>");
        this.mCardType = digitalFromType;
    }

    public final int getMActivityId() {
        return this.mActivityId;
    }

    public final void setMActivityId(int i) {
        this.mActivityId = i;
    }

    public final void hide() {
        RecyclerView recyclerView = this.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
    }

    public final void show() {
        RecyclerView recyclerView = this.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        recyclerView.setVisibility(0);
    }

    public final void onDestroyView() {
        CardAutoPlayManager cardAutoPlayManager = this.cardAutoPlayManager;
        if (cardAutoPlayManager != null) {
            cardAutoPlayManager.onDestroy();
        }
    }

    private final FrontAdapter getAdapter() {
        return new FrontAdapter(this.mContext, this.videoParams, this.isMe, this.lifecycle, new Function1() { // from class: tv.danmaku.bili.ui.garb.view.FrontRecycleView$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit adapter$lambda$0;
                adapter$lambda$0 = FrontRecycleView.getAdapter$lambda$0(FrontRecycleView.this, ((Integer) obj).intValue());
                return adapter$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getAdapter$lambda$0(FrontRecycleView this$0, int index) {
        CardAutoPlayManager cardAutoPlayManager = this$0.cardAutoPlayManager;
        if (cardAutoPlayManager != null) {
            cardAutoPlayManager.scrollToNextImmediately();
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ void playVideo$default(FrontRecycleView frontRecycleView, int i, SpaceBannerItemForUI spaceBannerItemForUI, long j, List list, boolean z, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            z = false;
        }
        frontRecycleView.playVideo(i, spaceBannerItemForUI, j, list, z);
    }

    private final void playVideo(final int index, final SpaceBannerItemForUI card, final long cardId, final List<String> list, final boolean isMute) {
        RecyclerView recyclerView = this.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        recyclerView.post(new Runnable() { // from class: tv.danmaku.bili.ui.garb.view.FrontRecycleView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FrontRecycleView.playVideo$lambda$0(FrontRecycleView.this, index, card, cardId, list, isMute);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playVideo$lambda$0(FrontRecycleView this$0, int $index, SpaceBannerItemForUI $card, long $cardId, List $videoList, boolean $isMute) {
        RecyclerView recyclerView = this$0.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition($index);
        FrontViewHolder frontViewHolder = findViewHolderForAdapterPosition instanceof FrontViewHolder ? (FrontViewHolder) findViewHolderForAdapterPosition : null;
        if (frontViewHolder != null) {
            FrontViewHolder.playVideo$default(frontViewHolder, $card, $cardId, $videoList, $isMute, null, null, 48, null);
        }
    }

    private final void showMusicAnimation(final int index, final SpaceBannerItemForUI card) {
        RecyclerView recyclerView = this.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        recyclerView.post(new Runnable() { // from class: tv.danmaku.bili.ui.garb.view.FrontRecycleView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                FrontRecycleView.showMusicAnimation$lambda$0(FrontRecycleView.this, index, card);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMusicAnimation$lambda$0(FrontRecycleView this$0, int $index, SpaceBannerItemForUI $card) {
        RecyclerView recyclerView = this$0.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition($index);
        FrontViewHolder frontViewHolder = findViewHolderForAdapterPosition instanceof FrontViewHolder ? (FrontViewHolder) findViewHolderForAdapterPosition : null;
        if (frontViewHolder != null) {
            frontViewHolder.showMusicAnimation($card);
        }
    }

    public static /* synthetic */ void init$default(FrontRecycleView frontRecycleView, BiliAppDialogDigitalCollectionRoomBinding biliAppDialogDigitalCollectionRoomBinding, Context context, Boolean bool, CollectionCardDetailCallback collectionCardDetailCallback, DigitalFromType digitalFromType, int i, boolean z, CardScrollListaner cardScrollListaner, int i2, Object obj) {
        Boolean bool2;
        CardScrollListaner cardScrollListaner2;
        if ((i2 & 4) == 0) {
            bool2 = bool;
        } else {
            bool2 = null;
        }
        if ((i2 & BR.cover) == 0) {
            cardScrollListaner2 = cardScrollListaner;
        } else {
            cardScrollListaner2 = null;
        }
        frontRecycleView.init(biliAppDialogDigitalCollectionRoomBinding, context, bool2, collectionCardDetailCallback, digitalFromType, i, z, cardScrollListaner2);
    }

    public final void init(BiliAppDialogDigitalCollectionRoomBinding binding, Context ctx, final Boolean isMe, CollectionCardDetailCallback cb, DigitalFromType cardType, int activityId, boolean isHalfScreen, final CardScrollListaner listener) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(cb, "cb");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        this.mCardType = cardType;
        this.mActivityId = activityId;
        setMCallback(cb);
        this.mContext = ctx;
        this.isMe = isMe;
        this.mIsHalfScreen = isHalfScreen;
        this.mAdapter = getAdapter();
        this.mBaseLineX = (ScreenUtil.getScreenWidth(ctx) - ScreenUtil.dip2px(ctx, 216.0f)) / 2.0f;
        RecyclerView recyclerView = binding.nftCardListFront;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "nftCardListFront");
        this.mInnerRecycleView = recyclerView;
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        RecyclerView recyclerView2 = this.mInnerRecycleView;
        FrontAdapter frontAdapter = null;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView2 = null;
        }
        pagerSnapHelper.attachToRecyclerView(recyclerView2);
        RecyclerView recyclerView3 = this.mInnerRecycleView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView3 = null;
        }
        recyclerView3.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: tv.danmaku.bili.ui.garb.view.FrontRecycleView$init$1
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0056, code lost:
                r7 = r10.this$0.cardAutoPlayManager;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onScrolled(RecyclerView recyclerView4, int dx, int dy) {
                RecyclerView recyclerView5;
                float f;
                CardAutoPlayManager cardAutoPlayManager;
                Intrinsics.checkNotNullParameter(recyclerView4, "recyclerView");
                super.onScrolled(recyclerView4, dx, dy);
                int childCount = recyclerView4.getChildCount();
                if (childCount <= 1) {
                    return;
                }
                for (int i = 0; i < childCount; i++) {
                    View child = recyclerView4.getChildAt(i);
                    if (child != null) {
                        recyclerView4.getChildAdapterPosition(child);
                        int left = child.getLeft();
                        child.getTop();
                        f = FrontRecycleView.this.mBaseLineX;
                        float bl = RangesKt.coerceAtMost(Math.abs(((left - f) * 1.0f) / child.getWidth()), 1.0f);
                        float scale = 1.0f - (0.16666669f * bl);
                        child.setScaleY(scale);
                        child.setScaleX(scale);
                        child.setAlpha(1.0f - (0.3f * bl));
                        if (dx > 0 && cardAutoPlayManager != null) {
                            cardAutoPlayManager.setFlinger(false);
                        }
                    }
                }
                recyclerView5 = FrontRecycleView.this.mInnerRecycleView;
                if (recyclerView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
                    recyclerView5 = null;
                }
                int offset = recyclerView5.computeHorizontalScrollOffset();
                CardScrollListaner cardScrollListaner = listener;
                if (cardScrollListaner != null) {
                    cardScrollListaner.onScrolled(dx, dy, offset);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:67:0x012d  */
            /* JADX WARN: Removed duplicated region for block: B:82:0x016e A[SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onScrollStateChanged(RecyclerView recyclerView4, int newState) {
                boolean z;
                FrontAdapter frontAdapter2;
                FrontViewHolder it;
                FrontAdapter frontAdapter3;
                FrontAdapter frontAdapter4;
                CardAutoPlayManager cardAutoPlayManager;
                CardAutoPlayManager cardAutoPlayManager2;
                CardAutoPlayManager cardAutoPlayManager3;
                CardAutoPlayManager cardAutoPlayManager4;
                CardAutoPlayManager cardAutoPlayManager5;
                SpaceBannerExtra extra;
                FrontAdapter frontAdapter5;
                Intrinsics.checkNotNullParameter(recyclerView4, "recyclerView");
                super.onScrollStateChanged(recyclerView4, newState);
                int childCount = recyclerView4.getChildCount();
                if (childCount <= 1) {
                    return;
                }
                switch (newState) {
                    case 0:
                        for (int i = 0; i < childCount; i++) {
                            View child = recyclerView4.getChildAt(i);
                            if (child != null) {
                                boolean z2 = false;
                                if (child.getScaleY() >= 0.99f) {
                                    int index = recyclerView4.getChildAdapterPosition(child);
                                    if (index >= 0) {
                                        frontAdapter5 = FrontRecycleView.this.mAdapter;
                                        if (frontAdapter5 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                                            frontAdapter5 = null;
                                        }
                                        if (index < frontAdapter5.getCards().size()) {
                                            z2 = true;
                                        }
                                    }
                                    if (z2) {
                                        frontAdapter4 = FrontRecycleView.this.mAdapter;
                                        if (frontAdapter4 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                                            frontAdapter4 = null;
                                        }
                                        SpaceBannerItemForUI cardInfo = frontAdapter4.getCards().get(index);
                                        FrontRecycleView.this.mCurrentPosition = index;
                                        CardScrollListaner cardScrollListaner = listener;
                                        if (cardScrollListaner != null) {
                                            cardScrollListaner.onScrollStateChanged(index);
                                        }
                                        cardAutoPlayManager = FrontRecycleView.this.cardAutoPlayManager;
                                        if (cardAutoPlayManager != null) {
                                            cardAutoPlayManager.reSetPosition(index);
                                        }
                                        cardAutoPlayManager2 = FrontRecycleView.this.cardAutoPlayManager;
                                        if (cardAutoPlayManager2 != null) {
                                            cardAutoPlayManager2.setMFirstDelay(RangesKt.coerceAtLeast(cardInfo.getBanner().getExtra() != null ? extra.getDuration() : 1500L, 1500L));
                                        }
                                        cardAutoPlayManager3 = FrontRecycleView.this.cardAutoPlayManager;
                                        if (cardAutoPlayManager3 != null) {
                                            cardAutoPlayManager5 = FrontRecycleView.this.cardAutoPlayManager;
                                            cardAutoPlayManager3.setMInterval(cardAutoPlayManager5 != null ? cardAutoPlayManager5.getMFirstDelay() : 1500L);
                                        }
                                        cardAutoPlayManager4 = FrontRecycleView.this.cardAutoPlayManager;
                                        if (cardAutoPlayManager4 != null) {
                                            cardAutoPlayManager4.setFlinger(true);
                                        }
                                        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView4.findViewHolderForAdapterPosition(index);
                                        it = findViewHolderForAdapterPosition instanceof FrontViewHolder ? (FrontViewHolder) findViewHolderForAdapterPosition : null;
                                        if (it != null) {
                                            FrontViewHolder it2 = it;
                                            it2.onViewAttachedToWindow();
                                            it2.getBinding().nftCardMask.setVisibility(8);
                                        }
                                        if (!cardInfo.isExposeReported()) {
                                            cardInfo.setExposeReported(true);
                                            CollectionReporterHelper.INSTANCE.reportCollectionTopShow(cardInfo.getBanner().getItemId(), isMe, String.valueOf(index + 1), "1");
                                        }
                                    }
                                } else {
                                    int index2 = recyclerView4.getChildAdapterPosition(child);
                                    if (index2 >= 0) {
                                        frontAdapter3 = FrontRecycleView.this.mAdapter;
                                        if (frontAdapter3 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                                            frontAdapter3 = null;
                                        }
                                        if (index2 < frontAdapter3.getCards().size()) {
                                            z = true;
                                            if (z) {
                                                frontAdapter2 = FrontRecycleView.this.mAdapter;
                                                if (frontAdapter2 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                                                    frontAdapter2 = null;
                                                }
                                                SpaceBannerItemForUI cardInfo2 = frontAdapter2.getCards().get(index2);
                                                RecyclerView.ViewHolder findViewHolderForAdapterPosition2 = recyclerView4.findViewHolderForAdapterPosition(index2);
                                                it = findViewHolderForAdapterPosition2 instanceof FrontViewHolder ? (FrontViewHolder) findViewHolderForAdapterPosition2 : null;
                                                if (it != null) {
                                                    it.getUamVideoController().stop(String.valueOf(cardInfo2.getUniqueId()));
                                                    it.onViewDetachedFromWindow();
                                                    it.getBinding().nftCardMask.setVisibility(0);
                                                }
                                            }
                                        }
                                    }
                                    z = false;
                                    if (z) {
                                    }
                                }
                            }
                        }
                        return;
                    case 1:
                        FrontRecycleView.this.getMCallback().onScrollStart();
                        return;
                    default:
                        return;
                }
            }
        });
        RecyclerView.LayoutManager frontLinearLayoutManager = new FrontLinearLayoutManager(ctx, true);
        RecyclerView recyclerView4 = this.mInnerRecycleView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView4 = null;
        }
        recyclerView4.setLayoutManager(frontLinearLayoutManager);
        RecyclerView recyclerView5 = this.mInnerRecycleView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView5 = null;
        }
        FrontAdapter frontAdapter2 = this.mAdapter;
        if (frontAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            frontAdapter = frontAdapter2;
        }
        recyclerView5.setAdapter(frontAdapter);
    }

    private final void addItemDecoration(Context context) {
        if (!this.isInitDecoration) {
            this.isInitDecoration = true;
            RecyclerView recyclerView = this.mInnerRecycleView;
            RecyclerView recyclerView2 = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
                recyclerView = null;
            }
            RecyclerView recyclerView3 = this.mInnerRecycleView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            } else {
                recyclerView2 = recyclerView3;
            }
            recyclerView.addItemDecoration(new FrontItemDecoration(context, recyclerView2.getMeasuredHeight()));
        }
    }

    public static /* synthetic */ void updateCardData$default(FrontRecycleView frontRecycleView, List list, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        frontRecycleView.updateCardData(list, i, str);
    }

    public final void updateCardData(final List<SpaceBannerItem> list, final int jumpToIndex, final String collectedFlagUrl) {
        Intrinsics.checkNotNullParameter(list, "cardTypeList");
        RecyclerView recyclerView = this.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        recyclerView.post(new Runnable() { // from class: tv.danmaku.bili.ui.garb.view.FrontRecycleView$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                FrontRecycleView.updateCardData$lambda$0(FrontRecycleView.this, list, collectedFlagUrl, jumpToIndex);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateCardData$lambda$0(final FrontRecycleView this$0, List $cardTypeList, String $collectedFlagUrl, final int $jumpToIndex) {
        long j;
        FrontAdapter frontAdapter;
        SpaceBannerExtra extra;
        SpaceBannerItemAnimation animation;
        SpaceBannerItemAnimation animation2;
        RecyclerView recyclerView;
        SpaceBannerExtra extra2;
        SpaceBannerItemAnimation animation3;
        SpaceBannerItemAnimation animation4;
        Context it = this$0.mContext;
        if (it != null) {
            this$0.addItemDecoration(it);
            int length = $cardTypeList.size();
            if (length == 0) {
                BLog.d("NftCardRecyclerView", "fck data null");
                return;
            }
            FrontAdapter frontAdapter2 = this$0.mAdapter;
            if (frontAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                frontAdapter2 = null;
            }
            int oldSize = frontAdapter2.getCards().size();
            ArrayList arrayList = new ArrayList();
            List $this$forEachIndexed$iv = $cardTypeList;
            boolean z = false;
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SpaceBannerItem item = (SpaceBannerItem) item$iv;
                Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                boolean z2 = z;
                arrayList.add(new SpaceBannerItemForUI(index + 1, item, index == $jumpToIndex));
                index = index$iv;
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                z = z2;
            }
            FrontAdapter frontAdapter3 = this$0.mAdapter;
            if (frontAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                frontAdapter3 = null;
            }
            RecyclerView recyclerView2 = this$0.mInnerRecycleView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
                recyclerView2 = null;
            }
            int measuredWidth = recyclerView2.getMeasuredWidth();
            RecyclerView recyclerView3 = this$0.mInnerRecycleView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
                recyclerView3 = null;
            }
            frontAdapter3.updateContainerSize(measuredWidth, recyclerView3.getMeasuredHeight());
            FrontAdapter frontAdapter4 = this$0.mAdapter;
            if (frontAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                frontAdapter4 = null;
            }
            frontAdapter4.setMCollectedImageUrl($collectedFlagUrl);
            FrontAdapter frontAdapter5 = this$0.mAdapter;
            if (frontAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                frontAdapter5 = null;
            }
            frontAdapter5.getCards().clear();
            FrontAdapter frontAdapter6 = this$0.mAdapter;
            if (frontAdapter6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                frontAdapter6 = null;
            }
            frontAdapter6.notifyItemRangeRemoved(0, oldSize);
            FrontAdapter frontAdapter7 = this$0.mAdapter;
            if (frontAdapter7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                frontAdapter7 = null;
            }
            frontAdapter7.getCards().addAll(arrayList);
            FrontAdapter frontAdapter8 = this$0.mAdapter;
            if (frontAdapter8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                frontAdapter8 = null;
            }
            frontAdapter8.notifyItemRangeInserted(oldSize, oldSize + length);
            if ($jumpToIndex > 0) {
                FrontAdapter frontAdapter9 = this$0.mAdapter;
                if (frontAdapter9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    frontAdapter9 = null;
                }
                if ($jumpToIndex < frontAdapter9.getCards().size()) {
                    FrontAdapter frontAdapter10 = this$0.mAdapter;
                    if (frontAdapter10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                        frontAdapter10 = null;
                    }
                    SpaceBannerItemForUI jumpCardInfo = frontAdapter10.getCards().get($jumpToIndex);
                    RecyclerView recyclerView4 = this$0.mInnerRecycleView;
                    if (recyclerView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
                        recyclerView4 = null;
                    }
                    recyclerView4.scrollToPosition($jumpToIndex);
                    this$0.getMCallback().showCardInfo(jumpCardInfo.getBanner());
                    long uniqueId = jumpCardInfo.getUniqueId();
                    SpaceBannerItemContent item2 = jumpCardInfo.getBanner().getItem();
                    List<String> animationVideoUrls = (item2 == null || (animation4 = item2.getAnimation()) == null) ? null : animation4.getAnimationVideoUrls();
                    SpaceBannerItemContent item3 = jumpCardInfo.getBanner().getItem();
                    this$0.playVideo($jumpToIndex, jumpCardInfo, uniqueId, animationVideoUrls, (item3 == null || (animation3 = item3.getAnimation()) == null || !animation3.isSilence()) ? false : true);
                    this$0.showMusicAnimation($jumpToIndex, jumpCardInfo);
                    RecyclerView recyclerView5 = this$0.mInnerRecycleView;
                    if (recyclerView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
                        recyclerView = null;
                    } else {
                        recyclerView = recyclerView5;
                    }
                    recyclerView.post(new Runnable() { // from class: tv.danmaku.bili.ui.garb.view.FrontRecycleView$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            FrontRecycleView.updateCardData$lambda$0$0$1(FrontRecycleView.this, $jumpToIndex);
                        }
                    });
                    this$0.cardAutoPlayManager = new CardAutoPlayManager($jumpToIndex, $cardTypeList.size(), this$0.mListener);
                    CardAutoPlayManager cardAutoPlayManager = this$0.cardAutoPlayManager;
                    if (cardAutoPlayManager != null) {
                        cardAutoPlayManager.setMFirstDelay(RangesKt.coerceAtLeast(jumpCardInfo.getBanner().getExtra() != null ? extra2.getDuration() : 1500L, 1500L));
                    }
                    CardAutoPlayManager cardAutoPlayManager2 = this$0.cardAutoPlayManager;
                    if (cardAutoPlayManager2 != null) {
                        CardAutoPlayManager cardAutoPlayManager3 = this$0.cardAutoPlayManager;
                        cardAutoPlayManager2.setMInterval(cardAutoPlayManager3 != null ? cardAutoPlayManager3.getMFirstDelay() : 1500L);
                    }
                    CardAutoPlayManager cardAutoPlayManager4 = this$0.cardAutoPlayManager;
                    if (cardAutoPlayManager4 != null) {
                        cardAutoPlayManager4.scrollNoLoop();
                        return;
                    }
                    return;
                }
            }
            if ($jumpToIndex == 0) {
                FrontAdapter frontAdapter11 = this$0.mAdapter;
                if (frontAdapter11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    frontAdapter11 = null;
                }
                if (frontAdapter11.getCards().size() > 0) {
                    CollectionCardDetailCallback mCallback = this$0.getMCallback();
                    FrontAdapter frontAdapter12 = this$0.mAdapter;
                    if (frontAdapter12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                        frontAdapter12 = null;
                    }
                    mCallback.showCardInfo(frontAdapter12.getCards().get(0).getBanner());
                    FrontAdapter frontAdapter13 = this$0.mAdapter;
                    if (frontAdapter13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                        frontAdapter13 = null;
                    }
                    SpaceBannerItemForUI spaceBannerItemForUI = frontAdapter13.getCards().get(0);
                    FrontAdapter frontAdapter14 = this$0.mAdapter;
                    if (frontAdapter14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                        frontAdapter14 = null;
                    }
                    long hashCode = frontAdapter14.getCards().get(0).getBanner().getItemId().hashCode();
                    FrontAdapter frontAdapter15 = this$0.mAdapter;
                    if (frontAdapter15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                        frontAdapter15 = null;
                    }
                    SpaceBannerItemContent item4 = frontAdapter15.getCards().get(0).getBanner().getItem();
                    List<String> animationVideoUrls2 = (item4 == null || (animation2 = item4.getAnimation()) == null) ? null : animation2.getAnimationVideoUrls();
                    FrontAdapter frontAdapter16 = this$0.mAdapter;
                    if (frontAdapter16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                        frontAdapter16 = null;
                    }
                    SpaceBannerItemContent item5 = frontAdapter16.getCards().get(0).getBanner().getItem();
                    this$0.playVideo(0, spaceBannerItemForUI, hashCode, animationVideoUrls2, (item5 == null || (animation = item5.getAnimation()) == null || !animation.isSilence()) ? false : true);
                    FrontAdapter frontAdapter17 = this$0.mAdapter;
                    if (frontAdapter17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                        frontAdapter17 = null;
                    }
                    this$0.showMusicAnimation(0, frontAdapter17.getCards().get(0));
                    RecyclerView recyclerView6 = this$0.mInnerRecycleView;
                    if (recyclerView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
                        recyclerView6 = null;
                    }
                    recyclerView6.post(new Runnable() { // from class: tv.danmaku.bili.ui.garb.view.FrontRecycleView$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            FrontRecycleView.updateCardData$lambda$0$0$2(FrontRecycleView.this);
                        }
                    });
                    this$0.cardAutoPlayManager = new CardAutoPlayManager($jumpToIndex, $cardTypeList.size(), this$0.mListener);
                    CardAutoPlayManager cardAutoPlayManager5 = this$0.cardAutoPlayManager;
                    if (cardAutoPlayManager5 != null) {
                        FrontAdapter frontAdapter18 = this$0.mAdapter;
                        if (frontAdapter18 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                            frontAdapter = null;
                        } else {
                            frontAdapter = frontAdapter18;
                        }
                        long duration = frontAdapter.getCards().get(0).getBanner().getExtra() != null ? extra.getDuration() : 1500L;
                        j = 1500;
                        cardAutoPlayManager5.setMFirstDelay(RangesKt.coerceAtLeast(duration, 1500L));
                    } else {
                        j = 1500;
                    }
                    CardAutoPlayManager cardAutoPlayManager6 = this$0.cardAutoPlayManager;
                    if (cardAutoPlayManager6 != null) {
                        CardAutoPlayManager cardAutoPlayManager7 = this$0.cardAutoPlayManager;
                        cardAutoPlayManager6.setMInterval(cardAutoPlayManager7 != null ? cardAutoPlayManager7.getMFirstDelay() : j);
                    }
                    CardAutoPlayManager cardAutoPlayManager8 = this$0.cardAutoPlayManager;
                    if (cardAutoPlayManager8 != null) {
                        cardAutoPlayManager8.scrollNoLoop();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateCardData$lambda$0$0$1(FrontRecycleView this$0, int $jumpToIndex) {
        BiliAppViewHolderCollectionFrontBinding binding;
        BiliImageView biliImageView;
        RecyclerView recyclerView = this$0.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition($jumpToIndex);
        FrontViewHolder frontViewHolder = findViewHolderForAdapterPosition instanceof FrontViewHolder ? (FrontViewHolder) findViewHolderForAdapterPosition : null;
        if (frontViewHolder == null || (binding = frontViewHolder.getBinding()) == null || (biliImageView = binding.nftCardMask) == null) {
            return;
        }
        biliImageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateCardData$lambda$0$0$2(FrontRecycleView this$0) {
        BiliAppViewHolderCollectionFrontBinding binding;
        BiliImageView biliImageView;
        RecyclerView recyclerView = this$0.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(0);
        FrontViewHolder frontViewHolder = findViewHolderForAdapterPosition instanceof FrontViewHolder ? (FrontViewHolder) findViewHolderForAdapterPosition : null;
        if (frontViewHolder == null || (binding = frontViewHolder.getBinding()) == null || (biliImageView = binding.nftCardMask) == null) {
            return;
        }
        biliImageView.setVisibility(8);
    }

    public final void clearData() {
        FrontAdapter frontAdapter = this.mAdapter;
        RecyclerView recyclerView = null;
        if (frontAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            frontAdapter = null;
        }
        frontAdapter.getCards().clear();
        FrontAdapter frontAdapter2 = this.mAdapter;
        if (frontAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            frontAdapter2 = null;
        }
        frontAdapter2.notifyDataSetChanged();
        RecyclerView recyclerView2 = this.mInnerRecycleView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setVisibility(8);
    }
}