package video.biz.offline.list.ui.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineBadge.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/ui/widget/OfflineBadgeModel;", "", "text", "", "icon", "Lvideo/biz/offline/list/ui/widget/IconType;", "<init>", "(Ljava/lang/String;Lvideo/biz/offline/list/ui/widget/IconType;)V", "getText", "()Ljava/lang/String;", "getIcon", "()Lvideo/biz/offline/list/ui/widget/IconType;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineBadgeModel {
    public static final int $stable = 8;
    private final IconType icon;
    private final String text;

    public OfflineBadgeModel(String text, IconType icon) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.icon = icon;
    }

    public /* synthetic */ OfflineBadgeModel(String str, IconType iconType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : iconType);
    }

    public final String getText() {
        return this.text;
    }

    public final IconType getIcon() {
        return this.icon;
    }
}