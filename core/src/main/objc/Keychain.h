/*
 *  Copyright (c) 2006 David Kocher. All rights reserved.
 *  http://cyberduck.ch/
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  Created by August Mueller on Wed Feb 04 2005.
 *  Bug fixes, suggestions and comments should be sent to:
 *  dkocher@cyberduck.ch
 */

/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class ch_cyberduck_core_Keychain */

#ifndef _Included_ch_cyberduck_core_Keychain
#define _Included_ch_cyberduck_core_Keychain
#ifdef __cplusplus
extern "C" {
#endif
/* Inaccessible static: log */
/* Inaccessible static: instance */
/* Inaccessible static: class_00024ch_00024cyberduck_00024core_00024Keychain */
/*
 * Class:     ch_cyberduck_core_Keychain
 * Method:    getInternetPasswordFromKeychain
 * Signature: (Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_ch_cyberduck_core_Keychain_getInternetPasswordFromKeychain
  (JNIEnv *, jobject, jstring, jint, jstring, jstring);

/*
 * Class:     ch_cyberduck_core_Keychain
 * Method:    getPasswordFromKeychain
 * Signature: (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_ch_cyberduck_core_Keychain_getPasswordFromKeychain
  (JNIEnv *, jobject, jstring, jstring);

/*
 * Class:     ch_cyberduck_core_Keychain
 * Method:    addPasswordToKeychain
 * Signature: (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_ch_cyberduck_core_Keychain_addPasswordToKeychain
  (JNIEnv *, jobject, jstring, jstring, jstring);

/*
 * Class:     ch_cyberduck_core_Keychain
 * Method:    addInternetPasswordToKeychain
 * Signature: (Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_ch_cyberduck_core_Keychain_addInternetPasswordToKeychain
  (JNIEnv *, jobject, jstring, jint, jstring, jstring, jstring);

/*
 * Class:     ch_cyberduck_core_Keychain
 * Method:    isTrusted
 * Signature: ([B)Z
 */
JNIEXPORT jboolean JNICALL Java_ch_cyberduck_core_Keychain_isTrustedNative
  (JNIEnv * env, jobject this, jstring jHostname, jobjectArray jCertificateChain);

/*
 * Class:     ch_cyberduck_core_Keychain
 * Method:    isTrusted
 * Signature: ([B)Z
 */
JNIEXPORT jboolean JNICALL Java_ch_cyberduck_core_Keychain_displayCertificatesNative
  (JNIEnv * env, jobject this, jobjectArray jCertificateChain);

/*
 * Class:     ch_cyberduck_core_Keychain
 * Method:    chooseCertificate
 * Signature: (Ljava/lang/String)Ljava/lang/String;
 */
JNIEXPORT jbyteArray Java_ch_cyberduck_core_Keychain_chooseCertificateNative
  (JNIEnv *env, jobject this, jobjectArray jIssuers, jstring jHostname, jstring jPrompt);

#ifdef __cplusplus
}
#endif
#endif