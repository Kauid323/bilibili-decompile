package tv.danmaku.bili.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.oaid.MsaHelper;
import com.bilibili.lib.spy.generated.android_content_ContentProvider;
import tv.danmaku.android.util.DebugLog;

public class BiliStatusProvider extends android_content_ContentProvider {
    private static final String LOGGED_STATUS_MIME_TYPE = "vnd.android.cursor.item/logged";
    private static final String NOT_INVALID_MIME_TYPE = "vnd.android.cursor.item/not_invalid";
    private static final String PATH_NAME_STATUS_LOGGED = "/status/logged";
    private static final String URI_QUERY_BUVID = "/queryBuvid";
    private static final String URI_QUERY_OAID = "/queryOaid";
    private String[] mLoggedColumnNames = {"uid", "logged"};
    private String[] mBuvidNames = {"buvid"};

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String path = uri.getPath();
        DebugLog.i("BiliStatusProvider", "BiliStatusProvider" + uri.toString() + ",path:" + path);
        if (PATH_NAME_STATUS_LOGGED.equalsIgnoreCase(path)) {
            return getLoggedStatusCursor();
        }
        if (URI_QUERY_BUVID.equalsIgnoreCase(path)) {
            return getBuvidCursor();
        }
        if (URI_QUERY_OAID.equalsIgnoreCase(path)) {
            return getOaidCursor();
        }
        return null;
    }

    private Cursor getLoggedStatusCursor() {
        try {
            MatrixCursor cursor = new MatrixCursor(this.mLoggedColumnNames, 1);
            Object[] objs = {"", 0};
            long mid = BiliAccounts.get(getContext()).mid();
            if (!BiliAccounts.get(getContext()).isTokenExpired()) {
                objs[0] = Long.valueOf(mid);
                objs[1] = 1;
            }
            cursor.addRow(objs);
            return cursor;
        } catch (Exception e) {
            return null;
        }
    }

    private Cursor getBuvidCursor() {
        try {
            MatrixCursor cursor = new MatrixCursor(this.mBuvidNames, 1);
            Object[] objs = {""};
            objs[0] = BuvidHelper.getBuvid();
            cursor.addRow(objs);
            return cursor;
        } catch (Exception e) {
            return null;
        }
    }

    private Cursor getOaidCursor() {
        try {
            MatrixCursor cursor = new MatrixCursor(new String[]{"oaid"}, 1);
            cursor.addRow(new Object[]{MsaHelper.getOaid()});
            return cursor;
        } catch (Exception e) {
            return null;
        }
    }

    public String getType(Uri uri) {
        String path = uri.getPath();
        if (PATH_NAME_STATUS_LOGGED.equalsIgnoreCase(path)) {
            return LOGGED_STATUS_MIME_TYPE;
        }
        return NOT_INVALID_MIME_TYPE;
    }

    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}