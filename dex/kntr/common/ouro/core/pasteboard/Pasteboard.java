package kntr.common.ouro.core.pasteboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import com.bilibili.lib.foundation.FoundationAlias;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;

/* compiled from: Pasteboard.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/common/ouro/core/pasteboard/Pasteboard;", "", "<init>", "()V", "INTENT_KEY", "", "manager", "Landroid/content/ClipboardManager;", "setData", "", "data", "Lkntr/common/ouro/core/pasteboard/PasteboardData;", "getData", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Pasteboard {
    public static final Pasteboard INSTANCE = new Pasteboard();
    private static final String INTENT_KEY = "ouro.editor";
    private static final ClipboardManager manager;

    private Pasteboard() {
    }

    static {
        Object systemService = FoundationAlias.getFapp().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        manager = (ClipboardManager) systemService;
    }

    public final void setData(PasteboardData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ClipData clipData = ClipData.newPlainText("rich_text", data.getText());
        byte[] it = data.getBytes();
        if (it != null) {
            Intent intent = new Intent().putExtra(INTENT_KEY, it);
            Intrinsics.checkNotNullExpressionValue(intent, "putExtra(...)");
            clipData.addItem(new ClipData.Item(intent));
        }
        manager.setPrimaryClip(clipData);
    }

    public final PasteboardData getData() {
        String plainText;
        Bundle extras;
        ClipData clipData = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPrimaryClip(manager);
        byte[] bytes = null;
        if (clipData != null && clipData.getItemCount() > 0) {
            ClipData.Item firstItem = clipData.getItemAt(0);
            CharSequence text = firstItem.getText();
            if (text == null || (plainText = text.toString()) == null) {
                return null;
            }
            if (clipData.getItemCount() > 1) {
                ClipData.Item lastItem = clipData.getItemAt(clipData.getItemCount() - 1);
                Intent intent = lastItem.getIntent();
                if (intent != null && (extras = intent.getExtras()) != null) {
                    bytes = extras.getByteArray(INTENT_KEY);
                }
            }
            return new PasteboardData(plainText, bytes);
        }
        return null;
    }

    @JvmStatic
    private static ClipData __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPrimaryClip(Object obj) {
        ClipData.Item itemAt;
        CharSequence text;
        Intrinsics.checkNotNullParameter(obj, "obj");
        ClipData data = ((ClipboardManager) obj).getPrimaryClip();
        String str = null;
        if (!(data instanceof ClipData)) {
            data = null;
        }
        if (data != null && (itemAt = data.getItemAt(0)) != null && (text = itemAt.getText()) != null) {
            str = text.toString();
        }
        BLog.d("privacy", "getPrimaryClip: clipdata = " + str);
        return data;
    }
}