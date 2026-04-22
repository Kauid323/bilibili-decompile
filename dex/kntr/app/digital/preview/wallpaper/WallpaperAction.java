package kntr.app.digital.preview.wallpaper;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: WallpaperActionModule.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006$"}, d2 = {"Lkntr/app/digital/preview/wallpaper/WallpaperAction;", RoomRecommendViewModel.EMPTY_CURSOR, "downloadImageLink", RoomRecommendViewModel.EMPTY_CURSOR, "downloadVideoLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDownloadImageLink$annotations", "()V", "getDownloadImageLink", "()Ljava/lang/String;", "getDownloadVideoLink$annotations", "getDownloadVideoLink", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class WallpaperAction {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String downloadImageLink;
    private final String downloadVideoLink;

    public WallpaperAction() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WallpaperAction copy$default(WallpaperAction wallpaperAction, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = wallpaperAction.downloadImageLink;
        }
        if ((i & 2) != 0) {
            str2 = wallpaperAction.downloadVideoLink;
        }
        return wallpaperAction.copy(str, str2);
    }

    @SerialName("card_img_download")
    public static /* synthetic */ void getDownloadImageLink$annotations() {
    }

    @SerialName("video_list_download")
    public static /* synthetic */ void getDownloadVideoLink$annotations() {
    }

    public final String component1() {
        return this.downloadImageLink;
    }

    public final String component2() {
        return this.downloadVideoLink;
    }

    public final WallpaperAction copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "downloadImageLink");
        Intrinsics.checkNotNullParameter(str2, "downloadVideoLink");
        return new WallpaperAction(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WallpaperAction) {
            WallpaperAction wallpaperAction = (WallpaperAction) obj;
            return Intrinsics.areEqual(this.downloadImageLink, wallpaperAction.downloadImageLink) && Intrinsics.areEqual(this.downloadVideoLink, wallpaperAction.downloadVideoLink);
        }
        return false;
    }

    public int hashCode() {
        return (this.downloadImageLink.hashCode() * 31) + this.downloadVideoLink.hashCode();
    }

    public String toString() {
        String str = this.downloadImageLink;
        return "WallpaperAction(downloadImageLink=" + str + ", downloadVideoLink=" + this.downloadVideoLink + ")";
    }

    /* compiled from: WallpaperActionModule.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/wallpaper/WallpaperAction$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/wallpaper/WallpaperAction;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<WallpaperAction> serializer() {
            return WallpaperAction$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ WallpaperAction(int seen0, String downloadImageLink, String downloadVideoLink, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.downloadImageLink = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.downloadImageLink = downloadImageLink;
        }
        if ((seen0 & 2) == 0) {
            this.downloadVideoLink = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.downloadVideoLink = downloadVideoLink;
        }
    }

    public WallpaperAction(String downloadImageLink, String downloadVideoLink) {
        Intrinsics.checkNotNullParameter(downloadImageLink, "downloadImageLink");
        Intrinsics.checkNotNullParameter(downloadVideoLink, "downloadVideoLink");
        this.downloadImageLink = downloadImageLink;
        this.downloadVideoLink = downloadVideoLink;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$preview_debug(WallpaperAction self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.downloadImageLink, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 0, self.downloadImageLink);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.downloadVideoLink, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 1, self.downloadVideoLink);
        }
    }

    public /* synthetic */ WallpaperAction(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2);
    }

    public final String getDownloadImageLink() {
        return this.downloadImageLink;
    }

    public final String getDownloadVideoLink() {
        return this.downloadVideoLink;
    }
}