package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.base.BiliContext;
import com.bilibili.biligame.report3.ReportV3ConfigKt;
import com.bilibili.lib.accounts.BiliAccounts;
import com.mall.logic.common.MallSpUtil;
import com.mall.logic.common.ValueUitl;
import com.mall.ui.common.UiUtils;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RxExtensions.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001aE\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u0001H\u00042\b\u0010\u0007\u001a\u0004\u0018\u0001H\u00052\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\u0010\n\u001aK\u0010\u000b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u0001H\u00042\b\u0010\u0007\u001a\u0004\u0018\u0001H\u00052\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u00030\tH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\n\u001ac\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u0001H\u00042\b\u0010\u0007\u001a\u0004\u0018\u0001H\u00052\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u00030\t2\u001c\u0010\r\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\u0005\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\u0010\u000e\u001aX\u0010\u000f\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u0002H\u0011\u0018\u00010\u00132$\u0010\f\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0013\u0012\u0004\u0012\u00020\u00030\t\u001a\u0082\u0001\u0010\u000f\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u0002H\u0011\u0018\u00010\u00132$\u0010\f\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0013\u0012\u0004\u0012\u00020\u00030\t2(\u0010\r\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u0013\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0011\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00030\t\u001aG\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00170\u0016\"\u0004\u0018\u00010\u00172\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00192\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0019¢\u0006\u0002\u0010\u001b\u001aG\u0010\u001c\u001a\u00020\u00032\u0016\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001e0\u0016\"\u0004\u0018\u00010\u001e2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00192\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0019¢\u0006\u0002\u0010!\u001a\u001c\u0010\"\u001a\u00020\u0003*\u00020#2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%\u001a\u0018\u0010'\u001a\u00020\u0003*\u00020(2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019\u001a\u0018\u0010)\u001a\u00020\u0003*\u00020(2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019\u001a\u0011\u0010*\u001a\u00020\u0001*\u0004\u0018\u00010+¢\u0006\u0002\u0010,\u001a\n\u0010*\u001a\u00020\u0001*\u00020\u0001\u001a\u0012\u0010-\u001a\u00020\u0003*\u00020#2\u0006\u0010.\u001a\u00020/\u001a\u0012\u00100\u001a\u00020\u0003*\u00020#2\u0006\u0010.\u001a\u00020/\u001a\n\u00101\u001a\u00020%*\u000202\u001a\n\u00103\u001a\u00020%*\u000202\u001a\n\u00104\u001a\u000205*\u00020%\u001a\u0012\u00104\u001a\u000205*\u00020%2\u0006\u00106\u001a\u000207\u001a\n\u00108\u001a\u00020%*\u00020%\u001a\n\u00109\u001a\u00020\u0001*\u00020%\u001a\n\u0010:\u001a\u00020\u0003*\u00020%\u001a\n\u0010:\u001a\u00020\u0003*\u00020\u0001\u001a\u0012\u0010;\u001a\u00020<*\u00020=2\u0006\u0010>\u001a\u00020%\u001a\"\u0010?\u001a\u00020\u00032\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019\u001a,\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u00012\u0006\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020/2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006F"}, d2 = {"DEFAULT_ERROR_TAG", "", "bothNotNull", "", "T1", "T2", "value1", "value2", "action", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "bothNotNullInLine", "action1", "action2", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "bothNotNullAndEmpty", "E1", "E2", "collection1", "", "collection2", "arg", "", "", "noneNullAction", "Lkotlin/Function0;", "hasNullAction", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "bothNotNullAndNotEmpty", "strs", "", "trueAction", "falseAction", "([Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "smoothSnapToPosition", "Landroidx/recyclerview/widget/RecyclerView;", ReportV3ConfigKt.EXTEND_POSITION, "", "snapMode", "whenEllipsize", "Landroid/widget/TextView;", "whenNotEllipsize", "formatPrice", "", "(Ljava/lang/Double;)Ljava/lang/String;", "canScrollH", "enable", "", "canScrollV", "toPx", "", "toDp", "drawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "color", "string", "showAsToast", "inflate", "Landroid/view/View;", "Landroid/view/ViewGroup;", "layoutRes", "loginStatus", "doWhenLogin", "doWhenLogout", "doOnce", "spKey", "defaultValue", "expectValue", "mallcommon_debug"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* renamed from: RxExtensionsKt  reason: default package */
public final class RxExtensionsKt {
    public static final String DEFAULT_ERROR_TAG = "RxOnError";

    public static final <T1, T2> void bothNotNull(T1 t1, T2 t2, Function2<? super T1, ? super T2, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        if (t1 != null && t2 != null) {
            function2.invoke(t1, t2);
        }
    }

    public static final <T1, T2> void bothNotNullInLine(T1 t1, T2 t2, Function2<? super T1, ? super T2, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        if (t1 != null && t2 != null) {
            function2.invoke(t1, t2);
        }
    }

    public static final <T1, T2> void bothNotNull(T1 t1, T2 t2, Function2<? super T1, ? super T2, Unit> function2, Function2<? super T1, ? super T2, Unit> function22) {
        Intrinsics.checkNotNullParameter(function2, "action1");
        Intrinsics.checkNotNullParameter(function22, "action2");
        if (t1 != null && t2 != null) {
            function2.invoke(t1, t2);
        } else {
            function22.invoke(t1, t2);
        }
    }

    public static final <E1, E2> void bothNotNullAndEmpty(Collection<? extends E1> collection, Collection<? extends E2> collection2, Function2<? super Collection<? extends E1>, ? super Collection<? extends E2>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "action1");
        if (collection != null && !collection.isEmpty() && collection2 != null && !collection2.isEmpty()) {
            function2.invoke(collection, collection2);
        }
    }

    public static final <E1, E2> void bothNotNullAndEmpty(Collection<? extends E1> collection, Collection<? extends E2> collection2, Function2<? super Collection<? extends E1>, ? super Collection<? extends E2>, Unit> function2, Function2<? super Collection<? extends E1>, ? super Collection<? extends E2>, Unit> function22) {
        Intrinsics.checkNotNullParameter(function2, "action1");
        Intrinsics.checkNotNullParameter(function22, "action2");
        if (collection != null && !collection.isEmpty() && collection2 != null && !collection2.isEmpty()) {
            function2.invoke(collection, collection2);
        } else {
            function22.invoke(collection, collection2);
        }
    }

    public static /* synthetic */ void bothNotNull$default(Object[] objArr, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        if ((i & 4) != 0) {
            function02 = null;
        }
        bothNotNull(objArr, function0, function02);
    }

    public static final void bothNotNull(Object[] arg, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        for (Object element$iv : arg) {
            if (element$iv == null) {
                if (function02 != null) {
                    function02.invoke();
                    return;
                }
                return;
            }
        }
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static /* synthetic */ void bothNotNullAndNotEmpty$default(CharSequence[] charSequenceArr, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        if ((i & 4) != 0) {
            function02 = null;
        }
        bothNotNullAndNotEmpty(charSequenceArr, function0, function02);
    }

    public static final void bothNotNullAndNotEmpty(CharSequence[] strs, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(strs, "strs");
        CharSequence[] charSequenceArr = !(strs.length == 0) ? strs : null;
        if (charSequenceArr == null) {
            if (function02 != null) {
                function02.invoke();
                return;
            }
            return;
        }
        int length = charSequenceArr.length;
        for (int i = 0; i < length; i++) {
            CharSequence charSequence = charSequenceArr[i];
            if (charSequence == null || charSequence.length() == 0) {
                if (function02 != null) {
                    function02.invoke();
                    return;
                }
                return;
            }
        }
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static /* synthetic */ void smoothSnapToPosition$default(RecyclerView recyclerView, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = -1;
        }
        smoothSnapToPosition(recyclerView, i, i2);
    }

    public static final void smoothSnapToPosition(RecyclerView $this$smoothSnapToPosition, int position, final int snapMode) {
        Intrinsics.checkNotNullParameter($this$smoothSnapToPosition, "<this>");
        final Context context = $this$smoothSnapToPosition.getContext();
        RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(context) { // from class: RxExtensionsKt$smoothSnapToPosition$smoothScroller$1
            protected int getVerticalSnapPreference() {
                return snapMode;
            }

            protected int getHorizontalSnapPreference() {
                return snapMode;
            }
        };
        smoothScroller.setTargetPosition(position);
        RecyclerView.LayoutManager layoutManager = $this$smoothSnapToPosition.getLayoutManager();
        if (layoutManager != null) {
            layoutManager.startSmoothScroll(smoothScroller);
        }
    }

    public static final void whenEllipsize(final TextView $this$whenEllipsize, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter($this$whenEllipsize, "<this>");
        Intrinsics.checkNotNullParameter(function0, "action");
        $this$whenEllipsize.post(new Runnable() { // from class: RxExtensionsKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RxExtensionsKt.whenEllipsize$lambda$0($this$whenEllipsize, function0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void whenEllipsize$lambda$0(TextView $this_whenEllipsize, Function0 $action) {
        Layout layout = $this_whenEllipsize.getLayout();
        int lines = layout.getLineCount();
        if (lines > 0 && layout.getEllipsisCount(lines - 1) > 0) {
            $action.invoke();
        }
    }

    public static final void whenNotEllipsize(final TextView $this$whenNotEllipsize, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter($this$whenNotEllipsize, "<this>");
        Intrinsics.checkNotNullParameter(function0, "action");
        $this$whenNotEllipsize.post(new Runnable() { // from class: RxExtensionsKt$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                RxExtensionsKt.whenNotEllipsize$lambda$0($this$whenNotEllipsize, function0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void whenNotEllipsize$lambda$0(TextView $this_whenNotEllipsize, Function0 $action) {
        Layout layout = $this_whenNotEllipsize.getLayout();
        int lines = layout.getLineCount();
        boolean ellipsize = lines > 0 && layout.getEllipsisCount(lines + (-1)) > 0;
        if (!ellipsize) {
            $action.invoke();
        }
    }

    public static final String formatPrice(Double $this$formatPrice) {
        if ($this$formatPrice == null) {
            return "";
        }
        String formatPrice = ValueUitl.formatPrice($this$formatPrice);
        Intrinsics.checkNotNullExpressionValue(formatPrice, "formatPrice(...)");
        return formatPrice;
    }

    public static final String formatPrice(String $this$formatPrice) {
        Intrinsics.checkNotNullParameter($this$formatPrice, "<this>");
        double doublePrice = ValueUitl.string2Double($this$formatPrice);
        String formatPrice = ValueUitl.formatPrice(Double.valueOf(doublePrice));
        Intrinsics.checkNotNullExpressionValue(formatPrice, "formatPrice(...)");
        return formatPrice;
    }

    public static final void canScrollH(RecyclerView $this$canScrollH, final boolean enable) {
        Intrinsics.checkNotNullParameter($this$canScrollH, "<this>");
        final Context context = $this$canScrollH.getContext();
        $this$canScrollH.setLayoutManager(new LinearLayoutManager(context) { // from class: RxExtensionsKt$canScrollH$1
            public boolean canScrollHorizontally() {
                return enable;
            }
        });
    }

    public static final void canScrollV(RecyclerView $this$canScrollV, final boolean enable) {
        Intrinsics.checkNotNullParameter($this$canScrollV, "<this>");
        final Context context = $this$canScrollV.getContext();
        $this$canScrollV.setLayoutManager(new LinearLayoutManager(context) { // from class: RxExtensionsKt$canScrollV$1
            public boolean canScrollVertically() {
                return enable;
            }
        });
    }

    public static final int toPx(float $this$toPx) {
        return UiUtils.dip2px(BiliContext.application(), $this$toPx);
    }

    public static final int toDp(float $this$toDp) {
        return UiUtils.px2dip(BiliContext.application(), $this$toDp);
    }

    public static final Drawable drawable(int $this$drawable) {
        Drawable drawable = UiUtils.getDrawable($this$drawable);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(...)");
        return drawable;
    }

    public static final Drawable drawable(int $this$drawable, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawableById = UiUtils.getDrawableById(context, $this$drawable);
        Intrinsics.checkNotNullExpressionValue(drawableById, "getDrawableById(...)");
        return drawableById;
    }

    public static final int color(int $this$color) {
        return UiUtils.getColor($this$color);
    }

    public static final String string(int $this$string) {
        String string = UiUtils.getString($this$string);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final void showAsToast(int $this$showAsToast) {
        UiUtils.showShortToast($this$showAsToast);
    }

    public static final void showAsToast(String $this$showAsToast) {
        Intrinsics.checkNotNullParameter($this$showAsToast, "<this>");
        UiUtils.showShortToast($this$showAsToast);
    }

    public static final View inflate(ViewGroup $this$inflate, int layoutRes) {
        Intrinsics.checkNotNullParameter($this$inflate, "<this>");
        View inflate = LayoutInflater.from($this$inflate.getContext()).inflate(layoutRes, $this$inflate, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public static final void loginStatus(Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "doWhenLogin");
        Intrinsics.checkNotNullParameter(function02, "doWhenLogout");
        if (BiliAccounts.get(BiliContext.application()).isLogin()) {
            function0.invoke();
        } else {
            function02.invoke();
        }
    }

    public static final void doOnce(String spKey, boolean defaultValue, boolean expectValue, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(spKey, "spKey");
        Intrinsics.checkNotNullParameter(function0, "action");
        boolean value = MallSpUtil.getBoolean(spKey, defaultValue);
        if (value == expectValue) {
            MallSpUtil.putBoolean(spKey, !value);
            function0.invoke();
        }
    }
}