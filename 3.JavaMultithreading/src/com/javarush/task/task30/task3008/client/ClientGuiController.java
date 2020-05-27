package com.javarush.task.task30.task3008.client;

public class ClientGuiController extends Client
{
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);

    public class GuiSocketThread extends SocketThread
    {
        @Override
        public void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
        }

        @Override
        public void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }

        @Override
        public void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
        }

        @Override
        public void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }

    @Override
    public String getServerAddress() {
        return view.getServerAddress();
    }

    @Override
    public int getServerPort() {
        return view.getServerPort();
    }

    @Override
    public String getUserName() {
        return view.getUserName();
    }

    @Override
    protected SocketThread getSocketThread(){
        return new GuiSocketThread();
    }

    @Override
    public void run()
    {
        getSocketThread().run();
    }

    public ClientGuiModel getModel()
    {
        return model;
    }

    public static void main(String[] args)
    {
        new ClientGuiController().run();
    }
}
