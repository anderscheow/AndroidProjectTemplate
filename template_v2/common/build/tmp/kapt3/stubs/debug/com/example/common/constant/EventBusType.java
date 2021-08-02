package com.example.common.constant;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\b"}, d2 = {"Lcom/example/common/constant/EventBusType;", "", "(Ljava/lang/String;I)V", "ON_ATTACH", "ON_CREATE", "ON_START", "ON_RESUME", "Companion", "common_debug"})
public enum EventBusType {
    /*public static final*/ ON_ATTACH /* = new ON_ATTACH() */,
    /*public static final*/ ON_CREATE /* = new ON_CREATE() */,
    /*public static final*/ ON_START /* = new ON_START() */,
    /*public static final*/ ON_RESUME /* = new ON_RESUME() */;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.common.constant.EventBusType.Companion Companion = null;
    
    EventBusType() {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/example/common/constant/EventBusType$Companion;", "", "()V", "isOnAttach", "", "eventBusType", "Lcom/example/common/constant/EventBusType;", "isOnCreate", "isOnResume", "isOnStart", "common_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean isOnAttach(@org.jetbrains.annotations.Nullable()
        com.example.common.constant.EventBusType eventBusType) {
            return false;
        }
        
        public final boolean isOnCreate(@org.jetbrains.annotations.Nullable()
        com.example.common.constant.EventBusType eventBusType) {
            return false;
        }
        
        public final boolean isOnStart(@org.jetbrains.annotations.Nullable()
        com.example.common.constant.EventBusType eventBusType) {
            return false;
        }
        
        public final boolean isOnResume(@org.jetbrains.annotations.Nullable()
        com.example.common.constant.EventBusType eventBusType) {
            return false;
        }
    }
}