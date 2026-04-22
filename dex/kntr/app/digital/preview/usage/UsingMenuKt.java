package kntr.app.digital.preview.usage;

import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.action.Report;
import kntr.app.digital.preview.toast.ToastAction;
import kntr.app.digital.preview.wallpaper.WallpaperActionModule;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UsingMenu.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toUsingMenu", "Lkntr/app/digital/preview/usage/UsingMenu;", "Lkntr/app/digital/preview/usage/UsageMenuItem;", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UsingMenuKt {
    public static final UsingMenu toUsingMenu(UsageMenuItem $this$toUsingMenu) {
        Action action;
        Intrinsics.checkNotNullParameter($this$toUsingMenu, "<this>");
        boolean badgeAvailable = false;
        if ($this$toUsingMenu.getUsable()) {
            if ($this$toUsingMenu instanceof Dynamics) {
                action = new Action(((Dynamics) $this$toUsingMenu).getData(), null, 2, null);
            } else if ($this$toUsingMenu instanceof Comment) {
                action = new Action(((Comment) $this$toUsingMenu).getData(), null, 2, null);
            } else if ($this$toUsingMenu instanceof Splash) {
                action = new Action(((Splash) $this$toUsingMenu).getData(), null, 2, null);
            } else if ($this$toUsingMenu instanceof Widget) {
                action = new Action(((Widget) $this$toUsingMenu).getData(), new Report("sqzz.dressing.single-card.all.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("name", "widget"), TuplesKt.to("dlc_id", ((Widget) $this$toUsingMenu).getData().getCardTypeId())})));
            } else if ($this$toUsingMenu instanceof AvatarChanged) {
                action = new Action(((AvatarChanged) $this$toUsingMenu).getData(), new Report("sqzz.activity.main-page.use-result.show", MapsKt.mapOf(TuplesKt.to("setting_type", "1"))));
            } else if ($this$toUsingMenu instanceof HeaderChanged) {
                action = new Action(((HeaderChanged) $this$toUsingMenu).getData(), null, 2, null);
            } else if (!($this$toUsingMenu instanceof Wallpaper)) {
                throw new NoWhenBranchMatchedException();
            } else {
                action = new Action(((Wallpaper) $this$toUsingMenu).getData(), new Report("sqzz.dressing.single-card.all.click", MapsKt.mapOf(TuplesKt.to("name", "wallpaper"))));
            }
        } else {
            action = new Action(new ToastAction($this$toUsingMenu.getToast()), null, 2, null);
        }
        if ($this$toUsingMenu instanceof Wallpaper) {
            if (!WallpaperActionModule.INSTANCE.getWallpaperSettingsShowed()) {
                badgeAvailable = true;
            }
        } else if (!($this$toUsingMenu instanceof Widget)) {
            badgeAvailable = true;
        } else if (!AppWidgetActionModule.INSTANCE.getAppWidgetBadgeShowed()) {
            badgeAvailable = true;
        }
        return new UsingMenu($this$toUsingMenu.getUsable(), $this$toUsingMenu.getTitle(), badgeAvailable ? $this$toUsingMenu.getBadge() : null, action);
    }
}