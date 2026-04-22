package kntr.app.im.chat.ui.widget.sticky;

import bili.resource.im.ImRes;
import bili.resource.im.String0_commonMainKt;
import bili.resource.im.String1_commonMainKt;
import com.bapis.bilibili.app.im.v1.KShortcutType;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: Confirmdialog.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B=\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lkntr/app/im/chat/ui/widget/sticky/ConfirmDialogType;", RoomRecommendViewModel.EMPTY_CURSOR, "type", "Lcom/bapis/bilibili/app/im/v1/KShortcutType;", "title", "Lorg/jetbrains/compose/resources/StringResource;", "content", "confirm", "cancel", "action", "Lkntr/app/im/chat/core/model/ChatAction;", "<init>", "(Ljava/lang/String;ILcom/bapis/bilibili/app/im/v1/KShortcutType;Lorg/jetbrains/compose/resources/StringResource;Lorg/jetbrains/compose/resources/StringResource;Lorg/jetbrains/compose/resources/StringResource;Lorg/jetbrains/compose/resources/StringResource;Lkntr/app/im/chat/core/model/ChatAction;)V", "getType", "()Lcom/bapis/bilibili/app/im/v1/KShortcutType;", "getTitle", "()Lorg/jetbrains/compose/resources/StringResource;", "getContent", "getConfirm", "getCancel", "getAction", "()Lkntr/app/im/chat/core/model/ChatAction;", "BlockUser", "DisablePush", "FollowFailed", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum ConfirmDialogType {
    BlockUser(KShortcutType.SHORTCUT_TYPE_BLOCK.INSTANCE, String0_commonMainKt.getIm_global_string_427(ImRes.INSTANCE.getString()), String1_commonMainKt.getIm_global_string_800(ImRes.INSTANCE.getString()), null, null, new ChatAction.ShortcutClick(KShortcutType.SHORTCUT_TYPE_BLOCK.INSTANCE), 24, null),
    DisablePush(KShortcutType.SHORTCUT_TYPE_PUSH_DISABLE.INSTANCE, String0_commonMainKt.getIm_global_string_481(ImRes.INSTANCE.getString()), String0_commonMainKt.getIm_global_string_272(ImRes.INSTANCE.getString()), null, null, new ChatAction.ShortcutClick(KShortcutType.SHORTCUT_TYPE_PUSH_DISABLE.INSTANCE), 24, null),
    FollowFailed(KShortcutType.SHORTCUT_TYPE_FOLLOW.INSTANCE, String0_commonMainKt.getIm_global_string_609(ImRes.INSTANCE.getString()), String0_commonMainKt.getIm_global_string_115(ImRes.INSTANCE.getString()), String0_commonMainKt.getIm_global_string_379(ImRes.INSTANCE.getString()), String0_commonMainKt.getIm_global_string_475(ImRes.INSTANCE.getString()), new ChatAction.RouteTo("https://account.bilibili.com/answer/base"));
    
    private final ChatAction action;
    private final StringResource cancel;
    private final StringResource confirm;
    private final StringResource content;
    private final StringResource title;
    private final KShortcutType type;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<ConfirmDialogType> getEntries() {
        return $ENTRIES;
    }

    ConfirmDialogType(KShortcutType type, StringResource title, StringResource content, StringResource confirm, StringResource cancel, ChatAction action) {
        this.type = type;
        this.title = title;
        this.content = content;
        this.confirm = confirm;
        this.cancel = cancel;
        this.action = action;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    /* synthetic */ ConfirmDialogType(KShortcutType kShortcutType, StringResource stringResource, StringResource stringResource2, StringResource stringResource3, StringResource stringResource4, ChatAction chatAction, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kShortcutType, stringResource, stringResource2, r7, r8, chatAction);
        StringResource stringResource5;
        StringResource stringResource6;
        if ((i & 8) == 0) {
            stringResource5 = stringResource3;
        } else {
            stringResource5 = String0_commonMainKt.getIm_global_string_485(ImRes.INSTANCE.getString());
        }
        if ((i & 16) == 0) {
            stringResource6 = stringResource4;
        } else {
            stringResource6 = String0_commonMainKt.getIm_global_string_414(ImRes.INSTANCE.getString());
        }
    }

    public final KShortcutType getType() {
        return this.type;
    }

    public final StringResource getTitle() {
        return this.title;
    }

    public final StringResource getContent() {
        return this.content;
    }

    public final StringResource getConfirm() {
        return this.confirm;
    }

    public final StringResource getCancel() {
        return this.cancel;
    }

    public final ChatAction getAction() {
        return this.action;
    }
}