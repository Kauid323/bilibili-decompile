package kntr.common.ouro.ui.textField;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.ui.utils.OuroDrawableUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroEditScrollView.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0081\u0001\u0010\u0014\u001a\u00020\u00132y\b\u0002\u0010\u0015\u001as\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000bJ(\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0014R\u007f\u0010\n\u001as\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkntr/common/ouro/ui/textField/OuroEditScrollView;", "Landroid/widget/ScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onScrollChangedCallback", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "view", "left", "top", "oldLeft", "oldTop", "", "setOnScrollChangedCallback", "callback", "onScrollChanged", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroEditScrollView extends ScrollView {
    public static final int $stable = 8;
    private Function5<? super OuroEditScrollView, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> onScrollChangedCallback;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OuroEditScrollView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OuroEditScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OuroEditScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        if (OuroDrawableUtilsKt.getUseExperimentalRender()) {
            return;
        }
        setLayerType(1, null);
    }

    public /* synthetic */ OuroEditScrollView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setOnScrollChangedCallback$default(OuroEditScrollView ouroEditScrollView, Function5 function5, int i, Object obj) {
        if ((i & 1) != 0) {
            function5 = null;
        }
        ouroEditScrollView.setOnScrollChangedCallback(function5);
    }

    public final void setOnScrollChangedCallback(Function5<? super OuroEditScrollView, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function5) {
        this.onScrollChangedCallback = function5;
    }

    @Override // android.view.View
    protected void onScrollChanged(int left, int top, int oldLeft, int oldTop) {
        super.onScrollChanged(left, top, oldLeft, oldTop);
        Function5<? super OuroEditScrollView, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function5 = this.onScrollChangedCallback;
        if (function5 != null) {
            function5.invoke(this, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(oldLeft), Integer.valueOf(oldTop));
        }
    }
}