#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_mahmoudbashir_data_di_DataModule_getBaseUrlFromNative(JNIEnv *env, jobject thiz) {
    std::string baseURL = "https://fakestoreapi.com/";
    return env->NewStringUTF(baseURL.c_str());
}