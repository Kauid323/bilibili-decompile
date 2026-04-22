package srcs.app.game.base.ui.generated.resources;

import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.FontResource;
import org.jetbrains.compose.resources.ResourceItem;
import srcs.app.game.base.ui.generated.resources.Res;
import tv.danmaku.bili.BR;

/* compiled from: Font0.commonMain.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\b\u0010\b\u001a\u00020\u0001H\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004¨\u0006\t"}, d2 = {"xx_bin_Regular", "Lorg/jetbrains/compose/resources/FontResource;", "Lsrcs/app/game/base/ui/generated/resources/Res$font;", "getXx_bin_Regular", "(Lsrcs/app/game/base/ui/generated/resources/Res$font;)Lorg/jetbrains/compose/resources/FontResource;", "init_xx_bin_Regular", "xx_bin_bold", "getXx_bin_bold", "init_xx_bin_bold", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = BR.badgeVisibility)
public final class Font0_commonMainKt {
    public static final FontResource getXx_bin_Regular(Res.font $this$xx_bin_Regular) {
        Intrinsics.checkNotNullParameter($this$xx_bin_Regular, "<this>");
        return CommonMainFont0.INSTANCE.getXx_bin_Regular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FontResource init_xx_bin_Regular() {
        return new FontResource("font:xx_bin_Regular", SetsKt.setOf(new ResourceItem(SetsKt.emptySet(), "composeResources/srcs.app.game.base.ui.generated.resources/font/xx-bin-Regular.ttf", -1L, -1L)));
    }

    public static final FontResource getXx_bin_bold(Res.font $this$xx_bin_bold) {
        Intrinsics.checkNotNullParameter($this$xx_bin_bold, "<this>");
        return CommonMainFont0.INSTANCE.getXx_bin_bold();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FontResource init_xx_bin_bold() {
        return new FontResource("font:xx_bin_bold", SetsKt.setOf(new ResourceItem(SetsKt.emptySet(), "composeResources/srcs.app.game.base.ui.generated.resources/font/xx-bin-bold.otf", -1L, -1L)));
    }
}