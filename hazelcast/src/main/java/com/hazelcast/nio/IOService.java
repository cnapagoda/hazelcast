/* 
 * Copyright (c) 2008-2010, Hazel Ltd. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.hazelcast.nio;

import com.hazelcast.config.AsymmetricEncryptionConfig;
import com.hazelcast.config.SymmetricEncryptionConfig;
import com.hazelcast.impl.ascii.TextCommandService;
import com.hazelcast.logging.ILogger;

public interface IOService {

    ILogger getLogger(String name);

    void onOutOfMemory(OutOfMemoryError oom);

    void handleInterruptedException(Thread thread, RuntimeException e);

    void onIOThreadStart();

    Address getThisAddress();

    void onFatalError(Exception e);

    SymmetricEncryptionConfig getSymmetricEncryptionConfig();

    AsymmetricEncryptionConfig getAsymmetricEncryptionConfig();

    void handleClientPacket(Packet p);

    void handleMemberPacket(Packet p);

    TextCommandService getTextCommandService();

    boolean isMemcacheEnabled();

    boolean isRestEnabled();

    void onConnectionClose(Address endPoint);

    String getThreadPrefix();

    void onFailedConnection(Address address);

    void shouldConnectTo(Address address);

    int getSocketReceiveBufferSize();

    int getSocketSendBufferSize();

    int getSocketLingerSeconds();

    boolean getSocketKeepAlive();

    boolean getSocketNoDelay();

    int getSelectorThreadCount();

    boolean onDuplicateConnection(Address endPoint,
                                  boolean acceptTypeConnection,
                                  boolean accept,
                                  Connection connExisting);

    boolean isClient();
}