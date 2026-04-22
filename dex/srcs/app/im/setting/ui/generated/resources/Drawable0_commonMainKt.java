package srcs.app.im.setting.ui.generated.resources;

import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ResourceItem;
import srcs.app.im.setting.ui.generated.resources.Res;
import tv.danmaku.bili.BR;

/* compiled from: Drawable0.commonMain.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\b\u0010\b\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000b\u001a\u00020\u0001H\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0018\u0010\t\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004¨\u0006\f"}, d2 = {"gender_female", "Lorg/jetbrains/compose/resources/DrawableResource;", "Lsrcs/app/im/setting/ui/generated/resources/Res$drawable;", "getGender_female", "(Lsrcs/app/im/setting/ui/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;", "init_gender_female", "gender_male", "getGender_male", "init_gender_male", "gender_unknown", "getGender_unknown", "init_gender_unknown", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = BR.badgeVisibility)
public final class Drawable0_commonMainKt {
    public static final DrawableResource getGender_female(Res.drawable $this$gender_female) {
        Intrinsics.checkNotNullParameter($this$gender_female, "<this>");
        return CommonMainDrawable0.INSTANCE.getGender_female();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource init_gender_female() {
        return new DrawableResource("drawable:gender_female", SetsKt.setOf(new ResourceItem(SetsKt.emptySet(), "composeResources/srcs.app.im.setting.ui.generated.resources/drawable/gender_female.webp", -1L, -1L)));
    }

    public static final DrawableResource getGender_male(Res.drawable $this$gender_male) {
        Intrinsics.checkNotNullParameter($this$gender_male, "<this>");
        return CommonMainDrawable0.INSTANCE.getGender_male();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource init_gender_male() {
        return new DrawableResource("drawable:gender_male", SetsKt.setOf(new ResourceItem(SetsKt.emptySet(), "composeResources/srcs.app.im.setting.ui.generated.resources/drawable/gender_male.webp", -1L, -1L)));
    }

    public static final DrawableResource getGender_unknown(Res.drawable $this$gender_unknown) {
        Intrinsics.checkNotNullParameter($this$gender_unknown, "<this>");
        return CommonMainDrawable0.INSTANCE.getGender_unknown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource init_gender_unknown() {
        return new DrawableResource("drawable:gender_unknown", SetsKt.setOf(new ResourceItem(SetsKt.emptySet(), "composeResources/srcs.app.im.setting.ui.generated.resources/drawable/gender_unknown.webp", -1L, -1L)));
    }
}