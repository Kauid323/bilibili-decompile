package kntr.common.ouro.ui.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ImageResourcesKt;
import org.jetbrains.compose.resources.ResourceEnvironmentKt;

/* compiled from: DrawableResourceUtils.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"toByteArray", "", "Lorg/jetbrains/compose/resources/DrawableResource;", "(Lorg/jetbrains/compose/resources/DrawableResource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DrawableResourceUtilsKt {
    public static final Object toByteArray(DrawableResource $this$toByteArray, Continuation<? super byte[]> continuation) {
        return ImageResourcesKt.getDrawableResourceBytes(ResourceEnvironmentKt.getSystemResourceEnvironment(), $this$toByteArray, continuation);
    }
}