package srcs.app.video.biz.offline.list.ui.generated.resources;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.DrawableResource;
import tv.danmaku.bili.BR;

/* compiled from: Drawable0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0013"}, d2 = {"Lsrcs/app/video/biz/offline/list/ui/generated/resources/CommonMainDrawable0;", "", "<init>", "()V", "card_placeholder", "Lorg/jetbrains/compose/resources/DrawableResource;", "getCard_placeholder", "()Lorg/jetbrains/compose/resources/DrawableResource;", "card_placeholder$delegate", "Lkotlin/Lazy;", "download_play", "getDownload_play", "download_play$delegate", "empty", "getEmpty", "empty$delegate", "item_selected", "getItem_selected", "item_selected$delegate", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainDrawable0 {
    public static final CommonMainDrawable0 INSTANCE = new CommonMainDrawable0();
    private static final Lazy card_placeholder$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.video.biz.offline.list.ui.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda0
        public final Object invoke() {
            DrawableResource card_placeholder_delegate$lambda$0;
            card_placeholder_delegate$lambda$0 = CommonMainDrawable0.card_placeholder_delegate$lambda$0();
            return card_placeholder_delegate$lambda$0;
        }
    });
    private static final Lazy download_play$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.video.biz.offline.list.ui.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda1
        public final Object invoke() {
            DrawableResource download_play_delegate$lambda$0;
            download_play_delegate$lambda$0 = CommonMainDrawable0.download_play_delegate$lambda$0();
            return download_play_delegate$lambda$0;
        }
    });
    private static final Lazy empty$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.video.biz.offline.list.ui.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda2
        public final Object invoke() {
            DrawableResource empty_delegate$lambda$0;
            empty_delegate$lambda$0 = CommonMainDrawable0.empty_delegate$lambda$0();
            return empty_delegate$lambda$0;
        }
    });
    private static final Lazy item_selected$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.video.biz.offline.list.ui.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda3
        public final Object invoke() {
            DrawableResource item_selected_delegate$lambda$0;
            item_selected_delegate$lambda$0 = CommonMainDrawable0.item_selected_delegate$lambda$0();
            return item_selected_delegate$lambda$0;
        }
    });

    private CommonMainDrawable0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource card_placeholder_delegate$lambda$0() {
        DrawableResource init_card_placeholder;
        init_card_placeholder = Drawable0_commonMainKt.init_card_placeholder();
        return init_card_placeholder;
    }

    public final DrawableResource getCard_placeholder() {
        return (DrawableResource) card_placeholder$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource download_play_delegate$lambda$0() {
        DrawableResource init_download_play;
        init_download_play = Drawable0_commonMainKt.init_download_play();
        return init_download_play;
    }

    public final DrawableResource getDownload_play() {
        return (DrawableResource) download_play$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource empty_delegate$lambda$0() {
        DrawableResource init_empty;
        init_empty = Drawable0_commonMainKt.init_empty();
        return init_empty;
    }

    public final DrawableResource getEmpty() {
        return (DrawableResource) empty$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource item_selected_delegate$lambda$0() {
        DrawableResource init_item_selected;
        init_item_selected = Drawable0_commonMainKt.init_item_selected();
        return init_item_selected;
    }

    public final DrawableResource getItem_selected() {
        return (DrawableResource) item_selected$delegate.getValue();
    }
}