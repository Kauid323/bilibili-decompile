package tv.danmaku.bili.ui.garb.view;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bilibili.app.authorspace.ui.nft.utils.FooterLoadingWidget;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: CollectionFooterLoadingView.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012#\u0010\u0004\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/garb/view/CollectionFooterLoadingView;", "Lcom/bilibili/app/authorspace/ui/nft/utils/FooterLoadingWidget;", "parent", "Landroid/view/ViewGroup;", "onErrorClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "type", "", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "text", "Landroid/widget/TextView;", "loading", "Landroid/view/View;", "rightArrow", "Landroidx/appcompat/widget/AppCompatImageView;", "mErrorText", "Landroid/text/SpannableStringBuilder;", "showNoData", "showLoading", "showLoadError", "getErrorText", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CollectionFooterLoadingView extends FooterLoadingWidget {
    public static final int $stable = 8;
    private final View loading;
    private SpannableStringBuilder mErrorText;
    private final AppCompatImageView rightArrow;
    private final TextView text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionFooterLoadingView(ViewGroup parent, Function1<? super Integer, Unit> function1) {
        super(parent, function1, R.layout.bili_app_fragment_collection_all_loading_view, true);
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(function1, "onErrorClick");
        View findViewById = getRootView().findViewById(R.id.collection_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.text = (TextView) findViewById;
        View findViewById2 = getRootView().findViewById(R.id.collection_loading);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.loading = findViewById2;
        AppCompatImageView findViewById3 = getRootView().findViewById(R.id.collection_right_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.rightArrow = findViewById3;
    }

    public void showNoData() {
        super.showNoData();
        this.loading.setVisibility(8);
        this.text.setVisibility(0);
        this.rightArrow.setVisibility(0);
        this.text.setText("没有更多了，去商城看看");
    }

    public void showLoading() {
        super.showLoading();
        this.loading.setVisibility(0);
        this.rightArrow.setVisibility(8);
        this.text.setVisibility(8);
    }

    public void showLoadError() {
        super.showLoadError();
        this.loading.setVisibility(8);
        this.text.setVisibility(0);
        this.rightArrow.setVisibility(0);
        TextView textView = this.text;
        CharSequence errorText = getErrorText();
        if (errorText == null) {
            errorText = "";
        }
        textView.setText(errorText);
    }

    private final SpannableStringBuilder getErrorText() {
        if (this.mErrorText != null) {
            return this.mErrorText;
        }
        try {
            Context context = this.text.getContext();
            String str = (context == null || (str = context.getString(bili.resource.common.R.string.common_global_string_118)) == null) ? "" : "";
            int length = str.length();
            if (length > 4) {
                this.mErrorText = new SpannableStringBuilder(str);
                SpannableStringBuilder spannableStringBuilder = this.mErrorText;
                if (spannableStringBuilder != null) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF6699")), length - 4, length, 33);
                }
                return this.mErrorText;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }
}