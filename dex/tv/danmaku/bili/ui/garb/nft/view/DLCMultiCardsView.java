package tv.danmaku.bili.ui.garb.nft.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.view.BiliImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.garb.api.BiliDLCCardDisplay;
import tv.danmaku.bili.ui.garb.api.BiliDLCCardDisplayFrame;
import tv.danmaku.bili.ui.garb.api.BiliDLCCardDisplayMark;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardDrawItem;
import tv.danmaku.bili.ui.garb.nft.model.DLCTagModel;

/* compiled from: DLCMultiCardsView.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0014J0\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0014J\b\u0010#\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0010`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/view/DLCMultiCardsView;", "Landroid/widget/FrameLayout;", "cardsLayoutHelper", "Ltv/danmaku/bili/ui/garb/nft/view/MultiCardsLayoutHelper;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Ltv/danmaku/bili/ui/garb/nft/view/MultiCardsLayoutHelper;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cardWidth", "cardHeight", "mCardItems", "Ljava/util/ArrayList;", "Ltv/danmaku/bili/ui/garb/nft/model/DLCCardDrawItem;", "Lkotlin/collections/ArrayList;", "totalHeight", "setData", "", "cardItems", "", "totalWidth", "(Ljava/util/List;Ljava/lang/Integer;)V", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "", "left", "top", "right", "bottom", "addChildrenView", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCMultiCardsView extends FrameLayout {
    public static final int MAX_HORIZONTAL_CARD_NUM = 3;
    private int cardHeight;
    private int cardWidth;
    private final MultiCardsLayoutHelper cardsLayoutHelper;
    private ArrayList<DLCCardDrawItem> mCardItems;
    private int totalHeight;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DLCMultiCardsView(MultiCardsLayoutHelper cardsLayoutHelper, Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(cardsLayoutHelper, "cardsLayoutHelper");
        Intrinsics.checkNotNullParameter(context, "context");
        this.cardsLayoutHelper = cardsLayoutHelper;
        this.mCardItems = new ArrayList<>();
    }

    public /* synthetic */ DLCMultiCardsView(MultiCardsLayoutHelper multiCardsLayoutHelper, Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiCardsLayoutHelper, context, (i2 & 4) != 0 ? null : attributeSet, (i2 & 8) != 0 ? 0 : i);
    }

    /* compiled from: DLCMultiCardsView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/view/DLCMultiCardsView$Companion;", "", "<init>", "()V", "MAX_HORIZONTAL_CARD_NUM", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void setData$default(DLCMultiCardsView dLCMultiCardsView, List list, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        dLCMultiCardsView.setData(list, num);
    }

    public final void setData(List<DLCCardDrawItem> list, Integer totalWidth) {
        Intrinsics.checkNotNullParameter(list, "cardItems");
        this.mCardItems.clear();
        this.mCardItems.addAll(list);
        BLog.d("DLCMultiCardView", "totalWidth:" + totalWidth);
        Pair result = this.cardsLayoutHelper.computeCardSize(totalWidth);
        this.cardWidth = ((Number) result.getFirst()).intValue();
        this.cardHeight = ((Number) result.getSecond()).intValue();
        if (!this.mCardItems.isEmpty()) {
            this.totalHeight = this.cardsLayoutHelper.getCardY(this.mCardItems.size()) + this.cardHeight;
        }
        addChildrenView();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, this.totalHeight);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        Sequence $this$forEachIndexed$iv = ViewGroupKt.getChildren(this);
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view = (View) item$iv;
            int resultLeft = this.cardsLayoutHelper.getCardX(index + 1);
            int resultTop = this.cardsLayoutHelper.getCardY(index + 1);
            view.layout(resultLeft, resultTop, this.cardWidth + resultLeft, this.cardHeight + resultTop);
            index = index$iv;
        }
    }

    private final void addChildrenView() {
        removeAllViews();
        Iterable $this$forEach$iv = this.mCardItems;
        for (Object element$iv : $this$forEach$iv) {
            final DLCCardDrawItem item = (DLCCardDrawItem) element$iv;
            final View rootView = LayoutInflater.from(getContext()).inflate(R.layout.bili_app_dlc_dialog_result_cardview, (ViewGroup) this, false);
            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(this.cardWidth, this.cardHeight);
            addView(rootView, (ViewGroup.LayoutParams) params);
            rootView.post(new Runnable() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCMultiCardsView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DLCMultiCardsView.addChildrenView$lambda$0$0(rootView, this, item);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addChildrenView$lambda$0$0(View $rootView, DLCMultiCardsView this$0, DLCCardDrawItem $item) {
        BiliDLCCardDisplayMark cornerMark;
        BiliDLCCardDisplayFrame frame;
        DLCTagModel tag;
        DLCTagModel tag2;
        DLCTagModel tag3;
        DLCTagModel tag4;
        BiliImageView cardView = $rootView.findViewById(R.id.dlc_detail_image);
        BiliImageView tagIcon = $rootView.findViewById(R.id.dlc_detail_tag_icon);
        TextView tagText = (TextView) $rootView.findViewById(R.id.dlc_detail_tag_content);
        LinearLayoutCompat tagRoot = $rootView.findViewById(R.id.dlc_detail_tag_root);
        BiliImageView bivFrameBolder = $rootView.findViewById(R.id.bivFrameBolder);
        BiliImageView bivBadge = $rootView.findViewById(R.id.bivBadge);
        BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ImageRequestBuilder with = biliImageLoader.with(ListExtentionsKt.lifecycle(context));
        String badge = null;
        ImageRequestBuilder url = with.url($item != null ? $item.getUrl() : null);
        Intrinsics.checkNotNull(cardView);
        url.into(cardView);
        String imageUrl = ($item == null || (tag4 = $item.getTag()) == null) ? null : tag4.getImageUrl();
        boolean z = true;
        if (imageUrl == null || imageUrl.length() == 0) {
            String content = ($item == null || (tag3 = $item.getTag()) == null) ? null : tag3.getContent();
            if (content == null || content.length() == 0) {
                tagRoot.setVisibility(4);
            }
        }
        BiliImageLoader biliImageLoader2 = BiliImageLoader.INSTANCE;
        Context context2 = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        ImageRequestBuilder url2 = biliImageLoader2.with(ListExtentionsKt.lifecycle(context2)).url(($item == null || (tag2 = $item.getTag()) == null) ? null : tag2.getImageUrl());
        ScaleType scaleType = ScaleType.FIT_XY;
        Intrinsics.checkNotNullExpressionValue(scaleType, "FIT_XY");
        ImageRequestBuilder actualImageScaleType = url2.actualImageScaleType(scaleType);
        Intrinsics.checkNotNull(tagIcon);
        actualImageScaleType.into(tagIcon);
        tagText.setText(($item == null || (tag = $item.getTag()) == null) ? null : tag.getContent());
        BiliDLCCardDisplay disPlay = $item != null ? $item.getDisplay() : null;
        String border = (disPlay == null || (frame = disPlay.getFrame()) == null) ? null : frame.getImgSmall();
        String str = border;
        if (!(str == null || StringsKt.isBlank(str)) && bivFrameBolder != null) {
            bivFrameBolder.setVisibility(0);
            BiliImageLoader biliImageLoader3 = BiliImageLoader.INSTANCE;
            Context context3 = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            biliImageLoader3.with(ListExtentionsKt.lifecycle(context3)).url(border).into(bivFrameBolder);
        } else if (bivFrameBolder != null) {
            bivFrameBolder.setVisibility(8);
        }
        if (disPlay != null && (cornerMark = disPlay.getCornerMark()) != null) {
            badge = cornerMark.getImg();
        }
        String str2 = badge;
        if (str2 != null && !StringsKt.isBlank(str2)) {
            z = false;
        }
        if (!z && bivBadge != null) {
            bivBadge.setVisibility(0);
            BiliImageLoader biliImageLoader4 = BiliImageLoader.INSTANCE;
            Context context4 = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            ImageRequestBuilder url3 = biliImageLoader4.with(ListExtentionsKt.lifecycle(context4)).useOrigin().url(badge);
            ScaleType scaleType2 = ScaleType.FIT_START;
            Intrinsics.checkNotNullExpressionValue(scaleType2, "FIT_START");
            url3.actualImageScaleType(scaleType2).into(bivBadge);
        } else if (bivBadge != null) {
            bivBadge.setVisibility(8);
        }
    }
}