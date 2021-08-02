package com.example.common.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bJ \u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/example/common/util/ShareUtil;", "", "()V", "shareAsMedia", "", "context", "Landroid/content/Context;", "text", "", "subject", "uri", "Landroid/net/Uri;", "mimeType", "shareAsText", "startIntentChooser", "intent", "Landroid/content/Intent;", "common_debug"})
public final class ShareUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.common.util.ShareUtil INSTANCE = null;
    
    private ShareUtil() {
        super();
    }
    
    public final void shareAsText(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.Nullable()
    java.lang.String subject) {
    }
    
    public final void shareAsMedia(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String text, @org.jetbrains.annotations.Nullable()
    java.lang.String subject, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.NotNull()
    java.lang.String mimeType) {
    }
    
    private final void startIntentChooser(android.content.Context context, android.content.Intent intent) {
    }
}