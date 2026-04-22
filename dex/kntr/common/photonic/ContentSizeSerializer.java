package kntr.common.photonic;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.ContentSizeSerializer;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: ContentSize.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lkntr/common/photonic/ContentSizeSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/photonic/ContentSize;", "<init>", "()V", "unit", "Lkntr/common/photonic/ContentSizeSerializer$Unit;", "getUnit", "()Lkntr/common/photonic/ContentSizeSerializer$Unit;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "deserialize-zLmOkFI", "(Lkotlinx/serialization/encoding/Decoder;)D", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "serialize-q1_JwpE", "(Lkotlinx/serialization/encoding/Encoder;D)V", "Unit", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class ContentSizeSerializer implements KSerializer<ContentSize> {
    public static final int $stable = 8;
    private final SerialDescriptor descriptor = BuiltinSerializersKt.serializer(FloatCompanionObject.INSTANCE).getDescriptor();

    public abstract Unit getUnit();

    /* compiled from: ContentSize.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B;\b\u0002\u0012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0006¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lkntr/common/photonic/ContentSizeSerializer$Unit;", "", "toContentSize", "Lkotlin/Function1;", "", "Lkntr/common/photonic/ContentSize;", "Lkotlin/ExtensionFunctionType;", "getValue", "<init>", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getToContentSize", "()Lkotlin/jvm/functions/Function1;", "getGetValue", "BYTES", "KILOBYTES", "MEGABYTES", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public enum Unit {
        BYTES(new Function1() { // from class: kntr.common.photonic.ContentSizeSerializer$Unit$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                ContentSize _init_$lambda$0;
                _init_$lambda$0 = ContentSizeSerializer.Unit._init_$lambda$0(((Double) obj).doubleValue());
                return _init_$lambda$0;
            }
        }, new Function1() { // from class: kntr.common.photonic.ContentSizeSerializer$Unit$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                double _init_$lambda$1;
                _init_$lambda$1 = ContentSizeSerializer.Unit._init_$lambda$1((ContentSize) obj);
                return Double.valueOf(_init_$lambda$1);
            }
        }),
        KILOBYTES(new Function1() { // from class: kntr.common.photonic.ContentSizeSerializer$Unit$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                ContentSize _init_$lambda$2;
                _init_$lambda$2 = ContentSizeSerializer.Unit._init_$lambda$2(((Double) obj).doubleValue());
                return _init_$lambda$2;
            }
        }, new Function1() { // from class: kntr.common.photonic.ContentSizeSerializer$Unit$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                double _init_$lambda$3;
                _init_$lambda$3 = ContentSizeSerializer.Unit._init_$lambda$3((ContentSize) obj);
                return Double.valueOf(_init_$lambda$3);
            }
        }),
        MEGABYTES(new Function1() { // from class: kntr.common.photonic.ContentSizeSerializer$Unit$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                ContentSize _init_$lambda$4;
                _init_$lambda$4 = ContentSizeSerializer.Unit._init_$lambda$4(((Double) obj).doubleValue());
                return _init_$lambda$4;
            }
        }, new Function1() { // from class: kntr.common.photonic.ContentSizeSerializer$Unit$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                double _init_$lambda$5;
                _init_$lambda$5 = ContentSizeSerializer.Unit._init_$lambda$5((ContentSize) obj);
                return Double.valueOf(_init_$lambda$5);
            }
        });
        
        private final Function1<ContentSize, Double> getValue;
        private final Function1<Double, ContentSize> toContentSize;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Unit> getEntries() {
            return $ENTRIES;
        }

        Unit(Function1 toContentSize, Function1 getValue) {
            this.toContentSize = toContentSize;
            this.getValue = getValue;
        }

        public final Function1<Double, ContentSize> getToContentSize() {
            return this.toContentSize;
        }

        public final Function1<ContentSize, Double> getGetValue() {
            return this.getValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ContentSize _init_$lambda$0(double d) {
            return ContentSize.m2181boximpl(ContentSizeKt.bytes(d));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double _init_$lambda$1(ContentSize contentSize) {
            return ContentSize.m2187getBytesimpl(contentSize.m2195unboximpl());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ContentSize _init_$lambda$2(double d) {
            return ContentSize.m2181boximpl(ContentSizeKt.kilobytes(d));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double _init_$lambda$3(ContentSize contentSize) {
            return ContentSize.m2188getKilobytesimpl(contentSize.m2195unboximpl());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ContentSize _init_$lambda$4(double d) {
            return ContentSize.m2181boximpl(ContentSizeKt.megabytes(d));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double _init_$lambda$5(ContentSize contentSize) {
            return ContentSize.m2189getMegabytesimpl(contentSize.m2195unboximpl());
        }
    }

    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return ContentSize.m2181boximpl(m2197deserializezLmOkFI(decoder));
    }

    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object value) {
        m2198serializeq1_JwpE(encoder, ((ContentSize) value).m2195unboximpl());
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    /* renamed from: deserialize-zLmOkFI  reason: not valid java name */
    public double m2197deserializezLmOkFI(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        double content = decoder.decodeDouble();
        Unit $this$deserialize_zLmOkFI_u24lambda_u240 = getUnit();
        return ((ContentSize) $this$deserialize_zLmOkFI_u24lambda_u240.getToContentSize().invoke(Double.valueOf(content))).m2195unboximpl();
    }

    /* renamed from: serialize-q1_JwpE  reason: not valid java name */
    public void m2198serializeq1_JwpE(Encoder encoder, double d) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Unit $this$serialize_q1_JwpE_u24lambda_u240 = getUnit();
        encoder.encodeDouble(((Number) $this$serialize_q1_JwpE_u24lambda_u240.getGetValue().invoke(ContentSize.m2181boximpl(d))).doubleValue());
    }
}