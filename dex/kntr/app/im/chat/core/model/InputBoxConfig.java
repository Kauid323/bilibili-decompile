package kntr.app.im.chat.core.model;

import BottomSheetItemData$;
import com.bilibili.blens.Lens;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputBoxConfig.kt */
@Lens
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lkntr/app/im/chat/core/model/InputBoxConfig;", RoomRecommendViewModel.EMPTY_CURSOR, "hintText", RoomRecommendViewModel.EMPTY_CURSOR, "enablePic", RoomRecommendViewModel.EMPTY_CURSOR, "enableVideo", "enableSticker", "<init>", "(Ljava/lang/String;ZZZ)V", "getHintText", "()Ljava/lang/String;", "getEnablePic", "()Z", "getEnableVideo", "getEnableSticker", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InputBoxConfig {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final InputBoxConfig DEFAULT = new InputBoxConfig(RoomRecommendViewModel.EMPTY_CURSOR, false, false, false, 14, null);
    private final boolean enablePic;
    private final boolean enableSticker;
    private final boolean enableVideo;
    private final String hintText;

    public static /* synthetic */ InputBoxConfig copy$default(InputBoxConfig inputBoxConfig, String str, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inputBoxConfig.hintText;
        }
        if ((i & 2) != 0) {
            z = inputBoxConfig.enablePic;
        }
        if ((i & 4) != 0) {
            z2 = inputBoxConfig.enableVideo;
        }
        if ((i & 8) != 0) {
            z3 = inputBoxConfig.enableSticker;
        }
        return inputBoxConfig.copy(str, z, z2, z3);
    }

    public final String component1() {
        return this.hintText;
    }

    public final boolean component2() {
        return this.enablePic;
    }

    public final boolean component3() {
        return this.enableVideo;
    }

    public final boolean component4() {
        return this.enableSticker;
    }

    public final InputBoxConfig copy(String str, boolean z, boolean z2, boolean z3) {
        return new InputBoxConfig(str, z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InputBoxConfig) {
            InputBoxConfig inputBoxConfig = (InputBoxConfig) obj;
            return Intrinsics.areEqual(this.hintText, inputBoxConfig.hintText) && this.enablePic == inputBoxConfig.enablePic && this.enableVideo == inputBoxConfig.enableVideo && this.enableSticker == inputBoxConfig.enableSticker;
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.hintText == null ? 0 : this.hintText.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enablePic)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableVideo)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableSticker);
    }

    public String toString() {
        String str = this.hintText;
        boolean z = this.enablePic;
        boolean z2 = this.enableVideo;
        return "InputBoxConfig(hintText=" + str + ", enablePic=" + z + ", enableVideo=" + z2 + ", enableSticker=" + this.enableSticker + ")";
    }

    public InputBoxConfig(String hintText, boolean enablePic, boolean enableVideo, boolean enableSticker) {
        this.hintText = hintText;
        this.enablePic = enablePic;
        this.enableVideo = enableVideo;
        this.enableSticker = enableSticker;
    }

    public /* synthetic */ InputBoxConfig(String str, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3);
    }

    public final String getHintText() {
        return this.hintText;
    }

    public final boolean getEnablePic() {
        return this.enablePic;
    }

    public final boolean getEnableVideo() {
        return this.enableVideo;
    }

    public final boolean getEnableSticker() {
        return this.enableSticker;
    }

    /* compiled from: InputBoxConfig.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/app/im/chat/core/model/InputBoxConfig$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "DEFAULT", "Lkntr/app/im/chat/core/model/InputBoxConfig;", "getDEFAULT", "()Lkntr/app/im/chat/core/model/InputBoxConfig;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InputBoxConfig getDEFAULT() {
            return InputBoxConfig.DEFAULT;
        }
    }
}