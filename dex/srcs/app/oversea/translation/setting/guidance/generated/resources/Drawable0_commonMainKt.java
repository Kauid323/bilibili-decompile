package srcs.app.oversea.translation.setting.guidance.generated.resources;

import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ResourceItem;
import srcs.app.oversea.translation.setting.guidance.generated.resources.Res;
import tv.danmaku.bili.BR;

/* compiled from: Drawable0.commonMain.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\b\u0010\b\u001a\u00020\u0001H\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004¨\u0006\t"}, d2 = {"checkbox_selected", "Lorg/jetbrains/compose/resources/DrawableResource;", "Lsrcs/app/oversea/translation/setting/guidance/generated/resources/Res$drawable;", "getCheckbox_selected", "(Lsrcs/app/oversea/translation/setting/guidance/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;", "init_checkbox_selected", "checkbox_unselected", "getCheckbox_unselected", "init_checkbox_unselected", "translation-setting-guidance_debug"}, k = 2, mv = {2, 2, 0}, xi = BR.badgeVisibility)
public final class Drawable0_commonMainKt {
    public static final DrawableResource getCheckbox_selected(Res.drawable $this$checkbox_selected) {
        Intrinsics.checkNotNullParameter($this$checkbox_selected, "<this>");
        return CommonMainDrawable0.INSTANCE.getCheckbox_selected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource init_checkbox_selected() {
        return new DrawableResource("drawable:checkbox_selected", SetsKt.setOf(new ResourceItem(SetsKt.emptySet(), "composeResources/srcs.app.oversea.translation.setting.guidance.generated.resources/drawable/checkbox_selected.png", -1L, -1L)));
    }

    public static final DrawableResource getCheckbox_unselected(Res.drawable $this$checkbox_unselected) {
        Intrinsics.checkNotNullParameter($this$checkbox_unselected, "<this>");
        return CommonMainDrawable0.INSTANCE.getCheckbox_unselected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource init_checkbox_unselected() {
        return new DrawableResource("drawable:checkbox_unselected", SetsKt.setOf(new ResourceItem(SetsKt.emptySet(), "composeResources/srcs.app.oversea.translation.setting.guidance.generated.resources/drawable/checkbox_unselected.png", -1L, -1L)));
    }
}