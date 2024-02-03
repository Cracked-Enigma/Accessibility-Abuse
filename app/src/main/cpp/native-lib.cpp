#include <jni.h>
#include <string>
#include <unistd.h>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_example_ransomware_1pro_activities_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT void  JNICALL
Java_com_example_ransomware_1pro_activities_RickActivity_killApp(JNIEnv *env, jobject thiz) {
    pid_t pid=getpid();
    kill(pid,SIGTERM);
}