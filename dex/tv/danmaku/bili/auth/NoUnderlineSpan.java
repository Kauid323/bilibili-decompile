package tv.danmaku.bili.auth;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import j$.util.Map;
import j$.util.function.BiConsumer;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiliAuthExts.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00030\u00030\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/auth/NoUnderlineSpan;", "Landroid/text/style/ClickableSpan;", "listener", "Ltv/danmaku/bili/auth/LinkItemListener;", "url", "", "underLineColor", "", "extras", "", "<init>", "(Ltv/danmaku/bili/auth/LinkItemListener;Ljava/lang/String;ILjava/util/Map;)V", "mListenerRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NoUnderlineSpan extends ClickableSpan {
    private final Map<String, String> extras;
    private final WeakReference<LinkItemListener> mListenerRef;
    private final int underLineColor;
    private final String url;

    public NoUnderlineSpan(LinkItemListener listener, String url, int underLineColor, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(map, "extras");
        this.url = url;
        this.underLineColor = underLineColor;
        this.extras = map;
        this.mListenerRef = new WeakReference<>(listener);
    }

    public /* synthetic */ NoUnderlineSpan(LinkItemListener linkItemListener, String str, int i, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(linkItemListener, str, i, (i2 & 8) != 0 ? MapsKt.emptyMap() : map);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        LinkItemListener listener = this.mListenerRef.get();
        if (listener != null) {
            listener.onItemClick();
        }
        Context context = widget.getContext();
        RouteRequest request = RouteRequestKt.toRouteRequest(this.url).newBuilder().extras(new Function1() { // from class: tv.danmaku.bili.auth.NoUnderlineSpan$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit onClick$lambda$0;
                onClick$lambda$0 = NoUnderlineSpan.onClick$lambda$0(NoUnderlineSpan.this, (MutableBundleLike) obj);
                return onClick$lambda$0;
            }
        }).build();
        BLRouter.routeTo(request, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClick$lambda$0(NoUnderlineSpan this$0, final MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        Map<String, String> map = this$0.extras;
        final Function2 function2 = new Function2() { // from class: tv.danmaku.bili.auth.NoUnderlineSpan$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit onClick$lambda$0$0;
                onClick$lambda$0$0 = NoUnderlineSpan.onClick$lambda$0$0($this$extras, (String) obj, (String) obj2);
                return onClick$lambda$0$0;
            }
        };
        Map.-EL.forEach(map, new BiConsumer() { // from class: tv.danmaku.bili.auth.NoUnderlineSpan$$ExternalSyntheticLambda1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                function2.invoke(obj, obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.-CC.$default$andThen(this, biConsumer);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClick$lambda$0$0(MutableBundleLike $this_extras, String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        $this_extras.put(key, value);
        return Unit.INSTANCE;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        super.updateDrawState(ds);
        ds.setUnderlineText(false);
        ds.bgColor = 0;
        ds.setColor(this.underLineColor);
    }
}