package tv.danmaku.bili.dislikefeedback;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.base.BiliContext;
import com.bilibili.dislikefeedback.R;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.pvtracker.PageViewTracker;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.dislikefeedback.DislikeFeedbackDialog;
import tv.danmaku.bili.dislikefeedback.actionsheeet.ActionSheetItemView;
import tv.danmaku.bili.dislikefeedback.data.DifferentiatedParams;
import tv.danmaku.bili.dislikefeedback.data.DislikeReason;
import tv.danmaku.bili.dislikefeedback.data.PageInfoParams;
import tv.danmaku.bili.dislikefeedback.data.VideoInfoParams;
import tv.danmaku.bili.dislikefeedback.remote.DislikeFeedbackRemoteService;
import tv.danmaku.bili.dislikefeedback.router.Router;
import tv.danmaku.bili.dislikefeedback.utils.DislikeFeedbackHelper;
import tv.danmaku.bili.quick.LoginQualityMonitor;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: DislikeFeedbackDialog.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0003012B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020\u001eH\u0014J+\u0010(\u001a\u00020\u001e2#\u0010)\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001aJ+\u0010+\u001a\u00020\u001e2#\u0010)\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001aJ\u0016\u0010-\u001a\u00020\u001e2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010!J\u0016\u0010.\u001a\u00020\u001e2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010!J\u0016\u0010/\u001a\u00020\u001e2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010!R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0014j\b\u0012\u0004\u0012\u00020\u0018`\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/DislikeFeedbackDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "context", "Landroid/content/Context;", "reportData", "", "reasons", "Ltv/danmaku/bili/dislikefeedback/data/DislikeReason;", "videoInfoParams", "Ltv/danmaku/bili/dislikefeedback/data/VideoInfoParams;", "pageInfoParams", "Ltv/danmaku/bili/dislikefeedback/data/PageInfoParams;", "differentiatedParams", "Ltv/danmaku/bili/dislikefeedback/data/DifferentiatedParams;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ltv/danmaku/bili/dislikefeedback/data/DislikeReason;Ltv/danmaku/bili/dislikefeedback/data/VideoInfoParams;Ltv/danmaku/bili/dislikefeedback/data/PageInfoParams;Ltv/danmaku/bili/dislikefeedback/data/DifferentiatedParams;)V", "mActionSheetItemHeightPx", "", "mRecyclerItemSpacePx", "mFeedbackList", "Ljava/util/ArrayList;", "Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$FeedbackItem;", "Lkotlin/collections/ArrayList;", "mDislikeList", "Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$DislikeItem;", "mDislikeItemClickedFunc", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "item", "", "mFeedbackItemClickedFunc", "mUserFeedbackClickedFunc", "Lkotlin/Function0;", "mPlayerFeedbackClickedFunc", "mReportClickedFunc", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setDislikeItemClickedFunc", "func", "dislikeItem", "setFeedbackItemClickedFunc", "feedbackItem", "setUserFeedbackClickedFunc", "setPlayerFeedbackClickedFunc", "setReportClickedFunc", "ItemDecoration", "DislikeAdapter", "FeedbackAdapter", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DislikeFeedbackDialog extends BottomSheetDialog {
    private final DifferentiatedParams differentiatedParams;
    private final int mActionSheetItemHeightPx;
    private Function1<? super DislikeReason.DislikeItem, Unit> mDislikeItemClickedFunc;
    private final ArrayList<DislikeReason.DislikeItem> mDislikeList;
    private Function1<? super DislikeReason.FeedbackItem, Unit> mFeedbackItemClickedFunc;
    private final ArrayList<DislikeReason.FeedbackItem> mFeedbackList;
    private Function0<Unit> mPlayerFeedbackClickedFunc;
    private final int mRecyclerItemSpacePx;
    private Function0<Unit> mReportClickedFunc;
    private Function0<Unit> mUserFeedbackClickedFunc;
    private final PageInfoParams pageInfoParams;
    private final DislikeReason reasons;
    private final String reportData;
    private final VideoInfoParams videoInfoParams;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DislikeFeedbackDialog(Context context, String reportData, DislikeReason reasons, VideoInfoParams videoInfoParams, PageInfoParams pageInfoParams, DifferentiatedParams differentiatedParams) {
        super(context, R.style.DislikeDisableDimBottomDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reasons, "reasons");
        Intrinsics.checkNotNullParameter(videoInfoParams, "videoInfoParams");
        Intrinsics.checkNotNullParameter(pageInfoParams, "pageInfoParams");
        Intrinsics.checkNotNullParameter(differentiatedParams, "differentiatedParams");
        this.reportData = reportData;
        this.reasons = reasons;
        this.videoInfoParams = videoInfoParams;
        this.pageInfoParams = pageInfoParams;
        this.differentiatedParams = differentiatedParams;
        this.mActionSheetItemHeightPx = (int) DislikeFeedbackHelper.INSTANCE.dp2px(40, context);
        this.mRecyclerItemSpacePx = (int) DislikeFeedbackHelper.INSTANCE.dp2px(4, context);
        this.mFeedbackList = new ArrayList<>();
        this.mDislikeList = new ArrayList<>();
        setContentView(R.layout.dislike_feedback_dialog);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ItemDecoration itemDecoration = new ItemDecoration(this.mRecyclerItemSpacePx, 0, this.mRecyclerItemSpacePx, 0);
        onCreate$initDislikeRecyclerView(this, itemDecoration);
        onCreate$initFeedbackRecyclerView(this, itemDecoration);
        onCreate$initActionSheets(this);
    }

    private static final void onCreate$dislike(DislikeFeedbackDialog this$0, Map<String, String> map) {
        String str;
        String accessKey = BiliAccounts.get(BiliContext.application()).getAccessKey();
        String str2 = accessKey;
        boolean z = false;
        if (!(str2 == null || StringsKt.isBlank(str2))) {
            map.put("access_key", accessKey);
        }
        map.put("id", String.valueOf(this$0.videoInfoParams.getAvid()));
        String it = this$0.pageInfoParams.getGoto();
        if (it != null) {
            map.put("goto", it);
        }
        String spmid = this$0.pageInfoParams.getSpmid();
        if (!StringsKt.isBlank(spmid)) {
            map.put("from_spmid", spmid);
            map.put(FavoritesConstsKt.SPMID, spmid);
        }
        String actionId = PageViewTracker.getInstance().currentPolarisActionId();
        if (actionId != null && (StringsKt.isBlank(actionId) ^ true)) {
            map.put(FavoritesConstsKt.ACTION_ID, actionId);
        }
        String trackId = this$0.pageInfoParams.getTrackId();
        if (trackId == null) {
            trackId = "";
        }
        map.put("track_id", trackId);
        if (this$0.reportData != null && (!StringsKt.isBlank(str))) {
            z = true;
        }
        if (z) {
            map.put("report_data", this$0.reportData);
        }
        if (this$0.pageInfoParams.isNatureAd()) {
            map.put("nature_ad", LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR);
        }
        ((DislikeFeedbackRemoteService) ServiceGenerator.createService(DislikeFeedbackRemoteService.class)).dislikeOrFeedback(map).enqueue();
    }

    private static final void onCreate$initDislikeRecyclerView(final DislikeFeedbackDialog this$0, ItemDecoration itemDecoration) {
        List list;
        RecyclerView recyclerView = this$0.findViewById(R.id.dislike_recycler);
        if (recyclerView == null) {
            return;
        }
        TextView titleView = (TextView) this$0.findViewById(R.id.dislike_title);
        ArrayList $this$onCreate_u24initDislikeRecyclerView_u24lambda_u241 = this$0.mDislikeList;
        DislikeReason.DislikeGroup dislikeGroup = this$0.reasons.getDislikeGroup();
        boolean z = true;
        if (dislikeGroup != null && (list = dislikeGroup.getDislikeItems()) != null) {
            for (DislikeReason.DislikeItem dislikeItem : list) {
                String title = dislikeItem.getTitle();
                if (!(title == null || StringsKt.isBlank(title))) {
                    $this$onCreate_u24initDislikeRecyclerView_u24lambda_u241.add(dislikeItem);
                }
            }
        }
        if (this$0.mDislikeList.size() > 0) {
            recyclerView.setVisibility(0);
            DislikeReason.DislikeGroup dislikeGroup2 = this$0.reasons.getDislikeGroup();
            String dislikeTitle = dislikeGroup2 != null ? dislikeGroup2.getTitle() : null;
            String str = dislikeTitle;
            if (str != null && !StringsKt.isBlank(str)) {
                z = false;
            }
            if (z) {
                if (titleView != null) {
                    titleView.setVisibility(8);
                }
            } else {
                if (titleView != null) {
                    titleView.setVisibility(0);
                }
                if (titleView != null) {
                    titleView.setText(dislikeTitle);
                }
            }
            RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
            linearLayoutManager.setOrientation(0);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(new DislikeAdapter(this$0.mDislikeList, this$0.mRecyclerItemSpacePx, this$0.mDislikeItemClickedFunc, new Function1() { // from class: tv.danmaku.bili.dislikefeedback.DislikeFeedbackDialog$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit onCreate$initDislikeRecyclerView$lambda$2$1;
                    onCreate$initDislikeRecyclerView$lambda$2$1 = DislikeFeedbackDialog.onCreate$initDislikeRecyclerView$lambda$2$1(DislikeFeedbackDialog.this, (DislikeReason.DislikeItem) obj);
                    return onCreate$initDislikeRecyclerView$lambda$2$1;
                }
            }));
            recyclerView.addItemDecoration(itemDecoration);
            return;
        }
        recyclerView.setVisibility(8);
        if (titleView != null) {
            titleView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$initDislikeRecyclerView$lambda$2$1(DislikeFeedbackDialog this$0, DislikeReason.DislikeItem dislikeItem) {
        Intrinsics.checkNotNullParameter(dislikeItem, "dislikeItem");
        Map params = new LinkedHashMap();
        if (dislikeItem.getUpperMid() > 0) {
            params.put("mid", String.valueOf(dislikeItem.getUpperMid()));
        }
        if (dislikeItem.getRid() > 0) {
            params.put("rid", String.valueOf(dislikeItem.getRid()));
        }
        if (dislikeItem.getTagId() > 0) {
            params.put("tag_id", String.valueOf(dislikeItem.getTagId()));
        }
        if (dislikeItem.getId() > 0) {
            params.put("reason_id", String.valueOf(dislikeItem.getId()));
        }
        onCreate$dislike(this$0, params);
        this$0.dismiss();
        return Unit.INSTANCE;
    }

    private static final void onCreate$initFeedbackRecyclerView(final DislikeFeedbackDialog this$0, ItemDecoration itemDecoration) {
        List list;
        RecyclerView recyclerView = this$0.findViewById(R.id.feedback_recycler);
        if (recyclerView == null) {
            return;
        }
        TextView titleView = (TextView) this$0.findViewById(R.id.feedback_title);
        ArrayList $this$onCreate_u24initFeedbackRecyclerView_u24lambda_u243 = this$0.mFeedbackList;
        DislikeReason.FeedbackGroup feedbackGroup = this$0.reasons.getFeedbackGroup();
        boolean z = true;
        if (feedbackGroup != null && (list = feedbackGroup.getFeedbackItems()) != null) {
            for (DislikeReason.FeedbackItem feedbackItem : list) {
                String title = feedbackItem.getTitle();
                if (!(title == null || StringsKt.isBlank(title))) {
                    $this$onCreate_u24initFeedbackRecyclerView_u24lambda_u243.add(feedbackItem);
                }
            }
        }
        if (this$0.mFeedbackList.size() > 0) {
            recyclerView.setVisibility(0);
            DislikeReason.FeedbackGroup feedbackGroup2 = this$0.reasons.getFeedbackGroup();
            String feedbackTitle = feedbackGroup2 != null ? feedbackGroup2.getTitle() : null;
            String str = feedbackTitle;
            if (str != null && !StringsKt.isBlank(str)) {
                z = false;
            }
            if (z) {
                if (titleView != null) {
                    titleView.setVisibility(8);
                }
            } else {
                if (titleView != null) {
                    titleView.setVisibility(0);
                }
                if (titleView != null) {
                    titleView.setText(feedbackTitle);
                }
            }
            RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
            linearLayoutManager.setOrientation(0);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(new FeedbackAdapter(this$0.mFeedbackList, this$0.mRecyclerItemSpacePx, this$0.mFeedbackItemClickedFunc, new Function1() { // from class: tv.danmaku.bili.dislikefeedback.DislikeFeedbackDialog$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    Unit onCreate$initFeedbackRecyclerView$lambda$4$1;
                    onCreate$initFeedbackRecyclerView$lambda$4$1 = DislikeFeedbackDialog.onCreate$initFeedbackRecyclerView$lambda$4$1(DislikeFeedbackDialog.this, (DislikeReason.FeedbackItem) obj);
                    return onCreate$initFeedbackRecyclerView$lambda$4$1;
                }
            }));
            recyclerView.addItemDecoration(itemDecoration);
            return;
        }
        recyclerView.setVisibility(8);
        if (titleView != null) {
            titleView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$initFeedbackRecyclerView$lambda$4$1(DislikeFeedbackDialog this$0, DislikeReason.FeedbackItem feedbackItem) {
        Intrinsics.checkNotNullParameter(feedbackItem, "feedbackItem");
        Map params = new LinkedHashMap();
        if (feedbackItem.getUpperMid() > 0) {
            params.put("mid", String.valueOf(feedbackItem.getUpperMid()));
        }
        if (feedbackItem.getRid() > 0) {
            params.put("rid", String.valueOf(feedbackItem.getRid()));
        }
        if (feedbackItem.getTagId() > 0) {
            params.put("tag_id", String.valueOf(feedbackItem.getTagId()));
        }
        if (feedbackItem.getId() > 0) {
            params.put("feedback_id", String.valueOf(feedbackItem.getId()));
        }
        onCreate$dislike(this$0, params);
        this$0.dismiss();
        return Unit.INSTANCE;
    }

    private static final void onCreate$initActionSheets(DislikeFeedbackDialog this$0) {
        LinearLayout actionSheetsViewGroup = (LinearLayout) this$0.findViewById(R.id.action_sheets);
        if (actionSheetsViewGroup == null) {
            return;
        }
        View space = this$0.findViewById(R.id.space);
        if (!this$0.differentiatedParams.getShouldShowActionSheet()) {
            actionSheetsViewGroup.setVisibility(8);
            if (space != null) {
                space.setVisibility(0);
                return;
            }
            return;
        }
        List actionSheets = this$0.reasons.getActionSheets();
        List list = actionSheets;
        if (list == null || list.isEmpty()) {
            actionSheetsViewGroup.setVisibility(8);
            if (space != null) {
                space.setVisibility(0);
                return;
            }
            return;
        }
        actionSheetsViewGroup.setVisibility(0);
        if (space != null) {
            space.setVisibility(8);
        }
        int lastIndex = actionSheets.size() - 1;
        int index = 0;
        int size = actionSheets.size();
        while (index < size) {
            DislikeReason.ActionSheet itemDate = actionSheets.get(index);
            ActionSheetItemView itemView = onCreate$initActionSheets$getActionSheetItemView(this$0, itemDate.getRecognizedName(), itemDate.getTitle(), this$0.videoInfoParams, this$0.pageInfoParams);
            if (itemView != null) {
                actionSheetsViewGroup.addView((View) itemView);
                lastIndex--;
                ViewGroup.LayoutParams $this$onCreate_u24initActionSheets_u24lambda_u249_u240 = itemView.getLayoutParams();
                $this$onCreate_u24initActionSheets_u24lambda_u249_u240.height = this$0.mActionSheetItemHeightPx;
                $this$onCreate_u24initActionSheets_u24lambda_u249_u240.width = -1;
                itemView.setShouldDrawBottomLine(index != lastIndex);
                itemView.setData(itemDate);
            }
            index++;
        }
    }

    private static final ActionSheetItemView onCreate$initActionSheets$getActionSheetItemView(final DislikeFeedbackDialog this$0, String recognizedName, String title, final VideoInfoParams videoInfoParams, final PageInfoParams pageInfoParams) {
        String str = title;
        if ((str == null || StringsKt.isBlank(str)) || recognizedName == null) {
            return null;
        }
        switch (recognizedName.hashCode()) {
            case -934521548:
                if (recognizedName.equals("report")) {
                    Context context = this$0.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    final ActionSheetItemView $this$onCreate_u24initActionSheets_u24getActionSheetItemView_u24lambda_u247 = new ActionSheetItemView(context);
                    $this$onCreate_u24initActionSheets_u24getActionSheetItemView_u24lambda_u247.setDefaultDrawableResId(R.drawable.report);
                    $this$onCreate_u24initActionSheets_u24getActionSheetItemView_u24lambda_u247.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.dislikefeedback.DislikeFeedbackDialog$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            DislikeFeedbackDialog.onCreate$initActionSheets$getActionSheetItemView$lambda$7$0(DislikeFeedbackDialog.this, $this$onCreate_u24initActionSheets_u24getActionSheetItemView_u24lambda_u247, videoInfoParams, view);
                        }
                    });
                    return $this$onCreate_u24initActionSheets_u24getActionSheetItemView_u24lambda_u247;
                }
                return null;
            case 37459783:
                if (recognizedName.equals("user-feedback")) {
                    Context context2 = this$0.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                    final ActionSheetItemView $this$onCreate_u24initActionSheets_u24getActionSheetItemView_u24lambda_u245 = new ActionSheetItemView(context2);
                    $this$onCreate_u24initActionSheets_u24getActionSheetItemView_u24lambda_u245.setDefaultDrawableResId(R.drawable.user_feedback);
                    $this$onCreate_u24initActionSheets_u24getActionSheetItemView_u24lambda_u245.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.dislikefeedback.DislikeFeedbackDialog$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            DislikeFeedbackDialog.onCreate$initActionSheets$getActionSheetItemView$lambda$5$0(DislikeFeedbackDialog.this, $this$onCreate_u24initActionSheets_u24getActionSheetItemView_u24lambda_u245, view);
                        }
                    });
                    return $this$onCreate_u24initActionSheets_u24getActionSheetItemView_u24lambda_u245;
                }
                return null;
            case 666403057:
                if (recognizedName.equals("player-feedback")) {
                    Context context3 = this$0.getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                    final ActionSheetItemView $this$onCreate_u24initActionSheets_u24getActionSheetItemView_u24lambda_u246 = new ActionSheetItemView(context3);
                    $this$onCreate_u24initActionSheets_u24getActionSheetItemView_u24lambda_u246.setDefaultDrawableResId(R.drawable.player_feedback);
                    $this$onCreate_u24initActionSheets_u24getActionSheetItemView_u24lambda_u246.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.dislikefeedback.DislikeFeedbackDialog$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            DislikeFeedbackDialog.onCreate$initActionSheets$getActionSheetItemView$lambda$6$0(DislikeFeedbackDialog.this, $this$onCreate_u24initActionSheets_u24getActionSheetItemView_u24lambda_u246, videoInfoParams, pageInfoParams, view);
                        }
                    });
                    return $this$onCreate_u24initActionSheets_u24getActionSheetItemView_u24lambda_u246;
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$initActionSheets$getActionSheetItemView$lambda$5$0(DislikeFeedbackDialog this$0, ActionSheetItemView $this_apply, View it) {
        Function0 func = this$0.mUserFeedbackClickedFunc;
        if (func != null) {
            func.invoke();
        }
        Router.gotoUserFeedback($this_apply.getContext());
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$initActionSheets$getActionSheetItemView$lambda$6$0(DislikeFeedbackDialog this$0, ActionSheetItemView $this_apply, VideoInfoParams $videoInfoParams, PageInfoParams $pageInfoParams, View it) {
        Function0 func = this$0.mPlayerFeedbackClickedFunc;
        if (func != null) {
            func.invoke();
        }
        Context context = $this_apply.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Router.gotoPlayerFeedback(context, $videoInfoParams.getAvid(), $videoInfoParams.getCid(), $pageInfoParams.getSpmid(), $pageInfoParams.getFromSpmid());
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$initActionSheets$getActionSheetItemView$lambda$7$0(DislikeFeedbackDialog this$0, ActionSheetItemView $this_apply, VideoInfoParams $videoInfoParams, View it) {
        Function0 func = this$0.mReportClickedFunc;
        if (func != null) {
            func.invoke();
        }
        Router.gotoAppeal($this_apply.getContext(), $videoInfoParams.getAvid(), $videoInfoParams.getBvid());
        this$0.dismiss();
    }

    protected void onStart() {
        super.onStart();
        getBehavior().setState(3);
    }

    public final void setDislikeItemClickedFunc(Function1<? super DislikeReason.DislikeItem, Unit> function1) {
        this.mDislikeItemClickedFunc = function1;
    }

    public final void setFeedbackItemClickedFunc(Function1<? super DislikeReason.FeedbackItem, Unit> function1) {
        this.mFeedbackItemClickedFunc = function1;
    }

    public final void setUserFeedbackClickedFunc(Function0<Unit> function0) {
        this.mUserFeedbackClickedFunc = function0;
    }

    public final void setPlayerFeedbackClickedFunc(Function0<Unit> function0) {
        this.mPlayerFeedbackClickedFunc = function0;
    }

    public final void setReportClickedFunc(Function0<Unit> function0) {
        this.mReportClickedFunc = function0;
    }

    /* compiled from: DislikeFeedbackDialog.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/DislikeFeedbackDialog$ItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "left", "", "top", "right", "bottom", "<init>", "(IIII)V", "getLeft", "()I", "getTop", "getRight", "getBottom", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", AuthResultCbHelper.ARGS_STATE, "Landroidx/recyclerview/widget/RecyclerView$State;", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static final class ItemDecoration extends RecyclerView.ItemDecoration {
        private final int bottom;
        private final int left;
        private final int right;
        private final int top;

        public ItemDecoration(int left, int top, int right, int bottom) {
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getTop() {
            return this.top;
        }

        public final int getBottom() {
            return this.bottom;
        }

        public final int getRight() {
            return this.right;
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
            outRect.left = this.left;
            outRect.top = this.top;
            outRect.right = this.right;
            outRect.bottom = this.bottom;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DislikeFeedbackDialog.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 Bg\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012#\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\t\u0012#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R.\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R.\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006!"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/DislikeFeedbackDialog$DislikeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltv/danmaku/bili/dislikefeedback/DislikeFeedbackDialog$DislikeAdapter$ViewHolder;", "dislikeList", "", "Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$DislikeItem;", "itemSpace", "", "itemClickedCallbackFunc", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "dislikeItem", "", "itemClickFunc", "<init>", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getDislikeList", "()Ljava/util/List;", "getItemSpace", "()I", "getItemClickedCallbackFunc", "()Lkotlin/jvm/functions/Function1;", "getItemClickFunc", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "ViewHolder", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class DislikeAdapter extends RecyclerView.Adapter<ViewHolder> {
        private final List<DislikeReason.DislikeItem> dislikeList;
        private final Function1<DislikeReason.DislikeItem, Unit> itemClickFunc;
        private final Function1<DislikeReason.DislikeItem, Unit> itemClickedCallbackFunc;
        private final int itemSpace;

        /* JADX WARN: Multi-variable type inference failed */
        public DislikeAdapter(List<DislikeReason.DislikeItem> list, int itemSpace, Function1<? super DislikeReason.DislikeItem, Unit> function1, Function1<? super DislikeReason.DislikeItem, Unit> function12) {
            Intrinsics.checkNotNullParameter(list, "dislikeList");
            this.dislikeList = list;
            this.itemSpace = itemSpace;
            this.itemClickedCallbackFunc = function1;
            this.itemClickFunc = function12;
        }

        public final List<DislikeReason.DislikeItem> getDislikeList() {
            return this.dislikeList;
        }

        public final int getItemSpace() {
            return this.itemSpace;
        }

        public final Function1<DislikeReason.DislikeItem, Unit> getItemClickedCallbackFunc() {
            return this.itemClickedCallbackFunc;
        }

        public final Function1<DislikeReason.DislikeItem, Unit> getItemClickFunc() {
            return this.itemClickFunc;
        }

        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dislike_recycler_item, parent, false);
            Intrinsics.checkNotNullExpressionValue(view, "inflate(...)");
            int width = (((parent.getMeasuredWidth() - parent.getPaddingLeft()) - parent.getPaddingRight()) / 4) - (this.itemSpace * 2);
            ViewHolder $this$onCreateViewHolder_u24lambda_u240 = new ViewHolder(view);
            if (width > DislikeFeedbackHelper.INSTANCE.dp2px(60, view.getContext())) {
                $this$onCreateViewHolder_u24lambda_u240.itemView.getLayoutParams().width = width;
            }
            return $this$onCreateViewHolder_u24lambda_u240;
        }

        public void onBindViewHolder(final ViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            final DislikeReason.DislikeItem dislikeItem = this.dislikeList.get(position);
            String iconUrl = dislikeItem.getIcon();
            if (iconUrl == null) {
                return;
            }
            Function0 showDefaultIconFunc = new Function0() { // from class: tv.danmaku.bili.dislikefeedback.DislikeFeedbackDialog$DislikeAdapter$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit onBindViewHolder$lambda$0;
                    onBindViewHolder$lambda$0 = DislikeFeedbackDialog.DislikeAdapter.onBindViewHolder$lambda$0(DislikeFeedbackDialog.DislikeAdapter.ViewHolder.this);
                    return onBindViewHolder$lambda$0;
                }
            };
            DislikeFeedbackHelper dislikeFeedbackHelper = DislikeFeedbackHelper.INSTANCE;
            View view = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "itemView");
            Context context = holder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            dislikeFeedbackHelper.loadDrawable(view, context, iconUrl, new Function1() { // from class: tv.danmaku.bili.dislikefeedback.DislikeFeedbackDialog$DislikeAdapter$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit onBindViewHolder$lambda$1;
                    onBindViewHolder$lambda$1 = DislikeFeedbackDialog.DislikeAdapter.onBindViewHolder$lambda$1(DislikeFeedbackDialog.DislikeAdapter.ViewHolder.this, (Drawable) obj);
                    return onBindViewHolder$lambda$1;
                }
            }, showDefaultIconFunc);
            holder.getDislikeTitle().setText(dislikeItem.getTitle());
            holder.getDislikeSubTitle().setText(dislikeItem.getSubTitle());
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.dislikefeedback.DislikeFeedbackDialog$DislikeAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DislikeFeedbackDialog.DislikeAdapter.onBindViewHolder$lambda$2(DislikeFeedbackDialog.DislikeAdapter.this, dislikeItem, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onBindViewHolder$lambda$0(ViewHolder $holder) {
            $holder.getIcon().setImageDrawable(ContextCompat.getDrawable($holder.itemView.getContext(), R.drawable.bili_rect_r4_ga2));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onBindViewHolder$lambda$1(ViewHolder $holder, Drawable icon) {
            Intrinsics.checkNotNullParameter(icon, "icon");
            $holder.getIcon().setImageDrawable(icon);
            $holder.getIcon().setBackgroundResource(0);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBindViewHolder$lambda$2(DislikeAdapter this$0, DislikeReason.DislikeItem $dislikeItem, View it) {
            Function1 click = this$0.itemClickFunc;
            if (click != null) {
                click.invoke($dislikeItem);
            }
            Function1 clicked = this$0.itemClickedCallbackFunc;
            if (clicked != null) {
                clicked.invoke($dislikeItem);
            }
        }

        public int getItemCount() {
            return this.dislikeList.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: DislikeFeedbackDialog.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/DislikeFeedbackDialog$DislikeAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "dislikeTitle", "Landroid/widget/TextView;", "getDislikeTitle", "()Landroid/widget/TextView;", "setDislikeTitle", "(Landroid/widget/TextView;)V", "dislikeSubTitle", "getDislikeSubTitle", "setDislikeSubTitle", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class ViewHolder extends RecyclerView.ViewHolder {
            private TextView dislikeSubTitle;
            private TextView dislikeTitle;
            private ImageView icon;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(View view) {
                super(view);
                Intrinsics.checkNotNullParameter(view, "view");
                View findViewById = view.findViewById(R.id.dislike_item_icon);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                this.icon = (ImageView) findViewById;
                View findViewById2 = view.findViewById(R.id.dislike_item_title);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
                this.dislikeTitle = (TextView) findViewById2;
                View findViewById3 = view.findViewById(R.id.dislike_item_sub_title);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
                this.dislikeSubTitle = (TextView) findViewById3;
            }

            public final ImageView getIcon() {
                return this.icon;
            }

            public final void setIcon(ImageView imageView) {
                Intrinsics.checkNotNullParameter(imageView, "<set-?>");
                this.icon = imageView;
            }

            public final TextView getDislikeTitle() {
                return this.dislikeTitle;
            }

            public final void setDislikeTitle(TextView textView) {
                Intrinsics.checkNotNullParameter(textView, "<set-?>");
                this.dislikeTitle = textView;
            }

            public final TextView getDislikeSubTitle() {
                return this.dislikeSubTitle;
            }

            public final void setDislikeSubTitle(TextView textView) {
                Intrinsics.checkNotNullParameter(textView, "<set-?>");
                this.dislikeSubTitle = textView;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DislikeFeedbackDialog.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 Bg\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012#\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\t\u0012#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R.\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R.\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006!"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/DislikeFeedbackDialog$FeedbackAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltv/danmaku/bili/dislikefeedback/DislikeFeedbackDialog$FeedbackAdapter$ViewHolder;", "dislikeList", "", "Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$FeedbackItem;", "itemSpace", "", "itemClickedCallbackFunc", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "feedbackItem", "", "itemClickFunc", "<init>", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getDislikeList", "()Ljava/util/List;", "getItemSpace", "()I", "getItemClickedCallbackFunc", "()Lkotlin/jvm/functions/Function1;", "getItemClickFunc", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "ViewHolder", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class FeedbackAdapter extends RecyclerView.Adapter<ViewHolder> {
        private final List<DislikeReason.FeedbackItem> dislikeList;
        private final Function1<DislikeReason.FeedbackItem, Unit> itemClickFunc;
        private final Function1<DislikeReason.FeedbackItem, Unit> itemClickedCallbackFunc;
        private final int itemSpace;

        /* JADX WARN: Multi-variable type inference failed */
        public FeedbackAdapter(List<DislikeReason.FeedbackItem> list, int itemSpace, Function1<? super DislikeReason.FeedbackItem, Unit> function1, Function1<? super DislikeReason.FeedbackItem, Unit> function12) {
            Intrinsics.checkNotNullParameter(list, "dislikeList");
            this.dislikeList = list;
            this.itemSpace = itemSpace;
            this.itemClickedCallbackFunc = function1;
            this.itemClickFunc = function12;
        }

        public final List<DislikeReason.FeedbackItem> getDislikeList() {
            return this.dislikeList;
        }

        public final int getItemSpace() {
            return this.itemSpace;
        }

        public final Function1<DislikeReason.FeedbackItem, Unit> getItemClickedCallbackFunc() {
            return this.itemClickedCallbackFunc;
        }

        public final Function1<DislikeReason.FeedbackItem, Unit> getItemClickFunc() {
            return this.itemClickFunc;
        }

        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feedback_recycler_item, parent, false);
            Intrinsics.checkNotNullExpressionValue(view, "inflate(...)");
            int width = (((parent.getMeasuredWidth() - parent.getPaddingLeft()) - parent.getPaddingRight()) / 4) - (this.itemSpace * 2);
            ViewHolder $this$onCreateViewHolder_u24lambda_u240 = new ViewHolder(view);
            if (width > DislikeFeedbackHelper.INSTANCE.dp2px(60, view.getContext())) {
                $this$onCreateViewHolder_u24lambda_u240.itemView.getLayoutParams().width = width;
            }
            return $this$onCreateViewHolder_u24lambda_u240;
        }

        public void onBindViewHolder(final ViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            final DislikeReason.FeedbackItem feedbackItem = this.dislikeList.get(position);
            String iconUrl = feedbackItem.getIcon();
            if (iconUrl == null) {
                return;
            }
            DislikeFeedbackHelper dislikeFeedbackHelper = DislikeFeedbackHelper.INSTANCE;
            View view = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "itemView");
            Context context = holder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            dislikeFeedbackHelper.loadDrawable(view, context, iconUrl, new Function1() { // from class: tv.danmaku.bili.dislikefeedback.DislikeFeedbackDialog$FeedbackAdapter$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit onBindViewHolder$lambda$0;
                    onBindViewHolder$lambda$0 = DislikeFeedbackDialog.FeedbackAdapter.onBindViewHolder$lambda$0(DislikeFeedbackDialog.FeedbackAdapter.ViewHolder.this, (Drawable) obj);
                    return onBindViewHolder$lambda$0;
                }
            }, new Function0() { // from class: tv.danmaku.bili.dislikefeedback.DislikeFeedbackDialog$FeedbackAdapter$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            });
            holder.getFeedbackTitle().setText(feedbackItem.getTitle());
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.dislikefeedback.DislikeFeedbackDialog$FeedbackAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DislikeFeedbackDialog.FeedbackAdapter.onBindViewHolder$lambda$2(DislikeFeedbackDialog.FeedbackAdapter.this, feedbackItem, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onBindViewHolder$lambda$0(ViewHolder $holder, Drawable icon) {
            Intrinsics.checkNotNullParameter(icon, "icon");
            $holder.getIcon().setImageDrawable(icon);
            $holder.getIcon().setBackgroundResource(0);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBindViewHolder$lambda$2(FeedbackAdapter this$0, DislikeReason.FeedbackItem $feedbackItem, View it) {
            Function1 click = this$0.itemClickFunc;
            if (click != null) {
                click.invoke($feedbackItem);
            }
            Function1 clicked = this$0.itemClickedCallbackFunc;
            if (clicked != null) {
                clicked.invoke($feedbackItem);
            }
        }

        public int getItemCount() {
            return this.dislikeList.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: DislikeFeedbackDialog.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/DislikeFeedbackDialog$FeedbackAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "feedbackTitle", "Landroid/widget/TextView;", "getFeedbackTitle", "()Landroid/widget/TextView;", "setFeedbackTitle", "(Landroid/widget/TextView;)V", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class ViewHolder extends RecyclerView.ViewHolder {
            private TextView feedbackTitle;
            private ImageView icon;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(View view) {
                super(view);
                Intrinsics.checkNotNullParameter(view, "view");
                View findViewById = view.findViewById(R.id.feedback_item_icon);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                this.icon = (ImageView) findViewById;
                View findViewById2 = view.findViewById(R.id.feedback_item_title);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
                this.feedbackTitle = (TextView) findViewById2;
            }

            public final ImageView getIcon() {
                return this.icon;
            }

            public final void setIcon(ImageView imageView) {
                Intrinsics.checkNotNullParameter(imageView, "<set-?>");
                this.icon = imageView;
            }

            public final TextView getFeedbackTitle() {
                return this.feedbackTitle;
            }

            public final void setFeedbackTitle(TextView textView) {
                Intrinsics.checkNotNullParameter(textView, "<set-?>");
                this.feedbackTitle = textView;
            }
        }
    }
}