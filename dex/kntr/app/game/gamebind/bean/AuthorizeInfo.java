package kntr.app.game.gamebind.bean;

import BottomSheetItemData$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AuthorizeInfo.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 _2\u00020\u0001:\u0002^_B±\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016B¯\u0001\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0015\u0010\u001aJ\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u000bHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u000bHÆ\u0003J\t\u0010M\u001a\u00020\u000bHÆ\u0003J\t\u0010N\u001a\u00020\u000bHÆ\u0003J\t\u0010O\u001a\u00020\u0013HÆ\u0003J\t\u0010P\u001a\u00020\u0013HÆ\u0003J³\u0001\u0010Q\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013HÆ\u0001J\u0013\u0010R\u001a\u00020\u00132\b\u0010S\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010T\u001a\u00020\u000bHÖ\u0001J\t\u0010U\u001a\u00020\u0003HÖ\u0001J%\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\H\u0001¢\u0006\u0002\b]R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001eR\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u001eR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010\u001eR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u001eR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u001c\u001a\u0004\b*\u0010\u001eR\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u001c\u001a\u0004\b,\u0010-R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001c\u001a\u0004\b/\u0010\u001eR\u001c\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001c\u001a\u0004\b1\u0010\u001eR\u001c\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u001c\u001a\u0004\b3\u0010\u001eR\u001c\u0010\u000f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u001c\u001a\u0004\b5\u0010-R\u001c\u0010\u0010\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u001c\u001a\u0004\b7\u0010-R\u001c\u0010\u0011\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010\u001c\u001a\u0004\b9\u0010-R\u001c\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010\u001c\u001a\u0004\b;\u0010<R$\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b=\u0010\u001c\u001a\u0004\b>\u0010<\"\u0004\b?\u0010@¨\u0006`"}, d2 = {"Lkntr/app/game/gamebind/bean/AuthorizeInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "dialogTitle", RoomRecommendViewModel.EMPTY_CURSOR, "title", "content", "agreementTitle", "agreementUrl", "privacyUrl", "batchAuthorizeTitle", "versionId", RoomRecommendViewModel.EMPTY_CURSOR, "versionDesc", "disagreeBtnText", "agreeBtnText", "distributorChannelId", "scene", "defaultCheck", "canBatchAuth", RoomRecommendViewModel.EMPTY_CURSOR, "bind", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIZZ)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDialogTitle$annotations", "()V", "getDialogTitle", "()Ljava/lang/String;", "getTitle$annotations", "getTitle", "getContent$annotations", "getContent", "getAgreementTitle$annotations", "getAgreementTitle", "getAgreementUrl$annotations", "getAgreementUrl", "getPrivacyUrl$annotations", "getPrivacyUrl", "getBatchAuthorizeTitle$annotations", "getBatchAuthorizeTitle", "getVersionId$annotations", "getVersionId", "()I", "getVersionDesc$annotations", "getVersionDesc", "getDisagreeBtnText$annotations", "getDisagreeBtnText", "getAgreeBtnText$annotations", "getAgreeBtnText", "getDistributorChannelId$annotations", "getDistributorChannelId", "getScene$annotations", "getScene", "getDefaultCheck$annotations", "getDefaultCheck", "getCanBatchAuth$annotations", "getCanBatchAuth", "()Z", "getBind$annotations", "getBind", "setBind", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$game_bind_debug", "$serializer", "Companion", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AuthorizeInfo {
    public static final Companion Companion = new Companion(null);
    private final String agreeBtnText;
    private final String agreementTitle;
    private final String agreementUrl;
    private final String batchAuthorizeTitle;
    private boolean bind;
    private final boolean canBatchAuth;
    private final String content;
    private final int defaultCheck;
    private final String dialogTitle;
    private final String disagreeBtnText;
    private final int distributorChannelId;
    private final String privacyUrl;
    private final int scene;
    private final String title;
    private final String versionDesc;
    private final int versionId;

    public AuthorizeInfo() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, 0, 0, 0, false, false, 65535, (DefaultConstructorMarker) null);
    }

    @SerialName("agree_button_text")
    public static /* synthetic */ void getAgreeBtnText$annotations() {
    }

    @SerialName("agreement_title")
    public static /* synthetic */ void getAgreementTitle$annotations() {
    }

    @SerialName("agreement_url")
    public static /* synthetic */ void getAgreementUrl$annotations() {
    }

    @SerialName("batch_auth_title")
    public static /* synthetic */ void getBatchAuthorizeTitle$annotations() {
    }

    @SerialName("bind")
    public static /* synthetic */ void getBind$annotations() {
    }

    @SerialName("can_batch_auth")
    public static /* synthetic */ void getCanBatchAuth$annotations() {
    }

    @SerialName("content")
    public static /* synthetic */ void getContent$annotations() {
    }

    @SerialName("default_check")
    public static /* synthetic */ void getDefaultCheck$annotations() {
    }

    @SerialName("dialog_title")
    public static /* synthetic */ void getDialogTitle$annotations() {
    }

    @SerialName("disagree_button_text")
    public static /* synthetic */ void getDisagreeBtnText$annotations() {
    }

    @SerialName("distributor_channel_id")
    public static /* synthetic */ void getDistributorChannelId$annotations() {
    }

    @SerialName("privacy_url")
    public static /* synthetic */ void getPrivacyUrl$annotations() {
    }

    @SerialName("scene")
    public static /* synthetic */ void getScene$annotations() {
    }

    @SerialName("title")
    public static /* synthetic */ void getTitle$annotations() {
    }

    @SerialName("version_desc")
    public static /* synthetic */ void getVersionDesc$annotations() {
    }

    @SerialName("version_id")
    public static /* synthetic */ void getVersionId$annotations() {
    }

    public final String component1() {
        return this.dialogTitle;
    }

    public final String component10() {
        return this.disagreeBtnText;
    }

    public final String component11() {
        return this.agreeBtnText;
    }

    public final int component12() {
        return this.distributorChannelId;
    }

    public final int component13() {
        return this.scene;
    }

    public final int component14() {
        return this.defaultCheck;
    }

    public final boolean component15() {
        return this.canBatchAuth;
    }

    public final boolean component16() {
        return this.bind;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.agreementTitle;
    }

    public final String component5() {
        return this.agreementUrl;
    }

    public final String component6() {
        return this.privacyUrl;
    }

    public final String component7() {
        return this.batchAuthorizeTitle;
    }

    public final int component8() {
        return this.versionId;
    }

    public final String component9() {
        return this.versionDesc;
    }

    public final AuthorizeInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, String str10, int i2, int i3, int i4, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "content");
        Intrinsics.checkNotNullParameter(str4, "agreementTitle");
        Intrinsics.checkNotNullParameter(str9, "disagreeBtnText");
        Intrinsics.checkNotNullParameter(str10, "agreeBtnText");
        return new AuthorizeInfo(str, str2, str3, str4, str5, str6, str7, i, str8, str9, str10, i2, i3, i4, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AuthorizeInfo) {
            AuthorizeInfo authorizeInfo = (AuthorizeInfo) obj;
            return Intrinsics.areEqual(this.dialogTitle, authorizeInfo.dialogTitle) && Intrinsics.areEqual(this.title, authorizeInfo.title) && Intrinsics.areEqual(this.content, authorizeInfo.content) && Intrinsics.areEqual(this.agreementTitle, authorizeInfo.agreementTitle) && Intrinsics.areEqual(this.agreementUrl, authorizeInfo.agreementUrl) && Intrinsics.areEqual(this.privacyUrl, authorizeInfo.privacyUrl) && Intrinsics.areEqual(this.batchAuthorizeTitle, authorizeInfo.batchAuthorizeTitle) && this.versionId == authorizeInfo.versionId && Intrinsics.areEqual(this.versionDesc, authorizeInfo.versionDesc) && Intrinsics.areEqual(this.disagreeBtnText, authorizeInfo.disagreeBtnText) && Intrinsics.areEqual(this.agreeBtnText, authorizeInfo.agreeBtnText) && this.distributorChannelId == authorizeInfo.distributorChannelId && this.scene == authorizeInfo.scene && this.defaultCheck == authorizeInfo.defaultCheck && this.canBatchAuth == authorizeInfo.canBatchAuth && this.bind == authorizeInfo.bind;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((this.dialogTitle == null ? 0 : this.dialogTitle.hashCode()) * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31) + this.agreementTitle.hashCode()) * 31) + (this.agreementUrl == null ? 0 : this.agreementUrl.hashCode())) * 31) + (this.privacyUrl == null ? 0 : this.privacyUrl.hashCode())) * 31) + (this.batchAuthorizeTitle == null ? 0 : this.batchAuthorizeTitle.hashCode())) * 31) + this.versionId) * 31) + (this.versionDesc != null ? this.versionDesc.hashCode() : 0)) * 31) + this.disagreeBtnText.hashCode()) * 31) + this.agreeBtnText.hashCode()) * 31) + this.distributorChannelId) * 31) + this.scene) * 31) + this.defaultCheck) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.canBatchAuth)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.bind);
    }

    public String toString() {
        String str = this.dialogTitle;
        String str2 = this.title;
        String str3 = this.content;
        String str4 = this.agreementTitle;
        String str5 = this.agreementUrl;
        String str6 = this.privacyUrl;
        String str7 = this.batchAuthorizeTitle;
        int i = this.versionId;
        String str8 = this.versionDesc;
        String str9 = this.disagreeBtnText;
        String str10 = this.agreeBtnText;
        int i2 = this.distributorChannelId;
        int i3 = this.scene;
        int i4 = this.defaultCheck;
        boolean z = this.canBatchAuth;
        return "AuthorizeInfo(dialogTitle=" + str + ", title=" + str2 + ", content=" + str3 + ", agreementTitle=" + str4 + ", agreementUrl=" + str5 + ", privacyUrl=" + str6 + ", batchAuthorizeTitle=" + str7 + ", versionId=" + i + ", versionDesc=" + str8 + ", disagreeBtnText=" + str9 + ", agreeBtnText=" + str10 + ", distributorChannelId=" + i2 + ", scene=" + i3 + ", defaultCheck=" + i4 + ", canBatchAuth=" + z + ", bind=" + this.bind + ")";
    }

    /* compiled from: AuthorizeInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/gamebind/bean/AuthorizeInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/gamebind/bean/AuthorizeInfo;", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AuthorizeInfo> serializer() {
            return new GeneratedSerializer<AuthorizeInfo>() { // from class: kntr.app.game.gamebind.bean.AuthorizeInfo$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.game.gamebind.bean.AuthorizeInfo", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.game.gamebind.bean.AuthorizeInfo> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.game.gamebind.bean.AuthorizeInfo> A[REMOVE]) =  kntr.app.game.gamebind.bean.AuthorizeInfo$$serializer.INSTANCE kntr.app.game.gamebind.bean.AuthorizeInfo$$serializer)
                         in method: kntr.app.game.gamebind.bean.AuthorizeInfo.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.game.gamebind.bean.AuthorizeInfo>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.util.ArrayList.forEach(ArrayList.java:1257)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:309)
                        	... 5 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: CONSTRUCTOR  (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.descriptors.SerialDescriptor) = 
                          ("kntr.app.game.gamebind.bean.AuthorizeInfo")
                          (wrap: kntr.app.game.gamebind.bean.AuthorizeInfo$$serializer : 0x0009: SGET  (r1v0 kntr.app.game.gamebind.bean.AuthorizeInfo$$serializer A[REMOVE]) =  kntr.app.game.gamebind.bean.AuthorizeInfo$$serializer.INSTANCE kntr.app.game.gamebind.bean.AuthorizeInfo$$serializer)
                          (16 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.game.gamebind.bean.AuthorizeInfo$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                        	... 5 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.game.gamebind.bean.AuthorizeInfo$$serializer
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:775)
                        	at jadx.core.codegen.InsnGen.staticField(InsnGen.java:224)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:491)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:765)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                        	... 15 more
                        */
                    /*
                        this = this;
                        kntr.app.game.gamebind.bean.AuthorizeInfo$$serializer r0 = kntr.app.game.gamebind.bean.AuthorizeInfo$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.game.gamebind.bean.AuthorizeInfo.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ AuthorizeInfo(int seen0, String dialogTitle, String title, String content, String agreementTitle, String agreementUrl, String privacyUrl, String batchAuthorizeTitle, int versionId, String versionDesc, String disagreeBtnText, String agreeBtnText, int distributorChannelId, int scene, int defaultCheck, boolean canBatchAuth, boolean bind, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.dialogTitle = null;
                } else {
                    this.dialogTitle = dialogTitle;
                }
                if ((seen0 & 2) == 0) {
                    this.title = RoomRecommendViewModel.EMPTY_CURSOR;
                } else {
                    this.title = title;
                }
                if ((seen0 & 4) == 0) {
                    this.content = RoomRecommendViewModel.EMPTY_CURSOR;
                } else {
                    this.content = content;
                }
                if ((seen0 & 8) == 0) {
                    this.agreementTitle = RoomRecommendViewModel.EMPTY_CURSOR;
                } else {
                    this.agreementTitle = agreementTitle;
                }
                if ((seen0 & 16) == 0) {
                    this.agreementUrl = null;
                } else {
                    this.agreementUrl = agreementUrl;
                }
                if ((seen0 & 32) == 0) {
                    this.privacyUrl = null;
                } else {
                    this.privacyUrl = privacyUrl;
                }
                if ((seen0 & 64) == 0) {
                    this.batchAuthorizeTitle = null;
                } else {
                    this.batchAuthorizeTitle = batchAuthorizeTitle;
                }
                if ((seen0 & 128) == 0) {
                    this.versionId = 0;
                } else {
                    this.versionId = versionId;
                }
                if ((seen0 & 256) == 0) {
                    this.versionDesc = null;
                } else {
                    this.versionDesc = versionDesc;
                }
                if ((seen0 & 512) == 0) {
                    this.disagreeBtnText = RoomRecommendViewModel.EMPTY_CURSOR;
                } else {
                    this.disagreeBtnText = disagreeBtnText;
                }
                if ((seen0 & 1024) == 0) {
                    this.agreeBtnText = RoomRecommendViewModel.EMPTY_CURSOR;
                } else {
                    this.agreeBtnText = agreeBtnText;
                }
                if ((seen0 & 2048) == 0) {
                    this.distributorChannelId = 0;
                } else {
                    this.distributorChannelId = distributorChannelId;
                }
                if ((seen0 & 4096) == 0) {
                    this.scene = 0;
                } else {
                    this.scene = scene;
                }
                if ((seen0 & 8192) == 0) {
                    this.defaultCheck = 0;
                } else {
                    this.defaultCheck = defaultCheck;
                }
                if ((seen0 & 16384) == 0) {
                    this.canBatchAuth = false;
                } else {
                    this.canBatchAuth = canBatchAuth;
                }
                if ((seen0 & 32768) == 0) {
                    this.bind = false;
                } else {
                    this.bind = bind;
                }
            }

            public AuthorizeInfo(String dialogTitle, String title, String content, String agreementTitle, String agreementUrl, String privacyUrl, String batchAuthorizeTitle, int versionId, String versionDesc, String disagreeBtnText, String agreeBtnText, int distributorChannelId, int scene, int defaultCheck, boolean canBatchAuth, boolean bind) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(content, "content");
                Intrinsics.checkNotNullParameter(agreementTitle, "agreementTitle");
                Intrinsics.checkNotNullParameter(disagreeBtnText, "disagreeBtnText");
                Intrinsics.checkNotNullParameter(agreeBtnText, "agreeBtnText");
                this.dialogTitle = dialogTitle;
                this.title = title;
                this.content = content;
                this.agreementTitle = agreementTitle;
                this.agreementUrl = agreementUrl;
                this.privacyUrl = privacyUrl;
                this.batchAuthorizeTitle = batchAuthorizeTitle;
                this.versionId = versionId;
                this.versionDesc = versionDesc;
                this.disagreeBtnText = disagreeBtnText;
                this.agreeBtnText = agreeBtnText;
                this.distributorChannelId = distributorChannelId;
                this.scene = scene;
                this.defaultCheck = defaultCheck;
                this.canBatchAuth = canBatchAuth;
                this.bind = bind;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$game_bind_debug(AuthorizeInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.dialogTitle != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.dialogTitle);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.title, RoomRecommendViewModel.EMPTY_CURSOR)) {
                    output.encodeStringElement(serialDesc, 1, self.title);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.content, RoomRecommendViewModel.EMPTY_CURSOR)) {
                    output.encodeStringElement(serialDesc, 2, self.content);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.agreementTitle, RoomRecommendViewModel.EMPTY_CURSOR)) {
                    output.encodeStringElement(serialDesc, 3, self.agreementTitle);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.agreementUrl != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.agreementUrl);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.privacyUrl != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.privacyUrl);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.batchAuthorizeTitle != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.batchAuthorizeTitle);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.versionId != 0) {
                    output.encodeIntElement(serialDesc, 7, self.versionId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.versionDesc != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.versionDesc);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.disagreeBtnText, RoomRecommendViewModel.EMPTY_CURSOR)) {
                    output.encodeStringElement(serialDesc, 9, self.disagreeBtnText);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 10) || !Intrinsics.areEqual(self.agreeBtnText, RoomRecommendViewModel.EMPTY_CURSOR)) {
                    output.encodeStringElement(serialDesc, 10, self.agreeBtnText);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 11) || self.distributorChannelId != 0) {
                    output.encodeIntElement(serialDesc, 11, self.distributorChannelId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 12) || self.scene != 0) {
                    output.encodeIntElement(serialDesc, 12, self.scene);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 13) || self.defaultCheck != 0) {
                    output.encodeIntElement(serialDesc, 13, self.defaultCheck);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 14) || self.canBatchAuth) {
                    output.encodeBooleanElement(serialDesc, 14, self.canBatchAuth);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 15) || self.bind) {
                    output.encodeBooleanElement(serialDesc, 15, self.bind);
                }
            }

            public /* synthetic */ AuthorizeInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, String str10, int i2, int i3, int i4, boolean z, boolean z2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
                this((i5 & 1) != 0 ? null : str, (i5 & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i5 & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i5 & 8) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str4, (i5 & 16) != 0 ? null : str5, (i5 & 32) != 0 ? null : str6, (i5 & 64) != 0 ? null : str7, (i5 & 128) != 0 ? 0 : i, (i5 & 256) == 0 ? str8 : null, (i5 & 512) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str9, (i5 & 1024) == 0 ? str10 : RoomRecommendViewModel.EMPTY_CURSOR, (i5 & 2048) != 0 ? 0 : i2, (i5 & 4096) != 0 ? 0 : i3, (i5 & 8192) != 0 ? 0 : i4, (i5 & 16384) != 0 ? false : z, (i5 & 32768) != 0 ? false : z2);
            }

            public final String getDialogTitle() {
                return this.dialogTitle;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getContent() {
                return this.content;
            }

            public final String getAgreementTitle() {
                return this.agreementTitle;
            }

            public final String getAgreementUrl() {
                return this.agreementUrl;
            }

            public final String getPrivacyUrl() {
                return this.privacyUrl;
            }

            public final String getBatchAuthorizeTitle() {
                return this.batchAuthorizeTitle;
            }

            public final int getVersionId() {
                return this.versionId;
            }

            public final String getVersionDesc() {
                return this.versionDesc;
            }

            public final String getDisagreeBtnText() {
                return this.disagreeBtnText;
            }

            public final String getAgreeBtnText() {
                return this.agreeBtnText;
            }

            public final int getDistributorChannelId() {
                return this.distributorChannelId;
            }

            public final int getScene() {
                return this.scene;
            }

            public final int getDefaultCheck() {
                return this.defaultCheck;
            }

            public final boolean getCanBatchAuth() {
                return this.canBatchAuth;
            }

            public final boolean getBind() {
                return this.bind;
            }

            public final void setBind(boolean z) {
                this.bind = z;
            }
        }