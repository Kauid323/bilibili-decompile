package srcs.common.iconfont.generated.resources;

import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.FontResource;
import org.jetbrains.compose.resources.ResourceItem;
import srcs.common.iconfont.generated.resources.Res;
import tv.danmaku.bili.BR;

/* compiled from: Font0.commonMain.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"iconfont", "Lorg/jetbrains/compose/resources/FontResource;", "Lsrcs/common/iconfont/generated/resources/Res$font;", "getIconfont", "(Lsrcs/common/iconfont/generated/resources/Res$font;)Lorg/jetbrains/compose/resources/FontResource;", "init_iconfont", "iconfont_debug"}, k = 2, mv = {2, 2, 0}, xi = BR.badgeVisibility)
public final class Font0_commonMainKt {
    public static final FontResource getIconfont(Res.font $this$iconfont) {
        Intrinsics.checkNotNullParameter($this$iconfont, "<this>");
        return CommonMainFont0.INSTANCE.getIconfont();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FontResource init_iconfont() {
        return new FontResource("font:iconfont", SetsKt.setOf(new ResourceItem(SetsKt.emptySet(), "composeResources/srcs.common.iconfont.generated.resources/font/iconfont.ttf", -1L, -1L)));
    }
}