package kntr.app.im.chat.core.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.IntRect;
import com.bapis.bilibili.app.im.v1.KNotifyCosmoThreeDotItem;
import com.bapis.bilibili.app.im.v1.KPictureModule;
import com.bapis.bilibili.app.im.v1.KShortcutType;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.List;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.db.model.InputBoxContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.ImageSource;
import kntr.common.photonic.Asset;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: ChatAction.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u001d\bg\u0018\u00002\u00020\u0001:\u001c\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001eÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction;", RoomRecommendViewModel.EMPTY_CURSOR, "RouteTo", "RequestListPrevious", "InputBoxTextChanged", "InputBoxTextInserted", "InputBoxBackspacePressed", "CopyTextIntoClipBoard", "InputBoxEmojiInserted", "SwitchBottomSheetPanel", "SwitchBottomSheetToGallery", "SendMessage", "ResendMessage", "DeleteMessage", "DeleteMessageConfirm", "DeleteMessageCancel", "RecallMessage", "RecallMessageWithSeq", "SaveSticker", "SendSingleAsset", "ShowStickerEditPage", "ImagePreviewClicked", "BottomSheetImagePreviewClicked", "ImagePreviewClosed", "ShortcutClick", "NotifyCosmosOp", "DismissUpgradeAnswerDialog", "ReportMessage", "DismissBehaviorAlert", "ShowPhaseTwoPushMessage", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ChatAction {

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$RouteTo;", "Lkntr/app/im/chat/core/model/ChatAction;", "url", "Lcom/bilibili/lib/brouter/uri/Uri;", "<init>", "(Lcom/bilibili/lib/brouter/uri/Uri;)V", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/String;)V", "getUrl", "()Lcom/bilibili/lib/brouter/uri/Uri;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class RouteTo implements ChatAction {
        public static final int $stable = 0;
        private final Uri url;

        public static /* synthetic */ RouteTo copy$default(RouteTo routeTo, Uri uri, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = routeTo.url;
            }
            return routeTo.copy(uri);
        }

        public final Uri component1() {
            return this.url;
        }

        public final RouteTo copy(Uri uri) {
            return new RouteTo(uri);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RouteTo) && Intrinsics.areEqual(this.url, ((RouteTo) obj).url);
        }

        public int hashCode() {
            if (this.url == null) {
                return 0;
            }
            return this.url.hashCode();
        }

        public String toString() {
            return "RouteTo(url=" + this.url + ")";
        }

        public RouteTo(Uri url) {
            this.url = url;
        }

        public final Uri getUrl() {
            return this.url;
        }

        public RouteTo(String url) {
            this(url != null ? Uri.Companion.parse(url) : null);
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$RequestListPrevious;", "Lkntr/app/im/chat/core/model/ChatAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class RequestListPrevious implements ChatAction {
        public static final int $stable = 0;
        public static final RequestListPrevious INSTANCE = new RequestListPrevious();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RequestListPrevious) {
                RequestListPrevious requestListPrevious = (RequestListPrevious) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1466548910;
        }

        public String toString() {
            return "RequestListPrevious";
        }

        private RequestListPrevious() {
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$InputBoxTextChanged;", "Lkntr/app/im/chat/core/model/ChatAction;", "newValue", "Lkntr/app/im/chat/db/model/InputBoxContent;", "<init>", "(Lkntr/app/im/chat/db/model/InputBoxContent;)V", "getNewValue", "()Lkntr/app/im/chat/db/model/InputBoxContent;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class InputBoxTextChanged implements ChatAction {
        public static final int $stable = 0;
        private final InputBoxContent newValue;

        public static /* synthetic */ InputBoxTextChanged copy$default(InputBoxTextChanged inputBoxTextChanged, InputBoxContent inputBoxContent, int i, Object obj) {
            if ((i & 1) != 0) {
                inputBoxContent = inputBoxTextChanged.newValue;
            }
            return inputBoxTextChanged.copy(inputBoxContent);
        }

        public final InputBoxContent component1() {
            return this.newValue;
        }

        public final InputBoxTextChanged copy(InputBoxContent inputBoxContent) {
            Intrinsics.checkNotNullParameter(inputBoxContent, "newValue");
            return new InputBoxTextChanged(inputBoxContent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InputBoxTextChanged) && Intrinsics.areEqual(this.newValue, ((InputBoxTextChanged) obj).newValue);
        }

        public int hashCode() {
            return this.newValue.hashCode();
        }

        public String toString() {
            return "InputBoxTextChanged(newValue=" + this.newValue + ")";
        }

        public InputBoxTextChanged(InputBoxContent newValue) {
            Intrinsics.checkNotNullParameter(newValue, "newValue");
            this.newValue = newValue;
        }

        public final InputBoxContent getNewValue() {
            return this.newValue;
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$InputBoxTextInserted;", "Lkntr/app/im/chat/core/model/ChatAction;", "text", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class InputBoxTextInserted implements ChatAction {
        public static final int $stable = 0;
        private final String text;

        public static /* synthetic */ InputBoxTextInserted copy$default(InputBoxTextInserted inputBoxTextInserted, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = inputBoxTextInserted.text;
            }
            return inputBoxTextInserted.copy(str);
        }

        public final String component1() {
            return this.text;
        }

        public final InputBoxTextInserted copy(String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            return new InputBoxTextInserted(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InputBoxTextInserted) && Intrinsics.areEqual(this.text, ((InputBoxTextInserted) obj).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "InputBoxTextInserted(text=" + this.text + ")";
        }

        public InputBoxTextInserted(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$InputBoxBackspacePressed;", "Lkntr/app/im/chat/core/model/ChatAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class InputBoxBackspacePressed implements ChatAction {
        public static final int $stable = 0;
        public static final InputBoxBackspacePressed INSTANCE = new InputBoxBackspacePressed();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InputBoxBackspacePressed) {
                InputBoxBackspacePressed inputBoxBackspacePressed = (InputBoxBackspacePressed) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 275453878;
        }

        public String toString() {
            return "InputBoxBackspacePressed";
        }

        private InputBoxBackspacePressed() {
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$CopyTextIntoClipBoard;", "Lkntr/app/im/chat/core/model/ChatAction;", "text", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CopyTextIntoClipBoard implements ChatAction {
        public static final int $stable = 0;
        private final String text;

        public static /* synthetic */ CopyTextIntoClipBoard copy$default(CopyTextIntoClipBoard copyTextIntoClipBoard, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = copyTextIntoClipBoard.text;
            }
            return copyTextIntoClipBoard.copy(str);
        }

        public final String component1() {
            return this.text;
        }

        public final CopyTextIntoClipBoard copy(String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            return new CopyTextIntoClipBoard(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CopyTextIntoClipBoard) && Intrinsics.areEqual(this.text, ((CopyTextIntoClipBoard) obj).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "CopyTextIntoClipBoard(text=" + this.text + ")";
        }

        public CopyTextIntoClipBoard(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0014J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JL\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b \u0010!J\u0013\u0010\"\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006("}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$InputBoxEmojiInserted;", "Lkntr/app/im/chat/core/model/ChatAction;", ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "url", "isGif", RoomRecommendViewModel.EMPTY_CURSOR, "rawText", "size", "Landroidx/compose/ui/geometry/Size;", "replaceChar", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;JCLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getUrl", "()Z", "getRawText", "getSize-NH-jbRc", "()J", "J", "getReplaceChar", "()C", "component1", "component2", "component3", "component4", "component5", "component5-NH-jbRc", "component6", "copy", "copy-GRGpd60", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;JC)Lkntr/app/im/chat/core/model/ChatAction$InputBoxEmojiInserted;", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class InputBoxEmojiInserted implements ChatAction {
        public static final int $stable = 0;
        private final String id;
        private final boolean isGif;
        private final String rawText;
        private final char replaceChar;
        private final long size;
        private final String url;

        public /* synthetic */ InputBoxEmojiInserted(String str, String str2, boolean z, String str3, long j2, char c, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, z, str3, j2, c);
        }

        /* renamed from: copy-GRGpd60$default  reason: not valid java name */
        public static /* synthetic */ InputBoxEmojiInserted m1347copyGRGpd60$default(InputBoxEmojiInserted inputBoxEmojiInserted, String str, String str2, boolean z, String str3, long j2, char c, int i, Object obj) {
            if ((i & 1) != 0) {
                str = inputBoxEmojiInserted.id;
            }
            if ((i & 2) != 0) {
                str2 = inputBoxEmojiInserted.url;
            }
            String str4 = str2;
            if ((i & 4) != 0) {
                z = inputBoxEmojiInserted.isGif;
            }
            boolean z2 = z;
            if ((i & 8) != 0) {
                str3 = inputBoxEmojiInserted.rawText;
            }
            String str5 = str3;
            if ((i & 16) != 0) {
                j2 = inputBoxEmojiInserted.size;
            }
            long j3 = j2;
            if ((i & 32) != 0) {
                c = inputBoxEmojiInserted.replaceChar;
            }
            return inputBoxEmojiInserted.m1349copyGRGpd60(str, str4, z2, str5, j3, c);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.url;
        }

        public final boolean component3() {
            return this.isGif;
        }

        public final String component4() {
            return this.rawText;
        }

        /* renamed from: component5-NH-jbRc  reason: not valid java name */
        public final long m1348component5NHjbRc() {
            return this.size;
        }

        public final char component6() {
            return this.replaceChar;
        }

        /* renamed from: copy-GRGpd60  reason: not valid java name */
        public final InputBoxEmojiInserted m1349copyGRGpd60(String str, String str2, boolean z, String str3, long j2, char c) {
            Intrinsics.checkNotNullParameter(str, ReportBuildInParam.ID);
            Intrinsics.checkNotNullParameter(str2, "url");
            Intrinsics.checkNotNullParameter(str3, "rawText");
            return new InputBoxEmojiInserted(str, str2, z, str3, j2, c, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InputBoxEmojiInserted) {
                InputBoxEmojiInserted inputBoxEmojiInserted = (InputBoxEmojiInserted) obj;
                return Intrinsics.areEqual(this.id, inputBoxEmojiInserted.id) && Intrinsics.areEqual(this.url, inputBoxEmojiInserted.url) && this.isGif == inputBoxEmojiInserted.isGif && Intrinsics.areEqual(this.rawText, inputBoxEmojiInserted.rawText) && Size.equals-impl0(this.size, inputBoxEmojiInserted.size) && this.replaceChar == inputBoxEmojiInserted.replaceChar;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((this.id.hashCode() * 31) + this.url.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isGif)) * 31) + this.rawText.hashCode()) * 31) + Size.hashCode-impl(this.size)) * 31) + this.replaceChar;
        }

        public String toString() {
            String str = this.id;
            String str2 = this.url;
            boolean z = this.isGif;
            String str3 = this.rawText;
            String str4 = Size.toString-impl(this.size);
            return "InputBoxEmojiInserted(id=" + str + ", url=" + str2 + ", isGif=" + z + ", rawText=" + str3 + ", size=" + str4 + ", replaceChar=" + this.replaceChar + ")";
        }

        private InputBoxEmojiInserted(String id, String url, boolean isGif, String rawText, long size, char replaceChar) {
            Intrinsics.checkNotNullParameter(id, ReportBuildInParam.ID);
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(rawText, "rawText");
            this.id = id;
            this.url = url;
            this.isGif = isGif;
            this.rawText = rawText;
            this.size = size;
            this.replaceChar = replaceChar;
        }

        public final String getId() {
            return this.id;
        }

        public final String getUrl() {
            return this.url;
        }

        public final boolean isGif() {
            return this.isGif;
        }

        public final String getRawText() {
            return this.rawText;
        }

        /* renamed from: getSize-NH-jbRc  reason: not valid java name */
        public final long m1350getSizeNHjbRc() {
            return this.size;
        }

        public final char getReplaceChar() {
            return this.replaceChar;
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$SwitchBottomSheetPanel;", "Lkntr/app/im/chat/core/model/ChatAction;", "state", "Lkntr/app/im/chat/core/model/InputBoxSelectState;", "<init>", "(Lkntr/app/im/chat/core/model/InputBoxSelectState;)V", "getState", "()Lkntr/app/im/chat/core/model/InputBoxSelectState;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SwitchBottomSheetPanel implements ChatAction {
        public static final int $stable = 0;
        private final InputBoxSelectState state;

        public static /* synthetic */ SwitchBottomSheetPanel copy$default(SwitchBottomSheetPanel switchBottomSheetPanel, InputBoxSelectState inputBoxSelectState, int i, Object obj) {
            if ((i & 1) != 0) {
                inputBoxSelectState = switchBottomSheetPanel.state;
            }
            return switchBottomSheetPanel.copy(inputBoxSelectState);
        }

        public final InputBoxSelectState component1() {
            return this.state;
        }

        public final SwitchBottomSheetPanel copy(InputBoxSelectState inputBoxSelectState) {
            Intrinsics.checkNotNullParameter(inputBoxSelectState, "state");
            return new SwitchBottomSheetPanel(inputBoxSelectState);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SwitchBottomSheetPanel) && Intrinsics.areEqual(this.state, ((SwitchBottomSheetPanel) obj).state);
        }

        public int hashCode() {
            return this.state.hashCode();
        }

        public String toString() {
            return "SwitchBottomSheetPanel(state=" + this.state + ")";
        }

        public SwitchBottomSheetPanel(InputBoxSelectState state) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }

        public final InputBoxSelectState getState() {
            return this.state;
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$SwitchBottomSheetToGallery;", "Lkntr/app/im/chat/core/model/ChatAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SwitchBottomSheetToGallery implements ChatAction {
        public static final int $stable = 0;
        public static final SwitchBottomSheetToGallery INSTANCE = new SwitchBottomSheetToGallery();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SwitchBottomSheetToGallery) {
                SwitchBottomSheetToGallery switchBottomSheetToGallery = (SwitchBottomSheetToGallery) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -2123752727;
        }

        public String toString() {
            return "SwitchBottomSheetToGallery";
        }

        private SwitchBottomSheetToGallery() {
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$SendMessage;", "Lkntr/app/im/chat/core/model/ChatAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SendMessage implements ChatAction {
        public static final int $stable = 0;
        public static final SendMessage INSTANCE = new SendMessage();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SendMessage) {
                SendMessage sendMessage = (SendMessage) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1255599923;
        }

        public String toString() {
            return "SendMessage";
        }

        private SendMessage() {
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$ResendMessage;", "Lkntr/app/im/chat/core/model/ChatAction;", "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "<init>", "(Lkntr/app/im/chat/core/model/EntityMessage;)V", "getMessage", "()Lkntr/app/im/chat/core/model/EntityMessage;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ResendMessage implements ChatAction {
        public static final int $stable = 0;
        private final EntityMessage message;

        public static /* synthetic */ ResendMessage copy$default(ResendMessage resendMessage, EntityMessage entityMessage, int i, Object obj) {
            if ((i & 1) != 0) {
                entityMessage = resendMessage.message;
            }
            return resendMessage.copy(entityMessage);
        }

        public final EntityMessage component1() {
            return this.message;
        }

        public final ResendMessage copy(EntityMessage entityMessage) {
            Intrinsics.checkNotNullParameter(entityMessage, "message");
            return new ResendMessage(entityMessage);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ResendMessage) && Intrinsics.areEqual(this.message, ((ResendMessage) obj).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "ResendMessage(message=" + this.message + ")";
        }

        public ResendMessage(EntityMessage message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final EntityMessage getMessage() {
            return this.message;
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$DeleteMessage;", "Lkntr/app/im/chat/core/model/ChatAction;", "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "<init>", "(Lkntr/app/im/chat/core/model/EntityMessage;)V", "getMessage", "()Lkntr/app/im/chat/core/model/EntityMessage;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DeleteMessage implements ChatAction {
        public static final int $stable = 0;
        private final EntityMessage message;

        public static /* synthetic */ DeleteMessage copy$default(DeleteMessage deleteMessage, EntityMessage entityMessage, int i, Object obj) {
            if ((i & 1) != 0) {
                entityMessage = deleteMessage.message;
            }
            return deleteMessage.copy(entityMessage);
        }

        public final EntityMessage component1() {
            return this.message;
        }

        public final DeleteMessage copy(EntityMessage entityMessage) {
            Intrinsics.checkNotNullParameter(entityMessage, "message");
            return new DeleteMessage(entityMessage);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeleteMessage) && Intrinsics.areEqual(this.message, ((DeleteMessage) obj).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "DeleteMessage(message=" + this.message + ")";
        }

        public DeleteMessage(EntityMessage message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final EntityMessage getMessage() {
            return this.message;
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$DeleteMessageConfirm;", "Lkntr/app/im/chat/core/model/ChatAction;", "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "<init>", "(Lkntr/app/im/chat/core/model/EntityMessage;)V", "getMessage", "()Lkntr/app/im/chat/core/model/EntityMessage;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DeleteMessageConfirm implements ChatAction {
        public static final int $stable = 0;
        private final EntityMessage message;

        public static /* synthetic */ DeleteMessageConfirm copy$default(DeleteMessageConfirm deleteMessageConfirm, EntityMessage entityMessage, int i, Object obj) {
            if ((i & 1) != 0) {
                entityMessage = deleteMessageConfirm.message;
            }
            return deleteMessageConfirm.copy(entityMessage);
        }

        public final EntityMessage component1() {
            return this.message;
        }

        public final DeleteMessageConfirm copy(EntityMessage entityMessage) {
            Intrinsics.checkNotNullParameter(entityMessage, "message");
            return new DeleteMessageConfirm(entityMessage);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeleteMessageConfirm) && Intrinsics.areEqual(this.message, ((DeleteMessageConfirm) obj).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "DeleteMessageConfirm(message=" + this.message + ")";
        }

        public DeleteMessageConfirm(EntityMessage message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final EntityMessage getMessage() {
            return this.message;
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$DeleteMessageCancel;", "Lkntr/app/im/chat/core/model/ChatAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DeleteMessageCancel implements ChatAction {
        public static final int $stable = 0;
        public static final DeleteMessageCancel INSTANCE = new DeleteMessageCancel();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DeleteMessageCancel) {
                DeleteMessageCancel deleteMessageCancel = (DeleteMessageCancel) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1261253860;
        }

        public String toString() {
            return "DeleteMessageCancel";
        }

        private DeleteMessageCancel() {
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$RecallMessage;", "Lkntr/app/im/chat/core/model/ChatAction;", "msgId", "Lkntr/app/im/chat/core/model/MessageId;", "<init>", "(Lkntr/app/im/chat/core/model/MessageId;)V", "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "(Lkntr/app/im/chat/core/model/EntityMessage;)V", "getMsgId", "()Lkntr/app/im/chat/core/model/MessageId;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class RecallMessage implements ChatAction {
        public static final int $stable = 0;
        private final MessageId msgId;

        public static /* synthetic */ RecallMessage copy$default(RecallMessage recallMessage, MessageId messageId, int i, Object obj) {
            if ((i & 1) != 0) {
                messageId = recallMessage.msgId;
            }
            return recallMessage.copy(messageId);
        }

        public final MessageId component1() {
            return this.msgId;
        }

        public final RecallMessage copy(MessageId messageId) {
            Intrinsics.checkNotNullParameter(messageId, "msgId");
            return new RecallMessage(messageId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RecallMessage) && Intrinsics.areEqual(this.msgId, ((RecallMessage) obj).msgId);
        }

        public int hashCode() {
            return this.msgId.hashCode();
        }

        public String toString() {
            return "RecallMessage(msgId=" + this.msgId + ")";
        }

        public RecallMessage(MessageId msgId) {
            Intrinsics.checkNotNullParameter(msgId, "msgId");
            this.msgId = msgId;
        }

        public final MessageId getMsgId() {
            return this.msgId;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public RecallMessage(EntityMessage message) {
            this(message.getMsgId());
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$RecallMessageWithSeq;", "Lkntr/app/im/chat/core/model/ChatAction;", "msgKey", RoomRecommendViewModel.EMPTY_CURSOR, "msgSeq", "<init>", "(JJ)V", "getMsgKey", "()J", "getMsgSeq", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class RecallMessageWithSeq implements ChatAction {
        public static final int $stable = 0;
        private final long msgKey;
        private final long msgSeq;

        public static /* synthetic */ RecallMessageWithSeq copy$default(RecallMessageWithSeq recallMessageWithSeq, long j2, long j3, int i, Object obj) {
            if ((i & 1) != 0) {
                j2 = recallMessageWithSeq.msgKey;
            }
            if ((i & 2) != 0) {
                j3 = recallMessageWithSeq.msgSeq;
            }
            return recallMessageWithSeq.copy(j2, j3);
        }

        public final long component1() {
            return this.msgKey;
        }

        public final long component2() {
            return this.msgSeq;
        }

        public final RecallMessageWithSeq copy(long j2, long j3) {
            return new RecallMessageWithSeq(j2, j3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RecallMessageWithSeq) {
                RecallMessageWithSeq recallMessageWithSeq = (RecallMessageWithSeq) obj;
                return this.msgKey == recallMessageWithSeq.msgKey && this.msgSeq == recallMessageWithSeq.msgSeq;
            }
            return false;
        }

        public int hashCode() {
            return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.msgKey) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.msgSeq);
        }

        public String toString() {
            long j2 = this.msgKey;
            return "RecallMessageWithSeq(msgKey=" + j2 + ", msgSeq=" + this.msgSeq + ")";
        }

        public RecallMessageWithSeq(long msgKey, long msgSeq) {
            this.msgKey = msgKey;
            this.msgSeq = msgSeq;
        }

        public final long getMsgKey() {
            return this.msgKey;
        }

        public final long getMsgSeq() {
            return this.msgSeq;
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$SaveSticker;", "Lkntr/app/im/chat/core/model/ChatAction;", "picture", "Lcom/bapis/bilibili/app/im/v1/KPictureModule;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KPictureModule;)V", "getPicture", "()Lcom/bapis/bilibili/app/im/v1/KPictureModule;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SaveSticker implements ChatAction {
        public static final int $stable = 0;
        private final KPictureModule picture;

        public static /* synthetic */ SaveSticker copy$default(SaveSticker saveSticker, KPictureModule kPictureModule, int i, Object obj) {
            if ((i & 1) != 0) {
                kPictureModule = saveSticker.picture;
            }
            return saveSticker.copy(kPictureModule);
        }

        public final KPictureModule component1() {
            return this.picture;
        }

        public final SaveSticker copy(KPictureModule kPictureModule) {
            return new SaveSticker(kPictureModule);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SaveSticker) && Intrinsics.areEqual(this.picture, ((SaveSticker) obj).picture);
        }

        public int hashCode() {
            if (this.picture == null) {
                return 0;
            }
            return this.picture.hashCode();
        }

        public String toString() {
            return "SaveSticker(picture=" + this.picture + ")";
        }

        public SaveSticker(KPictureModule picture) {
            this.picture = picture;
        }

        public final KPictureModule getPicture() {
            return this.picture;
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$SendSingleAsset;", "Lkntr/app/im/chat/core/model/ChatAction;", "sticker", "Lkntr/common/photonic/Asset;", "fromCamera", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/common/photonic/Asset;Z)V", "getSticker", "()Lkntr/common/photonic/Asset;", "getFromCamera", "()Z", "component1", "component2", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SendSingleAsset implements ChatAction {
        public static final int $stable = 0;
        private final boolean fromCamera;
        private final Asset sticker;

        public static /* synthetic */ SendSingleAsset copy$default(SendSingleAsset sendSingleAsset, Asset asset, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                asset = sendSingleAsset.sticker;
            }
            if ((i & 2) != 0) {
                z = sendSingleAsset.fromCamera;
            }
            return sendSingleAsset.copy(asset, z);
        }

        public final Asset component1() {
            return this.sticker;
        }

        public final boolean component2() {
            return this.fromCamera;
        }

        public final SendSingleAsset copy(Asset asset, boolean z) {
            Intrinsics.checkNotNullParameter(asset, "sticker");
            return new SendSingleAsset(asset, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SendSingleAsset) {
                SendSingleAsset sendSingleAsset = (SendSingleAsset) obj;
                return Intrinsics.areEqual(this.sticker, sendSingleAsset.sticker) && this.fromCamera == sendSingleAsset.fromCamera;
            }
            return false;
        }

        public int hashCode() {
            return (this.sticker.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.fromCamera);
        }

        public String toString() {
            Asset asset = this.sticker;
            return "SendSingleAsset(sticker=" + asset + ", fromCamera=" + this.fromCamera + ")";
        }

        public SendSingleAsset(Asset sticker, boolean fromCamera) {
            Intrinsics.checkNotNullParameter(sticker, "sticker");
            this.sticker = sticker;
            this.fromCamera = fromCamera;
        }

        public final Asset getSticker() {
            return this.sticker;
        }

        public final boolean getFromCamera() {
            return this.fromCamera;
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$ShowStickerEditPage;", "Lkntr/app/im/chat/core/model/ChatAction;", "isShow", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ShowStickerEditPage implements ChatAction {
        public static final int $stable = 0;
        private final boolean isShow;

        public static /* synthetic */ ShowStickerEditPage copy$default(ShowStickerEditPage showStickerEditPage, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = showStickerEditPage.isShow;
            }
            return showStickerEditPage.copy(z);
        }

        public final boolean component1() {
            return this.isShow;
        }

        public final ShowStickerEditPage copy(boolean z) {
            return new ShowStickerEditPage(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowStickerEditPage) && this.isShow == ((ShowStickerEditPage) obj).isShow;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isShow);
        }

        public String toString() {
            return "ShowStickerEditPage(isShow=" + this.isShow + ")";
        }

        public ShowStickerEditPage(boolean isShow) {
            this.isShow = isShow;
        }

        public final boolean isShow() {
            return this.isShow;
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$ImagePreviewClicked;", "Lkntr/app/im/chat/core/model/ChatAction;", "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "index", RoomRecommendViewModel.EMPTY_CURSOR, "frameInWindow", "Landroidx/compose/ui/unit/IntRect;", "imageSource", "Lkntr/base/imageloader/ImageSource;", "<init>", "(Lkntr/app/im/chat/core/model/EntityMessage;ILandroidx/compose/ui/unit/IntRect;Lkntr/base/imageloader/ImageSource;)V", "getMessage", "()Lkntr/app/im/chat/core/model/EntityMessage;", "getIndex", "()I", "getFrameInWindow", "()Landroidx/compose/ui/unit/IntRect;", "getImageSource", "()Lkntr/base/imageloader/ImageSource;", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ImagePreviewClicked implements ChatAction {
        public static final int $stable = 0;
        private final IntRect frameInWindow;
        private final ImageSource imageSource;
        private final int index;
        private final EntityMessage message;

        public static /* synthetic */ ImagePreviewClicked copy$default(ImagePreviewClicked imagePreviewClicked, EntityMessage entityMessage, int i, IntRect intRect, ImageSource imageSource, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                entityMessage = imagePreviewClicked.message;
            }
            if ((i2 & 2) != 0) {
                i = imagePreviewClicked.index;
            }
            if ((i2 & 4) != 0) {
                intRect = imagePreviewClicked.frameInWindow;
            }
            if ((i2 & 8) != 0) {
                imageSource = imagePreviewClicked.imageSource;
            }
            return imagePreviewClicked.copy(entityMessage, i, intRect, imageSource);
        }

        public final EntityMessage component1() {
            return this.message;
        }

        public final int component2() {
            return this.index;
        }

        public final IntRect component3() {
            return this.frameInWindow;
        }

        public final ImageSource component4() {
            return this.imageSource;
        }

        public final ImagePreviewClicked copy(EntityMessage entityMessage, int i, IntRect intRect, ImageSource imageSource) {
            Intrinsics.checkNotNullParameter(entityMessage, "message");
            return new ImagePreviewClicked(entityMessage, i, intRect, imageSource);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ImagePreviewClicked) {
                ImagePreviewClicked imagePreviewClicked = (ImagePreviewClicked) obj;
                return Intrinsics.areEqual(this.message, imagePreviewClicked.message) && this.index == imagePreviewClicked.index && Intrinsics.areEqual(this.frameInWindow, imagePreviewClicked.frameInWindow) && Intrinsics.areEqual(this.imageSource, imagePreviewClicked.imageSource);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.message.hashCode() * 31) + this.index) * 31) + (this.frameInWindow == null ? 0 : this.frameInWindow.hashCode())) * 31) + (this.imageSource != null ? this.imageSource.hashCode() : 0);
        }

        public String toString() {
            EntityMessage entityMessage = this.message;
            int i = this.index;
            IntRect intRect = this.frameInWindow;
            return "ImagePreviewClicked(message=" + entityMessage + ", index=" + i + ", frameInWindow=" + intRect + ", imageSource=" + this.imageSource + ")";
        }

        public ImagePreviewClicked(EntityMessage message, int index, IntRect frameInWindow, ImageSource imageSource) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
            this.index = index;
            this.frameInWindow = frameInWindow;
            this.imageSource = imageSource;
        }

        public final EntityMessage getMessage() {
            return this.message;
        }

        public final int getIndex() {
            return this.index;
        }

        public final IntRect getFrameInWindow() {
            return this.frameInWindow;
        }

        public final ImageSource getImageSource() {
            return this.imageSource;
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$BottomSheetImagePreviewClicked;", "Lkntr/app/im/chat/core/model/ChatAction;", "dataSource", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/common/photonic/aphro/ui/preview/model/PreviewableAsset;", "index", RoomRecommendViewModel.EMPTY_CURSOR, "albumId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/util/List;ILjava/lang/String;)V", "getDataSource", "()Ljava/util/List;", "getIndex", "()I", "getAlbumId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class BottomSheetImagePreviewClicked implements ChatAction {
        public static final int $stable = 0;
        private final String albumId;
        private final List<PreviewableAsset> dataSource;
        private final int index;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BottomSheetImagePreviewClicked copy$default(BottomSheetImagePreviewClicked bottomSheetImagePreviewClicked, List list, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = bottomSheetImagePreviewClicked.dataSource;
            }
            if ((i2 & 2) != 0) {
                i = bottomSheetImagePreviewClicked.index;
            }
            if ((i2 & 4) != 0) {
                str = bottomSheetImagePreviewClicked.albumId;
            }
            return bottomSheetImagePreviewClicked.copy(list, i, str);
        }

        public final List<PreviewableAsset> component1() {
            return this.dataSource;
        }

        public final int component2() {
            return this.index;
        }

        public final String component3() {
            return this.albumId;
        }

        public final BottomSheetImagePreviewClicked copy(List<? extends PreviewableAsset> list, int i, String str) {
            Intrinsics.checkNotNullParameter(list, "dataSource");
            return new BottomSheetImagePreviewClicked(list, i, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BottomSheetImagePreviewClicked) {
                BottomSheetImagePreviewClicked bottomSheetImagePreviewClicked = (BottomSheetImagePreviewClicked) obj;
                return Intrinsics.areEqual(this.dataSource, bottomSheetImagePreviewClicked.dataSource) && this.index == bottomSheetImagePreviewClicked.index && Intrinsics.areEqual(this.albumId, bottomSheetImagePreviewClicked.albumId);
            }
            return false;
        }

        public int hashCode() {
            return (((this.dataSource.hashCode() * 31) + this.index) * 31) + (this.albumId == null ? 0 : this.albumId.hashCode());
        }

        public String toString() {
            List<PreviewableAsset> list = this.dataSource;
            int i = this.index;
            return "BottomSheetImagePreviewClicked(dataSource=" + list + ", index=" + i + ", albumId=" + this.albumId + ")";
        }

        public BottomSheetImagePreviewClicked(List<? extends PreviewableAsset> list, int index, String albumId) {
            Intrinsics.checkNotNullParameter(list, "dataSource");
            this.dataSource = list;
            this.index = index;
            this.albumId = albumId;
        }

        public /* synthetic */ BottomSheetImagePreviewClicked(List list, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, i, (i2 & 4) != 0 ? null : str);
        }

        public final List<PreviewableAsset> getDataSource() {
            return this.dataSource;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getAlbumId() {
            return this.albumId;
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$ImagePreviewClosed;", "Lkntr/app/im/chat/core/model/ChatAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ImagePreviewClosed implements ChatAction {
        public static final int $stable = 0;
        public static final ImagePreviewClosed INSTANCE = new ImagePreviewClosed();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ImagePreviewClosed) {
                ImagePreviewClosed imagePreviewClosed = (ImagePreviewClosed) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1065575563;
        }

        public String toString() {
            return "ImagePreviewClosed";
        }

        private ImagePreviewClosed() {
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$ShortcutClick;", "Lkntr/app/im/chat/core/model/ChatAction;", "shortcutType", "Lcom/bapis/bilibili/app/im/v1/KShortcutType;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KShortcutType;)V", "getShortcutType", "()Lcom/bapis/bilibili/app/im/v1/KShortcutType;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ShortcutClick implements ChatAction {
        public static final int $stable = 0;
        private final KShortcutType shortcutType;

        public static /* synthetic */ ShortcutClick copy$default(ShortcutClick shortcutClick, KShortcutType kShortcutType, int i, Object obj) {
            if ((i & 1) != 0) {
                kShortcutType = shortcutClick.shortcutType;
            }
            return shortcutClick.copy(kShortcutType);
        }

        public final KShortcutType component1() {
            return this.shortcutType;
        }

        public final ShortcutClick copy(KShortcutType kShortcutType) {
            Intrinsics.checkNotNullParameter(kShortcutType, "shortcutType");
            return new ShortcutClick(kShortcutType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShortcutClick) && Intrinsics.areEqual(this.shortcutType, ((ShortcutClick) obj).shortcutType);
        }

        public int hashCode() {
            return this.shortcutType.hashCode();
        }

        public String toString() {
            return "ShortcutClick(shortcutType=" + this.shortcutType + ")";
        }

        public ShortcutClick(KShortcutType shortcutType) {
            Intrinsics.checkNotNullParameter(shortcutType, "shortcutType");
            this.shortcutType = shortcutType;
        }

        public final KShortcutType getShortcutType() {
            return this.shortcutType;
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$NotifyCosmosOp;", "Lkntr/app/im/chat/core/model/ChatAction;", "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "item", "Lcom/bapis/bilibili/app/im/v1/KNotifyCosmoThreeDotItem;", "<init>", "(Lkntr/app/im/chat/core/model/EntityMessage;Lcom/bapis/bilibili/app/im/v1/KNotifyCosmoThreeDotItem;)V", "getMessage", "()Lkntr/app/im/chat/core/model/EntityMessage;", "getItem", "()Lcom/bapis/bilibili/app/im/v1/KNotifyCosmoThreeDotItem;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class NotifyCosmosOp implements ChatAction {
        public static final int $stable = 0;
        private final KNotifyCosmoThreeDotItem item;
        private final EntityMessage message;

        public static /* synthetic */ NotifyCosmosOp copy$default(NotifyCosmosOp notifyCosmosOp, EntityMessage entityMessage, KNotifyCosmoThreeDotItem kNotifyCosmoThreeDotItem, int i, Object obj) {
            if ((i & 1) != 0) {
                entityMessage = notifyCosmosOp.message;
            }
            if ((i & 2) != 0) {
                kNotifyCosmoThreeDotItem = notifyCosmosOp.item;
            }
            return notifyCosmosOp.copy(entityMessage, kNotifyCosmoThreeDotItem);
        }

        public final EntityMessage component1() {
            return this.message;
        }

        public final KNotifyCosmoThreeDotItem component2() {
            return this.item;
        }

        public final NotifyCosmosOp copy(EntityMessage entityMessage, KNotifyCosmoThreeDotItem kNotifyCosmoThreeDotItem) {
            Intrinsics.checkNotNullParameter(entityMessage, "message");
            Intrinsics.checkNotNullParameter(kNotifyCosmoThreeDotItem, "item");
            return new NotifyCosmosOp(entityMessage, kNotifyCosmoThreeDotItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NotifyCosmosOp) {
                NotifyCosmosOp notifyCosmosOp = (NotifyCosmosOp) obj;
                return Intrinsics.areEqual(this.message, notifyCosmosOp.message) && Intrinsics.areEqual(this.item, notifyCosmosOp.item);
            }
            return false;
        }

        public int hashCode() {
            return (this.message.hashCode() * 31) + this.item.hashCode();
        }

        public String toString() {
            EntityMessage entityMessage = this.message;
            return "NotifyCosmosOp(message=" + entityMessage + ", item=" + this.item + ")";
        }

        public NotifyCosmosOp(EntityMessage message, KNotifyCosmoThreeDotItem item) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(item, "item");
            this.message = message;
            this.item = item;
        }

        public final EntityMessage getMessage() {
            return this.message;
        }

        public final KNotifyCosmoThreeDotItem getItem() {
            return this.item;
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$DismissUpgradeAnswerDialog;", "Lkntr/app/im/chat/core/model/ChatAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DismissUpgradeAnswerDialog implements ChatAction {
        public static final int $stable = 0;
        public static final DismissUpgradeAnswerDialog INSTANCE = new DismissUpgradeAnswerDialog();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DismissUpgradeAnswerDialog) {
                DismissUpgradeAnswerDialog dismissUpgradeAnswerDialog = (DismissUpgradeAnswerDialog) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1305816886;
        }

        public String toString() {
            return "DismissUpgradeAnswerDialog";
        }

        private DismissUpgradeAnswerDialog() {
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$ReportMessage;", "Lkntr/app/im/chat/core/model/ChatAction;", "ofMessage", "Lkntr/app/im/chat/core/model/MessageId;", "baseUrl", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/im/chat/core/model/MessageId;Ljava/lang/String;)V", "getOfMessage", "()Lkntr/app/im/chat/core/model/MessageId;", "getBaseUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ReportMessage implements ChatAction {
        public static final int $stable = 0;
        private final String baseUrl;
        private final MessageId ofMessage;

        public static /* synthetic */ ReportMessage copy$default(ReportMessage reportMessage, MessageId messageId, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                messageId = reportMessage.ofMessage;
            }
            if ((i & 2) != 0) {
                str = reportMessage.baseUrl;
            }
            return reportMessage.copy(messageId, str);
        }

        public final MessageId component1() {
            return this.ofMessage;
        }

        public final String component2() {
            return this.baseUrl;
        }

        public final ReportMessage copy(MessageId messageId, String str) {
            Intrinsics.checkNotNullParameter(messageId, "ofMessage");
            Intrinsics.checkNotNullParameter(str, "baseUrl");
            return new ReportMessage(messageId, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ReportMessage) {
                ReportMessage reportMessage = (ReportMessage) obj;
                return Intrinsics.areEqual(this.ofMessage, reportMessage.ofMessage) && Intrinsics.areEqual(this.baseUrl, reportMessage.baseUrl);
            }
            return false;
        }

        public int hashCode() {
            return (this.ofMessage.hashCode() * 31) + this.baseUrl.hashCode();
        }

        public String toString() {
            MessageId messageId = this.ofMessage;
            return "ReportMessage(ofMessage=" + messageId + ", baseUrl=" + this.baseUrl + ")";
        }

        public ReportMessage(MessageId ofMessage, String baseUrl) {
            Intrinsics.checkNotNullParameter(ofMessage, "ofMessage");
            Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
            this.ofMessage = ofMessage;
            this.baseUrl = baseUrl;
        }

        public final MessageId getOfMessage() {
            return this.ofMessage;
        }

        public final String getBaseUrl() {
            return this.baseUrl;
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$DismissBehaviorAlert;", "Lkntr/app/im/chat/core/model/ChatAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DismissBehaviorAlert implements ChatAction {
        public static final int $stable = 0;
        public static final DismissBehaviorAlert INSTANCE = new DismissBehaviorAlert();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DismissBehaviorAlert) {
                DismissBehaviorAlert dismissBehaviorAlert = (DismissBehaviorAlert) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 172450322;
        }

        public String toString() {
            return "DismissBehaviorAlert";
        }

        private DismissBehaviorAlert() {
        }
    }

    /* compiled from: ChatAction.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/im/chat/core/model/ChatAction$ShowPhaseTwoPushMessage;", "Lkntr/app/im/chat/core/model/ChatAction;", "messageSequence", "Lkntr/app/im/chat/core/model/MessageSequence;", "relatedTimeStamp", "Lkotlinx/datetime/Instant;", "<init>", "(Lkntr/app/im/chat/core/model/MessageSequence;Lkotlinx/datetime/Instant;)V", "getMessageSequence", "()Lkntr/app/im/chat/core/model/MessageSequence;", "getRelatedTimeStamp", "()Lkotlinx/datetime/Instant;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ShowPhaseTwoPushMessage implements ChatAction {
        public static final int $stable = 0;
        private final MessageSequence messageSequence;
        private final Instant relatedTimeStamp;

        public static /* synthetic */ ShowPhaseTwoPushMessage copy$default(ShowPhaseTwoPushMessage showPhaseTwoPushMessage, MessageSequence messageSequence, Instant instant, int i, Object obj) {
            if ((i & 1) != 0) {
                messageSequence = showPhaseTwoPushMessage.messageSequence;
            }
            if ((i & 2) != 0) {
                instant = showPhaseTwoPushMessage.relatedTimeStamp;
            }
            return showPhaseTwoPushMessage.copy(messageSequence, instant);
        }

        public final MessageSequence component1() {
            return this.messageSequence;
        }

        public final Instant component2() {
            return this.relatedTimeStamp;
        }

        public final ShowPhaseTwoPushMessage copy(MessageSequence messageSequence, Instant instant) {
            Intrinsics.checkNotNullParameter(messageSequence, "messageSequence");
            Intrinsics.checkNotNullParameter(instant, "relatedTimeStamp");
            return new ShowPhaseTwoPushMessage(messageSequence, instant);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowPhaseTwoPushMessage) {
                ShowPhaseTwoPushMessage showPhaseTwoPushMessage = (ShowPhaseTwoPushMessage) obj;
                return Intrinsics.areEqual(this.messageSequence, showPhaseTwoPushMessage.messageSequence) && Intrinsics.areEqual(this.relatedTimeStamp, showPhaseTwoPushMessage.relatedTimeStamp);
            }
            return false;
        }

        public int hashCode() {
            return (this.messageSequence.hashCode() * 31) + this.relatedTimeStamp.hashCode();
        }

        public String toString() {
            MessageSequence messageSequence = this.messageSequence;
            return "ShowPhaseTwoPushMessage(messageSequence=" + messageSequence + ", relatedTimeStamp=" + this.relatedTimeStamp + ")";
        }

        public ShowPhaseTwoPushMessage(MessageSequence messageSequence, Instant relatedTimeStamp) {
            Intrinsics.checkNotNullParameter(messageSequence, "messageSequence");
            Intrinsics.checkNotNullParameter(relatedTimeStamp, "relatedTimeStamp");
            this.messageSequence = messageSequence;
            this.relatedTimeStamp = relatedTimeStamp;
        }

        public final MessageSequence getMessageSequence() {
            return this.messageSequence;
        }

        public final Instant getRelatedTimeStamp() {
            return this.relatedTimeStamp;
        }
    }
}