package tv.danmaku.bili.ui.garb.digital.base.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.droid.ScreenUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.garb.digital.DigitalCardDetailCallback;
import tv.danmaku.bili.ui.garb.digital.base.adapter.DigitalCardDetailAdapter;
import tv.danmaku.bili.ui.garb.digital.base.adapter.DigitalCardDetailItemDecoration;
import tv.danmaku.bili.ui.garb.digital.base.adapter.DigitalCardDetailScrollLinearLayoutManager;
import tv.danmaku.bili.ui.garb.digital.base.adapter.DigitalCardDetailViewHolder;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailRenderData;
import tv.danmaku.bili.ui.garb.nft.model.DLCPlayModel;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: DigitalCardDetailBaseRecycleView.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\b'\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\b\u0010$\u001a\u00020\tH&J\b\u0010%\u001a\u00020\u0007H&J\u0006\u0010&\u001a\u00020\"J\u0006\u0010'\u001a\u00020\"J8\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/2\b\b\u0002\u00101\u001a\u00020\u0007J6\u00102\u001a\u00020\"2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\r2\u0006\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\u0007J\u000e\u0010:\u001a\u00020\"2\u0006\u0010;\u001a\u00020+J\u0010\u0010=\u001a\u00020\"2\u0006\u0010>\u001a\u00020\u0005H\u0002J\u001e\u0010?\u001a\u00020\"2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020+0/2\b\b\u0002\u0010A\u001a\u00020\u001bJ\"\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00020\u00132\b\u0010E\u001a\u0004\u0018\u000100H\u0002J\u0006\u0010F\u001a\u00020\"J\u0006\u0010G\u001a\u00020\"R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalCardDetailBaseRecycleView;", "", "<init>", "()V", "mContext", "Landroid/content/Context;", "mIsHalfScreen", "", "mAdapter", "Ltv/danmaku/bili/ui/garb/digital/base/adapter/DigitalCardDetailAdapter;", "mInnerRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "mCallback", "Ltv/danmaku/bili/ui/garb/digital/DigitalCardDetailCallback;", "getMCallback", "()Ltv/danmaku/bili/ui/garb/digital/DigitalCardDetailCallback;", "setMCallback", "(Ltv/danmaku/bili/ui/garb/digital/DigitalCardDetailCallback;)V", "mCenterX", "", "mCardType", "Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;", "getMCardType", "()Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;", "setMCardType", "(Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;)V", "mActivityId", "", "getMActivityId", "()I", "setMActivityId", "(I)V", "mCurrentPosition", "hide", "", ReportEvent.EVENT_TYPE_SHOW, "getAdapter", "canScrollHorizontally", "startPlay", "hideVideoView", "playVideo", "index", "card", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRenderData;", "cardId", "", "videoList", "", "", "isMute", "init", "view", "Landroid/view/ViewGroup;", "ctx", "cb", "cardType", "activityId", "isHalfScreen", "updateData", "drawCard", "isInitDecoration", "addItemDecoration", "context", "updateCardData", "cardTypeList", "jumpToIndex", "syncCardInfo", "cardTypeId", "cardRatio", "totalCount", "scrollToLeft", "clearData", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class DigitalCardDetailBaseRecycleView {
    public static final float MAX_ALPHA_SCALE = 0.3f;
    public static final float MAX_ALPHA_SCALE_FOR_NO_HAVE = 0.8f;
    public static final float MAX_SCALE = 1.0f;
    public static final float MIN_ALPHA_SCALE = 0.0f;
    public static final float MIN_ALPHA_SCALE_FOR_NO_HAVE = 0.5f;
    public static final float MIN_SCALE = 0.8f;
    public static final float NFT_CARD_HEIGHT = 393.0f;
    public static final float NFT_CARD_WIDTH = 263.0f;
    public static final float SCROLL_CENTER_RATIO = 0.95f;
    public static final String TAG = "NftCardRecyclerView";
    private boolean isInitDecoration;
    private int mActivityId;
    private DigitalCardDetailAdapter mAdapter;
    public DigitalCardDetailCallback mCallback;
    private DigitalFromType mCardType = DigitalFromType.SEE;
    private float mCenterX;
    private Context mContext;
    private int mCurrentPosition;
    private RecyclerView mInnerRecycleView;
    private boolean mIsHalfScreen;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public abstract boolean canScrollHorizontally();

    public abstract DigitalCardDetailAdapter getAdapter();

    /* compiled from: DigitalCardDetailBaseRecycleView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalCardDetailBaseRecycleView$Companion;", "", "<init>", "()V", "TAG", "", "MAX_SCALE", "", "MIN_SCALE", "MAX_ALPHA_SCALE", "MIN_ALPHA_SCALE", "MAX_ALPHA_SCALE_FOR_NO_HAVE", "MIN_ALPHA_SCALE_FOR_NO_HAVE", "SCROLL_CENTER_RATIO", "NFT_CARD_WIDTH", "NFT_CARD_HEIGHT", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final DigitalCardDetailCallback getMCallback() {
        DigitalCardDetailCallback digitalCardDetailCallback = this.mCallback;
        if (digitalCardDetailCallback != null) {
            return digitalCardDetailCallback;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mCallback");
        return null;
    }

    public final void setMCallback(DigitalCardDetailCallback digitalCardDetailCallback) {
        Intrinsics.checkNotNullParameter(digitalCardDetailCallback, "<set-?>");
        this.mCallback = digitalCardDetailCallback;
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

    public final void startPlay() {
        RecyclerView recyclerView = this.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(this.mCurrentPosition);
        DigitalCardDetailViewHolder digitalCardDetailViewHolder = findViewHolderForAdapterPosition instanceof DigitalCardDetailViewHolder ? (DigitalCardDetailViewHolder) findViewHolderForAdapterPosition : null;
        if (digitalCardDetailViewHolder != null) {
            digitalCardDetailViewHolder.startPlay();
        }
    }

    public final void hideVideoView() {
        RecyclerView recyclerView = this.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(this.mCurrentPosition);
        DigitalCardDetailViewHolder digitalCardDetailViewHolder = findViewHolderForAdapterPosition instanceof DigitalCardDetailViewHolder ? (DigitalCardDetailViewHolder) findViewHolderForAdapterPosition : null;
        if (digitalCardDetailViewHolder != null) {
            digitalCardDetailViewHolder.hideVideoView();
        }
    }

    public static /* synthetic */ void playVideo$default(DigitalCardDetailBaseRecycleView digitalCardDetailBaseRecycleView, int i, DigitalCardDetailRenderData digitalCardDetailRenderData, long j, List list, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playVideo");
        }
        if ((i2 & 16) != 0) {
            z = false;
        }
        digitalCardDetailBaseRecycleView.playVideo(i, digitalCardDetailRenderData, j, list, z);
    }

    public final void playVideo(final int index, final DigitalCardDetailRenderData card, final long cardId, final List<String> list, final boolean isMute) {
        Intrinsics.checkNotNullParameter(card, "card");
        RecyclerView recyclerView = this.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        recyclerView.post(new Runnable() { // from class: tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseRecycleView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                DigitalCardDetailBaseRecycleView.playVideo$lambda$0(DigitalCardDetailBaseRecycleView.this, index, card, cardId, list, isMute);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playVideo$lambda$0(DigitalCardDetailBaseRecycleView this$0, int $index, DigitalCardDetailRenderData $card, long $cardId, List $videoList, boolean $isMute) {
        RecyclerView recyclerView = this$0.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition($index);
        DigitalCardDetailViewHolder digitalCardDetailViewHolder = findViewHolderForAdapterPosition instanceof DigitalCardDetailViewHolder ? (DigitalCardDetailViewHolder) findViewHolderForAdapterPosition : null;
        if (digitalCardDetailViewHolder != null) {
            digitalCardDetailViewHolder.playVideo($card, $cardId, $videoList, $isMute);
        }
    }

    public final void init(ViewGroup view, Context ctx, DigitalCardDetailCallback cb, DigitalFromType cardType, int activityId, boolean isHalfScreen) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(cb, "cb");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        this.mCardType = cardType;
        this.mActivityId = activityId;
        setMCallback(cb);
        this.mContext = ctx;
        this.mIsHalfScreen = isHalfScreen;
        this.mAdapter = getAdapter();
        this.mCenterX = (ScreenUtil.getScreenWidth(ctx) - ScreenUtil.dip2px(ctx, 263.0f)) / 2.0f;
        RecyclerView findViewById = view.findViewById(R.id.nft_card_list);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mInnerRecycleView = findViewById;
        RecyclerView recyclerView = this.mInnerRecycleView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        DigitalCardDetailAdapter digitalCardDetailAdapter = this.mAdapter;
        if (digitalCardDetailAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            digitalCardDetailAdapter = null;
        }
        recyclerView.setAdapter(digitalCardDetailAdapter);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        RecyclerView recyclerView3 = this.mInnerRecycleView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView3 = null;
        }
        pagerSnapHelper.attachToRecyclerView(recyclerView3);
        RecyclerView recyclerView4 = this.mInnerRecycleView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView4 = null;
        }
        recyclerView4.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseRecycleView$init$1
            public void onScrolled(RecyclerView recyclerView5, int dx, int dy) {
                float f;
                DigitalCardDetailAdapter digitalCardDetailAdapter2;
                Intrinsics.checkNotNullParameter(recyclerView5, "recyclerView");
                super.onScrolled(recyclerView5, dx, dy);
                int childCount = recyclerView5.getChildCount();
                if (childCount <= 1) {
                    return;
                }
                for (int i = 0; i < childCount; i++) {
                    View child = recyclerView5.getChildAt(i);
                    if (child != null) {
                        int index = recyclerView5.getChildAdapterPosition(child);
                        int left = child.getLeft();
                        f = DigitalCardDetailBaseRecycleView.this.mCenterX;
                        float bl = RangesKt.coerceAtMost(Math.abs(((left - f) * 1.0f) / child.getWidth()), 1.0f);
                        float scale = 1.0f - (0.19999999f * bl);
                        child.setScaleY(scale);
                        child.setScaleX(scale);
                        digitalCardDetailAdapter2 = DigitalCardDetailBaseRecycleView.this.mAdapter;
                        if (digitalCardDetailAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                            digitalCardDetailAdapter2 = null;
                        }
                        if (digitalCardDetailAdapter2.getCards().get(index).isHighLight()) {
                            child.findViewById(R.id.nft_card_mask).setAlpha((0.3f * bl) + 0.0f);
                        } else {
                            child.findViewById(R.id.nft_card_mask).setAlpha((0.3f * bl) + 0.5f);
                        }
                    }
                }
            }

            public void onScrollStateChanged(RecyclerView recyclerView5, int newState) {
                DigitalCardDetailAdapter digitalCardDetailAdapter2;
                boolean cardMute;
                Intrinsics.checkNotNullParameter(recyclerView5, "recyclerView");
                super.onScrollStateChanged(recyclerView5, newState);
                int childCount = recyclerView5.getChildCount();
                if (childCount <= 1) {
                    return;
                }
                switch (newState) {
                    case 0:
                        for (int i = 0; i < childCount; i++) {
                            View child = recyclerView5.getChildAt(i);
                            if (child != null && child.getScaleY() >= 0.95f) {
                                int index = recyclerView5.getChildAdapterPosition(child);
                                digitalCardDetailAdapter2 = DigitalCardDetailBaseRecycleView.this.mAdapter;
                                if (digitalCardDetailAdapter2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                                    digitalCardDetailAdapter2 = null;
                                }
                                DigitalCardDetailRenderData cardInfo = digitalCardDetailAdapter2.getCards().get(index);
                                DigitalCardDetailBaseRecycleView.this.mCurrentPosition = index;
                                boolean pageMute = DigitalCardDetailBaseRecycleView.this.getMCallback().onScrollEnd(cardInfo);
                                DLCPlayModel play = cardInfo.getPlay();
                                boolean z = false;
                                if (play != null && play.getShowProgressBar()) {
                                    z = true;
                                }
                                if (!z) {
                                    cardMute = pageMute;
                                } else {
                                    cardMute = cardInfo.getSilence();
                                }
                                RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView5.findViewHolderForAdapterPosition(index);
                                DigitalCardDetailViewHolder digitalCardDetailViewHolder = findViewHolderForAdapterPosition instanceof DigitalCardDetailViewHolder ? (DigitalCardDetailViewHolder) findViewHolderForAdapterPosition : null;
                                if (digitalCardDetailViewHolder != null) {
                                    digitalCardDetailViewHolder.playVideo(cardInfo, cardInfo.getCardId(), cardInfo.getVideoList(), cardMute);
                                }
                            }
                        }
                        return;
                    case 1:
                        DigitalCardDetailBaseRecycleView.this.getMCallback().onScrollStart();
                        return;
                    default:
                        return;
                }
            }
        });
        RecyclerView.LayoutManager digitalCardDetailScrollLinearLayoutManager = new DigitalCardDetailScrollLinearLayoutManager(ctx, canScrollHorizontally());
        RecyclerView recyclerView5 = this.mInnerRecycleView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
        } else {
            recyclerView2 = recyclerView5;
        }
        recyclerView2.setLayoutManager(digitalCardDetailScrollLinearLayoutManager);
    }

    public final void updateData(final DigitalCardDetailRenderData drawCard) {
        Intrinsics.checkNotNullParameter(drawCard, "drawCard");
        RecyclerView recyclerView = this.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        recyclerView.post(new Runnable() { // from class: tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseRecycleView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DigitalCardDetailBaseRecycleView.updateData$lambda$0(DigitalCardDetailBaseRecycleView.this, drawCard);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateData$lambda$0(DigitalCardDetailBaseRecycleView this$0, DigitalCardDetailRenderData $drawCard) {
        Context it = this$0.mContext;
        if (it != null) {
            this$0.addItemDecoration(it);
            DigitalCardDetailAdapter digitalCardDetailAdapter = this$0.mAdapter;
            RecyclerView recyclerView = null;
            if (digitalCardDetailAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                digitalCardDetailAdapter = null;
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
            digitalCardDetailAdapter.updateContainerSize(measuredWidth, recyclerView3.getMeasuredHeight());
            this$0.syncCardInfo($drawCard.getCardTypeId(), $drawCard.getRatio(), $drawCard.getTotalCount());
            DigitalCardDetailAdapter digitalCardDetailAdapter2 = this$0.mAdapter;
            if (digitalCardDetailAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                digitalCardDetailAdapter2 = null;
            }
            digitalCardDetailAdapter2.getCards().clear();
            DigitalCardDetailAdapter digitalCardDetailAdapter3 = this$0.mAdapter;
            if (digitalCardDetailAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                digitalCardDetailAdapter3 = null;
            }
            digitalCardDetailAdapter3.getCards().add(0, $drawCard);
            DigitalCardDetailAdapter digitalCardDetailAdapter4 = this$0.mAdapter;
            if (digitalCardDetailAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                digitalCardDetailAdapter4 = null;
            }
            DigitalCardDetailAdapter digitalCardDetailAdapter5 = this$0.mAdapter;
            if (digitalCardDetailAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                digitalCardDetailAdapter5 = null;
            }
            digitalCardDetailAdapter4.notifyItemRangeChanged(0, digitalCardDetailAdapter5.getCards().size());
            RecyclerView recyclerView4 = this$0.mInnerRecycleView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            } else {
                recyclerView = recyclerView4;
            }
            recyclerView.nestedScrollBy(1, 0);
            this$0.getMCallback().showCardInfo($drawCard);
            this$0.playVideo(0, $drawCard, $drawCard.getCardTypeId(), $drawCard.getVideoList(), $drawCard.getSilence());
        }
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
            recyclerView.addItemDecoration(new DigitalCardDetailItemDecoration(context, recyclerView2.getMeasuredHeight(), this.mIsHalfScreen));
        }
    }

    public static /* synthetic */ void updateCardData$default(DigitalCardDetailBaseRecycleView digitalCardDetailBaseRecycleView, List list, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCardData");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        digitalCardDetailBaseRecycleView.updateCardData(list, i);
    }

    public final void updateCardData(final List<? extends DigitalCardDetailRenderData> list, final int jumpToIndex) {
        Intrinsics.checkNotNullParameter(list, "cardTypeList");
        RecyclerView recyclerView = this.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        recyclerView.post(new Runnable() { // from class: tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseRecycleView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DigitalCardDetailBaseRecycleView.updateCardData$lambda$0(DigitalCardDetailBaseRecycleView.this, list, jumpToIndex);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateCardData$lambda$0(DigitalCardDetailBaseRecycleView this$0, List $cardTypeList, int $jumpToIndex) {
        Context it = this$0.mContext;
        if (it != null) {
            this$0.addItemDecoration(it);
            int length = $cardTypeList.size();
            if (length == 0) {
                BLog.d("NftCardRecyclerView", "fck data null");
                return;
            }
            DigitalCardDetailAdapter digitalCardDetailAdapter = this$0.mAdapter;
            RecyclerView recyclerView = null;
            if (digitalCardDetailAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                digitalCardDetailAdapter = null;
            }
            int oldSize = digitalCardDetailAdapter.getCards().size();
            DigitalCardDetailAdapter digitalCardDetailAdapter2 = this$0.mAdapter;
            if (digitalCardDetailAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                digitalCardDetailAdapter2 = null;
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
            digitalCardDetailAdapter2.updateContainerSize(measuredWidth, recyclerView3.getMeasuredHeight());
            DigitalCardDetailAdapter digitalCardDetailAdapter3 = this$0.mAdapter;
            if (digitalCardDetailAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                digitalCardDetailAdapter3 = null;
            }
            digitalCardDetailAdapter3.getCards().clear();
            DigitalCardDetailAdapter digitalCardDetailAdapter4 = this$0.mAdapter;
            if (digitalCardDetailAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                digitalCardDetailAdapter4 = null;
            }
            digitalCardDetailAdapter4.getCards().addAll($cardTypeList);
            DigitalCardDetailAdapter digitalCardDetailAdapter5 = this$0.mAdapter;
            if (digitalCardDetailAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                digitalCardDetailAdapter5 = null;
            }
            digitalCardDetailAdapter5.notifyItemRangeChanged(oldSize, oldSize + length);
            if ($jumpToIndex > 0) {
                DigitalCardDetailAdapter digitalCardDetailAdapter6 = this$0.mAdapter;
                if (digitalCardDetailAdapter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    digitalCardDetailAdapter6 = null;
                }
                if ($jumpToIndex < digitalCardDetailAdapter6.getCards().size()) {
                    DigitalCardDetailAdapter digitalCardDetailAdapter7 = this$0.mAdapter;
                    if (digitalCardDetailAdapter7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                        digitalCardDetailAdapter7 = null;
                    }
                    DigitalCardDetailRenderData jumpCardInfo = digitalCardDetailAdapter7.getCards().get($jumpToIndex);
                    BLog.d("NftCardRecyclerView", "scroll to jumpId: " + $jumpToIndex);
                    RecyclerView recyclerView4 = this$0.mInnerRecycleView;
                    if (recyclerView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
                    } else {
                        recyclerView = recyclerView4;
                    }
                    recyclerView.scrollToPosition($jumpToIndex);
                    this$0.getMCallback().showCardInfo(jumpCardInfo);
                    this$0.playVideo($jumpToIndex, jumpCardInfo, jumpCardInfo.getCardTypeId(), jumpCardInfo.getVideoList(), jumpCardInfo.getSilence());
                    return;
                }
            }
            if ($jumpToIndex == 0) {
                DigitalCardDetailAdapter digitalCardDetailAdapter8 = this$0.mAdapter;
                if (digitalCardDetailAdapter8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    digitalCardDetailAdapter8 = null;
                }
                if (digitalCardDetailAdapter8.getCards().size() > 0) {
                    DigitalCardDetailCallback mCallback = this$0.getMCallback();
                    DigitalCardDetailAdapter digitalCardDetailAdapter9 = this$0.mAdapter;
                    if (digitalCardDetailAdapter9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                        digitalCardDetailAdapter9 = null;
                    }
                    mCallback.showCardInfo(digitalCardDetailAdapter9.getCards().get(0));
                    DigitalCardDetailAdapter digitalCardDetailAdapter10 = this$0.mAdapter;
                    if (digitalCardDetailAdapter10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                        digitalCardDetailAdapter10 = null;
                    }
                    DigitalCardDetailRenderData digitalCardDetailRenderData = digitalCardDetailAdapter10.getCards().get(0);
                    DigitalCardDetailAdapter digitalCardDetailAdapter11 = this$0.mAdapter;
                    if (digitalCardDetailAdapter11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                        digitalCardDetailAdapter11 = null;
                    }
                    long cardTypeId = digitalCardDetailAdapter11.getCards().get(0).getCardTypeId();
                    DigitalCardDetailAdapter digitalCardDetailAdapter12 = this$0.mAdapter;
                    if (digitalCardDetailAdapter12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                        digitalCardDetailAdapter12 = null;
                    }
                    List<String> videoList = digitalCardDetailAdapter12.getCards().get(0).getVideoList();
                    RecyclerView recyclerView5 = this$0.mAdapter;
                    if (recyclerView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    } else {
                        recyclerView = recyclerView5;
                    }
                    this$0.playVideo(0, digitalCardDetailRenderData, cardTypeId, videoList, recyclerView.getCards().get(0).getSilence());
                }
            }
        }
    }

    private final boolean syncCardInfo(long cardTypeId, float cardRatio, String totalCount) {
        boolean needSync = false;
        DigitalCardDetailAdapter digitalCardDetailAdapter = this.mAdapter;
        if (digitalCardDetailAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            digitalCardDetailAdapter = null;
        }
        Iterable $this$forEach$iv = digitalCardDetailAdapter.getCards();
        for (Object element$iv : $this$forEach$iv) {
            DigitalCardDetailRenderData it = (DigitalCardDetailRenderData) element$iv;
            if (it.getCardTypeId() == cardTypeId) {
                if (!(it.getRatio() == cardRatio)) {
                    it.setRatio(cardRatio);
                    needSync = true;
                }
            }
            if (it.getCardTypeId() == cardTypeId && totalCount != null && !Intrinsics.areEqual(it.getTotalCount(), totalCount)) {
                it.setTotalCount(totalCount);
                needSync = true;
            }
        }
        return needSync;
    }

    public final void scrollToLeft() {
        DigitalCardDetailAdapter digitalCardDetailAdapter = this.mAdapter;
        RecyclerView recyclerView = null;
        if (digitalCardDetailAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            digitalCardDetailAdapter = null;
        }
        if (digitalCardDetailAdapter.getCards().size() > 0) {
            RecyclerView recyclerView2 = this.mInnerRecycleView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.scrollToPosition(0);
        }
    }

    public final void clearData() {
        DigitalCardDetailAdapter digitalCardDetailAdapter = this.mAdapter;
        RecyclerView recyclerView = null;
        if (digitalCardDetailAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            digitalCardDetailAdapter = null;
        }
        digitalCardDetailAdapter.getCards().clear();
        DigitalCardDetailAdapter digitalCardDetailAdapter2 = this.mAdapter;
        if (digitalCardDetailAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            digitalCardDetailAdapter2 = null;
        }
        digitalCardDetailAdapter2.notifyDataSetChanged();
        RecyclerView recyclerView2 = this.mInnerRecycleView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setVisibility(8);
    }
}