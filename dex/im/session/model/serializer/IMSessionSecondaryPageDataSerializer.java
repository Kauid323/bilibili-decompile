package im.session.model.serializer;

import com.bapis.bilibili.app.im.v1.KPaginationParams;
import com.bapis.bilibili.app.im.v1.KUpdateSessionParams;
import com.tencent.smtt.sdk.TbsListener;
import im.session.model.IMSessionCard;
import im.session.model.IMSessionPageData;
import im.session.model.IMThreeDotItem;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.protobuf.ProtoNumber;
import kotlinx.serialization.protobuf.ProtoPacked;

/* compiled from: IMSessionSecondaryPageDataSerializer.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lim/session/model/serializer/IMSessionSecondaryPageDataSerializer;", "Lkotlinx/serialization/KSerializer;", "Lim/session/model/IMSessionPageData;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionSecondaryPageDataSerializer implements KSerializer<IMSessionPageData> {
    public static final IMSessionSecondaryPageDataSerializer INSTANCE = new IMSessionSecondaryPageDataSerializer();
    private static final Lazy descriptor$delegate = LazyKt.lazy(new Function0() { // from class: im.session.model.serializer.IMSessionSecondaryPageDataSerializer$$ExternalSyntheticLambda0
        public final Object invoke() {
            SerialDescriptor descriptor_delegate$lambda$0;
            descriptor_delegate$lambda$0 = IMSessionSecondaryPageDataSerializer.descriptor_delegate$lambda$0();
            return descriptor_delegate$lambda$0;
        }
    });

    private IMSessionSecondaryPageDataSerializer() {
    }

    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) descriptor$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor descriptor_delegate$lambda$0() {
        return SerialDescriptorsKt.buildClassSerialDescriptor("IMSessionPageData", new SerialDescriptor[0], new Function1() { // from class: im.session.model.serializer.IMSessionSecondaryPageDataSerializer$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit descriptor_delegate$lambda$0$0;
                descriptor_delegate$lambda$0$0 = IMSessionSecondaryPageDataSerializer.descriptor_delegate$lambda$0$0((ClassSerialDescriptorBuilder) obj);
                return descriptor_delegate$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit descriptor_delegate$lambda$0$0(ClassSerialDescriptorBuilder $this$buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter($this$buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        List annotations$iv = CollectionsKt.listOf(new ProtoNumber() { // from class: im.session.model.serializer.IMSessionSecondaryPageDataSerializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
            public final /* synthetic */ Class annotationType() {
                return ProtoNumber.class;
            }

            public final boolean equals(Object obj) {
                return (obj instanceof ProtoNumber) && number() == ((ProtoNumber) obj).number();
            }

            public final int hashCode() {
                return ("number".hashCode() * TbsListener.ErrorCode.STARTDOWNLOAD_OUT_OF_MAXTIME) ^ r1;
            }

            public final /* synthetic */ int number() {
                return r1;
            }

            public final String toString() {
                return "@kotlinx.serialization.protobuf.ProtoNumber(number=" + r1 + ")";
            }
        });
        SerialDescriptor descriptor$iv = KPaginationParams.Companion.serializer().getDescriptor();
        $this$buildClassSerialDescriptor.element("paginationParams", descriptor$iv, annotations$iv, true);
        List annotations$iv2 = CollectionsKt.listOf(new ProtoNumber() { // from class: im.session.model.serializer.IMSessionSecondaryPageDataSerializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
            public final /* synthetic */ Class annotationType() {
                return ProtoNumber.class;
            }

            public final boolean equals(Object obj) {
                return (obj instanceof ProtoNumber) && number() == ((ProtoNumber) obj).number();
            }

            public final int hashCode() {
                return ("number".hashCode() * TbsListener.ErrorCode.STARTDOWNLOAD_OUT_OF_MAXTIME) ^ r1;
            }

            public final /* synthetic */ int number() {
                return r1;
            }

            public final String toString() {
                return "@kotlinx.serialization.protobuf.ProtoNumber(number=" + r1 + ")";
            }
        });
        SerialDescriptor descriptor$iv2 = KUpdateSessionParams.Companion.serializer().getDescriptor();
        $this$buildClassSerialDescriptor.element("updateSessionParams", descriptor$iv2, annotations$iv2, true);
        List annotations$iv3 = CollectionsKt.listOf(new Annotation[]{new ProtoNumber() { // from class: im.session.model.serializer.IMSessionSecondaryPageDataSerializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
            public final /* synthetic */ Class annotationType() {
                return ProtoNumber.class;
            }

            public final boolean equals(Object obj) {
                return (obj instanceof ProtoNumber) && number() == ((ProtoNumber) obj).number();
            }

            public final int hashCode() {
                return ("number".hashCode() * TbsListener.ErrorCode.STARTDOWNLOAD_OUT_OF_MAXTIME) ^ r1;
            }

            public final /* synthetic */ int number() {
                return r1;
            }

            public final String toString() {
                return "@kotlinx.serialization.protobuf.ProtoNumber(number=" + r1 + ")";
            }
        }, new ProtoPacked() { // from class: im.session.model.serializer.IMSessionSecondaryPageDataSerializer$annotationImpl$kotlinx_serialization_protobuf_ProtoPacked$0
            public final /* synthetic */ Class annotationType() {
                return ProtoPacked.class;
            }

            public final boolean equals(Object obj) {
                if (obj instanceof ProtoPacked) {
                    ProtoPacked protoPacked = (ProtoPacked) obj;
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return 0;
            }

            public final String toString() {
                return "@kotlinx.serialization.protobuf.ProtoPacked()";
            }
        }});
        SerialDescriptor descriptor$iv3 = new ArrayListSerializer(IMSessionCard.Companion.serializer()).getDescriptor();
        $this$buildClassSerialDescriptor.element("sessions", descriptor$iv3, annotations$iv3, false);
        List annotations$iv4 = CollectionsKt.listOf(new Annotation[]{new ProtoNumber() { // from class: im.session.model.serializer.IMSessionSecondaryPageDataSerializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
            public final /* synthetic */ Class annotationType() {
                return ProtoNumber.class;
            }

            public final boolean equals(Object obj) {
                return (obj instanceof ProtoNumber) && number() == ((ProtoNumber) obj).number();
            }

            public final int hashCode() {
                return ("number".hashCode() * TbsListener.ErrorCode.STARTDOWNLOAD_OUT_OF_MAXTIME) ^ r1;
            }

            public final /* synthetic */ int number() {
                return r1;
            }

            public final String toString() {
                return "@kotlinx.serialization.protobuf.ProtoNumber(number=" + r1 + ")";
            }
        }, new ProtoPacked() { // from class: im.session.model.serializer.IMSessionSecondaryPageDataSerializer$annotationImpl$kotlinx_serialization_protobuf_ProtoPacked$0
            public final /* synthetic */ Class annotationType() {
                return ProtoPacked.class;
            }

            public final boolean equals(Object obj) {
                if (obj instanceof ProtoPacked) {
                    ProtoPacked protoPacked = (ProtoPacked) obj;
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return 0;
            }

            public final String toString() {
                return "@kotlinx.serialization.protobuf.ProtoPacked()";
            }
        }});
        SerialDescriptor descriptor$iv4 = new ArrayListSerializer(IMThreeDotItem.Companion.serializer()).getDescriptor();
        $this$buildClassSerialDescriptor.element("threeDots", descriptor$iv4, annotations$iv4, false);
        List annotations$iv5 = CollectionsKt.listOf(new Annotation[]{new ProtoNumber() { // from class: im.session.model.serializer.IMSessionSecondaryPageDataSerializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
            public final /* synthetic */ Class annotationType() {
                return ProtoNumber.class;
            }

            public final boolean equals(Object obj) {
                return (obj instanceof ProtoNumber) && number() == ((ProtoNumber) obj).number();
            }

            public final int hashCode() {
                return ("number".hashCode() * TbsListener.ErrorCode.STARTDOWNLOAD_OUT_OF_MAXTIME) ^ r1;
            }

            public final /* synthetic */ int number() {
                return r1;
            }

            public final String toString() {
                return "@kotlinx.serialization.protobuf.ProtoNumber(number=" + r1 + ")";
            }
        }, new ProtoPacked() { // from class: im.session.model.serializer.IMSessionSecondaryPageDataSerializer$annotationImpl$kotlinx_serialization_protobuf_ProtoPacked$0
            public final /* synthetic */ Class annotationType() {
                return ProtoPacked.class;
            }

            public final boolean equals(Object obj) {
                if (obj instanceof ProtoPacked) {
                    ProtoPacked protoPacked = (ProtoPacked) obj;
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return 0;
            }

            public final String toString() {
                return "@kotlinx.serialization.protobuf.ProtoPacked()";
            }
        }});
        SerialDescriptor descriptor$iv5 = new ArrayListSerializer(IMThreeDotItem.Companion.serializer()).getDescriptor();
        $this$buildClassSerialDescriptor.element("outsideActions", descriptor$iv5, annotations$iv5, false);
        return Unit.INSTANCE;
    }

    public void serialize(Encoder encoder, IMSessionPageData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeEncoder composite$iv = encoder.beginStructure(descriptor$iv);
        KPaginationParams it = value.getPaginationParams$session_debug();
        if (it != null) {
            composite$iv.encodeSerializableElement(INSTANCE.getDescriptor(), 0, KPaginationParams.Companion.serializer(), it);
        }
        KUpdateSessionParams it2 = value.getUpdateSessionParams$session_debug();
        if (it2 != null) {
            composite$iv.encodeSerializableElement(INSTANCE.getDescriptor(), 1, KUpdateSessionParams.Companion.serializer(), it2);
        }
        composite$iv.encodeSerializableElement(INSTANCE.getDescriptor(), 2, new ArrayListSerializer(IMSessionCard.Companion.serializer()), value.getSessions());
        composite$iv.encodeSerializableElement(INSTANCE.getDescriptor(), 3, new ArrayListSerializer(IMThreeDotItem.Companion.serializer()), value.getThreeDots());
        composite$iv.encodeSerializableElement(INSTANCE.getDescriptor(), 4, new ArrayListSerializer(IMThreeDotItem.Companion.serializer()), value.getOutsideActions());
        composite$iv.endStructure(descriptor$iv);
    }

    /* renamed from: deserialize */
    public IMSessionPageData m3336deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeDecoder composite$iv = decoder.beginStructure(descriptor$iv);
        List sessions = CollectionsKt.emptyList();
        List threeDots = CollectionsKt.emptyList();
        KPaginationParams paginationParams = null;
        KUpdateSessionParams updateSessionParams = null;
        List sessions2 = sessions;
        List threeDots2 = threeDots;
        List outsideActions = CollectionsKt.emptyList();
        while (true) {
            switch (composite$iv.decodeElementIndex(INSTANCE.getDescriptor())) {
                case -1:
                    IMSessionPageData iMSessionPageData = new IMSessionPageData(paginationParams, updateSessionParams, null, null, sessions2, threeDots2, outsideActions, null, null, null, false, 1932, null);
                    composite$iv.endStructure(descriptor$iv);
                    return iMSessionPageData;
                case 0:
                    paginationParams = (KPaginationParams) CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite$iv, INSTANCE.getDescriptor(), 0, KPaginationParams.Companion.serializer(), (Object) null, 8, (Object) null);
                    break;
                case 1:
                    updateSessionParams = (KUpdateSessionParams) CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite$iv, INSTANCE.getDescriptor(), 1, KUpdateSessionParams.Companion.serializer(), (Object) null, 8, (Object) null);
                    break;
                case 2:
                    sessions2 = (List) CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite$iv, INSTANCE.getDescriptor(), 2, new ArrayListSerializer(IMSessionCard.Companion.serializer()), (Object) null, 8, (Object) null);
                    break;
                case 3:
                    threeDots2 = (List) CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite$iv, INSTANCE.getDescriptor(), 3, new ArrayListSerializer(IMThreeDotItem.Companion.serializer()), (Object) null, 8, (Object) null);
                    break;
                case 4:
                    outsideActions = (List) CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite$iv, INSTANCE.getDescriptor(), 4, new ArrayListSerializer(IMThreeDotItem.Companion.serializer()), (Object) null, 8, (Object) null);
                    break;
            }
        }
    }
}