package tv.danmaku.bili.ui.garb;

import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.ogv.infra.tempfile.TempFileManager;
import java.io.File;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: SmeltVideoController.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002"}, d2 = {"tempFileManager", "Lcom/bilibili/ogv/infra/tempfile/TempFileManager;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SmeltVideoControllerKt {
    private static final TempFileManager tempFileManager = new TempFileManager(new File(FoundationAlias.getFapp().getCacheDir(), "digital/smelt/video"), 314572800);
}