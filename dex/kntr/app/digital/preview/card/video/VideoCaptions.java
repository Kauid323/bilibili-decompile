package kntr.app.digital.preview.card.video;

import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: VideoCard.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0003 !\"B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006#"}, d2 = {"Lkntr/app/digital/preview/card/video/VideoCaptions;", RoomRecommendViewModel.EMPTY_CURSOR, "captions", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/card/video/VideoCaptions$Caption;", "<init>", "(Ljava/util/List;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCaptions$annotations", "()V", "getCaptions", "()Ljava/util/List;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "Caption", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class VideoCaptions {
    private final List<Caption> captions;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.preview.card.video.VideoCaptions$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = VideoCaptions._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VideoCaptions copy$default(VideoCaptions videoCaptions, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = videoCaptions.captions;
        }
        return videoCaptions.copy(list);
    }

    @SerialName("utterances")
    public static /* synthetic */ void getCaptions$annotations() {
    }

    public final List<Caption> component1() {
        return this.captions;
    }

    public final VideoCaptions copy(List<Caption> list) {
        Intrinsics.checkNotNullParameter(list, "captions");
        return new VideoCaptions(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VideoCaptions) && Intrinsics.areEqual(this.captions, ((VideoCaptions) obj).captions);
    }

    public int hashCode() {
        return this.captions.hashCode();
    }

    public String toString() {
        return "VideoCaptions(captions=" + this.captions + ")";
    }

    /* compiled from: VideoCard.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/card/video/VideoCaptions$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/card/video/VideoCaptions;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<VideoCaptions> serializer() {
            return VideoCaptions$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ VideoCaptions(int seen0, List captions, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, VideoCaptions$$serializer.INSTANCE.getDescriptor());
        }
        this.captions = captions;
    }

    public VideoCaptions(List<Caption> list) {
        Intrinsics.checkNotNullParameter(list, "captions");
        this.captions = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(VideoCaptions$Caption$$serializer.INSTANCE);
    }

    /* compiled from: VideoCard.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Lkntr/app/digital/preview/card/video/VideoCaptions$Caption;", RoomRecommendViewModel.EMPTY_CURSOR, "endTime", RoomRecommendViewModel.EMPTY_CURSOR, "startTime", "transcript", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(IILjava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEndTime$annotations", "()V", "getEndTime", "()I", "getStartTime$annotations", "getStartTime", "getTranscript$annotations", "getTranscript", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Caption {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final int endTime;
        private final int startTime;
        private final String transcript;

        public static /* synthetic */ Caption copy$default(Caption caption, int i, int i2, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = caption.endTime;
            }
            if ((i3 & 2) != 0) {
                i2 = caption.startTime;
            }
            if ((i3 & 4) != 0) {
                str = caption.transcript;
            }
            return caption.copy(i, i2, str);
        }

        @SerialName("end_time")
        public static /* synthetic */ void getEndTime$annotations() {
        }

        @SerialName("start_time")
        public static /* synthetic */ void getStartTime$annotations() {
        }

        @SerialName("transcript")
        public static /* synthetic */ void getTranscript$annotations() {
        }

        public final int component1() {
            return this.endTime;
        }

        public final int component2() {
            return this.startTime;
        }

        public final String component3() {
            return this.transcript;
        }

        public final Caption copy(int i, int i2, String str) {
            Intrinsics.checkNotNullParameter(str, "transcript");
            return new Caption(i, i2, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Caption) {
                Caption caption = (Caption) obj;
                return this.endTime == caption.endTime && this.startTime == caption.startTime && Intrinsics.areEqual(this.transcript, caption.transcript);
            }
            return false;
        }

        public int hashCode() {
            return (((this.endTime * 31) + this.startTime) * 31) + this.transcript.hashCode();
        }

        public String toString() {
            int i = this.endTime;
            int i2 = this.startTime;
            return "Caption(endTime=" + i + ", startTime=" + i2 + ", transcript=" + this.transcript + ")";
        }

        /* compiled from: VideoCard.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/card/video/VideoCaptions$Caption$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/card/video/VideoCaptions$Caption;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Caption> serializer() {
                return VideoCaptions$Caption$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Caption(int seen0, int endTime, int startTime, String transcript, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (seen0 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(seen0, 7, VideoCaptions$Caption$$serializer.INSTANCE.getDescriptor());
            }
            this.endTime = endTime;
            this.startTime = startTime;
            this.transcript = transcript;
        }

        public Caption(int endTime, int startTime, String transcript) {
            Intrinsics.checkNotNullParameter(transcript, "transcript");
            this.endTime = endTime;
            this.startTime = startTime;
            this.transcript = transcript;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$preview_debug(Caption self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeIntElement(serialDesc, 0, self.endTime);
            output.encodeIntElement(serialDesc, 1, self.startTime);
            output.encodeStringElement(serialDesc, 2, self.transcript);
        }

        public final int getEndTime() {
            return this.endTime;
        }

        public final int getStartTime() {
            return this.startTime;
        }

        public final String getTranscript() {
            return this.transcript;
        }
    }

    public final List<Caption> getCaptions() {
        return this.captions;
    }
}