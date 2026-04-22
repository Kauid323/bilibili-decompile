package kntr.app.ad.common.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kntr.app.game.base.ui.widget.gameaction.state.GameActionStateKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdKModules.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00140\u0012H\u0002J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0012H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lkntr/app/ad/common/model/AdKModulesSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdKModules;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serializeAdSlotList", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdSlot;", "deserializeAdSlotList", "stringList", "getAllSlots", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdKModulesSerializer implements KSerializer<AdKModules> {
    public static final AdKModulesSerializer INSTANCE = new AdKModulesSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("AdKModules", new SerialDescriptor[0], new Function1() { // from class: kntr.app.ad.common.model.AdKModulesSerializer$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit descriptor$lambda$0;
            descriptor$lambda$0 = AdKModulesSerializer.descriptor$lambda$0((ClassSerialDescriptorBuilder) obj);
            return descriptor$lambda$0;
        }
    });

    private AdKModulesSerializer() {
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit descriptor$lambda$0(ClassSerialDescriptorBuilder $this$buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter($this$buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        List annotations$iv = CollectionsKt.emptyList();
        SerialDescriptor descriptor$iv = new ArrayListSerializer(StringSerializer.INSTANCE).getDescriptor();
        $this$buildClassSerialDescriptor.element("k_model", descriptor$iv, annotations$iv, false);
        List annotations$iv2 = CollectionsKt.emptyList();
        SerialDescriptor descriptor$iv2 = new ArrayListSerializer(StringSerializer.INSTANCE).getDescriptor();
        $this$buildClassSerialDescriptor.element("k_extrafetcher", descriptor$iv2, annotations$iv2, false);
        List annotations$iv3 = CollectionsKt.emptyList();
        SerialDescriptor descriptor$iv3 = new ArrayListSerializer(StringSerializer.INSTANCE).getDescriptor();
        $this$buildClassSerialDescriptor.element("k_reporter", descriptor$iv3, annotations$iv3, false);
        List annotations$iv4 = CollectionsKt.emptyList();
        SerialDescriptor descriptor$iv4 = new ArrayListSerializer(StringSerializer.INSTANCE).getDescriptor();
        $this$buildClassSerialDescriptor.element("k_clicker", descriptor$iv4, annotations$iv4, false);
        List annotations$iv5 = CollectionsKt.emptyList();
        SerialDescriptor descriptor$iv5 = new ArrayListSerializer(StringSerializer.INSTANCE).getDescriptor();
        $this$buildClassSerialDescriptor.element("k_track", descriptor$iv5, annotations$iv5, false);
        List annotations$iv6 = CollectionsKt.emptyList();
        SerialDescriptor descriptor$iv6 = new ArrayListSerializer(StringSerializer.INSTANCE).getDescriptor();
        $this$buildClassSerialDescriptor.element("k_vm", descriptor$iv6, annotations$iv6, false);
        List annotations$iv7 = CollectionsKt.emptyList();
        SerialDescriptor descriptor$iv7 = new ArrayListSerializer(StringSerializer.INSTANCE).getDescriptor();
        $this$buildClassSerialDescriptor.element("k_inspector", descriptor$iv7, annotations$iv7, false);
        return Unit.INSTANCE;
    }

    public void serialize(Encoder encoder, AdKModules value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeEncoder composite$iv = encoder.beginStructure(descriptor$iv);
        composite$iv.encodeSerializableElement(INSTANCE.getDescriptor(), 0, BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE)), INSTANCE.serializeAdSlotList(value.getKModel()));
        composite$iv.encodeSerializableElement(INSTANCE.getDescriptor(), 1, BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE)), INSTANCE.serializeAdSlotList(value.getKExtraFetcher()));
        composite$iv.encodeSerializableElement(INSTANCE.getDescriptor(), 2, BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE)), INSTANCE.serializeAdSlotList(value.getKReporter()));
        composite$iv.encodeSerializableElement(INSTANCE.getDescriptor(), 3, BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE)), INSTANCE.serializeAdSlotList(value.getKClicker()));
        composite$iv.encodeSerializableElement(INSTANCE.getDescriptor(), 4, BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE)), INSTANCE.serializeAdSlotList(value.getKTrack()));
        composite$iv.encodeSerializableElement(INSTANCE.getDescriptor(), 5, BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE)), INSTANCE.serializeAdSlotList(value.getKVM()));
        composite$iv.encodeSerializableElement(INSTANCE.getDescriptor(), 6, BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE)), INSTANCE.serializeAdSlotList(value.getKInspector()));
        composite$iv.endStructure(descriptor$iv);
    }

    public AdKModules deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeDecoder composite$iv = decoder.beginStructure(descriptor$iv);
        List kModel = CollectionsKt.emptyList();
        List kExtraFetcher = CollectionsKt.emptyList();
        List kReporter = CollectionsKt.emptyList();
        List kClicker = CollectionsKt.emptyList();
        List kTrack = CollectionsKt.emptyList();
        List kVM = CollectionsKt.emptyList();
        List kModel2 = kModel;
        List kExtraFetcher2 = kExtraFetcher;
        List kReporter2 = kReporter;
        List kClicker2 = kClicker;
        List kTrack2 = kTrack;
        List kVM2 = kVM;
        List kInspector = CollectionsKt.emptyList();
        while (true) {
            int index = composite$iv.decodeElementIndex(INSTANCE.getDescriptor());
            switch (index) {
                case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                    AdKModules adKModules = new AdKModules(kModel2, kExtraFetcher2, kReporter2, kClicker2, kTrack2, kVM2, kInspector);
                    composite$iv.endStructure(descriptor$iv);
                    return adKModules;
                case 0:
                    kModel2 = INSTANCE.deserializeAdSlotList((List) CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite$iv, INSTANCE.getDescriptor(), 0, BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE)), (Object) null, 8, (Object) null));
                    break;
                case 1:
                    kExtraFetcher2 = INSTANCE.deserializeAdSlotList((List) CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite$iv, INSTANCE.getDescriptor(), 1, BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE)), (Object) null, 8, (Object) null));
                    break;
                case 2:
                    kReporter2 = INSTANCE.deserializeAdSlotList((List) CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite$iv, INSTANCE.getDescriptor(), 2, BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE)), (Object) null, 8, (Object) null));
                    break;
                case 3:
                    kClicker2 = INSTANCE.deserializeAdSlotList((List) CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite$iv, INSTANCE.getDescriptor(), 3, BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE)), (Object) null, 8, (Object) null));
                    break;
                case 4:
                    kTrack2 = INSTANCE.deserializeAdSlotList((List) CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite$iv, INSTANCE.getDescriptor(), 4, BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE)), (Object) null, 8, (Object) null));
                    break;
                case 5:
                    kVM2 = INSTANCE.deserializeAdSlotList((List) CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite$iv, INSTANCE.getDescriptor(), 5, BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE)), (Object) null, 8, (Object) null));
                    break;
                case 6:
                    kInspector = INSTANCE.deserializeAdSlotList((List) CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite$iv, INSTANCE.getDescriptor(), 6, BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE)), (Object) null, 8, (Object) null));
                    break;
                default:
                    throw new IllegalStateException(("Unexpected index: " + index).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> serializeAdSlotList(List<? extends AdSlot> list) {
        if (list.containsAll(getAllSlots())) {
            return CollectionsKt.listOf("*");
        }
        List<? extends AdSlot> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            AdSlot it = (AdSlot) item$iv$iv;
            String lowerCase = it.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            destination$iv$iv.add(lowerCase);
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<AdSlot> deserializeAdSlotList(List<String> list) {
        AdSlot adSlot;
        if (list.contains("*")) {
            return getAllSlots();
        }
        List<String> $this$mapNotNull$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            String name = (String) element$iv$iv$iv;
            try {
                String upperCase = name.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                adSlot = AdSlot.valueOf(upperCase);
            } catch (Exception e) {
                adSlot = null;
            }
            if (adSlot != null) {
                destination$iv$iv.add(adSlot);
            }
        }
        return (List) destination$iv$iv;
    }

    private final List<AdSlot> getAllSlots() {
        return AdSlot.getEntries();
    }
}