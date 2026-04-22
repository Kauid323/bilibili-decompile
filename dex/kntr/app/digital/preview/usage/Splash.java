package kntr.app.digital.preview.usage;

import BottomSheetItemData$;
import com.bilibili.ogv.bpf.serialization.BooleanAsIntSerializer;
import kntr.app.digital.preview.splashsetting.SplashSettingAction;
import kntr.app.digital.preview.splashsetting.SplashSettingAction$$serializer;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: UsageMenuData.kt */
@SerialName("splash")
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 72\u00020\u0001:\u000267BL\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u001b\b\u0002\u0010\u0004\u001a\u00150\u0005j\u0002`\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010BK\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u001c\u0010$\u001a\u00150\u0005j\u0002`\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\t0\bHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003JP\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001b\b\u0002\u0010\u0004\u001a\u00150\u0005j\u0002`\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u0012HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R/\u0010\u0004\u001a\u00150\u0005j\u0002`\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\t0\b8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\n\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u0017R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00068"}, d2 = {"Lkntr/app/digital/preview/usage/Splash;", "Lkntr/app/digital/preview/usage/UsageMenuItem;", "title", RoomRecommendViewModel.EMPTY_CURSOR, "usable", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/Serializable;", "with", "Lkotlin/reflect/KClass;", "Lcom/bilibili/ogv/bpf/serialization/BooleanAsInt;", "toast", "badge", "Lkntr/app/digital/preview/usage/Badge;", "data", "Lkntr/app/digital/preview/splashsetting/SplashSettingAction;", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Lkntr/app/digital/preview/usage/Badge;Lkntr/app/digital/preview/splashsetting/SplashSettingAction;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLjava/lang/String;Lkntr/app/digital/preview/usage/Badge;Lkntr/app/digital/preview/splashsetting/SplashSettingAction;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle", "()Ljava/lang/String;", "getUsable$annotations", "()V", "getUsable", "()Z", "getToast$annotations", "getToast", "getBadge$annotations", "getBadge", "()Lkntr/app/digital/preview/usage/Badge;", "getData", "()Lkntr/app/digital/preview/splashsetting/SplashSettingAction;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class Splash implements UsageMenuItem {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final Badge badge;
    private final SplashSettingAction data;
    private final String title;
    private final String toast;
    private final boolean usable;

    public static /* synthetic */ Splash copy$default(Splash splash, String str, boolean z, String str2, Badge badge, SplashSettingAction splashSettingAction, int i, Object obj) {
        if ((i & 1) != 0) {
            str = splash.title;
        }
        if ((i & 2) != 0) {
            z = splash.usable;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            str2 = splash.toast;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            badge = splash.badge;
        }
        Badge badge2 = badge;
        if ((i & 16) != 0) {
            splashSettingAction = splash.data;
        }
        return splash.copy(str, z2, str3, badge2, splashSettingAction);
    }

    @SerialName("tips")
    public static /* synthetic */ void getBadge$annotations() {
    }

    @SerialName("click_toast")
    public static /* synthetic */ void getToast$annotations() {
    }

    @SerialName("can_set")
    public static /* synthetic */ void getUsable$annotations() {
    }

    public final String component1() {
        return this.title;
    }

    public final boolean component2() {
        return this.usable;
    }

    public final String component3() {
        return this.toast;
    }

    public final Badge component4() {
        return this.badge;
    }

    public final SplashSettingAction component5() {
        return this.data;
    }

    public final Splash copy(String str, boolean z, String str2, Badge badge, SplashSettingAction splashSettingAction) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "toast");
        Intrinsics.checkNotNullParameter(splashSettingAction, "data");
        return new Splash(str, z, str2, badge, splashSettingAction);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Splash) {
            Splash splash = (Splash) obj;
            return Intrinsics.areEqual(this.title, splash.title) && this.usable == splash.usable && Intrinsics.areEqual(this.toast, splash.toast) && Intrinsics.areEqual(this.badge, splash.badge) && Intrinsics.areEqual(this.data, splash.data);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.title.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.usable)) * 31) + this.toast.hashCode()) * 31) + (this.badge == null ? 0 : this.badge.hashCode())) * 31) + this.data.hashCode();
    }

    public String toString() {
        String str = this.title;
        boolean z = this.usable;
        String str2 = this.toast;
        Badge badge = this.badge;
        return "Splash(title=" + str + ", usable=" + z + ", toast=" + str2 + ", badge=" + badge + ", data=" + this.data + ")";
    }

    /* compiled from: UsageMenuData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/usage/Splash$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/usage/Splash;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Splash> serializer() {
            return Splash$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Splash(int seen0, String title, boolean usable, String toast, Badge badge, SplashSettingAction data, SerializationConstructorMarker serializationConstructorMarker) {
        if (16 != (seen0 & 16)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 16, Splash$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen0 & 1) == 0) {
            this.title = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.title = title;
        }
        if ((seen0 & 2) == 0) {
            this.usable = false;
        } else {
            this.usable = usable;
        }
        if ((seen0 & 4) == 0) {
            this.toast = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.toast = toast;
        }
        if ((seen0 & 8) == 0) {
            this.badge = null;
        } else {
            this.badge = badge;
        }
        this.data = data;
    }

    public Splash(String title, boolean usable, String toast, Badge badge, SplashSettingAction data) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(toast, "toast");
        Intrinsics.checkNotNullParameter(data, "data");
        this.title = title;
        this.usable = usable;
        this.toast = toast;
        this.badge = badge;
        this.data = data;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$preview_debug(Splash self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.getTitle(), RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 0, self.getTitle());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.getUsable()) {
            output.encodeSerializableElement(serialDesc, 1, BooleanAsIntSerializer.INSTANCE, Boolean.valueOf(self.getUsable()));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.getToast(), RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.getToast());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.getBadge() != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, Badge$$serializer.INSTANCE, self.getBadge());
        }
        output.encodeSerializableElement(serialDesc, 4, SplashSettingAction$$serializer.INSTANCE, self.data);
    }

    public /* synthetic */ Splash(String str, boolean z, String str2, Badge badge, SplashSettingAction splashSettingAction, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i & 8) != 0 ? null : badge, splashSettingAction);
    }

    @Override // kntr.app.digital.preview.usage.UsageMenuItem
    public String getTitle() {
        return this.title;
    }

    @Override // kntr.app.digital.preview.usage.UsageMenuItem
    public boolean getUsable() {
        return this.usable;
    }

    @Override // kntr.app.digital.preview.usage.UsageMenuItem
    public String getToast() {
        return this.toast;
    }

    @Override // kntr.app.digital.preview.usage.UsageMenuItem
    public Badge getBadge() {
        return this.badge;
    }

    public final SplashSettingAction getData() {
        return this.data;
    }
}