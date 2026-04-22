package srcs.common.ouroboros.editor.ui.generated.resources;

import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ResourceItem;
import srcs.common.ouroboros.editor.ui.generated.resources.Res;
import tv.danmaku.bili.BR;

/* compiled from: Drawable0.commonMain.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\b\u0010\b\u001a\u00020\u0001H\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004¨\u0006\t"}, d2 = {"image_failed_icon", "Lorg/jetbrains/compose/resources/DrawableResource;", "Lsrcs/common/ouroboros/editor/ui/generated/resources/Res$drawable;", "getImage_failed_icon", "(Lsrcs/common/ouroboros/editor/ui/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;", "init_image_failed_icon", "image_loading", "getImage_loading", "init_image_loading", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = BR.badgeVisibility)
public final class Drawable0_commonMainKt {
    public static final DrawableResource getImage_failed_icon(Res.drawable $this$image_failed_icon) {
        Intrinsics.checkNotNullParameter($this$image_failed_icon, "<this>");
        return CommonMainDrawable0.INSTANCE.getImage_failed_icon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource init_image_failed_icon() {
        return new DrawableResource("drawable:image_failed_icon", SetsKt.setOf(new ResourceItem(SetsKt.emptySet(), "composeResources/srcs.common.ouroboros.editor.ui.generated.resources/drawable/image_failed_icon.webp", -1L, -1L)));
    }

    public static final DrawableResource getImage_loading(Res.drawable $this$image_loading) {
        Intrinsics.checkNotNullParameter($this$image_loading, "<this>");
        return CommonMainDrawable0.INSTANCE.getImage_loading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource init_image_loading() {
        return new DrawableResource("drawable:image_loading", SetsKt.setOf(new ResourceItem(SetsKt.emptySet(), "composeResources/srcs.common.ouroboros.editor.ui.generated.resources/drawable/image_loading.png", -1L, -1L)));
    }
}