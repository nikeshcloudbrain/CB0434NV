#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_creditscoreinfo_report_check_util_Constant_getMainApi(
        JNIEnv *env, jclass clazz) {

    std::string hello = "http://206.189.136.121/nv/CreditScoreNV434/V1/";
    return env->NewStringUTF(hello.c_str());
}


extern "C"
JNIEXPORT jstring JNICALL
Java_com_creditscoreinfo_report_check_encrypt_DecryptEncrypt_encryptionKey(
        JNIEnv *env, jclass clazz) {

    std::string hello = "";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_creditscoreinfo_report_check_encrypt_DecryptEncrypt_zipencryptionkey(
        JNIEnv *env, jclass clazz) {

    std::string hello = "";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_creditscoreinfo_report_check_encrypt_DecScript_getDecKey1(
        JNIEnv *env, jclass clazz) {

    std::string hello = "FE09C0D2122AE3621D7B6F57B23BDE490CC8EE72A457C3AAA35F79627FD13728";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_creditscoreinfo_report_check_encrypt_DecScript_getDecKey2(
        JNIEnv *env, jclass clazz) {

    std::string hello = "04271C33067D59575AC4B35922FF33530CC8EE72A457C3AAA35F79627FD13728";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_creditscoreinfo_report_check_encrypt_EncScript_getEncKey1(
        JNIEnv *env, jclass clazz) {

    std::string hello = "";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_creditscoreinfo_report_check_encrypt_EncScript_getEncKey2(
        JNIEnv *env, jclass clazz) {

      std::string hello = "";
    return env->NewStringUTF(hello.c_str());
}