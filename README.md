# NetcdfError

This project contains a barebones reproduction of a problem with Netcdf on Android devices.

## Steps to reproduce
1. Build the project using Android Studio
2. Run the app. It will immidiately crash.
3. Check the logs. The app has crashed because of a HTTPException. You can see the full stacktrace below:

```
2022-06-14 11:40:47.301 6642-6642/? E/AndroidRuntime: FATAL EXCEPTION: main
    Process: me.filiphorvei.netcdferror, PID: 6642
    java.lang.RuntimeException: Unable to start activity ComponentInfo{me.filiphorvei.netcdferror/me.filiphorvei.netcdferror.MainActivity}: ucar.nc2.util.net.HTTPException: ucar.nc2.util.net.HTTPException: Unsupported algorithm exception: SunX509 TrustManagerFactory not available
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3685)
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3842)
        at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:103)
        at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:135)
        at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:95)
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2252)
        at android.os.Handler.dispatchMessage(Handler.java:106)
        at android.os.Looper.loopOnce(Looper.java:201)
        at android.os.Looper.loop(Looper.java:288)
        at android.app.ActivityThread.main(ActivityThread.java:7842)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:548)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1003)
     Caused by: ucar.nc2.util.net.HTTPException: ucar.nc2.util.net.HTTPException: Unsupported algorithm exception: SunX509 TrustManagerFactory not available
        at ucar.nc2.util.net.HTTPMethod.execute(HTTPMethod.java:498)
        at ucar.nc2.dataset.NetcdfDataset.checkIfDods(NetcdfDataset.java:915)
        at ucar.nc2.dataset.NetcdfDataset.disambiguateHttp(NetcdfDataset.java:866)
        at ucar.nc2.dataset.NetcdfDataset.disambiguateURL(NetcdfDataset.java:772)
        at ucar.nc2.dataset.NetcdfDataset.openOrAcquireFile(NetcdfDataset.java:660)
        at ucar.nc2.dataset.NetcdfDataset.openFile(NetcdfDataset.java:560)
        at me.filiphorvei.netcdferror.MainActivity.testOpendap(MainActivity.kt:25)
        at me.filiphorvei.netcdferror.MainActivity.onCreate(MainActivity.kt:20)
        at android.app.Activity.performCreate(Activity.java:8054)
        at android.app.Activity.performCreate(Activity.java:8034)
        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1341)
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3666)
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3842)??
        at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:103)??
        at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:135)??
        at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:95)??
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2252)??
        at android.os.Handler.dispatchMessage(Handler.java:106)??
        at android.os.Looper.loopOnce(Looper.java:201)??
        at android.os.Looper.loop(Looper.java:288)??
        at android.app.ActivityThread.main(ActivityThread.java:7842)??
        at java.lang.reflect.Method.invoke(Native Method)??
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:548)??
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1003)??
     Caused by: ucar.nc2.util.net.HTTPException: Unsupported algorithm exception: SunX509 TrustManagerFactory not available
        at ucar.nc2.util.net.EasySSLProtocolSocketFactory.createSSLContext(EasySSLProtocolSocketFactory.java:294)
        at ucar.nc2.util.net.EasySSLProtocolSocketFactory.getSSLContext(EasySSLProtocolSocketFactory.java:227)
        at ucar.nc2.util.net.EasySSLProtocolSocketFactory.createSocket(EasySSLProtocolSocketFactory.java:213)
        at org.apache.commons.httpclient.HttpConnection.open(HttpConnection.java:707)
        at org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$HttpConnectionAdapter.open(MultiThreadedHttpConnectionManager.java:1361)
        at org.apache.commons.httpclient.HttpMethodDirector.executeWithRetry(HttpMethodDirector.java:387)
        at org.apache.commons.httpclient.HttpMethodDirector.executeMethod(HttpMethodDirector.java:171)
        at org.apache.commons.httpclient.HttpClient.executeMethod(HttpClient.java:397)
        at org.apache.commons.httpclient.HttpClient.executeMethod(HttpClient.java:346)
        at ucar.nc2.util.net.HTTPMethod.execute(HTTPMethod.java:494)
        at ucar.nc2.dataset.NetcdfDataset.checkIfDods(NetcdfDataset.java:915)??
        at ucar.nc2.dataset.NetcdfDataset.disambiguateHttp(NetcdfDataset.java:866)??
        at ucar.nc2.dataset.NetcdfDataset.disambiguateURL(NetcdfDataset.java:772)??
        at ucar.nc2.dataset.NetcdfDataset.openOrAcquireFile(NetcdfDataset.java:660)??
        at ucar.nc2.dataset.NetcdfDataset.openFile(NetcdfDataset.java:560)??
        at me.filiphorvei.netcdferror.MainActivity.testOpendap(MainActivity.kt:25)??
        at me.filiphorvei.netcdferror.MainActivity.onCreate(MainActivity.kt:20)??
        at android.app.Activity.performCreate(Activity.java:8054)??
        at android.app.Activity.performCreate(Activity.java:8034)??
        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1341)??
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3666)??
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3842)??
        at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:103)??
        at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:135)??
        at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:95)??
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2252)??
        at android.os.Handler.dispatchMessage(Handler.java:106)??
        at android.os.Looper.loopOnce(Looper.java:201)??
        at android.os.Looper.loop(Looper.java:288)??
        at android.app.ActivityThread.main(ActivityThread.java:7842)??
        at java.lang.reflect.Method.invoke(Native Method)??
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:548)??
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1003)
```
