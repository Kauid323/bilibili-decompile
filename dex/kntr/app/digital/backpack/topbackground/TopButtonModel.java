package kntr.app.digital.backpack.topbackground;

import BottomSheetItemData$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.DrawableResource;

/* compiled from: TopBackgroundModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u001f"}, d2 = {"Lkntr/app/digital/backpack/topbackground/TopButtonModel;", RoomRecommendViewModel.EMPTY_CURSOR, "url", RoomRecommendViewModel.EMPTY_CURSOR, "icon", "Lorg/jetbrains/compose/resources/DrawableResource;", "title", "hasDot", RoomRecommendViewModel.EMPTY_CURSOR, "eventId", "<init>", "(Ljava/lang/String;Lorg/jetbrains/compose/resources/DrawableResource;Ljava/lang/String;ZLjava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getIcon", "()Lorg/jetbrains/compose/resources/DrawableResource;", "getTitle", "getHasDot", "()Z", "getEventId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TopButtonModel {
    public static final int $stable = 0;
    private final String eventId;
    private final boolean hasDot;
    private final DrawableResource icon;
    private final String title;
    private final String url;

    public static /* synthetic */ TopButtonModel copy$default(TopButtonModel topButtonModel, String str, DrawableResource drawableResource, String str2, boolean z, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = topButtonModel.url;
        }
        if ((i & 2) != 0) {
            drawableResource = topButtonModel.icon;
        }
        DrawableResource drawableResource2 = drawableResource;
        if ((i & 4) != 0) {
            str2 = topButtonModel.title;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            z = topButtonModel.hasDot;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            str3 = topButtonModel.eventId;
        }
        return topButtonModel.copy(str, drawableResource2, str4, z2, str3);
    }

    public final String component1() {
        return this.url;
    }

    public final DrawableResource component2() {
        return this.icon;
    }

    public final String component3() {
        return this.title;
    }

    public final boolean component4() {
        return this.hasDot;
    }

    public final String component5() {
        return this.eventId;
    }

    public final TopButtonModel copy(String str, DrawableResource drawableResource, String str2, boolean z, String str3) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(drawableResource, "icon");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "eventId");
        return new TopButtonModel(str, drawableResource, str2, z, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TopButtonModel) {
            TopButtonModel topButtonModel = (TopButtonModel) obj;
            return Intrinsics.areEqual(this.url, topButtonModel.url) && Intrinsics.areEqual(this.icon, topButtonModel.icon) && Intrinsics.areEqual(this.title, topButtonModel.title) && this.hasDot == topButtonModel.hasDot && Intrinsics.areEqual(this.eventId, topButtonModel.eventId);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.url.hashCode() * 31) + this.icon.hashCode()) * 31) + this.title.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasDot)) * 31) + this.eventId.hashCode();
    }

    public String toString() {
        String str = this.url;
        DrawableResource drawableResource = this.icon;
        String str2 = this.title;
        boolean z = this.hasDot;
        return "TopButtonModel(url=" + str + ", icon=" + drawableResource + ", title=" + str2 + ", hasDot=" + z + ", eventId=" + this.eventId + ")";
    }

    public TopButtonModel(String url, DrawableResource icon, String title, boolean hasDot, String eventId) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        this.url = url;
        this.icon = icon;
        this.title = title;
        this.hasDot = hasDot;
        this.eventId = eventId;
    }

    public final String getUrl() {
        return this.url;
    }

    public final DrawableResource getIcon() {
        return this.icon;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean getHasDot() {
        return this.hasDot;
    }

    public final String getEventId() {
        return this.eventId;
    }
}