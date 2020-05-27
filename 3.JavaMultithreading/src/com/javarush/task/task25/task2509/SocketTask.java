package com.javarush.task.task25.task2509;

import java.beans.IntrospectionException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public abstract class SocketTask<T> implements CancellableTask<T>
{
    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    public synchronized void cancel()
    {
        try
        {
//            socket.getInputStream().close();
//            socket.getOutputStream().close();
            socket.close();
        }
        catch (Exception e)
        {}
    }

    public RunnableFuture<T> newTask()
    {
        return new FutureTask<T>(this) {
            public boolean cancel(boolean mayInterruptIfRunning)
            {
                //close all resources here by using proper SocketTask method
                //call super-class method in finally block
                try
                {
                    socket.close();
                }
                catch (Exception e){}
                finally
                {
                    super.cancel(true);
                }
                return false;
            }
        };
    }
}