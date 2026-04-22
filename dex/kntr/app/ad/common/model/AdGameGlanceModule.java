package kntr.app.ad.common.model;

import BottomSheetItemData$;
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
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdAndroidGameInfo.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0003./0BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fBS\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003JK\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0001J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u000eHÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015R\u001b\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00061"}, d2 = {"Lkntr/app/ad/common/model/AdGameGlanceModule;", RoomRecommendViewModel.EMPTY_CURSOR, "display", RoomRecommendViewModel.EMPTY_CURSOR, "gameName", RoomRecommendViewModel.EMPTY_CURSOR, "gameIcon", "devName", "tagList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdGameGlanceModule$Tag;", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDisplay", "()Z", "getGameName", "()Ljava/lang/String;", "getGameIcon", "getDevName$annotations", "()V", "getDevName", "getTagList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "Tag", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdGameGlanceModule {
    private final String devName;
    private final boolean display;
    private final String gameIcon;
    private final String gameName;
    private final List<Tag> tagList;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdGameGlanceModule$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdGameGlanceModule._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public AdGameGlanceModule() {
        this(false, (String) null, (String) null, (String) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdGameGlanceModule copy$default(AdGameGlanceModule adGameGlanceModule, boolean z, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = adGameGlanceModule.display;
        }
        if ((i & 2) != 0) {
            str = adGameGlanceModule.gameName;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = adGameGlanceModule.gameIcon;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = adGameGlanceModule.devName;
        }
        String str6 = str3;
        List<Tag> list2 = list;
        if ((i & 16) != 0) {
            list2 = adGameGlanceModule.tagList;
        }
        return adGameGlanceModule.copy(z, str4, str5, str6, list2);
    }

    @SerialName("developer_input_name")
    public static /* synthetic */ void getDevName$annotations() {
    }

    public final boolean component1() {
        return this.display;
    }

    public final String component2() {
        return this.gameName;
    }

    public final String component3() {
        return this.gameIcon;
    }

    public final String component4() {
        return this.devName;
    }

    public final List<Tag> component5() {
        return this.tagList;
    }

    public final AdGameGlanceModule copy(boolean z, String str, String str2, String str3, List<Tag> list) {
        return new AdGameGlanceModule(z, str, str2, str3, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdGameGlanceModule) {
            AdGameGlanceModule adGameGlanceModule = (AdGameGlanceModule) obj;
            return this.display == adGameGlanceModule.display && Intrinsics.areEqual(this.gameName, adGameGlanceModule.gameName) && Intrinsics.areEqual(this.gameIcon, adGameGlanceModule.gameIcon) && Intrinsics.areEqual(this.devName, adGameGlanceModule.devName) && Intrinsics.areEqual(this.tagList, adGameGlanceModule.tagList);
        }
        return false;
    }

    public int hashCode() {
        return (((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.display) * 31) + (this.gameName == null ? 0 : this.gameName.hashCode())) * 31) + (this.gameIcon == null ? 0 : this.gameIcon.hashCode())) * 31) + (this.devName == null ? 0 : this.devName.hashCode())) * 31) + (this.tagList != null ? this.tagList.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.display;
        String str = this.gameName;
        String str2 = this.gameIcon;
        String str3 = this.devName;
        return "AdGameGlanceModule(display=" + z + ", gameName=" + str + ", gameIcon=" + str2 + ", devName=" + str3 + ", tagList=" + this.tagList + ")";
    }

    /* compiled from: AdAndroidGameInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdGameGlanceModule$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdGameGlanceModule;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdGameGlanceModule> serializer() {
            return AdGameGlanceModule$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdGameGlanceModule(int seen0, boolean display, String gameName, String gameIcon, String devName, List tagList, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.display = true;
        } else {
            this.display = display;
        }
        if ((seen0 & 2) == 0) {
            this.gameName = null;
        } else {
            this.gameName = gameName;
        }
        if ((seen0 & 4) == 0) {
            this.gameIcon = null;
        } else {
            this.gameIcon = gameIcon;
        }
        if ((seen0 & 8) == 0) {
            this.devName = null;
        } else {
            this.devName = devName;
        }
        if ((seen0 & 16) == 0) {
            this.tagList = null;
        } else {
            this.tagList = tagList;
        }
    }

    public AdGameGlanceModule(boolean display, String gameName, String gameIcon, String devName, List<Tag> list) {
        this.display = display;
        this.gameName = gameName;
        this.gameIcon = gameIcon;
        this.devName = devName;
        this.tagList = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdGameGlanceModule$Tag$$serializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdGameGlanceModule self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !self.display) {
            output.encodeBooleanElement(serialDesc, 0, self.display);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.gameName != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.gameName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.gameIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.gameIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.devName != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.devName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.tagList != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.tagList);
        }
    }

    public /* synthetic */ AdGameGlanceModule(boolean z, String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) == 0 ? list : null);
    }

    public final boolean getDisplay() {
        return this.display;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final String getGameIcon() {
        return this.gameIcon;
    }

    public final String getDevName() {
        return this.devName;
    }

    public final List<Tag> getTagList() {
        return this.tagList;
    }

    /* compiled from: AdAndroidGameInfo.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002 !B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lkntr/app/ad/common/model/AdGameGlanceModule$Tag;", RoomRecommendViewModel.EMPTY_CURSOR, "type", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ILjava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType", "()I", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "Companion", "$serializer", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Tag {
        public static final Companion Companion = new Companion(null);
        public static final int TYPE_1 = 1;
        public static final int TYPE_2 = 2;
        public static final int TYPE_3 = 3;
        public static final int TYPE_4 = 4;
        public static final int TYPE_5 = 5;
        public static final int TYPE_6 = 6;
        private final String text;
        private final int type;

        public Tag() {
            this(0, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Tag copy$default(Tag tag, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = tag.type;
            }
            if ((i2 & 2) != 0) {
                str = tag.text;
            }
            return tag.copy(i, str);
        }

        public final int component1() {
            return this.type;
        }

        public final String component2() {
            return this.text;
        }

        public final Tag copy(int i, String str) {
            return new Tag(i, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Tag) {
                Tag tag = (Tag) obj;
                return this.type == tag.type && Intrinsics.areEqual(this.text, tag.text);
            }
            return false;
        }

        public int hashCode() {
            return (this.type * 31) + (this.text == null ? 0 : this.text.hashCode());
        }

        public String toString() {
            int i = this.type;
            return "Tag(type=" + i + ", text=" + this.text + ")";
        }

        public /* synthetic */ Tag(int seen0, int type, String text, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.type = 6;
            } else {
                this.type = type;
            }
            if ((seen0 & 2) == 0) {
                this.text = null;
            } else {
                this.text = text;
            }
        }

        public Tag(int type, String text) {
            this.type = type;
            this.text = text;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$dto_debug(Tag self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.type != 6) {
                output.encodeIntElement(serialDesc, 0, self.type);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.text != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.text);
            }
        }

        public /* synthetic */ Tag(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 6 : i, (i2 & 2) != 0 ? null : str);
        }

        public final int getType() {
            return this.type;
        }

        public final String getText() {
            return this.text;
        }

        /* compiled from: AdAndroidGameInfo.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0015\u0010\u000b\u001a\u00020\f*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkntr/app/ad/common/model/AdGameGlanceModule$Tag$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "TYPE_1", RoomRecommendViewModel.EMPTY_CURSOR, "TYPE_2", "TYPE_3", "TYPE_4", "TYPE_5", "TYPE_6", "isEffectiveType", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdGameGlanceModule$Tag;", "(Lkntr/app/ad/common/model/AdGameGlanceModule$Tag;)Z", "serializer", "Lkotlinx/serialization/KSerializer;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Tag> serializer() {
                return AdGameGlanceModule$Tag$$serializer.INSTANCE;
            }

            public final boolean isEffectiveType(Tag $this$isEffectiveType) {
                Intrinsics.checkNotNullParameter($this$isEffectiveType, "<this>");
                return $this$isEffectiveType.getType() == 1 || $this$isEffectiveType.getType() == 2 || $this$isEffectiveType.getType() == 3 || $this$isEffectiveType.getType() == 4 || $this$isEffectiveType.getType() == 5 || $this$isEffectiveType.getType() == 6;
            }
        }
    }
}