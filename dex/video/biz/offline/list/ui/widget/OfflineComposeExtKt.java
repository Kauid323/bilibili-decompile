package video.biz.offline.list.ui.widget;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineComposeExt.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0005¨\u0006\u0006"}, d2 = {"ifMatch", "Landroidx/compose/ui/Modifier;", "condition", "", "action", "Lkotlin/Function1;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineComposeExtKt {
    public static final Modifier ifMatch(Modifier $this$ifMatch, boolean condition, Function1<? super Modifier, ? extends Modifier> function1) {
        Intrinsics.checkNotNullParameter($this$ifMatch, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        if (condition) {
            return (Modifier) function1.invoke($this$ifMatch);
        }
        return $this$ifMatch;
    }
}