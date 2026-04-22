package kntr.common.ouro.core.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroBackgroundColorMark;
import kntr.common.ouro.core.model.mark.OuroDrawableMark;
import kntr.common.ouro.core.model.mark.OuroFontSizeMark;
import kntr.common.ouro.core.model.mark.OuroForegroundColorMark;
import kntr.common.ouro.core.model.mark.OuroItalicMark;
import kntr.common.ouro.core.model.mark.OuroLineHeightMark;
import kntr.common.ouro.core.model.mark.OuroMark;
import kntr.common.ouro.core.model.mark.OuroMediumMark;
import kntr.common.ouro.core.model.mark.OuroRegularMark;
import kntr.common.ouro.core.model.mark.OuroSemiBoldMark;
import kntr.common.ouro.core.model.mark.OuroStrikethroughMark;
import kntr.common.ouro.core.model.mark.OuroSubscriptMark;
import kntr.common.ouro.core.model.mark.OuroSuperscriptMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignCenterMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignEndMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignJustifyMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignStartMark;
import kntr.common.ouro.core.model.mark.OuroTextIndentMark;
import kntr.common.ouro.core.model.mark.OuroTextSpacingMark;
import kntr.common.ouro.core.model.mark.OuroUnderlineMark;
import kntr.common.ouro.core.model.mark.OuroUnmergableMark;
import kntr.common.ouro.core.model.node.OuroAtMentionLink;
import kntr.common.ouro.core.model.node.OuroDocument;
import kntr.common.ouro.core.model.node.OuroH1;
import kntr.common.ouro.core.model.node.OuroH2;
import kntr.common.ouro.core.model.node.OuroH3;
import kntr.common.ouro.core.model.node.OuroListItem;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroOrderedList;
import kntr.common.ouro.core.model.node.OuroQuoteBlock;
import kntr.common.ouro.core.model.node.OuroText;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kntr.common.ouro.core.model.node.OuroUniversalLink;
import kntr.common.ouro.core.model.node.OuroUnorderedList;
import kntr.common.ouro.core.model.node.drawable.OuroBoxContainer;
import kntr.common.ouro.core.model.node.drawable.OuroInlineContent;
import kntr.common.ouro.core.model.node.renderable.OuroDivider;
import kntr.common.ouro.core.model.node.renderable.OuroLocalImage;
import kntr.common.ouro.core.model.node.renderable.OuroRemoteImage;
import kntr.common.ouro.core.model.node.renderable.OuroUnrecognizedCard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.modules.PolymorphicModuleBuilder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuilder;
import kotlinx.serialization.protobuf.ProtoBuf;
import kotlinx.serialization.protobuf.ProtoBufBuilder;
import kotlinx.serialization.protobuf.ProtoBufKt;

