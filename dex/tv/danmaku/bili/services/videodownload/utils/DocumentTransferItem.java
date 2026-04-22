package tv.danmaku.bili.services.videodownload.utils;

import android.net.Uri;
import com.bilibili.videodownloader.utils.Jsonable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.loginv2.LoginActivityV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DocumentTransfer.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/services/videodownload/utils/DocumentTransferItem;", "", "cacheRoot", "Landroid/net/Uri;", "multiPUri", LoginActivityV2.LOGIN_ENTRY_KEY, "Lcom/bilibili/videodownloader/utils/Jsonable;", "<init>", "(Landroid/net/Uri;Landroid/net/Uri;Lcom/bilibili/videodownloader/utils/Jsonable;)V", "getCacheRoot", "()Landroid/net/Uri;", "getMultiPUri", "getEntry", "()Lcom/bilibili/videodownloader/utils/Jsonable;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DocumentTransferItem {
    private final Uri cacheRoot;
    private final Jsonable entry;
    private final Uri multiPUri;

    public DocumentTransferItem(Uri cacheRoot, Uri multiPUri, Jsonable entry) {
        Intrinsics.checkNotNullParameter(cacheRoot, "cacheRoot");
        Intrinsics.checkNotNullParameter(multiPUri, "multiPUri");
        Intrinsics.checkNotNullParameter(entry, LoginActivityV2.LOGIN_ENTRY_KEY);
        this.cacheRoot = cacheRoot;
        this.multiPUri = multiPUri;
        this.entry = entry;
    }

    public final Uri getCacheRoot() {
        return this.cacheRoot;
    }

    public final Jsonable getEntry() {
        return this.entry;
    }

    public final Uri getMultiPUri() {
        return this.multiPUri;
    }
}