package leakcanary.internal.activity.ui;

import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UiUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n0\bH\u0000¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Lleakcanary/internal/activity/ui/UiUtils;", "", "()V", "replaceUrlSpanWithAction", "", "title", "Landroid/text/SpannableStringBuilder;", "urlAction", "Lkotlin/Function1;", "", "Lkotlin/Function0;", "replaceUrlSpanWithAction$leakcanary_android_core_release", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class UiUtils {
    public static final UiUtils INSTANCE = new UiUtils();

    private UiUtils() {
    }

    public final void replaceUrlSpanWithAction$leakcanary_android_core_release(SpannableStringBuilder title, Function1<? super String, ? extends Function0<Unit>> urlAction) {
        Intrinsics.checkParameterIsNotNull(title, "title");
        Intrinsics.checkParameterIsNotNull(urlAction, "urlAction");
        URLSpan[] urlSpans = (URLSpan[]) title.getSpans(0, title.length(), URLSpan.class);
        for (URLSpan span : urlSpans) {
            Intrinsics.checkExpressionValueIsNotNull(span, "span");
            String url = span.getURL();
            Intrinsics.checkExpressionValueIsNotNull(url, "span.url");
            final Function0 action = urlAction.invoke(url);
            if (action != null) {
                int start = title.getSpanStart(span);
                int end = title.getSpanEnd(span);
                int flags = title.getSpanFlags(span);
                title.removeSpan(span);
                title.setSpan(new ClickableSpan() { // from class: leakcanary.internal.activity.ui.UiUtils$replaceUrlSpanWithAction$newSpan$1
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View widget) {
                        Intrinsics.checkParameterIsNotNull(widget, "widget");
                        Function0.this.invoke();
                    }
                }, start, end, flags);
            }
        }
    }
}