/* compiled from: SerializationUtils.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0002\u001a\u00020\u0003¢\u0006\u000e\n\u0000\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"SerializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "OuroProtoBuf", "Lkotlinx/serialization/protobuf/ProtoBuf;", "getOuroProtoBuf$annotations", "()V", "getOuroProtoBuf", "()Lkotlinx/serialization/protobuf/ProtoBuf;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SerializationUtilsKt {
    private static final ProtoBuf OuroProtoBuf;
    private static final SerializersModule SerializersModule;

    public static /* synthetic */ void getOuroProtoBuf$annotations() {
    }

    static {
        SerializersModuleBuilder builder$iv = new SerializersModuleBuilder();
        KClass baseClass$iv = Reflection.getOrCreateKotlinClass(OuroMark.class);
        PolymorphicModuleBuilder builder$iv2 = new PolymorphicModuleBuilder(baseClass$iv, (KSerializer) null);
        KClass clazz$iv = Reflection.getOrCreateKotlinClass(OuroRegularMark.class);
        builder$iv2.subclass(clazz$iv, OuroRegularMark.INSTANCE.serializer());
        KClass clazz$iv2 = Reflection.getOrCreateKotlinClass(OuroMediumMark.class);
        builder$iv2.subclass(clazz$iv2, OuroMediumMark.INSTANCE.serializer());
        KClass clazz$iv3 = Reflection.getOrCreateKotlinClass(OuroSemiBoldMark.class);
        builder$iv2.subclass(clazz$iv3, OuroSemiBoldMark.INSTANCE.serializer());
        KClass clazz$iv4 = Reflection.getOrCreateKotlinClass(OuroItalicMark.class);
        builder$iv2.subclass(clazz$iv4, OuroItalicMark.INSTANCE.serializer());
        KClass clazz$iv5 = Reflection.getOrCreateKotlinClass(OuroUnderlineMark.class);
        builder$iv2.subclass(clazz$iv5, OuroUnderlineMark.INSTANCE.serializer());
        KClass clazz$iv6 = Reflection.getOrCreateKotlinClass(OuroStrikethroughMark.class);
        builder$iv2.subclass(clazz$iv6, OuroStrikethroughMark.INSTANCE.serializer());
        KClass clazz$iv7 = Reflection.getOrCreateKotlinClass(OuroSubscriptMark.class);
        builder$iv2.subclass(clazz$iv7, OuroSubscriptMark.INSTANCE.serializer());
        KClass clazz$iv8 = Reflection.getOrCreateKotlinClass(OuroSuperscriptMark.class);
        builder$iv2.subclass(clazz$iv8, OuroSuperscriptMark.INSTANCE.serializer());
        KClass clazz$iv9 = Reflection.getOrCreateKotlinClass(OuroTextSpacingMark.class);
        builder$iv2.subclass(clazz$iv9, OuroTextSpacingMark.Companion.serializer());
        KClass clazz$iv10 = Reflection.getOrCreateKotlinClass(OuroFontSizeMark.class);
        builder$iv2.subclass(clazz$iv10, OuroFontSizeMark.Companion.serializer());
        KClass clazz$iv11 = Reflection.getOrCreateKotlinClass(OuroBackgroundColorMark.class);
        builder$iv2.subclass(clazz$iv11, OuroBackgroundColorMark.Companion.serializer());
        KClass clazz$iv12 = Reflection.getOrCreateKotlinClass(OuroForegroundColorMark.class);
        builder$iv2.subclass(clazz$iv12, OuroForegroundColorMark.Companion.serializer());
        KClass clazz$iv13 = Reflection.getOrCreateKotlinClass(OuroUnmergableMark.class);
        builder$iv2.subclass(clazz$iv13, OuroUnmergableMark.INSTANCE.serializer());
        KClass clazz$iv14 = Reflection.getOrCreateKotlinClass(OuroTextAlignStartMark.class);
        builder$iv2.subclass(clazz$iv14, OuroTextAlignStartMark.INSTANCE.serializer());
        KClass clazz$iv15 = Reflection.getOrCreateKotlinClass(OuroTextAlignCenterMark.class);
        builder$iv2.subclass(clazz$iv15, OuroTextAlignCenterMark.INSTANCE.serializer());
        KClass clazz$iv16 = Reflection.getOrCreateKotlinClass(OuroTextAlignEndMark.class);
        builder$iv2.subclass(clazz$iv16, OuroTextAlignEndMark.INSTANCE.serializer());
        KClass clazz$iv17 = Reflection.getOrCreateKotlinClass(OuroTextAlignJustifyMark.class);
        builder$iv2.subclass(clazz$iv17, OuroTextAlignJustifyMark.INSTANCE.serializer());
        KClass clazz$iv18 = Reflection.getOrCreateKotlinClass(OuroLineHeightMark.class);
        builder$iv2.subclass(clazz$iv18, OuroLineHeightMark.Companion.serializer());
        KClass clazz$iv19 = Reflection.getOrCreateKotlinClass(OuroTextIndentMark.class);
        builder$iv2.subclass(clazz$iv19, OuroTextIndentMark.Companion.serializer());
        KClass clazz$iv20 = Reflection.getOrCreateKotlinClass(OuroDrawableMark.Padding.class);
        builder$iv2.subclass(clazz$iv20, OuroDrawableMark.Padding.Companion.serializer());
        KClass clazz$iv21 = Reflection.getOrCreateKotlinClass(OuroDrawableMark.Size.Specified.class);
        builder$iv2.subclass(clazz$iv21, OuroDrawableMark.Size.Specified.Companion.serializer());
        KClass clazz$iv22 = Reflection.getOrCreateKotlinClass(OuroDrawableMark.Size.AspectRatio.class);
        builder$iv2.subclass(clazz$iv22, OuroDrawableMark.Size.AspectRatio.Companion.serializer());
        KClass clazz$iv23 = Reflection.getOrCreateKotlinClass(OuroDrawableMark.Size.FillWidth.class);
        builder$iv2.subclass(clazz$iv23, OuroDrawableMark.Size.FillWidth.Companion.serializer());
        KClass clazz$iv24 = Reflection.getOrCreateKotlinClass(OuroDrawableMark.Size.ScaledByFontSize.class);
        builder$iv2.subclass(clazz$iv24, OuroDrawableMark.Size.ScaledByFontSize.Companion.serializer());
        KClass clazz$iv25 = Reflection.getOrCreateKotlinClass(OuroDrawableMark.Size.BiliBlockImageSize.class);
        builder$iv2.subclass(clazz$iv25, OuroDrawableMark.Size.BiliBlockImageSize.Companion.serializer());
        builder$iv2.buildTo(builder$iv);
        KClass baseClass$iv2 = Reflection.getOrCreateKotlinClass(OuroNode.class);
        PolymorphicModuleBuilder builder$iv3 = new PolymorphicModuleBuilder(baseClass$iv2, (KSerializer) null);
        KClass clazz$iv26 = Reflection.getOrCreateKotlinClass(OuroDocument.class);
        builder$iv3.subclass(clazz$iv26, OuroDocument.Companion.serializer());
        KClass clazz$iv27 = Reflection.getOrCreateKotlinClass(OuroH1.class);
        builder$iv3.subclass(clazz$iv27, OuroH1.Companion.serializer());
        KClass clazz$iv28 = Reflection.getOrCreateKotlinClass(OuroH2.class);
        builder$iv3.subclass(clazz$iv28, OuroH2.Companion.serializer());
        KClass clazz$iv29 = Reflection.getOrCreateKotlinClass(OuroH3.class);
        builder$iv3.subclass(clazz$iv29, OuroH3.Companion.serializer());
        KClass clazz$iv30 = Reflection.getOrCreateKotlinClass(OuroText.class);
        builder$iv3.subclass(clazz$iv30, OuroText.Companion.serializer());
        KClass clazz$iv31 = Reflection.getOrCreateKotlinClass(OuroOrderedList.class);
        builder$iv3.subclass(clazz$iv31, OuroOrderedList.Companion.serializer());
        KClass clazz$iv32 = Reflection.getOrCreateKotlinClass(OuroUnorderedList.class);
        builder$iv3.subclass(clazz$iv32, OuroUnorderedList.Companion.serializer());
        KClass clazz$iv33 = Reflection.getOrCreateKotlinClass(OuroListItem.class);
        builder$iv3.subclass(clazz$iv33, OuroListItem.Companion.serializer());
        KClass clazz$iv34 = Reflection.getOrCreateKotlinClass(OuroQuoteBlock.class);
        builder$iv3.subclass(clazz$iv34, OuroQuoteBlock.Companion.serializer());
        KClass clazz$iv35 = Reflection.getOrCreateKotlinClass(OuroBoxContainer.class);
        builder$iv3.subclass(clazz$iv35, OuroBoxContainer.Companion.serializer());
        KClass clazz$iv36 = Reflection.getOrCreateKotlinClass(OuroInlineContent.class);
        builder$iv3.subclass(clazz$iv36, OuroInlineContent.Companion.serializer());
        KClass clazz$iv37 = Reflection.getOrCreateKotlinClass(OuroUniversalLink.class);
        builder$iv3.subclass(clazz$iv37, OuroUniversalLink.Companion.serializer());
        KClass clazz$iv38 = Reflection.getOrCreateKotlinClass(OuroAtMentionLink.class);
        builder$iv3.subclass(clazz$iv38, OuroAtMentionLink.Companion.serializer());
        KClass clazz$iv39 = Reflection.getOrCreateKotlinClass(OuroTextElement.Plain.class);
        builder$iv3.subclass(clazz$iv39, OuroTextElement.Plain.Companion.serializer());
        KClass clazz$iv40 = Reflection.getOrCreateKotlinClass(OuroTextElement.HardBreak.class);
        builder$iv3.subclass(clazz$iv40, OuroTextElement.HardBreak.Companion.serializer());
        KClass clazz$iv41 = Reflection.getOrCreateKotlinClass(OuroLocalImage.class);
        builder$iv3.subclass(clazz$iv41, OuroLocalImage.Companion.serializer());
        KClass clazz$iv42 = Reflection.getOrCreateKotlinClass(OuroRemoteImage.Image.class);
        builder$iv3.subclass(clazz$iv42, OuroRemoteImage.Image.Companion.serializer());
        KClass clazz$iv43 = Reflection.getOrCreateKotlinClass(OuroRemoteImage.Sticker.class);
        builder$iv3.subclass(clazz$iv43, OuroRemoteImage.Sticker.Companion.serializer());
        KClass clazz$iv44 = Reflection.getOrCreateKotlinClass(OuroDivider.class);
        builder$iv3.subclass(clazz$iv44, OuroDivider.Companion.serializer());
        KClass clazz$iv45 = Reflection.getOrCreateKotlinClass(OuroUnrecognizedCard.class);
        builder$iv3.subclass(clazz$iv45, OuroUnrecognizedCard.Companion.serializer());
        builder$iv3.buildTo(builder$iv);
        KClass baseClass$iv3 = Reflection.getOrCreateKotlinClass(OuroNode.Parent.class);
        PolymorphicModuleBuilder builder$iv4 = new PolymorphicModuleBuilder(baseClass$iv3, (KSerializer) null);
        KClass clazz$iv46 = Reflection.getOrCreateKotlinClass(OuroDocument.class);
        builder$iv4.subclass(clazz$iv46, OuroDocument.Companion.serializer());
        KClass clazz$iv47 = Reflection.getOrCreateKotlinClass(OuroH1.class);
        builder$iv4.subclass(clazz$iv47, OuroH1.Companion.serializer());
        KClass clazz$iv48 = Reflection.getOrCreateKotlinClass(OuroH2.class);
        builder$iv4.subclass(clazz$iv48, OuroH2.Companion.serializer());
        KClass clazz$iv49 = Reflection.getOrCreateKotlinClass(OuroH3.class);
        builder$iv4.subclass(clazz$iv49, OuroH3.Companion.serializer());
        KClass clazz$iv50 = Reflection.getOrCreateKotlinClass(OuroText.class);
        builder$iv4.subclass(clazz$iv50, OuroText.Companion.serializer());
        KClass clazz$iv51 = Reflection.getOrCreateKotlinClass(OuroOrderedList.class);
        builder$iv4.subclass(clazz$iv51, OuroOrderedList.Companion.serializer());
        KClass clazz$iv52 = Reflection.getOrCreateKotlinClass(OuroUnorderedList.class);
        builder$iv4.subclass(clazz$iv52, OuroUnorderedList.Companion.serializer());
        KClass clazz$iv53 = Reflection.getOrCreateKotlinClass(OuroListItem.class);
        builder$iv4.subclass(clazz$iv53, OuroListItem.Companion.serializer());
        KClass clazz$iv54 = Reflection.getOrCreateKotlinClass(OuroQuoteBlock.class);
        builder$iv4.subclass(clazz$iv54, OuroQuoteBlock.Companion.serializer());
        KClass clazz$iv55 = Reflection.getOrCreateKotlinClass(OuroBoxContainer.class);
        builder$iv4.subclass(clazz$iv55, OuroBoxContainer.Companion.serializer());
        KClass clazz$iv56 = Reflection.getOrCreateKotlinClass(OuroInlineContent.class);
        builder$iv4.subclass(clazz$iv56, OuroInlineContent.Companion.serializer());
        KClass clazz$iv57 = Reflection.getOrCreateKotlinClass(OuroUniversalLink.class);
        builder$iv4.subclass(clazz$iv57, OuroUniversalLink.Companion.serializer());
        KClass clazz$iv58 = Reflection.getOrCreateKotlinClass(OuroAtMentionLink.class);
        builder$iv4.subclass(clazz$iv58, OuroAtMentionLink.Companion.serializer());
        builder$iv4.buildTo(builder$iv);
        SerializersModule = builder$iv.build();
        OuroProtoBuf = ProtoBufKt.ProtoBuf$default((ProtoBuf) null, new Function1() { // from class: kntr.common.ouro.core.utils.SerializationUtilsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit OuroProtoBuf$lambda$0;
                OuroProtoBuf$lambda$0 = SerializationUtilsKt.OuroProtoBuf$lambda$0((ProtoBufBuilder) obj);
                return OuroProtoBuf$lambda$0;
            }
        }, 1, (Object) null);
    }

    public static final ProtoBuf getOuroProtoBuf() {
        return OuroProtoBuf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OuroProtoBuf$lambda$0(ProtoBufBuilder $this$ProtoBuf) {
        Intrinsics.checkNotNullParameter($this$ProtoBuf, "$this$ProtoBuf");
        $this$ProtoBuf.setSerializersModule(SerializersModule);
        return Unit.INSTANCE;
    }
}