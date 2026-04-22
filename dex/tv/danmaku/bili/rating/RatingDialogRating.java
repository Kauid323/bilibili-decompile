package tv.danmaku.bili.rating;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.RawKV;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.widget.BaseDialog;

/* compiled from: RatingDialog.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/rating/RatingDialogRating;", "Ltv/danmaku/bili/widget/BaseDialog;", "context", "Landroid/content/Context;", "data", "Ltv/danmaku/bili/rating/RatingThenGuide;", "count", "", "specialPage", "", "toMarket", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/Context;Ltv/danmaku/bili/rating/RatingThenGuide;Ljava/lang/String;ILkotlin/jvm/functions/Function0;)V", "onCreateView", "Landroid/view/View;", "onViewCreated", "view", "handleRating", "rating", "setUiBeforeShow", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RatingDialogRating extends BaseDialog<RatingDialogRating> {
    public static final int $stable = 8;
    private final String count;
    private final RatingThenGuide data;
    private final int specialPage;
    private final Function0<Unit> toMarket;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RatingDialogRating(Context context, RatingThenGuide data, String count, int specialPage, Function0<Unit> function0) {
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

    public View onCreateView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.bili_app_dialog_rating, (ViewGroup) null);
        Intrinsics.checkNotNull(view);
        return view;
    }

    public void onViewCreated(View view) {
        String it;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view);
        View findViewById = view.findViewById(R.id.rating_dialog_ratingview);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        RatingView ratingView = (RatingView) findViewById;
        View findViewById2 = view.findViewById(R.id.rating_dialog_close);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        ImageView close = (ImageView) findViewById2;
        RatingPopup ratingPopup = this.data.getRatingPopup();
        if (ratingPopup != null && (it = ratingPopup.getTitle()) != null) {
            ((TextView) view.findViewById(R.id.rating_dialog_tv_title)).setText(it);
        }
        close.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.rating.RatingDialogRating$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RatingDialogRating.onViewCreated$lambda$1(RatingDialogRating.this, view2);
            }
        });
        ratingView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.rating.RatingDialogRating$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RatingDialogRating.onViewCreated$lambda$2(RatingDialogRating.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(RatingDialogRating this$0, View it) {
        Neurons.reportClick(false, "main.score-popup.0.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "1"), TuplesKt.to("appear_time", this$0.count), TuplesKt.to("choice", SplashCustomReporterKt.STATE_CANCEL), TuplesKt.to("special_page", String.valueOf(this$0.specialPage))}));
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(final RatingDialogRating this$0, final View v) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: tv.danmaku.bili.rating.RatingDialogRating$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RatingDialogRating.onViewCreated$lambda$2$0(RatingDialogRating.this, v);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2$0(RatingDialogRating this$0, View $v) {
        RatingView ratingView = $v instanceof RatingView ? (RatingView) $v : null;
        this$0.handleRating(ratingView != null ? ratingView.getRating() : 0);
    }

    private final void handleRating(int rating) {
        dismiss();
        Neurons.reportClick(false, "main.score-popup.0.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "1"), TuplesKt.to("appear_time", this.count), TuplesKt.to("choice", "score"), TuplesKt.to("score", String.valueOf(rating)), TuplesKt.to("special_page", String.valueOf(this.specialPage))}));
        if (rating < 5) {
            ToastHelper.showToast(getContext(), "感谢你的反馈", 0);
            return;
        }
        Application application = BiliContext.application();
        RawKV blkv = application != null ? BLKV.getKvs$default(application, RatingEventRegisterKt.RATING_DIALOG_COUNT_FILE_NAME, true, 0, 4, (Object) null) : null;
        int currentCount = blkv != null ? ((Number) blkv.get(RatingEventRegisterKt.RATING_DIALOG_GUIDE_COUNT_KEY, 1)).intValue() : 1;
        Map extra = new HashMap(3);
        extra.put("appear_times", String.valueOf(currentCount));
        extra.put("type", "2");
        extra.put("special_page", String.valueOf(this.specialPage));
        Neurons.reportExposure$default(false, "main.score-popup.0.0.show", extra, (List) null, 8, (Object) null);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        new RatingDialogGuide(context, this.data.getGuidePopup(), String.valueOf(currentCount), this.specialPage, this.toMarket).show();
        if (blkv != null) {
            blkv.putInt(RatingEventRegisterKt.RATING_DIALOG_GUIDE_COUNT_KEY, currentCount + 1);
        }
    }

    public void setUiBeforeShow() {
    }
}