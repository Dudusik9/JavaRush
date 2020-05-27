package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

public class BotClient extends Client
{
    public class BotSocketThread extends SocketThread
    {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
           sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
           super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);

            if(message.contains(":"))
            {
                String[] array = message.split(":");
                if (array[1].trim().equals("дата"))
                    sendTextMessage(String.format("Информация для %s: %s", array[0], new SimpleDateFormat("d.MM.YYYY", Locale.ENGLISH).format(Calendar.getInstance().getTime())));
                else if (array[1].trim().equals("день"))
                    sendTextMessage(String.format("Информация для %s: %s", array[0], new SimpleDateFormat("d", Locale.ENGLISH).format(Calendar.getInstance().getTime())));
                else if (array[1].trim().equals("месяц"))
                    sendTextMessage(String.format("Информация для %s: %s", array[0], new SimpleDateFormat("MMMM", Locale.ENGLISH).format(Calendar.getInstance().getTime())));
                else if (array[1].trim().equals("год"))
                    sendTextMessage(String.format("Информация для %s: %s", array[0], new SimpleDateFormat("YYYY", Locale.ENGLISH).format(Calendar.getInstance().getTime())));
                else if (array[1].trim().equals("время"))
                    sendTextMessage(String.format("Информация для %s: %s", array[0], new SimpleDateFormat("H:mm:ss", Locale.ENGLISH).format(Calendar.getInstance().getTime())));
                else if (array[1].trim().equals("час"))
                    sendTextMessage(String.format("Информация для %s: %s", array[0], new SimpleDateFormat("H", Locale.ENGLISH).format(Calendar.getInstance().getTime())));
                else if (array[1].trim().equals("минуты"))
                    sendTextMessage(String.format("Информация для %s: %s", array[0], new SimpleDateFormat("m", Locale.ENGLISH).format(Calendar.getInstance().getTime())));
                else if (array[1].trim().equals("секунды"))
                    sendTextMessage(String.format("Информация для %s: %s", array[0], new SimpleDateFormat("s", Locale.ENGLISH).format(Calendar.getInstance().getTime())));
            }
        }
    }

    @Override
    protected String getUserName() {
        return String.format("date_bot_%d", (int)(Math.random() * 100));
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
