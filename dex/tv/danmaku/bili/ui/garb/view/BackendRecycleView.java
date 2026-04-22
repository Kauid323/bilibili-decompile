package tv.danmaku.bili.ui.garb.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bili.digital.common.data.SpaceBannerItem;
import com.bilibili.droid.ScreenUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.databinding.BiliAppDialogDigitalCollectionRoomBinding;
import tv.danmaku.bili.ui.garb.adapter.BackendAdapter;
import tv.danmaku.bili.ui.garb.digital.base.view.DigitalFromType;
import tv.danmaku.bili.ui.garb.manager.BackendLinearLayoutManager;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: BackendRecycleView.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u001e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0013J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0013J\u0006\u0010!\u001a\u00020\u0019J\b\u0010\"\u001a\u00020\u0007H\u0002J\b\u0010#\u001a\u00020$H\u0002J.\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020$J\u0010\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u0005H\u0002J<\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00132\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`42\b\b\u0002\u00105\u001a\u00020\u00132\n\b\u0002\u00106\u001a\u0004\u0018\u000107J\u0006\u00108\u001a\u00020\u0019R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010,\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Ltv/danmaku/bili/ui/garb/view/BackendRecycleView;", "", "<init>", "()V", "mContext", "Landroid/content/Context;", "mAdapter", "Ltv/danmaku/bili/ui/garb/adapter/BackendAdapter;", "mInnerRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "mBaseLineX", "", "mCardType", "Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;", "getMCardType", "()Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;", "setMCardType", "(Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;)V", "mActivityId", "", "getMActivityId", "()I", "setMActivityId", "(I)V", "hide", "", ReportEvent.EVENT_TYPE_SHOW, "handleOnScrolledEvent", "dx", "dy", "offset", "handleOnScrollStateChangedEvent", "position", "disableTouchEvent", "getAdapter", "canScrollHorizontally", "", "init", "binding", "Ltv/danmaku/bili/databinding/BiliAppDialogDigitalCollectionRoomBinding;", "ctx", "cardType", "activityId", "isHalfScreen", "isInitDecoration", "addItemDecoration", "context", "updateCardData", "realCardSize", "cardTypeList", "Ljava/util/ArrayList;", "Lcom/bili/digital/common/data/SpaceBannerItem;", "Lkotlin/collections/ArrayList;", "jumpToIndex", "collectedFlagUrl", "", "clearData", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BackendRecycleView {
    public static final float MAX_ALPHA_SCALE = 0.5f;
    public static final float MAX_SCALE = 1.0f;
    public static final float MIN_ALPHA_SCALE = 0.3f;
    public static final float MIN_SCALE = 0.8333333f;
    public static final float NFT_CARD_CONTAINER_HEIGHT = 332.0f;
    public static final float NFT_CARD_CONTAINER_WIDTH = 180.0f;
    public static final float NFT_CARD_HEIGHT = 332.0f;
    public static final float NFT_CARD_WIDTH = 190.0f;
    public static final String TAG = "NftCardRecyclerView";
    private boolean isInitDecoration;
    private int mActivityId;
    private BackendAdapter mAdapter;
    private float mBaseLineX;
    private DigitalFromType mCardType = DigitalFromType.SEE;
    private Context mContext;
    private RecyclerView mInnerRecycleView;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: BackendRecycleView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/ui/garb/view/BackendRecycleView$Companion;", "", "<init>", "()V", "TAG", "", "MAX_SCALE", "", "MIN_SCALE", "NFT_CARD_WIDTH", "NFT_CARD_HEIGHT", "NFT_CARD_CONTAINER_WIDTH", "NFT_CARD_CONTAINER_HEIGHT", "MAX_ALPHA_SCALE", "MIN_ALPHA_SCALE", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
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

    public final void handleOnScrolledEvent(int dx, int dy, int offset) {
        RecyclerView recyclerView = this.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        recyclerView.scrollBy(-((int) ((dx * 180.0f) / 216.0f)), 0);
        RecyclerView recyclerView2 = this.mInnerRecycleView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView2 = null;
        }
        int childCount = recyclerView2.getChildCount();
        if (childCount <= 1) {
            return;
        }
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerView3 = this.mInnerRecycleView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
                recyclerView3 = null;
            }
            View child = recyclerView3.getChildAt(i);
            if (child != null) {
                RecyclerView recyclerView4 = this.mInnerRecycleView;
                if (recyclerView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
                    recyclerView4 = null;
                }
                recyclerView4.getChildAdapterPosition(child);
                int left = child.getLeft();
                float bl = RangesKt.coerceAtMost(Math.abs(((left - this.mBaseLineX) * 1.0f) / child.getWidth()), 1.0f);
                float scale = (bl > 1.0f ? 1 : (bl == 1.0f ? 0 : -1)) == 0 ? 1.0f : (0.16666669f * bl) + 0.8333333f;
                child.setScaleY(scale);
                child.setScaleX(scale);
                child.setAlpha((bl > 1.0f ? 1 : (bl == 1.0f ? 0 : -1)) == 0 ? 0.5f : (0.19999999f * bl) + 0.3f);
            }
        }
    }

    public final void handleOnScrollStateChangedEvent(int position) {
        BackendAdapter backendAdapter = this.mAdapter;
        BackendAdapter backendAdapter2 = null;
        if (backendAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            backendAdapter = null;
        }
        int childCount = backendAdapter.getCards().size();
        if (childCount > 1) {
            BackendAdapter backendAdapter3 = this.mAdapter;
            if (backendAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                backendAdapter3 = null;
            }
            if ((backendAdapter3.getMRealCardSize() + 2) - position >= 0) {
                BackendAdapter backendAdapter4 = this.mAdapter;
                if (backendAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    backendAdapter4 = null;
                }
                if ((backendAdapter4.getMRealCardSize() + 2) - position >= childCount) {
                    return;
                }
                RecyclerView recyclerView = this.mInnerRecycleView;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
                    recyclerView = null;
                }
                BackendAdapter backendAdapter5 = this.mAdapter;
                if (backendAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                } else {
                    backendAdapter2 = backendAdapter5;
                }
                recyclerView.scrollToPosition((backendAdapter2.getMRealCardSize() + 2) - position);
            }
        }
    }

    public final void disableTouchEvent() {
        RecyclerView recyclerView = this.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: tv.danmaku.bili.ui.garb.view.BackendRecycleView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean disableTouchEvent$lambda$0;
                disableTouchEvent$lambda$0 = BackendRecycleView.disableTouchEvent$lambda$0(view, motionEvent);
                return disableTouchEvent$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean disableTouchEvent$lambda$0(View view, MotionEvent motionEvent) {
        return true;
    }

    private final BackendAdapter getAdapter() {
        return new BackendAdapter(this.mContext);
    }

    private final boolean canScrollHorizontally() {
        return true;
    }

    public final void init(BiliAppDialogDigitalCollectionRoomBinding binding, Context ctx, DigitalFromType cardType, int activityId, boolean isHalfScreen) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        this.mCardType = cardType;
        this.mActivityId = activityId;
        this.mContext = ctx;
        this.mAdapter = getAdapter();
        this.mBaseLineX = (ScreenUtil.getScreenWidth(ctx) - ScreenUtil.dip2px(ctx, 180.0f)) / 2.0f;
        RecyclerView recyclerView = binding.nftCardListBackend;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "nftCardListBackend");
        this.mInnerRecycleView = recyclerView;
        RecyclerView recyclerView2 = this.mInnerRecycleView;
        RecyclerView recyclerView3 = null;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView2 = null;
        }
        BackendAdapter backendAdapter = this.mAdapter;
        if (backendAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            backendAdapter = null;
        }
        recyclerView2.setAdapter(backendAdapter);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        RecyclerView recyclerView4 = this.mInnerRecycleView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView4 = null;
        }
        pagerSnapHelper.attachToRecyclerView(recyclerView4);
        RecyclerView.LayoutManager backendLinearLayoutManager = new BackendLinearLayoutManager(ctx, canScrollHorizontally());
        RecyclerView recyclerView5 = this.mInnerRecycleView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
        } else {
            recyclerView3 = recyclerView5;
        }
        recyclerView3.setLayoutManager(backendLinearLayoutManager);
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
            recyclerView.addItemDecoration(new BackendItemDecoratiom(context, recyclerView2.getMeasuredHeight()));
        }
    }

    public static /* synthetic */ void updateCardData$default(BackendRecycleView backendRecycleView, int i, ArrayList arrayList, int i2, String str, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        if ((i3 & 8) != 0) {
            str = null;
        }
        backendRecycleView.updateCardData(i, arrayList, i2, str);
    }

    public final void updateCardData(final int realCardSize, final ArrayList<SpaceBannerItem> arrayList, final int jumpToIndex, final String collectedFlagUrl) {
        Intrinsics.checkNotNullParameter(arrayList, "cardTypeList");
        RecyclerView recyclerView = this.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        recyclerView.post(new Runnable() { // from class: tv.danmaku.bili.ui.garb.view.BackendRecycleView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                BackendRecycleView.updateCardData$lambda$0(BackendRecycleView.this, arrayList, realCardSize, collectedFlagUrl, jumpToIndex);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateCardData$lambda$0(BackendRecycleView this$0, ArrayList $cardTypeList, int $realCardSize, String $collectedFlagUrl, int $jumpToIndex) {
        Context it = this$0.mContext;
        if (it != null) {
            this$0.addItemDecoration(it);
            int length = $cardTypeList.size();
            if (length == 0) {
                BLog.d("NftCardRecyclerView", "fck data null");
                return;
            }
            BackendAdapter backendAdapter = this$0.mAdapter;
            RecyclerView recyclerView = null;
            if (backendAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                backendAdapter = null;
            }
            int oldSize = backendAdapter.getCards().size();
            BackendAdapter backendAdapter2 = this$0.mAdapter;
            if (backendAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                backendAdapter2 = null;
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
            backendAdapter2.updateContainerSize(measuredWidth, recyclerView3.getMeasuredHeight());
            BackendAdapter backendAdapter3 = this$0.mAdapter;
            if (backendAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                backendAdapter3 = null;
            }
            backendAdapter3.setMRealCardSize($realCardSize);
            BackendAdapter backendAdapter4 = this$0.mAdapter;
            if (backendAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                backendAdapter4 = null;
            }
            backendAdapter4.setMCollectedImageUrl($collectedFlagUrl);
            BackendAdapter backendAdapter5 = this$0.mAdapter;
            if (backendAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                backendAdapter5 = null;
            }
            backendAdapter5.getCards().clear();
            BackendAdapter backendAdapter6 = this$0.mAdapter;
            if (backendAdapter6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                backendAdapter6 = null;
            }
            backendAdapter6.notifyItemRangeRemoved(0, oldSize);
            BackendAdapter backendAdapter7 = this$0.mAdapter;
            if (backendAdapter7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                backendAdapter7 = null;
            }
            backendAdapter7.getCards().addAll($cardTypeList);
            BackendAdapter backendAdapter8 = this$0.mAdapter;
            if (backendAdapter8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                backendAdapter8 = null;
            }
            backendAdapter8.notifyItemRangeInserted(oldSize, oldSize + length);
            if ($jumpToIndex > 0) {
                BackendAdapter backendAdapter9 = this$0.mAdapter;
                if (backendAdapter9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    backendAdapter9 = null;
                }
                if ($jumpToIndex < backendAdapter9.getCards().size()) {
                    RecyclerView recyclerView4 = this$0.mInnerRecycleView;
                    if (recyclerView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
                    } else {
                        recyclerView = recyclerView4;
                    }
                    recyclerView.scrollToPosition($jumpToIndex);
                }
            }
        }
    }

    public final void clearData() {
        BackendAdapter backendAdapter = this.mAdapter;
        RecyclerView recyclerView = null;
        if (backendAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            backendAdapter = null;
        }
        backendAdapter.getCards().clear();
        BackendAdapter backendAdapter2 = this.mAdapter;
        if (backendAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            backendAdapter2 = null;
        }
        backendAdapter2.notifyDataSetChanged();
        RecyclerView recyclerView2 = this.mInnerRecycleView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setVisibility(8);
    }
}