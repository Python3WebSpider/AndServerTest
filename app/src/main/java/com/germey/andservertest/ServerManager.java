package com.germey.andservertest;
import android.content.Context;
import android.util.Log;

import com.yanzhenjie.andserver.AndServer;
import com.yanzhenjie.andserver.Server;

import java.net.InetAddress;
import java.util.concurrent.TimeUnit;


public class ServerManager {

    private final Server server;

    /**
     * Create server.
     */
    public ServerManager(Context context, InetAddress inetAddress, int port) {

        server = AndServer.serverBuilder(context)
                .inetAddress(inetAddress)
                .port(port)
                .timeout(10, TimeUnit.SECONDS)
                .listener(new Server.ServerListener() {
                    @Override
                    public void onStarted() {
                        // TODO The server started successfully.
                    }

                    @Override
                    public void onStopped() {
                        // TODO The server has stopped.
                    }

                    @Override
                    public void onException(Exception e) {
                        // TODO An exception occurred while the server was starting.
                    }
                })
                .build();
    }

    /**
     * Start server.
     */
    public void startServer() {
        if (server.isRunning()) {
            // TODO The server is already up.
        } else {
            server.startup();
        }
    }

    /**
     * Stop server.
     */
    public void stopServer() {
        if (server.isRunning()) {
            server.shutdown();
        } else {
            Log.w("AndServer", "The server has not started yet.");
        }
    }
}