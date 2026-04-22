package kntr.app.ad.common.model;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdLotteryCard.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006*"}, d2 = {"Lkntr/app/ad/common/model/AdTinyButton;", RoomRecommendViewModel.EMPTY_CURSOR, "bgCover", RoomRecommendViewModel.EMPTY_CURSOR, "text", "jumpDuration", RoomRecommendViewModel.EMPTY_CURSOR, "jumpUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBgCover", "()Ljava/lang/String;", "getText", "getJumpDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getJumpUrl", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lkntr/app/ad/common/model/AdTinyButton;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdTinyButton {
    public static final Companion Companion = new Companion(null);
    private final String bgCover;
    private final Integer jumpDuration;
    private final String jumpUrl;
    private final String text;

    public AdTinyButton() {
        this((String) null, (String) null, (Integer) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdTinyButton copy$default(AdTinyButton adTinyButton, String str, String str2, Integer num, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adTinyButton.bgCover;
        }
        if ((i & 2) != 0) {
            str2 = adTinyButton.text;
        }
        if ((i & 4) != 0) {
            num = adTinyButton.jumpDuration;
        }
        if ((i & 8) != 0) {
            str3 = adTinyButton.jumpUrl;
        }
        return adTinyButton.copy(str, str2, num, str3);
    }

    public final String component1() {
        return this.bgCover;
    }

    public final String component2() {
        return this.text;
    }

    public final Integer component3() {
        return this.jumpDuration;
    }

    public final String component4() {
        return this.jumpUrl;
    }

    public final AdTinyButton copy(String str, String str2, Integer num, String str3) {
        return new AdTinyButton(str, str2, num, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdTinyButton) {
            AdTinyButton adTinyButton = (AdTinyButton) obj;
            return Intrinsics.areEqual(this.bgCover, adTinyButton.bgCover) && Intrinsics.areEqual(this.text, adTinyButton.text) && Intrinsics.areEqual(this.jumpDuration, adTinyButton.jumpDuration) && Intrinsics.areEqual(this.jumpUrl, adTinyButton.jumpUrl);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.bgCover == null ? 0 : this.bgCover.hashCode()) * 31) + (this.text == null ? 0 : this.text.hashCode())) * 31) + (this.jumpDuration == null ? 0 : this.jumpDuration.hashCode())) * 31) + (this.jumpUrl != null ? this.jumpUrl.hashCode() : 0);
    }

    public String toString() {
        String str = this.bgCover;
        String str2 = this.text;
        Integer num = this.jumpDuration;
        return "AdTinyButton(bgCover=" + str + ", text=" + str2 + ", jumpDuration=" + num + ", jumpUrl=" + this.jumpUrl + ")";
    }

    /* compiled from: AdLotteryCard.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdTinyButton$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdTinyButton;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdTinyButton> serializer() {
            return AdTinyButton$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdTinyButton(int seen0, String bgCover, String text, Integer jumpDuration, String jumpUrl, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.bgCover = null;
        } else {
            this.bgCover = bgCover;
        }
        if ((seen0 & 2) == 0) {
            this.text = null;
        } else {
            this.text = text;
        }
        if ((seen0 & 4) == 0) {
            this.jumpDuration = 0;
        } else {
            this.jumpDuration = jumpDuration;
        }
        if ((seen0 & 8) == 0) {
            this.jumpUrl = null;
        } else {
            this.jumpUrl = jumpUrl;
        }
    }

    public AdTinyButton(String bgCover, String text, Integer jumpDuration, String jumpUrl) {
        this.bgCover = bgCover;
        this.text = text;
        this.jumpDuration = jumpDuration;
        this.jumpUrl = jumpUrl;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdTinyButton self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Integer num;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.bgCover != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.bgCover);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.text != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.text);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || (num = self.jumpDuration) == null || num.intValue() != 0) {
            output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.jumpDuration);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.jumpUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.jumpUrl);
        }
    }

    public /* synthetic */ AdTinyButton(String str, String str2, Integer num, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? 0 : num, (i & 8) != 0 ? null : str3);
    }

    public final String getBgCover() {
        return this.bgCover;
    }

    public final String getText() {
        return this.text;
    }

    public final Integer getJumpDuration() {
        return this.jumpDuration;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }
}