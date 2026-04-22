package tv.danmaku.bili.ui.rank.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bapis.bilibili.app.show.rank.v1.Item;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.image2.bean.BitmapTransformation;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.bean.ThumbnailUrlTransformStrategy;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.imageviewer.utils.ImageExtentionKt;
import java.lang.ref.WeakReference;
import java.util.List;
import kntr.base.localization.NumberFormat_androidKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.R;
import tv.danmaku.bili.ui.rank.RankVideoListFragment;
import tv.danmaku.bili.ui.rank.model.RankModel;
import tv.danmaku.bili.ui.rank.reporter.RankingReport;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.bili.ui.rank.utils.NeuronsEventKt;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterReporterKt;
import tv.danmaku.bili.widget.FixedPopupAnchor;
import tv.danmaku.bili.widget.ForegroundRelativeLayout;
import tv.danmaku.bili.widget.VectorTextView;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayerTracker;

/* compiled from: ViewHolderUgc.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J \u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u001fH\u0016J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Ltv/danmaku/bili/ui/rank/view/ViewHolderUgc;", "Ltv/danmaku/bili/ui/rank/view/ViewHolderBase;", "parent", "Landroid/view/ViewGroup;", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "<init>", "(Landroid/view/ViewGroup;Ljava/lang/String;)V", "mPlayNum", "Ltv/danmaku/bili/widget/VectorTextView;", "mDanmakuNum", "mUpName", "mVideoLayout", "Ltv/danmaku/bili/widget/ForegroundRelativeLayout;", "mCover", "Lcom/bilibili/lib/image2/view/BiliImageView;", "mTitleView", "Landroid/widget/TextView;", "mDuration", "mRankNum", "mAnchorMore", "Ltv/danmaku/bili/widget/FixedPopupAnchor;", "mUpMoreContent", "Landroid/widget/LinearLayout;", "mUpMoreContain", "mUpMoreText", "mUpMoreExpand", "Landroid/widget/ImageView;", "initView", "", "itemView", "Landroid/view/View;", "setListeners", "bind", "video", "Ltv/danmaku/bili/ui/rank/model/RankModel;", "fragment", "Ljava/lang/ref/WeakReference;", "Ltv/danmaku/bili/ui/rank/RankVideoListFragment;", "onClick", "v", "updateMoreContainer", "setRankAppearance", "rank", "", "rank_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ViewHolderUgc extends ViewHolderBase {
    public static final int $stable = 8;
    private FixedPopupAnchor mAnchorMore;
    private BiliImageView mCover;
    private VectorTextView mDanmakuNum;
    private TextView mDuration;
    private VectorTextView mPlayNum;
    private TextView mRankNum;
    private TextView mTitleView;
    private LinearLayout mUpMoreContain;
    private LinearLayout mUpMoreContent;
    private ImageView mUpMoreExpand;
    private TextView mUpMoreText;
    private VectorTextView mUpName;
    private ForegroundRelativeLayout mVideoLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolderUgc(ViewGroup parent, String title) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_layout_list_item_rank_ugc, parent, false), title);
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        View view2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "itemView");
        initView(view2);
        setListeners();
    }

    private final void initView(View itemView) {
        this.mUpMoreContent = (LinearLayout) itemView.findViewById(R.id.up_more_content_layout);
        this.mUpMoreContain = (LinearLayout) itemView.findViewById(R.id.up_more_contain);
        this.mUpMoreText = (TextView) itemView.findViewById(R.id.up_more_text);
        this.mUpMoreExpand = (ImageView) itemView.findViewById(R.id.up_more_expand);
        this.mVideoLayout = (ForegroundRelativeLayout) itemView.findViewById(R.id.video_layout);
        this.mCover = itemView.findViewById(R.id.cover);
        this.mTitleView = (TextView) itemView.findViewById(R.id.title);
        this.mDuration = (TextView) itemView.findViewById(R.id.tv_duration);
        this.mRankNum = (TextView) itemView.findViewById(R.id.tv_rank_num);
        View findViewById = itemView.findViewById(R.id.up_name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mUpName = (VectorTextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.rank_play_num);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mPlayNum = (VectorTextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.rank_danmaku_num);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mDanmakuNum = (VectorTextView) findViewById3;
        this.mAnchorMore = (FixedPopupAnchor) itemView.findViewById(R.id.anchor_more);
    }

    private final void setListeners() {
        ForegroundRelativeLayout foregroundRelativeLayout = this.mVideoLayout;
        if (foregroundRelativeLayout != null) {
            foregroundRelativeLayout.setOnClickListener(this);
        }
        LinearLayout linearLayout = this.mUpMoreContain;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        FixedPopupAnchor fixedPopupAnchor = this.mAnchorMore;
        if (fixedPopupAnchor != null) {
            fixedPopupAnchor.setOnClickListener(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x010f, code lost:
        if (r5.intValue() > 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0119, code lost:
        if ((r5 != null ? r5.getTag() : null) != r18) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x011b, code lost:
        r4 = r17.mUpMoreContent;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x011d, code lost:
        if (r4 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x011f, code lost:
        r4.removeAllViews();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0122, code lost:
        r4 = r18.getChildrenList().size();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x012b, code lost:
        if (r5 >= r4) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x012d, code lost:
        r7 = r18.getChildren(r5);
        r8 = android.view.LayoutInflater.from(r3).inflate(tv.danmaku.bili.ui.rank.R.layout.bili_app_layout_list_item_rank_more_item, (android.view.ViewGroup) r17.mUpMoreContent, false);
        r9 = (android.widget.TextView) r8.findViewById(tv.danmaku.bili.ui.rank.R.id.tv_title);
        r10 = (tv.danmaku.bili.widget.FixedPopupAnchor) r8.findViewById(tv.danmaku.bili.ui.rank.R.id.more_sub);
        r10.setOnClickListener(r17);
        r10.setTag(r7);
        r9.setText(r7.getTitle());
        r8.setTag(r7);
        r8.setOnClickListener(r17);
        r11 = r17.mUpMoreContent;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x016c, code lost:
        if (r11 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x016e, code lost:
        r11.addView(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0173, code lost:
        if (r5 != (r4 - 1)) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0175, code lost:
        r8.findViewById(tv.danmaku.bili.ui.rank.R.id.gap).setVisibility(8);
        r11 = new android.view.View(r3);
        r11.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, com.bilibili.app.comm.list.widget.utils.ListExtentionsKt.toPx(9)));
        r12 = r17.mUpMoreContent;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0194, code lost:
        if (r12 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0196, code lost:
        r12.addView(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0199, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x019c, code lost:
        r4 = r17.mUpMoreContain;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x019e, code lost:
        if (r4 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01a0, code lost:
        r4.setVisibility(0);
     */
    @Override // tv.danmaku.bili.ui.rank.view.ViewHolderBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bind(RankModel video2, WeakReference<RankVideoListFragment> weakReference) {
        VectorTextView vectorTextView;
        VectorTextView vectorTextView2;
        VectorTextView vectorTextView3;
        Intrinsics.checkNotNullParameter(weakReference, "fragment");
        if (video2 == null) {
            return;
        }
        this.mFragment = weakReference;
        BiliImageView biliImageView = this.mCover;
        if (biliImageView != null) {
            ImageExtentionKt.displayImage$default(biliImageView, video2.getCover(), (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, (BitmapTransformation) null, false, (int) IjkMediaPlayerTracker.BLIJK_EV_BUFFERING_START, (Object) null);
        }
        setRankAppearance(getRank());
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(video2.getTitle());
        }
        TextView textView2 = this.mDuration;
        if (textView2 != null) {
            textView2.setText(ViewHolderBase.formatTimeWithHour(video2.getDuration() * 1000));
        }
        VectorTextView vectorTextView4 = this.mUpName;
        if (vectorTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUpName");
            vectorTextView = null;
        } else {
            vectorTextView = vectorTextView4;
        }
        ListExtentionsKt.setTextWithIcon$default(vectorTextView, video2.getName(), 25, com.bilibili.lib.theme.R.color.Ga5, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 48, (Object) null);
        VectorTextView vectorTextView5 = this.mPlayNum;
        if (vectorTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayNum");
            vectorTextView2 = null;
        } else {
            vectorTextView2 = vectorTextView5;
        }
        ListExtentionsKt.setTextWithIcon$default(vectorTextView2, video2.getPlayText(), video2.getPlayIcon(), com.bilibili.lib.theme.R.color.Ga5, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 48, (Object) null);
        VectorTextView vectorTextView6 = this.mDanmakuNum;
        if (vectorTextView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDanmakuNum");
            vectorTextView3 = null;
        } else {
            vectorTextView3 = vectorTextView6;
        }
        ListExtentionsKt.setTextWithIcon$default(vectorTextView3, NumberFormat_androidKt.format$default(Integer.valueOf(video2.getDanmaku()), "-", 0, 2, (Object) null), 3, com.bilibili.lib.theme.R.color.Ga5, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 48, (Object) null);
        Context context = this.itemView.getContext();
        if (video2.getChildrenList() != null) {
            List<Item> childrenList = video2.getChildrenList();
            Intrinsics.checkNotNullExpressionValue(childrenList, "getChildrenList(...)");
            if (!childrenList.isEmpty() && context != null) {
                LinearLayout linearLayout = this.mUpMoreContent;
                if (linearLayout != null) {
                    linearLayout.setVisibility(ListExtentionsKt.toVisibility(video2.getShowMore()));
                }
                LinearLayout linearLayout2 = this.mUpMoreContain;
                if (linearLayout2 != null) {
                    linearLayout2.setTag(video2);
                }
                updateMoreContainer(video2);
                if (this.mUpMoreContent != null) {
                    LinearLayout linearLayout3 = this.mUpMoreContent;
                    Integer valueOf = linearLayout3 != null ? Integer.valueOf(linearLayout3.getChildCount()) : null;
                    Intrinsics.checkNotNull(valueOf);
                }
                ForegroundRelativeLayout foregroundRelativeLayout = this.mVideoLayout;
            }
        }
        LinearLayout linearLayout4 = this.mUpMoreContain;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        LinearLayout linearLayout5 = this.mUpMoreContent;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        ForegroundRelativeLayout foregroundRelativeLayout2 = this.mVideoLayout;
        if (foregroundRelativeLayout2 != null) {
            foregroundRelativeLayout2.setTag(video2);
        }
        FixedPopupAnchor fixedPopupAnchor = this.mAnchorMore;
        if (fixedPopupAnchor != null) {
            fixedPopupAnchor.setTag(video2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int viewId = v.getId();
        Context context = v.getContext();
        Object tag = v.getTag();
        if (viewId == R.id.video_layout) {
            if (tag instanceof RankModel) {
                RankingReport.reportRankingVideoClick(this.mTitle, ((RankModel) tag).getParam(), String.valueOf(getRank()));
                NeuronsEventKt.reportNeuronClick(NeuronsEventKt.RANK_VIDEO_CARD_CLICK, MapsKt.mapOf(new Pair[]{TuplesKt.to(WatchLaterReporterKt.KEY_TAB_NAME, this.mTitle), TuplesKt.to("avid", ((RankModel) tag).getParam()), TuplesKt.to("rank", String.valueOf(getRank()))}));
                if (Intrinsics.areEqual(ViewHolderUgcKt.GOTO_BANGUMI, ((RankModel) tag).getGoto())) {
                    Intrinsics.checkNotNull(context);
                    RankRouter.gotoPgcDetail(context, ((RankModel) tag).getUri());
                    return;
                }
                Intrinsics.checkNotNull(context);
                RankRouter.gotoVideoDetail(context, ((RankModel) tag).getUri(), ((RankModel) tag).getCover());
            }
        } else if (viewId == R.id.up_more_contain) {
            if (tag instanceof RankModel) {
                ((RankModel) tag).setShowMore(!((RankModel) tag).getShowMore());
                updateMoreContainer((RankModel) tag);
                LinearLayout linearLayout = this.mUpMoreContent;
                if (linearLayout != null) {
                    linearLayout.setVisibility(ListExtentionsKt.toVisibility(((RankModel) tag).getShowMore()));
                }
            }
        } else if (viewId == R.id.anchor_more) {
            if (tag instanceof RankModel) {
                RankingReport.reportRankingMoreClick(this.mTitle, "1");
                if (isFragmentEnabled()) {
                    showPromoMenu(this.mAnchorMore, ((RankModel) tag).getParam());
                }
            }
        } else if (viewId == R.id.more_sub) {
            if (tag instanceof Item) {
                RankingReport.reportRankingMoreClick(this.mTitle, "1");
                if (isFragmentEnabled()) {
                    showPromoMenu(v, ((Item) tag).getParam());
                }
            }
        } else if (tag instanceof Item) {
            if (Intrinsics.areEqual(ViewHolderUgcKt.GOTO_BANGUMI, ((Item) tag).getGoto())) {
                Intrinsics.checkNotNull(context);
                RankRouter.gotoPgcDetail(context, ((Item) tag).getUri());
                return;
            }
            Intrinsics.checkNotNull(context);
            RankRouter.gotoVideoDetail(context, ((Item) tag).getUri(), ((Item) tag).getCover());
        }
    }

    private final void updateMoreContainer(RankModel video2) {
        float f;
        String str;
        Resources resources;
        int i;
        TextView textView = this.mUpMoreText;
        if (textView != null) {
            TextView textView2 = this.mUpMoreText;
            if (textView2 == null || (resources = textView2.getResources()) == null) {
                str = null;
            } else {
                if (video2.getShowMore()) {
                    i = bili.resource.homepage.R.string.homepage_global_string_104;
                } else {
                    i = bili.resource.homepage.R.string.homepage_global_string_101;
                }
                str = resources.getString(i);
            }
            textView.setText(str);
        }
        ImageView imageView = this.mUpMoreExpand;
        if (imageView != null) {
            if (video2.getShowMore()) {
                f = 180.0f;
            } else {
                f = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
            }
            imageView.setRotation(f);
        }
    }

    private final void setRankAppearance(int rank) {
        TextView textView = this.mRankNum;
        if (textView != null) {
            textView.setText("");
        }
        switch (rank) {
            case 1:
                TextView textView2 = this.mRankNum;
                if (textView2 != null) {
                    textView2.setBackgroundResource(R.drawable.ic_rank_new_number_1);
                    return;
                }
                return;
            case 2:
                TextView textView3 = this.mRankNum;
                if (textView3 != null) {
                    textView3.setBackgroundResource(R.drawable.ic_rank_new_number_2);
                    return;
                }
                return;
            case 3:
                TextView textView4 = this.mRankNum;
                if (textView4 != null) {
                    textView4.setBackgroundResource(R.drawable.ic_rank_new_number_3);
                    return;
                }
                return;
            default:
                TextView textView5 = this.mRankNum;
                if (textView5 != null) {
                    textView5.setBackgroundResource(R.drawable.ic_rank_new_number_x);
                }
                TextView textView6 = this.mRankNum;
                if (textView6 != null) {
                    textView6.setText(String.valueOf(rank));
                    return;
                }
                return;
        }
    }
}