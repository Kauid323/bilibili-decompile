package g;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import faceverify.q;
import java.io.File;

public final class b {
    public static long a(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        }
        return 0L;
    }

    public static String b(Context context, Uri uri) {
        String uri2 = uri.toString();
        return new File(context.getExternalFilesDir(null), uri2.substring(uri2.lastIndexOf("/"))).getAbsolutePath();
    }

    public static boolean c(Context context, Uri uri) {
        String str;
        String str2;
        String a = a(context, uri);
        if (!TextUtils.isEmpty(a)) {
            File file = new File(a);
            File file2 = file.getParent() == null ? file : new File(file.getParentFile().getCanonicalFile(), file.getName());
            if (!file2.getCanonicalFile().equals(file2.getAbsoluteFile())) {
                return false;
            }
            try {
                String absolutePath = file.getAbsolutePath();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(absolutePath, options);
                str2 = options.outMimeType;
            } catch (Exception e2) {
                str = "*/*";
            }
            if (!str2.contains("jpg") && !str2.contains("gif") && !str2.contains("png")) {
                if (!str2.contains("jpeg")) {
                    str = null;
                    return !TextUtils.isEmpty(str) && str.startsWith("image/");
                }
            }
            str = "image/*";
            if (TextUtils.isEmpty(str)) {
                return false;
            }
        }
        throw new IllegalArgumentException("get image path is null");
    }

    public static boolean d(Context context, Uri uri) {
        String str;
        String a = a(context, uri);
        if (!TextUtils.isEmpty(a)) {
            File file = new File(a);
            File file2 = file.getParent() == null ? file : new File(file.getParentFile().getCanonicalFile(), file.getName());
            if (!file2.getCanonicalFile().equals(file2.getAbsoluteFile())) {
                return false;
            }
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(".");
            if (lastIndexOf >= 0) {
                String substring = name.substring(lastIndexOf);
                if (!TextUtils.isEmpty(substring) || substring.length() >= 2) {
                    str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(substring.substring(1).toLowerCase());
                    return !TextUtils.isEmpty(str) && str.startsWith("video/");
                }
            }
            str = "*/*";
            if (TextUtils.isEmpty(str)) {
                return false;
            }
        }
        throw new IllegalArgumentException("get video path is null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0093, code lost:
        if (r1 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009d, code lost:
        if (r1 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009f, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a6, code lost:
        return b(r12, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x010d, code lost:
        if (r1 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0117, code lost:
        if (r1 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0119, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0120, code lost:
        return b(r12, r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, Uri uri) {
        Uri uri2;
        String[] split;
        Cursor cursor = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                if ("primary".equalsIgnoreCase(DocumentsContract.getDocumentId(uri).split(":")[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri withAppendedId = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue());
                try {
                    cursor = context.getContentResolver().query(withAppendedId, new String[]{"_data"}, null, null, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        cursor.close();
                        return string;
                    }
                } catch (Exception e2) {
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } else if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str = split2[0];
                if ("image".equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if (!"audio".equals(str)) {
                    uri2 = null;
                } else {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                try {
                    cursor = context.getContentResolver().query(uri2, new String[]{"_data"}, "_id=?", new String[]{split2[1]}, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        String string2 = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        cursor.close();
                        return string2;
                    }
                } catch (Exception e3) {
                } catch (Throwable th2) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th2;
                }
            }
        } else if (q.KEY_RES_9_CONTENT.equalsIgnoreCase(uri.getScheme())) {
            if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
                return uri.getLastPathSegment();
            }
            return b(context, uri);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }
}