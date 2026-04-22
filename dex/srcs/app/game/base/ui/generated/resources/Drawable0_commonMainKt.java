package srcs.app.game.base.ui.generated.resources;

import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ResourceItem;
import srcs.app.game.base.ui.generated.resources.Res;
import tv.danmaku.bili.BR;

/* compiled from: Drawable0.commonMain.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"ic_tv_placeholder", "Lorg/jetbrains/compose/resources/DrawableResource;", "Lsrcs/app/game/base/ui/generated/resources/Res$drawable;", "getIc_tv_placeholder", "(Lsrcs/app/game/base/ui/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;", "init_ic_tv_placeholder", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = BR.badgeVisibility)
public final class Drawable0_commonMainKt {
    public static final DrawableResource getIc_tv_placeholder(Res.drawable $this$ic_tv_placeholder) {
        Intrinsics.checkNotNullParameter($this$ic_tv_placeholder, "<this>");
        return CommonMainDrawable0.INSTANCE.getIc_tv_placeholder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource init_ic_tv_placeholder() {
        return new DrawableResource("drawable:ic_tv_placeholder", SetsKt.setOf(new ResourceItem(SetsKt.emptySet(), "composeResources/srcs.app.game.base.ui.generated.resources/drawable/ic_tv_placeholder.png", -1L, -1L)));
    }
}