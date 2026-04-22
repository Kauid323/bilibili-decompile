package kntr.common.photonic.gallery.entity;

import android.net.Uri;
import com.bilibili.lib.foundation.FoundationAlias;
import java.io.InputStream;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.io.Buffer;
import kotlinx.io.CoreKt;
import kotlinx.io.JvmCoreKt;
import kotlinx.io.RawSource;
import kotlinx.io.Source;

/* compiled from: UriUtil.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080@¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"readContent", "Lkotlinx/io/Source;", "Landroid/net/Uri;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gallery_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UriUtilKt {
    public static final Object readContent(Uri $this$readContent, Continuation<? super Source> continuation) {
        RawSource asSource;
        Source buffered;
        InputStream openInputStream = FoundationAlias.getFapp().getContentResolver().openInputStream($this$readContent);
        return (openInputStream == null || (asSource = JvmCoreKt.asSource(openInputStream)) == null || (buffered = CoreKt.buffered(asSource)) == null) ? new Buffer() : buffered;
    }
}