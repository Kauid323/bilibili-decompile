package srcs.app.im.chat.sticker.generated.resources;

import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.DensityQualifier;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ResourceItem;
import srcs.app.im.chat.sticker.generated.resources.Res;
import tv.danmaku.bili.BR;

/* compiled from: Drawable0.commonMain.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"chat_sticker_settings", "Lorg/jetbrains/compose/resources/DrawableResource;", "Lsrcs/app/im/chat/sticker/generated/resources/Res$drawable;", "getChat_sticker_settings", "(Lsrcs/app/im/chat/sticker/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;", "init_chat_sticker_settings", "sticker_debug"}, k = 2, mv = {2, 2, 0}, xi = BR.badgeVisibility)
public final class Drawable0_commonMainKt {
    public static final DrawableResource getChat_sticker_settings(Res.drawable $this$chat_sticker_settings) {
        Intrinsics.checkNotNullParameter($this$chat_sticker_settings, "<this>");
        return CommonMainDrawable0.INSTANCE.getChat_sticker_settings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource init_chat_sticker_settings() {
        return new DrawableResource("drawable:chat_sticker_settings", SetsKt.setOf(new ResourceItem(SetsKt.setOf(DensityQualifier.XXHDPI), "composeResources/srcs.app.im.chat.sticker.generated.resources/drawable-xxhdpi/chat_sticker_settings.png", -1L, -1L)));
    }
}