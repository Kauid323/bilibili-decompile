package tv.danmaku.bili.rating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.bilibili.iconfont.KtxKt;
import com.bilibili.lib.neuron.api.Neurons;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.BaseDialog;

/* compiled from: RatingDialog.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/rating/RatingDialogGuide;", "Ltv/danmaku/bili/widget/BaseDialog;", "context", "Landroid/content/Context;", "data", "Ltv/danmaku/bili/rating/PopupBasicInfo;", "count", "", "specialPage", "", "toMarket", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/Context;Ltv/danmaku/bili/rating/PopupBasicInfo;Ljava/lang/String;ILkotlin/jvm/functions/Function0;)V", "getToMarket", "()Lkotlin/jvm/functions/Function0;", "onCreateView", "Landroid/view/View;", "onViewCreated", "view", "setUiBeforeShow", "reportClick", "choice", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RatingDialogGuide extends BaseDialog<RatingDialogGuide> {
    public static final int $stable = 8;
    private final String count;
    private final PopupBasicInfo data;
    private final int specialPage;
    private final Function0<Unit> toMarket;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RatingDialogGuide(Context context, PopupBasicInfo data, String count, int specialPage, Function0<Unit> function0) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
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
        View view = LayoutInflater.from(getContext()).inflate(R.layout.bili_app_dialog_guide, (ViewGroup) null);
        Intrinsics.checkNotNull(view);
        return view;
    }

    public void onViewCreated(View view) {
        String it;
        String it2;
        PopupButton it3;
        PopupButton it4;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view);
        View findViewById = view.findViewById(R.id.rating_dialog_fl_next);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        FrameLayout mFlNext = (FrameLayout) findViewById;
        CardView findViewById2 = view.findViewById(R.id.rating_dialog_card_gostore);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        CardView mCardToStore = findViewById2;
        View findViewById3 = view.findViewById(R.id.rating_dialog_tv_cancel_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        final TextView mTvCancelBtn = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.rating_dialog_tv_tostore_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        final TextView mTvConfirmBtn = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.rating_dialog_img_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        ImageView mImgIcon = (ImageView) findViewById5;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        mImgIcon.setBackground(KtxKt.getAppCompatDrawable(context, getContext().getApplicationInfo().icon));
        PopupBasicInfo popupBasicInfo = this.data;
        if (popupBasicInfo != null && (it4 = popupBasicInfo.getConfirmButton()) != null) {
            mTvConfirmBtn.setText(it4.getText());
        }
        PopupBasicInfo popupBasicInfo2 = this.data;
        if (popupBasicInfo2 != null && (it3 = popupBasicInfo2.getCancelButton()) != null) {
            mTvCancelBtn.setText(it3.getText());
        }
        PopupBasicInfo popupBasicInfo3 = this.data;
        if (popupBasicInfo3 != null && (it2 = popupBasicInfo3.getTitle()) != null) {
            ((TextView) view.findViewById(R.id.rating_dialog_tv_title)).setText(it2);
        }
        PopupBasicInfo popupBasicInfo4 = this.data;
        if (popupBasicInfo4 != null && (it = popupBasicInfo4.getSubtitle()) != null) {
            ((TextView) view.findViewById(R.id.rating_dialog_tv_subtitle)).setText(it);
        }
        mCardToStore.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.rating.RatingDialogGuide$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RatingDialogGuide.onViewCreated$lambda$4(RatingDialogGuide.this, mTvConfirmBtn, view2);
            }
        });
        mFlNext.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.rating.RatingDialogGuide$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RatingDialogGuide.onViewCreated$lambda$5(RatingDialogGuide.this, mTvCancelBtn, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(RatingDialogGuide this$0, TextView $mTvConfirmBtn, View it) {
        this$0.dismiss();
        this$0.reportClick($mTvConfirmBtn.getText().toString());
        this$0.toMarket.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(RatingDialogGuide this$0, TextView $mTvCancelBtn, View it) {
        this$0.dismiss();
        this$0.reportClick($mTvCancelBtn.getText().toString());
    }

    public void setUiBeforeShow() {
    }

    public final void reportClick(String choice) {
        Intrinsics.checkNotNullParameter(choice, "choice");
        Neurons.reportClick(false, "main.score-popup.0.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "2"), TuplesKt.to("appear_time", this.count), TuplesKt.to("choice", choice), TuplesKt.to("special_page", String.valueOf(this.specialPage))}));
    }
}