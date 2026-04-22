package tv.danmaku.bili.services.videodownload.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.lib.spy.generated.android_content_ContentProvider;
import com.bilibili.videodownloader.utils.log.LogHelper;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import tv.danmaku.bili.provider.ProviderHelper;

public class VideoDownloadProvider extends android_content_ContentProvider {
    private static final String DOWNLOAD_INFO_MIME_TYPE = "vnd.android.cursor.item/download";
    private static final String NAME = "BA15gaeGB";
    private static final String PATH_AUDIO_COUNT = "audioCount";
    private static final String PATH_TOTAL_COUNT = "count";
    private static final String PATH_VIDEO_COUNT = "videoCount";
    private static final int URI_MATCH_AUDIO_COUNT = 3;
    private static final int URI_MATCH_TOTAL_COUNT = 1;
    private static final int URI_MATCH_VIDEO_COUNT = 2;
    private int[] mCounts = new int[6];
    private UriMatcher mUriMatcher;
    private static final String COLUMN_TOTAL = "total";
    private static final String COLUMN_DOWNLOADING = "downloading";
    private static final String COLUMN_DOWNLOADED = "downloaded";
    private static final String[] COLUMN_NAMES = {COLUMN_TOTAL, COLUMN_DOWNLOADING, COLUMN_DOWNLOADED};

    /* JADX INFO: Access modifiers changed from: private */
    public static String getAuthority(Context context) {
        return context.getPackageName() + ".providers.VideoDownloadProvider";
    }

    private static Uri getTotalCountUrl(Context context) {
        return Uri.parse("content://" + getAuthority(context) + "/" + PATH_TOTAL_COUNT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Uri getVideoCountUrl(Context context) {
        return Uri.parse("content://" + getAuthority(context) + "/" + PATH_VIDEO_COUNT);
    }

    private static Uri getAudioCountUrl(Context context) {
        return Uri.parse("content://" + getAuthority(context) + "/" + PATH_AUDIO_COUNT);
    }

    public boolean onCreate() {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        String authority = getAuthority(context);
        this.mUriMatcher = new UriMatcher(-1);
        this.mUriMatcher.addURI(authority, PATH_TOTAL_COUNT, 1);
        this.mUriMatcher.addURI(authority, PATH_VIDEO_COUNT, 2);
        this.mUriMatcher.addURI(authority, PATH_AUDIO_COUNT, 3);
        FileInputStream input = null;
        try {
            try {
                input = getContext().openFileInput(NAME);
                FileChannel channel = input.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(input.available());
                channel.read(buffer);
                buffer.rewind();
                buffer.asIntBuffer().get(this.mCounts);
                channel.close();
            } catch (Exception e) {
                LogHelper.printStackTrace(e);
            }
            return true;
        } finally {
            IOUtils.closeQuietly(input);
        }
    }

    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int total = 0;
        int downloading = 0;
        int downloaded = 0;
        if (this.mUriMatcher.match(uri) == 1) {
            total = this.mCounts[0] + this.mCounts[3];
            downloading = this.mCounts[1] + this.mCounts[4];
            downloaded = this.mCounts[2] + this.mCounts[5];
        } else if (this.mUriMatcher.match(uri) == 2) {
            total = this.mCounts[0];
            downloading = this.mCounts[1];
            downloaded = this.mCounts[2];
        } else if (this.mUriMatcher.match(uri) == 3) {
            total = this.mCounts[3];
            downloading = this.mCounts[4];
            downloaded = this.mCounts[5];
        }
        MatrixCursor cursor = new MatrixCursor(COLUMN_NAMES, 1);
        cursor.addRow(new Integer[]{Integer.valueOf(total), Integer.valueOf(downloading), Integer.valueOf(downloaded)});
        return cursor;
    }

    public String getType(Uri uri) {
        if (this.mUriMatcher.match(uri) == 1 || this.mUriMatcher.match(uri) == 3 || this.mUriMatcher.match(uri) == 2) {
            return DOWNLOAD_INFO_MIME_TYPE;
        }
        return null;
    }

    public Uri insert(Uri uri, ContentValues values) {
        return uri;
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (this.mUriMatcher.match(uri) == 2) {
            LogHelper.i("@@@", "update count: %s", new Object[]{values});
            this.mCounts[0] = values.getAsInteger(COLUMN_TOTAL).intValue();
            this.mCounts[1] = values.getAsInteger(COLUMN_DOWNLOADING).intValue();
            this.mCounts[2] = values.getAsInteger(COLUMN_DOWNLOADED).intValue();
            saveToDisk();
            notifyDataChanged(getTotalCountUrl(getContext()));
            return 1;
        } else if (this.mUriMatcher.match(uri) == 3) {
            this.mCounts[3] = values.getAsInteger(COLUMN_TOTAL).intValue();
            this.mCounts[4] = values.getAsInteger(COLUMN_DOWNLOADING).intValue();
            this.mCounts[5] = values.getAsInteger(COLUMN_DOWNLOADED).intValue();
            saveToDisk();
            notifyDataChanged(getTotalCountUrl(getContext()));
            return 1;
        } else {
            return 0;
        }
    }

    private void notifyDataChanged(Uri uri) {
        Context context = getContext();
        if (context != null) {
            context.getContentResolver().notifyChange(uri, null);
        }
    }

    public Bundle call(String method, String arg, Bundle extras) {
        if ("onServiceDestroy".equals(method)) {
            saveToDisk();
            return Bundle.EMPTY;
        }
        return super.call(method, arg, extras);
    }

    private void saveToDisk() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        FileOutputStream output = null;
        try {
            try {
                output = context.openFileOutput(NAME, 0);
                FileChannel channel = output.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(this.mCounts.length * 4);
                buffer.asIntBuffer().put(this.mCounts);
                channel.write(buffer);
                channel.close();
            } catch (Exception e) {
                LogHelper.printStackTrace(e);
            }
        } finally {
            IOUtils.closeQuietly(output);
        }
    }

    public static int[] queryDownloadInfo(Context context) {
        return queryCountInfo(context, getTotalCountUrl(context));
    }

    private static int[] queryCountInfo(Context context, Uri uri) {
        Cursor cursor = ProviderHelper.query(context, uri, null, null, null, null);
        int[] counts = new int[3];
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    counts[0] = cursor.getInt(0);
                    counts[1] = cursor.getInt(1);
                    counts[2] = cursor.getInt(2);
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return counts;
    }

    public static void register(Context context, ContentObserver observer) {
        context.getContentResolver().registerContentObserver(getTotalCountUrl(context), true, observer);
    }

    public static void unregister(Context context, ContentObserver observer) {
        context.getContentResolver().unregisterContentObserver(observer);
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Notifier {
        public static void update(Context context, int total, int downloading, int downloaded) {
            ContentValues values = new ContentValues();
            values.put(VideoDownloadProvider.COLUMN_TOTAL, Integer.valueOf(total));
            values.put(VideoDownloadProvider.COLUMN_DOWNLOADING, Integer.valueOf(downloading));
            values.put(VideoDownloadProvider.COLUMN_DOWNLOADED, Integer.valueOf(downloaded));
            ProviderHelper.acquireProviderOp(context, VideoDownloadProvider.getAuthority(context)).update(VideoDownloadProvider.getVideoCountUrl(context), values).release();
        }

        public static void onServiceDestroy(Context context) {
            ProviderHelper.call(context, VideoDownloadProvider.getVideoCountUrl(context), "onServiceDestroy", null, null);
        }
    }
}