package kntr.watch.later.watchlater.api;

import kntr.app.upcomingEpisode.ConstantsKt;
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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: TranslateApi.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 02\u00020\u0001:\u0002/0B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tBA\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011R&\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u001c¨\u00061"}, d2 = {"Lkntr/watch/later/watchlater/api/TranslateInfo;", "", "originText", "", "translateState", "", "translateText", "translateTitle", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOriginText$annotations", "()V", "getOriginText", "()Ljava/lang/String;", "getTranslateState$annotations", "getTranslateState", "()I", "setTranslateState", "(I)V", "getTranslateText$annotations", "getTranslateText", "getTranslateTitle$annotations", "getTranslateTitle", "setTranslateTitle", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$watch_later_debug", "$serializer", "Companion", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class TranslateInfo {
    private final String originText;
    private int translateState;
    private final String translateText;
    private String translateTitle;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ TranslateInfo copy$default(TranslateInfo translateInfo, String str, int i, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = translateInfo.originText;
        }
        if ((i2 & 2) != 0) {
            i = translateInfo.translateState;
        }
        if ((i2 & 4) != 0) {
            str2 = translateInfo.translateText;
        }
        if ((i2 & 8) != 0) {
            str3 = translateInfo.translateTitle;
        }
        return translateInfo.copy(str, i, str2, str3);
    }

    @SerialName("origin_text")
    public static /* synthetic */ void getOriginText$annotations() {
    }

    @SerialName("translate_state")
    public static /* synthetic */ void getTranslateState$annotations() {
    }

    @SerialName("translate_text")
    public static /* synthetic */ void getTranslateText$annotations() {
    }

    @SerialName("translate_title")
    public static /* synthetic */ void getTranslateTitle$annotations() {
    }

    public final String component1() {
        return this.originText;
    }

    public final int component2() {
        return this.translateState;
    }

    public final String component3() {
        return this.translateText;
    }

    public final String component4() {
        return this.translateTitle;
    }

    public final TranslateInfo copy(String str, int i, String str2, String str3) {
        return new TranslateInfo(str, i, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TranslateInfo) {
            TranslateInfo translateInfo = (TranslateInfo) obj;
            return Intrinsics.areEqual(this.originText, translateInfo.originText) && this.translateState == translateInfo.translateState && Intrinsics.areEqual(this.translateText, translateInfo.translateText) && Intrinsics.areEqual(this.translateTitle, translateInfo.translateTitle);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.originText == null ? 0 : this.originText.hashCode()) * 31) + this.translateState) * 31) + (this.translateText == null ? 0 : this.translateText.hashCode())) * 31) + (this.translateTitle != null ? this.translateTitle.hashCode() : 0);
    }

    public String toString() {
        String str = this.originText;
        int i = this.translateState;
        String str2 = this.translateText;
        return "TranslateInfo(originText=" + str + ", translateState=" + i + ", translateText=" + str2 + ", translateTitle=" + this.translateTitle + ")";
    }

    /* compiled from: TranslateApi.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/watch/later/watchlater/api/TranslateInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/watch/later/watchlater/api/TranslateInfo;", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TranslateInfo> serializer() {
            return TranslateInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ TranslateInfo(int seen0, String originText, int translateState, String translateText, String translateTitle, SerializationConstructorMarker serializationConstructorMarker) {
        if (13 != (seen0 & 13)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 13, TranslateInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.originText = originText;
        if ((seen0 & 2) == 0) {
            this.translateState = 0;
        } else {
            this.translateState = translateState;
        }
        this.translateText = translateText;
        this.translateTitle = translateTitle;
    }

    public TranslateInfo(String originText, int translateState, String translateText, String translateTitle) {
        this.originText = originText;
        this.translateState = translateState;
        this.translateText = translateText;
        this.translateTitle = translateTitle;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$watch_later_debug(TranslateInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.originText);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.translateState != 0) {
            output.encodeIntElement(serialDesc, 1, self.translateState);
        }
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.translateText);
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.translateTitle);
    }

    public /* synthetic */ TranslateInfo(String str, int i, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : i, str2, str3);
    }

    public final String getOriginText() {
        return this.originText;
    }

    public final int getTranslateState() {
        return this.translateState;
    }

    public final void setTranslateState(int i) {
        this.translateState = i;
    }

    public final String getTranslateText() {
        return this.translateText;
    }

    public final String getTranslateTitle() {
        return this.translateTitle;
    }

    public final void setTranslateTitle(String str) {
        this.translateTitle = str;
    }
}