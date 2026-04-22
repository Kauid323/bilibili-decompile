package kntr.common.photonic.aphro.ui.preview.save;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import java.io.File;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.MimeType;
import kotlin.Metadata;

/* compiled from: SaveImageManager.android.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"createImageUri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "mimeType", "Lkntr/common/photonic/MimeType;", "extensionName", "", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SaveImageManager_androidKt {
    public static final /* synthetic */ Uri access$createImageUri(Context context, MimeType mimeType, String extensionName) {
        return createImageUri(context, mimeType, extensionName);
    }

    public static final Uri createImageUri(Context context, MimeType mimeType, String extensionName) {
        ContentValues contentValues = new ContentValues();
        String fileName = "IMG_" + System.currentTimeMillis() + "." + extensionName;
        contentValues.put("_display_name", fileName);
        contentValues.put("mime_type", mimeType.toString());
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + "/bili");
        } else {
            File picturesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File imageFile = new File(picturesDir, "bili/" + fileName);
            File parentFile = imageFile.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            contentValues.put("_data", imageFile.getAbsolutePath());
        }
        return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }
}