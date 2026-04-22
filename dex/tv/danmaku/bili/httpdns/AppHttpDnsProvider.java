package tv.danmaku.bili.httpdns;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.bilibili.lib.spy.generated.android_content_ContentProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.httpdns.api.AppHttpDnsKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: AppHttpDnsProvider.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016JO\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J1\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u001cJ;\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u001e¨\u0006 "}, d2 = {"Ltv/danmaku/bili/httpdns/AppHttpDnsProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "call", "Landroid/os/Bundle;", "method", "", LoginReporterV2.APP_ONEPASS_GUIDE_KEY, "extras", "onCreate", "", "query", "Landroid/database/Cursor;", AudioIntentHelper.ARGS_URI, "Landroid/net/Uri;", "projection", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "insert", "values", "Landroid/content/ContentValues;", "delete", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", ReportUtilKt.POS_UPDATE, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AppHttpDnsProvider extends android_content_ContentProvider {
    private static final String AUTHORITY_SUFFIX = ".dns.provider";
    public static final String EXTRA_KEY_DNS = "dns";
    public static final String FUNC_GET_DNS = "getDns";
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public Bundle call(String method, String arg, Bundle extras) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, FUNC_GET_DNS)) {
            Bundle $this$call_u24lambda_u240 = new Bundle();
            $this$call_u24lambda_u240.putString(EXTRA_KEY_DNS, AppHttpDnsKt.getClientIp());
            return $this$call_u24lambda_u240;
        }
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Intrinsics.checkNotNullParameter(uri, AudioIntentHelper.ARGS_URI);
        return null;
    }

    public String getType(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, AudioIntentHelper.ARGS_URI);
        return null;
    }

    public Uri insert(Uri uri, ContentValues values) {
        Intrinsics.checkNotNullParameter(uri, AudioIntentHelper.ARGS_URI);
        return null;
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, AudioIntentHelper.ARGS_URI);
        return 0;
    }

    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, AudioIntentHelper.ARGS_URI);
        return 0;
    }

    /* compiled from: AppHttpDnsProvider.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/httpdns/AppHttpDnsProvider$Companion;", "", "<init>", "()V", "AUTHORITY_SUFFIX", "", "FUNC_GET_DNS", "EXTRA_KEY_DNS", "getContentUri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Uri getContentUri(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Uri parse = Uri.parse("content://" + context.getPackageName() + AppHttpDnsProvider.AUTHORITY_SUFFIX);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            return parse;
        }
    }
}