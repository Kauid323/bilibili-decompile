package srcs.app.tribee.publish.ui.generated.resources;

import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ResourceItem;
import srcs.app.tribee.publish.ui.generated.resources.Res;
import tv.danmaku.bili.BR;

/* compiled from: Drawable0.commonMain.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"tribee_icon", "Lorg/jetbrains/compose/resources/DrawableResource;", "Lsrcs/app/tribee/publish/ui/generated/resources/Res$drawable;", "getTribee_icon", "(Lsrcs/app/tribee/publish/ui/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;", "init_tribee_icon", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = BR.badgeVisibility)
public final class Drawable0_commonMainKt {
    public static final DrawableResource getTribee_icon(Res.drawable $this$tribee_icon) {
        Intrinsics.checkNotNullParameter($this$tribee_icon, "<this>");
        return CommonMainDrawable0.INSTANCE.getTribee_icon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource init_tribee_icon() {
        return new DrawableResource("drawable:tribee_icon", SetsKt.setOf(new ResourceItem(SetsKt.emptySet(), "composeResources/srcs.app.tribee.publish.ui.generated.resources/drawable/tribee_icon.png", -1L, -1L)));
    }
}