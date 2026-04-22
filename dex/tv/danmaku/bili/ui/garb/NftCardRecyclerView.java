package tv.danmaku.bili.ui.garb;

import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.authorspace.api.BiliNftImage;
import com.bilibili.app.authorspace.ui.nft.ui.activity.NftType;
import com.bilibili.app.authorspace.ui.nft.utils.ImageLoadCallback;
import com.bilibili.app.authorspace.ui.nft.utils.SpaceNftUtils;
import com.bilibili.app.common.gyroscope.model.NftGyroAttribute;
import com.bilibili.app.common.gyroscope.view.GyroRoundedView;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.lib.image2.bean.ImageInfo;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.okretro.BiliApiDataCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.garb.NftCardRecyclerView;
import tv.danmaku.bili.ui.garb.api.BiliCardDetail;
import tv.danmaku.bili.ui.garb.api.BiliNftApiManager;
import tv.danmaku.bili.ui.garb.api.CardTypeInfo;
import tv.danmaku.bili.ui.garb.api.Content;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: NftCardRecyclerView.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 +2\u00020\u0001:\u0005+,-./B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ.\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bJ\"\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0006\u0010#\u001a\u00020\rJ\u0006\u0010$\u001a\u00020\rJ,\u0010%\u001a\u00020\r2\u001a\u0010&\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010(0'j\n\u0012\u0006\u0012\u0004\u0018\u00010(`)2\b\b\u0002\u0010*\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardRecyclerView;", "", "<init>", "()V", "mAdapter", "Ltv/danmaku/bili/ui/garb/NftCardRecyclerView$NftCardListAdapter;", "mCardList", "Landroidx/recyclerview/widget/RecyclerView;", "mCallback", "Ltv/danmaku/bili/ui/garb/NftCardCallback;", "mCenterX", "", "hide", "", ReportEvent.EVENT_TYPE_SHOW, "init", "view", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "cb", "type", "Ltv/danmaku/bili/ui/garb/NftCardFromType;", "actId", "", "updateData", "drawCard", "Ltv/danmaku/bili/ui/garb/NftCardData;", "syncCardInfo", "", "cardTypeId", "", "cardRatio", "totalCount", "", "scrollToLeft", "clearData", "updateCardData", "cardTypeList", "Ljava/util/ArrayList;", "Ltv/danmaku/bili/ui/garb/NftCardDetailModel;", "Lkotlin/collections/ArrayList;", "jumpToIndex", "Companion", "NftCardListAdapter", "ScrollLinearLayoutManager", "NftCard", "NftCardItemDecoration", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NftCardRecyclerView {
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
    private NftCardListAdapter mAdapter;
    private NftCardCallback mCallback;
    private RecyclerView mCardList;
    private float mCenterX;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: NftCardRecyclerView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardRecyclerView$Companion;", "", "<init>", "()V", "TAG", "", "MAX_SCALE", "", "MIN_SCALE", "MAX_ALPHA_SCALE", "MIN_ALPHA_SCALE", "MAX_ALPHA_SCALE_FOR_NO_HAVE", "MIN_ALPHA_SCALE_FOR_NO_HAVE", "SCROLL_CENTER_RATIO", "NFT_CARD_WIDTH", "NFT_CARD_HEIGHT", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void hide() {
        RecyclerView recyclerView = this.mCardList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardList");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
    }

    public final void show() {
        RecyclerView recyclerView = this.mCardList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardList");
            recyclerView = null;
        }
        recyclerView.setVisibility(0);
    }

    public final void init(View view, Context ctx, NftCardCallback cb, NftCardFromType type, int actId) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(cb, "cb");
        Intrinsics.checkNotNullParameter(type, "type");
        this.mCenterX = (ScreenUtil.getScreenWidth(ctx) - ScreenUtil.dip2px(ctx, 263.0f)) / 2.0f;
        this.mAdapter = new NftCardListAdapter(cb, actId, type);
        this.mCallback = cb;
        RecyclerView findViewById = view.findViewById(R.id.nft_card_list);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mCardList = findViewById;
        RecyclerView recyclerView = this.mCardList;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardList");
            recyclerView = null;
        }
        NftCardListAdapter nftCardListAdapter = this.mAdapter;
        if (nftCardListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            nftCardListAdapter = null;
        }
        recyclerView.setAdapter(nftCardListAdapter);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        RecyclerView recyclerView3 = this.mCardList;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardList");
            recyclerView3 = null;
        }
        pagerSnapHelper.attachToRecyclerView(recyclerView3);
        RecyclerView recyclerView4 = this.mCardList;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardList");
            recyclerView4 = null;
        }
        recyclerView4.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: tv.danmaku.bili.ui.garb.NftCardRecyclerView$init$1
            public void onScrolled(RecyclerView recyclerView5, int dx, int dy) {
                float f;
                NftCardRecyclerView.NftCardListAdapter nftCardListAdapter2;
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
                        f = NftCardRecyclerView.this.mCenterX;
                        float bl = RangesKt.coerceAtMost(Math.abs(((left - f) * 1.0f) / child.getWidth()), 1.0f);
                        float scale = 1.0f - (0.19999999f * bl);
                        child.setScaleY(scale);
                        child.setScaleX(scale);
                        nftCardListAdapter2 = NftCardRecyclerView.this.mAdapter;
                        if (nftCardListAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                            nftCardListAdapter2 = null;
                        }
                        if (nftCardListAdapter2.getCards().get(index).getHasGained()) {
                            child.findViewById(R.id.nft_card_mask).setAlpha((0.3f * bl) + 0.0f);
                        } else {
                            child.findViewById(R.id.nft_card_mask).setAlpha((0.3f * bl) + 0.5f);
                        }
                    }
                }
            }

            public void onScrollStateChanged(RecyclerView recyclerView5, int newState) {
                NftCardCallback nftCardCallback;
                NftCardRecyclerView.NftCardListAdapter nftCardListAdapter2;
                NftCardCallback nftCardCallback2;
                Intrinsics.checkNotNullParameter(recyclerView5, "recyclerView");
                super.onScrollStateChanged(recyclerView5, newState);
                int childCount = recyclerView5.getChildCount();
                if (childCount <= 1) {
                    return;
                }
                NftCardCallback nftCardCallback3 = null;
                switch (newState) {
                    case 0:
                        for (int i = 0; i < childCount; i++) {
                            View child = recyclerView5.getChildAt(i);
                            if (child != null && child.getScaleY() >= 0.95f) {
                                int index = recyclerView5.getChildAdapterPosition(child);
                                nftCardCallback = NftCardRecyclerView.this.mCallback;
                                if (nftCardCallback == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mCallback");
                                    nftCardCallback = null;
                                }
                                nftCardListAdapter2 = NftCardRecyclerView.this.mAdapter;
                                if (nftCardListAdapter2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                                    nftCardListAdapter2 = null;
                                }
                                nftCardCallback.onScrollEnd(nftCardListAdapter2.getCards().get(index));
                            }
                        }
                        return;
                    case 1:
                        nftCardCallback2 = NftCardRecyclerView.this.mCallback;
                        if (nftCardCallback2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mCallback");
                        } else {
                            nftCardCallback3 = nftCardCallback2;
                        }
                        nftCardCallback3.onScrollStart();
                        return;
                    default:
                        return;
                }
            }
        });
        RecyclerView.LayoutManager scrollLinearLayoutManager = new ScrollLinearLayoutManager(ctx, type);
        RecyclerView recyclerView5 = this.mCardList;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardList");
            recyclerView5 = null;
        }
        recyclerView5.setLayoutManager(scrollLinearLayoutManager);
        RecyclerView recyclerView6 = this.mCardList;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardList");
        } else {
            recyclerView2 = recyclerView6;
        }
        recyclerView2.addItemDecoration(new NftCardItemDecoration(ctx));
    }

    public final void updateData(NftCardData drawCard) {
        Intrinsics.checkNotNullParameter(drawCard, "drawCard");
        syncCardInfo(drawCard.getCardTypeId(), drawCard.getRatio(), drawCard.getTotalCount());
        NftCardListAdapter nftCardListAdapter = this.mAdapter;
        NftCardCallback nftCardCallback = null;
        if (nftCardListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            nftCardListAdapter = null;
        }
        nftCardListAdapter.getCards().add(0, drawCard);
        NftCardListAdapter nftCardListAdapter2 = this.mAdapter;
        if (nftCardListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            nftCardListAdapter2 = null;
        }
        NftCardListAdapter nftCardListAdapter3 = this.mAdapter;
        if (nftCardListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            nftCardListAdapter3 = null;
        }
        nftCardListAdapter2.notifyItemRangeChanged(0, nftCardListAdapter3.getCards().size());
        RecyclerView recyclerView = this.mCardList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardList");
            recyclerView = null;
        }
        recyclerView.nestedScrollBy(1, 0);
        NftCardCallback nftCardCallback2 = this.mCallback;
        if (nftCardCallback2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCallback");
        } else {
            nftCardCallback = nftCardCallback2;
        }
        nftCardCallback.showCardInfo(drawCard);
    }

    private final boolean syncCardInfo(long cardTypeId, float cardRatio, String totalCount) {
        boolean needSync = false;
        NftCardListAdapter nftCardListAdapter = this.mAdapter;
        if (nftCardListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            nftCardListAdapter = null;
        }
        Iterable $this$forEach$iv = nftCardListAdapter.getCards();
        for (Object element$iv : $this$forEach$iv) {
            NftCardData it = (NftCardData) element$iv;
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
        NftCardListAdapter nftCardListAdapter = this.mAdapter;
        RecyclerView recyclerView = null;
        if (nftCardListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            nftCardListAdapter = null;
        }
        if (nftCardListAdapter.getCards().size() > 0) {
            RecyclerView recyclerView2 = this.mCardList;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardList");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.scrollToPosition(0);
        }
    }

    public final void clearData() {
        NftCardListAdapter nftCardListAdapter = this.mAdapter;
        RecyclerView recyclerView = null;
        if (nftCardListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            nftCardListAdapter = null;
        }
        nftCardListAdapter.getCards().clear();
        NftCardListAdapter nftCardListAdapter2 = this.mAdapter;
        if (nftCardListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            nftCardListAdapter2 = null;
        }
        nftCardListAdapter2.notifyDataSetChanged();
        RecyclerView recyclerView2 = this.mCardList;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardList");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setVisibility(8);
    }

    public static /* synthetic */ void updateCardData$default(NftCardRecyclerView nftCardRecyclerView, ArrayList arrayList, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        nftCardRecyclerView.updateCardData(arrayList, i);
    }

    public final void updateCardData(ArrayList<NftCardDetailModel> arrayList, int jumpToIndex) {
        NftCardListAdapter nftCardListAdapter;
        NftCardCallback nftCardCallback;
        int length;
        Iterable cardIdList;
        ArrayList<NftCardDetailIdModel> cardIdList2;
        Intrinsics.checkNotNullParameter(arrayList, "cardTypeList");
        int length2 = arrayList.size();
        if (length2 == 0) {
            BLog.d("NftCardRecyclerView", "fck data null");
            return;
        }
        NftCardListAdapter nftCardListAdapter2 = this.mAdapter;
        if (nftCardListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            nftCardListAdapter2 = null;
        }
        int oldSize = nftCardListAdapter2.getCards().size();
        int count = 0;
        ArrayList<NftCardDetailModel> $this$forEach$iv = arrayList;
        Iterator<T> it = $this$forEach$iv.iterator();
        while (true) {
            int size = 0;
            if (!it.hasNext()) {
                break;
            }
            Object element$iv = it.next();
            NftCardDetailModel cardDetail = (NftCardDetailModel) element$iv;
            if (cardDetail != null && (cardIdList2 = cardDetail.getCardIdList()) != null) {
                size = cardIdList2.size();
            }
            if (size > 0) {
                count += size;
                if (cardDetail == null || (cardIdList = cardDetail.getCardIdList()) == null) {
                    length = length2;
                } else {
                    Iterable $this$forEach$iv2 = cardIdList;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        NftCardDetailIdModel card = (NftCardDetailIdModel) element$iv2;
                        NftCardListAdapter nftCardListAdapter3 = this.mAdapter;
                        if (nftCardListAdapter3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                            nftCardListAdapter3 = null;
                        }
                        nftCardListAdapter3.getCards().add(new NftCardData(cardDetail, card));
                        length2 = length2;
                    }
                    length = length2;
                }
            } else {
                length = length2;
                count++;
                if (cardDetail != null) {
                    NftCardListAdapter nftCardListAdapter4 = this.mAdapter;
                    if (nftCardListAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                        nftCardListAdapter4 = null;
                    }
                    nftCardListAdapter4.getCards().add(new NftCardData(cardDetail, null));
                }
            }
            length2 = length;
        }
        NftCardListAdapter nftCardListAdapter5 = this.mAdapter;
        if (nftCardListAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            nftCardListAdapter5 = null;
        }
        nftCardListAdapter5.notifyItemRangeChanged(oldSize, oldSize + count);
        if (jumpToIndex > 0) {
            NftCardListAdapter nftCardListAdapter6 = this.mAdapter;
            if (nftCardListAdapter6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                nftCardListAdapter6 = null;
            }
            if (jumpToIndex < nftCardListAdapter6.getCards().size()) {
                NftCardListAdapter nftCardListAdapter7 = this.mAdapter;
                if (nftCardListAdapter7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    nftCardListAdapter7 = null;
                }
                NftCardData jumpCardInfo = nftCardListAdapter7.getCards().get(jumpToIndex);
                BLog.d("NftCardRecyclerView", "scroll to jumpId: " + jumpToIndex);
                RecyclerView recyclerView = this.mCardList;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCardList");
                    recyclerView = null;
                }
                recyclerView.scrollToPosition(jumpToIndex);
                NftCardCallback nftCardCallback2 = this.mCallback;
                if (nftCardCallback2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCallback");
                    nftCardCallback = null;
                } else {
                    nftCardCallback = nftCardCallback2;
                }
                nftCardCallback.showCardInfo(jumpCardInfo);
                return;
            }
        }
        if (jumpToIndex == 0) {
            NftCardListAdapter nftCardListAdapter8 = this.mAdapter;
            if (nftCardListAdapter8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                nftCardListAdapter8 = null;
            }
            if (nftCardListAdapter8.getCards().size() > 0) {
                NftCardCallback nftCardCallback3 = this.mCallback;
                if (nftCardCallback3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCallback");
                    nftCardCallback3 = null;
                }
                NftCardListAdapter nftCardListAdapter9 = this.mAdapter;
                if (nftCardListAdapter9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    nftCardListAdapter = null;
                } else {
                    nftCardListAdapter = nftCardListAdapter9;
                }
                nftCardCallback3.showCardInfo(nftCardListAdapter.getCards().get(0));
            }
        }
    }

    /* compiled from: NftCardRecyclerView.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardRecyclerView$NftCardListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mCallback", "Ltv/danmaku/bili/ui/garb/NftCardCallback;", "mActionId", "", "mType", "Ltv/danmaku/bili/ui/garb/NftCardFromType;", "<init>", "(Ltv/danmaku/bili/ui/garb/NftCardCallback;ILtv/danmaku/bili/ui/garb/NftCardFromType;)V", "mCards", "", "Ltv/danmaku/bili/ui/garb/NftCardData;", "value", "cards", "getCards", "()Ljava/util/List;", "setCards", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "getItemViewType", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class NftCardListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public static final int $stable = 8;
        private final int mActionId;
        private final NftCardCallback mCallback;
        private List<NftCardData> mCards;
        private final NftCardFromType mType;

        /* compiled from: NftCardRecyclerView.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[NftType.values().length];
                try {
                    iArr[NftType.IMAGE.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[NftType.VIDEO.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public NftCardListAdapter(NftCardCallback mCallback, int mActionId, NftCardFromType mType) {
            Intrinsics.checkNotNullParameter(mCallback, "mCallback");
            Intrinsics.checkNotNullParameter(mType, "mType");
            this.mCallback = mCallback;
            this.mActionId = mActionId;
            this.mType = mType;
            this.mCards = new ArrayList();
        }

        public final List<NftCardData> getCards() {
            return this.mCards;
        }

        public final void setCards(List<NftCardData> list) {
            Intrinsics.checkNotNullParameter(list, "value");
            this.mCards = list;
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            return NftCard.Companion.create(parent);
        }

        public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (holder instanceof NftCard) {
                final NftCardData card = this.mCards.get(position);
                if (card.getHeight() > 0 && card.getWidth() > 0 && card.getWidth() > card.getHeight()) {
                    int expectedHeight = 0;
                    ViewGroup.LayoutParams it = ((NftCard) holder).getMCardImg().getLayoutParams();
                    if (it != null) {
                        expectedHeight = (int) (it.width * ((card.getHeight() * 1.0f) / card.getWidth()));
                        BLog.d("NftCardRecyclerView", "calculate expected height " + expectedHeight);
                        it.height = expectedHeight;
                        ((NftCard) holder).getMCardImg().setLayoutParams(it);
                    }
                    ViewGroup.LayoutParams layoutParams = ((NftCard) holder).getMCardGyro().getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = expectedHeight;
                    }
                    ViewGroup.LayoutParams layoutParams2 = ((NftCard) holder).getMCardMask().getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.height = expectedHeight;
                    }
                } else {
                    Context ctx = ((NftCard) holder).getMCardImg().getContext();
                    int defaultHeight = ScreenUtil.dip2px(ctx, 393.0f);
                    ViewGroup.LayoutParams it2 = ((NftCard) holder).getMCardImg().getLayoutParams();
                    if (it2 != null) {
                        BLog.d("NftCardRecyclerView", "default height " + defaultHeight);
                        it2.height = defaultHeight;
                        ((NftCard) holder).getMCardImg().setLayoutParams(it2);
                    }
                    ViewGroup.LayoutParams layoutParams3 = ((NftCard) holder).getMCardGyro().getLayoutParams();
                    if (layoutParams3 != null) {
                        layoutParams3.height = defaultHeight;
                    }
                    ViewGroup.LayoutParams layoutParams4 = ((NftCard) holder).getMCardMask().getLayoutParams();
                    if (layoutParams4 != null) {
                        layoutParams4.height = defaultHeight;
                    }
                }
                SpaceNftUtils.loadImage$default(SpaceNftUtils.INSTANCE, card.getImgUrl(), ((NftCard) holder).getMCardImg(), new ImageLoadCallback() { // from class: tv.danmaku.bili.ui.garb.NftCardRecyclerView$NftCardListAdapter$onBindViewHolder$3
                    public /* synthetic */ void onFailed(Throwable th) {
                        ImageLoadCallback.-CC.$default$onFailed(this, th);
                    }

                    public void onSucceed(ImageInfo imageInfo) {
                        NftCardFromType nftCardFromType;
                        NftCardCallback nftCardCallback;
                        Intrinsics.checkNotNullParameter(imageInfo, "imageInfo");
                        nftCardFromType = NftCardRecyclerView.NftCardListAdapter.this.mType;
                        if (nftCardFromType == NftCardFromType.DRAW) {
                            nftCardCallback = NftCardRecyclerView.NftCardListAdapter.this.mCallback;
                            nftCardCallback.onCardLoadSuccess(card);
                        }
                    }
                }, false, 8, (Object) null);
                switch (WhenMappings.$EnumSwitchMapping$0[card.getType().ordinal()]) {
                    case 1:
                        if (card.getHasGained()) {
                            if (card.getGyroscope() != null && !card.getGyroscope().isEmpty()) {
                                ((NftCard) holder).loadGyro(card.getGyroscope());
                                return;
                            } else if (card.getNeedRequest()) {
                                BiliNftApiManager.INSTANCE.loadCardDetail(this.mActionId, card.getCardTypeId(), new BiliApiDataCallback<BiliCardDetail>() { // from class: tv.danmaku.bili.ui.garb.NftCardRecyclerView$NftCardListAdapter$onBindViewHolder$4
                                    public void onDataSuccess(BiliCardDetail data) {
                                        CardTypeInfo cardTypeInfo;
                                        Content content;
                                        BiliNftImage image;
                                        List gyroData = (data == null || (cardTypeInfo = data.getCardTypeInfo()) == null || (content = cardTypeInfo.getContent()) == null || (image = content.getImage()) == null) ? null : image.getGyroscope();
                                        if (data == null || gyroData == null) {
                                            onError(new Exception("接口下发数据为空"));
                                            return;
                                        }
                                        BLog.d("NftCardRecyclerView", "load card detail api success");
                                        ((NftCardRecyclerView.NftCard) holder).loadGyro(gyroData);
                                    }

                                    public void onError(Throwable t) {
                                        BLog.e("NftCardRecyclerView", "load card detail err, cause " + (t != null ? t.getMessage() : null));
                                    }
                                });
                                return;
                            } else {
                                ((NftCard) holder).getMCardGyro().setVisibility(8);
                                return;
                            }
                        }
                        ((NftCard) holder).getMCardGyro().setVisibility(8);
                        return;
                    case 2:
                        ((NftCard) holder).getMCardGyro().setVisibility(8);
                        return;
                    default:
                        ((NftCard) holder).getMCardGyro().setVisibility(8);
                        return;
                }
            }
        }

        public int getItemCount() {
            return this.mCards.size();
        }

        public int getItemViewType(int position) {
            return 1;
        }
    }

    /* compiled from: NftCardRecyclerView.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardRecyclerView$ScrollLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "type", "Ltv/danmaku/bili/ui/garb/NftCardFromType;", "<init>", "(Landroid/content/Context;Ltv/danmaku/bili/ui/garb/NftCardFromType;)V", "mOffset", "", "scrollToPosition", "", "position", "", "canScrollHorizontally", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ScrollLinearLayoutManager extends LinearLayoutManager {
        public static final int $stable = 8;
        private final float mOffset;
        private final NftCardFromType type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScrollLinearLayoutManager(Context context, NftCardFromType type) {
            super(context, 0, false);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            this.mOffset = (ScreenUtil.getScreenWidth(context) - ScreenUtil.dip2px(context, 263.0f)) / 2.0f;
        }

        public void scrollToPosition(int position) {
            BLog.d("NftCardRecyclerView", "scrollToPosition " + position + ", offset " + this.mOffset);
            scrollToPositionWithOffset(position, (int) this.mOffset);
        }

        public boolean canScrollHorizontally() {
            return this.type != NftCardFromType.EXCHANGE;
        }
    }

    /* compiled from: NftCardRecyclerView.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardRecyclerView$NftCard;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mCardImg", "Lcom/bilibili/lib/image2/view/BiliImageView;", "getMCardImg", "()Lcom/bilibili/lib/image2/view/BiliImageView;", "mCardGyro", "Lcom/bilibili/app/common/gyroscope/view/GyroRoundedView;", "getMCardGyro", "()Lcom/bilibili/app/common/gyroscope/view/GyroRoundedView;", "mCardMask", "getMCardMask", "()Landroid/view/View;", "loadGyro", "", "data", "", "Lcom/bilibili/app/common/gyroscope/model/NftGyroAttribute;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class NftCard extends RecyclerView.ViewHolder {
        private final GyroRoundedView mCardGyro;
        private final BiliImageView mCardImg;
        private final View mCardMask;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NftCard(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            BiliImageView findViewById = itemView.findViewById(R.id.nft_card_img);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.mCardImg = findViewById;
            GyroRoundedView findViewById2 = itemView.findViewById(R.id.nft_card_gyro);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.mCardGyro = findViewById2;
            View findViewById3 = itemView.findViewById(R.id.nft_card_mask);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.mCardMask = findViewById3;
        }

        public final BiliImageView getMCardImg() {
            return this.mCardImg;
        }

        public final GyroRoundedView getMCardGyro() {
            return this.mCardGyro;
        }

        public final View getMCardMask() {
            return this.mCardMask;
        }

        public final void loadGyro(List<NftGyroAttribute> list) {
            Intrinsics.checkNotNullParameter(list, "data");
            BLog.d("NftCardRecyclerView", "loadGyro!");
            Application application = BiliContext.application();
            Context ctx = application != null ? application.getBaseContext() : null;
            this.mCardGyro.setVisibility(0);
            boolean result = this.mCardGyro.configWithGyro(ScreenUtil.dip2px(ctx, 263.0f), ScreenUtil.dip2px(ctx, 393.0f), list, new GyroRoundedView.GyroViewCallBack() { // from class: tv.danmaku.bili.ui.garb.NftCardRecyclerView$NftCard$loadGyro$result$1
                public void notifyImgLoadSuc(boolean suc) {
                    BLog.d("NftCardRecyclerView", "load success ? " + suc);
                }

                public void notifyGyroReport(float roll, float pitch, float yaw) {
                }
            });
            BLog.d("NftCardRecyclerView", "config gyro success ?" + result);
        }

        /* compiled from: NftCardRecyclerView.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardRecyclerView$NftCard$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/bili/ui/garb/NftCardRecyclerView$NftCard;", "parent", "Landroid/view/ViewGroup;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final NftCard create(ViewGroup parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
                View view = layoutInflater.inflate(R.layout.bili_app_view_holder_nft_card, parent, false);
                Intrinsics.checkNotNull(view);
                return new NftCard(view);
            }
        }
    }

    /* compiled from: NftCardRecyclerView.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardRecyclerView$NftCardItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", AuthResultCbHelper.ARGS_STATE, "Landroidx/recyclerview/widget/RecyclerView$State;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class NftCardItemDecoration extends RecyclerView.ItemDecoration {
        public static final int $stable = 8;
        private final Context context;

        public NftCardItemDecoration(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
            int position = parent.getChildAdapterPosition(view);
            int parentWidth = parent.getMeasuredWidth();
            int width = ScreenUtil.dip2px(this.context, 263.0f);
            int margin = RangesKt.coerceAtLeast(0, (parentWidth - width) / 2);
            if (position == 0) {
                outRect.left = margin;
            } else if (position == state.getItemCount() - 1) {
                outRect.right = margin;
            }
        }
    }
}