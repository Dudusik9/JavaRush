package com.javarush.task.task30.task3008;

import com.sun.javafx.binding.StringFormatter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message)
    {
        Connection connection;
        for (ConcurrentHashMap.Entry pair : connectionMap.entrySet())
        {
            try
            {
                connection = (Connection)pair.getValue();
                connection.send(message);
            }
            catch (IOException e)
            {
                System.out.println("Не удалось отправить сообщение!");
            }
        }
    }


    private static class Handler extends Thread
    {
        private Socket socket;

        public Handler (Socket socket)
        {
            this.socket = socket;
        }

        @Override
        public void run()
        {
            try
            {
                ConsoleHelper.writeMessage("Connection established:" + socket.getRemoteSocketAddress());
                Connection connection = new Connection(socket);
                String userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }
            catch (IOException e)
            {

            }
            catch (ClassNotFoundException e)
            {

            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            Message name = null;
            Boolean flag = false;
            while (true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                name = connection.receive();

                if(name.getType() == MessageType.USER_NAME)
                {
                    if(name != null && name.getData() != "")
                    {
                        if (!connectionMap.containsKey(name.getData()))
                        {
                            connectionMap.put(name.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            break;
                        }
                    }
                }
            }
            return name.getData();
        }

        private void notifyUsers(Connection connection, String userName) throws IOException
        {
            String currentName;
            for(ConcurrentHashMap.Entry pair : connectionMap.entrySet())
            {
                currentName = (String)pair.getKey();
                if (currentName.equals(userName))
                    continue;
                else
                    connection.send(new Message(MessageType.USER_ADDED, currentName));
            }
        }

        private void serverMainLoop (Connection connection, String userName) throws IOException, ClassNotFoundException
        {
            Message message;
            while(true)
            {
                message = connection.receive();
                if(message.getType() == MessageType.TEXT)
                {
                    sendBroadcastMessage(new Message(MessageType.TEXT, String.format("%s: %s", userName, message.getData())));
                }
                else
                    ConsoleHelper.writeMessage("Тип сообщения отличный от TEXT!");
            }
        }

    }

    public static void main(String[] args)
    {
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt());)
        {
            System.out.println("Сервер запущен.");
            while(true)
            {
               Socket socket = serverSocket.accept();
               new Handler(socket).start();
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
