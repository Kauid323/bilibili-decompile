package kntr.app.ad.common.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import java.util.List;
import kntr.app.game.base.ui.widget.gameaction.state.GameActionStateKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdAndroidGameInfo.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/common/model/AdAndroidGameInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/common/model/AdAndroidGameInfo;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdAndroidGameInfo$$serializer implements GeneratedSerializer<AdAndroidGameInfo> {
    public static final AdAndroidGameInfo$$serializer INSTANCE = new AdAndroidGameInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.common.model.AdAndroidGameInfo", INSTANCE, 15);
        pluginGeneratedSerialDescriptor.addElement("module_seq", true);
        pluginGeneratedSerialDescriptor.addElement("background_color", true);
        pluginGeneratedSerialDescriptor.addElement("module1", true);
        pluginGeneratedSerialDescriptor.addElement("module3", true);
        pluginGeneratedSerialDescriptor.addElement("module4", true);
        pluginGeneratedSerialDescriptor.addElement("module5", true);
        pluginGeneratedSerialDescriptor.addElement("module6", true);
        pluginGeneratedSerialDescriptor.addElement("module7", true);
        pluginGeneratedSerialDescriptor.addElement("module8", true);
        pluginGeneratedSerialDescriptor.addElement("module9", true);
        pluginGeneratedSerialDescriptor.addElement("module10", true);
        pluginGeneratedSerialDescriptor.addElement("module11", true);
        pluginGeneratedSerialDescriptor.addElement("module12", true);
        pluginGeneratedSerialDescriptor.addElement("module13", true);
        pluginGeneratedSerialDescriptor.addElement("module14", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdAndroidGameInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = AdAndroidGameInfo.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable((KSerializer) lazyArr[0].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdGameGlanceModule$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdGameQualityModule$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdGameGiftModule$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdGameSummaryModule$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdGameDescModule$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdGameScreenShotModule$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdGameTagModule$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdGameDevIntroModule$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdGameLatestUpdateModule$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdGameGradeModule$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdGameCommentModule$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdGameApkInfoModule$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdGameBookAwardModule$$serializer.INSTANCE)};
    }

    public final AdAndroidGameInfo deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        AdGameBookAwardModule adGameBookAwardModule;
        AdGameDescModule adGameDescModule;
        AdGameDevIntroModule adGameDevIntroModule;
        AdGameTagModule adGameTagModule;
        AdGameScreenShotModule adGameScreenShotModule;
        AdGameSummaryModule adGameSummaryModule;
        String str;
        AdGameGlanceModule adGameGlanceModule;
        List list;
        AdGameQualityModule adGameQualityModule;
        AdGameGradeModule adGameGradeModule;
        AdGameLatestUpdateModule adGameLatestUpdateModule;
        AdGameGiftModule adGameGiftModule;
        int i;
        AdGameApkInfoModule adGameApkInfoModule;
        AdGameCommentModule adGameCommentModule;
        AdGameQualityModule adGameQualityModule2;
        AdGameCommentModule adGameCommentModule2;
        AdGameApkInfoModule adGameApkInfoModule2;
        AdGameGlanceModule adGameGlanceModule2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = AdAndroidGameInfo.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            AdGameGradeModule adGameGradeModule2 = (AdGameGradeModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, AdGameGradeModule$$serializer.INSTANCE, (Object) null);
            AdGameCommentModule adGameCommentModule3 = (AdGameCommentModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, AdGameCommentModule$$serializer.INSTANCE, (Object) null);
            AdGameApkInfoModule adGameApkInfoModule3 = (AdGameApkInfoModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, AdGameApkInfoModule$$serializer.INSTANCE, (Object) null);
            adGameBookAwardModule = (AdGameBookAwardModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, AdGameBookAwardModule$$serializer.INSTANCE, (Object) null);
            adGameGiftModule = (AdGameGiftModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, AdGameGiftModule$$serializer.INSTANCE, (Object) null);
            adGameSummaryModule = (AdGameSummaryModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, AdGameSummaryModule$$serializer.INSTANCE, (Object) null);
            adGameDevIntroModule = (AdGameDevIntroModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, AdGameDevIntroModule$$serializer.INSTANCE, (Object) null);
            adGameLatestUpdateModule = (AdGameLatestUpdateModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, AdGameLatestUpdateModule$$serializer.INSTANCE, (Object) null);
            adGameApkInfoModule = adGameApkInfoModule3;
            adGameCommentModule = adGameCommentModule3;
            adGameGradeModule = adGameGradeModule2;
            adGameQualityModule = (AdGameQualityModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, AdGameQualityModule$$serializer.INSTANCE, (Object) null);
            i = 32767;
            adGameScreenShotModule = (AdGameScreenShotModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, AdGameScreenShotModule$$serializer.INSTANCE, (Object) null);
            adGameDescModule = (AdGameDescModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, AdGameDescModule$$serializer.INSTANCE, (Object) null);
            adGameTagModule = (AdGameTagModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, AdGameTagModule$$serializer.INSTANCE, (Object) null);
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            adGameGlanceModule = (AdGameGlanceModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, AdGameGlanceModule$$serializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            AdGameCommentModule adGameCommentModule4 = null;
            AdGameApkInfoModule adGameApkInfoModule4 = null;
            AdGameBookAwardModule adGameBookAwardModule2 = null;
            AdGameDescModule adGameDescModule2 = null;
            AdGameGiftModule adGameGiftModule2 = null;
            AdGameQualityModule adGameQualityModule3 = null;
            AdGameGradeModule adGameGradeModule3 = null;
            AdGameDevIntroModule adGameDevIntroModule2 = null;
            AdGameTagModule adGameTagModule2 = null;
            AdGameScreenShotModule adGameScreenShotModule2 = null;
            AdGameSummaryModule adGameSummaryModule2 = null;
            AdGameLatestUpdateModule adGameLatestUpdateModule2 = null;
            List list2 = null;
            String str2 = null;
            int i2 = 0;
            AdGameGlanceModule adGameGlanceModule3 = null;
            while (z) {
                AdGameGlanceModule adGameGlanceModule4 = adGameGlanceModule3;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z = false;
                        adGameGlanceModule3 = adGameGlanceModule4;
                        adGameApkInfoModule4 = adGameApkInfoModule4;
                        break;
                    case 0:
                        adGameCommentModule2 = adGameCommentModule4;
                        adGameApkInfoModule2 = adGameApkInfoModule4;
                        adGameGlanceModule2 = adGameGlanceModule4;
                        list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list2);
                        i2 |= 1;
                        str2 = str2;
                        adGameGlanceModule3 = adGameGlanceModule2;
                        adGameApkInfoModule4 = adGameApkInfoModule2;
                        adGameCommentModule4 = adGameCommentModule2;
                        break;
                    case 1:
                        adGameCommentModule2 = adGameCommentModule4;
                        adGameApkInfoModule2 = adGameApkInfoModule4;
                        adGameGlanceModule2 = adGameGlanceModule4;
                        str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str2);
                        i2 |= 2;
                        adGameGlanceModule3 = adGameGlanceModule2;
                        adGameApkInfoModule4 = adGameApkInfoModule2;
                        adGameCommentModule4 = adGameCommentModule2;
                        break;
                    case 2:
                        adGameCommentModule2 = adGameCommentModule4;
                        adGameApkInfoModule2 = adGameApkInfoModule4;
                        adGameGlanceModule3 = (AdGameGlanceModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, AdGameGlanceModule$$serializer.INSTANCE, adGameGlanceModule4);
                        i2 |= 4;
                        adGameApkInfoModule4 = adGameApkInfoModule2;
                        adGameCommentModule4 = adGameCommentModule2;
                        break;
                    case 3:
                        adGameQualityModule3 = (AdGameQualityModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, AdGameQualityModule$$serializer.INSTANCE, adGameQualityModule3);
                        i2 |= 8;
                        adGameCommentModule4 = adGameCommentModule4;
                        adGameGlanceModule3 = adGameGlanceModule4;
                        break;
                    case 4:
                        adGameQualityModule2 = adGameQualityModule3;
                        adGameGiftModule2 = (AdGameGiftModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, AdGameGiftModule$$serializer.INSTANCE, adGameGiftModule2);
                        i2 |= 16;
                        adGameGlanceModule3 = adGameGlanceModule4;
                        adGameQualityModule3 = adGameQualityModule2;
                        break;
                    case 5:
                        adGameQualityModule2 = adGameQualityModule3;
                        adGameSummaryModule2 = (AdGameSummaryModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, AdGameSummaryModule$$serializer.INSTANCE, adGameSummaryModule2);
                        i2 |= 32;
                        adGameGlanceModule3 = adGameGlanceModule4;
                        adGameQualityModule3 = adGameQualityModule2;
                        break;
                    case 6:
                        adGameQualityModule2 = adGameQualityModule3;
                        adGameDescModule2 = (AdGameDescModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, AdGameDescModule$$serializer.INSTANCE, adGameDescModule2);
                        i2 |= 64;
                        adGameGlanceModule3 = adGameGlanceModule4;
                        adGameQualityModule3 = adGameQualityModule2;
                        break;
                    case 7:
                        adGameQualityModule2 = adGameQualityModule3;
                        adGameScreenShotModule2 = (AdGameScreenShotModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, AdGameScreenShotModule$$serializer.INSTANCE, adGameScreenShotModule2);
                        i2 |= 128;
                        adGameGlanceModule3 = adGameGlanceModule4;
                        adGameQualityModule3 = adGameQualityModule2;
                        break;
                    case 8:
                        adGameQualityModule2 = adGameQualityModule3;
                        adGameTagModule2 = (AdGameTagModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, AdGameTagModule$$serializer.INSTANCE, adGameTagModule2);
                        i2 |= 256;
                        adGameGlanceModule3 = adGameGlanceModule4;
                        adGameQualityModule3 = adGameQualityModule2;
                        break;
                    case 9:
                        adGameQualityModule2 = adGameQualityModule3;
                        adGameDevIntroModule2 = (AdGameDevIntroModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, AdGameDevIntroModule$$serializer.INSTANCE, adGameDevIntroModule2);
                        i2 |= 512;
                        adGameGlanceModule3 = adGameGlanceModule4;
                        adGameQualityModule3 = adGameQualityModule2;
                        break;
                    case 10:
                        adGameQualityModule2 = adGameQualityModule3;
                        adGameLatestUpdateModule2 = (AdGameLatestUpdateModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, AdGameLatestUpdateModule$$serializer.INSTANCE, adGameLatestUpdateModule2);
                        i2 |= 1024;
                        adGameGlanceModule3 = adGameGlanceModule4;
                        adGameQualityModule3 = adGameQualityModule2;
                        break;
                    case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                        adGameQualityModule2 = adGameQualityModule3;
                        adGameGradeModule3 = (AdGameGradeModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, AdGameGradeModule$$serializer.INSTANCE, adGameGradeModule3);
                        i2 |= 2048;
                        adGameGlanceModule3 = adGameGlanceModule4;
                        adGameQualityModule3 = adGameQualityModule2;
                        break;
                    case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                        adGameQualityModule2 = adGameQualityModule3;
                        adGameCommentModule4 = (AdGameCommentModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, AdGameCommentModule$$serializer.INSTANCE, adGameCommentModule4);
                        i2 |= 4096;
                        adGameGlanceModule3 = adGameGlanceModule4;
                        adGameQualityModule3 = adGameQualityModule2;
                        break;
                    case AdditionVote2.BIZ_TYPE_FIELD_NUMBER /* 13 */:
                        adGameQualityModule2 = adGameQualityModule3;
                        adGameApkInfoModule4 = (AdGameApkInfoModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, AdGameApkInfoModule$$serializer.INSTANCE, adGameApkInfoModule4);
                        i2 |= 8192;
                        adGameGlanceModule3 = adGameGlanceModule4;
                        adGameQualityModule3 = adGameQualityModule2;
                        break;
                    case AdditionVote2.TOTAL_FIELD_NUMBER /* 14 */:
                        adGameQualityModule2 = adGameQualityModule3;
                        adGameBookAwardModule2 = (AdGameBookAwardModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, AdGameBookAwardModule$$serializer.INSTANCE, adGameBookAwardModule2);
                        i2 |= 16384;
                        adGameGlanceModule3 = adGameGlanceModule4;
                        adGameQualityModule3 = adGameQualityModule2;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            adGameBookAwardModule = adGameBookAwardModule2;
            adGameDescModule = adGameDescModule2;
            adGameDevIntroModule = adGameDevIntroModule2;
            adGameTagModule = adGameTagModule2;
            adGameScreenShotModule = adGameScreenShotModule2;
            adGameSummaryModule = adGameSummaryModule2;
            str = str2;
            adGameGlanceModule = adGameGlanceModule3;
            list = list2;
            adGameQualityModule = adGameQualityModule3;
            adGameGradeModule = adGameGradeModule3;
            adGameLatestUpdateModule = adGameLatestUpdateModule2;
            adGameGiftModule = adGameGiftModule2;
            i = i2;
            adGameApkInfoModule = adGameApkInfoModule4;
            adGameCommentModule = adGameCommentModule4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AdAndroidGameInfo(i, list, str, adGameGlanceModule, adGameQualityModule, adGameGiftModule, adGameSummaryModule, adGameDescModule, adGameScreenShotModule, adGameTagModule, adGameDevIntroModule, adGameLatestUpdateModule, adGameGradeModule, adGameCommentModule, adGameApkInfoModule, adGameBookAwardModule, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, AdAndroidGameInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdAndroidGameInfo.write$Self$dto_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}