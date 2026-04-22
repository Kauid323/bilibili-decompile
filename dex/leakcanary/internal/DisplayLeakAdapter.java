package leakcanary.internal;

import android.content.Context;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.squareup.leakcanary.core.R;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import leakcanary.internal.DisplayLeakConnectorView;
import leakcanary.internal.SquigglySpan;
import leakcanary.internal.navigation.ViewsKt;
import leakcanary.internal.utils.SizeKt;
import org.apache.commons.io.FilenameUtils;
import shark.LeakTrace;
import shark.LeakTraceObject;
import shark.LeakTraceReference;

/* compiled from: DisplayLeakAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0001,B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\"\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u00122\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0014H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010&\u001a\u00020\n*\u00020'2\u0006\u0010(\u001a\u00020\nH\u0002J\f\u0010)\u001a\u00020\n*\u00020'H\u0002J\f\u0010*\u001a\u00020\n*\u00020+H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lleakcanary/internal/DisplayLeakAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "leakTrace", "Lshark/LeakTrace;", "header", "", "(Landroid/content/Context;Lshark/LeakTrace;Ljava/lang/CharSequence;)V", "extraColorHexString", "", "helpColorHexString", "highlightColorHexString", "leakColorHexString", "referenceColorHexString", "bindConnectorRow", "", "view", "Landroid/view/View;", "position", "", "bindHeaderRow", "elementIndex", "getConnectorType", "Lleakcanary/internal/DisplayLeakConnectorView$Type;", "getCount", "getItem", "Ljava/io/Serializable;", "getItemId", "", "getItemViewType", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "getViewTypeCount", "isEnabled", "", "asHtmlString", "Lshark/LeakTraceObject;", "typeName", "styledClassSimpleName", "styledOwningClassSimpleName", "Lshark/LeakTraceReference;", "Companion", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class DisplayLeakAdapter extends BaseAdapter {
    public static final int CONNECTOR_ROW = 1;
    public static final int HEADER_ROW = 0;
    private final String extraColorHexString;
    private final CharSequence header;
    private final String helpColorHexString;
    private final String highlightColorHexString;
    private final String leakColorHexString;
    private final LeakTrace leakTrace;
    private final String referenceColorHexString;
    public static final Companion Companion = new Companion(null);
    private static final String INDENTATION = StringsKt.repeat("&nbsp;", 4);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[LeakTraceReference.ReferenceType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            $EnumSwitchMapping$0[LeakTraceReference.ReferenceType.STATIC_FIELD.ordinal()] = 1;
            $EnumSwitchMapping$0[LeakTraceReference.ReferenceType.INSTANCE_FIELD.ordinal()] = 2;
            $EnumSwitchMapping$1 = new int[LeakTraceObject.LeakingStatus.values().length];
            $EnumSwitchMapping$1[LeakTraceObject.LeakingStatus.UNKNOWN.ordinal()] = 1;
            $EnumSwitchMapping$1[LeakTraceObject.LeakingStatus.NOT_LEAKING.ordinal()] = 2;
            $EnumSwitchMapping$1[LeakTraceObject.LeakingStatus.LEAKING.ordinal()] = 3;
            $EnumSwitchMapping$2 = new int[LeakTraceObject.LeakingStatus.values().length];
            $EnumSwitchMapping$2[LeakTraceObject.LeakingStatus.UNKNOWN.ordinal()] = 1;
            $EnumSwitchMapping$2[LeakTraceObject.LeakingStatus.NOT_LEAKING.ordinal()] = 2;
            $EnumSwitchMapping$2[LeakTraceObject.LeakingStatus.LEAKING.ordinal()] = 3;
        }
    }

    public DisplayLeakAdapter(Context context, LeakTrace leakTrace, CharSequence header) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(leakTrace, "leakTrace");
        Intrinsics.checkParameterIsNotNull(header, "header");
        this.leakTrace = leakTrace;
        this.header = header;
        this.highlightColorHexString = Companion.hexStringColor(context, R.color.leak_canary_class_name);
        this.leakColorHexString = Companion.hexStringColor(context, R.color.leak_canary_leak);
        this.referenceColorHexString = Companion.hexStringColor(context, R.color.leak_canary_reference);
        this.extraColorHexString = Companion.hexStringColor(context, R.color.leak_canary_extra);
        this.helpColorHexString = Companion.hexStringColor(context, R.color.leak_canary_help);
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        switch (getItemViewType(position)) {
            case 0:
                view = convertView != null ? convertView : ViewsKt.inflate(parent, R.layout.leak_canary_leak_header);
                bindHeaderRow(view);
                break;
            case 1:
                view = convertView != null ? convertView : ViewsKt.inflate(parent, R.layout.leak_canary_ref_row);
                bindConnectorRow(view, position);
                break;
            default:
                throw new IllegalStateException("Unexpected type " + getItemViewType(position));
        }
        return view;
    }

    private final void bindHeaderRow(View view) {
        TextView $this$apply = (TextView) view.findViewById(R.id.leak_canary_header_text);
        $this$apply.setMovementMethod(LinkMovementMethod.getInstance());
        $this$apply.setText(this.header);
    }

    private final void bindConnectorRow(View view, int position) {
        Spanned fromHtml;
        TextView titleView = (TextView) view.findViewById(R.id.leak_canary_row_title);
        DisplayLeakConnectorView connector = (DisplayLeakConnectorView) view.findViewById(R.id.leak_canary_row_connector);
        connector.setType(getConnectorType(position));
        Intrinsics.checkExpressionValueIsNotNull(titleView, "titleView");
        if (position == 1) {
            fromHtml = "GC Root: " + this.leakTrace.getGcRootType().getDescription();
        } else if (position >= getCount() - 1) {
            fromHtml = Html.fromHtml(asHtmlString(this.leakTrace.getLeakingObject(), this.leakTrace.getLeakingObject().getTypeName()));
        } else {
            int referencePathIndex = elementIndex(position);
            LeakTraceReference referencePath = (LeakTraceReference) this.leakTrace.getReferencePath().get(referencePathIndex);
            boolean isSuspect = this.leakTrace.referencePathElementIsSuspect(referencePathIndex);
            LeakTraceObject leakTraceObject = referencePath.getOriginObject();
            String typeName = (position == 2 && this.leakTrace.getGcRootType() == LeakTrace.GcRootType.JAVA_FRAME) ? "thread" : leakTraceObject.getTypeName();
            String referenceName = new Regex(">").replace(new Regex("<").replace(referencePath.getReferenceDisplayName(), "&lt;"), "&gt;");
            String referenceName2 = isSuspect ? "<u><font color='" + this.leakColorHexString + "'>" + referenceName + "</font></u>" : "<font color='" + this.referenceColorHexString + "'>" + referenceName + "</font>";
            if (referencePath.getReferenceType() == LeakTraceReference.ReferenceType.STATIC_FIELD) {
                referenceName2 = "<i>" + referenceName2 + "</i>";
            }
            if (isSuspect) {
                referenceName2 = "<b>" + referenceName2 + "</b>";
            }
            String str = "";
            String staticPrefix = referencePath.getReferenceType() == LeakTraceReference.ReferenceType.STATIC_FIELD ? "static " : "";
            StringBuilder append = new StringBuilder().append(asHtmlString(leakTraceObject, typeName)).append(INDENTATION).append(staticPrefix).append(styledOwningClassSimpleName(referencePath));
            switch (WhenMappings.$EnumSwitchMapping$0[referencePath.getReferenceType().ordinal()]) {
                case 1:
                case 2:
                    str = ".";
                    break;
            }
            String htmlString = append.append(str).append(referenceName2).toString();
            Spanned fromHtml2 = Html.fromHtml(htmlString);
            if (fromHtml2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.text.SpannableStringBuilder");
            }
            SpannableStringBuilder builder = (SpannableStringBuilder) fromHtml2;
            if (isSuspect) {
                SquigglySpan.Companion companion = SquigglySpan.Companion;
                Context context = view.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "view.context");
                companion.replaceUnderlineSpans(builder, context);
            }
            fromHtml = builder;
        }
        titleView.setText(fromHtml);
    }

    private final String asHtmlString(LeakTraceObject $this$asHtmlString, String typeName) {
        String str;
        String reachabilityString;
        int packageEnd = StringsKt.lastIndexOf$default((CharSequence) $this$asHtmlString.getClassName(), (char) FilenameUtils.EXTENSION_SEPARATOR, 0, false, 6, (Object) null);
        Function1 extra = new Function1<String, String>() { // from class: leakcanary.internal.DisplayLeakAdapter$asHtmlString$extra$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String it) {
                String str2;
                Intrinsics.checkParameterIsNotNull(it, "it");
                StringBuilder append = new StringBuilder().append("<font color='");
                str2 = DisplayLeakAdapter.this.extraColorHexString;
                return append.append(str2).append("'>").append(it).append("</font>").toString();
            }
        };
        String styledClassName = styledClassSimpleName($this$asHtmlString);
        if (packageEnd != -1) {
            StringBuilder sb = new StringBuilder();
            String className = $this$asHtmlString.getClassName();
            if (className == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = className.substring(0, packageEnd);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            str = sb.append(extra.invoke(substring)).append(FilenameUtils.EXTENSION_SEPARATOR).append(styledClassName).toString();
        } else {
            str = styledClassName;
        }
        String str2 = str + ' ' + extra.invoke(typeName) + "<br>";
        switch (WhenMappings.$EnumSwitchMapping$1[$this$asHtmlString.getLeakingStatus().ordinal()]) {
            case 1:
                reachabilityString = extra.invoke("UNKNOWN");
                break;
            case 2:
                reachabilityString = "NO" + extra.invoke(" (" + $this$asHtmlString.getLeakingStatusReason() + ')');
                break;
            case 3:
                reachabilityString = "YES" + extra.invoke(" (" + $this$asHtmlString.getLeakingStatusReason() + ')');
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        String str3 = str2 + INDENTATION + extra.invoke("Leaking: ") + reachabilityString + "<br>";
        Integer retainedHeapByteSize = $this$asHtmlString.getRetainedHeapByteSize();
        if (retainedHeapByteSize != null) {
            int it = retainedHeapByteSize.intValue();
            String humanReadableRetainedHeapSize = SizeKt.humanReadableByteCount(it, true);
            str3 = str3 + INDENTATION + extra.invoke("Retaining ") + humanReadableRetainedHeapSize + extra.invoke(" in ") + $this$asHtmlString.getRetainedObjectCount() + extra.invoke(" objects") + "<br>";
        }
        Iterable $this$forEach$iv = $this$asHtmlString.getLabels();
        for (Object element$iv : $this$forEach$iv) {
            String label = (String) element$iv;
            str3 = str3 + INDENTATION + extra.invoke(label) + "<br>";
        }
        return str3;
    }

    private final String styledClassSimpleName(LeakTraceObject $this$styledClassSimpleName) {
        String simpleName = StringsKt.replace$default($this$styledClassSimpleName.getClassSimpleName(), "[]", "[ ]", false, 4, (Object) null);
        return "<font color='" + this.highlightColorHexString + "'>" + simpleName + "</font>";
    }

    private final String styledOwningClassSimpleName(LeakTraceReference $this$styledOwningClassSimpleName) {
        String simpleName = StringsKt.removeSuffix($this$styledOwningClassSimpleName.getOwningClassSimpleName(), (CharSequence) "[]");
        return "<font color='" + this.highlightColorHexString + "'>" + simpleName + "</font>";
    }

    private final DisplayLeakConnectorView.Type getConnectorType(int position) {
        if (position == 1) {
            return DisplayLeakConnectorView.Type.GC_ROOT;
        }
        if (position != 2) {
            boolean isLeakingInstance = position == getCount() - 1;
            if (isLeakingInstance) {
                LeakTraceObject previousReachability = ((LeakTraceReference) CollectionsKt.last((List<? extends Object>) this.leakTrace.getReferencePath())).getOriginObject();
                if (previousReachability.getLeakingStatus() != LeakTraceObject.LeakingStatus.LEAKING) {
                    return DisplayLeakConnectorView.Type.END_FIRST_UNREACHABLE;
                }
                return DisplayLeakConnectorView.Type.END;
            }
            LeakTraceObject reachability = ((LeakTraceReference) this.leakTrace.getReferencePath().get(elementIndex(position))).getOriginObject();
            switch (WhenMappings.$EnumSwitchMapping$2[reachability.getLeakingStatus().ordinal()]) {
                case 1:
                    return DisplayLeakConnectorView.Type.NODE_UNKNOWN;
                case 2:
                    LeakTraceObject nextReachability = position + 1 == getCount() - 1 ? this.leakTrace.getLeakingObject() : ((LeakTraceReference) this.leakTrace.getReferencePath().get(elementIndex(position + 1))).getOriginObject();
                    if (nextReachability.getLeakingStatus() != LeakTraceObject.LeakingStatus.NOT_LEAKING) {
                        return DisplayLeakConnectorView.Type.NODE_LAST_REACHABLE;
                    }
                    return DisplayLeakConnectorView.Type.NODE_REACHABLE;
                case 3:
                    LeakTraceObject previousReachability2 = ((LeakTraceReference) this.leakTrace.getReferencePath().get(elementIndex(position - 1))).getOriginObject();
                    if (previousReachability2.getLeakingStatus() != LeakTraceObject.LeakingStatus.LEAKING) {
                        return DisplayLeakConnectorView.Type.NODE_FIRST_UNREACHABLE;
                    }
                    return DisplayLeakConnectorView.Type.NODE_UNREACHABLE;
                default:
                    throw new IllegalStateException("Unknown value: " + reachability.getLeakingStatus());
            }
        }
        switch (this.leakTrace.getReferencePath().size()) {
            case 0:
                return DisplayLeakConnectorView.Type.END_FIRST_UNREACHABLE;
            case 1:
                return DisplayLeakConnectorView.Type.START_LAST_REACHABLE;
            default:
                LeakTraceObject nextReachability2 = ((LeakTraceReference) this.leakTrace.getReferencePath().get(1)).getOriginObject();
                if (nextReachability2.getLeakingStatus() != LeakTraceObject.LeakingStatus.NOT_LEAKING) {
                    return DisplayLeakConnectorView.Type.START_LAST_REACHABLE;
                }
                return DisplayLeakConnectorView.Type.START;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int position) {
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.leakTrace.getReferencePath().size() + 3;
    }

    @Override // android.widget.Adapter
    public Serializable getItem(int position) {
        if (position == 0 || position == 1) {
            return null;
        }
        return position == getCount() - 1 ? this.leakTrace.getLeakingObject() : (Serializable) this.leakTrace.getReferencePath().get(elementIndex(position));
    }

    private final int elementIndex(int position) {
        return position - 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        return position == 0 ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    /* compiled from: DisplayLeakAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lleakcanary/internal/DisplayLeakAdapter$Companion;", "", "()V", "CONNECTOR_ROW", "", "HEADER_ROW", "INDENTATION", "", "getINDENTATION", "()Ljava/lang/String;", "hexStringColor", "context", "Landroid/content/Context;", "colorResId", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final String getINDENTATION() {
            return DisplayLeakAdapter.INDENTATION;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String hexStringColor(Context context, int colorResId) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & ViewsKt.getColorCompat(context, colorResId))}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            return format;
        }
    }
}