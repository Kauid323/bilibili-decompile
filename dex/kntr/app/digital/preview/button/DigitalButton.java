package kntr.app.digital.preview.button;

import androidx.compose.ui.graphics.Color;
import java.util.List;
import kntr.app.digital.preview.action.Action;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DigitalButton.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0015\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lkntr/app/digital/preview/button/DigitalButton;", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "textColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "backgroundColor", RoomRecommendViewModel.EMPTY_CURSOR, "badgeImageUrl", "action", "Lkntr/app/digital/preview/action/Action;", "<init>", "(Ljava/lang/String;JJLjava/util/List;Ljava/lang/String;Lkntr/app/digital/preview/action/Action;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getText", "()Ljava/lang/String;", "getTextColor-0d7_KjU", "()J", "J", "getBorderColor-0d7_KjU", "getBackgroundColor", "()Ljava/util/List;", "getBadgeImageUrl", "getAction", "()Lkntr/app/digital/preview/action/Action;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalButton {
    public static final int $stable = 8;
    private final Action<?> action;
    private final List<Color> backgroundColor;
    private final String badgeImageUrl;
    private final long borderColor;
    private final String text;
    private final long textColor;

    public /* synthetic */ DigitalButton(String str, long j2, long j3, List list, String str2, Action action, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j2, j3, list, str2, action);
    }

    private DigitalButton(String text, long textColor, long borderColor, List<Color> list, String badgeImageUrl, Action<?> action) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(badgeImageUrl, "badgeImageUrl");
        Intrinsics.checkNotNullParameter(action, "action");
        this.text = text;
        this.textColor = textColor;
        this.borderColor = borderColor;
        this.backgroundColor = list;
        this.badgeImageUrl = badgeImageUrl;
        this.action = action;
    }

    public /* synthetic */ DigitalButton(String str, long j2, long j3, List list, String str2, Action action, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j2, (i & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : j3, (i & 8) != 0 ? null : list, (i & 16) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, action, null);
    }

    public final String getText() {
        return this.text;
    }

    /* renamed from: getTextColor-0d7_KjU  reason: not valid java name */
    public final long m922getTextColor0d7_KjU() {
        return this.textColor;
    }

    /* renamed from: getBorderColor-0d7_KjU  reason: not valid java name */
    public final long m921getBorderColor0d7_KjU() {
        return this.borderColor;
    }

    public final List<Color> getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getBadgeImageUrl() {
        return this.badgeImageUrl;
    }

    public final Action<?> getAction() {
        return this.action;
    }
}