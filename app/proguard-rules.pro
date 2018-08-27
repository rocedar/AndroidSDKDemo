# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-dontwarn
-optimizationpasses 5


-keep class *.R
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Appliction
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider



-dontwarn com.rocedar.***
-keep class com.rocedar.** {*;}
-dontwarn okio.**
-dontwarn okhttp3.**
-keep class com.cdfortis.** {*;}
-keep class com.google.protobuf.** {*;}

-keep class * extends com.rocedar.lib.base.config.IRCBaseUtil {*;}
-keep class * extends com.rocedar.lib.base.config.IWebViewBaseUtil {*;}
-keep class * extends com.rocedar.lib.base.image.load.IRCImageManagerBase {*;}
-keep class * extends com.rocedar.sdk.familydoctor.config.IRCFDConfig {*;}

#-keep class com.cdfortis.** {*;}
#-keep class com.google.protobuf.** {*;}
#-dontwarn com.android.volley.toolbox.**
#-keep class com.android.volley.** {*;}
