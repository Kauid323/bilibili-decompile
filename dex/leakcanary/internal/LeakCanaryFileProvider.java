package leakcanary.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.StrictMode;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bilibili.lib.spy.generated.android_content_ContentProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: LeakCanaryFileProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 $2\u00020\u0001:\u0003$%&B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J/\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0010H\u0016JI\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00122\b\u0010 \u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010!J9\u0010\"\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010#R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lleakcanary/internal/LeakCanaryFileProvider;", "Landroid/content/ContentProvider;", "()V", "mStrategy", "Lleakcanary/internal/LeakCanaryFileProvider$PathStrategy;", "attachInfo", "", "context", "Landroid/content/Context;", "info", "Landroid/content/pm/ProviderInfo;", "delete", "", "uri", "Landroid/net/Uri;", "selection", "", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "openFile", "Landroid/os/ParcelFileDescriptor;", "mode", "query", "Landroid/database/Cursor;", "projectionArg", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "PathStrategy", "SimplePathStrategy", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class LeakCanaryFileProvider extends android_content_ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private PathStrategy mStrategy;
    public static final Companion Companion = new Companion(null);
    private static final String[] COLUMNS = {"_display_name", "_size"};
    private static final File DEVICE_ROOT = new File("/");
    private static final HashMap<String, PathStrategy> sCache = new HashMap<>();

    /* compiled from: LeakCanaryFileProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lleakcanary/internal/LeakCanaryFileProvider$PathStrategy;", "", "getFileForUri", "Ljava/io/File;", "uri", "Landroid/net/Uri;", "getUriForFile", "file", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public interface PathStrategy {
        File getFileForUri(Uri uri);

        Uri getUriForFile(File file);
    }

    public boolean onCreate() {
        return true;
    }

    public void attachInfo(Context context, ProviderInfo info) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(info, "info");
        super.attachInfo(context, info);
        if (info.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!info.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        Companion companion = Companion;
        String str = info.authority;
        Intrinsics.checkExpressionValueIsNotNull(str, "info.authority");
        PathStrategy pathStrategy = companion.getPathStrategy(context, str);
        if (pathStrategy == null) {
            Intrinsics.throwNpe();
        }
        this.mStrategy = pathStrategy;
    }

    public Cursor query(Uri uri, String[] projectionArg, String selection, String[] selectionArgs, String sortOrder) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        String[] projection = projectionArg != null ? projectionArg : COLUMNS;
        PathStrategy pathStrategy = this.mStrategy;
        if (pathStrategy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStrategy");
        }
        File file = pathStrategy.getFileForUri(uri);
        String[] cols = new String[projection.length];
        Object[] values = new Object[projection.length];
        int i = 0;
        for (String col : projection) {
            if (Intrinsics.areEqual("_display_name", col)) {
                cols[i] = "_display_name";
                values[i] = file.getName();
                i++;
            } else if (Intrinsics.areEqual("_size", col)) {
                cols[i] = "_size";
                values[i] = Long.valueOf(file.length());
                i++;
            }
        }
        String[] cols2 = Companion.copyOfStringArray(cols, i);
        Object[] values2 = Companion.copyOfAnyArray(values, i);
        MatrixCursor cursor = new MatrixCursor(cols2, 1);
        cursor.addRow(values2);
        return cursor;
    }

    public String getType(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        PathStrategy pathStrategy = this.mStrategy;
        if (pathStrategy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStrategy");
        }
        File file = pathStrategy.getFileForUri(uri);
        String name = file.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "file.name");
        int lastDot = StringsKt.lastIndexOf$default((CharSequence) name, (char) FilenameUtils.EXTENSION_SEPARATOR, 0, false, 6, (Object) null);
        if (lastDot >= 0) {
            String name2 = file.getName();
            Intrinsics.checkExpressionValueIsNotNull(name2, "file.name");
            int i = lastDot + 1;
            if (name2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String extension = name2.substring(i);
            Intrinsics.checkNotNullExpressionValue(extension, "(this as java.lang.String).substring(startIndex)");
            String mime = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            if (mime != null) {
                return mime;
            }
            return "application/octet-stream";
        }
        return "application/octet-stream";
    }

    public Uri insert(Uri uri, ContentValues values) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        throw new UnsupportedOperationException("No external inserts");
    }

    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        throw new UnsupportedOperationException("No external updates");
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        PathStrategy pathStrategy = this.mStrategy;
        if (pathStrategy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStrategy");
        }
        File file = pathStrategy.getFileForUri(uri);
        return file.delete() ? 1 : 0;
    }

    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        PathStrategy pathStrategy = this.mStrategy;
        if (pathStrategy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStrategy");
        }
        File file = pathStrategy.getFileForUri(uri);
        int fileMode = Companion.modeToMode(mode);
        return ParcelFileDescriptor.open(file, fileMode);
    }

    /* compiled from: LeakCanaryFileProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lleakcanary/internal/LeakCanaryFileProvider$SimplePathStrategy;", "Lleakcanary/internal/LeakCanaryFileProvider$PathStrategy;", "mAuthority", "", "(Ljava/lang/String;)V", "mRoots", "Ljava/util/HashMap;", "Ljava/io/File;", "Lkotlin/collections/HashMap;", "addRoot", "", LeakCanaryFileProvider.ATTR_NAME, "root", "getFileForUri", "uri", "Landroid/net/Uri;", "getUriForFile", "file", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class SimplePathStrategy implements PathStrategy {
        private final String mAuthority;
        private final HashMap<String, File> mRoots;

        public SimplePathStrategy(String mAuthority) {
            Intrinsics.checkParameterIsNotNull(mAuthority, "mAuthority");
            this.mAuthority = mAuthority;
            this.mRoots = new HashMap<>();
        }

        public final void addRoot(String name, File root) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(root, "root");
            if (TextUtils.isEmpty(name)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            HashMap<String, File> hashMap = this.mRoots;
            try {
                File canonicalFile = root.getCanonicalFile();
                Intrinsics.checkExpressionValueIsNotNull(canonicalFile, "try {\n        // Resolve…oot\", e\n        )\n      }");
                hashMap.put(name, canonicalFile);
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + root, e);
            }
        }

        @Override // leakcanary.internal.LeakCanaryFileProvider.PathStrategy
        public Uri getUriForFile(File file) {
            String path;
            Intrinsics.checkParameterIsNotNull(file, "file");
            try {
                String path2 = file.getCanonicalPath();
                Intrinsics.checkExpressionValueIsNotNull(path2, "file.canonicalPath");
                Map.Entry mostSpecific = null;
                for (Map.Entry root : this.mRoots.entrySet()) {
                    File value = root.getValue();
                    Intrinsics.checkExpressionValueIsNotNull(value, "root.value");
                    String rootPath = value.getPath();
                    Intrinsics.checkExpressionValueIsNotNull(rootPath, "rootPath");
                    if (StringsKt.startsWith$default(path2, rootPath, false, 2, (Object) null) && (mostSpecific == null || rootPath.length() > mostSpecific.getValue().getPath().length())) {
                        mostSpecific = root;
                    }
                }
                if (mostSpecific == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains " + path2);
                }
                String rootPath2 = mostSpecific.getValue().getPath();
                Intrinsics.checkExpressionValueIsNotNull(rootPath2, "rootPath");
                int startIndex = StringsKt.endsWith$default(rootPath2, "/", false, 2, (Object) null) ? rootPath2.length() : rootPath2.length() + 1;
                if (path2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                Intrinsics.checkNotNullExpressionValue(path2.substring(startIndex), "(this as java.lang.String).substring(startIndex)");
                Uri build = new Uri.Builder().scheme("content").authority(this.mAuthority).encodedPath(Uri.encode(mostSpecific.getKey()) + "/" + Uri.encode(path, "/")).build();
                Intrinsics.checkExpressionValueIsNotNull(build, "Uri.Builder()\n        .s…th(path)\n        .build()");
                return build;
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        @Override // leakcanary.internal.LeakCanaryFileProvider.PathStrategy
        public File getFileForUri(Uri uri) {
            Intrinsics.checkParameterIsNotNull(uri, "uri");
            String path = uri.getEncodedPath();
            if (path == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(path, "uri.encodedPath!!");
            int splitIndex = StringsKt.indexOf$default((CharSequence) path, '/', 1, false, 4, (Object) null);
            if (path == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = path.substring(1, splitIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String tag = Uri.decode(substring);
            int i = splitIndex + 1;
            if (path == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String substring2 = path.substring(i);
            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
            String path2 = Uri.decode(substring2);
            Intrinsics.checkExpressionValueIsNotNull(path2, "Uri.decode(path.substring(splitIndex + 1))");
            File root = this.mRoots.get(tag);
            if (root != null) {
                Intrinsics.checkExpressionValueIsNotNull(root, "mRoots[tag]\n        ?: t…onfigured root for $uri\")");
                File file = new File(root, path2);
                try {
                    File file2 = file.getCanonicalFile();
                    Intrinsics.checkExpressionValueIsNotNull(file2, "file.canonicalFile");
                    String path3 = file2.getPath();
                    Intrinsics.checkExpressionValueIsNotNull(path3, "file.path");
                    String path4 = root.getPath();
                    Intrinsics.checkExpressionValueIsNotNull(path4, "root.path");
                    if (StringsKt.startsWith$default(path3, path4, false, 2, (Object) null)) {
                        return file2;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException e) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
                }
            }
            throw new IllegalArgumentException("Unable to find configured root for " + uri);
        }
    }

    /* compiled from: LeakCanaryFileProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0007\"\u00020\u0004H\u0002¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010\u001fJ-\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00072\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010!J\u001b\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010#\u001a\u00020$H\u0002¢\u0006\u0002\u0010%J%\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010#\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010(J\u001a\u0010)\u001a\u0004\u0018\u00010\u00152\u0006\u0010#\u001a\u00020$2\u0006\u0010*\u001a\u00020\u0004H\u0002J\u001e\u0010+\u001a\u00020,2\u0006\u0010#\u001a\u00020$2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\nJ\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0004H\u0002J\u0018\u00100\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$2\u0006\u0010*\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R*\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0014j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lleakcanary/internal/LeakCanaryFileProvider$Companion;", "", "()V", "ATTR_NAME", "", "ATTR_PATH", "COLUMNS", "", "[Ljava/lang/String;", "DEVICE_ROOT", "Ljava/io/File;", "META_DATA_FILE_PROVIDER_PATHS", "TAG_CACHE_PATH", "TAG_EXTERNAL", "TAG_EXTERNAL_CACHE", "TAG_EXTERNAL_FILES", "TAG_EXTERNAL_MEDIA", "TAG_FILES_PATH", "TAG_ROOT_PATH", "sCache", "Ljava/util/HashMap;", "Lleakcanary/internal/LeakCanaryFileProvider$PathStrategy;", "Lkotlin/collections/HashMap;", "buildPath", "base", "segments", "(Ljava/io/File;[Ljava/lang/String;)Ljava/io/File;", "copyOfAnyArray", "original", "newLength", "", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "copyOfStringArray", "([Ljava/lang/String;I)[Ljava/lang/String;", "getExternalCacheDirs", "context", "Landroid/content/Context;", "(Landroid/content/Context;)[Ljava/io/File;", "getExternalFilesDirs", "type", "(Landroid/content/Context;Ljava/lang/String;)[Ljava/io/File;", "getPathStrategy", "authority", "getUriForFile", "Landroid/net/Uri;", "file", "modeToMode", "mode", "parsePathStrategy", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final Uri getUriForFile(Context context, String authority, File file) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(authority, "authority");
            Intrinsics.checkParameterIsNotNull(file, "file");
            PathStrategy strategy = getPathStrategy(context, authority);
            if (strategy == null) {
                Intrinsics.throwNpe();
            }
            return strategy.getUriForFile(file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final PathStrategy getPathStrategy(Context context, String authority) {
            PathStrategy pathStrategy;
            synchronized (LeakCanaryFileProvider.sCache) {
                pathStrategy = (PathStrategy) LeakCanaryFileProvider.sCache.get(authority);
                if (pathStrategy == null) {
                    try {
                        try {
                            StrictMode.ThreadPolicy previousPolicy = StrictMode.getThreadPolicy();
                            try {
                                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());
                                pathStrategy = LeakCanaryFileProvider.Companion.parsePathStrategy(context, authority);
                                HashMap hashMap = LeakCanaryFileProvider.sCache;
                                if (pathStrategy == null) {
                                    Intrinsics.throwNpe();
                                }
                                hashMap.put(authority, pathStrategy);
                            } finally {
                                StrictMode.setThreadPolicy(previousPolicy);
                            }
                        } catch (IOException e) {
                            throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                        }
                    } catch (XmlPullParserException e2) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            return pathStrategy;
        }

        private final PathStrategy parsePathStrategy(Context context, String authority) throws IOException, XmlPullParserException {
            SimplePathStrategy strat = new SimplePathStrategy(authority);
            ProviderInfo info = context.getPackageManager().resolveContentProvider(authority, 128);
            if (info != null) {
                Intrinsics.checkExpressionValueIsNotNull(info, "context.packageManager\n …ity $authority\"\n        )");
                XmlResourceParser resourceParser = info.loadXmlMetaData(context.getPackageManager(), LeakCanaryFileProvider.META_DATA_FILE_PROVIDER_PATHS);
                if (resourceParser == null) {
                    throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
                }
                while (true) {
                    int type = resourceParser.next();
                    if (type != 1) {
                        if (type == 2) {
                            String tag = resourceParser.getName();
                            String name = resourceParser.getAttributeValue(null, LeakCanaryFileProvider.ATTR_NAME);
                            String path = resourceParser.getAttributeValue(null, LeakCanaryFileProvider.ATTR_PATH);
                            File target = null;
                            if (Intrinsics.areEqual(LeakCanaryFileProvider.TAG_ROOT_PATH, tag)) {
                                target = LeakCanaryFileProvider.DEVICE_ROOT;
                            } else if (Intrinsics.areEqual(LeakCanaryFileProvider.TAG_FILES_PATH, tag)) {
                                target = context.getFilesDir();
                            } else if (Intrinsics.areEqual(LeakCanaryFileProvider.TAG_CACHE_PATH, tag)) {
                                target = context.getCacheDir();
                            } else if (Intrinsics.areEqual(LeakCanaryFileProvider.TAG_EXTERNAL, tag)) {
                                target = Environment.getExternalStorageDirectory();
                            } else if (Intrinsics.areEqual(LeakCanaryFileProvider.TAG_EXTERNAL_FILES, tag)) {
                                File[] externalFilesDirs = getExternalFilesDirs(context, null);
                                if (!(externalFilesDirs.length == 0)) {
                                    target = externalFilesDirs[0];
                                }
                            } else if (Intrinsics.areEqual(LeakCanaryFileProvider.TAG_EXTERNAL_CACHE, tag)) {
                                File[] externalCacheDirs = getExternalCacheDirs(context);
                                if (!(externalCacheDirs.length == 0)) {
                                    target = externalCacheDirs[0];
                                }
                            } else if (Intrinsics.areEqual(LeakCanaryFileProvider.TAG_EXTERNAL_MEDIA, tag)) {
                                File[] externalMediaDirs = context.getExternalMediaDirs();
                                Intrinsics.checkExpressionValueIsNotNull(externalMediaDirs, "externalMediaDirs");
                                if (!(externalMediaDirs.length == 0)) {
                                    target = externalMediaDirs[0];
                                }
                            }
                            if (target != null) {
                                Intrinsics.checkExpressionValueIsNotNull(name, "name");
                                Intrinsics.checkExpressionValueIsNotNull(path, "path");
                                strat.addRoot(name, buildPath(target, path));
                            }
                        }
                    } else {
                        return strat;
                    }
                }
            } else {
                throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + authority);
            }
        }

        private final File[] getExternalFilesDirs(Context context, String type) {
            File[] externalFilesDirs = context.getExternalFilesDirs(type);
            Intrinsics.checkExpressionValueIsNotNull(externalFilesDirs, "context.getExternalFilesDirs(type)");
            return externalFilesDirs;
        }

        private final File[] getExternalCacheDirs(Context context) {
            File[] externalCacheDirs = context.getExternalCacheDirs();
            Intrinsics.checkExpressionValueIsNotNull(externalCacheDirs, "context.externalCacheDirs");
            return externalCacheDirs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
            if (r4.equals("w") != false) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
            return 738197504;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
            if (r4.equals("wt") != false) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final int modeToMode(String mode) {
            switch (mode.hashCode()) {
                case 114:
                    if (mode.equals("r")) {
                        return 268435456;
                    }
                    throw new IllegalArgumentException("Invalid mode: " + mode);
                case 119:
                    break;
                case 3653:
                    if (mode.equals("rw")) {
                        return 939524096;
                    }
                    throw new IllegalArgumentException("Invalid mode: " + mode);
                case 3786:
                    if (mode.equals("wa")) {
                        return 704643072;
                    }
                    throw new IllegalArgumentException("Invalid mode: " + mode);
                case 3805:
                    break;
                case 113359:
                    if (mode.equals("rwt")) {
                        return 1006632960;
                    }
                    throw new IllegalArgumentException("Invalid mode: " + mode);
                default:
                    throw new IllegalArgumentException("Invalid mode: " + mode);
            }
        }

        private final File buildPath(File base, String... segments) {
            File cur = base;
            for (String segment : segments) {
                cur = new File(cur, segment);
            }
            return cur;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String[] copyOfStringArray(String[] original, int newLength) {
            String[] result = new String[newLength];
            System.arraycopy(original, 0, result, 0, newLength);
            return result;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object[] copyOfAnyArray(Object[] original, int newLength) {
            Object[] result = new Object[newLength];
            System.arraycopy(original, 0, result, 0, newLength);
            return result;
        }
    }
}