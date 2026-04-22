package tv.danmaku.bili.ui.splash.brand.uiv2.setting.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bilibili.lib.theme.R;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashPagerTabLayoutBinding;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashBrandTabItemView.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020#H\u0002J\u0010\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020%H\u0002R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/view/SplashBrandTabItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "selectedTextColorResId", "", "getSelectedTextColorResId", "()I", "setSelectedTextColorResId", "(I)V", "selectedTextSizeSp", "getSelectedTextSizeSp", "setSelectedTextSizeSp", "unSelectedTextColorRes", "getUnSelectedTextColorRes", "setUnSelectedTextColorRes", "unSelectedTextSizeSp", "getUnSelectedTextSizeSp", "setUnSelectedTextSizeSp", "tabTitle", "", "getTabTitle", "()Ljava/lang/String;", "setTabTitle", "(Ljava/lang/String;)V", "source", "getSource", "setSource", "binding", "Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashPagerTabLayoutBinding;", "setSelected", "", "selected", "", "update", "setUnderline", "isSelected", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashBrandTabItemView extends FrameLayout {
    public static final int $stable = 8;
    private BiliAppListBrandSplashPagerTabLayoutBinding binding;
    private int selectedTextColorResId;
    private int selectedTextSizeSp;
    private String source;
    private String tabTitle;
    private int unSelectedTextColorRes;
    private int unSelectedTextSizeSp;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SplashBrandTabItemView(Context context, AttributeSet attr) {
        super(context, attr);
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        this.selectedTextColorResId = R.color.Brand_pink;
        this.selectedTextSizeSp = 16;
        this.unSelectedTextColorRes = R.color.Text2;
        this.unSelectedTextSizeSp = 15;
        this.tabTitle = "";
        BiliAppListBrandSplashPagerTabLayoutBinding bind = BiliAppListBrandSplashPagerTabLayoutBinding.bind(LayoutInflater.from(context2).inflate(tv.danmaku.bili.ui.splash.R.layout.bili_app_list_brand_splash_pager_tab_layout, this));
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
    }

    public /* synthetic */ SplashBrandTabItemView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final int getSelectedTextColorResId() {
        return this.selectedTextColorResId;
    }

    public final void setSelectedTextColorResId(int i) {
        this.selectedTextColorResId = i;
    }

    public final int getSelectedTextSizeSp() {
        return this.selectedTextSizeSp;
    }

    public final void setSelectedTextSizeSp(int i) {
        this.selectedTextSizeSp = i;
    }

    public final int getUnSelectedTextColorRes() {
        return this.unSelectedTextColorRes;
    }

    public final void setUnSelectedTextColorRes(int i) {
        this.unSelectedTextColorRes = i;
    }

    public final int getUnSelectedTextSizeSp() {
        return this.unSelectedTextSizeSp;
    }

    public final void setUnSelectedTextSizeSp(int i) {
        this.unSelectedTextSizeSp = i;
    }

    public final String getTabTitle() {
        return this.tabTitle;
    }

    public final void setTabTitle(String str) {
        this.tabTitle = str;
    }

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        update();
    }

    private final void update() {
        if (isSelected()) {
            this.binding.title.setText(this.tabTitle);
            this.binding.title.setTextColor(getContext().getResources().getColor(this.selectedTextColorResId));
            this.binding.title.setTextSize(this.selectedTextSizeSp);
            this.binding.title.setTypeface(null, 1);
        } else {
            this.binding.title.setText(this.tabTitle);
            this.binding.title.setTextSize(this.unSelectedTextSizeSp);
            this.binding.title.setTextColor(getContext().getResources().getColor(this.unSelectedTextColorRes));
            this.binding.title.setTypeface(null, 0);
        }
        setUnderline(isSelected());
    }

    private final void setUnderline(boolean isSelected) {
        String title = this.tabTitle;
        String str = title;
        if ((str == null || StringsKt.isBlank(str)) || !isSelected) {
            this.binding.underLine.setVisibility(8);
            return;
        }
        this.binding.underLine.setVisibility(0);
        Paint paint = new Paint();
        paint.setTextSize(this.binding.title.getTextSize());
        paint.setTypeface(this.binding.title.getTypeface());
        float textWidth = paint.measureText(title);
        ViewGroup.LayoutParams lp = this.binding.underLine.getLayoutParams();
        lp.width = (int) textWidth;
        this.binding.underLine.setLayoutParams(lp);
    }
}