package com.example.common.util.ext;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import com.alibaba.android.arouter.launcher.ARouter;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\t*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a<\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b\u001a2\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b\u001a$\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f\u00a8\u0006\u0010"}, d2 = {"navigateTo", "", "Lcom/alibaba/android/arouter/launcher/ARouter;", "activity", "Landroid/app/Activity;", "path", "", "requestCode", "", "", "navigateToWithParam", "bundle", "Landroid/os/Bundle;", "key", "param", "Landroid/os/Parcelable;", "common_debug"})
public final class ARouterExtKt {
    
    /**
     * Navigate to specific path.
     *
     * @param path Path to navigate.
     */
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Object navigateTo(@org.jetbrains.annotations.NotNull()
    com.alibaba.android.arouter.launcher.ARouter $this$navigateTo, @org.jetbrains.annotations.NotNull()
    java.lang.String path) {
        return null;
    }
    
    /**
     * Navigate to specific path with request code. Similar to calling startActivityForResult.
     *
     * @param activity Activity and so on.
     * @param path Path to navigate.
     * @param requestCode Request code to trigger startActivityForResult.
     */
    public static final void navigateTo(@org.jetbrains.annotations.NotNull()
    com.alibaba.android.arouter.launcher.ARouter $this$navigateTo, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String path, int requestCode) {
    }
    
    /**
     * Navigate to specific path with param.
     *
     * @param path Path to navigate.
     * @param key Key of the param.
     * @param param Value of the param.
     */
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Object navigateToWithParam(@org.jetbrains.annotations.NotNull()
    com.alibaba.android.arouter.launcher.ARouter $this$navigateToWithParam, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    android.os.Parcelable param) {
        return null;
    }
    
    /**
     * Navigate to specific path with param.
     *
     * @param activity Activity and so on.
     * @param path Path to navigate.
     * @param key Key of the param.
     * @param param Value of the param.
     * @param requestCode Request code to trigger startActivityForResult.
     */
    public static final void navigateToWithParam(@org.jetbrains.annotations.NotNull()
    com.alibaba.android.arouter.launcher.ARouter $this$navigateToWithParam, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    android.os.Parcelable param, int requestCode) {
    }
    
    /**
     * Navigate to specific path with param.
     *
     * @param activity Activity and so on.
     * @param path Path to navigate.
     * @param bundle Default bundle.
     * @param key Key of the param.
     * @param param Value of the param.
     * @param requestCode Request code to trigger startActivityForResult.
     */
    public static final void navigateToWithParam(@org.jetbrains.annotations.NotNull()
    com.alibaba.android.arouter.launcher.ARouter $this$navigateToWithParam, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.Nullable()
    android.os.Bundle bundle, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    android.os.Parcelable param, int requestCode) {
    }
}