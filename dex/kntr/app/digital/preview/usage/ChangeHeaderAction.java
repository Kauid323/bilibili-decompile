package kntr.app.digital.preview.usage;

import BottomSheetItemData$;
import com.bilibili.ogv.bpf.serialization.BooleanAsIntSerializer;
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

/* compiled from: ChangeAvatarActionModule.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 02\u00020\u0001:\u0002/0BB\u0012\u001b\b\u0002\u0010\u0002\u001a\u00150\u0003j\u0002`\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\t0\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rBA\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u001c\u0010\u001e\u001a\u00150\u0003j\u0002`\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\t0\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003JD\u0010\"\u001a\u00020\u00002\u001b\b\u0002\u0010\u0002\u001a\u00150\u0003j\u0002`\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\t0\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u000fHÖ\u0001J\t\u0010&\u001a\u00020\tHÖ\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R/\u0010\u0002\u001a\u00150\u0003j\u0002`\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\t0\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0019R\u001c\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0019¨\u00061"}, d2 = {"Lkntr/app/digital/preview/usage/ChangeHeaderAction;", RoomRecommendViewModel.EMPTY_CURSOR, "hasLimitDialog", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/Serializable;", "with", "Lkotlin/reflect/KClass;", "Lcom/bilibili/ogv/bpf/serialization/BooleanAsInt;", "limitDialogTitle", RoomRecommendViewModel.EMPTY_CURSOR, "limitDialogTime", "spaceBgSetUrl", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getHasLimitDialog$annotations", "()V", "getHasLimitDialog", "()Z", "getLimitDialogTitle$annotations", "getLimitDialogTitle", "()Ljava/lang/String;", "getLimitDialogTime$annotations", "getLimitDialogTime", "getSpaceBgSetUrl$annotations", "getSpaceBgSetUrl", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class ChangeHeaderAction {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final boolean hasLimitDialog;
    private final String limitDialogTime;
    private final String limitDialogTitle;
    private final String spaceBgSetUrl;

    public ChangeHeaderAction() {
        this(false, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ChangeHeaderAction copy$default(ChangeHeaderAction changeHeaderAction, boolean z, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = changeHeaderAction.hasLimitDialog;
        }
        if ((i & 2) != 0) {
            str = changeHeaderAction.limitDialogTitle;
        }
        if ((i & 4) != 0) {
            str2 = changeHeaderAction.limitDialogTime;
        }
        if ((i & 8) != 0) {
            str3 = changeHeaderAction.spaceBgSetUrl;
        }
        return changeHeaderAction.copy(z, str, str2, str3);
    }

    @SerialName("has_limit_dialog")
    public static /* synthetic */ void getHasLimitDialog$annotations() {
    }

    @SerialName("limit_dialog_time")
    public static /* synthetic */ void getLimitDialogTime$annotations() {
    }

    @SerialName("limit_dialog_title")
    public static /* synthetic */ void getLimitDialogTitle$annotations() {
    }

    @SerialName("space_bg_set_url")
    public static /* synthetic */ void getSpaceBgSetUrl$annotations() {
    }

    public final boolean component1() {
        return this.hasLimitDialog;
    }

    public final String component2() {
        return this.limitDialogTitle;
    }

    public final String component3() {
        return this.limitDialogTime;
    }

    public final String component4() {
        return this.spaceBgSetUrl;
    }

    public final ChangeHeaderAction copy(boolean z, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "limitDialogTitle");
        Intrinsics.checkNotNullParameter(str2, "limitDialogTime");
        Intrinsics.checkNotNullParameter(str3, "spaceBgSetUrl");
        return new ChangeHeaderAction(z, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChangeHeaderAction) {
            ChangeHeaderAction changeHeaderAction = (ChangeHeaderAction) obj;
            return this.hasLimitDialog == changeHeaderAction.hasLimitDialog && Intrinsics.areEqual(this.limitDialogTitle, changeHeaderAction.limitDialogTitle) && Intrinsics.areEqual(this.limitDialogTime, changeHeaderAction.limitDialogTime) && Intrinsics.areEqual(this.spaceBgSetUrl, changeHeaderAction.spaceBgSetUrl);
        }
        return false;
    }

    public int hashCode() {
        return (((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasLimitDialog) * 31) + this.limitDialogTitle.hashCode()) * 31) + this.limitDialogTime.hashCode()) * 31) + this.spaceBgSetUrl.hashCode();
    }

    public String toString() {
        boolean z = this.hasLimitDialog;
        String str = this.limitDialogTitle;
        String str2 = this.limitDialogTime;
        return "ChangeHeaderAction(hasLimitDialog=" + z + ", limitDialogTitle=" + str + ", limitDialogTime=" + str2 + ", spaceBgSetUrl=" + this.spaceBgSetUrl + ")";
    }

    /* compiled from: ChangeAvatarActionModule.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/usage/ChangeHeaderAction$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/usage/ChangeHeaderAction;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ChangeHeaderAction> serializer() {
            return ChangeHeaderAction$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ChangeHeaderAction(int seen0, boolean hasLimitDialog, String limitDialogTitle, String limitDialogTime, String spaceBgSetUrl, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.hasLimitDialog = false;
        } else {
            this.hasLimitDialog = hasLimitDialog;
        }
        if ((seen0 & 2) == 0) {
            this.limitDialogTitle = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.limitDialogTitle = limitDialogTitle;
        }
        if ((seen0 & 4) == 0) {
            this.limitDialogTime = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.limitDialogTime = limitDialogTime;
        }
        if ((seen0 & 8) == 0) {
            this.spaceBgSetUrl = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.spaceBgSetUrl = spaceBgSetUrl;
        }
    }

    public ChangeHeaderAction(boolean hasLimitDialog, String limitDialogTitle, String limitDialogTime, String spaceBgSetUrl) {
        Intrinsics.checkNotNullParameter(limitDialogTitle, "limitDialogTitle");
        Intrinsics.checkNotNullParameter(limitDialogTime, "limitDialogTime");
        Intrinsics.checkNotNullParameter(spaceBgSetUrl, "spaceBgSetUrl");
        this.hasLimitDialog = hasLimitDialog;
        this.limitDialogTitle = limitDialogTitle;
        this.limitDialogTime = limitDialogTime;
        this.spaceBgSetUrl = spaceBgSetUrl;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$preview_debug(ChangeHeaderAction self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.hasLimitDialog) {
            output.encodeSerializableElement(serialDesc, 0, BooleanAsIntSerializer.INSTANCE, Boolean.valueOf(self.hasLimitDialog));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.limitDialogTitle, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 1, self.limitDialogTitle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.limitDialogTime, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.limitDialogTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.spaceBgSetUrl, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 3, self.spaceBgSetUrl);
        }
    }

    public /* synthetic */ ChangeHeaderAction(boolean z, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i & 8) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3);
    }

    public final boolean getHasLimitDialog() {
        return this.hasLimitDialog;
    }

    public final String getLimitDialogTitle() {
        return this.limitDialogTitle;
    }

    public final String getLimitDialogTime() {
        return this.limitDialogTime;
    }

    public final String getSpaceBgSetUrl() {
        return this.spaceBgSetUrl;
    }
}