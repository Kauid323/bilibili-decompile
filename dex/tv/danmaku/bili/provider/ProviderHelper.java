package tv.danmaku.bili.provider;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import com.bilibili.lib.crashreport.CrashReporter;
import com.tencent.bugly.crashreport.BuglyLog;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

public final class ProviderHelper {
    private static final Operation NULL = new Operation(null);

    private ProviderHelper() {
    }

    public static Operation acquireProviderOp(Context context, String authority) {
        ContentResolver resolver = context.getContentResolver();
        ContentProviderClient client = null;
        try {
            client = resolver.acquireContentProviderClient(authority);
        } catch (SecurityException e) {
            BuglyLog.e("Provider", e.getMessage(), e);
        }
        if (client == null) {
            BuglyLog.i("Provider", "context is " + context + ", application is " + context.getApplicationContext());
            ContentProviderClient media = resolver.acquireContentProviderClient(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            BuglyLog.i("Provider", "images provider is " + String.valueOf(media));
            if (media != null) {
                try {
                    media.release();
                } catch (Exception e2) {
                }
            }
            CrashReporter.INSTANCE.postCaughtException(new ProviderNotFoundException("Couldn't find provider associated to authority '" + authority + "'. See log for more info"));
            return NULL;
        }
        return new Operation(client);
    }

    public static Bundle call(Context context, Uri uri, String method, String arg, Bundle extras) {
        try {
            return context.getContentResolver().call(uri, method, arg, extras);
        } catch (Exception e) {
            CrashReporter.INSTANCE.postCaughtException(new ProviderOperationsException("call", uri, e));
            return null;
        }
    }

    public static Cursor query(Context context, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        try {
            return context.getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);
        } catch (Exception e) {
            CrashReporter.INSTANCE.postCaughtException(new ProviderOperationsException("query", uri, e));
            return null;
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Operation {
        private ContentProviderClient mClient;

        public Operation(ContentProviderClient client) {
            this.mClient = client;
        }

        public Operation update(Uri uri, ContentValues values) {
            if (this.mClient != null) {
                try {
                    this.mClient.update(uri, values, null, null);
                } catch (Exception e) {
                    BuglyLog.w("Provider", "CANNOT APPLY CHANGES TO PROVIDER!!! " + values.keySet());
                    CrashReporter.INSTANCE.postCaughtException(new ProviderOperationsException(ReportUtilKt.POS_UPDATE, uri, e));
                }
            }
            return this;
        }

        public Operation insert(Uri uri, ContentValues values) {
            try {
                if (this.mClient != null) {
                    this.mClient.insert(uri, values);
                }
            } catch (Exception e) {
                BuglyLog.w("Provider", "CANNOT APPLY CHANGES TO PROVIDER!!! " + values.keySet());
                CrashReporter.INSTANCE.postCaughtException(new ProviderOperationsException("insert", uri, e));
            }
            return this;
        }

        public Operation delete(Uri uri, String selection, String[] selectionArgs) {
            try {
                if (this.mClient != null) {
                    this.mClient.delete(uri, selection, selectionArgs);
                }
            } catch (Exception e) {
                CrashReporter.INSTANCE.postCaughtException(new ProviderOperationsException("delete", uri, e));
            }
            return this;
        }

        public void release() {
            if (this.mClient != null) {
                try {
                    this.mClient.release();
                } catch (Exception e) {
                }
            }
            this.mClient = null;
        }

        protected void finalize() throws Throwable {
            if (this.mClient != null) {
                Log.e("Provider", "You have not call release() on ProviderOperation, ContentProviderClient may leak!");
                release();
            }
            super.finalize();
        }
    }
}