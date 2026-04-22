package kntr.app.ad.common.model;

import java.util.List;
import kntr.app.ad.common.model.AdFeedbackPanel;
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

/* compiled from: AdFeedbackPanel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0004-./0BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bBU\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003JM\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\rHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R&\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u00061"}, d2 = {"Lkntr/app/ad/common/model/AdFeedbackPanel;", RoomRecommendViewModel.EMPTY_CURSOR, "panelTypeText", RoomRecommendViewModel.EMPTY_CURSOR, "toast", "closeRecTips", "openRecTips", "panels", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdFeedbackPanel$Panel;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPanelTypeText", "()Ljava/lang/String;", "getToast", "getCloseRecTips", "getOpenRecTips", "getPanels$annotations", "()V", "getPanels", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "Panel", "SecondaryPanel", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdFeedbackPanel {
    private final String closeRecTips;
    private final String openRecTips;
    private final String panelTypeText;
    private final List<Panel> panels;
    private final String toast;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdFeedbackPanel$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdFeedbackPanel._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public AdFeedbackPanel() {
        this((String) null, (String) null, (String) null, (String) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdFeedbackPanel copy$default(AdFeedbackPanel adFeedbackPanel, String str, String str2, String str3, String str4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adFeedbackPanel.panelTypeText;
        }
        if ((i & 2) != 0) {
            str2 = adFeedbackPanel.toast;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = adFeedbackPanel.closeRecTips;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = adFeedbackPanel.openRecTips;
        }
        String str7 = str4;
        List<Panel> list2 = list;
        if ((i & 16) != 0) {
            list2 = adFeedbackPanel.panels;
        }
        return adFeedbackPanel.copy(str, str5, str6, str7, list2);
    }

    @SerialName("feedback_panel_detail")
    public static /* synthetic */ void getPanels$annotations() {
    }

    public final String component1() {
        return this.panelTypeText;
    }

    public final String component2() {
        return this.toast;
    }

    public final String component3() {
        return this.closeRecTips;
    }

    public final String component4() {
        return this.openRecTips;
    }

    public final List<Panel> component5() {
        return this.panels;
    }

    public final AdFeedbackPanel copy(String str, String str2, String str3, String str4, List<Panel> list) {
        return new AdFeedbackPanel(str, str2, str3, str4, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdFeedbackPanel) {
            AdFeedbackPanel adFeedbackPanel = (AdFeedbackPanel) obj;
            return Intrinsics.areEqual(this.panelTypeText, adFeedbackPanel.panelTypeText) && Intrinsics.areEqual(this.toast, adFeedbackPanel.toast) && Intrinsics.areEqual(this.closeRecTips, adFeedbackPanel.closeRecTips) && Intrinsics.areEqual(this.openRecTips, adFeedbackPanel.openRecTips) && Intrinsics.areEqual(this.panels, adFeedbackPanel.panels);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.panelTypeText == null ? 0 : this.panelTypeText.hashCode()) * 31) + (this.toast == null ? 0 : this.toast.hashCode())) * 31) + (this.closeRecTips == null ? 0 : this.closeRecTips.hashCode())) * 31) + (this.openRecTips == null ? 0 : this.openRecTips.hashCode())) * 31) + (this.panels != null ? this.panels.hashCode() : 0);
    }

    public String toString() {
        String str = this.panelTypeText;
        String str2 = this.toast;
        String str3 = this.closeRecTips;
        String str4 = this.openRecTips;
        return "AdFeedbackPanel(panelTypeText=" + str + ", toast=" + str2 + ", closeRecTips=" + str3 + ", openRecTips=" + str4 + ", panels=" + this.panels + ")";
    }

    /* compiled from: AdFeedbackPanel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdFeedbackPanel$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdFeedbackPanel;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdFeedbackPanel> serializer() {
            return AdFeedbackPanel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdFeedbackPanel(int seen0, String panelTypeText, String toast, String closeRecTips, String openRecTips, List panels, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.panelTypeText = null;
        } else {
            this.panelTypeText = panelTypeText;
        }
        if ((seen0 & 2) == 0) {
            this.toast = null;
        } else {
            this.toast = toast;
        }
        if ((seen0 & 4) == 0) {
            this.closeRecTips = null;
        } else {
            this.closeRecTips = closeRecTips;
        }
        if ((seen0 & 8) == 0) {
            this.openRecTips = null;
        } else {
            this.openRecTips = openRecTips;
        }
        if ((seen0 & 16) == 0) {
            this.panels = null;
        } else {
            this.panels = panels;
        }
    }

    public AdFeedbackPanel(String panelTypeText, String toast, String closeRecTips, String openRecTips, List<Panel> list) {
        this.panelTypeText = panelTypeText;
        this.toast = toast;
        this.closeRecTips = closeRecTips;
        this.openRecTips = openRecTips;
        this.panels = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdFeedbackPanel$Panel$$serializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdFeedbackPanel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.panelTypeText != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.panelTypeText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.toast != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.toast);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.closeRecTips != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.closeRecTips);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.openRecTips != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.openRecTips);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.panels != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.panels);
        }
    }

    public /* synthetic */ AdFeedbackPanel(String str, String str2, String str3, String str4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : list);
    }

    public final String getPanelTypeText() {
        return this.panelTypeText;
    }

    public final String getToast() {
        return this.toast;
    }

    public final String getCloseRecTips() {
        return this.closeRecTips;
    }

    public final String getOpenRecTips() {
        return this.openRecTips;
    }

    /* compiled from: AdFeedbackPanel.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000245B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eBe\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bHÆ\u0003Ja\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001J%\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R&\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u00066"}, d2 = {"Lkntr/app/ad/common/model/AdFeedbackPanel$Panel;", RoomRecommendViewModel.EMPTY_CURSOR, "moduleId", RoomRecommendViewModel.EMPTY_CURSOR, "iconUrl", RoomRecommendViewModel.EMPTY_CURSOR, "jumpType", "jumpUrl", "text", "subText", "secondaryPanels", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdFeedbackPanel$SecondaryPanel;", "<init>", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getModuleId", "()I", "getIconUrl", "()Ljava/lang/String;", "getJumpType", "getJumpUrl", "getText", "getSubText", "getSecondaryPanels$annotations", "()V", "getSecondaryPanels", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Panel {
        private final String iconUrl;
        private final int jumpType;
        private final String jumpUrl;
        private final int moduleId;
        private final List<SecondaryPanel> secondaryPanels;
        private final String subText;
        private final String text;
        public static final Companion Companion = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdFeedbackPanel$Panel$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = AdFeedbackPanel.Panel._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        })};

        public Panel() {
            this(0, (String) null, 0, (String) null, (String) null, (String) null, (List) null, 127, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Panel copy$default(Panel panel, int i, String str, int i2, String str2, String str3, String str4, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = panel.moduleId;
            }
            if ((i3 & 2) != 0) {
                str = panel.iconUrl;
            }
            String str5 = str;
            if ((i3 & 4) != 0) {
                i2 = panel.jumpType;
            }
            int i4 = i2;
            if ((i3 & 8) != 0) {
                str2 = panel.jumpUrl;
            }
            String str6 = str2;
            if ((i3 & 16) != 0) {
                str3 = panel.text;
            }
            String str7 = str3;
            if ((i3 & 32) != 0) {
                str4 = panel.subText;
            }
            String str8 = str4;
            List<SecondaryPanel> list2 = list;
            if ((i3 & 64) != 0) {
                list2 = panel.secondaryPanels;
            }
            return panel.copy(i, str5, i4, str6, str7, str8, list2);
        }

        @SerialName("secondary_panel")
        public static /* synthetic */ void getSecondaryPanels$annotations() {
        }

        public final int component1() {
            return this.moduleId;
        }

        public final String component2() {
            return this.iconUrl;
        }

        public final int component3() {
            return this.jumpType;
        }

        public final String component4() {
            return this.jumpUrl;
        }

        public final String component5() {
            return this.text;
        }

        public final String component6() {
            return this.subText;
        }

        public final List<SecondaryPanel> component7() {
            return this.secondaryPanels;
        }

        public final Panel copy(int i, String str, int i2, String str2, String str3, String str4, List<SecondaryPanel> list) {
            return new Panel(i, str, i2, str2, str3, str4, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Panel) {
                Panel panel = (Panel) obj;
                return this.moduleId == panel.moduleId && Intrinsics.areEqual(this.iconUrl, panel.iconUrl) && this.jumpType == panel.jumpType && Intrinsics.areEqual(this.jumpUrl, panel.jumpUrl) && Intrinsics.areEqual(this.text, panel.text) && Intrinsics.areEqual(this.subText, panel.subText) && Intrinsics.areEqual(this.secondaryPanels, panel.secondaryPanels);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((this.moduleId * 31) + (this.iconUrl == null ? 0 : this.iconUrl.hashCode())) * 31) + this.jumpType) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.text == null ? 0 : this.text.hashCode())) * 31) + (this.subText == null ? 0 : this.subText.hashCode())) * 31) + (this.secondaryPanels != null ? this.secondaryPanels.hashCode() : 0);
        }

        public String toString() {
            int i = this.moduleId;
            String str = this.iconUrl;
            int i2 = this.jumpType;
            String str2 = this.jumpUrl;
            String str3 = this.text;
            String str4 = this.subText;
            return "Panel(moduleId=" + i + ", iconUrl=" + str + ", jumpType=" + i2 + ", jumpUrl=" + str2 + ", text=" + str3 + ", subText=" + str4 + ", secondaryPanels=" + this.secondaryPanels + ")";
        }

        /* compiled from: AdFeedbackPanel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdFeedbackPanel$Panel$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdFeedbackPanel$Panel;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Panel> serializer() {
                return AdFeedbackPanel$Panel$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Panel(int seen0, int moduleId, String iconUrl, int jumpType, String jumpUrl, String text, String subText, List secondaryPanels, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.moduleId = 0;
            } else {
                this.moduleId = moduleId;
            }
            if ((seen0 & 2) == 0) {
                this.iconUrl = null;
            } else {
                this.iconUrl = iconUrl;
            }
            if ((seen0 & 4) == 0) {
                this.jumpType = 0;
            } else {
                this.jumpType = jumpType;
            }
            if ((seen0 & 8) == 0) {
                this.jumpUrl = null;
            } else {
                this.jumpUrl = jumpUrl;
            }
            if ((seen0 & 16) == 0) {
                this.text = null;
            } else {
                this.text = text;
            }
            if ((seen0 & 32) == 0) {
                this.subText = null;
            } else {
                this.subText = subText;
            }
            if ((seen0 & 64) == 0) {
                this.secondaryPanels = null;
            } else {
                this.secondaryPanels = secondaryPanels;
            }
        }

        public Panel(int moduleId, String iconUrl, int jumpType, String jumpUrl, String text, String subText, List<SecondaryPanel> list) {
            this.moduleId = moduleId;
            this.iconUrl = iconUrl;
            this.jumpType = jumpType;
            this.jumpUrl = jumpUrl;
            this.text = text;
            this.subText = subText;
            this.secondaryPanels = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdFeedbackPanel$SecondaryPanel$$serializer.INSTANCE));
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$dto_debug(Panel self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.moduleId != 0) {
                output.encodeIntElement(serialDesc, 0, self.moduleId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.iconUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.iconUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.jumpType != 0) {
                output.encodeIntElement(serialDesc, 2, self.jumpType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.jumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.jumpUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.text != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.text);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.subText != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.subText);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.secondaryPanels != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.secondaryPanels);
            }
        }

        public /* synthetic */ Panel(int i, String str, int i2, String str2, String str3, String str4, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? null : str, (i3 & 4) == 0 ? i2 : 0, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : str4, (i3 & 64) != 0 ? null : list);
        }

        public final int getModuleId() {
            return this.moduleId;
        }

        public final String getIconUrl() {
            return this.iconUrl;
        }

        public final int getJumpType() {
            return this.jumpType;
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public final String getText() {
            return this.text;
        }

        public final String getSubText() {
            return this.subText;
        }

        public final List<SecondaryPanel> getSecondaryPanels() {
            return this.secondaryPanels;
        }
    }

    public final List<Panel> getPanels() {
        return this.panels;
    }

    /* compiled from: AdFeedbackPanel.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lkntr/app/ad/common/model/AdFeedbackPanel$SecondaryPanel;", RoomRecommendViewModel.EMPTY_CURSOR, "reasonId", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ILjava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getReasonId", "()I", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SecondaryPanel {
        public static final Companion Companion = new Companion(null);
        private final int reasonId;
        private final String text;

        public SecondaryPanel() {
            this(0, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ SecondaryPanel copy$default(SecondaryPanel secondaryPanel, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = secondaryPanel.reasonId;
            }
            if ((i2 & 2) != 0) {
                str = secondaryPanel.text;
            }
            return secondaryPanel.copy(i, str);
        }

        public final int component1() {
            return this.reasonId;
        }

        public final String component2() {
            return this.text;
        }

        public final SecondaryPanel copy(int i, String str) {
            return new SecondaryPanel(i, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SecondaryPanel) {
                SecondaryPanel secondaryPanel = (SecondaryPanel) obj;
                return this.reasonId == secondaryPanel.reasonId && Intrinsics.areEqual(this.text, secondaryPanel.text);
            }
            return false;
        }

        public int hashCode() {
            return (this.reasonId * 31) + (this.text == null ? 0 : this.text.hashCode());
        }

        public String toString() {
            int i = this.reasonId;
            return "SecondaryPanel(reasonId=" + i + ", text=" + this.text + ")";
        }

        /* compiled from: AdFeedbackPanel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdFeedbackPanel$SecondaryPanel$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdFeedbackPanel$SecondaryPanel;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<SecondaryPanel> serializer() {
                return AdFeedbackPanel$SecondaryPanel$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ SecondaryPanel(int seen0, int reasonId, String text, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.reasonId = 0;
            } else {
                this.reasonId = reasonId;
            }
            if ((seen0 & 2) == 0) {
                this.text = null;
            } else {
                this.text = text;
            }
        }

        public SecondaryPanel(int reasonId, String text) {
            this.reasonId = reasonId;
            this.text = text;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$dto_debug(SecondaryPanel self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.reasonId != 0) {
                output.encodeIntElement(serialDesc, 0, self.reasonId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.text != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.text);
            }
        }

        public /* synthetic */ SecondaryPanel(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str);
        }

        public final int getReasonId() {
            return this.reasonId;
        }

        public final String getText() {
            return this.text;
        }
    }
}