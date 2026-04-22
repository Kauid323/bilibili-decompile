package srcs.app.game.gamebiz.generated.resources;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.DrawableResource;
import tv.danmaku.bili.BR;

/* compiled from: Drawable0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0013"}, d2 = {"Lsrcs/app/game/gamebiz/generated/resources/CommonMainDrawable0;", "", "<init>", "()V", "cover_steam_default", "Lorg/jetbrains/compose/resources/DrawableResource;", "getCover_steam_default", "()Lorg/jetbrains/compose/resources/DrawableResource;", "cover_steam_default$delegate", "Lkotlin/Lazy;", "cover_steam_game", "getCover_steam_game", "cover_steam_game$delegate", "steam_radiobox", "getSteam_radiobox", "steam_radiobox$delegate", "steam_select_radiobox", "getSteam_select_radiobox", "steam_select_radiobox$delegate", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainDrawable0 {
    public static final CommonMainDrawable0 INSTANCE = new CommonMainDrawable0();
    private static final Lazy cover_steam_default$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.game.gamebiz.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda0
        public final Object invoke() {
            DrawableResource cover_steam_default_delegate$lambda$0;
            cover_steam_default_delegate$lambda$0 = CommonMainDrawable0.cover_steam_default_delegate$lambda$0();
            return cover_steam_default_delegate$lambda$0;
        }
    });
    private static final Lazy cover_steam_game$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.game.gamebiz.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda1
        public final Object invoke() {
            DrawableResource cover_steam_game_delegate$lambda$0;
            cover_steam_game_delegate$lambda$0 = CommonMainDrawable0.cover_steam_game_delegate$lambda$0();
            return cover_steam_game_delegate$lambda$0;
        }
    });
    private static final Lazy steam_radiobox$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.game.gamebiz.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda2
        public final Object invoke() {
            DrawableResource steam_radiobox_delegate$lambda$0;
            steam_radiobox_delegate$lambda$0 = CommonMainDrawable0.steam_radiobox_delegate$lambda$0();
            return steam_radiobox_delegate$lambda$0;
        }
    });
    private static final Lazy steam_select_radiobox$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.game.gamebiz.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda3
        public final Object invoke() {
            DrawableResource steam_select_radiobox_delegate$lambda$0;
            steam_select_radiobox_delegate$lambda$0 = CommonMainDrawable0.steam_select_radiobox_delegate$lambda$0();
            return steam_select_radiobox_delegate$lambda$0;
        }
    });

    private CommonMainDrawable0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource cover_steam_default_delegate$lambda$0() {
        DrawableResource init_cover_steam_default;
        init_cover_steam_default = Drawable0_commonMainKt.init_cover_steam_default();
        return init_cover_steam_default;
    }

    public final DrawableResource getCover_steam_default() {
        return (DrawableResource) cover_steam_default$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource cover_steam_game_delegate$lambda$0() {
        DrawableResource init_cover_steam_game;
        init_cover_steam_game = Drawable0_commonMainKt.init_cover_steam_game();
        return init_cover_steam_game;
    }

    public final DrawableResource getCover_steam_game() {
        return (DrawableResource) cover_steam_game$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource steam_radiobox_delegate$lambda$0() {
        DrawableResource init_steam_radiobox;
        init_steam_radiobox = Drawable0_commonMainKt.init_steam_radiobox();
        return init_steam_radiobox;
    }

    public final DrawableResource getSteam_radiobox() {
        return (DrawableResource) steam_radiobox$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource steam_select_radiobox_delegate$lambda$0() {
        DrawableResource init_steam_select_radiobox;
        init_steam_select_radiobox = Drawable0_commonMainKt.init_steam_select_radiobox();
        return init_steam_select_radiobox;
    }

    public final DrawableResource getSteam_select_radiobox() {
        return (DrawableResource) steam_select_radiobox$delegate.getValue();
    }
}