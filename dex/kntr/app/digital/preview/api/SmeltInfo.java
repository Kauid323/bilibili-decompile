package kntr.app.digital.preview.api;

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

/* compiled from: CardPreviewModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 (2\u00020\u0001:\u0002'(B.\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u001b\b\u0002\u0010\u0004\u001a\u00150\u0005j\u0002`\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\t0\b¢\u0006\u0004\b\n\u0010\u000bB-\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u001c\u0010\u0019\u001a\u00150\u0005j\u0002`\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\t0\bHÆ\u0003J0\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001b\b\u0002\u0010\u0004\u001a\u00150\u0005j\u0002`\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\t0\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\rHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R/\u0010\u0004\u001a\u00150\u0005j\u0002`\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\t0\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017¨\u0006)"}, d2 = {"Lkntr/app/digital/preview/api/SmeltInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "renderUrl", RoomRecommendViewModel.EMPTY_CURSOR, "hasSmeltedParams", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/Serializable;", "with", "Lkotlin/reflect/KClass;", "Lcom/bilibili/ogv/bpf/serialization/BooleanAsInt;", "<init>", "(Ljava/lang/String;Z)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRenderUrl$annotations", "()V", "getRenderUrl", "()Ljava/lang/String;", "getHasSmeltedParams$annotations", "getHasSmeltedParams", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class SmeltInfo {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final boolean hasSmeltedParams;
    private final String renderUrl;

    public SmeltInfo() {
        this((String) null, false, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SmeltInfo copy$default(SmeltInfo smeltInfo, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = smeltInfo.renderUrl;
        }
        if ((i & 2) != 0) {
            z = smeltInfo.hasSmeltedParams;
        }
        return smeltInfo.copy(str, z);
    }

    @SerialName("has_smelted_params")
    public static /* synthetic */ void getHasSmeltedParams$annotations() {
    }

    @SerialName("render_url")
    public static /* synthetic */ void getRenderUrl$annotations() {
    }

    public final String component1() {
        return this.renderUrl;
    }

    public final boolean component2() {
        return this.hasSmeltedParams;
    }

    public final SmeltInfo copy(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "renderUrl");
        return new SmeltInfo(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SmeltInfo) {
            SmeltInfo smeltInfo = (SmeltInfo) obj;
            return Intrinsics.areEqual(this.renderUrl, smeltInfo.renderUrl) && this.hasSmeltedParams == smeltInfo.hasSmeltedParams;
        }
        return false;
    }

    public int hashCode() {
        return (this.renderUrl.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasSmeltedParams);
    }

    public String toString() {
        String str = this.renderUrl;
        return "SmeltInfo(renderUrl=" + str + ", hasSmeltedParams=" + this.hasSmeltedParams + ")";
    }

    /* compiled from: CardPreviewModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/api/SmeltInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/api/SmeltInfo;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SmeltInfo> serializer() {
            return SmeltInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SmeltInfo(int seen0, String renderUrl, boolean hasSmeltedParams, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.renderUrl = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.renderUrl = renderUrl;
        }
        if ((seen0 & 2) == 0) {
            this.hasSmeltedParams = false;
        } else {
            this.hasSmeltedParams = hasSmeltedParams;
        }
    }

    public SmeltInfo(String renderUrl, boolean hasSmeltedParams) {
        Intrinsics.checkNotNullParameter(renderUrl, "renderUrl");
        this.renderUrl = renderUrl;
        this.hasSmeltedParams = hasSmeltedParams;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$preview_debug(SmeltInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.renderUrl, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 0, self.renderUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.hasSmeltedParams) {
            output.encodeSerializableElement(serialDesc, 1, BooleanAsIntSerializer.INSTANCE, Boolean.valueOf(self.hasSmeltedParams));
        }
    }

    public /* synthetic */ SmeltInfo(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? false : z);
    }

    public final String getRenderUrl() {
        return this.renderUrl;
    }

    public final boolean getHasSmeltedParams() {
        return this.hasSmeltedParams;
    }
}