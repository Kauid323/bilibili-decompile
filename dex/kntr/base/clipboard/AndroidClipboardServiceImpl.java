package kntr.base.clipboard;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import androidx.compose.ui.platform.ClipEntry;
import javax.inject.Inject;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;

/* compiled from: Clipboard.android.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lkntr/base/clipboard/AndroidClipboardServiceImpl;", "Lkntr/base/clipboard/ClipboardService;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "clipboardManager", "Landroid/content/ClipboardManager;", "getClipboardManager", "()Landroid/content/ClipboardManager;", "clipboardManager$delegate", "Lkotlin/Lazy;", "writeTextIntoClipBoard", "", "text", "", "readTextFromClipBoard", "generateClipboardEntry", "Landroidx/compose/ui/platform/ClipEntry;", "Companion", "clipboard_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AndroidClipboardServiceImpl implements ClipboardService {
    public static final Companion Companion = new Companion(null);
    private static final String LABEL = "Bili";
    private final Application application;
    private final Lazy clipboardManager$delegate;

    @Inject
    public AndroidClipboardServiceImpl(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this.clipboardManager$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.clipboard.AndroidClipboardServiceImpl$$ExternalSyntheticLambda0
            public final Object invoke() {
                ClipboardManager clipboardManager_delegate$lambda$0;
                clipboardManager_delegate$lambda$0 = AndroidClipboardServiceImpl.clipboardManager_delegate$lambda$0(AndroidClipboardServiceImpl.this);
                return clipboardManager_delegate$lambda$0;
            }
        });
    }

    /* compiled from: Clipboard.android.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/base/clipboard/AndroidClipboardServiceImpl$Companion;", "", "<init>", "()V", "LABEL", "", "clipboard_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final ClipboardManager getClipboardManager() {
        return (ClipboardManager) this.clipboardManager$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClipboardManager clipboardManager_delegate$lambda$0(AndroidClipboardServiceImpl this$0) {
        Object systemService = this$0.application.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        return (ClipboardManager) systemService;
    }

    @Override // kntr.base.clipboard.ClipboardService
    public void writeTextIntoClipBoard(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        getClipboardManager().setPrimaryClip(ClipData.newPlainText(LABEL, text));
    }

    @Override // kntr.base.clipboard.ClipboardService
    public String readTextFromClipBoard() {
        ClipData __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPrimaryClip;
        ClipData.Item itemAt;
        CharSequence coerceToText;
        if (getClipboardManager().hasPrimaryClip()) {
            ClipData __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPrimaryClip2 = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPrimaryClip(getClipboardManager());
            if ((__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPrimaryClip2 != null ? __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPrimaryClip2.getItemCount() : 0) <= 0 || (__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPrimaryClip = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPrimaryClip(getClipboardManager())) == null || (itemAt = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPrimaryClip.getItemAt(0)) == null || (coerceToText = itemAt.coerceToText(this.application)) == null) {
                return null;
            }
            return coerceToText.toString();
        }
        return null;
    }

    @Override // kntr.base.clipboard.ClipboardService
    public ClipEntry generateClipboardEntry(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ClipData newPlainText = ClipData.newPlainText(LABEL, text);
        Intrinsics.checkNotNullExpressionValue(newPlainText, "newPlainText(...)");
        return AndroidClipboardManager_androidKt.toClipEntry(newPlainText);
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