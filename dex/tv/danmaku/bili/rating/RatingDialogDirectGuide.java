package tv.danmaku.bili.rating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.BaseDialog;

/* compiled from: RatingDialog.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/rating/RatingDialogDirectGuide;", "Ltv/danmaku/bili/widget/BaseDialog;", "context", "Landroid/content/Context;", "data", "Ltv/danmaku/bili/rating/DirectRatingGuide;", "count", "", "specialPage", "", "toMarket", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/Context;Ltv/danmaku/bili/rating/DirectRatingGuide;Ljava/lang/String;ILkotlin/jvm/functions/Function0;)V", "getToMarket", "()Lkotlin/jvm/functions/Function0;", "onCreateView", "Landroid/view/View;", "onViewCreated", "view", "setUiBeforeShow", "reportClick", "choice", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RatingDialogDirectGuide extends BaseDialog<RatingDialogDirectGuide> {
    public static final int $stable = 8;
    private final String count;
    private final DirectRatingGuide data;
    private final int specialPage;
    private final Function0<Unit> toMarket;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RatingDialogDirectGuide(Context context, DirectRatingGuide data, String count, int specialPage, Function0<Unit> function0) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(count, "count");
        Intrinsics.checkNotNullParameter(function0, "toMarket");
        this.data = data;
        this.count = count;
        this.specialPage = specialPage;
        this.toMarket = function0;
        widthScale(0.0f);
        setCanceledOnTouchOutside(true);
    }

    public final Function0<Unit> getToMarket() {
        return this.toMarket;
    }

    public View onCreateView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.bili_app_dialog_direct_guide, (ViewGroup) null);
        Intrinsics.checkNotNull(view);
        return view;
    }

    public void onViewCreated(View view) {
        String it;
        String it2;
        String it3;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view);
        View findViewById = view.findViewById(R.id.rating_dialog_tv_gostore);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        final TextView mTvGostore = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.rating_dialog_tv_feedback);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        final TextView mTvFeedback = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.rating_dialog_tv_next);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        final TextView mTvNext = (TextView) findViewById3;
        String it4 = this.data.getTitle();
        if (it4 != null) {
            ((TextView) view.findViewById(R.id.rating_dialog_tv_title)).setText(it4);
        }
        PopupButton cancelButton = this.data.getCancelButton();
        if (cancelButton != null && (it3 = cancelButton.getText()) != null) {
            mTvNext.setText(it3);
        }
        PopupButton gotoButton = this.data.getGotoButton();
        if (gotoButton != null && (it2 = gotoButton.getText()) != null) {
            mTvGostore.setText(it2);
        }
        PopupButton feedbackButton = this.data.getFeedbackButton();
        if (feedbackButton != null && (it = feedbackButton.getText()) != null) {
            mTvFeedback.setText(it);
        }
        mTvNext.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.rating.RatingDialogDirectGuide$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RatingDialogDirectGuide.onViewCreated$lambda$4(RatingDialogDirectGuide.this, mTvNext, view2);
            }
        });
        mTvGostore.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.rating.RatingDialogDirectGuide$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RatingDialogDirectGuide.onViewCreated$lambda$5(RatingDialogDirectGuide.this, mTvGostore, view2);
            }
        });
        mTvFeedback.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.rating.RatingDialogDirectGuide$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RatingDialogDirectGuide.onViewCreated$lambda$6(RatingDialogDirectGuide.this, mTvFeedback, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(RatingDialogDirectGuide this$0, TextView $mTvNext, View it) {
        this$0.dismiss();
        this$0.reportClick($mTvNext.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(RatingDialogDirectGuide this$0, TextView $mTvGostore, View it) {
        this$0.dismiss();
        this$0.reportClick($mTvGostore.getText().toString());
        this$0.toMarket.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$6(RatingDialogDirectGuide this$0, TextView $mTvFeedback, View it) {
        String it2;
        PopupButton feedbackButton = this$0.data.getFeedbackButton();
        if (feedbackButton != null && (it2 = feedbackButton.getUrl()) != null) {
            BLRouter.routeTo$default(RouteRequestKt.toRouteRequest(it2), (Context) null, 2, (Object) null);
        }
        this$0.dismiss();
        this$0.reportClick($mTvFeedback.getText().toString());
    }

    public void setUiBeforeShow() {
    }

    public final void reportClick(String choice) {
        Intrinsics.checkNotNullParameter(choice, "choice");
    }
}