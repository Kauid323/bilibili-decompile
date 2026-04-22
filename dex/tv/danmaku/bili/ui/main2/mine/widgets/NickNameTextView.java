package tv.danmaku.bili.ui.main2.mine.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bilibili.app.comm.vipconfig.VipThemeConfigManager;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.lib.voldemort.charsequence.VoldemortCharSequenceUtilsKt;
import com.bilibili.lib.voldemort.data.VoldemortNameRender;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.Tintable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;

/* compiled from: NickNameTextView.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ2\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/widgets/NickNameTextView;", "Ltv/danmaku/bili/ui/main2/mine/widgets/MultipleThemeTextView;", "Lcom/bilibili/magicasakura/widgets/Tintable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vip", "", "yearVip", "littleVip", "labelTheme", "", "nameRender", "Lcom/bilibili/lib/voldemort/data/VoldemortNameRender;", "setVipInfo", "", "tint", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NickNameTextView extends MultipleThemeTextView implements Tintable {
    public static final int $stable = 8;
    private String labelTheme;
    private boolean littleVip;
    private VoldemortNameRender nameRender;
    private boolean vip;
    private boolean yearVip;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NickNameTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NickNameTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NickNameTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ NickNameTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setVipInfo(boolean vip, boolean yearVip, boolean littleVip, String labelTheme, VoldemortNameRender nameRender) {
        this.vip = vip;
        this.yearVip = yearVip;
        this.littleVip = littleVip;
        this.labelTheme = labelTheme;
        this.nameRender = nameRender;
        tint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View tint$lambda$0(NickNameTextView this$0) {
        return (View) this$0;
    }

    @Override // tv.danmaku.bili.ui.main2.mine.widgets.MultipleThemeTextView
    public void tint() {
        int color;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setText(VoldemortCharSequenceUtilsKt.buildVoldemort(getText().toString(), context, this.nameRender, new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.widgets.NickNameTextView$$ExternalSyntheticLambda0
            public final Object invoke() {
                View tint$lambda$0;
                tint$lambda$0 = NickNameTextView.tint$lambda$0(NickNameTextView.this);
                return tint$lambda$0;
            }
        }));
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        Garb garb = GarbManager.getGarbWithNightMode(context2);
        if (garb.isPure() || garb.isPrimaryOnly()) {
            if (this.vip) {
                if (MultipleThemeUtils.isWhiteTheme(getContext()) || MultipleThemeUtils.isNightTheme(getContext())) {
                    Integer valueOf = Integer.valueOf(VipThemeConfigManager.getVipNicknameColor(getContext(), this.labelTheme, MultipleThemeUtils.isNightTheme(getContext())));
                    int it = valueOf.intValue();
                    if (!(it != 0)) {
                        valueOf = null;
                    }
                    if (valueOf != null) {
                        color = valueOf.intValue();
                    } else {
                        color = ContextCompat.getColor(getContext(), this.yearVip ? R.color.navigation_nickname_color : com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_title);
                    }
                    setTextColor(color);
                    return;
                }
                setTextColor(ThemeUtils.getColorById(getContext(), com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_title));
                return;
            }
            setTextColor(ThemeUtils.getColorById(getContext(), com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_title));
            return;
        }
        super.tint();
    }
}