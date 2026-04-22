package kntr.app.digital.preview.usage;

import java.lang.annotation.Annotation;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.json.JsonClassDiscriminator;

/* compiled from: UsageMenuData.kt */
@JsonClassDiscriminator(discriminator = "action_type")
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bq\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R%\u0010\u0006\u001a\u00150\u0007j\u0002`\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u0007\u0015\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001cÀ\u0006\u0003"}, d2 = {"Lkntr/app/digital/preview/usage/UsageMenuItem;", RoomRecommendViewModel.EMPTY_CURSOR, "title", RoomRecommendViewModel.EMPTY_CURSOR, "getTitle", "()Ljava/lang/String;", "usable", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/Serializable;", "with", "Lkotlin/reflect/KClass;", "Lcom/bilibili/ogv/bpf/serialization/BooleanAsInt;", "getUsable", "()Z", "toast", "getToast", "badge", "Lkntr/app/digital/preview/usage/Badge;", "getBadge", "()Lkntr/app/digital/preview/usage/Badge;", "Companion", "Lkntr/app/digital/preview/usage/AvatarChanged;", "Lkntr/app/digital/preview/usage/Comment;", "Lkntr/app/digital/preview/usage/Dynamics;", "Lkntr/app/digital/preview/usage/HeaderChanged;", "Lkntr/app/digital/preview/usage/Splash;", "Lkntr/app/digital/preview/usage/Wallpaper;", "Lkntr/app/digital/preview/usage/Widget;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public interface UsageMenuItem {
    public static final Companion Companion = Companion.$$INSTANCE;

    Badge getBadge();

    String getTitle();

    String getToast();

    boolean getUsable();

    /* compiled from: UsageMenuData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/usage/UsageMenuItem$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/usage/UsageMenuItem;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final KSerializer<UsageMenuItem> serializer() {
            return new SealedClassSerializer<>("kntr.app.digital.preview.usage.UsageMenuItem", Reflection.getOrCreateKotlinClass(UsageMenuItem.class), new KClass[]{Reflection.getOrCreateKotlinClass(AvatarChanged.class), Reflection.getOrCreateKotlinClass(Comment.class), Reflection.getOrCreateKotlinClass(Dynamics.class), Reflection.getOrCreateKotlinClass(HeaderChanged.class), Reflection.getOrCreateKotlinClass(Splash.class), Reflection.getOrCreateKotlinClass(Wallpaper.class), Reflection.getOrCreateKotlinClass(Widget.class)}, new KSerializer[]{AvatarChanged$$serializer.INSTANCE, Comment$$serializer.INSTANCE, Dynamics$$serializer.INSTANCE, HeaderChanged$$serializer.INSTANCE, Splash$$serializer.INSTANCE, Wallpaper$$serializer.INSTANCE, Widget$$serializer.INSTANCE}, new Annotation[]{new UsageMenuItem$Companion$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0("action_type")});
        }
    }
}