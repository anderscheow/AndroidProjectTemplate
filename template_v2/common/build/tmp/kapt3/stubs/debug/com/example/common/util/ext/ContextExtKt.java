package com.example.common.util.ext;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.provider.Settings;
import android.widget.Toast;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000:\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0001\u001a\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0001\u001a\u0016\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0001\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\u0002\u001a\n\u0010\r\u001a\u00020\u000e*\u00020\u0002\u001a\u0012\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u0012\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0004\u001a\u0012\u0010\u0013\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u0012\u0010\u0013\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0001\u00a8\u0006\u0014"}, d2 = {"dp", "", "Landroid/content/Context;", "px", "", "findColor", "resId", "findColorStateList", "Landroid/content/res/ColorStateList;", "findDrawable", "Landroid/graphics/drawable/Drawable;", "gotoLocationSetting", "", "isGpsEnabled", "", "longToast", "Landroid/widget/Toast;", "message", "", "toast", "common_debug"})
public final class ContextExtKt {
    
    /**
     * Get color from [ContextCompat].
     *
     * @param resId Color resource id.
     *
     * @return A single color value in the form 0xAARRGGBB.
     */
    public static final int findColor(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$findColor, @androidx.annotation.ColorRes()
    int resId) {
        return 0;
    }
    
    /**
     * Get color state list from [ContextCompat].
     *
     * @param resId Color resource id.
     *
     * @return A single color value in the form 0xAARRGGBB.
     */
    @org.jetbrains.annotations.Nullable()
    public static final android.content.res.ColorStateList findColorStateList(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$findColorStateList, @androidx.annotation.ColorRes()
    int resId) {
        return null;
    }
    
    /**
     * Get drawable from [ContextCompat].
     *
     * @param resId Drawable resource id.
     *
     * @return An object that can be used to draw this resource.
     */
    @org.jetbrains.annotations.Nullable()
    public static final android.graphics.drawable.Drawable findDrawable(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$findDrawable, @androidx.annotation.DrawableRes()
    int resId) {
        return null;
    }
    
    /**
     * Display the simple Toast message with the [Toast.LENGTH_SHORT] duration.
     *
     * @param message the message text resource.
     */
    @org.jetbrains.annotations.NotNull()
    public static final android.widget.Toast toast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$toast, int message) {
        return null;
    }
    
    /**
     * Display the simple Toast message with the [Toast.LENGTH_SHORT] duration.
     *
     * @param message the message text.
     */
    @org.jetbrains.annotations.NotNull()
    public static final android.widget.Toast toast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$toast, @org.jetbrains.annotations.NotNull()
    java.lang.CharSequence message) {
        return null;
    }
    
    /**
     * Display the simple Toast message with the [Toast.LENGTH_LONG] duration.
     *
     * @param message the message text resource.
     */
    @org.jetbrains.annotations.NotNull()
    public static final android.widget.Toast longToast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$longToast, int message) {
        return null;
    }
    
    /**
     * Display the simple Toast message with the [Toast.LENGTH_LONG] duration.
     *
     * @param message the message text.
     */
    @org.jetbrains.annotations.NotNull()
    public static final android.widget.Toast longToast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$longToast, @org.jetbrains.annotations.NotNull()
    java.lang.CharSequence message) {
        return null;
    }
    
    /**
     * Convert dp to px.
     *
     * @param dp Dp in float.
     *
     * @return Value in px.
     */
    public static final int px(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$px, float dp) {
        return 0;
    }
    
    /**
     * Convert px to dp.
     *
     * @param px Px in float.
     *
     * @return Value in dp.
     */
    public static final int dp(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$dp, float px) {
        return 0;
    }
    
    /**
     * Check is gps enable.
     *
     * @return Gps enable status.
     */
    public static final boolean isGpsEnabled(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$isGpsEnabled) {
        return false;
    }
    
    /**
     * Go to Location section in Settings.
     */
    public static final void gotoLocationSetting(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$gotoLocationSetting) {
    }
}