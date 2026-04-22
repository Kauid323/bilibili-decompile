package kntr.watch.later.watchlater.data;

import ComposableSingletons$CustomBottomSheetKt$;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: WatchLaterResponse.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 )2\u00020\u0001:\u0002()B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB7\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0014¨\u0006*"}, d2 = {"Lkntr/watch/later/watchlater/data/Owner;", "", "mid", "", "name", "", "face", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMid$annotations", "()V", "getMid", "()J", "getName$annotations", "getName", "()Ljava/lang/String;", "getFace$annotations", "getFace", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$watch_later_debug", "$serializer", "Companion", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class Owner {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String face;
    private final long mid;
    private final String name;

    public Owner() {
        this(0L, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Owner copy$default(Owner owner, long j, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = owner.mid;
        }
        if ((i & 2) != 0) {
            str = owner.name;
        }
        if ((i & 4) != 0) {
            str2 = owner.face;
        }
        return owner.copy(j, str, str2);
    }

    @SerialName("face")
    public static /* synthetic */ void getFace$annotations() {
    }

    @SerialName("mid")
    public static /* synthetic */ void getMid$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    public final long component1() {
        return this.mid;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.face;
    }

    public final Owner copy(long j, String str, String str2) {
        return new Owner(j, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Owner) {
            Owner owner = (Owner) obj;
            return this.mid == owner.mid && Intrinsics.areEqual(this.name, owner.name) && Intrinsics.areEqual(this.face, owner.face);
        }
        return false;
    }

    public int hashCode() {
        return (((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.mid) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.face != null ? this.face.hashCode() : 0);
    }

    public String toString() {
        long j = this.mid;
        String str = this.name;
        return "Owner(mid=" + j + ", name=" + str + ", face=" + this.face + ")";
    }

    /* compiled from: WatchLaterResponse.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/watch/later/watchlater/data/Owner$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/watch/later/watchlater/data/Owner;", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Owner> serializer() {
            return Owner$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Owner(int seen0, long mid, String name, String face, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.mid = 0L;
        } else {
            this.mid = mid;
        }
        if ((seen0 & 2) == 0) {
            this.name = null;
        } else {
            this.name = name;
        }
        if ((seen0 & 4) == 0) {
            this.face = null;
        } else {
            this.face = face;
        }
    }

    public Owner(long mid, String name, String face) {
        this.mid = mid;
        this.name = name;
        this.face = face;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$watch_later_debug(Owner self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.mid != 0) {
            output.encodeLongElement(serialDesc, 0, self.mid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.face != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.face);
        }
    }

    public /* synthetic */ Owner(long j, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    public final long getMid() {
        return this.mid;
    }

    public final String getName() {
        return this.name;
    }

    public final String getFace() {
        return this.face;
    }
}